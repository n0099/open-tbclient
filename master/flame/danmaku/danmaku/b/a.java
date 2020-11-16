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
    public interface InterfaceC1087a {
        void i(d dVar);
    }

    void Bm(boolean z);

    void Bn(boolean z);

    void a(InterfaceC1087a interfaceC1087a);

    void a(k kVar);

    void a(m mVar, l lVar, long j, b bVar);

    void clear();

    void eEj();

    void release();

    /* loaded from: classes6.dex */
    public static class b {
        public long beginTime;
        public long endTime;
        public long gzU;
        private boolean qaA;
        public boolean qak;
        public int qal;
        public int qam;
        public d qan;
        public int qao;
        public int qap;
        public int qaq;
        public int qar;
        public int qas;
        public int qat;
        public int qau;
        public long qav;
        public boolean qaw;
        public long qax;
        public long qay;
        public f pWr = new f();
        private l qaz = new master.flame.danmaku.danmaku.model.android.d(4);

        public int Se(int i) {
            this.qat += i;
            return this.qat;
        }

        public int eB(int i, int i2) {
            switch (i) {
                case 1:
                    this.qao += i2;
                    return this.qao;
                case 2:
                case 3:
                default:
                    return 0;
                case 4:
                    this.qar += i2;
                    return this.qar;
                case 5:
                    this.qaq += i2;
                    return this.qaq;
                case 6:
                    this.qap += i2;
                    return this.qap;
                case 7:
                    this.qas += i2;
                    return this.qas;
            }
        }

        public void reset() {
            this.qau = this.qat;
            this.qat = 0;
            this.qas = 0;
            this.qar = 0;
            this.qaq = 0;
            this.qap = 0;
            this.qao = 0;
            this.qav = 0L;
            this.endTime = 0L;
            this.beginTime = 0L;
            this.gzU = 0L;
            this.qaw = false;
            synchronized (this) {
                this.qaz.clear();
            }
        }

        public void b(b bVar) {
            if (bVar != null) {
                this.qau = bVar.qau;
                this.qao = bVar.qao;
                this.qap = bVar.qap;
                this.qaq = bVar.qaq;
                this.qar = bVar.qar;
                this.qas = bVar.qas;
                this.qat = bVar.qat;
                this.qav = bVar.qav;
                this.beginTime = bVar.beginTime;
                this.endTime = bVar.endTime;
                this.qaw = bVar.qaw;
                this.gzU = bVar.gzU;
                this.qax = bVar.qax;
                this.qay = bVar.qay;
            }
        }

        public void v(d dVar) {
            if (!this.qaA) {
                this.qaz.k(dVar);
            }
        }

        public l eEk() {
            l lVar;
            this.qaA = true;
            synchronized (this) {
                lVar = this.qaz;
                this.qaz = new master.flame.danmaku.danmaku.model.android.d(4);
            }
            this.qaA = false;
            return lVar;
        }
    }
}
