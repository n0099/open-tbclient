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

    void dWz();

    void release();

    void yd(boolean z);

    void ye(boolean z);

    /* loaded from: classes6.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long fJu;
        public boolean oeJ;
        public int oeK;
        public int oeL;
        public d oeM;
        public int oeN;
        public int oeO;
        public int oeP;
        public int oeQ;
        public int oeR;
        public int oeS;
        public int oeT;
        public long oeU;
        public boolean oeV;
        public long oeW;
        public long oeX;
        private boolean oeZ;
        public f oaM = new f();
        private l oeY = new master.flame.danmaku.danmaku.model.android.d(4);

        public int LB(int i) {
            this.oeS += i;
            return this.oeS;
        }

        public int ed(int i, int i2) {
            switch (i) {
                case 1:
                    this.oeN += i2;
                    return this.oeN;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.oeQ += i2;
                    return this.oeQ;
                case 5:
                    this.oeP += i2;
                    return this.oeP;
                case 6:
                    this.oeO += i2;
                    return this.oeO;
                case 7:
                    this.oeR += i2;
                    return this.oeR;
            }
        }

        public void reset() {
            this.oeT = this.oeS;
            this.oeS = 0;
            this.oeR = 0;
            this.oeQ = 0;
            this.oeP = 0;
            this.oeO = 0;
            this.oeN = 0;
            this.oeU = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.fJu = 0L;
            this.oeV = false;
            synchronized (this) {
                this.oeY.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.oeT = bVar.oeT;
                this.oeN = bVar.oeN;
                this.oeO = bVar.oeO;
                this.oeP = bVar.oeP;
                this.oeQ = bVar.oeQ;
                this.oeR = bVar.oeR;
                this.oeS = bVar.oeS;
                this.oeU = bVar.oeU;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.oeV = bVar.oeV;
                this.fJu = bVar.fJu;
                this.oeW = bVar.oeW;
                this.oeX = bVar.oeX;
            }
        }

        public void v(d dVar) {
            if (!this.oeZ) {
                this.oeY.k(dVar);
            }
        }

        public l dWA() {
            l lVar;
            this.oeZ = true;
            synchronized (this) {
                lVar = this.oeY;
                this.oeY = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.oeZ = false;
            return lVar;
        }
    }
}
