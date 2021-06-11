package com.kwad.sdk.glide.g.a;

import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public abstract class c {

    /* loaded from: classes7.dex */
    public static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f35893a;

        public a() {
            super();
        }

        @Override // com.kwad.sdk.glide.g.a.c
        public void a(boolean z) {
            this.f35893a = z;
        }

        @Override // com.kwad.sdk.glide.g.a.c
        public void b() {
            if (this.f35893a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public c() {
    }

    @NonNull
    public static c a() {
        return new a();
    }

    public abstract void a(boolean z);

    public abstract void b();
}
