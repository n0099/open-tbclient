package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class q extends d {
    public float fGt;
    public float fGu;
    public float lqH;
    public float lqI;
    public float pNe;
    public float pNf;
    public long pNg;
    public long pNh;
    public int pNj;
    public int pNk;
    public int pNl;
    public long pNm;
    public a[] pNo;
    public boolean pNi = false;
    private float[] pNn = new float[4];

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
        float fGu;
        b pNp;
        b pNq;
        float pNr;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.pNp = bVar;
            this.pNq = bVar2;
            this.pNr = bVar2.x - bVar.x;
            this.fGu = bVar2.y - bVar.y;
        }

        public float ezS() {
            return this.pNq.a(this.pNp);
        }

        public float[] ezT() {
            return new float[]{this.pNp.x, this.pNp.y};
        }

        public float[] ezU() {
            return new float[]{this.pNq.x, this.pNq.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.pLY.pMO);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!ezn()) {
            return null;
        }
        long ezz = j - ezz();
        if (this.pNm > 0 && this.pNl != 0) {
            if (ezz >= this.pNm) {
                this.alpha = this.pNk;
            } else {
                this.alpha = ((int) ((((float) ezz) / ((float) this.pNm)) * this.pNl)) + this.pNj;
            }
        }
        float f2 = this.pNe;
        float f3 = this.pNf;
        long j2 = ezz - this.pNh;
        if (this.pNg > 0 && j2 >= 0 && j2 <= this.pNg) {
            if (this.pNo != null) {
                a[] aVarArr = this.pNo;
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
                    f2 = aVar.pNq.x;
                    i++;
                    f = aVar.pNq.y;
                }
                if (aVar != null) {
                    float f4 = aVar.pNr;
                    float f5 = aVar.fGu;
                    float f6 = ((float) (ezz - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.pNp.x;
                    float f8 = aVar.pNp.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float S = this.pNi ? S(j2, this.pNg) : ((float) j2) / ((float) this.pNg);
                if (this.fGt != 0.0f) {
                    f2 = (this.fGt * S) + this.pNe;
                }
                if (this.fGu != 0.0f) {
                    f = (S * this.fGu) + this.pNf;
                }
                f = f3;
            }
        } else {
            if (j2 > this.pNg) {
                f2 = this.lqH;
                f = this.lqI;
            }
            f = f3;
        }
        this.pNn[0] = f2;
        this.pNn[1] = f;
        this.pNn[2] = f2 + this.pMx;
        this.pNn[3] = f + this.pMy;
        setVisibility(!ezq());
        return this.pNn;
    }

    private static final float S(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ezu() {
        return this.pNn[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ezv() {
        return this.pNn[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ezw() {
        return this.pNn[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ezx() {
        return this.pNn[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.pNe = f;
        this.pNf = f2;
        this.lqH = f3;
        this.lqI = f4;
        this.fGt = f3 - f;
        this.fGu = f4 - f2;
        this.pNg = j;
        this.pNh = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.pNe = fArr[0][0];
            this.pNf = fArr[0][1];
            this.lqH = fArr[length - 1][0];
            this.lqI = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.pNo = new a[fArr.length - 1];
                for (int i = 0; i < this.pNo.length; i++) {
                    this.pNo[i] = new a();
                    this.pNo[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.pNo;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].ezS() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.pNo;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.ezS() / f) * ((float) this.pNg);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
