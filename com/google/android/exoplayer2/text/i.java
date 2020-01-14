package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class i extends com.google.android.exoplayer2.a.f implements e {
    private e myd;
    private long subsampleOffsetUs;

    public abstract void release();

    public void a(long j, e eVar, long j2) {
        this.mcV = j;
        this.myd = eVar;
        if (j2 == Format.OFFSET_SAMPLE_RELATIVE) {
            j2 = this.mcV;
        }
        this.subsampleOffsetUs = j2;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dwy() {
        return this.myd.dwy();
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lf(int i) {
        return this.myd.Lf(i) + this.subsampleOffsetUs;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gy(long j) {
        return this.myd.gy(j - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<b> gz(long j) {
        return this.myd.gz(j - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.a.a
    public void clear() {
        super.clear();
        this.myd = null;
    }
}
