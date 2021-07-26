package d.a.z.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.z.a.a.a;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f69139a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f69140b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f69141c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f69142d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f69143e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f69144f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1095834367, "Ld/a/z/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1095834367, "Ld/a/z/a/b;");
                return;
            }
        }
        try {
            f69139a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f69140b = a.a(cls, "doInit", Context.class, String[].class);
            f69142d = a.a(cls, "setStatisticParam", String.class);
            f69141c = a.a(cls, "setEnabled", Boolean.TYPE);
            f69143e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f69144f = true;
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, strArr) == null) {
            try {
                if (f69144f) {
                    f69140b.invoke(f69139a, context, strArr);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            try {
                if (f69144f) {
                    f69142d.invoke(f69139a, str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            try {
                if (f69144f) {
                    f69143e.invoke(f69139a, str, str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            try {
                if (f69144f) {
                    f69141c.invoke(f69139a, Boolean.valueOf(z));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f69144f : invokeV.booleanValue;
    }
}
