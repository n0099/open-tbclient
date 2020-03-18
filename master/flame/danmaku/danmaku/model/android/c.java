package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes5.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g nJH;
    public master.flame.danmaku.danmaku.model.g nJI;
    public master.flame.danmaku.danmaku.model.g nJJ;
    public m nJL;
    private DanmakuContext nJM;
    public int nJC = 0;
    public int nJD = 0;
    private float nJE = 1.0f;
    public long nJF = 10000;
    public long nJG = 4000;
    public l nJK = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dMX() {
        return new c();
    }

    protected c() {
    }

    public void dMY() {
        this.nJL = null;
        this.nJD = 0;
        this.nJC = 0;
        this.nJK.clear();
        this.nJH = null;
        this.nJI = null;
        this.nJJ = null;
        this.nJG = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nJM = danmakuContext;
        this.nJL = danmakuContext.dMR();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d NS(int i) {
        return a(i, this.nJM);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nJM = danmakuContext;
        this.nJL = danmakuContext.dMR();
        return a(i, this.nJL.getWidth(), this.nJL.getHeight(), this.nJE, danmakuContext.nJk);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.nJC;
        int i3 = this.nJD;
        boolean i4 = i(f, f2, f3);
        if (this.nJH == null) {
            this.nJH = new master.flame.danmaku.danmaku.model.g(this.nJF);
            this.nJH.bF(f4);
        } else if (i4) {
            this.nJH.setValue(this.nJF);
        }
        if (this.nJI == null) {
            this.nJI = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (i4 && f > 0.0f) {
            dMZ();
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
                return new p(this.nJH);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.nJI);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.nJI);
            case 6:
                return new o(this.nJH);
            case 7:
                q qVar = new q();
                this.nJK.k(qVar);
                return qVar;
        }
    }

    public boolean i(float f, float f2, float f3) {
        if (this.nJC == ((int) f) && this.nJD == ((int) f2) && this.nJE == f3) {
            return false;
        }
        this.nJF = 10000.0f * ((f3 * f) / 682.0f);
        this.nJF = Math.min(9000L, this.nJF);
        this.nJF = Math.max(4000L, this.nJF);
        this.nJC = (int) f;
        this.nJD = (int) f2;
        this.nJE = f3;
        return true;
    }

    private void F(final float f, final float f2) {
        this.nJK.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nIh, qVar.nIi, qVar.iLG, qVar.iLH, qVar.nIj, qVar.nIk, f, f2);
                q.a[] aVarArr = qVar.nIr;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dMN();
                        fArr[i + 1] = aVarArr[i].dMO();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dMZ() {
        long j = this.nJH == null ? 0L : this.nJH.value;
        long j2 = this.nJI == null ? 0L : this.nJI.value;
        long j3 = this.nJJ != null ? this.nJJ.value : 0L;
        this.nJG = Math.max(j, j2);
        this.nJG = Math.max(this.nJG, j3);
        this.nJG = Math.max(10000L, this.nJG);
        this.nJG = Math.max(this.nJF, this.nJG);
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
        if (this.nJJ == null || (dVar.nHC != null && dVar.nHC.value > this.nJJ.value)) {
            this.nJJ = dVar.nHC;
            dMZ();
        }
    }
}
