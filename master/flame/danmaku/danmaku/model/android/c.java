package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes6.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g odY;
    public master.flame.danmaku.danmaku.model.g odZ;
    public master.flame.danmaku.danmaku.model.g oea;
    public m oec;
    private DanmakuContext oed;
    public int odT = 0;
    public int odU = 0;
    private float odV = 1.0f;
    public long odW = 10000;
    public long odX = 4000;
    public l oeb = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c dWi() {
        return new c();
    }

    protected c() {
    }

    public void dWj() {
        this.oec = null;
        this.odU = 0;
        this.odT = 0;
        this.oeb.clear();
        this.odY = null;
        this.odZ = null;
        this.oea = null;
        this.odX = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.oed = danmakuContext;
        this.oec = danmakuContext.dWc();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d LA(int i) {
        return a(i, this.oed);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.oed = danmakuContext;
        this.oec = danmakuContext.dWc();
        return a(i, this.oec.getWidth(), this.oec.getHeight(), this.odV, danmakuContext.odB);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return a(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.odT;
        int i3 = this.odU;
        boolean j = j(f, f2, f3);
        if (this.odY == null) {
            this.odY = new master.flame.danmaku.danmaku.model.g(this.odW);
            this.odY.aQ(f4);
        } else if (j) {
            this.odY.setValue(this.odW);
        }
        if (this.odZ == null) {
            this.odZ = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            dWk();
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
                return new p(this.odY);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.odZ);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.odZ);
            case 6:
                return new o(this.odY);
            case 7:
                q qVar = new q();
                this.oeb.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.odT == ((int) f) && this.odU == ((int) f2) && this.odV == f3) {
            return false;
        }
        this.odW = 10000.0f * ((f3 * f) / 682.0f);
        this.odW = Math.min(9000L, this.odW);
        this.odW = Math.max(4000L, this.odW);
        this.odT = (int) f;
        this.odU = (int) f2;
        this.odV = f3;
        return true;
    }

    private void A(final float f, final float f2) {
        this.oeb.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bM(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.ocx, qVar.ocy, qVar.kqS, qVar.kqT, qVar.ocz, qVar.ocA, f, f2);
                q.a[] aVarArr = qVar.ocH;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].dVY();
                        fArr[i + 1] = aVarArr[i].dVZ();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void dWk() {
        long j = this.odY == null ? 0L : this.odY.value;
        long j2 = this.odZ == null ? 0L : this.odZ.value;
        long j3 = this.oea != null ? this.oea.value : 0L;
        this.odX = Math.max(j, j2);
        this.odX = Math.max(this.odX, j3);
        this.odX = Math.max(10000L, this.odX);
        this.odX = Math.max(this.odW, this.odX);
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
        if (this.oea == null || (dVar.obQ != null && dVar.obQ.value > this.oea.value)) {
            this.oea = dVar.obQ;
            dWk();
        }
    }
}
