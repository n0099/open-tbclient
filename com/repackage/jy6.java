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
public class jy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public by6 A;
    public dy6 B;
    public ay6 C;
    public tx6 D;
    public wx6 E;
    public xx6 F;
    public zx6 G;
    public ix6 H;
    public gy6 I;
    public yt6 J;
    public an K;
    public an L;
    public an M;
    public an N;
    public an O;
    public an P;
    public an Q;
    public List<an> R;
    public boolean S;
    public boolean T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List<an> a;
    public tn b;
    public List<nn> c;
    public TbPageContext<?> d;
    public gx6 e;
    public hy6 f;
    public hx6 g;
    public tx6 h;
    public ey6 i;
    public nx6 j;
    public ox6 k;
    public px6 l;
    public yx6 m;
    public qx6 n;
    public vx6 o;
    public sx6 p;
    public ux6 q;
    public mx6 r;
    public lx6 s;
    public kx6 t;
    public fy6 u;
    public jx6 v;
    public rx6 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public cy6 z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ jy6 b;

        public a(jy6 jy6Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy6Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jy6Var;
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
        public final /* synthetic */ jy6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(jy6 jy6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy6Var, Integer.valueOf(i)};
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
            this.a = jy6Var;
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
                jy6 jy6Var = this.a;
                jy6Var.y(jy6Var.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(jy6 jy6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy6Var, Integer.valueOf(i)};
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
            this.a = jy6Var;
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
        public final /* synthetic */ jy6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(jy6 jy6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy6Var, Integer.valueOf(i)};
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
            this.a = jy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                vd7 vd7Var = new vd7();
                vd7Var.a = String.valueOf(customResponsedMessage.getData());
                vd7Var.b = true;
                this.a.g(vd7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(jy6 jy6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy6Var, Integer.valueOf(i)};
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
            this.a = jy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                vd7 vd7Var = new vd7();
                vd7Var.a = String.valueOf(customResponsedMessage.getData());
                vd7Var.b = false;
                this.a.g(vd7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public jy6(Context context, tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tnVar};
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
        this.b = tnVar;
        this.d = (TbPageContext) h9.a(context);
        j(context);
        x(tnVar);
        tnVar.a(this.a);
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
            List<an> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g = nh8.g();
                if (g == null || g.size() <= 0) {
                    return false;
                }
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    yc7 b2 = de7.d().b(this.d, g.get(i), 2);
                    if (this.S) {
                        b2.Z(3);
                    }
                    tx6 tx6Var = this.h;
                    if (tx6Var != null && (bdUniqueId = tx6Var.j) != null) {
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
        List<nn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || (list = this.c) == null) {
            return;
        }
        boolean z = false;
        for (nn nnVar : list) {
            if ((nnVar instanceof ICardInfo) && ((ICardInfo) nnVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            l();
        }
    }

    public List<nn> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (TbPageContext) invokeV.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new gx6(this.d);
            this.f = new hy6(this.d);
            this.g = new hx6(this.d, ry6.b);
            this.h = new tx6(this.d, vy5.o0);
            this.i = new ey6(this.d, vy5.z0);
            this.j = new nx6(this.d, vy5.H0);
            this.k = new ox6(this.d, vy5.A0);
            this.l = new px6(this.d, vy5.I0);
            this.m = new yx6(this.d, vy5.G0);
            this.n = new qx6(this.d, vy5.J0);
            this.o = new vx6(this.d, vy5.K0);
            this.p = new sx6(this.d, vy5.L0);
            this.q = new ux6(this.d, vy5.M0);
            this.r = new mx6(this.d, vy5.B0);
            this.s = new lx6(this.d, vy5.C0);
            this.t = new kx6(this.d, vy5.D0);
            this.u = new fy6(this.d, wy5.U);
            this.w = new rx6(this.d, vy5.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, uy5.N0);
            this.I = new gy6(this.d, vy5.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, uy5.O0);
            this.z = new cy6(this.d, vy5.r0);
            this.A = new by6(this.d, vy5.s0);
            this.B = new dy6(this.d, vy5.u0);
            this.C = new ay6(this.d, vy5.t0);
            this.D = new tx6(this.d, vy5.p0);
            this.E = new wx6(this.d, vy5.v0);
            this.F = new xx6(this.d, vy5.w0);
            this.G = new zx6(this.d, v17.j0);
            this.H = new ix6(this.d, qy5.N0);
            this.v = new jx6(this.d, vy5.E0);
            this.J = new yt6(this.d, vy5.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, fz6.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new iy6(this.d, ty6.e));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.H);
            this.a.add(this.v);
            this.a.add(this.J);
            this.a.add(this.I);
            e();
            k();
            q("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.s.set(false);
                return;
            }
            this.K = s98.l().g(this.d, AdvertAppInfo.v, "INDEX");
            this.L = s98.l().g(this.d, AdvertAppInfo.w, "INDEX");
            this.M = s98.l().g(this.d, AdvertAppInfo.x, "INDEX");
            this.N = s98.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.O = s98.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.P = s98.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = s98.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ar6.e().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.E));
                this.a.add(ar6.e().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.D));
            }
            AdvertAppInfo.s.set(true);
        }
    }

    public void l() {
        tn tnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tnVar = this.b) == null) {
            return;
        }
        tnVar.getListAdapter().notifyDataSetChanged();
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.Z(i);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void o() {
        fy6 fy6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (fy6Var = this.u) == null) {
            return;
        }
        fy6Var.onPause();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            fy6 fy6Var = this.u;
            if (fy6Var != null) {
                fy6Var.onResume();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            l();
        }
    }

    public final void q(String str) {
        List<an> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (an anVar : list) {
            if (anVar instanceof ck5) {
                ((ck5) anVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof os6) {
                    ((os6) anVar).Z(aVar);
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            tx6 tx6Var = this.h;
            if (tx6Var != null) {
                tx6Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            px6 px6Var = this.l;
            if (px6Var != null) {
                px6Var.setFromCDN(z);
            }
            jx6 jx6Var = this.v;
            if (jx6Var != null) {
                jx6Var.setFromCDN(z);
            }
            an anVar = this.L;
            if (anVar == null || !(anVar instanceof o98)) {
                return;
            }
            ((o98) anVar).j(z);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            tx6 tx6Var = this.h;
            if (tx6Var != null) {
                tx6Var.i0(bVar);
            }
            yx6 yx6Var = this.m;
            if (yx6Var != null) {
                yx6Var.g0(bVar);
            }
            ox6 ox6Var = this.k;
            if (ox6Var != null) {
                ox6Var.f0(bVar);
            }
            rx6 rx6Var = this.w;
            if (rx6Var != null) {
                rx6Var.e0(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.e0(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.e0(bVar);
            }
            cy6 cy6Var = this.z;
            if (cy6Var != null) {
                cy6Var.e0(bVar);
            }
            by6 by6Var = this.A;
            if (by6Var != null) {
                by6Var.j0(bVar);
            }
            ay6 ay6Var = this.C;
            if (ay6Var != null) {
                ay6Var.g0(bVar);
            }
            dy6 dy6Var = this.B;
            if (dy6Var != null) {
                dy6Var.h0(bVar);
            }
            tx6 tx6Var2 = this.D;
            if (tx6Var2 != null) {
                tx6Var2.i0(bVar);
            }
            wx6 wx6Var = this.E;
            if (wx6Var != null) {
                wx6Var.h0(bVar);
            }
            xx6 xx6Var = this.F;
            if (xx6Var != null) {
                xx6Var.g0(bVar);
            }
            zx6 zx6Var = this.G;
            if (zx6Var != null) {
                zx6Var.c0(bVar);
            }
            ix6 ix6Var = this.H;
            if (ix6Var != null) {
                ix6Var.g0(bVar);
            }
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.U = fVar;
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            hx6 hx6Var = this.g;
            if (hx6Var != null) {
                hx6Var.b0(bdUniqueId);
            }
            tx6 tx6Var = this.h;
            if (tx6Var != null) {
                tx6Var.j = bdUniqueId;
            }
            ey6 ey6Var = this.i;
            if (ey6Var != null) {
                ey6Var.j = bdUniqueId;
            }
            nx6 nx6Var = this.j;
            if (nx6Var != null) {
                nx6Var.i = bdUniqueId;
            }
            ox6 ox6Var = this.k;
            if (ox6Var != null) {
                ox6Var.i = bdUniqueId;
            }
            px6 px6Var = this.l;
            if (px6Var != null) {
                px6Var.i = bdUniqueId;
            }
            yx6 yx6Var = this.m;
            if (yx6Var != null) {
                yx6Var.i = bdUniqueId;
            }
            qx6 qx6Var = this.n;
            if (qx6Var != null) {
                qx6Var.i = bdUniqueId;
            }
            vx6 vx6Var = this.o;
            if (vx6Var != null) {
                vx6Var.i = bdUniqueId;
            }
            sx6 sx6Var = this.p;
            if (sx6Var != null) {
                sx6Var.i = bdUniqueId;
            }
            ux6 ux6Var = this.q;
            if (ux6Var != null) {
                ux6Var.i = bdUniqueId;
            }
            mx6 mx6Var = this.r;
            if (mx6Var != null) {
                mx6Var.i = bdUniqueId;
            }
            lx6 lx6Var = this.s;
            if (lx6Var != null) {
                lx6Var.i = bdUniqueId;
            }
            kx6 kx6Var = this.t;
            if (kx6Var != null) {
                kx6Var.i = bdUniqueId;
            }
            rx6 rx6Var = this.w;
            if (rx6Var != null) {
                rx6Var.j = bdUniqueId;
            }
            fy6 fy6Var = this.u;
            if (fy6Var != null) {
                fy6Var.i = bdUniqueId;
            }
            gx6 gx6Var = this.e;
            if (gx6Var != null) {
                gx6Var.c0(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.i = bdUniqueId;
            }
            gy6 gy6Var = this.I;
            if (gy6Var != null) {
                gy6Var.i = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.i = bdUniqueId;
            }
            cy6 cy6Var = this.z;
            if (cy6Var != null) {
                cy6Var.j = bdUniqueId;
            }
            by6 by6Var = this.A;
            if (by6Var != null) {
                by6Var.j = bdUniqueId;
            }
            ay6 ay6Var = this.C;
            if (ay6Var != null) {
                ay6Var.j = bdUniqueId;
            }
            dy6 dy6Var = this.B;
            if (dy6Var != null) {
                dy6Var.j = bdUniqueId;
            }
            tx6 tx6Var2 = this.D;
            if (tx6Var2 != null) {
                tx6Var2.j = bdUniqueId;
            }
            wx6 wx6Var = this.E;
            if (wx6Var != null) {
                wx6Var.i = bdUniqueId;
            }
            xx6 xx6Var = this.F;
            if (xx6Var != null) {
                xx6Var.i = bdUniqueId;
            }
            zx6 zx6Var = this.G;
            if (zx6Var != null) {
                zx6Var.i = bdUniqueId;
            }
            ix6 ix6Var = this.H;
            if (ix6Var != null) {
                ix6Var.j = bdUniqueId;
            }
            jx6 jx6Var = this.v;
            if (jx6Var != null) {
                jx6Var.i = bdUniqueId;
            }
            yt6 yt6Var = this.J;
            if (yt6Var != null) {
                yt6Var.j = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (an anVar : this.R) {
                    if (anVar instanceof yc7) {
                        ((yc7) anVar).setUniqueId(bdUniqueId);
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

    public void w(bz6 bz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bz6Var) == null) {
            this.h.j0(bz6Var);
            this.i.i0(bz6Var);
            this.j.g0(bz6Var);
            this.l.g0(bz6Var);
            this.m.h0(bz6Var);
            this.q.g0(bz6Var);
            this.r.g0(bz6Var);
            this.s.g0(bz6Var);
            this.t.g0(bz6Var);
            this.u.j0(bz6Var);
            this.v.h0(bz6Var);
        }
    }

    public final void x(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, tnVar) == null) {
            this.i.j0(tnVar);
            this.j.h0(tnVar);
            this.k.g0(tnVar);
            this.l.h0(tnVar);
            this.m.i0(tnVar);
            this.n.b0(tnVar);
            this.o.c0(tnVar);
            this.p.b0(tnVar);
            this.q.h0(tnVar);
            this.r.h0(tnVar);
            this.s.h0(tnVar);
            this.t.h0(tnVar);
            this.v.i0(tnVar);
            this.u.k0(tnVar);
            this.H.h0(tnVar);
            this.A.k0(tnVar);
            this.A.k0(tnVar);
            this.C.h0(tnVar);
            this.J.b0(tnVar);
        }
    }

    public void y(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            nh8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void z(List<nn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            nh8.f(list, 2);
            ViewGroup listView = this.b.getListView();
            if (i > 0 && (listView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
                int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
                View childAt = bdRecyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
                int i2 = firstVisiblePosition - i;
                if (layoutManager instanceof LinearLayoutManager) {
                    bdRecyclerView.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    bdRecyclerView.A();
                }
            }
            ug.b(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
