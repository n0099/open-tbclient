package d.a.n0.r0.s1.a.a;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f63292a;

    /* renamed from: b  reason: collision with root package name */
    public int f63293b;

    /* renamed from: c  reason: collision with root package name */
    public int f63294c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f63295d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63296e;

    /* renamed from: f  reason: collision with root package name */
    public int f63297f;

    public int a(List<n> list) {
        boolean z;
        if (ListUtils.isEmpty(list)) {
            return 0;
        }
        if (ListUtils.isEmpty(this.f63295d)) {
            LinkedList linkedList = new LinkedList();
            this.f63295d = linkedList;
            linkedList.addAll(list);
            return list.size();
        }
        LinkedList linkedList2 = new LinkedList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            n nVar = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= this.f63295d.size()) {
                    z = false;
                    break;
                }
                n nVar2 = this.f63295d.get(i3);
                if (nVar != null && (nVar instanceof b) && nVar2 != null && (nVar2 instanceof b)) {
                    a2 c2 = ((b) nVar).c();
                    a2 c3 = ((b) nVar2).c();
                    if (c2 != null && c3 != null && c2.z1() != null && c3.z1() != null && c2.z1().equals(c3.z1())) {
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
            ListUtils.addAll(this.f63295d, 0, linkedList2);
        }
        return linkedList2.size();
    }
}
