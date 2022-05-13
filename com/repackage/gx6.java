package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes6.dex */
public class gx6 extends ts6<by5, ThreadCardViewHolder<by5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public String l;
    public NEGFeedBackView.b m;
    public xo n;
    public ux5<by5> o;

    /* loaded from: classes6.dex */
    public class a extends ux5<by5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx6 b;

        public a(gx6 gx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, by5 by5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, by5Var) == null) {
                nx5.b().d(true);
                gj5.c().h("page_recommend", "show_");
                if (view2 == null || by5Var == null || by5Var.getThreadData() == null || StringUtils.isNull(by5Var.getThreadData().getTid())) {
                    return;
                }
                this.b.f0(view2, by5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx6 a;

        public b(gx6 gx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gx6Var;
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
    public gx6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.k = tbPageContext;
    }

    public final void c0(View view2, ro roVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, roVar) == null) && (roVar instanceof by5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            by5 by5Var = (by5) roVar;
            by5Var.f = 1;
            ThreadCardUtils.jumpToPB((zn4) by5Var, view2.getContext(), 2, false);
            ((ThreadCardViewHolder) view2.getTag()).c().o(new vz.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: d0 */
    public ThreadCardViewHolder<by5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.k.getPageActivity());
            cy cyVar = new cy(this.k.getPageActivity());
            cyVar.t(this.j);
            cyVar.v(this.k);
            bVar.o(cyVar);
            bVar.n(new ay(this.k.getPageActivity()));
            bVar.h(new jy(this.k.getPageActivity()));
            mz mzVar = new mz(this.k.getPageActivity());
            fo4 fo4Var = new fo4();
            fo4Var.b = 1;
            fo4Var.h = 1;
            mzVar.v(fo4Var);
            mzVar.x(1);
            mzVar.C(3);
            mzVar.y(2);
            mzVar.w(false);
            bVar.m(mzVar);
            bVar.l().h(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            kz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.n);
            k.r(2);
            ThreadCardViewHolder<by5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.j);
            V(new b(this));
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, by5Var, threadCardViewHolder})) == null) {
            if (by5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            by5Var.I(by5Var.position + 1);
            by5Var.a.statFloor = by5Var.q();
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.l);
            threadCardViewHolder.r(true).u(this.m);
            threadCardViewHolder.m(by5Var.showFollowBtn(), this.i);
            threadCardViewHolder.g(by5Var);
            threadCardViewHolder.c().p(this.o);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            nx5.b().a(by5Var.B());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(View view2, by5 by5Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, view2, by5Var) != null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091fe0) {
            TiebaStatic.log(by5Var.A());
        } else if (id == R.id.obfuscated_res_0x7f0922d3 || id == R.id.obfuscated_res_0x7f0922f3) {
            i = 2;
            if (i == 0) {
                fz6.d(by5Var.a, this.j, by5Var.q(), i);
                return;
            }
            return;
        }
        i = 0;
        if (i == 0) {
        }
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
        }
    }

    public void g0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void h0(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xoVar) == null) {
            this.n = xoVar;
        }
    }
}
