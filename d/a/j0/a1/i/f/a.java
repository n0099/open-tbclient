package d.a.j0.a1.i.f;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import d.a.j0.a1.i.e.c;
import d.a.j0.x.e0.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<a2> f51042a = new ArrayList();

    public c a(boolean z, d.a.j0.a1.i.e.a aVar) {
        c cVar = new c();
        cVar.f51039c = aVar.i();
        cVar.f51040d = aVar.a();
        cVar.f51041e = aVar.c();
        ArrayList<a2> h2 = aVar.h();
        if (z) {
            if (!ListUtils.isEmpty(h2)) {
                this.f51042a.clear();
                this.f51042a.addAll(h2);
            }
        } else if (!ListUtils.isEmpty(h2)) {
            this.f51042a.addAll(h2);
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.f51042a);
        d(arrayList, aVar.e());
        d(arrayList, aVar.f());
        d(arrayList, aVar.d());
        d(arrayList, aVar.g());
        cVar.f51037a = b(arrayList);
        return cVar;
    }

    public final ArrayList<n> b(ArrayList<n> arrayList) {
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof a2) {
                a2 a2Var = (a2) next;
                int[] p0 = a2Var.p0();
                if (a2Var.getType() == a2.H2) {
                    z1 z1Var = new z1();
                    z1Var.w = a2Var;
                    z1Var.position = i2;
                    z1Var.f49334e = true;
                    arrayList2.add(z1Var);
                    z1 z1Var2 = new z1();
                    z1Var2.w = a2Var;
                    z1Var2.position = i2;
                    if (a2Var.P1()) {
                        z1Var2.j = true;
                    } else if (a2Var.W2() == 1) {
                        z1Var2.f49337h = true;
                        z1Var2.x = p0[0];
                        z1Var2.y = p0[1];
                    } else if (a2Var.W2() >= 2) {
                        z1Var2.f49338i = true;
                    } else {
                        z1Var2.f49335f = true;
                    }
                    arrayList2.add(z1Var2);
                    if (a2Var.y0() != null) {
                        z1 z1Var3 = new z1();
                        z1Var3.r = true;
                        z1Var3.w = a2Var;
                        z1Var3.position = i2;
                        arrayList2.add(z1Var3);
                    }
                    if (!ListUtils.isEmpty(a2Var.G0()) || !ListUtils.isEmpty(a2Var.l0())) {
                        z1 z1Var4 = new z1();
                        z1Var4.w = a2Var;
                        z1Var4.position = i2;
                        if (ListUtils.getCount(a2Var.G0()) + ListUtils.getCount(a2Var.l0()) == 1) {
                            z1Var4.t = true;
                        } else if (ListUtils.getCount(a2Var.G0()) + ListUtils.getCount(a2Var.l0()) > 1) {
                            z1Var4.u = true;
                        }
                        arrayList2.add(z1Var4);
                    }
                    z1 z1Var5 = new z1();
                    z1Var5.q = true;
                    z1Var5.w = a2Var;
                    z1Var5.position = i2;
                    arrayList2.add(z1Var5);
                    z1 z1Var6 = new z1();
                    z1Var6.k = true;
                    z1Var6.w = a2Var;
                    z1Var6.position = i2;
                    arrayList2.add(z1Var6);
                } else if (a2Var.getType() == a2.e3) {
                    z1 z1Var7 = new z1();
                    z1Var7.w = a2Var;
                    z1Var7.position = i2;
                    z1Var7.f49334e = true;
                    arrayList2.add(z1Var7);
                    z1 z1Var8 = new z1();
                    z1Var8.w = a2Var;
                    z1Var8.position = i2;
                    z1Var8.m = true;
                    arrayList2.add(z1Var8);
                    if (a2Var.y0() != null) {
                        z1 z1Var9 = new z1();
                        z1Var9.r = true;
                        z1Var9.w = a2Var;
                        z1Var9.position = i2;
                        arrayList2.add(z1Var9);
                    }
                    z1 z1Var10 = new z1();
                    z1Var10.q = true;
                    z1Var10.w = a2Var;
                    z1Var10.position = i2;
                    arrayList2.add(z1Var10);
                    z1 z1Var11 = new z1();
                    z1Var11.k = true;
                    z1Var11.w = a2Var;
                    z1Var11.position = i2;
                    arrayList2.add(z1Var11);
                } else if (a2Var.getType() == a2.W2 && a2Var.O1()) {
                    a2Var.position = i2;
                    arrayList2.add(a2Var);
                } else if (j.i0(a2Var)) {
                    j jVar = new j(a2Var);
                    jVar.l = a2Var.w1();
                    arrayList2.add(jVar);
                } else {
                    z1 z1Var12 = new z1();
                    z1Var12.w = a2Var;
                    z1Var12.position = i2;
                    arrayList2.add(z1Var12);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i2;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i2++;
        }
        d.a.i0.b.f.a.d(arrayList2);
        return arrayList2;
    }

    public boolean c() {
        List<a2> list = this.f51042a;
        if (list == null) {
            return false;
        }
        return !ListUtils.isEmpty(list);
    }

    public final void d(ArrayList<n> arrayList, d.a.i0.r.q.a aVar) {
        int i2;
        if (aVar == null || arrayList == null || (i2 = aVar.floorPosition) <= 0) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (arrayList.get(i4) instanceof a2) {
                if (i2 == i3) {
                    ListUtils.add(arrayList, i4, aVar);
                    return;
                }
                i3++;
            }
        }
    }
}
