package ru.geekbrains.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Класс, содержащий базовые методы - логика игры
 * Это класс родитель для класса MenuScreen
 */

public class BaseScreen implements Screen, InputProcessor {

    // Батчер - прорисовщик. чего? спрайта или экрана?
    protected SpriteBatch batch;


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
    public void resize(int width, int height) {
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

    @Override
    public void dispose() {
        System.err.println("BaseScreen.dispose()");
        // метод не вызывается по умолчанию
        // сделан для того чтобы разработчик вызывал его там где это действительно нужно .
        // обычно вызвается из метода Hide
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
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
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
