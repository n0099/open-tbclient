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
    public interface InterfaceC0919a {
        void i(d dVar);
    }

    void a(InterfaceC0919a interfaceC0919a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void dWy();

    void release();

    void yd(boolean z);

    void ye(boolean z);

    /* loaded from: classes6.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long fJu;
        public boolean oeH;
        public int oeI;
        public int oeJ;
        public d oeK;
        public int oeL;
        public int oeM;
        public int oeN;
        public int oeO;
        public int oeP;
        public int oeQ;
        public int oeR;
        public long oeS;
        public boolean oeT;
        public long oeU;
        public long oeV;
        private boolean oeX;
        public f oaK = new f();
        private l oeW = new master.flame.danmaku.danmaku.model.android.d(4);

        public int LB(int i) {
            this.oeQ += i;
            return this.oeQ;
        }

        public int ed(int i, int i2) {
            switch (i) {
                case 1:
                    this.oeL += i2;
                    return this.oeL;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.oeO += i2;
                    return this.oeO;
                case 5:
                    this.oeN += i2;
                    return this.oeN;
                case 6:
                    this.oeM += i2;
                    return this.oeM;
                case 7:
                    this.oeP += i2;
                    return this.oeP;
            }
        }

        public void reset() {
            this.oeR = this.oeQ;
            this.oeQ = 0;
            this.oeP = 0;
            this.oeO = 0;
            this.oeN = 0;
            this.oeM = 0;
            this.oeL = 0;
            this.oeS = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.fJu = 0L;
            this.oeT = false;
            synchronized (this) {
                this.oeW.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.oeR = bVar.oeR;
                this.oeL = bVar.oeL;
                this.oeM = bVar.oeM;
                this.oeN = bVar.oeN;
                this.oeO = bVar.oeO;
                this.oeP = bVar.oeP;
                this.oeQ = bVar.oeQ;
                this.oeS = bVar.oeS;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.oeT = bVar.oeT;
                this.fJu = bVar.fJu;
                this.oeU = bVar.oeU;
                this.oeV = bVar.oeV;
            }
        }

        public void v(d dVar) {
            if (!this.oeX) {
                this.oeW.k(dVar);
            }
        }

        public l dWz() {
            l lVar;
            this.oeX = true;
            synchronized (this) {
                lVar = this.oeW;
                this.oeW = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.oeX = false;
            return lVar;
        }
    }
}
