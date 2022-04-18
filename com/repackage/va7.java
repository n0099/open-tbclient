package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class va7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String i = "com.repackage.va7";
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public TbRichTextView e;
    public View f;
    public TbPageContext g;
    public int h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755237819, "Lcom/repackage/va7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755237819, "Lcom/repackage/va7;");
        }
    }

    public va7(TbPageContext tbPageContext, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = 3;
        this.g = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0640, viewGroup, false);
        this.a = inflate;
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090fd1);
        this.b = headImageView;
        headImageView.setIsRound(true);
        this.b.setOnClickListener(onClickListener);
        this.b.setPlaceHolder(1);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09220d);
        this.c = textView;
        textView.setOnClickListener(onClickListener);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092181);
        TbRichTextView tbRichTextView = (TbRichTextView) this.a.findViewById(R.id.obfuscated_res_0x7f09217d);
        this.e = tbRichTextView;
        tbRichTextView.setTextSize(tbPageContext.getResources().getDimension(R.dimen.tbfontsize42));
        af5 layoutStrategy = this.e.getLayoutStrategy();
        layoutStrategy.o(tbPageContext.getResources().getDimension(R.dimen.tbds12), 1.0f);
        this.e.setLayoutStrategy(layoutStrategy);
        this.e.setClickable(true);
        this.e.setFocusable(true);
        this.f = this.a.findViewById(R.id.obfuscated_res_0x7f0903d4);
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.h == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
        this.e.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
        this.h = TbadkCoreApplication.getInst().getSkinType();
    }

    public void c(ChatMessage chatMessage) {
        TbRichTextView tbRichTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMessage) == null) || chatMessage.getUserInfo() == null) {
            return;
        }
        this.b.setUserId(chatMessage.getUserInfo().getUserId());
        this.b.K(chatMessage.getUserInfo().getPortrait(), 12, false);
        this.d.setText(StringHelper.getFormatTimeShort(chatMessage.getTime() * 1000));
        if (this.g == null || (tbRichTextView = this.e) == null) {
            return;
        }
        g57.e(tbRichTextView, chatMessage, i, 0);
        if (chatMessage == null || chatMessage.getContent() == null) {
            return;
        }
        String[] split = chatMessage.getContent().split("#");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : split) {
            stringBuffer.append(str);
        }
        this.e.setContentDescription(stringBuffer.toString());
        this.e.getTextView().setContentDescription(stringBuffer.toString());
    }
}
