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
/* loaded from: classes5.dex */
public class ae {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Object a(ArrayList<Object> arrayList, be beVar) {
        InterceptResult invokeLL;
        Object a;
        Object a2;
        Object a3;
        Object a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, arrayList, beVar)) == null) {
            if (arrayList != null && beVar != null) {
                Class<?> a5 = beVar.a();
                Type[] b = beVar.b();
                int i = 0;
                if (a5.isArray()) {
                    Object newInstance = Array.newInstance(a5.getComponentType(), arrayList.size());
                    Iterator<Object> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object a6 = fe.a(it.next()).a(new be(a5.getComponentType()));
                        if (a6 != null) {
                            Array.set(newInstance, i, a6);
                        }
                        i++;
                    }
                    return newInstance;
                } else if (bc.e(a5, List.class)) {
                    List<Object> a7 = zd.a(beVar, arrayList.size());
                    if (a7 != null) {
                        Iterator<Object> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ld a8 = fe.a(it2.next());
                            if (b != null && b.length >= 1 && (a4 = a8.a(new be(b[0]))) != null) {
                                a7.add(a4);
                            }
                        }
                    }
                    return a7;
                } else if (bc.e(a5, Queue.class)) {
                    Queue<Object> c = zd.c(beVar, arrayList.size());
                    if (c != null) {
                        Iterator<Object> it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            ld a9 = fe.a(it3.next());
                            if (b != null && b.length >= 1 && (a3 = a9.a(new be(b[0]))) != null) {
                                c.add(a3);
                            }
                        }
                    }
                    return c;
                } else if (bc.e(a5, Set.class)) {
                    Set<Object> d = zd.d(beVar, arrayList.size());
                    if (d != null) {
                        Iterator<Object> it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            ld a10 = fe.a(it4.next());
                            if (b != null && b.length >= 1 && (a2 = a10.a(new be(b[0]))) != null) {
                                d.add(a2);
                            }
                        }
                    }
                    return d;
                } else if (bc.e(a5, Map.class)) {
                    Map<String, Object> b2 = zd.b(beVar, arrayList.size());
                    if (b2 != null) {
                        Iterator<Object> it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            ld a11 = fe.a(it5.next());
                            if (b != null && b.length >= 2) {
                                a = a11.a(new be(b[1]));
                            } else {
                                a = a11.a(new be(String.class));
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
                        ld a12 = fe.a(next);
                        if (b != null && b.length >= 1 && a12.a(new be(b[0])) != null) {
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

    public static final Object b(Object obj, be beVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, beVar)) == null) {
            if (obj == null || beVar == null || !obj.getClass().isArray()) {
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
            return a(arrayList, beVar);
        }
        return invokeLL.objValue;
    }

    public static final Object c(List<Object> list, be beVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, beVar)) == null) {
            if (list == null || beVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj : list) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, beVar);
        }
        return invokeLL.objValue;
    }

    public static final Object d(Queue<Object> queue, be beVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, queue, beVar)) == null) {
            if (queue == null || beVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(queue.size());
            for (Object obj : queue) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, beVar);
        }
        return invokeLL.objValue;
    }

    public static final Object e(Set<Object> set, be beVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, set, beVar)) == null) {
            if (set == null || beVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(set.size());
            for (Object obj : set) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, beVar);
        }
        return invokeLL.objValue;
    }

    public static final Object f(SparseArray<Object> sparseArray, be beVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, sparseArray, beVar)) == null) {
            if (sparseArray == null || beVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(sparseArray.size());
            for (int i = 0; i < sparseArray.size(); i++) {
                Object obj = sparseArray.get(sparseArray.keyAt(i));
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, beVar);
        }
        return invokeLL.objValue;
    }
}
