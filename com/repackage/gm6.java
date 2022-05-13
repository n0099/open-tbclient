package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.lego.card.model.ICardInfo;
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
public class gm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public List<eo> c;
    public List<eo> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<ro> f;
    public FrsViewData g;
    public CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gm6 gm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gm6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                gm6 gm6Var = this.a;
                gm6Var.g(gm6Var.b);
                gm6 gm6Var2 = this.a;
                gm6Var2.q(gm6Var2.f, this.a.g);
            }
        }
    }

    public gm6(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new LinkedList();
        this.h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
        this.e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.c = new ArrayList();
                ArrayList<BdUniqueId> g = yi8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        pc6<ICardInfo, ? extends TypeAdapter.ViewHolder> b = jc6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b != null) {
                            this.d.add(b);
                            this.c.add(b);
                        }
                    }
                    if (ListUtils.isEmpty(this.c)) {
                        return true;
                    }
                    bdTypeRecyclerView.a(this.c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<ro> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ro roVar = arrayList.get(i);
            if ((roVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(roVar)) {
                this.e.put(Integer.valueOf(i), (ThreadData) roVar);
            }
        }
    }

    public List<ro> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            gh6 gh6Var = new gh6(frsNewAreaFragment.i(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            gh6Var.h0(bdTypeRecyclerView);
            sg6 sg6Var = new sg6(frsNewAreaFragment.i(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            sg6Var.h0(bdTypeRecyclerView);
            dh6 dh6Var = new dh6(frsNewAreaFragment.i(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            dh6Var.h0(bdTypeRecyclerView);
            ah6 ah6Var = new ah6(frsNewAreaFragment.i(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            ah6Var.h0(bdTypeRecyclerView);
            rg6 rg6Var = new rg6(frsNewAreaFragment.i(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            rg6Var.h0(bdTypeRecyclerView);
            ug6 ug6Var = new ug6(frsNewAreaFragment.i(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            ug6Var.h0(bdTypeRecyclerView);
            ih6 ih6Var = new ih6(frsNewAreaFragment.i(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            ih6Var.h0(bdTypeRecyclerView);
            eh6 eh6Var = new eh6(frsNewAreaFragment.i(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            eh6Var.h0(bdTypeRecyclerView);
            ch6 ch6Var = new ch6(frsNewAreaFragment.i(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            zg6 zg6Var = new zg6(frsNewAreaFragment.i(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            hh6 hh6Var = new hh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            hh6Var.h0(bdTypeRecyclerView);
            tg6 tg6Var = new tg6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            tg6Var.h0(bdTypeRecyclerView);
            xg6 xg6Var = new xg6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            xg6Var.h0(bdTypeRecyclerView);
            jg6 jg6Var = new jg6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            jg6Var.h0(bdTypeRecyclerView);
            og6 og6Var = new og6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            og6Var.h0(bdTypeRecyclerView);
            pg6 pg6Var = new pg6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            pg6Var.h0(bdTypeRecyclerView);
            bh6 bh6Var = new bh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            bh6Var.h0(bdTypeRecyclerView);
            hh6 hh6Var2 = new hh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            hh6Var2.h0(bdTypeRecyclerView);
            wc6 wc6Var = new wc6(frsNewAreaFragment.getPageContext(), xc6.b);
            wc6Var.h0(bdTypeRecyclerView);
            eo<? extends br4, ? extends TypeAdapter.ViewHolder> a2 = jc6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            eo<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = jc6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            eo<?, ?> d2 = ja8.l().d(this.a, AdvertAppInfo.t);
            eo<?, ?> d3 = ja8.l().d(this.a, AdvertAppInfo.w);
            fh6 fh6Var = new fh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            fh6Var.h0(bdTypeRecyclerView);
            mg6 mg6Var = new mg6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            mg6Var.c0(bdTypeRecyclerView);
            this.d.add(gh6Var);
            this.d.add(sg6Var);
            this.d.add(dh6Var);
            this.d.add(ah6Var);
            this.d.add(rg6Var);
            this.d.add(ug6Var);
            this.d.add(eh6Var);
            this.d.add(ih6Var);
            this.d.add(ch6Var);
            this.d.add(zg6Var);
            this.d.add(hh6Var);
            this.d.add(xg6Var);
            this.d.add(jg6Var);
            this.d.add(og6Var);
            this.d.add(pg6Var);
            this.d.add(bh6Var);
            this.d.add(wc6Var);
            this.d.add(tg6Var);
            this.d.add(hh6Var2);
            this.d.add(fh6Var);
            this.d.add(mg6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(d2);
            this.d.add(d3);
            eo<?, ?> b = fr6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.E);
            eo<?, ?> b2 = fr6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.D);
            this.d.add(b);
            this.d.add(b2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<eo<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    eo<?, ?> next = it.next();
                    if (next instanceof pc6) {
                        ((pc6) next).n(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<eo> list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            hi5 hi5Var = new hi5(this.a, 1);
            hi5Var.t(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, hi5Var));
            bdTypeRecyclerView.a(this.d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (eo eoVar : this.d) {
                if (eoVar instanceof pc6) {
                    ((pc6) eoVar).c0();
                } else if (eoVar instanceof aa8) {
                    ((aa8) eoVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setData(this.f);
            l();
        }
    }

    public void q(ArrayList<ro> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            yi8.f(arrayList, 1);
            i(arrayList);
            this.b.setData(arrayList);
            this.f = arrayList;
            this.g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).f0(frsViewData);
            }
        }
    }

    public void u(bp bpVar) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bpVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar != null && (eoVar instanceof pc6)) {
                ((pc6) eoVar).V(bpVar);
            }
        }
    }

    public final void v() {
        ho6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.g == null) {
            return;
        }
        for (eo eoVar : this.d) {
            if ((eoVar instanceof jo6) && (i = ((jo6) eoVar).i()) != null) {
                if (this.g.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.g.getForum() != null) {
                    i.c = this.g.getForum().getId();
                    i.d = this.g.getForum().getName();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.b) == null || bdTypeRecyclerView.getData() == null || this.b.getData().size() == 0) {
            return;
        }
        for (ro roVar : this.b.getData()) {
            if (roVar instanceof br4) {
                br4 br4Var = (br4) roVar;
                if (br4Var.s.getIs_top() != 0) {
                    br4Var.s.parser_title();
                }
            }
        }
    }
}
