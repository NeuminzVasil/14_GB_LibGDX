package ru.geekbrains.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.geekbrains.StarGame;

/**
 * главный класс приложения для рабочей станции
 * config - конфигуратор окна
 * new StarGame() - базовый класс проекта. с него начинается загрузка
  */
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new StarGame(), config);
	}
}
