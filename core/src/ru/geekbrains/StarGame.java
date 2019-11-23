package ru.geekbrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.screen.MenuScreen;

public class StarGame extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen());

        /**
         * поиграть с векторами
         */
/*      Vector2 v1 = new Vector2(3f, 5f);
        Vector2 v2 = new Vector2(2f, 4f);

        v1.add(v2);
        v2 = v1.cpy();
        v2.add(1, 1);

        Vector2 v3;
        v3 = v2.cpy().add(v1);

        Vector2 v4;
        v4 = v2.cpy().sub(v1);
        v3.scl(3);

        v1.nor();

        System.out.println("V1: " + v1.x + " | " + v1.y);
        System.out.println("V2: " + v2.x + " | " + v2.y);
        System.out.println("V3: " + v3.x + " | " + v3.y);
        System.out.println("V4: " + v4.x + " | " + v4.y);
        System.out.println("V1.len(): " + v1.len());
        System.out.println("V4.len(): " + v4.len());*/


    }
}
