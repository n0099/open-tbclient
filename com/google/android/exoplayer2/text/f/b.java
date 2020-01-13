package com.google.android.exoplayer2.text.f;

import com.google.android.exoplayer2.text.e;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
final class b implements e {
    public static final b mBc = new b();
    private final List<com.google.android.exoplayer2.text.b> myt;

    public b(com.google.android.exoplayer2.text.b bVar) {
        this.myt = Collections.singletonList(bVar);
    }

    private b() {
        this.myt = Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gy(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dww() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lf(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gz(long j) {
        return j >= 0 ? this.myt : Collections.emptyList();
    }
}
