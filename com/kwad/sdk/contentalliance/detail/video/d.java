package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f8611a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPlayerStatus f8612b;
    public c c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8613a;

        /* renamed from: b  reason: collision with root package name */
        private VideoPlayerStatus f8614b;
        private c c;

        public a a(@NonNull c cVar) {
            this.c = cVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f8614b = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f8613a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    private d(a aVar) {
        this.c = new c();
        this.f8611a = aVar.f8613a;
        this.f8612b = aVar.f8614b;
        if (aVar.c != null) {
            this.c.f8609a = aVar.c.f8609a;
            this.c.f8610b = aVar.c.f8610b;
        }
    }
}
