package com.repackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q68 extends tw5<j58> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TbImageView j;
    public TextView k;
    public ImageView l;
    public j58 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q68(TbPageContext<?> tbPageContext) {
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
        View k = k();
        this.i = k;
        this.j = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f09188d);
        this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09188c);
        this.l = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f09188e);
        this.i.setOnClickListener(this);
    }

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06d1 : invokeV.intValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
        SkinManager.setImageResource(this.l, R.drawable.obfuscated_res_0x7f0808ba, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && this.i == view2) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.c);
            j58 j58Var = this.m;
            messageManager.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(j58Var.c, j58Var.d, "person_page")));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: s */
    public void l(j58 j58Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, j58Var) == null) || j58Var == null) {
            return;
        }
        this.m = j58Var;
        this.j.K(j58Var.a, 10, false);
        this.k.setText(j58Var.b);
        m(this.b, TbadkCoreApplication.getInst().getSkinType());
    }
}
