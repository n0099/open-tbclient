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
    public interface InterfaceC0776a {
        void i(d dVar);
    }

    void a(InterfaceC0776a interfaceC0776a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void dMM();

    void release();

    void wQ(boolean z);

    void wR(boolean z);

    /* loaded from: classes5.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long ezR;
        public int nIA;
        public int nIB;
        public int nIC;
        public int nID;
        public long nIE;
        public boolean nIF;
        public long nIG;
        public long nIH;
        private boolean nIJ;
        public boolean nIt;
        public int nIu;
        public int nIv;
        public d nIw;
        public int nIx;
        public int nIy;
        public int nIz;
        public f nEy = new f();
        private l nII = new master.flame.danmaku.danmaku.model.android.d(4);

        public int NN(int i) {
            this.nIC += i;
            return this.nIC;
        }

        public int eB(int i, int i2) {
            switch (i) {
                case 1:
                    this.nIx += i2;
                    return this.nIx;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nIA += i2;
                    return this.nIA;
                case 5:
                    this.nIz += i2;
                    return this.nIz;
                case 6:
                    this.nIy += i2;
                    return this.nIy;
                case 7:
                    this.nIB += i2;
                    return this.nIB;
            }
        }

        public void reset() {
            this.nID = this.nIC;
            this.nIC = 0;
            this.nIB = 0;
            this.nIA = 0;
            this.nIz = 0;
            this.nIy = 0;
            this.nIx = 0;
            this.nIE = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.ezR = 0L;
            this.nIF = false;
            synchronized (this) {
                this.nII.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nID = bVar.nID;
                this.nIx = bVar.nIx;
                this.nIy = bVar.nIy;
                this.nIz = bVar.nIz;
                this.nIA = bVar.nIA;
                this.nIB = bVar.nIB;
                this.nIC = bVar.nIC;
                this.nIE = bVar.nIE;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nIF = bVar.nIF;
                this.ezR = bVar.ezR;
                this.nIG = bVar.nIG;
                this.nIH = bVar.nIH;
            }
        }

        public void v(d dVar) {
            if (!this.nIJ) {
                this.nII.k(dVar);
            }
        }

        public l dMN() {
            l lVar;
            this.nIJ = true;
            synchronized (this) {
                lVar = this.nII;
                this.nII = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nIJ = false;
            return lVar;
        }
    }
}
