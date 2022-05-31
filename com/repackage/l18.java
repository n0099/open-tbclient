package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy;
import com.repackage.pw;
import com.repackage.xx;
/* loaded from: classes6.dex */
public class l18 extends wm<uw5, ThreadCardViewHolder<uw5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public nw5<uw5> o;

    /* loaded from: classes6.dex */
    public class a extends nw5<uw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(l18 l18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l18Var};
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
        public void a(View view2, uw5 uw5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, uw5Var) == null) || view2 == null || uw5Var == null || uw5Var.getThreadData() == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091f85 || id == R.id.obfuscated_res_0x7f0903cc) {
                t08.a(view2, uw5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f090a49) {
                t08.a(view2, uw5Var, 7);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements pw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l18 a;

        public b(l18 l18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l18Var;
        }

        @Override // com.repackage.pw.b
        public void a(om4 om4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, om4Var, view2) == null) {
                this.a.j0(view2, om4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends nw5<om4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l18 b;

        public c(l18 l18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, om4 om4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, om4Var) == null) {
                this.b.j0(view2, om4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l18 a;

        public d(l18 l18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l18Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.c0(view2, jnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l18(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        b0();
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            zw5.n0 = "c13542";
        }
    }

    public final void c0(View view2, jn jnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view2, jnVar) == null) && (jnVar instanceof uw5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            uw5 uw5Var = (uw5) jnVar;
            uw5Var.f = 1;
            ThreadCardUtils.jumpToPB((om4) uw5Var, view2.getContext(), 4, false);
            ((ThreadCardViewHolder) view2.getTag()).c().o(new iy.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public ThreadCardViewHolder<uw5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity());
            pw pwVar = new pw(this.j.getPageActivity());
            pwVar.t(this.i);
            pwVar.v(this.j);
            pwVar.c(32768);
            int i = this.l;
            if (i > 0) {
                pwVar.b(i);
            }
            pwVar.r(false);
            pwVar.w(false);
            pwVar.s(new b(this));
            bVar.o(pwVar);
            bVar.l().h(li.f(this.a, R.dimen.tbds25));
            nw nwVar = new nw(this.j.getPageActivity());
            nwVar.l(new c(this));
            bVar.n(nwVar);
            bVar.h(new ww(this.j.getPageActivity()));
            zx zxVar = new zx(this.j.getPageActivity());
            zxVar.b(32);
            zxVar.w(false);
            um4 um4Var = new um4();
            um4Var.b = 3;
            um4Var.h = 3;
            zxVar.v(um4Var);
            zxVar.x(8);
            zxVar.C(6);
            zxVar.y(4);
            bVar.m(zxVar);
            xx i2 = bVar.i();
            i2.r(4);
            ThreadCardViewHolder<uw5> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.k(this.i);
            threadCardViewHolder.t(this.m);
            V(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, uw5 uw5Var, ThreadCardViewHolder<uw5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uw5Var, threadCardViewHolder})) == null) {
            if (uw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            uw5Var.I(uw5Var.position + 1);
            threadCardViewHolder.c().b(this.k);
            if (!this.n) {
                threadCardViewHolder.u();
            }
            threadCardViewHolder.g(uw5Var);
            threadCardViewHolder.c().p(this.o);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            t08.b(uw5Var);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.k = str;
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
        }
    }

    public void h0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    public void i0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.l = i;
        }
    }

    public final void j0(View view2, om4 om4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view2, om4Var) == null) || view2 == null || om4Var == null || view2.getId() == -1) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f092298 || id == R.id.obfuscated_res_0x7f092278) {
            t08.a(view2, om4Var, 1);
        } else if (id == R.id.obfuscated_res_0x7f0906f3 || id == R.id.obfuscated_res_0x7f0903cc) {
            t08.a(view2, om4Var, 3);
        }
    }
}
