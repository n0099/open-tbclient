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
public class mk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public List<wm> c;
    public List<wm> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<jn> f;
    public FrsViewData g;
    public CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mk6 mk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mk6Var, Integer.valueOf(i)};
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
            this.a = mk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                mk6 mk6Var = this.a;
                mk6Var.g(mk6Var.b);
                mk6 mk6Var2 = this.a;
                mk6Var2.q(mk6Var2.f, this.a.g);
            }
        }
    }

    public mk6(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
                ArrayList<BdUniqueId> g = zf8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        fb6<ICardInfo, ? extends TypeAdapter.ViewHolder> b = za6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public final void i(ArrayList<jn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            jn jnVar = arrayList.get(i);
            if ((jnVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(jnVar)) {
                this.e.put(Integer.valueOf(i), (ThreadData) jnVar);
            }
        }
    }

    public List<jn> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            xf6 xf6Var = new xf6(frsNewAreaFragment.i(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            xf6Var.h0(bdTypeRecyclerView);
            jf6 jf6Var = new jf6(frsNewAreaFragment.i(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            jf6Var.h0(bdTypeRecyclerView);
            uf6 uf6Var = new uf6(frsNewAreaFragment.i(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            uf6Var.h0(bdTypeRecyclerView);
            rf6 rf6Var = new rf6(frsNewAreaFragment.i(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            rf6Var.h0(bdTypeRecyclerView);
            if6 if6Var = new if6(frsNewAreaFragment.i(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            if6Var.h0(bdTypeRecyclerView);
            lf6 lf6Var = new lf6(frsNewAreaFragment.i(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            lf6Var.h0(bdTypeRecyclerView);
            zf6 zf6Var = new zf6(frsNewAreaFragment.i(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            zf6Var.h0(bdTypeRecyclerView);
            vf6 vf6Var = new vf6(frsNewAreaFragment.i(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            vf6Var.h0(bdTypeRecyclerView);
            tf6 tf6Var = new tf6(frsNewAreaFragment.i(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            qf6 qf6Var = new qf6(frsNewAreaFragment.i(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            yf6 yf6Var = new yf6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            yf6Var.h0(bdTypeRecyclerView);
            kf6 kf6Var = new kf6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            kf6Var.h0(bdTypeRecyclerView);
            of6 of6Var = new of6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            of6Var.h0(bdTypeRecyclerView);
            af6 af6Var = new af6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            af6Var.h0(bdTypeRecyclerView);
            ff6 ff6Var = new ff6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ff6Var.h0(bdTypeRecyclerView);
            gf6 gf6Var = new gf6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            gf6Var.h0(bdTypeRecyclerView);
            sf6 sf6Var = new sf6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            sf6Var.h0(bdTypeRecyclerView);
            yf6 yf6Var2 = new yf6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            yf6Var2.h0(bdTypeRecyclerView);
            mb6 mb6Var = new mb6(frsNewAreaFragment.getPageContext(), nb6.b);
            mb6Var.h0(bdTypeRecyclerView);
            wm<? extends rp4, ? extends TypeAdapter.ViewHolder> a2 = za6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            wm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = za6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            wm<?, ?> d2 = q78.l().d(this.a, AdvertAppInfo.t);
            wm<?, ?> d3 = q78.l().d(this.a, AdvertAppInfo.w);
            wf6 wf6Var = new wf6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            wf6Var.h0(bdTypeRecyclerView);
            df6 df6Var = new df6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
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
            this.d.add(af6Var);
            this.d.add(ff6Var);
            this.d.add(gf6Var);
            this.d.add(sf6Var);
            this.d.add(mb6Var);
            this.d.add(kf6Var);
            this.d.add(yf6Var2);
            this.d.add(wf6Var);
            this.d.add(df6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(d2);
            this.d.add(d3);
            wm<?, ?> b = lp6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.E);
            wm<?, ?> b2 = lp6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.D);
            this.d.add(b);
            this.d.add(b2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<wm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    wm<?, ?> next = it.next();
                    if (next instanceof fb6) {
                        ((fb6) next).n(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<wm> list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            bh5 bh5Var = new bh5(this.a, 1);
            bh5Var.t(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bh5Var));
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
            for (wm wmVar : this.d) {
                if (wmVar instanceof fb6) {
                    ((fb6) wmVar).c0();
                } else if (wmVar instanceof h78) {
                    ((h78) wmVar).onDestroy();
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

    public void q(ArrayList<jn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            zf8.f(arrayList, 1);
            i(arrayList);
            this.b.setData(arrayList);
            this.f = arrayList;
            this.g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.d) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (wm wmVar : this.d) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.d) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).f0(frsViewData);
            }
        }
    }

    public void u(tn tnVar) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, tnVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.d) {
            if (wmVar != null && (wmVar instanceof fb6)) {
                ((fb6) wmVar).V(tnVar);
            }
        }
    }

    public final void v() {
        nm6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.g == null) {
            return;
        }
        for (wm wmVar : this.d) {
            if ((wmVar instanceof pm6) && (i = ((pm6) wmVar).i()) != null) {
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
        for (jn jnVar : this.b.getData()) {
            if (jnVar instanceof rp4) {
                rp4 rp4Var = (rp4) jnVar;
                if (rp4Var.s.getIs_top() != 0) {
                    rp4Var.s.parser_title();
                }
            }
        }
    }
}
