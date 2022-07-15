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
/* loaded from: classes6.dex */
public class og6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public jd6 c;
    public List<an> d;
    public uh6 e;
    public gh6 f;
    public rh6 g;
    public oh6 h;
    public fh6 i;
    public ih6 j;
    public sh6 k;
    public wh6 l;
    public qh6 m;
    public nh6 n;
    public vh6 o;
    public hh6 p;
    public ph6 q;
    public lh6 r;
    public th6 s;
    public wg6 t;
    public yg6 u;
    public xg6 v;
    public ch6 w;
    public dh6 x;
    public vh6 y;
    public ah6 z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(og6 og6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og6Var, Integer.valueOf(i)};
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
            this.a = og6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<an<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    an<?, ?> next = it.next();
                    if (next instanceof gy5) {
                        gy5 gy5Var = (gy5) next;
                        if ("FrsHottopicDelegateAdapter".equals(gy5Var.from()) && this.a.d != null) {
                            gy5Var.n(this.a.a.getPageContext(), this.a.a.getUniqueId());
                            if (this.a.A) {
                                gy5Var.setFrom("c13010");
                            }
                            this.a.d.add(next);
                        }
                    }
                }
            }
        }
    }

    public og6(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
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
            this.e = new uh6(frsCommonTabFragment.o(), ThreadData.TYPE_USER_NORMAL, frsCommonTabFragment.getUniqueId());
            this.f = new gh6(frsCommonTabFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsCommonTabFragment.getUniqueId());
            this.g = new rh6(frsCommonTabFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsCommonTabFragment.getUniqueId());
            this.h = new oh6(frsCommonTabFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.i = new fh6(frsCommonTabFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, frsCommonTabFragment.getUniqueId());
            this.j = new ih6(frsCommonTabFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, frsCommonTabFragment.getUniqueId());
            this.k = new sh6(frsCommonTabFragment.o(), ThreadData.TYPE_SMART_APP, frsCommonTabFragment.getUniqueId());
            this.l = new wh6(frsCommonTabFragment.o(), ThreadData.TYPE_VOTE, frsCommonTabFragment.getUniqueId());
            qh6 qh6Var = new qh6(frsCommonTabFragment.o(), ThreadData.TYPE_SINGLE_LINK, frsCommonTabFragment.getUniqueId());
            this.m = qh6Var;
            qh6Var.n0(frsCommonTabFragment.h);
            nh6 nh6Var = new nh6(frsCommonTabFragment.o(), ThreadData.TYPE_MULTI_LINK, frsCommonTabFragment.getUniqueId());
            this.n = nh6Var;
            nh6Var.n0(frsCommonTabFragment.h);
            this.o = new vh6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.p = new hh6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.q = new ph6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsCommonTabFragment.getUniqueId());
            this.r = new lh6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_LINK, frsCommonTabFragment.getUniqueId());
            this.s = new th6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.t = new wg6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsCommonTabFragment.getUniqueId());
            this.u = new yg6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.v = new xg6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.w = new ch6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.x = new dh6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.y = new vh6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, frsCommonTabFragment.getUniqueId());
            this.c = new jd6(frsCommonTabFragment.getPageContext(), kd6.b);
            if (!z) {
                this.z = new ah6(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ITEM, frsCommonTabFragment.getUniqueId());
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
            for (an anVar : this.d) {
                if (anVar instanceof cd6) {
                    cd6 cd6Var = (cd6) anVar;
                    cd6Var.h0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.g == 89) {
                        cd6Var.setFrom("c13010");
                    }
                }
                if (anVar instanceof hy5) {
                    ((hy5) anVar).q(frsCommonTabFragment.g);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
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
            an<?, ?> d = s98.l().d(this.a, AdvertAppInfo.t);
            an<?, ?> d2 = s98.l().d(this.a, AdvertAppInfo.w);
            an<?, ?> d3 = s98.l().d(this.a, AdvertAppInfo.x);
            an<?, ?> d4 = s98.l().d(this.a, AdvertAppInfo.y);
            an<?, ?> d5 = s98.l().d(this.a, AdvertAppInfo.z);
            this.d.add(d);
            this.d.add(d2);
            this.d.add(d3);
            this.d.add(d4);
            this.d.add(d5);
            an<?, ?> d6 = ar6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.E);
            an<?, ?> d7 = ar6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.D);
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
            for (an anVar : this.d) {
                if (anVar instanceof cd6) {
                    ((cd6) anVar).c0();
                } else if (anVar instanceof j98) {
                    ((j98) anVar).onDestroy();
                }
            }
        }
    }

    public final ArrayList<nn> h(ArrayList<nn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<nn> arrayList2 = new ArrayList<>();
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
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

    public void i(ArrayList<nn> arrayList) {
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
        for (an anVar : this.d) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (an anVar : this.d) {
            if (anVar instanceof cd6) {
                ((cd6) anVar).f0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a == null || ListUtils.isEmpty(this.d)) {
            return;
        }
        for (an anVar : this.d) {
            if (anVar instanceof go6) {
                go6 go6Var = (go6) anVar;
                if (go6Var.i() != null) {
                    go6Var.i().a = this.a.k;
                    go6Var.i().c = this.a.e;
                    go6Var.i().d = this.a.f;
                    go6Var.i().e = this.a.g;
                    eo6 i = go6Var.i();
                    FrsCommonTabFragment frsCommonTabFragment = this.a;
                    i.h = frsCommonTabFragment.h;
                    if (frsCommonTabFragment.g == 502) {
                        go6Var.i().g = 10;
                    } else if (frsCommonTabFragment.j == 1) {
                        go6Var.i().g = 12;
                    }
                }
            }
        }
    }
}
