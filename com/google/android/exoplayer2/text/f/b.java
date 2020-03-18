package com.google.android.exoplayer2.text.f;

import com.google.android.exoplayer2.text.e;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
final class b implements e {
    public static final b mDL = new b();
    private final List<com.google.android.exoplayer2.text.b> mAY;

    public b(com.google.android.exoplayer2.text.b bVar) {
        this.mAY = Collections.singletonList(bVar);
    }

    private b() {
        this.mAY = Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gx(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dyi() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lq(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gy(long j) {
        return j >= 0 ? this.mAY : Collections.emptyList();
    }
}
