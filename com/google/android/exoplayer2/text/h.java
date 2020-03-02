package com.google.android.exoplayer2.text;

import android.support.annotation.NonNull;
/* loaded from: classes6.dex */
public final class h extends com.google.android.exoplayer2.a.e implements Comparable<h> {
    public long subsampleOffsetUs;

    public h() {
        super(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull h hVar) {
        if (duu() != hVar.duu()) {
            return duu() ? 1 : -1;
        }
        long j = this.mdD - hVar.mdD;
        if (j == 0) {
            return 0;
        }
        return j <= 0 ? -1 : 1;
    }
}
