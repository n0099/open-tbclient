package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f31957a;

    /* renamed from: b  reason: collision with root package name */
    public String f31958b;

    /* renamed from: c  reason: collision with root package name */
    public VideoPlayerStatus f31959c;

    /* renamed from: d  reason: collision with root package name */
    public b f31960d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31961e;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f31962a;

        /* renamed from: b  reason: collision with root package name */
        public String f31963b;

        /* renamed from: c  reason: collision with root package name */
        public VideoPlayerStatus f31964c;

        /* renamed from: d  reason: collision with root package name */
        public b f31965d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f31966e = false;

        public a a(@NonNull b bVar) {
            this.f31965d = bVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f31964c = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f31962a = str;
            return this;
        }

        public a a(boolean z) {
            this.f31966e = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(String str) {
            this.f31963b = str;
            return this;
        }
    }

    public c(a aVar) {
        this.f31960d = new b();
        this.f31961e = false;
        this.f31957a = aVar.f31962a;
        this.f31958b = aVar.f31963b;
        this.f31959c = aVar.f31964c;
        if (aVar.f31965d != null) {
            this.f31960d.f31955a = aVar.f31965d.f31955a;
            this.f31960d.f31956b = aVar.f31965d.f31956b;
        }
        this.f31961e = aVar.f31966e;
    }
}
