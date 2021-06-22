package com.kwad.sdk.glide.request.a;

import androidx.annotation.NonNull;
@Deprecated
/* loaded from: classes7.dex */
public abstract class h<Z> extends a<Z> {

    /* renamed from: a  reason: collision with root package name */
    public final int f36575a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36576b;

    public h() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public h(int i2, int i3) {
        this.f36575a = i2;
        this.f36576b = i3;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void a(@NonNull i iVar) {
        if (com.kwad.sdk.glide.g.k.a(this.f36575a, this.f36576b)) {
            iVar.a(this.f36575a, this.f36576b);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f36575a + " and height: " + this.f36576b + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void b(@NonNull i iVar) {
    }
}
