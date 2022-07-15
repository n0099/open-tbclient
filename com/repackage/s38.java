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
import com.repackage.ny;
import com.repackage.tw;
/* loaded from: classes7.dex */
public class s38 extends an<wy5, AutoVideoCardViewHolder<wy5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public jy5<wy5> o;

    /* loaded from: classes7.dex */
    public class a extends jy5<wy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
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
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, wy5 wy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, wy5Var) == null) || view2 == null || wy5Var == null || wy5Var.getThreadData() == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09202a || id == R.id.obfuscated_res_0x7f0923dd) {
                s28.a(view2, wy5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f09166e) {
                s28.a(view2, wy5Var, 4);
            } else if (id == R.id.obfuscated_res_0x7f090a40) {
                s28.a(view2, wy5Var, 7);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, nn4Var, view2) == null) || view2 == null || nn4Var == null || view2.getId() == -1) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09232d || id == R.id.obfuscated_res_0x7f09230c) {
                s28.a(view2, nn4Var, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s38 a;

        public c(s38 s38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s38Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof wy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                wy5 wy5Var = (wy5) nnVar;
                wy5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), wy5Var);
                }
                ThreadCardUtils.jumpToPB((nn4) wy5Var, view2.getContext(), 4, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public d(s38 s38Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s38Var, viewGroup, view2, Integer.valueOf(i)};
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

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.k
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(uw.a((tn) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s38(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            vy5.n0 = "c13542";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: b0 */
    public AutoVideoCardViewHolder<wy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity());
            tw twVar = new tw(this.j.getPageActivity());
            twVar.u(this.i);
            twVar.d(1024);
            twVar.d(32768);
            int i = this.l;
            if (i > 0) {
                twVar.c(i);
            }
            twVar.s(false);
            twVar.x(false);
            twVar.t(new b(this));
            bVar.o(twVar);
            u58 u58Var = new u58(this.j.getPageActivity());
            u58Var.x(this.i);
            u58Var.u("profile");
            u58Var.y(null);
            bVar.n(u58Var);
            bVar.l().h(pi.f(this.a, R.dimen.tbds25));
            jx jxVar = new jx(this.j.getPageActivity());
            jxVar.x(true);
            bVar.h(jxVar);
            bVar.h(new yx(this.j.getPageActivity()));
            bVar.h(new rx(this.j.getPageActivity()));
            bVar.h(new ax(this.j.getPageActivity()));
            ey eyVar = new ey(this.j.getPageActivity());
            eyVar.c(32);
            eyVar.x(false);
            tn4 tn4Var = new tn4();
            tn4Var.b = 3;
            tn4Var.h = 3;
            eyVar.w(tn4Var);
            eyVar.y(8);
            eyVar.E("personalize_page");
            eyVar.D(6);
            eyVar.z(4);
            bVar.m(eyVar);
            cy i2 = bVar.i();
            AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(i2);
            autoVideoCardViewHolder.k(this.i);
            i2.p(this.o);
            i2.r(4);
            autoVideoCardViewHolder.s(this.m);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, wy5 wy5Var, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wy5Var, autoVideoCardViewHolder})) == null) {
            if (wy5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            wy5Var.I(wy5Var.position + 1);
            if (autoVideoCardViewHolder.c() != null) {
                autoVideoCardViewHolder.c().b(this.k);
            }
            if (!this.n) {
                autoVideoCardViewHolder.t();
            }
            if (autoVideoCardViewHolder.c().f() instanceof ey) {
                ((ey) autoVideoCardViewHolder.c().f()).C(new d(this, viewGroup, view2, i));
            }
            autoVideoCardViewHolder.g(wy5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            s28.b(wy5Var);
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

    @Override // com.repackage.ck5
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
