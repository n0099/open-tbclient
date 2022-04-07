package com.repackage;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes7.dex */
public class xd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Object a(ArrayList<Object> arrayList, yd ydVar) {
        InterceptResult invokeLL;
        Object a;
        Object a2;
        Object a3;
        Object a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, arrayList, ydVar)) == null) {
            if (arrayList != null && ydVar != null) {
                Class<?> a5 = ydVar.a();
                Type[] b = ydVar.b();
                int i = 0;
                if (a5.isArray()) {
                    Object newInstance = Array.newInstance(a5.getComponentType(), arrayList.size());
                    Iterator<Object> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object a6 = ce.a(it.next()).a(new yd(a5.getComponentType()));
                        if (a6 != null) {
                            Array.set(newInstance, i, a6);
                        }
                        i++;
                    }
                    return newInstance;
                } else if (yb.e(a5, List.class)) {
                    List<Object> a7 = wd.a(ydVar, arrayList.size());
                    if (a7 != null) {
                        Iterator<Object> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            id a8 = ce.a(it2.next());
                            if (b != null && b.length >= 1 && (a4 = a8.a(new yd(b[0]))) != null) {
                                a7.add(a4);
                            }
                        }
                    }
                    return a7;
                } else if (yb.e(a5, Queue.class)) {
                    Queue<Object> c = wd.c(ydVar, arrayList.size());
                    if (c != null) {
                        Iterator<Object> it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            id a9 = ce.a(it3.next());
                            if (b != null && b.length >= 1 && (a3 = a9.a(new yd(b[0]))) != null) {
                                c.add(a3);
                            }
                        }
                    }
                    return c;
                } else if (yb.e(a5, Set.class)) {
                    Set<Object> d = wd.d(ydVar, arrayList.size());
                    if (d != null) {
                        Iterator<Object> it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            id a10 = ce.a(it4.next());
                            if (b != null && b.length >= 1 && (a2 = a10.a(new yd(b[0]))) != null) {
                                d.add(a2);
                            }
                        }
                    }
                    return d;
                } else if (yb.e(a5, Map.class)) {
                    Map<String, Object> b2 = wd.b(ydVar, arrayList.size());
                    if (b2 != null) {
                        Iterator<Object> it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            id a11 = ce.a(it5.next());
                            if (b != null && b.length >= 2) {
                                a = a11.a(new yd(b[1]));
                            } else {
                                a = a11.a(new yd(String.class));
                            }
                            if (a != null) {
                                b2.put(String.valueOf(i), a);
                            }
                            i++;
                        }
                    }
                    return b2;
                } else if (a5 == SparseArray.class) {
                    SparseArray sparseArray = new SparseArray();
                    Iterator<Object> it6 = arrayList.iterator();
                    int i2 = 0;
                    while (it6.hasNext()) {
                        Object next = it6.next();
                        id a12 = ce.a(next);
                        if (b != null && b.length >= 1 && a12.a(new yd(b[0])) != null) {
                            sparseArray.put(i2, next);
                        }
                        i2++;
                    }
                    return sparseArray;
                } else if (a5 == Bundle.class) {
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object b(Object obj, yd ydVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, ydVar)) == null) {
            if (obj == null || ydVar == null || !obj.getClass().isArray()) {
                return null;
            }
            int length = Array.getLength(obj);
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                Object obj2 = Array.get(obj, i);
                if (obj2 != null) {
                    arrayList.add(obj2);
                }
            }
            return a(arrayList, ydVar);
        }
        return invokeLL.objValue;
    }

    public static final Object c(List<Object> list, yd ydVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, ydVar)) == null) {
            if (list == null || ydVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj : list) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, ydVar);
        }
        return invokeLL.objValue;
    }

    public static final Object d(Queue<Object> queue, yd ydVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, queue, ydVar)) == null) {
            if (queue == null || ydVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(queue.size());
            for (Object obj : queue) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, ydVar);
        }
        return invokeLL.objValue;
    }

    public static final Object e(Set<Object> set, yd ydVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, set, ydVar)) == null) {
            if (set == null || ydVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(set.size());
            for (Object obj : set) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, ydVar);
        }
        return invokeLL.objValue;
    }

    public static final Object f(SparseArray<Object> sparseArray, yd ydVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, sparseArray, ydVar)) == null) {
            if (sparseArray == null || ydVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(sparseArray.size());
            for (int i = 0; i < sparseArray.size(); i++) {
                Object obj = sparseArray.get(sparseArray.keyAt(i));
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, ydVar);
        }
        return invokeLL.objValue;
    }
}
