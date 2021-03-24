package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f32540a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerStatus f32541b;

    /* renamed from: c  reason: collision with root package name */
    public c f32542c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f32543a;

        /* renamed from: b  reason: collision with root package name */
        public VideoPlayerStatus f32544b;

        /* renamed from: c  reason: collision with root package name */
        public c f32545c;

        public a a(@NonNull c cVar) {
            this.f32545c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f32544b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f32543a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f32542c = new c();
        this.f32540a = aVar.f32543a;
        this.f32541b = aVar.f32544b;
        if (aVar.f32545c != null) {
            this.f32542c.f32538a = aVar.f32545c.f32538a;
            this.f32542c.f32539b = aVar.f32545c.f32539b;
        }
    }
}
