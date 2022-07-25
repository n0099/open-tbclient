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
public class pu5 extends an<fv5, CardViewHolder<aw5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public jv5 j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv5 a;
        public final /* synthetic */ pu5 b;

        public a(pu5 pu5Var, fv5 fv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu5Var, fv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pu5Var;
            this.a = fv5Var;
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
    public pu5(TbPageContext tbPageContext, jv5 jv5Var) {
        super(tbPageContext.getPageActivity(), fv5.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, jv5Var};
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
        this.j = jv5Var;
    }

    public final void a0(fv5 fv5Var, aw5 aw5Var) {
        tu5 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fv5Var, aw5Var) == null) || (c = fv5Var.c()) == null || c.b() == null) {
            return;
        }
        aw5Var.w(0);
        aw5Var.x(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023e));
        int i = c.b().certify_status;
        if (i == 0) {
            aw5Var.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0242));
            aw5Var.v(0);
        } else if (1 == i) {
            aw5Var.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0241));
            aw5Var.v(4);
        } else if (2 == i) {
            aw5Var.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f023f));
            aw5Var.v(4);
        } else if (3 == i) {
            aw5Var.u(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0240));
            aw5Var.v(0);
        }
        aw5Var.j(this.i, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b0(fv5 fv5Var) {
        AlaUserInfoData b;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, fv5Var) == null) || fv5Var == null || fv5Var.c() == null || fv5Var.c().b() == null || 1 == (i = (b = fv5Var.c().b()).certify_status) || 2 == i) {
            return;
        }
        Context context = this.a;
        String str = b.user_id;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterRealAuthenConfig(context, str, b.certify_status + "")));
        jv5 jv5Var = this.j;
        if (jv5Var != null) {
            jv5Var.a(1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public CardViewHolder<aw5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new CardViewHolder<>(new aw5(this.i)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, fv5 fv5Var, CardViewHolder<aw5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fv5Var, cardViewHolder})) == null) {
            if (cardViewHolder.b() == null) {
                return null;
            }
            a0(fv5Var, cardViewHolder.b());
            cardViewHolder.b().h().setOnClickListener(new a(this, fv5Var));
            return cardViewHolder.b().h();
        }
        return (View) invokeCommon.objValue;
    }
}
