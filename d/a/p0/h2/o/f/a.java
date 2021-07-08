package d.a.p0.h2.o.f;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.k.e.n;
import d.a.o0.r.q.b2;
import d.a.o0.z0.f0;
import d.a.o0.z0.i0;
import d.a.p0.h2.h.h;
import d.a.p0.h2.h.p;
import d.a.p0.h2.h.q;
import d.a.p0.h2.h.u;
import d.a.p0.h2.k.e.j;
import d.a.p0.h2.k.e.l;
import d.a.p0.h2.k.e.s0;
import d.a.p0.h2.k.e.z;
import d.a.p0.h3.h0.o;
import d.a.p0.w2.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f57757a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f57758b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.h2.h.e f57759c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f57760d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f57761e;

    /* renamed from: f  reason: collision with root package name */
    public f f57762f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.h2.o.f.d f57763g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f57764h;

    /* renamed from: i  reason: collision with root package name */
    public l f57765i;
    public j j;
    public z k;
    public PbFirstFloorItemAdapter l;
    public s0 m;
    public d.a.c.k.e.a n;
    public d.a.c.k.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* renamed from: d.a.p0.h2.o.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1435a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57766e;

        /* renamed from: d.a.p0.h2.o.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1436a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC1435a f57767a;

            /* renamed from: d.a.p0.h2.o.f.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC1437a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1436a f57768e;

                public RunnableC1437a(C1436a c1436a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1436a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57768e = c1436a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f57768e.f57767a.f57766e.f57758b.y().J1(3);
                    }
                }
            }

            public C1436a(View$OnClickListenerC1435a view$OnClickListenerC1435a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC1435a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57767a = view$OnClickListenerC1435a;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!d.a.c.e.p.j.z()) {
                        this.f57767a.f57766e.f57758b.Y0();
                    } else {
                        d.a.c.e.m.e.a().postDelayed(new RunnableC1437a(this), 10L);
                    }
                }
            }
        }

        public View$OnClickListenerC1435a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57766e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57766e.f57758b == null || this.f57766e.f57758b.y() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f57766e.f57758b.getPageContext(), new C1436a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57769e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57769e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f57769e.f(11009)) {
                        this.f57769e.i(8);
                    }
                } else if (view.getId() == R.id.share_num_container) {
                    if (this.f57769e.f(11009)) {
                        this.f57769e.i(3);
                    }
                } else if (this.f57769e.f57758b == null || this.f57769e.f57758b.v() == null || this.f57769e.f57758b.v().d3() == null) {
                } else {
                    this.f57769e.f57758b.v().d3().onClick(view);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends f0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57770a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57770a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return d.a.p0.h2.k.e.f1.b.c(this.f57770a.f57758b.getContext(), this.f57770a.h(), ShareSwitch.isOn() ? 1 : 6, this.f57770a.f57758b.y());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.o0.z0.n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f57771a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f57772b;

        public d(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57772b = aVar;
            this.f57771a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f57772b.f57758b.getContext(), this.f57771a, shareItem, false));
            }
        }
    }

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57757a = new ArrayList();
        this.p = new View$OnClickListenerC1435a(this);
        this.q = new b(this);
        this.f57758b = detailInfoFragment;
        this.f57760d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(o oVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null || this.f57759c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().U3 = new d.a.o0.r.q.e();
        if (this.f57759c.x() != null) {
            oVar.getAdvertAppInfo().U3.f52633b = this.f57759c.x().a();
        }
        oVar.getAdvertAppInfo().U3.f52632a = oVar.E0();
        if (this.f57759c.m() != null && (m = this.f57759c.m()) != null) {
            oVar.getAdvertAppInfo().U3.f52635d = m.getId();
            oVar.getAdvertAppInfo().U3.f52636e = m.getFirst_class();
            oVar.getAdvertAppInfo().U3.f52637f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().U3.f52638g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().U3.f52639h = oVar.getAdvertAppInfo().S3;
        oVar.getAdvertAppInfo().U3.f52640i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f57758b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f57758b.z(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(d.a.p0.h2.h.e eVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            o oVar = null;
            if (eVar == null) {
                return null;
            }
            this.f57761e = new ArrayList();
            Iterator<PostData> it = eVar.E().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if (next instanceof PostData) {
                    postData = next;
                    if (postData.A() == 1) {
                        break;
                    }
                }
            }
            if (postData == null && eVar.j() != null) {
                postData = eVar.j();
            }
            if (postData != null) {
                this.f57761e.add(postData);
            }
            if (d.a.o0.c1.b.e.d()) {
                return this.f57761e;
            }
            u uVar = new u();
            b2 N = eVar.N();
            uVar.f56956e = N;
            if (N != null && k.isEmpty(N.W())) {
                uVar.f56956e.p3(eVar.o());
            }
            this.f57761e.add(uVar);
            p pVar = new p(eVar.N(), eVar.d());
            pVar.f56936f = true;
            this.f57761e.add(pVar);
            if (postData != null && postData.p0 != null && (eVar.m() == null || !TextUtils.equals(eVar.m().getName(), this.f57758b.y().f0()) || !this.f57758b.y().j0())) {
                h hVar = new h(postData.p0);
                hVar.f56909f = this.f57758b.y().T0();
                this.f57761e.add(hVar);
            }
            List<o> X = eVar.X();
            int i2 = 0;
            int i3 = -1;
            if (!d.a.p0.n1.o.k.a.e(X) && (oVar = (o) d.a.p0.n1.o.k.a.d(X, 0)) != null) {
                i3 = oVar.getPosition();
            }
            if (eVar.f() != null) {
                d.a.p0.h2.h.d dVar = new d.a.p0.h2.h.d();
                dVar.e(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                this.f57761e.add(dVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f57761e.add(new q());
                } else {
                    int i4 = 1;
                    for (d.a.o0.r.q.q qVar : eVar.f()) {
                        if (X != null && i4 == i3) {
                            if (oVar != null) {
                                e(oVar);
                                d.a.p0.n1.o.k.a.a(this.f57761e, oVar);
                                i2++;
                                if (oVar.getType() != AdvertAppInfo.g4) {
                                    i4++;
                                }
                            }
                            if (i2 < X.size() && (oVar = (o) d.a.p0.n1.o.k.a.d(X, i2)) != null) {
                                i3 = oVar.getPosition();
                            }
                        }
                        d.a.p0.n1.o.k.a.a(this.f57761e, qVar);
                        i4++;
                        if (i4 == 4 && eVar.B() != null) {
                            d.a.p0.n1.o.k.a.a(this.f57761e, eVar.B());
                            i4++;
                        }
                    }
                }
            }
            return this.f57761e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.p0.h2.h.e eVar = this.f57759c;
            if (eVar == null || eVar.N() == null) {
                return -1;
            }
            return this.f57759c.N().q();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            i0.b(new c(this), new d(this, i2));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i2 == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void j(DetailInfoFragment detailInfoFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, detailInfoFragment) == null) {
            this.n = w.o().a(detailInfoFragment.v().getBaseFragmentActivity(), AdvertAppInfo.g4);
            this.o = w.o().a(detailInfoFragment.v().getBaseFragmentActivity(), AdvertAppInfo.i4);
            this.f57757a.add(this.n);
            this.f57757a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            this.f57762f = new f(detailInfoFragment.v(), PostData.t0);
            this.f57763g = new d.a.p0.h2.o.f.d(detailInfoFragment.getContext(), u.f56955f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.v(), p.j);
            this.f57764h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.t0(this.q);
            this.f57765i = new l(detailInfoFragment.v(), d.a.p0.h2.h.d.f56890g);
            j jVar = new j(detailInfoFragment.v(), d.a.o0.r.q.q.P3);
            this.j = jVar;
            jVar.m0(true);
            this.k = new z(detailInfoFragment.v());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), h.f56907g);
            s0 s0Var = new s0(detailInfoFragment.v(), q.f56940e);
            this.m = s0Var;
            s0Var.j0(this.p);
            this.f57757a.add(this.f57762f);
            this.f57757a.add(this.f57763g);
            this.f57757a.add(this.f57764h);
            this.f57757a.add(this.f57765i);
            this.f57757a.add(this.j);
            this.f57757a.add(this.k);
            this.f57757a.add(this.l);
            this.f57757a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.a(this.f57757a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f57760d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f57760d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (fVar = this.f57762f) == null) {
            return;
        }
        fVar.L();
    }

    public void n(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f57759c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f57760d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f57762f.I0(eVar);
        this.j.l0(eVar);
        this.k.j0(eVar);
        this.f57760d.setData(g(eVar));
    }
}
