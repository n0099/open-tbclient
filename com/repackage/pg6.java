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
public class pg6 implements dh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public tn b;
    public List<an> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<nn> e;
    public FrsViewData f;
    public boolean g;
    public final dc6 h;
    public ch6 i;
    public an j;
    public xg6 k;
    public jg6 l;
    public ug6 m;
    public rg6 n;
    public ig6 o;
    public lg6 p;
    public vg6 q;
    public zg6 r;
    public tg6 s;
    public qg6 t;
    public yg6 u;
    public kg6 v;
    public sg6 w;

    public pg6(FrsFragment frsFragment, tn tnVar, boolean z) {
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
        this.h = new dc6();
        p(frsFragment, tnVar);
        this.d = new HashMap<>();
        n(z);
    }

    @Override // com.repackage.dh6
    public void a(String str) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (an anVar : list) {
            if (anVar instanceof kx5) {
                ((kx5) anVar).a(str);
            }
        }
    }

    @Override // com.repackage.dh6
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
            } else if (nnVar instanceof bq4) {
                bq4 bq4Var = (bq4) nnVar;
                if (bq4Var.s.getIs_top() != 0) {
                    bq4Var.s.parser_title();
                }
            }
        }
    }

    @Override // com.repackage.dh6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ac5;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.dh6
    public void d(xn xnVar) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, xnVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof fc6) {
                ((fc6) anVar).V(xnVar);
            } else if ((anVar instanceof sg6) || (anVar instanceof yg6)) {
                anVar.V(xnVar);
            }
        }
    }

    @Override // com.repackage.dh6
    public void e() {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof fc6) {
                ((fc6) anVar).n(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        z(this.c);
    }

    @Override // com.repackage.dh6
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

    @Override // com.repackage.dh6
    public void g(ArrayList<nn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            sg8.f(arrayList, 1);
            o(arrayList);
            x(arrayList);
            s(arrayList);
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
                if ((next instanceof bq4) && ((bq4) next).s.isTop()) {
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

    @Override // com.repackage.dh6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.repackage.dh6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090aa0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.dh6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b69;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.dh6
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

    @Override // com.repackage.dh6
    public void l(ac6 ac6Var) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ac6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof fc6) {
                ((fc6) anVar).e0(ac6Var);
            }
        }
    }

    @Override // com.repackage.dh6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (an anVar : this.c) {
                if (anVar instanceof fc6) {
                    ((fc6) anVar).c0();
                } else if (anVar instanceof o88) {
                    ((o88) anVar).onDestroy();
                }
            }
        }
    }

    @Override // com.repackage.dh6
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    @Override // com.repackage.dh6
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
            this.j = zb6.e().c(frsFragment.getPageContext(), vg8.d, this.a.getUniqueId(), false);
            xg6 xg6Var = new xg6(frsFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = xg6Var;
            xg6Var.h0(tnVar);
            jg6 jg6Var = new jg6(frsFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = jg6Var;
            jg6Var.h0(tnVar);
            ug6 ug6Var = new ug6(frsFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = ug6Var;
            ug6Var.h0(tnVar);
            rg6 rg6Var = new rg6(frsFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = rg6Var;
            rg6Var.h0(tnVar);
            ig6 ig6Var = new ig6(frsFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = ig6Var;
            ig6Var.h0(tnVar);
            lg6 lg6Var = new lg6(frsFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = lg6Var;
            lg6Var.h0(tnVar);
            zg6 zg6Var = new zg6(frsFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = zg6Var;
            zg6Var.h0(tnVar);
            vg6 vg6Var = new vg6(frsFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = vg6Var;
            vg6Var.h0(tnVar);
            tg6 tg6Var = new tg6(frsFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = tg6Var;
            tg6Var.h0(tnVar);
            qg6 qg6Var = new qg6(frsFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = qg6Var;
            qg6Var.h0(tnVar);
            yg6 yg6Var = new yg6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = yg6Var;
            yg6Var.h0(tnVar);
            kg6 kg6Var = new kg6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = kg6Var;
            kg6Var.h0(tnVar);
            og6 og6Var = new og6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            og6Var.h0(tnVar);
            wg6 wg6Var = new wg6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            wg6Var.h0(tnVar);
            zf6 zf6Var = new zf6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            zf6Var.h0(tnVar);
            zf6Var.q(1);
            bg6 bg6Var = new bg6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            bg6Var.h0(tnVar);
            ag6 ag6Var = new ag6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ag6Var.h0(tnVar);
            ag6Var.K0(true);
            fg6 fg6Var = new fg6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            fg6Var.h0(tnVar);
            fg6Var.K0(true);
            gg6 gg6Var = new gg6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            gg6Var.h0(tnVar);
            gg6Var.L0(true);
            yg6 yg6Var2 = new yg6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            yg6Var2.h0(tnVar);
            ng6 ng6Var = new ng6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            ng6Var.h0(tnVar);
            mg6 mg6Var = new mg6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            mg6Var.h0(tnVar);
            this.i = new ch6(frsFragment.getPageContext(), ng8.c, this.a.getUniqueId());
            sg6 sg6Var = new sg6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = sg6Var;
            sg6Var.h0(tnVar);
            an<? extends bq4, ? extends TypeAdapter.ViewHolder> a = zb6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            an<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = zb6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            mc6 mc6Var = new mc6(frsFragment.getPageContext(), nc6.b);
            hg6 hg6Var = new hg6(frsFragment.getPageContext(), pc6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), rc6.e, this.a.getUniqueId());
            dg6 dg6Var = new dg6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            dg6Var.c0((BdTypeRecyclerView) tnVar);
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
            this.c.add(og6Var);
            this.c.add(wg6Var);
            this.c.add(zf6Var);
            this.c.add(bg6Var);
            this.c.add(ag6Var);
            this.c.add(fg6Var);
            this.c.add(gg6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(mc6Var);
            this.c.add(hg6Var);
            this.c.add(ng6Var);
            this.c.add(mg6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(yg6Var2);
            this.c.add(dg6Var);
            this.c.add(oq6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.E));
            yh5 yh5Var = new yh5(this.a, 1);
            yh5Var.t(this.c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, yh5Var));
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
                if (next instanceof fc6) {
                    ((fc6) next).n(this.a.getPageContext(), this.a.getUniqueId());
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
                if (nnVar2 instanceof bq4) {
                    ThreadData threadData = ((bq4) nnVar2).s;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (nnVar instanceof pc6) {
                        threadData.needTopMargin = false;
                    } else if (nnVar != null && !q(nnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((nnVar instanceof bq4) && q(nnVar) && !TextUtils.isEmpty(((bq4) nnVar).s.getRecomReason())) {
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

    @Override // com.repackage.dh6
    public void setFromCDN(boolean z) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof fc6) {
                ((fc6) anVar).setFromCDN(z);
            }
        }
        xg6 xg6Var = this.k;
        if (xg6Var != null) {
            xg6Var.setFromCDN(z);
        }
        jg6 jg6Var = this.l;
        if (jg6Var != null) {
            jg6Var.setFromCDN(z);
        }
        ug6 ug6Var = this.m;
        if (ug6Var != null) {
            ug6Var.setFromCDN(z);
        }
        rg6 rg6Var = this.n;
        if (rg6Var != null) {
            rg6Var.setFromCDN(z);
        }
        ig6 ig6Var = this.o;
        if (ig6Var != null) {
            ig6Var.setFromCDN(z);
        }
        lg6 lg6Var = this.p;
        if (lg6Var != null) {
            lg6Var.setFromCDN(z);
        }
        yg6 yg6Var = this.u;
        if (yg6Var != null) {
            yg6Var.setFromCDN(z);
        }
        sg6 sg6Var = this.w;
        if (sg6Var != null) {
            sg6Var.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (an anVar : list) {
            if (anVar instanceof zi5) {
                ((zi5) anVar).g(str);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (an anVar : this.c) {
            if (anVar instanceof fc6) {
                ((fc6) anVar).j0(this.a.getTbPageTag());
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
            if (anVar instanceof fc6) {
                ((fc6) anVar).f0(frsViewData);
            }
        }
    }

    public final void w() {
        qn6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f == null) {
            return;
        }
        for (an anVar : this.c) {
            if ((anVar instanceof sn6) && (i = ((sn6) anVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.K0() != null) {
                    int U = this.a.K0().U();
                    if (U == -1) {
                        U = this.a.K0().T();
                    }
                    i.b = U;
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
            if (anVar instanceof fc6) {
                ((fc6) anVar).k0(i);
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        ch6 ch6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (ch6Var = this.i) == null) {
            return;
        }
        ch6Var.q0(this.f.getForum().getId());
    }

    public final void z(List<an> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, list) == null) || list == null) {
            return;
        }
        for (an anVar : list) {
            if (anVar instanceof fc6) {
                ((fc6) anVar).d0(this.h);
            }
        }
    }
}
