package com.google.android.exoplayer2.text.a;

import com.google.android.exoplayer2.text.i;
/* loaded from: classes4.dex */
public final class e extends i {
    private final d mvF;

    public e(d dVar) {
        this.mvF = dVar;
    }

    @Override // com.google.android.exoplayer2.text.i
    public final void release() {
        this.mvF.a(this);
    }
}
