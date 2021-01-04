package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f8908a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerStatus f8909b;
    public c c;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8910a;

        /* renamed from: b  reason: collision with root package name */
        private VideoPlayerStatus f8911b;
        private c c;

        public a a(@NonNull c cVar) {
            this.c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f8911b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f8910a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    private d(a aVar) {
        this.c = new c();
        this.f8908a = aVar.f8910a;
        this.f8909b = aVar.f8911b;
        if (aVar.c != null) {
            this.c.f8906a = aVar.c.f8906a;
            this.c.f8907b = aVar.c.f8907b;
        }
    }
}
