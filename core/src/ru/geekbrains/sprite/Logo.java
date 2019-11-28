package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;

public class Logo extends Sprite {

    private static final float V_LEN = .005f;
    private Vector2 speedVector = new Vector2();
    private Vector2 endPointVector = new Vector2();
    private Vector2 buffer = new Vector2();


    public Logo(TextureRegion region) {
        super(region);
    }

    @Override
    public void update(float delta) {
        buffer.set(endPointVector);
        if (buffer.sub(positionVector).len() > V_LEN){
            positionVector.add(speedVector);
        } else {
            positionVector.set(endPointVector);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {

        endPointVector.set(touch);
        speedVector.set(touch.cpy().sub(positionVector)).setLength(V_LEN);
        return false;
    }


}
