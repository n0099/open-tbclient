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

    void dMN();

    void release();

    void wQ(boolean z);

    void wR(boolean z);

    /* loaded from: classes5.dex */
    public static class b {
        public long beginTime;
        public long eAe;
        public long endTime;
        public boolean nIE;
        public int nIF;
        public int nIG;
        public d nIH;
        public int nII;
        public int nIJ;
        public int nIK;
        public int nIL;
        public int nIM;
        public int nIN;
        public int nIO;
        public long nIP;
        public boolean nIQ;
        public long nIR;
        public long nIS;
        private boolean nIU;
        public f nEJ = new f();
        private l nIT = new master.flame.danmaku.danmaku.model.android.d(4);

        public int NN(int i) {
            this.nIN += i;
            return this.nIN;
        }

        public int eB(int i, int i2) {
            switch (i) {
                case 1:
                    this.nII += i2;
                    return this.nII;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nIL += i2;
                    return this.nIL;
                case 5:
                    this.nIK += i2;
                    return this.nIK;
                case 6:
                    this.nIJ += i2;
                    return this.nIJ;
                case 7:
                    this.nIM += i2;
                    return this.nIM;
            }
        }

        public void reset() {
            this.nIO = this.nIN;
            this.nIN = 0;
            this.nIM = 0;
            this.nIL = 0;
            this.nIK = 0;
            this.nIJ = 0;
            this.nII = 0;
            this.nIP = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.eAe = 0L;
            this.nIQ = false;
            synchronized (this) {
                this.nIT.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nIO = bVar.nIO;
                this.nII = bVar.nII;
                this.nIJ = bVar.nIJ;
                this.nIK = bVar.nIK;
                this.nIL = bVar.nIL;
                this.nIM = bVar.nIM;
                this.nIN = bVar.nIN;
                this.nIP = bVar.nIP;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nIQ = bVar.nIQ;
                this.eAe = bVar.eAe;
                this.nIR = bVar.nIR;
                this.nIS = bVar.nIS;
            }
        }

        public void v(d dVar) {
            if (!this.nIU) {
                this.nIT.k(dVar);
            }
        }

        public l dMO() {
            l lVar;
            this.nIU = true;
            synchronized (this) {
                lVar = this.nIT;
                this.nIT = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nIU = false;
            return lVar;
        }
    }
}
