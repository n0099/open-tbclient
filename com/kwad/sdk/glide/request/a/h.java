package com.kwad.sdk.glide.request.a;

import androidx.annotation.NonNull;
@Deprecated
/* loaded from: classes6.dex */
public abstract class h<Z> extends a<Z> {

    /* renamed from: a  reason: collision with root package name */
    public final int f36163a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36164b;

    public h() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public h(int i, int i2) {
        this.f36163a = i;
        this.f36164b = i2;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void a(@NonNull i iVar) {
        if (com.kwad.sdk.glide.g.k.a(this.f36163a, this.f36164b)) {
            iVar.a(this.f36163a, this.f36164b);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f36163a + " and height: " + this.f36164b + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void b(@NonNull i iVar) {
    }
}
