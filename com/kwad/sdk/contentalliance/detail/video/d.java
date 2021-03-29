package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f32541a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerStatus f32542b;

    /* renamed from: c  reason: collision with root package name */
    public c f32543c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f32544a;

        /* renamed from: b  reason: collision with root package name */
        public VideoPlayerStatus f32545b;

        /* renamed from: c  reason: collision with root package name */
        public c f32546c;

        public a a(@NonNull c cVar) {
            this.f32546c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f32545b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f32544a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f32543c = new c();
        this.f32541a = aVar.f32544a;
        this.f32542b = aVar.f32545b;
        if (aVar.f32546c != null) {
            this.f32543c.f32539a = aVar.f32546c.f32539a;
            this.f32543c.f32540b = aVar.f32546c.f32540b;
        }
    }
}
