package com.repackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;

        public a(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    public static void a(Activity activity, TbPageContext<?> tbPageContext) {
        int k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, activity, tbPageContext) == null) || activity == null || tbPageContext == null) {
            return;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d030c, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c47);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c44);
        TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c45);
        TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c46);
        TextView textView5 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c43);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09209f);
        dq4 dq4Var = new dq4(activity);
        dq4Var.setContentView(inflate);
        dq4Var.setContentViewSize(2);
        dq4Var.setCanceledOnTouchOutside(true);
        dq4Var.setAutoNight(true);
        dq4Var.setCancelable(true);
        int f = li.f(activity, R.dimen.tbds31);
        SkinManager.setBackgroundShapeDrawable(inflate, f, R.color.CAM_X0201, R.color.CAM_X0101);
        tbImageView.setRadius(f);
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
        int f2 = li.f(activity, R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(activity) == 2) {
            k = li.i(activity);
        } else {
            k = li.k(activity);
        }
        int i = k - (f2 * 2);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (i * 556) / 988;
        tbImageView.setLayoutParams(layoutParams);
        SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f08057d);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView5, (int) R.color.CAM_X0302);
        textView5.setOnClickListener(new a(dq4Var));
        dq4Var.create(tbPageContext).show();
    }
}
