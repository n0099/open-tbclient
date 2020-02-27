package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public final long duration;
    public final long muH;
    public final long muI;
    public final boolean muJ;
    public final long muK;
    public final long muL;
    public final long muM;
    public final k muN;
    public final Uri muO;
    private final List<e> muP;

    public b(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<e> list) {
        this.muH = j;
        this.duration = j2;
        this.muI = j3;
        this.muJ = z;
        this.muK = j4;
        this.muL = j5;
        this.muM = j6;
        this.muN = kVar;
        this.muO = uri;
        this.muP = list == null ? Collections.emptyList() : list;
    }

    public final int dtA() {
        return this.muP.size();
    }

    public final e KZ(int i) {
        return this.muP.get(i);
    }

    public final long La(int i) {
        if (i == this.muP.size() - 1) {
            if (this.duration == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.duration - this.muP.get(i).muZ;
        }
        return this.muP.get(i + 1).muZ - this.muP.get(i).muZ;
    }

    public final long Lb(int i) {
        return com.google.android.exoplayer2.b.fo(La(i));
    }
}
