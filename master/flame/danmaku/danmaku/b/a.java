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
    public interface InterfaceC0977a {
        void i(d dVar);
    }

    void a(InterfaceC0977a interfaceC0977a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void eiC();

    void release();

    void yV(boolean z);

    void yW(boolean z);

    /* loaded from: classes6.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long fUL;
        public boolean oyG;
        public int oyH;
        public int oyI;
        public d oyJ;
        public int oyK;
        public int oyL;
        public int oyM;
        public int oyN;
        public int oyO;
        public int oyP;
        public int oyQ;
        public long oyR;
        public boolean oyS;
        public long oyT;
        public long oyU;
        private boolean oyW;
        public f ouL = new f();
        private l oyV = new master.flame.danmaku.danmaku.model.android.d(4);

        public int Oe(int i) {
            this.oyP += i;
            return this.oyP;
        }

        public int el(int i, int i2) {
            switch (i) {
                case 1:
                    this.oyK += i2;
                    return this.oyK;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.oyN += i2;
                    return this.oyN;
                case 5:
                    this.oyM += i2;
                    return this.oyM;
                case 6:
                    this.oyL += i2;
                    return this.oyL;
                case 7:
                    this.oyO += i2;
                    return this.oyO;
            }
        }

        public void reset() {
            this.oyQ = this.oyP;
            this.oyP = 0;
            this.oyO = 0;
            this.oyN = 0;
            this.oyM = 0;
            this.oyL = 0;
            this.oyK = 0;
            this.oyR = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.fUL = 0L;
            this.oyS = false;
            synchronized (this) {
                this.oyV.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.oyQ = bVar.oyQ;
                this.oyK = bVar.oyK;
                this.oyL = bVar.oyL;
                this.oyM = bVar.oyM;
                this.oyN = bVar.oyN;
                this.oyO = bVar.oyO;
                this.oyP = bVar.oyP;
                this.oyR = bVar.oyR;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.oyS = bVar.oyS;
                this.fUL = bVar.fUL;
                this.oyT = bVar.oyT;
                this.oyU = bVar.oyU;
            }
        }

        public void v(d dVar) {
            if (!this.oyW) {
                this.oyV.k(dVar);
            }
        }

        public l eiD() {
            l lVar;
            this.oyW = true;
            synchronized (this) {
                lVar = this.oyV;
                this.oyV = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.oyW = false;
            return lVar;
        }
    }
}
