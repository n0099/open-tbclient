package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public class q extends d {
    public float dNX;
    public float dNY;
    public float iIu;
    public float iIv;
    public float nFk;
    public float nFl;
    public long nFm;
    public long nFn;
    public int nFp;
    public int nFq;
    public int nFr;
    public long nFs;
    public a[] nFu;
    public boolean nFo = false;
    private float[] nFt = new float[4];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a {
        public long beginTime;
        float dNY;
        public long duration;
        public long endTime;
        b nFv;
        b nFw;
        float nFx;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nFv = bVar;
            this.nFw = bVar2;
            this.nFx = bVar2.x - bVar.x;
            this.dNY = bVar2.y - bVar.y;
        }

        public float dKU() {
            return this.nFw.a(this.nFv);
        }

        public float[] dKV() {
            return new float[]{this.nFv.x, this.nFv.y};
        }

        public float[] dKW() {
            return new float[]{this.nFw.x, this.nFw.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.nEd.nEU);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dKq()) {
            return null;
        }
        long dKB = j - dKB();
        if (this.nFs > 0 && this.nFr != 0) {
            if (dKB >= this.nFs) {
                this.alpha = this.nFq;
            } else {
                this.alpha = ((int) ((((float) dKB) / ((float) this.nFs)) * this.nFr)) + this.nFp;
            }
        }
        float f2 = this.nFk;
        float f3 = this.nFl;
        long j2 = dKB - this.nFn;
        if (this.nFm > 0 && j2 >= 0 && j2 <= this.nFm) {
            if (this.nFu != null) {
                a[] aVarArr = this.nFu;
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
                    f2 = aVar.nFw.x;
                    i++;
                    f = aVar.nFw.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nFx;
                    float f5 = aVar.dNY;
                    float f6 = ((float) (dKB - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nFv.x;
                    float f8 = aVar.nFv.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float ai = this.nFo ? ai(j2, this.nFm) : ((float) j2) / ((float) this.nFm);
                if (this.dNX != 0.0f) {
                    f2 = (this.dNX * ai) + this.nFk;
                }
                if (this.dNY != 0.0f) {
                    f = (ai * this.dNY) + this.nFl;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nFm) {
                f2 = this.iIu;
                f = this.iIv;
            }
            f = f3;
        }
        this.nFt[0] = f2;
        this.nFt[1] = f;
        this.nFt[2] = f2 + this.nED;
        this.nFt[3] = f + this.nEE;
        setVisibility(!dKs());
        return this.nFt;
    }

    private static final float ai(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKw() {
        return this.nFt[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKx() {
        return this.nFt[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKy() {
        return this.nFt[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKz() {
        return this.nFt[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nFk = f;
        this.nFl = f2;
        this.iIu = f3;
        this.iIv = f4;
        this.dNX = f3 - f;
        this.dNY = f4 - f2;
        this.nFm = j;
        this.nFn = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nFk = fArr[0][0];
            this.nFl = fArr[0][1];
            this.iIu = fArr[length - 1][0];
            this.iIv = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nFu = new a[fArr.length - 1];
                for (int i = 0; i < this.nFu.length; i++) {
                    this.nFu[i] = new a();
                    this.nFu[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nFu;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dKU() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nFu;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dKU() / f) * ((float) this.nFm);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
