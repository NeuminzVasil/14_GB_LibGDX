package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.sprite.Logo;

/**
 * Класс экрана меню.
 * наследник класса BaseScreen
 */

public class MenuScreen extends BaseScreen {

    private Texture badLogicLogoTexture;
    private Vector2 currentPosition; // вектор (точка) текущей позиции позиции
    private Logo logo;

    /**
     * метод отрабатывающий при первом отображении окна.
     * как правило используется для инициализации переменных.
     */
    @Override
    public void show() {
        super.show();
        badLogicLogoTexture = new Texture("newBLLogo.jpg");// попробовал новый логотип
        currentPosition = new Vector2(); // создаем объект вектора (точки) текущей позиции.
        logo = new Logo(new TextureRegion(badLogicLogoTexture));
        logo.setHeightProportion(0.5f);
    }


    /**
     * метод отрабатывающий 60 раз в секунду во время работы приложения.
     *
     * @param delta - Дельта переменная как правило для реализации времени, задершки , погрешности и тд.
     */
    @Override
    public void render(float delta) {
        super.render(delta);

        Gdx.gl.glClearColor(1, 1, 0.60f, 1); // цвет фона окна в RGB
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // не понял что это ?? - посмотреть в первом уроке. todo

        batch.begin(); // начало отрисовки ползущей картинки. Нарисовали ее в новой позиции. Не ясно почему первые позиции заданы 0?
        logo.draw(batch);
        batch.end(); // конец отрисовки ползущей картинки
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("MenuScreen.keyDown(): keycode: " + keycode);
        if (keycode >= 19 && keycode <= 22) {
            currentPosition.set(0f, 0f);
        }
        return super.keyDown(keycode);
    }

    @Override
    public void dispose() {
        batch.dispose();
        badLogicLogoTexture.dispose();
    }

}
