package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f8909a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerStatus f8910b;
    public c c;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8911a;

        /* renamed from: b  reason: collision with root package name */
        private VideoPlayerStatus f8912b;
        private c c;

        public a a(@NonNull c cVar) {
            this.c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f8912b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f8911a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    private d(a aVar) {
        this.c = new c();
        this.f8909a = aVar.f8911a;
        this.f8910b = aVar.f8912b;
        if (aVar.c != null) {
            this.c.f8907a = aVar.c.f8907a;
            this.c.f8908b = aVar.c.f8908b;
        }
    }
}
