package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f33220a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerStatus f33221b;

    /* renamed from: c  reason: collision with root package name */
    public c f33222c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f33223a;

        /* renamed from: b  reason: collision with root package name */
        public VideoPlayerStatus f33224b;

        /* renamed from: c  reason: collision with root package name */
        public c f33225c;

        public a a(@NonNull c cVar) {
            this.f33225c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f33224b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f33223a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f33222c = new c();
        this.f33220a = aVar.f33223a;
        this.f33221b = aVar.f33224b;
        if (aVar.f33225c != null) {
            this.f33222c.f33218a = aVar.f33225c.f33218a;
            this.f33222c.f33219b = aVar.f33225c.f33219b;
        }
    }
}
