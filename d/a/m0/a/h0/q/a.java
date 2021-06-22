package d.a.m0.a.h0.q;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.m0.a.a2.d;
import d.a.m0.a.a2.e;
import d.a.m0.a.k;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46301a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46302b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final LruCache<String, Long> f46303c;

    /* renamed from: d.a.m0.a.h0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0755a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f46305f;

        public RunnableC0755a(String str, boolean z) {
            this.f46304e = str;
            this.f46305f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = a.f46301a ? System.currentTimeMillis() : 0L;
            Set<String> h2 = b.g().h(this.f46304e, true);
            if (h2 == null || h2.size() <= 0) {
                return;
            }
            if (a.f46301a) {
                Log.d("SwanPreLinkWhenPreload", "start prelink, swan is already launched - " + this.f46305f);
            }
            for (String str : h2) {
                if (a.d(str)) {
                    a.f46303c.put(str, Long.valueOf(System.currentTimeMillis()));
                    b.g().m(str);
                }
            }
            if (a.f46301a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPreLinkWhenPreload", " prelink - " + this.f46304e + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    static {
        f46303c = 0 != 0 ? new LruCache<>(10) : null;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (f46301a) {
            Log.d("SwanPreLinkWhenPreload", "prelink url - " + str);
            Log.d("SwanPreLinkWhenPreload", "prelink LRU size - " + f46303c.size());
        }
        Long l = f46303c.get(str);
        if (l == null) {
            if (f46301a) {
                Log.d("SwanPreLinkWhenPreload", "url not in LRU, do prelink");
            }
            return true;
        }
        boolean z = System.currentTimeMillis() - l.longValue() > 30000;
        if (f46301a) {
            Log.d("SwanPreLinkWhenPreload", "url in LRU, time is out - " + z);
        }
        return z;
    }

    public static void e(String str) {
        if (!f46302b) {
            if (f46301a) {
                Log.d("SwanPreLinkWhenPreload", "prelink by preload ab is off");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (f46301a) {
                Log.d("SwanPreLinkWhenPreload", "prelink by preload appId is empty");
            }
        } else {
            e r = d.g().r();
            if (r == null) {
                if (f46301a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload swanApp is null");
                }
            } else if (TextUtils.equals(r.f44533f, str)) {
                f(str, r.e());
            }
        }
    }

    public static void f(@NonNull String str, boolean z) {
        ExecutorUtilsExt.postOnSerial(new RunnableC0755a(str, z), "SwanPreLinkWhenPreload");
    }
}
