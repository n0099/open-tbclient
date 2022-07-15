package com.repackage;

import android.graphics.Matrix;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public ls7 b;
    public RelativeLayout c;
    public TextView d;
    public ImageView e;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(dw7 dw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public dw7(PbFragment pbFragment, ls7 ls7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, ls7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.a = pbFragment;
        this.b = ls7Var;
        c();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.c.setVisibility(0);
        bdTypeListView.addHeaderView(this.c);
    }

    public void b(jr7 jr7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jr7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || jr7Var == null || jr7Var.O() == null || jr7Var.O().getIsNoTitle() != 0 || jr7Var.O().isVideoThreadType()) {
            return;
        }
        if (jr7Var.j) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080ea6);
            this.e.setVisibility(0);
        } else if (z && z2) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080ee6);
            this.e.setVisibility(0);
        } else if (z) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080ee4);
            this.e.setVisibility(0);
        } else if (z2) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080ee5);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        if (this.e.getVisibility() != 0 || this.e.getLayoutParams() == null) {
            return;
        }
        this.e.getLayoutParams().height = lv7.g() - lv7.h();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0605, (ViewGroup) null);
            this.c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0917a5);
            this.e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -lv7.h());
            this.e.setImageMatrix(matrix);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09226c);
            this.d = textView;
            ur4 d = ur4.d(textView);
            d.z(R.dimen.T_X03);
            d.w(R.dimen.M_T_X003);
            d.v(R.color.CAM_X0105);
            d.A(R.string.F_X02);
            d.r(R.color.CAM_X0304);
            this.d.setVisibility(8);
            if (this.d.getParent() == null) {
                this.c.addView(this.d);
            }
            this.c.setOnTouchListener(this.b);
            this.c.setOnLongClickListener(new a(this));
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            TextView textView = this.d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                this.d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.c.setVisibility(8);
        bdTypeListView.removeHeaderView(this.c);
    }

    public void f(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jr7Var) == null) || jr7Var == null || jr7Var.O() == null) {
            return;
        }
        SpannableStringBuilder span_str = jr7Var.O().getSpan_str();
        SpannableString c = lv7.c(jr7Var.O());
        if (!StringUtils.isNull(jr7Var.O().getTitle())) {
            if (c != null) {
                span_str.append((CharSequence) c);
                this.d.setText(span_str, TextView.BufferType.SPANNABLE);
            } else {
                this.d.setText(span_str);
            }
            i(jr7Var);
            this.d.setVisibility(0);
            this.d.setMaxLines(3);
            this.d.setEllipsize(TextUtils.TruncateAt.END);
            this.d.invalidate();
            return;
        }
        this.d.setVisibility(8);
    }

    public void g(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jr7Var) == null) {
            if (jr7Var != null && !jr7Var.O().isVideoThreadType() && this.d.getText() != null && this.d.getText().length() > 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void h(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jr7Var) == null) || jr7Var == null || jr7Var.O() == null) {
            return;
        }
        SpannableStringBuilder span_str = jr7Var.O().getSpan_str();
        this.d.setOnTouchListener(new bu8(span_str));
        this.d.setText(span_str);
        this.d.setVisibility(0);
    }

    public void i(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jr7Var) == null) || this.d == null) {
            return;
        }
        int f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (jr7Var.g0()) {
            f = 0;
        }
        layoutParams.bottomMargin = f;
        this.d.setLayoutParams(layoutParams);
    }
}
