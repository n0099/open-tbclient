package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes5.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g nyq;
    public master.flame.danmaku.danmaku.model.g nyr;
    public master.flame.danmaku.danmaku.model.g nys;
    public m nyu;
    private DanmakuContext nyv;
    public int nyl = 0;
    public int nym = 0;
    private float nyn = 1.0f;
    public long nyo = 10000;
    public long nyp = 4000;
    public l nyt = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dNO() {
        return new c();
    }

    protected c() {
    }

    public void dNP() {
        this.nyu = null;
        this.nym = 0;
        this.nyl = 0;
        this.nyt.clear();
        this.nyq = null;
        this.nyr = null;
        this.nys = null;
        this.nyp = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nyv = danmakuContext;
        this.nyu = danmakuContext.dNI();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d JX(int i) {
        return a(i, this.nyv);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nyv = danmakuContext;
        this.nyu = danmakuContext.dNI();
        return a(i, this.nyu.getWidth(), this.nyu.getHeight(), this.nyn, danmakuContext.nxT);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return a(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.nyl;
        int i3 = this.nym;
        boolean j = j(f, f2, f3);
        if (this.nyq == null) {
            this.nyq = new master.flame.danmaku.danmaku.model.g(this.nyo);
            this.nyq.aL(f4);
        } else if (j) {
            this.nyq.setValue(this.nyo);
        }
        if (this.nyr == null) {
            this.nyr = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            dNQ();
            if (i2 <= 0 || i3 <= 0) {
                f5 = 1.0f;
            } else {
                f5 = f / i2;
                f6 = f2 / i3;
            }
            if (f2 > 0.0f) {
                A(f5, f6);
            }
        }
        switch (i) {
            case 1:
                return new p(this.nyq);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.nyr);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.nyr);
            case 6:
                return new o(this.nyq);
            case 7:
                q qVar = new q();
                this.nyt.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.nyl == ((int) f) && this.nym == ((int) f2) && this.nyn == f3) {
            return false;
        }
        this.nyo = 10000.0f * ((f3 * f) / 682.0f);
        this.nyo = Math.min(9000L, this.nyo);
        this.nyo = Math.max(4000L, this.nyo);
        this.nyl = (int) f;
        this.nym = (int) f2;
        this.nyn = f3;
        return true;
    }

    private void A(final float f, final float f2) {
        this.nyt.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nwP, qVar.nwQ, qVar.jNe, qVar.jNf, qVar.nwR, qVar.nwS, f, f2);
                q.a[] aVarArr = qVar.nwZ;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dNE();
                        fArr[i + 1] = aVarArr[i].dNF();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dNQ() {
        long j = this.nyq == null ? 0L : this.nyq.value;
        long j2 = this.nyr == null ? 0L : this.nyr.value;
        long j3 = this.nys != null ? this.nys.value : 0L;
        this.nyp = Math.max(j, j2);
        this.nyp = Math.max(this.nyp, j3);
        this.nyp = Math.max(10000L, this.nyp);
        this.nyp = Math.max(this.nyo, this.nyp);
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar, float f, float f2, float f3, float f4, long j, long j2, float f5, float f6) {
        if (dVar.getType() == 7) {
            ((q) dVar).a(f * f5, f2 * f6, f3 * f5, f4 * f6, j, j2);
            u(dVar);
        }
    }

    public static void a(master.flame.danmaku.danmaku.model.d dVar, float[][] fArr, float f, float f2) {
        if (dVar.getType() == 7 && fArr.length != 0 && fArr[0].length == 2) {
            for (int i = 0; i < fArr.length; i++) {
                float[] fArr2 = fArr[i];
                fArr2[0] = fArr2[0] * f;
                float[] fArr3 = fArr[i];
                fArr3[1] = fArr3[1] * f2;
            }
            ((q) dVar).a(fArr);
        }
    }

    private void u(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nys == null || (dVar.nwi != null && dVar.nwi.value > this.nys.value)) {
            this.nys = dVar.nwi;
            dNQ();
        }
    }
}
