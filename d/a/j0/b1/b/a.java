package d.a.j0.b1.b;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f51458e = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    public int f51459a;

    /* renamed from: b  reason: collision with root package name */
    public int f51460b;

    /* renamed from: c  reason: collision with root package name */
    public int f51461c;

    /* renamed from: d  reason: collision with root package name */
    public int f51462d;

    public static a b() {
        synchronized (f51458e) {
            if (f51458e.size() > 0) {
                a remove = f51458e.remove(0);
                remove.f();
                return remove;
            }
            return new a();
        }
    }

    public static a c(int i2, int i3, int i4, int i5) {
        a b2 = b();
        b2.f51462d = i2;
        b2.f51459a = i3;
        b2.f51460b = i4;
        b2.f51461c = i5;
        return b2;
    }

    public static a d(int i2) {
        return c(2, i2, 0, 0);
    }

    public long a() {
        return this.f51462d == 1 ? ExpandableListView.getPackedPositionForChild(this.f51459a, this.f51460b) : ExpandableListView.getPackedPositionForGroup(this.f51459a);
    }

    public void e() {
        synchronized (f51458e) {
            if (f51458e.size() < 5) {
                f51458e.add(this);
            }
        }
    }

    public final void f() {
        this.f51459a = 0;
        this.f51460b = 0;
        this.f51461c = 0;
        this.f51462d = 0;
    }
}
