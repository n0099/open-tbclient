package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class i extends com.google.android.exoplayer2.a.f implements e {
    private e myW;
    private long subsampleOffsetUs;

    public abstract void release();

    public void a(long j, e eVar, long j2) {
        this.mdO = j;
        this.myW = eVar;
        if (j2 == Format.OFFSET_SAMPLE_RELATIVE) {
            j2 = this.mdO;
        }
        this.subsampleOffsetUs = j2;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxL() {
        return this.myW.dxL();
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        return this.myW.Lk(i) + this.subsampleOffsetUs;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        return this.myW.gw(j - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<b> gx(long j) {
        return this.myW.gx(j - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.a.a
    public void clear() {
        super.clear();
        this.myW = null;
    }
}
