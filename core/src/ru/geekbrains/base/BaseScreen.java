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
        System.out.println("resize width = " + width + " height = " + height);
    }

    @Override
    public void pause() {
        System.out.println("pause");
    }

    @Override
    public void resume() {
        System.out.println("resume");
    }

    @Override
    public void hide() {
        System.out.println("hide");
        dispose();
    }

    @Override
    public void dispose() {
        System.out.println("dispose");
        // метод не вызывается по умолчанию
        // сделан для того чтобы разработчик вызывал его там где это действительно нужно .
        // обычно вызвается из метода Hide
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown keycode = " + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println("keyUp keycode = " + keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        System.out.println("keyTyped character = " + character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchDown screenX = " + screenX + " screenY = " + screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchUp screenX = " + screenX + " screenY = " + screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("touchDragged screenX = " + screenX + " screenY = " + screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        System.out.println("scrolled amount = " + amount);
        return false;
    }
}
