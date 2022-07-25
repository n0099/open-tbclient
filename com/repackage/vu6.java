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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.ny;
/* loaded from: classes7.dex */
public class vu6 extends an<wy5, AutoVideoCardViewHolder<wy5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public BdUniqueId j;
    public tn k;
    public ky l;
    public int m;
    public jy5<wy5> n;

    /* loaded from: classes7.dex */
    public class a extends jy5<wy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu6 b;

        public a(vu6 vu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vu6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, wy5 wy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, wy5Var) == null) {
                this.b.c0(view2, wy5Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu6 a;

        public b(vu6 vu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vu6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof wy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                wy5 wy5Var = (wy5) nnVar;
                wy5Var.f = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.a(), wy5Var);
                }
                fv6.b(wy5Var, view2.getContext(), 18, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.b().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vu6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = new a(this);
        this.i = tbPageContext;
    }

    public final s68 b0(wy5 wy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wy5Var)) == null) {
            if (wy5Var != null) {
                s68 s68Var = new s68();
                s68Var.a = "17";
                s68Var.c = wy5Var.g;
                if (wy5Var.getThreadData() != null) {
                    s68Var.d = String.valueOf(wy5Var.getThreadData().getFid());
                    if (wy5Var.getThreadData().getThreadVideoInfo() != null) {
                        s68Var.m = wy5Var.getThreadData().getThreadVideoInfo().video_md5;
                        s68Var.p = String.valueOf(wy5Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                s68Var.k = wy5Var.g();
                s68Var.f = wy5Var.o();
                s68Var.l = wy5Var.c();
                s68Var.h = wy5Var.D();
                s68Var.e = TbadkCoreApplication.getCurrentAccount();
                s68Var.q = String.valueOf(wy5Var.m());
                s68Var.r = String.valueOf(this.m);
                return s68Var;
            }
            return null;
        }
        return (s68) invokeL.objValue;
    }

    public final void c0(View view2, wy5 wy5Var) {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, wy5Var) == null) || (kyVar = this.l) == null || kyVar.p() == null || this.l.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.l.p().getMainView().getId()) {
            fv6.d(wy5Var, this.m);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09202e) {
            fv6.d(wy5Var, this.m);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public AutoVideoCardViewHolder<wy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.i.getPageActivity(), false);
            tx txVar = new tx(this.i.getPageActivity());
            this.l = txVar;
            txVar.x(this.j);
            this.l.u(ImageViewerConfig.FROM_GAME_VIDEO);
            this.l.y("2001");
            bVar.n(this.l);
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.k);
            AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.j);
            k.p(this.n);
            k.r(18);
            V(new b(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, wy5 wy5Var, AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wy5Var, autoVideoCardViewHolder})) == null) {
            if (wy5Var == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            wy5Var.I(wy5Var.position + 1);
            autoVideoCardViewHolder.b().q(i);
            fv6.c(wy5Var, this.m);
            autoVideoCardViewHolder.v(b0(wy5Var));
            autoVideoCardViewHolder.f(wy5Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.n);
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m = i;
        }
    }

    public void g0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
        }
    }

    public void h0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tnVar) == null) {
            this.k = tnVar;
        }
    }

    public void onPause() {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (kyVar = this.l) == null) {
            return;
        }
        kyVar.s();
    }
}
