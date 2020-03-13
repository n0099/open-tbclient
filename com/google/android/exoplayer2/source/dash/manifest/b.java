package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public final long duration;
    public final long muU;
    public final long muV;
    public final boolean muW;
    public final long muX;
    public final long muY;
    public final long muZ;
    public final k mva;
    public final Uri mvb;
    private final List<e> mvc;

    public b(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<e> list) {
        this.muU = j;
        this.duration = j2;
        this.muV = j3;
        this.muW = z;
        this.muX = j4;
        this.muY = j5;
        this.muZ = j6;
        this.mva = kVar;
        this.mvb = uri;
        this.mvc = list == null ? Collections.emptyList() : list;
    }

    public final int dtD() {
        return this.mvc.size();
    }

    public final e KZ(int i) {
        return this.mvc.get(i);
    }

    public final long La(int i) {
        if (i == this.mvc.size() - 1) {
            if (this.duration == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.duration - this.mvc.get(i).mvm;
        }
        return this.mvc.get(i + 1).mvm - this.mvc.get(i).mvm;
    }

    public final long Lb(int i) {
        return com.google.android.exoplayer2.b.fo(La(i));
    }
}
