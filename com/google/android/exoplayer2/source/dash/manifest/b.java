package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public final long duration;
    public final long muJ;
    public final long muK;
    public final boolean muL;
    public final long muM;
    public final long muN;
    public final long muO;
    public final k muP;
    public final Uri muQ;
    private final List<e> muR;

    public b(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<e> list) {
        this.muJ = j;
        this.duration = j2;
        this.muK = j3;
        this.muL = z;
        this.muM = j4;
        this.muN = j5;
        this.muO = j6;
        this.muP = kVar;
        this.muQ = uri;
        this.muR = list == null ? Collections.emptyList() : list;
    }

    public final int dtC() {
        return this.muR.size();
    }

    public final e KZ(int i) {
        return this.muR.get(i);
    }

    public final long La(int i) {
        if (i == this.muR.size() - 1) {
            if (this.duration == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.duration - this.muR.get(i).mvb;
        }
        return this.muR.get(i + 1).mvb - this.muR.get(i).mvb;
    }

    public final long Lb(int i) {
        return com.google.android.exoplayer2.b.fo(La(i));
    }
}
