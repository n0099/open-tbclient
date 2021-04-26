package d.a.j0.e.e;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f53344b = new e();

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f53345a = new SparseArray<>();

    public static e b() {
        return f53344b;
    }

    public d a(int i2) {
        return this.f53345a.get(i2);
    }

    public void c(int i2, d dVar) {
        this.f53345a.put(i2, dVar);
    }
}
