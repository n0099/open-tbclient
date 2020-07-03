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
    public interface InterfaceC0903a {
        void i(d dVar);
    }

    void a(InterfaceC0903a interfaceC0903a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void dSY();

    void release();

    void xy(boolean z);

    void xz(boolean z);

    /* loaded from: classes5.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long fDZ;
        public boolean nVU;
        public int nVV;
        public int nVW;
        public d nVX;
        public int nVY;
        public int nVZ;
        public int nWa;
        public int nWb;
        public int nWc;
        public int nWd;
        public int nWe;
        public long nWf;
        public boolean nWg;
        public long nWh;
        public long nWi;
        private boolean nWk;
        public f nRY = new f();
        private l nWj = new master.flame.danmaku.danmaku.model.android.d(4);

        public int Lh(int i) {
            this.nWd += i;
            return this.nWd;
        }

        public int eb(int i, int i2) {
            switch (i) {
                case 1:
                    this.nVY += i2;
                    return this.nVY;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nWb += i2;
                    return this.nWb;
                case 5:
                    this.nWa += i2;
                    return this.nWa;
                case 6:
                    this.nVZ += i2;
                    return this.nVZ;
                case 7:
                    this.nWc += i2;
                    return this.nWc;
            }
        }

        public void reset() {
            this.nWe = this.nWd;
            this.nWd = 0;
            this.nWc = 0;
            this.nWb = 0;
            this.nWa = 0;
            this.nVZ = 0;
            this.nVY = 0;
            this.nWf = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.fDZ = 0L;
            this.nWg = false;
            synchronized (this) {
                this.nWj.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nWe = bVar.nWe;
                this.nVY = bVar.nVY;
                this.nVZ = bVar.nVZ;
                this.nWa = bVar.nWa;
                this.nWb = bVar.nWb;
                this.nWc = bVar.nWc;
                this.nWd = bVar.nWd;
                this.nWf = bVar.nWf;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nWg = bVar.nWg;
                this.fDZ = bVar.fDZ;
                this.nWh = bVar.nWh;
                this.nWi = bVar.nWi;
            }
        }

        public void v(d dVar) {
            if (!this.nWk) {
                this.nWj.k(dVar);
            }
        }

        public l dSZ() {
            l lVar;
            this.nWk = true;
            synchronized (this) {
                lVar = this.nWj;
                this.nWj = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nWk = false;
            return lVar;
        }
    }
}
