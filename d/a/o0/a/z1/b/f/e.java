package d.a.o0.a.z1.b.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.res.widget.toast.ToastRightAreaStyle;
import com.baidu.swan.apps.res.widget.toast.ToastTemplate;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h;
import d.a.o0.a.k;
import d.a.o0.a.v2.n0;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f49332a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f49333b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f49334c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f49335d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f49336e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f49337f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f49338g;

    /* renamed from: h  reason: collision with root package name */
    public int f49339h;

    /* renamed from: i  reason: collision with root package name */
    public int f49340i;
    public c j;
    public int k;
    public b l;
    public boolean m;
    public View n;
    public ToastRightAreaStyle o;
    public CharSequence p;
    public CharSequence q;
    public ToastLocation r;
    public ToastTemplate s;
    public boolean t;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f49341a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1218731056, "Ld/a/o0/a/z1/b/f/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1218731056, "Ld/a/o0/a/z1/b/f/e$a;");
                    return;
                }
            }
            int[] iArr = new int[ToastTemplate.values().length];
            f49341a = iArr;
            try {
                iArr[ToastTemplate.T1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49341a[ToastTemplate.T2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49341a[ToastTemplate.T3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49341a[ToastTemplate.T4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onDismiss();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-557390387, "Ld/a/o0/a/z1/b/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-557390387, "Ld/a/o0/a/z1/b/f/e;");
                return;
            }
        }
        u = k.f46335a;
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 2;
        this.o = ToastRightAreaStyle.JUMP;
        this.r = ToastLocation.MIDDLE;
        this.s = ToastTemplate.T1;
        this.t = false;
        this.f49332a = context;
        this.f49339h = 2;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            d.a.o0.a.z1.b.f.a.d();
            f.h();
        }
    }

    public static int c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? n0.u() + ((int) context.getResources().getDimension(d.a.o0.a.d.aiapps_normal_base_action_bar_height)) : invokeL.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a.o0.a.z1.b.f.a.e() || f.k() : invokeV.booleanValue;
    }

    public static e e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? new e(context) : (e) invokeL.objValue;
    }

    public static e f(@NonNull Context context, @StringRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, context, i2)) == null) {
            e eVar = new e(context);
            eVar.f49333b = context.getText(i2);
            return eVar;
        }
        return (e) invokeLI.objValue;
    }

    public static e g(@NonNull Context context, @NonNull CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, charSequence)) == null) {
            e eVar = new e(context);
            eVar.f49333b = charSequence;
            return eVar;
        }
        return (e) invokeLL.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B(false);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.f49332a;
                if (context instanceof Activity) {
                    f.n((Activity) context, this.f49333b, this.f49336e, this.n, this.f49339h, this.m);
                    return;
                }
            }
            d.a.o0.a.z1.b.f.a.j(this.f49332a, this.f49333b, this.f49336e, this.n, this.f49339h, this.m);
        }
    }

    @Deprecated
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            D(false);
        }
    }

    @Deprecated
    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && b()) {
            a();
            if (z) {
                x(this.f49332a, this.f49334c);
            } else if (this.f49332a instanceof Activity) {
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                if (1 == this.k) {
                    this.o = ToastRightAreaStyle.JUMP;
                } else {
                    this.o = ToastRightAreaStyle.BUTTON;
                }
                if (TextUtils.isEmpty(this.f49335d)) {
                    f.o((Activity) this.f49332a, null, null, null, this.f49333b, null, this.f49339h, this.r, this.j, this.m);
                    return;
                }
                CharSequence charSequence = this.f49334c;
                CharSequence charSequence2 = this.f49333b;
                if (TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.f49333b)) {
                    charSequence = this.f49333b;
                    charSequence2 = "";
                }
                f.p((Activity) this.f49332a, this.f49338g, null, null, charSequence, charSequence2, this.f49335d, this.o, this.f49339h, false, this.j);
            } else {
                b bVar2 = this.l;
                if (bVar2 != null) {
                    d.a.o0.a.z1.b.f.a.f(bVar2);
                    this.l = null;
                }
                x(this.f49332a, this.f49334c);
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            a();
            d.a.o0.a.z1.b.f.a.h(this.f49332a, this.f49333b, this.f49339h, false, this.f49340i, this.m);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            G(false);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && b()) {
            a();
            if (!z && (this.f49332a instanceof Activity)) {
                if (u) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("给View set 的mOnDismissListener是不是空?");
                    sb.append(this.l == null);
                    Log.w("UniversalToast", sb.toString());
                }
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                f.o((Activity) this.f49332a, null, null, null, this.f49333b, null, this.f49339h, this.r, this.j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                d.a.o0.a.z1.b.f.a.f(bVar2);
                this.l = null;
            }
            x(this.f49332a, this.f49333b);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            I(false);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.f49332a;
                if (context instanceof Activity) {
                    f.o((Activity) context, null, null, null, this.f49333b, null, this.f49339h, ToastLocation.BOTTOM, this.j, this.m);
                    return;
                }
            }
            x(this.f49332a, this.f49333b);
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f49332a == null) {
                if (u) {
                    throw new IllegalArgumentException("UniversalToast mContext is null!!!");
                }
                return false;
            } else if (this.f49333b == null) {
                if (u) {
                    throw new IllegalArgumentException("UniversalToast toast text is null!!!");
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public e h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this : (e) invokeI.objValue;
    }

    public e i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this : (e) invokeI.objValue;
    }

    @Deprecated
    public e j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.k = i2;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e k(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charSequence)) == null) {
            this.f49335d = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.f49339h = Math.max(i2, 1);
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e m(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            Context context = this.f49332a;
            if (context != null && context.getResources() != null) {
                this.f49336e = this.f49332a.getResources().getDrawable(i2);
            }
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e n(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, drawable)) == null) {
            this.f49336e = drawable;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e o(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, uri)) == null) {
            this.f49338g = uri;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e p(@NonNull int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.f49340i = i2;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e q(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, charSequence)) == null) {
            this.f49333b = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.m = z;
            return this;
        }
        return (e) invokeZ.objValue;
    }

    public e s(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, charSequence)) == null) {
            this.f49334c = charSequence;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e t(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, cVar)) == null) {
            this.j = cVar;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.f49332a != null && (!TextUtils.isEmpty(this.f49333b) || !TextUtils.isEmpty(this.f49334c))) {
                a();
                if (this.f49332a instanceof Activity) {
                    int i2 = a.f49341a[this.s.ordinal()];
                    if (i2 == 2) {
                        if (TextUtils.isEmpty(this.f49333b)) {
                            return;
                        }
                        f.o((Activity) this.f49332a, this.f49338g, this.f49337f, this.n, this.f49333b, this.q, this.f49339h, this.r, this.j, this.m);
                        return;
                    } else if (i2 == 3) {
                        if (TextUtils.isEmpty(this.q) && !TextUtils.isEmpty(this.f49333b)) {
                            f.o((Activity) this.f49332a, this.f49338g, this.f49337f, this.n, this.f49333b, this.q, this.f49339h, this.r, this.j, this.m);
                            return;
                        } else if (TextUtils.isEmpty(this.f49334c)) {
                            return;
                        } else {
                            f.p((Activity) this.f49332a, this.f49338g, this.f49337f, this.n, this.f49334c, this.p, this.q, this.o, this.f49339h, this.t, this.j);
                            return;
                        }
                    } else if (i2 != 4) {
                        if (TextUtils.isEmpty(this.f49333b)) {
                            return;
                        }
                        f.o((Activity) this.f49332a, null, null, null, this.f49333b, null, this.f49339h, this.r, null, this.m);
                        return;
                    } else if (TextUtils.isEmpty(this.f49333b)) {
                        return;
                    } else {
                        f.n((Activity) this.f49332a, this.f49333b, this.f49336e, this.n, this.f49339h, this.m);
                        return;
                    }
                } else if (a.f49341a[this.s.ordinal()] != 4) {
                    x(this.f49332a, TextUtils.isEmpty(this.f49333b) ? this.f49334c : this.f49333b);
                    return;
                } else if (TextUtils.isEmpty(this.f49333b)) {
                    return;
                } else {
                    d.a.o0.a.z1.b.f.a.j(this.f49332a, this.f49333b, this.f49336e, this.n, this.f49339h, this.m);
                    return;
                }
            }
            d.h("has no mToastText or mTitleText");
        }
    }

    @Deprecated
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            w(false, false);
        }
    }

    @Deprecated
    public void w(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && b()) {
            a();
            if (!z && (this.f49332a instanceof Activity)) {
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                if (TextUtils.isEmpty(this.f49335d)) {
                    this.f49335d = d.a.o0.a.c1.a.b().getResources().getText(h.aiapps_check_action_text);
                }
                f.o((Activity) this.f49332a, null, null, null, this.f49333b, this.f49335d, this.f49339h, ToastLocation.BOTTOM, this.j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                d.a.o0.a.z1.b.f.a.f(bVar2);
                this.l = null;
            }
            x(this.f49332a, this.f49333b);
        }
    }

    public final void x(Context context, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, context, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        d.a.o0.a.z1.b.f.a.k(context, null, null, null, charSequence, null, this.f49339h, this.r, null, this.m);
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            z(false);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.f49332a;
                if (context instanceof Activity) {
                    f.m((Activity) context, this.f49333b, this.f49339h, this.m);
                    return;
                }
            }
            d.a.o0.a.z1.b.f.a.i(this.f49332a, this.f49333b, this.f49339h, this.m);
        }
    }
}
