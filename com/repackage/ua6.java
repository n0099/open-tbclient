package com.repackage;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ua6 extends nv5<pa6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public int m;
    public pa6 n;
    public View.OnClickListener o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua6(TbPageContext<?> tbPageContext) {
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
        this.m = 3;
        this.i = (BarImageView) k().findViewById(R.id.obfuscated_res_0x7f090a05);
        this.j = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090a48);
        this.k = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090a03);
        this.l = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090a70);
        k().setOnClickListener(this);
        m(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d02c5 : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.m == i) {
            return;
        }
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(k(), R.drawable.square_search_item_bg);
        this.m = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || this.n == null) {
            return;
        }
        TiebaStatic.log("c12261");
        na6.d(this.n.r());
        view2.setTag(this.n);
        View.OnClickListener onClickListener = this.o;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nv5
    /* renamed from: s */
    public void l(pa6 pa6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pa6Var) == null) || pa6Var == null) {
            return;
        }
        this.n = pa6Var;
        this.i.K(pa6Var.e(), 10, false);
        this.j.setText(t(pa6Var.k(), pa6Var.r()));
        this.k.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f0421), pa6Var.g()));
        this.l.setText(String.format(this.b.getString(R.string.obfuscated_res_0x7f0f10be), pa6Var.q()));
        m(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public SpannableStringBuilder t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
                return null;
            }
            String trim = str2.trim();
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            int indexOf = str.indexOf(trim);
            if (indexOf != -1) {
                spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, trim.length() + indexOf, 33);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }
}
