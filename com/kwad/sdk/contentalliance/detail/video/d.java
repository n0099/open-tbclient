package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f32925a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerStatus f32926b;

    /* renamed from: c  reason: collision with root package name */
    public c f32927c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f32928a;

        /* renamed from: b  reason: collision with root package name */
        public VideoPlayerStatus f32929b;

        /* renamed from: c  reason: collision with root package name */
        public c f32930c;

        public a a(@NonNull c cVar) {
            this.f32930c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f32929b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f32928a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f32927c = new c();
        this.f32925a = aVar.f32928a;
        this.f32926b = aVar.f32929b;
        if (aVar.f32930c != null) {
            this.f32927c.f32923a = aVar.f32930c.f32923a;
            this.f32927c.f32924b = aVar.f32930c.f32924b;
        }
    }
}
