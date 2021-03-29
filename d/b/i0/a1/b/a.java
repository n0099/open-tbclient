package d.b.i0.a1.b;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f51871e = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    public int f51872a;

    /* renamed from: b  reason: collision with root package name */
    public int f51873b;

    /* renamed from: c  reason: collision with root package name */
    public int f51874c;

    /* renamed from: d  reason: collision with root package name */
    public int f51875d;

    public static a b() {
        synchronized (f51871e) {
            if (f51871e.size() > 0) {
                a remove = f51871e.remove(0);
                remove.f();
                return remove;
            }
            return new a();
        }
    }

    public static a c(int i, int i2, int i3, int i4) {
        a b2 = b();
        b2.f51875d = i;
        b2.f51872a = i2;
        b2.f51873b = i3;
        b2.f51874c = i4;
        return b2;
    }

    public static a d(int i) {
        return c(2, i, 0, 0);
    }

    public long a() {
        return this.f51875d == 1 ? ExpandableListView.getPackedPositionForChild(this.f51872a, this.f51873b) : ExpandableListView.getPackedPositionForGroup(this.f51872a);
    }

    public void e() {
        synchronized (f51871e) {
            if (f51871e.size() < 5) {
                f51871e.add(this);
            }
        }
    }

    public final void f() {
        this.f51872a = 0;
        this.f51873b = 0;
        this.f51874c = 0;
        this.f51875d = 0;
    }
}
