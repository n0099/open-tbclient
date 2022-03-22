package h.a.a.e.c.a;

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
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, h.a.a.e.c.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, h.a.a.e.c.a.b> f45103b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ArrayList<String>> f45104c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f45105d;

    /* renamed from: e  reason: collision with root package name */
    public Window f45106e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f45107f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f45108g;

    /* renamed from: h  reason: collision with root package name */
    public Dialog f45109h;
    public h.a.a.e.c.a.b i;
    public h.a.a.e.c.a.a j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes7.dex */
    public class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, handler};
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
            this.a = dVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (Settings.System.getInt(this.a.f45105d.getContentResolver(), "navigationbar_is_min", 0) == 1) {
                    this.a.i.p.setVisibility(8);
                    this.a.f45108g.setPadding(0, this.a.f45108g.getPaddingTop(), 0, 0);
                    return;
                }
                this.a.i.p.setVisibility(0);
                if (!this.a.i.x) {
                    if (this.a.j.l()) {
                        this.a.f45108g.setPadding(0, this.a.f45108g.getPaddingTop(), 0, this.a.j.d());
                        return;
                    } else {
                        this.a.f45108g.setPadding(0, this.a.f45108g.getPaddingTop(), this.a.j.f(), 0);
                        return;
                    }
                }
                this.a.f45108g.setPadding(0, this.a.f45108g.getPaddingTop(), 0, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-662025972, "Lh/a/a/e/c/a/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-662025972, "Lh/a/a/e/c/a/d$b;");
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1614094902, "Lh/a/a/e/c/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1614094902, "Lh/a/a/e/c/a/d;");
        }
    }

    public d(Activity activity) {
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
        this.f45103b = new HashMap();
        this.f45104c = new HashMap();
        Activity activity2 = (Activity) new WeakReference(activity).get();
        this.f45105d = activity2;
        this.f45106e = activity2.getWindow();
        String name = activity.getClass().getName();
        this.k = name;
        this.m = name;
        m();
    }

    public static d H(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) ? new d(activity) : (d) invokeL.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? str == null || str.trim().length() == 0 : invokeL.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f.m() || f.k() || Build.VERSION.SDK_INT >= 23 : invokeV.booleanValue;
    }

    public d A(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            this.i.a = i;
            return this;
        }
        return (d) invokeI.objValue;
    }

    public d B(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            C(z, 0.0f);
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public d C(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)})) == null) {
            h.a.a.e.c.a.b bVar = this.i;
            bVar.f45099h = z;
            if (!z) {
                bVar.r = 0;
            }
            if (o()) {
                this.i.f45094c = 0.0f;
            } else {
                this.i.f45094c = f2;
            }
            return this;
        }
        return (d) invokeCommon.objValue;
    }

    public final void D() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 21 || f.i() || (viewGroup = this.f45108g) == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f45108g.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                this.i.x = childAt.getFitsSystemWindows();
                if (this.i.x) {
                    this.f45108g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
        }
        h.a.a.e.c.a.b bVar = this.i;
        if (bVar.s) {
            this.f45108g.setPadding(0, this.j.i() + this.j.a(), 0, 0);
        } else if (bVar.n) {
            this.f45108g.setPadding(0, this.j.i(), 0, 0);
        } else {
            this.f45108g.setPadding(0, 0, 0, 0);
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
                    key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.i.f45094c));
                } else {
                    key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.i.m));
                }
            }
        }
    }

    public d F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.i.a = 0;
            return this;
        }
        return (d) invokeV.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if ((f.i() || f.h()) && this.j.k()) {
                h.a.a.e.c.a.b bVar = this.i;
                if (!bVar.v || !bVar.w || bVar.A == null || bVar.p == null) {
                    return;
                }
                this.f45105d.getContentResolver().unregisterContentObserver(this.i.A);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public h.a.a.e.c.a.b clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (h.a.a.e.c.a.b) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            G();
            h.a.a.e.c.a.b bVar = this.i;
            e eVar = bVar.y;
            if (eVar != null) {
                eVar.o(bVar.u);
                this.i.y = null;
            }
            if (this.f45107f != null) {
                this.f45107f = null;
            }
            if (this.f45108g != null) {
                this.f45108g = null;
            }
            if (this.j != null) {
                this.j = null;
            }
            if (this.f45106e != null) {
                this.f45106e = null;
            }
            if (this.f45109h != null) {
                this.f45109h = null;
            }
            if (this.f45105d != null) {
                this.f45105d = null;
            }
            if (n(this.m)) {
                return;
            }
            if (this.i != null) {
                this.i = null;
            }
            ArrayList<String> arrayList = this.f45104c.get(this.k);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f45103b.remove(it.next());
                }
                this.f45104c.remove(this.k);
            }
            this.a.remove(this.m);
        }
    }

    public d g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.i.n = z;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int i2 = b.a[this.i.f45098g.ordinal()];
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

    public d i() {
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
        return (d) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                int i2 = 256;
                if (i >= 21 && !f.i()) {
                    i2 = u(k(256));
                    D();
                } else {
                    l();
                    y();
                }
                this.f45106e.getDecorView().setSystemUiVisibility(h(i2));
            }
            if (f.m()) {
                s(this.f45106e, this.i.f45099h);
            } else if (f.k()) {
                h.a.a.e.c.a.b bVar = this.i;
                int i3 = bVar.r;
                if (i3 != 0) {
                    c.d(this.f45105d, i3);
                } else if (Build.VERSION.SDK_INT < 23) {
                    c.e(this.f45105d, bVar.f45099h);
                }
            } else if (f.n()) {
                t(this.i.f45099h);
            }
        }
    }

    @RequiresApi(api = 21)
    public final int k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            int i2 = i | 1024;
            h.a.a.e.c.a.b bVar = this.i;
            if (bVar.f45096e && bVar.v) {
                i2 |= 512;
            }
            this.f45106e.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            if (this.j.k()) {
                this.f45106e.clearFlags(134217728);
            }
            this.f45106e.addFlags(Integer.MIN_VALUE);
            h.a.a.e.c.a.b bVar2 = this.i;
            if (bVar2.i) {
                this.f45106e.setStatusBarColor(ColorUtils.blendARGB(bVar2.a, bVar2.j, bVar2.f45094c));
            } else {
                this.f45106e.setStatusBarColor(ColorUtils.blendARGB(bVar2.a, 0, bVar2.f45094c));
            }
            h.a.a.e.c.a.b bVar3 = this.i;
            if (bVar3.v) {
                this.f45106e.setNavigationBarColor(ColorUtils.blendARGB(bVar3.f45093b, bVar3.k, bVar3.f45095d));
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f45106e.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            x();
            if (this.j.k()) {
                h.a.a.e.c.a.b bVar = this.i;
                if (bVar.v && bVar.w) {
                    this.f45106e.addFlags(134217728);
                } else {
                    this.f45106e.clearFlags(134217728);
                }
                w();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ViewGroup viewGroup = (ViewGroup) this.f45106e.getDecorView();
            this.f45107f = viewGroup;
            this.f45108g = (ViewGroup) viewGroup.findViewById(16908290);
            this.j = new h.a.a.e.c.a.a(this.f45105d);
            if (this.a.get(this.m) == null) {
                this.i = new h.a.a.e.c.a.b();
                if (!n(this.l)) {
                    if (this.a.get(this.k) != null) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
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
        h.a.a.e.c.a.b bVar = this.i;
        if (bVar.y == null) {
            bVar.y = e.q(this.f45105d, this.f45106e);
        }
        h.a.a.e.c.a.b bVar2 = this.i;
        bVar2.y.r(bVar2);
        h.a.a.e.c.a.b bVar3 = this.i;
        if (bVar3.t) {
            bVar3.y.p(bVar3.u);
        } else {
            bVar3.y.o(bVar3.u);
        }
    }

    public d q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.i.v = z;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if ((f.i() || f.h()) && this.j.k()) {
                h.a.a.e.c.a.b bVar = this.i;
                if (bVar.v && bVar.w) {
                    if (bVar.A == null && bVar.p != null) {
                        bVar.A = new a(this, new Handler());
                    }
                    this.f45105d.getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, this.i.A);
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f45106e.addFlags(Integer.MIN_VALUE);
            }
            int systemUiVisibility = this.f45106e.getDecorView().getSystemUiVisibility();
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                systemUiVisibility = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
            } else if (i >= 19) {
                systemUiVisibility = z ? systemUiVisibility | 16 : systemUiVisibility & (-17);
            }
            this.f45106e.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    public final int u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) ? (Build.VERSION.SDK_INT < 23 || !this.i.f45099h) ? i : i | 8192 : invokeI.intValue;
    }

    public final void v() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || Build.VERSION.SDK_INT < 19 || (view = this.i.q) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = this.j.i();
        this.i.q.setLayoutParams(layoutParams);
    }

    public final void w() {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            h.a.a.e.c.a.b bVar = this.i;
            if (bVar.p == null) {
                bVar.p = new View(this.f45105d);
            }
            if (this.j.l()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.j.d());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.j.f(), -1);
                layoutParams.gravity = 8388613;
            }
            this.i.p.setLayoutParams(layoutParams);
            h.a.a.e.c.a.b bVar2 = this.i;
            if (bVar2.v && bVar2.w) {
                if (!bVar2.f45096e && bVar2.k == 0) {
                    bVar2.p.setBackgroundColor(ColorUtils.blendARGB(bVar2.f45093b, -16777216, bVar2.f45095d));
                } else {
                    h.a.a.e.c.a.b bVar3 = this.i;
                    bVar3.p.setBackgroundColor(ColorUtils.blendARGB(bVar3.f45093b, bVar3.k, bVar3.f45095d));
                }
            } else {
                this.i.p.setBackgroundColor(0);
            }
            this.i.p.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.i.p.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.i.p);
            }
            this.f45107f.addView(this.i.p);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            h.a.a.e.c.a.b bVar = this.i;
            if (bVar.o == null) {
                bVar.o = new View(this.f45105d);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.j.i());
            layoutParams.gravity = 48;
            this.i.o.setLayoutParams(layoutParams);
            h.a.a.e.c.a.b bVar2 = this.i;
            if (bVar2.i) {
                bVar2.o.setBackgroundColor(ColorUtils.blendARGB(bVar2.a, bVar2.j, bVar2.f45094c));
            } else {
                bVar2.o.setBackgroundColor(ColorUtils.blendARGB(bVar2.a, 0, bVar2.f45094c));
            }
            this.i.o.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.i.o.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.i.o);
            }
            this.f45107f.addView(this.i.o);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int childCount = this.f45108g.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f45108g.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    if (childAt instanceof DrawerLayout) {
                        View childAt2 = ((DrawerLayout) childAt).getChildAt(0);
                        if (childAt2 != null) {
                            this.i.x = childAt2.getFitsSystemWindows();
                            if (this.i.x) {
                                this.f45108g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        this.i.x = childAt.getFitsSystemWindows();
                        if (this.i.x) {
                            this.f45108g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    }
                }
            }
            if (this.j.k()) {
                h.a.a.e.c.a.b bVar = this.i;
                if (!bVar.f45097f && !bVar.f45096e) {
                    if (this.j.l()) {
                        h.a.a.e.c.a.b bVar2 = this.i;
                        if (!bVar2.s) {
                            if (bVar2.v && bVar2.w) {
                                if (bVar2.n) {
                                    this.f45108g.setPadding(0, this.j.i(), 0, this.j.d());
                                    return;
                                } else {
                                    this.f45108g.setPadding(0, 0, 0, this.j.d());
                                    return;
                                }
                            } else if (this.i.n) {
                                this.f45108g.setPadding(0, this.j.i(), 0, 0);
                                return;
                            } else {
                                this.f45108g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else if (bVar2.v && bVar2.w) {
                            this.f45108g.setPadding(0, this.j.i() + this.j.a() + 10, 0, this.j.d());
                            return;
                        } else {
                            this.f45108g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
                            return;
                        }
                    }
                    h.a.a.e.c.a.b bVar3 = this.i;
                    if (!bVar3.s) {
                        if (bVar3.v && bVar3.w) {
                            if (bVar3.n) {
                                this.f45108g.setPadding(0, this.j.i(), this.j.f(), 0);
                                return;
                            } else {
                                this.f45108g.setPadding(0, 0, this.j.f(), 0);
                                return;
                            }
                        } else if (this.i.n) {
                            this.f45108g.setPadding(0, this.j.i(), 0, 0);
                            return;
                        } else {
                            this.f45108g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    } else if (bVar3.v && bVar3.w) {
                        this.f45108g.setPadding(0, this.j.i() + this.j.a() + 10, this.j.f(), 0);
                        return;
                    } else {
                        this.f45108g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
                        return;
                    }
                }
            }
            h.a.a.e.c.a.b bVar4 = this.i;
            if (!bVar4.s) {
                if (bVar4.n) {
                    this.f45108g.setPadding(0, this.j.i(), 0, 0);
                    return;
                } else {
                    this.f45108g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
            this.f45108g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
        }
    }

    public d z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            A(ContextCompat.getColor(this.f45105d, i));
            return this;
        }
        return (d) invokeI.objValue;
    }
}
