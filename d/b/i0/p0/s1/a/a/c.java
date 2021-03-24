package d.b.i0.p0.s1.a.a;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f58523a;

    /* renamed from: b  reason: collision with root package name */
    public int f58524b;

    /* renamed from: c  reason: collision with root package name */
    public int f58525c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f58526d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58527e;

    /* renamed from: f  reason: collision with root package name */
    public int f58528f;

    public int a(List<n> list) {
        boolean z;
        if (ListUtils.isEmpty(list)) {
            return 0;
        }
        if (ListUtils.isEmpty(this.f58526d)) {
            LinkedList linkedList = new LinkedList();
            this.f58526d = linkedList;
            linkedList.addAll(list);
            return list.size();
        }
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            n nVar = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.f58526d.size()) {
                    z = false;
                    break;
                }
                n nVar2 = this.f58526d.get(i2);
                if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                    a2 g2 = ((b) nVar).g();
                    a2 g3 = ((b) nVar2).g();
                    if (g2 != null && g3 != null && g2.w1() != null && g3.w1() != null && g2.w1().equals(g3.w1())) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z) {
                ListUtils.add(linkedList2, nVar);
            }
        }
        if (linkedList2.size() != 0) {
            ListUtils.addAll(this.f58526d, 0, linkedList2);
        }
        return linkedList2.size();
    }
}
