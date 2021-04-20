package d.b.i0.e.e;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f55077b = new e();

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f55078a = new SparseArray<>();

    public static e b() {
        return f55077b;
    }

    public d a(int i) {
        return this.f55078a.get(i);
    }

    public void c(int i, d dVar) {
        this.f55078a.put(i, dVar);
    }
}
