package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.util.v;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class h {
    final f muy;
    final long muz;
    final long timescale;

    public h(f fVar, long j, long j2) {
        this.muy = fVar;
        this.timescale = j;
        this.muz = j2;
    }

    public f a(g gVar) {
        return this.muy;
    }

    public long dvP() {
        return v.h(this.muz, TimeUtils.NANOS_PER_MS, this.timescale);
    }

    /* loaded from: classes5.dex */
    public static class e extends h {
        final long muF;
        final long muG;

        public e(f fVar, long j, long j2, long j3, long j4) {
            super(fVar, j, j2);
            this.muF = j3;
            this.muG = j4;
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public f dvQ() {
            if (this.muG <= 0) {
                return null;
            }
            return new f(null, this.muF, this.muG);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class a extends h {
        final long duration;
        final int muA;
        final List<d> muB;

        public abstract f a(g gVar, int i);

        public abstract int gs(long j);

        public a(f fVar, long j, long j2, int i, long j3, List<d> list) {
            super(fVar, j, j2);
            this.muA = i;
            this.duration = j3;
            this.muB = list;
        }

        public int U(long j, long j2) {
            int dvJ = dvJ();
            int gs = gs(j2);
            if (gs != 0) {
                if (this.muB == null) {
                    int i = this.muA + ((int) (j / ((this.duration * TimeUtils.NANOS_PER_MS) / this.timescale)));
                    if (i >= dvJ) {
                        return gs == -1 ? i : Math.min(i, (dvJ + gs) - 1);
                    }
                    return dvJ;
                }
                int i2 = (dvJ + gs) - 1;
                int i3 = dvJ;
                while (i3 <= i2) {
                    int i4 = ((i2 - i3) / 2) + i3;
                    long KZ = KZ(i4);
                    if (KZ < j) {
                        i3 = i4 + 1;
                    } else if (KZ <= j) {
                        return i4;
                    } else {
                        i2 = i4 - 1;
                    }
                }
                if (i3 != dvJ) {
                    i3 = i2;
                }
                return i3;
            }
            return dvJ;
        }

        public final long H(int i, long j) {
            if (this.muB != null) {
                return (this.muB.get(i - this.muA).duration * TimeUtils.NANOS_PER_MS) / this.timescale;
            }
            int gs = gs(j);
            return (gs == -1 || i != (gs + dvJ()) + (-1)) ? (this.duration * TimeUtils.NANOS_PER_MS) / this.timescale : j - KZ(i);
        }

        public final long KZ(int i) {
            long j;
            if (this.muB != null) {
                j = this.muB.get(i - this.muA).startTime - this.muz;
            } else {
                j = (i - this.muA) * this.duration;
            }
            return v.h(j, TimeUtils.NANOS_PER_MS, this.timescale);
        }

        public int dvJ() {
            return this.muA;
        }

        public boolean dvK() {
            return this.muB != null;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends a {
        final List<f> muC;

        public b(f fVar, long j, long j2, int i, long j3, List<d> list, List<f> list2) {
            super(fVar, j, j2, i, j3, list);
            this.muC = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            return this.muC.get(i - this.muA);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gs(long j) {
            return this.muC.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public boolean dvK() {
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends a {
        final j muD;
        final j muE;

        public c(f fVar, long j, long j2, int i, long j3, List<d> list, j jVar, j jVar2) {
            super(fVar, j, j2, i, j3, list);
            this.muD = jVar;
            this.muE = jVar2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h
        public f a(g gVar) {
            return this.muD != null ? new f(this.muD.a(gVar.lYL.id, 0, gVar.lYL.bitrate, 0L), 0L, -1L) : super.a(gVar);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            long j;
            if (this.muB != null) {
                j = this.muB.get(i - this.muA).startTime;
            } else {
                j = (i - this.muA) * this.duration;
            }
            return new f(this.muE.a(gVar.lYL.id, i, gVar.lYL.bitrate, j), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gs(long j) {
            if (this.muB != null) {
                return this.muB.size();
            }
            if (j != -9223372036854775807L) {
                return (int) v.X(j, (this.duration * TimeUtils.NANOS_PER_MS) / this.timescale);
            }
            return -1;
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        final long duration;
        final long startTime;

        public d(long j, long j2) {
            this.startTime = j;
            this.duration = j2;
        }
    }
}
