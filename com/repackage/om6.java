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
public class om6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public BdTypeRecyclerView b;
    public List<bn> c;
    public List<bn> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<on> f;
    public ArrayList<on> g;
    public FrsViewData h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(om6 om6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om6Var, Integer.valueOf(i)};
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
            this.a = om6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<bn<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    bn<?, ?> next = it.next();
                    if (next instanceof ue6) {
                        ((ue6) next).m(this.a.a.getPageContext(), this.a.a.getUniqueId());
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
        public final /* synthetic */ om6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(om6 om6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om6Var, Integer.valueOf(i)};
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
            this.a = om6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                om6 om6Var = this.a;
                om6Var.i(om6Var.b);
                om6 om6Var2 = this.a;
                om6Var2.w(om6Var2.f, this.a.h);
            }
        }
    }

    public om6(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            for (bn bnVar : this.d) {
                if (bnVar instanceof zz5) {
                    ((zz5) bnVar).p(3);
                }
            }
        }
    }

    public void B(yn ynVar) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ynVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.d) {
            if (bnVar != null && (bnVar instanceof ue6)) {
                ((ue6) bnVar).setOnAdapterItemClickListener(ynVar);
            }
        }
    }

    public final void C() {
        xp6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.h == null) {
            return;
        }
        for (bn bnVar : this.d) {
            if ((bnVar instanceof zp6) && (i = ((zp6) bnVar).i()) != null) {
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
        for (on onVar : this.b.getData()) {
            if (onVar instanceof ir4) {
                ir4 ir4Var = (ir4) onVar;
                if (ir4Var.t.getIs_top() != 0) {
                    ir4Var.t.parser_title();
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
                ArrayList<BdUniqueId> g = ak8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        ue6<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = oe6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public final void k(ArrayList<on> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            on onVar = arrayList.get(i);
            if ((onVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(onVar)) {
                this.e.put(Integer.valueOf(i), (ThreadData) onVar);
            }
        }
    }

    public List<on> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public List<on> m() {
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
            nj6 nj6Var = new nj6(frsGoodFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            zi6 zi6Var = new zi6(frsGoodFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            kj6 kj6Var = new kj6(frsGoodFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            hj6 hj6Var = new hj6(frsGoodFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            yi6 yi6Var = new yi6(frsGoodFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            bj6 bj6Var = new bj6(frsGoodFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            pj6 pj6Var = new pj6(frsGoodFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            lj6 lj6Var = new lj6(frsGoodFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            jj6 jj6Var = new jj6(frsGoodFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            gj6 gj6Var = new gj6(frsGoodFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            oj6 oj6Var = new oj6(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            ej6 ej6Var = new ej6(frsGoodFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ij6 ij6Var = new ij6(frsGoodFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            oj6 oj6Var2 = new oj6(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            bf6 bf6Var = new bf6(frsGoodFragment.getPageContext(), cf6.b);
            bn<? extends ir4, ? extends TypeAdapter.ViewHolder> a2 = oe6.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            bn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = oe6.e().d(frsGoodFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            bn<?, ?> d2 = yb8.l().d(this.a, AdvertAppInfo.w);
            bn<?, ?> d3 = yb8.l().d(this.a, AdvertAppInfo.z);
            mj6 mj6Var = new mj6(frsGoodFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            pi6 pi6Var = new pi6(frsGoodFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ui6 ui6Var = new ui6(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            vi6 vi6Var = new vi6(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            si6 si6Var = new si6(frsGoodFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            si6Var.v(bdTypeRecyclerView);
            this.d.add(nj6Var);
            this.d.add(zi6Var);
            this.d.add(kj6Var);
            this.d.add(hj6Var);
            this.d.add(yi6Var);
            this.d.add(bj6Var);
            this.d.add(lj6Var);
            this.d.add(pj6Var);
            this.d.add(jj6Var);
            this.d.add(gj6Var);
            this.d.add(oj6Var);
            this.d.add(ej6Var);
            this.d.add(ej6Var);
            this.d.add(ij6Var);
            this.d.add(bf6Var);
            this.d.add(oj6Var);
            this.d.add(oj6Var2);
            this.d.add(mj6Var);
            this.d.add(pi6Var);
            this.d.add(ui6Var);
            this.d.add(vi6Var);
            this.d.add(si6Var);
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
            this.d.add(ss6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, null));
            this.d.add(ss6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, null));
            ok5 ok5Var = new ok5(this.a, 1);
            ok5Var.u(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ok5Var));
            bdTypeRecyclerView.a(this.d);
            v("page_frs_good");
            for (bn bnVar : this.d) {
                if (bnVar instanceof a06) {
                    ((a06) bnVar).j(true);
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
            for (bn bnVar : this.d) {
                if (bnVar != null && bnVar.getType() == bdUniqueId) {
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
            for (bn bnVar : this.d) {
                if (bnVar instanceof ue6) {
                    ((ue6) bnVar).v();
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

    public final void u(ArrayList<on> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<on> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == ThreadData.TYPE_TOP) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.d) == null) {
            return;
        }
        for (bn bnVar : list) {
            if (bnVar instanceof pl5) {
                ((pl5) bnVar).g(str);
            }
        }
    }

    public void w(ArrayList<on> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof cf6)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            ak8.f(arrayList, 1);
            k(arrayList);
            ArrayList<on> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.b.setData(switchThreadDataToThreadCardInfo);
            this.g = switchThreadDataToThreadCardInfo;
            this.f = arrayList;
            this.h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.d) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (bn bnVar : this.d) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.d) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).y(frsViewData);
            }
        }
    }
}
