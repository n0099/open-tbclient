package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class q extends d {
    public float fxY;
    public float fxZ;
    public float lee;
    public float lef;
    public float oVI;
    public float oVJ;
    public long oVK;
    public long oVL;
    public int oVN;
    public int oVO;
    public int oVP;
    public long oVQ;
    public a[] oVS;
    public boolean oVM = false;
    private float[] oVR = new float[4];

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
        float fxZ;
        b oVT;
        b oVU;
        float oVV;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.oVT = bVar;
            this.oVU = bVar2;
            this.oVV = bVar2.x - bVar.x;
            this.fxZ = bVar2.y - bVar.y;
        }

        public float epU() {
            return this.oVU.a(this.oVT);
        }

        public float[] epV() {
            return new float[]{this.oVT.x, this.oVT.y};
        }

        public float[] epW() {
            return new float[]{this.oVU.x, this.oVU.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.oUC.oVs);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!epp()) {
            return null;
        }
        long epB = j - epB();
        if (this.oVQ > 0 && this.oVP != 0) {
            if (epB >= this.oVQ) {
                this.alpha = this.oVO;
            } else {
                this.alpha = ((int) ((((float) epB) / ((float) this.oVQ)) * this.oVP)) + this.oVN;
            }
        }
        float f2 = this.oVI;
        float f3 = this.oVJ;
        long j2 = epB - this.oVL;
        if (this.oVK > 0 && j2 >= 0 && j2 <= this.oVK) {
            if (this.oVS != null) {
                a[] aVarArr = this.oVS;
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
                    f2 = aVar.oVU.x;
                    i++;
                    f = aVar.oVU.y;
                }
                if (aVar != null) {
                    float f4 = aVar.oVV;
                    float f5 = aVar.fxZ;
                    float f6 = ((float) (epB - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.oVT.x;
                    float f8 = aVar.oVT.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float R = this.oVM ? R(j2, this.oVK) : ((float) j2) / ((float) this.oVK);
                if (this.fxY != 0.0f) {
                    f2 = (this.fxY * R) + this.oVI;
                }
                if (this.fxZ != 0.0f) {
                    f = (R * this.fxZ) + this.oVJ;
                }
                f = f3;
            }
        } else {
            if (j2 > this.oVK) {
                f2 = this.lee;
                f = this.lef;
            }
            f = f3;
        }
        this.oVR[0] = f2;
        this.oVR[1] = f;
        this.oVR[2] = f2 + this.oVb;
        this.oVR[3] = f + this.oVc;
        setVisibility(!eps());
        return this.oVR;
    }

    private static final float R(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float epw() {
        return this.oVR[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float epx() {
        return this.oVR[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float epy() {
        return this.oVR[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float epz() {
        return this.oVR[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.oVI = f;
        this.oVJ = f2;
        this.lee = f3;
        this.lef = f4;
        this.fxY = f3 - f;
        this.fxZ = f4 - f2;
        this.oVK = j;
        this.oVL = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.oVI = fArr[0][0];
            this.oVJ = fArr[0][1];
            this.lee = fArr[length - 1][0];
            this.lef = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.oVS = new a[fArr.length - 1];
                for (int i = 0; i < this.oVS.length; i++) {
                    this.oVS[i] = new a();
                    this.oVS[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.oVS;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].epU() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.oVS;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.epU() / f) * ((float) this.oVK);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
