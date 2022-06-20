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
public class st5 extends an<iu5, CardViewHolder<dv5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public mu5 j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu5 a;
        public final /* synthetic */ st5 b;

        public a(st5 st5Var, iu5 iu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {st5Var, iu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = st5Var;
            this.a = iu5Var;
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
    public st5(TbPageContext tbPageContext, mu5 mu5Var) {
        super(tbPageContext.getPageActivity(), iu5.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, mu5Var};
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
        this.j = mu5Var;
    }

    public final void a0(iu5 iu5Var, dv5 dv5Var) {
        wt5 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, iu5Var, dv5Var) == null) || (c = iu5Var.c()) == null || c.b() == null) {
            return;
        }
        dv5Var.w(0);
        dv5Var.x(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023c));
        int i = c.b().certify_status;
        if (i == 0) {
            dv5Var.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0240));
            dv5Var.v(0);
        } else if (1 == i) {
            dv5Var.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023f));
            dv5Var.v(4);
        } else if (2 == i) {
            dv5Var.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023d));
            dv5Var.v(4);
        } else if (3 == i) {
            dv5Var.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023e));
            dv5Var.v(0);
        }
        dv5Var.j(this.i, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b0(iu5 iu5Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, iu5Var) == null) || iu5Var == null || iu5Var.c() == null || iu5Var.c().b() == null || 1 == (i = (b = iu5Var.c().b()).certify_status) || 2 == i) {
            return;
        }
        Context context = this.a;
        String str = b.user_id;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
        mu5 mu5Var = this.j;
        if (mu5Var != null) {
            mu5Var.a(1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public CardViewHolder<dv5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new CardViewHolder<>(new dv5(this.i)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, iu5 iu5Var, CardViewHolder<dv5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, iu5Var, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            a0(iu5Var, cardViewHolder.c());
            cardViewHolder.c().h().setOnClickListener(new a(this, iu5Var));
            return cardViewHolder.c().h();
        }
        return (View) invokeCommon.objValue;
    }
}
