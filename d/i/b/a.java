package d.i.b;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2039a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Object f73934a;

        /* renamed from: b  reason: collision with root package name */
        public static Class<?> f73935b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f73936c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-725363801, "Ld/i/b/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-725363801, "Ld/i/b/a$a;");
                    return;
                }
            }
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f73935b = cls;
                f73934a = cls.newInstance();
                f73935b.getMethod("getUDID", Context.class);
                f73936c = f73935b.getMethod("getOAID", Context.class);
                f73935b.getMethod("getVAID", Context.class);
                f73935b.getMethod("getAAID", Context.class);
            } catch (Throwable th) {
                Log.e("XiaomiId", "xiaomi init error", th);
            }
        }

        public static String a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? b(context, f73936c) : (String) invokeL.objValue;
        }

        public static String b(Context context, Method method) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, method)) == null) {
                Object obj = f73934a;
                if (obj == null || method == null) {
                    return null;
                }
                try {
                    Object invoke = method.invoke(obj, context);
                    if (invoke != null) {
                        return (String) invoke;
                    }
                    return null;
                } catch (Exception e2) {
                    Log.e("XiaomiId", "invoke method error", e2);
                    return null;
                }
            }
            return (String) invokeLL.objValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (f73935b == null || f73934a == null) ? false : true : invokeV.booleanValue;
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? C2039a.a(context.getApplicationContext()) : (String) invokeL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C2039a.c() : invokeV.booleanValue;
    }
}
