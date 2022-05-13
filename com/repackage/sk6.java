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
import com.baidu.tieba.frs.good.FrsGoodFragment;
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
/* loaded from: classes7.dex */
public class sk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public BdTypeRecyclerView b;
    public List<eo> c;
    public List<eo> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<ro> f;
    public ArrayList<ro> g;
    public FrsViewData h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sk6 sk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk6Var, Integer.valueOf(i)};
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
            this.a = sk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<eo<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    eo<?, ?> next = it.next();
                    if (next instanceof pc6) {
                        ((pc6) next).n(this.a.a.getPageContext(), this.a.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.a.d != null) {
                    this.a.d.addAll(arrayList);
                }
                if (this.a.b != null) {
                    this.a.b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sk6 sk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sk6Var, Integer.valueOf(i)};
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
            this.a = sk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                sk6 sk6Var = this.a;
                sk6Var.i(sk6Var.b);
                sk6 sk6Var2 = this.a;
                sk6Var2.w(sk6Var2.f, this.a.h);
            }
        }
    }

    public sk6(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment, bdTypeRecyclerView};
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
        this.i = new a(this, 2003008);
        this.j = new b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
        this.e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (eo eoVar : this.d) {
                if (eoVar instanceof sx5) {
                    ((sx5) eoVar).r(3);
                }
            }
        }
    }

    public void B(bp bpVar) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bpVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar != null && (eoVar instanceof pc6)) {
                ((pc6) eoVar).V(bpVar);
            }
        }
    }

    public final void C() {
        ho6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.h == null) {
            return;
        }
        for (eo eoVar : this.d) {
            if ((eoVar instanceof jo6) && (i = ((jo6) eoVar).i()) != null) {
                if (this.h.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.h.getForum() != null) {
                    i.c = this.h.getForum().getId();
                    i.d = this.h.getForum().getName();
                }
                if (this.a != null) {
                    i.b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.b) == null || bdTypeRecyclerView.getData() == null || this.b.getData().size() == 0) {
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

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.c = new ArrayList();
                ArrayList<BdUniqueId> g = yi8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        pc6<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = jc6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.d.add(b2);
                            this.c.add(b2);
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

    public HashMap<Integer, ThreadData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<ro> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ro roVar = arrayList.get(i);
            if ((roVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(roVar)) {
                this.e.put(Integer.valueOf(i), (ThreadData) roVar);
            }
        }
    }

    public List<ro> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public List<ro> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.a = frsGoodFragment;
            this.i.setPriority(1);
            this.i.setSelfListener(true);
            this.a.registerListener(this.i);
            gh6 gh6Var = new gh6(frsGoodFragment.i(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            sg6 sg6Var = new sg6(frsGoodFragment.i(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            dh6 dh6Var = new dh6(frsGoodFragment.i(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            ah6 ah6Var = new ah6(frsGoodFragment.i(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            rg6 rg6Var = new rg6(frsGoodFragment.i(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            ug6 ug6Var = new ug6(frsGoodFragment.i(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            ih6 ih6Var = new ih6(frsGoodFragment.i(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            eh6 eh6Var = new eh6(frsGoodFragment.i(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            ch6 ch6Var = new ch6(frsGoodFragment.i(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            zg6 zg6Var = new zg6(frsGoodFragment.i(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            hh6 hh6Var = new hh6(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            xg6 xg6Var = new xg6(frsGoodFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            bh6 bh6Var = new bh6(frsGoodFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            hh6 hh6Var2 = new hh6(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            wc6 wc6Var = new wc6(frsGoodFragment.getPageContext(), xc6.b);
            eo<? extends br4, ? extends TypeAdapter.ViewHolder> a2 = jc6.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            eo<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = jc6.e().d(frsGoodFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            eo<?, ?> d2 = ja8.l().d(this.a, AdvertAppInfo.t);
            eo<?, ?> d3 = ja8.l().d(this.a, AdvertAppInfo.w);
            fh6 fh6Var = new fh6(frsGoodFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            jg6 jg6Var = new jg6(frsGoodFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            og6 og6Var = new og6(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            pg6 pg6Var = new pg6(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            mg6 mg6Var = new mg6(frsGoodFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
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
            this.d.add(xg6Var);
            this.d.add(bh6Var);
            this.d.add(wc6Var);
            this.d.add(hh6Var);
            this.d.add(hh6Var2);
            this.d.add(fh6Var);
            this.d.add(jg6Var);
            this.d.add(og6Var);
            this.d.add(pg6Var);
            this.d.add(mg6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(d2);
            this.d.add(d3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.d.add(fr6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.E));
            this.d.add(fr6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.D));
            hi5 hi5Var = new hi5(this.a, 1);
            hi5Var.t(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, hi5Var));
            bdTypeRecyclerView.a(this.d);
            v("page_frs_good");
            for (eo eoVar : this.d) {
                if (eoVar instanceof tx5) {
                    ((tx5) eoVar).k(true);
                }
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (eo eoVar : this.d) {
                if (eoVar != null && eoVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (eo eoVar : this.d) {
                if (eoVar instanceof pc6) {
                    ((pc6) eoVar).c0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.setData(this.g);
            p();
        }
    }

    public final void u(ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<ro> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == ThreadData.TYPE_TOP) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.d) == null) {
            return;
        }
        for (eo eoVar : list) {
            if (eoVar instanceof ij5) {
                ((ij5) eoVar).g(str);
            }
        }
    }

    public void w(ArrayList<ro> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof xc6)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            yi8.f(arrayList, 1);
            k(arrayList);
            ArrayList<ro> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.b.setData(switchThreadDataToThreadCardInfo);
            this.g = switchThreadDataToThreadCardInfo;
            this.f = arrayList;
            this.h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).f0(frsViewData);
            }
        }
    }
}
