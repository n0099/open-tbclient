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
public class lw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dw6 A;
    public fw6 B;
    public cw6 C;
    public vv6 D;
    public yv6 E;
    public zv6 F;
    public bw6 G;
    public kv6 H;
    public iw6 I;
    public gs6 J;
    public wm K;
    public wm L;
    public wm M;
    public wm N;
    public wm O;
    public wm P;
    public wm Q;
    public List<wm> R;
    public boolean S;
    public boolean T;
    public f U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public List<wm> a;
    public pn b;
    public List<jn> c;
    public TbPageContext<?> d;
    public iv6 e;
    public jw6 f;
    public jv6 g;
    public vv6 h;
    public gw6 i;
    public pv6 j;
    public qv6 k;
    public rv6 l;
    public aw6 m;
    public sv6 n;
    public xv6 o;
    public uv6 p;
    public wv6 q;
    public ov6 r;
    public nv6 s;
    public mv6 t;
    public hw6 u;
    public lv6 v;
    public tv6 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public ew6 z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ lw6 b;

        public a(lw6 lw6Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw6Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lw6Var;
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
        public final /* synthetic */ lw6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(lw6 lw6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw6Var, Integer.valueOf(i)};
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
            this.a = lw6Var;
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
                lw6 lw6Var = this.a;
                lw6Var.x(lw6Var.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(lw6 lw6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw6Var, Integer.valueOf(i)};
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
            this.a = lw6Var;
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
        public final /* synthetic */ lw6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(lw6 lw6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw6Var, Integer.valueOf(i)};
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
            this.a = lw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                sb7 sb7Var = new sb7();
                sb7Var.a = String.valueOf(customResponsedMessage.getData());
                sb7Var.b = true;
                this.a.g(sb7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(lw6 lw6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw6Var, Integer.valueOf(i)};
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
            this.a = lw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                sb7 sb7Var = new sb7();
                sb7Var.a = String.valueOf(customResponsedMessage.getData());
                sb7Var.b = false;
                this.a.g(sb7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public lw6(Context context, pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, pnVar};
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
        this.b = pnVar;
        this.d = (TbPageContext) f9.a(context);
        i(context);
        w(pnVar);
        pnVar.a(this.a);
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
            List<wm> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g = zf8.g();
                if (g == null || g.size() <= 0) {
                    return false;
                }
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    va7 b2 = ac7.d().b(this.d, g.get(i), 2);
                    if (this.S) {
                        b2.Z(3);
                    }
                    vv6 vv6Var = this.h;
                    if (vv6Var != null && (bdUniqueId = vv6Var.j) != null) {
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
        List<jn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || (list = this.c) == null) {
            return;
        }
        boolean z = false;
        for (jn jnVar : list) {
            if ((jnVar instanceof ICardInfo) && ((ICardInfo) jnVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            k();
        }
    }

    public List<jn> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.e = new iv6(this.d);
            this.f = new jw6(this.d);
            this.g = new jv6(this.d, tw6.b);
            this.h = new vv6(this.d, zw5.o0);
            this.i = new gw6(this.d, zw5.z0);
            this.j = new pv6(this.d, zw5.H0);
            this.k = new qv6(this.d, zw5.A0);
            this.l = new rv6(this.d, zw5.I0);
            this.m = new aw6(this.d, zw5.G0);
            this.n = new sv6(this.d, zw5.J0);
            this.o = new xv6(this.d, zw5.K0);
            this.p = new uv6(this.d, zw5.L0);
            this.q = new wv6(this.d, zw5.M0);
            this.r = new ov6(this.d, zw5.B0);
            this.s = new nv6(this.d, zw5.C0);
            this.t = new mv6(this.d, zw5.D0);
            this.u = new hw6(this.d, ax5.U);
            this.w = new tv6(this.d, zw5.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, yw5.N0);
            this.I = new iw6(this.d, zw5.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, yw5.O0);
            this.z = new ew6(this.d, zw5.r0);
            this.A = new dw6(this.d, zw5.s0);
            this.B = new fw6(this.d, zw5.u0);
            this.C = new cw6(this.d, zw5.t0);
            this.D = new vv6(this.d, zw5.p0);
            this.E = new yv6(this.d, zw5.v0);
            this.F = new zv6(this.d, zw5.w0);
            this.G = new bw6(this.d, wz6.j0);
            this.H = new kv6(this.d, uw5.N0);
            this.v = new lv6(this.d, zw5.E0);
            this.J = new gs6(this.d, zw5.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, hx6.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new kw6(this.d, vw6.e));
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
            this.K = q78.l().g(this.d, AdvertAppInfo.v, "INDEX");
            this.L = q78.l().g(this.d, AdvertAppInfo.w, "INDEX");
            this.M = q78.l().g(this.d, AdvertAppInfo.x, "INDEX");
            this.N = q78.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.O = q78.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.P = q78.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = q78.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(lp6.e().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.E));
                this.a.add(lp6.e().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.D));
            }
            AdvertAppInfo.s.set(true);
        }
    }

    public void k() {
        pn pnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pnVar = this.b) == null) {
            return;
        }
        pnVar.getListAdapter().notifyDataSetChanged();
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
        hw6 hw6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (hw6Var = this.u) == null) {
            return;
        }
        hw6Var.onPause();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            hw6 hw6Var = this.u;
            if (hw6Var != null) {
                hw6Var.onResume();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            k();
        }
    }

    public final void p(String str) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (wm wmVar : list) {
            if (wmVar instanceof ci5) {
                ((ci5) wmVar).g(str);
            }
        }
    }

    public void q(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            for (wm wmVar : this.a) {
                if (wmVar instanceof xq6) {
                    ((xq6) wmVar).Z(aVar);
                }
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            vv6 vv6Var = this.h;
            if (vv6Var != null) {
                vv6Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            rv6 rv6Var = this.l;
            if (rv6Var != null) {
                rv6Var.setFromCDN(z);
            }
            lv6 lv6Var = this.v;
            if (lv6Var != null) {
                lv6Var.setFromCDN(z);
            }
            wm wmVar = this.L;
            if (wmVar == null || !(wmVar instanceof m78)) {
                return;
            }
            ((m78) wmVar).j(z);
        }
    }

    public void s(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            vv6 vv6Var = this.h;
            if (vv6Var != null) {
                vv6Var.i0(bVar);
            }
            aw6 aw6Var = this.m;
            if (aw6Var != null) {
                aw6Var.g0(bVar);
            }
            qv6 qv6Var = this.k;
            if (qv6Var != null) {
                qv6Var.f0(bVar);
            }
            tv6 tv6Var = this.w;
            if (tv6Var != null) {
                tv6Var.e0(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.e0(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.e0(bVar);
            }
            ew6 ew6Var = this.z;
            if (ew6Var != null) {
                ew6Var.e0(bVar);
            }
            dw6 dw6Var = this.A;
            if (dw6Var != null) {
                dw6Var.j0(bVar);
            }
            cw6 cw6Var = this.C;
            if (cw6Var != null) {
                cw6Var.g0(bVar);
            }
            fw6 fw6Var = this.B;
            if (fw6Var != null) {
                fw6Var.h0(bVar);
            }
            vv6 vv6Var2 = this.D;
            if (vv6Var2 != null) {
                vv6Var2.i0(bVar);
            }
            yv6 yv6Var = this.E;
            if (yv6Var != null) {
                yv6Var.h0(bVar);
            }
            zv6 zv6Var = this.F;
            if (zv6Var != null) {
                zv6Var.g0(bVar);
            }
            bw6 bw6Var = this.G;
            if (bw6Var != null) {
                bw6Var.c0(bVar);
            }
            kv6 kv6Var = this.H;
            if (kv6Var != null) {
                kv6Var.g0(bVar);
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
            jv6 jv6Var = this.g;
            if (jv6Var != null) {
                jv6Var.b0(bdUniqueId);
            }
            vv6 vv6Var = this.h;
            if (vv6Var != null) {
                vv6Var.j = bdUniqueId;
            }
            gw6 gw6Var = this.i;
            if (gw6Var != null) {
                gw6Var.j = bdUniqueId;
            }
            pv6 pv6Var = this.j;
            if (pv6Var != null) {
                pv6Var.i = bdUniqueId;
            }
            qv6 qv6Var = this.k;
            if (qv6Var != null) {
                qv6Var.i = bdUniqueId;
            }
            rv6 rv6Var = this.l;
            if (rv6Var != null) {
                rv6Var.i = bdUniqueId;
            }
            aw6 aw6Var = this.m;
            if (aw6Var != null) {
                aw6Var.i = bdUniqueId;
            }
            sv6 sv6Var = this.n;
            if (sv6Var != null) {
                sv6Var.i = bdUniqueId;
            }
            xv6 xv6Var = this.o;
            if (xv6Var != null) {
                xv6Var.i = bdUniqueId;
            }
            uv6 uv6Var = this.p;
            if (uv6Var != null) {
                uv6Var.i = bdUniqueId;
            }
            wv6 wv6Var = this.q;
            if (wv6Var != null) {
                wv6Var.i = bdUniqueId;
            }
            ov6 ov6Var = this.r;
            if (ov6Var != null) {
                ov6Var.i = bdUniqueId;
            }
            nv6 nv6Var = this.s;
            if (nv6Var != null) {
                nv6Var.i = bdUniqueId;
            }
            mv6 mv6Var = this.t;
            if (mv6Var != null) {
                mv6Var.i = bdUniqueId;
            }
            tv6 tv6Var = this.w;
            if (tv6Var != null) {
                tv6Var.j = bdUniqueId;
            }
            hw6 hw6Var = this.u;
            if (hw6Var != null) {
                hw6Var.i = bdUniqueId;
            }
            iv6 iv6Var = this.e;
            if (iv6Var != null) {
                iv6Var.c0(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.i = bdUniqueId;
            }
            iw6 iw6Var = this.I;
            if (iw6Var != null) {
                iw6Var.i = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.i = bdUniqueId;
            }
            ew6 ew6Var = this.z;
            if (ew6Var != null) {
                ew6Var.j = bdUniqueId;
            }
            dw6 dw6Var = this.A;
            if (dw6Var != null) {
                dw6Var.j = bdUniqueId;
            }
            cw6 cw6Var = this.C;
            if (cw6Var != null) {
                cw6Var.j = bdUniqueId;
            }
            fw6 fw6Var = this.B;
            if (fw6Var != null) {
                fw6Var.j = bdUniqueId;
            }
            vv6 vv6Var2 = this.D;
            if (vv6Var2 != null) {
                vv6Var2.j = bdUniqueId;
            }
            yv6 yv6Var = this.E;
            if (yv6Var != null) {
                yv6Var.i = bdUniqueId;
            }
            zv6 zv6Var = this.F;
            if (zv6Var != null) {
                zv6Var.i = bdUniqueId;
            }
            bw6 bw6Var = this.G;
            if (bw6Var != null) {
                bw6Var.i = bdUniqueId;
            }
            kv6 kv6Var = this.H;
            if (kv6Var != null) {
                kv6Var.j = bdUniqueId;
            }
            lv6 lv6Var = this.v;
            if (lv6Var != null) {
                lv6Var.i = bdUniqueId;
            }
            gs6 gs6Var = this.J;
            if (gs6Var != null) {
                gs6Var.j = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (wm wmVar : this.R) {
                    if (wmVar instanceof va7) {
                        ((va7) wmVar).setUniqueId(bdUniqueId);
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

    public void v(dx6 dx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dx6Var) == null) {
            this.h.j0(dx6Var);
            this.i.i0(dx6Var);
            this.j.g0(dx6Var);
            this.l.g0(dx6Var);
            this.m.h0(dx6Var);
            this.q.g0(dx6Var);
            this.r.g0(dx6Var);
            this.s.g0(dx6Var);
            this.t.g0(dx6Var);
            this.u.j0(dx6Var);
            this.v.h0(dx6Var);
        }
    }

    public final void w(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, pnVar) == null) {
            this.i.j0(pnVar);
            this.j.h0(pnVar);
            this.k.g0(pnVar);
            this.l.h0(pnVar);
            this.m.i0(pnVar);
            this.n.b0(pnVar);
            this.o.c0(pnVar);
            this.p.b0(pnVar);
            this.q.h0(pnVar);
            this.r.h0(pnVar);
            this.s.h0(pnVar);
            this.t.h0(pnVar);
            this.v.i0(pnVar);
            this.u.k0(pnVar);
            this.H.h0(pnVar);
            this.A.k0(pnVar);
            this.A.k0(pnVar);
            this.C.h0(pnVar);
            this.J.b0(pnVar);
        }
    }

    public void x(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            zf8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void y(List<jn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, list, i) == null) {
            zf8.f(list, 2);
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
            qg.b(new a(this, list));
            this.c = list;
            f fVar = this.U;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
