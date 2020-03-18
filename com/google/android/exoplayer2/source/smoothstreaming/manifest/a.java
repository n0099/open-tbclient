package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.v;
import java.util.List;
import java.util.UUID;
/* loaded from: classes6.dex */
public class a {
    public final int lIp;
    public final int lIq;
    public final long mbx;
    public final boolean mzB;
    public final int mzW;
    public final C0684a mzX;
    public final b[] mzY;
    public final long mzZ;

    public a(int i, int i2, long j, long j2, long j3, int i3, boolean z, C0684a c0684a, b[] bVarArr) {
        this(i, i2, j2 == 0 ? -9223372036854775807L : v.i(j2, TimeUtils.NANOS_PER_MS, j), j3 == 0 ? -9223372036854775807L : v.i(j3, TimeUtils.NANOS_PER_MS, j), i3, z, c0684a, bVarArr);
    }

    private a(int i, int i2, long j, long j2, int i3, boolean z, C0684a c0684a, b[] bVarArr) {
        this.lIp = i;
        this.lIq = i2;
        this.mbx = j;
        this.mzZ = j2;
        this.mzW = i3;
        this.mzB = z;
        this.mzX = c0684a;
        this.mzY = bVarArr;
    }

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0684a {
        public final byte[] data;
        public final UUID uuid;

        public C0684a(UUID uuid, byte[] bArr) {
            this.uuid = uuid;
            this.data = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public final String language;
        private final String mAa;
        private final List<Long> mAb;
        private final long[] mAc;
        private final long mAd;
        public final int maxHeight;
        public final int maxWidth;
        public final int mhU;
        public final int mhV;
        public final Format[] muo;
        public final int mvD;
        private final String myR;
        public final String name;
        public final String subType;
        public final long timescale;
        public final int type;

        public b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, formatArr, list, v.a(list, (long) TimeUtils.NANOS_PER_MS, j), v.i(j2, TimeUtils.NANOS_PER_MS, j));
        }

        private b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j2) {
            this.myR = str;
            this.mAa = str2;
            this.type = i;
            this.subType = str3;
            this.timescale = j;
            this.name = str4;
            this.maxWidth = i2;
            this.maxHeight = i3;
            this.mhU = i4;
            this.mhV = i5;
            this.language = str5;
            this.muo = formatArr;
            this.mAb = list;
            this.mAc = jArr;
            this.mAd = j2;
            this.mvD = list.size();
        }

        public int fL(long j) {
            return v.a(this.mAc, j, true, true);
        }

        public long Ln(int i) {
            return this.mAc[i];
        }

        public long Lo(int i) {
            return i == this.mvD + (-1) ? this.mAd : this.mAc[i + 1] - this.mAc[i];
        }

        public Uri dR(int i, int i2) {
            com.google.android.exoplayer2.util.a.checkState(this.muo != null);
            com.google.android.exoplayer2.util.a.checkState(this.mAb != null);
            com.google.android.exoplayer2.util.a.checkState(i2 < this.mAb.size());
            String num = Integer.toString(this.muo[i].bitrate);
            String l = this.mAb.get(i2).toString();
            return u.fq(this.myR, this.mAa.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
        }
    }
}
