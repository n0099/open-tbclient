package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.util.v;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class h {
    final f mvw;
    final long mvx;
    final long timescale;

    public h(f fVar, long j, long j2) {
        this.mvw = fVar;
        this.timescale = j;
        this.mvx = j2;
    }

    public f a(g gVar) {
        return this.mvw;
    }

    public long dxe() {
        return v.i(this.mvx, TimeUtils.NANOS_PER_MS, this.timescale);
    }

    /* loaded from: classes6.dex */
    public static class e extends h {
        final long mvD;
        final long mvE;

        public e(f fVar, long j, long j2, long j3, long j4) {
            super(fVar, j, j2);
            this.mvD = j3;
            this.mvE = j4;
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public f dxf() {
            if (this.mvE <= 0) {
                return null;
            }
            return new f(null, this.mvD, this.mvE);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class a extends h {
        final long duration;
        final int mvy;
        final List<d> mvz;

        public abstract f a(g gVar, int i);

        public abstract int gq(long j);

        public a(f fVar, long j, long j2, int i, long j3, List<d> list) {
            super(fVar, j, j2);
            this.mvy = i;
            this.duration = j3;
            this.mvz = list;
        }

        public int T(long j, long j2) {
            int dwY = dwY();
            int gq = gq(j2);
            if (gq != 0) {
                if (this.mvz == null) {
                    int i = this.mvy + ((int) (j / ((this.duration * TimeUtils.NANOS_PER_MS) / this.timescale)));
                    if (i >= dwY) {
                        return gq == -1 ? i : Math.min(i, (dwY + gq) - 1);
                    }
                    return dwY;
                }
                int i2 = (dwY + gq) - 1;
                int i3 = dwY;
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
                if (i3 != dwY) {
                    i3 = i2;
                }
                return i3;
            }
            return dwY;
        }

        public final long G(int i, long j) {
            if (this.mvz != null) {
                return (this.mvz.get(i - this.mvy).duration * TimeUtils.NANOS_PER_MS) / this.timescale;
            }
            int gq = gq(j);
            return (gq == -1 || i != (gq + dwY()) + (-1)) ? (this.duration * TimeUtils.NANOS_PER_MS) / this.timescale : j - Le(i);
        }

        public final long Le(int i) {
            long j;
            if (this.mvz != null) {
                j = this.mvz.get(i - this.mvy).startTime - this.mvx;
            } else {
                j = (i - this.mvy) * this.duration;
            }
            return v.i(j, TimeUtils.NANOS_PER_MS, this.timescale);
        }

        public int dwY() {
            return this.mvy;
        }

        public boolean dwZ() {
            return this.mvz != null;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends a {
        final List<f> mvA;

        public b(f fVar, long j, long j2, int i, long j3, List<d> list, List<f> list2) {
            super(fVar, j, j2, i, j3, list);
            this.mvA = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            return this.mvA.get(i - this.mvy);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gq(long j) {
            return this.mvA.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public boolean dwZ() {
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a {
        final j mvB;
        final j mvC;

        public c(f fVar, long j, long j2, int i, long j3, List<d> list, j jVar, j jVar2) {
            super(fVar, j, j2, i, j3, list);
            this.mvB = jVar;
            this.mvC = jVar2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h
        public f a(g gVar) {
            return this.mvB != null ? new f(this.mvB.a(gVar.lZJ.id, 0, gVar.lZJ.bitrate, 0L), 0L, -1L) : super.a(gVar);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            long j;
            if (this.mvz != null) {
                j = this.mvz.get(i - this.mvy).startTime;
            } else {
                j = (i - this.mvy) * this.duration;
            }
            return new f(this.mvC.a(gVar.lZJ.id, i, gVar.lZJ.bitrate, j), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gq(long j) {
            if (this.mvz != null) {
                return this.mvz.size();
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
