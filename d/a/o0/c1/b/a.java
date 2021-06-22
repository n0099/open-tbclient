package d.a.o0.c1.b;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f56129e = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    public int f56130a;

    /* renamed from: b  reason: collision with root package name */
    public int f56131b;

    /* renamed from: c  reason: collision with root package name */
    public int f56132c;

    /* renamed from: d  reason: collision with root package name */
    public int f56133d;

    public static a b() {
        synchronized (f56129e) {
            if (f56129e.size() > 0) {
                a remove = f56129e.remove(0);
                remove.f();
                return remove;
            }
            return new a();
        }
    }

    public static a c(int i2, int i3, int i4, int i5) {
        a b2 = b();
        b2.f56133d = i2;
        b2.f56130a = i3;
        b2.f56131b = i4;
        b2.f56132c = i5;
        return b2;
    }

    public static a d(int i2) {
        return c(2, i2, 0, 0);
    }

    public long a() {
        return this.f56133d == 1 ? ExpandableListView.getPackedPositionForChild(this.f56130a, this.f56131b) : ExpandableListView.getPackedPositionForGroup(this.f56130a);
    }

    public void e() {
        synchronized (f56129e) {
            if (f56129e.size() < 5) {
                f56129e.add(this);
            }
        }
    }

    public final void f() {
        this.f56130a = 0;
        this.f56131b = 0;
        this.f56132c = 0;
        this.f56133d = 0;
    }
}
