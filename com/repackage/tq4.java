package com.repackage;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class tq4 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public View b;
    public ViewGroup c;
    public View d;
    public TextView e;
    public WindowManager f;
    public WindowManager.LayoutParams g;
    public int h;
    public int i;
    public float j;
    public int k;
    public int l;
    public int m;
    public int n;
    public Drawable o;
    public View.OnClickListener p;
    public final Runnable q;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tq4 a;

        public a(tq4 tq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tq4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    public tq4(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 1.0f;
        this.k = 5000;
        this.q = new a(this);
        if (activity == null) {
            return;
        }
        this.a = activity;
        this.n = pi.f(activity, R.dimen.tbds114);
        this.l = pi.f(activity, R.dimen.tbds84);
        this.m = pi.f(activity, R.dimen.tbds44);
        this.i = pi.f(activity, R.dimen.tbds222);
        this.h = pi.f(activity, R.dimen.tbds29);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d0808, (ViewGroup) null);
        this.c = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09118d);
        this.d = inflate.findViewById(R.id.obfuscated_res_0x7f0902f7);
        this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09207c);
        this.b = inflate;
        this.d.setBackgroundDrawable(b());
        this.e.setMaxLines(1);
        this.e.setGravity(17);
        this.e.setTextSize(0, pi.f(activity, R.dimen.tbfontsize40));
        this.e.setTextColor(this.a.getResources().getColor(R.color.CAM_X0101));
        TextView textView = this.e;
        int i3 = this.m;
        textView.setPadding(i3, 0, i3, 0);
        this.f = (WindowManager) this.a.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.g = layoutParams;
        layoutParams.width = pi.k(this.a) - (this.h * 2);
        WindowManager.LayoutParams layoutParams2 = this.g;
        layoutParams2.height = this.n;
        layoutParams2.type = 1000;
        layoutParams2.format = -3;
        layoutParams2.windowAnimations = R.style.obfuscated_res_0x7f10029f;
        layoutParams2.flags = 262152;
        layoutParams2.gravity = 81;
        layoutParams2.y = d();
        this.g.alpha = this.j;
    }

    public static tq4 f(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, str)) == null) {
            tq4 tq4Var = new tq4(activity);
            tq4Var.a(str);
            return tq4Var;
        }
        return (tq4) invokeLL.objValue;
    }

    public final tq4 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                String e = gd5.e(str, 34);
                int u = pi.u(this.e.getPaint(), e);
                ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                layoutParams.width = u + (this.m * 2);
                this.c.setLayoutParams(layoutParams);
                this.e.setText(e);
            }
            return this;
        }
        return (tq4) invokeL.objValue;
    }

    public final Drawable b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.o == null) {
                this.o = c();
            }
            return this.o;
        }
        return (Drawable) invokeV.objValue;
    }

    public final GradientDrawable c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{pc7.b("#FF722B"), pc7.b("#FF2b5D")});
            gradientDrawable.setCornerRadius(this.l);
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i + UtilHelper.getNavigationBarHeight(this.a) : invokeV.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            qg.a().removeCallbacks(this.q);
            if (this.b.getWindowToken() != null) {
                this.f.removeView(this.b);
            }
        }
    }

    public tq4 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i > 0) {
                this.k = i * 1000;
            }
            return this;
        }
        return (tq4) invokeI.objValue;
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.c.setTag(obj);
            this.c.setOnClickListener(this);
        }
    }

    public tq4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            qg.a().removeCallbacks(this.q);
            View view2 = this.b;
            if (view2 != null && view2.getWindowToken() != null) {
                this.f.removeView(this.b);
            }
            this.f.addView(this.b, this.g);
            qg.a().postDelayed(this.q, this.k);
            return this;
        }
        return (tq4) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            View.OnClickListener onClickListener = this.p;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            e();
        }
    }
}
