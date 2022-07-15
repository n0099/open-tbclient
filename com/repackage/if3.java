package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import com.repackage.hf3;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class if3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static int j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Activity a;
    @NonNull
    public ViewGroup b;
    @Nullable
    public View c;
    @Nullable
    public View d;
    public int e;
    public boolean f;
    public hf3 g;
    public View.OnSystemUiVisibilityChangeListener h;

    /* loaded from: classes6.dex */
    public class a implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(if3 if3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755620421, "Lcom/repackage/if3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755620421, "Lcom/repackage/if3;");
                return;
            }
        }
        i = j();
        j = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            j = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            j = 2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public if3(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            if (i3 == 0) {
                return i2;
            }
            float f = 1.0f - (i3 / 255.0f);
            return ((int) (((i2 & 255) * f) + 0.5d)) | (((int) ((((i2 >> 16) & 255) * f) + 0.5d)) << 16) | (-16777216) | (((int) ((((i2 >> 8) & 255) * f) + 0.5d)) << 8);
        }
        return invokeII.intValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.VERSION.SDK_INT >= 21 : invokeV.booleanValue;
    }

    public final hf3 b(int i2, int i3, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            hf3.b b = hf3.b.b();
            b.i(z);
            b.h(true);
            b.g(false);
            b.f(i3);
            b.e(i2);
            b.c(z2);
            b.d(z3);
            return b.a();
        }
        return (hf3) invokeCommon.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int f = f();
            this.g = b(f, g(f), false, false, true);
        }
    }

    @NonNull
    public hf3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.g == null) {
                c();
            }
            return this.g;
        }
        return (hf3) invokeV.objValue;
    }

    @Nullable
    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.a.getResources().getColor(R.color.obfuscated_res_0x7f0603e0);
            }
            return this.a.getResources().getColor(R.color.obfuscated_res_0x7f0603e1);
        }
        return invokeV.intValue;
    }

    public final int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return 0;
            }
            return a(i2, 45);
        }
        return invokeI.intValue;
    }

    public final View h(@NonNull hf3 hf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hf3Var)) == null) {
            if (hf3Var.g) {
                View view2 = this.d;
                if (view2 != null) {
                    if (hf3Var.e) {
                        return view2;
                    }
                    this.b.removeView(view2);
                    this.d = null;
                    return null;
                } else if (!hf3Var.e) {
                    this.d = null;
                    return null;
                } else {
                    int t = yd3.t();
                    View view3 = new View(this.a);
                    view3.setTag("IMMERSION_VIEW");
                    view3.setId(R.id.obfuscated_res_0x7f090eb8);
                    this.b.addView(view3, new ViewGroup.LayoutParams(-1, t));
                    this.d = view3;
                    return view3;
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g = null;
            this.e = 1;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(d());
        }
    }

    public void m(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            n(i2, z, true, z2);
        }
    }

    public void n(int i2, boolean z, boolean z2, boolean z3) {
        hf3 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && i) {
            if (i2 == 1) {
                if (this.e != 1) {
                    k();
                }
                this.e = i2;
                b = d();
            } else {
                this.e = i2;
                b = b(i2, g(i2), z3, z, z2);
                this.g = b;
            }
            this.f = z;
            o(b);
        }
    }

    public final void o(@NonNull hf3 hf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hf3Var) == null) {
            if (j == 2) {
                p(hf3Var);
            } else {
                r();
                s(hf3Var);
            }
            View view2 = this.c;
            if (view2 != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
                if (hf3Var.f) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = yd3.t();
                }
                this.c.setLayoutParams(layoutParams);
            }
        }
    }

    public final void p(hf3 hf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hf3Var) == null) {
            try {
                Window window = this.a.getWindow();
                window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, hf3Var.d ? i2 | i3 : (~i2) & i3);
                window.setAttributes(attributes);
                int i4 = hf3Var.b;
                if (i4 == 1) {
                    i4 = f();
                }
                View h = h(hf3Var);
                if (h != null) {
                    h.setBackgroundColor(i4);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    public final boolean q(Window window, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, window, z)) == null) {
            if (window != null) {
                Class<?> cls = window.getClass();
                try {
                    Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                    int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                    Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                    if (z) {
                        method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                    } else {
                        method.invoke(window, 0, Integer.valueOf(i2));
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Window window = this.a.getWindow();
            window.clearFlags(1024);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21) {
                if (i2 >= 19) {
                    window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    return;
                }
                return;
            }
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.addFlags(Integer.MIN_VALUE);
            if (j != 1) {
                return;
            }
            q(window, d().d);
        }
    }

    @SuppressLint({"InlinedApi"})
    public final void s(hf3 hf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hf3Var) == null) {
            Window window = this.a.getWindow();
            boolean z = hf3Var.c;
            int i2 = hf3Var.d ? 13312 : 5120;
            int i3 = !hf3Var.e ? i2 & (-257) : i2 | 256;
            int i4 = hf3Var.b;
            if (i4 == 1) {
                i4 = f();
            }
            window.getDecorView().setSystemUiVisibility(i3);
            if (Build.VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(hf3Var.a);
            }
            View h = h(hf3Var);
            if (h != null) {
                h.setBackgroundColor(i4);
            }
            if (this.h == null) {
                this.h = new a(this);
                window.getDecorView().setOnSystemUiVisibilityChangeListener(this.h);
            }
        }
    }

    public if3(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewGroup};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = 1;
        this.a = activity;
        this.b = viewGroup;
        this.c = viewGroup.getChildAt(0);
    }
}
