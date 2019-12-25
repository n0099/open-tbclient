package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.util.v;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class h {
    final f mqJ;
    final long mqK;
    final long timescale;

    public h(f fVar, long j, long j2) {
        this.mqJ = fVar;
        this.timescale = j;
        this.mqK = j2;
    }

    public f a(g gVar) {
        return this.mqJ;
    }

    public long duE() {
        return v.h(this.mqK, TimeUtils.NANOS_PER_MS, this.timescale);
    }

    /* loaded from: classes4.dex */
    public static class e extends h {
        final long mqQ;
        final long mqR;

        public e(f fVar, long j, long j2, long j3, long j4) {
            super(fVar, j, j2);
            this.mqQ = j3;
            this.mqR = j4;
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public f duF() {
            if (this.mqR <= 0) {
                return null;
            }
            return new f(null, this.mqQ, this.mqR);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a extends h {
        final long duration;
        final int mqL;
        final List<d> mqM;

        public abstract f a(g gVar, int i);

        public abstract int gn(long j);

        public a(f fVar, long j, long j2, int i, long j3, List<d> list) {
            super(fVar, j, j2);
            this.mqL = i;
            this.duration = j3;
            this.mqM = list;
        }

        public int U(long j, long j2) {
            int duy = duy();
            int gn = gn(j2);
            if (gn != 0) {
                if (this.mqM == null) {
                    int i = this.mqL + ((int) (j / ((this.duration * TimeUtils.NANOS_PER_MS) / this.timescale)));
                    if (i >= duy) {
                        return gn == -1 ? i : Math.min(i, (duy + gn) - 1);
                    }
                    return duy;
                }
                int i2 = (duy + gn) - 1;
                int i3 = duy;
                while (i3 <= i2) {
                    int i4 = ((i2 - i3) / 2) + i3;
                    long KQ = KQ(i4);
                    if (KQ < j) {
                        i3 = i4 + 1;
                    } else if (KQ <= j) {
                        return i4;
                    } else {
                        i2 = i4 - 1;
                    }
                }
                if (i3 != duy) {
                    i3 = i2;
                }
                return i3;
            }
            return duy;
        }

        public final long H(int i, long j) {
            if (this.mqM != null) {
                return (this.mqM.get(i - this.mqL).duration * TimeUtils.NANOS_PER_MS) / this.timescale;
            }
            int gn = gn(j);
            return (gn == -1 || i != (gn + duy()) + (-1)) ? (this.duration * TimeUtils.NANOS_PER_MS) / this.timescale : j - KQ(i);
        }

        public final long KQ(int i) {
            long j;
            if (this.mqM != null) {
                j = this.mqM.get(i - this.mqL).startTime - this.mqK;
            } else {
                j = (i - this.mqL) * this.duration;
            }
            return v.h(j, TimeUtils.NANOS_PER_MS, this.timescale);
        }

        public int duy() {
            return this.mqL;
        }

        public boolean duz() {
            return this.mqM != null;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends a {
        final List<f> mqN;

        public b(f fVar, long j, long j2, int i, long j3, List<d> list, List<f> list2) {
            super(fVar, j, j2, i, j3, list);
            this.mqN = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            return this.mqN.get(i - this.mqL);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gn(long j) {
            return this.mqN.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public boolean duz() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends a {
        final j mqO;
        final j mqP;

        public c(f fVar, long j, long j2, int i, long j3, List<d> list, j jVar, j jVar2) {
            super(fVar, j, j2, i, j3, list);
            this.mqO = jVar;
            this.mqP = jVar2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h
        public f a(g gVar) {
            return this.mqO != null ? new f(this.mqO.a(gVar.lUU.id, 0, gVar.lUU.bitrate, 0L), 0L, -1L) : super.a(gVar);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            long j;
            if (this.mqM != null) {
                j = this.mqM.get(i - this.mqL).startTime;
            } else {
                j = (i - this.mqL) * this.duration;
            }
            return new f(this.mqP.a(gVar.lUU.id, i, gVar.lUU.bitrate, j), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gn(long j) {
            if (this.mqM != null) {
                return this.mqM.size();
            }
            if (j != -9223372036854775807L) {
                return (int) v.X(j, (this.duration * TimeUtils.NANOS_PER_MS) / this.timescale);
            }
            return -1;
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        final long duration;
        final long startTime;

        public d(long j, long j2) {
            this.startTime = j;
            this.duration = j2;
        }
    }
}
