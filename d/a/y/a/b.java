package d.a.y.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.y.a.a.a;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f68461a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f68462b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f68463c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f68464d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f68465e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f68466f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1124463518, "Ld/a/y/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1124463518, "Ld/a/y/a/b;");
                return;
            }
        }
        try {
            f68461a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f68462b = a.a(cls, "doInit", Context.class, String[].class);
            f68464d = a.a(cls, "setStatisticParam", String.class);
            f68463c = a.a(cls, "setEnabled", Boolean.TYPE);
            f68465e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f68466f = true;
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
                if (f68466f) {
                    f68462b.invoke(f68461a, context, strArr);
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
                if (f68466f) {
                    f68464d.invoke(f68461a, str);
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
                if (f68466f) {
                    f68465e.invoke(f68461a, str, str2);
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
                if (f68466f) {
                    f68463c.invoke(f68461a, Boolean.valueOf(z));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f68466f : invokeV.booleanValue;
    }
}
