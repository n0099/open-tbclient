package d.a.n0.e.e;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f52746b = new e();

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f52747a = new SparseArray<>();

    public static e b() {
        return f52746b;
    }

    public d a(int i2) {
        return this.f52747a.get(i2);
    }

    public void c(int i2, d dVar) {
        this.f52747a.put(i2, dVar);
    }
}
