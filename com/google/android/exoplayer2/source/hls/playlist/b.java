package com.google.android.exoplayer2.source.hls.playlist;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b extends c {
    public final DrmInitData drmInitData;
    public final long lZO;
    public final long mtv;
    public final int mwU;
    public final long mwV;
    public final boolean mwW;
    public final int mwX;
    public final int mwY;
    public final long mwZ;
    public final boolean mxa;
    public final boolean mxb;
    public final boolean mxc;
    public final a mxd;
    public final List<a> mxe;
    public final int version;

    /* loaded from: classes6.dex */
    public static final class a implements Comparable<Long> {
        public final long lZO;
        public final int mxf;
        public final long mxg;
        public final String mxh;
        public final String mxi;
        public final long mxj;
        public final long mxk;
        public final String url;

        public a(String str, long j, long j2) {
            this(str, 0L, -1, -9223372036854775807L, null, null, j, j2);
        }

        public a(String str, long j, int i, long j2, String str2, String str3, long j3, long j4) {
            this.url = str;
            this.lZO = j;
            this.mxf = i;
            this.mxg = j2;
            this.mxh = str2;
            this.mxi = str3;
            this.mxj = j3;
            this.mxk = j4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: g */
        public int compareTo(@NonNull Long l) {
            if (this.mxg > l.longValue()) {
                return 1;
            }
            return this.mxg < l.longValue() ? -1 : 0;
        }
    }

    public b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, a aVar, List<a> list2) {
        super(str, list);
        this.mwU = i;
        this.mtv = j2;
        this.mwW = z;
        this.mwX = i2;
        this.mwY = i3;
        this.version = i4;
        this.mwZ = j3;
        this.mxa = z2;
        this.mxb = z3;
        this.mxc = z4;
        this.drmInitData = drmInitData;
        this.mxd = aVar;
        this.mxe = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.lZO = aVar2.lZO + aVar2.mxg;
        } else {
            this.lZO = 0L;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.lZO;
        }
        this.mwV = j;
    }

    public boolean c(b bVar) {
        if (bVar == null || this.mwY > bVar.mwY) {
            return true;
        }
        if (this.mwY >= bVar.mwY) {
            int size = this.mxe.size();
            int size2 = bVar.mxe.size();
            return size > size2 || (size == size2 && this.mxb && !bVar.mxb);
        }
        return false;
    }

    public long dxv() {
        return this.mtv + this.lZO;
    }

    public b D(long j, int i) {
        return new b(this.mwU, this.mxl, this.tags, this.mwV, j, true, i, this.mwY, this.version, this.mwZ, this.mxa, this.mxb, this.mxc, this.drmInitData, this.mxd, this.mxe);
    }

    public b dxw() {
        return this.mxb ? this : new b(this.mwU, this.mxl, this.tags, this.mwV, this.mtv, this.mwW, this.mwX, this.mwY, this.version, this.mwZ, this.mxa, true, this.mxc, this.drmInitData, this.mxd, this.mxe);
    }
}
