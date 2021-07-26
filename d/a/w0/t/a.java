package d.a.w0.t;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f68923a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f68924b = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2005790150, "Ld/a/w0/t/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2005790150, "Ld/a/w0/t/a;");
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!TextUtils.isEmpty(f68924b)) {
                return f68924b;
            }
            try {
                f68924b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return f68924b;
        }
        return (String) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            int i2 = f68923a;
            if (i2 >= 0) {
                return i2;
            }
            try {
                f68923a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return f68923a;
        }
        return invokeL.intValue;
    }
}
