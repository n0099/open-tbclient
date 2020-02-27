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

    void dMK();

    void release();

    void wQ(boolean z);

    void wR(boolean z);

    /* loaded from: classes5.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long ezQ;
        public int nIA;
        public int nIB;
        public long nIC;
        public boolean nID;
        public long nIE;
        public long nIF;
        private boolean nIH;
        public boolean nIr;
        public int nIs;
        public int nIt;
        public d nIu;
        public int nIv;
        public int nIw;
        public int nIx;
        public int nIy;
        public int nIz;
        public f nEw = new f();
        private l nIG = new master.flame.danmaku.danmaku.model.android.d(4);

        public int NN(int i) {
            this.nIA += i;
            return this.nIA;
        }

        public int eB(int i, int i2) {
            switch (i) {
                case 1:
                    this.nIv += i2;
                    return this.nIv;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nIy += i2;
                    return this.nIy;
                case 5:
                    this.nIx += i2;
                    return this.nIx;
                case 6:
                    this.nIw += i2;
                    return this.nIw;
                case 7:
                    this.nIz += i2;
                    return this.nIz;
            }
        }

        public void reset() {
            this.nIB = this.nIA;
            this.nIA = 0;
            this.nIz = 0;
            this.nIy = 0;
            this.nIx = 0;
            this.nIw = 0;
            this.nIv = 0;
            this.nIC = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.ezQ = 0L;
            this.nID = false;
            synchronized (this) {
                this.nIG.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nIB = bVar.nIB;
                this.nIv = bVar.nIv;
                this.nIw = bVar.nIw;
                this.nIx = bVar.nIx;
                this.nIy = bVar.nIy;
                this.nIz = bVar.nIz;
                this.nIA = bVar.nIA;
                this.nIC = bVar.nIC;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nID = bVar.nID;
                this.ezQ = bVar.ezQ;
                this.nIE = bVar.nIE;
                this.nIF = bVar.nIF;
            }
        }

        public void v(d dVar) {
            if (!this.nIH) {
                this.nIG.k(dVar);
            }
        }

        public l dML() {
            l lVar;
            this.nIH = true;
            synchronized (this) {
                lVar = this.nIG;
                this.nIG = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nIH = false;
            return lVar;
        }
    }
}
