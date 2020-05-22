package master.flame.danmaku.danmaku.model;
/* loaded from: classes5.dex */
public class q extends d {
    public float eHl;
    public float eHm;
    public float jNe;
    public float jNf;
    public float nwP;
    public float nwQ;
    public long nwR;
    public long nwS;
    public int nwU;
    public int nwV;
    public int nwW;
    public long nwX;
    public a[] nwZ;
    public boolean nwT = false;
    private float[] nwY = new float[4];

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
        float eHm;
        public long endTime;
        b nxa;
        b nxb;
        float nxc;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.nxa = bVar;
            this.nxb = bVar2;
            this.nxc = bVar2.x - bVar.x;
            this.eHm = bVar2.y - bVar.y;
        }

        public float dND() {
            return this.nxb.a(this.nxa);
        }

        public float[] dNE() {
            return new float[]{this.nxa.x, this.nxa.y};
        }

        public float[] dNF() {
            return new float[]{this.nxb.x, this.nxb.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.nvG.nwy);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!dMZ()) {
            return null;
        }
        long dNk = j - dNk();
        if (this.nwX > 0 && this.nwW != 0) {
            if (dNk >= this.nwX) {
                this.alpha = this.nwV;
            } else {
                this.alpha = ((int) ((((float) dNk) / ((float) this.nwX)) * this.nwW)) + this.nwU;
            }
        }
        float f2 = this.nwP;
        float f3 = this.nwQ;
        long j2 = dNk - this.nwS;
        if (this.nwR > 0 && j2 >= 0 && j2 <= this.nwR) {
            if (this.nwZ != null) {
                a[] aVarArr = this.nwZ;
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
                    f2 = aVar.nxb.x;
                    i++;
                    f = aVar.nxb.y;
                }
                if (aVar != null) {
                    float f4 = aVar.nxc;
                    float f5 = aVar.eHm;
                    float f6 = ((float) (dNk - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.nxa.x;
                    float f8 = aVar.nxa.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float R = this.nwT ? R(j2, this.nwR) : ((float) j2) / ((float) this.nwR);
                if (this.eHl != 0.0f) {
                    f2 = (this.eHl * R) + this.nwP;
                }
                if (this.eHm != 0.0f) {
                    f = (R * this.eHm) + this.nwQ;
                }
                f = f3;
            }
        } else {
            if (j2 > this.nwR) {
                f2 = this.jNe;
                f = this.jNf;
            }
            f = f3;
        }
        this.nwY[0] = f2;
        this.nwY[1] = f;
        this.nwY[2] = f2 + this.nwg;
        this.nwY[3] = f + this.nwh;
        setVisibility(!dNb());
        return this.nwY;
    }

    private static final float R(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNf() {
        return this.nwY[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNg() {
        return this.nwY[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNh() {
        return this.nwY[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float dNi() {
        return this.nwY[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.nwP = f;
        this.nwQ = f2;
        this.jNe = f3;
        this.jNf = f4;
        this.eHl = f3 - f;
        this.eHm = f4 - f2;
        this.nwR = j;
        this.nwS = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.nwP = fArr[0][0];
            this.nwQ = fArr[0][1];
            this.jNe = fArr[length - 1][0];
            this.jNf = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.nwZ = new a[fArr.length - 1];
                for (int i = 0; i < this.nwZ.length; i++) {
                    this.nwZ[i] = new a();
                    this.nwZ[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.nwZ;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].dND() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.nwZ;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.dND() / f) * ((float) this.nwR);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
