package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.v;
import java.util.List;
import java.util.UUID;
/* loaded from: classes4.dex */
public class a {
    public final int lCm;
    public final int lCn;
    public final long lUZ;
    public final int mtF;
    public final C0669a mtG;
    public final b[] mtH;
    public final long mtI;
    public final boolean mtj;

    public a(int i, int i2, long j, long j2, long j3, int i3, boolean z, C0669a c0669a, b[] bVarArr) {
        this(i, i2, j2 == 0 ? -9223372036854775807L : v.h(j2, TimeUtils.NANOS_PER_MS, j), j3 == 0 ? -9223372036854775807L : v.h(j3, TimeUtils.NANOS_PER_MS, j), i3, z, c0669a, bVarArr);
    }

    private a(int i, int i2, long j, long j2, int i3, boolean z, C0669a c0669a, b[] bVarArr) {
        this.lCm = i;
        this.lCn = i2;
        this.lUZ = j;
        this.mtI = j2;
        this.mtF = i3;
        this.mtj = z;
        this.mtG = c0669a;
        this.mtH = bVarArr;
    }

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0669a {
        public final byte[] data;
        public final UUID uuid;

        public C0669a(UUID uuid, byte[] bArr) {
            this.uuid = uuid;
            this.data = bArr;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public final String language;
        public final int maxHeight;
        public final int maxWidth;
        public final int mbB;
        public final int mbC;
        public final Format[] mnT;
        public final int mpj;
        private final String msz;
        private final String mtJ;
        private final List<Long> mtK;
        private final long[] mtL;
        private final long mtM;
        public final String name;
        public final String subType;
        public final long timescale;
        public final int type;

        public b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, formatArr, list, v.a(list, (long) TimeUtils.NANOS_PER_MS, j), v.h(j2, TimeUtils.NANOS_PER_MS, j));
        }

        private b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j2) {
            this.msz = str;
            this.mtJ = str2;
            this.type = i;
            this.subType = str3;
            this.timescale = j;
            this.name = str4;
            this.maxWidth = i2;
            this.maxHeight = i3;
            this.mbB = i4;
            this.mbC = i5;
            this.language = str5;
            this.mnT = formatArr;
            this.mtK = list;
            this.mtL = jArr;
            this.mtM = j2;
            this.mpj = list.size();
        }

        public int fH(long j) {
            return v.a(this.mtL, j, true, true);
        }

        public long KT(int i) {
            return this.mtL[i];
        }

        public long KU(int i) {
            return i == this.mpj + (-1) ? this.mtM : this.mtL[i + 1] - this.mtL[i];
        }

        public Uri dP(int i, int i2) {
            com.google.android.exoplayer2.util.a.checkState(this.mnT != null);
            com.google.android.exoplayer2.util.a.checkState(this.mtK != null);
            com.google.android.exoplayer2.util.a.checkState(i2 < this.mtK.size());
            String num = Integer.toString(this.mnT[i].bitrate);
            String l = this.mtK.get(i2).toString();
            return u.fi(this.msz, this.mtJ.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
        }
    }
}
