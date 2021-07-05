package d.a.q0.a.v2;

import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes8.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Integer> f51347a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Integer> f51348b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<Integer> f51349c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(129924042, "Ld/a/q0/a/v2/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(129924042, "Ld/a/q0/a/v2/k;");
                return;
            }
        }
        f51347a = new HashSet();
        f51348b = new HashSet();
        f51349c = new HashSet();
        f51347a.add(2);
        f51347a.add(3);
        f51347a.add(4);
        f51347a.add(5);
        f51347a.add(6);
        f51348b.add(7);
        f51348b.add(1);
        f51349c.addAll(f51347a);
        f51349c.addAll(f51348b);
    }

    public static Date a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new Date() : (Date) invokeV.objValue;
    }

    public static String b(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, date, str)) == null) {
            if (date == null) {
                return "";
            }
            try {
                return new SimpleDateFormat(str, Locale.getDefault()).format(date);
            } catch (Exception unused) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static Date c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            } catch (Exception unused) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return (Date) invokeLL.objValue;
    }

    public static Date d(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, strArr)) == null) {
            Date date = null;
            if (!TextUtils.isEmpty(str) && strArr != null) {
                for (String str2 : strArr) {
                    try {
                        date = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (date != null) {
                        break;
                    }
                }
            }
            return date;
        }
        return (Date) invokeLL.objValue;
    }

    public static String e(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, date, str)) == null) {
            if (date == null) {
                return "";
            }
            try {
                return new SimpleDateFormat(str, Locale.getDefault()).format(date);
            } catch (Exception unused) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean f(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, l, l2)) == null) ? l.longValue() / 86400000 == l2.longValue() / 86400000 : invokeLL.booleanValue;
    }

    public static String g(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65543, null, j, str)) == null) {
            try {
                return new SimpleDateFormat((str == null || str.isEmpty()) ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
            } catch (NumberFormatException e2) {
                if (d.a.q0.a.k.f49133a) {
                    e2.printStackTrace();
                    return "";
                }
                return "";
            }
        }
        return (String) invokeJL.objValue;
    }
}
