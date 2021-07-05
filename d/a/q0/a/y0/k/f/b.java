package d.a.q0.a.y0.k.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.y0.k.f.c.c;
import d.a.q0.a.y0.k.f.c.d;
import d.a.q0.a.y0.k.f.c.e;
import d.a.q0.a.y0.k.f.c.f;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final e f51822a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f51823b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements d.a.q0.a.v2.e1.b<HybridUbcFlow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
                b.b().b(TextUtils.equals(hybridUbcFlow.k().optString("type"), "3") || hybridUbcFlow.n("na_first_meaningful_paint"), hybridUbcFlow);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1246201243, "Ld/a/q0/a/y0/k/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1246201243, "Ld/a/q0/a/y0/k/f/b;");
                return;
            }
        }
        f fVar = new f();
        f51822a = fVar;
        f51823b = fVar;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            b().c();
        }
    }

    @NonNull
    public static e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f51823b : (e) invokeV.objValue;
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, null, i2) == null) || i2 == 3) {
            return;
        }
        b().c();
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, str) == null) {
            e b2 = b();
            if (b2 != null && (b2 instanceof d.a.q0.a.y0.k.f.c.b)) {
                ((d.a.q0.a.y0.k.f.c.b) b2).f(str);
            } else {
                g(new d.a.q0.a.y0.k.f.c.b(str));
            }
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            if (TextUtils.equals(str, "3")) {
                g(new d(str));
            } else {
                g(new c(str));
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            g(f51822a);
        }
    }

    public static void g(@NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, eVar) == null) {
            f51823b = eVar;
        }
    }
}
