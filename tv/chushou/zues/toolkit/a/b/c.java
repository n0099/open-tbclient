package tv.chushou.zues.toolkit.a.b;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class c<T> {
    private final Map<String, WeakReference<T>> nst;

    public c() {
        this.nst = new ArrayMap(4);
    }

    public c(int i) {
        this.nst = new ArrayMap(i <= 0 ? 4 : i);
    }

    public void put(String str, T t) {
        if (!h.isEmpty(str) && t != null) {
            synchronized (this) {
                this.nst.put(str, new WeakReference<>(t));
            }
        }
    }

    @Nullable
    public T get(String str) {
        T t;
        if (h.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            WeakReference<T> weakReference = this.nst.get(str);
            if (weakReference != null) {
                t = weakReference.get();
                if (t == null) {
                    this.nst.remove(str);
                }
            } else {
                t = null;
            }
        }
        return t;
    }

    public void clear() {
        synchronized (this) {
            this.nst.clear();
        }
    }
}
