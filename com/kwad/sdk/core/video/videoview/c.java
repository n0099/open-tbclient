package com.kwad.sdk.core.video.videoview;
/* loaded from: classes10.dex */
public interface c {
    int getBufferPercentage();

    long getCurrentPosition();

    long getDuration();

    boolean isIdle();

    boolean isPaused();

    void pause();

    void release();

    void restart();

    void setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a aVar);

    void start();

    boolean vE();
}
