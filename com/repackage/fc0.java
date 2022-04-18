package com.repackage;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fc0 {
    public static /* synthetic */ Interceptable $ic;
    public static fc0 d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public bc0 c;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final fc0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-390517983, "Lcom/repackage/fc0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-390517983, "Lcom/repackage/fc0$a;");
                    return;
                }
            }
            a = new fc0();
        }
    }

    public fc0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = Config.TRACE_VISIT_RECENT_DAY;
    }

    public static fc0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                d = a.a;
            }
            return d;
        }
        return (fc0) invokeV.objValue;
    }

    public int a(Context context, boolean z, String str) {
        InterceptResult invokeCommon;
        bc0 bc0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), str})) == null) {
            if (TextUtils.isEmpty(str) || (bc0Var = this.c) == null) {
                return -16777216;
            }
            return bc0Var.a(context, z, str);
        }
        return invokeCommon.intValue;
    }

    public int b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (z) {
                return fa0.a().h;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return fa0.a().f;
            }
            if ("dark".equals(this.b)) {
                return fa0.a().g;
            }
            return fa0.a().e;
        }
        return invokeZ.intValue;
    }

    public int c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (z) {
                return fa0.a().n;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return fa0.a().l;
            }
            if ("dark".equals(this.b)) {
                return fa0.a().m;
            }
            return fa0.a().k;
        }
        return invokeZ.intValue;
    }

    public int d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (z) {
                return fa0.a().t;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return fa0.a().r;
            }
            if ("dark".equals(this.b)) {
                return fa0.a().s;
            }
            return fa0.a().q;
        }
        return invokeZ.intValue;
    }

    public String f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (z) {
                return u90.a().o;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return u90.a().m;
            }
            if ("dark".equals(this.b)) {
                return u90.a().n;
            }
            return u90.a().l;
        }
        return (String) invokeZ.objValue;
    }

    public int g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                return u90.a().s;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return u90.a().q;
            }
            if ("dark".equals(this.b)) {
                return u90.a().r;
            }
            return u90.a().p;
        }
        return invokeZ.intValue;
    }

    public String h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (z) {
                return u90.a().w;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return u90.a().u;
            }
            if ("dark".equals(this.b)) {
                return u90.a().v;
            }
            return u90.a().t;
        }
        return (String) invokeZ.objValue;
    }

    public int i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (z) {
                return u90.a().A;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return u90.a().y;
            }
            if ("dark".equals(this.b)) {
                return u90.a().z;
            }
            return u90.a().x;
        }
        return invokeZ.intValue;
    }

    public int j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (z) {
                return fa0.a().d;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return fa0.a().b;
            }
            if ("dark".equals(this.b)) {
                return fa0.a().c;
            }
            return fa0.a().a;
        }
        return invokeZ.intValue;
    }

    public String k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (z) {
                return u90.a().d;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return u90.a().b;
            }
            if ("dark".equals(this.b)) {
                return u90.a().c;
            }
            return u90.a().a;
        }
        return (String) invokeZ.objValue;
    }

    public int l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            if (z) {
                return u90.a().h;
            }
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return u90.a().f;
            }
            if ("dark".equals(this.b)) {
                return u90.a().g;
            }
            return u90.a().e;
        }
        return invokeZ.intValue;
    }

    public GradientDrawable m(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, context, z)) == null) {
            float a2 = y90.a(context, 18.0f);
            float[] fArr = {a2, a2, a2, a2, a2, a2, a2, a2};
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(fArr);
            gradientDrawable.setColor(a(context, z, "color_btn_fill"));
            gradientDrawable.setStroke(1, a(context, z, "color_btn_stroke"));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeLZ.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(this.b)) {
                return R.drawable.obfuscated_res_0x7f080d21;
            }
            if ("dark".equals(this.b)) {
            }
            return R.drawable.obfuscated_res_0x7f080d20;
        }
        return invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.a = str;
            if (q(str2)) {
                this.b = str2;
            }
            if ("baidu".equals(this.a)) {
                this.c = new ac0();
            } else if ("haokan".equals(this.a)) {
                this.c = new cc0();
            } else if ("quanmin".equals(this.a)) {
                this.c = new dc0();
            } else if ("tieba".equals(this.a)) {
                this.c = new ec0();
            }
            this.c.b(str2);
        }
    }

    public final boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? Config.TRACE_VISIT_RECENT_DAY.equals(str) || SkinManager.SKIN_TYPE_STR_NIGHT.equals(str) || "dark".equals(str) : invokeL.booleanValue;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && q(str)) {
            this.b = str;
            bc0 bc0Var = this.c;
            if (bc0Var != null) {
                bc0Var.b(str);
            }
        }
    }
}
