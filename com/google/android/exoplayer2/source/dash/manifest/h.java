package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.util.v;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class h {
    final f mxc;
    final long mxd;
    final long timescale;

    public h(f fVar, long j, long j2) {
        this.mxc = fVar;
        this.timescale = j;
        this.mxd = j2;
    }

    public f a(g gVar) {
        return this.mxc;
    }

    public long dxB() {
        return v.i(this.mxd, TimeUtils.NANOS_PER_MS, this.timescale);
    }

    /* loaded from: classes6.dex */
    public static class e extends h {
        final long mxj;
        final long mxk;

        public e(f fVar, long j, long j2, long j3, long j4) {
            super(fVar, j, j2);
            this.mxj = j3;
            this.mxk = j4;
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public f dxC() {
            if (this.mxk <= 0) {
                return null;
            }
            return new f(null, this.mxj, this.mxk);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class a extends h {
        final long duration;
        final int mxe;
        final List<d> mxf;

        public abstract f a(g gVar, int i);

        public abstract int gr(long j);

        public a(f fVar, long j, long j2, int i, long j3, List<d> list) {
            super(fVar, j, j2);
            this.mxe = i;
            this.duration = j3;
            this.mxf = list;
        }

        public int T(long j, long j2) {
            int dxv = dxv();
            int gr = gr(j2);
            if (gr != 0) {
                if (this.mxf == null) {
                    int i = this.mxe + ((int) (j / ((this.duration * TimeUtils.NANOS_PER_MS) / this.timescale)));
                    if (i >= dxv) {
                        return gr == -1 ? i : Math.min(i, (dxv + gr) - 1);
                    }
                    return dxv;
                }
                int i2 = (dxv + gr) - 1;
                int i3 = dxv;
                while (i3 <= i2) {
                    int i4 = ((i2 - i3) / 2) + i3;
                    long Lk = Lk(i4);
                    if (Lk < j) {
                        i3 = i4 + 1;
                    } else if (Lk <= j) {
                        return i4;
                    } else {
                        i2 = i4 - 1;
                    }
                }
                if (i3 != dxv) {
                    i3 = i2;
                }
                return i3;
            }
            return dxv;
        }

        public final long G(int i, long j) {
            if (this.mxf != null) {
                return (this.mxf.get(i - this.mxe).duration * TimeUtils.NANOS_PER_MS) / this.timescale;
            }
            int gr = gr(j);
            return (gr == -1 || i != (gr + dxv()) + (-1)) ? (this.duration * TimeUtils.NANOS_PER_MS) / this.timescale : j - Lk(i);
        }

        public final long Lk(int i) {
            long j;
            if (this.mxf != null) {
                j = this.mxf.get(i - this.mxe).startTime - this.mxd;
            } else {
                j = (i - this.mxe) * this.duration;
            }
            return v.i(j, TimeUtils.NANOS_PER_MS, this.timescale);
        }

        public int dxv() {
            return this.mxe;
        }

        public boolean dxw() {
            return this.mxf != null;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends a {
        final List<f> mxg;

        public b(f fVar, long j, long j2, int i, long j3, List<d> list, List<f> list2) {
            super(fVar, j, j2, i, j3, list);
            this.mxg = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            return this.mxg.get(i - this.mxe);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gr(long j) {
            return this.mxg.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public boolean dxw() {
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a {
        final j mxh;
        final j mxi;

        public c(f fVar, long j, long j2, int i, long j3, List<d> list, j jVar, j jVar2) {
            super(fVar, j, j2, i, j3, list);
            this.mxh = jVar;
            this.mxi = jVar2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h
        public f a(g gVar) {
            return this.mxh != null ? new f(this.mxh.a(gVar.mbs.id, 0, gVar.mbs.bitrate, 0L), 0L, -1L) : super.a(gVar);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            long j;
            if (this.mxf != null) {
                j = this.mxf.get(i - this.mxe).startTime;
            } else {
                j = (i - this.mxe) * this.duration;
            }
            return new f(this.mxi.a(gVar.mbs.id, i, gVar.mbs.bitrate, j), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gr(long j) {
            if (this.mxf != null) {
                return this.mxf.size();
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
