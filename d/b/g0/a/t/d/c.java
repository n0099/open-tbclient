package d.b.g0.a.t.d;

import android.util.Log;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46210b = k.f45050a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f46211c;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f46212a;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f46212a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        if (f46211c == null) {
            synchronized (c.class) {
                if (f46211c == null) {
                    f46211c = new c();
                }
            }
        }
        return f46211c;
    }

    @Override // d.b.g0.a.t.d.a
    public void a(String str) {
        if (f46210b) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        for (int i = 0; i < this.f46212a.size(); i++) {
            this.f46212a.get(i).a(str);
        }
    }

    @Override // d.b.g0.a.t.d.a
    public void b(String str) {
        if (f46210b) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        for (int i = 0; i < this.f46212a.size(); i++) {
            this.f46212a.get(i).b(str);
        }
    }

    public synchronized void d() {
        if (f46210b) {
            Log.d("Api-Marker", "release: ");
        }
        if (f46211c == null) {
            return;
        }
        f46211c = null;
    }
}
