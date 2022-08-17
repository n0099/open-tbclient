package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
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
public class xu6 extends bn<n06, ThreadCardViewHolder<n06>> implements pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public un e;
    public b06<n06> f;

    /* loaded from: classes7.dex */
    public class a extends b06<n06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu6 b;

        public a(xu6 xu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xu6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, n06 n06Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, n06Var) == null) || view2 == null || n06Var == null || n06Var.getThreadData() == null || StringUtils.isNull(n06Var.getThreadData().getTid())) {
                return;
            }
            this.b.w(view2, n06Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu6 a;

        public b(xu6 xu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xu6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof n06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                n06 n06Var = (n06) onVar;
                n06Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), n06Var);
                }
                ThreadCardUtils.jumpToPB((fo4) n06Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().o(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xu6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = true;
        this.f = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: u */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity(), false);
            qx qxVar = new qx(this.b.getPageActivity());
            qxVar.r(ImageViewerConfig.FROM_CONCERN);
            qxVar.s(this.d);
            bVar.n(qxVar);
            dy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: v */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n06 n06Var, ThreadCardViewHolder<n06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n06Var, threadCardViewHolder})) == null) {
            if (n06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || n06Var.a == null) {
                return null;
            }
            n06Var.I(n06Var.position + 1);
            uz5.b().a(n06Var.f("c12351"));
            threadCardViewHolder.a().q(i);
            if (threadCardViewHolder.a() instanceof ol5) {
                threadCardViewHolder.a().b(this.c);
            }
            threadCardViewHolder.e(n06Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.f);
            qx qxVar = (qx) threadCardViewHolder.a().g();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qxVar.f.d.getLayoutParams();
            layoutParams.width = n06Var.j;
            layoutParams.height = n06Var.k;
            if (qxVar.f.d.getVisibility() != 8) {
                qxVar.f.d.setLayoutParams(layoutParams);
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void w(View view2, n06 n06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, n06Var) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f09212a) {
                nu6.b(view2, n06Var, 2);
            } else if (view2 instanceof TbImageView) {
                nu6.b(view2, n06Var, 3);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09212b || view2.getId() == R.id.obfuscated_res_0x7f09211d) {
                nu6.b(view2, n06Var, 2);
            }
        }
    }

    public void x(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, unVar) == null) {
            this.e = unVar;
        }
    }
}
