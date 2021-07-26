package d.a.q0.v.d.a;

import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.d.k.e.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<d.a.q0.v.d.b.b.a> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new d.a.q0.v.d.b.b.a(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(d.a.q0.v.d.b.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            List<ThreadInfo> list = aVar.f64877e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    c cVar = new c();
                    cVar.f64860e = aVar.f64873a;
                    cVar.f64861f = aVar.f64874b;
                    cVar.f64862g = aVar.f64875c;
                    cVar.c(threadInfo);
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<d.a.q0.v.d.b.b.a> list, List<d.a.q0.v.d.b.b.a> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (d.a.q0.v.d.b.b.a aVar : list2) {
            if (aVar != null) {
                hashMap.put(e(aVar), aVar.f64877e);
            }
        }
        for (d.a.q0.v.d.b.b.a aVar2 : list) {
            if (aVar2 != null && !ListUtils.isEmpty(aVar2.f64877e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < aVar2.f64877e.size(); i2++) {
                    ThreadInfo threadInfo = aVar2.f64877e.get(i2);
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
                            if (intValue < aVar2.f64877e.size()) {
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
                                    aVar2.f64877e.set(intValue, threadInfo2);
                                } else {
                                    aVar2.f64877e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<n>, List<n>> d(String str, List<d.a.q0.v.d.b.b.a> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (d.a.q0.v.d.b.b.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f64877e)) {
                    List<n> b2 = b(aVar);
                    String str2 = aVar.f64874b;
                    if (!ListUtils.isEmpty(b2) && b2.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        d.a.q0.v.d.b.b.b bVar = new d.a.q0.v.d.b.b.b();
                        bVar.f64880e = aVar.f64873a;
                        bVar.f64881f = str2;
                        bVar.f64882g = aVar.f64875c;
                        bVar.f64883h = aVar.f64876d;
                        int i2 = aVar.f64878f;
                        bVar.f64884i = aVar.f64879g;
                        linkedList.add(bVar);
                        int size = b2.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i3 = 0;
                        aVar.f64877e = aVar.f64877e.subList(0, size);
                        while (true) {
                            int i4 = i3 + 1;
                            if (i4 < size) {
                                if ("1:1".equals(aVar.f64876d)) {
                                    d.a.q0.v.d.g.b.b bVar2 = new d.a.q0.v.d.g.b.b();
                                    c cVar = (c) b2.get(i3);
                                    c cVar2 = (c) b2.get(i4);
                                    bVar2.f65232e = cVar;
                                    bVar2.f65233f = cVar2;
                                    arrayList.add(cVar);
                                    arrayList.add(cVar2);
                                    linkedList.add(bVar2);
                                } else if ("16:9".equals(aVar.f64876d)) {
                                    d.a.q0.v.d.g.b.a aVar2 = new d.a.q0.v.d.g.b.a();
                                    c cVar3 = (c) b2.get(i3);
                                    c cVar4 = (c) b2.get(i4);
                                    aVar2.f65229e = cVar3;
                                    aVar2.f65230f = cVar4;
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

    public static String e(d.a.q0.v.d.b.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.f64873a + "_");
            sb.append(aVar.f64874b + "_");
            sb.append(aVar.f64875c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(d.a.q0.v.d.b.b.a aVar, List<d.a.q0.v.d.b.b.a> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, list)) == null) {
            if (aVar != null && !ListUtils.isEmpty(list)) {
                for (d.a.q0.v.d.b.b.a aVar2 : list) {
                    if (aVar.f64873a == aVar2.f64873a && aVar.f64874b.equals(aVar2.f64874b) && aVar.f64875c.equals(aVar2.f64875c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<d.a.q0.v.d.b.b.a> g(List<d.a.q0.v.d.b.b.a> list, List<d.a.q0.v.d.b.b.a> list2, boolean z) {
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
            for (d.a.q0.v.d.b.b.a aVar : list2) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f64877e) && !TextUtils.isEmpty(aVar.f64874b)) {
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
