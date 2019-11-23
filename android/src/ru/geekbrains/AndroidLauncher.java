package ru.geekbrains;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import ru.geekbrains.StarGame;

/**
 * главный класс приложения для мобильной станции
 * config - конфигуратор окна
 * new StarGame() - базовый класс проекта. с него начинается загрузка
 */
public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new StarGame(), config);
	}
}
