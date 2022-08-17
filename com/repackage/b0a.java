package com.repackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tv.athena.revenue.payui.activity.immersion.BarHide;
@TargetApi(19)
/* loaded from: classes5.dex */
public class b0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, zz9> a;
    public Map<String, zz9> b;
    public Map<String, ArrayList<String>> c;
    public Activity d;
    public Window e;
    public ViewGroup f;
    public ViewGroup g;
    public Dialog h;
    public zz9 i;
    public yz9 j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes5.dex */
    public class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b0a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b0a b0aVar, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0aVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b0aVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (Settings.System.getInt(this.a.d.getContentResolver(), "navigationbar_is_min", 0) == 1) {
                    this.a.i.p.setVisibility(8);
                    this.a.g.setPadding(0, this.a.g.getPaddingTop(), 0, 0);
                    return;
                }
                this.a.i.p.setVisibility(0);
                if (!this.a.i.x) {
                    if (this.a.j.l()) {
                        this.a.g.setPadding(0, this.a.g.getPaddingTop(), 0, this.a.j.d());
                        return;
                    } else {
                        this.a.g.setPadding(0, this.a.g.getPaddingTop(), this.a.j.f(), 0);
                        return;
                    }
                }
                this.a.g.setPadding(0, this.a.g.getPaddingTop(), 0, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-550674368, "Lcom/repackage/b0a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-550674368, "Lcom/repackage/b0a$b;");
                    return;
                }
            }
            int[] iArr = new int[BarHide.values().length];
            a = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755879426, "Lcom/repackage/b0a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755879426, "Lcom/repackage/b0a;");
        }
    }

    public b0a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        Activity activity2 = (Activity) new WeakReference(activity).get();
        this.d = activity2;
        this.e = activity2.getWindow();
        String name = activity.getClass().getName();
        this.k = name;
        this.m = name;
        m();
    }

    public static b0a H(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) ? new b0a(activity) : (b0a) invokeL.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? str == null || str.trim().length() == 0 : invokeL.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d0a.m() || d0a.k() || Build.VERSION.SDK_INT >= 23 : invokeV.booleanValue;
    }

    public b0a A(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            this.i.a = i;
            return this;
        }
        return (b0a) invokeI.objValue;
    }

    public b0a B(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            C(z, 0.0f);
            return this;
        }
        return (b0a) invokeZ.objValue;
    }

    public b0a C(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f)})) == null) {
            zz9 zz9Var = this.i;
            zz9Var.h = z;
            if (!z) {
                zz9Var.r = 0;
            }
            if (o()) {
                this.i.c = 0.0f;
            } else {
                this.i.c = f;
            }
            return this;
        }
        return (b0a) invokeCommon.objValue;
    }

    public final void D() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 21 || d0a.i() || (viewGroup = this.g) == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.g.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                this.i.x = childAt.getFitsSystemWindows();
                if (this.i.x) {
                    this.g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
        }
        zz9 zz9Var = this.i;
        if (zz9Var.s) {
            this.g.setPadding(0, this.j.i() + this.j.a(), 0, 0);
        } else if (zz9Var.n) {
            this.g.setPadding(0, this.j.i(), 0, 0);
        } else {
            this.g.setPadding(0, 0, 0, 0);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.i.l.size() == 0) {
            return;
        }
        for (Map.Entry<View, Map<Integer, Integer>> entry : this.i.l.entrySet()) {
            View key = entry.getKey();
            Integer valueOf = Integer.valueOf(this.i.a);
            Integer valueOf2 = Integer.valueOf(this.i.j);
            for (Map.Entry<Integer, Integer> entry2 : entry.getValue().entrySet()) {
                Integer key2 = entry2.getKey();
                valueOf2 = entry2.getValue();
                valueOf = key2;
            }
            if (key != null) {
                if (Math.abs(this.i.m - 0.0f) == 0.0f) {
                    key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.i.c));
                } else {
                    key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.i.m));
                }
            }
        }
    }

    public b0a F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.i.a = 0;
            return this;
        }
        return (b0a) invokeV.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if ((d0a.i() || d0a.h()) && this.j.k()) {
                zz9 zz9Var = this.i;
                if (!zz9Var.v || !zz9Var.w || zz9Var.A == null || zz9Var.p == null) {
                    return;
                }
                this.d.getContentResolver().unregisterContentObserver(this.i.A);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public zz9 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (zz9) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            G();
            zz9 zz9Var = this.i;
            c0a c0aVar = zz9Var.y;
            if (c0aVar != null) {
                c0aVar.o(zz9Var.u);
                this.i.y = null;
            }
            if (this.f != null) {
                this.f = null;
            }
            if (this.g != null) {
                this.g = null;
            }
            if (this.j != null) {
                this.j = null;
            }
            if (this.e != null) {
                this.e = null;
            }
            if (this.h != null) {
                this.h = null;
            }
            if (this.d != null) {
                this.d = null;
            }
            if (n(this.m)) {
                return;
            }
            if (this.i != null) {
                this.i = null;
            }
            ArrayList<String> arrayList = this.c.get(this.k);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    this.b.remove(it.next());
                }
                this.c.remove(this.k);
            }
            this.a.remove(this.m);
        }
    }

    public b0a g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.i.n = z;
            return this;
        }
        return (b0a) invokeZ.objValue;
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int i2 = b.a[this.i.g.ordinal()];
                if (i2 == 1) {
                    i |= 518;
                } else if (i2 == 2) {
                    i |= ARPMessageType.MSG_TYPE_VIDEO_STOP_RES;
                } else if (i2 == 3) {
                    i |= 514;
                } else if (i2 == 4) {
                    i |= 0;
                }
            }
            return i | 4096;
        }
        return invokeI.intValue;
    }

    public b0a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.a.put(this.m, this.i);
            j();
            v();
            E();
            p();
            r();
            return this;
        }
        return (b0a) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                int i2 = 256;
                if (i >= 21 && !d0a.i()) {
                    i2 = u(k(256));
                    D();
                } else {
                    l();
                    y();
                }
                this.e.getDecorView().setSystemUiVisibility(h(i2));
            }
            if (d0a.m()) {
                s(this.e, this.i.h);
            } else if (d0a.k()) {
                zz9 zz9Var = this.i;
                int i3 = zz9Var.r;
                if (i3 != 0) {
                    a0a.d(this.d, i3);
                } else if (Build.VERSION.SDK_INT < 23) {
                    a0a.e(this.d, zz9Var.h);
                }
            } else if (d0a.n()) {
                t(this.i.h);
            }
        }
    }

    @RequiresApi(api = 21)
    public final int k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            int i2 = i | 1024;
            zz9 zz9Var = this.i;
            if (zz9Var.e && zz9Var.v) {
                i2 |= 512;
            }
            this.e.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            if (this.j.k()) {
                this.e.clearFlags(134217728);
            }
            this.e.addFlags(Integer.MIN_VALUE);
            zz9 zz9Var2 = this.i;
            if (zz9Var2.i) {
                this.e.setStatusBarColor(ColorUtils.blendARGB(zz9Var2.a, zz9Var2.j, zz9Var2.c));
            } else {
                this.e.setStatusBarColor(ColorUtils.blendARGB(zz9Var2.a, 0, zz9Var2.c));
            }
            zz9 zz9Var3 = this.i;
            if (zz9Var3.v) {
                this.e.setNavigationBarColor(ColorUtils.blendARGB(zz9Var3.b, zz9Var3.k, zz9Var3.d));
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.e.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            x();
            if (this.j.k()) {
                zz9 zz9Var = this.i;
                if (zz9Var.v && zz9Var.w) {
                    this.e.addFlags(134217728);
                } else {
                    this.e.clearFlags(134217728);
                }
                w();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ViewGroup viewGroup = (ViewGroup) this.e.getDecorView();
            this.f = viewGroup;
            this.g = (ViewGroup) viewGroup.findViewById(16908290);
            this.j = new yz9(this.d);
            if (this.a.get(this.m) == null) {
                this.i = new zz9();
                if (!n(this.l)) {
                    if (this.a.get(this.k) != null) {
                        if (Build.VERSION.SDK_INT == 19 || d0a.i()) {
                            this.i.o = this.a.get(this.k).o;
                            this.i.p = this.a.get(this.k).p;
                        }
                        this.i.y = this.a.get(this.k).y;
                    } else {
                        throw new IllegalArgumentException("在Fragment里使用时，请先在加载Fragment的Activity里初始化！！！");
                    }
                }
                this.a.put(this.m, this.i);
                return;
            }
            this.i = this.a.get(this.m);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        zz9 zz9Var = this.i;
        if (zz9Var.y == null) {
            zz9Var.y = c0a.q(this.d, this.e);
        }
        zz9 zz9Var2 = this.i;
        zz9Var2.y.r(zz9Var2);
        zz9 zz9Var3 = this.i;
        if (zz9Var3.t) {
            zz9Var3.y.p(zz9Var3.u);
        } else {
            zz9Var3.y.o(zz9Var3.u);
        }
    }

    public b0a q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.i.v = z;
            return this;
        }
        return (b0a) invokeZ.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if ((d0a.i() || d0a.h()) && this.j.k()) {
                zz9 zz9Var = this.i;
                if (zz9Var.v && zz9Var.w) {
                    if (zz9Var.A == null && zz9Var.p != null) {
                        zz9Var.A = new a(this, new Handler());
                    }
                    this.d.getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, this.i.A);
                }
            }
        }
    }

    public final void s(Window window, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, window, z) == null) || window == null) {
            return;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            if (z) {
                method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } else {
                method.invoke(window, 0, Integer.valueOf(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.e.addFlags(Integer.MIN_VALUE);
            }
            int systemUiVisibility = this.e.getDecorView().getSystemUiVisibility();
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                systemUiVisibility = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
            } else if (i >= 19) {
                systemUiVisibility = z ? systemUiVisibility | 16 : systemUiVisibility & (-17);
            }
            this.e.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    public final int u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) ? (Build.VERSION.SDK_INT < 23 || !this.i.h) ? i : i | 8192 : invokeI.intValue;
    }

    public final void v() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || Build.VERSION.SDK_INT < 19 || (view2 = this.i.q) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = this.j.i();
        this.i.q.setLayoutParams(layoutParams);
    }

    public final void w() {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            zz9 zz9Var = this.i;
            if (zz9Var.p == null) {
                zz9Var.p = new View(this.d);
            }
            if (this.j.l()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.j.d());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.j.f(), -1);
                layoutParams.gravity = 8388613;
            }
            this.i.p.setLayoutParams(layoutParams);
            zz9 zz9Var2 = this.i;
            if (zz9Var2.v && zz9Var2.w) {
                if (!zz9Var2.e && zz9Var2.k == 0) {
                    zz9Var2.p.setBackgroundColor(ColorUtils.blendARGB(zz9Var2.b, -16777216, zz9Var2.d));
                } else {
                    zz9 zz9Var3 = this.i;
                    zz9Var3.p.setBackgroundColor(ColorUtils.blendARGB(zz9Var3.b, zz9Var3.k, zz9Var3.d));
                }
            } else {
                this.i.p.setBackgroundColor(0);
            }
            this.i.p.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.i.p.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.i.p);
            }
            this.f.addView(this.i.p);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            zz9 zz9Var = this.i;
            if (zz9Var.o == null) {
                zz9Var.o = new View(this.d);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.j.i());
            layoutParams.gravity = 48;
            this.i.o.setLayoutParams(layoutParams);
            zz9 zz9Var2 = this.i;
            if (zz9Var2.i) {
                zz9Var2.o.setBackgroundColor(ColorUtils.blendARGB(zz9Var2.a, zz9Var2.j, zz9Var2.c));
            } else {
                zz9Var2.o.setBackgroundColor(ColorUtils.blendARGB(zz9Var2.a, 0, zz9Var2.c));
            }
            this.i.o.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.i.o.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.i.o);
            }
            this.f.addView(this.i.o);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int childCount = this.g.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.g.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    if (childAt instanceof DrawerLayout) {
                        View childAt2 = ((DrawerLayout) childAt).getChildAt(0);
                        if (childAt2 != null) {
                            this.i.x = childAt2.getFitsSystemWindows();
                            if (this.i.x) {
                                this.g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        this.i.x = childAt.getFitsSystemWindows();
                        if (this.i.x) {
                            this.g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    }
                }
            }
            if (this.j.k()) {
                zz9 zz9Var = this.i;
                if (!zz9Var.f && !zz9Var.e) {
                    if (this.j.l()) {
                        zz9 zz9Var2 = this.i;
                        if (!zz9Var2.s) {
                            if (zz9Var2.v && zz9Var2.w) {
                                if (zz9Var2.n) {
                                    this.g.setPadding(0, this.j.i(), 0, this.j.d());
                                    return;
                                } else {
                                    this.g.setPadding(0, 0, 0, this.j.d());
                                    return;
                                }
                            } else if (this.i.n) {
                                this.g.setPadding(0, this.j.i(), 0, 0);
                                return;
                            } else {
                                this.g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else if (zz9Var2.v && zz9Var2.w) {
                            this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, this.j.d());
                            return;
                        } else {
                            this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
                            return;
                        }
                    }
                    zz9 zz9Var3 = this.i;
                    if (!zz9Var3.s) {
                        if (zz9Var3.v && zz9Var3.w) {
                            if (zz9Var3.n) {
                                this.g.setPadding(0, this.j.i(), this.j.f(), 0);
                                return;
                            } else {
                                this.g.setPadding(0, 0, this.j.f(), 0);
                                return;
                            }
                        } else if (this.i.n) {
                            this.g.setPadding(0, this.j.i(), 0, 0);
                            return;
                        } else {
                            this.g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    } else if (zz9Var3.v && zz9Var3.w) {
                        this.g.setPadding(0, this.j.i() + this.j.a() + 10, this.j.f(), 0);
                        return;
                    } else {
                        this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
                        return;
                    }
                }
            }
            zz9 zz9Var4 = this.i;
            if (!zz9Var4.s) {
                if (zz9Var4.n) {
                    this.g.setPadding(0, this.j.i(), 0, 0);
                    return;
                } else {
                    this.g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
            this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
        }
    }

    public b0a z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            A(ContextCompat.getColor(this.d, i));
            return this;
        }
        return (b0a) invokeI.objValue;
    }
}
