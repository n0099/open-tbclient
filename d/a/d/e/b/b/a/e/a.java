package d.a.d.e.b.b.a.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final List<Object> a(c cVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, cVar, i2)) == null) {
            Class<?> a2 = cVar.a();
            if (a2 != List.class && a2 != ArrayList.class) {
                if (a2 == LinkedList.class) {
                    return new LinkedList();
                }
                Object g2 = d.a.d.e.b.a.a.g(a2, i2);
                if (g2 == null) {
                    g2 = d.a.d.e.b.a.a.f(a2);
                }
                if (g2 instanceof List) {
                    return (List) g2;
                }
                return null;
            }
            return new ArrayList(i2);
        }
        return (List) invokeLI.objValue;
    }

    public static final Map<String, Object> b(c cVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, cVar, i2)) == null) {
            Class<?> a2 = cVar.a();
            Type[] b2 = cVar.b();
            if (d.a.d.e.b.a.a.e(a2, Map.class)) {
                if (b2 != null && b2.length >= 2 && b2[0] == String.class) {
                    if (a2 == Map.class) {
                        return new HashMap(i2);
                    }
                    Object g2 = d.a.d.e.b.a.a.g(a2, i2);
                    if (g2 == null) {
                        g2 = d.a.d.e.b.a.a.f(a2);
                    }
                    if (g2 instanceof Map) {
                        return (Map) g2;
                    }
                    return null;
                } else if (a2 == Map.class) {
                    return new HashMap(i2);
                } else {
                    Object g3 = d.a.d.e.b.a.a.g(a2, i2);
                    if (g3 == null) {
                        g3 = d.a.d.e.b.a.a.f(a2);
                    }
                    if (g3 instanceof Map) {
                        return (Map) g3;
                    }
                    return null;
                }
            }
            return null;
        }
        return (Map) invokeLI.objValue;
    }

    public static final Queue<Object> c(c cVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, cVar, i2)) == null) {
            Class<?> a2 = cVar.a();
            if (a2 == Queue.class) {
                return new LinkedList();
            }
            Object g2 = d.a.d.e.b.a.a.g(a2, i2);
            if (g2 == null) {
                g2 = d.a.d.e.b.a.a.f(a2);
            }
            if (g2 instanceof Queue) {
                return (Queue) g2;
            }
            return null;
        }
        return (Queue) invokeLI.objValue;
    }

    public static final Set<Object> d(c cVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, cVar, i2)) == null) {
            Class<?> a2 = cVar.a();
            if (a2 == Set.class) {
                return new HashSet();
            }
            Object g2 = d.a.d.e.b.a.a.g(a2, i2);
            if (g2 == null) {
                g2 = d.a.d.e.b.a.a.f(a2);
            }
            if (g2 instanceof Set) {
                return (Set) g2;
            }
            return null;
        }
        return (Set) invokeLI.objValue;
    }
}
