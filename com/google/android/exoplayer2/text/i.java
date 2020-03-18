package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class i extends com.google.android.exoplayer2.a.f implements e {
    private e mAD;
    private long subsampleOffsetUs;

    public abstract void release();

    public void a(long j, e eVar, long j2) {
        this.mfu = j;
        this.mAD = eVar;
        if (j2 == Format.OFFSET_SAMPLE_RELATIVE) {
            j2 = this.mfu;
        }
        this.subsampleOffsetUs = j2;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dyi() {
        return this.mAD.dyi();
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lq(int i) {
        return this.mAD.Lq(i) + this.subsampleOffsetUs;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gx(long j) {
        return this.mAD.gx(j - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<b> gy(long j) {
        return this.mAD.gy(j - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.a.a
    public void clear() {
        super.clear();
        this.mAD = null;
    }
}
