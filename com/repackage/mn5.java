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
public class mn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<qn5> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new qn5(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<nn> b(qn5 qn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qn5Var)) == null) {
            List<ThreadInfo> list = qn5Var.e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    nn5 nn5Var = new nn5();
                    nn5Var.a = qn5Var.a;
                    nn5Var.b = qn5Var.b;
                    nn5Var.c = qn5Var.c;
                    nn5Var.parserProtobuf(threadInfo);
                    arrayList.add(nn5Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<qn5> list, List<qn5> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (qn5 qn5Var : list2) {
            if (qn5Var != null) {
                hashMap.put(e(qn5Var), qn5Var.e);
            }
        }
        for (qn5 qn5Var2 : list) {
            if (qn5Var2 != null && !ListUtils.isEmpty(qn5Var2.e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < qn5Var2.e.size(); i++) {
                    ThreadInfo threadInfo = qn5Var2.e.get(i);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(qn5Var2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < qn5Var2.e.size()) {
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
                                    qn5Var2.e.set(intValue, threadInfo2);
                                } else {
                                    qn5Var2.e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<nn>, List<nn>> d(String str, List<qn5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (qn5 qn5Var : list) {
                if (qn5Var != null && !ListUtils.isEmpty(qn5Var.e)) {
                    List<nn> b = b(qn5Var);
                    String str2 = qn5Var.b;
                    if (!ListUtils.isEmpty(b) && b.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        rn5 rn5Var = new rn5();
                        rn5Var.a = qn5Var.a;
                        rn5Var.b = str2;
                        rn5Var.c = qn5Var.c;
                        rn5Var.d = qn5Var.d;
                        int i = qn5Var.f;
                        rn5Var.e = qn5Var.g;
                        linkedList.add(rn5Var);
                        int size = b.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i2 = 0;
                        qn5Var.e = qn5Var.e.subList(0, size);
                        while (true) {
                            int i3 = i2 + 1;
                            if (i3 < size) {
                                if ("1:1".equals(qn5Var.d)) {
                                    gr5 gr5Var = new gr5();
                                    nn5 nn5Var = (nn5) b.get(i2);
                                    nn5 nn5Var2 = (nn5) b.get(i3);
                                    gr5Var.a = nn5Var;
                                    gr5Var.b = nn5Var2;
                                    arrayList.add(nn5Var);
                                    arrayList.add(nn5Var2);
                                    linkedList.add(gr5Var);
                                } else if ("16:9".equals(qn5Var.d)) {
                                    fr5 fr5Var = new fr5();
                                    nn5 nn5Var3 = (nn5) b.get(i2);
                                    nn5 nn5Var4 = (nn5) b.get(i3);
                                    fr5Var.a = nn5Var3;
                                    fr5Var.b = nn5Var4;
                                    arrayList.add(nn5Var3);
                                    arrayList.add(nn5Var4);
                                    linkedList.add(fr5Var);
                                }
                                i2 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(qn5Var);
                    }
                } else {
                    arrayList2.add(qn5Var);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(qn5 qn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, qn5Var)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(qn5Var.a + "_");
            sb.append(qn5Var.b + "_");
            sb.append(qn5Var.c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(qn5 qn5Var, List<qn5> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, qn5Var, list)) == null) {
            if (qn5Var != null && !ListUtils.isEmpty(list)) {
                for (qn5 qn5Var2 : list) {
                    if (qn5Var.a == qn5Var2.a && qn5Var.b.equals(qn5Var2.b) && qn5Var.c.equals(qn5Var2.c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<qn5> g(List<qn5> list, List<qn5> list2, boolean z) {
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
            for (qn5 qn5Var : list2) {
                if (qn5Var != null && !ListUtils.isEmpty(qn5Var.e) && !TextUtils.isEmpty(qn5Var.b)) {
                    if (z) {
                        if (!f(qn5Var, list)) {
                            linkedList.add(qn5Var);
                        }
                    } else {
                        linkedList.add(qn5Var);
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
