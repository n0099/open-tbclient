package com.google.android.exoplayer2.source.hls.playlist;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class b extends c {
    public final DrmInitData drmInitData;
    public final long lUZ;
    public final long moI;
    public final int msi;
    public final long msj;
    public final boolean msk;
    public final int msl;
    public final int msm;
    public final long msn;
    public final boolean mso;
    public final boolean msp;
    public final boolean msq;
    public final a msr;
    public final List<a> mss;
    public final int version;

    /* loaded from: classes4.dex */
    public static final class a implements Comparable<Long> {
        public final long lUZ;
        public final int mst;
        public final long msu;
        public final String msv;
        public final String msw;
        public final long msx;
        public final long msy;
        public final String url;

        public a(String str, long j, long j2) {
            this(str, 0L, -1, -9223372036854775807L, null, null, j, j2);
        }

        public a(String str, long j, int i, long j2, String str2, String str3, long j3, long j4) {
            this.url = str;
            this.lUZ = j;
            this.mst = i;
            this.msu = j2;
            this.msv = str2;
            this.msw = str3;
            this.msx = j3;
            this.msy = j4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: g */
        public int compareTo(@NonNull Long l) {
            if (this.msu > l.longValue()) {
                return 1;
            }
            return this.msu < l.longValue() ? -1 : 0;
        }
    }

    public b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, a aVar, List<a> list2) {
        super(str, list);
        this.msi = i;
        this.moI = j2;
        this.msk = z;
        this.msl = i2;
        this.msm = i3;
        this.version = i4;
        this.msn = j3;
        this.mso = z2;
        this.msp = z3;
        this.msq = z4;
        this.drmInitData = drmInitData;
        this.msr = aVar;
        this.mss = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.lUZ = aVar2.lUZ + aVar2.msu;
        } else {
            this.lUZ = 0L;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.lUZ;
        }
        this.msj = j;
    }

    public boolean c(b bVar) {
        if (bVar == null || this.msm > bVar.msm) {
            return true;
        }
        if (this.msm >= bVar.msm) {
            int size = this.mss.size();
            int size2 = bVar.mss.size();
            return size > size2 || (size == size2 && this.msp && !bVar.msp);
        }
        return false;
    }

    public long duV() {
        return this.moI + this.lUZ;
    }

    public b D(long j, int i) {
        return new b(this.msi, this.msz, this.tags, this.msj, j, true, i, this.msm, this.version, this.msn, this.mso, this.msp, this.msq, this.drmInitData, this.msr, this.mss);
    }

    public b duW() {
        return this.msp ? this : new b(this.msi, this.msz, this.tags, this.msj, this.moI, this.msk, this.msl, this.msm, this.version, this.msn, this.mso, true, this.msq, this.drmInitData, this.msr, this.mss);
    }
}
