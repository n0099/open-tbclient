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
public class un5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<yn5> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new yn5(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<uo> b(yn5 yn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yn5Var)) == null) {
            List<ThreadInfo> list = yn5Var.e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    vn5 vn5Var = new vn5();
                    vn5Var.a = yn5Var.a;
                    vn5Var.b = yn5Var.b;
                    vn5Var.c = yn5Var.c;
                    vn5Var.parserProtobuf(threadInfo);
                    arrayList.add(vn5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<yn5> list, List<yn5> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (yn5 yn5Var : list2) {
            if (yn5Var != null) {
                hashMap.put(e(yn5Var), yn5Var.e);
            }
        }
        for (yn5 yn5Var2 : list) {
            if (yn5Var2 != null && !ListUtils.isEmpty(yn5Var2.e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < yn5Var2.e.size(); i++) {
                    ThreadInfo threadInfo = yn5Var2.e.get(i);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(yn5Var2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < yn5Var2.e.size()) {
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
                                    yn5Var2.e.set(intValue, threadInfo2);
                                } else {
                                    yn5Var2.e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<uo>, List<uo>> d(String str, List<yn5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (yn5 yn5Var : list) {
                if (yn5Var != null && !ListUtils.isEmpty(yn5Var.e)) {
                    List<uo> b = b(yn5Var);
                    String str2 = yn5Var.b;
                    if (!ListUtils.isEmpty(b) && b.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        zn5 zn5Var = new zn5();
                        zn5Var.a = yn5Var.a;
                        zn5Var.b = str2;
                        zn5Var.c = yn5Var.c;
                        zn5Var.d = yn5Var.d;
                        int i = yn5Var.f;
                        zn5Var.e = yn5Var.g;
                        linkedList.add(zn5Var);
                        int size = b.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i2 = 0;
                        yn5Var.e = yn5Var.e.subList(0, size);
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 < size) {
                                if ("1:1".equals(yn5Var.d)) {
                                    nr5 nr5Var = new nr5();
                                    vn5 vn5Var = (vn5) b.get(i2);
                                    vn5 vn5Var2 = (vn5) b.get(i3);
                                    nr5Var.a = vn5Var;
                                    nr5Var.b = vn5Var2;
                                    arrayList.add(vn5Var);
                                    arrayList.add(vn5Var2);
                                    linkedList.add(nr5Var);
                                } else if ("16:9".equals(yn5Var.d)) {
                                    mr5 mr5Var = new mr5();
                                    vn5 vn5Var3 = (vn5) b.get(i2);
                                    vn5 vn5Var4 = (vn5) b.get(i3);
                                    mr5Var.a = vn5Var3;
                                    mr5Var.b = vn5Var4;
                                    arrayList.add(vn5Var3);
                                    arrayList.add(vn5Var4);
                                    linkedList.add(mr5Var);
                                }
                                i2 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(yn5Var);
                    }
                } else {
                    arrayList2.add(yn5Var);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(yn5 yn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yn5Var)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(yn5Var.a + "_");
            sb.append(yn5Var.b + "_");
            sb.append(yn5Var.c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(yn5 yn5Var, List<yn5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, yn5Var, list)) == null) {
            if (yn5Var != null && !ListUtils.isEmpty(list)) {
                for (yn5 yn5Var2 : list) {
                    if (yn5Var.a == yn5Var2.a && yn5Var.b.equals(yn5Var2.b) && yn5Var.c.equals(yn5Var2.c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<yn5> g(List<yn5> list, List<yn5> list2, boolean z) {
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
            for (yn5 yn5Var : list2) {
                if (yn5Var != null && !ListUtils.isEmpty(yn5Var.e) && !TextUtils.isEmpty(yn5Var.b)) {
                    if (z) {
                        if (!f(yn5Var, list)) {
                            linkedList.add(yn5Var);
                        }
                    } else {
                        linkedList.add(yn5Var);
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
