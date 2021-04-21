package d.b.u.b.g;

import android.opengl.Matrix;
/* loaded from: classes2.dex */
public class b implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public float[] f65673e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f65674f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65675g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65676h;

    public b() {
        float[] fArr = new float[16];
        this.f65673e = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        this.f65674f = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        this.f65675g = false;
        this.f65676h = false;
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
            bVar.g((float[]) this.f65673e.clone());
            bVar.h((float[]) this.f65674f.clone());
        }
        return bVar;
    }

    public float[] c() {
        return this.f65673e;
    }

    public float[] d() {
        return this.f65674f;
    }

    public boolean e() {
        return this.f65676h;
    }

    public boolean f() {
        return this.f65675g;
    }

    public void g(float[] fArr) {
        this.f65673e = fArr;
    }

    public void h(float[] fArr) {
        this.f65674f = fArr;
    }

    public void i(long j) {
    }
}
