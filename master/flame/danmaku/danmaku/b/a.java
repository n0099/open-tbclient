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

    void eiL();

    void release();

    void yX(boolean z);

    void yY(boolean z);

    /* loaded from: classes6.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long fUP;
        public boolean oyY;
        public int oyZ;
        public int oza;
        public d ozb;
        public int ozc;
        public int ozd;
        public int oze;
        public int ozf;
        public int ozg;
        public int ozh;
        public int ozi;
        public long ozj;
        public boolean ozk;
        public long ozl;
        public long ozm;
        private boolean ozo;
        public f ovd = new f();
        private l ozn = new master.flame.danmaku.danmaku.model.android.d(4);

        public int Oe(int i) {
            this.ozh += i;
            return this.ozh;
        }

        public int el(int i, int i2) {
            switch (i) {
                case 1:
                    this.ozc += i2;
                    return this.ozc;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.ozf += i2;
                    return this.ozf;
                case 5:
                    this.oze += i2;
                    return this.oze;
                case 6:
                    this.ozd += i2;
                    return this.ozd;
                case 7:
                    this.ozg += i2;
                    return this.ozg;
            }
        }

        public void reset() {
            this.ozi = this.ozh;
            this.ozh = 0;
            this.ozg = 0;
            this.ozf = 0;
            this.oze = 0;
            this.ozd = 0;
            this.ozc = 0;
            this.ozj = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.fUP = 0L;
            this.ozk = false;
            synchronized (this) {
                this.ozn.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.ozi = bVar.ozi;
                this.ozc = bVar.ozc;
                this.ozd = bVar.ozd;
                this.oze = bVar.oze;
                this.ozf = bVar.ozf;
                this.ozg = bVar.ozg;
                this.ozh = bVar.ozh;
                this.ozj = bVar.ozj;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.ozk = bVar.ozk;
                this.fUP = bVar.fUP;
                this.ozl = bVar.ozl;
                this.ozm = bVar.ozm;
            }
        }

        public void v(d dVar) {
            if (!this.ozo) {
                this.ozn.k(dVar);
            }
        }

        public l eiM() {
            l lVar;
            this.ozo = true;
            synchronized (this) {
                lVar = this.ozn;
                this.ozn = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.ozo = false;
            return lVar;
        }
    }
}
