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
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes7.dex */
public class wx6 extends eo<gy5, ThreadCardViewHolder<gy5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public zy6 k;
    public String l;
    public xo m;
    public NEGFeedBackView.b n;
    public ux5<gy5> o;

    /* loaded from: classes7.dex */
    public class a extends ux5<gy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wx6 b;

        public a(wx6 wx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, gy5 gy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gy5Var) == null) {
                nx5.b().d(true);
                gj5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.k == null || gy5Var == null || gy5Var.getThreadData() == null || StringUtils.isNull(gy5Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !cx6.b(kg.g(gy5Var.getThreadData().getTid(), 0L))) {
                    cx6.a(kg.g(gy5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(kg.g(gy5Var.getThreadData().getTid(), 0L), gy5Var.D(), gy5Var.r(), gy5Var.q(), gy5Var.e(), kg.e((String) view2.getTag(), 1), "homepage", gy5Var.getThreadData().getBaijiahaoData());
                }
                this.b.f0(view2, gy5Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wx6 a;

        public b(wx6 wx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wx6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof gy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                gy5 gy5Var = (gy5) roVar;
                gy5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), gy5Var);
                }
                ThreadCardUtils.jumpToPB((zn4) gy5Var, view2.getContext(), 2, false, dy.a((xo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ gy5 d;

        public c(wx6 wx6Var, ViewGroup viewGroup, View view2, int i, gy5 gy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wx6Var, viewGroup, view2, Integer.valueOf(i), gy5Var};
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
            this.d = gy5Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(dy.a((xo) this.a, this.b, this.c));
                if (this.d.getThreadData() == null || this.d.getThreadData().getSmartApp() == null) {
                    return;
                }
                StatisticItem s = this.d.s(gy5.j0);
                s.param("obj_type", this.d.getThreadData().getSmartApp().id);
                s.param("obj_name", this.d.getThreadData().getSmartApp().name);
                TiebaStatic.log(s);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            gy5.S = "c10730";
            gy5.T = "c10731";
            gy5.U = "c10704";
            gy5.V = "c10755";
            gy5.W = "c10710";
            gy5.X = "c10736";
            gy5.Y = "c10737";
            gy5.Z = "c10711";
            gy5.g0 = "c10758";
            gy5.h0 = "c10757";
            gy5.k0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity(), false);
            mz mzVar = new mz(this.j.getPageActivity());
            fo4 fo4Var = new fo4();
            fo4Var.b = 1;
            fo4Var.h = 1;
            mzVar.v(fo4Var);
            mzVar.x(1);
            mzVar.D("personalize_page");
            mzVar.C(3);
            mzVar.y(2);
            mzVar.b(32);
            mzVar.w(false);
            bVar.m(mzVar);
            kz k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.m);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, gy5 gy5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gy5Var, threadCardViewHolder})) == null) {
            if (gy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || gy5Var.a == null) {
                return null;
            }
            gy5Var.I(gy5Var.position + 1);
            gy5Var.a.statFloor = gy5Var.q();
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.l);
            if (threadCardViewHolder.c().f() instanceof mz) {
                ((mz) threadCardViewHolder.c().f()).B(new c(this, viewGroup, view2, i, gy5Var));
            }
            threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM, this.n);
            threadCardViewHolder.g(gy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.o);
            nx5.b().a(gy5Var.B());
            gj5.c().a(gy5Var.B());
            fz6.h(gy5Var.a, this.i, gy5Var.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(View view2, gy5 gy5Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, view2, gy5Var) != null) {
            return;
        }
        int id = view2.getId();
        int i = 5;
        if (view2.getId() == R.id.obfuscated_res_0x7f091fe0 || id == R.id.obfuscated_res_0x7f091ff4) {
            if (hy5.R(gy5Var.a)) {
                A = gy5Var.C();
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
            } else {
                A = gy5Var.A();
                TiebaStatic.log(A);
            }
            gj5.c().i("page_recommend", "clk_", A);
            fz6.c(gy5Var.a, gy5Var.r(), gy5Var.q(), 1);
        } else if (id == R.id.obfuscated_res_0x7f091fe2) {
            TiebaStatic.log(gy5Var.T());
            gj5.c().i("page_recommend", "clk_", gy5Var.T());
        } else {
            if (id == R.id.obfuscated_res_0x7f0922d3) {
                TiebaStatic.log(gy5Var.S());
                gj5.c().i("page_recommend", "clk_", gy5Var.S());
            } else if (id != R.id.obfuscated_res_0x7f0922f3) {
                if (id == R.id.obfuscated_res_0x7f090a5f) {
                    TiebaStatic.log(gy5Var.k());
                    gj5.c().i("page_recommend", "clk_", gy5Var.k());
                    i = 9;
                } else if (id == R.id.obfuscated_res_0x7f090cc7) {
                    StatisticItem statisticItem = new StatisticItem("c10760");
                    statisticItem.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090cc2) {
                    StatisticItem statisticItem2 = new StatisticItem("c10760");
                    statisticItem2.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem2);
                    fz6.c(gy5Var.a, gy5Var.r(), gy5Var.q(), 1);
                } else if (id == R.id.obfuscated_res_0x7f090cc5 || id == R.id.obfuscated_res_0x7f090cc6) {
                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                } else {
                    i = 0;
                }
                if (i != 0) {
                    fz6.d(gy5Var.a, this.i, gy5Var.q(), i);
                    return;
                }
                return;
            } else {
                TiebaStatic.log(gy5Var.S());
                gj5.c().i("page_recommend", "clk_", gy5Var.S());
            }
            i = 2;
            if (i != 0) {
            }
        }
        i = 1;
        if (i != 0) {
        }
    }

    @Override // com.repackage.ij5
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

    public void h0(zy6 zy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zy6Var) == null) {
            this.k = zy6Var;
        }
    }

    public void i0(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, xoVar) == null) {
            this.m = xoVar;
        }
    }
}
