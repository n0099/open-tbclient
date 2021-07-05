package d.a.r0.r.a0;

import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static a f55553a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f55554b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f55555c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f55556d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f55557e = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2116617424, "Ld/a/r0/r/a0/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2116617424, "Ld/a/r0/r/a0/b;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            a aVar = f55553a;
            if (aVar == null) {
                return -1;
            }
            return aVar.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public static Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a aVar = f55553a;
            if (aVar == null) {
                return null;
            }
            return aVar.d();
        }
        return (Class) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            a aVar = f55553a;
            if (aVar == null) {
                return null;
            }
            return aVar.f();
        }
        return (String) invokeV.objValue;
    }

    public static void d(Context context) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, context) == null) || (aVar = f55553a) == null) {
            return;
        }
        aVar.a(context);
    }

    public static void e(Context context, int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, context, i2) == null) || (aVar = f55553a) == null) {
            return;
        }
        aVar.b(context, i2);
    }

    public static void f(Context context, int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = f55553a) == null) {
            return;
        }
        aVar.c(context, i2, z);
    }

    public static void g(Context context, int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = f55553a) == null) {
            return;
        }
        aVar.e(context, i2, z);
    }

    public static void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, aVar) == null) {
            f55553a = aVar;
        }
    }
}
