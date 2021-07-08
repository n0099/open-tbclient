package d.d.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.dxmpay.statistics.internal.StatService;
import d.d.a.a.b.c;
import d.d.a.a.b.d;
import d.d.a.a.b.i;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static Context f69103d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.d.a.a.b.a f69104a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69105b;

    /* renamed from: c  reason: collision with root package name */
    public c f69106c;

    /* renamed from: d.d.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1968a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f69107a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2040013925, "Ld/d/a/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2040013925, "Ld/d/a/a/a$a;");
                    return;
                }
            }
            f69107a = new a(null);
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ a(b bVar) {
        this();
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f69103d == null && context != null) {
                f69103d = context.getApplicationContext();
            }
            return f69103d != null;
        }
        return invokeL.booleanValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f69103d : (Context) invokeV.objValue;
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? C1968a.f69107a : (a) invokeV.objValue;
    }

    public static void g(Context context, d.d.a.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, aVar) == null) {
            e();
            if (!b(context) || aVar == null) {
                return;
            }
            a e2 = e();
            e2.f69104a = aVar;
            try {
                if (e2.f69105b) {
                    return;
                }
                e2.f69105b = true;
                i.a().e();
                d.h().i("normal_log");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) || e().a()) {
            return;
        }
        u(str, null, str2);
    }

    public static void i(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, str, i2) == null) {
            l(str, i2, null, null);
        }
    }

    public static void j(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, str, i2, str2) == null) {
            l(str, i2, null, str2);
        }
    }

    public static void k(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i2, str2) == null) {
            l(str, i2, str2, null);
        }
    }

    public static void l(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65546, null, str, i2, str2, str3) == null) || e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.d(str, Integer.toString(i2), str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void m(String str, int i2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65547, null, str, i2, collection) == null) {
            p(str, i2, collection, null, null);
        }
    }

    public static void n(String str, int i2, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65548, null, str, i2, collection, str2) == null) {
            p(str, i2, collection, null, str2);
        }
    }

    public static void o(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65549, null, str, i2, collection, map) == null) {
            p(str, i2, collection, map, null);
        }
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, str) == null) || e().a()) {
            return;
        }
        w(str, null, null, null);
    }

    public static void p(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{str, Integer.valueOf(i2), collection, map, str2}) == null) || e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.g(str, Integer.toString(i2), collection, map, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, str) == null) || e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void r(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, str2) == null) {
            s(str, str2, null);
        }
    }

    public static void s(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65554, null, str, str2, str3) == null) || e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.c(str, str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void t(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, str, collection) == null) {
            w(str, collection, null, null);
        }
    }

    public static void u(String str, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, str, collection, str2) == null) {
            w(str, collection, null, str2);
        }
    }

    public static void v(String str, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, str, collection, map) == null) {
            w(str, collection, map, null);
        }
    }

    public static void w(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65558, null, str, collection, map, str2) == null) || e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.e(str, null, collection, map, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void x(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, cVar) == null) {
            e().f69106c = cVar;
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.d.a.a.b.a aVar = this.f69104a;
            if (aVar != null) {
                return aVar.isDisabled();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69106c : (c) invokeV.objValue;
    }

    public d.d.a.a.b.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69104a : (d.d.a.a.b.a) invokeV.objValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
