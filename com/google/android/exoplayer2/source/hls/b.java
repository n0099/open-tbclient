package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.upstream.e;
/* loaded from: classes5.dex */
public final class b implements e {
    private final e.a mrr;

    public b(e.a aVar) {
        this.mrr = aVar;
    }

    @Override // com.google.android.exoplayer2.source.hls.e
    public com.google.android.exoplayer2.upstream.e La(int i) {
        return this.mrr.dxJ();
    }
}
