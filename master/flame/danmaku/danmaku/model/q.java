package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class q extends d {
    public float esG;
    public float esH;
    public float jvP;
    public float jvQ;
    public float nbJ;
    public float nbK;
    public long nbL;
    public long nbM;
    public int nbO;
    public int nbP;
    public int nbQ;
    public long nbR;
    public a[] nbT;
    public boolean nbN = false;
    private float[] nbS = new float[4];

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
        float esH;
        b nbU;
        b nbV;
        float nbW;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nbU = bVar;
            this.nbV = bVar2;
            this.nbW = bVar2.x - bVar.x;
            this.esH = bVar2.y - bVar.y;
        }

        public float dFM() {
            return this.nbV.a(this.nbU);
        }

        public float[] dFN() {
            return new float[]{this.nbU.x, this.nbU.y};
        }

        public float[] dFO() {
            return new float[]{this.nbV.x, this.nbV.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.naA.nbs);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dFi()) {
            return null;
        }
        long dFt = j - dFt();
        if (this.nbR > 0 && this.nbQ != 0) {
            if (dFt >= this.nbR) {
                this.alpha = this.nbP;
            } else {
                this.alpha = ((int) ((((float) dFt) / ((float) this.nbR)) * this.nbQ)) + this.nbO;
            }
        }
        float f2 = this.nbJ;
        float f3 = this.nbK;
        long j2 = dFt - this.nbM;
        if (this.nbL > 0 && j2 >= 0 && j2 <= this.nbL) {
            if (this.nbT != null) {
                a[] aVarArr = this.nbT;
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
                    f2 = aVar.nbV.x;
                    i++;
                    f = aVar.nbV.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nbW;
                    float f5 = aVar.esH;
                    float f6 = ((float) (dFt - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nbU.x;
                    float f8 = aVar.nbU.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float Q = this.nbN ? Q(j2, this.nbL) : ((float) j2) / ((float) this.nbL);
                if (this.esG != 0.0f) {
                    f2 = (this.esG * Q) + this.nbJ;
                }
                if (this.esH != 0.0f) {
                    f = (Q * this.esH) + this.nbK;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nbL) {
                f2 = this.jvP;
                f = this.jvQ;
            }
            f = f3;
        }
        this.nbS[0] = f2;
        this.nbS[1] = f;
        this.nbS[2] = f2 + this.nba;
        this.nbS[3] = f + this.nbb;
        setVisibility(!dFk());
        return this.nbS;
    }

    private static final float Q(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFo() {
        return this.nbS[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFp() {
        return this.nbS[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFq() {
        return this.nbS[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dFr() {
        return this.nbS[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nbJ = f;
        this.nbK = f2;
        this.jvP = f3;
        this.jvQ = f4;
        this.esG = f3 - f;
        this.esH = f4 - f2;
        this.nbL = j;
        this.nbM = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nbJ = fArr[0][0];
            this.nbK = fArr[0][1];
            this.jvP = fArr[length - 1][0];
            this.jvQ = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nbT = new a[fArr.length - 1];
                for (int i = 0; i < this.nbT.length; i++) {
                    this.nbT[i] = new a();
                    this.nbT[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nbT;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dFM() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nbT;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dFM() / f) * ((float) this.nbL);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
