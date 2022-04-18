package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr7;
/* loaded from: classes6.dex */
public class it7 extends ft7<CustomDialogData> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomDialogData c;
    public jt7 d;
    public TbImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public View j;
    public View k;
    public LinearLayout l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public it7(TbPageContext<?> tbPageContext) {
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
    }

    @Override // com.repackage.kt7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = (TbImageView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f0907b0);
            this.f = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f0907bf);
            this.g = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f09079c);
            this.h = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f092493);
            this.i = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f091579);
            this.j = getViewGroup().findViewById(R.id.obfuscated_res_0x7f090342);
            this.k = getViewGroup().findViewById(R.id.obfuscated_res_0x7f090816);
            this.l = (LinearLayout) getViewGroup().findViewById(R.id.obfuscated_res_0x7f0919bb);
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            SkinManager.setBackgroundResource(this.h, R.drawable.dialog_single_button_bg_selector);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, (int) R.color.common_color_10122);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.l, R.drawable.dialog_background);
        }
    }

    @Override // com.repackage.kt7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d0211 : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.kt7
    /* renamed from: e */
    public void b(CustomDialogData customDialogData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customDialogData) == null) || customDialogData == null) {
            return;
        }
        this.c = customDialogData;
        CustomDialogData.Head head = customDialogData.head;
        if (!TextUtils.isEmpty(head.imageUrl)) {
            this.e.K(head.imageUrl, 10, false);
        }
        if (!TextUtils.isEmpty(head.text)) {
            this.f.setText(head.text);
        }
        if (!TextUtils.isEmpty(customDialogData.body)) {
            this.g.setText(customDialogData.body);
        }
        CustomDialogData.Button button = customDialogData.leftButton;
        if (button != null && !StringUtils.isNull(button.text)) {
            this.i.setText(customDialogData.leftButton.text);
        }
        CustomDialogData.Button button2 = customDialogData.rightButton;
        if (button2 == null || StringUtils.isNull(button2.text)) {
            return;
        }
        this.h.setText(customDialogData.rightButton.text);
    }

    public void f(jt7 jt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jt7Var) == null) {
            this.d = jt7Var;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        CustomDialogData.Button button;
        CustomDialogData.Button button2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 == this.h) {
                CustomDialogData customDialogData = this.c;
                if (customDialogData != null && (button2 = customDialogData.rightButton) != null && !StringUtils.isNull(button2.action)) {
                    UrlManager.getInstance().dealOneLink(d(), new String[]{this.c.rightButton.action});
                }
                jt7 jt7Var = this.d;
                if (jt7Var != null) {
                    jt7Var.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem(cr7.a.b);
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
            } else if (view2 == this.i) {
                CustomDialogData customDialogData2 = this.c;
                if (customDialogData2 != null && (button = customDialogData2.leftButton) != null && !StringUtils.isNull(button.action)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageActivity(), null, this.c.leftButton.action, true)));
                }
                jt7 jt7Var2 = this.d;
                if (jt7Var2 != null) {
                    jt7Var2.dismiss();
                }
                StatisticItem statisticItem2 = new StatisticItem(cr7.a.b);
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
            }
        }
    }
}
