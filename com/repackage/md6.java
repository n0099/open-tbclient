package com.repackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.WindowToast;
/* loaded from: classes6.dex */
public class md6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;

        public a(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ TbPageContext e;

        public b(cr4 cr4Var, int i, String str, String str2, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr4Var, Integer.valueOf(i), str, str2, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cr4Var;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                if (this.b == 1) {
                    UrlManager.getInstance().dealOneLink(this.e, new String[]{String.format("https://tieba.baidu.com/mo/q/bawu/taskinfoview?fn=%1$s&fid=%2$s&noshare=1", this.c, this.d)});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;

        public c(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    public static void a(TbPageContext<?> tbPageContext, WindowToast windowToast, String str, String str2) {
        int k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, windowToast, str, str2) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        int intValue = windowToast.toast_type.intValue();
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0307, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09033b);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090339);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09033a);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090338);
        textView.setText(windowToast.toast_content);
        if (windowToast.toast_type.intValue() == 0) {
            textView2.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0984));
        } else if (windowToast.toast_type.intValue() != 1) {
            return;
        } else {
            textView2.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ed));
        }
        cr4 cr4Var = new cr4(tbPageContext.getPageActivity());
        cr4Var.setContentView(inflate);
        cr4Var.setContentViewSize(2);
        cr4Var.setCanceledOnTouchOutside(false);
        cr4Var.setAutoNight(true);
        cr4Var.setCancelable(true);
        int f = oi.f(tbPageContext.getPageActivity(), R.dimen.tbds31);
        SkinManager.setBackgroundShapeDrawable(inflate, f, R.color.CAM_X0201, R.color.CAM_X0201);
        tbImageView.setRadius(f);
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
        int f2 = oi.f(tbPageContext.getPageActivity(), R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(tbPageContext.getPageActivity()) == 2) {
            k = oi.i(tbPageContext.getPageActivity());
        } else {
            k = oi.k(tbPageContext.getPageActivity());
        }
        int i = k - (f2 * 2);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (i * 560) / 992;
        tbImageView.setLayoutParams(layoutParams);
        SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f0801f9);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0304);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.obfuscated_res_0x7f0805f8, SvgManager.SvgResourceStateType.NORMAL);
        textView2.setOnClickListener(new b(cr4Var, intValue, str2, str, tbPageContext));
        imageView.setOnClickListener(new c(cr4Var));
        cr4Var.create(tbPageContext).show();
    }

    public static void b(Activity activity, TbPageContext<?> tbPageContext) {
        int k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, activity, tbPageContext) == null) || activity == null || tbPageContext == null) {
            return;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d031c, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c96);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c93);
        TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c94);
        TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c95);
        TextView textView5 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c92);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09209e);
        cr4 cr4Var = new cr4(activity);
        cr4Var.setContentView(inflate);
        cr4Var.setContentViewSize(2);
        cr4Var.setCanceledOnTouchOutside(true);
        cr4Var.setAutoNight(true);
        cr4Var.setCancelable(true);
        int f = oi.f(activity, R.dimen.tbds31);
        SkinManager.setBackgroundShapeDrawable(inflate, f, R.color.CAM_X0201, R.color.CAM_X0101);
        tbImageView.setRadius(f);
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
        int f2 = oi.f(activity, R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(activity) == 2) {
            k = oi.i(activity);
        } else {
            k = oi.k(activity);
        }
        int i = k - (f2 * 2);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (i * 556) / 988;
        tbImageView.setLayoutParams(layoutParams);
        SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f08058e);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView5, (int) R.color.CAM_X0302);
        textView5.setOnClickListener(new a(cr4Var));
        cr4Var.create(tbPageContext).show();
    }
}
