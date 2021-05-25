package d.a.n0.r0.s1.a.a;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f59601a;

    /* renamed from: b  reason: collision with root package name */
    public int f59602b;

    /* renamed from: c  reason: collision with root package name */
    public int f59603c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f59604d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59605e;

    /* renamed from: f  reason: collision with root package name */
    public int f59606f;

    public int a(List<n> list) {
        boolean z;
        if (ListUtils.isEmpty(list)) {
            return 0;
        }
        if (ListUtils.isEmpty(this.f59604d)) {
            LinkedList linkedList = new LinkedList();
            this.f59604d = linkedList;
            linkedList.addAll(list);
            return list.size();
        }
        LinkedList linkedList2 = new LinkedList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            n nVar = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= this.f59604d.size()) {
                    z = false;
                    break;
                }
                n nVar2 = this.f59604d.get(i3);
                if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                    a2 h2 = ((b) nVar).h();
                    a2 h3 = ((b) nVar2).h();
                    if (h2 != null && h3 != null && h2.y1() != null && h3.y1() != null && h2.y1().equals(h3.y1())) {
                        z = true;
                        break;
                    }
                }
                i3++;
            }
            if (!z) {
                ListUtils.add(linkedList2, nVar);
            }
        }
        if (linkedList2.size() != 0) {
            ListUtils.addAll(this.f59604d, 0, linkedList2);
        }
        return linkedList2.size();
    }
}
