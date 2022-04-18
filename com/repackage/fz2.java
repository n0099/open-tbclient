package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes6.dex */
public class fz2 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kf3 a;

        public a(kf3 kf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kf3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            kf3 kf3Var;
            View e;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (kf3Var = this.a) == null || (e = kf3Var.e()) == null) {
                return;
            }
            e.setVisibility(0);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz1 a;
        public final /* synthetic */ View b;

        public b(pz1 pz1Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz1Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz1Var;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            View e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kf3 H1 = this.a.H1();
                if (H1 != null && (e = H1.e()) != null) {
                    e.setVisibility(8);
                }
                LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090181);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                linearLayout.setLayoutParams(layoutParams);
                FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f090182);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams2.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ boolean b;

        public c(Activity activity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getWindow().clearFlags(2048);
                fz2.n(fz2.e(this.a), this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755690605, "Lcom/repackage/fz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755690605, "Lcom/repackage/fz2;");
                return;
            }
        }
        a = tg1.a;
        Color.parseColor("#80000000");
        b = j();
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            return;
        }
        TextUtils.equals(Build.MANUFACTURER, "Meizu");
    }

    public static View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            sz1 V = wl2.U().V();
            return c(V != null ? V.m() : null);
        }
        return (View) invokeV.objValue;
    }

    public static View c(pz1 pz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pz1Var)) == null) {
            if (pz1Var != null) {
                return pz1Var.K1();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static LinearLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            vb3 z = jp1.z();
            if (z != null) {
                return z.m();
            }
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public static ViewGroup e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            if (activity != null) {
                return (ViewGroup) activity.getWindow().getDecorView();
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public static boolean f(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, dialog)) == null) ? ((dialog.getWindow().getDecorView().getSystemUiVisibility() | dialog.getWindow().getAttributes().systemUiVisibility) & 2) != 0 : invokeL.booleanValue;
    }

    public static void g() {
        sz1 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || (V = wl2.U().V()) == null) {
            return;
        }
        h(V.m());
    }

    public static void h(pz1 pz1Var) {
        View S;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, pz1Var) == null) || (S = pz1Var.S()) == null) {
            return;
        }
        de3.a0(new b(pz1Var, S));
    }

    public static boolean i(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view2)) == null) ? (!b || view2 == null || view2.findViewById(R.id.obfuscated_res_0x7f090ee4) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            boolean z = Build.VERSION.SDK_INT >= 21;
            return a ? z & pd3.b("sp_key_immersion_switch", z) : z;
        }
        return invokeV.booleanValue;
    }

    public static void k(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, dialog) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        int color = dialog.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06038d);
        Window window = dialog.getWindow();
        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(color);
    }

    public static void l(Activity activity, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{activity, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            de3.b0(new c(activity, z), j);
        }
    }

    public static void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            l(wl2.U().getActivity(), 100L, z);
        }
    }

    public static void n(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65550, null, view2, z) == null) || view2 == null) {
            return;
        }
        if (z) {
            view2.setSystemUiVisibility(sc3.c());
        } else {
            view2.setSystemUiVisibility(0);
        }
    }

    public static void o() {
        sz1 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, null) == null) || (V = wl2.U().V()) == null) {
            return;
        }
        de3.a0(new a(V.m().H1()));
    }
}
