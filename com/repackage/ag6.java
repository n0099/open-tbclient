package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class ag6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public wc6 c;
    public List<eo> d;
    public gh6 e;
    public sg6 f;
    public dh6 g;
    public ah6 h;
    public rg6 i;
    public ug6 j;
    public eh6 k;
    public ih6 l;
    public ch6 m;
    public zg6 n;
    public hh6 o;
    public tg6 p;
    public bh6 q;
    public xg6 r;
    public fh6 s;
    public ig6 t;
    public kg6 u;
    public jg6 v;
    public og6 w;
    public pg6 x;
    public hh6 y;
    public mg6 z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ag6 ag6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag6Var, Integer.valueOf(i)};
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
            this.a = ag6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<eo<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    eo<?, ?> next = it.next();
                    if (next instanceof rx5) {
                        rx5 rx5Var = (rx5) next;
                        if ("FrsHottopicDelegateAdapter".equals(rx5Var.from()) && this.a.d != null) {
                            rx5Var.n(this.a.a.getPageContext(), this.a.a.getUniqueId());
                            if (this.a.A) {
                                rx5Var.setFrom("c13010");
                            }
                            this.a.d.add(next);
                        }
                    }
                }
            }
        }
    }

    public ag6(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)};
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
        this.B = new a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.a.registerListener(this.B);
            this.e = new gh6(frsCommonTabFragment.i(), ThreadData.TYPE_USER_NORMAL, frsCommonTabFragment.getUniqueId());
            this.f = new sg6(frsCommonTabFragment.i(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsCommonTabFragment.getUniqueId());
            this.g = new dh6(frsCommonTabFragment.i(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsCommonTabFragment.getUniqueId());
            this.h = new ah6(frsCommonTabFragment.i(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.i = new rg6(frsCommonTabFragment.i(), ThreadData.TYPE_BOTTOM_NORMAL, frsCommonTabFragment.getUniqueId());
            this.j = new ug6(frsCommonTabFragment.i(), ThreadData.TYPE_GODREPLY_NORMAL, frsCommonTabFragment.getUniqueId());
            this.k = new eh6(frsCommonTabFragment.i(), ThreadData.TYPE_SMART_APP, frsCommonTabFragment.getUniqueId());
            this.l = new ih6(frsCommonTabFragment.i(), ThreadData.TYPE_VOTE, frsCommonTabFragment.getUniqueId());
            ch6 ch6Var = new ch6(frsCommonTabFragment.i(), ThreadData.TYPE_SINGLE_LINK, frsCommonTabFragment.getUniqueId());
            this.m = ch6Var;
            ch6Var.n0(frsCommonTabFragment.h);
            zg6 zg6Var = new zg6(frsCommonTabFragment.i(), ThreadData.TYPE_MULTI_LINK, frsCommonTabFragment.getUniqueId());
            this.n = zg6Var;
            zg6Var.n0(frsCommonTabFragment.h);
            this.o = new hh6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.p = new tg6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.q = new bh6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsCommonTabFragment.getUniqueId());
            this.r = new xg6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_LINK, frsCommonTabFragment.getUniqueId());
            this.s = new fh6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.t = new ig6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsCommonTabFragment.getUniqueId());
            this.u = new kg6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.v = new jg6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.w = new og6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.x = new pg6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.y = new hh6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, frsCommonTabFragment.getUniqueId());
            this.c = new wc6(frsCommonTabFragment.getPageContext(), xc6.b);
            if (!z) {
                this.z = new mg6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ITEM, frsCommonTabFragment.getUniqueId());
            }
            this.d.add(this.e);
            this.d.add(this.f);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.i);
            this.d.add(this.j);
            this.d.add(this.k);
            this.d.add(this.l);
            this.d.add(this.m);
            this.d.add(this.n);
            this.d.add(this.o);
            this.d.add(this.p);
            this.d.add(this.q);
            this.d.add(this.r);
            this.d.add(this.s);
            this.d.add(this.t);
            this.d.add(this.u);
            this.d.add(this.v);
            this.d.add(this.w);
            this.d.add(this.x);
            this.d.add(this.y);
            this.d.add(this.c);
            if (!z) {
                this.d.add(this.z);
            }
            e();
            for (eo eoVar : this.d) {
                if (eoVar instanceof pc6) {
                    pc6 pc6Var = (pc6) eoVar;
                    pc6Var.h0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.g == 89) {
                        pc6Var.setFrom("c13010");
                    }
                }
                if (eoVar instanceof sx5) {
                    ((sx5) eoVar).r(frsCommonTabFragment.g);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
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
            if (frsCommonTabFragment.g == 502 || frsCommonTabFragment.j == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.a(this.d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            eo<?, ?> d = ja8.l().d(this.a, AdvertAppInfo.t);
            eo<?, ?> d2 = ja8.l().d(this.a, AdvertAppInfo.w);
            eo<?, ?> d3 = ja8.l().d(this.a, AdvertAppInfo.x);
            eo<?, ?> d4 = ja8.l().d(this.a, AdvertAppInfo.y);
            eo<?, ?> d5 = ja8.l().d(this.a, AdvertAppInfo.z);
            this.d.add(d);
            this.d.add(d2);
            this.d.add(d3);
            this.d.add(d4);
            this.d.add(d5);
            eo<?, ?> d6 = fr6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.E);
            eo<?, ?> d7 = fr6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.D);
            this.d.add(d6);
            this.d.add(d7);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (eo eoVar : this.d) {
                if (eoVar instanceof pc6) {
                    ((pc6) eoVar).c0();
                } else if (eoVar instanceof aa8) {
                    ((aa8) eoVar).onDestroy();
                }
            }
        }
    }

    public final ArrayList<ro> h(ArrayList<ro> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<ro> arrayList2 = new ArrayList<>();
            Iterator<ro> it = arrayList.iterator();
            while (it.hasNext()) {
                ro next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (threadData.getItem() != null) {
                        if (!threadData.isVoteThreadType()) {
                            arrayList2.add(next);
                        } else {
                            threadData.setItem(null);
                            arrayList2.add(next);
                        }
                    } else {
                        arrayList2.add(next);
                    }
                } else {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void i(ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            k();
            this.b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).f0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a == null || ListUtils.isEmpty(this.d)) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof jo6) {
                jo6 jo6Var = (jo6) eoVar;
                if (jo6Var.i() != null) {
                    jo6Var.i().a = this.a.k;
                    jo6Var.i().c = this.a.e;
                    jo6Var.i().d = this.a.f;
                    jo6Var.i().e = this.a.g;
                    ho6 i = jo6Var.i();
                    FrsCommonTabFragment frsCommonTabFragment = this.a;
                    i.h = frsCommonTabFragment.h;
                    if (frsCommonTabFragment.g == 502) {
                        jo6Var.i().g = 10;
                    } else if (frsCommonTabFragment.j == 1) {
                        jo6Var.i().g = 12;
                    }
                }
            }
        }
    }
}
