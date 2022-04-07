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
/* loaded from: classes7.dex */
public class sn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<wn5> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new wn5(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<uo> b(wn5 wn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wn5Var)) == null) {
            List<ThreadInfo> list = wn5Var.e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    tn5 tn5Var = new tn5();
                    tn5Var.a = wn5Var.a;
                    tn5Var.b = wn5Var.b;
                    tn5Var.c = wn5Var.c;
                    tn5Var.parserProtobuf(threadInfo);
                    arrayList.add(tn5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<wn5> list, List<wn5> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (wn5 wn5Var : list2) {
            if (wn5Var != null) {
                hashMap.put(e(wn5Var), wn5Var.e);
            }
        }
        for (wn5 wn5Var2 : list) {
            if (wn5Var2 != null && !ListUtils.isEmpty(wn5Var2.e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < wn5Var2.e.size(); i++) {
                    ThreadInfo threadInfo = wn5Var2.e.get(i);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(wn5Var2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < wn5Var2.e.size()) {
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
                                    wn5Var2.e.set(intValue, threadInfo2);
                                } else {
                                    wn5Var2.e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<uo>, List<uo>> d(String str, List<wn5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (wn5 wn5Var : list) {
                if (wn5Var != null && !ListUtils.isEmpty(wn5Var.e)) {
                    List<uo> b = b(wn5Var);
                    String str2 = wn5Var.b;
                    if (!ListUtils.isEmpty(b) && b.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        xn5 xn5Var = new xn5();
                        xn5Var.a = wn5Var.a;
                        xn5Var.b = str2;
                        xn5Var.c = wn5Var.c;
                        xn5Var.d = wn5Var.d;
                        int i = wn5Var.f;
                        xn5Var.e = wn5Var.g;
                        linkedList.add(xn5Var);
                        int size = b.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i2 = 0;
                        wn5Var.e = wn5Var.e.subList(0, size);
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 < size) {
                                if ("1:1".equals(wn5Var.d)) {
                                    lr5 lr5Var = new lr5();
                                    tn5 tn5Var = (tn5) b.get(i2);
                                    tn5 tn5Var2 = (tn5) b.get(i3);
                                    lr5Var.a = tn5Var;
                                    lr5Var.b = tn5Var2;
                                    arrayList.add(tn5Var);
                                    arrayList.add(tn5Var2);
                                    linkedList.add(lr5Var);
                                } else if ("16:9".equals(wn5Var.d)) {
                                    kr5 kr5Var = new kr5();
                                    tn5 tn5Var3 = (tn5) b.get(i2);
                                    tn5 tn5Var4 = (tn5) b.get(i3);
                                    kr5Var.a = tn5Var3;
                                    kr5Var.b = tn5Var4;
                                    arrayList.add(tn5Var3);
                                    arrayList.add(tn5Var4);
                                    linkedList.add(kr5Var);
                                }
                                i2 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(wn5Var);
                    }
                } else {
                    arrayList2.add(wn5Var);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(wn5 wn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, wn5Var)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(wn5Var.a + "_");
            sb.append(wn5Var.b + "_");
            sb.append(wn5Var.c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(wn5 wn5Var, List<wn5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, wn5Var, list)) == null) {
            if (wn5Var != null && !ListUtils.isEmpty(list)) {
                for (wn5 wn5Var2 : list) {
                    if (wn5Var.a == wn5Var2.a && wn5Var.b.equals(wn5Var2.b) && wn5Var.c.equals(wn5Var2.c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<wn5> g(List<wn5> list, List<wn5> list2, boolean z) {
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
            for (wn5 wn5Var : list2) {
                if (wn5Var != null && !ListUtils.isEmpty(wn5Var.e) && !TextUtils.isEmpty(wn5Var.b)) {
                    if (z) {
                        if (!f(wn5Var, list)) {
                            linkedList.add(wn5Var);
                        }
                    } else {
                        linkedList.add(wn5Var);
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
