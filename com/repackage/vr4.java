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
/* loaded from: classes7.dex */
public class vr4 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: n */
    public static final int obfuscated = 2131235040;
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
    public ck4 m;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr4 a;

        public a(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vr4Var;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755221575, "Lcom/repackage/vr4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755221575, "Lcom/repackage/vr4;");
        }
    }

    public vr4(Context context) {
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
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0601, (ViewGroup) null);
        this.b = viewGroup;
        this.c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0920d1);
        TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0920cb);
        this.d = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0920ca);
        this.e = tbImageView;
        tbImageView.setDefaultBgResource(obfuscated);
        this.e.setDrawCorner(true);
        this.e.setConrers(15);
        this.e.setRadius(mi.f(context, R.dimen.tbds20));
        this.i = mi.f(context, R.dimen.tbds176);
        this.h = mi.f(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.b, R.drawable.obfuscated_res_0x7f080d11);
        this.f = (WindowManager) this.a.getSystemService("window");
        g();
        this.l = new a(this);
    }

    public static vr4 h(Context context, ck4 ck4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, ck4Var)) == null) {
            vr4 vr4Var = new vr4(context);
            vr4Var.a(ck4Var);
            return vr4Var;
        }
        return (vr4) invokeLL.objValue;
    }

    public final vr4 a(ck4 ck4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ck4Var)) == null) {
            if (this.a == null) {
                return this;
            }
            if (ck4Var == null) {
                c();
                return this;
            }
            this.m = ck4Var;
            if (li.isEmpty(ck4Var.e)) {
                this.c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f136c));
            } else {
                this.c.setText(ck4Var.e);
            }
            if (li.isEmpty(ck4Var.f)) {
                this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02c0));
            } else {
                this.d.setText(ck4Var.f);
            }
            if (li.isEmpty(ck4Var.p)) {
                SkinManager.setViewTextColor(this.c, R.color.CAM_X0302, 1);
            } else {
                this.c.setTextColor(qd7.b(ck4Var.p));
            }
            if (li.isEmpty(ck4Var.q)) {
                SkinManager.setViewTextColor(this.d, R.color.CAM_X0101, 1);
            } else {
                this.d.setTextColor(qd7.b(ck4Var.q));
            }
            if (!li.isEmpty(ck4Var.o)) {
                this.d.setBackgroundDrawable(b(ck4Var.o));
            }
            if (!li.isEmpty(ck4Var.j)) {
                this.e.K(ck4Var.j, 10, false);
            }
            int i = ck4Var.i;
            if (i > 3) {
                this.k = i * 1000;
            }
            this.j = (float) ck4Var.n;
            i();
            return this;
        }
        return (vr4) invokeL.objValue;
    }

    public final StateListDrawable b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810e1);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(mi.f(this.a, R.dimen.tbds10));
            gradientDrawable.setColor(qd7.b(str));
            stateListDrawable.addState(new int[]{16842919}, drawable);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeL.objValue;
    }

    public final vr4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f136c));
            this.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02c0));
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0101, 1);
            i();
            return this;
        }
        return (vr4) invokeV.objValue;
    }

    public final void d(String str) {
        TbPageContext<?> e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || li.isEmpty(str) || (e = e(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
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
                ng.a().removeCallbacks(this.l);
            }
            this.a = null;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.g = layoutParams;
            layoutParams.width = mi.k(this.a) - (this.h * 2);
            this.g.height = mi.f(this.a, R.dimen.tbds196);
            WindowManager.LayoutParams layoutParams2 = this.g;
            layoutParams2.type = 1000;
            layoutParams2.format = -3;
            layoutParams2.windowAnimations = R.style.obfuscated_res_0x7f1003c2;
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

    public vr4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a != null) {
                this.f.addView(this.b, this.g);
                ng.a().removeCallbacks(this.l);
                ng.a().postDelayed(this.l, this.k);
                if (this.m != null) {
                    TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.m.a).param("obj_type", this.m.b));
                }
            }
            return this;
        }
        return (vr4) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ck4 ck4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view2) == null) || (ck4Var = this.m) == null) {
            return;
        }
        int i = ck4Var.d;
        if (i == ck4.D) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.m.l) && !li.isEmpty(this.m.k)) {
                d(this.m.k);
            }
        } else if (i == ck4.E && !li.isEmpty(ck4Var.k)) {
            d(this.m.k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.m.a).param("obj_type", this.m.b));
    }
}
