package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes4.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g nGQ;
    public master.flame.danmaku.danmaku.model.g nGR;
    public master.flame.danmaku.danmaku.model.g nGS;
    public m nGU;
    private DanmakuContext nGV;
    public int nGL = 0;
    public int nGM = 0;
    private float nGN = 1.0f;
    public long nGO = 10000;
    public long nGP = 4000;
    public l nGT = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dLh() {
        return new c();
    }

    protected c() {
    }

    public void dLi() {
        this.nGU = null;
        this.nGM = 0;
        this.nGL = 0;
        this.nGT.clear();
        this.nGQ = null;
        this.nGR = null;
        this.nGS = null;
        this.nGP = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nGV = danmakuContext;
        this.nGU = danmakuContext.dLb();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d NJ(int i) {
        return a(i, this.nGV);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nGV = danmakuContext;
        this.nGU = danmakuContext.dLb();
        return a(i, this.nGU.getWidth(), this.nGU.getHeight(), this.nGN, danmakuContext.nGt);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.nGL;
        int i3 = this.nGM;
        boolean i4 = i(f, f2, f3);
        if (this.nGQ == null) {
            this.nGQ = new master.flame.danmaku.danmaku.model.g(this.nGO);
            this.nGQ.bG(f4);
        } else if (i4) {
            this.nGQ.setValue(this.nGO);
        }
        if (this.nGR == null) {
            this.nGR = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (i4 && f > 0.0f) {
            dLj();
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
                return new p(this.nGQ);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.nGR);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.nGR);
            case 6:
                return new o(this.nGQ);
            case 7:
                q qVar = new q();
                this.nGT.k(qVar);
                return qVar;
        }
    }

    public boolean i(float f, float f2, float f3) {
        if (this.nGL == ((int) f) && this.nGM == ((int) f2) && this.nGN == f3) {
            return false;
        }
        this.nGO = 10000.0f * ((f3 * f) / 682.0f);
        this.nGO = Math.min(9000L, this.nGO);
        this.nGO = Math.max(4000L, this.nGO);
        this.nGL = (int) f;
        this.nGM = (int) f2;
        this.nGN = f3;
        return true;
    }

    private void F(final float f, final float f2) {
        this.nGT.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nFp, qVar.nFq, qVar.iIu, qVar.iIv, qVar.nFr, qVar.nFs, f, f2);
                q.a[] aVarArr = qVar.nFz;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dKX();
                        fArr[i + 1] = aVarArr[i].dKY();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dLj() {
        long j = this.nGQ == null ? 0L : this.nGQ.value;
        long j2 = this.nGR == null ? 0L : this.nGR.value;
        long j3 = this.nGS != null ? this.nGS.value : 0L;
        this.nGP = Math.max(j, j2);
        this.nGP = Math.max(this.nGP, j3);
        this.nGP = Math.max(10000L, this.nGP);
        this.nGP = Math.max(this.nGO, this.nGP);
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
        if (this.nGS == null || (dVar.nEK != null && dVar.nEK.value > this.nGS.value)) {
            this.nGS = dVar.nEK;
            dLj();
        }
    }
}
