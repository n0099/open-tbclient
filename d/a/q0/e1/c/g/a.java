package d.a.q0.e1.c.g;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.q0.a0.e0.e;
import d.a.q0.a0.e0.j;
import d.a.q0.a0.e0.k;
import d.a.q0.a0.e0.l;
import d.a.q0.e1.c.d;
import d.a.q0.e1.h.k.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f55763a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55763a = new c();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public c b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2)})) == null) {
            if (i2 == 0 || i2 == 1) {
                if (builder == null) {
                    builder = new DataRes.Builder();
                }
                if (builder2 == null) {
                    builder2 = new DataRes.Builder();
                }
                a(builder);
                a(builder2);
                d(z, builder, builder2, i2);
                LinkedList linkedList = new LinkedList();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                for (ConcernData concernData : builder.thread_info) {
                    if (concernData != null) {
                        if (d.a.q0.e1.c.f.c.j(builder.hot_recomforum, i3)) {
                            d.a.q0.e1.c.f.c cVar = new d.a.q0.e1.c.f.c();
                            if (cVar.e(builder.hot_recomforum.tab_list)) {
                                cVar.position = i3;
                                linkedList.add(cVar);
                                i3++;
                            }
                        }
                        if (d.a.q0.e1.c.f.a.h(concernData)) {
                            d.a.q0.e1.c.f.a aVar = new d.a.q0.e1.c.f.a();
                            if (concernData.recom_user_list.size() >= 4) {
                                aVar.d(concernData.recom_user_list);
                                aVar.position = i3;
                                aVar.j(builder.thread_info.size() > 1);
                                linkedList.add(aVar);
                            }
                        } else {
                            b2 b2Var = new b2();
                            b2Var.t3(true);
                            d.a.p0.b.f.a.e(b2Var);
                            b2Var.K2(concernData.thread_list);
                            JSONObject b2 = d.a.q0.w2.i0.b.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(e(b2Var, i3, concernData));
                        }
                        i3++;
                    }
                }
                d.a.p0.b.f.a.d(linkedList);
                d.a.q0.w2.i0.b.f().h("CONCERN", arrayList);
                c cVar2 = this.f55763a;
                cVar2.f56198a = linkedList;
                return cVar2;
            }
            return null;
        }
        return (c) invokeCommon.objValue;
    }

    public final void c(boolean z, List<ConcernData> list, List<ConcernData> list2, int i2) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i2)}) == null) || list == null || list2 == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        if (i2 == 1) {
            for (ConcernData concernData : list2) {
                if (d.a.q0.e1.c.f.a.h(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!d.J()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && d.a.q0.e1.c.f.a.h(concernData2)) {
                    list.add(0, concernData2);
                } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                    list.add(0, concernData2);
                }
            }
        }
        this.f55763a.f56199b = ListUtils.getCount(list) - count;
    }

    public final void d(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i2) {
        List<ConcernData> list;
        List<ConcernData> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i2)}) == null) || (list = builder.thread_info) == null || (list2 = builder2.thread_info) == null) {
            return;
        }
        c(z, list, list2, i2);
        builder.hot_recomforum = builder2.hot_recomforum;
    }

    public List<n> e(b2 b2Var, int i2, ConcernData concernData) {
        InterceptResult invokeLIL;
        d.a.q0.a0.e0.b kVar;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, b2Var, i2, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((k.W(b2Var) || l.R(b2Var)) && b2Var.getType() != b2.w3) {
                if (l.R(b2Var)) {
                    kVar = new l(b2Var);
                } else {
                    kVar = new k();
                    b2Var.W1();
                    b2Var.k2();
                    if (!b2Var.W1() && !b2Var.k2()) {
                        b2Var.R1();
                    }
                    kVar.f54338e = b2Var;
                }
                kVar.l = b2Var.o1();
                if (k.W(b2Var)) {
                    kVar.L("1");
                } else if (l.R(b2Var)) {
                    kVar.L("2");
                }
                kVar.F = true;
                if (d.a.p0.b.d.i() && kVar.getThreadData() != null && kVar.getThreadData().H() != null) {
                    if (!kVar.getThreadData().H().hadConcerned() && !ThreadCardUtils.isSelf(b2Var)) {
                        d.a.q0.e1.h.k.d.r(kVar);
                        d.a.q0.e1.h.k.d.o(b2Var);
                    } else {
                        d.a.q0.e1.h.k.d.t(kVar);
                    }
                } else {
                    d.a.q0.e1.h.k.d.t(kVar);
                }
                kVar.f54338e.A1();
                if (kVar instanceof k) {
                    if (b2Var.G1()) {
                        d.a.q0.e1.h.k.d.u(kVar);
                    } else if (b2Var.P2() == 1) {
                        d.a.q0.e1.h.k.d.w(kVar);
                        int[] e0 = b2Var.e0();
                        kVar.o = e0[0];
                        kVar.p = e0[1];
                    } else if (b2Var.P2() >= 2) {
                        d.a.q0.e1.h.k.d.v(kVar);
                    } else {
                        d.a.q0.e1.h.k.d.x(kVar);
                    }
                } else if (kVar instanceof l) {
                    d.a.q0.e1.h.k.d.y(kVar);
                }
                if (b2Var.o0() != null) {
                    d.a.q0.e1.h.k.d.z(kVar);
                }
                if (!ListUtils.isEmpty(b2Var.w0()) || !ListUtils.isEmpty(b2Var.a0())) {
                    if (ListUtils.getCount(b2Var.w0()) + ListUtils.getCount(b2Var.a0()) == 1) {
                        d.a.q0.e1.h.k.d.C(kVar);
                    } else {
                        d.a.q0.e1.h.k.d.A(kVar);
                    }
                }
                d.a.q0.e1.h.k.d.q(kVar);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    d.a.q0.e1.h.k.d.s(kVar);
                }
                d.a.q0.e1.h.k.d.p(kVar);
                kVar.setSupportType(BaseCardInfo.SupportType.TOP);
                kVar.position = i2;
                arrayList.add(kVar);
            } else {
                if (d.a.p0.b.d.i()) {
                    b2Var.getThreadData();
                    if (b2Var != null) {
                        b2Var.getThreadData();
                        if (b2Var.H() != null) {
                            b2Var.getThreadData();
                            boolean hadConcerned = b2Var.H().hadConcerned();
                            if (!hadConcerned && (hadConcerned || !ThreadCardUtils.isSelf(b2Var))) {
                                d.a.q0.e1.h.k.d.o(b2Var);
                            }
                        }
                    }
                }
                if (b2Var.v1) {
                    k kVar2 = new k();
                    kVar2.f54338e = b2Var;
                    kVar2.position = i2;
                    arrayList.add(kVar2);
                } else if (l.R(b2Var)) {
                    l lVar = new l(b2Var);
                    lVar.l = b2Var.o1();
                    if (concernData != null) {
                        lVar.K(concernData.source.intValue());
                    }
                    if (lVar.isValid()) {
                        arrayList.add(lVar);
                    }
                } else if (j.W(b2Var)) {
                    j jVar = new j(b2Var);
                    jVar.l = b2Var.o1();
                    jVar.L("3");
                    if (jVar.isValid()) {
                        arrayList.add(jVar);
                    }
                } else if (e.W(b2Var) && b2Var.F1()) {
                    e eVar = new e(b2Var);
                    eVar.position = i2;
                    arrayList.add(eVar);
                } else {
                    k kVar3 = new k();
                    kVar3.f54338e = b2Var;
                    kVar3.L(b2Var.W1() ? "4" : "1");
                    kVar3.position = i2;
                    if (concernData != null) {
                        kVar3.K(concernData.source.intValue());
                    }
                    if (kVar3.f54338e != null && kVar3.isValid() && !StringUtils.isNull(kVar3.f54338e.d0()) && !"0".equals(kVar3.f54338e.o1())) {
                        arrayList.add(kVar3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
