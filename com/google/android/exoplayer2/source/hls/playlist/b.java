package com.google.android.exoplayer2.source.hls.playlist;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class b extends c {
    public final DrmInitData drmInitData;
    public final long lYQ;
    public final long msx;
    public final int mvW;
    public final long mvX;
    public final boolean mvY;
    public final int mvZ;
    public final int mwa;
    public final long mwb;
    public final boolean mwc;
    public final boolean mwd;
    public final boolean mwe;
    public final a mwf;
    public final List<a> mwg;
    public final int version;

    /* loaded from: classes5.dex */
    public static final class a implements Comparable<Long> {
        public final long lYQ;
        public final int mwh;
        public final long mwi;
        public final String mwj;
        public final String mwk;
        public final long mwl;
        public final long mwm;
        public final String url;

        public a(String str, long j, long j2) {
            this(str, 0L, -1, -9223372036854775807L, null, null, j, j2);
        }

        public a(String str, long j, int i, long j2, String str2, String str3, long j3, long j4) {
            this.url = str;
            this.lYQ = j;
            this.mwh = i;
            this.mwi = j2;
            this.mwj = str2;
            this.mwk = str3;
            this.mwl = j3;
            this.mwm = j4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: g */
        public int compareTo(@NonNull Long l) {
            if (this.mwi > l.longValue()) {
                return 1;
            }
            return this.mwi < l.longValue() ? -1 : 0;
        }
    }

    public b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, a aVar, List<a> list2) {
        super(str, list);
        this.mvW = i;
        this.msx = j2;
        this.mvY = z;
        this.mvZ = i2;
        this.mwa = i3;
        this.version = i4;
        this.mwb = j3;
        this.mwc = z2;
        this.mwd = z3;
        this.mwe = z4;
        this.drmInitData = drmInitData;
        this.mwf = aVar;
        this.mwg = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.lYQ = aVar2.lYQ + aVar2.mwi;
        } else {
            this.lYQ = 0L;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.lYQ;
        }
        this.mvX = j;
    }

    public boolean c(b bVar) {
        if (bVar == null || this.mwa > bVar.mwa) {
            return true;
        }
        if (this.mwa >= bVar.mwa) {
            int size = this.mwg.size();
            int size2 = bVar.mwg.size();
            return size > size2 || (size == size2 && this.mwd && !bVar.mwd);
        }
        return false;
    }

    public long dwg() {
        return this.msx + this.lYQ;
    }

    public b D(long j, int i) {
        return new b(this.mvW, this.mwn, this.tags, this.mvX, j, true, i, this.mwa, this.version, this.mwb, this.mwc, this.mwd, this.mwe, this.drmInitData, this.mwf, this.mwg);
    }

    public b dwh() {
        return this.mwd ? this : new b(this.mvW, this.mwn, this.tags, this.mvX, this.msx, this.mvY, this.mvZ, this.mwa, this.version, this.mwb, this.mwc, true, this.mwe, this.drmInitData, this.mwf, this.mwg);
    }
}
