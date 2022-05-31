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
import com.repackage.iy;
import com.repackage.pw;
import com.repackage.xx;
/* loaded from: classes6.dex */
public class gw6 extends xq6<zw5, ThreadCardViewHolder<zw5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public dx6 l;
    public String m;
    public pn n;
    public NEGFeedBackView.b o;
    public nw5<zw5> p;

    /* loaded from: classes6.dex */
    public class a extends nw5<zw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw6 b;

        public a(gw6 gw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, zw5 zw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zw5Var) == null) {
                gw5.b().d(true);
                ai5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.l == null || zw5Var == null || zw5Var.getThreadData() == null || StringUtils.isNull(zw5Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !gv6.b(jg.g(zw5Var.getThreadData().getTid(), 0L))) {
                    gv6.a(jg.g(zw5Var.getThreadData().getTid(), 0L));
                    this.b.l.e(jg.g(zw5Var.getThreadData().getTid(), 0L), zw5Var.D(), zw5Var.r(), zw5Var.q(), zw5Var.e(), jg.e((String) view2.getTag(), 1), "homepage", zw5Var.getThreadData().getBaijiahaoData());
                }
                this.b.h0(view2, zw5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements pw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(gw6 gw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.pw.b
        public void a(om4 om4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, om4Var, view2) == null) || om4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092298) {
                om4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092278) {
                om4Var.objType = 4;
            } else {
                om4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw6 a;

        public c(gw6 gw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof zw5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zw5 zw5Var = (zw5) jnVar;
                zw5Var.f = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.b(), zw5Var);
                }
                if (lx6.a(this.a.k, zw5Var)) {
                    return;
                }
                ThreadCardUtils.jumpToPB((om4) zw5Var, view2.getContext(), 2, false, qw.a((pn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gw6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            zw5.S = "c10730";
            zw5.T = "c10731";
            zw5.U = "c10704";
            zw5.V = "c10755";
            zw5.W = "c10710";
            zw5.X = "c10736";
            zw5.Y = "c10737";
            zw5.Z = "c10711";
            zw5.g0 = "c10758";
            zw5.h0 = "c10757";
            zw5.k0 = "c10734";
            zw5.l0 = "c10708";
            zw5.m0 = "c10735";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: f0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.k.getPageActivity());
            pw pwVar = new pw(this.k.getPageActivity());
            pwVar.t(this.j);
            pwVar.c(1024);
            pwVar.s(new b(this));
            pwVar.v(this.k);
            bVar.o(pwVar);
            xx k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.n);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.j);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: g0 */
    public View S(int i, View view2, ViewGroup viewGroup, zw5 zw5Var, ThreadCardViewHolder<zw5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zw5Var, threadCardViewHolder})) == null) {
            if (zw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || zw5Var.a == null) {
                return null;
            }
            zw5Var.I(zw5Var.position + 1);
            zw5Var.a.statFloor = zw5Var.q();
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.m);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP, this.o);
            threadCardViewHolder.n(zw5Var.showFollowBtn(), this.i, true);
            threadCardViewHolder.g(zw5Var);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            gw5.b().a(zw5Var.B());
            ai5.c().a(zw5Var.B());
            jx6.h(zw5Var.a, this.j, zw5Var.q());
            jx6.g(zw5Var.a, zw5Var.r(), zw5Var.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void h0(View view2, zw5 zw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, zw5Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.obfuscated_res_0x7f091f85 || id == R.id.obfuscated_res_0x7f091f99) {
                if (ax5.R(zw5Var.a)) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(zw5Var.C()));
                } else {
                    TiebaStatic.log(zw5Var.A());
                }
                ai5.c().i("page_recommend", "clk_", zw5Var.A());
                jx6.c(zw5Var.a, zw5Var.r(), zw5Var.q(), 1);
                i = 1;
            } else {
                if (id == R.id.obfuscated_res_0x7f092278) {
                    TiebaStatic.log(zw5Var.S());
                    ai5.c().i("page_recommend", "clk_", zw5Var.S());
                    jx6.c(zw5Var.a, zw5Var.r(), zw5Var.q(), 4);
                } else if (id == R.id.obfuscated_res_0x7f092298) {
                    TiebaStatic.log(zw5Var.S());
                    ai5.c().i("page_recommend", "clk_", zw5Var.S());
                    jx6.c(zw5Var.a, zw5Var.r(), zw5Var.q(), 4);
                } else if (id == R.id.obfuscated_res_0x7f090a49) {
                    TiebaStatic.log(zw5Var.k());
                    ai5.c().i("page_recommend", "clk_", zw5Var.k());
                    i = 9;
                } else {
                    if (id == R.id.obfuscated_res_0x7f090c86) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        jx6.c(zw5Var.a, zw5Var.r(), zw5Var.q(), 1);
                    } else if (id != R.id.obfuscated_res_0x7f090c89 && id != R.id.obfuscated_res_0x7f090c8a) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f090c87) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(zw5Var.P());
                            ai5.c().i("page_recommend", "clk_", zw5Var.P());
                            jx6.c(zw5Var.a, zw5Var.r(), zw5Var.q(), 2);
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
                jx6.d(zw5Var.a, this.j, zw5Var.q(), i);
            }
        }
    }

    public void i0(dx6 dx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dx6Var) == null) {
            this.l = dx6Var;
        }
    }

    public void j0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pnVar) == null) {
            this.n = pnVar;
        }
    }
}
