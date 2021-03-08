package com.yy.mediaframework.gpuimage.custom;

import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public interface IGPUProcess {
    void onDestroy();

    void onDraw(int i, FloatBuffer floatBuffer);

    void onInit(int i, int i2, int i3);

    void onOutputSizeChanged(int i, int i2);
}
