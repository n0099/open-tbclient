package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c18 extends an<s18, CardViewHolder<h28>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public h28 j;
    public zz5 k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c18 a;

        public a(c18 c18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 4) {
                        str = "&skin=dart";
                    } else if (skinType == 1) {
                        str = "&skin=" + SkinManager.SKIN_TYPE_STR_NIGHT;
                    } else {
                        str = "";
                    }
                    UrlManager.getInstance().dealOneLink(this.a.i, new String[]{"https://tieba.baidu.com/mo/q/hybrid-main-service/virtualAvatar?customfullscreen=1&nonavigationbar=1" + str + "&from=3"});
                } catch (Exception e) {
                    BdLog.e("openPageByUrl fail:" + e.toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c18(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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

    public void a0() {
        zz5 zz5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (zz5Var = this.k) == null) {
            return;
        }
        zz5Var.D();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: b0 */
    public CardViewHolder<h28> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.j = new h28(this.i);
            return new CardViewHolder<>(this.j);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, s18 s18Var, CardViewHolder<h28> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, s18Var, cardViewHolder})) == null) {
            cardViewHolder.b().i(s18Var);
            return cardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void d0() {
        h28 h28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (h28Var = this.j) == null || h28Var.y() == null || this.j.y().getVisibility() != 0 || i08.a().b() == 1) {
            return;
        }
        zz5 zz5Var = this.k;
        if (zz5Var == null) {
            this.k = new zz5(this.i, this.j.y());
        } else {
            zz5Var.D();
        }
        String string = this.i.getString(R.string.obfuscated_res_0x7f0f0e38);
        this.k.O(R.drawable.obfuscated_res_0x7f0802eb);
        this.k.F(2);
        this.k.I(48);
        this.k.P(true);
        this.k.R(pi.f(this.i.getPageActivity(), R.dimen.tbds0));
        this.k.Q(pi.f(this.i.getPageActivity(), R.dimen.tbds22));
        this.k.M(R.color.CAM_X0101);
        this.k.N(R.dimen.T_X09);
        this.k.L(1);
        this.k.J(true);
        this.k.G(new a(this));
        this.k.T(string);
    }
}
