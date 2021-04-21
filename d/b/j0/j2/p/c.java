package d.b.j0.j2.p;

import android.content.Context;
import android.os.Environment;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.turbonet.net.OkHttp3Interceptor;
import com.baidu.turbonet.net.TurbonetConfig;
import com.baidu.turbonet.net.TurbonetContext;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static OkHttpClient f58051a = null;

    /* renamed from: b  reason: collision with root package name */
    public static TurbonetContext f58052b = null;

    /* renamed from: c  reason: collision with root package name */
    public static long f58053c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f58054d = false;

    public static OkHttpClient a() {
        f58052b = g();
        OkHttp3Interceptor okHttp3Interceptor = new OkHttp3Interceptor(f58052b);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15000L, TimeUnit.MILLISECONDS).readTimeout(15000L, TimeUnit.MILLISECONDS).addInterceptor(okHttp3Interceptor);
        return builder.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        String path;
        boolean equalsIgnoreCase;
        boolean z;
        Context context = TbadkCoreApplication.getInst().getContext();
        try {
            String externalStorageState = Environment.getExternalStorageState();
            equalsIgnoreCase = externalStorageState.equalsIgnoreCase("mounted");
            z = (equalsIgnoreCase || Environment.isExternalStorageRemovable() || externalStorageState.equalsIgnoreCase("shared")) ? false : true;
        } catch (Exception unused) {
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            path = cacheDir.getPath();
        }
        if (!equalsIgnoreCase && !z) {
            path = context.getCacheDir().getPath();
            return !path.endsWith(File.separator) ? path.substring(0, path.length() - 1) : path;
        }
        path = context.getExternalCacheDir().getPath();
        if (!path.endsWith(File.separator)) {
        }
    }

    public static OkHttpClient c() {
        if (f58051a == null) {
            f58051a = a();
        }
        return f58051a;
    }

    public static TurbonetConfig d() {
        TurbonetConfig turbonetConfig = new TurbonetConfig();
        turbonetConfig.j(15);
        turbonetConfig.c(true);
        turbonetConfig.b(true);
        turbonetConfig.e(true);
        turbonetConfig.a("http://tb-video.bdstatic.com|2");
        turbonetConfig.f(true);
        turbonetConfig.i("bdns", "bce_http_dns_account_id", "119799");
        turbonetConfig.i("bdns", "bce_http_dns_secret", "87JNTZjGacgUzuMBYvid");
        turbonetConfig.i("bdbus", "min_trigger_interval", 180);
        turbonetConfig.i("bdns", "dual_stack_bdns_cache_policy", 0);
        File file = new File(b(), "turbonetcache");
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                file.mkdirs();
            }
        } else {
            file.mkdirs();
        }
        turbonetConfig.k(file.getAbsolutePath());
        turbonetConfig.d(3, Config.FULL_TRACE_LOG_LIMIT);
        turbonetConfig.i(TbConfig.TMP_LOG_DIR_NAME, "lite_log_in_response_header", Boolean.TRUE);
        turbonetConfig.i("app", "app_package_name", "com.baidu.tieba");
        turbonetConfig.i("nq", "network_quality_enabled", Boolean.TRUE);
        turbonetConfig.i("nq", "watch_all", Boolean.TRUE);
        turbonetConfig.i("nq", "rejudge_interval_sec", 10);
        turbonetConfig.i("nq", "weak_window_sec", 30);
        turbonetConfig.i("nq", "weak_min_cnt", 10);
        turbonetConfig.i("nq", "probe_enabled", Boolean.FALSE);
        turbonetConfig.i("nq", "weak_policy_tcp_retrans_enable", Boolean.TRUE);
        turbonetConfig.i("nq", "weak_policy_tcp_retrans_percentage", 30);
        turbonetConfig.i("nq", "weak_policy_tcp_recv_len_enable", Boolean.FALSE);
        turbonetConfig.i("nq", "weak_policy_http_ttfb_enable", Boolean.TRUE);
        turbonetConfig.i("nq", "weak_policy_http_ttfb_threshold_ms", 800);
        turbonetConfig.i("nq", "weak_policy_http_ttfb_percentage", 30);
        turbonetConfig.i("nq", "weak_policy_tcp_rtt_enable", Boolean.TRUE);
        turbonetConfig.i("nq", "weak_policy_tcp_rtt_threshold_ms", 500);
        turbonetConfig.i("nq", "weak_policy_tcp_rtt_percentage", 30);
        turbonetConfig.i("misc", "preconnect_for_alter_quic", Boolean.TRUE);
        return turbonetConfig;
    }

    public static long e() {
        TurbonetContext turbonetContext = f58052b;
        if (turbonetContext != null && f58053c == 0) {
            f58053c = turbonetContext.c();
        }
        return f58053c;
    }

    public static void f() {
        if (f58054d) {
            return;
        }
        f58054d = true;
        try {
            c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static TurbonetContext g() {
        TurbonetContext turbonetContext = new TurbonetContext(TbadkCoreApplication.getInst().getContext(), "tieba", TbadkCoreApplication.getInst().getCuid(), d());
        f58052b = turbonetContext;
        return turbonetContext;
    }
}
