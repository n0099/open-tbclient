package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e38 extends bn<w38, CardViewHolder<m48>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public m48 b;
    public r16 c;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e38 a;

        public a(e38 e38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e38Var;
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
                        str = "&skin=night";
                    } else {
                        str = "";
                    }
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{TbConfig.VIRTUAL_IMAGE_MAIN_URL + str + "&from=3"});
                } catch (Exception e) {
                    BdLog.e("openPageByUrl fail:" + e.toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e38(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.a = tbPageContext;
    }

    public void t() {
        r16 r16Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (r16Var = this.c) == null) {
            return;
        }
        r16Var.E();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: u */
    public CardViewHolder<m48> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.b = new m48(this.a);
            return new CardViewHolder<>(this.b);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: v */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, w38 w38Var, CardViewHolder<m48> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, w38Var, cardViewHolder})) == null) {
            cardViewHolder.a().i(w38Var);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void w() {
        m48 m48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (m48Var = this.b) == null || m48Var.y() == null || this.b.y().getVisibility() != 0 || k28.a().b() == 1) {
            return;
        }
        r16 r16Var = this.c;
        if (r16Var == null) {
            this.c = new r16(this.a, this.b.y());
        } else {
            r16Var.E();
        }
        String string = this.a.getString(R.string.obfuscated_res_0x7f0f0e66);
        this.c.R(R.drawable.obfuscated_res_0x7f0802ed);
        this.c.G(2);
        this.c.J(48);
        this.c.S(true);
        this.c.U(qi.f(this.a.getPageActivity(), R.dimen.tbds0));
        this.c.T(qi.f(this.a.getPageActivity(), R.dimen.tbds22));
        this.c.P(R.color.CAM_X0101);
        this.c.Q(R.dimen.T_X09);
        this.c.O(1);
        this.c.K(true);
        this.c.H(new a(this));
        this.c.W(string);
    }
}
