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
import com.baidu.adp.lib.util.StringUtils;
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
public class fz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xy6 A;
    public zy6 B;
    public wy6 C;
    public py6 D;
    public sy6 E;
    public ty6 F;
    public vy6 G;
    public ey6 H;
    public cz6 I;
    public av6 J;
    public ho K;
    public ho L;
    public ho M;
    public ho N;
    public ho O;
    public ho P;
    public ho Q;
    public List<ho> R;
    public boolean S;
    public boolean T;
    public g U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<ho> a;
    public zo b;
    public List<uo> c;
    public TbPageContext<?> d;
    public cy6 e;
    public dz6 f;
    public dy6 g;
    public py6 h;
    public az6 i;
    public jy6 j;
    public ky6 k;
    public ly6 l;
    public uy6 m;
    public my6 n;
    public ry6 o;
    public oy6 p;
    public qy6 q;
    public iy6 r;
    public hy6 s;
    public gy6 t;
    public bz6 u;
    public fy6 v;
    public ny6 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public yy6 z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ fz6 b;

        public a(fz6 fz6Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fz6Var;
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
        public final /* synthetic */ fz6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fz6 fz6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var, Integer.valueOf(i)};
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
            this.a = fz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.g();
            if (this.a.c != null) {
                fz6 fz6Var = this.a;
                fz6Var.A(fz6Var.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(fz6 fz6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var, Integer.valueOf(i)};
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
            this.a = fz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.h(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(fz6 fz6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var, Integer.valueOf(i)};
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
            this.a = fz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                xd7 xd7Var = new xd7();
                xd7Var.a = String.valueOf(customResponsedMessage.getData());
                xd7Var.b = true;
                this.a.h(xd7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(fz6 fz6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var, Integer.valueOf(i)};
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
            this.a = fz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                xd7 xd7Var = new xd7();
                xd7Var.a = String.valueOf(customResponsedMessage.getData());
                xd7Var.b = false;
                this.a.h(xd7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(fz6 fz6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz6Var, Integer.valueOf(i)};
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
            this.a = fz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            yp j;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str, true) || (j = this.a.j(str)) == null) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, j));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a();
    }

    public fz6(Context context, zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, zoVar};
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
        this.Z = new f(this, 2921394);
        this.a = new ArrayList();
        this.b = zoVar;
        this.d = (TbPageContext) f9.a(context);
        k(context);
        z(zoVar);
        zoVar.a(this.a);
    }

    public void A(List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            uj8.f(list, 2);
            this.b.setData(list);
            this.c = list;
            g gVar = this.U;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public void B(List<uo> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i) == null) {
            uj8.f(list, 2);
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
            tg.b(new a(this, list));
            this.c = list;
            g gVar = this.U;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.T = g();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ho> list = this.R;
            if (list == null || list.size() <= 0) {
                this.R = new ArrayList();
                ArrayList<BdUniqueId> g2 = uj8.g();
                if (g2 == null || g2.size() <= 0) {
                    return false;
                }
                int size = g2.size();
                for (int i = 0; i < size; i++) {
                    yc7 b2 = fe7.d().b(this.d, g2.get(i), 2);
                    if (this.S) {
                        b2.Z(3);
                    }
                    py6 py6Var = this.h;
                    if (py6Var != null && (bdUniqueId = py6Var.j) != null) {
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

    public final void h(Object obj) {
        List<uo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, obj) == null) || (list = this.c) == null) {
            return;
        }
        boolean z = false;
        for (uo uoVar : list) {
            if ((uoVar instanceof ICardInfo) && ((ICardInfo) uoVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            n();
        }
    }

    public List<uo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final yp j(String str) {
        InterceptResult invokeL;
        int i;
        ey5 ey5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            List<uo> list = this.c;
            if (list == null || list.isEmpty() || str == null) {
                return null;
            }
            yp ypVar = new yp();
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            while (true) {
                if (i2 >= this.c.size()) {
                    i = -1;
                    break;
                }
                if (this.c.get(i2) instanceof pz6) {
                    i3++;
                }
                if (this.c.get(i2) instanceof iz6) {
                    if (m(this.c.get(i2))) {
                        if (z) {
                            i = ((iz6) this.c.get(i2)).position;
                            break;
                        }
                        i5 = ((iz6) this.c.get(i2)).position;
                    } else if (z) {
                        i4++;
                    }
                }
                if ((this.c.get(i2) instanceof ey5) && (ey5Var = (ey5) this.c.get(i2)) != null && (threadData = ey5Var.a) != null && str.equals(threadData.getId())) {
                    i6 = ((ey5) this.c.get(i2)).position;
                    z = true;
                }
                i2++;
            }
            if (i != -1 && (i = i - i4) < -1) {
                i = -1;
            }
            ypVar.h(str);
            int i7 = i6 - i3;
            ypVar.e(i7 >= -1 ? i7 : -1);
            ypVar.g(i5);
            ypVar.f(i);
            return ypVar;
        }
        return (yp) invokeL.objValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.e = new cy6(this.d);
            this.f = new dz6(this.d);
            this.g = new dy6(this.d, nz6.b);
            this.h = new py6(this.d, dy5.o0);
            this.i = new az6(this.d, dy5.z0);
            this.j = new jy6(this.d, dy5.H0);
            this.k = new ky6(this.d, dy5.A0);
            this.l = new ly6(this.d, dy5.I0);
            this.m = new uy6(this.d, dy5.G0);
            this.n = new my6(this.d, dy5.J0);
            this.o = new ry6(this.d, dy5.K0);
            this.p = new oy6(this.d, dy5.L0);
            this.q = new qy6(this.d, dy5.M0);
            this.r = new iy6(this.d, dy5.B0);
            this.s = new hy6(this.d, dy5.C0);
            this.t = new gy6(this.d, dy5.D0);
            this.u = new bz6(this.d, ey5.U);
            this.w = new ny6(this.d, dy5.q0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, cy5.N0);
            this.I = new cz6(this.d, dy5.F0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, cy5.O0);
            this.z = new yy6(this.d, dy5.r0);
            this.A = new xy6(this.d, dy5.s0);
            this.B = new zy6(this.d, dy5.u0);
            this.C = new wy6(this.d, dy5.t0);
            this.D = new py6(this.d, dy5.p0);
            this.E = new sy6(this.d, dy5.v0);
            this.F = new ty6(this.d, dy5.w0);
            this.G = new vy6(this.d, q27.j0);
            this.H = new ey6(this.d, yx5.N0);
            this.v = new fy6(this.d, dy5.E0);
            this.J = new av6(this.d, dy5.x0, (byte) 3);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, b07.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new ez6(this.d, pz6.e));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.H);
            this.a.add(this.v);
            this.a.add(this.J);
            this.a.add(this.I);
            f();
            l();
            s("page_recommend");
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.K = fa8.q().j(this.d, AdvertAppInfo.y, "INDEX");
            this.L = fa8.q().j(this.d, AdvertAppInfo.z, "INDEX");
            this.M = fa8.q().j(this.d, AdvertAppInfo.A, "INDEX");
            this.N = fa8.q().j(this.d, AdvertAppInfo.B, "INDEX");
            this.O = fa8.q().j(this.d, AdvertAppInfo.C, "INDEX");
            this.P = fa8.q().j(this.d, AdvertAppInfo.E, "INDEX");
            this.Q = fa8.q().j(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.K);
            this.a.add(this.L);
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ds6.e().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(ds6.e().c((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public final boolean m(uo uoVar) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, uoVar)) == null) ? uoVar != null && (uoVar instanceof iz6) && (advertAppInfo = ((iz6) uoVar).a) != null && advertAppInfo.q() == 0 : invokeL.booleanValue;
    }

    public void n() {
        zo zoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (zoVar = this.b) == null) {
            return;
        }
        zoVar.getListAdapter().notifyDataSetChanged();
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            n();
            this.e.Z(i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void q() {
        bz6 bz6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bz6Var = this.u) == null) {
            return;
        }
        bz6Var.onPause();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            bz6 bz6Var = this.u;
            if (bz6Var != null) {
                bz6Var.onResume();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            n();
        }
    }

    public final void s(String str) {
        List<ho> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (list = this.a) == null) {
            return;
        }
        for (ho hoVar : list) {
            if (hoVar instanceof qi5) {
                ((qi5) hoVar).g(str);
            }
        }
    }

    public void t(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            for (ho hoVar : this.a) {
                if (hoVar instanceof rt6) {
                    ((rt6) hoVar).Z(aVar);
                }
            }
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            py6 py6Var = this.h;
            if (py6Var != null) {
                py6Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            ly6 ly6Var = this.l;
            if (ly6Var != null) {
                ly6Var.setFromCDN(z);
            }
            fy6 fy6Var = this.v;
            if (fy6Var != null) {
                fy6Var.setFromCDN(z);
            }
            ho hoVar = this.L;
            if (hoVar == null || !(hoVar instanceof aa8)) {
                return;
            }
            ((aa8) hoVar).j(z);
        }
    }

    public void v(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            py6 py6Var = this.h;
            if (py6Var != null) {
                py6Var.i0(bVar);
            }
            uy6 uy6Var = this.m;
            if (uy6Var != null) {
                uy6Var.g0(bVar);
            }
            ky6 ky6Var = this.k;
            if (ky6Var != null) {
                ky6Var.f0(bVar);
            }
            ny6 ny6Var = this.w;
            if (ny6Var != null) {
                ny6Var.e0(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.e0(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.e0(bVar);
            }
            yy6 yy6Var = this.z;
            if (yy6Var != null) {
                yy6Var.e0(bVar);
            }
            xy6 xy6Var = this.A;
            if (xy6Var != null) {
                xy6Var.j0(bVar);
            }
            wy6 wy6Var = this.C;
            if (wy6Var != null) {
                wy6Var.g0(bVar);
            }
            zy6 zy6Var = this.B;
            if (zy6Var != null) {
                zy6Var.h0(bVar);
            }
            py6 py6Var2 = this.D;
            if (py6Var2 != null) {
                py6Var2.i0(bVar);
            }
            sy6 sy6Var = this.E;
            if (sy6Var != null) {
                sy6Var.h0(bVar);
            }
            ty6 ty6Var = this.F;
            if (ty6Var != null) {
                ty6Var.g0(bVar);
            }
            vy6 vy6Var = this.G;
            if (vy6Var != null) {
                vy6Var.c0(bVar);
            }
            ey6 ey6Var = this.H;
            if (ey6Var != null) {
                ey6Var.g0(bVar);
            }
        }
    }

    public void w(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gVar) == null) {
            this.U = gVar;
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            dy6 dy6Var = this.g;
            if (dy6Var != null) {
                dy6Var.b0(bdUniqueId);
            }
            py6 py6Var = this.h;
            if (py6Var != null) {
                py6Var.j = bdUniqueId;
            }
            az6 az6Var = this.i;
            if (az6Var != null) {
                az6Var.j = bdUniqueId;
            }
            jy6 jy6Var = this.j;
            if (jy6Var != null) {
                jy6Var.i = bdUniqueId;
            }
            ky6 ky6Var = this.k;
            if (ky6Var != null) {
                ky6Var.i = bdUniqueId;
            }
            ly6 ly6Var = this.l;
            if (ly6Var != null) {
                ly6Var.i = bdUniqueId;
            }
            uy6 uy6Var = this.m;
            if (uy6Var != null) {
                uy6Var.i = bdUniqueId;
            }
            my6 my6Var = this.n;
            if (my6Var != null) {
                my6Var.i = bdUniqueId;
            }
            ry6 ry6Var = this.o;
            if (ry6Var != null) {
                ry6Var.i = bdUniqueId;
            }
            oy6 oy6Var = this.p;
            if (oy6Var != null) {
                oy6Var.i = bdUniqueId;
            }
            qy6 qy6Var = this.q;
            if (qy6Var != null) {
                qy6Var.i = bdUniqueId;
            }
            iy6 iy6Var = this.r;
            if (iy6Var != null) {
                iy6Var.i = bdUniqueId;
            }
            hy6 hy6Var = this.s;
            if (hy6Var != null) {
                hy6Var.i = bdUniqueId;
            }
            gy6 gy6Var = this.t;
            if (gy6Var != null) {
                gy6Var.i = bdUniqueId;
            }
            ny6 ny6Var = this.w;
            if (ny6Var != null) {
                ny6Var.j = bdUniqueId;
            }
            bz6 bz6Var = this.u;
            if (bz6Var != null) {
                bz6Var.i = bdUniqueId;
            }
            cy6 cy6Var = this.e;
            if (cy6Var != null) {
                cy6Var.c0(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.i = bdUniqueId;
            }
            cz6 cz6Var = this.I;
            if (cz6Var != null) {
                cz6Var.i = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.i = bdUniqueId;
            }
            yy6 yy6Var = this.z;
            if (yy6Var != null) {
                yy6Var.j = bdUniqueId;
            }
            xy6 xy6Var = this.A;
            if (xy6Var != null) {
                xy6Var.j = bdUniqueId;
            }
            wy6 wy6Var = this.C;
            if (wy6Var != null) {
                wy6Var.j = bdUniqueId;
            }
            zy6 zy6Var = this.B;
            if (zy6Var != null) {
                zy6Var.j = bdUniqueId;
            }
            py6 py6Var2 = this.D;
            if (py6Var2 != null) {
                py6Var2.j = bdUniqueId;
            }
            sy6 sy6Var = this.E;
            if (sy6Var != null) {
                sy6Var.i = bdUniqueId;
            }
            ty6 ty6Var = this.F;
            if (ty6Var != null) {
                ty6Var.i = bdUniqueId;
            }
            vy6 vy6Var = this.G;
            if (vy6Var != null) {
                vy6Var.i = bdUniqueId;
            }
            ey6 ey6Var = this.H;
            if (ey6Var != null) {
                ey6Var.j = bdUniqueId;
            }
            fy6 fy6Var = this.v;
            if (fy6Var != null) {
                fy6Var.i = bdUniqueId;
            }
            av6 av6Var = this.J;
            if (av6Var != null) {
                av6Var.j = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.R)) {
                for (ho hoVar : this.R) {
                    if (hoVar instanceof yc7) {
                        ((yc7) hoVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            this.Z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
            if (this.T) {
                return;
            }
            this.V.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
        }
    }

    public void y(xz6 xz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, xz6Var) == null) {
            this.h.j0(xz6Var);
            this.i.i0(xz6Var);
            this.j.g0(xz6Var);
            this.l.g0(xz6Var);
            this.m.h0(xz6Var);
            this.q.f0(xz6Var);
            this.r.g0(xz6Var);
            this.s.g0(xz6Var);
            this.t.g0(xz6Var);
            this.u.j0(xz6Var);
            this.v.h0(xz6Var);
        }
    }

    public final void z(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, zoVar) == null) {
            this.i.j0(zoVar);
            this.j.h0(zoVar);
            this.k.g0(zoVar);
            this.l.h0(zoVar);
            this.m.i0(zoVar);
            this.n.b0(zoVar);
            this.o.c0(zoVar);
            this.p.b0(zoVar);
            this.q.g0(zoVar);
            this.r.h0(zoVar);
            this.s.h0(zoVar);
            this.t.h0(zoVar);
            this.v.i0(zoVar);
            this.u.k0(zoVar);
            this.H.h0(zoVar);
            this.A.k0(zoVar);
            this.A.k0(zoVar);
            this.C.h0(zoVar);
            this.J.b0(zoVar);
        }
    }
}
