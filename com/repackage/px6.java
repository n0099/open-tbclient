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
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes6.dex */
public class px6 extends ts6<gy5, ThreadCardViewHolder<gy5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public NEGFeedBackView.b l;
    public String m;
    public boolean n;
    public ux5<gy5> o;

    /* loaded from: classes6.dex */
    public class a extends ux5<gy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px6 b;

        public a(px6 px6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = px6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, gy5 gy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gy5Var) == null) {
                int i = 1;
                nx5.b().d(true);
                gj5.c().h("page_recommend", "show_");
                if (gy5Var == null || gy5Var.getThreadData() == null || li.isEmpty(gy5Var.getThreadData().getTid())) {
                    return;
                }
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091fe0) {
                    TiebaStatic.log(gy5Var.A());
                    gj5.c().i("page_recommend", "clk_", gy5Var.A());
                    fz6.c(gy5Var.a, gy5Var.r(), gy5Var.q(), 1);
                } else if (id == R.id.obfuscated_res_0x7f091ff4) {
                    TiebaStatic.log(gy5Var.A());
                    gj5.c().i("page_recommend", "clk_", gy5Var.A());
                    fz6.c(gy5Var.a, gy5Var.r(), gy5Var.q(), 1);
                    i = 5;
                } else {
                    if (id == R.id.obfuscated_res_0x7f091fe2) {
                        TiebaStatic.log(gy5Var.T());
                        gj5.c().i("page_recommend", "clk_", gy5Var.T());
                    } else {
                        if (id == R.id.obfuscated_res_0x7f0922d3) {
                            TiebaStatic.log(gy5Var.S());
                            gj5.c().i("page_recommend", "clk_", gy5Var.S());
                            fz6.c(gy5Var.a, gy5Var.r(), gy5Var.q(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f0922f3) {
                            TiebaStatic.log(gy5Var.S());
                            gj5.c().i("page_recommend", "clk_", gy5Var.S());
                            fz6.c(gy5Var.a, gy5Var.r(), gy5Var.q(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f090a5f) {
                            TiebaStatic.log(gy5Var.k());
                            gj5.c().i("page_recommend", "clk_", gy5Var.k());
                        } else if (id == R.id.obfuscated_res_0x7f090cc7) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.obfuscated_res_0x7f090cc2) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            fz6.c(gy5Var.a, gy5Var.r(), gy5Var.q(), 1);
                        } else if (id != R.id.obfuscated_res_0x7f090cc5 && id != R.id.obfuscated_res_0x7f090cc6) {
                            if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f090cc3) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(gy5Var.P());
                                gj5.c().i("page_recommend", "clk_", gy5Var.P());
                                fz6.c(gy5Var.a, gy5Var.r(), gy5Var.q(), 2);
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
                    fz6.d(gy5Var.a, this.b.j, gy5Var.q(), i);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(px6 px6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cy.b
        public void a(zn4 zn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, zn4Var, view2) == null) || zn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0922f3) {
                zn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0922d3) {
                zn4Var.objType = 4;
            } else {
                zn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px6 a;

        public c(px6 px6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = px6Var;
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
                ThreadCardUtils.jumpToPB((zn4) gy5Var, view2.getContext(), 2, false);
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            gy5.R = "c10705";
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
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: c0 */
    public ThreadCardViewHolder<gy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.k.getPageActivity());
            cy cyVar = new cy(this.k.getPageActivity());
            cyVar.t(this.j);
            cyVar.c(1024);
            cyVar.s(new b(this));
            bVar.o(cyVar);
            bVar.n(new sy(this.k.getPageActivity()));
            bVar.h(new jy(this.k.getPageActivity()));
            my myVar = new my(this.k.getPageActivity());
            myVar.x(this.n);
            myVar.w("index");
            myVar.y(new StatisticItem("c13342"));
            bVar.h(myVar);
            mz mzVar = new mz(this.k.getPageActivity());
            fo4 fo4Var = new fo4();
            fo4Var.b = 1;
            fo4Var.h = 1;
            mzVar.v(fo4Var);
            mzVar.x(1);
            mzVar.C(3);
            mzVar.y(2);
            mzVar.w(false);
            bVar.m(mzVar);
            kz i = bVar.i();
            i.r(2);
            ThreadCardViewHolder<gy5> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.k(this.j);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, gy5 gy5Var, ThreadCardViewHolder<gy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gy5Var, threadCardViewHolder})) == null) {
            if (gy5Var == null || threadCardViewHolder == null || threadCardViewHolder.c() == null) {
                return null;
            }
            gy5Var.I(gy5Var.position + 1);
            gy5Var.a.statFloor = gy5Var.q();
            nx5.b().a(gy5Var.O("c12190"));
            if (threadCardViewHolder.c() instanceof hj5) {
                threadCardViewHolder.c().b(this.m);
            }
            az r = threadCardViewHolder.r(true);
            r.u(this.l);
            threadCardViewHolder.m(gy5Var.showFollowBtn(), this.i);
            r.a(gy5Var.getNegFeedBackData());
            threadCardViewHolder.g(gy5Var);
            threadCardViewHolder.j(this.o);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            fz6.h(gy5Var.a, this.j, gy5Var.q());
            fz6.g(gy5Var.a, gy5Var.r(), gy5Var.q());
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

    @Override // com.repackage.ij5
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
