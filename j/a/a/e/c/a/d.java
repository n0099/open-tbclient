package j.a.a.e.c.a;

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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, j.a.a.e.c.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, j.a.a.e.c.a.b> f60787b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ArrayList<String>> f60788c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f60789d;

    /* renamed from: e  reason: collision with root package name */
    public Window f60790e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f60791f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f60792g;

    /* renamed from: h  reason: collision with root package name */
    public Dialog f60793h;

    /* renamed from: i  reason: collision with root package name */
    public j.a.a.e.c.a.b f60794i;

    /* renamed from: j  reason: collision with root package name */
    public j.a.a.e.c.a.a f60795j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (Settings.System.getInt(this.a.f60789d.getContentResolver(), "navigationbar_is_min", 0) == 1) {
                    this.a.f60794i.t.setVisibility(8);
                    this.a.f60792g.setPadding(0, this.a.f60792g.getPaddingTop(), 0, 0);
                    return;
                }
                this.a.f60794i.t.setVisibility(0);
                if (!this.a.f60794i.B) {
                    if (this.a.f60795j.l()) {
                        this.a.f60792g.setPadding(0, this.a.f60792g.getPaddingTop(), 0, this.a.f60795j.d());
                        return;
                    } else {
                        this.a.f60792g.setPadding(0, this.a.f60792g.getPaddingTop(), this.a.f60795j.f(), 0);
                        return;
                    }
                }
                this.a.f60792g.setPadding(0, this.a.f60792g.getPaddingTop(), 0, 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1683094326, "Lj/a/a/e/c/a/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1683094326, "Lj/a/a/e/c/a/d$b;");
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1669755144, "Lj/a/a/e/c/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1669755144, "Lj/a/a/e/c/a/d;");
        }
    }

    public d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.f60787b = new HashMap();
        this.f60788c = new HashMap();
        Activity activity2 = (Activity) new WeakReference(activity).get();
        this.f60789d = activity2;
        this.f60790e = activity2.getWindow();
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

    public d A(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.f60794i.f60778e = i2;
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
            j.a.a.e.c.a.b bVar = this.f60794i;
            bVar.l = z;
            if (!z) {
                bVar.v = 0;
            }
            if (o()) {
                this.f60794i.f60780g = 0.0f;
            } else {
                this.f60794i.f60780g = f2;
            }
            return this;
        }
        return (d) invokeCommon.objValue;
    }

    public final void D() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 21 || f.i() || (viewGroup = this.f60792g) == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f60792g.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                this.f60794i.B = childAt.getFitsSystemWindows();
                if (this.f60794i.B) {
                    this.f60792g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
        }
        j.a.a.e.c.a.b bVar = this.f60794i;
        if (bVar.w) {
            this.f60792g.setPadding(0, this.f60795j.i() + this.f60795j.a(), 0, 0);
        } else if (bVar.r) {
            this.f60792g.setPadding(0, this.f60795j.i(), 0, 0);
        } else {
            this.f60792g.setPadding(0, 0, 0, 0);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f60794i.p.size() == 0) {
            return;
        }
        for (Map.Entry<View, Map<Integer, Integer>> entry : this.f60794i.p.entrySet()) {
            View key = entry.getKey();
            Integer valueOf = Integer.valueOf(this.f60794i.f60778e);
            Integer valueOf2 = Integer.valueOf(this.f60794i.n);
            for (Map.Entry<Integer, Integer> entry2 : entry.getValue().entrySet()) {
                Integer key2 = entry2.getKey();
                valueOf2 = entry2.getValue();
                valueOf = key2;
            }
            if (key != null) {
                if (Math.abs(this.f60794i.q - 0.0f) == 0.0f) {
                    key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f60794i.f60780g));
                } else {
                    key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f60794i.q));
                }
            }
        }
    }

    public d F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.f60794i.f60778e = 0;
            return this;
        }
        return (d) invokeV.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if ((f.i() || f.h()) && this.f60795j.k()) {
                j.a.a.e.c.a.b bVar = this.f60794i;
                if (!bVar.z || !bVar.A || bVar.E == null || bVar.t == null) {
                    return;
                }
                this.f60789d.getContentResolver().unregisterContentObserver(this.f60794i.E);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public j.a.a.e.c.a.b clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f60794i : (j.a.a.e.c.a.b) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            G();
            j.a.a.e.c.a.b bVar = this.f60794i;
            e eVar = bVar.C;
            if (eVar != null) {
                eVar.o(bVar.y);
                this.f60794i.C = null;
            }
            if (this.f60791f != null) {
                this.f60791f = null;
            }
            if (this.f60792g != null) {
                this.f60792g = null;
            }
            if (this.f60795j != null) {
                this.f60795j = null;
            }
            if (this.f60790e != null) {
                this.f60790e = null;
            }
            if (this.f60793h != null) {
                this.f60793h = null;
            }
            if (this.f60789d != null) {
                this.f60789d = null;
            }
            if (n(this.m)) {
                return;
            }
            if (this.f60794i != null) {
                this.f60794i = null;
            }
            ArrayList<String> arrayList = this.f60788c.get(this.k);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f60787b.remove(it.next());
                }
                this.f60788c.remove(this.k);
            }
            this.a.remove(this.m);
        }
    }

    public d g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.f60794i.r = z;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public final int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int i3 = b.a[this.f60794i.k.ordinal()];
                if (i3 == 1) {
                    i2 |= 518;
                } else if (i3 == 2) {
                    i2 |= ARPMessageType.MSG_TYPE_VIDEO_STOP_RES;
                } else if (i3 == 3) {
                    i2 |= 514;
                } else if (i3 == 4) {
                    i2 |= 0;
                }
            }
            return i2 | 4096;
        }
        return invokeI.intValue;
    }

    public d i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.a.put(this.m, this.f60794i);
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
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                int i3 = 256;
                if (i2 >= 21 && !f.i()) {
                    i3 = u(k(256));
                    D();
                } else {
                    l();
                    y();
                }
                this.f60790e.getDecorView().setSystemUiVisibility(h(i3));
            }
            if (f.m()) {
                s(this.f60790e, this.f60794i.l);
            } else if (f.k()) {
                j.a.a.e.c.a.b bVar = this.f60794i;
                int i4 = bVar.v;
                if (i4 != 0) {
                    c.d(this.f60789d, i4);
                } else if (Build.VERSION.SDK_INT < 23) {
                    c.e(this.f60789d, bVar.l);
                }
            } else if (f.n()) {
                t(this.f60794i.l);
            }
        }
    }

    @RequiresApi(api = 21)
    public final int k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            int i3 = i2 | 1024;
            j.a.a.e.c.a.b bVar = this.f60794i;
            if (bVar.f60782i && bVar.z) {
                i3 |= 512;
            }
            this.f60790e.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            if (this.f60795j.k()) {
                this.f60790e.clearFlags(134217728);
            }
            this.f60790e.addFlags(Integer.MIN_VALUE);
            j.a.a.e.c.a.b bVar2 = this.f60794i;
            if (bVar2.m) {
                this.f60790e.setStatusBarColor(ColorUtils.blendARGB(bVar2.f60778e, bVar2.n, bVar2.f60780g));
            } else {
                this.f60790e.setStatusBarColor(ColorUtils.blendARGB(bVar2.f60778e, 0, bVar2.f60780g));
            }
            j.a.a.e.c.a.b bVar3 = this.f60794i;
            if (bVar3.z) {
                this.f60790e.setNavigationBarColor(ColorUtils.blendARGB(bVar3.f60779f, bVar3.o, bVar3.f60781h));
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f60790e.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            x();
            if (this.f60795j.k()) {
                j.a.a.e.c.a.b bVar = this.f60794i;
                if (bVar.z && bVar.A) {
                    this.f60790e.addFlags(134217728);
                } else {
                    this.f60790e.clearFlags(134217728);
                }
                w();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ViewGroup viewGroup = (ViewGroup) this.f60790e.getDecorView();
            this.f60791f = viewGroup;
            this.f60792g = (ViewGroup) viewGroup.findViewById(16908290);
            this.f60795j = new j.a.a.e.c.a.a(this.f60789d);
            if (this.a.get(this.m) == null) {
                this.f60794i = new j.a.a.e.c.a.b();
                if (!n(this.l)) {
                    if (this.a.get(this.k) != null) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            this.f60794i.s = this.a.get(this.k).s;
                            this.f60794i.t = this.a.get(this.k).t;
                        }
                        this.f60794i.C = this.a.get(this.k).C;
                    } else {
                        throw new IllegalArgumentException("在Fragment里使用时，请先在加载Fragment的Activity里初始化！！！");
                    }
                }
                this.a.put(this.m, this.f60794i);
                return;
            }
            this.f60794i = this.a.get(this.m);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        j.a.a.e.c.a.b bVar = this.f60794i;
        if (bVar.C == null) {
            bVar.C = e.q(this.f60789d, this.f60790e);
        }
        j.a.a.e.c.a.b bVar2 = this.f60794i;
        bVar2.C.r(bVar2);
        j.a.a.e.c.a.b bVar3 = this.f60794i;
        if (bVar3.x) {
            bVar3.C.p(bVar3.y);
        } else {
            bVar3.C.o(bVar3.y);
        }
    }

    public d q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.f60794i.z = z;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if ((f.i() || f.h()) && this.f60795j.k()) {
                j.a.a.e.c.a.b bVar = this.f60794i;
                if (bVar.z && bVar.A) {
                    if (bVar.E == null && bVar.t != null) {
                        bVar.E = new a(this, new Handler());
                    }
                    this.f60789d.getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, this.f60794i.E);
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
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            if (z) {
                method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
            } else {
                method.invoke(window, 0, Integer.valueOf(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f60790e.addFlags(Integer.MIN_VALUE);
            }
            int systemUiVisibility = this.f60790e.getDecorView().getSystemUiVisibility();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                systemUiVisibility = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
            } else if (i2 >= 19) {
                systemUiVisibility = z ? systemUiVisibility | 16 : systemUiVisibility & (-17);
            }
            this.f60790e.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    public final int u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? (Build.VERSION.SDK_INT < 23 || !this.f60794i.l) ? i2 : i2 | 8192 : invokeI.intValue;
    }

    public final void v() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || Build.VERSION.SDK_INT < 19 || (view = this.f60794i.u) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = this.f60795j.i();
        this.f60794i.u.setLayoutParams(layoutParams);
    }

    public final void w() {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            j.a.a.e.c.a.b bVar = this.f60794i;
            if (bVar.t == null) {
                bVar.t = new View(this.f60789d);
            }
            if (this.f60795j.l()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.f60795j.d());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.f60795j.f(), -1);
                layoutParams.gravity = 8388613;
            }
            this.f60794i.t.setLayoutParams(layoutParams);
            j.a.a.e.c.a.b bVar2 = this.f60794i;
            if (bVar2.z && bVar2.A) {
                if (!bVar2.f60782i && bVar2.o == 0) {
                    bVar2.t.setBackgroundColor(ColorUtils.blendARGB(bVar2.f60779f, -16777216, bVar2.f60781h));
                } else {
                    j.a.a.e.c.a.b bVar3 = this.f60794i;
                    bVar3.t.setBackgroundColor(ColorUtils.blendARGB(bVar3.f60779f, bVar3.o, bVar3.f60781h));
                }
            } else {
                this.f60794i.t.setBackgroundColor(0);
            }
            this.f60794i.t.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.f60794i.t.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f60794i.t);
            }
            this.f60791f.addView(this.f60794i.t);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            j.a.a.e.c.a.b bVar = this.f60794i;
            if (bVar.s == null) {
                bVar.s = new View(this.f60789d);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f60795j.i());
            layoutParams.gravity = 48;
            this.f60794i.s.setLayoutParams(layoutParams);
            j.a.a.e.c.a.b bVar2 = this.f60794i;
            if (bVar2.m) {
                bVar2.s.setBackgroundColor(ColorUtils.blendARGB(bVar2.f60778e, bVar2.n, bVar2.f60780g));
            } else {
                bVar2.s.setBackgroundColor(ColorUtils.blendARGB(bVar2.f60778e, 0, bVar2.f60780g));
            }
            this.f60794i.s.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.f60794i.s.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f60794i.s);
            }
            this.f60791f.addView(this.f60794i.s);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int childCount = this.f60792g.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f60792g.getChildAt(i2);
                if (childAt instanceof ViewGroup) {
                    if (childAt instanceof DrawerLayout) {
                        View childAt2 = ((DrawerLayout) childAt).getChildAt(0);
                        if (childAt2 != null) {
                            this.f60794i.B = childAt2.getFitsSystemWindows();
                            if (this.f60794i.B) {
                                this.f60792g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        this.f60794i.B = childAt.getFitsSystemWindows();
                        if (this.f60794i.B) {
                            this.f60792g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    }
                }
            }
            if (this.f60795j.k()) {
                j.a.a.e.c.a.b bVar = this.f60794i;
                if (!bVar.f60783j && !bVar.f60782i) {
                    if (this.f60795j.l()) {
                        j.a.a.e.c.a.b bVar2 = this.f60794i;
                        if (!bVar2.w) {
                            if (bVar2.z && bVar2.A) {
                                if (bVar2.r) {
                                    this.f60792g.setPadding(0, this.f60795j.i(), 0, this.f60795j.d());
                                    return;
                                } else {
                                    this.f60792g.setPadding(0, 0, 0, this.f60795j.d());
                                    return;
                                }
                            } else if (this.f60794i.r) {
                                this.f60792g.setPadding(0, this.f60795j.i(), 0, 0);
                                return;
                            } else {
                                this.f60792g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else if (bVar2.z && bVar2.A) {
                            this.f60792g.setPadding(0, this.f60795j.i() + this.f60795j.a() + 10, 0, this.f60795j.d());
                            return;
                        } else {
                            this.f60792g.setPadding(0, this.f60795j.i() + this.f60795j.a() + 10, 0, 0);
                            return;
                        }
                    }
                    j.a.a.e.c.a.b bVar3 = this.f60794i;
                    if (!bVar3.w) {
                        if (bVar3.z && bVar3.A) {
                            if (bVar3.r) {
                                this.f60792g.setPadding(0, this.f60795j.i(), this.f60795j.f(), 0);
                                return;
                            } else {
                                this.f60792g.setPadding(0, 0, this.f60795j.f(), 0);
                                return;
                            }
                        } else if (this.f60794i.r) {
                            this.f60792g.setPadding(0, this.f60795j.i(), 0, 0);
                            return;
                        } else {
                            this.f60792g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    } else if (bVar3.z && bVar3.A) {
                        this.f60792g.setPadding(0, this.f60795j.i() + this.f60795j.a() + 10, this.f60795j.f(), 0);
                        return;
                    } else {
                        this.f60792g.setPadding(0, this.f60795j.i() + this.f60795j.a() + 10, 0, 0);
                        return;
                    }
                }
            }
            j.a.a.e.c.a.b bVar4 = this.f60794i;
            if (!bVar4.w) {
                if (bVar4.r) {
                    this.f60792g.setPadding(0, this.f60795j.i(), 0, 0);
                    return;
                } else {
                    this.f60792g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
            this.f60792g.setPadding(0, this.f60795j.i() + this.f60795j.a() + 10, 0, 0);
        }
    }

    public d z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            A(ContextCompat.getColor(this.f60789d, i2));
            return this;
        }
        return (d) invokeI.objValue;
    }
}
