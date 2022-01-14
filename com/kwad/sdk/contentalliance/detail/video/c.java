package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes3.dex */
public class c {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public String f55580b;

    /* renamed from: c  reason: collision with root package name */
    public String f55581c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayerStatus f55582d;

    /* renamed from: e  reason: collision with root package name */
    public b f55583e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55584f;

    /* loaded from: classes3.dex */
    public static class a {
        public AdTemplate a;

        /* renamed from: b  reason: collision with root package name */
        public String f55585b;

        /* renamed from: c  reason: collision with root package name */
        public String f55586c;

        /* renamed from: d  reason: collision with root package name */
        public VideoPlayerStatus f55587d;

        /* renamed from: e  reason: collision with root package name */
        public b f55588e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f55589f = false;

        public a(AdTemplate adTemplate) {
            this.a = adTemplate;
        }

        public a a(@NonNull b bVar) {
            this.f55588e = bVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f55587d = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f55585b = str;
            return this;
        }

        public a a(boolean z) {
            this.f55589f = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(String str) {
            this.f55586c = str;
            return this;
        }
    }

    public c(a aVar) {
        this.f55583e = new b();
        this.f55584f = false;
        this.a = aVar.a;
        this.f55580b = aVar.f55585b;
        this.f55581c = aVar.f55586c;
        this.f55582d = aVar.f55587d;
        if (aVar.f55588e != null) {
            this.f55583e.a = aVar.f55588e.a;
            this.f55583e.f55577b = aVar.f55588e.f55577b;
            this.f55583e.f55578c = aVar.f55588e.f55578c;
            this.f55583e.f55579d = aVar.f55588e.f55579d;
        }
        this.f55584f = aVar.f55589f;
    }
}
