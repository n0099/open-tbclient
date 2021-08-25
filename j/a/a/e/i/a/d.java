package j.a.a.e.i.a;

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
import com.baidu.mapapi.UIMsg;
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
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, j.a.a.e.i.a.b> f78831a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, j.a.a.e.i.a.b> f78832b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ArrayList<String>> f78833c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f78834d;

    /* renamed from: e  reason: collision with root package name */
    public Window f78835e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f78836f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f78837g;

    /* renamed from: h  reason: collision with root package name */
    public Dialog f78838h;

    /* renamed from: i  reason: collision with root package name */
    public j.a.a.e.i.a.b f78839i;

    /* renamed from: j  reason: collision with root package name */
    public j.a.a.e.i.a.a f78840j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes2.dex */
    public class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f78841a;

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
            this.f78841a = dVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (Settings.System.getInt(this.f78841a.f78834d.getContentResolver(), "navigationbar_is_min", 0) == 1) {
                    this.f78841a.f78839i.t.setVisibility(8);
                    this.f78841a.f78837g.setPadding(0, this.f78841a.f78837g.getPaddingTop(), 0, 0);
                    return;
                }
                this.f78841a.f78839i.t.setVisibility(0);
                if (!this.f78841a.f78839i.B) {
                    if (this.f78841a.f78840j.l()) {
                        this.f78841a.f78837g.setPadding(0, this.f78841a.f78837g.getPaddingTop(), 0, this.f78841a.f78840j.d());
                        return;
                    } else {
                        this.f78841a.f78837g.setPadding(0, this.f78841a.f78837g.getPaddingTop(), this.f78841a.f78840j.f(), 0);
                        return;
                    }
                }
                this.f78841a.f78837g.setPadding(0, this.f78841a.f78837g.getPaddingTop(), 0, 0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f78842a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(183833092, "Lj/a/a/e/i/a/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(183833092, "Lj/a/a/e/i/a/d$b;");
                    return;
                }
            }
            int[] iArr = new int[BarHide.values().length];
            f78842a = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f78842a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f78842a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f78842a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1841530050, "Lj/a/a/e/i/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1841530050, "Lj/a/a/e/i/a/d;");
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
        this.f78831a = new HashMap();
        this.f78832b = new HashMap();
        this.f78833c = new HashMap();
        Activity activity2 = (Activity) new WeakReference(activity).get();
        this.f78834d = activity2;
        this.f78835e = activity2.getWindow();
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
            this.f78839i.f78821e = i2;
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
            j.a.a.e.i.a.b bVar = this.f78839i;
            bVar.l = z;
            if (!z) {
                bVar.v = 0;
            }
            if (o()) {
                this.f78839i.f78823g = 0.0f;
            } else {
                this.f78839i.f78823g = f2;
            }
            return this;
        }
        return (d) invokeCommon.objValue;
    }

    public final void D() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 21 || f.i() || (viewGroup = this.f78837g) == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f78837g.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                this.f78839i.B = childAt.getFitsSystemWindows();
                if (this.f78839i.B) {
                    this.f78837g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
        }
        j.a.a.e.i.a.b bVar = this.f78839i;
        if (bVar.w) {
            this.f78837g.setPadding(0, this.f78840j.i() + this.f78840j.a(), 0, 0);
        } else if (bVar.r) {
            this.f78837g.setPadding(0, this.f78840j.i(), 0, 0);
        } else {
            this.f78837g.setPadding(0, 0, 0, 0);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f78839i.p.size() == 0) {
            return;
        }
        for (Map.Entry<View, Map<Integer, Integer>> entry : this.f78839i.p.entrySet()) {
            View key = entry.getKey();
            Integer valueOf = Integer.valueOf(this.f78839i.f78821e);
            Integer valueOf2 = Integer.valueOf(this.f78839i.n);
            for (Map.Entry<Integer, Integer> entry2 : entry.getValue().entrySet()) {
                Integer key2 = entry2.getKey();
                valueOf2 = entry2.getValue();
                valueOf = key2;
            }
            if (key != null) {
                if (Math.abs(this.f78839i.q - 0.0f) == 0.0f) {
                    key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f78839i.f78823g));
                } else {
                    key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f78839i.q));
                }
            }
        }
    }

    public d F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.f78839i.f78821e = 0;
            return this;
        }
        return (d) invokeV.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if ((f.i() || f.h()) && this.f78840j.k()) {
                j.a.a.e.i.a.b bVar = this.f78839i;
                if (!bVar.z || !bVar.A || bVar.E == null || bVar.t == null) {
                    return;
                }
                this.f78834d.getContentResolver().unregisterContentObserver(this.f78839i.E);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public j.a.a.e.i.a.b clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f78839i : (j.a.a.e.i.a.b) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            G();
            j.a.a.e.i.a.b bVar = this.f78839i;
            e eVar = bVar.C;
            if (eVar != null) {
                eVar.o(bVar.y);
                this.f78839i.C = null;
            }
            if (this.f78836f != null) {
                this.f78836f = null;
            }
            if (this.f78837g != null) {
                this.f78837g = null;
            }
            if (this.f78840j != null) {
                this.f78840j = null;
            }
            if (this.f78835e != null) {
                this.f78835e = null;
            }
            if (this.f78838h != null) {
                this.f78838h = null;
            }
            if (this.f78834d != null) {
                this.f78834d = null;
            }
            if (n(this.m)) {
                return;
            }
            if (this.f78839i != null) {
                this.f78839i = null;
            }
            ArrayList<String> arrayList = this.f78833c.get(this.k);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f78832b.remove(it.next());
                }
                this.f78833c.remove(this.k);
            }
            this.f78831a.remove(this.m);
        }
    }

    public d g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.f78839i.r = z;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public final int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int i3 = b.f78842a[this.f78839i.k.ordinal()];
                if (i3 == 1) {
                    i2 |= UIMsg.m_AppUI.MSG_COMPASS_DISPLAY;
                } else if (i3 == 2) {
                    i2 |= 1028;
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
            this.f78831a.put(this.m, this.f78839i);
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
                this.f78835e.getDecorView().setSystemUiVisibility(h(i3));
            }
            if (f.m()) {
                s(this.f78835e, this.f78839i.l);
            } else if (f.k()) {
                j.a.a.e.i.a.b bVar = this.f78839i;
                int i4 = bVar.v;
                if (i4 != 0) {
                    c.d(this.f78834d, i4);
                } else if (Build.VERSION.SDK_INT < 23) {
                    c.e(this.f78834d, bVar.l);
                }
            } else if (f.n()) {
                t(this.f78839i.l);
            }
        }
    }

    @RequiresApi(api = 21)
    public final int k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            int i3 = i2 | 1024;
            j.a.a.e.i.a.b bVar = this.f78839i;
            if (bVar.f78825i && bVar.z) {
                i3 |= 512;
            }
            this.f78835e.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            if (this.f78840j.k()) {
                this.f78835e.clearFlags(134217728);
            }
            this.f78835e.addFlags(Integer.MIN_VALUE);
            j.a.a.e.i.a.b bVar2 = this.f78839i;
            if (bVar2.m) {
                this.f78835e.setStatusBarColor(ColorUtils.blendARGB(bVar2.f78821e, bVar2.n, bVar2.f78823g));
            } else {
                this.f78835e.setStatusBarColor(ColorUtils.blendARGB(bVar2.f78821e, 0, bVar2.f78823g));
            }
            j.a.a.e.i.a.b bVar3 = this.f78839i;
            if (bVar3.z) {
                this.f78835e.setNavigationBarColor(ColorUtils.blendARGB(bVar3.f78822f, bVar3.o, bVar3.f78824h));
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f78835e.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            x();
            if (this.f78840j.k()) {
                j.a.a.e.i.a.b bVar = this.f78839i;
                if (bVar.z && bVar.A) {
                    this.f78835e.addFlags(134217728);
                } else {
                    this.f78835e.clearFlags(134217728);
                }
                w();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ViewGroup viewGroup = (ViewGroup) this.f78835e.getDecorView();
            this.f78836f = viewGroup;
            this.f78837g = (ViewGroup) viewGroup.findViewById(16908290);
            this.f78840j = new j.a.a.e.i.a.a(this.f78834d);
            if (this.f78831a.get(this.m) == null) {
                this.f78839i = new j.a.a.e.i.a.b();
                if (!n(this.l)) {
                    if (this.f78831a.get(this.k) != null) {
                        if (Build.VERSION.SDK_INT == 19 || f.i()) {
                            this.f78839i.s = this.f78831a.get(this.k).s;
                            this.f78839i.t = this.f78831a.get(this.k).t;
                        }
                        this.f78839i.C = this.f78831a.get(this.k).C;
                    } else {
                        throw new IllegalArgumentException("在Fragment里使用时，请先在加载Fragment的Activity里初始化！！！");
                    }
                }
                this.f78831a.put(this.m, this.f78839i);
                return;
            }
            this.f78839i = this.f78831a.get(this.m);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        j.a.a.e.i.a.b bVar = this.f78839i;
        if (bVar.C == null) {
            bVar.C = e.q(this.f78834d, this.f78835e);
        }
        j.a.a.e.i.a.b bVar2 = this.f78839i;
        bVar2.C.r(bVar2);
        j.a.a.e.i.a.b bVar3 = this.f78839i;
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
            this.f78839i.z = z;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if ((f.i() || f.h()) && this.f78840j.k()) {
                j.a.a.e.i.a.b bVar = this.f78839i;
                if (bVar.z && bVar.A) {
                    if (bVar.E == null && bVar.t != null) {
                        bVar.E = new a(this, new Handler());
                    }
                    this.f78834d.getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, this.f78839i.E);
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
                this.f78835e.addFlags(Integer.MIN_VALUE);
            }
            int systemUiVisibility = this.f78835e.getDecorView().getSystemUiVisibility();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                systemUiVisibility = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
            } else if (i2 >= 19) {
                systemUiVisibility = z ? systemUiVisibility | 16 : systemUiVisibility & (-17);
            }
            this.f78835e.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    public final int u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? (Build.VERSION.SDK_INT < 23 || !this.f78839i.l) ? i2 : i2 | 8192 : invokeI.intValue;
    }

    public final void v() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || Build.VERSION.SDK_INT < 19 || (view = this.f78839i.u) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = this.f78840j.i();
        this.f78839i.u.setLayoutParams(layoutParams);
    }

    public final void w() {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            j.a.a.e.i.a.b bVar = this.f78839i;
            if (bVar.t == null) {
                bVar.t = new View(this.f78834d);
            }
            if (this.f78840j.l()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.f78840j.d());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.f78840j.f(), -1);
                layoutParams.gravity = 8388613;
            }
            this.f78839i.t.setLayoutParams(layoutParams);
            j.a.a.e.i.a.b bVar2 = this.f78839i;
            if (bVar2.z && bVar2.A) {
                if (!bVar2.f78825i && bVar2.o == 0) {
                    bVar2.t.setBackgroundColor(ColorUtils.blendARGB(bVar2.f78822f, -16777216, bVar2.f78824h));
                } else {
                    j.a.a.e.i.a.b bVar3 = this.f78839i;
                    bVar3.t.setBackgroundColor(ColorUtils.blendARGB(bVar3.f78822f, bVar3.o, bVar3.f78824h));
                }
            } else {
                this.f78839i.t.setBackgroundColor(0);
            }
            this.f78839i.t.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.f78839i.t.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f78839i.t);
            }
            this.f78836f.addView(this.f78839i.t);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            j.a.a.e.i.a.b bVar = this.f78839i;
            if (bVar.s == null) {
                bVar.s = new View(this.f78834d);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f78840j.i());
            layoutParams.gravity = 48;
            this.f78839i.s.setLayoutParams(layoutParams);
            j.a.a.e.i.a.b bVar2 = this.f78839i;
            if (bVar2.m) {
                bVar2.s.setBackgroundColor(ColorUtils.blendARGB(bVar2.f78821e, bVar2.n, bVar2.f78823g));
            } else {
                bVar2.s.setBackgroundColor(ColorUtils.blendARGB(bVar2.f78821e, 0, bVar2.f78823g));
            }
            this.f78839i.s.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.f78839i.s.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f78839i.s);
            }
            this.f78836f.addView(this.f78839i.s);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int childCount = this.f78837g.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f78837g.getChildAt(i2);
                if (childAt instanceof ViewGroup) {
                    if (childAt instanceof DrawerLayout) {
                        View childAt2 = ((DrawerLayout) childAt).getChildAt(0);
                        if (childAt2 != null) {
                            this.f78839i.B = childAt2.getFitsSystemWindows();
                            if (this.f78839i.B) {
                                this.f78837g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        this.f78839i.B = childAt.getFitsSystemWindows();
                        if (this.f78839i.B) {
                            this.f78837g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    }
                }
            }
            if (this.f78840j.k()) {
                j.a.a.e.i.a.b bVar = this.f78839i;
                if (!bVar.f78826j && !bVar.f78825i) {
                    if (this.f78840j.l()) {
                        j.a.a.e.i.a.b bVar2 = this.f78839i;
                        if (!bVar2.w) {
                            if (bVar2.z && bVar2.A) {
                                if (bVar2.r) {
                                    this.f78837g.setPadding(0, this.f78840j.i(), 0, this.f78840j.d());
                                    return;
                                } else {
                                    this.f78837g.setPadding(0, 0, 0, this.f78840j.d());
                                    return;
                                }
                            } else if (this.f78839i.r) {
                                this.f78837g.setPadding(0, this.f78840j.i(), 0, 0);
                                return;
                            } else {
                                this.f78837g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else if (bVar2.z && bVar2.A) {
                            this.f78837g.setPadding(0, this.f78840j.i() + this.f78840j.a() + 10, 0, this.f78840j.d());
                            return;
                        } else {
                            this.f78837g.setPadding(0, this.f78840j.i() + this.f78840j.a() + 10, 0, 0);
                            return;
                        }
                    }
                    j.a.a.e.i.a.b bVar3 = this.f78839i;
                    if (!bVar3.w) {
                        if (bVar3.z && bVar3.A) {
                            if (bVar3.r) {
                                this.f78837g.setPadding(0, this.f78840j.i(), this.f78840j.f(), 0);
                                return;
                            } else {
                                this.f78837g.setPadding(0, 0, this.f78840j.f(), 0);
                                return;
                            }
                        } else if (this.f78839i.r) {
                            this.f78837g.setPadding(0, this.f78840j.i(), 0, 0);
                            return;
                        } else {
                            this.f78837g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    } else if (bVar3.z && bVar3.A) {
                        this.f78837g.setPadding(0, this.f78840j.i() + this.f78840j.a() + 10, this.f78840j.f(), 0);
                        return;
                    } else {
                        this.f78837g.setPadding(0, this.f78840j.i() + this.f78840j.a() + 10, 0, 0);
                        return;
                    }
                }
            }
            j.a.a.e.i.a.b bVar4 = this.f78839i;
            if (!bVar4.w) {
                if (bVar4.r) {
                    this.f78837g.setPadding(0, this.f78840j.i(), 0, 0);
                    return;
                } else {
                    this.f78837g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
            this.f78837g.setPadding(0, this.f78840j.i() + this.f78840j.a() + 10, 0, 0);
        }
    }

    public d z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            A(ContextCompat.getColor(this.f78834d, i2));
            return this;
        }
        return (d) invokeI.objValue;
    }
}
