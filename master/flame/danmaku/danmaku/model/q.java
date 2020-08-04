package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class q extends d {
    public float eYd;
    public float eYe;
    public float kqU;
    public float kqV;
    public float ocA;
    public long ocB;
    public long ocC;
    public int ocE;
    public int ocF;
    public int ocG;
    public long ocH;
    public a[] ocJ;
    public float ocz;
    public boolean ocD = false;
    private float[] ocI = new float[4];

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
        b ocK;
        b ocL;
        float ocM;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.ocK = bVar;
            this.ocL = bVar2;
            this.ocM = bVar2.x - bVar.x;
            this.eYe = bVar2.y - bVar.y;
        }

        public float dVY() {
            return this.ocL.a(this.ocK);
        }

        public float[] dVZ() {
            return new float[]{this.ocK.x, this.ocK.y};
        }

        public float[] dWa() {
            return new float[]{this.ocL.x, this.ocL.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.obr.och);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dVu()) {
            return null;
        }
        long dVF = j - dVF();
        if (this.ocH > 0 && this.ocG != 0) {
            if (dVF >= this.ocH) {
                this.alpha = this.ocF;
            } else {
                this.alpha = ((int) ((((float) dVF) / ((float) this.ocH)) * this.ocG)) + this.ocE;
            }
        }
        float f2 = this.ocz;
        float f3 = this.ocA;
        long j2 = dVF - this.ocC;
        if (this.ocB > 0 && j2 >= 0 && j2 <= this.ocB) {
            if (this.ocJ != null) {
                a[] aVarArr = this.ocJ;
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
                    f2 = aVar.ocL.x;
                    i++;
                    f = aVar.ocL.y;
                }
                if (aVar != null) {
                    float f4 = aVar.ocM;
                    float f5 = aVar.eYe;
                    float f6 = ((float) (dVF - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.ocK.x;
                    float f8 = aVar.ocK.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float U = this.ocD ? U(j2, this.ocB) : ((float) j2) / ((float) this.ocB);
                if (this.eYd != 0.0f) {
                    f2 = (this.eYd * U) + this.ocz;
                }
                if (this.eYe != 0.0f) {
                    f = (U * this.eYe) + this.ocA;
                }
                f = f3;
            }
        } else {
            if (j2 > this.ocB) {
                f2 = this.kqU;
                f = this.kqV;
            }
            f = f3;
        }
        this.ocI[0] = f2;
        this.ocI[1] = f;
        this.ocI[2] = f2 + this.obQ;
        this.ocI[3] = f + this.obR;
        setVisibility(!dVw());
        return this.ocI;
    }

    private static final float U(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVA() {
        return this.ocI[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVB() {
        return this.ocI[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVC() {
        return this.ocI[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dVD() {
        return this.ocI[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.ocz = f;
        this.ocA = f2;
        this.kqU = f3;
        this.kqV = f4;
        this.eYd = f3 - f;
        this.eYe = f4 - f2;
        this.ocB = j;
        this.ocC = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.ocz = fArr[0][0];
            this.ocA = fArr[0][1];
            this.kqU = fArr[length - 1][0];
            this.kqV = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.ocJ = new a[fArr.length - 1];
                for (int i = 0; i < this.ocJ.length; i++) {
                    this.ocJ[i] = new a();
                    this.ocJ[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.ocJ;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dVY() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.ocJ;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dVY() / f) * ((float) this.ocB);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
