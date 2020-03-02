package com.google.android.exoplayer2.source.hls.playlist;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b extends c {
    public final DrmInitData drmInitData;
    public final long lZD;
    public final long mtk;
    public final int mwJ;
    public final long mwK;
    public final boolean mwL;
    public final int mwM;
    public final int mwN;
    public final long mwO;
    public final boolean mwP;
    public final boolean mwQ;
    public final boolean mwR;
    public final a mwS;
    public final List<a> mwT;
    public final int version;

    /* loaded from: classes6.dex */
    public static final class a implements Comparable<Long> {
        public final long lZD;
        public final int mwU;
        public final long mwV;
        public final String mwW;
        public final String mwX;
        public final long mwY;
        public final long mwZ;
        public final String url;

        public a(String str, long j, long j2) {
            this(str, 0L, -1, -9223372036854775807L, null, null, j, j2);
        }

        public a(String str, long j, int i, long j2, String str2, String str3, long j3, long j4) {
            this.url = str;
            this.lZD = j;
            this.mwU = i;
            this.mwV = j2;
            this.mwW = str2;
            this.mwX = str3;
            this.mwY = j3;
            this.mwZ = j4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: g */
        public int compareTo(@NonNull Long l) {
            if (this.mwV > l.longValue()) {
                return 1;
            }
            return this.mwV < l.longValue() ? -1 : 0;
        }
    }

    public b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, a aVar, List<a> list2) {
        super(str, list);
        this.mwJ = i;
        this.mtk = j2;
        this.mwL = z;
        this.mwM = i2;
        this.mwN = i3;
        this.version = i4;
        this.mwO = j3;
        this.mwP = z2;
        this.mwQ = z3;
        this.mwR = z4;
        this.drmInitData = drmInitData;
        this.mwS = aVar;
        this.mwT = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.lZD = aVar2.lZD + aVar2.mwV;
        } else {
            this.lZD = 0L;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.lZD;
        }
        this.mwK = j;
    }

    public boolean c(b bVar) {
        if (bVar == null || this.mwN > bVar.mwN) {
            return true;
        }
        if (this.mwN >= bVar.mwN) {
            int size = this.mwT.size();
            int size2 = bVar.mwT.size();
            return size > size2 || (size == size2 && this.mwQ && !bVar.mwQ);
        }
        return false;
    }

    public long dxu() {
        return this.mtk + this.lZD;
    }

    public b D(long j, int i) {
        return new b(this.mwJ, this.mxa, this.tags, this.mwK, j, true, i, this.mwN, this.version, this.mwO, this.mwP, this.mwQ, this.mwR, this.drmInitData, this.mwS, this.mwT);
    }

    public b dxv() {
        return this.mwQ ? this : new b(this.mwJ, this.mxa, this.tags, this.mwK, this.mtk, this.mwL, this.mwM, this.mwN, this.version, this.mwO, this.mwP, true, this.mwR, this.drmInitData, this.mwS, this.mwT);
    }
}
