package d.a.d.e.p;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, String> f41975a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-402035258, "Ld/a/d/e/p/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-402035258, "Ld/a/d/e/p/n;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        f41975a = hashMap;
        hashMap.put("java.lang.String", "java.lang.String");
        f41975a.put("java.lang.Integer", "java.lang.Integer");
        f41975a.put("java.lang.Double", "java.lang.Double");
        f41975a.put("java.lang.Float", "java.lang.Float");
        f41975a.put("java.lang.Boolean", "java.lang.Boolean");
        f41975a.put("java.lang.Character", "java.lang.Character");
        f41975a.put("java.lang.Short", "java.lang.Short");
        f41975a.put("java.lang.Long", "java.lang.Long");
        f41975a.put("java.lang.Byte", "java.lang.Byte");
        f41975a.put("java.util.Date", "java.util.Date");
        f41975a.put("java.lang.Integer", "java.lang.Integer");
        f41975a.put("java.lang.Integer", "java.lang.Integer");
    }

    public static Object a(Object obj, Field field) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, field)) == null) {
            Object obj2 = null;
            if (obj != null && field != null) {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                try {
                    obj2 = field.get(obj);
                } catch (Throwable unused) {
                }
                field.setAccessible(isAccessible);
            }
            return obj2;
        }
        return invokeLL.objValue;
    }
}
