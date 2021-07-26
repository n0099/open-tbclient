package d.a.q0.h2.o.f;

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
import d.a.d.e.p.k;
import d.a.d.k.e.n;
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import d.a.p0.s.q.b2;
import d.a.q0.h2.h.p;
import d.a.q0.h2.h.q;
import d.a.q0.h2.h.v;
import d.a.q0.h2.k.e.l;
import d.a.q0.h2.k.e.s0;
import d.a.q0.h2.k.e.z;
import d.a.q0.h3.h0.o;
import d.a.q0.w2.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.d.k.e.a> f58338a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f58339b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.h2.h.e f58340c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f58341d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f58342e;

    /* renamed from: f  reason: collision with root package name */
    public h f58343f;

    /* renamed from: g  reason: collision with root package name */
    public f f58344g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f58345h;

    /* renamed from: i  reason: collision with root package name */
    public l f58346i;
    public d.a.q0.h2.k.e.j j;
    public z k;
    public PbFirstFloorItemAdapter l;
    public s0 m;
    public d.a.d.k.e.a n;
    public d.a.d.k.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f58347e;

        /* renamed from: d.a.q0.h2.o.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1443a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f58348a;

            /* renamed from: d.a.q0.h2.o.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC1444a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1443a f58349e;

                public RunnableC1444a(C1443a c1443a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1443a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58349e = c1443a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f58349e.f58348a.f58347e.f58339b.y().S1(3);
                    }
                }
            }

            public C1443a(a aVar) {
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
                this.f58348a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!d.a.d.e.p.j.z()) {
                        this.f58348a.f58347e.f58339b.d1();
                    } else {
                        d.a.d.e.m.e.a().postDelayed(new RunnableC1444a(this), 10L);
                    }
                }
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58347e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58347e.f58339b == null || this.f58347e.f58339b.y() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f58347e.f58339b.getPageContext(), new C1443a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f58350e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58350e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f58350e.f(11009)) {
                        this.f58350e.i(8);
                    }
                } else if (view.getId() == R.id.share_num_container) {
                    if (this.f58350e.f(11009)) {
                        this.f58350e.i(3);
                    }
                } else if (this.f58350e.f58339b == null || this.f58350e.f58339b.v() == null || this.f58350e.f58339b.v().h3() == null) {
                } else {
                    this.f58350e.f58339b.v().h3().onClick(view);
                }
            }
        }
    }

    /* renamed from: d.a.q0.h2.o.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1445c extends f0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f58351a;

        public C1445c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58351a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return d.a.q0.h2.k.e.g1.b.c(this.f58351a.f58339b.getContext(), this.f58351a.h(), ShareSwitch.isOn() ? 1 : 6, this.f58351a.f58339b.y());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.p0.b1.n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f58352a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f58353b;

        public d(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58353b = cVar;
            this.f58352a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f58353b.f58339b.getContext(), this.f58352a, shareItem, false));
            }
        }
    }

    public c(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.f58338a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.f58339b = detailInfoFragment;
        this.f58341d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(o oVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null || this.f58340c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().a4 = new d.a.p0.s.q.e();
        if (this.f58340c.x() != null) {
            oVar.getAdvertAppInfo().a4.f53297b = this.f58340c.x().a();
        }
        oVar.getAdvertAppInfo().a4.f53296a = oVar.E0();
        if (this.f58340c.m() != null && (m = this.f58340c.m()) != null) {
            oVar.getAdvertAppInfo().a4.f53299d = m.getId();
            oVar.getAdvertAppInfo().a4.f53300e = m.getFirst_class();
            oVar.getAdvertAppInfo().a4.f53301f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().a4.f53302g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().a4.f53303h = oVar.getAdvertAppInfo().Y3;
        oVar.getAdvertAppInfo().a4.f53304i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f58339b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f58339b.z(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            o oVar = null;
            if (eVar == null) {
                return null;
            }
            this.f58342e = new ArrayList();
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
                this.f58342e.add(postData);
            }
            if (d.a.p0.e1.b.e.d()) {
                return this.f58342e;
            }
            v vVar = new v();
            b2 N = eVar.N();
            vVar.f57505e = N;
            if (N != null && k.isEmpty(N.X())) {
                vVar.f57505e.s3(eVar.o());
            }
            this.f58342e.add(vVar);
            p pVar = new p(eVar.N(), eVar.d());
            pVar.f57480f = true;
            this.f58342e.add(pVar);
            if (postData != null && postData.p0 != null && (eVar.m() == null || !TextUtils.equals(eVar.m().getName(), this.f58339b.y().n0()) || !this.f58339b.y().r0())) {
                d.a.q0.h2.h.h hVar = new d.a.q0.h2.h.h(postData.p0);
                hVar.f57453f = this.f58339b.y().b1();
                this.f58342e.add(hVar);
            }
            List<o> X = eVar.X();
            int i2 = 0;
            int i3 = -1;
            if (!d.a.q0.n1.o.k.a.e(X) && (oVar = (o) d.a.q0.n1.o.k.a.d(X, 0)) != null) {
                i3 = oVar.getPosition();
            }
            if (eVar.f() != null) {
                d.a.q0.h2.h.d dVar = new d.a.q0.h2.h.d();
                dVar.e(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                this.f58342e.add(dVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f58342e.add(new q());
                } else {
                    int i4 = 1;
                    for (d.a.p0.s.q.q qVar : eVar.f()) {
                        if (X != null && i4 == i3) {
                            if (oVar != null) {
                                e(oVar);
                                d.a.q0.n1.o.k.a.a(this.f58342e, oVar);
                                i2++;
                                if (oVar.getType() != AdvertAppInfo.m4) {
                                    i4++;
                                }
                            }
                            if (i2 < X.size() && (oVar = (o) d.a.q0.n1.o.k.a.d(X, i2)) != null) {
                                i3 = oVar.getPosition();
                            }
                        }
                        d.a.q0.n1.o.k.a.a(this.f58342e, qVar);
                        i4++;
                        if (i4 == 4 && eVar.B() != null) {
                            d.a.q0.n1.o.k.a.a(this.f58342e, eVar.B());
                            i4++;
                        }
                    }
                }
            }
            return this.f58342e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.q0.h2.h.e eVar = this.f58340c;
            if (eVar == null || eVar.N() == null) {
                return -1;
            }
            return this.f58340c.N().q();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            i0.b(new C1445c(this), new d(this, i2));
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
            this.n = w.o().a(detailInfoFragment.v().getBaseFragmentActivity(), AdvertAppInfo.m4);
            this.o = w.o().a(detailInfoFragment.v().getBaseFragmentActivity(), AdvertAppInfo.o4);
            this.f58338a.add(this.n);
            this.f58338a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            this.f58343f = new h(detailInfoFragment.v(), PostData.t0);
            this.f58344g = new f(detailInfoFragment.getContext(), v.f57504f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.v(), p.j);
            this.f58345h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.t0(this.q);
            this.f58346i = new l(detailInfoFragment.v(), d.a.q0.h2.h.d.f57434g);
            d.a.q0.h2.k.e.j jVar = new d.a.q0.h2.k.e.j(detailInfoFragment.v(), d.a.p0.s.q.q.V3);
            this.j = jVar;
            jVar.m0(true);
            this.k = new z(detailInfoFragment.v());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), d.a.q0.h2.h.h.f57451g);
            s0 s0Var = new s0(detailInfoFragment.v(), q.f57484e);
            this.m = s0Var;
            s0Var.j0(this.p);
            this.f58338a.add(this.f58343f);
            this.f58338a.add(this.f58344g);
            this.f58338a.add(this.f58345h);
            this.f58338a.add(this.f58346i);
            this.f58338a.add(this.j);
            this.f58338a.add(this.k);
            this.f58338a.add(this.l);
            this.f58338a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.a(this.f58338a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f58341d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f58341d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f58343f) == null) {
            return;
        }
        hVar.L();
    }

    public void n(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f58340c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f58341d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f58343f.I0(eVar);
        this.j.l0(eVar);
        this.k.j0(eVar);
        this.f58341d.setData(g(eVar));
    }
}
