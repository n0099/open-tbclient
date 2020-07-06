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
    public interface InterfaceC0904a {
        void i(d dVar);
    }

    void a(InterfaceC0904a interfaceC0904a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void dTc();

    void release();

    void xy(boolean z);

    void xz(boolean z);

    /* loaded from: classes5.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long fDZ;
        public boolean nVX;
        public int nVY;
        public int nVZ;
        public d nWa;
        public int nWb;
        public int nWc;
        public int nWd;
        public int nWe;
        public int nWf;
        public int nWg;
        public int nWh;
        public long nWi;
        public boolean nWj;
        public long nWk;
        public long nWl;
        private boolean nWn;
        public f nSb = new f();
        private l nWm = new master.flame.danmaku.danmaku.model.android.d(4);

        public int Lh(int i) {
            this.nWg += i;
            return this.nWg;
        }

        public int eb(int i, int i2) {
            switch (i) {
                case 1:
                    this.nWb += i2;
                    return this.nWb;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nWe += i2;
                    return this.nWe;
                case 5:
                    this.nWd += i2;
                    return this.nWd;
                case 6:
                    this.nWc += i2;
                    return this.nWc;
                case 7:
                    this.nWf += i2;
                    return this.nWf;
            }
        }

        public void reset() {
            this.nWh = this.nWg;
            this.nWg = 0;
            this.nWf = 0;
            this.nWe = 0;
            this.nWd = 0;
            this.nWc = 0;
            this.nWb = 0;
            this.nWi = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.fDZ = 0L;
            this.nWj = false;
            synchronized (this) {
                this.nWm.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nWh = bVar.nWh;
                this.nWb = bVar.nWb;
                this.nWc = bVar.nWc;
                this.nWd = bVar.nWd;
                this.nWe = bVar.nWe;
                this.nWf = bVar.nWf;
                this.nWg = bVar.nWg;
                this.nWi = bVar.nWi;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nWj = bVar.nWj;
                this.fDZ = bVar.fDZ;
                this.nWk = bVar.nWk;
                this.nWl = bVar.nWl;
            }
        }

        public void v(d dVar) {
            if (!this.nWn) {
                this.nWm.k(dVar);
            }
        }

        public l dTd() {
            l lVar;
            this.nWn = true;
            synchronized (this) {
                lVar = this.nWm;
                this.nWm = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nWn = false;
            return lVar;
        }
    }
}
