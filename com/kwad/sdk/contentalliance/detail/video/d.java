package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f32830a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerStatus f32831b;

    /* renamed from: c  reason: collision with root package name */
    public c f32832c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f32833a;

        /* renamed from: b  reason: collision with root package name */
        public VideoPlayerStatus f32834b;

        /* renamed from: c  reason: collision with root package name */
        public c f32835c;

        public a a(@NonNull c cVar) {
            this.f32835c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f32834b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f32833a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f32832c = new c();
        this.f32830a = aVar.f32833a;
        this.f32831b = aVar.f32834b;
        if (aVar.f32835c != null) {
            this.f32832c.f32828a = aVar.f32835c.f32828a;
            this.f32832c.f32829b = aVar.f32835c.f32829b;
        }
    }
}
