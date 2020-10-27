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
    public interface InterfaceC1064a {
        void i(d dVar);
    }

    void AU(boolean z);

    void AV(boolean z);

    void a(InterfaceC1064a interfaceC1064a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void eAt();

    void release();

    /* loaded from: classes6.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long guz;
        public long pPA;
        public long pPB;
        private boolean pPD;
        public boolean pPn;
        public int pPo;
        public int pPp;
        public d pPq;
        public int pPr;
        public int pPs;
        public int pPt;
        public int pPu;
        public int pPv;
        public int pPw;
        public int pPx;
        public long pPy;
        public boolean pPz;
        public f pLu = new f();
        private l pPC = new master.flame.danmaku.danmaku.model.android.d(4);

        public int Rg(int i) {
            this.pPw += i;
            return this.pPw;
        }

        public int ex(int i, int i2) {
            switch (i) {
                case 1:
                    this.pPr += i2;
                    return this.pPr;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.pPu += i2;
                    return this.pPu;
                case 5:
                    this.pPt += i2;
                    return this.pPt;
                case 6:
                    this.pPs += i2;
                    return this.pPs;
                case 7:
                    this.pPv += i2;
                    return this.pPv;
            }
        }

        public void reset() {
            this.pPx = this.pPw;
            this.pPw = 0;
            this.pPv = 0;
            this.pPu = 0;
            this.pPt = 0;
            this.pPs = 0;
            this.pPr = 0;
            this.pPy = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.guz = 0L;
            this.pPz = false;
            synchronized (this) {
                this.pPC.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.pPx = bVar.pPx;
                this.pPr = bVar.pPr;
                this.pPs = bVar.pPs;
                this.pPt = bVar.pPt;
                this.pPu = bVar.pPu;
                this.pPv = bVar.pPv;
                this.pPw = bVar.pPw;
                this.pPy = bVar.pPy;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.pPz = bVar.pPz;
                this.guz = bVar.guz;
                this.pPA = bVar.pPA;
                this.pPB = bVar.pPB;
            }
        }

        public void v(d dVar) {
            if (!this.pPD) {
                this.pPC.k(dVar);
            }
        }

        public l eAu() {
            l lVar;
            this.pPD = true;
            synchronized (this) {
                lVar = this.pPC;
                this.pPC = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.pPD = false;
            return lVar;
        }
    }
}
