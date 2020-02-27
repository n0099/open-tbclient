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

    void dwc() throws IOException;

    u dwd();

    long dwe();

    @Override // com.google.android.exoplayer2.source.q
    long dwf();

    @Override // com.google.android.exoplayer2.source.q
    long dwg();

    void gb(long j);

    long gc(long j);

    @Override // com.google.android.exoplayer2.source.q
    boolean gd(long j);
}
