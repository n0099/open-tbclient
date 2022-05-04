package com.repackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i68 extends tw5<g58> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public ImageView j;
    public TextView k;
    public String l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i68(TbPageContext<?> tbPageContext) {
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
        s(k());
    }

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01af : invokeV.intValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.color.CAM_X0201);
                SkinManager.setImageResource(this.j, R.drawable.new_pic_emotion_07);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0108, 1);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090565);
            this.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090564);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090566);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: t */
    public void l(g58 g58Var) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, g58Var) == null) {
            if (g58Var == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            if (StringUtils.isNull(this.l)) {
                TextView textView = this.k;
                String string2 = this.c.getString(R.string.obfuscated_res_0x7f0f0e29);
                Object[] objArr = new Object[1];
                if (g58Var.a) {
                    string = this.c.getString(R.string.obfuscated_res_0x7f0f15b7);
                } else if (g58Var.b == 2) {
                    string = this.c.getString(R.string.obfuscated_res_0x7f0f1157);
                } else {
                    string = this.c.getString(R.string.obfuscated_res_0x7f0f0819);
                }
                objArr[0] = string;
                textView.setText(String.format(string2, objArr));
                return;
            }
            this.k.setText(this.l);
        }
    }
}
