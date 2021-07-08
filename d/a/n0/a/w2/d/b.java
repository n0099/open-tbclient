package d.a.n0.a.w2.d;

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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import d.a.n0.a.c;
import d.a.n0.a.f;
import d.a.n0.a.v2.n0;
import d.a.n0.a.w2.d.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f48284i;
    public static int j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Activity f48285a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f48286b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public View f48287c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public View f48288d;

    /* renamed from: e  reason: collision with root package name */
    public int f48289e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48290f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.a.w2.d.a f48291g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnSystemUiVisibilityChangeListener f48292h;

    /* loaded from: classes7.dex */
    public class a implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
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
                }
            }
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(802991330, "Ld/a/n0/a/w2/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(802991330, "Ld/a/n0/a/w2/d/b;");
                return;
            }
        }
        f48284i = j();
        j = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            j = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            j = 2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Activity activity) {
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
            float f2 = 1.0f - (i3 / 255.0f);
            return ((int) (((i2 & 255) * f2) + 0.5d)) | (((int) ((((i2 >> 16) & 255) * f2) + 0.5d)) << 16) | (-16777216) | (((int) ((((i2 >> 8) & 255) * f2) + 0.5d)) << 8);
        }
        return invokeII.intValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.VERSION.SDK_INT >= 21 : invokeV.booleanValue;
    }

    public final d.a.n0.a.w2.d.a b(int i2, int i3, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            a.b b2 = a.b.b();
            b2.i(z);
            b2.h(true);
            b2.g(false);
            b2.f(i3);
            b2.e(i2);
            b2.c(z2);
            b2.d(z3);
            return b2.a();
        }
        return (d.a.n0.a.w2.d.a) invokeCommon.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int f2 = f();
            this.f48291g = b(f2, g(f2), false, false, true);
        }
    }

    @NonNull
    public d.a.n0.a.w2.d.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f48291g == null) {
                c();
            }
            return this.f48291g;
        }
        return (d.a.n0.a.w2.d.a) invokeV.objValue;
    }

    @Nullable
    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48288d : (View) invokeV.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.f48285a.getResources().getColor(c.aiapps_statusbar_immersion_bg);
            }
            return this.f48285a.getResources().getColor(c.aiapps_statusbar_immersion_bg_below_lollipop);
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

    public final View h(@NonNull d.a.n0.a.w2.d.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            if (aVar.f48276g) {
                View view = this.f48288d;
                if (view != null) {
                    if (aVar.f48274e) {
                        return view;
                    }
                    this.f48286b.removeView(view);
                    this.f48288d = null;
                    return null;
                } else if (!aVar.f48274e) {
                    this.f48288d = null;
                    return null;
                } else {
                    int u = n0.u();
                    View view2 = new View(this.f48285a);
                    view2.setTag("IMMERSION_VIEW");
                    view2.setId(f.immersion_custom_statusbar_view);
                    this.f48286b.addView(view2, new ViewGroup.LayoutParams(-1, u));
                    this.f48288d = view2;
                    return view2;
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f48290f : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f48291g = null;
            this.f48289e = 1;
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
        d.a.n0.a.w2.d.a b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && f48284i) {
            if (i2 == 1) {
                if (this.f48289e != 1) {
                    k();
                }
                this.f48289e = i2;
                b2 = d();
            } else {
                this.f48289e = i2;
                b2 = b(i2, g(i2), z3, z, z2);
                this.f48291g = b2;
            }
            this.f48290f = z;
            o(b2);
        }
    }

    public final void o(@NonNull d.a.n0.a.w2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            if (j == 2) {
                p(aVar);
            } else {
                r();
                s(aVar);
            }
            View view = this.f48287c;
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                if (aVar.f48275f) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = n0.u();
                }
                this.f48287c.setLayoutParams(layoutParams);
            }
        }
    }

    public final void p(d.a.n0.a.w2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            try {
                Window window = this.f48285a.getWindow();
                window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, aVar.f48273d ? i2 | i3 : (~i2) & i3);
                window.setAttributes(attributes);
                int i4 = aVar.f48271b;
                if (i4 == 1) {
                    i4 = f();
                }
                View h2 = h(aVar);
                if (h2 != null) {
                    h2.setBackgroundColor(i4);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
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
            Window window = this.f48285a.getWindow();
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
            q(window, d().f48273d);
        }
    }

    @SuppressLint({"InlinedApi"})
    public final void s(d.a.n0.a.w2.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            Window window = this.f48285a.getWindow();
            boolean z = aVar.f48272c;
            int i2 = aVar.f48273d ? 13312 : 5120;
            int i3 = !aVar.f48274e ? i2 & (-257) : i2 | 256;
            int i4 = aVar.f48271b;
            if (i4 == 1) {
                i4 = f();
            }
            window.getDecorView().setSystemUiVisibility(i3);
            if (Build.VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(aVar.f48270a);
            }
            View h2 = h(aVar);
            if (h2 != null) {
                h2.setBackgroundColor(i4);
            }
            if (this.f48292h == null) {
                this.f48292h = new a(this);
                window.getDecorView().setOnSystemUiVisibilityChangeListener(this.f48292h);
            }
        }
    }

    public b(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
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
        this.f48289e = 1;
        this.f48285a = activity;
        this.f48286b = viewGroup;
        this.f48287c = viewGroup.getChildAt(0);
    }
}
