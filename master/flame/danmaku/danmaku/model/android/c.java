package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes5.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g ndn;
    public master.flame.danmaku.danmaku.model.g ndo;
    public master.flame.danmaku.danmaku.model.g ndp;
    public m ndr;
    private DanmakuContext nds;
    public int ndi = 0;
    public int ndj = 0;
    private float ndk = 1.0f;
    public long ndl = 10000;
    public long ndm = 4000;
    public l ndq = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dFT() {
        return new c();
    }

    protected c() {
    }

    public void dFU() {
        this.ndr = null;
        this.ndj = 0;
        this.ndi = 0;
        this.ndq.clear();
        this.ndn = null;
        this.ndo = null;
        this.ndp = null;
        this.ndm = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.nds = danmakuContext;
        this.ndr = danmakuContext.dFN();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d Jm(int i) {
        return a(i, this.nds);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.nds = danmakuContext;
        this.ndr = danmakuContext.dFN();
        return a(i, this.ndr.getWidth(), this.ndr.getHeight(), this.ndk, danmakuContext.ncQ);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return a(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.ndi;
        int i3 = this.ndj;
        boolean j = j(f, f2, f3);
        if (this.ndn == null) {
            this.ndn = new master.flame.danmaku.danmaku.model.g(this.ndl);
            this.ndn.aM(f4);
        } else if (j) {
            this.ndn.setValue(this.ndl);
        }
        if (this.ndo == null) {
            this.ndo = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            dFV();
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
                return new p(this.ndn);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.ndo);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.ndo);
            case 6:
                return new o(this.ndn);
            case 7:
                q qVar = new q();
                this.ndq.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.ndi == ((int) f) && this.ndj == ((int) f2) && this.ndk == f3) {
            return false;
        }
        this.ndl = 10000.0f * ((f3 * f) / 682.0f);
        this.ndl = Math.min(9000L, this.ndl);
        this.ndl = Math.max(4000L, this.ndl);
        this.ndi = (int) f;
        this.ndj = (int) f2;
        this.ndk = f3;
        return true;
    }

    private void A(final float f, final float f2) {
        this.ndq.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bF(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.nbM, qVar.nbN, qVar.jvT, qVar.jvU, qVar.nbO, qVar.nbP, f, f2);
                q.a[] aVarArr = qVar.nbW;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dFJ();
                        fArr[i + 1] = aVarArr[i].dFK();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dFV() {
        long j = this.ndn == null ? 0L : this.ndn.value;
        long j2 = this.ndo == null ? 0L : this.ndo.value;
        long j3 = this.ndp != null ? this.ndp.value : 0L;
        this.ndm = Math.max(j, j2);
        this.ndm = Math.max(this.ndm, j3);
        this.ndm = Math.max(10000L, this.ndm);
        this.ndm = Math.max(this.ndl, this.ndm);
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
        if (this.ndp == null || (dVar.nbf != null && dVar.nbf.value > this.ndp.value)) {
            this.ndp = dVar.nbf;
            dFV();
        }
    }
}
