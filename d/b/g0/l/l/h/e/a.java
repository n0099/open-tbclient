package d.b.g0.l.l.h.e;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f48936a = new ArrayList();

    public synchronized T c() {
        if (this.f48936a.isEmpty()) {
            return null;
        }
        T t = this.f48936a.get(0);
        this.f48936a.remove(0);
        return t;
    }

    public synchronized T d() {
        if (this.f48936a.isEmpty()) {
            return null;
        }
        return this.f48936a.get(0);
    }

    public T e(T t) {
        if (t != null) {
            for (int size = this.f48936a.size() - 1; size >= 0; size--) {
                if (t.equals(this.f48936a.get(size))) {
                    return this.f48936a.get(size);
                }
            }
            return null;
        }
        return null;
    }

    @NonNull
    public Iterator<T> f() {
        return this.f48936a.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(",Queue Size:" + this.f48936a.size());
        synchronized (this) {
            int i = 0;
            for (T t : this.f48936a) {
                sb.append(":[" + i + "]" + t);
                i++;
            }
        }
        return sb.toString();
    }
}
