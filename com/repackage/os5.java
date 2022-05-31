package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaFansFamilyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class os5 extends wm<et5, CardViewHolder<eu5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ et5 a;
        public final /* synthetic */ os5 b;

        public a(os5 os5Var, et5 et5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {os5Var, et5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = os5Var;
            this.a = et5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.b0(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public os5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), et5.b);
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

    public final void a0(et5 et5Var, eu5 eu5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, et5Var, eu5Var) == null) || et5Var.e() == null) {
            return;
        }
        eu5Var.x(8);
        eu5Var.y(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0239));
        eu5Var.m(this.i, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b0(et5 et5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, et5Var) == null) || et5Var == null || et5Var.e() == null) {
            return;
        }
        TiebaStatic.log("c13134");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaFansFamilyActivityConfig(this.a, et5Var.e().b().user_id, true, AlaFansFamilyActivityConfig.FROM_PERSON_CENTER)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public CardViewHolder<eu5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new CardViewHolder<>(new eu5(this.i)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, et5 et5Var, CardViewHolder<eu5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, et5Var, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            TiebaStatic.log("c13133");
            a0(et5Var, cardViewHolder.c());
            cardViewHolder.c().k().setOnClickListener(new a(this, et5Var));
            return cardViewHolder.c().k();
        }
        return (View) invokeCommon.objValue;
    }
}
