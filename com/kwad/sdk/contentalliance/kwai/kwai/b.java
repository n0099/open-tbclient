package com.kwad.sdk.contentalliance.kwai.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes10.dex */
public final class b {
    public com.kwad.sdk.contentalliance.kwai.kwai.a Te;
    public AdTemplate adTemplate;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    /* loaded from: classes10.dex */
    public static class a {
        public com.kwad.sdk.contentalliance.kwai.kwai.a Te;
        public AdTemplate adTemplate;
        public boolean isNoCache = false;
        public String manifest;
        public VideoPlayerStatus videoPlayerStatus;
        public String videoUrl;

        public a(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public a(String str) {
            this.videoUrl = str;
        }

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public final a aJ(boolean z) {
            this.isNoCache = z;
            return this;
        }

        public final a b(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
            this.Te = aVar;
            return this;
        }

        public final a bk(String str) {
            this.videoUrl = str;
            return this;
        }

        public final a bl(String str) {
            this.manifest = str;
            return this;
        }

        public final b rC() {
            return new b(this, (byte) 0);
        }
    }

    public b(a aVar) {
        this.Te = new com.kwad.sdk.contentalliance.kwai.kwai.a();
        this.isNoCache = false;
        this.adTemplate = aVar.adTemplate;
        this.videoUrl = aVar.videoUrl;
        this.manifest = aVar.manifest;
        this.videoPlayerStatus = aVar.videoPlayerStatus;
        if (aVar.Te != null) {
            this.Te.photoId = aVar.Te.photoId;
            this.Te.clickTime = aVar.Te.clickTime;
            this.Te.adStyle = aVar.Te.adStyle;
            this.Te.contentType = aVar.Te.contentType;
        }
        this.isNoCache = aVar.isNoCache;
    }

    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }
}
