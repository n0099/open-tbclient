package d.a.s0.l0.l.e;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.r.q.o1;
import d.a.r0.r.q.p1;
import d.a.s0.n2.i;
import d.a.s0.u0.c1;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f63030a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.l0.l.b f63031b;

    /* renamed from: c  reason: collision with root package name */
    public String f63032c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f63033d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f63034e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f63035f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f63036g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.r0.r.f0.g f63037h;

    /* renamed from: i  reason: collision with root package name */
    public c1 f63038i;
    public SmartBubbleAnimatedView j;
    public d.a.s0.l0.l.e.b k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public i p;
    public d.a.s0.l0.l.a q;
    public BdListView.p r;
    public RecyclerView.OnScrollListener s;
    public View.OnClickListener t;
    public d.a.r0.m.f u;
    public View.OnClickListener v;
    public PullLeftRefreshLayout.f w;

    /* renamed from: d.a.s0.l0.l.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1572a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63039e;

        public C1572a(a aVar) {
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
            this.f63039e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f63039e.f63035f != null) {
                    this.f63039e.f63035f.stopScroll();
                }
                if (this.f63039e.f63036g == null || this.f63039e.f63031b == null) {
                    return;
                }
                if (j.z()) {
                    this.f63039e.f63035f.setNextPage(this.f63039e.f63036g);
                    this.f63039e.f63036g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.f63039e.f63036g.z(null);
                    if (this.f63039e.o) {
                        this.f63039e.f63036g.L();
                        this.f63039e.f63031b.j();
                        return;
                    }
                    this.f63039e.f63036g.A(this.f63039e.f63030a.getResources().getString(R.string.list_has_no_more));
                    this.f63039e.f63036g.f();
                    return;
                }
                this.f63039e.f63035f.setNextPage(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f63040a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f63041b;

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
            this.f63041b = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f63041b.p != null) {
                    this.f63041b.p.n(this.f63041b.f63035f.getFirstVisiblePosition(), this.f63041b.f63035f.getLastVisiblePosition(), this.f63040a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f63041b.k())));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.f63040a = false;
                } else {
                    this.f63040a = true;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63042e;

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
            this.f63042e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f63042e.f63035f != null) {
                    this.f63042e.f63035f.stopScroll();
                }
                if (this.f63042e.f63036g == null || this.f63042e.f63031b == null || !j.z()) {
                    return;
                }
                this.f63042e.f63036g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f63042e.f63036g.z(null);
                if (this.f63042e.o) {
                    this.f63042e.f63036g.L();
                    this.f63042e.f63031b.j();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements d.a.r0.m.f<o1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63043e;

        public d(a aVar) {
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
            this.f63043e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.m.f
        /* renamed from: b */
        public void c(View view, o1 o1Var, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, o1Var, Integer.valueOf(i2), Long.valueOf(j)}) == null) || o1Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13642");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", o1Var.h());
            if (this.f63043e.n.p != 0) {
                if (this.f63043e.n.p == 1) {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f63043e.f63032c);
                }
            } else {
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.f63043e.n.r ? 3 : 1);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.m.f
        /* renamed from: d */
        public void a(View view, o1 o1Var, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, o1Var, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (o1Var == null) {
                    d.a.s0.l0.b.a(this.f63043e.f63030a.getPageContext(), this.f63043e.f63032c);
                    if (this.f63043e.n == null) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13645");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_type", this.f63043e.n.r ? 5 : 1);
                    statisticItem.param("obj_source", 5);
                    TiebaStatic.log(statisticItem);
                } else if (o1Var == null || this.f63043e.f63030a == null) {
                } else {
                    String j2 = o1Var.j();
                    if (k.isForumName(j2)) {
                        this.f63043e.f63030a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63043e.f63030a.getFragmentActivity()).createNormalCfg(j2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.f63043e.n == null) {
                            return;
                        }
                        StatisticItem statisticItem2 = new StatisticItem("c13643");
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("fid", o1Var.h());
                        if (this.f63043e.n.p != 0) {
                            if (this.f63043e.n.p == 1) {
                                statisticItem2.param("obj_locate", 2);
                                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.f63043e.f63032c);
                            }
                        } else {
                            statisticItem2.param("obj_locate", 1);
                            statisticItem2.param("obj_type", this.f63043e.n.r ? 4 : 1);
                        }
                        TiebaStatic.log(statisticItem2);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63044e;

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
            this.f63044e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.s0.l0.b.a(this.f63044e.f63030a.getPageContext(), this.f63044e.f63032c);
                if (this.f63044e.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.f63044e.n.r ? 5 : 1);
                statisticItem.param("obj_source", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63045a;

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
            this.f63045a = aVar;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.s0.l0.b.a(this.f63045a.f63030a.getPageContext(), this.f63045a.f63032c);
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.f63045a.n.r ? 5 : 1);
                statisticItem.param("obj_source", 4);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63046a;

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
            this.f63046a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f63046a.p == null) {
                return;
            }
            this.f63046a.p.k(view);
        }
    }

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, d.a.s0.l0.l.b bVar, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, bVar, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new C1572a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.w = new f(this);
        this.f63030a = enterForumTabFeedFragment;
        this.f63031b = bVar;
        this.f63032c = str;
        i(viewGroup);
        this.q = new d.a.s0.l0.l.a(enterForumTabFeedFragment, this.f63035f);
        q(false);
    }

    public final void i(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            this.f63033d = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f63035f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f63030a.getContext()));
            this.f63035f.setFadingEdgeLength(0);
            this.f63035f.setOverScrollMode(2);
            this.f63035f.setOnSrollToBottomListener(this.r);
            this.f63035f.addOnScrollListener(this.s);
            d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(this.f63030a.getPageContext());
            this.f63037h = gVar;
            gVar.a(this.f63031b);
            this.f63035f.setRecyclerListener(new g(this));
            PbListView pbListView = new PbListView(this.f63030a.getPageContext().getPageActivity());
            this.f63036g = pbListView;
            pbListView.b();
            this.f63036g.o(R.color.CAM_X0205);
            this.f63036g.r(l.g(this.f63030a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f63036g.v();
            this.f63036g.E(R.dimen.tbfontsize33);
            this.f63036g.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f63036g.y(R.color.CAM_X0110);
            this.f63036g.q();
            this.f63036g.z(this.t);
            if (this.f63034e == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f63034e = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f63037h);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f63034e.getLayoutParams();
                marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f63030a.getPageContext().getPageActivity(), R.dimen.tbds219);
                this.f63034e.setLayoutParams(marginLayoutParams);
            }
            this.f63038i = new c1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f63030a.getContext());
            this.j = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f63030a.getContext(), R.dimen.tbds83)));
            if (this.p == null) {
                i iVar = new i(this.f63030a.getPageContext(), this.f63035f);
                this.p = iVar;
                iVar.p(1);
                this.p.t(this.f63030a.getUniqueId());
            }
            d.a.s0.l0.l.e.b bVar = new d.a.s0.l0.l.e.b(this.f63030a.getPageContext());
            this.k = bVar;
            bVar.g(this.f63032c);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m == null) {
            TextView textView = new TextView(this.f63030a.getContext());
            this.m = textView;
            textView.setPadding(l.g(this.f63030a.getContext(), R.dimen.tbds44), l.g(this.f63030a.getContext(), R.dimen.tbds60), 0, l.g(this.f63030a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.tab_feed_title);
            this.m.setTextSize(0, l.g(this.f63030a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f63035f.removeHeaderView(this.m);
            this.f63035f.t(this.m, 0);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f63035f;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f63035f.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            d.a.r0.r.f0.g gVar = this.f63037h;
            if (gVar != null) {
                gVar.I(i2);
            }
            PbListView pbListView = this.f63036g;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f63036g.d(i2);
            }
            d.a.s0.l0.l.a aVar = this.q;
            if (aVar != null) {
                aVar.b();
            }
            TextView textView = this.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            d.a.s0.l0.l.e.b bVar = this.k;
            if (bVar != null) {
                bVar.e();
            }
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                recommendForumLayout.c();
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.e(i2);
            }
        }
    }

    public void m(d.a.s0.l0.l.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            if (bVar != null) {
                this.o = bVar.f63021c;
            }
            q(false);
            if (bVar == null || this.q == null || this.f63035f == null || this.f63036g == null) {
                return;
            }
            j();
            u(bVar);
            v(bVar);
            if (bVar.f63023e > 0) {
                int firstVisiblePosition = this.f63035f.getFirstVisiblePosition();
                View childAt = this.f63035f.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f63035f.getLayoutManager();
                int i2 = firstVisiblePosition - bVar.f63023e;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f63035f.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f63035f.A();
                }
                bVar.f63023e = 0;
            }
            this.q.d(bVar.f63022d);
            this.q.c(bVar.f63020b);
            this.q.b();
            if (bVar.f63026h) {
                s(bVar.f63024f);
            }
            i iVar = this.p;
            if (iVar != null) {
                iVar.n(this.f63035f.getFirstVisiblePosition(), this.f63035f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void n() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.x();
        this.p.q(false);
    }

    public void o(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || (bdTypeRecyclerView = this.f63035f) == null || i2 >= i3) {
            return;
        }
        bdTypeRecyclerView.E(i2, i3);
    }

    public void p() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.q(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f63035f;
        if (bdTypeRecyclerView != null) {
            this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f63035f.getLastVisiblePosition(), false, true);
        }
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdSwipeRefreshLayout = this.f63034e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f63034e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public final void s(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 < 0) {
            return;
        }
        this.f63038i.f();
        if (i2 > 0) {
            string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
        }
        if (TextUtils.isEmpty(string) || !j.z()) {
            return;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
        smartBubbleAnimatedView.f15411e = string;
        smartBubbleAnimatedView.f15412f = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f63030a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.f63033d;
        if (viewGroup != null) {
            viewGroup.removeView(this.j);
            this.f63033d.addView(this.j, layoutParams);
            this.j.g();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bdTypeRecyclerView = this.f63035f) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public final void u(d.a.s0.l0.l.d.b bVar) {
        List<ShortUserInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            d.a.s0.l0.l.d.c cVar = bVar.f63025g;
            if (cVar != null && (list = cVar.f63027a) != null && list.size() > 0 && !TextUtils.isEmpty(bVar.f63025g.f63028b)) {
                this.k.f(bVar.f63025g);
                if (this.k.d().getParent() != null || this.l) {
                    return;
                }
                this.l = true;
                this.f63035f.t(this.k.d(), 0);
                StatisticItem statisticItem = new StatisticItem("c13656");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f63032c);
                TiebaStatic.log(statisticItem);
                return;
            }
            this.l = false;
            this.f63035f.removeHeaderView(this.k.d());
        }
    }

    public final void v(d.a.s0.l0.l.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) || bVar == null || this.f63035f == null || this.f63030a == null || !bVar.f63026h) {
            return;
        }
        p1 p1Var = bVar.f63019a;
        if (!((p1Var == null || ListUtils.isEmpty(p1Var.e())) ? false : true)) {
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                this.f63035f.removeHeaderView(recommendForumLayout);
                return;
            }
            return;
        }
        if (this.n == null) {
            RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.f63030a.getPageContext());
            this.n = recommendForumLayout2;
            recommendForumLayout2.setShowMore(true);
            this.n.setSquareEntranceAtStart(true);
            this.n.setTabName(this.f63032c);
            this.n.setFrom(1);
        }
        this.n.setOnClickRightArrowListener(this.v);
        this.n.setOnRullOkCallbackr(this.w);
        this.n.setOnItemCoverListener(this.u);
        this.n.a(bVar.f63019a);
        this.f63035f.removeHeaderView(this.n);
        this.f63035f.t(this.n, 0);
        StatisticItem statisticItem = new StatisticItem("c13641");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 2);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f63032c);
        TiebaStatic.log(statisticItem);
    }
}
