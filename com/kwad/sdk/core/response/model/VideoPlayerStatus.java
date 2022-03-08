package com.kwad.sdk.core.response.model;

import java.io.Serializable;
/* loaded from: classes8.dex */
public class VideoPlayerStatus extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = -9021213312245598171L;
    public int mVideoPlayerBehavior = 1;
    public int mVideoPlayerType;

    public void setVideoPlayerBehavior(int i2) {
        this.mVideoPlayerBehavior = i2;
    }

    public void setVideoPlayerType(int i2) {
        this.mVideoPlayerType = i2;
    }
}
