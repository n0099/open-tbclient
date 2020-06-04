package master.flame.danmaku.danmaku.b;

import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public interface a {

    /* renamed from: master.flame.danmaku.danmaku.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0884a {
        void i(d dVar);
    }

    void a(InterfaceC0884a interfaceC0884a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void dOs();

    void release();

    void xd(boolean z);

    void xe(boolean z);

    /* loaded from: classes5.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long fsO;
        public boolean nAj;
        public int nAk;
        public int nAl;
        public d nAm;
        public int nAn;
        public int nAo;
        public int nAp;
        public int nAq;
        public int nAr;
        public int nAs;
        public int nAt;
        public long nAu;
        public boolean nAv;
        public long nAw;
        public long nAx;
        private boolean nAz;
        public f nwm = new f();
        private l nAy = new master.flame.danmaku.danmaku.model.android.d(4);

        public int Ka(int i) {
            this.nAs += i;
            return this.nAs;
        }

        public int dS(int i, int i2) {
            switch (i) {
                case 1:
                    this.nAn += i2;
                    return this.nAn;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nAq += i2;
                    return this.nAq;
                case 5:
                    this.nAp += i2;
                    return this.nAp;
                case 6:
                    this.nAo += i2;
                    return this.nAo;
                case 7:
                    this.nAr += i2;
                    return this.nAr;
            }
        }

        public void reset() {
            this.nAt = this.nAs;
            this.nAs = 0;
            this.nAr = 0;
            this.nAq = 0;
            this.nAp = 0;
            this.nAo = 0;
            this.nAn = 0;
            this.nAu = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.fsO = 0L;
            this.nAv = false;
            synchronized (this) {
                this.nAy.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nAt = bVar.nAt;
                this.nAn = bVar.nAn;
                this.nAo = bVar.nAo;
                this.nAp = bVar.nAp;
                this.nAq = bVar.nAq;
                this.nAr = bVar.nAr;
                this.nAs = bVar.nAs;
                this.nAu = bVar.nAu;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nAv = bVar.nAv;
                this.fsO = bVar.fsO;
                this.nAw = bVar.nAw;
                this.nAx = bVar.nAx;
            }
        }

        public void v(d dVar) {
            if (!this.nAz) {
                this.nAy.k(dVar);
            }
        }

        public l dOt() {
            l lVar;
            this.nAz = true;
            synchronized (this) {
                lVar = this.nAy;
                this.nAy = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nAz = false;
            return lVar;
        }
    }
}
