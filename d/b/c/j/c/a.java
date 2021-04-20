package d.b.c.j.c;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<c> f42834a = new SparseArray<>();

    public c a(int i) {
        return this.f42834a.get(i);
    }

    public boolean b(int i) {
        c a2 = a(i);
        return a2 != null && a2.b() > 0 && a2.a() > 0;
    }

    public boolean c(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.f42834a.put(i, new c(i2, i3));
        return true;
    }
}
