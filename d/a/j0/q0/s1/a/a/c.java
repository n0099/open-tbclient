package d.a.j0.q0.s1.a.a;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f58718a;

    /* renamed from: b  reason: collision with root package name */
    public int f58719b;

    /* renamed from: c  reason: collision with root package name */
    public int f58720c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f58721d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58722e;

    /* renamed from: f  reason: collision with root package name */
    public int f58723f;

    public int a(List<n> list) {
        boolean z;
        if (ListUtils.isEmpty(list)) {
            return 0;
        }
        if (ListUtils.isEmpty(this.f58721d)) {
            LinkedList linkedList = new LinkedList();
            this.f58721d = linkedList;
            linkedList.addAll(list);
            return list.size();
        }
        LinkedList linkedList2 = new LinkedList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            n nVar = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= this.f58721d.size()) {
                    z = false;
                    break;
                }
                n nVar2 = this.f58721d.get(i3);
                if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                    a2 h2 = ((b) nVar).h();
                    a2 h3 = ((b) nVar2).h();
                    if (h2 != null && h3 != null && h2.w1() != null && h3.w1() != null && h2.w1().equals(h3.w1())) {
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
            ListUtils.addAll(this.f58721d, 0, linkedList2);
        }
        return linkedList2.size();
    }
}
