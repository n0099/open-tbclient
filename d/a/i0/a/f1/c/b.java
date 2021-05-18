package d.a.i0.a.f1.c;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f41651b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, Object> f41652a;

    /* renamed from: d.a.i0.a.f1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0618b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f41653a = new b();
    }

    public static b c() {
        return C0618b.f41653a;
    }

    public synchronized void a() {
        if (this.f41652a != null) {
            this.f41652a.evictAll();
        }
    }

    public synchronized <RESULT> RESULT b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        RESULT result = (RESULT) this.f41652a.get(str);
        if (result == null) {
            if (f41651b) {
                Log.d("SwanAppLaunchCache", "doesn't hit the cache result, key = " + str);
            }
            return null;
        }
        try {
            if (f41651b) {
                Log.d("SwanAppLaunchCache", "hit the cache result, key = " + str);
            }
            return result;
        } catch (Exception e2) {
            if (f41651b) {
                Log.e("SwanAppLaunchCache", Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public synchronized <RESULT> void d(String str, RESULT result) {
        if (!TextUtils.isEmpty(str) && result != null) {
            if (f41651b) {
                Log.d("SwanAppLaunchCache", "putConfig key: " + str);
            }
            this.f41652a.put(str, result);
        }
    }

    public synchronized void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f41651b) {
            Log.d("SwanAppLaunchCache", "removeConfig key: " + str);
        }
        this.f41652a.remove(str);
    }

    public b() {
        this.f41652a = new LruCache<>(10);
    }
}
