package d.a.q0.a.h0.q;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.d;
import d.a.q0.a.a2.e;
import d.a.q0.a.k;
import java.util.Set;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48451a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48452b;

    /* renamed from: c  reason: collision with root package name */
    public static final LruCache<String, Long> f48453c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.h0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class RunnableC0815a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f48455f;

        public RunnableC0815a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48454e = str;
            this.f48455f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = a.f48451a ? System.currentTimeMillis() : 0L;
                Set<String> h2 = b.g().h(this.f48454e, true);
                if (h2 == null || h2.size() <= 0) {
                    return;
                }
                if (a.f48451a) {
                    Log.d("SwanPreLinkWhenPreload", "start prelink, swan is already launched - " + this.f48455f);
                }
                for (String str : h2) {
                    if (a.d(str)) {
                        a.f48453c.put(str, Long.valueOf(System.currentTimeMillis()));
                        b.g().m(str);
                    }
                }
                if (a.f48451a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPreLinkWhenPreload", " prelink - " + this.f48454e + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705715110, "Ld/a/q0/a/h0/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705715110, "Ld/a/q0/a/h0/q/a;");
                return;
            }
        }
        f48451a = k.f49133a;
        f48452b = false;
        f48453c = 0 != 0 ? new LruCache<>(10) : null;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f48451a) {
                Log.d("SwanPreLinkWhenPreload", "prelink url - " + str);
                Log.d("SwanPreLinkWhenPreload", "prelink LRU size - " + f48453c.size());
            }
            Long l = f48453c.get(str);
            if (l == null) {
                if (f48451a) {
                    Log.d("SwanPreLinkWhenPreload", "url not in LRU, do prelink");
                }
                return true;
            }
            boolean z = System.currentTimeMillis() - l.longValue() > 30000;
            if (f48451a) {
                Log.d("SwanPreLinkWhenPreload", "url in LRU, time is out - " + z);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            if (!f48452b) {
                if (f48451a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload ab is off");
                }
            } else if (TextUtils.isEmpty(str)) {
                if (f48451a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload appId is empty");
                }
            } else {
                e r = d.g().r();
                if (r == null) {
                    if (f48451a) {
                        Log.d("SwanPreLinkWhenPreload", "prelink by preload swanApp is null");
                    }
                } else if (TextUtils.equals(r.f46683f, str)) {
                    f(str, r.e());
                }
            }
        }
    }

    public static void f(@NonNull String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, str, z) == null) {
            ExecutorUtilsExt.postOnSerial(new RunnableC0815a(str, z), "SwanPreLinkWhenPreload");
        }
    }
}
