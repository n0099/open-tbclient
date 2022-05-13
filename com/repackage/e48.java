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
import com.repackage.cy;
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes5.dex */
public class e48 extends eo<by5, ThreadCardViewHolder<by5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public ux5<by5> o;

    /* loaded from: classes5.dex */
    public class a extends ux5<by5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e48 e48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e48Var};
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
        public void a(View view2, by5 by5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, by5Var) == null) || view2 == null || by5Var == null || by5Var.getThreadData() == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091fe0 || id == R.id.obfuscated_res_0x7f0903d1) {
                m38.a(view2, by5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f090a5f) {
                m38.a(view2, by5Var, 7);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements cy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e48 a;

        public b(e48 e48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e48Var;
        }

        @Override // com.repackage.cy.b
        public void a(zn4 zn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, zn4Var, view2) == null) {
                this.a.j0(view2, zn4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends ux5<zn4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e48 b;

        public c(e48 e48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, zn4 zn4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zn4Var) == null) {
                this.b.j0(view2, zn4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e48 a;

        public d(e48 e48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e48Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.c0(view2, roVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e48(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            gy5.n0 = "c13542";
        }
    }

    public final void c0(View view2, ro roVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view2, roVar) == null) && (roVar instanceof by5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            by5 by5Var = (by5) roVar;
            by5Var.f = 1;
            ThreadCardUtils.jumpToPB((zn4) by5Var, view2.getContext(), 4, false);
            ((ThreadCardViewHolder) view2.getTag()).c().o(new vz.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: d0 */
    public ThreadCardViewHolder<by5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity());
            cy cyVar = new cy(this.j.getPageActivity());
            cyVar.t(this.i);
            cyVar.v(this.j);
            cyVar.c(32768);
            int i = this.l;
            if (i > 0) {
                cyVar.b(i);
            }
            cyVar.r(false);
            cyVar.w(false);
            cyVar.s(new b(this));
            bVar.o(cyVar);
            bVar.l().h(mi.f(this.a, R.dimen.tbds25));
            ay ayVar = new ay(this.j.getPageActivity());
            ayVar.l(new c(this));
            bVar.n(ayVar);
            bVar.h(new jy(this.j.getPageActivity()));
            mz mzVar = new mz(this.j.getPageActivity());
            mzVar.b(32);
            mzVar.w(false);
            fo4 fo4Var = new fo4();
            fo4Var.b = 3;
            fo4Var.h = 3;
            mzVar.v(fo4Var);
            mzVar.x(8);
            mzVar.C(6);
            mzVar.y(4);
            bVar.m(mzVar);
            kz i2 = bVar.i();
            i2.r(4);
            ThreadCardViewHolder<by5> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.k(this.i);
            threadCardViewHolder.t(this.m);
            V(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, by5 by5Var, ThreadCardViewHolder<by5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, by5Var, threadCardViewHolder})) == null) {
            if (by5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            by5Var.I(by5Var.position + 1);
            threadCardViewHolder.c().b(this.k);
            if (!this.n) {
                threadCardViewHolder.u();
            }
            threadCardViewHolder.g(by5Var);
            threadCardViewHolder.c().p(this.o);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            m38.b(by5Var);
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

    @Override // com.repackage.ij5
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

    public final void j0(View view2, zn4 zn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view2, zn4Var) == null) || view2 == null || zn4Var == null || view2.getId() == -1) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f0922f3 || id == R.id.obfuscated_res_0x7f0922d3) {
            m38.a(view2, zn4Var, 1);
        } else if (id == R.id.obfuscated_res_0x7f090710 || id == R.id.obfuscated_res_0x7f0903d1) {
            m38.a(view2, zn4Var, 3);
        }
    }
}
