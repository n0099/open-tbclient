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
import com.repackage.dy;
import com.repackage.oy;
import com.repackage.uw;
/* loaded from: classes6.dex */
public class kz6 extends gu6<n06, ThreadCardViewHolder<n06>> implements pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public boolean f;
    public b06<n06> g;

    /* loaded from: classes6.dex */
    public class a extends b06<n06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz6 b;

        public a(kz6 kz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, n06 n06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, n06Var) == null) {
                int i = 1;
                uz5.b().d(true);
                nl5.c().h("page_recommend", "show_");
                if (n06Var == null || n06Var.getThreadData() == null || pi.isEmpty(n06Var.getThreadData().getTid())) {
                    return;
                }
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f09212a) {
                    TiebaStatic.log(n06Var.A());
                    nl5.c().i("page_recommend", "clk_", n06Var.A());
                    b17.c(n06Var.a, n06Var.r(), n06Var.n(), 1);
                } else if (id == R.id.obfuscated_res_0x7f09213e) {
                    TiebaStatic.log(n06Var.A());
                    nl5.c().i("page_recommend", "clk_", n06Var.A());
                    b17.c(n06Var.a, n06Var.r(), n06Var.n(), 1);
                    i = 5;
                } else {
                    if (id == R.id.obfuscated_res_0x7f09212c) {
                        TiebaStatic.log(n06Var.T());
                        nl5.c().i("page_recommend", "clk_", n06Var.T());
                    } else {
                        if (id == R.id.obfuscated_res_0x7f092422) {
                            TiebaStatic.log(n06Var.S());
                            nl5.c().i("page_recommend", "clk_", n06Var.S());
                            b17.c(n06Var.a, n06Var.r(), n06Var.n(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f092450) {
                            TiebaStatic.log(n06Var.S());
                            nl5.c().i("page_recommend", "clk_", n06Var.S());
                            b17.c(n06Var.a, n06Var.r(), n06Var.n(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f090a74) {
                            TiebaStatic.log(n06Var.j());
                            nl5.c().i("page_recommend", "clk_", n06Var.j());
                        } else if (id == R.id.obfuscated_res_0x7f090cbe) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.obfuscated_res_0x7f090cb9) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            b17.c(n06Var.a, n06Var.r(), n06Var.n(), 1);
                        } else if (id != R.id.obfuscated_res_0x7f090cbc && id != R.id.obfuscated_res_0x7f090cbd) {
                            if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f090cba) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(n06Var.P());
                                nl5.c().i("page_recommend", "clk_", n06Var.P());
                                b17.c(n06Var.a, n06Var.r(), n06Var.n(), 2);
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
                    b17.d(n06Var.a, this.b.b, n06Var.n(), i);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements uw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(kz6 kz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.uw.b
        public void a(fo4 fo4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, fo4Var, view2) == null) || fo4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092450) {
                fo4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092422) {
                fo4Var.objType = 4;
            } else {
                fo4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz6 a;

        public c(kz6 kz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz6Var;
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
                ThreadCardUtils.jumpToPB((fo4) n06Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().o(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kz6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = null;
        this.f = true;
        this.g = new a(this);
        this.c = tbPageContext;
        u();
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f = z;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n06.R = "c10705";
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
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: v */
    public ThreadCardViewHolder<n06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.c.getPageActivity());
            uw uwVar = new uw(this.c.getPageActivity());
            uwVar.u(this.b);
            uwVar.d(1024);
            uwVar.t(new b(this));
            bVar.o(uwVar);
            bVar.n(new lx(this.c.getPageActivity()));
            bVar.h(new bx(this.c.getPageActivity()));
            fx fxVar = new fx(this.c.getPageActivity());
            fxVar.y(this.f);
            fxVar.x("index");
            fxVar.z(new StatisticItem("c13342"));
            bVar.h(fxVar);
            fy fyVar = new fy(this.c.getPageActivity());
            lo4 lo4Var = new lo4();
            lo4Var.b = 1;
            lo4Var.h = 1;
            fyVar.w(lo4Var);
            fyVar.y(1);
            fyVar.D(3);
            fyVar.z(2);
            fyVar.x(false);
            bVar.m(fyVar);
            dy i = bVar.i();
            i.r(2);
            ThreadCardViewHolder<n06> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n06 n06Var, ThreadCardViewHolder<n06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n06Var, threadCardViewHolder})) == null) {
            if (n06Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            n06Var.I(n06Var.position + 1);
            n06Var.a.statFloor = n06Var.n();
            uz5.b().a(n06Var.O("c12190"));
            if (threadCardViewHolder.a() instanceof ol5) {
                threadCardViewHolder.a().b(this.e);
            }
            tx o = threadCardViewHolder.o(true);
            o.u(this.d);
            threadCardViewHolder.k(n06Var.showFollowBtn(), this.a);
            o.a(n06Var.getNegFeedBackData());
            threadCardViewHolder.e(n06Var);
            threadCardViewHolder.h(this.g);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            b17.i(n06Var.a, this.b, n06Var.n());
            b17.h(n06Var.a, n06Var.r(), n06Var.n());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void x(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.d = bVar;
        }
    }
}
