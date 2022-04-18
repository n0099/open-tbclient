package com.repackage;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberExchange.MemberExchangeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public Context b;
    public View c;
    public NavigationBar d;
    public NoNetworkView e;
    public TextView f;
    public HeadImageView g;
    public TextView h;
    public TextView i;
    public TbImageView j;
    public EditText k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public int q;

    public rj7(MemberExchangeActivity memberExchangeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberExchangeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 3;
        TbPageContext<MemberExchangeActivity> pageContext = memberExchangeActivity.getPageContext();
        this.a = pageContext;
        this.b = pageContext.getPageActivity();
        memberExchangeActivity.setContentView(R.layout.obfuscated_res_0x7f0d053b);
        View findViewById = memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f0913ce);
        this.c = findViewById;
        findViewById.setOnClickListener(memberExchangeActivity);
        NavigationBar navigationBar = (NavigationBar) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091515);
        this.d = navigationBar;
        navigationBar.setOnClickListener(memberExchangeActivity);
        this.f = this.d.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f05ad));
        this.e = (NoNetworkView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091598);
        this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.showBottomLine();
        HeadImageView headImageView = (HeadImageView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f0913cf);
        this.g = headImageView;
        headImageView.setIsRound(true);
        this.h = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f0913d3);
        this.i = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f0913ca);
        this.j = (TbImageView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f0913d2);
        this.k = (EditText) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f09091f);
        oi.w(this.a.getPageActivity(), this.k);
        TextView textView = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f090ccf);
        this.l = textView;
        textView.setOnClickListener(memberExchangeActivity);
        TextView textView2 = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091af4);
        this.m = textView2;
        textView2.setOnClickListener(null);
        TextView textView3 = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091af1);
        this.n = textView3;
        textView3.setClickable(false);
        TextView textView4 = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091af2);
        this.o = textView4;
        textView4.setClickable(false);
        TextView textView5 = (TextView) memberExchangeActivity.findViewById(R.id.obfuscated_res_0x7f091af3);
        this.p = textView5;
        textView5.setClickable(false);
        c(TbadkApplication.getInst().getSkinType());
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, str2, str3, str4, str5) == null) {
            this.g.K(str, 12, false);
            this.h.setText(str2);
            if (!ni.isEmpty(str3)) {
                this.j.setVisibility(0);
                this.j.K(str3, 10, false);
            } else {
                this.j.setVisibility(8);
            }
            if (!ni.isEmpty(str4)) {
                TextView textView = this.i;
                textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1511) + str4);
                return;
            }
            this.i.setText(str5);
        }
    }

    public EditText b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (EditText) invokeV.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.q != i) {
                this.d.onChangeSkinType(this.a, i);
                this.e.c(this.a, i);
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
                this.k.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
                SkinManager.setBackgroundResource(this.k, R.drawable.exchange_edit_text_bg);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0111);
                SkinManager.setBackgroundResource(this.l, R.drawable.btn_all_orange);
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
            }
            this.q = i;
        }
    }
}
