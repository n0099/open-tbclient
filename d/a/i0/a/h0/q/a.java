package d.a.i0.a.h0.q;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.a.i0.a.a2.d;
import d.a.i0.a.a2.e;
import d.a.i0.a.k;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42343a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42344b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final LruCache<String, Long> f42345c;

    /* renamed from: d.a.i0.a.h0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0685a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f42347f;

        public RunnableC0685a(String str, boolean z) {
            this.f42346e = str;
            this.f42347f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = a.f42343a ? System.currentTimeMillis() : 0L;
            Set<String> h2 = b.g().h(this.f42346e, true);
            if (h2 == null || h2.size() <= 0) {
                return;
            }
            if (a.f42343a) {
                Log.d("SwanPreLinkWhenPreload", "start prelink, swan is already launched - " + this.f42347f);
            }
            for (String str : h2) {
                if (a.d(str)) {
                    a.f42345c.put(str, Long.valueOf(System.currentTimeMillis()));
                    b.g().m(str);
                }
            }
            if (a.f42343a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPreLinkWhenPreload", " prelink - " + this.f42346e + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    static {
        f42345c = 0 != 0 ? new LruCache<>(10) : null;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (f42343a) {
            Log.d("SwanPreLinkWhenPreload", "prelink url - " + str);
            Log.d("SwanPreLinkWhenPreload", "prelink LRU size - " + f42345c.size());
        }
        Long l = f42345c.get(str);
        if (l == null) {
            if (f42343a) {
                Log.d("SwanPreLinkWhenPreload", "url not in LRU, do prelink");
            }
            return true;
        }
        boolean z = System.currentTimeMillis() - l.longValue() > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
        if (f42343a) {
            Log.d("SwanPreLinkWhenPreload", "url in LRU, time is out - " + z);
        }
        return z;
    }

    public static void e(String str) {
        if (!f42344b) {
            if (f42343a) {
                Log.d("SwanPreLinkWhenPreload", "prelink by preload ab is off");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (f42343a) {
                Log.d("SwanPreLinkWhenPreload", "prelink by preload appId is empty");
            }
        } else {
            e r = d.g().r();
            if (r == null) {
                if (f42343a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload swanApp is null");
                }
            } else if (TextUtils.equals(r.f40575f, str)) {
                f(str, r.e());
            }
        }
    }

    public static void f(@NonNull String str, boolean z) {
        ExecutorUtilsExt.postOnSerial(new RunnableC0685a(str, z), "SwanPreLinkWhenPreload");
    }
}
