package d.a.q0.a.e0.f.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47387a;

    /* renamed from: b  reason: collision with root package name */
    public static String f47388b;

    /* renamed from: c  reason: collision with root package name */
    public static String f47389c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(399974196, "Ld/a/q0/a/e0/f/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(399974196, "Ld/a/q0/a/e0/f/e/e;");
                return;
            }
        }
        f47387a = k.f49133a;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return f47388b + "/swan-core/master/master.html";
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f47388b + "/swan-core/slaves/slaves.html";
        }
        return (String) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? TextUtils.equals(f47389c, "update_tag_by_remote_debug") : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? !TextUtils.isEmpty(f47388b) : invokeV.booleanValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            if (f47387a) {
                Log.d("RemoteDebugger", "Current launch mode is " + str);
            }
            f47389c = str;
            if (TextUtils.equals(str, "update_tag_by_activity_on_new_intent")) {
                d.g().o();
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            f47389c = "update_tag_by_remote_debug";
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            f47388b = str;
        }
    }
}
