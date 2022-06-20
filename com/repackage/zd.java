package com.repackage;

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
public class zd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final List<Object> a(be beVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, beVar, i)) == null) {
            Class<?> a = beVar.a();
            if (a != List.class && a != ArrayList.class) {
                if (a == LinkedList.class) {
                    return new LinkedList();
                }
                Object g = bc.g(a, i);
                if (g == null) {
                    g = bc.f(a);
                }
                if (g instanceof List) {
                    return (List) g;
                }
                return null;
            }
            return new ArrayList(i);
        }
        return (List) invokeLI.objValue;
    }

    public static final Map<String, Object> b(be beVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, beVar, i)) == null) {
            Class<?> a = beVar.a();
            Type[] b = beVar.b();
            if (bc.e(a, Map.class)) {
                if (b != null && b.length >= 2 && b[0] == String.class) {
                    if (a == Map.class) {
                        return new HashMap(i);
                    }
                    Object g = bc.g(a, i);
                    if (g == null) {
                        g = bc.f(a);
                    }
                    if (g instanceof Map) {
                        return (Map) g;
                    }
                    return null;
                } else if (a == Map.class) {
                    return new HashMap(i);
                } else {
                    Object g2 = bc.g(a, i);
                    if (g2 == null) {
                        g2 = bc.f(a);
                    }
                    if (g2 instanceof Map) {
                        return (Map) g2;
                    }
                    return null;
                }
            }
            return null;
        }
        return (Map) invokeLI.objValue;
    }

    public static final Queue<Object> c(be beVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, beVar, i)) == null) {
            Class<?> a = beVar.a();
            if (a == Queue.class) {
                return new LinkedList();
            }
            Object g = bc.g(a, i);
            if (g == null) {
                g = bc.f(a);
            }
            if (g instanceof Queue) {
                return (Queue) g;
            }
            return null;
        }
        return (Queue) invokeLI.objValue;
    }

    public static final Set<Object> d(be beVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, beVar, i)) == null) {
            Class<?> a = beVar.a();
            if (a == Set.class) {
                return new HashSet();
            }
            Object g = bc.g(a, i);
            if (g == null) {
                g = bc.f(a);
            }
            if (g instanceof Set) {
                return (Set) g;
            }
            return null;
        }
        return (Set) invokeLI.objValue;
    }
}
