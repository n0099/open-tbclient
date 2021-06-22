package d.a.o0.v.d.a;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {
    public static List<d.a.o0.v.d.b.b.a> a(List<HotLiveWithCategory> list) {
        if (ListUtils.isEmpty(list)) {
            return new LinkedList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (HotLiveWithCategory hotLiveWithCategory : list) {
            if (hotLiveWithCategory != null) {
                arrayList.add(new d.a.o0.v.d.b.b.a(hotLiveWithCategory));
            }
        }
        return arrayList;
    }

    public static List<n> b(d.a.o0.v.d.b.b.a aVar) {
        List<ThreadInfo> list = aVar.f65269e;
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                c cVar = new c();
                cVar.f65252e = aVar.f65265a;
                cVar.f65253f = aVar.f65266b;
                cVar.f65254g = aVar.f65267c;
                cVar.g(threadInfo);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public static void c(List<d.a.o0.v.d.b.b.a> list, List<d.a.o0.v.d.b.b.a> list2, List<Long> list3) {
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (d.a.o0.v.d.b.b.a aVar : list2) {
            if (aVar != null) {
                hashMap.put(e(aVar), aVar.f65269e);
            }
        }
        for (d.a.o0.v.d.b.b.a aVar2 : list) {
            if (aVar2 != null && !ListUtils.isEmpty(aVar2.f65269e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < aVar2.f65269e.size(); i2++) {
                    ThreadInfo threadInfo = aVar2.f65269e.get(i2);
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
                            if (intValue < aVar2.f65269e.size()) {
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
                                    aVar2.f65269e.set(intValue, threadInfo2);
                                } else {
                                    aVar2.f65269e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<n>, List<n>> d(String str, List<d.a.o0.v.d.b.b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (d.a.o0.v.d.b.b.a aVar : list) {
            if (aVar != null && !ListUtils.isEmpty(aVar.f65269e)) {
                List<n> b2 = b(aVar);
                String str2 = aVar.f65266b;
                if (!ListUtils.isEmpty(b2) && b2.size() >= 2 && !TextUtils.isEmpty(str2)) {
                    d.a.o0.v.d.b.b.b bVar = new d.a.o0.v.d.b.b.b();
                    bVar.f65272e = aVar.f65265a;
                    bVar.f65273f = str2;
                    bVar.f65274g = aVar.f65267c;
                    bVar.f65275h = aVar.f65268d;
                    int i2 = aVar.f65270f;
                    bVar.f65276i = aVar.f65271g;
                    linkedList.add(bVar);
                    int size = b2.size();
                    if (size % 2 != 0) {
                        size--;
                    }
                    int i3 = 0;
                    aVar.f65269e = aVar.f65269e.subList(0, size);
                    while (true) {
                        int i4 = i3 + 1;
                        if (i4 < size) {
                            if ("1:1".equals(aVar.f65268d)) {
                                d.a.o0.v.d.g.b.b bVar2 = new d.a.o0.v.d.g.b.b();
                                c cVar = (c) b2.get(i3);
                                c cVar2 = (c) b2.get(i4);
                                bVar2.f65627e = cVar;
                                bVar2.f65628f = cVar2;
                                arrayList.add(cVar);
                                arrayList.add(cVar2);
                                linkedList.add(bVar2);
                            } else if ("16:9".equals(aVar.f65268d)) {
                                d.a.o0.v.d.g.b.a aVar2 = new d.a.o0.v.d.g.b.a();
                                c cVar3 = (c) b2.get(i3);
                                c cVar4 = (c) b2.get(i4);
                                aVar2.f65624e = cVar3;
                                aVar2.f65625f = cVar4;
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

    public static String e(d.a.o0.v.d.b.b.a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.f65265a + "_");
        sb.append(aVar.f65266b + "_");
        sb.append(aVar.f65267c);
        return sb.toString();
    }

    public static boolean f(d.a.o0.v.d.b.b.a aVar, List<d.a.o0.v.d.b.b.a> list) {
        if (aVar != null && !ListUtils.isEmpty(list)) {
            for (d.a.o0.v.d.b.b.a aVar2 : list) {
                if (aVar.f65265a == aVar2.f65265a && aVar.f65266b.equals(aVar2.f65266b) && aVar.f65267c.equals(aVar2.f65267c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<d.a.o0.v.d.b.b.a> g(List<d.a.o0.v.d.b.b.a> list, List<d.a.o0.v.d.b.b.a> list2, boolean z) {
        if (list == null || list.isEmpty()) {
            return list2;
        }
        if (list2 == null || list2.isEmpty()) {
            return list;
        }
        LinkedList linkedList = new LinkedList();
        for (d.a.o0.v.d.b.b.a aVar : list2) {
            if (aVar != null && !ListUtils.isEmpty(aVar.f65269e) && !TextUtils.isEmpty(aVar.f65266b)) {
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
}
