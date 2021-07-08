package d.a.p0.h2.k.d;

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
import d.a.c.k.e.n;
import d.a.p0.h2.k.e.e0;
import d.a.p0.h2.k.e.m;
import d.a.p0.h2.k.e.t0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements d.a.o0.k0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57010e;

    /* renamed from: f  reason: collision with root package name */
    public final PbFragment f57011f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.h2.k.d.d f57012g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.h2.k.d.c f57013h;

    /* renamed from: i  reason: collision with root package name */
    public t0 f57014i;
    public m j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public TbRichTextView.x m;
    public View.OnLongClickListener n;
    public d.a.p0.h2.i.c o;
    public final MoreGodReplyModel p;
    public d.a.o0.k0.d q;
    public long r;
    public BdListView.p s;
    public AbsListView.OnScrollListener t;
    public e0.b u;
    public PbFragment.r2 v;

    /* renamed from: d.a.p0.h2.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1409a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57015e;

        public C1409a(a aVar) {
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
            this.f57015e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57015e.p.G()) {
                return;
            }
            this.f57015e.p.H();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f57016e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f57017f;

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
            this.f57017f = aVar;
            this.f57016e = -1;
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
                if (!a(this.f57016e) && a(i2) && (pbFragment = this.f57017f.f57011f) != null && pbFragment.Q4() != null) {
                    this.f57017f.f57011f.Q4().j2();
                    this.f57017f.f57011f.Q4().X0();
                }
                this.f57016e = i2;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57018a;

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
            this.f57018a = aVar;
        }

        @Override // d.a.p0.h2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f57018a.f57014i.u3(str);
        }

        @Override // d.a.p0.h2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f57018a.x();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f57019e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f57020f;

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
            this.f57020f = aVar;
            this.f57019e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57020f.f57012g.i();
                this.f57020f.f57010e = false;
                PbFragment pbFragment = this.f57020f.f57011f;
                if (pbFragment != null) {
                    if (pbFragment.Q4() != null) {
                        this.f57020f.f57011f.Q4().Y2(false);
                        d.a.p0.h2.k.e.i l0 = this.f57020f.f57011f.Q4().l0();
                        l0.a0(this.f57020f.f57011f.y().D0(), true);
                        l0.V();
                    }
                    a aVar = this.f57020f;
                    aVar.f57011f.J5(aVar.v);
                }
                Runnable runnable = this.f57019e;
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
        public final /* synthetic */ a f57021e;

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
            this.f57021e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57021e.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57022e;

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
            this.f57022e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57022e.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57023e;

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
            this.f57023e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57023e.p.G()) {
                return;
            }
            this.f57023e.p.H();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements PbFragment.r2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57024a;

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
            this.f57024a = aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.r2
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f57024a.h();
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
        public final /* synthetic */ a f57025e;

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
            this.f57025e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57025e.f57013h.g(false);
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
        this.s = new C1409a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.v = new h(this);
        MoreGodReplyModel moreGodReplyModel = new MoreGodReplyModel(pbFragment.getPageContext(), pbFragment.y());
        this.p = moreGodReplyModel;
        moreGodReplyModel.I(this.u);
        this.f57014i = t0Var;
        this.f57011f = pbFragment;
        this.f57012g = new d.a.p0.h2.k.d.d(pbFragment, viewStub);
        this.f57013h = new d.a.p0.h2.k.d.c(this);
    }

    @Override // d.a.o0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a053" : (String) invokeV.objValue;
    }

    @Override // d.a.o0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbFragment pbFragment = this.f57011f;
            if (pbFragment == null) {
                return null;
            }
            return pbFragment.getNextPageSourceKeyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.o0.k0.a
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

    @Override // d.a.o0.k0.a
    public d.a.o0.k0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (d.a.o0.k0.b) invokeV.objValue;
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
            this.f57011f.b5();
            if (!l() && runnable != null) {
                runnable.run();
                return;
            }
            if (l() && !this.f57013h.e()) {
                this.f57012g.r(new d(this, runnable));
            }
            if (this.r != 0) {
                d.a.o0.k0.d j = j();
                j.v(System.currentTimeMillis() - this.r);
                d.a.o0.k0.e.b().i(this.f57011f.getContext(), j, getPageStayFilter());
            }
        }
    }

    public d.a.o0.k0.d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.q == null) {
                d.a.o0.k0.d dVar = new d.a.o0.k0.d();
                this.q = dVar;
                dVar.u(getCurrentPageSourceKeyList());
                this.q.p(getCurrentPageKey());
                PbModel y = this.f57011f.y();
                if (y != null) {
                    this.q.q(d.a.c.e.m.b.f(y.getForumId(), 0L));
                    this.q.y(d.a.c.e.m.b.f(y.T0(), 0L));
                }
            }
            return this.q;
        }
        return (d.a.o0.k0.d) invokeV.objValue;
    }

    public d.a.p0.h2.k.d.d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57012g : (d.a.p0.h2.k.d.d) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f57010e : invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f57012g.o(i2);
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

    public void q(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, xVar) == null) {
            this.m = xVar;
        }
    }

    public void r(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onLongClickListener) == null) {
            this.n = onLongClickListener;
        }
    }

    public void s(d.a.p0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public final void t(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, bdTypeListView) == null) && this.j == null) {
            m mVar = new m(this.f57011f, PostData.u0);
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
            boolean m = this.f57012g.m();
            this.f57012g.p();
            if (!m) {
                this.f57012g.d().setOnClickListener(new e(this));
                this.f57012g.c().setOnClickListener(new f(this));
                this.f57012g.f().z(new g(this));
                this.f57012g.e().setOnScrollListener(this.t);
            }
            this.r = System.currentTimeMillis();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!l()) {
                this.f57011f.b5();
                this.f57010e = true;
                this.f57013h.h(false);
                this.f57013h.g(true);
                u();
                x();
                this.f57012g.q(new i(this));
                this.f57011f.U3(this.v);
                this.p.H();
            }
            this.f57011f.Q4().X0();
        }
    }

    public final void w(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.j.t(eVar);
            d.a.p0.h2.k.e.i l0 = this.f57014i.l0();
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
        d.a.p0.h2.h.e D0 = this.p.E().D0();
        this.f57012g.p();
        this.f57012g.e().setOnSrollToBottomListener(this.s);
        BdTypeListView e2 = this.f57012g.e();
        this.f57013h.d();
        t(e2);
        w(D0);
        e2.setData(new ArrayList(D));
        this.f57012g.g().setCenterTextTitle(String.format(this.f57011f.getResources().getString(R.string.more_god_reply_count), StringHelper.numFormatOver10000(D0.S().f56952b.size())));
        this.f57012g.b(this.p.F());
        if (e2.getAdapter2() instanceof d.a.c.k.e.e) {
            e2.getAdapter2().notifyDataSetChanged();
        }
    }
}
