package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes6.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g pXZ;
    public master.flame.danmaku.danmaku.model.g pYa;
    public master.flame.danmaku.danmaku.model.g pYb;
    public m pYd;
    private DanmakuContext pYe;
    public int pXU = 0;
    public int pXV = 0;
    private float pXW = 1.0f;
    public long pXX = 10000;
    public long pXY = 4000;
    public l pYc = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c eDS() {
        return new c();
    }

    protected c() {
    }

    public void eDT() {
        this.pYd = null;
        this.pXV = 0;
        this.pXU = 0;
        this.pYc.clear();
        this.pXZ = null;
        this.pYa = null;
        this.pYb = null;
        this.pXY = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.pYe = danmakuContext;
        this.pYd = danmakuContext.eDM();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d RA(int i) {
        return a(i, this.pYe);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.pYe = danmakuContext;
        this.pYd = danmakuContext.eDM();
        return a(i, this.pYd.getWidth(), this.pYd.getHeight(), this.pXW, danmakuContext.pXC);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.pXU;
        int i3 = this.pXV;
        boolean l = l(f, f2, f3);
        if (this.pXZ == null) {
            this.pXZ = new master.flame.danmaku.danmaku.model.g(this.pXX);
            this.pXZ.bv(f4);
        } else if (l) {
            this.pXZ.setValue(this.pXX);
        }
        if (this.pYa == null) {
            this.pYa = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (l && f > 0.0f) {
            eDU();
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
                return new p(this.pXZ);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.pYa);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.pYa);
            case 6:
                return new o(this.pXZ);
            case 7:
                q qVar = new q();
                this.pYc.k(qVar);
                return qVar;
        }
    }

    public boolean l(float f, float f2, float f3) {
        if (this.pXU == ((int) f) && this.pXV == ((int) f2) && this.pXW == f3) {
            return false;
        }
        this.pXX = 10000.0f * ((f3 * f) / 682.0f);
        this.pXX = Math.min(9000L, this.pXX);
        this.pXX = Math.max(4000L, this.pXX);
        this.pXU = (int) f;
        this.pXV = (int) f2;
        this.pXW = f3;
        return true;
    }

    private void J(final float f, final float f2) {
        this.pYc.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bX(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.pWy, qVar.pWz, qVar.lwE, qVar.lwF, qVar.pWA, qVar.pWB, f, f2);
                q.a[] aVarArr = qVar.pWI;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].eDI();
                        fArr[i + 1] = aVarArr[i].eDJ();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void eDU() {
        long j = this.pXZ == null ? 0L : this.pXZ.value;
        long j2 = this.pYa == null ? 0L : this.pYa.value;
        long j3 = this.pYb != null ? this.pYb.value : 0L;
        this.pXY = Math.max(j, j2);
        this.pXY = Math.max(this.pXY, j3);
        this.pXY = Math.max(10000L, this.pXY);
        this.pXY = Math.max(this.pXX, this.pXY);
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
        if (this.pYb == null || (dVar.pVT != null && dVar.pVT.value > this.pYb.value)) {
            this.pYb = dVar.pVT;
            eDU();
        }
    }
}
