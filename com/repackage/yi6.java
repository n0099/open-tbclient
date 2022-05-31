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
public class yi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public BdTypeRecyclerView b;
    public List<wm> c;
    public List<wm> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<jn> f;
    public ArrayList<jn> g;
    public FrsViewData h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yi6 yi6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi6Var, Integer.valueOf(i)};
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
            this.a = yi6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<wm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    wm<?, ?> next = it.next();
                    if (next instanceof fb6) {
                        ((fb6) next).n(this.a.a.getPageContext(), this.a.a.getUniqueId());
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
        public final /* synthetic */ yi6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yi6 yi6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yi6Var, Integer.valueOf(i)};
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
            this.a = yi6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                yi6 yi6Var = this.a;
                yi6Var.i(yi6Var.b);
                yi6 yi6Var2 = this.a;
                yi6Var2.w(yi6Var2.f, this.a.h);
            }
        }
    }

    public yi6(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            for (wm wmVar : this.d) {
                if (wmVar instanceof lw5) {
                    ((lw5) wmVar).r(3);
                }
            }
        }
    }

    public void B(tn tnVar) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tnVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.d) {
            if (wmVar != null && (wmVar instanceof fb6)) {
                ((fb6) wmVar).V(tnVar);
            }
        }
    }

    public final void C() {
        nm6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.h == null) {
            return;
        }
        for (wm wmVar : this.d) {
            if ((wmVar instanceof pm6) && (i = ((pm6) wmVar).i()) != null) {
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
        for (jn jnVar : this.b.getData()) {
            if (jnVar instanceof rp4) {
                rp4 rp4Var = (rp4) jnVar;
                if (rp4Var.s.getIs_top() != 0) {
                    rp4Var.s.parser_title();
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
                ArrayList<BdUniqueId> g = zf8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        fb6<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = za6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public final void k(ArrayList<jn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            jn jnVar = arrayList.get(i);
            if ((jnVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(jnVar)) {
                this.e.put(Integer.valueOf(i), (ThreadData) jnVar);
            }
        }
    }

    public List<jn> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public List<jn> m() {
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
            xf6 xf6Var = new xf6(frsGoodFragment.i(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            jf6 jf6Var = new jf6(frsGoodFragment.i(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            uf6 uf6Var = new uf6(frsGoodFragment.i(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            rf6 rf6Var = new rf6(frsGoodFragment.i(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            if6 if6Var = new if6(frsGoodFragment.i(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            lf6 lf6Var = new lf6(frsGoodFragment.i(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            zf6 zf6Var = new zf6(frsGoodFragment.i(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            vf6 vf6Var = new vf6(frsGoodFragment.i(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            tf6 tf6Var = new tf6(frsGoodFragment.i(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            qf6 qf6Var = new qf6(frsGoodFragment.i(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            yf6 yf6Var = new yf6(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            of6 of6Var = new of6(frsGoodFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            sf6 sf6Var = new sf6(frsGoodFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            yf6 yf6Var2 = new yf6(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            mb6 mb6Var = new mb6(frsGoodFragment.getPageContext(), nb6.b);
            wm<? extends rp4, ? extends TypeAdapter.ViewHolder> a2 = za6.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            wm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = za6.e().d(frsGoodFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            wm<?, ?> d2 = q78.l().d(this.a, AdvertAppInfo.t);
            wm<?, ?> d3 = q78.l().d(this.a, AdvertAppInfo.w);
            wf6 wf6Var = new wf6(frsGoodFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            af6 af6Var = new af6(frsGoodFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ff6 ff6Var = new ff6(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            gf6 gf6Var = new gf6(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            df6 df6Var = new df6(frsGoodFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            df6Var.c0(bdTypeRecyclerView);
            this.d.add(xf6Var);
            this.d.add(jf6Var);
            this.d.add(uf6Var);
            this.d.add(rf6Var);
            this.d.add(if6Var);
            this.d.add(lf6Var);
            this.d.add(vf6Var);
            this.d.add(zf6Var);
            this.d.add(tf6Var);
            this.d.add(qf6Var);
            this.d.add(yf6Var);
            this.d.add(of6Var);
            this.d.add(of6Var);
            this.d.add(sf6Var);
            this.d.add(mb6Var);
            this.d.add(yf6Var);
            this.d.add(yf6Var2);
            this.d.add(wf6Var);
            this.d.add(af6Var);
            this.d.add(ff6Var);
            this.d.add(gf6Var);
            this.d.add(df6Var);
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
            this.d.add(lp6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.E));
            this.d.add(lp6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.D));
            bh5 bh5Var = new bh5(this.a, 1);
            bh5Var.t(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bh5Var));
            bdTypeRecyclerView.a(this.d);
            v("page_frs_good");
            for (wm wmVar : this.d) {
                if (wmVar instanceof mw5) {
                    ((mw5) wmVar).k(true);
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
            for (wm wmVar : this.d) {
                if (wmVar != null && wmVar.getType() == bdUniqueId) {
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
            for (wm wmVar : this.d) {
                if (wmVar instanceof fb6) {
                    ((fb6) wmVar).c0();
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

    public final void u(ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<jn> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == ThreadData.TYPE_TOP) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.d) == null) {
            return;
        }
        for (wm wmVar : list) {
            if (wmVar instanceof ci5) {
                ((ci5) wmVar).g(str);
            }
        }
    }

    public void w(ArrayList<jn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof nb6)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            zf8.f(arrayList, 1);
            k(arrayList);
            ArrayList<jn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.b.setData(switchThreadDataToThreadCardInfo);
            this.g = switchThreadDataToThreadCardInfo;
            this.f = arrayList;
            this.h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.d) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (wm wmVar : this.d) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.d) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).f0(frsViewData);
            }
        }
    }
}
