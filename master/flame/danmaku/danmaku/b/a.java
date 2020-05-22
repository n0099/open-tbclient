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
    public interface InterfaceC0883a {
        void i(d dVar);
    }

    void a(InterfaceC0883a interfaceC0883a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void dOe();

    void release();

    void xb(boolean z);

    void xc(boolean z);

    /* loaded from: classes5.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long fsD;
        public boolean nyZ;
        public int nza;
        public int nzb;
        public d nzc;
        public int nzd;
        public int nze;
        public int nzf;
        public int nzg;
        public int nzh;
        public int nzi;
        public int nzj;
        public long nzk;
        public boolean nzl;
        public long nzm;
        public long nzn;
        private boolean nzp;
        public f nvc = new f();
        private l nzo = new master.flame.danmaku.danmaku.model.android.d(4);

        public int JY(int i) {
            this.nzi += i;
            return this.nzi;
        }

        public int dS(int i, int i2) {
            switch (i) {
                case 1:
                    this.nzd += i2;
                    return this.nzd;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.nzg += i2;
                    return this.nzg;
                case 5:
                    this.nzf += i2;
                    return this.nzf;
                case 6:
                    this.nze += i2;
                    return this.nze;
                case 7:
                    this.nzh += i2;
                    return this.nzh;
            }
        }

        public void reset() {
            this.nzj = this.nzi;
            this.nzi = 0;
            this.nzh = 0;
            this.nzg = 0;
            this.nzf = 0;
            this.nze = 0;
            this.nzd = 0;
            this.nzk = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.fsD = 0L;
            this.nzl = false;
            synchronized (this) {
                this.nzo.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.nzj = bVar.nzj;
                this.nzd = bVar.nzd;
                this.nze = bVar.nze;
                this.nzf = bVar.nzf;
                this.nzg = bVar.nzg;
                this.nzh = bVar.nzh;
                this.nzi = bVar.nzi;
                this.nzk = bVar.nzk;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.nzl = bVar.nzl;
                this.fsD = bVar.fsD;
                this.nzm = bVar.nzm;
                this.nzn = bVar.nzn;
            }
        }

        public void v(d dVar) {
            if (!this.nzp) {
                this.nzo.k(dVar);
            }
        }

        public l dOf() {
            l lVar;
            this.nzp = true;
            synchronized (this) {
                lVar = this.nzo;
                this.nzo = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.nzp = false;
            return lVar;
        }
    }
}
