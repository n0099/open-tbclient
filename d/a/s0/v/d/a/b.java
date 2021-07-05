package d.a.s0.v.d.a;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<d.a.s0.v.d.b.b.a> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new d.a.s0.v.d.b.b.a(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(d.a.s0.v.d.b.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            List<ThreadInfo> list = aVar.f67450e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    c cVar = new c();
                    cVar.f67433e = aVar.f67446a;
                    cVar.f67434f = aVar.f67447b;
                    cVar.f67435g = aVar.f67448c;
                    cVar.c(threadInfo);
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<d.a.s0.v.d.b.b.a> list, List<d.a.s0.v.d.b.b.a> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (d.a.s0.v.d.b.b.a aVar : list2) {
            if (aVar != null) {
                hashMap.put(e(aVar), aVar.f67450e);
            }
        }
        for (d.a.s0.v.d.b.b.a aVar2 : list) {
            if (aVar2 != null && !ListUtils.isEmpty(aVar2.f67450e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < aVar2.f67450e.size(); i2++) {
                    ThreadInfo threadInfo = aVar2.f67450e.get(i2);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i2));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(aVar2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < aVar2.f67450e.size()) {
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
                                    aVar2.f67450e.set(intValue, threadInfo2);
                                } else {
                                    aVar2.f67450e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<n>, List<n>> d(String str, List<d.a.s0.v.d.b.b.a> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (d.a.s0.v.d.b.b.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f67450e)) {
                    List<n> b2 = b(aVar);
                    String str2 = aVar.f67447b;
                    if (!ListUtils.isEmpty(b2) && b2.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        d.a.s0.v.d.b.b.b bVar = new d.a.s0.v.d.b.b.b();
                        bVar.f67453e = aVar.f67446a;
                        bVar.f67454f = str2;
                        bVar.f67455g = aVar.f67448c;
                        bVar.f67456h = aVar.f67449d;
                        int i2 = aVar.f67451f;
                        bVar.f67457i = aVar.f67452g;
                        linkedList.add(bVar);
                        int size = b2.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i3 = 0;
                        aVar.f67450e = aVar.f67450e.subList(0, size);
                        while (true) {
                            int i4 = i3 + 1;
                            if (i4 < size) {
                                if ("1:1".equals(aVar.f67449d)) {
                                    d.a.s0.v.d.g.b.b bVar2 = new d.a.s0.v.d.g.b.b();
                                    c cVar = (c) b2.get(i3);
                                    c cVar2 = (c) b2.get(i4);
                                    bVar2.f67805e = cVar;
                                    bVar2.f67806f = cVar2;
                                    arrayList.add(cVar);
                                    arrayList.add(cVar2);
                                    linkedList.add(bVar2);
                                } else if ("16:9".equals(aVar.f67449d)) {
                                    d.a.s0.v.d.g.b.a aVar2 = new d.a.s0.v.d.g.b.a();
                                    c cVar3 = (c) b2.get(i3);
                                    c cVar4 = (c) b2.get(i4);
                                    aVar2.f67802e = cVar3;
                                    aVar2.f67803f = cVar4;
                                    arrayList.add(cVar3);
                                    arrayList.add(cVar4);
                                    linkedList.add(aVar2);
                                }
                                i3 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(aVar);
                    }
                } else {
                    arrayList2.add(aVar);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(d.a.s0.v.d.b.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, aVar)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.f67446a + "_");
            sb.append(aVar.f67447b + "_");
            sb.append(aVar.f67448c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(d.a.s0.v.d.b.b.a aVar, List<d.a.s0.v.d.b.b.a> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, list)) == null) {
            if (aVar != null && !ListUtils.isEmpty(list)) {
                for (d.a.s0.v.d.b.b.a aVar2 : list) {
                    if (aVar.f67446a == aVar2.f67446a && aVar.f67447b.equals(aVar2.f67447b) && aVar.f67448c.equals(aVar2.f67448c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<d.a.s0.v.d.b.b.a> g(List<d.a.s0.v.d.b.b.a> list, List<d.a.s0.v.d.b.b.a> list2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, list, list2, z)) == null) {
            if (list == null || list.isEmpty()) {
                return list2;
            }
            if (list2 == null || list2.isEmpty()) {
                return list;
            }
            LinkedList linkedList = new LinkedList();
            for (d.a.s0.v.d.b.b.a aVar : list2) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f67450e) && !TextUtils.isEmpty(aVar.f67447b)) {
                    if (z) {
                        if (!f(aVar, list)) {
                            linkedList.add(aVar);
                        }
                    } else {
                        linkedList.add(aVar);
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
