package tv.chushou.zues.toolkit.a.b;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class a<T> {
    private final LruCache<String, T> oMQ;
    private final Map<String, WeakReference<T>> oMR = new ArrayMap();

    public a(int i, final b<T> bVar) {
        this.oMQ = new LruCache<String, T>(i <= 0 ? 8388608 : i) { // from class: tv.chushou.zues.toolkit.a.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.support.v4.util.LruCache
            /* renamed from: K */
            public int sizeOf(String str, T t) {
                if (bVar == null) {
                    return 1;
                }
                return bVar.K(str, t);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.support.v4.util.LruCache
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, T t, T t2) {
                if (z && t != null) {
                    a.this.oMR.put(str, new WeakReference(t));
                }
            }
        };
    }

    public void put(String str, T t) {
        if (!h.isEmpty(str) && t != null) {
            synchronized (this) {
                this.oMQ.put(str, t);
            }
        }
    }

    @Nullable
    public T get(String str) {
        T t;
        WeakReference<T> weakReference;
        if (h.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            T t2 = this.oMQ.get(str);
            if (t2 != null || (weakReference = this.oMR.get(str)) == null) {
                t = t2;
            } else {
                t = weakReference.get();
                if (t != null) {
                    this.oMQ.put(str, t);
                } else {
                    this.oMR.remove(str);
                }
            }
        }
        return t;
    }

    public void clear() {
        synchronized (this) {
            this.oMQ.evictAll();
            this.oMR.clear();
        }
    }
}
