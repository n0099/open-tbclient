package d.a.o0.e.e;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f56560b = new e();

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f56561a = new SparseArray<>();

    public static e b() {
        return f56560b;
    }

    public d a(int i2) {
        return this.f56561a.get(i2);
    }

    public void c(int i2, d dVar) {
        this.f56561a.put(i2, dVar);
    }
}
