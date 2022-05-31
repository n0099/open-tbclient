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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy;
import com.repackage.xx;
/* loaded from: classes5.dex */
public class aw6 extends wm<zw5, ThreadCardViewHolder<zw5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public dx6 k;
    public String l;
    public pn m;
    public NEGFeedBackView.b n;
    public nw5<zw5> o;

    /* loaded from: classes5.dex */
    public class a extends nw5<zw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw6 b;

        public a(aw6 aw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, zw5 zw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zw5Var) == null) {
                gw5.b().d(true);
                ai5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.k == null || zw5Var == null || zw5Var.getThreadData() == null || StringUtils.isNull(zw5Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !gv6.b(jg.g(zw5Var.getThreadData().getTid(), 0L))) {
                    gv6.a(jg.g(zw5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(jg.g(zw5Var.getThreadData().getTid(), 0L), zw5Var.D(), zw5Var.r(), zw5Var.q(), zw5Var.e(), jg.e((String) view2.getTag(), 1), "homepage", zw5Var.getThreadData().getBaijiahaoData());
                }
                this.b.f0(view2, zw5Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw6 a;

        public b(aw6 aw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof zw5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zw5 zw5Var = (zw5) jnVar;
                zw5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), zw5Var);
                }
                ThreadCardUtils.jumpToPB((om4) zw5Var, view2.getContext(), 2, false, qw.a((pn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ zw5 d;

        public c(aw6 aw6Var, ViewGroup viewGroup, View view2, int i, zw5 zw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw6Var, viewGroup, view2, Integer.valueOf(i), zw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
            this.d = zw5Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(qw.a((pn) this.a, this.b, this.c));
                if (this.d.getThreadData() == null || this.d.getThreadData().getSmartApp() == null) {
                    return;
                }
                StatisticItem s = this.d.s(zw5.j0);
                s.param("obj_type", this.d.getThreadData().getSmartApp().id);
                s.param("obj_name", this.d.getThreadData().getSmartApp().name);
                TiebaStatic.log(s);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.o = new a(this);
        this.j = tbPageContext;
        c0();
    }

    public final void c0() {
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
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity(), false);
            zx zxVar = new zx(this.j.getPageActivity());
            um4 um4Var = new um4();
            um4Var.b = 1;
            um4Var.h = 1;
            zxVar.v(um4Var);
            zxVar.x(1);
            zxVar.D("personalize_page");
            zxVar.C(3);
            zxVar.y(2);
            zxVar.b(32);
            zxVar.w(false);
            bVar.m(zxVar);
            xx k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.m);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, zw5 zw5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zw5Var, threadCardViewHolder})) == null) {
            if (zw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || zw5Var.a == null) {
                return null;
            }
            zw5Var.I(zw5Var.position + 1);
            zw5Var.a.statFloor = zw5Var.q();
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.l);
            if (threadCardViewHolder.c().f() instanceof zx) {
                ((zx) threadCardViewHolder.c().f()).B(new c(this, viewGroup, view2, i, zw5Var));
            }
            threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM, this.n);
            threadCardViewHolder.g(zw5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.o);
            gw5.b().a(zw5Var.B());
            ai5.c().a(zw5Var.B());
            jx6.h(zw5Var.a, this.i, zw5Var.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(View view2, zw5 zw5Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, view2, zw5Var) != null) {
            return;
        }
        int id = view2.getId();
        int i = 5;
        if (view2.getId() == R.id.obfuscated_res_0x7f091f85 || id == R.id.obfuscated_res_0x7f091f99) {
            if (ax5.R(zw5Var.a)) {
                A = zw5Var.C();
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
            } else {
                A = zw5Var.A();
                TiebaStatic.log(A);
            }
            ai5.c().i("page_recommend", "clk_", A);
            jx6.c(zw5Var.a, zw5Var.r(), zw5Var.q(), 1);
        } else if (id == R.id.obfuscated_res_0x7f091f87) {
            TiebaStatic.log(zw5Var.T());
            ai5.c().i("page_recommend", "clk_", zw5Var.T());
        } else {
            if (id == R.id.obfuscated_res_0x7f092278) {
                TiebaStatic.log(zw5Var.S());
                ai5.c().i("page_recommend", "clk_", zw5Var.S());
            } else if (id != R.id.obfuscated_res_0x7f092298) {
                if (id == R.id.obfuscated_res_0x7f090a49) {
                    TiebaStatic.log(zw5Var.k());
                    ai5.c().i("page_recommend", "clk_", zw5Var.k());
                    i = 9;
                } else if (id == R.id.obfuscated_res_0x7f090c8b) {
                    StatisticItem statisticItem = new StatisticItem("c10760");
                    statisticItem.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090c86) {
                    StatisticItem statisticItem2 = new StatisticItem("c10760");
                    statisticItem2.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem2);
                    jx6.c(zw5Var.a, zw5Var.r(), zw5Var.q(), 1);
                } else if (id == R.id.obfuscated_res_0x7f090c89 || id == R.id.obfuscated_res_0x7f090c8a) {
                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                } else {
                    i = 0;
                }
                if (i != 0) {
                    jx6.d(zw5Var.a, this.i, zw5Var.q(), i);
                    return;
                }
                return;
            } else {
                TiebaStatic.log(zw5Var.S());
                ai5.c().i("page_recommend", "clk_", zw5Var.S());
            }
            i = 2;
            if (i != 0) {
            }
        }
        i = 1;
        if (i != 0) {
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
        }
    }

    public void g0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void h0(dx6 dx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dx6Var) == null) {
            this.k = dx6Var;
        }
    }

    public void i0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pnVar) == null) {
            this.m = pnVar;
        }
    }
}
