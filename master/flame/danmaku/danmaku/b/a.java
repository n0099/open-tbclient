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
    public interface InterfaceC1084a {
        void i(d dVar);
    }

    void Bf(boolean z);

    void Bg(boolean z);

    void a(InterfaceC1084a interfaceC1084a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void eEi();

    void release();

    /* loaded from: classes6.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long gAn;
        public boolean pYH;
        public int pYI;
        public int pYJ;
        public d pYK;
        public int pYL;
        public int pYM;
        public int pYN;
        public int pYO;
        public int pYP;
        public int pYQ;
        public int pYR;
        public long pYS;
        public boolean pYT;
        public long pYU;
        public long pYV;
        private boolean pYX;
        public f pUO = new f();
        private l pYW = new master.flame.danmaku.danmaku.model.android.d(4);

        public int RB(int i) {
            this.pYQ += i;
            return this.pYQ;
        }

        public int eA(int i, int i2) {
            switch (i) {
                case 1:
                    this.pYL += i2;
                    return this.pYL;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.pYO += i2;
                    return this.pYO;
                case 5:
                    this.pYN += i2;
                    return this.pYN;
                case 6:
                    this.pYM += i2;
                    return this.pYM;
                case 7:
                    this.pYP += i2;
                    return this.pYP;
            }
        }

        public void reset() {
            this.pYR = this.pYQ;
            this.pYQ = 0;
            this.pYP = 0;
            this.pYO = 0;
            this.pYN = 0;
            this.pYM = 0;
            this.pYL = 0;
            this.pYS = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.gAn = 0L;
            this.pYT = false;
            synchronized (this) {
                this.pYW.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.pYR = bVar.pYR;
                this.pYL = bVar.pYL;
                this.pYM = bVar.pYM;
                this.pYN = bVar.pYN;
                this.pYO = bVar.pYO;
                this.pYP = bVar.pYP;
                this.pYQ = bVar.pYQ;
                this.pYS = bVar.pYS;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.pYT = bVar.pYT;
                this.gAn = bVar.gAn;
                this.pYU = bVar.pYU;
                this.pYV = bVar.pYV;
            }
        }

        public void v(d dVar) {
            if (!this.pYX) {
                this.pYW.k(dVar);
            }
        }

        public l eEj() {
            l lVar;
            this.pYX = true;
            synchronized (this) {
                lVar = this.pYW;
                this.pYW = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.pYX = false;
            return lVar;
        }
    }
}
