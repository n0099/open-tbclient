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
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.tw;
/* loaded from: classes7.dex */
public class rx6 extends os6<vy5, ThreadCardViewHolder<vy5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public NEGFeedBackView.b l;
    public String m;
    public boolean n;
    public jy5<vy5> o;

    /* loaded from: classes7.dex */
    public class a extends jy5<vy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rx6 b;

        public a(rx6 rx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, vy5 vy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, vy5Var) == null) {
                int i = 1;
                cy5.b().d(true);
                ak5.c().h("page_recommend", "show_");
                if (vy5Var == null || vy5Var.getThreadData() == null || oi.isEmpty(vy5Var.getThreadData().getTid())) {
                    return;
                }
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f09202a) {
                    TiebaStatic.log(vy5Var.A());
                    ak5.c().i("page_recommend", "clk_", vy5Var.A());
                    iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 1);
                } else if (id == R.id.obfuscated_res_0x7f09203e) {
                    TiebaStatic.log(vy5Var.A());
                    ak5.c().i("page_recommend", "clk_", vy5Var.A());
                    iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 1);
                    i = 5;
                } else {
                    if (id == R.id.obfuscated_res_0x7f09202c) {
                        TiebaStatic.log(vy5Var.T());
                        ak5.c().i("page_recommend", "clk_", vy5Var.T());
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
                        } else if (id == R.id.obfuscated_res_0x7f090c84) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.obfuscated_res_0x7f090c7f) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 1);
                        } else if (id != R.id.obfuscated_res_0x7f090c82 && id != R.id.obfuscated_res_0x7f090c83) {
                            if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f090c80) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(vy5Var.P());
                                ak5.c().i("page_recommend", "clk_", vy5Var.P());
                                iz6.c(vy5Var.a, vy5Var.o(), vy5Var.m(), 2);
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
                    iz6.d(vy5Var.a, this.b.j, vy5Var.m(), i);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(rx6 rx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rx6Var};
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

    /* loaded from: classes7.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rx6 a;

        public c(rx6 rx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rx6Var;
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
                ThreadCardUtils.jumpToPB((nn4) vy5Var, view2.getContext(), 2, false);
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            vy5.R = "c10705";
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
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public ThreadCardViewHolder<vy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.k.getPageActivity());
            tw twVar = new tw(this.k.getPageActivity());
            twVar.u(this.j);
            twVar.d(1024);
            twVar.t(new b(this));
            bVar.o(twVar);
            bVar.n(new kx(this.k.getPageActivity()));
            bVar.h(new ax(this.k.getPageActivity()));
            ex exVar = new ex(this.k.getPageActivity());
            exVar.y(this.n);
            exVar.x("index");
            exVar.z(new StatisticItem("c13342"));
            bVar.h(exVar);
            ey eyVar = new ey(this.k.getPageActivity());
            tn4 tn4Var = new tn4();
            tn4Var.b = 1;
            tn4Var.h = 1;
            eyVar.w(tn4Var);
            eyVar.y(1);
            eyVar.D(3);
            eyVar.z(2);
            eyVar.x(false);
            bVar.m(eyVar);
            cy i = bVar.i();
            i.r(2);
            ThreadCardViewHolder<vy5> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.k(this.j);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, vy5 vy5Var, ThreadCardViewHolder<vy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vy5Var, threadCardViewHolder})) == null) {
            if (vy5Var == null || threadCardViewHolder == null || threadCardViewHolder.c() == null) {
                return null;
            }
            vy5Var.I(vy5Var.position + 1);
            vy5Var.a.statFloor = vy5Var.m();
            cy5.b().a(vy5Var.O("c12190"));
            if (threadCardViewHolder.c() instanceof bk5) {
                threadCardViewHolder.c().b(this.m);
            }
            sx q = threadCardViewHolder.q(true);
            q.u(this.l);
            threadCardViewHolder.m(vy5Var.showFollowBtn(), this.i);
            q.a(vy5Var.getNegFeedBackData());
            threadCardViewHolder.g(vy5Var);
            threadCardViewHolder.j(this.o);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            iz6.i(vy5Var.a, this.j, vy5Var.m());
            iz6.h(vy5Var.a, vy5Var.o(), vy5Var.m());
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

    @Override // com.repackage.ck5
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
