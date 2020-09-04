package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class q extends d {
    public float fiS;
    public float fiT;
    public float kGt;
    public float kGu;
    public float owO;
    public float owP;
    public long owQ;
    public long owR;
    public int owT;
    public int owU;
    public int owV;
    public long owW;
    public a[] owY;
    public boolean owS = false;
    private float[] owX = new float[4];

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
        float fiT;
        b owZ;
        b oxa;
        float oxb;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.owZ = bVar;
            this.oxa = bVar2;
            this.oxb = bVar2.x - bVar.x;
            this.fiT = bVar2.y - bVar.y;
        }

        public float eik() {
            return this.oxa.a(this.owZ);
        }

        public float[] eil() {
            return new float[]{this.owZ.x, this.owZ.y};
        }

        public float[] eim() {
            return new float[]{this.oxa.x, this.oxa.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.ovH.owx);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!ehF()) {
            return null;
        }
        long ehR = j - ehR();
        if (this.owW > 0 && this.owV != 0) {
            if (ehR >= this.owW) {
                this.alpha = this.owU;
            } else {
                this.alpha = ((int) ((((float) ehR) / ((float) this.owW)) * this.owV)) + this.owT;
            }
        }
        float f2 = this.owO;
        float f3 = this.owP;
        long j2 = ehR - this.owR;
        if (this.owQ > 0 && j2 >= 0 && j2 <= this.owQ) {
            if (this.owY != null) {
                a[] aVarArr = this.owY;
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
                    f2 = aVar.oxa.x;
                    i++;
                    f = aVar.oxa.y;
                }
                if (aVar != null) {
                    float f4 = aVar.oxb;
                    float f5 = aVar.fiT;
                    float f6 = ((float) (ehR - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.owZ.x;
                    float f8 = aVar.owZ.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float U = this.owS ? U(j2, this.owQ) : ((float) j2) / ((float) this.owQ);
                if (this.fiS != 0.0f) {
                    f2 = (this.fiS * U) + this.owO;
                }
                if (this.fiT != 0.0f) {
                    f = (U * this.fiT) + this.owP;
                }
                f = f3;
            }
        } else {
            if (j2 > this.owQ) {
                f2 = this.kGt;
                f = this.kGu;
            }
            f = f3;
        }
        this.owX[0] = f2;
        this.owX[1] = f;
        this.owX[2] = f2 + this.owg;
        this.owX[3] = f + this.owh;
        setVisibility(!ehI());
        return this.owX;
    }

    private static final float U(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehM() {
        return this.owX[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehN() {
        return this.owX[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehO() {
        return this.owX[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehP() {
        return this.owX[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.owO = f;
        this.owP = f2;
        this.kGt = f3;
        this.kGu = f4;
        this.fiS = f3 - f;
        this.fiT = f4 - f2;
        this.owQ = j;
        this.owR = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.owO = fArr[0][0];
            this.owP = fArr[0][1];
            this.kGt = fArr[length - 1][0];
            this.kGu = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.owY = new a[fArr.length - 1];
                for (int i = 0; i < this.owY.length; i++) {
                    this.owY[i] = new a();
                    this.owY[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.owY;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].eik() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.owY;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.eik() / f) * ((float) this.owQ);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
