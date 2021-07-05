package d.a.s0.n2.p;

import android.content.Context;
import android.os.Environment;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.turbonet.net.OkHttp3Interceptor;
import com.baidu.turbonet.net.TurbonetConfig;
import com.baidu.turbonet.net.TurbonetContext;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static OkHttpClient f64063a;

    /* renamed from: b  reason: collision with root package name */
    public static TurbonetContext f64064b;

    /* renamed from: c  reason: collision with root package name */
    public static long f64065c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f64066d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1588292747, "Ld/a/s0/n2/p/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1588292747, "Ld/a/s0/n2/p/c;");
        }
    }

    public static OkHttpClient a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            f64064b = g();
            OkHttp3Interceptor okHttp3Interceptor = new OkHttp3Interceptor(f64064b);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(15000L, TimeUnit.MILLISECONDS).readTimeout(15000L, TimeUnit.MILLISECONDS).addInterceptor(okHttp3Interceptor);
            return builder.build();
        }
        return (OkHttpClient) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        InterceptResult invokeV;
        String path;
        boolean equalsIgnoreCase;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (String) invokeV.objValue;
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f64063a == null) {
                f64063a = a();
            }
            return f64063a;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public static TurbonetConfig d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
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
        return (TurbonetConfig) invokeV.objValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            TurbonetContext turbonetContext = f64064b;
            if (turbonetContext != null && f64065c == 0) {
                f64065c = turbonetContext.c();
            }
            return f64065c;
        }
        return invokeV.longValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) || f64066d) {
            return;
        }
        f64066d = true;
        try {
            c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static TurbonetContext g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            TurbonetContext turbonetContext = new TurbonetContext(TbadkCoreApplication.getInst().getContext(), "tieba", TbadkCoreApplication.getInst().getCuid(), d());
            f64064b = turbonetContext;
            return turbonetContext;
        }
        return (TurbonetContext) invokeV.objValue;
    }
}
