package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
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
public class ft6 extends eo<by5, ThreadCardViewHolder<by5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public xo l;
    public ux5<by5> m;

    /* loaded from: classes6.dex */
    public class a extends ux5<by5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft6 b;

        public a(ft6 ft6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ft6Var;
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
                this.b.e0(view2, by5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft6 a;

        public b(ft6 ft6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.b0(view2, roVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.m = new a(this);
        this.j = tbPageContext;
    }

    public final void b0(View view2, ro roVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, roVar) == null) && (roVar instanceof by5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            by5 by5Var = (by5) roVar;
            by5Var.f = 1;
            ThreadCardUtils.jumpToPB((zn4) by5Var, view2.getContext(), 1, false);
            ((ThreadCardViewHolder) view2.getTag()).c().o(new vz.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: c0 */
    public ThreadCardViewHolder<by5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity());
            cy cyVar = new cy(this.j.getPageActivity());
            cyVar.t(this.i);
            cyVar.v(this.j);
            bVar.o(cyVar);
            bVar.n(new ay(this.j.getPageActivity()));
            bVar.h(new jy(this.j.getPageActivity()));
            mz mzVar = new mz(this.j.getPageActivity());
            fo4 fo4Var = new fo4();
            fo4Var.b = 1;
            fo4Var.h = 1;
            mzVar.v(fo4Var);
            mzVar.x(9);
            mzVar.C(4);
            mzVar.y(1);
            mzVar.w(false);
            bVar.m(mzVar);
            bVar.l().h(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            kz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<by5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, by5 by5Var, ThreadCardViewHolder<by5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, by5Var, threadCardViewHolder})) == null) {
            if (by5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            by5Var.I(by5Var.position + 1);
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.k);
            threadCardViewHolder.v(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.l();
            threadCardViewHolder.g(by5Var);
            nx5.b().a(by5Var.g("c12351"));
            threadCardViewHolder.c().p(this.m);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void e0(View view2, by5 by5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, by5Var) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091fe0) {
                at6.b(view2, by5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f0922d3 || id == R.id.obfuscated_res_0x7f0922f3) {
                at6.b(view2, by5Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090710 || id == R.id.obfuscated_res_0x7f0903d1) {
                at6.b(view2, by5Var, 3);
            }
        }
    }

    public void f0(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xoVar) == null) {
            this.l = xoVar;
        }
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.k = str;
        }
    }
}
