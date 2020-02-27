package tv.chushou.zues.toolkit.a.b;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class c<T> {
    private final Map<String, WeakReference<T>> nWB;

    public c() {
        this.nWB = new ArrayMap(4);
    }

    public c(int i) {
        this.nWB = new ArrayMap(i <= 0 ? 4 : i);
    }

    public void put(String str, T t) {
        if (!h.isEmpty(str) && t != null) {
            synchronized (this) {
                this.nWB.put(str, new WeakReference<>(t));
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
            WeakReference<T> weakReference = this.nWB.get(str);
            if (weakReference != null) {
                t = weakReference.get();
                if (t == null) {
                    this.nWB.remove(str);
                }
            } else {
                t = null;
            }
        }
        return t;
    }

    public void clear() {
        synchronized (this) {
            this.nWB.clear();
        }
    }
}
