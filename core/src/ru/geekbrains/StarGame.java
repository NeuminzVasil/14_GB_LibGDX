package ru.geekbrains;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.screen.MenuScreen;

public class StarGame extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen());
    }
}
