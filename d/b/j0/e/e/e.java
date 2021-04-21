package d.b.j0.e.e;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f55498b = new e();

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f55499a = new SparseArray<>();

    public static e b() {
        return f55498b;
    }

    public d a(int i) {
        return this.f55499a.get(i);
    }

    public void c(int i, d dVar) {
        this.f55499a.put(i, dVar);
    }
}
