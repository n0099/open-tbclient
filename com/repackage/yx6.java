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
import com.repackage.cy;
import com.repackage.ny;
/* loaded from: classes7.dex */
public class yx6 extends an<vy5, ThreadCardViewHolder<vy5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public bz6 k;
    public String l;
    public tn m;
    public NEGFeedBackView.b n;
    public jy5<vy5> o;

    /* loaded from: classes7.dex */
    public class a extends jy5<vy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx6 b;

        public a(yx6 yx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, vy5 vy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, vy5Var) == null) {
                cy5.b().d(true);
                ak5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.k == null || vy5Var == null || vy5Var.getThreadData() == null || StringUtils.isNull(vy5Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !ex6.b(ng.g(vy5Var.getThreadData().getTid(), 0L))) {
                    ex6.a(ng.g(vy5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(ng.g(vy5Var.getThreadData().getTid(), 0L), vy5Var.D(), vy5Var.o(), vy5Var.m(), vy5Var.c(), ng.e((String) view2.getTag(), 1), "homepage", vy5Var.getThreadData().getBaijiahaoData());
                }
                this.b.f0(view2, vy5Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx6 a;

        public b(yx6 yx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof vy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                vy5 vy5Var = (vy5) nnVar;
                vy5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), vy5Var);
                }
                ThreadCardUtils.jumpToPB((nn4) vy5Var, view2.getContext(), 2, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new ny.a(1));
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
        public final /* synthetic */ vy5 d;

        public c(yx6 yx6Var, ViewGroup viewGroup, View view2, int i, vy5 vy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx6Var, viewGroup, view2, Integer.valueOf(i), vy5Var};
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
            this.d = vy5Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.k
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(uw.a((tn) this.a, this.b, this.c));
                if (this.d.getThreadData() == null || this.d.getThreadData().getSmartApp() == null) {
                    return;
                }
                StatisticItem s = this.d.s(vy5.j0);
                s.param("obj_type", this.d.getThreadData().getSmartApp().id);
                s.param("obj_name", this.d.getThreadData().getSmartApp().name);
                TiebaStatic.log(s);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.o = new a(this);
        this.j = tbPageContext;
        c0();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            vy5.S = "c10730";
            vy5.T = "c10731";
            vy5.U = "c10704";
            vy5.V = "c10755";
            vy5.W = "c10710";
            vy5.X = "c10736";
            vy5.Y = "c10737";
            vy5.Z = "c10711";
            vy5.g0 = "c10758";
            vy5.h0 = "c10757";
            vy5.k0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity(), false);
            ey eyVar = new ey(this.j.getPageActivity());
            tn4 tn4Var = new tn4();
            tn4Var.b = 1;
            tn4Var.h = 1;
            eyVar.w(tn4Var);
            eyVar.y(1);
            eyVar.E("personalize_page");
            eyVar.D(3);
            eyVar.z(2);
            eyVar.c(32);
            eyVar.x(false);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.m);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, vy5 vy5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vy5Var, threadCardViewHolder})) == null) {
            if (vy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || vy5Var.a == null) {
                return null;
            }
            vy5Var.I(vy5Var.position + 1);
            vy5Var.a.statFloor = vy5Var.m();
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.l);
            if (threadCardViewHolder.c().f() instanceof ey) {
                ((ey) threadCardViewHolder.c().f()).C(new c(this, viewGroup, view2, i, vy5Var));
            }
            threadCardViewHolder.r(false, Align.ALIGN_RIGHT_BOTTOM, this.n);
            threadCardViewHolder.g(vy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.o);
            cy5.b().a(vy5Var.B());
            ak5.c().a(vy5Var.B());
            iz6.i(vy5Var.a, this.i, vy5Var.m());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(View view2, vy5 vy5Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, view2, vy5Var) != null) {
            return;
        }
        int id = view2.getId();
        int i = 5;
        if (view2.getId() == R.id.obfuscated_res_0x7f09202a || id == R.id.obfuscated_res_0x7f09203e) {
            if (wy5.R(vy5Var.a)) {
                A = vy5Var.C();
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
            } else {
                A = vy5Var.A();
                TiebaStatic.log(A);
            }
            ak5.c().i("page_recommend", "clk_", A);
            iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 1);
        } else if (id == R.id.obfuscated_res_0x7f09202c) {
            TiebaStatic.log(vy5Var.T());
            ak5.c().i("page_recommend", "clk_", vy5Var.T());
        } else {
            if (id == R.id.obfuscated_res_0x7f09230c) {
                TiebaStatic.log(vy5Var.S());
                ak5.c().i("page_recommend", "clk_", vy5Var.S());
            } else if (id != R.id.obfuscated_res_0x7f09232d) {
                if (id == R.id.obfuscated_res_0x7f090a40) {
                    TiebaStatic.log(vy5Var.i());
                    ak5.c().i("page_recommend", "clk_", vy5Var.i());
                    i = 9;
                } else if (id == R.id.obfuscated_res_0x7f090c84) {
                    StatisticItem statisticItem = new StatisticItem("c10760");
                    statisticItem.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090c7f) {
                    StatisticItem statisticItem2 = new StatisticItem("c10760");
                    statisticItem2.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem2);
                    iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 1);
                } else if (id == R.id.obfuscated_res_0x7f090c82 || id == R.id.obfuscated_res_0x7f090c83) {
                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                } else {
                    i = 0;
                }
                if (i != 0) {
                    iz6.d(vy5Var.a, this.i, vy5Var.m(), i);
                    return;
                }
                return;
            } else {
                TiebaStatic.log(vy5Var.S());
                ak5.c().i("page_recommend", "clk_", vy5Var.S());
            }
            i = 2;
            if (i != 0) {
            }
        }
        i = 1;
        if (i != 0) {
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
        }
    }

    public void g0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void h0(bz6 bz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bz6Var) == null) {
            this.k = bz6Var;
        }
    }

    public void i0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tnVar) == null) {
            this.m = tnVar;
        }
    }
}
