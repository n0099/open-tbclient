package d.b.t.b.g;

import android.opengl.Matrix;
/* loaded from: classes2.dex */
public class b implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public float[] f65409e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f65410f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65411g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65412h;

    public b() {
        float[] fArr = new float[16];
        this.f65409e = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        this.f65410f = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        this.f65411g = false;
        this.f65412h = false;
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
            bVar.g((float[]) this.f65409e.clone());
            bVar.h((float[]) this.f65410f.clone());
        }
        return bVar;
    }

    public float[] c() {
        return this.f65409e;
    }

    public float[] d() {
        return this.f65410f;
    }

    public boolean e() {
        return this.f65412h;
    }

    public boolean f() {
        return this.f65411g;
    }

    public void g(float[] fArr) {
        this.f65409e = fArr;
    }

    public void h(float[] fArr) {
        this.f65410f = fArr;
    }

    public void i(long j) {
    }
}
