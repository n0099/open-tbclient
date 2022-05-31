package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gi6 extends wm<e16, CardViewHolder<sv5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public sv5 j;
    public String k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gi6(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), e16.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.k = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: Z */
    public CardViewHolder<sv5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            sv5 sv5Var = new sv5(this.i);
            this.j = sv5Var;
            sv5Var.u(this.k);
            return new CardViewHolder<>(this.j);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, e16 e16Var, CardViewHolder<sv5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, e16Var, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            cardViewHolder.c().l(e16Var);
            cardViewHolder.c().m(this.i, TbadkCoreApplication.getInst().getSkinType());
            return cardViewHolder.c().k();
        }
        return (View) invokeCommon.objValue;
    }
}
