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
    public interface InterfaceC0800a {
        void i(d dVar);
    }

    void a(InterfaceC0800a interfaceC0800a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void dGn();

    void release();

    void wD(boolean z);

    void wE(boolean z);

    /* loaded from: classes5.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long feT;
        public boolean ndU;
        public int ndV;
        public int ndW;
        public d ndX;
        public int ndY;
        public int ndZ;
        public int nea;
        public int neb;
        public int nec;
        public int ned;
        public int nee;
        public long nef;
        public boolean neg;
        public long neh;
        public long nei;
        private boolean nek;
        public f mZW = new f();
        private l nej = new master.flame.danmaku.danmaku.model.android.d(4);

        public int Jn(int i) {
            this.ned += i;
            return this.ned;
        }

        public int dN(int i, int i2) {
            switch (i) {
                case 1:
                    this.ndY += i2;
                    return this.ndY;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.neb += i2;
                    return this.neb;
                case 5:
                    this.nea += i2;
                    return this.nea;
                case 6:
                    this.ndZ += i2;
                    return this.ndZ;
                case 7:
                    this.nec += i2;
                    return this.nec;
            }
        }

        public void reset() {
            this.nee = this.ned;
            this.ned = 0;
            this.nec = 0;
            this.neb = 0;
            this.nea = 0;
            this.ndZ = 0;
            this.ndY = 0;
            this.nef = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.feT = 0L;
            this.neg = false;
            synchronized (this) {
                this.nej.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nee = bVar.nee;
                this.ndY = bVar.ndY;
                this.ndZ = bVar.ndZ;
                this.nea = bVar.nea;
                this.neb = bVar.neb;
                this.nec = bVar.nec;
                this.ned = bVar.ned;
                this.nef = bVar.nef;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.neg = bVar.neg;
                this.feT = bVar.feT;
                this.neh = bVar.neh;
                this.nei = bVar.nei;
            }
        }

        public void v(d dVar) {
            if (!this.nek) {
                this.nej.k(dVar);
            }
        }

        public l dGo() {
            l lVar;
            this.nek = true;
            synchronized (this) {
                lVar = this.nej;
                this.nej = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nek = false;
            return lVar;
        }
    }
}
