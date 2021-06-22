package d.a.m0.u;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.m0.u.c.b<T>> f52280a = new ArrayList(6);

    public void a(d.a.m0.u.c.b<T> bVar) {
        if (bVar == null || this.f52280a.contains(bVar)) {
            return;
        }
        this.f52280a.add(bVar);
    }

    public T b() {
        ArrayList<d.a.m0.u.c.b> arrayList = new ArrayList();
        Iterator<d.a.m0.u.c.b<T>> it = this.f52280a.iterator();
        T t = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.m0.u.c.b<T> next = it.next();
            T t2 = next.get();
            if (c(t2)) {
                t = t2;
                break;
            }
            arrayList.add(next);
            t = t2;
        }
        if (arrayList.size() > 0) {
            for (d.a.m0.u.c.b bVar : arrayList) {
                bVar.put(t);
            }
        }
        return t;
    }

    public final boolean c(T t) {
        char[] charArray;
        if (t != null && (t instanceof String)) {
            String str = (String) t;
            if (str.length() != 32) {
                return false;
            }
            for (char c2 : str.toCharArray()) {
                if ((c2 < 'A' || c2 > 'Z') && (c2 < '0' || c2 > '9')) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void d(T t) {
        if (c(t)) {
            return;
        }
        for (d.a.m0.u.c.b<T> bVar : this.f52280a) {
            if (bVar.a()) {
                bVar.put(t);
            }
        }
    }
}
