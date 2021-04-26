package d.a.h0.l.l.h.e;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f47167a = new ArrayList();

    public synchronized T c() {
        if (this.f47167a.isEmpty()) {
            return null;
        }
        T t = this.f47167a.get(0);
        this.f47167a.remove(0);
        return t;
    }

    public synchronized T d() {
        if (this.f47167a.isEmpty()) {
            return null;
        }
        return this.f47167a.get(0);
    }

    public T e(T t) {
        if (t != null) {
            for (int size = this.f47167a.size() - 1; size >= 0; size--) {
                if (t.equals(this.f47167a.get(size))) {
                    return this.f47167a.get(size);
                }
            }
            return null;
        }
        return null;
    }

    @NonNull
    public Iterator<T> f() {
        return this.f47167a.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(",Queue Size:" + this.f47167a.size());
        synchronized (this) {
            int i2 = 0;
            for (T t : this.f47167a) {
                sb.append(":[" + i2 + "]" + t);
                i2++;
            }
        }
        return sb.toString();
    }
}
