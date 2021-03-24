package d.b.i0.a1.b;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f51870e = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    public int f51871a;

    /* renamed from: b  reason: collision with root package name */
    public int f51872b;

    /* renamed from: c  reason: collision with root package name */
    public int f51873c;

    /* renamed from: d  reason: collision with root package name */
    public int f51874d;

    public static a b() {
        synchronized (f51870e) {
            if (f51870e.size() > 0) {
                a remove = f51870e.remove(0);
                remove.f();
                return remove;
            }
            return new a();
        }
    }

    public static a c(int i, int i2, int i3, int i4) {
        a b2 = b();
        b2.f51874d = i;
        b2.f51871a = i2;
        b2.f51872b = i3;
        b2.f51873c = i4;
        return b2;
    }

    public static a d(int i) {
        return c(2, i, 0, 0);
    }

    public long a() {
        return this.f51874d == 1 ? ExpandableListView.getPackedPositionForChild(this.f51871a, this.f51872b) : ExpandableListView.getPackedPositionForGroup(this.f51871a);
    }

    public void e() {
        synchronized (f51870e) {
            if (f51870e.size() < 5) {
                f51870e.add(this);
            }
        }
    }

    public final void f() {
        this.f51871a = 0;
        this.f51872b = 0;
        this.f51873c = 0;
        this.f51874d = 0;
    }
}
