package com.kwad.sdk.glide.g.a;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public abstract class c {

    /* loaded from: classes3.dex */
    private static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f10016a;

        a() {
            super();
        }

        @Override // com.kwad.sdk.glide.g.a.c
        public void a(boolean z) {
            this.f10016a = z;
        }

        @Override // com.kwad.sdk.glide.g.a.c
        public void b() {
            if (this.f10016a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private c() {
    }

    @NonNull
    public static c a() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(boolean z);

    public abstract void b();
}
