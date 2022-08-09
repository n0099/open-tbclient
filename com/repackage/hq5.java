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
public class hq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<lq5> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new lq5(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<on> b(lq5 lq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lq5Var)) == null) {
            List<ThreadInfo> list = lq5Var.e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    iq5 iq5Var = new iq5();
                    iq5Var.a = lq5Var.a;
                    iq5Var.b = lq5Var.b;
                    iq5Var.c = lq5Var.c;
                    iq5Var.parserProtobuf(threadInfo);
                    arrayList.add(iq5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<lq5> list, List<lq5> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (lq5 lq5Var : list2) {
            if (lq5Var != null) {
                hashMap.put(e(lq5Var), lq5Var.e);
            }
        }
        for (lq5 lq5Var2 : list) {
            if (lq5Var2 != null && !ListUtils.isEmpty(lq5Var2.e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < lq5Var2.e.size(); i++) {
                    ThreadInfo threadInfo = lq5Var2.e.get(i);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(lq5Var2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < lq5Var2.e.size()) {
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
                                    lq5Var2.e.set(intValue, threadInfo2);
                                } else {
                                    lq5Var2.e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<on>, List<on>> d(String str, List<lq5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (lq5 lq5Var : list) {
                if (lq5Var != null && !ListUtils.isEmpty(lq5Var.e)) {
                    List<on> b = b(lq5Var);
                    String str2 = lq5Var.b;
                    if (!ListUtils.isEmpty(b) && b.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        mq5 mq5Var = new mq5();
                        mq5Var.a = lq5Var.a;
                        mq5Var.b = str2;
                        mq5Var.c = lq5Var.c;
                        mq5Var.d = lq5Var.d;
                        int i = lq5Var.f;
                        mq5Var.e = lq5Var.g;
                        linkedList.add(mq5Var);
                        int size = b.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i2 = 0;
                        lq5Var.e = lq5Var.e.subList(0, size);
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 < size) {
                                if ("1:1".equals(lq5Var.d)) {
                                    vt5 vt5Var = new vt5();
                                    iq5 iq5Var = (iq5) b.get(i2);
                                    iq5 iq5Var2 = (iq5) b.get(i3);
                                    vt5Var.a = iq5Var;
                                    vt5Var.b = iq5Var2;
                                    arrayList.add(iq5Var);
                                    arrayList.add(iq5Var2);
                                    linkedList.add(vt5Var);
                                } else if ("16:9".equals(lq5Var.d)) {
                                    ut5 ut5Var = new ut5();
                                    iq5 iq5Var3 = (iq5) b.get(i2);
                                    iq5 iq5Var4 = (iq5) b.get(i3);
                                    ut5Var.a = iq5Var3;
                                    ut5Var.b = iq5Var4;
                                    arrayList.add(iq5Var3);
                                    arrayList.add(iq5Var4);
                                    linkedList.add(ut5Var);
                                }
                                i2 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(lq5Var);
                    }
                } else {
                    arrayList2.add(lq5Var);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(lq5 lq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lq5Var)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(lq5Var.a + "_");
            sb.append(lq5Var.b + "_");
            sb.append(lq5Var.c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(lq5 lq5Var, List<lq5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, lq5Var, list)) == null) {
            if (lq5Var != null && !ListUtils.isEmpty(list)) {
                for (lq5 lq5Var2 : list) {
                    if (lq5Var.a == lq5Var2.a && lq5Var.b.equals(lq5Var2.b) && lq5Var.c.equals(lq5Var2.c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<lq5> g(List<lq5> list, List<lq5> list2, boolean z) {
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
            for (lq5 lq5Var : list2) {
                if (lq5Var != null && !ListUtils.isEmpty(lq5Var.e) && !TextUtils.isEmpty(lq5Var.b)) {
                    if (z) {
                        if (!f(lq5Var, list)) {
                            linkedList.add(lq5Var);
                        }
                    } else {
                        linkedList.add(lq5Var);
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
