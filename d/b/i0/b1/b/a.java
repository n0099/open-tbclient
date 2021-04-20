package d.b.i0.b1.b;

import android.widget.ExpandableListView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f53291e = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    public int f53292a;

    /* renamed from: b  reason: collision with root package name */
    public int f53293b;

    /* renamed from: c  reason: collision with root package name */
    public int f53294c;

    /* renamed from: d  reason: collision with root package name */
    public int f53295d;

    public static a b() {
        synchronized (f53291e) {
            if (f53291e.size() > 0) {
                a remove = f53291e.remove(0);
                remove.f();
                return remove;
            }
            return new a();
        }
    }

    public static a c(int i, int i2, int i3, int i4) {
        a b2 = b();
        b2.f53295d = i;
        b2.f53292a = i2;
        b2.f53293b = i3;
        b2.f53294c = i4;
        return b2;
    }

    public static a d(int i) {
        return c(2, i, 0, 0);
    }

    public long a() {
        return this.f53295d == 1 ? ExpandableListView.getPackedPositionForChild(this.f53292a, this.f53293b) : ExpandableListView.getPackedPositionForGroup(this.f53292a);
    }

    public void e() {
        synchronized (f53291e) {
            if (f53291e.size() < 5) {
                f53291e.add(this);
            }
        }
    }

    public final void f() {
        this.f53292a = 0;
        this.f53293b = 0;
        this.f53294c = 0;
        this.f53295d = 0;
    }
}
