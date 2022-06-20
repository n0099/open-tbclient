package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.by;
import com.repackage.my;
import com.repackage.tw;
/* loaded from: classes5.dex */
public class bx6 extends as6<yx5, ThreadCardViewHolder<yx5>> implements zi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public NEGFeedBackView.b l;
    public String m;
    public boolean n;
    public mx5<yx5> o;

    /* loaded from: classes5.dex */
    public class a extends mx5<yx5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx6 b;

        public a(bx6 bx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mx5
        /* renamed from: d */
        public void a(View view2, yx5 yx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yx5Var) == null) {
                int i = 1;
                fx5.b().d(true);
                xi5.c().h("page_recommend", "show_");
                if (yx5Var == null || yx5Var.getThreadData() == null || oi.isEmpty(yx5Var.getThreadData().getTid())) {
                    return;
                }
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091f85) {
                    TiebaStatic.log(yx5Var.A());
                    xi5.c().i("page_recommend", "clk_", yx5Var.A());
                    sy6.c(yx5Var.a, yx5Var.r(), yx5Var.n(), 1);
                } else if (id == R.id.obfuscated_res_0x7f091f99) {
                    TiebaStatic.log(yx5Var.A());
                    xi5.c().i("page_recommend", "clk_", yx5Var.A());
                    sy6.c(yx5Var.a, yx5Var.r(), yx5Var.n(), 1);
                    i = 5;
                } else {
                    if (id == R.id.obfuscated_res_0x7f091f87) {
                        TiebaStatic.log(yx5Var.T());
                        xi5.c().i("page_recommend", "clk_", yx5Var.T());
                    } else {
                        if (id == R.id.obfuscated_res_0x7f092266) {
                            TiebaStatic.log(yx5Var.S());
                            xi5.c().i("page_recommend", "clk_", yx5Var.S());
                            sy6.c(yx5Var.a, yx5Var.r(), yx5Var.n(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f092285) {
                            TiebaStatic.log(yx5Var.S());
                            xi5.c().i("page_recommend", "clk_", yx5Var.S());
                            sy6.c(yx5Var.a, yx5Var.r(), yx5Var.n(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f090a38) {
                            TiebaStatic.log(yx5Var.j());
                            xi5.c().i("page_recommend", "clk_", yx5Var.j());
                        } else if (id == R.id.obfuscated_res_0x7f090c7b) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.obfuscated_res_0x7f090c76) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            sy6.c(yx5Var.a, yx5Var.r(), yx5Var.n(), 1);
                        } else if (id != R.id.obfuscated_res_0x7f090c79 && id != R.id.obfuscated_res_0x7f090c7a) {
                            if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f090c77) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(yx5Var.P());
                                xi5.c().i("page_recommend", "clk_", yx5Var.P());
                                sy6.c(yx5Var.a, yx5Var.r(), yx5Var.n(), 2);
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
                    sy6.d(yx5Var.a, this.b.j, yx5Var.n(), i);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(bx6 bx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx6Var};
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
        public void a(ym4 ym4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, ym4Var, view2) == null) || ym4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092285) {
                ym4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092266) {
                ym4Var.objType = 4;
            } else {
                ym4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx6 a;

        public c(bx6 bx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof yx5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                yx5 yx5Var = (yx5) nnVar;
                yx5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), yx5Var);
                }
                ThreadCardUtils.jumpToPB((ym4) yx5Var, view2.getContext(), 2, false);
                threadCardViewHolder.c().o(new my.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = true;
        this.o = new a(this);
        this.k = tbPageContext;
        b0();
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            yx5.R = "c10705";
            yx5.S = "c10730";
            yx5.T = "c10731";
            yx5.U = "c10704";
            yx5.V = "c10755";
            yx5.W = "c10710";
            yx5.X = "c10736";
            yx5.Y = "c10737";
            yx5.Z = "c10711";
            yx5.g0 = "c10758";
            yx5.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public ThreadCardViewHolder<yx5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            by.b bVar = new by.b(this.k.getPageActivity());
            tw twVar = new tw(this.k.getPageActivity());
            twVar.t(this.j);
            twVar.c(1024);
            twVar.s(new b(this));
            bVar.o(twVar);
            bVar.n(new jx(this.k.getPageActivity()));
            bVar.h(new ax(this.k.getPageActivity()));
            dx dxVar = new dx(this.k.getPageActivity());
            dxVar.x(this.n);
            dxVar.w("index");
            dxVar.y(new StatisticItem("c13342"));
            bVar.h(dxVar);
            dy dyVar = new dy(this.k.getPageActivity());
            en4 en4Var = new en4();
            en4Var.b = 1;
            en4Var.h = 1;
            dyVar.v(en4Var);
            dyVar.x(1);
            dyVar.C(3);
            dyVar.y(2);
            dyVar.w(false);
            bVar.m(dyVar);
            by i = bVar.i();
            i.r(2);
            ThreadCardViewHolder<yx5> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.k(this.j);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, yx5 yx5Var, ThreadCardViewHolder<yx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yx5Var, threadCardViewHolder})) == null) {
            if (yx5Var == null || threadCardViewHolder == null || threadCardViewHolder.c() == null) {
                return null;
            }
            yx5Var.I(yx5Var.position + 1);
            yx5Var.a.statFloor = yx5Var.n();
            fx5.b().a(yx5Var.O("c12190"));
            if (threadCardViewHolder.c() instanceof yi5) {
                threadCardViewHolder.c().b(this.m);
            }
            rx q = threadCardViewHolder.q(true);
            q.u(this.l);
            threadCardViewHolder.m(yx5Var.showFollowBtn(), this.i);
            q.a(yx5Var.getNegFeedBackData());
            threadCardViewHolder.g(yx5Var);
            threadCardViewHolder.j(this.o);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            sy6.h(yx5Var.a, this.j, yx5Var.n());
            sy6.g(yx5Var.a, yx5Var.r(), yx5Var.n());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.l = bVar;
        }
    }

    @Override // com.repackage.zi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n = z;
        }
    }
}
