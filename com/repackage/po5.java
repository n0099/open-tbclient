package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class po5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<to5> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new to5(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<nn> b(to5 to5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, to5Var)) == null) {
            List<ThreadInfo> list = to5Var.e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    qo5 qo5Var = new qo5();
                    qo5Var.a = to5Var.a;
                    qo5Var.b = to5Var.b;
                    qo5Var.c = to5Var.c;
                    qo5Var.parserProtobuf(threadInfo);
                    arrayList.add(qo5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<to5> list, List<to5> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (to5 to5Var : list2) {
            if (to5Var != null) {
                hashMap.put(e(to5Var), to5Var.e);
            }
        }
        for (to5 to5Var2 : list) {
            if (to5Var2 != null && !ListUtils.isEmpty(to5Var2.e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < to5Var2.e.size(); i++) {
                    ThreadInfo threadInfo = to5Var2.e.get(i);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(to5Var2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < to5Var2.e.size()) {
                                ThreadInfo threadInfo2 = null;
                                Iterator it = list4.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    ThreadInfo threadInfo3 = (ThreadInfo) it.next();
                                    if (threadInfo3 != null && !list3.contains(threadInfo3.ala_info.live_id) && !arrayList2.contains(threadInfo3.ala_info.live_id) && !arrayList3.contains(threadInfo3.ala_info.live_id)) {
                                        threadInfo2 = threadInfo3;
                                        break;
                                    }
                                }
                                if (threadInfo2 != null) {
                                    arrayList3.add(threadInfo2.ala_info.live_id);
                                    to5Var2.e.set(intValue, threadInfo2);
                                } else {
                                    to5Var2.e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<nn>, List<nn>> d(String str, List<to5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (to5 to5Var : list) {
                if (to5Var != null && !ListUtils.isEmpty(to5Var.e)) {
                    List<nn> b = b(to5Var);
                    String str2 = to5Var.b;
                    if (!ListUtils.isEmpty(b) && b.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        uo5 uo5Var = new uo5();
                        uo5Var.a = to5Var.a;
                        uo5Var.b = str2;
                        uo5Var.c = to5Var.c;
                        uo5Var.d = to5Var.d;
                        int i = to5Var.f;
                        uo5Var.e = to5Var.g;
                        linkedList.add(uo5Var);
                        int size = b.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i2 = 0;
                        to5Var.e = to5Var.e.subList(0, size);
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 < size) {
                                if ("1:1".equals(to5Var.d)) {
                                    ds5 ds5Var = new ds5();
                                    qo5 qo5Var = (qo5) b.get(i2);
                                    qo5 qo5Var2 = (qo5) b.get(i3);
                                    ds5Var.a = qo5Var;
                                    ds5Var.b = qo5Var2;
                                    arrayList.add(qo5Var);
                                    arrayList.add(qo5Var2);
                                    linkedList.add(ds5Var);
                                } else if ("16:9".equals(to5Var.d)) {
                                    cs5 cs5Var = new cs5();
                                    qo5 qo5Var3 = (qo5) b.get(i2);
                                    qo5 qo5Var4 = (qo5) b.get(i3);
                                    cs5Var.a = qo5Var3;
                                    cs5Var.b = qo5Var4;
                                    arrayList.add(qo5Var3);
                                    arrayList.add(qo5Var4);
                                    linkedList.add(cs5Var);
                                }
                                i2 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(to5Var);
                    }
                } else {
                    arrayList2.add(to5Var);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(to5 to5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, to5Var)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(to5Var.a + "_");
            sb.append(to5Var.b + "_");
            sb.append(to5Var.c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(to5 to5Var, List<to5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, to5Var, list)) == null) {
            if (to5Var != null && !ListUtils.isEmpty(list)) {
                for (to5 to5Var2 : list) {
                    if (to5Var.a == to5Var2.a && to5Var.b.equals(to5Var2.b) && to5Var.c.equals(to5Var2.c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<to5> g(List<to5> list, List<to5> list2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, list, list2, z)) == null) {
            if (list == null || list.isEmpty()) {
                return list2;
            }
            if (list2 == null || list2.isEmpty()) {
                return list;
            }
            LinkedList linkedList = new LinkedList();
            for (to5 to5Var : list2) {
                if (to5Var != null && !ListUtils.isEmpty(to5Var.e) && !TextUtils.isEmpty(to5Var.b)) {
                    if (z) {
                        if (!f(to5Var, list)) {
                            linkedList.add(to5Var);
                        }
                    } else {
                        linkedList.add(to5Var);
                    }
                }
            }
            if (z) {
                linkedList.addAll(0, list);
            }
            return linkedList;
        }
        return (List) invokeLLZ.objValue;
    }
}
