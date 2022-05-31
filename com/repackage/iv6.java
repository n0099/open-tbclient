package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iv6 extends wm<pw6, CardViewHolder<uv5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public uv5 j;
    public BdUniqueId k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iv6(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), rw6.f);
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
        uv5 uv5Var = new uv5(tbPageContext);
        this.j = uv5Var;
        uv5Var.H("c10714", "c10739", "c10712", "c10738");
        this.j.setFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME);
    }

    public void Z(int i) {
        uv5 uv5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (uv5Var = this.j) == null) {
            return;
        }
        uv5Var.m(this.i, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public CardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            if (this.j == null) {
                uv5 uv5Var = new uv5(this.i);
                this.j = uv5Var;
                uv5Var.G(this.k);
                this.j.H("c10714", "c10739", "c10712", "c10738");
            }
            return new CardViewHolder(this.j);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, pw6 pw6Var, CardViewHolder cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pw6Var, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            cardViewHolder.c().l(pw6Var);
            gw5.b().a(new StatisticItem("c10714").param(TiebaStatic.Params.OBJ_PARAM3, yv5.e()));
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.k = bdUniqueId;
            uv5 uv5Var = this.j;
            if (uv5Var != null) {
                uv5Var.G(bdUniqueId);
            }
        }
    }
}
