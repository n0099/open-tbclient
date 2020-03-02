package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes5.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g nHJ;
    public master.flame.danmaku.danmaku.model.g nHK;
    public master.flame.danmaku.danmaku.model.g nHL;
    public m nHN;
    private DanmakuContext nHO;
    public int nHE = 0;
    public int nHF = 0;
    private float nHG = 1.0f;
    public long nHH = 10000;
    public long nHI = 4000;
    public l nHM = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dMw() {
        return new c();
    }

    protected c() {
    }

    public void dMx() {
        this.nHN = null;
        this.nHF = 0;
        this.nHE = 0;
        this.nHM.clear();
        this.nHJ = null;
        this.nHK = null;
        this.nHL = null;
        this.nHI = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nHO = danmakuContext;
        this.nHN = danmakuContext.dMq();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d NM(int i) {
        return a(i, this.nHO);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nHO = danmakuContext;
        this.nHN = danmakuContext.dMq();
        return a(i, this.nHN.getWidth(), this.nHN.getHeight(), this.nHG, danmakuContext.nHm);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.nHE;
        int i3 = this.nHF;
        boolean i4 = i(f, f2, f3);
        if (this.nHJ == null) {
            this.nHJ = new master.flame.danmaku.danmaku.model.g(this.nHH);
            this.nHJ.bF(f4);
        } else if (i4) {
            this.nHJ.setValue(this.nHH);
        }
        if (this.nHK == null) {
            this.nHK = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (i4 && f > 0.0f) {
            dMy();
            if (i2 <= 0 || i3 <= 0) {
                f5 = 1.0f;
            } else {
                f5 = f / i2;
                f6 = f2 / i3;
            }
            if (f2 > 0.0f) {
                F(f5, f6);
            }
        }
        switch (i) {
            case 1:
                return new p(this.nHJ);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.nHK);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.nHK);
            case 6:
                return new o(this.nHJ);
            case 7:
                q qVar = new q();
                this.nHM.k(qVar);
                return qVar;
        }
    }

    public boolean i(float f, float f2, float f3) {
        if (this.nHE == ((int) f) && this.nHF == ((int) f2) && this.nHG == f3) {
            return false;
        }
        this.nHH = 10000.0f * ((f3 * f) / 682.0f);
        this.nHH = Math.min(9000L, this.nHH);
        this.nHH = Math.max(4000L, this.nHH);
        this.nHE = (int) f;
        this.nHF = (int) f2;
        this.nHG = f3;
        return true;
    }

    private void F(final float f, final float f2) {
        this.nHM.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nGj, qVar.nGk, qVar.iJT, qVar.iJU, qVar.nGl, qVar.nGm, f, f2);
                q.a[] aVarArr = qVar.nGt;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dMm();
                        fArr[i + 1] = aVarArr[i].dMn();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dMy() {
        long j = this.nHJ == null ? 0L : this.nHJ.value;
        long j2 = this.nHK == null ? 0L : this.nHK.value;
        long j3 = this.nHL != null ? this.nHL.value : 0L;
        this.nHI = Math.max(j, j2);
        this.nHI = Math.max(this.nHI, j3);
        this.nHI = Math.max(10000L, this.nHI);
        this.nHI = Math.max(this.nHH, this.nHI);
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
        if (this.nHL == null || (dVar.nFE != null && dVar.nFE.value > this.nHL.value)) {
            this.nHL = dVar.nFE;
            dMy();
        }
    }
}
