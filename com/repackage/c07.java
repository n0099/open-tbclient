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
/* loaded from: classes5.dex */
public class c07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uz6 A;
    public wz6 B;
    public tz6 C;
    public mz6 D;
    public pz6 E;
    public qz6 F;
    public sz6 G;
    public bz6 H;
    public zz6 I;
    public qv6 J;
    public bn K;
    public bn L;
    public bn M;
    public bn N;
    public bn O;
    public bn P;
    public bn Q;
    public List<bn> R;
    public boolean S;
    public boolean T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List<bn> a;
    public un b;
    public List<on> c;
    public TbPageContext<?> d;
    public zy6 e;
    public a07 f;
    public az6 g;
    public mz6 h;
    public xz6 i;
    public gz6 j;
    public hz6 k;
    public iz6 l;
    public rz6 m;
    public jz6 n;
    public oz6 o;
    public lz6 p;
    public nz6 q;
    public fz6 r;
    public ez6 s;
    public dz6 t;
    public yz6 u;
    public cz6 v;
    public kz6 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public vz6 z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ c07 b;

        public a(c07 c07Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c07Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c07Var;
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

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c07 c07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c07Var, Integer.valueOf(i)};
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
            this.a = c07Var;
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
                c07 c07Var = this.a;
                c07Var.y(c07Var.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(c07 c07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c07Var, Integer.valueOf(i)};
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
            this.a = c07Var;
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

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c07 c07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c07Var, Integer.valueOf(i)};
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
            this.a = c07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                pf7 pf7Var = new pf7();
                pf7Var.a = String.valueOf(customResponsedMessage.getData());
                pf7Var.b = true;
                this.a.g(pf7Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c07 c07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c07Var, Integer.valueOf(i)};
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
            this.a = c07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                pf7 pf7Var = new pf7();
                pf7Var.a = String.valueOf(customResponsedMessage.getData());
                pf7Var.b = false;
                this.a.g(pf7Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a();
    }

    public c07(Context context, un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, unVar};
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
        this.b = unVar;
        this.d = (TbPageContext) h9.a(context);
        j(context);
        x(unVar);
        unVar.a(this.a);
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
            List<bn> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g = ak8.g();
                if (g == null || g.size() <= 0) {
                    return false;
                }
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    se7 b2 = xf7.d().b(this.d, g.get(i), 2);
                    if (this.S) {
                        b2.s(3);
                    }
                    mz6 mz6Var = this.h;
                    if (mz6Var != null && (bdUniqueId = mz6Var.b) != null) {
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
        List<on> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || (list = this.c) == null) {
            return;
        }
        boolean z = false;
        for (on onVar : list) {
            if ((onVar instanceof ICardInfo) && ((ICardInfo) onVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            l();
        }
    }

    public List<on> h() {
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
            this.e = new zy6(this.d);
            this.f = new a07(this.d);
            this.g = new az6(this.d, k07.b);
            this.h = new mz6(this.d, n06.i0);
            this.i = new xz6(this.d, n06.z0);
            this.j = new gz6(this.d, n06.H0);
            this.k = new hz6(this.d, n06.A0);
            this.l = new iz6(this.d, n06.I0);
            this.m = new rz6(this.d, n06.G0);
            this.n = new jz6(this.d, n06.J0);
            this.o = new oz6(this.d, n06.K0);
            this.p = new lz6(this.d, n06.L0);
            this.q = new nz6(this.d, n06.M0);
            this.r = new fz6(this.d, n06.B0);
            this.s = new ez6(this.d, n06.C0);
            this.t = new dz6(this.d, n06.D0);
            this.u = new yz6(this.d, o06.U);
            this.w = new kz6(this.d, n06.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, m06.N0);
            this.I = new zz6(this.d, n06.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, m06.O0);
            this.z = new vz6(this.d, n06.r0);
            this.A = new uz6(this.d, n06.s0);
            this.B = new wz6(this.d, n06.u0);
            this.C = new tz6(this.d, n06.t0);
            this.D = new mz6(this.d, n06.j0);
            this.E = new pz6(this.d, n06.v0);
            this.F = new qz6(this.d, n06.w0);
            this.G = new sz6(this.d, o37.d0);
            this.H = new bz6(this.d, i06.N0);
            this.v = new cz6(this.d, n06.E0);
            this.J = new qv6(this.d, n06.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, y07.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new b07(this.d, m07.e));
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
                AdvertAppInfo.v.set(false);
                return;
            }
            this.K = yb8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.L = yb8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.M = yb8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.N = yb8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.O = yb8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.P = yb8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.Q = yb8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ss6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(ss6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void l() {
        un unVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (unVar = this.b) == null) {
            return;
        }
        unVar.getListAdapter().notifyDataSetChanged();
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void o() {
        yz6 yz6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (yz6Var = this.u) == null) {
            return;
        }
        yz6Var.onPause();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            yz6 yz6Var = this.u;
            if (yz6Var != null) {
                yz6Var.onResume();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            l();
        }
    }

    public final void q(String str) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (bn bnVar : list) {
            if (bnVar instanceof pl5) {
                ((pl5) bnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (bn bnVar : this.a) {
                if (bnVar instanceof gu6) {
                    ((gu6) bnVar).s(aVar);
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            mz6 mz6Var = this.h;
            if (mz6Var != null) {
                mz6Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            iz6 iz6Var = this.l;
            if (iz6Var != null) {
                iz6Var.setFromCDN(z);
            }
            cz6 cz6Var = this.v;
            if (cz6Var != null) {
                cz6Var.setFromCDN(z);
            }
            bn bnVar = this.L;
            if (bnVar == null || !(bnVar instanceof ub8)) {
                return;
            }
            ((ub8) bnVar).setIsFromCDN(z);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            mz6 mz6Var = this.h;
            if (mz6Var != null) {
                mz6Var.B(bVar);
            }
            rz6 rz6Var = this.m;
            if (rz6Var != null) {
                rz6Var.z(bVar);
            }
            hz6 hz6Var = this.k;
            if (hz6Var != null) {
                hz6Var.y(bVar);
            }
            kz6 kz6Var = this.w;
            if (kz6Var != null) {
                kz6Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            vz6 vz6Var = this.z;
            if (vz6Var != null) {
                vz6Var.x(bVar);
            }
            uz6 uz6Var = this.A;
            if (uz6Var != null) {
                uz6Var.C(bVar);
            }
            tz6 tz6Var = this.C;
            if (tz6Var != null) {
                tz6Var.z(bVar);
            }
            wz6 wz6Var = this.B;
            if (wz6Var != null) {
                wz6Var.A(bVar);
            }
            mz6 mz6Var2 = this.D;
            if (mz6Var2 != null) {
                mz6Var2.B(bVar);
            }
            pz6 pz6Var = this.E;
            if (pz6Var != null) {
                pz6Var.A(bVar);
            }
            qz6 qz6Var = this.F;
            if (qz6Var != null) {
                qz6Var.z(bVar);
            }
            sz6 sz6Var = this.G;
            if (sz6Var != null) {
                sz6Var.v(bVar);
            }
            bz6 bz6Var = this.H;
            if (bz6Var != null) {
                bz6Var.z(bVar);
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
            az6 az6Var = this.g;
            if (az6Var != null) {
                az6Var.u(bdUniqueId);
            }
            mz6 mz6Var = this.h;
            if (mz6Var != null) {
                mz6Var.b = bdUniqueId;
            }
            xz6 xz6Var = this.i;
            if (xz6Var != null) {
                xz6Var.b = bdUniqueId;
            }
            gz6 gz6Var = this.j;
            if (gz6Var != null) {
                gz6Var.a = bdUniqueId;
            }
            hz6 hz6Var = this.k;
            if (hz6Var != null) {
                hz6Var.a = bdUniqueId;
            }
            iz6 iz6Var = this.l;
            if (iz6Var != null) {
                iz6Var.a = bdUniqueId;
            }
            rz6 rz6Var = this.m;
            if (rz6Var != null) {
                rz6Var.a = bdUniqueId;
            }
            jz6 jz6Var = this.n;
            if (jz6Var != null) {
                jz6Var.a = bdUniqueId;
            }
            oz6 oz6Var = this.o;
            if (oz6Var != null) {
                oz6Var.a = bdUniqueId;
            }
            lz6 lz6Var = this.p;
            if (lz6Var != null) {
                lz6Var.a = bdUniqueId;
            }
            nz6 nz6Var = this.q;
            if (nz6Var != null) {
                nz6Var.a = bdUniqueId;
            }
            fz6 fz6Var = this.r;
            if (fz6Var != null) {
                fz6Var.a = bdUniqueId;
            }
            ez6 ez6Var = this.s;
            if (ez6Var != null) {
                ez6Var.a = bdUniqueId;
            }
            dz6 dz6Var = this.t;
            if (dz6Var != null) {
                dz6Var.a = bdUniqueId;
            }
            kz6 kz6Var = this.w;
            if (kz6Var != null) {
                kz6Var.b = bdUniqueId;
            }
            yz6 yz6Var = this.u;
            if (yz6Var != null) {
                yz6Var.a = bdUniqueId;
            }
            zy6 zy6Var = this.e;
            if (zy6Var != null) {
                zy6Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            zz6 zz6Var = this.I;
            if (zz6Var != null) {
                zz6Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            vz6 vz6Var = this.z;
            if (vz6Var != null) {
                vz6Var.b = bdUniqueId;
            }
            uz6 uz6Var = this.A;
            if (uz6Var != null) {
                uz6Var.b = bdUniqueId;
            }
            tz6 tz6Var = this.C;
            if (tz6Var != null) {
                tz6Var.b = bdUniqueId;
            }
            wz6 wz6Var = this.B;
            if (wz6Var != null) {
                wz6Var.b = bdUniqueId;
            }
            mz6 mz6Var2 = this.D;
            if (mz6Var2 != null) {
                mz6Var2.b = bdUniqueId;
            }
            pz6 pz6Var = this.E;
            if (pz6Var != null) {
                pz6Var.a = bdUniqueId;
            }
            qz6 qz6Var = this.F;
            if (qz6Var != null) {
                qz6Var.a = bdUniqueId;
            }
            sz6 sz6Var = this.G;
            if (sz6Var != null) {
                sz6Var.a = bdUniqueId;
            }
            bz6 bz6Var = this.H;
            if (bz6Var != null) {
                bz6Var.b = bdUniqueId;
            }
            cz6 cz6Var = this.v;
            if (cz6Var != null) {
                cz6Var.a = bdUniqueId;
            }
            qv6 qv6Var = this.J;
            if (qv6Var != null) {
                qv6Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (bn bnVar : this.R) {
                    if (bnVar instanceof se7) {
                        ((se7) bnVar).setUniqueId(bdUniqueId);
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

    public void w(u07 u07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, u07Var) == null) {
            this.h.C(u07Var);
            this.i.B(u07Var);
            this.j.z(u07Var);
            this.l.z(u07Var);
            this.m.A(u07Var);
            this.q.z(u07Var);
            this.r.z(u07Var);
            this.s.z(u07Var);
            this.t.z(u07Var);
            this.u.C(u07Var);
            this.v.A(u07Var);
        }
    }

    public final void x(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, unVar) == null) {
            this.i.C(unVar);
            this.j.A(unVar);
            this.k.z(unVar);
            this.l.A(unVar);
            this.m.B(unVar);
            this.n.u(unVar);
            this.o.v(unVar);
            this.p.u(unVar);
            this.q.A(unVar);
            this.r.A(unVar);
            this.s.A(unVar);
            this.t.A(unVar);
            this.v.B(unVar);
            this.u.D(unVar);
            this.H.A(unVar);
            this.A.D(unVar);
            this.A.D(unVar);
            this.C.A(unVar);
            this.J.u(unVar);
        }
    }

    public void y(List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            ak8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void z(List<on> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            ak8.f(list, 2);
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
            vg.b(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
