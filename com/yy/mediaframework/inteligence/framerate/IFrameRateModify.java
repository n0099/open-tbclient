package com.yy.mediaframework.inteligence.framerate;
/* loaded from: classes6.dex */
public interface IFrameRateModify {
    float getLastFrameRate();

    boolean onInterceptDoFrame(long j);

    void publishCurrentFrameRate(int i);

    void publishCurrentResolution(int i, int i2, int i3);

    void publishNetworkCodeRate(int i);

    void release();

    void setLastFrameRate(float f);
}
