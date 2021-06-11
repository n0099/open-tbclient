package d.a.n0.c1.b;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f56004e = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    public int f56005a;

    /* renamed from: b  reason: collision with root package name */
    public int f56006b;

    /* renamed from: c  reason: collision with root package name */
    public int f56007c;

    /* renamed from: d  reason: collision with root package name */
    public int f56008d;

    public static a b() {
        synchronized (f56004e) {
            if (f56004e.size() > 0) {
                a remove = f56004e.remove(0);
                remove.f();
                return remove;
            }
            return new a();
        }
    }

    public static a c(int i2, int i3, int i4, int i5) {
        a b2 = b();
        b2.f56008d = i2;
        b2.f56005a = i3;
        b2.f56006b = i4;
        b2.f56007c = i5;
        return b2;
    }

    public static a d(int i2) {
        return c(2, i2, 0, 0);
    }

    public long a() {
        return this.f56008d == 1 ? ExpandableListView.getPackedPositionForChild(this.f56005a, this.f56006b) : ExpandableListView.getPackedPositionForGroup(this.f56005a);
    }

    public void e() {
        synchronized (f56004e) {
            if (f56004e.size() < 5) {
                f56004e.add(this);
            }
        }
    }

    public final void f() {
        this.f56005a = 0;
        this.f56006b = 0;
        this.f56007c = 0;
        this.f56008d = 0;
    }
}
