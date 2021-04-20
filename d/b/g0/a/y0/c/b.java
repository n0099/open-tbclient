package d.b.g0.a.y0.c;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47472b = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, Object> f47473a;

    /* renamed from: d.b.g0.a.y0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0894b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f47474a = new b();
    }

    public static b c() {
        return C0894b.f47474a;
    }

    public synchronized void a() {
        if (this.f47473a != null) {
            this.f47473a.evictAll();
        }
    }

    public synchronized <RESULT> RESULT b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        RESULT result = (RESULT) this.f47473a.get(str);
        if (result == null) {
            if (f47472b) {
                Log.d("SwanAppLaunchCache", "doesn't hit the cache result, key = " + str);
            }
            return null;
        }
        try {
            if (f47472b) {
                Log.d("SwanAppLaunchCache", "hit the cache result, key = " + str);
            }
            return result;
        } catch (Exception e2) {
            if (f47472b) {
                Log.e("SwanAppLaunchCache", Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public synchronized <RESULT> void d(String str, RESULT result) {
        if (!TextUtils.isEmpty(str) && result != null) {
            if (f47472b) {
                Log.d("SwanAppLaunchCache", "putConfig key: " + str);
            }
            this.f47473a.put(str, result);
        }
    }

    public synchronized void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f47472b) {
            Log.d("SwanAppLaunchCache", "removeConfig key: " + str);
        }
        this.f47473a.remove(str);
    }

    public b() {
        this.f47473a = new LruCache<>(10);
    }
}
