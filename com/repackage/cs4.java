package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class cs4 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: n */
    public static final int obfuscated = 2131235022;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewGroup b;
    public TextView c;
    public TextView d;
    public TbImageView e;
    public WindowManager f;
    public WindowManager.LayoutParams g;
    public int h;
    public int i;
    public float j;
    public int k;
    public Runnable l;
    public gk4 m;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs4 a;

        public a(cs4 cs4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cs4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755786643, "Lcom/repackage/cs4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755786643, "Lcom/repackage/cs4;");
        }
    }

    public cs4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 1.0f;
        this.k = 3000;
        if (context == null) {
            return;
        }
        this.a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d063a, (ViewGroup) null);
        this.b = viewGroup;
        this.c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09221b);
        TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092215);
        this.d = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f092214);
        this.e = tbImageView;
        tbImageView.setDefaultBgResource(obfuscated);
        this.e.setDrawCorner(true);
        this.e.setConrers(15);
        this.e.setRadius(qi.f(context, R.dimen.tbds20));
        this.i = qi.f(context, R.dimen.tbds176);
        this.h = qi.f(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.b, R.drawable.obfuscated_res_0x7f080cb0);
        this.f = (WindowManager) this.a.getSystemService("window");
        g();
        this.l = new a(this);
    }

    public static cs4 h(Context context, gk4 gk4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, gk4Var)) == null) {
            cs4 cs4Var = new cs4(context);
            cs4Var.a(gk4Var);
            return cs4Var;
        }
        return (cs4) invokeLL.objValue;
    }

    public final cs4 a(gk4 gk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gk4Var)) == null) {
            if (this.a == null) {
                return this;
            }
            if (gk4Var == null) {
                c();
                return this;
            }
            this.m = gk4Var;
            if (pi.isEmpty(gk4Var.e)) {
                this.c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1372));
            } else {
                this.c.setText(gk4Var.e);
            }
            if (pi.isEmpty(gk4Var.f)) {
                this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02c9));
            } else {
                this.d.setText(gk4Var.f);
            }
            if (pi.isEmpty(gk4Var.p)) {
                SkinManager.setViewTextColor(this.c, R.color.CAM_X0302, 1);
            } else {
                this.c.setTextColor(bf7.b(gk4Var.p));
            }
            if (pi.isEmpty(gk4Var.q)) {
                SkinManager.setViewTextColor(this.d, R.color.CAM_X0101, 1);
            } else {
                this.d.setTextColor(bf7.b(gk4Var.q));
            }
            if (!pi.isEmpty(gk4Var.o)) {
                this.d.setBackgroundDrawable(b(gk4Var.o));
            }
            if (!pi.isEmpty(gk4Var.j)) {
                this.e.K(gk4Var.j, 10, false);
            }
            int i = gk4Var.i;
            if (i > 3) {
                this.k = i * 1000;
            }
            this.j = (float) gk4Var.n;
            i();
            return this;
        }
        return (cs4) invokeL.objValue;
    }

    public final StateListDrawable b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810cf);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(qi.f(this.a, R.dimen.tbds10));
            gradientDrawable.setColor(bf7.b(str));
            stateListDrawable.addState(new int[]{16842919}, drawable);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeL.objValue;
    }

    public final cs4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1372));
            this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02c9));
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0101, 1);
            i();
            return this;
        }
        return (cs4) invokeV.objValue;
    }

    public final void d(String str) {
        TbPageContext<?> e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || pi.isEmpty(str) || (e = e(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(e, new String[]{str});
    }

    public final TbPageContext e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a != null) {
                if (this.b.getWindowToken() != null) {
                    this.f.removeView(this.b);
                }
                rg.a().removeCallbacks(this.l);
            }
            this.a = null;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.g = layoutParams;
            layoutParams.width = qi.k(this.a) - (this.h * 2);
            this.g.height = qi.f(this.a, R.dimen.tbds196);
            WindowManager.LayoutParams layoutParams2 = this.g;
            layoutParams2.type = 1000;
            layoutParams2.format = -3;
            layoutParams2.windowAnimations = R.style.obfuscated_res_0x7f1003cc;
            layoutParams2.flags = 262152;
            layoutParams2.gravity = 81;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            WindowManager.LayoutParams layoutParams = this.g;
            layoutParams.y = this.i;
            layoutParams.alpha = this.j;
        }
    }

    public cs4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a != null) {
                this.f.addView(this.b, this.g);
                rg.a().removeCallbacks(this.l);
                rg.a().postDelayed(this.l, this.k);
                if (this.m != null) {
                    TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.m.a).param("obj_type", this.m.b));
                }
            }
            return this;
        }
        return (cs4) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        gk4 gk4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view2) == null) || (gk4Var = this.m) == null) {
            return;
        }
        int i = gk4Var.d;
        if (i == gk4.D) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.m.l) && !pi.isEmpty(this.m.k)) {
                d(this.m.k);
            }
        } else if (i == gk4.E && !pi.isEmpty(gk4Var.k)) {
            d(this.m.k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.m.a).param("obj_type", this.m.b));
    }
}
