package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class i extends com.google.android.exoplayer2.a.f implements e {
    private e myJ;
    private long subsampleOffsetUs;

    public abstract void release();

    public void a(long j, e eVar, long j2) {
        this.mdB = j;
        this.myJ = eVar;
        if (j2 == Format.OFFSET_SAMPLE_RELATIVE) {
            j2 = this.mdB;
        }
        this.subsampleOffsetUs = j2;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxI() {
        return this.myJ.dxI();
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        return this.myJ.Lk(i) + this.subsampleOffsetUs;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        return this.myJ.gw(j - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<b> gx(long j) {
        return this.myJ.gx(j - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.a.a
    public void clear() {
        super.clear();
        this.myJ = null;
    }
}
