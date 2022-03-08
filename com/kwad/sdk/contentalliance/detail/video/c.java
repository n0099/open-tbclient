package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes7.dex */
public class c {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public String f54142b;

    /* renamed from: c  reason: collision with root package name */
    public String f54143c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPlayerStatus f54144d;

    /* renamed from: e  reason: collision with root package name */
    public b f54145e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54146f;

    /* loaded from: classes7.dex */
    public static class a {
        public AdTemplate a;

        /* renamed from: b  reason: collision with root package name */
        public String f54147b;

        /* renamed from: c  reason: collision with root package name */
        public String f54148c;

        /* renamed from: d  reason: collision with root package name */
        public VideoPlayerStatus f54149d;

        /* renamed from: e  reason: collision with root package name */
        public b f54150e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f54151f = false;

        public a(AdTemplate adTemplate) {
            this.a = adTemplate;
        }

        public a a(@NonNull b bVar) {
            this.f54150e = bVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f54149d = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f54147b = str;
            return this;
        }

        public a a(boolean z) {
            this.f54151f = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(String str) {
            this.f54148c = str;
            return this;
        }
    }

    public c(a aVar) {
        this.f54145e = new b();
        this.f54146f = false;
        this.a = aVar.a;
        this.f54142b = aVar.f54147b;
        this.f54143c = aVar.f54148c;
        this.f54144d = aVar.f54149d;
        if (aVar.f54150e != null) {
            this.f54145e.a = aVar.f54150e.a;
            this.f54145e.f54139b = aVar.f54150e.f54139b;
            this.f54145e.f54140c = aVar.f54150e.f54140c;
            this.f54145e.f54141d = aVar.f54150e.f54141d;
        }
        this.f54146f = aVar.f54151f;
    }
}
