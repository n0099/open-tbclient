package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class q extends d {
    public float fLM;
    public float fLN;
    public float lwU;
    public float lwV;
    public float pYb;
    public float pYc;
    public long pYd;
    public long pYe;
    public int pYg;
    public int pYh;
    public int pYi;
    public long pYj;
    public a[] pYl;
    public boolean pYf = false;
    private float[] pYk = new float[4];

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
        float fLN;
        b pYm;
        b pYn;
        float pYo;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.pYm = bVar;
            this.pYn = bVar2;
            this.pYo = bVar2.x - bVar.x;
            this.fLN = bVar2.y - bVar.y;
        }

        public float eDI() {
            return this.pYn.a(this.pYm);
        }

        public float[] eDJ() {
            return new float[]{this.pYm.x, this.pYm.y};
        }

        public float[] eDK() {
            return new float[]{this.pYn.x, this.pYn.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.pWV.pXL);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!eDd()) {
            return null;
        }
        long eDp = j - eDp();
        if (this.pYj > 0 && this.pYi != 0) {
            if (eDp >= this.pYj) {
                this.alpha = this.pYh;
            } else {
                this.alpha = ((int) ((((float) eDp) / ((float) this.pYj)) * this.pYi)) + this.pYg;
            }
        }
        float f2 = this.pYb;
        float f3 = this.pYc;
        long j2 = eDp - this.pYe;
        if (this.pYd > 0 && j2 >= 0 && j2 <= this.pYd) {
            if (this.pYl != null) {
                a[] aVarArr = this.pYl;
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
                    f2 = aVar.pYn.x;
                    i++;
                    f = aVar.pYn.y;
                }
                if (aVar != null) {
                    float f4 = aVar.pYo;
                    float f5 = aVar.fLN;
                    float f6 = ((float) (eDp - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.pYm.x;
                    float f8 = aVar.pYm.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float T = this.pYf ? T(j2, this.pYd) : ((float) j2) / ((float) this.pYd);
                if (this.fLM != 0.0f) {
                    f2 = (this.fLM * T) + this.pYb;
                }
                if (this.fLN != 0.0f) {
                    f = (T * this.fLN) + this.pYc;
                }
                f = f3;
            }
        } else {
            if (j2 > this.pYd) {
                f2 = this.lwU;
                f = this.lwV;
            }
            f = f3;
        }
        this.pYk[0] = f2;
        this.pYk[1] = f;
        this.pYk[2] = f2 + this.pXu;
        this.pYk[3] = f + this.pXv;
        setVisibility(!eDg());
        return this.pYk;
    }

    private static final float T(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDk() {
        return this.pYk[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDl() {
        return this.pYk[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDm() {
        return this.pYk[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float eDn() {
        return this.pYk[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.pYb = f;
        this.pYc = f2;
        this.lwU = f3;
        this.lwV = f4;
        this.fLM = f3 - f;
        this.fLN = f4 - f2;
        this.pYd = j;
        this.pYe = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.pYb = fArr[0][0];
            this.pYc = fArr[0][1];
            this.lwU = fArr[length - 1][0];
            this.lwV = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.pYl = new a[fArr.length - 1];
                for (int i = 0; i < this.pYl.length; i++) {
                    this.pYl[i] = new a();
                    this.pYl[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.pYl;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].eDI() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.pYl;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.eDI() / f) * ((float) this.pYd);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
