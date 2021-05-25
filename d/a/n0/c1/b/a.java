package d.a.n0.c1.b;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f52315e = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    public int f52316a;

    /* renamed from: b  reason: collision with root package name */
    public int f52317b;

    /* renamed from: c  reason: collision with root package name */
    public int f52318c;

    /* renamed from: d  reason: collision with root package name */
    public int f52319d;

    public static a b() {
        synchronized (f52315e) {
            if (f52315e.size() > 0) {
                a remove = f52315e.remove(0);
                remove.f();
                return remove;
            }
            return new a();
        }
    }

    public static a c(int i2, int i3, int i4, int i5) {
        a b2 = b();
        b2.f52319d = i2;
        b2.f52316a = i3;
        b2.f52317b = i4;
        b2.f52318c = i5;
        return b2;
    }

    public static a d(int i2) {
        return c(2, i2, 0, 0);
    }

    public long a() {
        return this.f52319d == 1 ? ExpandableListView.getPackedPositionForChild(this.f52316a, this.f52317b) : ExpandableListView.getPackedPositionForGroup(this.f52316a);
    }

    public void e() {
        synchronized (f52315e) {
            if (f52315e.size() < 5) {
                f52315e.add(this);
            }
        }
    }

    public final void f() {
        this.f52316a = 0;
        this.f52317b = 0;
        this.f52318c = 0;
        this.f52319d = 0;
    }
}
