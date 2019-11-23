package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

/**
 * Класс экрана меню.
 * наследник класса BaseScreen
 */

public class MenuScreen extends BaseScreen {

    private Texture img;

    private Vector2 pos; // позиция
    private Vector2 v; // скорость

    @Override
    public void show() {
        super.show();
        // попробовал новый логотип
        img = new Texture("NewBLLogo.jpg");
        pos = new Vector2();
        v = new Vector2(10f, 5.5f); // задаем скорость. Под скоростью понимем вектор смещения основной позиции.
    }


    /**
     * метод отрабатывающий 60 раз в секунду во время работы приложения.
     * @param delta - Дельта переменная как правило для реализации времени, задершки , погрешности и тд.
     */
    @Override
    public void render(float delta) {
        super.render(delta);

        Gdx.gl.glClearColor(1, 1, 0.60f, 1); // цвет фона окна в RGB
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // не понял что это ??

        batch.begin(); // начало отрисовки ползущей картинки. Нарисовали ее в новой позиции. Не ясно почему первые позиции заданы 0?
        batch.draw(img, // ползущая картинка
                pos.x, pos.y // координаты ползущей картинки
        );
        batch.end(); // конец отрисовки ползущей картинки ?


        if (Gdx.graphics.getHeight() >= pos.y + img.getHeight()
                && Gdx.graphics.getWidth() >= pos.x + img.getWidth()) {
            pos.add(v); // если картинка не выходит за рамки экрана то приваить к текущей позицици "вектор скорости"(читай координаты смещения)
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        System.out.println(screenX + "; " + (Gdx.graphics.getHeight() - screenY));
        return false;
    }
}
