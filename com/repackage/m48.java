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
import com.repackage.cy;
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes6.dex */
public class m48 extends eo<hy5, AutoVideoCardViewHolder<hy5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public ux5<hy5> o;

    /* loaded from: classes6.dex */
    public class a extends ux5<hy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(m48 m48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m48Var};
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
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, hy5 hy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, hy5Var) == null) || view2 == null || hy5Var == null || hy5Var.getThreadData() == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091fe0 || id == R.id.obfuscated_res_0x7f0923a3) {
                m38.a(view2, hy5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f09161e) {
                m38.a(view2, hy5Var, 4);
            } else if (id == R.id.obfuscated_res_0x7f090a5f) {
                m38.a(view2, hy5Var, 7);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(m48 m48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m48Var};
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, zn4Var, view2) == null) || view2 == null || zn4Var == null || view2.getId() == -1) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0922f3 || id == R.id.obfuscated_res_0x7f0922d3) {
                m38.a(view2, zn4Var, 1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m48 a;

        public c(m48 m48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m48Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof hy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                hy5 hy5Var = (hy5) roVar;
                hy5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), hy5Var);
                }
                ThreadCardUtils.jumpToPB((zn4) hy5Var, view2.getContext(), 4, false, dy.a((xo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public d(m48 m48Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m48Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(dy.a((xo) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m48(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            gy5.n0 = "c13542";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public AutoVideoCardViewHolder<hy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity());
            cy cyVar = new cy(this.j.getPageActivity());
            cyVar.t(this.i);
            cyVar.c(1024);
            cyVar.c(32768);
            int i = this.l;
            if (i > 0) {
                cyVar.b(i);
            }
            cyVar.r(false);
            cyVar.w(false);
            cyVar.s(new b(this));
            bVar.o(cyVar);
            o68 o68Var = new o68(this.j.getPageActivity());
            o68Var.w(this.i);
            o68Var.t("profile");
            o68Var.x(null);
            bVar.n(o68Var);
            bVar.l().h(mi.f(this.a, R.dimen.tbds25));
            ry ryVar = new ry(this.j.getPageActivity());
            ryVar.w(true);
            bVar.h(ryVar);
            bVar.h(new gz(this.j.getPageActivity()));
            bVar.h(new zy(this.j.getPageActivity()));
            bVar.h(new jy(this.j.getPageActivity()));
            mz mzVar = new mz(this.j.getPageActivity());
            mzVar.b(32);
            mzVar.w(false);
            fo4 fo4Var = new fo4();
            fo4Var.b = 3;
            fo4Var.h = 3;
            mzVar.v(fo4Var);
            mzVar.x(8);
            mzVar.D("personalize_page");
            mzVar.C(6);
            mzVar.y(4);
            bVar.m(mzVar);
            kz i2 = bVar.i();
            AutoVideoCardViewHolder<hy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(i2);
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
    @Override // com.repackage.eo
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, hy5 hy5Var, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hy5Var, autoVideoCardViewHolder})) == null) {
            if (hy5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            hy5Var.I(hy5Var.position + 1);
            if (autoVideoCardViewHolder.c() != null) {
                autoVideoCardViewHolder.c().b(this.k);
            }
            if (!this.n) {
                autoVideoCardViewHolder.u();
            }
            if (autoVideoCardViewHolder.c().f() instanceof mz) {
                ((mz) autoVideoCardViewHolder.c().f()).B(new d(this, viewGroup, view2, i));
            }
            autoVideoCardViewHolder.g(hy5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            m38.b(hy5Var);
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

    @Override // com.repackage.ij5
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
