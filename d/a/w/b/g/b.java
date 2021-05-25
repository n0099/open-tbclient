package d.a.w.b.g;

import android.opengl.Matrix;
/* loaded from: classes2.dex */
public class b implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public float[] f64762e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f64763f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64764g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64765h;

    public b() {
        float[] fArr = new float[16];
        this.f64762e = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        this.f64763f = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        this.f64764g = false;
        this.f64765h = false;
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
            bVar.g((float[]) this.f64762e.clone());
            bVar.h((float[]) this.f64763f.clone());
        }
        return bVar;
    }

    public float[] c() {
        return this.f64762e;
    }

    public float[] d() {
        return this.f64763f;
    }

    public boolean e() {
        return this.f64765h;
    }

    public boolean f() {
        return this.f64764g;
    }

    public void g(float[] fArr) {
        this.f64762e = fArr;
    }

    public void h(float[] fArr) {
        this.f64763f = fArr;
    }

    public void i(long j) {
    }
}
