package com.kwai.player.vr;

import android.opengl.Matrix;
/* loaded from: classes4.dex */
public class MDVector3D {
    private float[] values = new float[4];

    public MDVector3D() {
        this.values[3] = 1.0f;
    }

    public static float len(float f, float f2, float f3) {
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    public float getX() {
        return this.values[0];
    }

    public float getY() {
        return this.values[1];
    }

    public float getZ() {
        return this.values[2];
    }

    public void multiplyMV(float[] fArr) {
        Matrix.multiplyMV(this.values, 0, fArr, 0, this.values, 0);
    }

    public MDVector3D setX(float f) {
        this.values[0] = f;
        return this;
    }

    public MDVector3D setY(float f) {
        this.values[1] = f;
        return this;
    }

    public MDVector3D setZ(float f) {
        this.values[2] = f;
        return this;
    }

    public String toString() {
        return "MDVector3D{x=" + getX() + ", y=" + getY() + ", z=" + getZ() + '}';
    }

    public float x() {
        return this.values[0];
    }

    public float y() {
        return this.values[1];
    }

    public float z() {
        return this.values[2];
    }
}
