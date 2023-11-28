package com.kwad.sdk.contentalliance.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes10.dex */
public final class b {
    public AdTemplate adTemplate;
    public com.kwad.sdk.contentalliance.a.a.a aoi;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    /* loaded from: classes10.dex */
    public static class a {
        public AdTemplate adTemplate;
        public com.kwad.sdk.contentalliance.a.a.a aoi;
        public boolean isNoCache = false;
        public String manifest;
        public VideoPlayerStatus videoPlayerStatus;
        public String videoUrl;

        public a(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public final a bl(boolean z) {
            this.isNoCache = z;
            return this;
        }

        public final a cD(String str) {
            this.videoUrl = str;
            return this;
        }

        public final a cE(String str) {
            this.manifest = str;
            return this;
        }

        public a(String str) {
            this.videoUrl = str;
        }

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public final a b(@NonNull com.kwad.sdk.contentalliance.a.a.a aVar) {
            this.aoi = aVar;
            return this;
        }

        public final b Ah() {
            return new b(this, (byte) 0);
        }
    }

    public b(a aVar) {
        this.aoi = new com.kwad.sdk.contentalliance.a.a.a();
        this.isNoCache = false;
        this.adTemplate = aVar.adTemplate;
        this.videoUrl = aVar.videoUrl;
        this.manifest = aVar.manifest;
        this.videoPlayerStatus = aVar.videoPlayerStatus;
        if (aVar.aoi != null) {
            this.aoi.photoId = aVar.aoi.photoId;
            this.aoi.clickTime = aVar.aoi.clickTime;
            this.aoi.adStyle = aVar.aoi.adStyle;
            this.aoi.contentType = aVar.aoi.contentType;
        }
        this.isNoCache = aVar.isNoCache;
    }

    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }
}
