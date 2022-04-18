package com.repackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wt5 extends ho<mu5, CardViewHolder<kv5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public TextView j;
    public String k;
    public String l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wt5 a;

        public a(wt5 wt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wt5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wt5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), mu5.b);
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

    public final void a0(mu5 mu5Var, kv5 kv5Var) {
        du5 e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, mu5Var, kv5Var) == null) || (e = mu5Var.e()) == null || kv5Var == null) {
            return;
        }
        this.j = kv5Var.s();
        this.k = e.b().user_id;
        e0(e, kv5Var);
        kv5Var.x(8);
        kv5Var.y(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0238));
        kv5Var.m(this.i, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaSharedPrefHelper.getInstance().putBoolean(AlaSharedPrefConfig.ALA_MY_LIVE_PRIVILEGE_HAS_ENTERED, true);
            f0(this.j, this.l, false);
            StatisticItem statisticItem = new StatisticItem("c13333");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            String q = vt4.k().q("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            if (q == null) {
                return;
            }
            if (q.endsWith("/")) {
                q = q.substring(0, q.length() - 1);
            }
            String str = this.k;
            StringBuilder sb = new StringBuilder();
            sb.append("id=");
            sb.append(str);
            if (!q.contains("?")) {
                sb.insert(0, "?");
            } else {
                sb.insert(0, "&");
            }
            sb.insert(0, q);
            ul4.m(this.i.getPageActivity(), sb.toString());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: c0 */
    public CardViewHolder<kv5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new CardViewHolder<>(new kv5(this.i)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, mu5 mu5Var, CardViewHolder<kv5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mu5Var, cardViewHolder})) == null) {
            if (cardViewHolder.c() == null) {
                return null;
            }
            a0(mu5Var, cardViewHolder.c());
            cardViewHolder.c().k().setOnClickListener(new a(this));
            return cardViewHolder.c().k();
        }
        return (View) invokeCommon.objValue;
    }

    public final void e0(du5 du5Var, kv5 kv5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, du5Var, kv5Var) != null) || du5Var == null || kv5Var == null) {
        }
    }

    public final void f0(TextView textView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048583, this, textView, str, z) == null) || textView == null || this.i == null) {
            return;
        }
        if (z) {
            textView.setText("");
            Drawable drawable = this.i.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801e2);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        textView.setCompoundDrawables(null, null, null, null);
    }
}
