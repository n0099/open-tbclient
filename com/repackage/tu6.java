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
import com.repackage.dy;
import com.repackage.oy;
/* loaded from: classes7.dex */
public class tu6 extends bn<i06, ThreadCardViewHolder<i06>> implements pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public un d;
    public b06<i06> e;

    /* loaded from: classes7.dex */
    public class a extends b06<i06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu6 b;

        public a(tu6 tu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tu6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, i06 i06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i06Var) == null) {
                uz5.b().d(true);
                nl5.c().h("page_recommend", "show_");
                if (view2 == null || i06Var == null || i06Var.getThreadData() == null || StringUtils.isNull(i06Var.getThreadData().getTid())) {
                    return;
                }
                this.b.x(view2, i06Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu6 a;

        public b(tu6 tu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tu6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.u(view2, onVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tu6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public final void u(View view2, on onVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view2, onVar) == null) && (onVar instanceof i06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            i06 i06Var = (i06) onVar;
            i06Var.f = 1;
            ThreadCardUtils.jumpToPB((fo4) i06Var, view2.getContext(), 1, false);
            ((ThreadCardViewHolder) view2.getTag()).a().o(new oy.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: v */
    public ThreadCardViewHolder<i06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity());
            uw uwVar = new uw(this.b.getPageActivity());
            uwVar.u(this.a);
            uwVar.w(this.b);
            bVar.o(uwVar);
            bVar.n(new sw(this.b.getPageActivity()));
            bVar.h(new bx(this.b.getPageActivity()));
            fy fyVar = new fy(this.b.getPageActivity());
            lo4 lo4Var = new lo4();
            lo4Var.b = 1;
            lo4Var.h = 1;
            fyVar.w(lo4Var);
            fyVar.y(9);
            fyVar.D(4);
            fyVar.z(1);
            fyVar.x(false);
            bVar.m(fyVar);
            bVar.l().h(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            dy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<i06> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, i06 i06Var, ThreadCardViewHolder<i06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, i06Var, threadCardViewHolder})) == null) {
            if (i06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            i06Var.I(i06Var.position + 1);
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.a().b(this.c);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.j();
            threadCardViewHolder.e(i06Var);
            uz5.b().a(i06Var.f("c12351"));
            threadCardViewHolder.a().p(this.e);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void x(View view2, i06 i06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, i06Var) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09212a) {
                nu6.b(view2, i06Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f092422 || id == R.id.obfuscated_res_0x7f092450) {
                nu6.b(view2, i06Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090702 || id == R.id.obfuscated_res_0x7f0903e4) {
                nu6.b(view2, i06Var, 3);
            }
        }
    }

    public void y(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, unVar) == null) {
            this.d = unVar;
        }
    }
}
