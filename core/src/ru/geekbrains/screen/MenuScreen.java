package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.StarSprite;

/**
 * Класс экрана меню.
 * наследник класса BaseScreen
 */

public class MenuScreen extends BaseScreen {

    private static final int STAR_COUNT = 100; // Определяем колличество звезд
    private Texture backgroundTexture;
    private Background backgroundSprite;
    private TextureAtlas textureAtlas;
    private StarSprite[] starsSprite;

    /**
     * метод открытия окна.
     * как правило используется для инициализации переменных.
     */
    @Override
    public void show() {
        super.show();
        backgroundTexture = new Texture("textures/backgroundTexture.png"); // создаем переменную картинки спрайта
        backgroundSprite = new Background(new TextureRegion(backgroundTexture)); // создаем переменну спрайта фона и загружаем в нее картинку фона.
        textureAtlas = new TextureAtlas("textures/menuAtlas.tpack"); // переменная файла атласа текстур.
        starsSprite = new StarSprite[STAR_COUNT]; // переменная массива звезд
        for (int i = 0; i < STAR_COUNT; i++) {
            starsSprite[i] = new StarSprite(textureAtlas); // создаем звезды в массиве звезд.
        }
    }

    /**
     * метод отрисовки изображения
     * отрисовка осузществляется в пределах бегин энд.
     */
    private void draw() {
        Gdx.gl.glClearColor(1, 1, 0.60f, 1); // цвет фона окна в RGB
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // не понял что это ?? - посмотреть в первом уроке. todo

        batch.begin(); // начало отрисовки ползущей картинки. Нарисовали ее в новой позиции. Не ясно почему первые позиции заданы 0?

        backgroundSprite.draw(batch); // вызываем переопределенный метод класса Sprite для этого обекта

        for (StarSprite starSprite : starsSprite) {
            starSprite.draw(batch); // вызываем переопределенный метод класса Sprite для этого обекта
        }

        batch.end(); // конец отрисовки ползущей картинки
    }

    /**
     * метод отрабатывающий 60 раз в секунду во время работы приложения.
     *
     * @param delta - Дельта переменная как правило для реализации времени, задершки , погрешности и тд.
     */
    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    /**
     * метод изменения размеров экрана
     * нужен тогда когда изменились границы экрана
     *
     * @param worldBounds - новые границы экрана
     */
    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        backgroundSprite.resize(worldBounds); // вызываем переопределенный метод класса Sprite для этого обекта
        for (StarSprite starSprite: starsSprite) {
            starSprite.resize(worldBounds); // вызываем переопределенный метод класса Sprite для этого обекта
        }
    }


    private void update(float delta) {
        for (StarSprite starSprite: starsSprite) {
            starSprite.update(delta); // вызываем переопределенный метод класса Sprite для этого обекта
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("MenuScreen.keyDown(): keycode: " + keycode);
        if (keycode >= 19 && keycode <= 22) {
            // currentPosition.set(0f, 0f);
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        return false;
    }


    /**
     * метод закрытия программы и чистки памяти
     */
    @Override
    public void dispose() {
        batch.dispose();
        backgroundTexture.dispose();
        textureAtlas.dispose();
    }


}
