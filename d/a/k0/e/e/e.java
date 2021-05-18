package d.a.k0.e.e;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f54051b = new e();

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f54052a = new SparseArray<>();

    public static e b() {
        return f54051b;
    }

    public d a(int i2) {
        return this.f54052a.get(i2);
    }

    public void c(int i2, d dVar) {
        this.f54052a.put(i2, dVar);
    }
}
