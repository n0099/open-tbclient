package com.repackage;

import android.annotation.SuppressLint;
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
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.res.widget.toast.ToastRightAreaStyle;
import com.baidu.swan.apps.res.widget.toast.ToastTemplate;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public CharSequence b;
    public CharSequence c;
    public CharSequence d;
    public Drawable e;
    public Drawable f;
    public Uri g;
    public int h;
    public int i;
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

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-237124124, "Lcom/repackage/m03$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-237124124, "Lcom/repackage/m03$a;");
                    return;
                }
            }
            int[] iArr = new int[ToastTemplate.values().length];
            a = iArr;
            try {
                iArr[ToastTemplate.T1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ToastTemplate.T2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ToastTemplate.T3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ToastTemplate.T4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onDismiss();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755553151, "Lcom/repackage/m03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755553151, "Lcom/repackage/m03;");
                return;
            }
        }
        u = eh1.a;
    }

    public m03(Context context) {
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
        this.k = 2;
        this.o = ToastRightAreaStyle.JUMP;
        this.r = ToastLocation.MIDDLE;
        this.s = ToastTemplate.T1;
        this.t = false;
        this.a = context;
        this.h = 2;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            i03.d();
            n03.h();
        }
    }

    public static int c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? le3.t() + ((int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f07015b)) : invokeL.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? i03.e() || n03.k() : invokeV.booleanValue;
    }

    public static m03 e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? new m03(context) : (m03) invokeL.objValue;
    }

    public static m03 f(@NonNull Context context, @StringRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i)) == null) {
            m03 m03Var = new m03(context);
            m03Var.b = context.getText(i);
            return m03Var;
        }
        return (m03) invokeLI.objValue;
    }

    public static m03 g(@NonNull Context context, @NonNull CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, charSequence)) == null) {
            m03 m03Var = new m03(context);
            m03Var.b = charSequence;
            return m03Var;
        }
        return (m03) invokeLL.objValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.a;
                if (context instanceof Activity) {
                    n03.m((Activity) context, this.b, this.h, this.m);
                    return;
                }
            }
            i03.i(this.a, this.b, this.h, this.m);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C(false);
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.a;
                if (context instanceof Activity) {
                    n03.n((Activity) context, this.b, this.e, this.n, this.h, this.m);
                    return;
                }
            }
            i03.j(this.a, this.b, this.e, this.n, this.h, this.m);
        }
    }

    @Deprecated
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            E(false);
        }
    }

    @Deprecated
    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && b()) {
            a();
            if (z) {
                y(this.a, this.c);
            } else if (this.a instanceof Activity) {
                b bVar = this.l;
                if (bVar != null) {
                    n03.l(bVar);
                    this.l = null;
                }
                if (1 == this.k) {
                    this.o = ToastRightAreaStyle.JUMP;
                } else {
                    this.o = ToastRightAreaStyle.BUTTON;
                }
                if (TextUtils.isEmpty(this.d)) {
                    n03.o((Activity) this.a, null, null, null, this.b, null, this.h, this.r, this.j, this.m);
                    return;
                }
                CharSequence charSequence = this.c;
                CharSequence charSequence2 = this.b;
                if (TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.b)) {
                    charSequence = this.b;
                    charSequence2 = "";
                }
                n03.p((Activity) this.a, this.g, null, null, charSequence, charSequence2, this.d, this.o, this.h, false, this.j);
            } else {
                b bVar2 = this.l;
                if (bVar2 != null) {
                    i03.f(bVar2);
                    this.l = null;
                }
                y(this.a, this.c);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && b()) {
            a();
            i03.h(this.a, this.b, this.h, false, this.i, this.m);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            H(false);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && b()) {
            a();
            if (!z && (this.a instanceof Activity)) {
                if (u) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("给View set 的mOnDismissListener是不是空?");
                    sb.append(this.l == null);
                    Log.w("UniversalToast", sb.toString());
                }
                b bVar = this.l;
                if (bVar != null) {
                    n03.l(bVar);
                    this.l = null;
                }
                n03.o((Activity) this.a, null, null, null, this.b, null, this.h, this.r, this.j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                i03.f(bVar2);
                this.l = null;
            }
            y(this.a, this.b);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            J(false);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && b()) {
            a();
            if (!z) {
                Context context = this.a;
                if (context instanceof Activity) {
                    n03.o((Activity) context, null, null, null, this.b, null, this.h, ToastLocation.BOTTOM, this.j, this.m);
                    return;
                }
            }
            y(this.a, this.b);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.a == null) {
                if (u) {
                    throw new IllegalArgumentException("UniversalToast mContext is null!!!");
                }
                return false;
            } else if (this.b == null) {
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
    public m03 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? this : (m03) invokeI.objValue;
    }

    public m03 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? this : (m03) invokeI.objValue;
    }

    @Deprecated
    public m03 j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.k = i;
            return this;
        }
        return (m03) invokeI.objValue;
    }

    public m03 k(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, charSequence)) == null) {
            this.d = charSequence;
            return this;
        }
        return (m03) invokeL.objValue;
    }

    public m03 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            this.h = Math.max(i, 1);
            return this;
        }
        return (m03) invokeI.objValue;
    }

    public m03 m(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            Context context = this.a;
            if (context != null && context.getResources() != null) {
                this.e = this.a.getResources().getDrawable(i);
            }
            return this;
        }
        return (m03) invokeI.objValue;
    }

    public m03 n(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, drawable)) == null) {
            this.e = drawable;
            return this;
        }
        return (m03) invokeL.objValue;
    }

    public m03 o(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
            this.g = uri;
            return this;
        }
        return (m03) invokeL.objValue;
    }

    public m03 p(ToastLocation toastLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, toastLocation)) == null) {
            this.r = toastLocation;
            return this;
        }
        return (m03) invokeL.objValue;
    }

    public m03 q(@NonNull int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            this.i = i;
            return this;
        }
        return (m03) invokeI.objValue;
    }

    public m03 r(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, charSequence)) == null) {
            this.b = charSequence;
            return this;
        }
        return (m03) invokeL.objValue;
    }

    public m03 s(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.m = z;
            return this;
        }
        return (m03) invokeZ.objValue;
    }

    public m03 t(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, charSequence)) == null) {
            this.c = charSequence;
            return this;
        }
        return (m03) invokeL.objValue;
    }

    public m03 u(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, cVar)) == null) {
            this.j = cVar;
            return this;
        }
        return (m03) invokeL.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.a != null && (!TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.c))) {
                a();
                if (this.a instanceof Activity) {
                    int i = a.a[this.s.ordinal()];
                    if (i == 2) {
                        if (TextUtils.isEmpty(this.b)) {
                            return;
                        }
                        n03.o((Activity) this.a, this.g, this.f, this.n, this.b, this.q, this.h, this.r, this.j, this.m);
                        return;
                    } else if (i == 3) {
                        if (TextUtils.isEmpty(this.q) && !TextUtils.isEmpty(this.b)) {
                            n03.o((Activity) this.a, this.g, this.f, this.n, this.b, this.q, this.h, this.r, this.j, this.m);
                            return;
                        } else if (TextUtils.isEmpty(this.c)) {
                            return;
                        } else {
                            n03.p((Activity) this.a, this.g, this.f, this.n, this.c, this.p, this.q, this.o, this.h, this.t, this.j);
                            return;
                        }
                    } else if (i != 4) {
                        if (TextUtils.isEmpty(this.b)) {
                            return;
                        }
                        n03.o((Activity) this.a, null, null, null, this.b, null, this.h, this.r, null, this.m);
                        return;
                    } else if (TextUtils.isEmpty(this.b)) {
                        return;
                    } else {
                        n03.n((Activity) this.a, this.b, this.e, this.n, this.h, this.m);
                        return;
                    }
                } else if (a.a[this.s.ordinal()] != 4) {
                    y(this.a, TextUtils.isEmpty(this.b) ? this.c : this.b);
                    return;
                } else if (TextUtils.isEmpty(this.b)) {
                    return;
                } else {
                    i03.j(this.a, this.b, this.e, this.n, this.h, this.m);
                    return;
                }
            }
            l03.h("has no mToastText or mTitleText");
        }
    }

    @Deprecated
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            x(false, false);
        }
    }

    @Deprecated
    public void x(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && b()) {
            a();
            if (!z && (this.a instanceof Activity)) {
                b bVar = this.l;
                if (bVar != null) {
                    n03.l(bVar);
                    this.l = null;
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = bk2.c().getResources().getText(R.string.obfuscated_res_0x7f0f010e);
                }
                n03.o((Activity) this.a, null, null, null, this.b, this.d, this.h, ToastLocation.BOTTOM, this.j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                i03.f(bVar2);
                this.l = null;
            }
            y(this.a, this.b);
        }
    }

    public final void y(Context context, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, context, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        i03.k(context, null, null, null, charSequence, null, this.h, this.r, null, this.m);
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            A(false);
        }
    }
}
