package com.google.android.exoplayer2.text.a;

import com.google.android.exoplayer2.text.i;
/* loaded from: classes5.dex */
public final class e extends i {
    private final d mzx;

    public e(d dVar) {
        this.mzx = dVar;
    }

    @Override // com.google.android.exoplayer2.text.i
    public final void release() {
        this.mzx.a(this);
    }
}
