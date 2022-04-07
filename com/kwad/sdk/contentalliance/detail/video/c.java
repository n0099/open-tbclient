package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes5.dex */
public class c {
    public AdTemplate a;
    public String b;
    public String c;
    public VideoPlayerStatus d;
    public b e;
    public boolean f;

    /* loaded from: classes5.dex */
    public static class a {
        public AdTemplate a;
        public String b;
        public String c;
        public VideoPlayerStatus d;
        public b e;
        public boolean f = false;

        public a(AdTemplate adTemplate) {
            this.a = adTemplate;
        }

        public a a(@NonNull b bVar) {
            this.e = bVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.d = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a a(boolean z) {
            this.f = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(String str) {
            this.c = str;
            return this;
        }
    }

    public c(a aVar) {
        this.e = new b();
        this.f = false;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        if (aVar.e != null) {
            this.e.a = aVar.e.a;
            this.e.b = aVar.e.b;
            this.e.c = aVar.e.c;
            this.e.d = aVar.e.d;
        }
        this.f = aVar.f;
    }
}
