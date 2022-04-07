package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class v9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(LinkedList<x9> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkedList)) == null) {
            if (linkedList == null) {
                return false;
            }
            Iterator<x9> it = linkedList.iterator();
            while (it.hasNext()) {
                x9 next = it.next();
                if (next != null && next.i()) {
                    next.g();
                    if (next.o() >= next.l()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(LinkedList<x9> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, linkedList) == null) || linkedList == null) {
            return;
        }
        Iterator<x9> it = linkedList.iterator();
        while (it.hasNext()) {
            x9 next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static boolean c(LinkedList<x9> linkedList, int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeLIL;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, linkedList, i, bdUniqueId)) == null) {
            Iterator<x9> it = linkedList.iterator();
            while (it.hasNext()) {
                x9 next = it.next();
                if (next != null && (m = next.m()) != null) {
                    if (i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) {
                        return true;
                    }
                    if (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static boolean d(LinkedList<x9> linkedList, t9 t9Var, int i) {
        InterceptResult invokeLLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, linkedList, t9Var, i)) == null) {
            if (t9Var == null) {
                return false;
            }
            Iterator<x9> it = linkedList.iterator();
            while (it.hasNext()) {
                x9 next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i && t9Var.onFindMessage(m)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean e(LinkedList<x9> linkedList, int i) {
        InterceptResult invokeLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedList, i)) == null) {
            Iterator<x9> it = linkedList.iterator();
            while (it.hasNext()) {
                x9 next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static x9 f(LinkedList<x9> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, linkedList)) == null) {
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return linkedList.peek();
        }
        return (x9) invokeL.objValue;
    }

    public static int g(x9 x9Var, LinkedList<x9> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, x9Var, linkedList)) == null) {
            if (x9Var == null || linkedList == null) {
                return -1;
            }
            int size = linkedList.size();
            int i = 0;
            while (i < size && linkedList.get(i).n() <= x9Var.n()) {
                i++;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static boolean h(x9 x9Var, LinkedList<x9> linkedList) {
        InterceptResult invokeLL;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, x9Var, linkedList)) == null) {
            if (x9Var == null || linkedList == null || (g = g(x9Var, linkedList)) < 0 || g > linkedList.size()) {
                return false;
            }
            linkedList.add(g, x9Var);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(LinkedList<x9> linkedList, LinkedList<x9> linkedList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, null, linkedList, linkedList2)) != null) {
            return invokeLL.booleanValue;
        }
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            x9 poll = linkedList2.poll();
            if (poll == null) {
                return true;
            }
            h(poll, linkedList);
        }
    }

    public static boolean j(LinkedList<x9> linkedList, LinkedList<x9> linkedList2, x9 x9Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, linkedList, linkedList2, x9Var)) == null) {
            if (x9Var == null || linkedList == null || linkedList2 == null || !linkedList.remove(x9Var)) {
                return false;
            }
            linkedList2.add(x9Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static x9 k(LinkedList<x9> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<x9> it = linkedList.iterator();
            while (it.hasNext()) {
                x9 next = it.next();
                if (next != null && !next.i()) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (x9) invokeL.objValue;
    }

    public static x9 l(LinkedList<x9> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, linkedList)) == null) {
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return linkedList.poll();
        }
        return (x9) invokeL.objValue;
    }

    public static void m(LinkedList<x9> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65548, null, linkedList, i, bdUniqueId) == null) || linkedList == null) {
            return;
        }
        Iterator<x9> it = linkedList.iterator();
        while (it.hasNext()) {
            x9 next = it.next();
            if (next != null && (m = next.m()) != null && ((i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) || (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean n(x9 x9Var, LinkedList<x9> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, x9Var, linkedList)) == null) {
            if (x9Var == null || linkedList == null) {
                return false;
            }
            return linkedList.remove(x9Var);
        }
        return invokeLL.booleanValue;
    }

    public static void o(LinkedList<x9> linkedList, int i) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, linkedList, i) == null) {
            Iterator<x9> it = linkedList.iterator();
            while (it.hasNext()) {
                x9 next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    it.remove();
                }
            }
        }
    }

    public static x9 p(int i, LinkedList<x9> linkedList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<x9> it = linkedList.iterator();
            while (it.hasNext()) {
                x9 next = it.next();
                if (next != null && next.q() == i) {
                    it.remove();
                    next.w();
                    return next;
                }
            }
            return null;
        }
        return (x9) invokeIL.objValue;
    }

    public static int q(LinkedList<x9> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, linkedList)) == null) {
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeL.intValue;
    }
}
