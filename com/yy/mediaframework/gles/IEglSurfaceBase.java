package com.yy.mediaframework.gles;
/* loaded from: classes4.dex */
public interface IEglSurfaceBase {
    void createOffscreenSurface(int i, int i2);

    void createWindowSurface(Object obj);

    int getHeight();

    int getWidth();

    boolean isCurrent();

    void makeCurrent();

    void makeCurrentReadFrom(Object obj);

    void releaseEglSurface();

    void setPresentationTime(long j);

    boolean swapBuffers();
}
