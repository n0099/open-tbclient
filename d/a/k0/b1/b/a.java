package d.a.k0.b1.b;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f52157e = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    public int f52158a;

    /* renamed from: b  reason: collision with root package name */
    public int f52159b;

    /* renamed from: c  reason: collision with root package name */
    public int f52160c;

    /* renamed from: d  reason: collision with root package name */
    public int f52161d;

    public static a b() {
        synchronized (f52157e) {
            if (f52157e.size() > 0) {
                a remove = f52157e.remove(0);
                remove.f();
                return remove;
            }
            return new a();
        }
    }

    public static a c(int i2, int i3, int i4, int i5) {
        a b2 = b();
        b2.f52161d = i2;
        b2.f52158a = i3;
        b2.f52159b = i4;
        b2.f52160c = i5;
        return b2;
    }

    public static a d(int i2) {
        return c(2, i2, 0, 0);
    }

    public long a() {
        return this.f52161d == 1 ? ExpandableListView.getPackedPositionForChild(this.f52158a, this.f52159b) : ExpandableListView.getPackedPositionForGroup(this.f52158a);
    }

    public void e() {
        synchronized (f52157e) {
            if (f52157e.size() < 5) {
                f52157e.add(this);
            }
        }
    }

    public final void f() {
        this.f52158a = 0;
        this.f52159b = 0;
        this.f52160c = 0;
        this.f52161d = 0;
    }
}
