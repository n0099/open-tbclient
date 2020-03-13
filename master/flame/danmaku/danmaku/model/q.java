package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class q extends d {
    public float dSr;
    public float dSs;
    public float iKf;
    public float iKg;
    public int nGA;
    public int nGB;
    public long nGC;
    public a[] nGE;
    public float nGu;
    public float nGv;
    public long nGw;
    public long nGx;
    public int nGz;
    public boolean nGy = false;
    private float[] nGD = new float[4];

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
        float dSs;
        public long duration;
        public long endTime;
        b nGF;
        b nGG;
        float nGH;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nGF = bVar;
            this.nGG = bVar2;
            this.nGH = bVar2.x - bVar.x;
            this.dSs = bVar2.y - bVar.y;
        }

        public float dMm() {
            return this.nGG.a(this.nGF);
        }

        public float[] dMn() {
            return new float[]{this.nGF.x, this.nGF.y};
        }

        public float[] dMo() {
            return new float[]{this.nGG.x, this.nGG.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.nFn.nGe);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dLI()) {
            return null;
        }
        long dLT = j - dLT();
        if (this.nGC > 0 && this.nGB != 0) {
            if (dLT >= this.nGC) {
                this.alpha = this.nGA;
            } else {
                this.alpha = ((int) ((((float) dLT) / ((float) this.nGC)) * this.nGB)) + this.nGz;
            }
        }
        float f2 = this.nGu;
        float f3 = this.nGv;
        long j2 = dLT - this.nGx;
        if (this.nGw > 0 && j2 >= 0 && j2 <= this.nGw) {
            if (this.nGE != null) {
                a[] aVarArr = this.nGE;
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
                    f2 = aVar.nGG.x;
                    i++;
                    f = aVar.nGG.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nGH;
                    float f5 = aVar.dSs;
                    float f6 = ((float) (dLT - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nGF.x;
                    float f8 = aVar.nGF.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float ai = this.nGy ? ai(j2, this.nGw) : ((float) j2) / ((float) this.nGw);
                if (this.dSr != 0.0f) {
                    f2 = (this.dSr * ai) + this.nGu;
                }
                if (this.dSs != 0.0f) {
                    f = (ai * this.dSs) + this.nGv;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nGw) {
                f2 = this.iKf;
                f = this.iKg;
            }
            f = f3;
        }
        this.nGD[0] = f2;
        this.nGD[1] = f;
        this.nGD[2] = f2 + this.nFN;
        this.nGD[3] = f + this.nFO;
        setVisibility(!dLK());
        return this.nGD;
    }

    private static final float ai(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLO() {
        return this.nGD[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLP() {
        return this.nGD[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLQ() {
        return this.nGD[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLR() {
        return this.nGD[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nGu = f;
        this.nGv = f2;
        this.iKf = f3;
        this.iKg = f4;
        this.dSr = f3 - f;
        this.dSs = f4 - f2;
        this.nGw = j;
        this.nGx = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nGu = fArr[0][0];
            this.nGv = fArr[0][1];
            this.iKf = fArr[length - 1][0];
            this.iKg = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nGE = new a[fArr.length - 1];
                for (int i = 0; i < this.nGE.length; i++) {
                    this.nGE[i] = new a();
                    this.nGE[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nGE;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dMm() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nGE;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dMm() / f) * ((float) this.nGw);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
