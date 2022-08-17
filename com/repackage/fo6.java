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
public class fo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public List<bn> c;
    public List<bn> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<on> f;
    public FrsViewData g;
    public CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fo6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fo6 fo6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo6Var, Integer.valueOf(i)};
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
            this.a = fo6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                fo6 fo6Var = this.a;
                fo6Var.g(fo6Var.b);
                fo6 fo6Var2 = this.a;
                fo6Var2.q(fo6Var2.f, this.a.g);
            }
        }
    }

    public fo6(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
                ArrayList<BdUniqueId> g = ak8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        ue6<ICardInfo, ? extends TypeAdapter.ViewHolder> b = oe6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public final void i(ArrayList<on> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            on onVar = arrayList.get(i);
            if ((onVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(onVar)) {
                this.e.put(Integer.valueOf(i), (ThreadData) onVar);
            }
        }
    }

    public List<on> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            nj6 nj6Var = new nj6(frsNewAreaFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            nj6Var.A(bdTypeRecyclerView);
            zi6 zi6Var = new zi6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            zi6Var.A(bdTypeRecyclerView);
            kj6 kj6Var = new kj6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            kj6Var.A(bdTypeRecyclerView);
            hj6 hj6Var = new hj6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            hj6Var.A(bdTypeRecyclerView);
            yi6 yi6Var = new yi6(frsNewAreaFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            yi6Var.A(bdTypeRecyclerView);
            bj6 bj6Var = new bj6(frsNewAreaFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            bj6Var.A(bdTypeRecyclerView);
            pj6 pj6Var = new pj6(frsNewAreaFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            pj6Var.A(bdTypeRecyclerView);
            lj6 lj6Var = new lj6(frsNewAreaFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            lj6Var.A(bdTypeRecyclerView);
            jj6 jj6Var = new jj6(frsNewAreaFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            gj6 gj6Var = new gj6(frsNewAreaFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            oj6 oj6Var = new oj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            oj6Var.A(bdTypeRecyclerView);
            aj6 aj6Var = new aj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            aj6Var.A(bdTypeRecyclerView);
            ej6 ej6Var = new ej6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ej6Var.A(bdTypeRecyclerView);
            pi6 pi6Var = new pi6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            pi6Var.A(bdTypeRecyclerView);
            ui6 ui6Var = new ui6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ui6Var.A(bdTypeRecyclerView);
            vi6 vi6Var = new vi6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            vi6Var.A(bdTypeRecyclerView);
            ij6 ij6Var = new ij6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            ij6Var.A(bdTypeRecyclerView);
            oj6 oj6Var2 = new oj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            oj6Var2.A(bdTypeRecyclerView);
            bf6 bf6Var = new bf6(frsNewAreaFragment.getPageContext(), cf6.b);
            bf6Var.A(bdTypeRecyclerView);
            bn<? extends ir4, ? extends TypeAdapter.ViewHolder> a2 = oe6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            bn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = oe6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            bn<?, ?> d2 = yb8.l().d(this.a, AdvertAppInfo.w);
            bn<?, ?> d3 = yb8.l().d(this.a, AdvertAppInfo.z);
            mj6 mj6Var = new mj6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            mj6Var.A(bdTypeRecyclerView);
            si6 si6Var = new si6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
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
            this.d.add(pi6Var);
            this.d.add(ui6Var);
            this.d.add(vi6Var);
            this.d.add(ij6Var);
            this.d.add(bf6Var);
            this.d.add(aj6Var);
            this.d.add(oj6Var2);
            this.d.add(mj6Var);
            this.d.add(si6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(d2);
            this.d.add(d3);
            bn<?, ?> d4 = ss6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            bn<?, ?> d5 = ss6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.d.add(d4);
            this.d.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<bn<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    bn<?, ?> next = it.next();
                    if (next instanceof ue6) {
                        ((ue6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<bn> list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            ok5 ok5Var = new ok5(this.a, 1);
            ok5Var.u(this.d);
            ok5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ok5Var));
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
            for (bn bnVar : this.d) {
                if (bnVar instanceof ue6) {
                    ((ue6) bnVar).v();
                } else if (bnVar instanceof pb8) {
                    ((pb8) bnVar).onDestroy();
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

    public void q(ArrayList<on> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            ak8.f(arrayList, 1);
            i(arrayList);
            this.b.setData(arrayList);
            this.f = arrayList;
            this.g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.d) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (bn bnVar : this.d) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.d) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).y(frsViewData);
            }
        }
    }

    public void u(yn ynVar) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, ynVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.d) {
            if (bnVar != null && (bnVar instanceof ue6)) {
                ((ue6) bnVar).setOnAdapterItemClickListener(ynVar);
            }
        }
    }

    public final void v() {
        xp6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.g == null) {
            return;
        }
        for (bn bnVar : this.d) {
            if ((bnVar instanceof zp6) && (i = ((zp6) bnVar).i()) != null) {
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
        for (on onVar : this.b.getData()) {
            if (onVar instanceof ir4) {
                ir4 ir4Var = (ir4) onVar;
                if (ir4Var.t.getIs_top() != 0) {
                    ir4Var.t.parser_title();
                }
            }
        }
    }
}
