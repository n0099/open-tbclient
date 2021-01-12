package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f8609a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerStatus f8610b;
    public c c;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8611a;

        /* renamed from: b  reason: collision with root package name */
        private VideoPlayerStatus f8612b;
        private c c;

        public a a(@NonNull c cVar) {
            this.c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f8612b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f8611a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    private d(a aVar) {
        this.c = new c();
        this.f8609a = aVar.f8611a;
        this.f8610b = aVar.f8612b;
        if (aVar.c != null) {
            this.c.f8607a = aVar.c.f8607a;
            this.c.f8608b = aVar.c.f8608b;
        }
    }
}
