package com.google.android.exoplayer2.text.a;

import com.google.android.exoplayer2.text.i;
/* loaded from: classes6.dex */
public final class e extends i {
    private final d mBY;

    public e(d dVar) {
        this.mBY = dVar;
    }

    @Override // com.google.android.exoplayer2.text.i
    public final void release() {
        this.mBY.a(this);
    }
}
