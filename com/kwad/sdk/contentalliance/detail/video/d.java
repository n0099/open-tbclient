package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f5747a;
    public VideoPlayerStatus b;
    public c c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f5748a;
        private VideoPlayerStatus b;
        private c c;

        public a a(@NonNull c cVar) {
            this.c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f5748a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    private d(a aVar) {
        this.c = new c();
        this.f5747a = aVar.f5748a;
        this.b = aVar.b;
        if (aVar.c != null) {
            this.c.f5746a = aVar.c.f5746a;
            this.c.b = aVar.c.b;
        }
    }
}
