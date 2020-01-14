package com.google.android.exoplayer2.text;

import android.support.annotation.NonNull;
/* loaded from: classes5.dex */
public final class h extends com.google.android.exoplayer2.a.e implements Comparable<h> {
    public long subsampleOffsetUs;

    public h() {
        super(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull h hVar) {
        if (dth() != hVar.dth()) {
            return dth() ? 1 : -1;
        }
        long j = this.mcV - hVar.mcV;
        if (j == 0) {
            return 0;
        }
        return j <= 0 ? -1 : 1;
    }
}
