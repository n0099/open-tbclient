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
    public interface InterfaceC0821a {
        void i(d dVar);
    }

    void a(InterfaceC0821a interfaceC0821a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void dGk();

    void release();

    void wD(boolean z);

    void wE(boolean z);

    /* loaded from: classes5.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long feY;
        public boolean ndX;
        public int ndY;
        public int ndZ;
        public d nea;
        public int neb;
        public int nec;
        public int ned;
        public int nee;
        public int nef;
        public int neg;
        public int neh;
        public long nei;
        public boolean nej;
        public long nek;
        public long nel;
        private boolean nen;
        public f mZZ = new f();
        private l nem = new master.flame.danmaku.danmaku.model.android.d(4);

        public int Jn(int i) {
            this.neg += i;
            return this.neg;
        }

        public int dN(int i, int i2) {
            switch (i) {
                case 1:
                    this.neb += i2;
                    return this.neb;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nee += i2;
                    return this.nee;
                case 5:
                    this.ned += i2;
                    return this.ned;
                case 6:
                    this.nec += i2;
                    return this.nec;
                case 7:
                    this.nef += i2;
                    return this.nef;
            }
        }

        public void reset() {
            this.neh = this.neg;
            this.neg = 0;
            this.nef = 0;
            this.nee = 0;
            this.ned = 0;
            this.nec = 0;
            this.neb = 0;
            this.nei = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.feY = 0L;
            this.nej = false;
            synchronized (this) {
                this.nem.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.neh = bVar.neh;
                this.neb = bVar.neb;
                this.nec = bVar.nec;
                this.ned = bVar.ned;
                this.nee = bVar.nee;
                this.nef = bVar.nef;
                this.neg = bVar.neg;
                this.nei = bVar.nei;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nej = bVar.nej;
                this.feY = bVar.feY;
                this.nek = bVar.nek;
                this.nel = bVar.nel;
            }
        }

        public void v(d dVar) {
            if (!this.nen) {
                this.nem.k(dVar);
            }
        }

        public l dGl() {
            l lVar;
            this.nen = true;
            synchronized (this) {
                lVar = this.nem;
                this.nem = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nen = false;
            return lVar;
        }
    }
}
