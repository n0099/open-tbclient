package com.repackage;

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
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes7.dex */
public class s86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public b86 b;
    public String c;
    public ViewGroup d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public PbListView g;
    public bv4 h;
    public og6 i;
    public SmartBubbleAnimatedView j;
    public t86 k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public o88 p;
    public a86 q;
    public BdListView.p r;
    public RecyclerView.OnScrollListener s;
    public View.OnClickListener t;
    public bn4 u;
    public View.OnClickListener v;
    public PullLeftRefreshLayout.f w;

    /* loaded from: classes7.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s86 a;

        public a(s86 s86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s86Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                if (this.a.g == null || this.a.b == null) {
                    return;
                }
                if (oi.z()) {
                    this.a.f.setNextPage(this.a.g);
                    this.a.g.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.g.B(null);
                    if (this.a.o) {
                        this.a.g.N();
                        this.a.b.i();
                        return;
                    }
                    this.a.g.C(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e9));
                    this.a.g.f();
                    return;
                }
                this.a.f.setNextPage(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ s86 b;

        public b(s86 s86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s86Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.b.p != null) {
                    this.b.p.n(this.b.f.getFirstVisiblePosition(), this.b.f.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.b.k())));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s86 a;

        public c(s86 s86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                if (this.a.g == null || this.a.b == null || !oi.z()) {
                    return;
                }
                this.a.g.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.g.B(null);
                if (this.a.o) {
                    this.a.g.N();
                    this.a.b.i();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements bn4<uq4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s86 a;

        public d(s86 s86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s86Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bn4
        /* renamed from: a */
        public void d(View view2, uq4 uq4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uq4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) || uq4Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13642");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", uq4Var.j());
            if (this.a.n.l != 0) {
                if (this.a.n.l == 1) {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.a.c);
                }
            } else {
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.a.n.n ? 3 : 1);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bn4
        /* renamed from: b */
        public void c(View view2, uq4 uq4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, uq4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (uq4Var == null) {
                    k66.b(this.a.a.getPageContext(), this.a.c);
                    if (this.a.n == null) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13645");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_type", this.a.n.n ? 5 : 1);
                    statisticItem.param("obj_source", 5);
                    TiebaStatic.log(statisticItem);
                } else if (uq4Var == null || this.a.a == null) {
                } else {
                    String l = uq4Var.l();
                    if (pi.isForumName(l)) {
                        this.a.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getFragmentActivity()).createNormalCfg(l, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                        if (this.a.n == null) {
                            return;
                        }
                        StatisticItem statisticItem2 = new StatisticItem("c13643");
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("fid", uq4Var.j());
                        if (this.a.n.l != 0) {
                            if (this.a.n.l == 1) {
                                statisticItem2.param("obj_locate", 2);
                                statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.a.c);
                            }
                        } else {
                            statisticItem2.param("obj_locate", 1);
                            statisticItem2.param("obj_type", this.a.n.n ? 4 : 1);
                        }
                        TiebaStatic.log(statisticItem2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s86 a;

        public e(s86 s86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                k66.b(this.a.a.getPageContext(), this.a.c);
                if (this.a.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.a.n.n ? 5 : 1);
                statisticItem.param("obj_source", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s86 a;

        public f(s86 s86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s86Var;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k66.b(this.a.a.getPageContext(), this.a.c);
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.a.n.n ? 5 : 1);
                statisticItem.param("obj_source", 4);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s86 a;

        public g(s86 s86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s86Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view2 = viewHolder.itemView) == null || this.a.p == null) {
                return;
            }
            this.a.p.k(view2);
        }
    }

    public s86(EnterForumTabFeedFragment enterForumTabFeedFragment, b86 b86Var, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, b86Var, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.w = new f(this);
        this.a = enterForumTabFeedFragment;
        this.b = b86Var;
        this.c = str;
        i(viewGroup);
        this.q = new a86(enterForumTabFeedFragment, this.f);
        q(false);
    }

    public final void i(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            this.d = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091fc0);
            this.f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.setOnSrollToBottomListener(this.r);
            this.f.addOnScrollListener(this.s);
            bv4 bv4Var = new bv4(this.a.getPageContext());
            this.h = bv4Var;
            bv4Var.f(this.b);
            this.f.setRecyclerListener(new g(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.g = pbListView;
            pbListView.b();
            this.g.p(R.color.CAM_X0205);
            this.g.t(qi.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.g.x();
            this.g.G(R.dimen.tbfontsize33);
            this.g.E(SkinManager.getColor(R.color.CAM_X0107));
            this.g.A(R.color.CAM_X0110);
            this.g.s();
            this.g.B(this.t);
            if (this.e == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091fbf);
                this.e = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.h);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
                marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + qi.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds219);
                this.e.setLayoutParams(marginLayoutParams);
            }
            this.i = new og6();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.a.getContext());
            this.j = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, qi.f(this.a.getContext(), R.dimen.tbds83)));
            if (this.p == null) {
                o88 o88Var = new o88(this.a.getPageContext(), this.f);
                this.p = o88Var;
                o88Var.p(2);
                this.p.u(this.a.getUniqueId());
            }
            t86 t86Var = new t86(this.a.getPageContext());
            this.k = t86Var;
            t86Var.g(this.c);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m == null) {
            TextView textView = new TextView(this.a.getContext());
            this.m = textView;
            textView.setPadding(qi.f(this.a.getContext(), R.dimen.tbds44), qi.f(this.a.getContext(), R.dimen.tbds60), 0, qi.f(this.a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.obfuscated_res_0x7f0f1347);
            this.m.setTextSize(0, qi.f(this.a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f.removeHeaderView(this.m);
            this.f.t(this.m, 0);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            bv4 bv4Var = this.h;
            if (bv4Var != null) {
                bv4Var.H(i);
            }
            PbListView pbListView = this.g;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.g.d(i);
            }
            a86 a86Var = this.q;
            if (a86Var != null) {
                a86Var.b();
            }
            TextView textView = this.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            t86 t86Var = this.k;
            if (t86Var != null) {
                t86Var.e();
            }
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                recommendForumLayout.c();
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.e(i);
            }
        }
    }

    public void m(q86 q86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, q86Var) == null) {
            if (q86Var != null) {
                this.o = q86Var.c;
            }
            q(false);
            if (q86Var == null || this.q == null || this.f == null || this.g == null) {
                return;
            }
            j();
            u(q86Var);
            v(q86Var);
            if (q86Var.e > 0) {
                int firstVisiblePosition = this.f.getFirstVisiblePosition();
                View childAt = this.f.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f.getLayoutManager();
                int i = firstVisiblePosition - q86Var.e;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.f.A();
                }
                q86Var.e = 0;
            }
            this.q.d(q86Var.d);
            this.q.c(q86Var.b);
            this.q.b();
            if (q86Var.h) {
                s(q86Var.f);
            }
            o88 o88Var = this.p;
            if (o88Var != null) {
                o88Var.n(this.f.getFirstVisiblePosition(), this.f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void n() {
        o88 o88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (o88Var = this.p) == null) {
            return;
        }
        o88Var.y();
        this.p.r(false);
    }

    public void o(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) || (bdTypeRecyclerView = this.f) == null || i >= i2) {
            return;
        }
        bdTypeRecyclerView.E(i, i2);
    }

    public void p() {
        o88 o88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (o88Var = this.p) == null) {
            return;
        }
        o88Var.r(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f;
        if (bdTypeRecyclerView != null) {
            this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f.getLastVisiblePosition(), false, true);
        }
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdSwipeRefreshLayout = this.e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public final void s(int i) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i < 0) {
            return;
        }
        this.i.f();
        if (i > 0) {
            string = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa4), Integer.valueOf(i));
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa3);
        }
        if (TextUtils.isEmpty(string) || !oi.z()) {
            return;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
        smartBubbleAnimatedView.a = string;
        smartBubbleAnimatedView.b = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + qi.f(this.a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.removeView(this.j);
            this.d.addView(this.j, layoutParams);
            this.j.g();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bdTypeRecyclerView = this.f) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public final void u(q86 q86Var) {
        List<ShortUserInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, q86Var) == null) {
            r86 r86Var = q86Var.g;
            if (r86Var != null && (list = r86Var.a) != null && list.size() > 0 && !TextUtils.isEmpty(q86Var.g.b)) {
                this.k.f(q86Var.g);
                if (this.k.d().getParent() != null || this.l) {
                    return;
                }
                this.l = true;
                this.f.t(this.k.d(), 0);
                StatisticItem statisticItem = new StatisticItem("c13656");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.c);
                TiebaStatic.log(statisticItem);
                return;
            }
            this.l = false;
            this.f.removeHeaderView(this.k.d());
        }
    }

    public final void v(q86 q86Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, q86Var) == null) || q86Var == null || this.f == null || this.a == null || !q86Var.h) {
            return;
        }
        vq4 vq4Var = q86Var.a;
        if (!((vq4Var == null || ListUtils.isEmpty(vq4Var.h())) ? false : true)) {
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                this.f.removeHeaderView(recommendForumLayout);
                return;
            }
            return;
        }
        if (this.n == null) {
            RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.a.getPageContext());
            this.n = recommendForumLayout2;
            recommendForumLayout2.setShowMore(true);
            this.n.setSquareEntranceAtStart(true);
            this.n.setTabName(this.c);
            this.n.setFrom(1);
        }
        this.n.setOnClickRightArrowListener(this.v);
        this.n.setOnRullOkCallbackr(this.w);
        this.n.setOnItemCoverListener(this.u);
        this.n.a(q86Var.a);
        this.f.removeHeaderView(this.n);
        this.f.t(this.n, 0);
        StatisticItem statisticItem = new StatisticItem("c13641");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 2);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.c);
        TiebaStatic.log(statisticItem);
    }
}
