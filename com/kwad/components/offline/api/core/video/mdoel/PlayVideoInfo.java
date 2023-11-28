package com.kwad.components.offline.api.core.video.mdoel;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes10.dex */
public class PlayVideoInfo {
    public final boolean isNoCache;
    public final KsPlayerLogParams ksplayerLogParams;
    public final String manifest;
    public final VideoPlayerStatus videoPlayerStatus;
    public final String videoUrl;

    /* loaded from: classes10.dex */
    public static class Builder {
        public boolean isNoCache = false;
        public KsPlayerLogParams ksplayerLogParams;
        public String manifest;
        public VideoPlayerStatus videoPlayerStatus;
        public String videoUrl;

        public Builder(String str) {
            this.videoUrl = str;
        }

        public Builder ksplayerLogParams(@NonNull KsPlayerLogParams ksPlayerLogParams) {
            this.ksplayerLogParams = ksPlayerLogParams;
            return this;
        }

        public Builder manifest(String str) {
            this.manifest = str;
            return this;
        }

        public Builder noCache(boolean z) {
            this.isNoCache = z;
            return this;
        }

        public Builder videoPlayerStatus(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public Builder videoUrl(String str) {
            this.videoUrl = str;
            return this;
        }

        public PlayVideoInfo build() {
            return new PlayVideoInfo(this);
        }
    }

    public PlayVideoInfo(Builder builder) {
        this.ksplayerLogParams = new KsPlayerLogParams();
        this.videoUrl = builder.videoUrl;
        this.manifest = builder.manifest;
        this.videoPlayerStatus = builder.videoPlayerStatus;
        if (builder.ksplayerLogParams != null) {
            this.ksplayerLogParams.photoId = builder.ksplayerLogParams.photoId;
            this.ksplayerLogParams.clickTime = builder.ksplayerLogParams.clickTime;
            this.ksplayerLogParams.adStyle = builder.ksplayerLogParams.adStyle;
            this.ksplayerLogParams.contentType = builder.ksplayerLogParams.contentType;
        }
        this.isNoCache = builder.isNoCache;
    }
}
