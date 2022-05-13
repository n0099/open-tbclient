package com.repackage;

import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Profile.FinanceTabItems;
/* loaded from: classes7.dex */
public class t28 extends uw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public g28 n;
    public TbPageContext o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t28(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = tbPageContext;
        View k = k();
        this.i = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f0917b9);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0917b8);
        this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0917bb);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0917b7);
        this.m = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0917a4);
        m(this.o, this.a);
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06a4 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void l(BaseCardInfo baseCardInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseCardInfo) == null) {
            g28 g28Var = (g28) baseCardInfo;
            this.n = g28Var;
            FinanceTabItems e = g28Var.e();
            this.j.setText(e.tab_name);
            this.i.setImageURI(Uri.parse(e.icon_url));
            this.i.K(e.icon_url, 10, false);
            this.k.setText(e.desc_text);
            this.l.setText(e.tab_bubble);
            String str = e.tab_bubble;
            if (str != null && str.length() > 0) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(4);
            }
            m(this.o, this.a);
        }
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }
}
