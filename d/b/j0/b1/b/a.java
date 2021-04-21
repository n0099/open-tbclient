package d.b.j0.b1.b;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f53712e = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    public int f53713a;

    /* renamed from: b  reason: collision with root package name */
    public int f53714b;

    /* renamed from: c  reason: collision with root package name */
    public int f53715c;

    /* renamed from: d  reason: collision with root package name */
    public int f53716d;

    public static a b() {
        synchronized (f53712e) {
            if (f53712e.size() > 0) {
                a remove = f53712e.remove(0);
                remove.f();
                return remove;
            }
            return new a();
        }
    }

    public static a c(int i, int i2, int i3, int i4) {
        a b2 = b();
        b2.f53716d = i;
        b2.f53713a = i2;
        b2.f53714b = i3;
        b2.f53715c = i4;
        return b2;
    }

    public static a d(int i) {
        return c(2, i, 0, 0);
    }

    public long a() {
        return this.f53716d == 1 ? ExpandableListView.getPackedPositionForChild(this.f53713a, this.f53714b) : ExpandableListView.getPackedPositionForGroup(this.f53713a);
    }

    public void e() {
        synchronized (f53712e) {
            if (f53712e.size() < 5) {
                f53712e.add(this);
            }
        }
    }

    public final void f() {
        this.f53713a = 0;
        this.f53714b = 0;
        this.f53715c = 0;
        this.f53716d = 0;
    }
}
