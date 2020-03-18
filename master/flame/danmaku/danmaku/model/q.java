package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class q extends d {
    public float dSI;
    public float dSJ;
    public float iLG;
    public float iLH;
    public float nIh;
    public float nIi;
    public long nIj;
    public long nIk;
    public int nIm;
    public int nIn;
    public int nIo;
    public long nIp;
    public a[] nIr;
    public boolean nIl = false;
    private float[] nIq = new float[4];

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
        float dSJ;
        public long duration;
        public long endTime;
        b nIs;
        b nIt;
        float nIu;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nIs = bVar;
            this.nIt = bVar2;
            this.nIu = bVar2.x - bVar.x;
            this.dSJ = bVar2.y - bVar.y;
        }

        public float dMM() {
            return this.nIt.a(this.nIs);
        }

        public float[] dMN() {
            return new float[]{this.nIs.x, this.nIs.y};
        }

        public float[] dMO() {
            return new float[]{this.nIt.x, this.nIt.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.nHa.nHR);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dMi()) {
            return null;
        }
        long dMt = j - dMt();
        if (this.nIp > 0 && this.nIo != 0) {
            if (dMt >= this.nIp) {
                this.alpha = this.nIn;
            } else {
                this.alpha = ((int) ((((float) dMt) / ((float) this.nIp)) * this.nIo)) + this.nIm;
            }
        }
        float f2 = this.nIh;
        float f3 = this.nIi;
        long j2 = dMt - this.nIk;
        if (this.nIj > 0 && j2 >= 0 && j2 <= this.nIj) {
            if (this.nIr != null) {
                a[] aVarArr = this.nIr;
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
                    f2 = aVar.nIt.x;
                    i++;
                    f = aVar.nIt.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nIu;
                    float f5 = aVar.dSJ;
                    float f6 = ((float) (dMt - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nIs.x;
                    float f8 = aVar.nIs.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float ai = this.nIl ? ai(j2, this.nIj) : ((float) j2) / ((float) this.nIj);
                if (this.dSI != 0.0f) {
                    f2 = (this.dSI * ai) + this.nIh;
                }
                if (this.dSJ != 0.0f) {
                    f = (ai * this.dSJ) + this.nIi;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nIj) {
                f2 = this.iLG;
                f = this.iLH;
            }
            f = f3;
        }
        this.nIq[0] = f2;
        this.nIq[1] = f;
        this.nIq[2] = f2 + this.nHA;
        this.nIq[3] = f + this.nHB;
        setVisibility(!dMk());
        return this.nIq;
    }

    private static final float ai(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMo() {
        return this.nIq[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMp() {
        return this.nIq[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMq() {
        return this.nIq[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dMr() {
        return this.nIq[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nIh = f;
        this.nIi = f2;
        this.iLG = f3;
        this.iLH = f4;
        this.dSI = f3 - f;
        this.dSJ = f4 - f2;
        this.nIj = j;
        this.nIk = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nIh = fArr[0][0];
            this.nIi = fArr[0][1];
            this.iLG = fArr[length - 1][0];
            this.iLH = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nIr = new a[fArr.length - 1];
                for (int i = 0; i < this.nIr.length; i++) {
                    this.nIr[i] = new a();
                    this.nIr[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nIr;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dMM() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nIr;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dMM() / f) * ((float) this.nIj);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
