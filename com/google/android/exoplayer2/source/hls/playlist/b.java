package com.google.android.exoplayer2.source.hls.playlist;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b extends c {
    public final DrmInitData drmInitData;
    public final long mbx;
    public final long mvc;
    public final int myA;
    public final long myB;
    public final boolean myC;
    public final int myD;
    public final int myE;
    public final long myF;
    public final boolean myG;
    public final boolean myH;
    public final boolean myI;
    public final a myJ;
    public final List<a> myK;
    public final int version;

    /* loaded from: classes6.dex */
    public static final class a implements Comparable<Long> {
        public final long mbx;
        public final int myL;
        public final long myM;
        public final String myN;
        public final String myO;
        public final long myP;
        public final long myQ;
        public final String url;

        public a(String str, long j, long j2) {
            this(str, 0L, -1, -9223372036854775807L, null, null, j, j2);
        }

        public a(String str, long j, int i, long j2, String str2, String str3, long j3, long j4) {
            this.url = str;
            this.mbx = j;
            this.myL = i;
            this.myM = j2;
            this.myN = str2;
            this.myO = str3;
            this.myP = j3;
            this.myQ = j4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: g */
        public int compareTo(@NonNull Long l) {
            if (this.myM > l.longValue()) {
                return 1;
            }
            return this.myM < l.longValue() ? -1 : 0;
        }
    }

    public b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData, a aVar, List<a> list2) {
        super(str, list);
        this.myA = i;
        this.mvc = j2;
        this.myC = z;
        this.myD = i2;
        this.myE = i3;
        this.version = i4;
        this.myF = j3;
        this.myG = z2;
        this.myH = z3;
        this.myI = z4;
        this.drmInitData = drmInitData;
        this.myJ = aVar;
        this.myK = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.mbx = aVar2.mbx + aVar2.myM;
        } else {
            this.mbx = 0L;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.mbx;
        }
        this.myB = j;
    }

    public boolean c(b bVar) {
        if (bVar == null || this.myE > bVar.myE) {
            return true;
        }
        if (this.myE >= bVar.myE) {
            int size = this.myK.size();
            int size2 = bVar.myK.size();
            return size > size2 || (size == size2 && this.myH && !bVar.myH);
        }
        return false;
    }

    public long dxS() {
        return this.mvc + this.mbx;
    }

    public b D(long j, int i) {
        return new b(this.myA, this.myR, this.tags, this.myB, j, true, i, this.myE, this.version, this.myF, this.myG, this.myH, this.myI, this.drmInitData, this.myJ, this.myK);
    }

    public b dxT() {
        return this.myH ? this : new b(this.myA, this.myR, this.tags, this.myB, this.mvc, this.myC, this.myD, this.myE, this.version, this.myF, this.myG, true, this.myI, this.drmInitData, this.myJ, this.myK);
    }
}
