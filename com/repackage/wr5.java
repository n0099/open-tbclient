package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wr5 extends bz5<et5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public ImageView j;
    public View k;
    public View l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wr5(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = h();
        this.i = (TextView) h().findViewById(R.id.obfuscated_res_0x7f09232f);
        this.j = (ImageView) h().findViewById(R.id.obfuscated_res_0x7f090fe9);
        this.l = h().findViewById(R.id.obfuscated_res_0x7f090e38);
        j(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.repackage.bz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0831 : invokeV.intValue;
    }

    @Override // com.repackage.bz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(this.k, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
            SkinManager.setImageResource(this.j, R.drawable.new_pic_emotion_08);
            SkinManager.setBackgroundResource(this.l, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bz5
    /* renamed from: r */
    public void i(et5 et5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, et5Var) == null) {
            if (et5Var.a == 1) {
                this.i.setText(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0a15));
                SkinManager.setImageResource(this.j, R.drawable.new_pic_emotion_07);
                return;
            }
            this.i.setText(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0a14));
            SkinManager.setImageResource(this.j, R.drawable.new_pic_emotion_06);
        }
    }
}
