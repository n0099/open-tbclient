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
public class yg6 implements mh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public xo b;
    public List<eo> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<ro> e;
    public FrsViewData f;
    public boolean g;
    public final nc6 h;
    public lh6 i;
    public eo j;
    public gh6 k;
    public sg6 l;
    public dh6 m;
    public ah6 n;
    public rg6 o;
    public ug6 p;
    public eh6 q;
    public ih6 r;
    public ch6 s;
    public zg6 t;
    public hh6 u;
    public tg6 v;
    public bh6 w;

    public yg6(FrsFragment frsFragment, xo xoVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, xoVar, Boolean.valueOf(z)};
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
        this.b = xoVar;
        this.h = new nc6();
        p(frsFragment, xoVar);
        this.d = new HashMap<>();
        n(z);
    }

    @Override // com.repackage.mh6
    public void a(String str) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (eo eoVar : list) {
            if (eoVar instanceof sx5) {
                ((sx5) eoVar).a(str);
            }
        }
    }

    @Override // com.repackage.mh6
    public void b() {
        xo xoVar;
        List<ro> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (xoVar = this.b) == null || xoVar.getData() == null || this.b.getData().size() == 0 || (data = this.b.getData()) == null || data.size() == 0) {
            return;
        }
        for (ro roVar : data) {
            if (roVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) roVar;
                if (threadData.getIs_top() != 0) {
                    threadData.parser_title();
                }
            } else if (roVar instanceof br4) {
                br4 br4Var = (br4) roVar;
                if (br4Var.s.getIs_top() != 0) {
                    br4Var.s.parser_title();
                }
            }
        }
    }

    @Override // com.repackage.mh6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ae9;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.mh6
    public void d(bp bpVar) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bpVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.c) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).V(bpVar);
            } else if ((eoVar instanceof bh6) || (eoVar instanceof hh6)) {
                eoVar.V(bpVar);
            }
        }
    }

    @Override // com.repackage.mh6
    public void e() {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.c) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).n(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        z(this.c);
    }

    @Override // com.repackage.mh6
    public List<ro> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            xo xoVar = this.b;
            if (xoVar != null) {
                return xoVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.mh6
    public void g(ArrayList<ro> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            yi8.f(arrayList, 1);
            o(arrayList);
            x(arrayList);
            s(arrayList);
            Iterator<ro> it = arrayList.iterator();
            while (it.hasNext()) {
                ro next = it.next();
                if ((next instanceof br4) && ((br4) next).s.isTop()) {
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

    @Override // com.repackage.mh6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.repackage.mh6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ac4;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.mh6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b91;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.mh6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (eo eoVar : this.c) {
                if (eoVar != null && eoVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.mh6
    public void l(kc6 kc6Var) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, kc6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.c) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).e0(kc6Var);
            }
        }
    }

    @Override // com.repackage.mh6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (eo eoVar : this.c) {
                if (eoVar instanceof pc6) {
                    ((pc6) eoVar).c0();
                } else if (eoVar instanceof aa8) {
                    ((aa8) eoVar).onDestroy();
                }
            }
        }
    }

    @Override // com.repackage.mh6
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    @Override // com.repackage.mh6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.b.getListAdapter() == null) {
            return;
        }
        this.b.getListAdapter().notifyDataSetChanged();
    }

    public final ArrayList<Integer> o(ArrayList<ro> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                ro roVar = arrayList.get(i);
                if (roVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i));
                    HashMap<Integer, ThreadData> hashMap = this.d;
                    if (hashMap != null && !hashMap.containsValue(roVar)) {
                        this.d.put(Integer.valueOf(i), (ThreadData) roVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void p(FrsFragment frsFragment, xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, frsFragment, xoVar) == null) {
            this.a = frsFragment;
            this.j = jc6.e().c(frsFragment.getPageContext(), bj8.d, this.a.getUniqueId(), false);
            gh6 gh6Var = new gh6(frsFragment.i(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = gh6Var;
            gh6Var.h0(xoVar);
            sg6 sg6Var = new sg6(frsFragment.i(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = sg6Var;
            sg6Var.h0(xoVar);
            dh6 dh6Var = new dh6(frsFragment.i(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = dh6Var;
            dh6Var.h0(xoVar);
            ah6 ah6Var = new ah6(frsFragment.i(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = ah6Var;
            ah6Var.h0(xoVar);
            rg6 rg6Var = new rg6(frsFragment.i(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = rg6Var;
            rg6Var.h0(xoVar);
            ug6 ug6Var = new ug6(frsFragment.i(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = ug6Var;
            ug6Var.h0(xoVar);
            ih6 ih6Var = new ih6(frsFragment.i(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = ih6Var;
            ih6Var.h0(xoVar);
            eh6 eh6Var = new eh6(frsFragment.i(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = eh6Var;
            eh6Var.h0(xoVar);
            ch6 ch6Var = new ch6(frsFragment.i(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = ch6Var;
            ch6Var.h0(xoVar);
            zg6 zg6Var = new zg6(frsFragment.i(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = zg6Var;
            zg6Var.h0(xoVar);
            hh6 hh6Var = new hh6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = hh6Var;
            hh6Var.h0(xoVar);
            tg6 tg6Var = new tg6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = tg6Var;
            tg6Var.h0(xoVar);
            xg6 xg6Var = new xg6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            xg6Var.h0(xoVar);
            fh6 fh6Var = new fh6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            fh6Var.h0(xoVar);
            ig6 ig6Var = new ig6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            ig6Var.h0(xoVar);
            ig6Var.r(1);
            kg6 kg6Var = new kg6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            kg6Var.h0(xoVar);
            jg6 jg6Var = new jg6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            jg6Var.h0(xoVar);
            jg6Var.K0(true);
            og6 og6Var = new og6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            og6Var.h0(xoVar);
            og6Var.K0(true);
            pg6 pg6Var = new pg6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            pg6Var.h0(xoVar);
            pg6Var.L0(true);
            hh6 hh6Var2 = new hh6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            hh6Var2.h0(xoVar);
            wg6 wg6Var = new wg6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            wg6Var.h0(xoVar);
            vg6 vg6Var = new vg6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            vg6Var.h0(xoVar);
            this.i = new lh6(frsFragment.getPageContext(), ti8.c, this.a.getUniqueId());
            bh6 bh6Var = new bh6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = bh6Var;
            bh6Var.h0(xoVar);
            eo<? extends br4, ? extends TypeAdapter.ViewHolder> a = jc6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            eo<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = jc6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            wc6 wc6Var = new wc6(frsFragment.getPageContext(), xc6.b);
            qg6 qg6Var = new qg6(frsFragment.getPageContext(), zc6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), bd6.e, this.a.getUniqueId());
            mg6 mg6Var = new mg6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            mg6Var.c0((BdTypeRecyclerView) xoVar);
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
            this.c.add(xg6Var);
            this.c.add(fh6Var);
            this.c.add(ig6Var);
            this.c.add(kg6Var);
            this.c.add(jg6Var);
            this.c.add(og6Var);
            this.c.add(pg6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(wc6Var);
            this.c.add(qg6Var);
            this.c.add(wg6Var);
            this.c.add(vg6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(hh6Var2);
            this.c.add(mg6Var);
            this.c.add(fr6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.E));
            hi5 hi5Var = new hi5(this.a, 1);
            hi5Var.t(this.c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, hi5Var));
            z(this.c);
            xoVar.a(this.c);
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
            Iterator<eo<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                eo<?, ?> next = it.next();
                if (next instanceof pc6) {
                    ((pc6) next).n(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<eo> list = this.c;
            if (list != null) {
                list.addAll(arrayList);
            }
            xo xoVar2 = this.b;
            if (xoVar2 != null) {
                xoVar2.a(arrayList);
            }
        }
    }

    public final boolean q(ro roVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, roVar)) == null) {
            if (roVar == null) {
                return false;
            }
            BdUniqueId type = roVar.getType();
            return type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_GOD_NORMAL || type == ThreadData.TYPE_VIDEO || type == ThreadData.TYPE_VIDEO_GOD || type == ThreadData.TYPE_INSERT_VIDEO;
        }
        return invokeL.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<ro> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public final void s(ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                ro roVar = (ro) ListUtils.getItem(arrayList, i - 1);
                ro roVar2 = (ro) ListUtils.getItem(arrayList, i);
                if (roVar2 instanceof br4) {
                    ThreadData threadData = ((br4) roVar2).s;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (roVar instanceof zc6) {
                        threadData.needTopMargin = false;
                    } else if (roVar != null && !q(roVar)) {
                        threadData.needTopMargin = false;
                    } else if ((roVar instanceof br4) && q(roVar) && !TextUtils.isEmpty(((br4) roVar).s.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (q(roVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.repackage.mh6
    public void setFromCDN(boolean z) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.c) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).setFromCDN(z);
            }
        }
        gh6 gh6Var = this.k;
        if (gh6Var != null) {
            gh6Var.setFromCDN(z);
        }
        sg6 sg6Var = this.l;
        if (sg6Var != null) {
            sg6Var.setFromCDN(z);
        }
        dh6 dh6Var = this.m;
        if (dh6Var != null) {
            dh6Var.setFromCDN(z);
        }
        ah6 ah6Var = this.n;
        if (ah6Var != null) {
            ah6Var.setFromCDN(z);
        }
        rg6 rg6Var = this.o;
        if (rg6Var != null) {
            rg6Var.setFromCDN(z);
        }
        ug6 ug6Var = this.p;
        if (ug6Var != null) {
            ug6Var.setFromCDN(z);
        }
        hh6 hh6Var = this.u;
        if (hh6Var != null) {
            hh6Var.setFromCDN(z);
        }
        bh6 bh6Var = this.w;
        if (bh6Var != null) {
            bh6Var.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (eo eoVar : list) {
            if (eoVar instanceof ij5) {
                ((ij5) eoVar).g(str);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (eo eoVar : this.c) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frsViewData) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.c) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).f0(frsViewData);
            }
        }
    }

    public final void w() {
        ho6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f == null) {
            return;
        }
        for (eo eoVar : this.c) {
            if ((eoVar instanceof jo6) && (i = ((jo6) eoVar).i()) != null) {
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

    public final void x(ArrayList<ro> arrayList) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, arrayList) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ro> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                i++;
            }
        }
        for (eo eoVar : this.c) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).k0(i);
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        lh6 lh6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (lh6Var = this.i) == null) {
            return;
        }
        lh6Var.q0(this.f.getForum().getId());
    }

    public final void z(List<eo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, list) == null) || list == null) {
            return;
        }
        for (eo eoVar : list) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).d0(this.h);
            }
        }
    }
}
