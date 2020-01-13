package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.v;
import java.util.List;
import java.util.UUID;
/* loaded from: classes5.dex */
public class a {
    public final int lFK;
    public final int lFL;
    public final long lYQ;
    public final boolean mwX;
    public final int mxs;
    public final C0675a mxt;
    public final b[] mxu;
    public final long mxv;

    public a(int i, int i2, long j, long j2, long j3, int i3, boolean z, C0675a c0675a, b[] bVarArr) {
        this(i, i2, j2 == 0 ? -9223372036854775807L : v.h(j2, TimeUtils.NANOS_PER_MS, j), j3 == 0 ? -9223372036854775807L : v.h(j3, TimeUtils.NANOS_PER_MS, j), i3, z, c0675a, bVarArr);
    }

    private a(int i, int i2, long j, long j2, int i3, boolean z, C0675a c0675a, b[] bVarArr) {
        this.lFK = i;
        this.lFL = i2;
        this.lYQ = j;
        this.mxv = j2;
        this.mxs = i3;
        this.mwX = z;
        this.mxt = c0675a;
        this.mxu = bVarArr;
    }

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0675a {
        public final byte[] data;
        public final UUID uuid;

        public C0675a(UUID uuid, byte[] bArr) {
            this.uuid = uuid;
            this.data = bArr;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public final String language;
        public final int maxHeight;
        public final int maxWidth;
        public final int mfq;
        public final int mfr;
        public final Format[] mrI;
        public final int msY;
        private final String mwn;
        private final String mxw;
        private final List<Long> mxx;
        private final long[] mxy;
        private final long mxz;
        public final String name;
        public final String subType;
        public final long timescale;
        public final int type;

        public b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, formatArr, list, v.a(list, (long) TimeUtils.NANOS_PER_MS, j), v.h(j2, TimeUtils.NANOS_PER_MS, j));
        }

        private b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j2) {
            this.mwn = str;
            this.mxw = str2;
            this.type = i;
            this.subType = str3;
            this.timescale = j;
            this.name = str4;
            this.maxWidth = i2;
            this.maxHeight = i3;
            this.mfq = i4;
            this.mfr = i5;
            this.language = str5;
            this.mrI = formatArr;
            this.mxx = list;
            this.mxy = jArr;
            this.mxz = j2;
            this.msY = list.size();
        }

        public int fM(long j) {
            return v.a(this.mxy, j, true, true);
        }

        public long Lc(int i) {
            return this.mxy[i];
        }

        public long Ld(int i) {
            return i == this.msY + (-1) ? this.mxz : this.mxy[i + 1] - this.mxy[i];
        }

        public Uri dN(int i, int i2) {
            com.google.android.exoplayer2.util.a.checkState(this.mrI != null);
            com.google.android.exoplayer2.util.a.checkState(this.mxx != null);
            com.google.android.exoplayer2.util.a.checkState(i2 < this.mxx.size());
            String num = Integer.toString(this.mrI[i].bitrate);
            String l = this.mxx.get(i2).toString();
            return u.fk(this.mwn, this.mxw.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
        }
    }
}
