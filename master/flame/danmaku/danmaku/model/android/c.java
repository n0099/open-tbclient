package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes4.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g nGL;
    public master.flame.danmaku.danmaku.model.g nGM;
    public master.flame.danmaku.danmaku.model.g nGN;
    public m nGP;
    private DanmakuContext nGQ;
    public int nGG = 0;
    public int nGH = 0;
    private float nGI = 1.0f;
    public long nGJ = 10000;
    public long nGK = 4000;
    public l nGO = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dLf() {
        return new c();
    }

    protected c() {
    }

    public void dLg() {
        this.nGP = null;
        this.nGH = 0;
        this.nGG = 0;
        this.nGO.clear();
        this.nGL = null;
        this.nGM = null;
        this.nGN = null;
        this.nGK = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nGQ = danmakuContext;
        this.nGP = danmakuContext.dKZ();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d NJ(int i) {
        return a(i, this.nGQ);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nGQ = danmakuContext;
        this.nGP = danmakuContext.dKZ();
        return a(i, this.nGP.getWidth(), this.nGP.getHeight(), this.nGI, danmakuContext.nGo);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.nGG;
        int i3 = this.nGH;
        boolean i4 = i(f, f2, f3);
        if (this.nGL == null) {
            this.nGL = new master.flame.danmaku.danmaku.model.g(this.nGJ);
            this.nGL.bG(f4);
        } else if (i4) {
            this.nGL.setValue(this.nGJ);
        }
        if (this.nGM == null) {
            this.nGM = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (i4 && f > 0.0f) {
            dLh();
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
                return new p(this.nGL);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.nGM);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.nGM);
            case 6:
                return new o(this.nGL);
            case 7:
                q qVar = new q();
                this.nGO.k(qVar);
                return qVar;
        }
    }

    public boolean i(float f, float f2, float f3) {
        if (this.nGG == ((int) f) && this.nGH == ((int) f2) && this.nGI == f3) {
            return false;
        }
        this.nGJ = 10000.0f * ((f3 * f) / 682.0f);
        this.nGJ = Math.min(9000L, this.nGJ);
        this.nGJ = Math.max(4000L, this.nGJ);
        this.nGG = (int) f;
        this.nGH = (int) f2;
        this.nGI = f3;
        return true;
    }

    private void F(final float f, final float f2) {
        this.nGO.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bU(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nFk, qVar.nFl, qVar.iIu, qVar.iIv, qVar.nFm, qVar.nFn, f, f2);
                q.a[] aVarArr = qVar.nFu;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dKV();
                        fArr[i + 1] = aVarArr[i].dKW();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dLh() {
        long j = this.nGL == null ? 0L : this.nGL.value;
        long j2 = this.nGM == null ? 0L : this.nGM.value;
        long j3 = this.nGN != null ? this.nGN.value : 0L;
        this.nGK = Math.max(j, j2);
        this.nGK = Math.max(this.nGK, j3);
        this.nGK = Math.max(10000L, this.nGK);
        this.nGK = Math.max(this.nGJ, this.nGK);
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
        if (this.nGN == null || (dVar.nEF != null && dVar.nEF.value > this.nGN.value)) {
            this.nGN = dVar.nEF;
            dLh();
        }
    }
}
