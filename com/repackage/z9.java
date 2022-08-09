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
public class z9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(LinkedList<ba> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkedList)) == null) {
            if (linkedList == null) {
                return false;
            }
            Iterator<ba> it = linkedList.iterator();
            while (it.hasNext()) {
                ba next = it.next();
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

    public static void b(LinkedList<ba> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, linkedList) == null) || linkedList == null) {
            return;
        }
        Iterator<ba> it = linkedList.iterator();
        while (it.hasNext()) {
            ba next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static boolean c(LinkedList<ba> linkedList, int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeLIL;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, linkedList, i, bdUniqueId)) == null) {
            Iterator<ba> it = linkedList.iterator();
            while (it.hasNext()) {
                ba next = it.next();
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

    public static boolean d(LinkedList<ba> linkedList, x9 x9Var, int i) {
        InterceptResult invokeLLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, linkedList, x9Var, i)) == null) {
            if (x9Var == null) {
                return false;
            }
            Iterator<ba> it = linkedList.iterator();
            while (it.hasNext()) {
                ba next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i && x9Var.onFindMessage(m)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean e(LinkedList<ba> linkedList, int i) {
        InterceptResult invokeLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedList, i)) == null) {
            Iterator<ba> it = linkedList.iterator();
            while (it.hasNext()) {
                ba next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static ba f(LinkedList<ba> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, linkedList)) == null) {
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return linkedList.peek();
        }
        return (ba) invokeL.objValue;
    }

    public static int g(ba baVar, LinkedList<ba> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, baVar, linkedList)) == null) {
            if (baVar == null || linkedList == null) {
                return -1;
            }
            int size = linkedList.size();
            int i = 0;
            while (i < size && linkedList.get(i).n() <= baVar.n()) {
                i++;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static boolean h(ba baVar, LinkedList<ba> linkedList) {
        InterceptResult invokeLL;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, baVar, linkedList)) == null) {
            if (baVar == null || linkedList == null || (g = g(baVar, linkedList)) < 0 || g > linkedList.size()) {
                return false;
            }
            linkedList.add(g, baVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(LinkedList<ba> linkedList, LinkedList<ba> linkedList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, null, linkedList, linkedList2)) != null) {
            return invokeLL.booleanValue;
        }
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            ba poll = linkedList2.poll();
            if (poll == null) {
                return true;
            }
            h(poll, linkedList);
        }
    }

    public static boolean j(LinkedList<ba> linkedList, LinkedList<ba> linkedList2, ba baVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, linkedList, linkedList2, baVar)) == null) {
            if (baVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(baVar)) {
                return false;
            }
            linkedList2.add(baVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static ba k(LinkedList<ba> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<ba> it = linkedList.iterator();
            while (it.hasNext()) {
                ba next = it.next();
                if (next != null && !next.i()) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (ba) invokeL.objValue;
    }

    public static ba l(LinkedList<ba> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, linkedList)) == null) {
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return linkedList.poll();
        }
        return (ba) invokeL.objValue;
    }

    public static void m(LinkedList<ba> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65548, null, linkedList, i, bdUniqueId) == null) || linkedList == null) {
            return;
        }
        Iterator<ba> it = linkedList.iterator();
        while (it.hasNext()) {
            ba next = it.next();
            if (next != null && (m = next.m()) != null && ((i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) || (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean n(ba baVar, LinkedList<ba> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, baVar, linkedList)) == null) {
            if (baVar == null || linkedList == null) {
                return false;
            }
            return linkedList.remove(baVar);
        }
        return invokeLL.booleanValue;
    }

    public static void o(LinkedList<ba> linkedList, int i) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, linkedList, i) == null) {
            Iterator<ba> it = linkedList.iterator();
            while (it.hasNext()) {
                ba next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    it.remove();
                }
            }
        }
    }

    public static ba p(int i, LinkedList<ba> linkedList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<ba> it = linkedList.iterator();
            while (it.hasNext()) {
                ba next = it.next();
                if (next != null && next.q() == i) {
                    it.remove();
                    next.w();
                    return next;
                }
            }
            return null;
        }
        return (ba) invokeIL.objValue;
    }

    public static int q(LinkedList<ba> linkedList) {
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
