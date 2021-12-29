package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes3.dex */
public class c {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public String f57768b;

    /* renamed from: c  reason: collision with root package name */
    public String f57769c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayerStatus f57770d;

    /* renamed from: e  reason: collision with root package name */
    public b f57771e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57772f;

    /* loaded from: classes3.dex */
    public static class a {
        public AdTemplate a;

        /* renamed from: b  reason: collision with root package name */
        public String f57773b;

        /* renamed from: c  reason: collision with root package name */
        public String f57774c;

        /* renamed from: d  reason: collision with root package name */
        public VideoPlayerStatus f57775d;

        /* renamed from: e  reason: collision with root package name */
        public b f57776e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f57777f = false;

        public a(AdTemplate adTemplate) {
            this.a = adTemplate;
        }

        public a a(@NonNull b bVar) {
            this.f57776e = bVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f57775d = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f57773b = str;
            return this;
        }

        public a a(boolean z) {
            this.f57777f = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(String str) {
            this.f57774c = str;
            return this;
        }
    }

    public c(a aVar) {
        this.f57771e = new b();
        this.f57772f = false;
        this.a = aVar.a;
        this.f57768b = aVar.f57773b;
        this.f57769c = aVar.f57774c;
        this.f57770d = aVar.f57775d;
        if (aVar.f57776e != null) {
            this.f57771e.a = aVar.f57776e.a;
            this.f57771e.f57765b = aVar.f57776e.f57765b;
            this.f57771e.f57766c = aVar.f57776e.f57766c;
            this.f57771e.f57767d = aVar.f57776e.f57767d;
        }
        this.f57772f = aVar.f57777f;
    }
}
