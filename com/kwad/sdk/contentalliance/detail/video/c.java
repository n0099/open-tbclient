package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes4.dex */
public class c {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public String f55792b;

    /* renamed from: c  reason: collision with root package name */
    public String f55793c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayerStatus f55794d;

    /* renamed from: e  reason: collision with root package name */
    public b f55795e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55796f;

    /* loaded from: classes4.dex */
    public static class a {
        public AdTemplate a;

        /* renamed from: b  reason: collision with root package name */
        public String f55797b;

        /* renamed from: c  reason: collision with root package name */
        public String f55798c;

        /* renamed from: d  reason: collision with root package name */
        public VideoPlayerStatus f55799d;

        /* renamed from: e  reason: collision with root package name */
        public b f55800e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f55801f = false;

        public a(AdTemplate adTemplate) {
            this.a = adTemplate;
        }

        public a a(@NonNull b bVar) {
            this.f55800e = bVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f55799d = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f55797b = str;
            return this;
        }

        public a a(boolean z) {
            this.f55801f = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(String str) {
            this.f55798c = str;
            return this;
        }
    }

    public c(a aVar) {
        this.f55795e = new b();
        this.f55796f = false;
        this.a = aVar.a;
        this.f55792b = aVar.f55797b;
        this.f55793c = aVar.f55798c;
        this.f55794d = aVar.f55799d;
        if (aVar.f55800e != null) {
            this.f55795e.a = aVar.f55800e.a;
            this.f55795e.f55789b = aVar.f55800e.f55789b;
            this.f55795e.f55790c = aVar.f55800e.f55790c;
            this.f55795e.f55791d = aVar.f55800e.f55791d;
        }
        this.f55796f = aVar.f55801f;
    }
}
