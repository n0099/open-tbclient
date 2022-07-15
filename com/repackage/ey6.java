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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
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
import com.repackage.tw;
/* loaded from: classes6.dex */
public class ey6 extends os6<vy5, ThreadCardViewHolder<vy5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public bz6 l;
    public String m;
    public tn n;
    public NEGFeedBackView.b o;
    public jy5<vy5> p;

    /* loaded from: classes6.dex */
    public class a extends jy5<vy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey6 b;

        public a(ey6 ey6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ey6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, vy5 vy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, vy5Var) == null) {
                cy5.b().d(true);
                ak5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.l == null || vy5Var == null || vy5Var.getThreadData() == null || StringUtils.isNull(vy5Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !ex6.b(ng.g(vy5Var.getThreadData().getTid(), 0L))) {
                    ex6.a(ng.g(vy5Var.getThreadData().getTid(), 0L));
                    this.b.l.e(ng.g(vy5Var.getThreadData().getTid(), 0L), vy5Var.D(), vy5Var.o(), vy5Var.m(), vy5Var.c(), ng.e((String) view2.getTag(), 1), "homepage", vy5Var.getThreadData().getBaijiahaoData());
                }
                this.b.h0(view2, vy5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ey6 ey6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.tw.b
        public void a(nn4 nn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, nn4Var, view2) == null) || nn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09232d) {
                nn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09230c) {
                nn4Var.objType = 4;
            } else {
                nn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey6 a;

        public c(ey6 ey6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ey6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof vy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                vy5 vy5Var = (vy5) nnVar;
                vy5Var.f = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.b(), vy5Var);
                }
                if (kz6.a(this.a.k, vy5Var)) {
                    return;
                }
                ThreadCardUtils.jumpToPB((nn4) vy5Var, view2.getContext(), 2, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ey6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.p = new a(this);
        this.k = tbPageContext;
        e0();
    }

    public final void e0() {
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
            vy5.l0 = "c10708";
            vy5.m0 = "c10735";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.k.getPageActivity());
            tw twVar = new tw(this.k.getPageActivity());
            twVar.u(this.j);
            twVar.d(1024);
            twVar.t(new b(this));
            twVar.w(this.k);
            bVar.o(twVar);
            cy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.n);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.j);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public View S(int i, View view2, ViewGroup viewGroup, vy5 vy5Var, ThreadCardViewHolder<vy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vy5Var, threadCardViewHolder})) == null) {
            if (vy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || vy5Var.a == null) {
                return null;
            }
            vy5Var.I(vy5Var.position + 1);
            vy5Var.a.statFloor = vy5Var.m();
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.m);
            threadCardViewHolder.r(true, Align.ALIGN_RIGHT_TOP, this.o);
            threadCardViewHolder.n(vy5Var.showFollowBtn(), this.i, true);
            threadCardViewHolder.g(vy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            cy5.b().a(vy5Var.B());
            ak5.c().a(vy5Var.B());
            iz6.i(vy5Var.a, this.j, vy5Var.m());
            iz6.h(vy5Var.a, vy5Var.o(), vy5Var.m());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void h0(View view2, vy5 vy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, vy5Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.obfuscated_res_0x7f09202a || id == R.id.obfuscated_res_0x7f09203e) {
                if (wy5.R(vy5Var.a)) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(vy5Var.C()));
                } else {
                    TiebaStatic.log(vy5Var.A());
                }
                ak5.c().i("page_recommend", "clk_", vy5Var.A());
                iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 1);
                i = 1;
            } else {
                if (id == R.id.obfuscated_res_0x7f09230c) {
                    TiebaStatic.log(vy5Var.S());
                    ak5.c().i("page_recommend", "clk_", vy5Var.S());
                    iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 4);
                } else if (id == R.id.obfuscated_res_0x7f09232d) {
                    TiebaStatic.log(vy5Var.S());
                    ak5.c().i("page_recommend", "clk_", vy5Var.S());
                    iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 4);
                } else if (id == R.id.obfuscated_res_0x7f090a40) {
                    TiebaStatic.log(vy5Var.i());
                    ak5.c().i("page_recommend", "clk_", vy5Var.i());
                    i = 9;
                } else {
                    if (id == R.id.obfuscated_res_0x7f090c7f) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 1);
                    } else if (id != R.id.obfuscated_res_0x7f090c82 && id != R.id.obfuscated_res_0x7f090c83) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f090c80) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(vy5Var.P());
                            ak5.c().i("page_recommend", "clk_", vy5Var.P());
                            iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 2);
                        } else {
                            i = 0;
                        }
                    } else {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    }
                    i = 5;
                }
                i = 2;
            }
            if (i != 0) {
                iz6.d(vy5Var.a, this.j, vy5Var.m(), i);
            }
        }
    }

    public void i0(bz6 bz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bz6Var) == null) {
            this.l = bz6Var;
        }
    }

    public void j0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tnVar) == null) {
            this.n = tnVar;
        }
    }
}
