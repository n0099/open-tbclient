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
public class om5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<sm5> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new sm5(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<jn> b(sm5 sm5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sm5Var)) == null) {
            List<ThreadInfo> list = sm5Var.e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    pm5 pm5Var = new pm5();
                    pm5Var.a = sm5Var.a;
                    pm5Var.b = sm5Var.b;
                    pm5Var.c = sm5Var.c;
                    pm5Var.parserProtobuf(threadInfo);
                    arrayList.add(pm5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<sm5> list, List<sm5> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (sm5 sm5Var : list2) {
            if (sm5Var != null) {
                hashMap.put(e(sm5Var), sm5Var.e);
            }
        }
        for (sm5 sm5Var2 : list) {
            if (sm5Var2 != null && !ListUtils.isEmpty(sm5Var2.e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < sm5Var2.e.size(); i++) {
                    ThreadInfo threadInfo = sm5Var2.e.get(i);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(sm5Var2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < sm5Var2.e.size()) {
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
                                    sm5Var2.e.set(intValue, threadInfo2);
                                } else {
                                    sm5Var2.e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<jn>, List<jn>> d(String str, List<sm5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (sm5 sm5Var : list) {
                if (sm5Var != null && !ListUtils.isEmpty(sm5Var.e)) {
                    List<jn> b = b(sm5Var);
                    String str2 = sm5Var.b;
                    if (!ListUtils.isEmpty(b) && b.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        tm5 tm5Var = new tm5();
                        tm5Var.a = sm5Var.a;
                        tm5Var.b = str2;
                        tm5Var.c = sm5Var.c;
                        tm5Var.d = sm5Var.d;
                        int i = sm5Var.f;
                        tm5Var.e = sm5Var.g;
                        linkedList.add(tm5Var);
                        int size = b.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i2 = 0;
                        sm5Var.e = sm5Var.e.subList(0, size);
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 < size) {
                                if ("1:1".equals(sm5Var.d)) {
                                    hq5 hq5Var = new hq5();
                                    pm5 pm5Var = (pm5) b.get(i2);
                                    pm5 pm5Var2 = (pm5) b.get(i3);
                                    hq5Var.a = pm5Var;
                                    hq5Var.b = pm5Var2;
                                    arrayList.add(pm5Var);
                                    arrayList.add(pm5Var2);
                                    linkedList.add(hq5Var);
                                } else if ("16:9".equals(sm5Var.d)) {
                                    gq5 gq5Var = new gq5();
                                    pm5 pm5Var3 = (pm5) b.get(i2);
                                    pm5 pm5Var4 = (pm5) b.get(i3);
                                    gq5Var.a = pm5Var3;
                                    gq5Var.b = pm5Var4;
                                    arrayList.add(pm5Var3);
                                    arrayList.add(pm5Var4);
                                    linkedList.add(gq5Var);
                                }
                                i2 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(sm5Var);
                    }
                } else {
                    arrayList2.add(sm5Var);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(sm5 sm5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sm5Var)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(sm5Var.a + "_");
            sb.append(sm5Var.b + "_");
            sb.append(sm5Var.c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(sm5 sm5Var, List<sm5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, sm5Var, list)) == null) {
            if (sm5Var != null && !ListUtils.isEmpty(list)) {
                for (sm5 sm5Var2 : list) {
                    if (sm5Var.a == sm5Var2.a && sm5Var.b.equals(sm5Var2.b) && sm5Var.c.equals(sm5Var2.c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<sm5> g(List<sm5> list, List<sm5> list2, boolean z) {
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
            for (sm5 sm5Var : list2) {
                if (sm5Var != null && !ListUtils.isEmpty(sm5Var.e) && !TextUtils.isEmpty(sm5Var.b)) {
                    if (z) {
                        if (!f(sm5Var, list)) {
                            linkedList.add(sm5Var);
                        }
                    } else {
                        linkedList.add(sm5Var);
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
