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
public class vn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<zn5> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new zn5(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<ro> b(zn5 zn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zn5Var)) == null) {
            List<ThreadInfo> list = zn5Var.e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    wn5 wn5Var = new wn5();
                    wn5Var.a = zn5Var.a;
                    wn5Var.b = zn5Var.b;
                    wn5Var.c = zn5Var.c;
                    wn5Var.parserProtobuf(threadInfo);
                    arrayList.add(wn5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<zn5> list, List<zn5> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (zn5 zn5Var : list2) {
            if (zn5Var != null) {
                hashMap.put(e(zn5Var), zn5Var.e);
            }
        }
        for (zn5 zn5Var2 : list) {
            if (zn5Var2 != null && !ListUtils.isEmpty(zn5Var2.e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < zn5Var2.e.size(); i++) {
                    ThreadInfo threadInfo = zn5Var2.e.get(i);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(zn5Var2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < zn5Var2.e.size()) {
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
                                    zn5Var2.e.set(intValue, threadInfo2);
                                } else {
                                    zn5Var2.e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<ro>, List<ro>> d(String str, List<zn5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (zn5 zn5Var : list) {
                if (zn5Var != null && !ListUtils.isEmpty(zn5Var.e)) {
                    List<ro> b = b(zn5Var);
                    String str2 = zn5Var.b;
                    if (!ListUtils.isEmpty(b) && b.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        ao5 ao5Var = new ao5();
                        ao5Var.a = zn5Var.a;
                        ao5Var.b = str2;
                        ao5Var.c = zn5Var.c;
                        ao5Var.d = zn5Var.d;
                        int i = zn5Var.f;
                        ao5Var.e = zn5Var.g;
                        linkedList.add(ao5Var);
                        int size = b.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i2 = 0;
                        zn5Var.e = zn5Var.e.subList(0, size);
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 < size) {
                                if ("1:1".equals(zn5Var.d)) {
                                    or5 or5Var = new or5();
                                    wn5 wn5Var = (wn5) b.get(i2);
                                    wn5 wn5Var2 = (wn5) b.get(i3);
                                    or5Var.a = wn5Var;
                                    or5Var.b = wn5Var2;
                                    arrayList.add(wn5Var);
                                    arrayList.add(wn5Var2);
                                    linkedList.add(or5Var);
                                } else if ("16:9".equals(zn5Var.d)) {
                                    nr5 nr5Var = new nr5();
                                    wn5 wn5Var3 = (wn5) b.get(i2);
                                    wn5 wn5Var4 = (wn5) b.get(i3);
                                    nr5Var.a = wn5Var3;
                                    nr5Var.b = wn5Var4;
                                    arrayList.add(wn5Var3);
                                    arrayList.add(wn5Var4);
                                    linkedList.add(nr5Var);
                                }
                                i2 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(zn5Var);
                    }
                } else {
                    arrayList2.add(zn5Var);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(zn5 zn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zn5Var)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(zn5Var.a + "_");
            sb.append(zn5Var.b + "_");
            sb.append(zn5Var.c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(zn5 zn5Var, List<zn5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, zn5Var, list)) == null) {
            if (zn5Var != null && !ListUtils.isEmpty(list)) {
                for (zn5 zn5Var2 : list) {
                    if (zn5Var.a == zn5Var2.a && zn5Var.b.equals(zn5Var2.b) && zn5Var.c.equals(zn5Var2.c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<zn5> g(List<zn5> list, List<zn5> list2, boolean z) {
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
            for (zn5 zn5Var : list2) {
                if (zn5Var != null && !ListUtils.isEmpty(zn5Var.e) && !TextUtils.isEmpty(zn5Var.b)) {
                    if (z) {
                        if (!f(zn5Var, list)) {
                            linkedList.add(zn5Var);
                        }
                    } else {
                        linkedList.add(zn5Var);
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
