package master.flame.danmaku.danmaku.b;

import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public interface a {

    /* renamed from: master.flame.danmaku.danmaku.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0974a {
        void i(d dVar);
    }

    void a(InterfaceC0974a interfaceC0974a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void emI();

    void release();

    void zf(boolean z);

    void zg(boolean z);

    /* loaded from: classes6.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long fYd;
        public boolean oID;
        public int oIE;
        public int oIF;
        public d oIG;
        public int oIH;
        public int oII;
        public int oIJ;
        public int oIK;
        public int oIL;
        public int oIM;
        public int oIN;
        public long oIO;
        public boolean oIP;
        public long oIQ;
        public long oIR;
        private boolean oIT;
        public f oEJ = new f();
        private l oIS = new master.flame.danmaku.danmaku.model.android.d(4);

        public int OJ(int i) {
            this.oIM += i;
            return this.oIM;
        }

        public int ep(int i, int i2) {
            switch (i) {
                case 1:
                    this.oIH += i2;
                    return this.oIH;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.oIK += i2;
                    return this.oIK;
                case 5:
                    this.oIJ += i2;
                    return this.oIJ;
                case 6:
                    this.oII += i2;
                    return this.oII;
                case 7:
                    this.oIL += i2;
                    return this.oIL;
            }
        }

        public void reset() {
            this.oIN = this.oIM;
            this.oIM = 0;
            this.oIL = 0;
            this.oIK = 0;
            this.oIJ = 0;
            this.oII = 0;
            this.oIH = 0;
            this.oIO = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.fYd = 0L;
            this.oIP = false;
            synchronized (this) {
                this.oIS.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.oIN = bVar.oIN;
                this.oIH = bVar.oIH;
                this.oII = bVar.oII;
                this.oIJ = bVar.oIJ;
                this.oIK = bVar.oIK;
                this.oIL = bVar.oIL;
                this.oIM = bVar.oIM;
                this.oIO = bVar.oIO;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.oIP = bVar.oIP;
                this.fYd = bVar.fYd;
                this.oIQ = bVar.oIQ;
                this.oIR = bVar.oIR;
            }
        }

        public void v(d dVar) {
            if (!this.oIT) {
                this.oIS.k(dVar);
            }
        }

        public l emJ() {
            l lVar;
            this.oIT = true;
            synchronized (this) {
                lVar = this.oIS;
                this.oIS = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.oIT = false;
            return lVar;
        }
    }
}
