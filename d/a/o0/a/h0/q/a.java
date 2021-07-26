package d.a.o0.a.h0.q;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.d;
import d.a.o0.a.a2.e;
import d.a.o0.a.k;
import java.util.Set;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45653a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45654b;

    /* renamed from: c  reason: collision with root package name */
    public static final LruCache<String, Long> f45655c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.h0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC0773a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45656e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45657f;

        public RunnableC0773a(String str, boolean z) {
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
            this.f45656e = str;
            this.f45657f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = a.f45653a ? System.currentTimeMillis() : 0L;
                Set<String> h2 = b.g().h(this.f45656e, true);
                if (h2 == null || h2.size() <= 0) {
                    return;
                }
                if (a.f45653a) {
                    Log.d("SwanPreLinkWhenPreload", "start prelink, swan is already launched - " + this.f45657f);
                }
                for (String str : h2) {
                    if (a.d(str)) {
                        a.f45655c.put(str, Long.valueOf(System.currentTimeMillis()));
                        b.g().m(str);
                    }
                }
                if (a.f45653a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPreLinkWhenPreload", " prelink - " + this.f45656e + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447549672, "Ld/a/o0/a/h0/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447549672, "Ld/a/o0/a/h0/q/a;");
                return;
            }
        }
        f45653a = k.f46335a;
        f45654b = false;
        f45655c = 0 != 0 ? new LruCache<>(10) : null;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f45653a) {
                Log.d("SwanPreLinkWhenPreload", "prelink url - " + str);
                Log.d("SwanPreLinkWhenPreload", "prelink LRU size - " + f45655c.size());
            }
            Long l = f45655c.get(str);
            if (l == null) {
                if (f45653a) {
                    Log.d("SwanPreLinkWhenPreload", "url not in LRU, do prelink");
                }
                return true;
            }
            boolean z = System.currentTimeMillis() - l.longValue() > 30000;
            if (f45653a) {
                Log.d("SwanPreLinkWhenPreload", "url in LRU, time is out - " + z);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            if (!f45654b) {
                if (f45653a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload ab is off");
                }
            } else if (TextUtils.isEmpty(str)) {
                if (f45653a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload appId is empty");
                }
            } else {
                e r = d.g().r();
                if (r == null) {
                    if (f45653a) {
                        Log.d("SwanPreLinkWhenPreload", "prelink by preload swanApp is null");
                    }
                } else if (TextUtils.equals(r.f43885f, str)) {
                    f(str, r.e());
                }
            }
        }
    }

    public static void f(@NonNull String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, str, z) == null) {
            ExecutorUtilsExt.postOnSerial(new RunnableC0773a(str, z), "SwanPreLinkWhenPreload");
        }
    }
}
