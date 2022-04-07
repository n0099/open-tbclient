package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes7.dex */
public class sm7 extends a75<rm7, v65> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public View l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sm7(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = view2;
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092012);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906e0);
        this.i = textView;
        textView.setSingleLine();
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fe6);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912b9);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f09124a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e75
    /* renamed from: m */
    public void i(rm7 rm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rm7Var) == null) {
            super.i(rm7Var);
            if (rm7Var == null) {
                return;
            }
            if (this.h != null) {
                if (rm7Var.k() == 49) {
                    if (StringUtils.isNull(rm7Var.c())) {
                        if (StringUtils.isNull(rm7Var.m())) {
                            this.h.setText(g(R.string.obfuscated_res_0x7f0f0da6));
                        } else {
                            this.h.setText(rm7Var.m());
                        }
                    } else {
                        this.h.setText(rm7Var.c());
                    }
                } else if (rm7Var.i() != null) {
                    if (rm7Var.s()) {
                        this.h.setText(String.format("%s%s", g(R.string.obfuscated_res_0x7f0f0da8), rm7Var.i()));
                    } else {
                        this.h.setText(rm7Var.i());
                    }
                }
            }
            if (this.i != null) {
                if (rm7Var.k() == 49 && !TextUtils.isEmpty(rm7Var.m())) {
                    this.i.setText(String.format(g(R.string.obfuscated_res_0x7f0f0da9), rm7Var.m()));
                } else if (rm7Var.k() == 49) {
                    this.i.setText(String.format(g(R.string.obfuscated_res_0x7f0f0da9), g(R.string.obfuscated_res_0x7f0f0da6)));
                } else if (rm7Var.d() != null) {
                    this.i.setText(rm7Var.d());
                }
            }
            if (rm7Var.k() == 49) {
                this.k.setVisibility(rm7Var.q() ? 0 : 8);
            } else {
                this.k.setVisibility(8);
            }
            if (this.j != null) {
                String postTimeString = StringHelper.getPostTimeString(new Date(rm7Var.l()));
                if (postTimeString == null) {
                    postTimeString = "";
                }
                this.j.setText(postTimeString);
            }
        }
    }

    @Override // com.repackage.sj8
    @SuppressLint({"ResourceAsColor"})
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            SkinManager.setBackgroundResource(this.g, R.drawable.list_item_selector);
            SkinManager.setBackgroundResource(this.l, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().cornerRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).gradientLinear(DrawableSelector.LEFT_RIGHT, R.color.CAM_X0308, R.color.CAM_X0301).into(this.k);
            return true;
        }
        return invokeLI.booleanValue;
    }
}
