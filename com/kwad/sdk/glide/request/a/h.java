package com.kwad.sdk.glide.request.a;

import androidx.annotation.NonNull;
@Deprecated
/* loaded from: classes5.dex */
public abstract class h<Z> extends a<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final int f10643a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10644b;

    public h() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public h(int i, int i2) {
        this.f10643a = i;
        this.f10644b = i2;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void a(@NonNull i iVar) {
        if (!com.kwad.sdk.glide.g.k.a(this.f10643a, this.f10644b)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f10643a + " and height: " + this.f10644b + ", either provide dimensions in the constructor or call override()");
        }
        iVar.a(this.f10643a, this.f10644b);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void b(@NonNull i iVar) {
    }
}
