package com.google.android.exoplayer2.text.e;

import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
final class f implements com.google.android.exoplayer2.text.e {
    private final b mxb;
    private final long[] mxc;
    private final Map<String, e> mxd;
    private final Map<String, c> mxe;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.mxb = bVar;
        this.mxe = map2;
        this.mxd = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.mxc = bVar.dvL();
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gt(long j) {
        int b = v.b(this.mxc, j, false, false);
        if (b < this.mxc.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dvl() {
        return this.mxc.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long KW(int i) {
        return this.mxc[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gu(long j) {
        return this.mxb.a(j, this.mxd, this.mxe);
    }
}
