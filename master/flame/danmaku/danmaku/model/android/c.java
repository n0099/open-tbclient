package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes6.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g pOF;
    public master.flame.danmaku.danmaku.model.g pOG;
    public master.flame.danmaku.danmaku.model.g pOH;
    public m pOJ;
    private DanmakuContext pOK;
    public int pOA = 0;
    public int pOB = 0;
    private float pOC = 1.0f;
    public long pOD = 10000;
    public long pOE = 4000;
    public l pOI = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c eAd() {
        return new c();
    }

    protected c() {
    }

    public void eAe() {
        this.pOJ = null;
        this.pOB = 0;
        this.pOA = 0;
        this.pOI.clear();
        this.pOF = null;
        this.pOG = null;
        this.pOH = null;
        this.pOE = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.pOK = danmakuContext;
        this.pOJ = danmakuContext.ezX();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d Rf(int i) {
        return a(i, this.pOK);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.pOK = danmakuContext;
        this.pOJ = danmakuContext.ezX();
        return a(i, this.pOJ.getWidth(), this.pOJ.getHeight(), this.pOC, danmakuContext.pOi);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.pOA;
        int i3 = this.pOB;
        boolean l = l(f, f2, f3);
        if (this.pOF == null) {
            this.pOF = new master.flame.danmaku.danmaku.model.g(this.pOD);
            this.pOF.bt(f4);
        } else if (l) {
            this.pOF.setValue(this.pOD);
        }
        if (this.pOG == null) {
            this.pOG = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (l && f > 0.0f) {
            eAf();
            if (i2 <= 0 || i3 <= 0) {
                f5 = 1.0f;
            } else {
                f5 = f / i2;
                f6 = f2 / i3;
            }
            if (f2 > 0.0f) {
                H(f5, f6);
            }
        }
        switch (i) {
            case 1:
                return new p(this.pOF);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.pOG);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.pOG);
            case 6:
                return new o(this.pOF);
            case 7:
                q qVar = new q();
                this.pOI.k(qVar);
                return qVar;
        }
    }

    public boolean l(float f, float f2, float f3) {
        if (this.pOA == ((int) f) && this.pOB == ((int) f2) && this.pOC == f3) {
            return false;
        }
        this.pOD = 10000.0f * ((f3 * f) / 682.0f);
        this.pOD = Math.min(9000L, this.pOD);
        this.pOD = Math.max(4000L, this.pOD);
        this.pOA = (int) f;
        this.pOB = (int) f2;
        this.pOC = f3;
        return true;
    }

    private void H(final float f, final float f2) {
        this.pOI.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.pNe, qVar.pNf, qVar.lqH, qVar.lqI, qVar.pNg, qVar.pNh, f, f2);
                q.a[] aVarArr = qVar.pNo;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].ezT();
                        fArr[i + 1] = aVarArr[i].ezU();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void eAf() {
        long j = this.pOF == null ? 0L : this.pOF.value;
        long j2 = this.pOG == null ? 0L : this.pOG.value;
        long j3 = this.pOH != null ? this.pOH.value : 0L;
        this.pOE = Math.max(j, j2);
        this.pOE = Math.max(this.pOE, j3);
        this.pOE = Math.max(10000L, this.pOE);
        this.pOE = Math.max(this.pOD, this.pOE);
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
        if (this.pOH == null || (dVar.pMz != null && dVar.pMz.value > this.pOH.value)) {
            this.pOH = dVar.pMz;
            eAf();
        }
    }
}
