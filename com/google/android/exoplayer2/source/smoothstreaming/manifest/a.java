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
    public final int lGw;
    public final int lGx;
    public final long lZB;
    public final boolean mxI;
    public final int myd;
    public final C0683a mye;
    public final b[] myf;
    public final long myg;

    public a(int i, int i2, long j, long j2, long j3, int i3, boolean z, C0683a c0683a, b[] bVarArr) {
        this(i, i2, j2 == 0 ? -9223372036854775807L : v.i(j2, TimeUtils.NANOS_PER_MS, j), j3 == 0 ? -9223372036854775807L : v.i(j3, TimeUtils.NANOS_PER_MS, j), i3, z, c0683a, bVarArr);
    }

    private a(int i, int i2, long j, long j2, int i3, boolean z, C0683a c0683a, b[] bVarArr) {
        this.lGw = i;
        this.lGx = i2;
        this.lZB = j;
        this.myg = j2;
        this.myd = i3;
        this.mxI = z;
        this.mye = c0683a;
        this.myf = bVarArr;
    }

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0683a {
        public final byte[] data;
        public final UUID uuid;

        public C0683a(UUID uuid, byte[] bArr) {
            this.uuid = uuid;
            this.data = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public final String language;
        public final int maxHeight;
        public final int maxWidth;
        public final int mgb;
        public final int mgc;
        public final Format[] msu;
        public final int mtK;
        private final String mwY;
        private final String myh;
        private final List<Long> myi;
        private final long[] myj;
        private final long myk;
        public final String name;
        public final String subType;
        public final long timescale;
        public final int type;

        public b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, formatArr, list, v.a(list, (long) TimeUtils.NANOS_PER_MS, j), v.i(j2, TimeUtils.NANOS_PER_MS, j));
        }

        private b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j2) {
            this.mwY = str;
            this.myh = str2;
            this.type = i;
            this.subType = str3;
            this.timescale = j;
            this.name = str4;
            this.maxWidth = i2;
            this.maxHeight = i3;
            this.mgb = i4;
            this.mgc = i5;
            this.language = str5;
            this.msu = formatArr;
            this.myi = list;
            this.myj = jArr;
            this.myk = j2;
            this.mtK = list.size();
        }

        public int fK(long j) {
            return v.a(this.myj, j, true, true);
        }

        public long Lh(int i) {
            return this.myj[i];
        }

        public long Li(int i) {
            return i == this.mtK + (-1) ? this.myk : this.myj[i + 1] - this.myj[i];
        }

        public Uri dQ(int i, int i2) {
            com.google.android.exoplayer2.util.a.checkState(this.msu != null);
            com.google.android.exoplayer2.util.a.checkState(this.myi != null);
            com.google.android.exoplayer2.util.a.checkState(i2 < this.myi.size());
            String num = Integer.toString(this.msu[i].bitrate);
            String l = this.myi.get(i2).toString();
            return u.fs(this.mwY, this.myh.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
        }
    }
}
