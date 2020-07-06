package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes5.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g nVo;
    public master.flame.danmaku.danmaku.model.g nVp;
    public master.flame.danmaku.danmaku.model.g nVq;
    public m nVs;
    private DanmakuContext nVt;
    public int nVj = 0;
    public int nVk = 0;
    private float nVl = 1.0f;
    public long nVm = 10000;
    public long nVn = 4000;
    public l nVr = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dSM() {
        return new c();
    }

    protected c() {
    }

    public void dSN() {
        this.nVs = null;
        this.nVk = 0;
        this.nVj = 0;
        this.nVr.clear();
        this.nVo = null;
        this.nVp = null;
        this.nVq = null;
        this.nVn = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nVt = danmakuContext;
        this.nVs = danmakuContext.dSG();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d Lg(int i) {
        return a(i, this.nVt);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nVt = danmakuContext;
        this.nVs = danmakuContext.dSG();
        return a(i, this.nVs.getWidth(), this.nVs.getHeight(), this.nVl, danmakuContext.nUR);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return a(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.nVj;
        int i3 = this.nVk;
        boolean j = j(f, f2, f3);
        if (this.nVo == null) {
            this.nVo = new master.flame.danmaku.danmaku.model.g(this.nVm);
            this.nVo.aR(f4);
        } else if (j) {
            this.nVo.setValue(this.nVm);
        }
        if (this.nVp == null) {
            this.nVp = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            dSO();
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
                return new p(this.nVo);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.nVp);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.nVp);
            case 6:
                return new o(this.nVo);
            case 7:
                q qVar = new q();
                this.nVr.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.nVj == ((int) f) && this.nVk == ((int) f2) && this.nVl == f3) {
            return false;
        }
        this.nVm = 10000.0f * ((f3 * f) / 682.0f);
        this.nVm = Math.min(9000L, this.nVm);
        this.nVm = Math.max(4000L, this.nVm);
        this.nVj = (int) f;
        this.nVk = (int) f2;
        this.nVl = f3;
        return true;
    }

    private void A(final float f, final float f2) {
        this.nVr.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nTN, qVar.nTO, qVar.khX, qVar.khY, qVar.nTP, qVar.nTQ, f, f2);
                q.a[] aVarArr = qVar.nTX;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dSC();
                        fArr[i + 1] = aVarArr[i].dSD();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dSO() {
        long j = this.nVo == null ? 0L : this.nVo.value;
        long j2 = this.nVp == null ? 0L : this.nVp.value;
        long j3 = this.nVq != null ? this.nVq.value : 0L;
        this.nVn = Math.max(j, j2);
        this.nVn = Math.max(this.nVn, j3);
        this.nVn = Math.max(10000L, this.nVn);
        this.nVn = Math.max(this.nVm, this.nVn);
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
        if (this.nVq == null || (dVar.nTh != null && dVar.nTh.value > this.nVq.value)) {
            this.nVq = dVar.nTh;
            dSO();
        }
    }
}
