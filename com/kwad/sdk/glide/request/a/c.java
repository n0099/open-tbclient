package com.kwad.sdk.glide.request.a;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public abstract class c<T> implements j<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f36157a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36158b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.request.c f36159c;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public c(int i, int i2) {
        if (com.kwad.sdk.glide.g.k.a(i, i2)) {
            this.f36157a = i;
            this.f36158b = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void a(@NonNull i iVar) {
        iVar.a(this.f36157a, this.f36158b);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void a(@Nullable com.kwad.sdk.glide.request.c cVar) {
        this.f36159c = cVar;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    @Nullable
    public final com.kwad.sdk.glide.request.c b() {
        return this.f36159c;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void b(@Nullable Drawable drawable) {
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void b(@NonNull i iVar) {
    }

    @Override // com.kwad.sdk.glide.c.i
    public void c() {
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void c(@Nullable Drawable drawable) {
    }

    @Override // com.kwad.sdk.glide.c.i
    public void d() {
    }

    @Override // com.kwad.sdk.glide.c.i
    public void e() {
    }
}
