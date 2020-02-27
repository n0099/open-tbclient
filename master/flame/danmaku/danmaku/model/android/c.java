package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes5.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g nHH;
    public master.flame.danmaku.danmaku.model.g nHI;
    public master.flame.danmaku.danmaku.model.g nHJ;
    public m nHL;
    private DanmakuContext nHM;
    public int nHC = 0;
    public int nHD = 0;
    private float nHE = 1.0f;
    public long nHF = 10000;
    public long nHG = 4000;
    public l nHK = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dMu() {
        return new c();
    }

    protected c() {
    }

    public void dMv() {
        this.nHL = null;
        this.nHD = 0;
        this.nHC = 0;
        this.nHK.clear();
        this.nHH = null;
        this.nHI = null;
        this.nHJ = null;
        this.nHG = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nHM = danmakuContext;
        this.nHL = danmakuContext.dMo();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d NM(int i) {
        return a(i, this.nHM);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nHM = danmakuContext;
        this.nHL = danmakuContext.dMo();
        return a(i, this.nHL.getWidth(), this.nHL.getHeight(), this.nHE, danmakuContext.nHk);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.nHC;
        int i3 = this.nHD;
        boolean i4 = i(f, f2, f3);
        if (this.nHH == null) {
            this.nHH = new master.flame.danmaku.danmaku.model.g(this.nHF);
            this.nHH.bF(f4);
        } else if (i4) {
            this.nHH.setValue(this.nHF);
        }
        if (this.nHI == null) {
            this.nHI = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (i4 && f > 0.0f) {
            dMw();
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
                return new p(this.nHH);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.nHI);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.nHI);
            case 6:
                return new o(this.nHH);
            case 7:
                q qVar = new q();
                this.nHK.k(qVar);
                return qVar;
        }
    }

    public boolean i(float f, float f2, float f3) {
        if (this.nHC == ((int) f) && this.nHD == ((int) f2) && this.nHE == f3) {
            return false;
        }
        this.nHF = 10000.0f * ((f3 * f) / 682.0f);
        this.nHF = Math.min(9000L, this.nHF);
        this.nHF = Math.max(4000L, this.nHF);
        this.nHC = (int) f;
        this.nHD = (int) f2;
        this.nHE = f3;
        return true;
    }

    private void F(final float f, final float f2) {
        this.nHK.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nGh, qVar.nGi, qVar.iJR, qVar.iJS, qVar.nGj, qVar.nGk, f, f2);
                q.a[] aVarArr = qVar.nGr;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dMk();
                        fArr[i + 1] = aVarArr[i].dMl();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dMw() {
        long j = this.nHH == null ? 0L : this.nHH.value;
        long j2 = this.nHI == null ? 0L : this.nHI.value;
        long j3 = this.nHJ != null ? this.nHJ.value : 0L;
        this.nHG = Math.max(j, j2);
        this.nHG = Math.max(this.nHG, j3);
        this.nHG = Math.max(10000L, this.nHG);
        this.nHG = Math.max(this.nHF, this.nHG);
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
        if (this.nHJ == null || (dVar.nFC != null && dVar.nFC.value > this.nHJ.value)) {
            this.nHJ = dVar.nFC;
            dMw();
        }
    }
}
