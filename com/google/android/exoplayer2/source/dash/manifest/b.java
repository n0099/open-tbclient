package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public final long duration;
    public final long mwA;
    public final long mwB;
    public final boolean mwC;
    public final long mwD;
    public final long mwE;
    public final long mwF;
    public final k mwG;
    public final Uri mwH;
    private final List<e> mwI;

    public b(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<e> list) {
        this.mwA = j;
        this.duration = j2;
        this.mwB = j3;
        this.mwC = z;
        this.mwD = j4;
        this.mwE = j5;
        this.mwF = j6;
        this.mwG = kVar;
        this.mwH = uri;
        this.mwI = list == null ? Collections.emptyList() : list;
    }

    public final int dua() {
        return this.mwI.size();
    }

    public final e Lf(int i) {
        return this.mwI.get(i);
    }

    public final long Lg(int i) {
        if (i == this.mwI.size() - 1) {
            if (this.duration == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.duration - this.mwI.get(i).mwS;
        }
        return this.mwI.get(i + 1).mwS - this.mwI.get(i).mwS;
    }

    public final long Lh(int i) {
        return com.google.android.exoplayer2.b.fp(Lg(i));
    }
}
