package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b00;
import com.repackage.m00;
import com.repackage.qy;
import com.repackage.ty;
/* loaded from: classes7.dex */
public class wy6 extends rt6<dy5, ThreadCardViewHolder<dy5>> implements qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public NEGFeedBackView.b l;
    public String m;
    public zo n;
    public rx5<dy5> o;

    /* loaded from: classes7.dex */
    public class a extends rx5<dy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy6 b;

        public a(wy6 wy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.rx5
        /* renamed from: d */
        public void a(View view2, dy5 dy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dy5Var) == null) {
                int i = 1;
                kx5.b().d(true);
                oi5.c().h("page_recommend", "show_");
                if (view2 == null || dy5Var == null || dy5Var.getThreadData() == null || StringUtils.isNull(dy5Var.getThreadData().getTid())) {
                    return;
                }
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091f86 || id == R.id.obfuscated_res_0x7f091f98) {
                    TiebaStatic.log(dy5Var.Q("c12642"));
                    oi5.c().i("page_recommend", "clk_", dy5Var.A());
                    d07.c(dy5Var.a, dy5Var.r(), dy5Var.q(), 1);
                } else {
                    if (id == R.id.obfuscated_res_0x7f091f88) {
                        TiebaStatic.log(dy5Var.T());
                        oi5.c().i("page_recommend", "clk_", dy5Var.T());
                    } else {
                        if (id == R.id.obfuscated_res_0x7f09227a) {
                            TiebaStatic.log(dy5Var.S());
                            oi5.c().i("page_recommend", "clk_", dy5Var.S());
                            d07.c(dy5Var.a, dy5Var.r(), dy5Var.q(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f09229c) {
                            TiebaStatic.log(dy5Var.S());
                            oi5.c().i("page_recommend", "clk_", dy5Var.S());
                            d07.c(dy5Var.a, dy5Var.r(), dy5Var.q(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f090a6a) {
                            TiebaStatic.log(dy5Var.k());
                            oi5.c().i("page_recommend", "clk_", dy5Var.k());
                        } else if (id == R.id.obfuscated_res_0x7f090cda) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.obfuscated_res_0x7f090cd5) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            d07.c(dy5Var.a, dy5Var.r(), dy5Var.q(), 1);
                        } else if (id != R.id.obfuscated_res_0x7f090cd8 && id != R.id.obfuscated_res_0x7f090cd9) {
                            if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f090cd6) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(dy5Var.P());
                                oi5.c().i("page_recommend", "clk_", dy5Var.P());
                                d07.c(dy5Var.a, dy5Var.r(), dy5Var.q(), 2);
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
                    d07.d(dy5Var.a, this.b.j, dy5Var.q(), i);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ty.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(wy6 wy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy6Var};
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
        public void a(qn4 qn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, qn4Var, view2) == null) || qn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09229c) {
                qn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09227a) {
                qn4Var.objType = 4;
            } else {
                qn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy6 a;

        public c(wy6 wy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wy6Var;
        }

        @Override // com.repackage.qy.a
        public void a(qn4 qn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qn4Var) == null) || qn4Var == null || qn4Var.getThreadData() == null || qn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(qn4Var.getThreadData().originalThreadData, this.a.a, 2);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy6 a;

        public d(wy6 wy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wy6Var;
        }

        @Override // com.repackage.qy.a
        public void a(qn4 qn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qn4Var) == null) || qn4Var == null || qn4Var.getThreadData() == null || qn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(qn4Var.getThreadData().originalThreadData, this.a.a, 2);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy6 a;

        public e(wy6 wy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wy6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof dy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                dy5 dy5Var = (dy5) uoVar;
                dy5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), dy5Var);
                }
                ThreadCardUtils.jumpToPB((qn4) dy5Var, view2.getContext(), 2, false);
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wy6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.o = new a(this);
        this.k = tbPageContext;
        d0();
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            dy5.R = "c10705";
            dy5.S = "c10730";
            dy5.T = "c10731";
            dy5.U = "c10704";
            dy5.V = "c10755";
            dy5.W = "c10710";
            dy5.X = "c10736";
            dy5.Y = "c10737";
            dy5.Z = "c10711";
            dy5.g0 = "c10758";
            dy5.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: e0 */
    public ThreadCardViewHolder<dy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.k.getPageActivity());
            ty tyVar = new ty(this.k.getPageActivity());
            tyVar.t(this.j);
            tyVar.c(1024);
            tyVar.s(new b(this));
            bVar.o(tyVar);
            wz wzVar = new wz(this.k);
            wzVar.n(Boolean.FALSE);
            wzVar.v("index");
            bVar.n(wzVar);
            wz wzVar2 = new wz(this.k);
            wzVar2.n(Boolean.TRUE);
            wzVar2.r(oi.f(this.a, R.dimen.M_H_X003));
            wzVar2.v("index");
            wzVar2.y(HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            bVar.h(wzVar2);
            wzVar2.w(new c(this));
            e00 e00Var = new e00(this.k.getPageActivity());
            e00Var.n(Boolean.TRUE);
            e00Var.u(new d(this));
            bVar.h(e00Var);
            bVar.h(new az(this.k.getPageActivity()));
            d00 d00Var = new d00(this.k.getPageActivity());
            wn4 wn4Var = new wn4();
            wn4Var.b = 1;
            wn4Var.h = 1;
            d00Var.v(wn4Var);
            d00Var.w(1);
            d00Var.A(3);
            d00Var.x(2);
            bVar.m(d00Var);
            b00 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.n);
            k.r(2);
            ThreadCardViewHolder<dy5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.j);
            V(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: f0 */
    public View S(int i, View view2, ViewGroup viewGroup, dy5 dy5Var, ThreadCardViewHolder<dy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dy5Var, threadCardViewHolder})) == null) {
            if (dy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || dy5Var.a == null) {
                return null;
            }
            dy5Var.I(dy5Var.position + 1);
            dy5Var.a.statFloor = dy5Var.q();
            threadCardViewHolder.c().q(i);
            kx5.b().a(dy5Var.R("c12641"));
            oi5.c().i("page_recommend", "show_", dy5Var.B());
            threadCardViewHolder.c().b(this.m);
            threadCardViewHolder.r(true).u(this.l);
            threadCardViewHolder.m(dy5Var.showFollowBtn(), this.i);
            threadCardViewHolder.g(dy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.o);
            d07.h(dy5Var.a, this.j, dy5Var.q());
            d07.g(dy5Var.a, dy5Var.r(), dy5Var.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.qi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    public void g0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void h0(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zoVar) == null) {
            this.n = zoVar;
        }
    }
}
