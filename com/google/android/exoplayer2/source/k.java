package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.q;
import java.io.IOException;
/* loaded from: classes5.dex */
public interface k extends q {

    /* loaded from: classes5.dex */
    public interface a extends q.a<k> {
        void a(k kVar);
    }

    long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j);

    void a(a aVar, long j);

    void duS() throws IOException;

    u duT();

    long duU();

    @Override // com.google.android.exoplayer2.source.q
    long duV();

    @Override // com.google.android.exoplayer2.source.q
    long duW();

    void gd(long j);

    long ge(long j);

    @Override // com.google.android.exoplayer2.source.q
    boolean gf(long j);
}
