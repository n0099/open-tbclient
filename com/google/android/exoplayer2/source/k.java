package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.q;
import java.io.IOException;
/* loaded from: classes6.dex */
public interface k extends q {

    /* loaded from: classes6.dex */
    public interface a extends q.a<k> {
        void a(k kVar);
    }

    long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j);

    void a(a aVar, long j);

    void dwC() throws IOException;

    u dwD();

    long dwE();

    @Override // com.google.android.exoplayer2.source.q
    long dwF();

    @Override // com.google.android.exoplayer2.source.q
    long dwG();

    void gc(long j);

    long gd(long j);

    @Override // com.google.android.exoplayer2.source.q
    boolean ge(long j);
}
