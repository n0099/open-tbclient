package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f33122a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerStatus f33123b;

    /* renamed from: c  reason: collision with root package name */
    public c f33124c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f33125a;

        /* renamed from: b  reason: collision with root package name */
        public VideoPlayerStatus f33126b;

        /* renamed from: c  reason: collision with root package name */
        public c f33127c;

        public a a(@NonNull c cVar) {
            this.f33127c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f33126b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f33125a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f33124c = new c();
        this.f33122a = aVar.f33125a;
        this.f33123b = aVar.f33126b;
        if (aVar.f33127c != null) {
            this.f33124c.f33120a = aVar.f33127c.f33120a;
            this.f33124c.f33121b = aVar.f33127c.f33121b;
        }
    }
}
