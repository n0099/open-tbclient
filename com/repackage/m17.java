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
import com.repackage.b00;
import com.repackage.m00;
import com.repackage.ty;
/* loaded from: classes6.dex */
public class m17 extends ho<qq4, ThreadCardViewHolder<qq4>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public String j;
    public String k;
    public TbPageContext<?> l;
    public zo m;
    public tx5<qq4> n;
    public NEGFeedBackView.b o;
    public FollowUserButton.a p;

    /* loaded from: classes6.dex */
    public class a extends tx5<qq4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m17 b;

        public a(m17 m17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m17Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tx5
        /* renamed from: d */
        public void a(View view2, qq4 qq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, qq4Var) == null) {
                mx5.b().d(true);
                r07.j(view2, qq4Var, this.b.j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ty.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(m17 m17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ty.b
        public void a(pn4 pn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, pn4Var, view2) == null) || pn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09229d) {
                pn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09227b) {
                pn4Var.objType = 4;
            } else {
                pn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m17 a;

        public c(m17 m17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m17Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof qq4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                qq4 qq4Var = (qq4) uoVar;
                ThreadData threadData = qq4Var.s;
                threadData.objType = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), qq4Var);
                }
                ThreadCardUtils.jumpToPB((pn4) threadData, view2.getContext(), 0, false, uy.a((zo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m17(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str, String str2) {
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
    @Override // com.repackage.ho
    /* renamed from: b0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.l.getPageActivity());
            ty tyVar = new ty(this.l.getPageActivity());
            tyVar.t(this.i);
            tyVar.c(1024);
            tyVar.s(new b(this));
            tyVar.v(this.l);
            bVar.o(tyVar);
            b00 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.m);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, qq4 qq4Var, ThreadCardViewHolder<qq4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qq4Var, threadCardViewHolder})) == null) {
            if (qq4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || (threadData = qq4Var.s) == null) {
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
                threadCardViewHolder.n(qq4Var.showFollowBtn(), this.p, true);
            }
            threadCardViewHolder.v(!equals, Align.ALIGN_RIGHT_TOP);
            qq4Var.s.mHomePageTopTabTabCode = this.k;
            threadCardViewHolder.g(qq4Var);
            threadCardViewHolder.c().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.n);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zoVar) == null) {
            this.m = zoVar;
        }
    }
}
