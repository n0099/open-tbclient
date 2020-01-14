package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.util.v;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class h {
    final f muD;
    final long muE;
    final long timescale;

    public h(f fVar, long j, long j2) {
        this.muD = fVar;
        this.timescale = j;
        this.muE = j2;
    }

    public f a(g gVar) {
        return this.muD;
    }

    public long dvR() {
        return v.h(this.muE, TimeUtils.NANOS_PER_MS, this.timescale);
    }

    /* loaded from: classes5.dex */
    public static class e extends h {
        final long muK;
        final long muL;

        public e(f fVar, long j, long j2, long j3, long j4) {
            super(fVar, j, j2);
            this.muK = j3;
            this.muL = j4;
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public f dvS() {
            if (this.muL <= 0) {
                return null;
            }
            return new f(null, this.muK, this.muL);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class a extends h {
        final long duration;
        final int muF;
        final List<d> muG;

        public abstract f a(g gVar, int i);

        public abstract int gs(long j);

        public a(f fVar, long j, long j2, int i, long j3, List<d> list) {
            super(fVar, j, j2);
            this.muF = i;
            this.duration = j3;
            this.muG = list;
        }

        public int U(long j, long j2) {
            int dvL = dvL();
            int gs = gs(j2);
            if (gs != 0) {
                if (this.muG == null) {
                    int i = this.muF + ((int) (j / ((this.duration * TimeUtils.NANOS_PER_MS) / this.timescale)));
                    if (i >= dvL) {
                        return gs == -1 ? i : Math.min(i, (dvL + gs) - 1);
                    }
                    return dvL;
                }
                int i2 = (dvL + gs) - 1;
                int i3 = dvL;
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
                if (i3 != dvL) {
                    i3 = i2;
                }
                return i3;
            }
            return dvL;
        }

        public final long H(int i, long j) {
            if (this.muG != null) {
                return (this.muG.get(i - this.muF).duration * TimeUtils.NANOS_PER_MS) / this.timescale;
            }
            int gs = gs(j);
            return (gs == -1 || i != (gs + dvL()) + (-1)) ? (this.duration * TimeUtils.NANOS_PER_MS) / this.timescale : j - KZ(i);
        }

        public final long KZ(int i) {
            long j;
            if (this.muG != null) {
                j = this.muG.get(i - this.muF).startTime - this.muE;
            } else {
                j = (i - this.muF) * this.duration;
            }
            return v.h(j, TimeUtils.NANOS_PER_MS, this.timescale);
        }

        public int dvL() {
            return this.muF;
        }

        public boolean dvM() {
            return this.muG != null;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends a {
        final List<f> muH;

        public b(f fVar, long j, long j2, int i, long j3, List<d> list, List<f> list2) {
            super(fVar, j, j2, i, j3, list);
            this.muH = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            return this.muH.get(i - this.muF);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gs(long j) {
            return this.muH.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public boolean dvM() {
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends a {
        final j muI;
        final j muJ;

        public c(f fVar, long j, long j2, int i, long j3, List<d> list, j jVar, j jVar2) {
            super(fVar, j, j2, i, j3, list);
            this.muI = jVar;
            this.muJ = jVar2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h
        public f a(g gVar) {
            return this.muI != null ? new f(this.muI.a(gVar.lYQ.id, 0, gVar.lYQ.bitrate, 0L), 0L, -1L) : super.a(gVar);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            long j;
            if (this.muG != null) {
                j = this.muG.get(i - this.muF).startTime;
            } else {
                j = (i - this.muF) * this.duration;
            }
            return new f(this.muJ.a(gVar.lYQ.id, i, gVar.lYQ.bitrate, j), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gs(long j) {
            if (this.muG != null) {
                return this.muG.size();
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
