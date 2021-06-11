package d.a.w.b.g;

import android.opengl.Matrix;
/* loaded from: classes2.dex */
public class b implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public float[] f68480e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f68481f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68482g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68483h;

    public b() {
        float[] fArr = new float[16];
        this.f68480e = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        this.f68481f = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        this.f68482g = false;
        this.f68483h = false;
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
            bVar.g((float[]) this.f68480e.clone());
            bVar.h((float[]) this.f68481f.clone());
        }
        return bVar;
    }

    public float[] c() {
        return this.f68480e;
    }

    public float[] d() {
        return this.f68481f;
    }

    public boolean e() {
        return this.f68483h;
    }

    public boolean f() {
        return this.f68482g;
    }

    public void g(float[] fArr) {
        this.f68480e = fArr;
    }

    public void h(float[] fArr) {
        this.f68481f = fArr;
    }

    public void i(long j) {
    }
}
