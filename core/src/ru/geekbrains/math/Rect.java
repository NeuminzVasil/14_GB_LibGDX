package ru.geekbrains.math;

import com.badlogic.gdx.math.Vector2;

/**
 * Прямоугольник
 */
public class Rect {

    public final Vector2 positionVector = new Vector2(); // позиция по центру
    protected float halfWidth; // половина ширины
    protected float halfHeight; // половина высоты

    public Rect() {

    }

    public Rect(Rect from) {
        this(from.positionVector.x, from.positionVector.y, from.getHalfWidth(), from.getHalfHeight());
    }

    public float getLeft() {
        return positionVector.x - halfWidth;
    }

    public Rect(float x, float y, float halfWidth, float halfHeight) {
        positionVector.set(x, y);
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
    }

    public float getTop() {
        return positionVector.y + halfHeight;
    }

    public float getRight() {
        return positionVector.x + halfWidth;
    }

    public float getBottom() {
        return positionVector.y - halfHeight;
    }

    public float getHalfWidth() {
        return halfWidth;
    }

    public float getHalfHeight() {
        return halfHeight;
    }

    public float getWidth() {
        return halfWidth * 2f;
    }

    public float getHeight() {
        return halfHeight * 2f;
    }

    public void set(Rect from) {
        positionVector.set(from.positionVector);
        halfWidth = from.halfWidth;
        halfHeight = from.halfHeight;
    }

    public void setLeft(float left) {
        positionVector.x = left + halfWidth;
    }

    public void setTop(float top) {
        positionVector.y = top - halfHeight;
    }

    public void setRight(float right) {
        positionVector.x = right - halfWidth;
    }

    public void setBottom(float bottom) {
        positionVector.y = bottom + halfHeight;
    }

    public void setWidth(float width) {
        this.halfWidth = width / 2f;
    }

    public void setHeight(float height) {
        this.halfHeight = height / 2f;
    }

    public void setSize(float width, float height) {
        this.halfWidth = width / 2f;
        this.halfHeight = height / 2f;
    }

    public boolean isMe(Vector2 touch) {
        return touch.x >= getLeft() && touch.x <= getRight() && touch.y >= getBottom() && touch.y <= getTop();
    }

    public boolean isOutside(Rect other) {
        return getLeft() > other.getRight() || getRight() < other.getLeft() || getBottom() > other.getTop() || getTop() < other.getBottom();
    }

    @Override
    public String toString() {
        return "Rectangle: positionVector" + positionVector + " size(" + getWidth() + ", " + getHeight() + ")";
    }
}