package d.a.q0.a.y0.i;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.k;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import d.a.q0.a.y0.d;
/* loaded from: classes8.dex */
public final class c implements d.a.q0.a.y0.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f51773g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f51774h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f51775a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f51776b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.a.h0.g.f f51777c;

    /* renamed from: d  reason: collision with root package name */
    public int f51778d;

    /* renamed from: e  reason: collision with root package name */
    public ShowConfirmBarLayout f51779e;

    /* renamed from: f  reason: collision with root package name */
    public f f51780f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f51781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f51782f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f51783g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f51784h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f51785i;

        public a(c cVar, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51785i = cVar;
            this.f51781e = i2;
            this.f51782f = i3;
            this.f51783g = i4;
            this.f51784h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51785i.C0(this.f51781e, this.f51782f, this.f51783g, this.f51784h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f51786e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51786e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51786e.B0();
            }
        }
    }

    /* renamed from: d.a.q0.a.y0.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1035c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f51787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f51788f;

        public RunnableC1035c(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51788f = cVar;
            this.f51787e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51788f.E0(this.f51787e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ShowConfirmBarLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f51789a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51789a = cVar;
        }

        @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51789a.A0("onConfirmBtnClick", null);
                if (this.f51789a.f51780f != null) {
                    this.f51789a.f51780f.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f51790e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51790e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51790e.v0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1386829763, "Ld/a/q0/a/y0/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1386829763, "Ld/a/q0/a/y0/i/c;");
                return;
            }
        }
        f51773g = k.f49133a;
        f51774h = n0.g(38.0f);
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (invoker != null) {
            this.f51776b = (String) invoker.get("id");
        }
        this.f51775a = str;
        this.f51777c = t0();
    }

    @Override // d.a.q0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (d.a.q0.a.a2.e.i() == null) {
                aVar.a(false);
            } else {
                aVar.a(true);
            }
        }
    }

    public final void A0(String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && f51773g) {
            String str3 = (" <<" + j0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }

    public final void B0() {
        d.a.q0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (fVar = this.f51777c) == null || this.f51778d == 0) {
            return;
        }
        this.f51778d = 0;
        if (fVar.k3().getScrollY() > 0) {
            this.f51777c.k3().setScrollY(0);
        }
    }

    public final void C0(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || this.f51777c == null) {
            return;
        }
        d.a.q0.a.p.e.c h2 = d.a.q0.a.g1.f.V().h();
        if (this.f51778d == i4 || h2 == null) {
            return;
        }
        this.f51778d = i4;
        int i6 = this.f51779e == null ? 0 : f51774h;
        int height = ((this.f51777c.k3().getHeight() - i2) - i3) + h2.getWebViewScrollY();
        if (height - i5 < i4) {
            if (i5 > height) {
                this.f51777c.k3().setScrollY(i4 + i6);
            } else {
                this.f51777c.k3().setScrollY((i4 - height) + i5 + i6);
            }
        }
    }

    public void D0(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f51780f = fVar;
        }
    }

    public final void E0(int i2) {
        Activity u0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (u0 = u0()) == null) {
            return;
        }
        View decorView = u0.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.f51779e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(u0);
            this.f51779e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d(this));
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i2) - f51774h;
            frameLayout.addView(this.f51779e, layoutParams);
        }
    }

    @Override // d.a.q0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f51775a : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.y0.d
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f51776b : (String) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Nullable
    public final d.a.q0.a.h0.g.f t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            g W = d.a.q0.a.g1.f.V().W();
            if (W == null) {
                return null;
            }
            int k = W.k();
            for (int i2 = 0; i2 < k; i2++) {
                d.a.q0.a.h0.g.d j = W.j(i2);
                if (j instanceof d.a.q0.a.h0.g.f) {
                    d.a.q0.a.h0.g.f fVar = (d.a.q0.a.h0.g.f) j;
                    if (TextUtils.equals(fVar.g3(), this.f51775a)) {
                        return fVar;
                    }
                }
            }
            return null;
        }
        return (d.a.q0.a.h0.g.f) invokeV.objValue;
    }

    @Nullable
    public final Activity u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
            if (i2 == null) {
                return null;
            }
            return i2.k();
        }
        return (Activity) invokeV.objValue;
    }

    public final void v0() {
        Activity u0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (u0 = u0()) == null) {
            return;
        }
        View decorView = u0.getWindow().getDecorView();
        ShowConfirmBarLayout showConfirmBarLayout = this.f51779e;
        if (showConfirmBarLayout == null || showConfirmBarLayout.getVisibility() != 0) {
            return;
        }
        ((FrameLayout) decorView.findViewById(16908290)).removeView(this.f51779e);
        this.f51779e = null;
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            q0.X(new e(this));
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            q0.X(new b(this));
        }
    }

    public void y0(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i2, i3, i4, i5) == null) {
            q0.X(new a(this, i2, i3, i4, i5));
        }
    }

    public void z0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            q0.X(new RunnableC1035c(this, i2));
        }
    }
}
