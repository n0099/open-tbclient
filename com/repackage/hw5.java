package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaPersonCenterRealAuthenConfig;
import com.baidu.ala.data.AlaUserInfoData;
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
/* loaded from: classes6.dex */
public class hw5 extends bn<xw5, CardViewHolder<sx5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public bx5 b;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw5 a;
        public final /* synthetic */ hw5 b;

        public a(hw5 hw5Var, xw5 xw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw5Var, xw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hw5Var;
            this.a = xw5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.u(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hw5(TbPageContext tbPageContext, bx5 bx5Var) {
        super(tbPageContext.getPageActivity(), xw5.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bx5Var};
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
        this.a = tbPageContext;
        this.b = bx5Var;
    }

    public final void t(xw5 xw5Var, sx5 sx5Var) {
        lw5 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, xw5Var, sx5Var) == null) || (c = xw5Var.c()) == null || c.b() == null) {
            return;
        }
        sx5Var.w(0);
        sx5Var.x(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0241));
        int i = c.b().certify_status;
        if (i == 0) {
            sx5Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0245));
            sx5Var.v(0);
        } else if (1 == i) {
            sx5Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0244));
            sx5Var.v(4);
        } else if (2 == i) {
            sx5Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0242));
            sx5Var.v(4);
        } else if (3 == i) {
            sx5Var.u(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0243));
            sx5Var.v(0);
        }
        sx5Var.j(this.a, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void u(xw5 xw5Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, xw5Var) == null) || xw5Var == null || xw5Var.c() == null || xw5Var.c().b() == null || 1 == (i = (b = xw5Var.c().b()).certify_status) || 2 == i) {
            return;
        }
        Context context = this.mContext;
        String str = b.user_id;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
        bx5 bx5Var = this.b;
        if (bx5Var != null) {
            bx5Var.a(1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: v */
    public CardViewHolder<sx5> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new CardViewHolder<>(new sx5(this.a)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, xw5 xw5Var, CardViewHolder<sx5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xw5Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            t(xw5Var, cardViewHolder.a());
            cardViewHolder.a().h().setOnClickListener(new a(this, xw5Var));
            return cardViewHolder.a().h();
        }
        return (View) invokeCommon.objValue;
    }
}
