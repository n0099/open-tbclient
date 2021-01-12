package com.kwad.sdk.glide.request.a;

import androidx.annotation.NonNull;
@Deprecated
/* loaded from: classes4.dex */
public abstract class h<Z> extends a<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final int f10343a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10344b;

    public h() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public h(int i, int i2) {
        this.f10343a = i;
        this.f10344b = i2;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void a(@NonNull i iVar) {
        if (!com.kwad.sdk.glide.g.k.a(this.f10343a, this.f10344b)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f10343a + " and height: " + this.f10344b + ", either provide dimensions in the constructor or call override()");
        }
        iVar.a(this.f10343a, this.f10344b);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void b(@NonNull i iVar) {
    }
}
