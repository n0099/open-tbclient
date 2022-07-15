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
public class vk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public BdTypeRecyclerView b;
    public List<an> c;
    public List<an> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<nn> f;
    public ArrayList<nn> g;
    public FrsViewData h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vk6 vk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var, Integer.valueOf(i)};
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
            this.a = vk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<an<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    an<?, ?> next = it.next();
                    if (next instanceof cd6) {
                        ((cd6) next).n(this.a.a.getPageContext(), this.a.a.getUniqueId());
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
        public final /* synthetic */ vk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vk6 vk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var, Integer.valueOf(i)};
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
            this.a = vk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                vk6 vk6Var = this.a;
                vk6Var.i(vk6Var.b);
                vk6 vk6Var2 = this.a;
                vk6Var2.w(vk6Var2.f, this.a.h);
            }
        }
    }

    public vk6(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            for (an anVar : this.d) {
                if (anVar instanceof hy5) {
                    ((hy5) anVar).q(3);
                }
            }
        }
    }

    public void B(xn xnVar) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xnVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.d) {
            if (anVar != null && (anVar instanceof cd6)) {
                ((cd6) anVar).V(xnVar);
            }
        }
    }

    public final void C() {
        eo6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.h == null) {
            return;
        }
        for (an anVar : this.d) {
            if ((anVar instanceof go6) && (i = ((go6) anVar).i()) != null) {
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
        for (nn nnVar : this.b.getData()) {
            if (nnVar instanceof qq4) {
                qq4 qq4Var = (qq4) nnVar;
                if (qq4Var.s.getIs_top() != 0) {
                    qq4Var.s.parser_title();
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
                ArrayList<BdUniqueId> g = nh8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        cd6<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = wc6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public final void k(ArrayList<nn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            nn nnVar = arrayList.get(i);
            if ((nnVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(nnVar)) {
                this.e.put(Integer.valueOf(i), (ThreadData) nnVar);
            }
        }
    }

    public List<nn> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public List<nn> m() {
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
            uh6 uh6Var = new uh6(frsGoodFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            gh6 gh6Var = new gh6(frsGoodFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            rh6 rh6Var = new rh6(frsGoodFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            oh6 oh6Var = new oh6(frsGoodFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            fh6 fh6Var = new fh6(frsGoodFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            ih6 ih6Var = new ih6(frsGoodFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            wh6 wh6Var = new wh6(frsGoodFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            sh6 sh6Var = new sh6(frsGoodFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            qh6 qh6Var = new qh6(frsGoodFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            nh6 nh6Var = new nh6(frsGoodFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            vh6 vh6Var = new vh6(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            lh6 lh6Var = new lh6(frsGoodFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ph6 ph6Var = new ph6(frsGoodFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            vh6 vh6Var2 = new vh6(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            jd6 jd6Var = new jd6(frsGoodFragment.getPageContext(), kd6.b);
            an<? extends qq4, ? extends TypeAdapter.ViewHolder> a2 = wc6.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            an<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = wc6.e().d(frsGoodFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            an<?, ?> d2 = s98.l().d(this.a, AdvertAppInfo.t);
            an<?, ?> d3 = s98.l().d(this.a, AdvertAppInfo.w);
            th6 th6Var = new th6(frsGoodFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            xg6 xg6Var = new xg6(frsGoodFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ch6 ch6Var = new ch6(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            dh6 dh6Var = new dh6(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            ah6 ah6Var = new ah6(frsGoodFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
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
            this.d.add(lh6Var);
            this.d.add(ph6Var);
            this.d.add(jd6Var);
            this.d.add(vh6Var);
            this.d.add(vh6Var2);
            this.d.add(th6Var);
            this.d.add(xg6Var);
            this.d.add(ch6Var);
            this.d.add(dh6Var);
            this.d.add(ah6Var);
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
            this.d.add(ar6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.E));
            this.d.add(ar6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.D));
            bj5 bj5Var = new bj5(this.a, 1);
            bj5Var.t(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bj5Var));
            bdTypeRecyclerView.a(this.d);
            v("page_frs_good");
            for (an anVar : this.d) {
                if (anVar instanceof iy5) {
                    ((iy5) anVar).k(true);
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
            for (an anVar : this.d) {
                if (anVar != null && anVar.getType() == bdUniqueId) {
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
            for (an anVar : this.d) {
                if (anVar instanceof cd6) {
                    ((cd6) anVar).c0();
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

    public final void u(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<nn> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == ThreadData.TYPE_TOP) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.d) == null) {
            return;
        }
        for (an anVar : list) {
            if (anVar instanceof ck5) {
                ((ck5) anVar).g(str);
            }
        }
    }

    public void w(ArrayList<nn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof kd6)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            nh8.f(arrayList, 1);
            k(arrayList);
            ArrayList<nn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.b.setData(switchThreadDataToThreadCardInfo);
            this.g = switchThreadDataToThreadCardInfo;
            this.f = arrayList;
            this.h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.d) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (an anVar : this.d) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.d) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).f0(frsViewData);
            }
        }
    }
}
