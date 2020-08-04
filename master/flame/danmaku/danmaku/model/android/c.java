package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes6.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g oea;
    public master.flame.danmaku.danmaku.model.g oeb;
    public master.flame.danmaku.danmaku.model.g oec;
    public m oee;
    private DanmakuContext oef;
    public int odV = 0;
    public int odW = 0;
    private float odX = 1.0f;
    public long odY = 10000;
    public long odZ = 4000;
    public l oed = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dWj() {
        return new c();
    }

    protected c() {
    }

    public void dWk() {
        this.oee = null;
        this.odW = 0;
        this.odV = 0;
        this.oed.clear();
        this.oea = null;
        this.oeb = null;
        this.oec = null;
        this.odZ = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.oef = danmakuContext;
        this.oee = danmakuContext.dWd();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d LA(int i) {
        return a(i, this.oef);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.oef = danmakuContext;
        this.oee = danmakuContext.dWd();
        return a(i, this.oee.getWidth(), this.oee.getHeight(), this.odX, danmakuContext.odD);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return a(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.odV;
        int i3 = this.odW;
        boolean j = j(f, f2, f3);
        if (this.oea == null) {
            this.oea = new master.flame.danmaku.danmaku.model.g(this.odY);
            this.oea.aQ(f4);
        } else if (j) {
            this.oea.setValue(this.odY);
        }
        if (this.oeb == null) {
            this.oeb = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            dWl();
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
                return new p(this.oea);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.oeb);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.oeb);
            case 6:
                return new o(this.oea);
            case 7:
                q qVar = new q();
                this.oed.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.odV == ((int) f) && this.odW == ((int) f2) && this.odX == f3) {
            return false;
        }
        this.odY = 10000.0f * ((f3 * f) / 682.0f);
        this.odY = Math.min(9000L, this.odY);
        this.odY = Math.max(4000L, this.odY);
        this.odV = (int) f;
        this.odW = (int) f2;
        this.odX = f3;
        return true;
    }

    private void A(final float f, final float f2) {
        this.oed.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.ocz, qVar.ocA, qVar.kqU, qVar.kqV, qVar.ocB, qVar.ocC, f, f2);
                q.a[] aVarArr = qVar.ocJ;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dVZ();
                        fArr[i + 1] = aVarArr[i].dWa();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dWl() {
        long j = this.oea == null ? 0L : this.oea.value;
        long j2 = this.oeb == null ? 0L : this.oeb.value;
        long j3 = this.oec != null ? this.oec.value : 0L;
        this.odZ = Math.max(j, j2);
        this.odZ = Math.max(this.odZ, j3);
        this.odZ = Math.max(10000L, this.odZ);
        this.odZ = Math.max(this.odY, this.odZ);
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
        if (this.oec == null || (dVar.obS != null && dVar.obS.value > this.oec.value)) {
            this.oec = dVar.obS;
            dWl();
        }
    }
}
