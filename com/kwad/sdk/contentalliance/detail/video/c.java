package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes3.dex */
public class c {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public String f55625b;

    /* renamed from: c  reason: collision with root package name */
    public String f55626c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayerStatus f55627d;

    /* renamed from: e  reason: collision with root package name */
    public b f55628e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55629f;

    /* loaded from: classes3.dex */
    public static class a {
        public AdTemplate a;

        /* renamed from: b  reason: collision with root package name */
        public String f55630b;

        /* renamed from: c  reason: collision with root package name */
        public String f55631c;

        /* renamed from: d  reason: collision with root package name */
        public VideoPlayerStatus f55632d;

        /* renamed from: e  reason: collision with root package name */
        public b f55633e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f55634f = false;

        public a(AdTemplate adTemplate) {
            this.a = adTemplate;
        }

        public a a(@NonNull b bVar) {
            this.f55633e = bVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f55632d = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f55630b = str;
            return this;
        }

        public a a(boolean z) {
            this.f55634f = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(String str) {
            this.f55631c = str;
            return this;
        }
    }

    public c(a aVar) {
        this.f55628e = new b();
        this.f55629f = false;
        this.a = aVar.a;
        this.f55625b = aVar.f55630b;
        this.f55626c = aVar.f55631c;
        this.f55627d = aVar.f55632d;
        if (aVar.f55633e != null) {
            this.f55628e.a = aVar.f55633e.a;
            this.f55628e.f55622b = aVar.f55633e.f55622b;
            this.f55628e.f55623c = aVar.f55633e.f55623c;
            this.f55628e.f55624d = aVar.f55633e.f55624d;
        }
        this.f55629f = aVar.f55634f;
    }
}
