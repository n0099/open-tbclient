package d.a.k0.q0.s1.a.a;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f59460a;

    /* renamed from: b  reason: collision with root package name */
    public int f59461b;

    /* renamed from: c  reason: collision with root package name */
    public int f59462c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f59463d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59464e;

    /* renamed from: f  reason: collision with root package name */
    public int f59465f;

    public int a(List<n> list) {
        boolean z;
        if (ListUtils.isEmpty(list)) {
            return 0;
        }
        if (ListUtils.isEmpty(this.f59463d)) {
            LinkedList linkedList = new LinkedList();
            this.f59463d = linkedList;
            linkedList.addAll(list);
            return list.size();
        }
        LinkedList linkedList2 = new LinkedList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            n nVar = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= this.f59463d.size()) {
                    z = false;
                    break;
                }
                n nVar2 = this.f59463d.get(i3);
                if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                    a2 h2 = ((b) nVar).h();
                    a2 h3 = ((b) nVar2).h();
                    if (h2 != null && h3 != null && h2.x1() != null && h3.x1() != null && h2.x1().equals(h3.x1())) {
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
            ListUtils.addAll(this.f59463d, 0, linkedList2);
        }
        return linkedList2.size();
    }
}
