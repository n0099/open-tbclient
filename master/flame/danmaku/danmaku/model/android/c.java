package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes5.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g nVl;
    public master.flame.danmaku.danmaku.model.g nVm;
    public master.flame.danmaku.danmaku.model.g nVn;
    public m nVp;
    private DanmakuContext nVq;
    public int nVg = 0;
    public int nVh = 0;
    private float nVi = 1.0f;
    public long nVj = 10000;
    public long nVk = 4000;
    public l nVo = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dSI() {
        return new c();
    }

    protected c() {
    }

    public void dSJ() {
        this.nVp = null;
        this.nVh = 0;
        this.nVg = 0;
        this.nVo.clear();
        this.nVl = null;
        this.nVm = null;
        this.nVn = null;
        this.nVk = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nVq = danmakuContext;
        this.nVp = danmakuContext.dSC();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d Lg(int i) {
        return a(i, this.nVq);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nVq = danmakuContext;
        this.nVp = danmakuContext.dSC();
        return a(i, this.nVp.getWidth(), this.nVp.getHeight(), this.nVi, danmakuContext.nUO);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return a(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.nVg;
        int i3 = this.nVh;
        boolean j = j(f, f2, f3);
        if (this.nVl == null) {
            this.nVl = new master.flame.danmaku.danmaku.model.g(this.nVj);
            this.nVl.aR(f4);
        } else if (j) {
            this.nVl.setValue(this.nVj);
        }
        if (this.nVm == null) {
            this.nVm = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            dSK();
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
                return new p(this.nVl);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.nVm);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.nVm);
            case 6:
                return new o(this.nVl);
            case 7:
                q qVar = new q();
                this.nVo.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.nVg == ((int) f) && this.nVh == ((int) f2) && this.nVi == f3) {
            return false;
        }
        this.nVj = 10000.0f * ((f3 * f) / 682.0f);
        this.nVj = Math.min(9000L, this.nVj);
        this.nVj = Math.max(4000L, this.nVj);
        this.nVg = (int) f;
        this.nVh = (int) f2;
        this.nVi = f3;
        return true;
    }

    private void A(final float f, final float f2) {
        this.nVo.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nTK, qVar.nTL, qVar.khX, qVar.khY, qVar.nTM, qVar.nTN, f, f2);
                q.a[] aVarArr = qVar.nTU;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dSy();
                        fArr[i + 1] = aVarArr[i].dSz();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dSK() {
        long j = this.nVl == null ? 0L : this.nVl.value;
        long j2 = this.nVm == null ? 0L : this.nVm.value;
        long j3 = this.nVn != null ? this.nVn.value : 0L;
        this.nVk = Math.max(j, j2);
        this.nVk = Math.max(this.nVk, j3);
        this.nVk = Math.max(10000L, this.nVk);
        this.nVk = Math.max(this.nVj, this.nVk);
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
        if (this.nVn == null || (dVar.nTe != null && dVar.nTe.value > this.nVn.value)) {
            this.nVn = dVar.nTe;
            dSK();
        }
    }
}
