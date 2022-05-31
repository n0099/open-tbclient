package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy;
import com.repackage.pw;
import com.repackage.xx;
/* loaded from: classes7.dex */
public class t18 extends wm<ax5, AutoVideoCardViewHolder<ax5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public nw5<ax5> o;

    /* loaded from: classes7.dex */
    public class a extends nw5<ax5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, ax5 ax5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ax5Var) == null) || view2 == null || ax5Var == null || ax5Var.getThreadData() == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091f85 || id == R.id.obfuscated_res_0x7f092348) {
                t08.a(view2, ax5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f0915d3) {
                t08.a(view2, ax5Var, 4);
            } else if (id == R.id.obfuscated_res_0x7f090a49) {
                t08.a(view2, ax5Var, 7);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements pw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, om4Var, view2) == null) || view2 == null || om4Var == null || view2.getId() == -1) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f092298 || id == R.id.obfuscated_res_0x7f092278) {
                t08.a(view2, om4Var, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public c(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof ax5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ax5 ax5Var = (ax5) jnVar;
                ax5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), ax5Var);
                }
                ThreadCardUtils.jumpToPB((om4) ax5Var, view2.getContext(), 4, false, qw.a((pn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public d(t18 t18Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, viewGroup, view2, Integer.valueOf(i)};
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
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(qw.a((pn) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t18(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.l = 0;
        this.m = 0;
        this.o = new a(this);
        this.j = tbPageContext;
        a0();
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            zw5.n0 = "c13542";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public AutoVideoCardViewHolder<ax5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity());
            pw pwVar = new pw(this.j.getPageActivity());
            pwVar.t(this.i);
            pwVar.c(1024);
            pwVar.c(32768);
            int i = this.l;
            if (i > 0) {
                pwVar.b(i);
            }
            pwVar.r(false);
            pwVar.w(false);
            pwVar.s(new b(this));
            bVar.o(pwVar);
            v38 v38Var = new v38(this.j.getPageActivity());
            v38Var.w(this.i);
            v38Var.t("profile");
            v38Var.x(null);
            bVar.n(v38Var);
            bVar.l().h(li.f(this.a, R.dimen.tbds25));
            ex exVar = new ex(this.j.getPageActivity());
            exVar.w(true);
            bVar.h(exVar);
            bVar.h(new tx(this.j.getPageActivity()));
            bVar.h(new mx(this.j.getPageActivity()));
            bVar.h(new ww(this.j.getPageActivity()));
            zx zxVar = new zx(this.j.getPageActivity());
            zxVar.b(32);
            zxVar.w(false);
            um4 um4Var = new um4();
            um4Var.b = 3;
            um4Var.h = 3;
            zxVar.v(um4Var);
            zxVar.x(8);
            zxVar.D("personalize_page");
            zxVar.C(6);
            zxVar.y(4);
            bVar.m(zxVar);
            xx i2 = bVar.i();
            AutoVideoCardViewHolder<ax5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(i2);
            autoVideoCardViewHolder.k(this.i);
            i2.p(this.o);
            i2.r(4);
            autoVideoCardViewHolder.t(this.m);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, ax5 ax5Var, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ax5Var, autoVideoCardViewHolder})) == null) {
            if (ax5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            ax5Var.I(ax5Var.position + 1);
            if (autoVideoCardViewHolder.c() != null) {
                autoVideoCardViewHolder.c().b(this.k);
            }
            if (!this.n) {
                autoVideoCardViewHolder.u();
            }
            if (autoVideoCardViewHolder.c().f() instanceof zx) {
                ((zx) autoVideoCardViewHolder.c().f()).B(new d(this, viewGroup, view2, i));
            }
            autoVideoCardViewHolder.g(ax5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            t08.b(ax5Var);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.n = z;
        }
    }

    public void e0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m = i;
        }
    }

    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.k = str;
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.l = i;
        }
    }
}
