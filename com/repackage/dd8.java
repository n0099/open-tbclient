package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dd8 extends wm<fd8, CardViewHolder<wd8>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public nw5<fd8> j;

    /* loaded from: classes5.dex */
    public class a extends nw5<fd8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd8 b;

        public a(dd8 dd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dd8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, fd8 fd8Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fd8Var) == null) && fd8Var != null && (this.b.i.getPageActivity() instanceof ForumSquareActivity)) {
                String className = ((ForumSquareActivity) this.b.i.getPageActivity()).getDelegate().getClassName();
                if (!"推荐".equals(className)) {
                    StatisticItem statisticItem = new StatisticItem("c13652");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", fd8Var.a);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, className);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13643");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", fd8Var.a);
                statisticItem2.param("obj_locate", 3);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd8(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), fd8.h);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.i = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public CardViewHolder<wd8> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            wd8 wd8Var = new wd8(this.i);
            wd8Var.o(this.e);
            return new CardViewHolder<>(wd8Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, fd8 fd8Var, CardViewHolder<wd8> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fd8Var, cardViewHolder})) == null) {
            if (fd8Var == null || cardViewHolder == null || cardViewHolder.c() == null) {
                return null;
            }
            cardViewHolder.c().l(fd8Var);
            cardViewHolder.c().n(this.j);
            if (this.i.getPageActivity() instanceof ForumSquareActivity) {
                String className = ((ForumSquareActivity) this.i.getPageActivity()).getDelegate().getClassName();
                if (!"推荐".equals(className)) {
                    StatisticItem statisticItem = new StatisticItem("c13651");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", fd8Var.a);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, className);
                    TiebaStatic.log(statisticItem);
                } else {
                    StatisticItem statisticItem2 = new StatisticItem("c13642");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", fd8Var.g());
                    statisticItem2.param("obj_locate", 3);
                    TiebaStatic.log(statisticItem2);
                }
            }
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
