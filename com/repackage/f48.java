package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b00;
import com.repackage.m00;
import com.repackage.qy;
/* loaded from: classes6.dex */
public class f48 extends ho<fy5, ThreadCardViewHolder<fy5>> implements qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public tx5<fy5> o;

    /* loaded from: classes6.dex */
    public class a extends tx5<fy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(f48 f48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f48Var};
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
        @Override // com.repackage.tx5
        /* renamed from: d */
        public void a(View view2, fy5 fy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fy5Var) == null) || view2 == null || fy5Var == null || fy5Var.getThreadData() == null || view2.getId() != R.id.obfuscated_res_0x7f090a6b) {
                return;
            }
            m38.a(view2, fy5Var, 7);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wz a;
        public final /* synthetic */ f48 b;

        public b(f48 f48Var, wz wzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f48Var, wzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f48Var;
            this.a = wzVar;
        }

        @Override // com.repackage.qy.a
        public void a(pn4 pn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pn4Var) == null) || pn4Var == null || pn4Var.getThreadData() == null || pn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(pn4Var.getThreadData().originalThreadData, this.b.a, 4);
            m38.a(this.a.g(), pn4Var, 6);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e00 a;
        public final /* synthetic */ f48 b;

        public c(f48 f48Var, e00 e00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f48Var, e00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f48Var;
            this.a = e00Var;
        }

        @Override // com.repackage.qy.a
        public void a(pn4 pn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pn4Var) == null) || pn4Var == null || pn4Var.getThreadData() == null || pn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(pn4Var.getThreadData().originalThreadData, this.b.a, 4);
            m38.a(this.a.g(), pn4Var, 6);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f48 a;

        public d(f48 f48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f48Var;
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
                ThreadCardUtils.jumpToPB((pn4) fy5Var, view2.getContext(), 4, false);
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f48(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: c0 */
    public ThreadCardViewHolder<fy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.j.getPageActivity());
            ty tyVar = new ty(this.j.getPageActivity());
            tyVar.t(this.i);
            tyVar.c(1024);
            tyVar.c(32768);
            int i = this.l;
            if (i > 0) {
                tyVar.b(i);
            }
            tyVar.r(false);
            tyVar.w(false);
            bVar.o(tyVar);
            wz wzVar = new wz(this.j);
            wzVar.n(Boolean.FALSE);
            wzVar.v(ImageViewerConfig.FROM_CONCERN);
            wzVar.r(oi.f(this.a, R.dimen.tbds9));
            bVar.n(wzVar);
            bVar.l().h(oi.f(this.a, R.dimen.tbds25));
            wz wzVar2 = new wz(this.j);
            wzVar2.n(Boolean.TRUE);
            wzVar2.v(ImageViewerConfig.FROM_CONCERN);
            wzVar2.y(HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            wzVar2.w(new b(this, wzVar2));
            bVar.h(wzVar2);
            e00 e00Var = new e00(this.j.getPageActivity());
            e00Var.n(Boolean.TRUE);
            e00Var.u(new c(this, e00Var));
            bVar.h(e00Var);
            bVar.h(new az(this.j.getPageActivity()));
            d00 d00Var = new d00(this.j.getPageActivity());
            d00Var.b(32);
            d00Var.w(false);
            vn4 vn4Var = new vn4();
            vn4Var.b = 3;
            vn4Var.h = 3;
            d00Var.v(vn4Var);
            d00Var.x(8);
            d00Var.C(6);
            d00Var.y(4);
            bVar.m(d00Var);
            b00 i2 = bVar.i();
            i2.r(4);
            ThreadCardViewHolder<fy5> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.k(this.i);
            threadCardViewHolder.t(this.m);
            V(new d(this));
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fy5Var, threadCardViewHolder})) == null) {
            if (fy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || fy5Var.a == null) {
                return null;
            }
            fy5Var.I(fy5Var.position + 1);
            threadCardViewHolder.c().b(this.k);
            if (!this.n) {
                threadCardViewHolder.u();
            }
            threadCardViewHolder.g(fy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.o);
            m38.b(fy5Var);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.n = z;
        }
    }

    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.repackage.qi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.k = str;
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    public void h0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }
}
