package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class d implements m {
    @Override // com.google.android.exoplayer2.extractor.m
    public void h(Format format) {
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public int a(f fVar, int i, boolean z) throws IOException, InterruptedException {
        int Ju = fVar.Ju(i);
        if (Ju == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        return Ju;
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(com.google.android.exoplayer2.util.l lVar, int i) {
        lVar.skipBytes(i);
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(long j, int i, int i2, int i3, m.a aVar) {
    }
}
