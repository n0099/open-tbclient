package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes6.dex */
public class m07 extends eo<br4, ThreadCardViewHolder<br4>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public String j;
    public String k;
    public TbPageContext<?> l;
    public xo m;
    public ux5<br4> n;
    public NEGFeedBackView.b o;
    public FollowUserButton.a p;

    /* loaded from: classes6.dex */
    public class a extends ux5<br4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m07 b;

        public a(m07 m07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, br4 br4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, br4Var) == null) {
                nx5.b().d(true);
                rz6.j(view2, br4Var, this.b.j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(m07 m07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cy.b
        public void a(zn4 zn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, zn4Var, view2) == null) || zn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0922f3) {
                zn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0922d3) {
                zn4Var.objType = 4;
            } else {
                zn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m07 a;

        public c(m07 m07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m07Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof br4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                br4 br4Var = (br4) roVar;
                ThreadData threadData = br4Var.s;
                threadData.objType = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), br4Var);
                }
                ThreadCardUtils.jumpToPB((zn4) threadData, view2.getContext(), 0, false, dy.a((xo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m07(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str, String str2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, str, str2};
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
        this.l = tbPageContext;
        this.i = bdUniqueId2;
        this.j = str;
        this.k = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.l.getPageActivity());
            cy cyVar = new cy(this.l.getPageActivity());
            cyVar.t(this.i);
            cyVar.c(1024);
            cyVar.s(new b(this));
            cyVar.v(this.l);
            bVar.o(cyVar);
            kz k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.m);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, br4 br4Var, ThreadCardViewHolder<br4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, br4Var, threadCardViewHolder})) == null) {
            if (br4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || (threadData = br4Var.s) == null) {
                return null;
            }
            threadData.statFloor = C(i) + 1;
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b("page_recommend");
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP, this.o);
            boolean equals = "fashion".equals(this.k);
            if (equals) {
                threadCardViewHolder.n(false, this.p, true);
            } else {
                threadCardViewHolder.n(br4Var.showFollowBtn(), this.p, true);
            }
            threadCardViewHolder.v(!equals, Align.ALIGN_RIGHT_TOP);
            br4Var.s.mHomePageTopTabTabCode = this.k;
            threadCardViewHolder.g(br4Var);
            threadCardViewHolder.c().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.n);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xoVar) == null) {
            this.m = xoVar;
        }
    }
}
