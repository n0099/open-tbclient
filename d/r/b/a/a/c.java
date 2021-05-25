package d.r.b.a.a;

import android.util.SparseArray;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static SparseArray<b> f67683a = new SparseArray<>();

    public static void a(int i2, b bVar) {
        f67683a.put(i2, bVar);
    }

    public static b b(int i2) {
        return f67683a.get(i2);
    }

    public static void c(int i2) {
        f67683a.remove(i2);
    }
}
