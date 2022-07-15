package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public ViewGroup c;
    public ImageView d;
    public TextView e;
    public TextView f;

    public m76(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d061d, (ViewGroup) null);
        this.b = inflate;
        this.c = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090f3d);
        this.d = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090e33);
        this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d0e);
        this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d0f);
        this.e.setText(R.string.obfuscated_res_0x7f0f0c58);
        this.f.setText(R.string.obfuscated_res_0x7f0f0c59);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setImageResource(this.d, R.drawable.cp_mask_attention_a);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(pi.f(this.a.getPageActivity(), R.dimen.tbds21)).trRadius(pi.f(this.a.getPageActivity(), R.dimen.tbds21)).blRadius(pi.f(this.a.getPageActivity(), R.dimen.tbds21)).brRadius(pi.f(this.a.getPageActivity(), R.dimen.tbds21)).into(this.c);
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (View) invokeV.objValue;
    }
}
