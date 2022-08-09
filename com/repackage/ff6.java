package com.repackage;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur4;
import tbclient.BawuThrones;
/* loaded from: classes6.dex */
public class ff6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ur4 a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public TextView e;
    public boolean f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff6 a;

        public a(ff6 ff6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ff6 ff6Var = this.a;
                ff6Var.f = !ff6Var.f;
                this.a.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ff6 c;

        public b(ff6 ff6Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff6Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ff6Var;
            this.a = str;
            this.b = str2;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ru4.k().u("key_frs_recommend_tip", !this.c.f);
                me6.c().d(this.a, this.b);
                this.c.a.dismiss();
                this.c.a = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff6 a;

        public c(ff6 ff6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff6Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.a.f = false;
                this.a.a.dismiss();
                this.a.a = null;
            }
        }
    }

    public ff6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            TextView textView2 = this.c;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            }
            h();
            TextView textView3 = this.e;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0107);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    public final void h() {
        ImageView imageView;
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.d) == null) {
            return;
        }
        if (this.f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805e2, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805e1, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(TbPageContext tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, str, str2) == null) {
            ur4 ur4Var = this.a;
            if (ur4Var == null || !ur4Var.isShowing()) {
                ur4 ur4Var2 = new ur4(tbPageContext.getPageActivity());
                this.a = ur4Var2;
                ur4Var2.setContentViewSize(1);
                this.a.setNegativeTextColor(R.color.CAM_X0105);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d016b, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921ba);
                this.b = textView;
                textView.setText(R.string.obfuscated_res_0x7f0f0747);
                this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090480);
                BawuThrones b2 = me6.c().b();
                if (b2 != null) {
                    TextView textView2 = this.c;
                    String string = tbPageContext.getString(R.string.obfuscated_res_0x7f0f0746);
                    Integer num = b2.total_recommend_num;
                    textView2.setText(String.format(string, b2.bazhu_level, num, Integer.valueOf(num.intValue() - b2.used_recommend_num.intValue())));
                } else {
                    this.c.setText(String.format(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0746), "D", 2, 2));
                }
                this.d = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0905fe);
                this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0916af);
                inflate.findViewById(R.id.obfuscated_res_0x7f0916ae).setOnClickListener(new a(this));
                f();
                this.a.setContentView(inflate);
                this.a.setPositiveButton(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0745), new b(this, str, str2));
                this.a.setNegativeButton(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0c48), new c(this));
                this.a.create(tbPageContext).show();
            }
        }
    }
}
