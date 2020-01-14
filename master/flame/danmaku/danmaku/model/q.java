package master.flame.danmaku.danmaku.model;
/* loaded from: classes4.dex */
public class q extends d {
    public float dNX;
    public float dNY;
    public float iIu;
    public float iIv;
    public float nFp;
    public float nFq;
    public long nFr;
    public long nFs;
    public int nFu;
    public int nFv;
    public int nFw;
    public long nFx;
    public a[] nFz;
    public boolean nFt = false;
    private float[] nFy = new float[4];

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
        b nFA;
        b nFB;
        float nFC;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nFA = bVar;
            this.nFB = bVar2;
            this.nFC = bVar2.x - bVar.x;
            this.dNY = bVar2.y - bVar.y;
        }

        public float dKW() {
            return this.nFB.a(this.nFA);
        }

        public float[] dKX() {
            return new float[]{this.nFA.x, this.nFA.y};
        }

        public float[] dKY() {
            return new float[]{this.nFB.x, this.nFB.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.nEi.nEZ);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dKs()) {
            return null;
        }
        long dKD = j - dKD();
        if (this.nFx > 0 && this.nFw != 0) {
            if (dKD >= this.nFx) {
                this.alpha = this.nFv;
            } else {
                this.alpha = ((int) ((((float) dKD) / ((float) this.nFx)) * this.nFw)) + this.nFu;
            }
        }
        float f2 = this.nFp;
        float f3 = this.nFq;
        long j2 = dKD - this.nFs;
        if (this.nFr > 0 && j2 >= 0 && j2 <= this.nFr) {
            if (this.nFz != null) {
                a[] aVarArr = this.nFz;
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
                    f2 = aVar.nFB.x;
                    i++;
                    f = aVar.nFB.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nFC;
                    float f5 = aVar.dNY;
                    float f6 = ((float) (dKD - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nFA.x;
                    float f8 = aVar.nFA.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float ai = this.nFt ? ai(j2, this.nFr) : ((float) j2) / ((float) this.nFr);
                if (this.dNX != 0.0f) {
                    f2 = (this.dNX * ai) + this.nFp;
                }
                if (this.dNY != 0.0f) {
                    f = (ai * this.dNY) + this.nFq;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nFr) {
                f2 = this.iIu;
                f = this.iIv;
            }
            f = f3;
        }
        this.nFy[0] = f2;
        this.nFy[1] = f;
        this.nFy[2] = f2 + this.nEI;
        this.nFy[3] = f + this.nEJ;
        setVisibility(!dKu());
        return this.nFy;
    }

    private static final float ai(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKy() {
        return this.nFy[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKz() {
        return this.nFy[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKA() {
        return this.nFy[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dKB() {
        return this.nFy[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nFp = f;
        this.nFq = f2;
        this.iIu = f3;
        this.iIv = f4;
        this.dNX = f3 - f;
        this.dNY = f4 - f2;
        this.nFr = j;
        this.nFs = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nFp = fArr[0][0];
            this.nFq = fArr[0][1];
            this.iIu = fArr[length - 1][0];
            this.iIv = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nFz = new a[fArr.length - 1];
                for (int i = 0; i < this.nFz.length; i++) {
                    this.nFz[i] = new a();
                    this.nFz[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nFz;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dKW() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nFz;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dKW() / f) * ((float) this.nFr);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
