package d.b.u.b.g;

import android.opengl.Matrix;
/* loaded from: classes2.dex */
public class b implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public float[] f64714e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f64715f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64716g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64717h;

    public b() {
        float[] fArr = new float[16];
        this.f64714e = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        this.f64715f = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        this.f64716g = false;
        this.f64717h = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public b clone() {
        b bVar;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            bVar = null;
        }
        if (bVar != null) {
            bVar.g((float[]) this.f64714e.clone());
            bVar.h((float[]) this.f64715f.clone());
        }
        return bVar;
    }

    public float[] c() {
        return this.f64714e;
    }

    public float[] d() {
        return this.f64715f;
    }

    public boolean e() {
        return this.f64717h;
    }

    public boolean f() {
        return this.f64716g;
    }

    public void g(float[] fArr) {
        this.f64714e = fArr;
    }

    public void h(float[] fArr) {
        this.f64715f = fArr;
    }

    public void i(long j) {
    }
}
