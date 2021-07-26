package d.a.q0.h2.o.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import d.a.p0.b1.n;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.q;
import d.a.q0.h2.h.o;
import d.a.q0.h2.h.p;
import d.a.q0.h2.h.w;
import d.a.q0.h2.k.e.b0;
import d.a.q0.h2.k.e.j0;
import d.a.q0.h2.k.e.l;
import d.a.q0.h2.k.e.m;
import d.a.q0.h2.k.e.n0;
import d.a.q0.h2.k.e.z;
import d.a.q0.w2.s;
/* loaded from: classes8.dex */
public class d extends d.a.q0.h2.o.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.d.k.e.a A;
    public d.a.d.k.e.a B;
    public View.OnClickListener C;
    public m m;
    public h n;
    public PbFirstFloorCommentAndPraiseAdapter o;
    public e p;
    public PbFirstFloorEnterForumAdapter q;
    public n0 r;
    public PbReplyLoadMoreAdapter s;
    public j0 t;
    public b0 u;
    public l v;
    public d.a.q0.h2.k.e.j w;
    public z x;
    public g y;
    public PbFirstFloorItemAdapter z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f58354e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58354e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f58354e.I(11009)) {
                        this.f58354e.K(8);
                    }
                } else if (view.getId() == R.id.share_num_container && this.f58354e.I(11009)) {
                    this.f58354e.K(3);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends f0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f58355a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58355a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return d.a.q0.h2.k.e.g1.b.c(this.f58355a.f58330b.getContext(), this.f58355a.J(), ShareSwitch.isOn() ? 1 : 6, this.f58355a.f58330b.y());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f58356a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f58357b;

        public c(d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58357b = dVar;
            this.f58356a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f58357b.f58330b.getContext(), this.f58356a, shareItem, false));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        super(detailInfoAndReplyFragment, bdTypeRecyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.C = new a(this);
        L();
    }

    @Override // d.a.q0.h2.o.f.a
    public void A(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.r.t(eVar);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void B(d.a.q0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            super.B(cVar);
            this.m.Y0(cVar);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void C(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.n.I0(eVar);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.n.q(str);
        }
    }

    public final boolean I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f58330b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f58330b.z(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.q0.h2.h.e eVar = this.f58332d;
            if (eVar == null || eVar.N() == null) {
                return -1;
            }
            return this.f58332d.N().q();
        }
        return invokeV.intValue;
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            i0.b(new b(this), new c(this, i2));
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

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.n = new h(this.f58330b.v(), PostData.t0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f58330b.v(), p.j);
            this.o = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.t0(this.C);
            this.p = new e(this.f58330b.getContext(), w.f57506f);
            this.q = new PbFirstFloorEnterForumAdapter(this.f58330b, d.a.q0.h2.h.g.m);
            this.r = new n0(this.f58330b.v(), o.l);
            this.u = new b0(this.f58330b.v(), d.a.q0.h2.h.j.f57456g, this.f58330b.getUniqueId());
            this.t = new j0(this.f58330b.v(), d.a.q0.h2.h.l.I0);
            this.v = new l(this.f58330b.v(), d.a.q0.h2.h.d.f57434g);
            d.a.q0.h2.k.e.j jVar = new d.a.q0.h2.k.e.j(this.f58330b.v(), q.V3);
            this.w = jVar;
            jVar.m0(true);
            this.x = new z(this.f58330b.v());
            m mVar = new m(this.f58330b.v(), PostData.u0);
            this.m = mVar;
            mVar.Z0(this.f58330b.v());
            this.s = new PbReplyLoadMoreAdapter(this.f58330b.v(), PostData.A0);
            this.A = d.a.q0.w2.w.o().a(this.f58330b.v().getBaseFragmentActivity(), AdvertAppInfo.m4);
            this.B = d.a.q0.w2.w.o().a(this.f58330b.v().getBaseFragmentActivity(), AdvertAppInfo.o4);
            g gVar = new g(this.f58330b.getPageContext(), b2.l3, this.f58330b.getUniqueId());
            this.y = gVar;
            gVar.g0(this.f58331c);
            this.z = new PbFirstFloorItemAdapter(this.f58330b.getContext(), d.a.q0.h2.h.h.f57451g);
            this.f58333e.add(this.n);
            this.f58333e.add(this.o);
            this.f58333e.add(this.p);
            this.f58333e.add(this.q);
            this.f58333e.add(this.r);
            this.f58333e.add(this.t);
            this.f58333e.add(this.u);
            this.f58333e.add(this.v);
            this.f58333e.add(this.w);
            this.f58333e.add(this.x);
            this.f58333e.add(this.A);
            this.f58333e.add(this.B);
            this.f58333e.add(this.m);
            this.f58333e.add(this.s);
            this.f58333e.add(this.y);
            this.f58333e.add(this.z);
            this.f58333e.add(new PbPrivateTitleAdapter(this.f58330b.v()));
            this.f58331c.a(this.f58333e);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public n0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.r : (n0) invokeV.objValue;
    }

    @Override // d.a.q0.h2.o.f.a
    public m f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (m) invokeV.objValue;
    }

    @Override // d.a.q0.h2.o.f.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // d.a.q0.h2.o.f.a
    public void l() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.L();
    }

    @Override // d.a.q0.h2.o.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            n0 n0Var = this.r;
            if (n0Var != null) {
                n0Var.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.o;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void o(boolean z) {
        d.a.d.k.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (aVar = this.B) != null && (aVar instanceof s)) {
            ((s) aVar).k(z);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void p(d.a.q0.h2.h.e eVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{eVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.m.t(eVar);
            this.m.setFromCDN(z);
            this.m.q(str);
            this.m.c(z2);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            super.u(onClickListener);
            this.m.m(onClickListener);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void v(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zVar) == null) {
            super.v(zVar);
            this.m.p(zVar);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.m.d(onLongClickListener);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void x(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            super.x(fVar);
            this.r.l0(fVar);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            super.y(onClickListener);
            this.m.e(onClickListener);
            this.r.e(onClickListener);
            this.s.j0(onClickListener);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            this.u.j0(onClickListener);
        }
    }
}
