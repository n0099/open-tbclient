package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class q extends d {
    public float fMj;
    public float fMk;
    public float lwE;
    public float lwF;
    public long pWA;
    public long pWB;
    public int pWD;
    public int pWE;
    public int pWF;
    public long pWG;
    public a[] pWI;
    public float pWy;
    public float pWz;
    public boolean pWC = false;
    private float[] pWH = new float[4];

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
        float fMk;
        b pWJ;
        b pWK;
        float pWL;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.pWJ = bVar;
            this.pWK = bVar2;
            this.pWL = bVar2.x - bVar.x;
            this.fMk = bVar2.y - bVar.y;
        }

        public float eDH() {
            return this.pWK.a(this.pWJ);
        }

        public float[] eDI() {
            return new float[]{this.pWJ.x, this.pWJ.y};
        }

        public float[] eDJ() {
            return new float[]{this.pWK.x, this.pWK.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.pVs.pWi);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!eDc()) {
            return null;
        }
        long eDo = j - eDo();
        if (this.pWG > 0 && this.pWF != 0) {
            if (eDo >= this.pWG) {
                this.alpha = this.pWE;
            } else {
                this.alpha = ((int) ((((float) eDo) / ((float) this.pWG)) * this.pWF)) + this.pWD;
            }
        }
        float f2 = this.pWy;
        float f3 = this.pWz;
        long j2 = eDo - this.pWB;
        if (this.pWA > 0 && j2 >= 0 && j2 <= this.pWA) {
            if (this.pWI != null) {
                a[] aVarArr = this.pWI;
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
                    f2 = aVar.pWK.x;
                    i++;
                    f = aVar.pWK.y;
                }
                if (aVar != null) {
                    float f4 = aVar.pWL;
                    float f5 = aVar.fMk;
                    float f6 = ((float) (eDo - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.pWJ.x;
                    float f8 = aVar.pWJ.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float T = this.pWC ? T(j2, this.pWA) : ((float) j2) / ((float) this.pWA);
                if (this.fMj != 0.0f) {
                    f2 = (this.fMj * T) + this.pWy;
                }
                if (this.fMk != 0.0f) {
                    f = (T * this.fMk) + this.pWz;
                }
                f = f3;
            }
        } else {
            if (j2 > this.pWA) {
                f2 = this.lwE;
                f = this.lwF;
            }
            f = f3;
        }
        this.pWH[0] = f2;
        this.pWH[1] = f;
        this.pWH[2] = f2 + this.pVR;
        this.pWH[3] = f + this.pVS;
        setVisibility(!eDf());
        return this.pWH;
    }

    private static final float T(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDj() {
        return this.pWH[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDk() {
        return this.pWH[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDl() {
        return this.pWH[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDm() {
        return this.pWH[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.pWy = f;
        this.pWz = f2;
        this.lwE = f3;
        this.lwF = f4;
        this.fMj = f3 - f;
        this.fMk = f4 - f2;
        this.pWA = j;
        this.pWB = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.pWy = fArr[0][0];
            this.pWz = fArr[0][1];
            this.lwE = fArr[length - 1][0];
            this.lwF = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.pWI = new a[fArr.length - 1];
                for (int i = 0; i < this.pWI.length; i++) {
                    this.pWI[i] = new a();
                    this.pWI[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.pWI;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].eDH() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.pWI;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.eDH() / f) * ((float) this.pWA);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
