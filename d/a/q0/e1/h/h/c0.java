package d.a.q0.e1.h.h;

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
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
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
    public d.a.q0.e1.h.h.c H;
    public d.a.q0.e1.c.e.z I;
    public d.a.d.k.e.a J;
    public d.a.d.k.e.a K;
    public d.a.d.k.e.a L;
    public d.a.d.k.e.a M;
    public d.a.d.k.e.a N;
    public d.a.d.k.e.a O;
    public d.a.d.k.e.a P;
    public List<d.a.d.k.e.a> Q;
    public boolean R;
    public boolean S;
    public f T;
    public CustomMessageListener U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.d.k.e.a> f56089a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.d.k.e.s f56090b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.d.k.e.n> f56091c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext<?> f56092d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.e1.h.h.a f56093e;

    /* renamed from: f  reason: collision with root package name */
    public a0 f56094f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.e1.h.h.b f56095g;

    /* renamed from: h  reason: collision with root package name */
    public n f56096h;

    /* renamed from: i  reason: collision with root package name */
    public y f56097i;
    public h j;
    public i k;
    public j l;
    public s m;
    public k n;
    public p o;
    public m p;
    public o q;
    public g r;
    public d.a.q0.e1.h.h.f s;
    public d.a.q0.e1.h.h.e t;
    public z u;
    public d.a.q0.e1.h.h.d v;
    public l w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public w z;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f56098a;

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
            this.f56098a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f56098a.f();
            if (this.f56098a.f56091c != null) {
                c0 c0Var = this.f56098a;
                c0Var.z(c0Var.f56091c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f56099a;

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
            this.f56099a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f12866a) {
                return;
            }
            this.f56099a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f56100a;

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
            this.f56100a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                d.a.q0.n1.p.b bVar = new d.a.q0.n1.p.b();
                bVar.f61264a = String.valueOf(customResponsedMessage.getData());
                bVar.f61265b = true;
                this.f56100a.g(bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f56101a;

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
            this.f56101a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                d.a.q0.n1.p.b bVar = new d.a.q0.n1.p.b();
                bVar.f61264a = String.valueOf(customResponsedMessage.getData());
                bVar.f61265b = false;
                this.f56101a.g(bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f56102a;

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
            this.f56102a = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.e.m.e.b i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str, true) || (i2 = this.f56102a.i(str)) == null) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, i2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a();
    }

    public c0(Context context, d.a.d.k.e.s sVar) {
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
        this.f56089a = new ArrayList();
        this.f56090b = sVar;
        this.f56092d = (TbPageContext) d.a.d.a.j.a(context);
        j(context);
        y(sVar);
        sVar.a(this.f56089a);
    }

    public void A(List<d.a.d.k.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
            d.a.q0.h3.v.f(list, 2);
            ViewGroup listView = this.f56090b.getListView();
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
            this.f56090b.setData(list);
            this.f56091c = list;
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
            List<d.a.d.k.e.a> list = this.Q;
            if (list == null || list.size() <= 0) {
                this.Q = new ArrayList();
                ArrayList<BdUniqueId> g2 = d.a.q0.h3.v.g();
                if (g2 == null || g2.size() <= 0) {
                    return false;
                }
                int size = g2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.q0.n1.o.g.a b2 = d.a.q0.n1.r.b.d().b(this.f56092d, g2.get(i2), 2);
                    if (this.R) {
                        b2.e0(3);
                    }
                    n nVar = this.f56096h;
                    if (nVar != null && (bdUniqueId = nVar.n) != null) {
                        b2.setUniqueId(bdUniqueId);
                    }
                    this.Q.add(b2);
                }
                this.f56090b.a(this.Q);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<d.a.d.k.e.n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || (list = this.f56091c) == null) {
            return;
        }
        boolean z = false;
        for (d.a.d.k.e.n nVar : list) {
            if ((nVar instanceof ICardInfo) && ((ICardInfo) nVar).responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            m();
        }
    }

    public List<d.a.d.k.e.n> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56091c : (List) invokeV.objValue;
    }

    public final d.a.e.m.e.b i(String str) {
        InterceptResult invokeL;
        int i2;
        d.a.q0.a0.e0.l lVar;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            List<d.a.d.k.e.n> list = this.f56091c;
            if (list == null || list.isEmpty() || str == null) {
                return null;
            }
            d.a.e.m.e.b bVar = new d.a.e.m.e.b();
            int i3 = 0;
            int i4 = 0;
            boolean z = false;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i3 >= this.f56091c.size()) {
                    i2 = -1;
                    break;
                }
                if (this.f56091c.get(i3) instanceof d.a.q0.e1.h.j.h) {
                    i4++;
                }
                if (this.f56091c.get(i3) instanceof d.a.q0.e1.h.j.a) {
                    if (l(this.f56091c.get(i3))) {
                        if (z) {
                            i2 = ((d.a.q0.e1.h.j.a) this.f56091c.get(i3)).position;
                            break;
                        }
                        i6 = ((d.a.q0.e1.h.j.a) this.f56091c.get(i3)).position;
                    } else if (z) {
                        i5++;
                    }
                }
                if ((this.f56091c.get(i3) instanceof d.a.q0.a0.e0.l) && (lVar = (d.a.q0.a0.e0.l) this.f56091c.get(i3)) != null && (b2Var = lVar.f54338e) != null && str.equals(b2Var.d0())) {
                    i7 = ((d.a.q0.a0.e0.l) this.f56091c.get(i3)).position;
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
        return (d.a.e.m.e.b) invokeL.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f56093e = new d.a.q0.e1.h.h.a(this.f56092d);
            this.f56094f = new a0(this.f56092d);
            this.f56095g = new d.a.q0.e1.h.h.b(this.f56092d, d.a.q0.e1.h.j.f.f56172f);
            this.f56096h = new n(this.f56092d, d.a.q0.a0.e0.k.s0);
            this.f56097i = new y(this.f56092d, d.a.q0.a0.e0.k.C0);
            this.j = new h(this.f56092d, d.a.q0.a0.e0.k.J0);
            this.k = new i(this.f56092d, d.a.q0.a0.e0.k.D0);
            this.l = new j(this.f56092d, d.a.q0.a0.e0.k.K0);
            this.m = new s(this.f56092d, d.a.q0.a0.e0.k.I0);
            this.n = new k(this.f56092d, d.a.q0.a0.e0.k.L0);
            this.o = new p(this.f56092d, d.a.q0.a0.e0.k.M0);
            this.p = new m(this.f56092d, d.a.q0.a0.e0.k.N0);
            this.q = new o(this.f56092d, d.a.q0.a0.e0.k.O0);
            this.r = new g(this.f56092d, d.a.q0.a0.e0.k.E0);
            this.s = new d.a.q0.e1.h.h.f(this.f56092d, d.a.q0.a0.e0.k.F0);
            this.t = new d.a.q0.e1.h.h.e(this.f56092d, d.a.q0.a0.e0.k.G0);
            this.u = new z(this.f56092d, d.a.q0.a0.e0.l.X);
            this.w = new l(this.f56092d, d.a.q0.a0.e0.k.u0);
            this.x = new HomePageAlaLiveThreadAdapter(this.f56092d, d.a.q0.a0.e0.j.P0);
            this.y = new HomePageAlaFriendRoomAdapter(this.f56092d, d.a.q0.a0.e0.j.Q0);
            this.z = new w(this.f56092d, d.a.q0.a0.e0.k.v0);
            this.A = new v(this.f56092d, d.a.q0.a0.e0.k.w0);
            this.B = new x(this.f56092d, d.a.q0.a0.e0.k.y0);
            this.C = new u(this.f56092d, d.a.q0.a0.e0.k.x0);
            this.D = new n(this.f56092d, d.a.q0.a0.e0.k.t0);
            this.E = new q(this.f56092d, d.a.q0.a0.e0.k.z0);
            this.F = new r(this.f56092d, d.a.q0.a0.e0.k.A0);
            this.G = new t(this.f56092d, d.a.q0.e1.k.b.c.a.k0);
            this.H = new d.a.q0.e1.h.h.c(this.f56092d, d.a.q0.a0.e0.e.P0);
            this.v = new d.a.q0.e1.h.h.d(this.f56092d, d.a.q0.a0.e0.k.H0);
            this.I = new d.a.q0.e1.c.e.z(this.f56092d, d.a.q0.a0.e0.k.B0, (byte) 3);
            this.f56089a.add(this.f56093e);
            this.f56089a.add(this.f56094f);
            this.f56089a.add(this.f56095g);
            this.f56089a.add(this.f56096h);
            this.f56089a.add(this.f56097i);
            this.f56089a.add(this.j);
            this.f56089a.add(this.k);
            this.f56089a.add(this.l);
            this.f56089a.add(this.m);
            this.f56089a.add(this.n);
            this.f56089a.add(this.o);
            this.f56089a.add(this.p);
            this.f56089a.add(this.q);
            this.f56089a.add(this.r);
            this.f56089a.add(this.s);
            this.f56089a.add(this.t);
            this.f56089a.add(this.u);
            this.f56089a.add(this.w);
            this.f56089a.add(this.D);
            this.f56089a.add(new ReadProgessDelegetAdapter(this.f56092d, d.a.q0.e1.h.l.b.f56206g));
            this.f56089a.add(this.x);
            this.f56089a.add(this.y);
            this.f56089a.add(this.z);
            this.f56089a.add(this.A);
            this.f56089a.add(this.C);
            this.f56089a.add(this.B);
            this.f56089a.add(new b0(this.f56092d, d.a.q0.e1.h.j.h.f56174i));
            this.f56089a.add(this.E);
            this.f56089a.add(this.F);
            this.f56089a.add(this.G);
            this.f56089a.add(this.H);
            this.f56089a.add(this.v);
            this.f56089a.add(this.I);
            e();
            k();
            r("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!b2.H3.get()) {
                AdvertAppInfo.k4.set(false);
                return;
            }
            this.J = d.a.q0.w2.w.o().j(this.f56092d, AdvertAppInfo.n4, "INDEX");
            this.K = d.a.q0.w2.w.o().j(this.f56092d, AdvertAppInfo.o4, "INDEX");
            this.L = d.a.q0.w2.w.o().j(this.f56092d, AdvertAppInfo.p4, "INDEX");
            this.M = d.a.q0.w2.w.o().j(this.f56092d, AdvertAppInfo.q4, "INDEX");
            this.N = d.a.q0.w2.w.o().j(this.f56092d, AdvertAppInfo.r4, "INDEX");
            this.O = d.a.q0.w2.w.o().j(this.f56092d, AdvertAppInfo.t4, "INDEX");
            this.P = d.a.q0.w2.w.o().j(this.f56092d, AdvertAppInfo.s4, "INDEX");
            this.f56089a.add(this.J);
            this.f56089a.add(this.K);
            this.f56089a.add(this.L);
            this.f56089a.add(this.M);
            this.f56089a.add(this.N);
            this.f56089a.add(this.O);
            this.f56089a.add(this.P);
            if (this.f56092d.getPageActivity() instanceof BaseFragmentActivity) {
                this.f56089a.add(d.a.q0.v0.b.e().c((BaseFragmentActivity) this.f56092d.getPageActivity(), AdvertAppInfo.w4));
                this.f56089a.add(d.a.q0.v0.b.e().c((BaseFragmentActivity) this.f56092d.getPageActivity(), AdvertAppInfo.v4));
            }
            AdvertAppInfo.k4.set(true);
        }
    }

    public final boolean l(d.a.d.k.e.n nVar) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) ? nVar != null && (nVar instanceof d.a.q0.e1.h.j.a) && (advertAppInfo = ((d.a.q0.e1.h.j.a) nVar).f54343e) != null && advertAppInfo.z4() == 0 : invokeL.booleanValue;
    }

    public void m() {
        d.a.d.k.e.s sVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (sVar = this.f56090b) == null) {
            return;
        }
        sVar.getListAdapter().notifyDataSetChanged();
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            m();
            this.f56093e.e0(i2);
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
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (list = this.f56089a) == null) {
            return;
        }
        for (d.a.d.k.e.a aVar : list) {
            if (aVar instanceof d.a.q0.o.f) {
                ((d.a.q0.o.f) aVar).g(str);
            }
        }
    }

    public void s(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            for (d.a.d.k.e.a aVar2 : this.f56089a) {
                if (aVar2 instanceof d.a.q0.e1.a) {
                    ((d.a.q0.e1.a) aVar2).e0(aVar);
                }
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            n nVar = this.f56096h;
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
            d.a.q0.e1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.setFromCDN(z);
            }
            d.a.d.k.e.a aVar = this.K;
            if (aVar == null || !(aVar instanceof d.a.q0.w2.s)) {
                return;
            }
            ((d.a.q0.w2.s) aVar).k(z);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            n nVar = this.f56096h;
            if (nVar != null) {
                nVar.o0(bVar);
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
                vVar.p0(bVar);
            }
            u uVar = this.C;
            if (uVar != null) {
                uVar.m0(bVar);
            }
            x xVar = this.B;
            if (xVar != null) {
                xVar.n0(bVar);
            }
            n nVar2 = this.D;
            if (nVar2 != null) {
                nVar2.o0(bVar);
            }
            q qVar = this.E;
            if (qVar != null) {
                qVar.n0(bVar);
            }
            r rVar = this.F;
            if (rVar != null) {
                rVar.m0(bVar);
            }
            t tVar = this.G;
            if (tVar != null) {
                tVar.i0(bVar);
            }
            d.a.q0.e1.h.h.c cVar = this.H;
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
            d.a.q0.e1.h.h.b bVar = this.f56095g;
            if (bVar != null) {
                bVar.g0(bdUniqueId);
            }
            n nVar = this.f56096h;
            if (nVar != null) {
                nVar.n = bdUniqueId;
            }
            y yVar = this.f56097i;
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
            d.a.q0.e1.h.h.f fVar = this.s;
            if (fVar != null) {
                fVar.m = bdUniqueId;
            }
            d.a.q0.e1.h.h.e eVar = this.t;
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
            d.a.q0.e1.h.h.a aVar = this.f56093e;
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
            d.a.q0.e1.h.h.c cVar = this.H;
            if (cVar != null) {
                cVar.n = bdUniqueId;
            }
            d.a.q0.e1.h.h.d dVar = this.v;
            if (dVar != null) {
                dVar.m = bdUniqueId;
            }
            d.a.q0.e1.c.e.z zVar2 = this.I;
            if (zVar2 != null) {
                zVar2.n = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.Q)) {
                for (d.a.d.k.e.a aVar2 : this.Q) {
                    if (aVar2 instanceof d.a.q0.n1.o.g.a) {
                        ((d.a.q0.n1.o.g.a) aVar2).setUniqueId(bdUniqueId);
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

    public void x(d.a.q0.e1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            this.f56096h.p0(eVar);
            this.f56097i.n0(eVar);
            this.j.m0(eVar);
            this.l.m0(eVar);
            this.m.n0(eVar);
            this.q.l0(eVar);
            this.r.m0(eVar);
            this.s.m0(eVar);
            this.t.m0(eVar);
            this.u.p0(eVar);
            this.v.n0(eVar);
        }
    }

    public final void y(d.a.d.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sVar) == null) {
            this.f56097i.o0(sVar);
            this.j.n0(sVar);
            this.k.m0(sVar);
            this.l.n0(sVar);
            this.m.o0(sVar);
            this.n.g0(sVar);
            this.o.i0(sVar);
            this.p.g0(sVar);
            this.q.m0(sVar);
            this.r.n0(sVar);
            this.s.n0(sVar);
            this.t.n0(sVar);
            this.v.o0(sVar);
            this.u.r0(sVar);
            this.H.n0(sVar);
            this.A.r0(sVar);
            this.A.r0(sVar);
            this.C.n0(sVar);
            this.I.g0(sVar);
        }
    }

    public void z(List<d.a.d.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            d.a.q0.h3.v.f(list, 2);
            this.f56090b.setData(list);
            this.f56091c = list;
            f fVar = this.T;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
