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
    public interface InterfaceC0992a {
        void i(d dVar);
    }

    void a(InterfaceC0992a interfaceC0992a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void eqv();

    void release();

    void zM(boolean z);

    void zN(boolean z);

    /* loaded from: classes6.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long gkv;
        public boolean oXR;
        public int oXS;
        public int oXT;
        public d oXU;
        public int oXV;
        public int oXW;
        public int oXX;
        public int oXY;
        public int oXZ;
        public int oYa;
        public int oYb;
        public long oYc;
        public boolean oYd;
        public long oYe;
        public long oYf;
        private boolean oYh;
        public f oTY = new f();
        private l oYg = new master.flame.danmaku.danmaku.model.android.d(4);

        public int Pp(int i) {
            this.oYa += i;
            return this.oYa;
        }

        public int ep(int i, int i2) {
            switch (i) {
                case 1:
                    this.oXV += i2;
                    return this.oXV;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.oXY += i2;
                    return this.oXY;
                case 5:
                    this.oXX += i2;
                    return this.oXX;
                case 6:
                    this.oXW += i2;
                    return this.oXW;
                case 7:
                    this.oXZ += i2;
                    return this.oXZ;
            }
        }

        public void reset() {
            this.oYb = this.oYa;
            this.oYa = 0;
            this.oXZ = 0;
            this.oXY = 0;
            this.oXX = 0;
            this.oXW = 0;
            this.oXV = 0;
            this.oYc = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.gkv = 0L;
            this.oYd = false;
            synchronized (this) {
                this.oYg.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.oYb = bVar.oYb;
                this.oXV = bVar.oXV;
                this.oXW = bVar.oXW;
                this.oXX = bVar.oXX;
                this.oXY = bVar.oXY;
                this.oXZ = bVar.oXZ;
                this.oYa = bVar.oYa;
                this.oYc = bVar.oYc;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.oYd = bVar.oYd;
                this.gkv = bVar.gkv;
                this.oYe = bVar.oYe;
                this.oYf = bVar.oYf;
            }
        }

        public void v(d dVar) {
            if (!this.oYh) {
                this.oYg.k(dVar);
            }
        }

        public l eqw() {
            l lVar;
            this.oYh = true;
            synchronized (this) {
                lVar = this.oYg;
                this.oYg = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.oYh = false;
            return lVar;
        }
    }
}
