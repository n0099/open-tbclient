package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes7.dex */
public class c {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public String f39285b;

    /* renamed from: c  reason: collision with root package name */
    public String f39286c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayerStatus f39287d;

    /* renamed from: e  reason: collision with root package name */
    public b f39288e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39289f;

    /* loaded from: classes7.dex */
    public static class a {
        public AdTemplate a;

        /* renamed from: b  reason: collision with root package name */
        public String f39290b;

        /* renamed from: c  reason: collision with root package name */
        public String f39291c;

        /* renamed from: d  reason: collision with root package name */
        public VideoPlayerStatus f39292d;

        /* renamed from: e  reason: collision with root package name */
        public b f39293e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f39294f = false;

        public a(AdTemplate adTemplate) {
            this.a = adTemplate;
        }

        public a a(@NonNull b bVar) {
            this.f39293e = bVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f39292d = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f39290b = str;
            return this;
        }

        public a a(boolean z) {
            this.f39294f = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(String str) {
            this.f39291c = str;
            return this;
        }
    }

    public c(a aVar) {
        this.f39288e = new b();
        this.f39289f = false;
        this.a = aVar.a;
        this.f39285b = aVar.f39290b;
        this.f39286c = aVar.f39291c;
        this.f39287d = aVar.f39292d;
        if (aVar.f39293e != null) {
            this.f39288e.a = aVar.f39293e.a;
            this.f39288e.f39282b = aVar.f39293e.f39282b;
            this.f39288e.f39283c = aVar.f39293e.f39283c;
            this.f39288e.f39284d = aVar.f39293e.f39284d;
        }
        this.f39289f = aVar.f39294f;
    }
}
