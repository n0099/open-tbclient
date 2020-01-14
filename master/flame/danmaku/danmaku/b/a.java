package master.flame.danmaku.danmaku.b;

import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: master.flame.danmaku.danmaku.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0768a {
        void i(d dVar);
    }

    void a(InterfaceC0768a interfaceC0768a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void dLx();

    void release();

    void wN(boolean z);

    void wO(boolean z);

    /* loaded from: classes4.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long evF;
        public boolean nHB;
        public int nHC;
        public int nHD;
        public d nHE;
        public int nHF;
        public int nHG;
        public int nHH;
        public int nHI;
        public int nHJ;
        public int nHK;
        public int nHL;
        public long nHM;
        public boolean nHN;
        public long nHO;
        public long nHP;
        private boolean nHR;
        public f nDE = new f();
        private l nHQ = new master.flame.danmaku.danmaku.model.android.d(4);

        public int NK(int i) {
            this.nHK += i;
            return this.nHK;
        }

        public int ey(int i, int i2) {
            switch (i) {
                case 1:
                    this.nHF += i2;
                    return this.nHF;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nHI += i2;
                    return this.nHI;
                case 5:
                    this.nHH += i2;
                    return this.nHH;
                case 6:
                    this.nHG += i2;
                    return this.nHG;
                case 7:
                    this.nHJ += i2;
                    return this.nHJ;
            }
        }

        public void reset() {
            this.nHL = this.nHK;
            this.nHK = 0;
            this.nHJ = 0;
            this.nHI = 0;
            this.nHH = 0;
            this.nHG = 0;
            this.nHF = 0;
            this.nHM = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.evF = 0L;
            this.nHN = false;
            synchronized (this) {
                this.nHQ.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nHL = bVar.nHL;
                this.nHF = bVar.nHF;
                this.nHG = bVar.nHG;
                this.nHH = bVar.nHH;
                this.nHI = bVar.nHI;
                this.nHJ = bVar.nHJ;
                this.nHK = bVar.nHK;
                this.nHM = bVar.nHM;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nHN = bVar.nHN;
                this.evF = bVar.evF;
                this.nHO = bVar.nHO;
                this.nHP = bVar.nHP;
            }
        }

        public void v(d dVar) {
            if (!this.nHR) {
                this.nHQ.k(dVar);
            }
        }

        public l dLy() {
            l lVar;
            this.nHR = true;
            synchronized (this) {
                lVar = this.nHQ;
                this.nHQ = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nHR = false;
            return lVar;
        }
    }
}
