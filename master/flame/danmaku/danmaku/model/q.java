package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class q extends d {
    public float eHw;
    public float eHx;
    public float jOk;
    public float jOl;
    public float nxZ;
    public float nya;
    public long nyb;
    public long nyc;
    public int nye;
    public int nyf;
    public int nyg;
    public long nyh;
    public a[] nyj;
    public boolean nyd = false;
    private float[] nyi = new float[4];

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
        public long duration;
        float eHx;
        public long endTime;
        b nyk;
        b nyl;
        float nym;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nyk = bVar;
            this.nyl = bVar2;
            this.nym = bVar2.x - bVar.x;
            this.eHx = bVar2.y - bVar.y;
        }

        public float dNR() {
            return this.nyl.a(this.nyk);
        }

        public float[] dNS() {
            return new float[]{this.nyk.x, this.nyk.y};
        }

        public float[] dNT() {
            return new float[]{this.nyl.x, this.nyl.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.nwQ.nxI);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dNn()) {
            return null;
        }
        long dNy = j - dNy();
        if (this.nyh > 0 && this.nyg != 0) {
            if (dNy >= this.nyh) {
                this.alpha = this.nyf;
            } else {
                this.alpha = ((int) ((((float) dNy) / ((float) this.nyh)) * this.nyg)) + this.nye;
            }
        }
        float f2 = this.nxZ;
        float f3 = this.nya;
        long j2 = dNy - this.nyc;
        if (this.nyb > 0 && j2 >= 0 && j2 <= this.nyb) {
            if (this.nyj != null) {
                a[] aVarArr = this.nyj;
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
                    f2 = aVar.nyl.x;
                    i++;
                    f = aVar.nyl.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nym;
                    float f5 = aVar.eHx;
                    float f6 = ((float) (dNy - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nyk.x;
                    float f8 = aVar.nyk.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float R = this.nyd ? R(j2, this.nyb) : ((float) j2) / ((float) this.nyb);
                if (this.eHw != 0.0f) {
                    f2 = (this.eHw * R) + this.nxZ;
                }
                if (this.eHx != 0.0f) {
                    f = (R * this.eHx) + this.nya;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nyb) {
                f2 = this.jOk;
                f = this.jOl;
            }
            f = f3;
        }
        this.nyi[0] = f2;
        this.nyi[1] = f;
        this.nyi[2] = f2 + this.nxq;
        this.nyi[3] = f + this.nxr;
        setVisibility(!dNp());
        return this.nyi;
    }

    private static final float R(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNt() {
        return this.nyi[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNu() {
        return this.nyi[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNv() {
        return this.nyi[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNw() {
        return this.nyi[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nxZ = f;
        this.nya = f2;
        this.jOk = f3;
        this.jOl = f4;
        this.eHw = f3 - f;
        this.eHx = f4 - f2;
        this.nyb = j;
        this.nyc = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nxZ = fArr[0][0];
            this.nya = fArr[0][1];
            this.jOk = fArr[length - 1][0];
            this.jOl = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nyj = new a[fArr.length - 1];
                for (int i = 0; i < this.nyj.length; i++) {
                    this.nyj[i] = new a();
                    this.nyj[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nyj;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dNR() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nyj;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dNR() / f) * ((float) this.nyb);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
