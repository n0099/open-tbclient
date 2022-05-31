package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xx;
/* loaded from: classes5.dex */
public class bw6 extends wm<wz6, ThreadCardViewHolder<wz6>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public NEGFeedBackView.b l;

    /* loaded from: classes5.dex */
    public class a implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bw6 a;

        public a(bw6 bw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bw6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof wz6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                wz6 wz6Var = (wz6) jnVar;
                if (wz6Var != null && wz6Var.Z != 1) {
                    TiebaStatic.log(new StatisticItem("c13351").param("topic_id", wz6Var.S).param("obj_locate", wz6Var.R));
                }
                if (wz6Var != null && wz6Var.Z == 1) {
                    TiebaStatic.log(new StatisticItem("c13449").param("topic_id", wz6Var.S));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(this.a.a, wz6Var.S)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public ThreadCardViewHolder<wz6> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity(), false);
            rx6 rx6Var = new rx6(this.a, this.j);
            rx6Var.p(this.e);
            bVar.n(rx6Var);
            bVar.l().c(0);
            bVar.l().e(0);
            bVar.l().f(0);
            bVar.l().i(0);
            bVar.l().h(0);
            xx j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j.r(2);
            ThreadCardViewHolder<wz6> threadCardViewHolder = new ThreadCardViewHolder<>(j);
            threadCardViewHolder.k(this.i);
            V(new a(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, wz6 wz6Var, ThreadCardViewHolder<wz6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wz6Var, threadCardViewHolder})) == null) {
            if (wz6Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            TiebaStatic.log(new StatisticItem("c13448").param("topic_id", wz6Var.S));
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.k);
            threadCardViewHolder.r(false).u(this.l);
            threadCardViewHolder.g(wz6Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.l = bVar;
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.k = str;
        }
    }
}
