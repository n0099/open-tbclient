package d.b.h0.a.t.d;

import android.util.Log;
import d.b.h0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46932b = k.f45772a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f46933c;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f46934a;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f46934a = arrayList;
        arrayList.add(new b());
    }

    public static c c() {
        if (f46933c == null) {
            synchronized (c.class) {
                if (f46933c == null) {
                    f46933c = new c();
                }
            }
        }
        return f46933c;
    }

    @Override // d.b.h0.a.t.d.a
    public void a(String str) {
        if (f46932b) {
            Log.d("Api-Marker", "markStart: " + str);
        }
        for (int i = 0; i < this.f46934a.size(); i++) {
            this.f46934a.get(i).a(str);
        }
    }

    @Override // d.b.h0.a.t.d.a
    public void b(String str) {
        if (f46932b) {
            Log.d("Api-Marker", "markEnd: " + str);
        }
        for (int i = 0; i < this.f46934a.size(); i++) {
            this.f46934a.get(i).b(str);
        }
    }

    public synchronized void d() {
        if (f46932b) {
            Log.d("Api-Marker", "release: ");
        }
        if (f46933c == null) {
            return;
        }
        f46933c = null;
    }
}
