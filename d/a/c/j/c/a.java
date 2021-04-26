package d.a.c.j.c;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<c> f40296a = new SparseArray<>();

    public c a(int i2) {
        return this.f40296a.get(i2);
    }

    public boolean b(int i2) {
        c a2 = a(i2);
        return a2 != null && a2.b() > 0 && a2.a() > 0;
    }

    public boolean c(int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            return false;
        }
        this.f40296a.put(i2, new c(i3, i4));
        return true;
    }
}
