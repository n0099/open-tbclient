package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.util.v;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class h {
    final f mvj;
    final long mvk;
    final long timescale;

    public h(f fVar, long j, long j2) {
        this.mvj = fVar;
        this.timescale = j;
        this.mvk = j2;
    }

    public f a(g gVar) {
        return this.mvj;
    }

    public long dxb() {
        return v.i(this.mvk, TimeUtils.NANOS_PER_MS, this.timescale);
    }

    /* loaded from: classes6.dex */
    public static class e extends h {
        final long mvq;
        final long mvr;

        public e(f fVar, long j, long j2, long j3, long j4) {
            super(fVar, j, j2);
            this.mvq = j3;
            this.mvr = j4;
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public f dxc() {
            if (this.mvr <= 0) {
                return null;
            }
            return new f(null, this.mvq, this.mvr);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class a extends h {
        final long duration;
        final int mvl;
        final List<d> mvm;

        public abstract f a(g gVar, int i);

        public abstract int gq(long j);

        public a(f fVar, long j, long j2, int i, long j3, List<d> list) {
            super(fVar, j, j2);
            this.mvl = i;
            this.duration = j3;
            this.mvm = list;
        }

        public int T(long j, long j2) {
            int dwV = dwV();
            int gq = gq(j2);
            if (gq != 0) {
                if (this.mvm == null) {
                    int i = this.mvl + ((int) (j / ((this.duration * TimeUtils.NANOS_PER_MS) / this.timescale)));
                    if (i >= dwV) {
                        return gq == -1 ? i : Math.min(i, (dwV + gq) - 1);
                    }
                    return dwV;
                }
                int i2 = (dwV + gq) - 1;
                int i3 = dwV;
                while (i3 <= i2) {
                    int i4 = ((i2 - i3) / 2) + i3;
                    long Le = Le(i4);
                    if (Le < j) {
                        i3 = i4 + 1;
                    } else if (Le <= j) {
                        return i4;
                    } else {
                        i2 = i4 - 1;
                    }
                }
                if (i3 != dwV) {
                    i3 = i2;
                }
                return i3;
            }
            return dwV;
        }

        public final long G(int i, long j) {
            if (this.mvm != null) {
                return (this.mvm.get(i - this.mvl).duration * TimeUtils.NANOS_PER_MS) / this.timescale;
            }
            int gq = gq(j);
            return (gq == -1 || i != (gq + dwV()) + (-1)) ? (this.duration * TimeUtils.NANOS_PER_MS) / this.timescale : j - Le(i);
        }

        public final long Le(int i) {
            long j;
            if (this.mvm != null) {
                j = this.mvm.get(i - this.mvl).startTime - this.mvk;
            } else {
                j = (i - this.mvl) * this.duration;
            }
            return v.i(j, TimeUtils.NANOS_PER_MS, this.timescale);
        }

        public int dwV() {
            return this.mvl;
        }

        public boolean dwW() {
            return this.mvm != null;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends a {
        final List<f> mvn;

        public b(f fVar, long j, long j2, int i, long j3, List<d> list, List<f> list2) {
            super(fVar, j, j2, i, j3, list);
            this.mvn = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            return this.mvn.get(i - this.mvl);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gq(long j) {
            return this.mvn.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public boolean dwW() {
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a {
        final j mvo;
        final j mvp;

        public c(f fVar, long j, long j2, int i, long j3, List<d> list, j jVar, j jVar2) {
            super(fVar, j, j2, i, j3, list);
            this.mvo = jVar;
            this.mvp = jVar2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h
        public f a(g gVar) {
            return this.mvo != null ? new f(this.mvo.a(gVar.lZw.id, 0, gVar.lZw.bitrate, 0L), 0L, -1L) : super.a(gVar);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            long j;
            if (this.mvm != null) {
                j = this.mvm.get(i - this.mvl).startTime;
            } else {
                j = (i - this.mvl) * this.duration;
            }
            return new f(this.mvp.a(gVar.lZw.id, i, gVar.lZw.bitrate, j), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gq(long j) {
            if (this.mvm != null) {
                return this.mvm.size();
            }
            if (j != -9223372036854775807L) {
                return (int) v.W(j, (this.duration * TimeUtils.NANOS_PER_MS) / this.timescale);
            }
            return -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        final long duration;
        final long startTime;

        public d(long j, long j2) {
            this.startTime = j;
            this.duration = j2;
        }
    }
}
