package d.b.i0.h2.i.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.h2.e.k;
import d.b.i0.x.e0.b;
import d.b.i0.x.e0.e;
import d.b.i0.x.e0.f;
import d.b.i0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f55367a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);

    /* renamed from: b  reason: collision with root package name */
    public static final int f55368b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);

    /* renamed from: c  reason: collision with root package name */
    public static final int f55369c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<n> a(List<a2> list) {
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            a2 a2Var = (a2) ListUtils.getItem(list, i);
            if (a2Var != null) {
                d.b.h0.b.f.a.e(a2Var);
                b d2 = d(a2Var);
                if (d2 != null) {
                    arrayList.add(d2);
                }
            }
        }
        d.b.h0.b.f.a.d(arrayList);
        return arrayList;
    }

    public static List<n> b(List<a2> list) {
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(list)) {
            k kVar = new k();
            kVar.f55301h = f55369c;
            kVar.f55300g = f55368b;
            kVar.f55299f = f55367a;
            kVar.f55298e = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i = 0; i < list.size(); i++) {
                a2 a2Var = list.get(i);
                if (a2Var != null) {
                    d.b.h0.b.f.a.e(a2Var);
                    b d2 = d(a2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            d.b.h0.b.f.a.d(arrayList);
        }
        return arrayList;
    }

    public static List<n> c(List<n> list) {
        a2 a2Var;
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            n nVar = (n) ListUtils.getItem(list, i);
            if ((nVar instanceof CardPersonDynamicThreadData) && (a2Var = ((CardPersonDynamicThreadData) nVar).r) != null) {
                d.b.h0.b.f.a.e(a2Var);
                b d2 = d(a2Var);
                if (d2 != null) {
                    arrayList.add(d2);
                }
            }
        }
        d.b.h0.b.f.a.d(arrayList);
        return arrayList;
    }

    public static b d(a2 a2Var) {
        b bVar = null;
        if (a2Var == null) {
            return null;
        }
        a2Var.W1 = true;
        a2Var.J1();
        if (a2Var.s1) {
            bVar = new d.b.i0.x.e0.k();
            bVar.f62196e = a2Var;
        } else if (e.i0(a2Var)) {
            bVar = new e(a2Var);
        } else if (f.l0(a2Var)) {
            bVar = new f(a2Var);
        } else if (!d.b.i0.x.e0.k.i0(a2Var) && !d.b.i0.x.e0.k.j0(a2Var)) {
            if (l.d0(a2Var)) {
                bVar = new l(a2Var);
            }
        } else {
            bVar = new d.b.i0.x.e0.k();
            if (!a2Var.e2() && !a2Var.r2()) {
                a2Var.Z1();
            }
            bVar.f62196e = a2Var;
        }
        if (bVar != null) {
            d.b.h0.b.f.a.e(bVar);
        }
        return bVar;
    }

    public static a2 e(n nVar) {
        if (nVar != null && (nVar instanceof d.b.h0.r.q.a)) {
            a2 n = ((d.b.h0.r.q.a) nVar).n();
            n.W1 = true;
            d.b.h0.b.f.a.e(n);
            return n;
        }
        return null;
    }
}
