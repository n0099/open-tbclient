package d.a.b0.a;

import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.b0.a.a.a;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f43799a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f43800b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f43801c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f43802d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f43803e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f43804f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(547516035, "Ld/a/b0/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(547516035, "Ld/a/b0/a/b;");
                return;
            }
        }
        try {
            f43799a = Class.forName("com.baidu.crashpad.ZwCrashpad").getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls = Class.forName("com.baidu.crashpad.ZwCrashpad");
            f43800b = a.a(cls, "doInit", Context.class, String[].class);
            f43802d = a.a(cls, "setStatisticParam", String.class);
            f43801c = a.a(cls, "setEnabled", Boolean.TYPE);
            f43803e = a.a(cls, "setCrashKeyValue", String.class, String.class);
            f43804f = true;
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
                if (f43804f) {
                    f43800b.invoke(f43799a, context, strArr);
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
                if (f43804f) {
                    f43802d.invoke(f43799a, str);
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
                if (f43804f) {
                    f43803e.invoke(f43799a, str, str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65540, null, z) == null) {
            try {
                if (f43804f) {
                    f43801c.invoke(f43799a, Boolean.valueOf(z));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f43804f : invokeV.booleanValue;
    }
}
