package d.a.l0.a.f1.c;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45501b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, Object> f45502a;

    /* renamed from: d.a.l0.a.f1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0685b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f45503a = new b();
    }

    public static b c() {
        return C0685b.f45503a;
    }

    public synchronized void a() {
        if (this.f45502a != null) {
            this.f45502a.evictAll();
        }
    }

    public synchronized <RESULT> RESULT b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        RESULT result = (RESULT) this.f45502a.get(str);
        if (result == null) {
            if (f45501b) {
                Log.d("SwanAppLaunchCache", "doesn't hit the cache result, key = " + str);
            }
            return null;
        }
        try {
            if (f45501b) {
                Log.d("SwanAppLaunchCache", "hit the cache result, key = " + str);
            }
            return result;
        } catch (Exception e2) {
            if (f45501b) {
                Log.e("SwanAppLaunchCache", Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public synchronized <RESULT> void d(String str, RESULT result) {
        if (!TextUtils.isEmpty(str) && result != null) {
            if (f45501b) {
                Log.d("SwanAppLaunchCache", "putConfig key: " + str);
            }
            this.f45502a.put(str, result);
        }
    }

    public synchronized void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f45501b) {
            Log.d("SwanAppLaunchCache", "removeConfig key: " + str);
        }
        this.f45502a.remove(str);
    }

    public b() {
        this.f45502a = new LruCache<>(10);
    }
}
