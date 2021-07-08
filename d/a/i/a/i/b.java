package d.a.i.a.i;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, a> f42544a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-392643688, "Ld/a/i/a/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-392643688, "Ld/a/i/a/i/b;");
                return;
            }
        }
        f42544a = new HashMap<>();
    }

    public static synchronized a a(String str) {
        InterceptResult invokeL;
        a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (b.class) {
                b2 = b(str, 0);
            }
            return b2;
        }
        return (a) invokeL.objValue;
    }

    public static synchronized a b(String str, int i2) {
        InterceptResult invokeLI;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            synchronized (b.class) {
                if (!f42544a.containsKey(str) || (aVar = f42544a.get(str)) == null) {
                    a aVar2 = new a(str, i2);
                    try {
                        aVar2.start();
                    } catch (Exception unused) {
                    }
                    f42544a.put(str, aVar2);
                    return aVar2;
                }
                return aVar;
            }
        }
        return (a) invokeLI.objValue;
    }

    public static synchronized void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            synchronized (b.class) {
                if (aVar != null) {
                    aVar.a();
                    f42544a.values().remove(aVar);
                }
            }
        }
    }
}
