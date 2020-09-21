package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
/* loaded from: classes6.dex */
public class c {
    public master.flame.danmaku.danmaku.model.g oHU;
    public master.flame.danmaku.danmaku.model.g oHV;
    public master.flame.danmaku.danmaku.model.g oHW;
    public m oHY;
    private DanmakuContext oHZ;
    public int oHP = 0;
    public int oHQ = 0;
    private float oHR = 1.0f;
    public long oHS = 10000;
    public long oHT = 4000;
    public l oHX = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c ems() {
        return new c();
    }

    protected c() {
    }

    public void emt() {
        this.oHY = null;
        this.oHQ = 0;
        this.oHP = 0;
        this.oHX.clear();
        this.oHU = null;
        this.oHV = null;
        this.oHW = null;
        this.oHT = 4000L;
    }

    public void b(DanmakuContext danmakuContext) {
        this.oHZ = danmakuContext;
        this.oHY = danmakuContext.emm();
        a(1, danmakuContext);
    }

    public master.flame.danmaku.danmaku.model.d OI(int i) {
        return a(i, this.oHZ);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.oHZ = danmakuContext;
        this.oHY = danmakuContext.emm();
        return a(i, this.oHY.getWidth(), this.oHY.getHeight(), this.oHR, danmakuContext.oHx);
    }

    public master.flame.danmaku.danmaku.model.d a(int i, int i2, int i3, float f, float f2) {
        return b(i, i2, i3, f, f2);
    }

    public master.flame.danmaku.danmaku.model.d b(int i, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = 1.0f;
        int i2 = this.oHP;
        int i3 = this.oHQ;
        boolean j = j(f, f2, f3);
        if (this.oHU == null) {
            this.oHU = new master.flame.danmaku.danmaku.model.g(this.oHS);
            this.oHU.aW(f4);
        } else if (j) {
            this.oHU.setValue(this.oHS);
        }
        if (this.oHV == null) {
            this.oHV = new master.flame.danmaku.danmaku.model.g(10000L);
        }
        if (j && f > 0.0f) {
            emu();
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
                return new p(this.oHU);
            case 2:
            case 3:
            default:
                return null;
            case 4:
                return new master.flame.danmaku.danmaku.model.h(this.oHV);
            case 5:
                return new master.flame.danmaku.danmaku.model.i(this.oHV);
            case 6:
                return new o(this.oHU);
            case 7:
                q qVar = new q();
                this.oHX.k(qVar);
                return qVar;
        }
    }

    public boolean j(float f, float f2, float f3) {
        if (this.oHP == ((int) f) && this.oHQ == ((int) f2) && this.oHR == f3) {
            return false;
        }
        this.oHS = 10000.0f * ((f3 * f) / 682.0f);
        this.oHS = Math.min(9000L, this.oHS);
        this.oHS = Math.max(4000L, this.oHS);
        this.oHP = (int) f;
        this.oHQ = (int) f2;
        this.oHR = f3;
        return true;
    }

    private void F(final float f, final float f2) {
        this.oHX.a(new l.c<master.flame.danmaku.danmaku.model.d>() { // from class: master.flame.danmaku.danmaku.model.android.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // master.flame.danmaku.danmaku.model.l.b
            /* renamed from: e */
            public int bQ(master.flame.danmaku.danmaku.model.d dVar) {
                q qVar = (q) dVar;
                c.this.a(qVar, qVar.oGt, qVar.oGu, qVar.kOS, qVar.kOT, qVar.oGv, qVar.oGw, f, f2);
                q.a[] aVarArr = qVar.oGD;
                if (aVarArr != null && aVarArr.length > 0) {
                    int length = aVarArr.length;
                    float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, length + 1, 2);
                    for (int i = 0; i < length; i++) {
                        fArr[i] = aVarArr[i].emi();
                        fArr[i + 1] = aVarArr[i].emj();
                    }
                    c.a(qVar, fArr, f, f2);
                }
                return 0;
            }
        });
    }

    public void emu() {
        long j = this.oHU == null ? 0L : this.oHU.value;
        long j2 = this.oHV == null ? 0L : this.oHV.value;
        long j3 = this.oHW != null ? this.oHW.value : 0L;
        this.oHT = Math.max(j, j2);
        this.oHT = Math.max(this.oHT, j3);
        this.oHT = Math.max(10000L, this.oHT);
        this.oHT = Math.max(this.oHS, this.oHT);
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
        if (this.oHW == null || (dVar.oFO != null && dVar.oFO.value > this.oHW.value)) {
            this.oHW = dVar.oFO;
            emu();
        }
    }
}
