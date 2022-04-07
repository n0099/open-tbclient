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
/* loaded from: classes7.dex */
public class xt5 extends ho<nu5, CardViewHolder<iv5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public ru5 j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu5 a;
        public final /* synthetic */ xt5 b;

        public a(xt5 xt5Var, nu5 nu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt5Var, nu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xt5Var;
            this.a = nu5Var;
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
    public xt5(TbPageContext tbPageContext, ru5 ru5Var) {
        super(tbPageContext.getPageActivity(), nu5.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ru5Var};
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
        this.j = ru5Var;
    }

    public final void a0(nu5 nu5Var, iv5 iv5Var) {
        bu5 e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nu5Var, iv5Var) == null) || (e = nu5Var.e()) == null || e.b() == null) {
            return;
        }
        iv5Var.x(0);
        iv5Var.y(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0239));
        int i = e.b().certify_status;
        if (i == 0) {
            iv5Var.v(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023d));
            iv5Var.w(0);
        } else if (1 == i) {
            iv5Var.v(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023c));
            iv5Var.w(4);
        } else if (2 == i) {
            iv5Var.v(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023a));
            iv5Var.w(4);
        } else if (3 == i) {
            iv5Var.v(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023b));
            iv5Var.w(0);
        }
        iv5Var.m(this.i, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b0(nu5 nu5Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, nu5Var) == null) || nu5Var == null || nu5Var.e() == null || nu5Var.e().b() == null || 1 == (i = (b = nu5Var.e().b()).certify_status) || 2 == i) {
            return;
        }
        Context context = this.a;
        String str = b.user_id;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
        ru5 ru5Var = this.j;
        if (ru5Var != null) {
            ru5Var.a(1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: c0 */
    public CardViewHolder<iv5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new CardViewHolder<>(new iv5(this.i)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, nu5 nu5Var, CardViewHolder<iv5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nu5Var, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            a0(nu5Var, cardViewHolder.c());
            cardViewHolder.c().k().setOnClickListener(new a(this, nu5Var));
            return cardViewHolder.c().k();
        }
        return (View) invokeCommon.objValue;
    }
}
