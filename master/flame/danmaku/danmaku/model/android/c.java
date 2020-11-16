package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes6.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g pZC;
    public master.flame.danmaku.danmaku.model.g pZD;
    public master.flame.danmaku.danmaku.model.g pZE;
    public m pZG;
    private DanmakuContext pZH;
    public int pZx = 0;
    public int pZy = 0;
    private float pZz = 1.0f;
    public long pZA = 10000;
    public long pZB = 4000;
    public l pZF = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c eDT() {
        return new c();
    }

    protected c() {
    }

    public void eDU() {
        this.pZG = null;
        this.pZy = 0;
        this.pZx = 0;
        this.pZF.clear();
        this.pZC = null;
        this.pZD = null;
        this.pZE = null;
        this.pZB = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.pZH = danmakuContext;
        this.pZG = danmakuContext.eDN();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d Sd(int i) {
        return a(i, this.pZH);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.pZH = danmakuContext;
        this.pZG = danmakuContext.eDN();
        return a(i, this.pZG.getWidth(), this.pZG.getHeight(), this.pZz, danmakuContext.pZf);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.pZx;
        int i3 = this.pZy;
        boolean l = l(f, f2, f3);
        if (this.pZC == null) {
            this.pZC = new master.flame.danmaku.danmaku.model.g(this.pZA);
            this.pZC.bD(f4);
        } else if (l) {
            this.pZC.setValue(this.pZA);
        }
        if (this.pZD == null) {
            this.pZD = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (l && f > 0.0f) {
            eDV();
            if (i2 <= 0 || i3 <= 0) {
                f5 = 1.0f;
            } else {
                f5 = f / i2;
                f6 = f2 / i3;
            }
            if (f2 > 0.0f) {
                J(f5, f6);
            }
        }
        switch (i) {
            case 1:
                return new p(this.pZC);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.pZD);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.pZD);
            case 6:
                return new o(this.pZC);
            case 7:
                q qVar = new q();
                this.pZF.k(qVar);
                return qVar;
        }
    }

    public boolean l(float f, float f2, float f3) {
        if (this.pZx == ((int) f) && this.pZy == ((int) f2) && this.pZz == f3) {
            return false;
        }
        this.pZA = 10000.0f * ((f3 * f) / 682.0f);
        this.pZA = Math.min(9000L, this.pZA);
        this.pZA = Math.max(4000L, this.pZA);
        this.pZx = (int) f;
        this.pZy = (int) f2;
        this.pZz = f3;
        return true;
    }

    private void J(final float f, final float f2) {
        this.pZF.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bY(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.pYb, qVar.pYc, qVar.lwU, qVar.lwV, qVar.pYd, qVar.pYe, f, f2);
                q.a[] aVarArr = qVar.pYl;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].eDJ();
                        fArr[i + 1] = aVarArr[i].eDK();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void eDV() {
        long j = this.pZC == null ? 0L : this.pZC.value;
        long j2 = this.pZD == null ? 0L : this.pZD.value;
        long j3 = this.pZE != null ? this.pZE.value : 0L;
        this.pZB = Math.max(j, j2);
        this.pZB = Math.max(this.pZB, j3);
        this.pZB = Math.max(10000L, this.pZB);
        this.pZB = Math.max(this.pZA, this.pZB);
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
        if (this.pZE == null || (dVar.pXw != null && dVar.pXw.value > this.pZE.value)) {
            this.pZE = dVar.pXw;
            eDV();
        }
    }
}
