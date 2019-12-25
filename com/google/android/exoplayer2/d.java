package com.google.android.exoplayer2;
/* loaded from: classes4.dex */
public class d implements c {
    @Override // com.google.android.exoplayer2.c
    public boolean a(r rVar, boolean z) {
        rVar.vi(z);
        return true;
    }

    @Override // com.google.android.exoplayer2.c
    public boolean a(r rVar, int i, long j) {
        rVar.B(i, j);
        return true;
    }

    @Override // com.google.android.exoplayer2.c
    public boolean a(r rVar, int i) {
        rVar.setRepeatMode(i);
        return true;
    }

    @Override // com.google.android.exoplayer2.c
    public boolean b(r rVar, boolean z) {
        rVar.vj(z);
        return true;
    }
}
