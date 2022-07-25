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
/* loaded from: classes6.dex */
public class mh6 implements ai6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public tn b;
    public List<an> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<nn> e;
    public FrsViewData f;
    public boolean g;
    public final ad6 h;
    public zh6 i;
    public an j;
    public uh6 k;
    public gh6 l;
    public rh6 m;
    public oh6 n;
    public fh6 o;
    public ih6 p;
    public sh6 q;
    public wh6 r;
    public qh6 s;
    public nh6 t;
    public vh6 u;
    public hh6 v;
    public ph6 w;

    public mh6(FrsFragment frsFragment, tn tnVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, tnVar, Boolean.valueOf(z)};
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
        this.b = tnVar;
        this.h = new ad6();
        p(frsFragment, tnVar);
        this.d = new HashMap<>();
        n(z);
    }

    @Override // com.repackage.ai6
    public void a(String str) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (an anVar : list) {
            if (anVar instanceof hy5) {
                ((hy5) anVar).a(str);
            }
        }
    }

    @Override // com.repackage.ai6
    public void b() {
        tn tnVar;
        List<nn> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tnVar = this.b) == null || tnVar.getData() == null || this.b.getData().size() == 0 || (data = this.b.getData()) == null || data.size() == 0) {
            return;
        }
        for (nn nnVar : data) {
            if (nnVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) nnVar;
                if (threadData.getIs_top() != 0) {
                    threadData.parser_title();
                }
            } else if (nnVar instanceof rq4) {
                rq4 rq4Var = (rq4) nnVar;
                if (rq4Var.s.getIs_top() != 0) {
                    rq4Var.s.parser_title();
                }
            }
        }
    }

    @Override // com.repackage.ai6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ac6;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ai6
    public void d(xn xnVar) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, xnVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).V(xnVar);
            } else if ((anVar instanceof ph6) || (anVar instanceof vh6)) {
                anVar.V(xnVar);
            }
        }
    }

    @Override // com.repackage.ai6
    public void e() {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).n(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        z(this.c);
    }

    @Override // com.repackage.ai6
    public List<nn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            tn tnVar = this.b;
            if (tnVar != null) {
                return tnVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.ai6
    public void g(ArrayList<nn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            nh8.f(arrayList, 1);
            o(arrayList);
            x(arrayList);
            s(arrayList);
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
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

    @Override // com.repackage.ai6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.repackage.ai6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090aa1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ai6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b6b;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ai6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (an anVar : this.c) {
                if (anVar != null && anVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ai6
    public void l(xc6 xc6Var) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, xc6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).e0(xc6Var);
            }
        }
    }

    @Override // com.repackage.ai6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (an anVar : this.c) {
                if (anVar instanceof cd6) {
                    ((cd6) anVar).c0();
                } else if (anVar instanceof j98) {
                    ((j98) anVar).onDestroy();
                }
            }
        }
    }

    @Override // com.repackage.ai6
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    @Override // com.repackage.ai6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.b.getListAdapter() == null) {
            return;
        }
        this.b.getListAdapter().notifyDataSetChanged();
    }

    public final ArrayList<Integer> o(ArrayList<nn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                nn nnVar = arrayList.get(i);
                if (nnVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i));
                    HashMap<Integer, ThreadData> hashMap = this.d;
                    if (hashMap != null && !hashMap.containsValue(nnVar)) {
                        this.d.put(Integer.valueOf(i), (ThreadData) nnVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void p(FrsFragment frsFragment, tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, frsFragment, tnVar) == null) {
            this.a = frsFragment;
            this.j = wc6.e().c(frsFragment.getPageContext(), qh8.d, this.a.getUniqueId(), false);
            uh6 uh6Var = new uh6(frsFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = uh6Var;
            uh6Var.h0(tnVar);
            gh6 gh6Var = new gh6(frsFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = gh6Var;
            gh6Var.h0(tnVar);
            rh6 rh6Var = new rh6(frsFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = rh6Var;
            rh6Var.h0(tnVar);
            oh6 oh6Var = new oh6(frsFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = oh6Var;
            oh6Var.h0(tnVar);
            fh6 fh6Var = new fh6(frsFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = fh6Var;
            fh6Var.h0(tnVar);
            ih6 ih6Var = new ih6(frsFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = ih6Var;
            ih6Var.h0(tnVar);
            wh6 wh6Var = new wh6(frsFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = wh6Var;
            wh6Var.h0(tnVar);
            sh6 sh6Var = new sh6(frsFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = sh6Var;
            sh6Var.h0(tnVar);
            qh6 qh6Var = new qh6(frsFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = qh6Var;
            qh6Var.h0(tnVar);
            nh6 nh6Var = new nh6(frsFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = nh6Var;
            nh6Var.h0(tnVar);
            vh6 vh6Var = new vh6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = vh6Var;
            vh6Var.h0(tnVar);
            hh6 hh6Var = new hh6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = hh6Var;
            hh6Var.h0(tnVar);
            lh6 lh6Var = new lh6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            lh6Var.h0(tnVar);
            th6 th6Var = new th6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            th6Var.h0(tnVar);
            wg6 wg6Var = new wg6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            wg6Var.h0(tnVar);
            wg6Var.q(1);
            yg6 yg6Var = new yg6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            yg6Var.h0(tnVar);
            xg6 xg6Var = new xg6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            xg6Var.h0(tnVar);
            xg6Var.K0(true);
            ch6 ch6Var = new ch6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ch6Var.h0(tnVar);
            ch6Var.K0(true);
            dh6 dh6Var = new dh6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            dh6Var.h0(tnVar);
            dh6Var.L0(true);
            vh6 vh6Var2 = new vh6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            vh6Var2.h0(tnVar);
            kh6 kh6Var = new kh6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            kh6Var.h0(tnVar);
            jh6 jh6Var = new jh6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            jh6Var.h0(tnVar);
            this.i = new zh6(frsFragment.getPageContext(), ih8.c, this.a.getUniqueId());
            ph6 ph6Var = new ph6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = ph6Var;
            ph6Var.h0(tnVar);
            an<? extends rq4, ? extends TypeAdapter.ViewHolder> a = wc6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            an<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = wc6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            jd6 jd6Var = new jd6(frsFragment.getPageContext(), kd6.b);
            eh6 eh6Var = new eh6(frsFragment.getPageContext(), md6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), od6.e, this.a.getUniqueId());
            ah6 ah6Var = new ah6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            ah6Var.c0((BdTypeRecyclerView) tnVar);
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
            this.c.add(lh6Var);
            this.c.add(th6Var);
            this.c.add(wg6Var);
            this.c.add(yg6Var);
            this.c.add(xg6Var);
            this.c.add(ch6Var);
            this.c.add(dh6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(jd6Var);
            this.c.add(eh6Var);
            this.c.add(kh6Var);
            this.c.add(jh6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(vh6Var2);
            this.c.add(ah6Var);
            this.c.add(ar6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.E));
            bj5 bj5Var = new bj5(this.a, 1);
            bj5Var.t(this.c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bj5Var));
            z(this.c);
            tnVar.a(this.c);
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
            Iterator<an<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                an<?, ?> next = it.next();
                if (next instanceof cd6) {
                    ((cd6) next).n(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<an> list = this.c;
            if (list != null) {
                list.addAll(arrayList);
            }
            tn tnVar2 = this.b;
            if (tnVar2 != null) {
                tnVar2.a(arrayList);
            }
        }
    }

    public final boolean q(nn nnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, nnVar)) == null) {
            if (nnVar == null) {
                return false;
            }
            BdUniqueId type = nnVar.getType();
            return type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_GOD_NORMAL || type == ThreadData.TYPE_VIDEO || type == ThreadData.TYPE_VIDEO_GOD || type == ThreadData.TYPE_INSERT_VIDEO;
        }
        return invokeL.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<nn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public final void s(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                nn nnVar = (nn) ListUtils.getItem(arrayList, i - 1);
                nn nnVar2 = (nn) ListUtils.getItem(arrayList, i);
                if (nnVar2 instanceof rq4) {
                    ThreadData threadData = ((rq4) nnVar2).s;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (nnVar instanceof md6) {
                        threadData.needTopMargin = false;
                    } else if (nnVar != null && !q(nnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((nnVar instanceof rq4) && q(nnVar) && !TextUtils.isEmpty(((rq4) nnVar).s.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (q(nnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.repackage.ai6
    public void setFromCDN(boolean z) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).setFromCDN(z);
            }
        }
        uh6 uh6Var = this.k;
        if (uh6Var != null) {
            uh6Var.setFromCDN(z);
        }
        gh6 gh6Var = this.l;
        if (gh6Var != null) {
            gh6Var.setFromCDN(z);
        }
        rh6 rh6Var = this.m;
        if (rh6Var != null) {
            rh6Var.setFromCDN(z);
        }
        oh6 oh6Var = this.n;
        if (oh6Var != null) {
            oh6Var.setFromCDN(z);
        }
        fh6 fh6Var = this.o;
        if (fh6Var != null) {
            fh6Var.setFromCDN(z);
        }
        ih6 ih6Var = this.p;
        if (ih6Var != null) {
            ih6Var.setFromCDN(z);
        }
        vh6 vh6Var = this.u;
        if (vh6Var != null) {
            vh6Var.setFromCDN(z);
        }
        ph6 ph6Var = this.w;
        if (ph6Var != null) {
            ph6Var.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (an anVar : list) {
            if (anVar instanceof ck5) {
                ((ck5) anVar).g(str);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frsViewData) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).f0(frsViewData);
            }
        }
    }

    public final void w() {
        eo6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f == null) {
            return;
        }
        for (an anVar : this.c) {
            if ((anVar instanceof go6) && (i = ((go6) anVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.L0() != null) {
                    int V = this.a.L0().V();
                    if (V == -1) {
                        V = this.a.L0().U();
                    }
                    i.b = V;
                }
            }
        }
    }

    public final void x(ArrayList<nn> arrayList) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, arrayList) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                i++;
            }
        }
        for (an anVar : this.c) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).k0(i);
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        zh6 zh6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (zh6Var = this.i) == null) {
            return;
        }
        zh6Var.q0(this.f.getForum().getId());
    }

    public final void z(List<an> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, list) == null) || list == null) {
            return;
        }
        for (an anVar : list) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).d0(this.h);
            }
        }
    }
}
