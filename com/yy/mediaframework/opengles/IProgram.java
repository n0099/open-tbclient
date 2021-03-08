package com.yy.mediaframework.opengles;
/* loaded from: classes6.dex */
public interface IProgram {
    void clip(int i, int i2, int i3, int i4);

    void drawFrame();

    void enableWaterMarker(boolean z);

    void flipHorizontal();

    void flipHorizontalWater();

    void flipReset();

    void flipResetWater();

    void flipVertical();

    void flipVerticalWater();

    void prepareInputTextureTransformMatrix(float[] fArr);

    int programType();

    void release();

    void rotation(int i);

    void useProgram();
}
