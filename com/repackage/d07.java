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
public class d07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vz6 A;
    public xz6 B;
    public uz6 C;
    public nz6 D;
    public qz6 E;
    public rz6 F;
    public tz6 G;
    public cz6 H;
    public a07 I;
    public rv6 J;
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
    public az6 e;
    public b07 f;
    public bz6 g;
    public nz6 h;
    public yz6 i;
    public hz6 j;
    public iz6 k;
    public jz6 l;
    public sz6 m;
    public kz6 n;
    public pz6 o;
    public mz6 p;
    public oz6 q;
    public gz6 r;
    public fz6 s;
    public ez6 t;
    public zz6 u;
    public dz6 v;
    public lz6 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public wz6 z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ d07 b;

        public a(d07 d07Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d07Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d07Var;
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
        public final /* synthetic */ d07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d07 d07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d07Var, Integer.valueOf(i)};
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
            this.a = d07Var;
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
                d07 d07Var = this.a;
                d07Var.y(d07Var.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d07 d07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d07Var, Integer.valueOf(i)};
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
            this.a = d07Var;
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
        public final /* synthetic */ d07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d07 d07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d07Var, Integer.valueOf(i)};
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
            this.a = d07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                qf7 qf7Var = new qf7();
                qf7Var.a = String.valueOf(customResponsedMessage.getData());
                qf7Var.b = true;
                this.a.g(qf7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d07 d07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d07Var, Integer.valueOf(i)};
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
            this.a = d07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                qf7 qf7Var = new qf7();
                qf7Var.a = String.valueOf(customResponsedMessage.getData());
                qf7Var.b = false;
                this.a.g(qf7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public d07(Context context, un unVar) {
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
                ArrayList<BdUniqueId> g = bk8.g();
                if (g == null || g.size() <= 0) {
                    return false;
                }
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    te7 b2 = yf7.d().b(this.d, g.get(i), 2);
                    if (this.S) {
                        b2.s(3);
                    }
                    nz6 nz6Var = this.h;
                    if (nz6Var != null && (bdUniqueId = nz6Var.b) != null) {
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
            this.e = new az6(this.d);
            this.f = new b07(this.d);
            this.g = new bz6(this.d, l07.b);
            this.h = new nz6(this.d, n06.i0);
            this.i = new yz6(this.d, n06.z0);
            this.j = new hz6(this.d, n06.H0);
            this.k = new iz6(this.d, n06.A0);
            this.l = new jz6(this.d, n06.I0);
            this.m = new sz6(this.d, n06.G0);
            this.n = new kz6(this.d, n06.J0);
            this.o = new pz6(this.d, n06.K0);
            this.p = new mz6(this.d, n06.L0);
            this.q = new oz6(this.d, n06.M0);
            this.r = new gz6(this.d, n06.B0);
            this.s = new fz6(this.d, n06.C0);
            this.t = new ez6(this.d, n06.D0);
            this.u = new zz6(this.d, o06.U);
            this.w = new lz6(this.d, n06.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, m06.N0);
            this.I = new a07(this.d, n06.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, m06.O0);
            this.z = new wz6(this.d, n06.r0);
            this.A = new vz6(this.d, n06.s0);
            this.B = new xz6(this.d, n06.u0);
            this.C = new uz6(this.d, n06.t0);
            this.D = new nz6(this.d, n06.j0);
            this.E = new qz6(this.d, n06.v0);
            this.F = new rz6(this.d, n06.w0);
            this.G = new tz6(this.d, p37.d0);
            this.H = new cz6(this.d, i06.N0);
            this.v = new dz6(this.d, n06.E0);
            this.J = new rv6(this.d, n06.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, z07.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new c07(this.d, n07.e));
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
            this.K = zb8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.L = zb8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.M = zb8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.N = zb8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.O = zb8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.P = zb8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.Q = zb8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ts6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(ts6.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
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
        zz6 zz6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (zz6Var = this.u) == null) {
            return;
        }
        zz6Var.onPause();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            zz6 zz6Var = this.u;
            if (zz6Var != null) {
                zz6Var.onResume();
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
                if (bnVar instanceof hu6) {
                    ((hu6) bnVar).s(aVar);
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            nz6 nz6Var = this.h;
            if (nz6Var != null) {
                nz6Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            jz6 jz6Var = this.l;
            if (jz6Var != null) {
                jz6Var.setFromCDN(z);
            }
            dz6 dz6Var = this.v;
            if (dz6Var != null) {
                dz6Var.setFromCDN(z);
            }
            bn bnVar = this.L;
            if (bnVar == null || !(bnVar instanceof vb8)) {
                return;
            }
            ((vb8) bnVar).setIsFromCDN(z);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            nz6 nz6Var = this.h;
            if (nz6Var != null) {
                nz6Var.B(bVar);
            }
            sz6 sz6Var = this.m;
            if (sz6Var != null) {
                sz6Var.z(bVar);
            }
            iz6 iz6Var = this.k;
            if (iz6Var != null) {
                iz6Var.y(bVar);
            }
            lz6 lz6Var = this.w;
            if (lz6Var != null) {
                lz6Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            wz6 wz6Var = this.z;
            if (wz6Var != null) {
                wz6Var.x(bVar);
            }
            vz6 vz6Var = this.A;
            if (vz6Var != null) {
                vz6Var.C(bVar);
            }
            uz6 uz6Var = this.C;
            if (uz6Var != null) {
                uz6Var.z(bVar);
            }
            xz6 xz6Var = this.B;
            if (xz6Var != null) {
                xz6Var.A(bVar);
            }
            nz6 nz6Var2 = this.D;
            if (nz6Var2 != null) {
                nz6Var2.B(bVar);
            }
            qz6 qz6Var = this.E;
            if (qz6Var != null) {
                qz6Var.A(bVar);
            }
            rz6 rz6Var = this.F;
            if (rz6Var != null) {
                rz6Var.z(bVar);
            }
            tz6 tz6Var = this.G;
            if (tz6Var != null) {
                tz6Var.v(bVar);
            }
            cz6 cz6Var = this.H;
            if (cz6Var != null) {
                cz6Var.z(bVar);
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
            bz6 bz6Var = this.g;
            if (bz6Var != null) {
                bz6Var.u(bdUniqueId);
            }
            nz6 nz6Var = this.h;
            if (nz6Var != null) {
                nz6Var.b = bdUniqueId;
            }
            yz6 yz6Var = this.i;
            if (yz6Var != null) {
                yz6Var.b = bdUniqueId;
            }
            hz6 hz6Var = this.j;
            if (hz6Var != null) {
                hz6Var.a = bdUniqueId;
            }
            iz6 iz6Var = this.k;
            if (iz6Var != null) {
                iz6Var.a = bdUniqueId;
            }
            jz6 jz6Var = this.l;
            if (jz6Var != null) {
                jz6Var.a = bdUniqueId;
            }
            sz6 sz6Var = this.m;
            if (sz6Var != null) {
                sz6Var.a = bdUniqueId;
            }
            kz6 kz6Var = this.n;
            if (kz6Var != null) {
                kz6Var.a = bdUniqueId;
            }
            pz6 pz6Var = this.o;
            if (pz6Var != null) {
                pz6Var.a = bdUniqueId;
            }
            mz6 mz6Var = this.p;
            if (mz6Var != null) {
                mz6Var.a = bdUniqueId;
            }
            oz6 oz6Var = this.q;
            if (oz6Var != null) {
                oz6Var.a = bdUniqueId;
            }
            gz6 gz6Var = this.r;
            if (gz6Var != null) {
                gz6Var.a = bdUniqueId;
            }
            fz6 fz6Var = this.s;
            if (fz6Var != null) {
                fz6Var.a = bdUniqueId;
            }
            ez6 ez6Var = this.t;
            if (ez6Var != null) {
                ez6Var.a = bdUniqueId;
            }
            lz6 lz6Var = this.w;
            if (lz6Var != null) {
                lz6Var.b = bdUniqueId;
            }
            zz6 zz6Var = this.u;
            if (zz6Var != null) {
                zz6Var.a = bdUniqueId;
            }
            az6 az6Var = this.e;
            if (az6Var != null) {
                az6Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            a07 a07Var = this.I;
            if (a07Var != null) {
                a07Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            wz6 wz6Var = this.z;
            if (wz6Var != null) {
                wz6Var.b = bdUniqueId;
            }
            vz6 vz6Var = this.A;
            if (vz6Var != null) {
                vz6Var.b = bdUniqueId;
            }
            uz6 uz6Var = this.C;
            if (uz6Var != null) {
                uz6Var.b = bdUniqueId;
            }
            xz6 xz6Var = this.B;
            if (xz6Var != null) {
                xz6Var.b = bdUniqueId;
            }
            nz6 nz6Var2 = this.D;
            if (nz6Var2 != null) {
                nz6Var2.b = bdUniqueId;
            }
            qz6 qz6Var = this.E;
            if (qz6Var != null) {
                qz6Var.a = bdUniqueId;
            }
            rz6 rz6Var = this.F;
            if (rz6Var != null) {
                rz6Var.a = bdUniqueId;
            }
            tz6 tz6Var = this.G;
            if (tz6Var != null) {
                tz6Var.a = bdUniqueId;
            }
            cz6 cz6Var = this.H;
            if (cz6Var != null) {
                cz6Var.b = bdUniqueId;
            }
            dz6 dz6Var = this.v;
            if (dz6Var != null) {
                dz6Var.a = bdUniqueId;
            }
            rv6 rv6Var = this.J;
            if (rv6Var != null) {
                rv6Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (bn bnVar : this.R) {
                    if (bnVar instanceof te7) {
                        ((te7) bnVar).setUniqueId(bdUniqueId);
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

    public void w(v07 v07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, v07Var) == null) {
            this.h.C(v07Var);
            this.i.B(v07Var);
            this.j.z(v07Var);
            this.l.z(v07Var);
            this.m.A(v07Var);
            this.q.z(v07Var);
            this.r.z(v07Var);
            this.s.z(v07Var);
            this.t.z(v07Var);
            this.u.C(v07Var);
            this.v.A(v07Var);
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
            bk8.f(list, 2);
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
            bk8.f(list, 2);
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
