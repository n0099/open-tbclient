package d.a.l0.n.i.i.e;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f51706a = new ArrayList();

    public synchronized T c() {
        if (this.f51706a.isEmpty()) {
            return null;
        }
        T t = this.f51706a.get(0);
        this.f51706a.remove(0);
        return t;
    }

    public synchronized T d() {
        if (this.f51706a.isEmpty()) {
            return null;
        }
        return this.f51706a.get(0);
    }

    public T e(T t) {
        if (t != null) {
            for (int size = this.f51706a.size() - 1; size >= 0; size--) {
                if (t.equals(this.f51706a.get(size))) {
                    return this.f51706a.get(size);
                }
            }
            return null;
        }
        return null;
    }

    @NonNull
    public Iterator<T> f() {
        return this.f51706a.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(",Queue Size:" + this.f51706a.size());
        synchronized (this) {
            int i2 = 0;
            for (T t : this.f51706a) {
                sb.append(":[" + i2 + "]" + t);
                i2++;
            }
        }
        return sb.toString();
    }
}
