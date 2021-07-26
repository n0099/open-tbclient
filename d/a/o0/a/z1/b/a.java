package d.a.o0.a.z1.b;

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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import d.a.o0.a.f;
import d.a.o0.a.h0.g.d;
import d.a.o0.a.h0.g.g;
import d.a.o0.a.k;
import d.a.o0.a.v2.c0;
import d.a.o0.a.v2.q0;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49169a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49170b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.z1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1007a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.w2.d.b f49171e;

        public RunnableC1007a(d.a.o0.a.w2.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49171e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.o0.a.w2.d.b bVar;
            View e2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f49171e) == null || (e2 = bVar.e()) == null) {
                return;
            }
            e2.setVisibility(0);
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f49172e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f49173f;

        public b(d dVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49172e = dVar;
            this.f49173f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.w2.d.b F1 = this.f49172e.F1();
                if (F1 != null && (e2 = F1.e()) != null) {
                    e2.setVisibility(8);
                }
                LinearLayout linearLayout = (LinearLayout) this.f49173f.findViewById(f.ai_apps_fragment_base_view);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                linearLayout.setLayoutParams(layoutParams);
                FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(f.ai_apps_fragment_content);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams2.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f49174e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f49175f;

        public c(Activity activity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49174e = activity;
            this.f49175f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49174e.getWindow().clearFlags(2048);
                a.l(a.d(this.f49174e), this.f49175f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-729070968, "Ld/a/o0/a/z1/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-729070968, "Ld/a/o0/a/z1/b/a;");
                return;
            }
        }
        f49169a = k.f46335a;
        Color.parseColor("#80000000");
        f49170b = h();
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            return;
        }
        TextUtils.equals(Build.MANUFACTURER, "Meizu");
    }

    public static View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            g W = d.a.o0.a.g1.f.V().W();
            d m = W != null ? W.m() : null;
            if (m != null) {
                return m.I1();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public static LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            d.a.o0.a.o2.b.a t = d.a.o0.a.u.e.g.g.t();
            if (t != null) {
                return t.m();
            }
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public static ViewGroup d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            if (activity != null) {
                return (ViewGroup) activity.getWindow().getDecorView();
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public static boolean e(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dialog)) == null) ? ((dialog.getWindow().getDecorView().getSystemUiVisibility() | dialog.getWindow().getAttributes().systemUiVisibility) & 2) != 0 : invokeL.booleanValue;
    }

    public static void f() {
        g W;
        d m;
        View b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) || (W = d.a.o0.a.g1.f.V().W()) == null || (b0 = (m = W.m()).b0()) == null) {
            return;
        }
        q0.X(new b(m, b0));
    }

    public static boolean g(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) ? (!f49170b || view == null || view.findViewById(f.immersion_custom_statusbar_view) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            boolean z = Build.VERSION.SDK_INT >= 21;
            return f49169a ? z & c0.b("sp_key_immersion_switch", z) : z;
        }
        return invokeV.booleanValue;
    }

    public static void i(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dialog) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        int color = dialog.getContext().getResources().getColor(d.a.o0.a.c.aiapps_dialog_immersion_status_bar_color);
        Window window = dialog.getWindow();
        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(color);
    }

    public static void j(Activity activity, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{activity, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            q0.Y(new c(activity, z), j);
        }
    }

    public static void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            j(d.a.o0.a.g1.f.V().getActivity(), 100L, z);
        }
    }

    public static void l(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65548, null, view, z) == null) || view == null) {
            return;
        }
        if (z) {
            view.setSystemUiVisibility(d.a.o0.a.v2.f.c());
        } else {
            view.setSystemUiVisibility(0);
        }
    }

    public static void m() {
        g W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, null) == null) || (W = d.a.o0.a.g1.f.V().W()) == null) {
            return;
        }
        q0.X(new RunnableC1007a(W.m().F1()));
    }
}
