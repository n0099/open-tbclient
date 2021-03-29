package d.b.g0.a.t.d;

import android.util.Log;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46211b = k.f45051a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f46212c;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f46213a;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f46213a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        if (f46212c == null) {
            synchronized (c.class) {
                if (f46212c == null) {
                    f46212c = new c();
                }
            }
        }
        return f46212c;
    }

    @Override // d.b.g0.a.t.d.a
    public void a(String str) {
        if (f46211b) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        for (int i = 0; i < this.f46213a.size(); i++) {
            this.f46213a.get(i).a(str);
        }
    }

    @Override // d.b.g0.a.t.d.a
    public void b(String str) {
        if (f46211b) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        for (int i = 0; i < this.f46213a.size(); i++) {
            this.f46213a.get(i).b(str);
        }
    }

    public synchronized void d() {
        if (f46211b) {
            Log.d("Api-Marker", "release: ");
        }
        if (f46212c == null) {
            return;
        }
        f46212c = null;
    }
}
