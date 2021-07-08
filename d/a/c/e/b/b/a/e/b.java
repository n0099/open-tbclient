package d.a.c.e.b.b.a.e;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.e.b.b.a.d.h;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Object a(ArrayList<Object> arrayList, c cVar) {
        InterceptResult invokeLL;
        Object a2;
        Object a3;
        Object a4;
        Object a5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, arrayList, cVar)) == null) {
            if (arrayList != null && cVar != null) {
                Class<?> a6 = cVar.a();
                Type[] b2 = cVar.b();
                int i2 = 0;
                if (a6.isArray()) {
                    Object newInstance = Array.newInstance(a6.getComponentType(), arrayList.size());
                    Iterator<Object> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object a7 = g.a(it.next()).a(new c(a6.getComponentType()));
                        if (a7 != null) {
                            Array.set(newInstance, i2, a7);
                        }
                        i2++;
                    }
                    return newInstance;
                } else if (d.a.c.e.b.a.a.e(a6, List.class)) {
                    List<Object> a8 = a.a(cVar, arrayList.size());
                    if (a8 != null) {
                        Iterator<Object> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            h a9 = g.a(it2.next());
                            if (b2 != null && b2.length >= 1 && (a5 = a9.a(new c(b2[0]))) != null) {
                                a8.add(a5);
                            }
                        }
                    }
                    return a8;
                } else if (d.a.c.e.b.a.a.e(a6, Queue.class)) {
                    Queue<Object> c2 = a.c(cVar, arrayList.size());
                    if (c2 != null) {
                        Iterator<Object> it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            h a10 = g.a(it3.next());
                            if (b2 != null && b2.length >= 1 && (a4 = a10.a(new c(b2[0]))) != null) {
                                c2.add(a4);
                            }
                        }
                    }
                    return c2;
                } else if (d.a.c.e.b.a.a.e(a6, Set.class)) {
                    Set<Object> d2 = a.d(cVar, arrayList.size());
                    if (d2 != null) {
                        Iterator<Object> it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            h a11 = g.a(it4.next());
                            if (b2 != null && b2.length >= 1 && (a3 = a11.a(new c(b2[0]))) != null) {
                                d2.add(a3);
                            }
                        }
                    }
                    return d2;
                } else if (d.a.c.e.b.a.a.e(a6, Map.class)) {
                    Map<String, Object> b3 = a.b(cVar, arrayList.size());
                    if (b3 != null) {
                        Iterator<Object> it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            h a12 = g.a(it5.next());
                            if (b2 != null && b2.length >= 2) {
                                a2 = a12.a(new c(b2[1]));
                            } else {
                                a2 = a12.a(new c(String.class));
                            }
                            if (a2 != null) {
                                b3.put(String.valueOf(i2), a2);
                            }
                            i2++;
                        }
                    }
                    return b3;
                } else if (a6 == SparseArray.class) {
                    SparseArray sparseArray = new SparseArray();
                    Iterator<Object> it6 = arrayList.iterator();
                    int i3 = 0;
                    while (it6.hasNext()) {
                        Object next = it6.next();
                        h a13 = g.a(next);
                        if (b2 != null && b2.length >= 1 && a13.a(new c(b2[0])) != null) {
                            sparseArray.put(i3, next);
                        }
                        i3++;
                    }
                    return sparseArray;
                } else if (a6 == Bundle.class) {
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object b(Object obj, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, cVar)) == null) {
            if (obj == null || cVar == null || !obj.getClass().isArray()) {
                return null;
            }
            int length = Array.getLength(obj);
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj2 = Array.get(obj, i2);
                if (obj2 != null) {
                    arrayList.add(obj2);
                }
            }
            return a(arrayList, cVar);
        }
        return invokeLL.objValue;
    }

    public static final Object c(List<Object> list, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, cVar)) == null) {
            if (list == null || cVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj : list) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, cVar);
        }
        return invokeLL.objValue;
    }

    public static final Object d(Queue<Object> queue, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, queue, cVar)) == null) {
            if (queue == null || cVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(queue.size());
            for (Object obj : queue) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, cVar);
        }
        return invokeLL.objValue;
    }

    public static final Object e(Set<Object> set, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, set, cVar)) == null) {
            if (set == null || cVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(set.size());
            for (Object obj : set) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, cVar);
        }
        return invokeLL.objValue;
    }

    public static final Object f(SparseArray<Object> sparseArray, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, sparseArray, cVar)) == null) {
            if (sparseArray == null || cVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(sparseArray.size());
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                Object obj = sparseArray.get(sparseArray.keyAt(i2));
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, cVar);
        }
        return invokeLL.objValue;
    }
}
