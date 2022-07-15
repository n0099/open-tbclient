package com.kwad.sdk.contentalliance.kwai.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes5.dex */
public final class b {
    public AdTemplate a;
    public String b;
    public String c;
    public VideoPlayerStatus d;
    public com.kwad.sdk.contentalliance.kwai.kwai.a e;
    public boolean f;

    /* loaded from: classes5.dex */
    public static class a {
        public AdTemplate a;
        public String b;
        public String c;
        public VideoPlayerStatus d;
        public com.kwad.sdk.contentalliance.kwai.kwai.a e;
        public boolean f = false;

        public a(AdTemplate adTemplate) {
            this.a = adTemplate;
        }

        public final a a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
            this.e = aVar;
            return this;
        }

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.d = videoPlayerStatus;
            return this;
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final a a(boolean z) {
            this.f = z;
            return this;
        }

        public final b a() {
            return new b(this, (byte) 0);
        }

        public final a b(String str) {
            this.c = str;
            return this;
        }
    }

    public b(a aVar) {
        this.e = new com.kwad.sdk.contentalliance.kwai.kwai.a();
        this.f = false;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        if (aVar.e != null) {
            this.e.a = aVar.e.a;
            this.e.b = aVar.e.b;
            this.e.c = aVar.e.c;
            this.e.d = aVar.e.d;
        }
        this.f = aVar.f;
    }

    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }
}
