package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class rh6 implements fi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public zo b;
    public List<ho> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<uo> e;
    public FrsViewData f;
    public boolean g;
    public final gd6 h;
    public ei6 i;
    public ho j;
    public zh6 k;
    public lh6 l;
    public wh6 m;
    public th6 n;
    public kh6 o;
    public nh6 p;
    public xh6 q;
    public bi6 r;
    public vh6 s;
    public sh6 t;
    public ai6 u;
    public mh6 v;
    public uh6 w;

    public rh6(FrsFragment frsFragment, zo zoVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, zoVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        this.g = false;
        this.b = zoVar;
        this.h = new gd6();
        p(frsFragment, zoVar);
        this.d = new HashMap<>();
        n(z);
    }

    @Override // com.repackage.fi6
    public void a(String str) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (ho hoVar : list) {
            if (hoVar instanceof px5) {
                ((px5) hoVar).a(str);
            }
        }
    }

    @Override // com.repackage.fi6
    public void b() {
        zo zoVar;
        List<uo> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (zoVar = this.b) == null || zoVar.getData() == null || this.b.getData().size() == 0 || (data = this.b.getData()) == null || data.size() == 0) {
            return;
        }
        for (uo uoVar : data) {
            if (uoVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) uoVar;
                if (threadData.getIs_top() != 0) {
                    threadData.parser_title();
                }
            } else if (uoVar instanceof rq4) {
                rq4 rq4Var = (rq4) uoVar;
                if (rq4Var.s.getIs_top() != 0) {
                    rq4Var.s.parser_title();
                }
            }
        }
    }

    @Override // com.repackage.fi6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090afa;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.fi6
    public void d(dp dpVar) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dpVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof id6) {
                ((id6) hoVar).V(dpVar);
            } else if ((hoVar instanceof uh6) || (hoVar instanceof ai6)) {
                hoVar.V(dpVar);
            }
        }
    }

    @Override // com.repackage.fi6
    public void e() {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof id6) {
                ((id6) hoVar).n(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        z(this.c);
    }

    @Override // com.repackage.fi6
    public List<uo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            zo zoVar = this.b;
            if (zoVar != null) {
                return zoVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.fi6
    public void g(ArrayList<uo> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            uj8.f(arrayList, 1);
            o(arrayList);
            x(arrayList);
            s(arrayList);
            Iterator<uo> it = arrayList.iterator();
            while (it.hasNext()) {
                uo next = it.next();
                if ((next instanceof rq4) && ((rq4) next).s.isTop()) {
                    it.remove();
                }
            }
            this.b.setData(arrayList);
            this.f = frsViewData;
            w();
            y();
            this.e = arrayList;
        }
    }

    @Override // com.repackage.fi6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.repackage.fi6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ad5;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.fi6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ba2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.fi6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (ho hoVar : this.c) {
                if (hoVar != null && hoVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.fi6
    public void l(dd6 dd6Var) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, dd6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof id6) {
                ((id6) hoVar).e0(dd6Var);
            }
        }
    }

    @Override // com.repackage.fi6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (ho hoVar : this.c) {
                if (hoVar instanceof id6) {
                    ((id6) hoVar).c0();
                } else if (hoVar instanceof v98) {
                    ((v98) hoVar).onDestroy();
                }
            }
        }
    }

    @Override // com.repackage.fi6
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    @Override // com.repackage.fi6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.b.getListAdapter() == null) {
            return;
        }
        this.b.getListAdapter().notifyDataSetChanged();
    }

    public final ArrayList<Integer> o(ArrayList<uo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                uo uoVar = arrayList.get(i);
                if (uoVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i));
                    HashMap<Integer, ThreadData> hashMap = this.d;
                    if (hashMap != null && !hashMap.containsValue(uoVar)) {
                        this.d.put(Integer.valueOf(i), (ThreadData) uoVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void p(FrsFragment frsFragment, zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, frsFragment, zoVar) == null) {
            this.a = frsFragment;
            this.j = cd6.e().c(frsFragment.getPageContext(), xj8.d, this.a.getUniqueId(), false);
            zh6 zh6Var = new zh6(frsFragment.i(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = zh6Var;
            zh6Var.h0(zoVar);
            lh6 lh6Var = new lh6(frsFragment.i(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = lh6Var;
            lh6Var.h0(zoVar);
            wh6 wh6Var = new wh6(frsFragment.i(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = wh6Var;
            wh6Var.h0(zoVar);
            th6 th6Var = new th6(frsFragment.i(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = th6Var;
            th6Var.h0(zoVar);
            kh6 kh6Var = new kh6(frsFragment.i(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = kh6Var;
            kh6Var.h0(zoVar);
            nh6 nh6Var = new nh6(frsFragment.i(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = nh6Var;
            nh6Var.h0(zoVar);
            bi6 bi6Var = new bi6(frsFragment.i(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = bi6Var;
            bi6Var.h0(zoVar);
            xh6 xh6Var = new xh6(frsFragment.i(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = xh6Var;
            xh6Var.h0(zoVar);
            vh6 vh6Var = new vh6(frsFragment.i(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = vh6Var;
            vh6Var.h0(zoVar);
            sh6 sh6Var = new sh6(frsFragment.i(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = sh6Var;
            sh6Var.h0(zoVar);
            ai6 ai6Var = new ai6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = ai6Var;
            ai6Var.h0(zoVar);
            mh6 mh6Var = new mh6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = mh6Var;
            mh6Var.h0(zoVar);
            qh6 qh6Var = new qh6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            qh6Var.h0(zoVar);
            yh6 yh6Var = new yh6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            yh6Var.h0(zoVar);
            bh6 bh6Var = new bh6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            bh6Var.h0(zoVar);
            bh6Var.r(1);
            dh6 dh6Var = new dh6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            dh6Var.h0(zoVar);
            ch6 ch6Var = new ch6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ch6Var.h0(zoVar);
            ch6Var.K0(true);
            hh6 hh6Var = new hh6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            hh6Var.h0(zoVar);
            hh6Var.K0(true);
            ih6 ih6Var = new ih6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            ih6Var.h0(zoVar);
            ih6Var.L0(true);
            ai6 ai6Var2 = new ai6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            ai6Var2.h0(zoVar);
            ph6 ph6Var = new ph6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            ph6Var.h0(zoVar);
            oh6 oh6Var = new oh6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            oh6Var.h0(zoVar);
            this.i = new ei6(frsFragment.getPageContext(), pj8.c, this.a.getUniqueId());
            uh6 uh6Var = new uh6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = uh6Var;
            uh6Var.h0(zoVar);
            ho<? extends rq4, ? extends TypeAdapter.ViewHolder> a = cd6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            ho<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = cd6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            pd6 pd6Var = new pd6(frsFragment.getPageContext(), qd6.b);
            jh6 jh6Var = new jh6(frsFragment.getPageContext(), sd6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), ud6.e, this.a.getUniqueId());
            fh6 fh6Var = new fh6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            fh6Var.c0((BdTypeRecyclerView) zoVar);
            this.c.add(this.j);
            this.c.add(this.k);
            this.c.add(this.l);
            this.c.add(this.m);
            this.c.add(this.n);
            this.c.add(this.o);
            this.c.add(this.p);
            this.c.add(this.q);
            this.c.add(this.r);
            this.c.add(this.s);
            this.c.add(this.t);
            this.c.add(this.i);
            this.c.add(qh6Var);
            this.c.add(yh6Var);
            this.c.add(bh6Var);
            this.c.add(dh6Var);
            this.c.add(ch6Var);
            this.c.add(hh6Var);
            this.c.add(ih6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(pd6Var);
            this.c.add(jh6Var);
            this.c.add(ph6Var);
            this.c.add(oh6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(ai6Var2);
            this.c.add(fh6Var);
            this.c.add(ds6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.H));
            oh5 oh5Var = new oh5(this.a, 1);
            oh5Var.t(this.c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, oh5Var));
            z(this.c);
            zoVar.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            t("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<ho<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                ho<?, ?> next = it.next();
                if (next instanceof id6) {
                    ((id6) next).n(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<ho> list = this.c;
            if (list != null) {
                list.addAll(arrayList);
            }
            zo zoVar2 = this.b;
            if (zoVar2 != null) {
                zoVar2.a(arrayList);
            }
        }
    }

    public final boolean q(uo uoVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, uoVar)) == null) {
            if (uoVar == null) {
                return false;
            }
            BdUniqueId type = uoVar.getType();
            return type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_GOD_NORMAL || type == ThreadData.TYPE_VIDEO || type == ThreadData.TYPE_VIDEO_GOD || type == ThreadData.TYPE_INSERT_VIDEO;
        }
        return invokeL.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<uo> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public final void s(ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                uo uoVar = (uo) ListUtils.getItem(arrayList, i - 1);
                uo uoVar2 = (uo) ListUtils.getItem(arrayList, i);
                if (uoVar2 instanceof rq4) {
                    ThreadData threadData = ((rq4) uoVar2).s;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (uoVar instanceof sd6) {
                        threadData.needTopMargin = false;
                    } else if (uoVar != null && !q(uoVar)) {
                        threadData.needTopMargin = false;
                    } else if ((uoVar instanceof rq4) && q(uoVar) && !TextUtils.isEmpty(((rq4) uoVar).s.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (q(uoVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.repackage.fi6
    public void setFromCDN(boolean z) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof id6) {
                ((id6) hoVar).setFromCDN(z);
            }
        }
        zh6 zh6Var = this.k;
        if (zh6Var != null) {
            zh6Var.setFromCDN(z);
        }
        lh6 lh6Var = this.l;
        if (lh6Var != null) {
            lh6Var.setFromCDN(z);
        }
        wh6 wh6Var = this.m;
        if (wh6Var != null) {
            wh6Var.setFromCDN(z);
        }
        th6 th6Var = this.n;
        if (th6Var != null) {
            th6Var.setFromCDN(z);
        }
        kh6 kh6Var = this.o;
        if (kh6Var != null) {
            kh6Var.setFromCDN(z);
        }
        nh6 nh6Var = this.p;
        if (nh6Var != null) {
            nh6Var.setFromCDN(z);
        }
        ai6 ai6Var = this.u;
        if (ai6Var != null) {
            ai6Var.setFromCDN(z);
        }
        uh6 uh6Var = this.w;
        if (uh6Var != null) {
            uh6Var.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (ho hoVar : list) {
            if (hoVar instanceof qi5) {
                ((qi5) hoVar).g(str);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof id6) {
                ((id6) hoVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frsViewData) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof id6) {
                ((id6) hoVar).f0(frsViewData);
            }
        }
    }

    public final void w() {
        ep6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f == null) {
            return;
        }
        for (ho hoVar : this.c) {
            if ((hoVar instanceof gp6) && (i = ((gp6) hoVar).i()) != null) {
                if (this.f.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.f.getForum() != null) {
                    i.c = this.f.getForum().getId();
                    i.d = this.f.getForum().getName();
                }
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.b0() != null) {
                    int T = this.a.b0().T();
                    if (T == -1) {
                        T = this.a.b0().S();
                    }
                    i.b = T;
                }
            }
        }
    }

    public final void x(ArrayList<uo> arrayList) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, arrayList) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<uo> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                i++;
            }
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof id6) {
                ((id6) hoVar).k0(i);
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        ei6 ei6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (ei6Var = this.i) == null) {
            return;
        }
        ei6Var.q0(this.f.getForum().getId());
    }

    public final void z(List<ho> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, list) == null) || list == null) {
            return;
        }
        for (ho hoVar : list) {
            if (hoVar instanceof id6) {
                ((id6) hoVar).d0(this.h);
            }
        }
    }
}
