package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class q extends d {
    public float eRI;
    public float eRJ;
    public float khX;
    public float khY;
    public float nTK;
    public float nTL;
    public long nTM;
    public long nTN;
    public int nTP;
    public int nTQ;
    public int nTR;
    public long nTS;
    public a[] nTU;
    public boolean nTO = false;
    private float[] nTT = new float[4];

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
        public long duration;
        float eRJ;
        public long endTime;
        b nTV;
        b nTW;
        float nTX;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nTV = bVar;
            this.nTW = bVar2;
            this.nTX = bVar2.x - bVar.x;
            this.eRJ = bVar2.y - bVar.y;
        }

        public float dSx() {
            return this.nTW.a(this.nTV);
        }

        public float[] dSy() {
            return new float[]{this.nTV.x, this.nTV.y};
        }

        public float[] dSz() {
            return new float[]{this.nTW.x, this.nTW.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.nSC.nTt);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dRT()) {
            return null;
        }
        long dSe = j - dSe();
        if (this.nTS > 0 && this.nTR != 0) {
            if (dSe >= this.nTS) {
                this.alpha = this.nTQ;
            } else {
                this.alpha = ((int) ((((float) dSe) / ((float) this.nTS)) * this.nTR)) + this.nTP;
            }
        }
        float f2 = this.nTK;
        float f3 = this.nTL;
        long j2 = dSe - this.nTN;
        if (this.nTM > 0 && j2 >= 0 && j2 <= this.nTM) {
            if (this.nTU != null) {
                a[] aVarArr = this.nTU;
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
                    f2 = aVar.nTW.x;
                    i++;
                    f = aVar.nTW.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nTX;
                    float f5 = aVar.eRJ;
                    float f6 = ((float) (dSe - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nTV.x;
                    float f8 = aVar.nTV.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float S = this.nTO ? S(j2, this.nTM) : ((float) j2) / ((float) this.nTM);
                if (this.eRI != 0.0f) {
                    f2 = (this.eRI * S) + this.nTK;
                }
                if (this.eRJ != 0.0f) {
                    f = (S * this.eRJ) + this.nTL;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nTM) {
                f2 = this.khX;
                f = this.khY;
            }
            f = f3;
        }
        this.nTT[0] = f2;
        this.nTT[1] = f;
        this.nTT[2] = f2 + this.nTc;
        this.nTT[3] = f + this.nTd;
        setVisibility(!dRV());
        return this.nTT;
    }

    private static final float S(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dRZ() {
        return this.nTT[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSa() {
        return this.nTT[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSb() {
        return this.nTT[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSc() {
        return this.nTT[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nTK = f;
        this.nTL = f2;
        this.khX = f3;
        this.khY = f4;
        this.eRI = f3 - f;
        this.eRJ = f4 - f2;
        this.nTM = j;
        this.nTN = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nTK = fArr[0][0];
            this.nTL = fArr[0][1];
            this.khX = fArr[length - 1][0];
            this.khY = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nTU = new a[fArr.length - 1];
                for (int i = 0; i < this.nTU.length; i++) {
                    this.nTU[i] = new a();
                    this.nTU[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nTU;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dSx() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nTU;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dSx() / f) * ((float) this.nTM);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
