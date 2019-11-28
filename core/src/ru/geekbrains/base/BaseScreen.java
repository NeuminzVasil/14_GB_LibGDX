package ru.geekbrains.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

import javax.swing.BoundedRangeModel;

import ru.geekbrains.math.MatrixUtils;
import ru.geekbrains.math.Rect;


/**
 * Класс, содержащий базовые методы - логика игры
 * Это класс родитель для класса MenuScreen
 */

public class BaseScreen implements Screen, InputProcessor {

    // Батчер - прорисовщик. чего? спрайта или экрана?
    protected SpriteBatch batch;
    private Rect screenBounds; // экранная кооржинатная сетка
    private Rect worldBounds; // мировая система координат
    private Rect glBounds; // система координат oGL

    private Matrix4 worldToGl;
    private Matrix3 screenToWorld;

    private Vector2 touch;

    public BaseScreen() {
        this.screenBounds = new Rect();
        this.worldBounds = new Rect();
        this.glBounds = new Rect(0, 0, 1f, 1f);
        this.worldToGl = new Matrix4();
        this.screenToWorld = new Matrix3();
        this.touch = new Vector2();
    }

    /**
     * Метод вызывается при открытии программы,
     * метод не вызывается при свертывании окна в панель задач.
     */
    @Override
    public void show() {
        System.err.println("show");
        Gdx.input.setInputProcessor(this); // обращаемся к классу GDX указывая ему кто имеемно осуществляет воод с ЭТОГО экрана
        this.batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        // обязательно должен присутсвовать даже если пустой. неясно почему.
        // работет 60 раз в секунду
    }

    @Override
    public void resize(int width, int height) { // переменные размера экрана поступают от API
        screenBounds.setSize(width, height); // задаем размеры экранного прямоугольника.
        screenBounds.setLeft(0); //
        screenBounds.setBottom(0);

        float aspect = width / (float) height;
        worldBounds.setHeight(1f);
        worldBounds.setWidth(1f * aspect);

        MatrixUtils.calcTransitionMatrix(worldToGl, worldBounds, glBounds);
        batch.setProjectionMatrix(worldToGl);

        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, worldBounds);


        resize(worldBounds);
    }

    public void resize(Rect worldBounds){

    }

    @Override
    public void pause() {
        System.err.println("BaseScreen.pause()");
    }

    @Override
    public void resume() {
        System.err.println("BaseScreen.resume()");
    }

    @Override
    public void hide() {
        dispose();
    }

    /**
     * // метод не вызывается по умолчанию
     * // сделан для того чтобы разработчик вызывал его там где это действительно нужно .
     * // обычно вызвается из метода Hide
     */
    @Override
    public void dispose() {
//        System.err.println("BaseScreen.dispose()");
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchDown(touch, pointer);
        return false;
    }

    public boolean touchDown(Vector2 touch, int pointer) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchUp(touch, pointer);
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchDragged(touch, pointer);
        return false;
    }
    public boolean touchDragged(Vector2 touch, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
