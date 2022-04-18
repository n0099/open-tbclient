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
public class th6 implements hi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public zo b;
    public List<ho> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<uo> e;
    public FrsViewData f;
    public boolean g;
    public final id6 h;
    public gi6 i;
    public ho j;
    public bi6 k;
    public nh6 l;
    public yh6 m;
    public vh6 n;
    public mh6 o;
    public ph6 p;
    public zh6 q;
    public di6 r;
    public xh6 s;
    public uh6 t;
    public ci6 u;
    public oh6 v;
    public wh6 w;

    public th6(FrsFragment frsFragment, zo zoVar, boolean z) {
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
        this.h = new id6();
        p(frsFragment, zoVar);
        this.d = new HashMap<>();
        n(z);
    }

    @Override // com.repackage.hi6
    public void a(String str) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (ho hoVar : list) {
            if (hoVar instanceof rx5) {
                ((rx5) hoVar).a(str);
            }
        }
    }

    @Override // com.repackage.hi6
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
            } else if (uoVar instanceof qq4) {
                qq4 qq4Var = (qq4) uoVar;
                if (qq4Var.s.getIs_top() != 0) {
                    qq4Var.s.parser_title();
                }
            }
        }
    }

    @Override // com.repackage.hi6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090afb;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.hi6
    public void d(dp dpVar) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dpVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).V(dpVar);
            } else if ((hoVar instanceof wh6) || (hoVar instanceof ci6)) {
                hoVar.V(dpVar);
            }
        }
    }

    @Override // com.repackage.hi6
    public void e() {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).n(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        z(this.c);
    }

    @Override // com.repackage.hi6
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

    @Override // com.repackage.hi6
    public void g(ArrayList<uo> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            bk8.f(arrayList, 1);
            o(arrayList);
            x(arrayList);
            s(arrayList);
            Iterator<uo> it = arrayList.iterator();
            while (it.hasNext()) {
                uo next = it.next();
                if ((next instanceof qq4) && ((qq4) next).s.isTop()) {
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

    @Override // com.repackage.hi6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.repackage.hi6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ad6;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.hi6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ba3;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.hi6
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

    @Override // com.repackage.hi6
    public void l(fd6 fd6Var) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fd6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).e0(fd6Var);
            }
        }
    }

    @Override // com.repackage.hi6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (ho hoVar : this.c) {
                if (hoVar instanceof kd6) {
                    ((kd6) hoVar).c0();
                } else if (hoVar instanceof ca8) {
                    ((ca8) hoVar).onDestroy();
                }
            }
        }
    }

    @Override // com.repackage.hi6
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    @Override // com.repackage.hi6
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
            this.j = ed6.e().c(frsFragment.getPageContext(), ek8.d, this.a.getUniqueId(), false);
            bi6 bi6Var = new bi6(frsFragment.i(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = bi6Var;
            bi6Var.h0(zoVar);
            nh6 nh6Var = new nh6(frsFragment.i(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = nh6Var;
            nh6Var.h0(zoVar);
            yh6 yh6Var = new yh6(frsFragment.i(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = yh6Var;
            yh6Var.h0(zoVar);
            vh6 vh6Var = new vh6(frsFragment.i(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = vh6Var;
            vh6Var.h0(zoVar);
            mh6 mh6Var = new mh6(frsFragment.i(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = mh6Var;
            mh6Var.h0(zoVar);
            ph6 ph6Var = new ph6(frsFragment.i(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = ph6Var;
            ph6Var.h0(zoVar);
            di6 di6Var = new di6(frsFragment.i(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = di6Var;
            di6Var.h0(zoVar);
            zh6 zh6Var = new zh6(frsFragment.i(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = zh6Var;
            zh6Var.h0(zoVar);
            xh6 xh6Var = new xh6(frsFragment.i(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = xh6Var;
            xh6Var.h0(zoVar);
            uh6 uh6Var = new uh6(frsFragment.i(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = uh6Var;
            uh6Var.h0(zoVar);
            ci6 ci6Var = new ci6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = ci6Var;
            ci6Var.h0(zoVar);
            oh6 oh6Var = new oh6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = oh6Var;
            oh6Var.h0(zoVar);
            sh6 sh6Var = new sh6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            sh6Var.h0(zoVar);
            ai6 ai6Var = new ai6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ai6Var.h0(zoVar);
            dh6 dh6Var = new dh6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            dh6Var.h0(zoVar);
            dh6Var.r(1);
            fh6 fh6Var = new fh6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            fh6Var.h0(zoVar);
            eh6 eh6Var = new eh6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            eh6Var.h0(zoVar);
            eh6Var.K0(true);
            jh6 jh6Var = new jh6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            jh6Var.h0(zoVar);
            jh6Var.K0(true);
            kh6 kh6Var = new kh6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            kh6Var.h0(zoVar);
            kh6Var.L0(true);
            ci6 ci6Var2 = new ci6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            ci6Var2.h0(zoVar);
            rh6 rh6Var = new rh6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            rh6Var.h0(zoVar);
            qh6 qh6Var = new qh6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            qh6Var.h0(zoVar);
            this.i = new gi6(frsFragment.getPageContext(), wj8.c, this.a.getUniqueId());
            wh6 wh6Var = new wh6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = wh6Var;
            wh6Var.h0(zoVar);
            ho<? extends qq4, ? extends TypeAdapter.ViewHolder> a = ed6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            ho<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = ed6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            rd6 rd6Var = new rd6(frsFragment.getPageContext(), sd6.b);
            lh6 lh6Var = new lh6(frsFragment.getPageContext(), ud6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), wd6.e, this.a.getUniqueId());
            hh6 hh6Var = new hh6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            hh6Var.c0((BdTypeRecyclerView) zoVar);
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
            this.c.add(sh6Var);
            this.c.add(ai6Var);
            this.c.add(dh6Var);
            this.c.add(fh6Var);
            this.c.add(eh6Var);
            this.c.add(jh6Var);
            this.c.add(kh6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(rd6Var);
            this.c.add(lh6Var);
            this.c.add(rh6Var);
            this.c.add(qh6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(ci6Var2);
            this.c.add(hh6Var);
            this.c.add(fs6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.H));
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
                if (next instanceof kd6) {
                    ((kd6) next).n(this.a.getPageContext(), this.a.getUniqueId());
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
                if (uoVar2 instanceof qq4) {
                    ThreadData threadData = ((qq4) uoVar2).s;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (uoVar instanceof ud6) {
                        threadData.needTopMargin = false;
                    } else if (uoVar != null && !q(uoVar)) {
                        threadData.needTopMargin = false;
                    } else if ((uoVar instanceof qq4) && q(uoVar) && !TextUtils.isEmpty(((qq4) uoVar).s.getRecomReason())) {
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

    @Override // com.repackage.hi6
    public void setFromCDN(boolean z) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.c) {
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).setFromCDN(z);
            }
        }
        bi6 bi6Var = this.k;
        if (bi6Var != null) {
            bi6Var.setFromCDN(z);
        }
        nh6 nh6Var = this.l;
        if (nh6Var != null) {
            nh6Var.setFromCDN(z);
        }
        yh6 yh6Var = this.m;
        if (yh6Var != null) {
            yh6Var.setFromCDN(z);
        }
        vh6 vh6Var = this.n;
        if (vh6Var != null) {
            vh6Var.setFromCDN(z);
        }
        mh6 mh6Var = this.o;
        if (mh6Var != null) {
            mh6Var.setFromCDN(z);
        }
        ph6 ph6Var = this.p;
        if (ph6Var != null) {
            ph6Var.setFromCDN(z);
        }
        ci6 ci6Var = this.u;
        if (ci6Var != null) {
            ci6Var.setFromCDN(z);
        }
        wh6 wh6Var = this.w;
        if (wh6Var != null) {
            wh6Var.setFromCDN(z);
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
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).j0(this.a.getTbPageTag());
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
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).f0(frsViewData);
            }
        }
    }

    public final void w() {
        gp6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f == null) {
            return;
        }
        for (ho hoVar : this.c) {
            if ((hoVar instanceof ip6) && (i = ((ip6) hoVar).i()) != null) {
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
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).k0(i);
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        gi6 gi6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (gi6Var = this.i) == null) {
            return;
        }
        gi6Var.q0(this.f.getForum().getId());
    }

    public final void z(List<ho> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, list) == null) || list == null) {
            return;
        }
        for (ho hoVar : list) {
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).d0(this.h);
            }
        }
    }
}
