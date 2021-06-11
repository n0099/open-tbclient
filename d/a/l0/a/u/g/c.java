package d.a.l0.a.u.g;

import android.util.Log;
import d.a.l0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48908b = k.f46875a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f48909c;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f48910a;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f48910a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        if (f48909c == null) {
            synchronized (c.class) {
                if (f48909c == null) {
                    f48909c = new c();
                }
            }
        }
        return f48909c;
    }

    @Override // d.a.l0.a.u.g.a
    public void a(String str) {
        if (f48908b) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        for (int i2 = 0; i2 < this.f48910a.size(); i2++) {
            this.f48910a.get(i2).a(str);
        }
    }

    @Override // d.a.l0.a.u.g.a
    public void b(String str) {
        if (f48908b) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        for (int i2 = 0; i2 < this.f48910a.size(); i2++) {
            this.f48910a.get(i2).b(str);
        }
    }

    public synchronized void d() {
        if (f48908b) {
            Log.d("Api-Marker", "release: ");
        }
        if (f48909c == null) {
            return;
        }
        f48909c = null;
    }
}
