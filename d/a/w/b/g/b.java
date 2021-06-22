package d.a.w.b.g;

import android.opengl.Matrix;
/* loaded from: classes2.dex */
public class b implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public float[] f68584e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f68585f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68586g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68587h;

    public b() {
        float[] fArr = new float[16];
        this.f68584e = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        this.f68585f = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        this.f68586g = false;
        this.f68587h = false;
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
            bVar.g((float[]) this.f68584e.clone());
            bVar.h((float[]) this.f68585f.clone());
        }
        return bVar;
    }

    public float[] c() {
        return this.f68584e;
    }

    public float[] d() {
        return this.f68585f;
    }

    public boolean e() {
        return this.f68587h;
    }

    public boolean f() {
        return this.f68586g;
    }

    public void g(float[] fArr) {
        this.f68584e = fArr;
    }

    public void h(float[] fArr) {
        this.f68585f = fArr;
    }

    public void i(long j) {
    }
}
