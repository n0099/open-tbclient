package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.webview.container.BaseNativeBrowserContainer;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.s21;
import com.repackage.w11;
import com.repackage.x21;
import com.repackage.y21;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public BaseNativeBrowserContainer a;
    public WebView b;
    public x21 c;
    public t21 d;
    public final r21 e;
    public a21 f;
    public boolean g;
    public ViewTreeObserver.OnGlobalLayoutListener h;
    public View.OnLayoutChangeListener i;
    public boolean j;
    public final Object k;
    public long l;
    public int m;
    public final a31 n;

    /* loaded from: classes7.dex */
    public class a implements a31 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z21 a;

        public a(z21 z21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z21Var;
        }

        @Override // com.repackage.a31
        public void loadUrl(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) || this.a.b == null) {
                return;
            }
            this.a.b.loadUrl(str, map);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements w11.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z21 a;

        public b(z21 z21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z21Var;
        }

        @Override // com.repackage.w11.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.a.l(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements s21.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ z21 b;

        public c(z21 z21Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z21Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z21Var;
            this.a = webView;
        }

        @Override // com.repackage.s21.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int i = this.b.a.getResources().getDisplayMetrics().heightPixels - rect.bottom;
                if (i < 0) {
                    i = 0;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visibleHeight", this.a.getHeight() - i);
                    jSONObject.put("keyboardHeight", i);
                    jSONObject.put("webviewHeight", this.a.getHeight());
                    jSONObject.put("videoHeight", 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements y21.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ z21 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.b.b.canGoBack()) {
                        this.a.b.b.goBack();
                    } else {
                        this.a.a.finish();
                    }
                }
            }
        }

        public d(z21 z21Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z21Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z21Var;
            this.a = activity;
        }

        @Override // com.repackage.y21.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.post(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ z21 b;

        public e(z21 z21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z21Var;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                Rect rect = new Rect();
                view2.getWindowVisibleDisplayFrame(rect);
                int i9 = rect.bottom;
                int i10 = this.a;
                if (i9 != i10 && i10 != 0) {
                    LinearLayout N = this.b.a.N();
                    int i11 = this.a - rect.bottom;
                    if (i11 > 200) {
                        this.b.j = true;
                        if (i3 == i7) {
                            N.setPadding(N.getPaddingLeft(), N.getPaddingTop(), N.getPaddingRight(), i11);
                            f21.b(this.b.n, N.getHeight() - i11, i11, N.getHeight(), 0);
                            z21 z21Var = this.b;
                            z21Var.F(z21Var.b, -1, -1);
                        }
                    } else {
                        if (i3 == i7 && this.b.j) {
                            N.setPadding(N.getPaddingLeft(), N.getPaddingTop(), N.getPaddingRight(), 0);
                            f21.b(this.b.n, N.getHeight(), 0, N.getHeight(), 0);
                            z21 z21Var2 = this.b;
                            z21Var2.F(z21Var2.b, -1, -1);
                        }
                        this.b.j = false;
                    }
                    this.a = rect.bottom;
                    return;
                }
                this.a = rect.bottom;
            }
        }
    }

    public z21(@NonNull BaseNativeBrowserContainer baseNativeBrowserContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseNativeBrowserContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new r21();
        this.g = true;
        this.h = null;
        this.k = new Object();
        this.l = 0L;
        this.n = new a(this);
        this.a = baseNativeBrowserContainer;
    }

    public void A(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i, str, str2) == null) {
            if (!NetUtil.a(this.a.N().getContext())) {
                this.m = -1000;
            } else {
                this.m = i;
            }
        }
    }

    public void B(String str) {
        x21 x21Var;
        x21.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (x21Var = this.c) == null || (cVar = x21Var.b) == null || TextUtils.isEmpty(cVar.a)) {
            return;
        }
        this.a.l(this.c.b.a);
    }

    public void C() {
        t21 t21Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (t21Var = this.d) == null) {
            return;
        }
        t21Var.e();
    }

    public void D() {
        t21 t21Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (t21Var = this.d) == null) {
            return;
        }
        t21Var.f();
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void F(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, view2, i, i2) == null) {
            if (view2.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                view2.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                view2.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                view2.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                view2.setLayoutParams(new ViewGroup.MarginLayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof ViewGroup.LayoutParams) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            }
        }
    }

    public boolean G(@NonNull WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webView, str, str2)) == null) {
            H(webView, str2);
            x21 x21Var = this.c;
            if (x21Var == null || !x21Var.a()) {
                return true;
            }
            return !ch0.a(webView.getContext(), str2);
        }
        return invokeLLL.booleanValue;
    }

    public final void H(@NonNull WebView webView, String str) {
        x21 x21Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) || TextUtils.isEmpty(str) || !str.startsWith("tel:") || webView.getContext() == null || (x21Var = this.c) == null || TextUtils.isEmpty(x21Var.f)) {
            return;
        }
        new j51().m(webView.getContext(), this.c.f, "tel");
    }

    public final void f() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.N() == null || this.h == null || (viewTreeObserver = this.a.N().getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.h);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a.N() == null || this.i == null) {
            return;
        }
        this.a.N().removeOnLayoutChangeListener(this.i);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d = null;
            a21 a21Var = this.f;
            if (a21Var != null) {
                a21Var.d();
                this.f = null;
            }
        }
    }

    public t21 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d : (t21) invokeV.objValue;
    }

    @Nullable
    public final Intent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.h() : (Intent) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            x21 x21Var = this.c;
            if (x21Var == null) {
                return null;
            }
            return x21Var.g;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            x21 x21Var = this.c;
            if (x21Var == null) {
                return null;
            }
            return x21Var.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.d.g();
            if (j() != null) {
                String k = k();
                if (TextUtils.isEmpty(k)) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Referer", k);
                this.a.f0(hashMap);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intent) == null) {
            this.c = x21.b(intent);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f == null) {
                this.f = new a21();
            }
            x21 x21Var = this.c;
            if (x21Var != null) {
                this.f.b(x21Var.i);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.a.L() == null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.a.N().getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setVisibility(8);
        this.a.L().addView(relativeLayout, layoutParams);
        this.a.k0(relativeLayout);
        String str = null;
        if (this.c != null) {
            JSONObject jSONObject = new JSONObject();
            yx0.f(jSONObject, LegoListActivityConfig.AD_ID, this.c.c);
            yx0.f(jSONObject, "lp_url", this.c.a);
            yx0.f(jSONObject, "log_ext", this.c.f);
            yx0.f(jSONObject, Constant.KEY_BUSINESS, "native_ads");
            x21.b bVar = this.c.j;
            if (bVar != null) {
                yx0.f(jSONObject, "key", bVar.e);
                yx0.f(jSONObject, "url", this.c.j.a);
                yx0.f(jSONObject, "close_v_dl", this.c.j.b);
                yx0.f(jSONObject, "app_icon", this.c.j.d);
                yx0.f(jSONObject, "app_name", this.c.j.c);
            }
            str = jSONObject.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.n0(str);
    }

    public void q(@NonNull Activity activity, @NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, activity, webView) == null) {
            s21 s21Var = new s21(0);
            s21Var.a(this.e);
            s21Var.b(new c(this, webView));
            this.a.F(s21Var, "NadJsControl");
            this.a.F(new y21(new d(this, activity)), "go_back_js_interface_name");
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.a.N() == null) {
            return;
        }
        if (this.h == null) {
            this.h = new f31(this.a.N());
        }
        ViewTreeObserver viewTreeObserver = this.a.N().getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.h);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.i = new e(this);
            if (this.a.N() != null) {
                this.a.N().addOnLayoutChangeListener(this.i);
            }
        }
    }

    public final void t() {
        Intent j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (j = j()) == null) {
            return;
        }
        n(j);
        o();
        this.d = new t21();
        h21.b().a(this.k, new b(this));
    }

    public void u(Context context, ViewGroup viewGroup, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, context, viewGroup, webView) == null) {
            this.b = webView;
            p();
            if (h21.h()) {
                f();
                g();
            } else if (this.g) {
                f();
                s();
            } else {
                r();
                g();
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            t();
        }
    }

    public void w() {
        t21 t21Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            x21 x21Var = this.c;
            if (x21Var != null && TextUtils.equals(x21Var.h, "1") && (t21Var = this.d) != null) {
                this.d.b(this.e.a(), t21Var.a(this.c.f, this.l, this.m, false), this.c.a, this.a.J(), 0L);
            }
            t21 t21Var2 = this.d;
            if (t21Var2 != null) {
                t21Var2.c();
            }
            h21.b().release();
            h();
            f();
            g();
            if (this.i != null) {
                this.a.N().removeOnLayoutChangeListener(this.i);
            }
            ek0.a().unregister(this.k);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, str) == null) && this.l == 0) {
            this.l = System.currentTimeMillis();
        }
    }

    public void y(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, webView, str, bitmap) == null) {
        }
    }

    public void z() {
        t21 t21Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (t21Var = this.d) == null) {
            return;
        }
        t21Var.d();
    }
}
