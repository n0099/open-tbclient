package com.repackage;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ak7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbPageContext b;
    public NavigationBar c;
    public NoNetworkView d;
    public TbImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public int l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak7 a;

        public a(ak7 ak7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ak7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.a.b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    public ak7(TbPageContext tbPageContext) {
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
        this.l = 3;
        this.a = tbPageContext.getPageActivity();
        this.b = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d0542);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091514);
        this.c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.showBottomLine();
        this.d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091597);
        this.c.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.e = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091dc7);
        this.f = (TextView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091dc8);
        this.g = (TextView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091665);
        this.i = (TextView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091dcd);
        this.h = (TextView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091ff8);
        TextView textView = (TextView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0915ff);
        this.j = textView;
        textView.setOnClickListener(new a(this));
        c();
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.g.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d49), str));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k = this.c.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0380));
            this.d.c(this.b, TbadkApplication.getInst().getSkinType());
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setImageResource(this.e, R.drawable.obfuscated_res_0x7f080a14);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.l != i) {
                this.c.onChangeSkinType(this.b, i);
                this.d.c(this.b, i);
                SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
                SkinManager.setImageResource(this.e, R.drawable.obfuscated_res_0x7f080a14);
                SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0305);
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0108);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0111);
                SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
            }
            this.l = i;
        }
    }
}
