package com.google.android.exoplayer2.source.hls.playlist;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b extends c {
    public final DrmInitData drmInitData;
    public final long lZB;
    public final long mti;
    public final int mwH;
    public final long mwI;
    public final boolean mwJ;
    public final int mwK;
    public final int mwL;
    public final long mwM;
    public final boolean mwN;
    public final boolean mwO;
    public final boolean mwP;
    public final a mwQ;
    public final List<a> mwR;
    public final int version;

    /* loaded from: classes6.dex */
    public static final class a implements Comparable<Long> {
        public final long lZB;
        public final int mwS;
        public final long mwT;
        public final String mwU;
        public final String mwV;
        public final long mwW;
        public final long mwX;
        public final String url;

        public a(String str, long j, long j2) {
            this(str, 0L, -1, -9223372036854775807L, null, null, j, j2);
        }

        public a(String str, long j, int i, long j2, String str2, String str3, long j3, long j4) {
            this.url = str;
            this.lZB = j;
            this.mwS = i;
            this.mwT = j2;
            this.mwU = str2;
            this.mwV = str3;
            this.mwW = j3;
            this.mwX = j4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: g */
        public int compareTo(@NonNull Long l) {
            if (this.mwT > l.longValue()) {
                return 1;
            }
            return this.mwT < l.longValue() ? -1 : 0;
        }
    }

    public b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, a aVar, List<a> list2) {
        super(str, list);
        this.mwH = i;
        this.mti = j2;
        this.mwJ = z;
        this.mwK = i2;
        this.mwL = i3;
        this.version = i4;
        this.mwM = j3;
        this.mwN = z2;
        this.mwO = z3;
        this.mwP = z4;
        this.drmInitData = drmInitData;
        this.mwQ = aVar;
        this.mwR = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.lZB = aVar2.lZB + aVar2.mwT;
        } else {
            this.lZB = 0L;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.lZB;
        }
        this.mwI = j;
    }

    public boolean c(b bVar) {
        if (bVar == null || this.mwL > bVar.mwL) {
            return true;
        }
        if (this.mwL >= bVar.mwL) {
            int size = this.mwR.size();
            int size2 = bVar.mwR.size();
            return size > size2 || (size == size2 && this.mwO && !bVar.mwO);
        }
        return false;
    }

    public long dxs() {
        return this.mti + this.lZB;
    }

    public b D(long j, int i) {
        return new b(this.mwH, this.mwY, this.tags, this.mwI, j, true, i, this.mwL, this.version, this.mwM, this.mwN, this.mwO, this.mwP, this.drmInitData, this.mwQ, this.mwR);
    }

    public b dxt() {
        return this.mwO ? this : new b(this.mwH, this.mwY, this.tags, this.mwI, this.mti, this.mwJ, this.mwK, this.mwL, this.version, this.mwM, this.mwN, true, this.mwP, this.drmInitData, this.mwQ, this.mwR);
    }
}
