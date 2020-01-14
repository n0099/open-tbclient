package com.google.android.exoplayer2.source.hls.playlist;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class b extends c {
    public final DrmInitData drmInitData;
    public final long lYV;
    public final long msC;
    public final int mwb;
    public final long mwc;
    public final boolean mwd;
    public final int mwe;
    public final int mwf;
    public final long mwg;
    public final boolean mwh;
    public final boolean mwi;
    public final boolean mwj;
    public final a mwk;
    public final List<a> mwl;
    public final int version;

    /* loaded from: classes5.dex */
    public static final class a implements Comparable<Long> {
        public final long lYV;
        public final int mwm;
        public final long mwn;
        public final String mwo;
        public final String mwp;
        public final long mwq;
        public final long mwr;
        public final String url;

        public a(String str, long j, long j2) {
            this(str, 0L, -1, -9223372036854775807L, null, null, j, j2);
        }

        public a(String str, long j, int i, long j2, String str2, String str3, long j3, long j4) {
            this.url = str;
            this.lYV = j;
            this.mwm = i;
            this.mwn = j2;
            this.mwo = str2;
            this.mwp = str3;
            this.mwq = j3;
            this.mwr = j4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: g */
        public int compareTo(@NonNull Long l) {
            if (this.mwn > l.longValue()) {
                return 1;
            }
            return this.mwn < l.longValue() ? -1 : 0;
        }
    }

    public b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, a aVar, List<a> list2) {
        super(str, list);
        this.mwb = i;
        this.msC = j2;
        this.mwd = z;
        this.mwe = i2;
        this.mwf = i3;
        this.version = i4;
        this.mwg = j3;
        this.mwh = z2;
        this.mwi = z3;
        this.mwj = z4;
        this.drmInitData = drmInitData;
        this.mwk = aVar;
        this.mwl = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.lYV = aVar2.lYV + aVar2.mwn;
        } else {
            this.lYV = 0L;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.lYV;
        }
        this.mwc = j;
    }

    public boolean c(b bVar) {
        if (bVar == null || this.mwf > bVar.mwf) {
            return true;
        }
        if (this.mwf >= bVar.mwf) {
            int size = this.mwl.size();
            int size2 = bVar.mwl.size();
            return size > size2 || (size == size2 && this.mwi && !bVar.mwi);
        }
        return false;
    }

    public long dwi() {
        return this.msC + this.lYV;
    }

    public b D(long j, int i) {
        return new b(this.mwb, this.mws, this.tags, this.mwc, j, true, i, this.mwf, this.version, this.mwg, this.mwh, this.mwi, this.mwj, this.drmInitData, this.mwk, this.mwl);
    }

    public b dwj() {
        return this.mwi ? this : new b(this.mwb, this.mws, this.tags, this.mwc, this.msC, this.mwd, this.mwe, this.mwf, this.version, this.mwg, this.mwh, true, this.mwj, this.drmInitData, this.mwk, this.mwl);
    }
}
