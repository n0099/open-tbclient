package d.a.q0.a.l2.f;

import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f49360a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f49361b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f49362c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(17693170, "Ld/a/q0/a/l2/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(17693170, "Ld/a/q0/a/l2/f/b;");
                return;
            }
        }
        f49360a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        f49361b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f49362c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(str) || d(str) : invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int length = str.length();
            if (length > 2 && str.charAt(0) == '[') {
                int i2 = length - 1;
                if (str.charAt(i2) == ']') {
                    str = str.substring(1, i2);
                }
            }
            return a(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return f49360a.matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return f(str) || e(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return f49362c.matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return f49361b.matcher(str).matches();
        }
        return invokeL.booleanValue;
    }
}
