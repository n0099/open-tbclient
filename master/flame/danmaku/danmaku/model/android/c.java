package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes5.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g nzA;
    public master.flame.danmaku.danmaku.model.g nzB;
    public master.flame.danmaku.danmaku.model.g nzC;
    public m nzE;
    private DanmakuContext nzF;
    public int nzv = 0;
    public int nzw = 0;
    private float nzx = 1.0f;
    public long nzy = 10000;
    public long nzz = 4000;
    public l nzD = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dOc() {
        return new c();
    }

    protected c() {
    }

    public void dOd() {
        this.nzE = null;
        this.nzw = 0;
        this.nzv = 0;
        this.nzD.clear();
        this.nzA = null;
        this.nzB = null;
        this.nzC = null;
        this.nzz = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nzF = danmakuContext;
        this.nzE = danmakuContext.dNW();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d JZ(int i) {
        return a(i, this.nzF);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nzF = danmakuContext;
        this.nzE = danmakuContext.dNW();
        return a(i, this.nzE.getWidth(), this.nzE.getHeight(), this.nzx, danmakuContext.nzd);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return a(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.nzv;
        int i3 = this.nzw;
        boolean j = j(f, f2, f3);
        if (this.nzA == null) {
            this.nzA = new master.flame.danmaku.danmaku.model.g(this.nzy);
            this.nzA.aL(f4);
        } else if (j) {
            this.nzA.setValue(this.nzy);
        }
        if (this.nzB == null) {
            this.nzB = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            dOe();
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
                return new p(this.nzA);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.nzB);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.nzB);
            case 6:
                return new o(this.nzA);
            case 7:
                q qVar = new q();
                this.nzD.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.nzv == ((int) f) && this.nzw == ((int) f2) && this.nzx == f3) {
            return false;
        }
        this.nzy = 10000.0f * ((f3 * f) / 682.0f);
        this.nzy = Math.min(9000L, this.nzy);
        this.nzy = Math.max(4000L, this.nzy);
        this.nzv = (int) f;
        this.nzw = (int) f2;
        this.nzx = f3;
        return true;
    }

    private void A(final float f, final float f2) {
        this.nzD.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bL(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nxZ, qVar.nya, qVar.jOk, qVar.jOl, qVar.nyb, qVar.nyc, f, f2);
                q.a[] aVarArr = qVar.nyj;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dNS();
                        fArr[i + 1] = aVarArr[i].dNT();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dOe() {
        long j = this.nzA == null ? 0L : this.nzA.value;
        long j2 = this.nzB == null ? 0L : this.nzB.value;
        long j3 = this.nzC != null ? this.nzC.value : 0L;
        this.nzz = Math.max(j, j2);
        this.nzz = Math.max(this.nzz, j3);
        this.nzz = Math.max(10000L, this.nzz);
        this.nzz = Math.max(this.nzy, this.nzz);
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
        if (this.nzC == null || (dVar.nxs != null && dVar.nxs.value > this.nzC.value)) {
            this.nzC = dVar.nxs;
            dOe();
        }
    }
}
