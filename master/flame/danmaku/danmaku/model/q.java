package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class q extends d {
    public float dSd;
    public float dSe;
    public float iJR;
    public float iJS;
    public float nGh;
    public float nGi;
    public long nGj;
    public long nGk;
    public int nGm;
    public int nGn;
    public int nGo;
    public long nGp;
    public a[] nGr;
    public boolean nGl = false;
    private float[] nGq = new float[4];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b {
        float x;
        float y;

        public b(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        public float a(b bVar) {
            float abs = Math.abs(this.x - bVar.x);
            float abs2 = Math.abs(this.y - bVar.y);
            return (float) Math.sqrt((abs * abs) + (abs2 * abs2));
        }
    }

    /* loaded from: classes5.dex */
    public class a {
        public long beginTime;
        float dSe;
        public long duration;
        public long endTime;
        b nGs;
        b nGt;
        float nGu;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nGs = bVar;
            this.nGt = bVar2;
            this.nGu = bVar2.x - bVar.x;
            this.dSe = bVar2.y - bVar.y;
        }

        public float dMj() {
            return this.nGt.a(this.nGs);
        }

        public float[] dMk() {
            return new float[]{this.nGs.x, this.nGs.y};
        }

        public float[] dMl() {
            return new float[]{this.nGt.x, this.nGt.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.nFa.nFR);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dLF()) {
            return null;
        }
        long dLQ = j - dLQ();
        if (this.nGp > 0 && this.nGo != 0) {
            if (dLQ >= this.nGp) {
                this.alpha = this.nGn;
            } else {
                this.alpha = ((int) ((((float) dLQ) / ((float) this.nGp)) * this.nGo)) + this.nGm;
            }
        }
        float f2 = this.nGh;
        float f3 = this.nGi;
        long j2 = dLQ - this.nGk;
        if (this.nGj > 0 && j2 >= 0 && j2 <= this.nGj) {
            if (this.nGr != null) {
                a[] aVarArr = this.nGr;
                int length = aVarArr.length;
                int i = 0;
                f = f3;
                while (true) {
                    if (i >= length) {
                        aVar = null;
                        break;
                    }
                    aVar = aVarArr[i];
                    if (j2 >= aVar.beginTime && j2 < aVar.endTime) {
                        break;
                    }
                    f2 = aVar.nGt.x;
                    i++;
                    f = aVar.nGt.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nGu;
                    float f5 = aVar.dSe;
                    float f6 = ((float) (dLQ - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nGs.x;
                    float f8 = aVar.nGs.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float ai = this.nGl ? ai(j2, this.nGj) : ((float) j2) / ((float) this.nGj);
                if (this.dSd != 0.0f) {
                    f2 = (this.dSd * ai) + this.nGh;
                }
                if (this.dSe != 0.0f) {
                    f = (ai * this.dSe) + this.nGi;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nGj) {
                f2 = this.iJR;
                f = this.iJS;
            }
            f = f3;
        }
        this.nGq[0] = f2;
        this.nGq[1] = f;
        this.nGq[2] = f2 + this.nFA;
        this.nGq[3] = f + this.nFB;
        setVisibility(!dLH());
        return this.nGq;
    }

    private static final float ai(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLL() {
        return this.nGq[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLM() {
        return this.nGq[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLN() {
        return this.nGq[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLO() {
        return this.nGq[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nGh = f;
        this.nGi = f2;
        this.iJR = f3;
        this.iJS = f4;
        this.dSd = f3 - f;
        this.dSe = f4 - f2;
        this.nGj = j;
        this.nGk = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nGh = fArr[0][0];
            this.nGi = fArr[0][1];
            this.iJR = fArr[length - 1][0];
            this.iJS = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nGr = new a[fArr.length - 1];
                for (int i = 0; i < this.nGr.length; i++) {
                    this.nGr[i] = new a();
                    this.nGr[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nGr;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dMj() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nGr;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dMj() / f) * ((float) this.nGj);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
