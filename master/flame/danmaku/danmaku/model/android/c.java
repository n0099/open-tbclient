package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes6.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g oXj;
    public master.flame.danmaku.danmaku.model.g oXk;
    public master.flame.danmaku.danmaku.model.g oXl;
    public m oXn;
    private DanmakuContext oXo;
    public int oXe = 0;
    public int oXf = 0;
    private float oXg = 1.0f;
    public long oXh = 10000;
    public long oXi = 4000;
    public l oXm = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c eqf() {
        return new c();
    }

    protected c() {
    }

    public void eqg() {
        this.oXn = null;
        this.oXf = 0;
        this.oXe = 0;
        this.oXm.clear();
        this.oXj = null;
        this.oXk = null;
        this.oXl = null;
        this.oXi = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.oXo = danmakuContext;
        this.oXn = danmakuContext.epZ();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d Po(int i) {
        return a(i, this.oXo);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.oXo = danmakuContext;
        this.oXn = danmakuContext.epZ();
        return a(i, this.oXn.getWidth(), this.oXn.getHeight(), this.oXg, danmakuContext.oWM);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.oXe;
        int i3 = this.oXf;
        boolean j = j(f, f2, f3);
        if (this.oXj == null) {
            this.oXj = new master.flame.danmaku.danmaku.model.g(this.oXh);
            this.oXj.bc(f4);
        } else if (j) {
            this.oXj.setValue(this.oXh);
        }
        if (this.oXk == null) {
            this.oXk = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            eqh();
            if (i2 <= 0 || i3 <= 0) {
                f5 = 1.0f;
            } else {
                f5 = f / i2;
                f6 = f2 / i3;
            }
            if (f2 > 0.0f) {
                G(f5, f6);
            }
        }
        switch (i) {
            case 1:
                return new p(this.oXj);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.oXk);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.oXk);
            case 6:
                return new o(this.oXj);
            case 7:
                q qVar = new q();
                this.oXm.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.oXe == ((int) f) && this.oXf == ((int) f2) && this.oXg == f3) {
            return false;
        }
        this.oXh = 10000.0f * ((f3 * f) / 682.0f);
        this.oXh = Math.min(9000L, this.oXh);
        this.oXh = Math.max(4000L, this.oXh);
        this.oXe = (int) f;
        this.oXf = (int) f2;
        this.oXg = f3;
        return true;
    }

    private void G(final float f, final float f2) {
        this.oXm.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bT(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.oVI, qVar.oVJ, qVar.lee, qVar.lef, qVar.oVK, qVar.oVL, f, f2);
                q.a[] aVarArr = qVar.oVS;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].epV();
                        fArr[i + 1] = aVarArr[i].epW();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void eqh() {
        long j = this.oXj == null ? 0L : this.oXj.value;
        long j2 = this.oXk == null ? 0L : this.oXk.value;
        long j3 = this.oXl != null ? this.oXl.value : 0L;
        this.oXi = Math.max(j, j2);
        this.oXi = Math.max(this.oXi, j3);
        this.oXi = Math.max(10000L, this.oXi);
        this.oXi = Math.max(this.oXh, this.oXi);
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
        if (this.oXl == null || (dVar.oVd != null && dVar.oVd.value > this.oXl.value)) {
            this.oXl = dVar.oVd;
            eqh();
        }
    }
}
