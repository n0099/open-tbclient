package d.a.o0.j2.i.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.o0.j2.e.k;
import d.a.o0.z.e0.b;
import d.a.o0.z.e0.e;
import d.a.o0.z.e0.f;
import d.a.o0.z.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f60310a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);

    /* renamed from: b  reason: collision with root package name */
    public static final int f60311b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);

    /* renamed from: c  reason: collision with root package name */
    public static final int f60312c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);

    public static List<n> a(List<a2> list) {
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(list)) {
            return arrayList;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            a2 a2Var = (a2) ListUtils.getItem(list, i2);
            if (a2Var != null) {
                d.a.n0.b.f.a.e(a2Var);
                b d2 = d(a2Var);
                if (d2 != null) {
                    arrayList.add(d2);
                }
            }
        }
        d.a.n0.b.f.a.d(arrayList);
        return arrayList;
    }

    public static List<n> b(List<a2> list) {
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(list)) {
            k kVar = new k();
            kVar.f60240h = f60312c;
            kVar.f60239g = f60311b;
            kVar.f60238f = f60310a;
            kVar.f60237e = R.string.person_center_tab_main_list_title;
            arrayList.add(kVar);
            for (int i2 = 0; i2 < list.size(); i2++) {
                a2 a2Var = list.get(i2);
                if (a2Var != null) {
                    d.a.n0.b.f.a.e(a2Var);
                    b d2 = d(a2Var);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
            }
            d.a.n0.b.f.a.d(arrayList);
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
                d.a.n0.b.f.a.e(a2Var);
                b d2 = d(a2Var);
                if (d2 != null) {
                    arrayList.add(d2);
                }
            }
        }
        d.a.n0.b.f.a.d(arrayList);
        return arrayList;
    }

    public static b d(a2 a2Var) {
        b bVar = null;
        if (a2Var == null) {
            return null;
        }
        a2Var.Z1 = true;
        a2Var.M1();
        if (a2Var.u1) {
            bVar = new d.a.o0.z.e0.k();
            bVar.f67302e = a2Var;
        } else if (e.i0(a2Var)) {
            bVar = new e(a2Var);
        } else if (f.l0(a2Var)) {
            bVar = new f(a2Var);
        } else if (!d.a.o0.z.e0.k.i0(a2Var) && !d.a.o0.z.e0.k.j0(a2Var)) {
            if (l.d0(a2Var)) {
                bVar = new l(a2Var);
            }
        } else {
            bVar = new d.a.o0.z.e0.k();
            if (!a2Var.i2() && !a2Var.w2()) {
                a2Var.d2();
            }
            bVar.f67302e = a2Var;
        }
        if (bVar != null) {
            d.a.n0.b.f.a.e(bVar);
        }
        return bVar;
    }

    public static a2 e(n nVar) {
        if (nVar != null && (nVar instanceof d.a.n0.r.q.a)) {
            a2 i2 = ((d.a.n0.r.q.a) nVar).i();
            i2.Z1 = true;
            d.a.n0.b.f.a.e(i2);
            return i2;
        }
        return null;
    }
}
