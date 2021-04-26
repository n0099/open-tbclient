package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f32783a;

    /* renamed from: b  reason: collision with root package name */
    public String f32784b;

    /* renamed from: c  reason: collision with root package name */
    public VideoPlayerStatus f32785c;

    /* renamed from: d  reason: collision with root package name */
    public b f32786d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32787e;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f32788a;

        /* renamed from: b  reason: collision with root package name */
        public String f32789b;

        /* renamed from: c  reason: collision with root package name */
        public VideoPlayerStatus f32790c;

        /* renamed from: d  reason: collision with root package name */
        public b f32791d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32792e = false;

        public a a(@NonNull b bVar) {
            this.f32791d = bVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f32790c = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f32788a = str;
            return this;
        }

        public a a(boolean z) {
            this.f32792e = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(String str) {
            this.f32789b = str;
            return this;
        }
    }

    public c(a aVar) {
        this.f32786d = new b();
        this.f32787e = false;
        this.f32783a = aVar.f32788a;
        this.f32784b = aVar.f32789b;
        this.f32785c = aVar.f32790c;
        if (aVar.f32791d != null) {
            this.f32786d.f32781a = aVar.f32791d.f32781a;
            this.f32786d.f32782b = aVar.f32791d.f32782b;
        }
        this.f32787e = aVar.f32792e;
    }
}
