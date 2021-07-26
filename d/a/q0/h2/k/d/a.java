package d.a.q0.h2.k.d;

import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.godreply.MoreGodReplyModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.q0.h2.k.e.e0;
import d.a.q0.h2.k.e.m;
import d.a.q0.h2.k.e.t0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements d.a.p0.m0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57559e;

    /* renamed from: f  reason: collision with root package name */
    public final PbFragment f57560f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.h2.k.d.d f57561g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.h2.k.d.c f57562h;

    /* renamed from: i  reason: collision with root package name */
    public t0 f57563i;
    public m j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public TbRichTextView.z m;
    public View.OnLongClickListener n;
    public d.a.q0.h2.i.c o;
    public final MoreGodReplyModel p;
    public d.a.p0.m0.d q;
    public long r;
    public BdListView.p s;
    public AbsListView.OnScrollListener t;
    public e0.b u;
    public PbFragment.s2 v;

    /* renamed from: d.a.q0.h2.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1418a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57564e;

        public C1418a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57564e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57564e.p.G()) {
                return;
            }
            this.f57564e.p.H();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f57565e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f57566f;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57566f = aVar;
            this.f57565e = -1;
        }

        public final boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 == 2 || i2 == 1 : invokeI.booleanValue;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, absListView, i2) == null) {
                if (!a(this.f57565e) && a(i2) && (pbFragment = this.f57566f.f57560f) != null && pbFragment.V4() != null) {
                    this.f57566f.f57560f.V4().j2();
                    this.f57566f.f57560f.V4().X0();
                }
                this.f57565e = i2;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57567a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57567a = aVar;
        }

        @Override // d.a.q0.h2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f57567a.f57563i.v3(str);
        }

        @Override // d.a.q0.h2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f57567a.x();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f57568e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f57569f;

        public d(a aVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57569f = aVar;
            this.f57568e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57569f.f57561g.i();
                this.f57569f.f57559e = false;
                PbFragment pbFragment = this.f57569f.f57560f;
                if (pbFragment != null) {
                    if (pbFragment.V4() != null) {
                        this.f57569f.f57560f.V4().Z2(false);
                        d.a.q0.h2.k.e.i l0 = this.f57569f.f57560f.V4().l0();
                        l0.a0(this.f57569f.f57560f.y().L0(), true);
                        l0.V();
                    }
                    a aVar = this.f57569f;
                    aVar.f57560f.P5(aVar.v);
                }
                Runnable runnable = this.f57568e;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57570e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57570e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57570e.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57571e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57571e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57571e.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57572e;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57572e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57572e.p.G()) {
                return;
            }
            this.f57572e.p.H();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements PbFragment.s2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57573a;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57573a = aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.s2
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f57573a.h();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57574e;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57574e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57574e.f57562h.g(false);
            }
        }
    }

    public a(PbFragment pbFragment, t0 t0Var, ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, t0Var, viewStub};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new C1418a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.v = new h(this);
        MoreGodReplyModel moreGodReplyModel = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.y());
        this.p = moreGodReplyModel;
        moreGodReplyModel.I(this.u);
        this.f57563i = t0Var;
        this.f57560f = pbFragment;
        this.f57561g = new d.a.q0.h2.k.d.d(pbFragment, viewStub);
        this.f57562h = new d.a.q0.h2.k.d.c(this);
    }

    @Override // d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a053" : (String) invokeV.objValue;
    }

    @Override // d.a.p0.m0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbFragment pbFragment = this.f57560f;
            if (pbFragment == null) {
                return null;
            }
            return pbFragment.getNextPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.p0.m0.a
    public List<String> getNextPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
            String currentPageKey = getCurrentPageKey();
            if (ListUtils.isEmpty(arrayList2)) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                arrayList.addAll(arrayList2);
            }
            if (getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) {
                if (!StringUtils.isNull(currentPageKey)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(currentPageKey);
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.p0.m0.a
    public d.a.p0.m0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (d.a.p0.m0.b) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i(null);
        }
    }

    public void i(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
            this.p.cancelLoadData();
            this.f57560f.h5();
            if (!l() && runnable != null) {
                runnable.run();
                return;
            }
            if (l() && !this.f57562h.e()) {
                this.f57561g.r(new d(this, runnable));
            }
            if (this.r != 0) {
                d.a.p0.m0.d j = j();
                j.v(System.currentTimeMillis() - this.r);
                d.a.p0.m0.e.b().i(this.f57560f.getContext(), j, getPageStayFilter());
            }
        }
    }

    public d.a.p0.m0.d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.q == null) {
                d.a.p0.m0.d dVar = new d.a.p0.m0.d();
                this.q = dVar;
                dVar.u(getCurrentPageSourceKeyList());
                this.q.p(getCurrentPageKey());
                PbModel y = this.f57560f.y();
                if (y != null) {
                    this.q.q(d.a.d.e.m.b.f(y.getForumId(), 0L));
                    this.q.y(d.a.d.e.m.b.f(y.b1(), 0L));
                }
            }
            return this.q;
        }
        return (d.a.p0.m0.d) invokeV.objValue;
    }

    public d.a.q0.h2.k.d.d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57561g : (d.a.q0.h2.k.d.d) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f57559e : invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f57561g.o(i2);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && l()) {
            x();
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void q(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zVar) == null) {
            this.m = zVar;
        }
    }

    public void r(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onLongClickListener) == null) {
            this.n = onLongClickListener;
        }
    }

    public void s(d.a.q0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public final void t(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, bdTypeListView) == null) && this.j == null) {
            m mVar = new m(this.f57560f, PostData.u0);
            this.j = mVar;
            mVar.V0(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.j);
            bdTypeListView.a(arrayList);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            boolean m = this.f57561g.m();
            this.f57561g.p();
            if (!m) {
                this.f57561g.d().setOnClickListener(new e(this));
                this.f57561g.c().setOnClickListener(new f(this));
                this.f57561g.f().z(new g(this));
                this.f57561g.e().setOnScrollListener(this.t);
            }
            this.r = System.currentTimeMillis();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!l()) {
                this.f57560f.h5();
                this.f57559e = true;
                this.f57562h.h(false);
                this.f57562h.g(true);
                u();
                x();
                this.f57561g.q(new i(this));
                this.f57560f.Z3(this.v);
                this.p.H();
            }
            this.f57560f.V4().X0();
        }
    }

    public final void w(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.j.t(eVar);
            d.a.q0.h2.k.e.i l0 = this.f57563i.l0();
            this.j.setFromCDN(l0.T());
            this.j.q(eVar.N().H().getUserId());
            this.j.c(l0.U());
            this.j.e(this.k);
            this.j.m(this.l);
            this.j.p(this.m);
            this.j.d(this.n);
            this.j.Y0(this.o);
        }
    }

    public final void x() {
        List<n> D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (D = this.p.D()) == null) {
            return;
        }
        d.a.q0.h2.h.e L0 = this.p.E().L0();
        this.f57561g.p();
        this.f57561g.e().setOnSrollToBottomListener(this.s);
        BdTypeListView e2 = this.f57561g.e();
        this.f57562h.d();
        t(e2);
        w(L0);
        e2.setData(new ArrayList(D));
        this.f57561g.g().setCenterTextTitle(String.format(this.f57560f.getResources().getString(R.string.more_god_reply_count), StringHelper.numFormatOver10000(L0.S().f57501b.size())));
        this.f57561g.b(this.p.F());
        if (e2.getAdapter2() instanceof d.a.d.k.e.e) {
            e2.getAdapter2().notifyDataSetChanged();
        }
    }
}
