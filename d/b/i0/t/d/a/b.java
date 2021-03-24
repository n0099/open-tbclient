package d.b.i0.t.d.a;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {
    public static List<d.b.i0.t.d.b.b.a> a(List<HotLiveWithCategory> list) {
        if (ListUtils.isEmpty(list)) {
            return new LinkedList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (HotLiveWithCategory hotLiveWithCategory : list) {
            if (hotLiveWithCategory != null) {
                arrayList.add(new d.b.i0.t.d.b.b.a(hotLiveWithCategory));
            }
        }
        return arrayList;
    }

    public static List<n> b(d.b.i0.t.d.b.b.a aVar) {
        List<ThreadInfo> list = aVar.f60254e;
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null && threadInfo.thread_type.intValue() == 49) {
                c cVar = new c();
                cVar.f60238e = aVar.f60250a;
                cVar.f60239f = aVar.f60251b;
                cVar.f60240g = aVar.f60252c;
                cVar.j(threadInfo);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public static void c(List<d.b.i0.t.d.b.b.a> list, List<d.b.i0.t.d.b.b.a> list2, List<Long> list3) {
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (d.b.i0.t.d.b.b.a aVar : list2) {
            if (aVar != null) {
                hashMap.put(e(aVar), aVar.f60254e);
            }
        }
        for (d.b.i0.t.d.b.b.a aVar2 : list) {
            if (aVar2 != null && !ListUtils.isEmpty(aVar2.f60254e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < aVar2.f60254e.size(); i++) {
                    ThreadInfo threadInfo = aVar2.f60254e.get(i);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i));
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
                            if (intValue < aVar2.f60254e.size()) {
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
                                    aVar2.f60254e.set(intValue, threadInfo2);
                                } else {
                                    aVar2.f60254e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<n>, List<n>> d(String str, List<d.b.i0.t.d.b.b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (d.b.i0.t.d.b.b.a aVar : list) {
            if (aVar != null && !ListUtils.isEmpty(aVar.f60254e)) {
                List<n> b2 = b(aVar);
                String str2 = aVar.f60251b;
                if (!ListUtils.isEmpty(b2) && b2.size() >= 2 && !TextUtils.isEmpty(str2)) {
                    d.b.i0.t.d.b.b.b bVar = new d.b.i0.t.d.b.b.b();
                    bVar.f60257e = aVar.f60250a;
                    bVar.f60258f = str2;
                    bVar.f60259g = aVar.f60252c;
                    bVar.f60260h = aVar.f60253d;
                    int i = aVar.f60255f;
                    bVar.i = aVar.f60256g;
                    linkedList.add(bVar);
                    int size = b2.size();
                    if (size % 2 != 0) {
                        size--;
                    }
                    int i2 = 0;
                    aVar.f60254e = aVar.f60254e.subList(0, size);
                    while (true) {
                        int i3 = i2 + 1;
                        if (i3 < size) {
                            if ("1:1".equals(aVar.f60253d)) {
                                d.b.i0.t.d.g.b.b bVar2 = new d.b.i0.t.d.g.b.b();
                                c cVar = (c) b2.get(i2);
                                c cVar2 = (c) b2.get(i3);
                                bVar2.f60607e = cVar;
                                bVar2.f60608f = cVar2;
                                arrayList.add(cVar);
                                arrayList.add(cVar2);
                                linkedList.add(bVar2);
                            } else if ("16:9".equals(aVar.f60253d)) {
                                d.b.i0.t.d.g.b.a aVar2 = new d.b.i0.t.d.g.b.a();
                                c cVar3 = (c) b2.get(i2);
                                c cVar4 = (c) b2.get(i3);
                                aVar2.f60604e = cVar3;
                                aVar2.f60605f = cVar4;
                                arrayList.add(cVar3);
                                arrayList.add(cVar4);
                                linkedList.add(aVar2);
                            }
                            i2 += 2;
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

    public static String e(d.b.i0.t.d.b.b.a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.f60250a + "_");
        sb.append(aVar.f60251b + "_");
        sb.append(aVar.f60252c);
        return sb.toString();
    }

    public static boolean f(d.b.i0.t.d.b.b.a aVar, List<d.b.i0.t.d.b.b.a> list) {
        if (aVar != null && !ListUtils.isEmpty(list)) {
            for (d.b.i0.t.d.b.b.a aVar2 : list) {
                if (aVar.f60250a == aVar2.f60250a && aVar.f60251b.equals(aVar2.f60251b) && aVar.f60252c.equals(aVar2.f60252c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<d.b.i0.t.d.b.b.a> g(List<d.b.i0.t.d.b.b.a> list, List<d.b.i0.t.d.b.b.a> list2, boolean z) {
        if (list == null || list.isEmpty()) {
            return list2;
        }
        if (list2 == null || list2.isEmpty()) {
            return list;
        }
        LinkedList linkedList = new LinkedList();
        for (d.b.i0.t.d.b.b.a aVar : list2) {
            if (aVar != null && !ListUtils.isEmpty(aVar.f60254e) && !TextUtils.isEmpty(aVar.f60251b)) {
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
