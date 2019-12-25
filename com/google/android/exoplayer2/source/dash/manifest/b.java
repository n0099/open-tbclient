package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public final long duration;
    public final long mqg;
    public final long mqh;
    public final boolean mqi;
    public final long mqj;
    public final long mqk;
    public final long mql;
    public final k mqm;
    public final Uri mqn;
    private final List<e> mqo;

    public b(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<e> list) {
        this.mqg = j;
        this.duration = j2;
        this.mqh = j3;
        this.mqi = z;
        this.mqj = j4;
        this.mqk = j5;
        this.mql = j6;
        this.mqm = kVar;
        this.mqn = uri;
        this.mqo = list == null ? Collections.emptyList() : list;
    }

    public final int dra() {
        return this.mqo.size();
    }

    public final e KL(int i) {
        return this.mqo.get(i);
    }

    public final long KM(int i) {
        if (i == this.mqo.size() - 1) {
            if (this.duration == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.duration - this.mqo.get(i).mqz;
        }
        return this.mqo.get(i + 1).mqz - this.mqo.get(i).mqz;
    }

    public final long KN(int i) {
        return com.google.android.exoplayer2.b.fl(KM(i));
    }
}
