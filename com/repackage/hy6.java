package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter;
import com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zx6 A;
    public by6 B;
    public yx6 C;
    public rx6 D;
    public ux6 E;
    public vx6 F;
    public xx6 G;
    public gx6 H;
    public ey6 I;
    public cu6 J;
    public eo K;
    public eo L;
    public eo M;
    public eo N;
    public eo O;
    public eo P;
    public eo Q;
    public List<eo> R;
    public boolean S;
    public boolean T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List<eo> a;
    public xo b;
    public List<ro> c;
    public TbPageContext<?> d;
    public ex6 e;
    public fy6 f;
    public fx6 g;
    public rx6 h;
    public cy6 i;
    public lx6 j;
    public mx6 k;
    public nx6 l;
    public wx6 m;
    public ox6 n;
    public tx6 o;
    public qx6 p;
    public sx6 q;
    public kx6 r;
    public jx6 s;
    public ix6 t;
    public dy6 u;
    public hx6 v;
    public px6 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public ay6 z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ hy6 b;

        public a(hy6 hy6Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hy6Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hy6Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setData(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hy6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(hy6 hy6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hy6Var, Integer.valueOf(i)};
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
            this.a = hy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.f();
            if (this.a.c != null) {
                hy6 hy6Var = this.a;
                hy6Var.x(hy6Var.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hy6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(hy6 hy6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hy6Var, Integer.valueOf(i)};
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
            this.a = hy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hy6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(hy6 hy6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hy6Var, Integer.valueOf(i)};
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
            this.a = hy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                ee7 ee7Var = new ee7();
                ee7Var.a = String.valueOf(customResponsedMessage.getData());
                ee7Var.b = true;
                this.a.g(ee7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hy6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(hy6 hy6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hy6Var, Integer.valueOf(i)};
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
            this.a = hy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                ee7 ee7Var = new ee7();
                ee7Var.a = String.valueOf(customResponsedMessage.getData());
                ee7Var.b = false;
                this.a.g(ee7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public hy6(Context context, xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, xoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.V = new b(this, 2016470);
        this.W = new c(this, 2001115);
        this.X = new d(this, 2001335);
        this.Y = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = xoVar;
        this.d = (TbPageContext) f9.a(context);
        i(context);
        w(xoVar);
        xoVar.a(this.a);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.T = f();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<eo> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g = yi8.g();
                if (g == null || g.size() <= 0) {
                    return false;
                }
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    hd7 b2 = me7.d().b(this.d, g.get(i), 2);
                    if (this.S) {
                        b2.Z(3);
                    }
                    rx6 rx6Var = this.h;
                    if (rx6Var != null && (bdUniqueId = rx6Var.j) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.R.add(b2);
                }
                this.b.a(this.R);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<ro> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || (list = this.c) == null) {
            return;
        }
        boolean z = false;
        for (ro roVar : list) {
            if ((roVar instanceof ICardInfo) && ((ICardInfo) roVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            k();
        }
    }

    public List<ro> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.e = new ex6(this.d);
            this.f = new fy6(this.d);
            this.g = new fx6(this.d, py6.b);
            this.h = new rx6(this.d, gy5.o0);
            this.i = new cy6(this.d, gy5.z0);
            this.j = new lx6(this.d, gy5.H0);
            this.k = new mx6(this.d, gy5.A0);
            this.l = new nx6(this.d, gy5.I0);
            this.m = new wx6(this.d, gy5.G0);
            this.n = new ox6(this.d, gy5.J0);
            this.o = new tx6(this.d, gy5.K0);
            this.p = new qx6(this.d, gy5.L0);
            this.q = new sx6(this.d, gy5.M0);
            this.r = new kx6(this.d, gy5.B0);
            this.s = new jx6(this.d, gy5.C0);
            this.t = new ix6(this.d, gy5.D0);
            this.u = new dy6(this.d, hy5.U);
            this.w = new px6(this.d, gy5.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, fy5.N0);
            this.I = new ey6(this.d, gy5.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, fy5.O0);
            this.z = new ay6(this.d, gy5.r0);
            this.A = new zx6(this.d, gy5.s0);
            this.B = new by6(this.d, gy5.u0);
            this.C = new yx6(this.d, gy5.t0);
            this.D = new rx6(this.d, gy5.p0);
            this.E = new ux6(this.d, gy5.v0);
            this.F = new vx6(this.d, gy5.w0);
            this.G = new xx6(this.d, t17.j0);
            this.H = new gx6(this.d, by5.N0);
            this.v = new hx6(this.d, gy5.E0);
            this.J = new cu6(this.d, gy5.x0, (byte) 3);
            this.a.add(this.e);
            this.a.add(this.f);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.n);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.r);
            this.a.add(this.s);
            this.a.add(this.t);
            this.a.add(this.u);
            this.a.add(this.w);
            this.a.add(this.D);
            this.a.add(new ReadProgessDelegetAdapter(this.d, dz6.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new gy6(this.d, ry6.e));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.H);
            this.a.add(this.v);
            this.a.add(this.J);
            this.a.add(this.I);
            e();
            j();
            p("page_recommend");
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.s.set(false);
                return;
            }
            this.K = ja8.l().g(this.d, AdvertAppInfo.v, "INDEX");
            this.L = ja8.l().g(this.d, AdvertAppInfo.w, "INDEX");
            this.M = ja8.l().g(this.d, AdvertAppInfo.x, "INDEX");
            this.N = ja8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.O = ja8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.P = ja8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = ja8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(fr6.e().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.E));
                this.a.add(fr6.e().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.D));
            }
            AdvertAppInfo.s.set(true);
        }
    }

    public void k() {
        xo xoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (xoVar = this.b) == null) {
            return;
        }
        xoVar.getListAdapter().notifyDataSetChanged();
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            k();
            this.e.Z(i);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void n() {
        dy6 dy6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (dy6Var = this.u) == null) {
            return;
        }
        dy6Var.onPause();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            dy6 dy6Var = this.u;
            if (dy6Var != null) {
                dy6Var.onResume();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            k();
        }
    }

    public final void p(String str) {
        List<eo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (eo eoVar : list) {
            if (eoVar instanceof ij5) {
                ((ij5) eoVar).g(str);
            }
        }
    }

    public void q(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            for (eo eoVar : this.a) {
                if (eoVar instanceof ts6) {
                    ((ts6) eoVar).Z(aVar);
                }
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            rx6 rx6Var = this.h;
            if (rx6Var != null) {
                rx6Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            nx6 nx6Var = this.l;
            if (nx6Var != null) {
                nx6Var.setFromCDN(z);
            }
            hx6 hx6Var = this.v;
            if (hx6Var != null) {
                hx6Var.setFromCDN(z);
            }
            eo eoVar = this.L;
            if (eoVar == null || !(eoVar instanceof fa8)) {
                return;
            }
            ((fa8) eoVar).j(z);
        }
    }

    public void s(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            rx6 rx6Var = this.h;
            if (rx6Var != null) {
                rx6Var.i0(bVar);
            }
            wx6 wx6Var = this.m;
            if (wx6Var != null) {
                wx6Var.g0(bVar);
            }
            mx6 mx6Var = this.k;
            if (mx6Var != null) {
                mx6Var.f0(bVar);
            }
            px6 px6Var = this.w;
            if (px6Var != null) {
                px6Var.e0(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.e0(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.e0(bVar);
            }
            ay6 ay6Var = this.z;
            if (ay6Var != null) {
                ay6Var.e0(bVar);
            }
            zx6 zx6Var = this.A;
            if (zx6Var != null) {
                zx6Var.j0(bVar);
            }
            yx6 yx6Var = this.C;
            if (yx6Var != null) {
                yx6Var.g0(bVar);
            }
            by6 by6Var = this.B;
            if (by6Var != null) {
                by6Var.h0(bVar);
            }
            rx6 rx6Var2 = this.D;
            if (rx6Var2 != null) {
                rx6Var2.i0(bVar);
            }
            ux6 ux6Var = this.E;
            if (ux6Var != null) {
                ux6Var.h0(bVar);
            }
            vx6 vx6Var = this.F;
            if (vx6Var != null) {
                vx6Var.g0(bVar);
            }
            xx6 xx6Var = this.G;
            if (xx6Var != null) {
                xx6Var.c0(bVar);
            }
            gx6 gx6Var = this.H;
            if (gx6Var != null) {
                gx6Var.g0(bVar);
            }
        }
    }

    public void t(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            this.U = fVar;
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bdUniqueId) == null) {
            fx6 fx6Var = this.g;
            if (fx6Var != null) {
                fx6Var.b0(bdUniqueId);
            }
            rx6 rx6Var = this.h;
            if (rx6Var != null) {
                rx6Var.j = bdUniqueId;
            }
            cy6 cy6Var = this.i;
            if (cy6Var != null) {
                cy6Var.j = bdUniqueId;
            }
            lx6 lx6Var = this.j;
            if (lx6Var != null) {
                lx6Var.i = bdUniqueId;
            }
            mx6 mx6Var = this.k;
            if (mx6Var != null) {
                mx6Var.i = bdUniqueId;
            }
            nx6 nx6Var = this.l;
            if (nx6Var != null) {
                nx6Var.i = bdUniqueId;
            }
            wx6 wx6Var = this.m;
            if (wx6Var != null) {
                wx6Var.i = bdUniqueId;
            }
            ox6 ox6Var = this.n;
            if (ox6Var != null) {
                ox6Var.i = bdUniqueId;
            }
            tx6 tx6Var = this.o;
            if (tx6Var != null) {
                tx6Var.i = bdUniqueId;
            }
            qx6 qx6Var = this.p;
            if (qx6Var != null) {
                qx6Var.i = bdUniqueId;
            }
            sx6 sx6Var = this.q;
            if (sx6Var != null) {
                sx6Var.i = bdUniqueId;
            }
            kx6 kx6Var = this.r;
            if (kx6Var != null) {
                kx6Var.i = bdUniqueId;
            }
            jx6 jx6Var = this.s;
            if (jx6Var != null) {
                jx6Var.i = bdUniqueId;
            }
            ix6 ix6Var = this.t;
            if (ix6Var != null) {
                ix6Var.i = bdUniqueId;
            }
            px6 px6Var = this.w;
            if (px6Var != null) {
                px6Var.j = bdUniqueId;
            }
            dy6 dy6Var = this.u;
            if (dy6Var != null) {
                dy6Var.i = bdUniqueId;
            }
            ex6 ex6Var = this.e;
            if (ex6Var != null) {
                ex6Var.c0(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.i = bdUniqueId;
            }
            ey6 ey6Var = this.I;
            if (ey6Var != null) {
                ey6Var.i = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.i = bdUniqueId;
            }
            ay6 ay6Var = this.z;
            if (ay6Var != null) {
                ay6Var.j = bdUniqueId;
            }
            zx6 zx6Var = this.A;
            if (zx6Var != null) {
                zx6Var.j = bdUniqueId;
            }
            yx6 yx6Var = this.C;
            if (yx6Var != null) {
                yx6Var.j = bdUniqueId;
            }
            by6 by6Var = this.B;
            if (by6Var != null) {
                by6Var.j = bdUniqueId;
            }
            rx6 rx6Var2 = this.D;
            if (rx6Var2 != null) {
                rx6Var2.j = bdUniqueId;
            }
            ux6 ux6Var = this.E;
            if (ux6Var != null) {
                ux6Var.i = bdUniqueId;
            }
            vx6 vx6Var = this.F;
            if (vx6Var != null) {
                vx6Var.i = bdUniqueId;
            }
            xx6 xx6Var = this.G;
            if (xx6Var != null) {
                xx6Var.i = bdUniqueId;
            }
            gx6 gx6Var = this.H;
            if (gx6Var != null) {
                gx6Var.j = bdUniqueId;
            }
            hx6 hx6Var = this.v;
            if (hx6Var != null) {
                hx6Var.i = bdUniqueId;
            }
            cu6 cu6Var = this.J;
            if (cu6Var != null) {
                cu6Var.j = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (eo eoVar : this.R) {
                    if (eoVar instanceof hd7) {
                        ((hd7) eoVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            if (this.T) {
                return;
            }
            this.V.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
        }
    }

    public void v(zy6 zy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, zy6Var) == null) {
            this.h.j0(zy6Var);
            this.i.i0(zy6Var);
            this.j.g0(zy6Var);
            this.l.g0(zy6Var);
            this.m.h0(zy6Var);
            this.q.f0(zy6Var);
            this.r.g0(zy6Var);
            this.s.g0(zy6Var);
            this.t.g0(zy6Var);
            this.u.j0(zy6Var);
            this.v.h0(zy6Var);
        }
    }

    public final void w(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, xoVar) == null) {
            this.i.j0(xoVar);
            this.j.h0(xoVar);
            this.k.g0(xoVar);
            this.l.h0(xoVar);
            this.m.i0(xoVar);
            this.n.b0(xoVar);
            this.o.c0(xoVar);
            this.p.b0(xoVar);
            this.q.g0(xoVar);
            this.r.h0(xoVar);
            this.s.h0(xoVar);
            this.t.h0(xoVar);
            this.v.i0(xoVar);
            this.u.k0(xoVar);
            this.H.h0(xoVar);
            this.A.k0(xoVar);
            this.A.k0(xoVar);
            this.C.h0(xoVar);
            this.J.b0(xoVar);
        }
    }

    public void x(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            yi8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void y(List<ro> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, list, i) == null) {
            yi8.f(list, 2);
            ViewGroup listView = this.b.getListView();
            if (i > 0 && (listView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
                int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
                View childAt = bdRecyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
                int i2 = firstVisiblePosition - i;
                if (layoutManager instanceof LinearLayoutManager) {
                    bdRecyclerView.A();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    bdRecyclerView.B();
                }
            }
            rg.b(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
