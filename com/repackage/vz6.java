package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vz6 extends wm<yz6, CardViewHolder<a07>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vz6(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), yz6.c);
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
        this.i = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: Z */
    public CardViewHolder<a07> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            a07 a07Var = new a07(this.i);
            a07Var.o(this.e);
            CardViewHolder<a07> cardViewHolder = new CardViewHolder<>(a07Var);
            int f = li.f(this.i.getPageActivity(), R.dimen.tbds44);
            cardViewHolder.b().setPadding(f, 0, f, 0);
            return cardViewHolder;
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, yz6 yz6Var, CardViewHolder<a07> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yz6Var, cardViewHolder})) == null) {
            if (yz6Var == null || cardViewHolder == null || cardViewHolder.c() == null) {
                return null;
            }
            cardViewHolder.c().l(yz6Var);
            cardViewHolder.c().m(this.i, TbadkCoreApplication.getInst().getSkinType());
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
