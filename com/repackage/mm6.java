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
public class mm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public List<an> c;
    public List<an> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<nn> f;
    public FrsViewData g;
    public CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mm6 mm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm6Var, Integer.valueOf(i)};
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
            this.a = mm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                mm6 mm6Var = this.a;
                mm6Var.g(mm6Var.b);
                mm6 mm6Var2 = this.a;
                mm6Var2.q(mm6Var2.f, this.a.g);
            }
        }
    }

    public mm6(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
                ArrayList<BdUniqueId> g = nh8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        cd6<ICardInfo, ? extends TypeAdapter.ViewHolder> b = wc6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public final void i(ArrayList<nn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            nn nnVar = arrayList.get(i);
            if ((nnVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(nnVar)) {
                this.e.put(Integer.valueOf(i), (ThreadData) nnVar);
            }
        }
    }

    public List<nn> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            uh6 uh6Var = new uh6(frsNewAreaFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            uh6Var.h0(bdTypeRecyclerView);
            gh6 gh6Var = new gh6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            gh6Var.h0(bdTypeRecyclerView);
            rh6 rh6Var = new rh6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            rh6Var.h0(bdTypeRecyclerView);
            oh6 oh6Var = new oh6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            oh6Var.h0(bdTypeRecyclerView);
            fh6 fh6Var = new fh6(frsNewAreaFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            fh6Var.h0(bdTypeRecyclerView);
            ih6 ih6Var = new ih6(frsNewAreaFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            ih6Var.h0(bdTypeRecyclerView);
            wh6 wh6Var = new wh6(frsNewAreaFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            wh6Var.h0(bdTypeRecyclerView);
            sh6 sh6Var = new sh6(frsNewAreaFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            sh6Var.h0(bdTypeRecyclerView);
            qh6 qh6Var = new qh6(frsNewAreaFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            nh6 nh6Var = new nh6(frsNewAreaFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            vh6 vh6Var = new vh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            vh6Var.h0(bdTypeRecyclerView);
            hh6 hh6Var = new hh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            hh6Var.h0(bdTypeRecyclerView);
            lh6 lh6Var = new lh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            lh6Var.h0(bdTypeRecyclerView);
            xg6 xg6Var = new xg6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            xg6Var.h0(bdTypeRecyclerView);
            ch6 ch6Var = new ch6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ch6Var.h0(bdTypeRecyclerView);
            dh6 dh6Var = new dh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            dh6Var.h0(bdTypeRecyclerView);
            ph6 ph6Var = new ph6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            ph6Var.h0(bdTypeRecyclerView);
            vh6 vh6Var2 = new vh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            vh6Var2.h0(bdTypeRecyclerView);
            jd6 jd6Var = new jd6(frsNewAreaFragment.getPageContext(), kd6.b);
            jd6Var.h0(bdTypeRecyclerView);
            an<? extends qq4, ? extends TypeAdapter.ViewHolder> a2 = wc6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            an<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = wc6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            an<?, ?> d2 = s98.l().d(this.a, AdvertAppInfo.t);
            an<?, ?> d3 = s98.l().d(this.a, AdvertAppInfo.w);
            th6 th6Var = new th6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            th6Var.h0(bdTypeRecyclerView);
            ah6 ah6Var = new ah6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            ah6Var.c0(bdTypeRecyclerView);
            this.d.add(uh6Var);
            this.d.add(gh6Var);
            this.d.add(rh6Var);
            this.d.add(oh6Var);
            this.d.add(fh6Var);
            this.d.add(ih6Var);
            this.d.add(sh6Var);
            this.d.add(wh6Var);
            this.d.add(qh6Var);
            this.d.add(nh6Var);
            this.d.add(vh6Var);
            this.d.add(lh6Var);
            this.d.add(xg6Var);
            this.d.add(ch6Var);
            this.d.add(dh6Var);
            this.d.add(ph6Var);
            this.d.add(jd6Var);
            this.d.add(hh6Var);
            this.d.add(vh6Var2);
            this.d.add(th6Var);
            this.d.add(ah6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(d2);
            this.d.add(d3);
            an<?, ?> b = ar6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.E);
            an<?, ?> b2 = ar6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.D);
            this.d.add(b);
            this.d.add(b2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<an<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    an<?, ?> next = it.next();
                    if (next instanceof cd6) {
                        ((cd6) next).n(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<an> list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            bj5 bj5Var = new bj5(this.a, 1);
            bj5Var.t(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bj5Var));
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
            for (an anVar : this.d) {
                if (anVar instanceof cd6) {
                    ((cd6) anVar).c0();
                } else if (anVar instanceof j98) {
                    ((j98) anVar).onDestroy();
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

    public void q(ArrayList<nn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            nh8.f(arrayList, 1);
            i(arrayList);
            this.b.setData(arrayList);
            this.f = arrayList;
            this.g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.d) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (an anVar : this.d) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.d) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).f0(frsViewData);
            }
        }
    }

    public void u(xn xnVar) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, xnVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.d) {
            if (anVar != null && (anVar instanceof cd6)) {
                ((cd6) anVar).V(xnVar);
            }
        }
    }

    public final void v() {
        eo6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.g == null) {
            return;
        }
        for (an anVar : this.d) {
            if ((anVar instanceof go6) && (i = ((go6) anVar).i()) != null) {
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
        for (nn nnVar : this.b.getData()) {
            if (nnVar instanceof qq4) {
                qq4 qq4Var = (qq4) nnVar;
                if (qq4Var.s.getIs_top() != 0) {
                    qq4Var.s.parser_title();
                }
            }
        }
    }
}
