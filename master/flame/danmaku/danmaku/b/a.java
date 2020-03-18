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
    public interface InterfaceC0777a {
        void i(d dVar);
    }

    void a(InterfaceC0777a interfaceC0777a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void dNn();

    void release();

    void wY(boolean z);

    void wZ(boolean z);

    /* loaded from: classes5.dex */
    public static class b {
        public long beginTime;
        public long eAA;
        public long endTime;
        public int nKA;
        public int nKB;
        public long nKC;
        public boolean nKD;
        public long nKE;
        public long nKF;
        private boolean nKH;
        public boolean nKr;
        public int nKs;
        public int nKt;
        public d nKu;
        public int nKv;
        public int nKw;
        public int nKx;
        public int nKy;
        public int nKz;
        public f nGw = new f();
        private l nKG = new master.flame.danmaku.danmaku.model.android.d(4);

        public int NT(int i) {
            this.nKA += i;
            return this.nKA;
        }

        public int eC(int i, int i2) {
            switch (i) {
                case 1:
                    this.nKv += i2;
                    return this.nKv;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nKy += i2;
                    return this.nKy;
                case 5:
                    this.nKx += i2;
                    return this.nKx;
                case 6:
                    this.nKw += i2;
                    return this.nKw;
                case 7:
                    this.nKz += i2;
                    return this.nKz;
            }
        }

        public void reset() {
            this.nKB = this.nKA;
            this.nKA = 0;
            this.nKz = 0;
            this.nKy = 0;
            this.nKx = 0;
            this.nKw = 0;
            this.nKv = 0;
            this.nKC = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.eAA = 0L;
            this.nKD = false;
            synchronized (this) {
                this.nKG.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nKB = bVar.nKB;
                this.nKv = bVar.nKv;
                this.nKw = bVar.nKw;
                this.nKx = bVar.nKx;
                this.nKy = bVar.nKy;
                this.nKz = bVar.nKz;
                this.nKA = bVar.nKA;
                this.nKC = bVar.nKC;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nKD = bVar.nKD;
                this.eAA = bVar.eAA;
                this.nKE = bVar.nKE;
                this.nKF = bVar.nKF;
            }
        }

        public void v(d dVar) {
            if (!this.nKH) {
                this.nKG.k(dVar);
            }
        }

        public l dNo() {
            l lVar;
            this.nKH = true;
            synchronized (this) {
                lVar = this.nKG;
                this.nKG = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nKH = false;
            return lVar;
        }
    }
}
