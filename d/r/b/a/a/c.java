package d.r.b.a.a;

import android.util.SparseArray;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static SparseArray<b> f66954a = new SparseArray<>();

    public static void a(int i2, b bVar) {
        f66954a.put(i2, bVar);
    }

    public static b b(int i2) {
        return f66954a.get(i2);
    }

    public static void c(int i2) {
        f66954a.remove(i2);
    }
}
