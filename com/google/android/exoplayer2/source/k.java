package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.q;
import java.io.IOException;
/* loaded from: classes4.dex */
public interface k extends q {

    /* loaded from: classes4.dex */
    public interface a extends q.a<k> {
        void a(k kVar);
    }

    long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j);

    void a(a aVar, long j);

    void dtF() throws IOException;

    u dtG();

    long dtH();

    @Override // com.google.android.exoplayer2.source.q
    long dtI();

    @Override // com.google.android.exoplayer2.source.q
    long dtJ();

    void fY(long j);

    long fZ(long j);

    @Override // com.google.android.exoplayer2.source.q
    boolean ga(long j);
}
