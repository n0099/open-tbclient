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
import com.repackage.dy;
import com.repackage.oy;
import com.repackage.uw;
/* loaded from: classes7.dex */
public class y58 extends bn<o06, AutoVideoCardViewHolder<o06>> implements pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public b06<o06> g;

    /* loaded from: classes7.dex */
    public class a extends b06<o06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(y58 y58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y58Var};
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
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, o06 o06Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o06Var) == null) || view2 == null || o06Var == null || o06Var.getThreadData() == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09212a || id == R.id.obfuscated_res_0x7f092502) {
                y48.a(view2, o06Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f09170f) {
                y48.a(view2, o06Var, 4);
            } else if (id == R.id.obfuscated_res_0x7f090a74) {
                y48.a(view2, o06Var, 7);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements uw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(y58 y58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y58Var};
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, fo4Var, view2) == null) || view2 == null || fo4Var == null || view2.getId() == -1) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f092450 || id == R.id.obfuscated_res_0x7f092422) {
                y48.a(view2, fo4Var, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y58 a;

        public c(y58 y58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y58Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof o06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o06 o06Var = (o06) onVar;
                o06Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), o06Var);
                }
                ThreadCardUtils.jumpToPB((fo4) o06Var, view2.getContext(), 4, false, vw.a((un) viewGroup, view2, i));
                threadCardViewHolder.a().o(new oy.a(1));
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

        public d(y58 y58Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y58Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(vw.a((un) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y58(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = 0;
        this.e = 0;
        this.g = new a(this);
        this.b = tbPageContext;
        t();
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n06.h0 = "c13542";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: u */
    public AutoVideoCardViewHolder<o06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity());
            uw uwVar = new uw(this.b.getPageActivity());
            uwVar.u(this.a);
            uwVar.d(1024);
            uwVar.d(32768);
            int i = this.d;
            if (i > 0) {
                uwVar.c(i);
            }
            uwVar.s(false);
            uwVar.x(false);
            uwVar.t(new b(this));
            bVar.o(uwVar);
            a88 a88Var = new a88(this.b.getPageActivity());
            a88Var.x(this.a);
            a88Var.u("profile");
            a88Var.y(null);
            bVar.n(a88Var);
            bVar.l().h(qi.f(this.mContext, R.dimen.tbds25));
            kx kxVar = new kx(this.b.getPageActivity());
            kxVar.x(true);
            bVar.h(kxVar);
            bVar.h(new zx(this.b.getPageActivity()));
            bVar.h(new sx(this.b.getPageActivity()));
            bVar.h(new bx(this.b.getPageActivity()));
            fy fyVar = new fy(this.b.getPageActivity());
            fyVar.c(32);
            fyVar.x(false);
            lo4 lo4Var = new lo4();
            lo4Var.b = 3;
            lo4Var.h = 3;
            fyVar.w(lo4Var);
            fyVar.y(8);
            fyVar.E("personalize_page");
            fyVar.D(6);
            fyVar.z(4);
            bVar.m(fyVar);
            dy i2 = bVar.i();
            AutoVideoCardViewHolder<o06> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(i2);
            autoVideoCardViewHolder.i(this.a);
            i2.p(this.g);
            i2.r(4);
            autoVideoCardViewHolder.q(this.e);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: v */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o06 o06Var, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o06Var, autoVideoCardViewHolder})) == null) {
            if (o06Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            o06Var.I(o06Var.position + 1);
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.c);
            }
            if (!this.f) {
                autoVideoCardViewHolder.r();
            }
            if (autoVideoCardViewHolder.a().f() instanceof fy) {
                ((fy) autoVideoCardViewHolder.a().f()).C(new d(this, viewGroup, view2, i));
            }
            autoVideoCardViewHolder.e(o06Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            y48.b(o06Var);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f = z;
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.e = i;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.d = i;
        }
    }
}
