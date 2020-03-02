package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class q extends d {
    public float dSe;
    public float dSf;
    public float iJT;
    public float iJU;
    public float nGj;
    public float nGk;
    public long nGl;
    public long nGm;
    public int nGo;
    public int nGp;
    public int nGq;
    public long nGr;
    public a[] nGt;
    public boolean nGn = false;
    private float[] nGs = new float[4];

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
        float dSf;
        public long duration;
        public long endTime;
        b nGu;
        b nGv;
        float nGw;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nGu = bVar;
            this.nGv = bVar2;
            this.nGw = bVar2.x - bVar.x;
            this.dSf = bVar2.y - bVar.y;
        }

        public float dMl() {
            return this.nGv.a(this.nGu);
        }

        public float[] dMm() {
            return new float[]{this.nGu.x, this.nGu.y};
        }

        public float[] dMn() {
            return new float[]{this.nGv.x, this.nGv.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.nFc.nFT);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dLH()) {
            return null;
        }
        long dLS = j - dLS();
        if (this.nGr > 0 && this.nGq != 0) {
            if (dLS >= this.nGr) {
                this.alpha = this.nGp;
            } else {
                this.alpha = ((int) ((((float) dLS) / ((float) this.nGr)) * this.nGq)) + this.nGo;
            }
        }
        float f2 = this.nGj;
        float f3 = this.nGk;
        long j2 = dLS - this.nGm;
        if (this.nGl > 0 && j2 >= 0 && j2 <= this.nGl) {
            if (this.nGt != null) {
                a[] aVarArr = this.nGt;
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
                    f2 = aVar.nGv.x;
                    i++;
                    f = aVar.nGv.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nGw;
                    float f5 = aVar.dSf;
                    float f6 = ((float) (dLS - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nGu.x;
                    float f8 = aVar.nGu.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float ai = this.nGn ? ai(j2, this.nGl) : ((float) j2) / ((float) this.nGl);
                if (this.dSe != 0.0f) {
                    f2 = (this.dSe * ai) + this.nGj;
                }
                if (this.dSf != 0.0f) {
                    f = (ai * this.dSf) + this.nGk;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nGl) {
                f2 = this.iJT;
                f = this.iJU;
            }
            f = f3;
        }
        this.nGs[0] = f2;
        this.nGs[1] = f;
        this.nGs[2] = f2 + this.nFC;
        this.nGs[3] = f + this.nFD;
        setVisibility(!dLJ());
        return this.nGs;
    }

    private static final float ai(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLN() {
        return this.nGs[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLO() {
        return this.nGs[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLP() {
        return this.nGs[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dLQ() {
        return this.nGs[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nGj = f;
        this.nGk = f2;
        this.iJT = f3;
        this.iJU = f4;
        this.dSe = f3 - f;
        this.dSf = f4 - f2;
        this.nGl = j;
        this.nGm = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nGj = fArr[0][0];
            this.nGk = fArr[0][1];
            this.iJT = fArr[length - 1][0];
            this.iJU = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nGt = new a[fArr.length - 1];
                for (int i = 0; i < this.nGt.length; i++) {
                    this.nGt[i] = new a();
                    this.nGt[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nGt;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dMl() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nGt;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dMl() / f) * ((float) this.nGl);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
