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

    private Texture badLogicLogoTexture;

    private Vector2 currentPosition; // вектор (точка) текущей позиции позиции
    private Vector2 nexStepVector; // вектор направления движения (следующего шага).
    private Vector2 touchPoint; // вектор (точка) конечной позиции при клике на экране.
    private static final float V_LEN = 5.5f; // переменная скорости, за счет нормализации длинны шага на ЭТУ величену
    private Vector2 nexStepVectorTesting;

    /**
     * метод отрабатывающий при первом отображении окна.
     * как правило используется для инициализации переменных.
     */
    @Override
    public void show() {
        super.show();

        badLogicLogoTexture = new Texture("NewBLLogo.jpg");// попробовал новый логотип

        currentPosition = new Vector2(); // создаем объект вектора (точки) текущей позиции.
        nexStepVector = new Vector2(); // создаем объект ветора скорости и направлени следующего шага).
        touchPoint = new Vector2(); // создаем объект вектора конечной точки.
        nexStepVectorTesting = new Vector2(); // вектор для провеки текущей позииции - не самое оптимальное решение . нужно сделать булин и проверять в отдельном методе чтобы не проводить вычислений 60 раз в секунду
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
        batch.draw(badLogicLogoTexture, // ползущая картинка
                currentPosition.x, currentPosition.y // текушее положение ползущей картинки
        );
        batch.end(); // конец отрисовки ползущей картинки

        nexStepVectorTesting.set(touchPoint); // копируем вектор конечной позиции чтобы не пложить объекты методом cpy()
        // из вектора конечной позиции вычитаем вектор текущей позиции и смотрим длину волученного вектора
        if (nexStepVectorTesting.sub(currentPosition).len() > V_LEN) { //если растояние между конечной и текушей точками больше длинны шага то делаем шаг
            currentPosition.add(nexStepVector); // do the next step.
            //System.out.println("MenuScreen.render(): ..sub.len() = " + nexStepVectorTesting.len() + "(" + currentPosition.x + "," + currentPosition.y + ")");
        } else { // если меньше то это занчит что мы достигли конечной точки и нужно встать на заданную позицию.
            currentPosition.set(touchPoint); // set finish.
            //System.out.println("MenuScreen.render(): FINISH ..sub.len() = " + nexStepVectorTesting.len() + "(" + currentPosition.x + "," + currentPosition.y + ")");
        }
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
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        super.touchDown(screenX, screenY, pointer, button);

        touchPoint.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("MenuScreen.touchDown(): touchPoint (Сюда кликнул мышкой: ): " + touchPoint.x + ", " + touchPoint.y);
        System.out.println("MenuScreen.touchDown(): currentPosition (я здесь: ): " + currentPosition.x + ", " + currentPosition.y);
        System.out.println("MenuScreen.touchDown(): touchPoint.cpy().sub(currentPosition): " + touchPoint.cpy().sub(currentPosition).x + ", " + touchPoint.cpy().sub(currentPosition).y);
        System.out.println("MenuScreen.touchDown(): (touchPoint.cpy().sub(currentPosition)).nor(): " + (touchPoint.cpy().sub(currentPosition)).nor().x + ", " + (touchPoint.cpy().sub(currentPosition)).nor().y);

        //nexStepVector.set(touchPoint.cpy().sub(currentPosition)).nor(); // получаем вектор смещения путем разницы между конечной и текущей позициями и полседующей нормализации вектора.
        nexStepVector.set(touchPoint.cpy().sub(currentPosition)).setLength(V_LEN); // получаем вектор смещения путем разницы между конечной и текущей позициями  и полседующей корректировки длинны полученного вектора с помощью константы скорости
        System.out.println("MenuScreen.touchDown(): nexStepVector (вектор точки следующего шага: ): " + nexStepVector.x + ", " + nexStepVector.y + "\n");

        return false;
    }
}
