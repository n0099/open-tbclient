package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes6.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g oxX;
    public master.flame.danmaku.danmaku.model.g oxY;
    public master.flame.danmaku.danmaku.model.g oxZ;
    public m oyb;
    private DanmakuContext oyc;
    public int oxS = 0;
    public int oxT = 0;
    private float oxU = 1.0f;
    public long oxV = 10000;
    public long oxW = 4000;
    public l oya = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c eim() {
        return new c();
    }

    protected c() {
    }

    public void ein() {
        this.oyb = null;
        this.oxT = 0;
        this.oxS = 0;
        this.oya.clear();
        this.oxX = null;
        this.oxY = null;
        this.oxZ = null;
        this.oxW = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.oyc = danmakuContext;
        this.oyb = danmakuContext.eig();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d Od(int i) {
        return a(i, this.oyc);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.oyc = danmakuContext;
        this.oyb = danmakuContext.eig();
        return a(i, this.oyb.getWidth(), this.oyb.getHeight(), this.oxU, danmakuContext.oxA);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return a(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.oxS;
        int i3 = this.oxT;
        boolean j = j(f, f2, f3);
        if (this.oxX == null) {
            this.oxX = new master.flame.danmaku.danmaku.model.g(this.oxV);
            this.oxX.aW(f4);
        } else if (j) {
            this.oxX.setValue(this.oxV);
        }
        if (this.oxY == null) {
            this.oxY = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            eio();
            if (i2 <= 0 || i3 <= 0) {
                f5 = 1.0f;
            } else {
                f5 = f / i2;
                f6 = f2 / i3;
            }
            if (f2 > 0.0f) {
                E(f5, f6);
            }
        }
        switch (i) {
            case 1:
                return new p(this.oxX);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.oxY);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.oxY);
            case 6:
                return new o(this.oxX);
            case 7:
                q qVar = new q();
                this.oya.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.oxS == ((int) f) && this.oxT == ((int) f2) && this.oxU == f3) {
            return false;
        }
        this.oxV = 10000.0f * ((f3 * f) / 682.0f);
        this.oxV = Math.min(9000L, this.oxV);
        this.oxV = Math.max(4000L, this.oxV);
        this.oxS = (int) f;
        this.oxT = (int) f2;
        this.oxU = f3;
        return true;
    }

    private void E(final float f, final float f2) {
        this.oya.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.oww, qVar.owx, qVar.kGm, qVar.kGn, qVar.owy, qVar.owz, f, f2);
                q.a[] aVarArr = qVar.owG;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].eic();
                        fArr[i + 1] = aVarArr[i].eid();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void eio() {
        long j = this.oxX == null ? 0L : this.oxX.value;
        long j2 = this.oxY == null ? 0L : this.oxY.value;
        long j3 = this.oxZ != null ? this.oxZ.value : 0L;
        this.oxW = Math.max(j, j2);
        this.oxW = Math.max(this.oxW, j3);
        this.oxW = Math.max(10000L, this.oxW);
        this.oxW = Math.max(this.oxV, this.oxW);
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
        if (this.oxZ == null || (dVar.ovQ != null && dVar.ovQ.value > this.oxZ.value)) {
            this.oxZ = dVar.ovQ;
            eio();
        }
    }
}
