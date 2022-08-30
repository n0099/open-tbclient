package com.kwad.components.offline.api.core.video.listener;
/* loaded from: classes7.dex */
public interface VideoPlayStateListener {
    void onVideoPlayBufferingPaused();

    void onVideoPlayBufferingPlaying();

    void onVideoPlayCompleted();

    void onVideoPlayError(int i, int i2);

    void onVideoPlayPaused();

    void onVideoPlayProgress(long j, long j2);

    void onVideoPlayStart();

    void onVideoPlaying();

    void onVideoPrepared();

    void onVideoPreparing();
}
