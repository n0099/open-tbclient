package d.a.l0.a.u.g;

import android.util.Log;
import d.a.l0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45234b = k.f43199a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f45235c;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f45236a;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f45236a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        if (f45235c == null) {
            synchronized (c.class) {
                if (f45235c == null) {
                    f45235c = new c();
                }
            }
        }
        return f45235c;
    }

    @Override // d.a.l0.a.u.g.a
    public void a(String str) {
        if (f45234b) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        for (int i2 = 0; i2 < this.f45236a.size(); i2++) {
            this.f45236a.get(i2).a(str);
        }
    }

    @Override // d.a.l0.a.u.g.a
    public void b(String str) {
        if (f45234b) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        for (int i2 = 0; i2 < this.f45236a.size(); i2++) {
            this.f45236a.get(i2).b(str);
        }
    }

    public synchronized void d() {
        if (f45234b) {
            Log.d("Api-Marker", "release: ");
        }
        if (f45235c == null) {
            return;
        }
        f45235c = null;
    }
}
