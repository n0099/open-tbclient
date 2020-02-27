package com.google.android.exoplayer2.text.f;

import com.google.android.exoplayer2.text.e;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
final class b implements e {
    public static final b mBO = new b();
    private final List<com.google.android.exoplayer2.text.b> mze;

    public b(com.google.android.exoplayer2.text.b bVar) {
        this.mze = Collections.singletonList(bVar);
    }

    private b() {
        this.mze = Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxI() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gx(long j) {
        return j >= 0 ? this.mze : Collections.emptyList();
    }
}
