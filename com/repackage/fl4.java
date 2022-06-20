package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class fl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final NavigationBar b;
    public final View c;
    public final Set<el4> d;
    public float e;
    public boolean f;
    public boolean g;
    public int h;

    public fl4(NavigationBar navigationBar, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {navigationBar, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds300);
        this.d = new HashSet();
        this.e = 1.0f;
        this.f = false;
        this.g = false;
        this.h = Integer.MAX_VALUE;
        this.b = navigationBar;
        this.c = view2;
    }

    public void a(el4... el4VarArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, el4VarArr) == null) || el4VarArr == null || el4VarArr.length <= 0) {
            return;
        }
        this.d.addAll(Arrays.asList(el4VarArr));
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z || !this.g || this.e >= 0.5f) {
                if (this.e < 0.5f) {
                    this.g = true;
                } else {
                    this.g = false;
                }
                for (el4 el4Var : this.d) {
                    if (el4Var.b() != null) {
                        if (el4Var.b() instanceof TextView) {
                            if (this.g && !xf8.e(this.h)) {
                                ((TextView) el4Var.b()).setTextColor(this.h);
                            } else {
                                SkinManager.setViewTextColor(el4Var.b(), d());
                            }
                        } else if (el4Var.b() instanceof ImageView) {
                            if (this.g) {
                                if (!xf8.e(this.h)) {
                                    ((ImageView) el4Var.b()).setImageDrawable(SvgManager.getInstance().getPureDrawableWithColorInt(el4Var.a(), this.h, SvgManager.SvgResourceStateType.NORMAL_PRESS));
                                } else {
                                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) el4Var.b(), el4Var.a(), R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                                }
                            } else {
                                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) el4Var.b(), el4Var.a(), R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f) {
            float abs = Math.abs(this.e - 0.5f) * 2.0f;
            for (el4 el4Var : this.d) {
                if (el4Var.b() != null) {
                    el4Var.b().setAlpha(abs);
                }
            }
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f && this.g) ? R.color.CAM_X0101 : R.color.CAM_X0106 : invokeV.intValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.contains(BaseWebViewActivity.QUERY_OPACITY) && !this.f) {
            this.f = true;
            this.e = 0.0f;
            this.h = xf8.f(i(str, "opacitybtnhex"));
            NavigationBar navigationBar = this.b;
            if (navigationBar != null && navigationBar.getBackground() != null && this.b.getBackground().mutate() != null) {
                this.b.getBackground().mutate().setAlpha(0);
            }
            View view2 = this.c;
            if (view2 != null) {
                view2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
            b(true);
        } else if (str.contains(BaseWebViewActivity.QUERY_OPACITY) || !this.f) {
        } else {
            this.f = false;
            this.e = 1.0f;
            NavigationBar navigationBar2 = this.b;
            if (navigationBar2 != null && navigationBar2.getBackground() != null && this.b.getBackground().mutate() != null) {
                this.b.getBackground().mutate().setAlpha(1);
            }
            View view3 = this.c;
            if (view3 != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view3.getLayoutParams();
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09238f);
                this.c.setLayoutParams(layoutParams);
            }
            b(true);
        }
    }

    public void f(int i) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.f && (navigationBar = this.b) != null) {
            if (navigationBar.getBackground() != null && this.b.getBackground().mutate() != null) {
                this.b.getBackground().mutate().setAlpha((int) (this.e * 255.0f));
            }
            b(true);
            c();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f) {
            b(true);
            c();
        }
    }

    public void h(int i, int i2, int i3, int i4) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) || !this.f || (navigationBar = this.b) == null || navigationBar.getBackground() == null || this.b.getBackground().mutate() == null) {
            return;
        }
        int i5 = this.a;
        if (i2 < i5) {
            this.e = (i2 * 1.0f) / i5;
        } else {
            this.e = 1.0f;
        }
        this.b.getBackground().mutate().setAlpha((int) (this.e * 255.0f));
        b(false);
        c();
    }

    public final String i(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                try {
                    String query = new URL(str).getQuery();
                    if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                        return null;
                    }
                    for (String str3 : split) {
                        String[] split2 = str3.split("=");
                        if (split2 != null && split2.length == 2) {
                            String str4 = split2[0];
                            String str5 = split2[1];
                            if (str2.equalsIgnoreCase(str4)) {
                                return str5;
                            }
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f = false;
            this.e = 1.0f;
            NavigationBar navigationBar = this.b;
            if (navigationBar != null && navigationBar.getBackground() != null && this.b.getBackground().mutate() != null) {
                this.b.getBackground().mutate().setAlpha(1);
            }
            b(true);
            c();
            this.d.clear();
        }
    }
}
