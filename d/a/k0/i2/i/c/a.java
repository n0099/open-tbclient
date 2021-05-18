package d.a.k0.i2.i.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import d.a.k0.i2.e.k;
import d.a.k0.x.e0.b;
import d.a.k0.x.e0.e;
import d.a.k0.x.e0.f;
import d.a.k0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f56312a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);

    /* renamed from: b  reason: collision with root package name */
    public static final int f56313b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);

    /* renamed from: c  reason: collision with root package name */
    public static final int f56314c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<n> a(List<a2> list) {
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(list)) {
            return arrayList;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            a2 a2Var = (a2) ListUtils.getItem(list, i2);
            if (a2Var != null) {
                d.a.j0.b.f.a.e(a2Var);
                b d2 = d(a2Var);
                if (d2 != null) {
                    arrayList.add(d2);
                }
            }
        }
        d.a.j0.b.f.a.d(arrayList);
        return arrayList;
    }

    public static List<n> b(List<a2> list) {
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(list)) {
            k kVar = new k();
            kVar.f56242h = f56314c;
            kVar.f56241g = f56313b;
            kVar.f56240f = f56312a;
            kVar.f56239e = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i2 = 0; i2 < list.size(); i2++) {
                a2 a2Var = list.get(i2);
                if (a2Var != null) {
                    d.a.j0.b.f.a.e(a2Var);
                    b d2 = d(a2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            d.a.j0.b.f.a.d(arrayList);
        }
        return arrayList;
    }

    public static List<n> c(List<n> list) {
        a2 a2Var;
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(list)) {
            return arrayList;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            n nVar = (n) ListUtils.getItem(list, i2);
            if ((nVar instanceof CardPersonDynamicThreadData) && (a2Var = ((CardPersonDynamicThreadData) nVar).r) != null) {
                d.a.j0.b.f.a.e(a2Var);
                b d2 = d(a2Var);
                if (d2 != null) {
                    arrayList.add(d2);
                }
            }
        }
        d.a.j0.b.f.a.d(arrayList);
        return arrayList;
    }

    public static b d(a2 a2Var) {
        b bVar = null;
        if (a2Var == null) {
            return null;
        }
        a2Var.W1 = true;
        a2Var.K1();
        if (a2Var.s1) {
            bVar = new d.a.k0.x.e0.k();
            bVar.f63179e = a2Var;
        } else if (e.i0(a2Var)) {
            bVar = new e(a2Var);
        } else if (f.l0(a2Var)) {
            bVar = new f(a2Var);
        } else if (!d.a.k0.x.e0.k.i0(a2Var) && !d.a.k0.x.e0.k.j0(a2Var)) {
            if (l.d0(a2Var)) {
                bVar = new l(a2Var);
            }
        } else {
            bVar = new d.a.k0.x.e0.k();
            if (!a2Var.g2() && !a2Var.u2()) {
                a2Var.b2();
            }
            bVar.f63179e = a2Var;
        }
        if (bVar != null) {
            d.a.j0.b.f.a.e(bVar);
        }
        return bVar;
    }

    public static a2 e(n nVar) {
        if (nVar != null && (nVar instanceof d.a.j0.r.q.a)) {
            a2 m = ((d.a.j0.r.q.a) nVar).m();
            m.W1 = true;
            d.a.j0.b.f.a.e(m);
            return m;
        }
        return null;
    }
}
