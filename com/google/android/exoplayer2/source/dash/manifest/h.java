package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.util.v;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class h {
    final f mvl;
    final long mvm;
    final long timescale;

    public h(f fVar, long j, long j2) {
        this.mvl = fVar;
        this.timescale = j;
        this.mvm = j2;
    }

    public f a(g gVar) {
        return this.mvl;
    }

    public long dxd() {
        return v.i(this.mvm, TimeUtils.NANOS_PER_MS, this.timescale);
    }

    /* loaded from: classes6.dex */
    public static class e extends h {
        final long mvs;
        final long mvt;

        public e(f fVar, long j, long j2, long j3, long j4) {
            super(fVar, j, j2);
            this.mvs = j3;
            this.mvt = j4;
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public f dxe() {
            if (this.mvt <= 0) {
                return null;
            }
            return new f(null, this.mvs, this.mvt);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class a extends h {
        final long duration;
        final int mvn;
        final List<d> mvo;

        public abstract f a(g gVar, int i);

        public abstract int gq(long j);

        public a(f fVar, long j, long j2, int i, long j3, List<d> list) {
            super(fVar, j, j2);
            this.mvn = i;
            this.duration = j3;
            this.mvo = list;
        }

        public int T(long j, long j2) {
            int dwX = dwX();
            int gq = gq(j2);
            if (gq != 0) {
                if (this.mvo == null) {
                    int i = this.mvn + ((int) (j / ((this.duration * TimeUtils.NANOS_PER_MS) / this.timescale)));
                    if (i >= dwX) {
                        return gq == -1 ? i : Math.min(i, (dwX + gq) - 1);
                    }
                    return dwX;
                }
                int i2 = (dwX + gq) - 1;
                int i3 = dwX;
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
                if (i3 != dwX) {
                    i3 = i2;
                }
                return i3;
            }
            return dwX;
        }

        public final long G(int i, long j) {
            if (this.mvo != null) {
                return (this.mvo.get(i - this.mvn).duration * TimeUtils.NANOS_PER_MS) / this.timescale;
            }
            int gq = gq(j);
            return (gq == -1 || i != (gq + dwX()) + (-1)) ? (this.duration * TimeUtils.NANOS_PER_MS) / this.timescale : j - Le(i);
        }

        public final long Le(int i) {
            long j;
            if (this.mvo != null) {
                j = this.mvo.get(i - this.mvn).startTime - this.mvm;
            } else {
                j = (i - this.mvn) * this.duration;
            }
            return v.i(j, TimeUtils.NANOS_PER_MS, this.timescale);
        }

        public int dwX() {
            return this.mvn;
        }

        public boolean dwY() {
            return this.mvo != null;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends a {
        final List<f> mvp;

        public b(f fVar, long j, long j2, int i, long j3, List<d> list, List<f> list2) {
            super(fVar, j, j2, i, j3, list);
            this.mvp = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            return this.mvp.get(i - this.mvn);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gq(long j) {
            return this.mvp.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public boolean dwY() {
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends a {
        final j mvq;
        final j mvr;

        public c(f fVar, long j, long j2, int i, long j3, List<d> list, j jVar, j jVar2) {
            super(fVar, j, j2, i, j3, list);
            this.mvq = jVar;
            this.mvr = jVar2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h
        public f a(g gVar) {
            return this.mvq != null ? new f(this.mvq.a(gVar.lZy.id, 0, gVar.lZy.bitrate, 0L), 0L, -1L) : super.a(gVar);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public f a(g gVar, int i) {
            long j;
            if (this.mvo != null) {
                j = this.mvo.get(i - this.mvn).startTime;
            } else {
                j = (i - this.mvn) * this.duration;
            }
            return new f(this.mvr.a(gVar.lZy.id, i, gVar.lZy.bitrate, j), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.h.a
        public int gq(long j) {
            if (this.mvo != null) {
                return this.mvo.size();
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
