package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d62;
import java.util.Set;
/* loaded from: classes6.dex */
public class i62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final q62 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public a(String str, boolean z, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = i62.a ? System.currentTimeMillis() : 0L;
                Set<String> m = j62.k().m(this.a, true);
                if (m == null || m.size() <= 0) {
                    return;
                }
                if (i62.a) {
                    Log.d("SwanPreLinkWhenPreload", "start prelink, swan is already launched - " + this.b);
                }
                for (String str : m) {
                    boolean b = i62.b(this.c, this.a, str);
                    c62 d = c62.d();
                    String str2 = this.c;
                    d62.b a = d62.a();
                    a.h(RecordType.PREFETCH_PRELINK);
                    a.f(str);
                    a.g(b);
                    d.f(str2, a.e());
                    if (b) {
                        j62.k().s(this.a, str);
                        i62.d(this.a, str);
                    }
                }
                if (i62.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPreLinkWhenPreload", " prelink - " + this.a + ", cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755666580, "Lcom/repackage/i62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755666580, "Lcom/repackage/i62;");
                return;
            }
        }
        a = jh1.a;
        b = s62.a();
    }

    public static boolean b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            return b.c(str, str2, str3);
        }
        return invokeLLL.booleanValue;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            if (!b.b()) {
                if (a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload ab is off");
                }
            } else if (TextUtils.isEmpty(str2)) {
                if (a) {
                    Log.d("SwanPreLinkWhenPreload", "prelink by preload appId is empty");
                }
            } else {
                z03 q = y03.K().q();
                if (q == null) {
                    if (a) {
                        Log.d("SwanPreLinkWhenPreload", "prelink by preload swanApp is null");
                    }
                } else if (TextUtils.equals(q.b, str2)) {
                    e(str, str2, q.I());
                }
            }
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || b.a() == null) {
            return;
        }
        b.a().b(str, str2, true);
    }

    public static void e(String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65541, null, str, str2, z) == null) {
            ExecutorUtilsExt.postOnSerial(new a(str2, z, str), "SwanPreLinkWhenPreload");
        }
    }
}
