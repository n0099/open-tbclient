package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public final long duration;
    public final long mub;
    public final long muc;
    public final boolean mud;
    public final long mue;
    public final long muf;
    public final long mug;
    public final k muh;
    public final Uri mui;
    private final List<e> muj;

    public b(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<e> list) {
        this.mub = j;
        this.duration = j2;
        this.muc = j3;
        this.mud = z;
        this.mue = j4;
        this.muf = j5;
        this.mug = j6;
        this.muh = kVar;
        this.mui = uri;
        this.muj = list == null ? Collections.emptyList() : list;
    }

    public final int dso() {
        return this.muj.size();
    }

    public final e KU(int i) {
        return this.muj.get(i);
    }

    public final long KV(int i) {
        if (i == this.muj.size() - 1) {
            if (this.duration == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.duration - this.muj.get(i).mut;
        }
        return this.muj.get(i + 1).mut - this.muj.get(i).mut;
    }

    public final long KW(int i) {
        return com.google.android.exoplayer2.b.fq(KV(i));
    }
}
