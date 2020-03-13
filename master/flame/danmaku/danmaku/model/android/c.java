package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes5.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g nHU;
    public master.flame.danmaku.danmaku.model.g nHV;
    public master.flame.danmaku.danmaku.model.g nHW;
    public m nHY;
    private DanmakuContext nHZ;
    public int nHP = 0;
    public int nHQ = 0;
    private float nHR = 1.0f;
    public long nHS = 10000;
    public long nHT = 4000;
    public l nHX = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dMx() {
        return new c();
    }

    protected c() {
    }

    public void dMy() {
        this.nHY = null;
        this.nHQ = 0;
        this.nHP = 0;
        this.nHX.clear();
        this.nHU = null;
        this.nHV = null;
        this.nHW = null;
        this.nHT = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nHZ = danmakuContext;
        this.nHY = danmakuContext.dMr();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d NM(int i) {
        return a(i, this.nHZ);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nHZ = danmakuContext;
        this.nHY = danmakuContext.dMr();
        return a(i, this.nHY.getWidth(), this.nHY.getHeight(), this.nHR, danmakuContext.nHx);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.nHP;
        int i3 = this.nHQ;
        boolean i4 = i(f, f2, f3);
        if (this.nHU == null) {
            this.nHU = new master.flame.danmaku.danmaku.model.g(this.nHS);
            this.nHU.bF(f4);
        } else if (i4) {
            this.nHU.setValue(this.nHS);
        }
        if (this.nHV == null) {
            this.nHV = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (i4 && f > 0.0f) {
            dMz();
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
                return new p(this.nHU);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.nHV);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.nHV);
            case 6:
                return new o(this.nHU);
            case 7:
                q qVar = new q();
                this.nHX.k(qVar);
                return qVar;
        }
    }

    public boolean i(float f, float f2, float f3) {
        if (this.nHP == ((int) f) && this.nHQ == ((int) f2) && this.nHR == f3) {
            return false;
        }
        this.nHS = 10000.0f * ((f3 * f) / 682.0f);
        this.nHS = Math.min(9000L, this.nHS);
        this.nHS = Math.max(4000L, this.nHS);
        this.nHP = (int) f;
        this.nHQ = (int) f2;
        this.nHR = f3;
        return true;
    }

    private void F(final float f, final float f2) {
        this.nHX.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bV(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nGu, qVar.nGv, qVar.iKf, qVar.iKg, qVar.nGw, qVar.nGx, f, f2);
                q.a[] aVarArr = qVar.nGE;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dMn();
                        fArr[i + 1] = aVarArr[i].dMo();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dMz() {
        long j = this.nHU == null ? 0L : this.nHU.value;
        long j2 = this.nHV == null ? 0L : this.nHV.value;
        long j3 = this.nHW != null ? this.nHW.value : 0L;
        this.nHT = Math.max(j, j2);
        this.nHT = Math.max(this.nHT, j3);
        this.nHT = Math.max(10000L, this.nHT);
        this.nHT = Math.max(this.nHS, this.nHT);
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
        if (this.nHW == null || (dVar.nFP != null && dVar.nFP.value > this.nHW.value)) {
            this.nHW = dVar.nFP;
            dMz();
        }
    }
}
