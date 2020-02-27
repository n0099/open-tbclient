package com.google.android.exoplayer2.text.a;

import com.google.android.exoplayer2.text.i;
/* loaded from: classes6.dex */
public final class e extends i {
    private final d mAd;

    public e(d dVar) {
        this.mAd = dVar;
    }

    @Override // com.google.android.exoplayer2.text.i
    public final void release() {
        this.mAd.a(this);
    }
}
