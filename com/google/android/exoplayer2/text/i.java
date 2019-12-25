package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class i extends com.google.android.exoplayer2.a.f implements e {
    private e mul;
    private long subsampleOffsetUs;

    public abstract void release();

    public void a(long j, e eVar, long j2) {
        this.lYY = j;
        this.mul = eVar;
        if (j2 == Format.OFFSET_SAMPLE_RELATIVE) {
            j2 = this.lYY;
        }
        this.subsampleOffsetUs = j2;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dvl() {
        return this.mul.dvl();
    }

    @Override // com.google.android.exoplayer2.text.e
    public long KW(int i) {
        return this.mul.KW(i) + this.subsampleOffsetUs;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gt(long j) {
        return this.mul.gt(j - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<b> gu(long j) {
        return this.mul.gu(j - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.a.a
    public void clear() {
        super.clear();
        this.mul = null;
    }
}
