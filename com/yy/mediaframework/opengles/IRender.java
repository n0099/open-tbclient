package com.yy.mediaframework.opengles;

import com.yy.mediaframework.model.YMFImageBuffer;
/* loaded from: classes4.dex */
public interface IRender {
    void clip(int i, int i2, int i3, int i4);

    void flipHorizontal();

    void flipHorizontalWater();

    void flipReset();

    void flipResetWater();

    void flipVertical();

    void flipVerticalWater();

    boolean prepareInputImageData(YMFImageBuffer yMFImageBuffer);

    boolean prepareInputTexture(YMFTexture yMFTexture);

    boolean prepareInputTextureTransformMatrix(float[] fArr);

    boolean prepareOutputTexture(YMFTexture yMFTexture);

    void prepareWaterTexture(YMFTexture yMFTexture);

    void release();

    void render();

    void rotate(int i);
}
