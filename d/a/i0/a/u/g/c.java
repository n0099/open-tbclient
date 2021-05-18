package d.a.i0.a.u.g;

import android.util.Log;
import d.a.i0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45058b = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f45059c;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f45060a;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f45060a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        if (f45059c == null) {
            synchronized (c.class) {
                if (f45059c == null) {
                    f45059c = new c();
                }
            }
        }
        return f45059c;
    }

    @Override // d.a.i0.a.u.g.a
    public void a(String str) {
        if (f45058b) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        for (int i2 = 0; i2 < this.f45060a.size(); i2++) {
            this.f45060a.get(i2).a(str);
        }
    }

    @Override // d.a.i0.a.u.g.a
    public void b(String str) {
        if (f45058b) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        for (int i2 = 0; i2 < this.f45060a.size(); i2++) {
            this.f45060a.get(i2).b(str);
        }
    }

    public synchronized void d() {
        if (f45058b) {
            Log.d("Api-Marker", "release: ");
        }
        if (f45059c == null) {
            return;
        }
        f45059c = null;
    }
}
