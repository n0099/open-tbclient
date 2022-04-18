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
public class fn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public List<ho> c;
    public List<ho> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<uo> f;
    public FrsViewData g;
    public CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fn6 fn6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn6Var, Integer.valueOf(i)};
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
            this.a = fn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                fn6 fn6Var = this.a;
                fn6Var.g(fn6Var.b);
                fn6 fn6Var2 = this.a;
                fn6Var2.q(fn6Var2.f, this.a.g);
            }
        }
    }

    public fn6(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
                ArrayList<BdUniqueId> g = bk8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        kd6<ICardInfo, ? extends TypeAdapter.ViewHolder> b = ed6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public final void i(ArrayList<uo> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            uo uoVar = arrayList.get(i);
            if ((uoVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(uoVar)) {
                this.e.put(Integer.valueOf(i), (ThreadData) uoVar);
            }
        }
    }

    public List<uo> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            bi6 bi6Var = new bi6(frsNewAreaFragment.i(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            bi6Var.h0(bdTypeRecyclerView);
            nh6 nh6Var = new nh6(frsNewAreaFragment.i(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            nh6Var.h0(bdTypeRecyclerView);
            yh6 yh6Var = new yh6(frsNewAreaFragment.i(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            yh6Var.h0(bdTypeRecyclerView);
            vh6 vh6Var = new vh6(frsNewAreaFragment.i(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            vh6Var.h0(bdTypeRecyclerView);
            mh6 mh6Var = new mh6(frsNewAreaFragment.i(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            mh6Var.h0(bdTypeRecyclerView);
            ph6 ph6Var = new ph6(frsNewAreaFragment.i(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            ph6Var.h0(bdTypeRecyclerView);
            di6 di6Var = new di6(frsNewAreaFragment.i(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            di6Var.h0(bdTypeRecyclerView);
            zh6 zh6Var = new zh6(frsNewAreaFragment.i(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            zh6Var.h0(bdTypeRecyclerView);
            xh6 xh6Var = new xh6(frsNewAreaFragment.i(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            uh6 uh6Var = new uh6(frsNewAreaFragment.i(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            ci6 ci6Var = new ci6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            ci6Var.h0(bdTypeRecyclerView);
            oh6 oh6Var = new oh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            oh6Var.h0(bdTypeRecyclerView);
            sh6 sh6Var = new sh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            sh6Var.h0(bdTypeRecyclerView);
            eh6 eh6Var = new eh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            eh6Var.h0(bdTypeRecyclerView);
            jh6 jh6Var = new jh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            jh6Var.h0(bdTypeRecyclerView);
            kh6 kh6Var = new kh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            kh6Var.h0(bdTypeRecyclerView);
            wh6 wh6Var = new wh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            wh6Var.h0(bdTypeRecyclerView);
            ci6 ci6Var2 = new ci6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            ci6Var2.h0(bdTypeRecyclerView);
            rd6 rd6Var = new rd6(frsNewAreaFragment.getPageContext(), sd6.b);
            rd6Var.h0(bdTypeRecyclerView);
            ho<? extends qq4, ? extends TypeAdapter.ViewHolder> a2 = ed6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            ho<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = ed6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            ho<?, ?> f = ma8.q().f(this.a, AdvertAppInfo.w);
            ho<?, ?> f2 = ma8.q().f(this.a, AdvertAppInfo.z);
            ai6 ai6Var = new ai6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ai6Var.h0(bdTypeRecyclerView);
            hh6 hh6Var = new hh6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            hh6Var.c0(bdTypeRecyclerView);
            this.d.add(bi6Var);
            this.d.add(nh6Var);
            this.d.add(yh6Var);
            this.d.add(vh6Var);
            this.d.add(mh6Var);
            this.d.add(ph6Var);
            this.d.add(zh6Var);
            this.d.add(di6Var);
            this.d.add(xh6Var);
            this.d.add(uh6Var);
            this.d.add(ci6Var);
            this.d.add(sh6Var);
            this.d.add(eh6Var);
            this.d.add(jh6Var);
            this.d.add(kh6Var);
            this.d.add(wh6Var);
            this.d.add(rd6Var);
            this.d.add(oh6Var);
            this.d.add(ci6Var2);
            this.d.add(ai6Var);
            this.d.add(hh6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(f);
            this.d.add(f2);
            ho<?, ?> b = fs6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.H);
            ho<?, ?> b2 = fs6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.d.add(b);
            this.d.add(b2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<ho<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    ho<?, ?> next = it.next();
                    if (next instanceof kd6) {
                        ((kd6) next).n(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<ho> list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            oh5 oh5Var = new oh5(this.a, 1);
            oh5Var.t(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, oh5Var));
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
            for (ho hoVar : this.d) {
                if (hoVar instanceof kd6) {
                    ((kd6) hoVar).c0();
                } else if (hoVar instanceof ca8) {
                    ((ca8) hoVar).onDestroy();
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

    public void q(ArrayList<uo> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            bk8.f(arrayList, 1);
            i(arrayList);
            this.b.setData(arrayList);
            this.f = arrayList;
            this.g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.d) {
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (ho hoVar : this.d) {
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.d) {
            if (hoVar instanceof kd6) {
                ((kd6) hoVar).f0(frsViewData);
            }
        }
    }

    public void u(dp dpVar) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, dpVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (ho hoVar : this.d) {
            if (hoVar != null && (hoVar instanceof kd6)) {
                ((kd6) hoVar).V(dpVar);
            }
        }
    }

    public final void v() {
        gp6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.g == null) {
            return;
        }
        for (ho hoVar : this.d) {
            if ((hoVar instanceof ip6) && (i = ((ip6) hoVar).i()) != null) {
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
        for (uo uoVar : this.b.getData()) {
            if (uoVar instanceof qq4) {
                qq4 qq4Var = (qq4) uoVar;
                if (qq4Var.s.getIs_top() != 0) {
                    qq4Var.s.parser_title();
                }
            }
        }
    }
}
