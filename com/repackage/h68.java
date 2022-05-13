package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h68 extends uw5<f58> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView i;
    public View j;
    public View k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h68(TbPageContext tbPageContext) {
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
        this.j = k;
        this.i = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f0905d9);
        this.k = this.j.findViewById(R.id.obfuscated_res_0x7f091461);
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01a9 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setImageResource(this.i, R.drawable.icon_mine_more);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_look_more_selector);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: s */
    public void l(f58 f58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f58Var) == null) {
            if (f58Var == null) {
                this.j.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width > 0) {
                    layoutParams.width = f58Var.a;
                }
                if (layoutParams.height > 0) {
                    layoutParams.height = f58Var.b;
                }
            }
            this.k.setLayoutParams(layoutParams);
            this.j.setVisibility(0);
            m(this.b, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
