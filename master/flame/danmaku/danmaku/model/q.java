package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class q extends d {
    public float eRI;
    public float eRJ;
    public float khX;
    public float khY;
    public float nTN;
    public float nTO;
    public long nTP;
    public long nTQ;
    public int nTS;
    public int nTT;
    public int nTU;
    public long nTV;
    public a[] nTX;
    public boolean nTR = false;
    private float[] nTW = new float[4];

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
        b nTY;
        b nTZ;
        float nUa;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nTY = bVar;
            this.nTZ = bVar2;
            this.nUa = bVar2.x - bVar.x;
            this.eRJ = bVar2.y - bVar.y;
        }

        public float dSB() {
            return this.nTZ.a(this.nTY);
        }

        public float[] dSC() {
            return new float[]{this.nTY.x, this.nTY.y};
        }

        public float[] dSD() {
            return new float[]{this.nTZ.x, this.nTZ.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.nSF.nTw);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dRX()) {
            return null;
        }
        long dSi = j - dSi();
        if (this.nTV > 0 && this.nTU != 0) {
            if (dSi >= this.nTV) {
                this.alpha = this.nTT;
            } else {
                this.alpha = ((int) ((((float) dSi) / ((float) this.nTV)) * this.nTU)) + this.nTS;
            }
        }
        float f2 = this.nTN;
        float f3 = this.nTO;
        long j2 = dSi - this.nTQ;
        if (this.nTP > 0 && j2 >= 0 && j2 <= this.nTP) {
            if (this.nTX != null) {
                a[] aVarArr = this.nTX;
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
                    f2 = aVar.nTZ.x;
                    i++;
                    f = aVar.nTZ.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nUa;
                    float f5 = aVar.eRJ;
                    float f6 = ((float) (dSi - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nTY.x;
                    float f8 = aVar.nTY.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float S = this.nTR ? S(j2, this.nTP) : ((float) j2) / ((float) this.nTP);
                if (this.eRI != 0.0f) {
                    f2 = (this.eRI * S) + this.nTN;
                }
                if (this.eRJ != 0.0f) {
                    f = (S * this.eRJ) + this.nTO;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nTP) {
                f2 = this.khX;
                f = this.khY;
            }
            f = f3;
        }
        this.nTW[0] = f2;
        this.nTW[1] = f;
        this.nTW[2] = f2 + this.nTf;
        this.nTW[3] = f + this.nTg;
        setVisibility(!dRZ());
        return this.nTW;
    }

    private static final float S(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSd() {
        return this.nTW[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSe() {
        return this.nTW[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSf() {
        return this.nTW[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dSg() {
        return this.nTW[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nTN = f;
        this.nTO = f2;
        this.khX = f3;
        this.khY = f4;
        this.eRI = f3 - f;
        this.eRJ = f4 - f2;
        this.nTP = j;
        this.nTQ = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nTN = fArr[0][0];
            this.nTO = fArr[0][1];
            this.khX = fArr[length - 1][0];
            this.khY = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nTX = new a[fArr.length - 1];
                for (int i = 0; i < this.nTX.length; i++) {
                    this.nTX[i] = new a();
                    this.nTX[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nTX;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dSB() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nTX;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dSB() / f) * ((float) this.nTP);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
