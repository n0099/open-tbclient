package d.a.i0.f.j.n;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public volatile HashMap<String, List<d.a.i0.f.j.p.a>> f46732a = new HashMap<>();

    public synchronized void a(String str, d.a.i0.f.j.p.a aVar) {
        if (e(str, aVar)) {
            return;
        }
        List<d.a.i0.f.j.p.a> c2 = c(str);
        if (!c2.contains(aVar)) {
            c2.add(aVar);
        }
        if (!this.f46732a.containsKey(str)) {
            this.f46732a.put(str, c2);
        }
    }

    public synchronized void b(String str, d.a.i0.f.j.q.a aVar) {
        for (d.a.i0.f.j.p.a aVar2 : new ArrayList(c(str))) {
            if (aVar2 != null) {
                aVar2.a(aVar);
            }
        }
    }

    public final List<d.a.i0.f.j.p.a> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        List<d.a.i0.f.j.p.a> list = this.f46732a.get(str);
        return list == null ? new ArrayList() : list;
    }

    public synchronized boolean d(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<d.a.i0.f.j.p.a> list = this.f46732a.get(str);
        if (list != null) {
            if (!list.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    public final boolean e(String str, d.a.i0.f.j.p.a aVar) {
        return TextUtils.isEmpty(str) || aVar == null;
    }

    public synchronized void f(String str) {
        g(str, null);
    }

    public synchronized void g(String str, d.a.i0.f.j.p.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar == null) {
            this.f46732a.remove(str);
            return;
        }
        List<d.a.i0.f.j.p.a> c2 = c(str);
        if (c2.contains(aVar)) {
            c2.remove(aVar);
            if (c2.isEmpty()) {
                this.f46732a.remove(str);
            }
        }
    }
}
