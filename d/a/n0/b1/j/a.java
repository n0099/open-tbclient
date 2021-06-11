package d.a.n0.b1.j;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.n0.z.e0.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static ArrayList<n> a(ArrayList<n> arrayList) {
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof a2) {
                a2 a2Var = (a2) next;
                a2Var.Y1 = true;
                int[] p0 = a2Var.p0();
                if (a2Var.getType() == a2.M2) {
                    if (a2Var != null && a2Var.h0() != null && !StringUtils.isNull(a2Var.h0().f53834b)) {
                        z1 z1Var = new z1();
                        z1Var.w = a2Var;
                        z1Var.position = i2;
                        z1Var.v = true;
                        z1Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(z1Var);
                    } else {
                        z1 z1Var2 = new z1();
                        z1Var2.w = a2Var;
                        z1Var2.position = i2;
                        z1Var2.f53873e = true;
                        z1Var2.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(z1Var2);
                    }
                    z1 z1Var3 = new z1();
                    z1Var3.w = a2Var;
                    z1Var3.position = i2;
                    if (a2Var.S1()) {
                        z1Var3.j = true;
                    } else if (a2Var.a3() == 1) {
                        z1Var3.f53876h = true;
                        z1Var3.x = p0[0];
                        z1Var3.y = p0[1];
                    } else if (a2Var.a3() >= 2) {
                        z1Var3.f53877i = true;
                    } else {
                        z1Var3.f53874f = true;
                    }
                    z1Var3.w.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    z1Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(z1Var3);
                    if (a2Var.z0() != null) {
                        z1 z1Var4 = new z1();
                        z1Var4.r = true;
                        z1Var4.w = a2Var;
                        z1Var4.position = i2;
                        z1Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var4);
                    }
                    if (!ListUtils.isEmpty(a2Var.H0()) || !ListUtils.isEmpty(a2Var.l0())) {
                        z1 z1Var5 = new z1();
                        z1Var5.w = a2Var;
                        z1Var5.position = i2;
                        if (ListUtils.getCount(a2Var.H0()) + ListUtils.getCount(a2Var.l0()) == 1) {
                            z1Var5.t = true;
                        } else if (ListUtils.getCount(a2Var.H0()) + ListUtils.getCount(a2Var.l0()) > 1) {
                            z1Var5.u = true;
                        }
                        z1Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var5);
                    }
                    z1 z1Var6 = new z1();
                    z1Var6.q = true;
                    z1Var6.w = a2Var;
                    z1Var6.position = i2;
                    arrayList2.add(z1Var6);
                    z1 z1Var7 = new z1();
                    z1Var7.k = true;
                    z1Var7.w = a2Var;
                    z1Var7.position = i2;
                    z1Var7.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(z1Var7);
                } else if (a2Var.getType() == a2.j3) {
                    if (a2Var != null && a2Var.h0() != null && !StringUtils.isNull(a2Var.h0().f53834b)) {
                        z1 z1Var8 = new z1();
                        z1Var8.w = a2Var;
                        z1Var8.position = i2;
                        z1Var8.v = true;
                        z1Var8.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(z1Var8);
                    } else {
                        z1 z1Var9 = new z1();
                        z1Var9.w = a2Var;
                        z1Var9.position = i2;
                        z1Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        z1Var9.f53873e = true;
                        arrayList2.add(z1Var9);
                    }
                    z1 z1Var10 = new z1();
                    z1Var10.w = a2Var;
                    z1Var10.position = i2;
                    z1Var10.m = true;
                    a2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    z1Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(z1Var10);
                    if (a2Var.z0() != null) {
                        z1 z1Var11 = new z1();
                        z1Var11.r = true;
                        z1Var11.w = a2Var;
                        z1Var11.position = i2;
                        z1Var11.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(z1Var11);
                    }
                    z1 z1Var12 = new z1();
                    z1Var12.q = true;
                    z1Var12.w = a2Var;
                    z1Var12.position = i2;
                    arrayList2.add(z1Var12);
                    z1 z1Var13 = new z1();
                    z1Var13.k = true;
                    z1Var13.w = a2Var;
                    z1Var13.position = i2;
                    z1Var13.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(z1Var13);
                } else if (a2Var.getType() == a2.b3 && a2Var.R1()) {
                    a2Var.position = i2;
                    a2Var.setSupportType(BaseCardInfo.SupportType.FULL);
                    arrayList2.add(a2Var);
                } else if (j.i0(a2Var)) {
                    j jVar = new j(a2Var);
                    jVar.l = a2Var.z1();
                    jVar.feedBackReasonMap = a2Var.f1;
                    jVar.setSupportType(BaseCardInfo.SupportType.FULL);
                    arrayList2.add(jVar);
                } else {
                    z1 z1Var14 = new z1();
                    z1Var14.w = a2Var;
                    z1Var14.position = i2;
                    z1Var14.setSupportType(BaseCardInfo.SupportType.FULL);
                    arrayList2.add(z1Var14);
                }
            } else if (next instanceof BaseCardInfo) {
                ((BaseCardInfo) next).position = i2;
                arrayList2.add(next);
            } else {
                arrayList2.add(next);
            }
            i2++;
        }
        d.a.m0.b.f.a.d(arrayList2);
        return arrayList2;
    }

    public static List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        ArrayList arrayList = new ArrayList(2);
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
            n B = bdTypeRecyclerView.B(i4);
            a2 a2Var = null;
            if (B instanceof z1) {
                a2Var = ((z1) B).i();
            } else if (B instanceof a2) {
                a2Var = (a2) B;
            } else if (B instanceof j) {
                a2Var = ((j) B).f67177e;
            }
            if (a2Var != null && a2Var.z1().equals(str)) {
                if (!z) {
                    i2 = i4;
                }
                z = true;
                i3 = i4;
            }
        }
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(i3));
        return arrayList;
    }

    public static void c(boolean z, ArrayList<n> arrayList, d.a.m0.r.q.a aVar) {
        int i2;
        if (aVar == null || arrayList == null || (i2 = aVar.floorPosition) < 0) {
            return;
        }
        if (i2 != 0 || z) {
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
}
