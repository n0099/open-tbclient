package d.a.n0.e.e;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f56435b = new e();

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f56436a = new SparseArray<>();

    public static e b() {
        return f56435b;
    }

    public d a(int i2) {
        return this.f56436a.get(i2);
    }

    public void c(int i2, d dVar) {
        this.f56436a.put(i2, dVar);
    }
}
