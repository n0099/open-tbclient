package d.a.m0.g.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public volatile HashMap<String, List<d.a.m0.g.c.f.b>> f50768a = new HashMap<>();

    public synchronized void a(String str, d.a.m0.g.c.f.b bVar) {
        if (e(str, bVar)) {
            return;
        }
        List<d.a.m0.g.c.f.b> c2 = c(str);
        if (!c2.contains(bVar)) {
            c2.add(bVar);
        }
        if (!this.f50768a.containsKey(str)) {
            this.f50768a.put(str, c2);
        }
    }

    public synchronized void b(String str, d.a.m0.g.c.g.b bVar) {
        for (d.a.m0.g.c.f.b bVar2 : new ArrayList(c(str))) {
            if (bVar2 != null) {
                bVar2.b(bVar);
            }
        }
    }

    public final List<d.a.m0.g.c.f.b> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        List<d.a.m0.g.c.f.b> list = this.f50768a.get(str);
        return list == null ? new ArrayList() : list;
    }

    public synchronized boolean d(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<d.a.m0.g.c.f.b> list = this.f50768a.get(str);
        if (list != null) {
            if (!list.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    public final boolean e(String str, d.a.m0.g.c.f.b bVar) {
        return TextUtils.isEmpty(str) || bVar == null;
    }

    public synchronized void f(String str) {
        g(str, null);
    }

    public synchronized void g(String str, d.a.m0.g.c.f.b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bVar == null) {
            this.f50768a.remove(str);
            return;
        }
        List<d.a.m0.g.c.f.b> c2 = c(str);
        if (c2.contains(bVar)) {
            c2.remove(bVar);
            if (c2.isEmpty()) {
                this.f50768a.remove(str);
            }
        }
    }
}
