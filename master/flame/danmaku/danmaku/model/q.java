package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class q extends d {
    public float flK;
    public float flL;
    public float kOS;
    public float kOT;
    public int oGA;
    public long oGB;
    public a[] oGD;
    public float oGt;
    public float oGu;
    public long oGv;
    public long oGw;
    public int oGy;
    public int oGz;
    public boolean oGx = false;
    private float[] oGC = new float[4];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a {
        public long beginTime;
        public long duration;
        public long endTime;
        float flL;
        b oGE;
        b oGF;
        float oGG;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.oGE = bVar;
            this.oGF = bVar2;
            this.oGG = bVar2.x - bVar.x;
            this.flL = bVar2.y - bVar.y;
        }

        public float emh() {
            return this.oGF.a(this.oGE);
        }

        public float[] emi() {
            return new float[]{this.oGE.x, this.oGE.y};
        }

        public float[] emj() {
            return new float[]{this.oGF.x, this.oGF.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.oFn.oGd);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!elC()) {
            return null;
        }
        long elO = j - elO();
        if (this.oGB > 0 && this.oGA != 0) {
            if (elO >= this.oGB) {
                this.alpha = this.oGz;
            } else {
                this.alpha = ((int) ((((float) elO) / ((float) this.oGB)) * this.oGA)) + this.oGy;
            }
        }
        float f2 = this.oGt;
        float f3 = this.oGu;
        long j2 = elO - this.oGw;
        if (this.oGv > 0 && j2 >= 0 && j2 <= this.oGv) {
            if (this.oGD != null) {
                a[] aVarArr = this.oGD;
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
                    f2 = aVar.oGF.x;
                    i++;
                    f = aVar.oGF.y;
                }
                if (aVar != null) {
                    float f4 = aVar.oGG;
                    float f5 = aVar.flL;
                    float f6 = ((float) (elO - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.oGE.x;
                    float f8 = aVar.oGE.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float R = this.oGx ? R(j2, this.oGv) : ((float) j2) / ((float) this.oGv);
                if (this.flK != 0.0f) {
                    f2 = (this.flK * R) + this.oGt;
                }
                if (this.flL != 0.0f) {
                    f = (R * this.flL) + this.oGu;
                }
                f = f3;
            }
        } else {
            if (j2 > this.oGv) {
                f2 = this.kOS;
                f = this.kOT;
            }
            f = f3;
        }
        this.oGC[0] = f2;
        this.oGC[1] = f;
        this.oGC[2] = f2 + this.oFM;
        this.oGC[3] = f + this.oFN;
        setVisibility(!elF());
        return this.oGC;
    }

    private static final float R(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float elJ() {
        return this.oGC[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float elK() {
        return this.oGC[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float elL() {
        return this.oGC[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float elM() {
        return this.oGC[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.oGt = f;
        this.oGu = f2;
        this.kOS = f3;
        this.kOT = f4;
        this.flK = f3 - f;
        this.flL = f4 - f2;
        this.oGv = j;
        this.oGw = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.oGt = fArr[0][0];
            this.oGu = fArr[0][1];
            this.kOS = fArr[length - 1][0];
            this.kOT = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.oGD = new a[fArr.length - 1];
                for (int i = 0; i < this.oGD.length; i++) {
                    this.oGD[i] = new a();
                    this.oGD[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.oGD;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].emh() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.oGD;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.emh() / f) * ((float) this.oGv);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
