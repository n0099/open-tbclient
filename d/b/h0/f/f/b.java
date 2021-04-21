package d.b.h0.f.f;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public volatile HashMap<String, List<d.b.h0.f.f.f.b>> f48488a = new HashMap<>();

    public synchronized void a(String str, d.b.h0.f.f.f.b bVar) {
        if (e(str, bVar)) {
            return;
        }
        List<d.b.h0.f.f.f.b> c2 = c(str);
        if (!c2.contains(bVar)) {
            c2.add(bVar);
        }
        if (!this.f48488a.containsKey(str)) {
            this.f48488a.put(str, c2);
        }
    }

    public synchronized void b(String str, d.b.h0.f.f.g.b bVar) {
        for (d.b.h0.f.f.f.b bVar2 : new ArrayList(c(str))) {
            if (bVar2 != null) {
                bVar2.a(bVar);
            }
        }
    }

    public final List<d.b.h0.f.f.f.b> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        List<d.b.h0.f.f.f.b> list = this.f48488a.get(str);
        return list == null ? new ArrayList() : list;
    }

    public synchronized boolean d(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<d.b.h0.f.f.f.b> list = this.f48488a.get(str);
        if (list != null) {
            if (!list.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    public final boolean e(String str, d.b.h0.f.f.f.b bVar) {
        return TextUtils.isEmpty(str) || bVar == null;
    }

    public synchronized void f(String str) {
        g(str, null);
    }

    public synchronized void g(String str, d.b.h0.f.f.f.b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bVar == null) {
            this.f48488a.remove(str);
            return;
        }
        List<d.b.h0.f.f.f.b> c2 = c(str);
        if (c2.contains(bVar)) {
            c2.remove(bVar);
            if (c2.isEmpty()) {
                this.f48488a.remove(str);
            }
        }
    }
}
