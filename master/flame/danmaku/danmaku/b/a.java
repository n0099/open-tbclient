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

    void dLv();

    void release();

    void wN(boolean z);

    void wO(boolean z);

    /* loaded from: classes4.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long evF;
        public int nHA;
        public int nHB;
        public int nHC;
        public int nHD;
        public int nHE;
        public int nHF;
        public int nHG;
        public long nHH;
        public boolean nHI;
        public long nHJ;
        public long nHK;
        private boolean nHM;
        public boolean nHw;
        public int nHx;
        public int nHy;
        public d nHz;
        public f nDz = new f();
        private l nHL = new master.flame.danmaku.danmaku.model.android.d(4);

        public int NK(int i) {
            this.nHF += i;
            return this.nHF;
        }

        public int ey(int i, int i2) {
            switch (i) {
                case 1:
                    this.nHA += i2;
                    return this.nHA;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nHD += i2;
                    return this.nHD;
                case 5:
                    this.nHC += i2;
                    return this.nHC;
                case 6:
                    this.nHB += i2;
                    return this.nHB;
                case 7:
                    this.nHE += i2;
                    return this.nHE;
            }
        }

        public void reset() {
            this.nHG = this.nHF;
            this.nHF = 0;
            this.nHE = 0;
            this.nHD = 0;
            this.nHC = 0;
            this.nHB = 0;
            this.nHA = 0;
            this.nHH = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.evF = 0L;
            this.nHI = false;
            synchronized (this) {
                this.nHL.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nHG = bVar.nHG;
                this.nHA = bVar.nHA;
                this.nHB = bVar.nHB;
                this.nHC = bVar.nHC;
                this.nHD = bVar.nHD;
                this.nHE = bVar.nHE;
                this.nHF = bVar.nHF;
                this.nHH = bVar.nHH;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nHI = bVar.nHI;
                this.evF = bVar.evF;
                this.nHJ = bVar.nHJ;
                this.nHK = bVar.nHK;
            }
        }

        public void v(d dVar) {
            if (!this.nHM) {
                this.nHL.k(dVar);
            }
        }

        public l dLw() {
            l lVar;
            this.nHM = true;
            synchronized (this) {
                lVar = this.nHL;
                this.nHL = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nHM = false;
            return lVar;
        }
    }
}
