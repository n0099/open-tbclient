package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
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
/* loaded from: classes7.dex */
public class ra5 extends ja5<br4, ThreadCardViewHolder<br4>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView.b o;
    public ux5<br4> p;

    /* loaded from: classes7.dex */
    public class a extends ux5<br4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra5 b;

        public a(ra5 ra5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ra5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, br4 br4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, br4Var) == null) {
                this.b.b0(view2, br4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra5 a;

        public b(ra5 ra5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ra5Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof br4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                br4 br4Var = (br4) roVar;
                br4Var.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.b(), br4Var);
                }
                ThreadCardUtils.jumpToPB((zn4) br4Var, view2.getContext(), this.a.h0(), false, dy.a((xo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ra5(TbPageContext<?> tbPageContext) {
        super(tbPageContext, ThreadData.TYPE_FORUM_HEADER);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: t0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.k.getPageActivity());
            bVar.l().i(mi.f(this.k.getPageActivity(), HomeGroupUbsUIHelper.handleDimen(R.dimen.tbds30, R.dimen.tbds10)));
            bVar.o(new ly(this.k.getPageActivity()));
            kz k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.l);
            k.r(h0());
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.e);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: u0 */
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
            threadCardViewHolder.s(m0(1), Align.ALIGN_RIGHT_TOP, this.o);
            threadCardViewHolder.g(br4Var);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
