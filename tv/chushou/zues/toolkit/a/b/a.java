package tv.chushou.zues.toolkit.a.b;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class a<T> {
    private final LruCache<String, T> nYx;
    private final Map<String, WeakReference<T>> nYy = new ArrayMap();

    public a(int i, final b<T> bVar) {
        this.nYx = new LruCache<String, T>(i <= 0 ? 8388608 : i) { // from class: tv.chushou.zues.toolkit.a.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.support.v4.util.LruCache
            /* renamed from: E */
            public int sizeOf(String str, T t) {
                if (bVar == null) {
                    return 1;
                }
                return bVar.E(str, t);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.support.v4.util.LruCache
            /* renamed from: a */
            public void entryRemoved(boolean z, String str, T t, T t2) {
                if (z && t != null) {
                    a.this.nYy.put(str, new WeakReference(t));
                }
            }
        };
    }

    public void put(String str, T t) {
        if (!h.isEmpty(str) && t != null) {
            synchronized (this) {
                this.nYx.put(str, t);
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
            T t2 = this.nYx.get(str);
            if (t2 != null || (weakReference = this.nYy.get(str)) == null) {
                t = t2;
            } else {
                t = weakReference.get();
                if (t != null) {
                    this.nYx.put(str, t);
                } else {
                    this.nYy.remove(str);
                }
            }
        }
        return t;
    }

    public void clear() {
        synchronized (this) {
            this.nYx.evictAll();
            this.nYy.clear();
        }
    }
}
