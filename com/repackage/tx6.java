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
/* loaded from: classes7.dex */
public class tx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lx6 A;
    public nx6 B;
    public kx6 C;
    public dx6 D;
    public gx6 E;
    public hx6 F;
    public jx6 G;
    public sw6 H;
    public qx6 I;
    public kt6 J;
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
    public qw6 e;
    public rx6 f;
    public rw6 g;
    public dx6 h;
    public ox6 i;
    public xw6 j;
    public yw6 k;
    public zw6 l;
    public ix6 m;
    public ax6 n;
    public fx6 o;
    public cx6 p;
    public ex6 q;
    public ww6 r;
    public vw6 s;
    public uw6 t;
    public px6 u;
    public tw6 v;
    public bx6 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public mx6 z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ tx6 b;

        public a(tx6 tx6Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx6Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tx6Var;
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

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tx6 tx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx6Var, Integer.valueOf(i)};
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
            this.a = tx6Var;
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
                tx6 tx6Var = this.a;
                tx6Var.y(tx6Var.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(tx6 tx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx6Var, Integer.valueOf(i)};
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
            this.a = tx6Var;
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

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(tx6 tx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx6Var, Integer.valueOf(i)};
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
            this.a = tx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                dd7 dd7Var = new dd7();
                dd7Var.a = String.valueOf(customResponsedMessage.getData());
                dd7Var.b = true;
                this.a.g(dd7Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(tx6 tx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx6Var, Integer.valueOf(i)};
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
            this.a = tx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                dd7 dd7Var = new dd7();
                dd7Var.a = String.valueOf(customResponsedMessage.getData());
                dd7Var.b = false;
                this.a.g(dd7Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a();
    }

    public tx6(Context context, tn tnVar) {
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
                ArrayList<BdUniqueId> g = sg8.g();
                if (g == null || g.size() <= 0) {
                    return false;
                }
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    gc7 b2 = ld7.d().b(this.d, g.get(i), 2);
                    if (this.S) {
                        b2.Z(3);
                    }
                    dx6 dx6Var = this.h;
                    if (dx6Var != null && (bdUniqueId = dx6Var.j) != null) {
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
            this.e = new qw6(this.d);
            this.f = new rx6(this.d);
            this.g = new rw6(this.d, by6.b);
            this.h = new dx6(this.d, yx5.o0);
            this.i = new ox6(this.d, yx5.z0);
            this.j = new xw6(this.d, yx5.H0);
            this.k = new yw6(this.d, yx5.A0);
            this.l = new zw6(this.d, yx5.I0);
            this.m = new ix6(this.d, yx5.G0);
            this.n = new ax6(this.d, yx5.J0);
            this.o = new fx6(this.d, yx5.K0);
            this.p = new cx6(this.d, yx5.L0);
            this.q = new ex6(this.d, yx5.M0);
            this.r = new ww6(this.d, yx5.B0);
            this.s = new vw6(this.d, yx5.C0);
            this.t = new uw6(this.d, yx5.D0);
            this.u = new px6(this.d, zx5.U);
            this.w = new bx6(this.d, yx5.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, xx5.N0);
            this.I = new qx6(this.d, yx5.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, xx5.O0);
            this.z = new mx6(this.d, yx5.r0);
            this.A = new lx6(this.d, yx5.s0);
            this.B = new nx6(this.d, yx5.u0);
            this.C = new kx6(this.d, yx5.t0);
            this.D = new dx6(this.d, yx5.p0);
            this.E = new gx6(this.d, yx5.v0);
            this.F = new hx6(this.d, yx5.w0);
            this.G = new jx6(this.d, f17.j0);
            this.H = new sw6(this.d, tx5.N0);
            this.v = new tw6(this.d, yx5.E0);
            this.J = new kt6(this.d, yx5.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, py6.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new sx6(this.d, dy6.e));
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
            this.K = x88.l().g(this.d, AdvertAppInfo.v, "INDEX");
            this.L = x88.l().g(this.d, AdvertAppInfo.w, "INDEX");
            this.M = x88.l().g(this.d, AdvertAppInfo.x, "INDEX");
            this.N = x88.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.O = x88.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.P = x88.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = x88.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(oq6.e().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.E));
                this.a.add(oq6.e().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.D));
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
        px6 px6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (px6Var = this.u) == null) {
            return;
        }
        px6Var.onPause();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            px6 px6Var = this.u;
            if (px6Var != null) {
                px6Var.onResume();
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
            if (anVar instanceof zi5) {
                ((zi5) anVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof as6) {
                    ((as6) anVar).Z(aVar);
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            dx6 dx6Var = this.h;
            if (dx6Var != null) {
                dx6Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            zw6 zw6Var = this.l;
            if (zw6Var != null) {
                zw6Var.setFromCDN(z);
            }
            tw6 tw6Var = this.v;
            if (tw6Var != null) {
                tw6Var.setFromCDN(z);
            }
            an anVar = this.L;
            if (anVar == null || !(anVar instanceof t88)) {
                return;
            }
            ((t88) anVar).j(z);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            dx6 dx6Var = this.h;
            if (dx6Var != null) {
                dx6Var.i0(bVar);
            }
            ix6 ix6Var = this.m;
            if (ix6Var != null) {
                ix6Var.g0(bVar);
            }
            yw6 yw6Var = this.k;
            if (yw6Var != null) {
                yw6Var.f0(bVar);
            }
            bx6 bx6Var = this.w;
            if (bx6Var != null) {
                bx6Var.e0(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.e0(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.e0(bVar);
            }
            mx6 mx6Var = this.z;
            if (mx6Var != null) {
                mx6Var.e0(bVar);
            }
            lx6 lx6Var = this.A;
            if (lx6Var != null) {
                lx6Var.j0(bVar);
            }
            kx6 kx6Var = this.C;
            if (kx6Var != null) {
                kx6Var.g0(bVar);
            }
            nx6 nx6Var = this.B;
            if (nx6Var != null) {
                nx6Var.h0(bVar);
            }
            dx6 dx6Var2 = this.D;
            if (dx6Var2 != null) {
                dx6Var2.i0(bVar);
            }
            gx6 gx6Var = this.E;
            if (gx6Var != null) {
                gx6Var.h0(bVar);
            }
            hx6 hx6Var = this.F;
            if (hx6Var != null) {
                hx6Var.g0(bVar);
            }
            jx6 jx6Var = this.G;
            if (jx6Var != null) {
                jx6Var.c0(bVar);
            }
            sw6 sw6Var = this.H;
            if (sw6Var != null) {
                sw6Var.g0(bVar);
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
            rw6 rw6Var = this.g;
            if (rw6Var != null) {
                rw6Var.b0(bdUniqueId);
            }
            dx6 dx6Var = this.h;
            if (dx6Var != null) {
                dx6Var.j = bdUniqueId;
            }
            ox6 ox6Var = this.i;
            if (ox6Var != null) {
                ox6Var.j = bdUniqueId;
            }
            xw6 xw6Var = this.j;
            if (xw6Var != null) {
                xw6Var.i = bdUniqueId;
            }
            yw6 yw6Var = this.k;
            if (yw6Var != null) {
                yw6Var.i = bdUniqueId;
            }
            zw6 zw6Var = this.l;
            if (zw6Var != null) {
                zw6Var.i = bdUniqueId;
            }
            ix6 ix6Var = this.m;
            if (ix6Var != null) {
                ix6Var.i = bdUniqueId;
            }
            ax6 ax6Var = this.n;
            if (ax6Var != null) {
                ax6Var.i = bdUniqueId;
            }
            fx6 fx6Var = this.o;
            if (fx6Var != null) {
                fx6Var.i = bdUniqueId;
            }
            cx6 cx6Var = this.p;
            if (cx6Var != null) {
                cx6Var.i = bdUniqueId;
            }
            ex6 ex6Var = this.q;
            if (ex6Var != null) {
                ex6Var.i = bdUniqueId;
            }
            ww6 ww6Var = this.r;
            if (ww6Var != null) {
                ww6Var.i = bdUniqueId;
            }
            vw6 vw6Var = this.s;
            if (vw6Var != null) {
                vw6Var.i = bdUniqueId;
            }
            uw6 uw6Var = this.t;
            if (uw6Var != null) {
                uw6Var.i = bdUniqueId;
            }
            bx6 bx6Var = this.w;
            if (bx6Var != null) {
                bx6Var.j = bdUniqueId;
            }
            px6 px6Var = this.u;
            if (px6Var != null) {
                px6Var.i = bdUniqueId;
            }
            qw6 qw6Var = this.e;
            if (qw6Var != null) {
                qw6Var.c0(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.i = bdUniqueId;
            }
            qx6 qx6Var = this.I;
            if (qx6Var != null) {
                qx6Var.i = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.i = bdUniqueId;
            }
            mx6 mx6Var = this.z;
            if (mx6Var != null) {
                mx6Var.j = bdUniqueId;
            }
            lx6 lx6Var = this.A;
            if (lx6Var != null) {
                lx6Var.j = bdUniqueId;
            }
            kx6 kx6Var = this.C;
            if (kx6Var != null) {
                kx6Var.j = bdUniqueId;
            }
            nx6 nx6Var = this.B;
            if (nx6Var != null) {
                nx6Var.j = bdUniqueId;
            }
            dx6 dx6Var2 = this.D;
            if (dx6Var2 != null) {
                dx6Var2.j = bdUniqueId;
            }
            gx6 gx6Var = this.E;
            if (gx6Var != null) {
                gx6Var.i = bdUniqueId;
            }
            hx6 hx6Var = this.F;
            if (hx6Var != null) {
                hx6Var.i = bdUniqueId;
            }
            jx6 jx6Var = this.G;
            if (jx6Var != null) {
                jx6Var.i = bdUniqueId;
            }
            sw6 sw6Var = this.H;
            if (sw6Var != null) {
                sw6Var.j = bdUniqueId;
            }
            tw6 tw6Var = this.v;
            if (tw6Var != null) {
                tw6Var.i = bdUniqueId;
            }
            kt6 kt6Var = this.J;
            if (kt6Var != null) {
                kt6Var.j = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (an anVar : this.R) {
                    if (anVar instanceof gc7) {
                        ((gc7) anVar).setUniqueId(bdUniqueId);
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

    public void w(ly6 ly6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ly6Var) == null) {
            this.h.j0(ly6Var);
            this.i.i0(ly6Var);
            this.j.g0(ly6Var);
            this.l.g0(ly6Var);
            this.m.h0(ly6Var);
            this.q.g0(ly6Var);
            this.r.g0(ly6Var);
            this.s.g0(ly6Var);
            this.t.g0(ly6Var);
            this.u.j0(ly6Var);
            this.v.h0(ly6Var);
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
            sg8.f(list, 2);
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
            sg8.f(list, 2);
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
            ug.b(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
