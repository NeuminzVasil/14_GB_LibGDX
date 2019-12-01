package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;

public class StarSprite extends Sprite {

    private Vector2 velocityVector = new Vector2(); // скорость движения звезы
    private Rect worldBounds; // Запоминаем глобальные границы экрана

    /**
     * конструктор класса
     *
     * @param textureAtlas
     */
    public StarSprite(TextureAtlas textureAtlas) {
        super(textureAtlas.findRegion("Star")); // достаем картинку (текстуру) звезды по названию в атласе текстур

        // сгенерировать вектор скорости(направления) немного наискосок
        float velocityVectorX = Rnd.nextFloat(-.00001f, .00005f);
        float velocityVectorY = Rnd.nextFloat(-.001f, -.005f);
        velocityVector.set(velocityVectorX, velocityVectorY);

        setHeightProportion(Rnd.nextFloat(.002f, .004f)); // задать размер звезды (в процентах от размера экрана)
    }

    /**
     * метод изменения размеров экрана
     * нужен тогда когда изменились границы экрана
     * @param worldBounds - новые границы экрана
     */
    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;

        // посчитать начальную позицию звезды
        float positionX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float positionY = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        positionVector.set(positionX, positionY); // вектр (точка) позвии звезды наследуется от свойства класса Rect через класс Srite

    }

    @Override
    public void update(float delta) {
        positionVector.add(velocityVector); // движение звезды за счет добавления вектора скорости (направления) к вектору (точке) текущей позиции.
        checkBounds();
    }


    private void checkBounds (){

        if (getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight()); // если правая сторона звезды меньше левой стороны жкрана то задать позицию звезы с другой стороны жкрана
        if (getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());
        if (getTop() < worldBounds.getBottom()) setBottom(worldBounds.getTop());
        if (getBottom() > worldBounds.getTop()) setTop(worldBounds.getBottom());


    }
}
