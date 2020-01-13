package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public final long duration;
    public final long mtW;
    public final long mtX;
    public final boolean mtY;
    public final long mtZ;
    public final long mua;
    public final long mub;
    public final k muc;
    public final Uri mud;
    private final List<e> mue;

    public b(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<e> list) {
        this.mtW = j;
        this.duration = j2;
        this.mtX = j3;
        this.mtY = z;
        this.mtZ = j4;
        this.mua = j5;
        this.mub = j6;
        this.muc = kVar;
        this.mud = uri;
        this.mue = list == null ? Collections.emptyList() : list;
    }

    public final int dsm() {
        return this.mue.size();
    }

    public final e KU(int i) {
        return this.mue.get(i);
    }

    public final long KV(int i) {
        if (i == this.mue.size() - 1) {
            if (this.duration == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.duration - this.mue.get(i).muo;
        }
        return this.mue.get(i + 1).muo - this.mue.get(i).muo;
    }

    public final long KW(int i) {
        return com.google.android.exoplayer2.b.fq(KV(i));
    }
}
