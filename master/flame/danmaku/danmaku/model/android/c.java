package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes5.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g ndk;
    public master.flame.danmaku.danmaku.model.g ndl;
    public master.flame.danmaku.danmaku.model.g ndm;
    public m ndo;
    private DanmakuContext ndp;
    public int ndf = 0;
    public int ndg = 0;
    private float ndh = 1.0f;
    public long ndi = 10000;
    public long ndj = 4000;
    public l ndn = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dFX() {
        return new c();
    }

    protected c() {
    }

    public void dFY() {
        this.ndo = null;
        this.ndg = 0;
        this.ndf = 0;
        this.ndn.clear();
        this.ndk = null;
        this.ndl = null;
        this.ndm = null;
        this.ndj = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.ndp = danmakuContext;
        this.ndo = danmakuContext.dFR();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d Jm(int i) {
        return a(i, this.ndp);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.ndp = danmakuContext;
        this.ndo = danmakuContext.dFR();
        return a(i, this.ndo.getWidth(), this.ndo.getHeight(), this.ndh, danmakuContext.ncN);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return a(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.ndf;
        int i3 = this.ndg;
        boolean j = j(f, f2, f3);
        if (this.ndk == null) {
            this.ndk = new master.flame.danmaku.danmaku.model.g(this.ndi);
            this.ndk.aM(f4);
        } else if (j) {
            this.ndk.setValue(this.ndi);
        }
        if (this.ndl == null) {
            this.ndl = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            dFZ();
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
                return new p(this.ndk);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.ndl);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.ndl);
            case 6:
                return new o(this.ndk);
            case 7:
                q qVar = new q();
                this.ndn.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.ndf == ((int) f) && this.ndg == ((int) f2) && this.ndh == f3) {
            return false;
        }
        this.ndi = 10000.0f * ((f3 * f) / 682.0f);
        this.ndi = Math.min(9000L, this.ndi);
        this.ndi = Math.max(4000L, this.ndi);
        this.ndf = (int) f;
        this.ndg = (int) f2;
        this.ndh = f3;
        return true;
    }

    private void A(final float f, final float f2) {
        this.ndn.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bE(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nbJ, qVar.nbK, qVar.jvP, qVar.jvQ, qVar.nbL, qVar.nbM, f, f2);
                q.a[] aVarArr = qVar.nbT;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dFN();
                        fArr[i + 1] = aVarArr[i].dFO();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dFZ() {
        long j = this.ndk == null ? 0L : this.ndk.value;
        long j2 = this.ndl == null ? 0L : this.ndl.value;
        long j3 = this.ndm != null ? this.ndm.value : 0L;
        this.ndj = Math.max(j, j2);
        this.ndj = Math.max(this.ndj, j3);
        this.ndj = Math.max(10000L, this.ndj);
        this.ndj = Math.max(this.ndi, this.ndj);
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
        if (this.ndm == null || (dVar.nbc != null && dVar.nbc.value > this.ndm.value)) {
            this.ndm = dVar.nbc;
            dFZ();
        }
    }
}
