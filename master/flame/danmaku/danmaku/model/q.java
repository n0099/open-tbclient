package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class q extends d {
    public float esL;
    public float esM;
    public float jvT;
    public float jvU;
    public float nbM;
    public float nbN;
    public long nbO;
    public long nbP;
    public int nbR;
    public int nbS;
    public int nbT;
    public long nbU;
    public a[] nbW;
    public boolean nbQ = false;
    private float[] nbV = new float[4];

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
        public long endTime;
        float esM;
        b nbX;
        b nbY;
        float nbZ;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nbX = bVar;
            this.nbY = bVar2;
            this.nbZ = bVar2.x - bVar.x;
            this.esM = bVar2.y - bVar.y;
        }

        public float dFJ() {
            return this.nbY.a(this.nbX);
        }

        public float[] dFK() {
            return new float[]{this.nbX.x, this.nbX.y};
        }

        public float[] dFL() {
            return new float[]{this.nbY.x, this.nbY.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.naD.nbv);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dFf()) {
            return null;
        }
        long dFq = j - dFq();
        if (this.nbU > 0 && this.nbT != 0) {
            if (dFq >= this.nbU) {
                this.alpha = this.nbS;
            } else {
                this.alpha = ((int) ((((float) dFq) / ((float) this.nbU)) * this.nbT)) + this.nbR;
            }
        }
        float f2 = this.nbM;
        float f3 = this.nbN;
        long j2 = dFq - this.nbP;
        if (this.nbO > 0 && j2 >= 0 && j2 <= this.nbO) {
            if (this.nbW != null) {
                a[] aVarArr = this.nbW;
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
                    f2 = aVar.nbY.x;
                    i++;
                    f = aVar.nbY.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nbZ;
                    float f5 = aVar.esM;
                    float f6 = ((float) (dFq - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nbX.x;
                    float f8 = aVar.nbX.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float Q = this.nbQ ? Q(j2, this.nbO) : ((float) j2) / ((float) this.nbO);
                if (this.esL != 0.0f) {
                    f2 = (this.esL * Q) + this.nbM;
                }
                if (this.esM != 0.0f) {
                    f = (Q * this.esM) + this.nbN;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nbO) {
                f2 = this.jvT;
                f = this.jvU;
            }
            f = f3;
        }
        this.nbV[0] = f2;
        this.nbV[1] = f;
        this.nbV[2] = f2 + this.nbd;
        this.nbV[3] = f + this.nbe;
        setVisibility(!dFh());
        return this.nbV;
    }

    private static final float Q(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFl() {
        return this.nbV[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFm() {
        return this.nbV[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFn() {
        return this.nbV[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFo() {
        return this.nbV[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nbM = f;
        this.nbN = f2;
        this.jvT = f3;
        this.jvU = f4;
        this.esL = f3 - f;
        this.esM = f4 - f2;
        this.nbO = j;
        this.nbP = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nbM = fArr[0][0];
            this.nbN = fArr[0][1];
            this.jvT = fArr[length - 1][0];
            this.jvU = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nbW = new a[fArr.length - 1];
                for (int i = 0; i < this.nbW.length; i++) {
                    this.nbW[i] = new a();
                    this.nbW[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nbW;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dFJ() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nbW;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dFJ() / f) * ((float) this.nbO);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
