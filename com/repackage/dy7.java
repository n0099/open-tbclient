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
/* loaded from: classes6.dex */
public class dy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public hu7 b;
    public RelativeLayout c;
    public TextView d;
    public ImageView e;

    /* loaded from: classes6.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(dy7 dy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var};
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

    public dy7(PbFragment pbFragment, hu7 hu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, hu7Var};
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
        this.b = hu7Var;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.c.setVisibility(0);
        bdTypeListView.addHeaderView(this.c);
    }

    public void b(ft7 ft7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{ft7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || ft7Var == null || ft7Var.O() == null || ft7Var.O().getIsNoTitle() != 0 || ft7Var.O().isVideoThreadType()) {
            return;
        }
        if (ft7Var.j) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f0d);
            this.e.setVisibility(0);
        } else if (z && z2) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f4f);
            this.e.setVisibility(0);
        } else if (z) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f4d);
            this.e.setVisibility(0);
        } else if (z2) {
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080f4e);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        if (this.e.getVisibility() != 0 || this.e.getLayoutParams() == null) {
            return;
        }
        this.e.getLayoutParams().height = lx7.i() - lx7.j();
    }

    public final SpannableStringBuilder c(SpannableStringBuilder spannableStringBuilder, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder, z)) == null) {
            if (z) {
                int f = qi.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int f2 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int f3 = qi.f(TbadkCoreApplication.getInst(), R.dimen.T_X09);
                int f4 = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f5 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int f6 = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int f7 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds52);
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dc0);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                spannableStringBuilder2.append((CharSequence) string);
                vu4 vu4Var = new vu4(f, -1, R.color.CAM_X0302, f3, R.color.CAM_X0101, f4, f7);
                vu4Var.f(true);
                vu4Var.b(f2);
                vu4Var.h(f5);
                vu4Var.i(f6);
                vu4Var.g(true);
                vu4Var.d(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                spannableStringBuilder2.setSpan(vu4Var, 0, string.length(), 17);
                spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
                return spannableStringBuilder2;
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d062f, (ViewGroup) null);
            this.c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09184d);
            this.e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -lx7.j());
            this.e.setImageMatrix(matrix);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092379);
            this.d = textView;
            ms4 d = ms4.d(textView);
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

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            TextView textView = this.d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                this.d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.c.setVisibility(8);
        bdTypeListView.removeHeaderView(this.c);
    }

    public void g(ft7 ft7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ft7Var) == null) || ft7Var == null || ft7Var.O() == null) {
            return;
        }
        SpannableStringBuilder span_str = ft7Var.O().getSpan_str();
        SpannableString c = lx7.c(ft7Var.O());
        if (!StringUtils.isNull(ft7Var.O().getTitle())) {
            if (c != null) {
                span_str.append((CharSequence) c);
                this.d.setText(span_str, TextView.BufferType.SPANNABLE);
            } else {
                this.d.setText(span_str);
            }
            j(ft7Var);
            this.d.setVisibility(0);
            this.d.setMaxLines(3);
            this.d.setEllipsize(TextUtils.TruncateAt.END);
            this.d.invalidate();
            return;
        }
        this.d.setVisibility(8);
    }

    public void h(ft7 ft7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ft7Var) == null) {
            if (ft7Var != null && !ft7Var.O().isVideoThreadType() && this.d.getText() != null && this.d.getText().length() > 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void i(ft7 ft7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ft7Var) == null) || ft7Var == null || ft7Var.O() == null) {
            return;
        }
        SpannableStringBuilder span_str = ft7Var.O().getSpan_str();
        this.d.setOnTouchListener(new rw8(span_str));
        this.d.setText(c(span_str, ft7Var.O().isQuestionThread()));
        this.d.setVisibility(0);
    }

    public void j(ft7 ft7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, ft7Var) == null) || this.d == null) {
            return;
        }
        int f = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (ft7Var.i0()) {
            f = 0;
        }
        layoutParams.bottomMargin = f;
        this.d.setLayoutParams(layoutParams);
    }
}
