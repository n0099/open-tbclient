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

    void dwe() throws IOException;

    u dwf();

    long dwg();

    @Override // com.google.android.exoplayer2.source.q
    long dwh();

    @Override // com.google.android.exoplayer2.source.q
    long dwi();

    void gb(long j);

    long gc(long j);

    @Override // com.google.android.exoplayer2.source.q
    boolean gd(long j);
}
