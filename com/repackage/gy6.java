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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b00;
import com.repackage.m00;
/* loaded from: classes6.dex */
public class gy6 extends ho<dy5, ThreadCardViewHolder<dy5>> implements qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public xz6 k;
    public String l;
    public boolean m;
    public zo n;
    public rx5<dy5> o;

    /* loaded from: classes6.dex */
    public class a extends rx5<dy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy6 b;

        public a(gy6 gy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.rx5
        /* renamed from: d */
        public void a(View view2, dy5 dy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dy5Var) == null) {
                kx5.b().d(true);
                oi5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.k == null || dy5Var == null || dy5Var.getThreadData() == null || StringUtils.isNull(dy5Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !ay6.b(mg.g(dy5Var.getThreadData().getTid(), 0L))) {
                    ay6.a(mg.g(dy5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(mg.g(dy5Var.getThreadData().getTid(), 0L), dy5Var.D(), dy5Var.r(), dy5Var.q(), dy5Var.e(), mg.e((String) view2.getTag(), 1), "homepage", dy5Var.getThreadData().getBaijiahaoData());
                }
                this.b.f0(view2, dy5Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy6 a;

        public b(gy6 gy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gy6Var;
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
    public gy6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.m = true;
        this.o = new a(this);
        this.j = tbPageContext;
        c0();
    }

    public final void c0() {
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
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.j.getPageActivity(), false);
            lz lzVar = new lz(this.j.getPageActivity());
            lzVar.s("index");
            lzVar.t(this.m);
            bVar.n(lzVar);
            b00 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.n);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: e0 */
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
            threadCardViewHolder.c().b(this.l);
            threadCardViewHolder.g(dy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.o);
            kx5.b().a(dy5Var.B());
            oi5.c().a(dy5Var.B());
            d07.h(dy5Var.a, this.i, dy5Var.q());
            d07.g(dy5Var.a, dy5Var.r(), dy5Var.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(View view2, dy5 dy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, dy5Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.obfuscated_res_0x7f091f86 || id == R.id.obfuscated_res_0x7f091f98) {
                TiebaStatic.log(dy5Var.A());
                oi5.c().i("page_recommend", "clk_", dy5Var.A());
                d07.c(dy5Var.a, dy5Var.r(), dy5Var.q(), 1);
                i = 1;
            } else {
                if (id == R.id.obfuscated_res_0x7f09227a) {
                    TiebaStatic.log(dy5Var.S());
                    oi5.c().i("page_recommend", "clk_", dy5Var.S());
                } else if (id == R.id.obfuscated_res_0x7f09229c) {
                    TiebaStatic.log(dy5Var.S());
                    oi5.c().i("page_recommend", "clk_", dy5Var.S());
                } else if (id == R.id.obfuscated_res_0x7f090a6a) {
                    TiebaStatic.log(dy5Var.k());
                    oi5.c().i("page_recommend", "clk_", dy5Var.k());
                    i = 9;
                } else {
                    if (id == R.id.obfuscated_res_0x7f090cd5) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        d07.c(dy5Var.a, dy5Var.r(), dy5Var.q(), 1);
                    } else if (id != R.id.obfuscated_res_0x7f090cd8 && id != R.id.obfuscated_res_0x7f090cd9) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f090cd6) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(dy5Var.P());
                            oi5.c().i("page_recommend", "clk_", dy5Var.P());
                            d07.c(dy5Var.a, dy5Var.r(), dy5Var.q(), 2);
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
                d07.d(dy5Var.a, this.i, dy5Var.q(), i);
            }
        }
    }

    @Override // com.repackage.qi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
        }
    }

    public void g0(xz6 xz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xz6Var) == null) {
            this.k = xz6Var;
        }
    }

    public void h0(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zoVar) == null) {
            this.n = zoVar;
        }
    }
}
