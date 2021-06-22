package d.a.c.k.c;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<c> f42989a = new SparseArray<>();

    public c a(int i2) {
        return this.f42989a.get(i2);
    }

    public boolean b(int i2) {
        c a2 = a(i2);
        return a2 != null && a2.b() > 0 && a2.a() > 0;
    }

    public boolean c(int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            return false;
        }
        this.f42989a.put(i2, new c(i3, i4));
        return true;
    }
}
