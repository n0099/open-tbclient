package master.flame.danmaku.danmaku.model;
/* loaded from: classes6.dex */
public class q extends d {
    public float fiO;
    public float fiP;
    public float kGm;
    public float kGn;
    public int owB;
    public int owC;
    public int owD;
    public long owE;
    public a[] owG;
    public float oww;
    public float owx;
    public long owy;
    public long owz;
    public boolean owA = false;
    private float[] owF = new float[4];

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
        float fiP;
        b owH;
        b owI;
        float owJ;

        public a() {
        }

        public void a(b bVar, b bVar2) {
            this.owH = bVar;
            this.owI = bVar2;
            this.owJ = bVar2.x - bVar.x;
            this.fiP = bVar2.y - bVar.y;
        }

        public float eib() {
            return this.owI.a(this.owH);
        }

        public float[] eic() {
            return new float[]{this.owH.x, this.owH.y};
        }

        public float[] eid() {
            return new float[]{this.owI.x, this.owI.y};
        }
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void a(m mVar, float f, float f2) {
        a(mVar, this.ovp.owf);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] a(m mVar, long j) {
        float f;
        a aVar;
        if (!ehw()) {
            return null;
        }
        long ehI = j - ehI();
        if (this.owE > 0 && this.owD != 0) {
            if (ehI >= this.owE) {
                this.alpha = this.owC;
            } else {
                this.alpha = ((int) ((((float) ehI) / ((float) this.owE)) * this.owD)) + this.owB;
            }
        }
        float f2 = this.oww;
        float f3 = this.owx;
        long j2 = ehI - this.owz;
        if (this.owy > 0 && j2 >= 0 && j2 <= this.owy) {
            if (this.owG != null) {
                a[] aVarArr = this.owG;
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
                    f2 = aVar.owI.x;
                    i++;
                    f = aVar.owI.y;
                }
                if (aVar != null) {
                    float f4 = aVar.owJ;
                    float f5 = aVar.fiP;
                    float f6 = ((float) (ehI - aVar.beginTime)) / ((float) aVar.duration);
                    float f7 = aVar.owH.x;
                    float f8 = aVar.owH.y;
                    if (f4 != 0.0f) {
                        f2 = (f4 * f6) + f7;
                    }
                    if (f5 != 0.0f) {
                        f = (f5 * f6) + f8;
                    }
                }
            } else {
                float U = this.owA ? U(j2, this.owy) : ((float) j2) / ((float) this.owy);
                if (this.fiO != 0.0f) {
                    f2 = (this.fiO * U) + this.oww;
                }
                if (this.fiP != 0.0f) {
                    f = (U * this.fiP) + this.owx;
                }
                f = f3;
            }
        } else {
            if (j2 > this.owy) {
                f2 = this.kGm;
                f = this.kGn;
            }
            f = f3;
        }
        this.owF[0] = f2;
        this.owF[1] = f;
        this.owF[2] = f2 + this.ovO;
        this.owF[3] = f + this.ovP;
        setVisibility(!ehz());
        return this.owF;
    }

    private static final float U(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (f - 2.0f) * (-1.0f) * f;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehD() {
        return this.owF[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehE() {
        return this.owF[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehF() {
        return this.owF[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float ehG() {
        return this.owF[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    public void a(float f, float f2, float f3, float f4, long j, long j2) {
        this.oww = f;
        this.owx = f2;
        this.kGm = f3;
        this.kGn = f4;
        this.fiO = f3 - f;
        this.fiP = f4 - f2;
        this.owy = j;
        this.owz = j2;
    }

    public void a(float[][] fArr) {
        if (fArr != null) {
            int length = fArr.length;
            this.oww = fArr[0][0];
            this.owx = fArr[0][1];
            this.kGm = fArr[length - 1][0];
            this.kGn = fArr[length - 1][1];
            if (fArr.length > 1) {
                this.owG = new a[fArr.length - 1];
                for (int i = 0; i < this.owG.length; i++) {
                    this.owG[i] = new a();
                    this.owG[i].a(new b(fArr[i][0], fArr[i][1]), new b(fArr[i + 1][0], fArr[i + 1][1]));
                }
                a[] aVarArr = this.owG;
                int length2 = aVarArr.length;
                float f = 0.0f;
                int i2 = 0;
                while (i2 < length2) {
                    i2++;
                    f = aVarArr[i2].eib() + f;
                }
                a aVar = null;
                a[] aVarArr2 = this.owG;
                int length3 = aVarArr2.length;
                int i3 = 0;
                while (i3 < length3) {
                    a aVar2 = aVarArr2[i3];
                    aVar2.duration = (aVar2.eib() / f) * ((float) this.owy);
                    aVar2.beginTime = aVar == null ? 0L : aVar.endTime;
                    aVar2.endTime = aVar2.beginTime + aVar2.duration;
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }
}
