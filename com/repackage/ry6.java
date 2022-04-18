package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b00;
import com.repackage.m00;
import com.repackage.ty;
/* loaded from: classes7.dex */
public class ry6 extends tt6<fy5, ThreadCardViewHolder<fy5>> implements qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public NEGFeedBackView.b l;
    public zz6 m;
    public String n;
    public boolean o;
    public dg<ConstrainImageLayout> p;
    public dg<TbImageView> q;
    public tx5<fy5> r;

    /* loaded from: classes7.dex */
    public class a implements eg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 a;

        public a(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.k.getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements eg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 a;

        public b(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.k.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends tx5<fy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 b;

        public c(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ry6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tx5
        /* renamed from: d */
        public void a(View view2, fy5 fy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fy5Var) == null) {
                mx5.b().d(true);
                oi5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.m == null || fy5Var == null || fy5Var.getThreadData() == null || StringUtils.isNull(fy5Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !cy6.b(mg.g(fy5Var.getThreadData().getTid(), 0L))) {
                    cy6.a(mg.g(fy5Var.getThreadData().getTid(), 0L));
                    this.b.m.e(mg.g(fy5Var.getThreadData().getTid(), 0L), fy5Var.D(), fy5Var.r(), fy5Var.q(), fy5Var.e(), mg.e((String) view2.getTag(), 1), "homepage", fy5Var.getThreadData().getBaijiahaoData());
                }
                this.b.h0(view2, fy5Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ty.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ty.b
        public void a(pn4 pn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, pn4Var, view2) == null) || pn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09229d) {
                pn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09227b) {
                pn4Var.objType = 4;
            } else {
                pn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Cdo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz a;
        public final /* synthetic */ ry6 b;

        public e(ry6 ry6Var, mz mzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var, mzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ry6Var;
            this.a = mzVar;
        }

        @Override // com.repackage.Cdo
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.b.Y(i, i2, i3);
                if (this.b.F(1) && this.b.F(2)) {
                    this.a.w(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry6 a;

        public f(ry6 ry6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof fy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                fy5 fy5Var = (fy5) uoVar;
                fy5Var.f = 1;
                if (this.a.r != null) {
                    this.a.r.a(threadCardViewHolder.b(), fy5Var);
                }
                ThreadCardUtils.jumpToPB((pn4) fy5Var, view2.getContext(), 2, false);
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ry6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.l = null;
        this.o = true;
        this.p = new dg<>(new a(this), 6, 0);
        this.q = new dg<>(new b(this), 12, 0);
        this.r = new c(this);
        this.k = tbPageContext;
        e0();
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fy5.R = "c10705";
            fy5.S = "c10730";
            fy5.T = "c10731";
            fy5.U = "c10704";
            fy5.V = "c10755";
            fy5.W = "c10710";
            fy5.X = "c10736";
            fy5.Y = "c10737";
            fy5.Z = "c10711";
            fy5.g0 = "c10758";
            fy5.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: f0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.k.getPageActivity());
            ty tyVar = new ty(this.k.getPageActivity());
            tyVar.t(this.j);
            tyVar.c(1024);
            tyVar.s(new d(this));
            bVar.o(tyVar);
            mz mzVar = new mz(this.k.getPageActivity());
            mzVar.t("index");
            mzVar.s(this.p);
            mzVar.r(this.q);
            mzVar.u(this.o);
            bVar.n(mzVar);
            iz izVar = new iz(this.k.getPageActivity());
            izVar.w(true);
            bVar.h(izVar);
            bVar.h(new xz(this.k.getPageActivity()));
            bVar.h(new qz(this.k.getPageActivity()));
            bVar.h(new az(this.k.getPageActivity()));
            dz dzVar = new dz(this.k.getPageActivity());
            dzVar.x(this.o);
            dzVar.w("index");
            bVar.h(dzVar);
            if (!F(1) || !F(2)) {
                mzVar.w(new e(this, mzVar));
            }
            d00 d00Var = new d00(this.k.getPageActivity());
            vn4 vn4Var = new vn4();
            vn4Var.b = 1;
            vn4Var.h = 1;
            d00Var.v(vn4Var);
            d00Var.x(1);
            d00Var.C(3);
            d00Var.y(2);
            d00Var.w(false);
            bVar.m(d00Var);
            b00 i = bVar.i();
            i.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i);
            threadCardViewHolder.k(this.j);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    @Override // com.repackage.qi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: g0 */
    public View S(int i, View view2, ViewGroup viewGroup, fy5 fy5Var, ThreadCardViewHolder<fy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fy5Var, threadCardViewHolder})) == null) {
            if (fy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || fy5Var.a == null) {
                return null;
            }
            fy5Var.I(fy5Var.position + 1);
            fy5Var.a.statFloor = fy5Var.q();
            threadCardViewHolder.c().b(this.n);
            threadCardViewHolder.r(true).u(this.l);
            threadCardViewHolder.m(fy5Var.showFollowBtn(), this.i);
            threadCardViewHolder.g(fy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.r);
            mx5.b().a(fy5Var.B());
            oi5.c().i("page_recommend", "show_", fy5Var.B());
            f07.h(fy5Var.a, this.j, fy5Var.q());
            f07.g(fy5Var.a, fy5Var.r(), fy5Var.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void h0(View view2, fy5 fy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, fy5Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.obfuscated_res_0x7f091f87) {
                TiebaStatic.log(fy5Var.A());
                oi5.c().i("page_recommend", "clk_", fy5Var.A());
                f07.c(fy5Var.a, fy5Var.r(), fy5Var.q(), 1);
                i = 1;
            } else if (id == R.id.obfuscated_res_0x7f091f99) {
                TiebaStatic.log(fy5Var.A());
                oi5.c().i("page_recommend", "clk_", fy5Var.A());
                i = 5;
                f07.c(fy5Var.a, fy5Var.r(), fy5Var.q(), 1);
            } else {
                if (id == R.id.obfuscated_res_0x7f091f89) {
                    TiebaStatic.log(fy5Var.T());
                    oi5.c().i("page_recommend", "clk_", fy5Var.T());
                } else {
                    if (id == R.id.obfuscated_res_0x7f09227b) {
                        TiebaStatic.log(fy5Var.S());
                        oi5.c().i("page_recommend", "clk_", fy5Var.S());
                        f07.c(fy5Var.a, fy5Var.r(), fy5Var.q(), 4);
                    } else if (id == R.id.obfuscated_res_0x7f09229d) {
                        TiebaStatic.log(fy5Var.S());
                        oi5.c().i("page_recommend", "clk_", fy5Var.S());
                        f07.c(fy5Var.a, fy5Var.r(), fy5Var.q(), 4);
                    } else if (id == R.id.obfuscated_res_0x7f090a6b) {
                        TiebaStatic.log(fy5Var.k());
                        oi5.c().i("page_recommend", "clk_", fy5Var.k());
                    } else if (id == R.id.obfuscated_res_0x7f090cdb) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.obfuscated_res_0x7f090cd6) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                        f07.c(fy5Var.a, fy5Var.r(), fy5Var.q(), 1);
                    } else if (id != R.id.obfuscated_res_0x7f090cd9 && id != R.id.obfuscated_res_0x7f090cda) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f090cd7) instanceof Integer) {
                                StatisticItem statisticItem3 = new StatisticItem("c10760");
                                statisticItem3.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem3);
                            }
                            TiebaStatic.log(fy5Var.P());
                            oi5.c().i("page_recommend", "clk_", fy5Var.P());
                            f07.c(fy5Var.a, fy5Var.r(), fy5Var.q(), 2);
                        }
                    } else {
                        StatisticItem statisticItem4 = new StatisticItem("c10760");
                        statisticItem4.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem4);
                    }
                    i = 2;
                }
                i = 0;
            }
            if (i != 0) {
                f07.d(fy5Var.a, this.j, fy5Var.q(), i);
            }
        }
    }

    public void i0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void j0(zz6 zz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zz6Var) == null) {
            this.m = zz6Var;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }
}
