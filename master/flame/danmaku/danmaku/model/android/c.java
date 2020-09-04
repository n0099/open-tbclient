package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes6.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g oyp;
    public master.flame.danmaku.danmaku.model.g oyq;
    public master.flame.danmaku.danmaku.model.g oyr;
    public m oyt;
    private DanmakuContext oyu;
    public int oyk = 0;
    public int oyl = 0;
    private float oym = 1.0f;
    public long oyn = 10000;
    public long oyo = 4000;
    public l oys = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c eiv() {
        return new c();
    }

    protected c() {
    }

    public void eiw() {
        this.oyt = null;
        this.oyl = 0;
        this.oyk = 0;
        this.oys.clear();
        this.oyp = null;
        this.oyq = null;
        this.oyr = null;
        this.oyo = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.oyu = danmakuContext;
        this.oyt = danmakuContext.eip();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d Od(int i) {
        return a(i, this.oyu);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.oyu = danmakuContext;
        this.oyt = danmakuContext.eip();
        return a(i, this.oyt.getWidth(), this.oyt.getHeight(), this.oym, danmakuContext.oxS);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return a(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.oyk;
        int i3 = this.oyl;
        boolean j = j(f, f2, f3);
        if (this.oyp == null) {
            this.oyp = new master.flame.danmaku.danmaku.model.g(this.oyn);
            this.oyp.aW(f4);
        } else if (j) {
            this.oyp.setValue(this.oyn);
        }
        if (this.oyq == null) {
            this.oyq = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            eix();
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
                return new p(this.oyp);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.oyq);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.oyq);
            case 6:
                return new o(this.oyp);
            case 7:
                q qVar = new q();
                this.oys.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.oyk == ((int) f) && this.oyl == ((int) f2) && this.oym == f3) {
            return false;
        }
        this.oyn = 10000.0f * ((f3 * f) / 682.0f);
        this.oyn = Math.min(9000L, this.oyn);
        this.oyn = Math.max(4000L, this.oyn);
        this.oyk = (int) f;
        this.oyl = (int) f2;
        this.oym = f3;
        return true;
    }

    private void E(final float f, final float f2) {
        this.oys.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bO(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.owO, qVar.owP, qVar.kGt, qVar.kGu, qVar.owQ, qVar.owR, f, f2);
                q.a[] aVarArr = qVar.owY;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].eil();
                        fArr[i + 1] = aVarArr[i].eim();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void eix() {
        long j = this.oyp == null ? 0L : this.oyp.value;
        long j2 = this.oyq == null ? 0L : this.oyq.value;
        long j3 = this.oyr != null ? this.oyr.value : 0L;
        this.oyo = Math.max(j, j2);
        this.oyo = Math.max(this.oyo, j3);
        this.oyo = Math.max(10000L, this.oyo);
        this.oyo = Math.max(this.oyn, this.oyo);
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
        if (this.oyr == null || (dVar.owi != null && dVar.owi.value > this.oyr.value)) {
            this.oyr = dVar.owi;
            eix();
        }
    }
}
