package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dy;
import com.repackage.oy;
/* loaded from: classes7.dex */
public class sz6 extends bn<n06, ThreadCardViewHolder<n06>> implements pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public v07 c;
    public String d;
    public un e;
    public NEGFeedBackView.b f;
    public b06<n06> g;

    /* loaded from: classes7.dex */
    public class a extends b06<n06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz6 b;

        public a(sz6 sz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, n06 n06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, n06Var) == null) {
                uz5.b().d(true);
                nl5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.c == null || n06Var == null || n06Var.getThreadData() == null || StringUtils.isNull(n06Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !yy6.b(og.g(n06Var.getThreadData().getTid(), 0L))) {
                    yy6.a(og.g(n06Var.getThreadData().getTid(), 0L));
                    this.b.c.e(og.g(n06Var.getThreadData().getTid(), 0L), n06Var.D(), n06Var.r(), n06Var.n(), n06Var.c(), og.e((String) view2.getTag(), 1), "homepage", n06Var.getThreadData().getBaijiahaoData());
                }
                this.b.y(view2, n06Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz6 a;

        public b(sz6 sz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof n06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                n06 n06Var = (n06) onVar;
                n06Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), n06Var);
                }
                ThreadCardUtils.jumpToPB((fo4) n06Var, view2.getContext(), 2, false, vw.a((un) viewGroup, view2, i));
                threadCardViewHolder.a().o(new oy.a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ n06 d;

        public c(sz6 sz6Var, ViewGroup viewGroup, View view2, int i, n06 n06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var, viewGroup, view2, Integer.valueOf(i), n06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
            this.d = n06Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.k
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(vw.a((un) this.a, this.b, this.c));
                if (this.d.getThreadData() == null || this.d.getThreadData().getSmartApp() == null) {
                    return;
                }
                StatisticItem s = this.d.s(n06.d0);
                s.param("obj_type", this.d.getThreadData().getSmartApp().id);
                s.param("obj_name", this.d.getThreadData().getSmartApp().name);
                TiebaStatic.log(s);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.b = tbPageContext;
        v();
    }

    public void A(v07 v07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v07Var) == null) {
            this.c = v07Var;
        }
    }

    public void B(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unVar) == null) {
            this.e = unVar;
        }
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.d = str;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            n06.S = "c10730";
            n06.T = "c10731";
            n06.U = "c10704";
            n06.V = "c10755";
            n06.W = "c10710";
            n06.X = "c10736";
            n06.Y = "c10737";
            n06.Z = "c10711";
            n06.a0 = "c10758";
            n06.b0 = "c10757";
            n06.e0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: w */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity(), false);
            fy fyVar = new fy(this.b.getPageActivity());
            lo4 lo4Var = new lo4();
            lo4Var.b = 1;
            lo4Var.h = 1;
            fyVar.w(lo4Var);
            fyVar.y(1);
            fyVar.E("personalize_page");
            fyVar.D(3);
            fyVar.z(2);
            fyVar.c(32);
            fyVar.x(false);
            bVar.m(fyVar);
            dy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.e);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n06 n06Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n06Var, threadCardViewHolder})) == null) {
            if (n06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || n06Var.a == null) {
                return null;
            }
            n06Var.I(n06Var.position + 1);
            n06Var.a.statFloor = n06Var.n();
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.a().b(this.d);
            if (threadCardViewHolder.a().f() instanceof fy) {
                ((fy) threadCardViewHolder.a().f()).C(new c(this, viewGroup, view2, i, n06Var));
            }
            threadCardViewHolder.p(false, Align.ALIGN_RIGHT_BOTTOM, this.f);
            threadCardViewHolder.e(n06Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.g);
            uz5.b().a(n06Var.B());
            nl5.c().a(n06Var.B());
            c17.i(n06Var.a, this.a, n06Var.n());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y(View view2, n06 n06Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, n06Var) != null) {
            return;
        }
        int id = view2.getId();
        int i = 5;
        if (view2.getId() == R.id.obfuscated_res_0x7f09212a || id == R.id.obfuscated_res_0x7f09213e) {
            if (o06.R(n06Var.a)) {
                A = n06Var.C();
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
            } else {
                A = n06Var.A();
                TiebaStatic.log(A);
            }
            nl5.c().i("page_recommend", "clk_", A);
            c17.c(n06Var.a, n06Var.r(), n06Var.n(), 1);
        } else if (id == R.id.obfuscated_res_0x7f09212c) {
            TiebaStatic.log(n06Var.T());
            nl5.c().i("page_recommend", "clk_", n06Var.T());
        } else {
            if (id == R.id.obfuscated_res_0x7f092421) {
                TiebaStatic.log(n06Var.S());
                nl5.c().i("page_recommend", "clk_", n06Var.S());
            } else if (id != R.id.obfuscated_res_0x7f09244f) {
                if (id == R.id.obfuscated_res_0x7f090a74) {
                    TiebaStatic.log(n06Var.j());
                    nl5.c().i("page_recommend", "clk_", n06Var.j());
                    i = 9;
                } else if (id == R.id.obfuscated_res_0x7f090cbe) {
                    StatisticItem statisticItem = new StatisticItem("c10760");
                    statisticItem.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090cb9) {
                    StatisticItem statisticItem2 = new StatisticItem("c10760");
                    statisticItem2.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem2);
                    c17.c(n06Var.a, n06Var.r(), n06Var.n(), 1);
                } else if (id == R.id.obfuscated_res_0x7f090cbc || id == R.id.obfuscated_res_0x7f090cbd) {
                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                } else {
                    i = 0;
                }
                if (i != 0) {
                    c17.d(n06Var.a, this.a, n06Var.n(), i);
                    return;
                }
                return;
            } else {
                TiebaStatic.log(n06Var.S());
                nl5.c().i("page_recommend", "clk_", n06Var.S());
            }
            i = 2;
            if (i != 0) {
            }
        }
        i = 1;
        if (i != 0) {
        }
    }

    public void z(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.f = bVar;
        }
    }
}
