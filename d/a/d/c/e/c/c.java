package d.a.d.c.e.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(LinkedList<e> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkedList)) == null) {
            if (linkedList == null) {
                return false;
            }
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
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

    public static void b(LinkedList<e> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, linkedList) == null) || linkedList == null) {
            return;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static boolean c(LinkedList<e> linkedList, int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeLIL;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, linkedList, i2, bdUniqueId)) == null) {
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null && (m = next.m()) != null) {
                    if (i2 != 0 && m.getTag() == bdUniqueId && i2 == m.getCmd()) {
                        return true;
                    }
                    if (i2 == 0 && bdUniqueId != null && m.getTag() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static boolean d(LinkedList<e> linkedList, a aVar, int i2) {
        InterceptResult invokeLLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, linkedList, aVar, i2)) == null) {
            if (aVar == null) {
                return false;
            }
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i2 && aVar.onFindMessage(m)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean e(LinkedList<e> linkedList, int i2) {
        InterceptResult invokeLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedList, i2)) == null) {
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static e f(LinkedList<e> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, linkedList)) == null) {
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return linkedList.peek();
        }
        return (e) invokeL.objValue;
    }

    public static int g(e eVar, LinkedList<e> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, eVar, linkedList)) == null) {
            if (eVar == null || linkedList == null) {
                return -1;
            }
            int size = linkedList.size();
            int i2 = 0;
            while (i2 < size && linkedList.get(i2).n() <= eVar.n()) {
                i2++;
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static boolean h(e eVar, LinkedList<e> linkedList) {
        InterceptResult invokeLL;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, eVar, linkedList)) == null) {
            if (eVar == null || linkedList == null || (g2 = g(eVar, linkedList)) < 0 || g2 > linkedList.size()) {
                return false;
            }
            linkedList.add(g2, eVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(LinkedList<e> linkedList, LinkedList<e> linkedList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, null, linkedList, linkedList2)) != null) {
            return invokeLL.booleanValue;
        }
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            e poll = linkedList2.poll();
            if (poll == null) {
                return true;
            }
            h(poll, linkedList);
        }
    }

    public static boolean j(LinkedList<e> linkedList, LinkedList<e> linkedList2, e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, linkedList, linkedList2, eVar)) == null) {
            if (eVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(eVar)) {
                return false;
            }
            linkedList2.add(eVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static e k(LinkedList<e> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null && !next.i()) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (e) invokeL.objValue;
    }

    public static e l(LinkedList<e> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, linkedList)) == null) {
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return linkedList.poll();
        }
        return (e) invokeL.objValue;
    }

    public static void m(LinkedList<e> linkedList, int i2, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65548, null, linkedList, i2, bdUniqueId) == null) || linkedList == null) {
            return;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (m = next.m()) != null && ((i2 != 0 && m.getTag() == bdUniqueId && i2 == m.getCmd()) || (i2 == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean n(e eVar, LinkedList<e> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, eVar, linkedList)) == null) {
            if (eVar == null || linkedList == null) {
                return false;
            }
            return linkedList.remove(eVar);
        }
        return invokeLL.booleanValue;
    }

    public static void o(LinkedList<e> linkedList, int i2) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, linkedList, i2) == null) {
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i2) {
                    it.remove();
                }
            }
        }
    }

    public static e p(int i2, LinkedList<e> linkedList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i2, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<e> it = linkedList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null && next.q() == i2) {
                    it.remove();
                    next.w();
                    return next;
                }
            }
            return null;
        }
        return (e) invokeIL.objValue;
    }

    public static int q(LinkedList<e> linkedList) {
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
