package d.b.h0.l.l.h.e;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f49657a = new ArrayList();

    public synchronized T c() {
        if (this.f49657a.isEmpty()) {
            return null;
        }
        T t = this.f49657a.get(0);
        this.f49657a.remove(0);
        return t;
    }

    public synchronized T d() {
        if (this.f49657a.isEmpty()) {
            return null;
        }
        return this.f49657a.get(0);
    }

    public T e(T t) {
        if (t != null) {
            for (int size = this.f49657a.size() - 1; size >= 0; size--) {
                if (t.equals(this.f49657a.get(size))) {
                    return this.f49657a.get(size);
                }
            }
            return null;
        }
        return null;
    }

    @NonNull
    public Iterator<T> f() {
        return this.f49657a.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(",Queue Size:" + this.f49657a.size());
        synchronized (this) {
            int i = 0;
            for (T t : this.f49657a) {
                sb.append(":[" + i + "]" + t);
                i++;
            }
        }
        return sb.toString();
    }
}
