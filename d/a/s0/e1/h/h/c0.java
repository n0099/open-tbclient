package d.a.s0.e1.h.h;

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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
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
import d.a.r0.r.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v A;
    public x B;
    public u C;
    public n D;
    public q E;
    public r F;
    public t G;
    public d.a.s0.e1.h.h.c H;
    public d.a.s0.e1.c.e.z I;
    public d.a.c.k.e.a J;
    public d.a.c.k.e.a K;
    public d.a.c.k.e.a L;
    public d.a.c.k.e.a M;
    public d.a.c.k.e.a N;
    public d.a.c.k.e.a O;
    public d.a.c.k.e.a P;
    public List<d.a.c.k.e.a> Q;
    public boolean R;
    public boolean S;
    public f T;
    public CustomMessageListener U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f58800a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.k.e.s f58801b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.n> f58802c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f58803d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.e1.h.h.a f58804e;

    /* renamed from: f  reason: collision with root package name */
    public a0 f58805f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.e1.h.h.b f58806g;

    /* renamed from: h  reason: collision with root package name */
    public n f58807h;

    /* renamed from: i  reason: collision with root package name */
    public y f58808i;
    public h j;
    public i k;
    public j l;
    public s m;
    public k n;
    public p o;
    public m p;
    public o q;
    public g r;
    public d.a.s0.e1.h.h.f s;
    public d.a.s0.e1.h.h.e t;
    public z u;
    public d.a.s0.e1.h.h.d v;
    public l w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public w z;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f58809a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c0 c0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58809a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f58809a.f();
            if (this.f58809a.f58802c != null) {
                c0 c0Var = this.f58809a;
                c0Var.z(c0Var.f58802c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f58810a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c0 c0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58810a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f12800a) {
                return;
            }
            this.f58810a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f58811a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(c0 c0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58811a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                d.a.s0.n1.p.b bVar = new d.a.s0.n1.p.b();
                bVar.f63884a = String.valueOf(customResponsedMessage.getData());
                bVar.f63885b = true;
                this.f58811a.g(bVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f58812a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c0 c0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58812a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                d.a.s0.n1.p.b bVar = new d.a.s0.n1.p.b();
                bVar.f63884a = String.valueOf(customResponsedMessage.getData());
                bVar.f63885b = false;
                this.f58812a.g(bVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f58813a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c0 c0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58813a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.d.m.e.b i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str, true) || (i2 = this.f58813a.i(str)) == null) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, i2));
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a();
    }

    public c0(Context context, d.a.c.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.U = new a(this, 2016470);
        this.V = new b(this, 2001115);
        this.W = new c(this, 2001335);
        this.X = new d(this, 2001336);
        this.Y = new e(this, 2921394);
        this.f58800a = new ArrayList();
        this.f58801b = sVar;
        this.f58803d = (TbPageContext) d.a.c.a.j.a(context);
        j(context);
        y(sVar);
        sVar.a(this.f58800a);
    }

    public void A(List<d.a.c.k.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
            d.a.s0.h3.v.f(list, 2);
            ViewGroup listView = this.f58801b.getListView();
            if (i2 > 0 && (listView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
                int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
                View childAt = bdRecyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
                int i3 = firstVisiblePosition - i2;
                if (layoutManager instanceof LinearLayoutManager) {
                    bdRecyclerView.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, top);
                    bdRecyclerView.A();
                }
            }
            this.f58801b.setData(list);
            this.f58802c = list;
            f fVar = this.T;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.S = f();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d.a.c.k.e.a> list = this.Q;
            if (list == null || list.size() <= 0) {
                this.Q = new ArrayList();
                ArrayList<BdUniqueId> g2 = d.a.s0.h3.v.g();
                if (g2 == null || g2.size() <= 0) {
                    return false;
                }
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.s0.n1.o.g.a b2 = d.a.s0.n1.r.b.d().b(this.f58803d, g2.get(i2), 2);
                    if (this.R) {
                        b2.f0(3);
                    }
                    n nVar = this.f58807h;
                    if (nVar != null && (bdUniqueId = nVar.n) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.Q.add(b2);
                }
                this.f58801b.a(this.Q);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<d.a.c.k.e.n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || (list = this.f58802c) == null) {
            return;
        }
        boolean z = false;
        for (d.a.c.k.e.n nVar : list) {
            if ((nVar instanceof ICardInfo) && ((ICardInfo) nVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            m();
        }
    }

    public List<d.a.c.k.e.n> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58802c : (List) invokeV.objValue;
    }

    public final d.a.d.m.e.b i(String str) {
        InterceptResult invokeL;
        int i2;
        d.a.s0.a0.e0.l lVar;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            List<d.a.c.k.e.n> list = this.f58802c;
            if (list == null || list.isEmpty() || str == null) {
                return null;
            }
            d.a.d.m.e.b bVar = new d.a.d.m.e.b();
            int i3 = 0;
            int i4 = 0;
            boolean z = false;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i3 >= this.f58802c.size()) {
                    i2 = -1;
                    break;
                }
                if (this.f58802c.get(i3) instanceof d.a.s0.e1.h.j.h) {
                    i4++;
                }
                if (this.f58802c.get(i3) instanceof d.a.s0.e1.h.j.a) {
                    if (l(this.f58802c.get(i3))) {
                        if (z) {
                            i2 = ((d.a.s0.e1.h.j.a) this.f58802c.get(i3)).position;
                            break;
                        }
                        i6 = ((d.a.s0.e1.h.j.a) this.f58802c.get(i3)).position;
                    } else if (z) {
                        i5++;
                    }
                }
                if ((this.f58802c.get(i3) instanceof d.a.s0.a0.e0.l) && (lVar = (d.a.s0.a0.e0.l) this.f58802c.get(i3)) != null && (b2Var = lVar.f57050e) != null && str.equals(b2Var.c0())) {
                    i7 = ((d.a.s0.a0.e0.l) this.f58802c.get(i3)).position;
                    z = true;
                }
                i3++;
            }
            if (i2 != -1 && (i2 = i2 - i5) < -1) {
                i2 = -1;
            }
            bVar.h(str);
            int i8 = i7 - i4;
            bVar.e(i8 >= -1 ? i8 : -1);
            bVar.g(i6);
            bVar.f(i2);
            return bVar;
        }
        return (d.a.d.m.e.b) invokeL.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f58804e = new d.a.s0.e1.h.h.a(this.f58803d);
            this.f58805f = new a0(this.f58803d);
            this.f58806g = new d.a.s0.e1.h.h.b(this.f58803d, d.a.s0.e1.h.j.f.f58883f);
            this.f58807h = new n(this.f58803d, d.a.s0.a0.e0.k.s0);
            this.f58808i = new y(this.f58803d, d.a.s0.a0.e0.k.C0);
            this.j = new h(this.f58803d, d.a.s0.a0.e0.k.J0);
            this.k = new i(this.f58803d, d.a.s0.a0.e0.k.D0);
            this.l = new j(this.f58803d, d.a.s0.a0.e0.k.K0);
            this.m = new s(this.f58803d, d.a.s0.a0.e0.k.I0);
            this.n = new k(this.f58803d, d.a.s0.a0.e0.k.L0);
            this.o = new p(this.f58803d, d.a.s0.a0.e0.k.M0);
            this.p = new m(this.f58803d, d.a.s0.a0.e0.k.N0);
            this.q = new o(this.f58803d, d.a.s0.a0.e0.k.O0);
            this.r = new g(this.f58803d, d.a.s0.a0.e0.k.E0);
            this.s = new d.a.s0.e1.h.h.f(this.f58803d, d.a.s0.a0.e0.k.F0);
            this.t = new d.a.s0.e1.h.h.e(this.f58803d, d.a.s0.a0.e0.k.G0);
            this.u = new z(this.f58803d, d.a.s0.a0.e0.l.X);
            this.w = new l(this.f58803d, d.a.s0.a0.e0.k.u0);
            this.x = new HomePageAlaLiveThreadAdapter(this.f58803d, d.a.s0.a0.e0.j.P0);
            this.y = new HomePageAlaFriendRoomAdapter(this.f58803d, d.a.s0.a0.e0.j.Q0);
            this.z = new w(this.f58803d, d.a.s0.a0.e0.k.v0);
            this.A = new v(this.f58803d, d.a.s0.a0.e0.k.w0);
            this.B = new x(this.f58803d, d.a.s0.a0.e0.k.y0);
            this.C = new u(this.f58803d, d.a.s0.a0.e0.k.x0);
            this.D = new n(this.f58803d, d.a.s0.a0.e0.k.t0);
            this.E = new q(this.f58803d, d.a.s0.a0.e0.k.z0);
            this.F = new r(this.f58803d, d.a.s0.a0.e0.k.A0);
            this.G = new t(this.f58803d, d.a.s0.e1.k.b.c.a.k0);
            this.H = new d.a.s0.e1.h.h.c(this.f58803d, d.a.s0.a0.e0.e.P0);
            this.v = new d.a.s0.e1.h.h.d(this.f58803d, d.a.s0.a0.e0.k.H0);
            this.I = new d.a.s0.e1.c.e.z(this.f58803d, d.a.s0.a0.e0.k.B0, (byte) 3);
            this.f58800a.add(this.f58804e);
            this.f58800a.add(this.f58805f);
            this.f58800a.add(this.f58806g);
            this.f58800a.add(this.f58807h);
            this.f58800a.add(this.f58808i);
            this.f58800a.add(this.j);
            this.f58800a.add(this.k);
            this.f58800a.add(this.l);
            this.f58800a.add(this.m);
            this.f58800a.add(this.n);
            this.f58800a.add(this.o);
            this.f58800a.add(this.p);
            this.f58800a.add(this.q);
            this.f58800a.add(this.r);
            this.f58800a.add(this.s);
            this.f58800a.add(this.t);
            this.f58800a.add(this.u);
            this.f58800a.add(this.w);
            this.f58800a.add(this.D);
            this.f58800a.add(new ReadProgessDelegetAdapter(this.f58803d, d.a.s0.e1.h.l.b.f58917g));
            this.f58800a.add(this.x);
            this.f58800a.add(this.y);
            this.f58800a.add(this.z);
            this.f58800a.add(this.A);
            this.f58800a.add(this.C);
            this.f58800a.add(this.B);
            this.f58800a.add(new b0(this.f58803d, d.a.s0.e1.h.j.h.f58885i));
            this.f58800a.add(this.E);
            this.f58800a.add(this.F);
            this.f58800a.add(this.G);
            this.f58800a.add(this.H);
            this.f58800a.add(this.v);
            this.f58800a.add(this.I);
            e();
            k();
            r("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!b2.B3.get()) {
                AdvertAppInfo.e4.set(false);
                return;
            }
            this.J = d.a.s0.w2.w.p().k(this.f58803d, AdvertAppInfo.h4, "INDEX");
            this.K = d.a.s0.w2.w.p().k(this.f58803d, AdvertAppInfo.i4, "INDEX");
            this.L = d.a.s0.w2.w.p().k(this.f58803d, AdvertAppInfo.j4, "INDEX");
            this.M = d.a.s0.w2.w.p().k(this.f58803d, AdvertAppInfo.k4, "INDEX");
            this.N = d.a.s0.w2.w.p().k(this.f58803d, AdvertAppInfo.l4, "INDEX");
            this.O = d.a.s0.w2.w.p().k(this.f58803d, AdvertAppInfo.n4, "INDEX");
            this.P = d.a.s0.w2.w.p().k(this.f58803d, AdvertAppInfo.m4, "INDEX");
            this.f58800a.add(this.J);
            this.f58800a.add(this.K);
            this.f58800a.add(this.L);
            this.f58800a.add(this.M);
            this.f58800a.add(this.N);
            this.f58800a.add(this.O);
            this.f58800a.add(this.P);
            if (this.f58803d.getPageActivity() instanceof BaseFragmentActivity) {
                this.f58800a.add(d.a.s0.v0.b.e().c((BaseFragmentActivity) this.f58803d.getPageActivity(), AdvertAppInfo.q4));
                this.f58800a.add(d.a.s0.v0.b.e().c((BaseFragmentActivity) this.f58803d.getPageActivity(), AdvertAppInfo.p4));
            }
            AdvertAppInfo.e4.set(true);
        }
    }

    public final boolean l(d.a.c.k.e.n nVar) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) ? nVar != null && (nVar instanceof d.a.s0.e1.h.j.a) && (advertAppInfo = ((d.a.s0.e1.h.j.a) nVar).f57055e) != null && advertAppInfo.w4() == 0 : invokeL.booleanValue;
    }

    public void m() {
        d.a.c.k.e.s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (sVar = this.f58801b) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            m();
            this.f58804e.f0(i2);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void p() {
        z zVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (zVar = this.u) == null) {
            return;
        }
        zVar.onPause();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            z zVar = this.u;
            if (zVar != null) {
                zVar.onResume();
            }
            m();
        }
    }

    public final void r(String str) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (list = this.f58800a) == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.s0.o.f) {
                ((d.a.s0.o.f) aVar).g(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            for (d.a.c.k.e.a aVar2 : this.f58800a) {
                if (aVar2 instanceof d.a.s0.e1.a) {
                    ((d.a.s0.e1.a) aVar2).f0(aVar);
                }
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            n nVar = this.f58807h;
            if (nVar != null) {
                nVar.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            j jVar = this.l;
            if (jVar != null) {
                jVar.setFromCDN(z);
            }
            d.a.s0.e1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
            d.a.c.k.e.a aVar = this.K;
            if (aVar == null || !(aVar instanceof d.a.s0.w2.s)) {
                return;
            }
            ((d.a.s0.w2.s) aVar).k(z);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            n nVar = this.f58807h;
            if (nVar != null) {
                nVar.q0(bVar);
            }
            s sVar = this.m;
            if (sVar != null) {
                sVar.m0(bVar);
            }
            i iVar = this.k;
            if (iVar != null) {
                iVar.l0(bVar);
            }
            l lVar = this.w;
            if (lVar != null) {
                lVar.k0(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.k0(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.k0(bVar);
            }
            w wVar = this.z;
            if (wVar != null) {
                wVar.k0(bVar);
            }
            v vVar = this.A;
            if (vVar != null) {
                vVar.s0(bVar);
            }
            u uVar = this.C;
            if (uVar != null) {
                uVar.m0(bVar);
            }
            x xVar = this.B;
            if (xVar != null) {
                xVar.p0(bVar);
            }
            n nVar2 = this.D;
            if (nVar2 != null) {
                nVar2.q0(bVar);
            }
            q qVar = this.E;
            if (qVar != null) {
                qVar.p0(bVar);
            }
            r rVar = this.F;
            if (rVar != null) {
                rVar.m0(bVar);
            }
            t tVar = this.G;
            if (tVar != null) {
                tVar.i0(bVar);
            }
            d.a.s0.e1.h.h.c cVar = this.H;
            if (cVar != null) {
                cVar.m0(bVar);
            }
        }
    }

    public void v(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            this.T = fVar;
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            d.a.s0.e1.h.h.b bVar = this.f58806g;
            if (bVar != null) {
                bVar.h0(bdUniqueId);
            }
            n nVar = this.f58807h;
            if (nVar != null) {
                nVar.n = bdUniqueId;
            }
            y yVar = this.f58808i;
            if (yVar != null) {
                yVar.n = bdUniqueId;
            }
            h hVar = this.j;
            if (hVar != null) {
                hVar.m = bdUniqueId;
            }
            i iVar = this.k;
            if (iVar != null) {
                iVar.m = bdUniqueId;
            }
            j jVar = this.l;
            if (jVar != null) {
                jVar.m = bdUniqueId;
            }
            s sVar = this.m;
            if (sVar != null) {
                sVar.m = bdUniqueId;
            }
            k kVar = this.n;
            if (kVar != null) {
                kVar.m = bdUniqueId;
            }
            p pVar = this.o;
            if (pVar != null) {
                pVar.m = bdUniqueId;
            }
            m mVar = this.p;
            if (mVar != null) {
                mVar.m = bdUniqueId;
            }
            o oVar = this.q;
            if (oVar != null) {
                oVar.m = bdUniqueId;
            }
            g gVar = this.r;
            if (gVar != null) {
                gVar.m = bdUniqueId;
            }
            d.a.s0.e1.h.h.f fVar = this.s;
            if (fVar != null) {
                fVar.m = bdUniqueId;
            }
            d.a.s0.e1.h.h.e eVar = this.t;
            if (eVar != null) {
                eVar.m = bdUniqueId;
            }
            l lVar = this.w;
            if (lVar != null) {
                lVar.n = bdUniqueId;
            }
            z zVar = this.u;
            if (zVar != null) {
                zVar.m = bdUniqueId;
            }
            d.a.s0.e1.h.h.a aVar = this.f58804e;
            if (aVar != null) {
                aVar.i0(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.m = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.m = bdUniqueId;
            }
            w wVar = this.z;
            if (wVar != null) {
                wVar.n = bdUniqueId;
            }
            v vVar = this.A;
            if (vVar != null) {
                vVar.n = bdUniqueId;
            }
            u uVar = this.C;
            if (uVar != null) {
                uVar.n = bdUniqueId;
            }
            x xVar = this.B;
            if (xVar != null) {
                xVar.n = bdUniqueId;
            }
            n nVar2 = this.D;
            if (nVar2 != null) {
                nVar2.n = bdUniqueId;
            }
            q qVar = this.E;
            if (qVar != null) {
                qVar.m = bdUniqueId;
            }
            r rVar = this.F;
            if (rVar != null) {
                rVar.m = bdUniqueId;
            }
            t tVar = this.G;
            if (tVar != null) {
                tVar.m = bdUniqueId;
            }
            d.a.s0.e1.h.h.c cVar = this.H;
            if (cVar != null) {
                cVar.n = bdUniqueId;
            }
            d.a.s0.e1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.m = bdUniqueId;
            }
            d.a.s0.e1.c.e.z zVar2 = this.I;
            if (zVar2 != null) {
                zVar2.n = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.Q)) {
                for (d.a.c.k.e.a aVar2 : this.Q) {
                    if (aVar2 instanceof d.a.s0.n1.o.g.a) {
                        ((d.a.s0.n1.o.g.a) aVar2).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.V.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
            this.W.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
            this.X.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            if (this.S) {
                return;
            }
            this.U.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.U);
        }
    }

    public void x(d.a.s0.e1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            this.f58807h.s0(eVar);
            this.f58808i.p0(eVar);
            this.j.m0(eVar);
            this.l.m0(eVar);
            this.m.p0(eVar);
            this.q.l0(eVar);
            this.r.m0(eVar);
            this.s.m0(eVar);
            this.t.m0(eVar);
            this.u.s0(eVar);
            this.v.p0(eVar);
        }
    }

    public final void y(d.a.c.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sVar) == null) {
            this.f58808i.q0(sVar);
            this.j.p0(sVar);
            this.k.m0(sVar);
            this.l.p0(sVar);
            this.m.q0(sVar);
            this.n.h0(sVar);
            this.o.i0(sVar);
            this.p.h0(sVar);
            this.q.m0(sVar);
            this.r.p0(sVar);
            this.s.p0(sVar);
            this.t.p0(sVar);
            this.v.q0(sVar);
            this.u.t0(sVar);
            this.H.p0(sVar);
            this.A.t0(sVar);
            this.A.t0(sVar);
            this.C.p0(sVar);
            this.I.h0(sVar);
        }
    }

    public void z(List<d.a.c.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            d.a.s0.h3.v.f(list, 2);
            this.f58801b.setData(list);
            this.f58802c = list;
            f fVar = this.T;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
