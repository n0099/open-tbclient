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
import com.repackage.b00;
import com.repackage.m00;
import com.repackage.ty;
/* loaded from: classes6.dex */
public class py6 extends tt6<fy5, ThreadCardViewHolder<fy5>> implements qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public NEGFeedBackView.b l;
    public String m;
    public boolean n;
    public tx5<fy5> o;

    /* loaded from: classes6.dex */
    public class a extends tx5<fy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py6 b;

        public a(py6 py6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = py6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tx5
        /* renamed from: d */
        public void a(View view2, fy5 fy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fy5Var) == null) {
                int i = 1;
                mx5.b().d(true);
                oi5.c().h("page_recommend", "show_");
                if (fy5Var == null || fy5Var.getThreadData() == null || ni.isEmpty(fy5Var.getThreadData().getTid())) {
                    return;
                }
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091f87) {
                    TiebaStatic.log(fy5Var.A());
                    oi5.c().i("page_recommend", "clk_", fy5Var.A());
                    f07.c(fy5Var.a, fy5Var.r(), fy5Var.q(), 1);
                } else if (id == R.id.obfuscated_res_0x7f091f99) {
                    TiebaStatic.log(fy5Var.A());
                    oi5.c().i("page_recommend", "clk_", fy5Var.A());
                    f07.c(fy5Var.a, fy5Var.r(), fy5Var.q(), 1);
                    i = 5;
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
                    f07.d(fy5Var.a, this.b.j, fy5Var.q(), i);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ty.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(py6 py6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py6Var};
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

    /* loaded from: classes6.dex */
    public class c implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py6 a;

        public c(py6 py6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = py6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof fy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                fy5 fy5Var = (fy5) uoVar;
                fy5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), fy5Var);
                }
                ThreadCardUtils.jumpToPB((pn4) fy5Var, view2.getContext(), 2, false);
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public py6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    /* renamed from: c0 */
    public ThreadCardViewHolder<fy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.k.getPageActivity());
            ty tyVar = new ty(this.k.getPageActivity());
            tyVar.t(this.j);
            tyVar.c(1024);
            tyVar.s(new b(this));
            bVar.o(tyVar);
            bVar.n(new jz(this.k.getPageActivity()));
            bVar.h(new az(this.k.getPageActivity()));
            dz dzVar = new dz(this.k.getPageActivity());
            dzVar.x(this.n);
            dzVar.w("index");
            dzVar.y(new StatisticItem("c13342"));
            bVar.h(dzVar);
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
            ThreadCardViewHolder<fy5> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.k(this.j);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, fy5 fy5Var, ThreadCardViewHolder<fy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fy5Var, threadCardViewHolder})) == null) {
            if (fy5Var == null || threadCardViewHolder == null || threadCardViewHolder.c() == null) {
                return null;
            }
            fy5Var.I(fy5Var.position + 1);
            fy5Var.a.statFloor = fy5Var.q();
            mx5.b().a(fy5Var.O("c12190"));
            if (threadCardViewHolder.c() instanceof pi5) {
                threadCardViewHolder.c().b(this.m);
            }
            rz r = threadCardViewHolder.r(true);
            r.u(this.l);
            threadCardViewHolder.m(fy5Var.showFollowBtn(), this.i);
            r.a(fy5Var.getNegFeedBackData());
            threadCardViewHolder.g(fy5Var);
            threadCardViewHolder.j(this.o);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            f07.h(fy5Var.a, this.j, fy5Var.q());
            f07.g(fy5Var.a, fy5Var.r(), fy5Var.q());
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

    @Override // com.repackage.qi5
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
