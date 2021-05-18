package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f32028a;

    /* renamed from: b  reason: collision with root package name */
    public String f32029b;

    /* renamed from: c  reason: collision with root package name */
    public VideoPlayerStatus f32030c;

    /* renamed from: d  reason: collision with root package name */
    public b f32031d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32032e;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f32033a;

        /* renamed from: b  reason: collision with root package name */
        public String f32034b;

        /* renamed from: c  reason: collision with root package name */
        public VideoPlayerStatus f32035c;

        /* renamed from: d  reason: collision with root package name */
        public b f32036d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32037e = false;

        public a a(@NonNull b bVar) {
            this.f32036d = bVar;
            return this;
        }

        public a a(VideoPlayerStatus videoPlayerStatus) {
            this.f32035c = videoPlayerStatus;
            return this;
        }

        public a a(String str) {
            this.f32033a = str;
            return this;
        }

        public a a(boolean z) {
            this.f32037e = z;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(String str) {
            this.f32034b = str;
            return this;
        }
    }

    public c(a aVar) {
        this.f32031d = new b();
        this.f32032e = false;
        this.f32028a = aVar.f32033a;
        this.f32029b = aVar.f32034b;
        this.f32030c = aVar.f32035c;
        if (aVar.f32036d != null) {
            this.f32031d.f32026a = aVar.f32036d.f32026a;
            this.f32031d.f32027b = aVar.f32036d.f32027b;
        }
        this.f32032e = aVar.f32037e;
    }
}
