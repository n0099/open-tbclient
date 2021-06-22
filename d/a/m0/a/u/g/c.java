package d.a.m0.a.u.g;

import android.util.Log;
import d.a.m0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49016b = k.f46983a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f49017c;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f49018a;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f49018a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        if (f49017c == null) {
            synchronized (c.class) {
                if (f49017c == null) {
                    f49017c = new c();
                }
            }
        }
        return f49017c;
    }

    @Override // d.a.m0.a.u.g.a
    public void a(String str) {
        if (f49016b) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        for (int i2 = 0; i2 < this.f49018a.size(); i2++) {
            this.f49018a.get(i2).a(str);
        }
    }

    @Override // d.a.m0.a.u.g.a
    public void b(String str) {
        if (f49016b) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        for (int i2 = 0; i2 < this.f49018a.size(); i2++) {
            this.f49018a.get(i2).b(str);
        }
    }

    public synchronized void d() {
        if (f49016b) {
            Log.d("Api-Marker", "release: ");
        }
        if (f49017c == null) {
            return;
        }
        f49017c = null;
    }
}
