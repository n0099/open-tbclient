package d.a.l0.a.h0.q;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.l0.a.a2.d;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46193a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46194b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final LruCache<String, Long> f46195c;

    /* renamed from: d.a.l0.a.h0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0752a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46196e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f46197f;

        public RunnableC0752a(String str, boolean z) {
            this.f46196e = str;
            this.f46197f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = a.f46193a ? System.currentTimeMillis() : 0L;
            Set<String> h2 = b.g().h(this.f46196e, true);
            if (h2 == null || h2.size() <= 0) {
                return;
            }
            if (a.f46193a) {
                Log.d("SwanPreLinkWhenPreload", "start prelink, swan is already launched - " + this.f46197f);
            }
            for (String str : h2) {
                if (a.d(str)) {
                    a.f46195c.put(str, Long.valueOf(System.currentTimeMillis()));
                    b.g().m(str);
                }
            }
            if (a.f46193a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPreLinkWhenPreload", " prelink - " + this.f46196e + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    static {
        f46195c = 0 != 0 ? new LruCache<>(10) : null;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (f46193a) {
            Log.d("SwanPreLinkWhenPreload", "prelink url - " + str);
            Log.d("SwanPreLinkWhenPreload", "prelink LRU size - " + f46195c.size());
        }
        Long l = f46195c.get(str);
        if (l == null) {
            if (f46193a) {
                Log.d("SwanPreLinkWhenPreload", "url not in LRU, do prelink");
            }
            return true;
        }
        boolean z = System.currentTimeMillis() - l.longValue() > 30000;
        if (f46193a) {
            Log.d("SwanPreLinkWhenPreload", "url in LRU, time is out - " + z);
        }
        return z;
    }

    public static void e(String str) {
        if (!f46194b) {
            if (f46193a) {
                Log.d("SwanPreLinkWhenPreload", "prelink by preload ab is off");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (f46193a) {
                Log.d("SwanPreLinkWhenPreload", "prelink by preload appId is empty");
            }
        } else {
            e r = d.g().r();
            if (r == null) {
                if (f46193a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload swanApp is null");
                }
            } else if (TextUtils.equals(r.f44425f, str)) {
                f(str, r.e());
            }
        }
    }

    public static void f(@NonNull String str, boolean z) {
        ExecutorUtilsExt.postOnSerial(new RunnableC0752a(str, z), "SwanPreLinkWhenPreload");
    }
}
