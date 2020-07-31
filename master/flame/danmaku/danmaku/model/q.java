package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class q extends d {
    public float eYd;
    public float eYe;
    public float kqS;
    public float kqT;
    public long ocA;
    public int ocC;
    public int ocD;
    public int ocE;
    public long ocF;
    public a[] ocH;
    public float ocx;
    public float ocy;
    public long ocz;
    public boolean ocB = false;
    private float[] ocG = new float[4];

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
        float eYe;
        public long endTime;
        b ocI;
        b ocJ;
        float ocK;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.ocI = bVar;
            this.ocJ = bVar2;
            this.ocK = bVar2.x - bVar.x;
            this.eYe = bVar2.y - bVar.y;
        }

        public float dVX() {
            return this.ocJ.a(this.ocI);
        }

        public float[] dVY() {
            return new float[]{this.ocI.x, this.ocI.y};
        }

        public float[] dVZ() {
            return new float[]{this.ocJ.x, this.ocJ.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.obp.ocf);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dVt()) {
            return null;
        }
        long dVE = j - dVE();
        if (this.ocF > 0 && this.ocE != 0) {
            if (dVE >= this.ocF) {
                this.alpha = this.ocD;
            } else {
                this.alpha = ((int) ((((float) dVE) / ((float) this.ocF)) * this.ocE)) + this.ocC;
            }
        }
        float f2 = this.ocx;
        float f3 = this.ocy;
        long j2 = dVE - this.ocA;
        if (this.ocz > 0 && j2 >= 0 && j2 <= this.ocz) {
            if (this.ocH != null) {
                a[] aVarArr = this.ocH;
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
                    f2 = aVar.ocJ.x;
                    i++;
                    f = aVar.ocJ.y;
                }
                if (aVar != null) {
                    float f4 = aVar.ocK;
                    float f5 = aVar.eYe;
                    float f6 = ((float) (dVE - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.ocI.x;
                    float f8 = aVar.ocI.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float U = this.ocB ? U(j2, this.ocz) : ((float) j2) / ((float) this.ocz);
                if (this.eYd != 0.0f) {
                    f2 = (this.eYd * U) + this.ocx;
                }
                if (this.eYe != 0.0f) {
                    f = (U * this.eYe) + this.ocy;
                }
                f = f3;
            }
        } else {
            if (j2 > this.ocz) {
                f2 = this.kqS;
                f = this.kqT;
            }
            f = f3;
        }
        this.ocG[0] = f2;
        this.ocG[1] = f;
        this.ocG[2] = f2 + this.obO;
        this.ocG[3] = f + this.obP;
        setVisibility(!dVv());
        return this.ocG;
    }

    private static final float U(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVz() {
        return this.ocG[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVA() {
        return this.ocG[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVB() {
        return this.ocG[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVC() {
        return this.ocG[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.ocx = f;
        this.ocy = f2;
        this.kqS = f3;
        this.kqT = f4;
        this.eYd = f3 - f;
        this.eYe = f4 - f2;
        this.ocz = j;
        this.ocA = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.ocx = fArr[0][0];
            this.ocy = fArr[0][1];
            this.kqS = fArr[length - 1][0];
            this.kqT = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.ocH = new a[fArr.length - 1];
                for (int i = 0; i < this.ocH.length; i++) {
                    this.ocH[i] = new a();
                    this.ocH[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.ocH;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dVX() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.ocH;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dVX() / f) * ((float) this.ocz);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
