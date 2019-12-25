package com.google.android.exoplayer2.text;
/* loaded from: classes4.dex */
final class d extends i {
    private final c muj;

    public d(c cVar) {
        this.muj = cVar;
    }

    @Override // com.google.android.exoplayer2.text.i
    public final void release() {
        this.muj.a((i) this);
    }
}
