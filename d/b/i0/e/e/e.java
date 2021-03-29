package d.b.i0.e.e;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f54194b = new e();

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f54195a = new SparseArray<>();

    public static e b() {
        return f54194b;
    }

    public d a(int i) {
        return this.f54195a.get(i);
    }

    public void c(int i, d dVar) {
        this.f54195a.put(i, dVar);
    }
}
