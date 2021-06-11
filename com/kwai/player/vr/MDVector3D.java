package com.kwai.player.vr;

import android.opengl.Matrix;
/* loaded from: classes7.dex */
public class MDVector3D {
    public float[] values;

    public MDVector3D() {
        float[] fArr = new float[4];
        this.values = fArr;
        fArr[3] = 1.0f;
    }

    public static float len(float f2, float f3, float f4) {
        return (float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
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
        float[] fArr2 = this.values;
        Matrix.multiplyMV(fArr2, 0, fArr, 0, fArr2, 0);
    }

    public MDVector3D setX(float f2) {
        this.values[0] = f2;
        return this;
    }

    public MDVector3D setY(float f2) {
        this.values[1] = f2;
        return this;
    }

    public MDVector3D setZ(float f2) {
        this.values[2] = f2;
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
