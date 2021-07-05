package d.a.r0.z0;

import android.net.Uri;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f56944a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f56945b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-257393245, "Ld/a/r0/z0/e0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-257393245, "Ld/a/r0/z0/e0;");
                return;
            }
        }
        f56944a = Pattern.compile("http[s]?://tieba\\.baidu\\.com/f(.*)&jump_tieba_native=1(.*)");
        f56945b = Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1");
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d.a.r0.b.d.H()) {
                Date date = new Date(d.a.r0.r.d0.b.j().l("show_login_dialog_strategy_key", 0L));
                long currentTimeMillis = System.currentTimeMillis();
                Date date2 = new Date(currentTimeMillis);
                d.a.r0.r.d0.b.j().w("show_login_dialog_strategy_key", currentTimeMillis);
                return !TimeHelper.isSameDay(date, date2);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (d.a.c.e.p.k.isEmpty(str)) {
                return false;
            }
            return f56944a.matcher(str.toLowerCase()).find();
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (d.a.c.e.p.k.isEmpty(str)) {
                return false;
            }
            return f56945b.matcher(str.toLowerCase()).find();
        }
        return invokeL.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (d.a.c.e.p.k.isEmpty(str)) {
                return false;
            }
            return "person".equalsIgnoreCase(Uri.parse(str).getAuthority());
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? b(str) || c(str) || d(str) : invokeL.booleanValue;
    }
}
