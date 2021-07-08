package d.a.p0.e1.j;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.k.e.n;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.p0.a0.e0.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<n> a(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, arrayList)) == null) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof b2) {
                    b2 b2Var = (b2) next;
                    b2Var.Z1 = true;
                    int[] d0 = b2Var.d0();
                    if (b2Var.getType() == b2.O2) {
                        if (b2Var != null && b2Var.V() != null && !StringUtils.isNull(b2Var.V().f52815b)) {
                            a2 a2Var = new a2();
                            a2Var.w = b2Var;
                            a2Var.position = i2;
                            a2Var.v = true;
                            a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                            arrayList2.add(a2Var);
                        } else {
                            a2 a2Var2 = new a2();
                            a2Var2.w = b2Var;
                            a2Var2.position = i2;
                            a2Var2.f52563e = true;
                            a2Var2.setSupportType(BaseCardInfo.SupportType.TOP);
                            arrayList2.add(a2Var2);
                        }
                        a2 a2Var3 = new a2();
                        a2Var3.w = b2Var;
                        a2Var3.position = i2;
                        if (b2Var.F1()) {
                            a2Var3.j = true;
                        } else if (b2Var.N2() == 1) {
                            a2Var3.f52566h = true;
                            a2Var3.x = d0[0];
                            a2Var3.y = d0[1];
                        } else if (b2Var.N2() >= 2) {
                            a2Var3.f52567i = true;
                        } else {
                            a2Var3.f52564f = true;
                        }
                        a2Var3.w.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        a2Var3.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var3);
                        if (b2Var.n0() != null) {
                            a2 a2Var4 = new a2();
                            a2Var4.r = true;
                            a2Var4.w = b2Var;
                            a2Var4.position = i2;
                            a2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var4);
                        }
                        if (!ListUtils.isEmpty(b2Var.v0()) || !ListUtils.isEmpty(b2Var.Z())) {
                            a2 a2Var5 = new a2();
                            a2Var5.w = b2Var;
                            a2Var5.position = i2;
                            if (ListUtils.getCount(b2Var.v0()) + ListUtils.getCount(b2Var.Z()) == 1) {
                                a2Var5.t = true;
                            } else if (ListUtils.getCount(b2Var.v0()) + ListUtils.getCount(b2Var.Z()) > 1) {
                                a2Var5.u = true;
                            }
                            a2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var5);
                        }
                        a2 a2Var6 = new a2();
                        a2Var6.q = true;
                        a2Var6.w = b2Var;
                        a2Var6.position = i2;
                        arrayList2.add(a2Var6);
                        a2 a2Var7 = new a2();
                        a2Var7.k = true;
                        a2Var7.w = b2Var;
                        a2Var7.position = i2;
                        a2Var7.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var7);
                    } else if (b2Var.getType() == b2.l3) {
                        if (b2Var != null && b2Var.V() != null && !StringUtils.isNull(b2Var.V().f52815b)) {
                            a2 a2Var8 = new a2();
                            a2Var8.w = b2Var;
                            a2Var8.position = i2;
                            a2Var8.v = true;
                            a2Var8.setSupportType(BaseCardInfo.SupportType.TOP);
                            arrayList2.add(a2Var8);
                        } else {
                            a2 a2Var9 = new a2();
                            a2Var9.w = b2Var;
                            a2Var9.position = i2;
                            a2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                            a2Var9.f52563e = true;
                            arrayList2.add(a2Var9);
                        }
                        a2 a2Var10 = new a2();
                        a2Var10.w = b2Var;
                        a2Var10.position = i2;
                        a2Var10.m = true;
                        b2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        a2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var10);
                        if (b2Var.n0() != null) {
                            a2 a2Var11 = new a2();
                            a2Var11.r = true;
                            a2Var11.w = b2Var;
                            a2Var11.position = i2;
                            a2Var11.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(a2Var11);
                        }
                        a2 a2Var12 = new a2();
                        a2Var12.q = true;
                        a2Var12.w = b2Var;
                        a2Var12.position = i2;
                        arrayList2.add(a2Var12);
                        a2 a2Var13 = new a2();
                        a2Var13.k = true;
                        a2Var13.w = b2Var;
                        a2Var13.position = i2;
                        a2Var13.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var13);
                    } else if (b2Var.getType() == b2.d3 && b2Var.E1()) {
                        b2Var.position = i2;
                        b2Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(b2Var);
                    } else if (j.W(b2Var)) {
                        j jVar = new j(b2Var);
                        jVar.l = b2Var.n1();
                        jVar.feedBackReasonMap = b2Var.g1;
                        jVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(jVar);
                    } else {
                        a2 a2Var14 = new a2();
                        a2Var14.w = b2Var;
                        a2Var14.position = i2;
                        a2Var14.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(a2Var14);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i2;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            d.a.o0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                n B = bdTypeRecyclerView.B(i4);
                b2 b2Var = null;
                if (B instanceof a2) {
                    b2Var = ((a2) B).getThreadData();
                } else if (B instanceof b2) {
                    b2Var = (b2) B;
                } else if (B instanceof j) {
                    b2Var = ((j) B).f53795e;
                }
                if (b2Var != null && b2Var.n1().equals(str)) {
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
        return (List) invokeLL.objValue;
    }

    public static void c(boolean z, ArrayList<n> arrayList, d.a.o0.r.q.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), arrayList, aVar}) == null) || aVar == null || arrayList == null || (i2 = aVar.floorPosition) < 0) {
            return;
        }
        if (i2 != 0 || z) {
            int size = arrayList.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                if (arrayList.get(i4) instanceof b2) {
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
