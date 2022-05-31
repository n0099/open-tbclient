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
import com.repackage.a21;
import com.repackage.e11;
import com.repackage.f21;
import com.repackage.g21;
import com.tachikoma.core.component.input.InputType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public BaseNativeBrowserContainer a;
    public WebView b;
    public f21 c;
    public b21 d;
    public final z11 e;
    public i11 f;
    public boolean g;
    public ViewTreeObserver.OnGlobalLayoutListener h;
    public View.OnLayoutChangeListener i;
    public boolean j;
    public final Object k;
    public long l;
    public int m;
    public final i21 n;

    /* loaded from: classes6.dex */
    public class a implements i21 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h21 a;

        public a(h21 h21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h21Var;
        }

        @Override // com.repackage.i21
        public void loadUrl(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) || this.a.b == null) {
                return;
            }
            this.a.b.loadUrl(str, map);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements e11.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h21 a;

        public b(h21 h21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h21Var;
        }

        @Override // com.repackage.e11.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.a.l(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a21.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ h21 b;

        public c(h21 h21Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h21Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h21Var;
            this.a = webView;
        }

        @Override // com.repackage.a21.a
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

    /* loaded from: classes6.dex */
    public class d implements g21.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ h21 b;

        /* loaded from: classes6.dex */
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

        public d(h21 h21Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h21Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h21Var;
            this.a = activity;
        }

        @Override // com.repackage.g21.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ h21 b;

        public e(h21 h21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h21Var;
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
                            n11.b(this.b.n, N.getHeight() - i11, i11, N.getHeight(), 0);
                            h21 h21Var = this.b;
                            h21Var.F(h21Var.b, -1, -1);
                        }
                    } else {
                        if (i3 == i7 && this.b.j) {
                            N.setPadding(N.getPaddingLeft(), N.getPaddingTop(), N.getPaddingRight(), 0);
                            n11.b(this.b.n, N.getHeight(), 0, N.getHeight(), 0);
                            h21 h21Var2 = this.b;
                            h21Var2.F(h21Var2.b, -1, -1);
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

    public h21(@NonNull BaseNativeBrowserContainer baseNativeBrowserContainer) {
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
        this.e = new z11();
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
        f21 f21Var;
        f21.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (f21Var = this.c) == null || (cVar = f21Var.b) == null || TextUtils.isEmpty(cVar.a)) {
            return;
        }
        this.a.l(this.c.b.a);
    }

    public void C() {
        b21 b21Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (b21Var = this.d) == null) {
            return;
        }
        b21Var.e();
    }

    public void D() {
        b21 b21Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b21Var = this.d) == null) {
            return;
        }
        b21Var.f();
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
            f21 f21Var = this.c;
            if (f21Var == null || !f21Var.a()) {
                return true;
            }
            return !sg0.a(webView.getContext(), str2);
        }
        return invokeLLL.booleanValue;
    }

    public final void H(@NonNull WebView webView, String str) {
        f21 f21Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) || TextUtils.isEmpty(str) || !str.startsWith("tel:") || webView.getContext() == null || (f21Var = this.c) == null || TextUtils.isEmpty(f21Var.f)) {
            return;
        }
        new r41().m(webView.getContext(), this.c.f, InputType.TEL);
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
            i11 i11Var = this.f;
            if (i11Var != null) {
                i11Var.d();
                this.f = null;
            }
        }
    }

    public b21 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d : (b21) invokeV.objValue;
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
            f21 f21Var = this.c;
            if (f21Var == null) {
                return null;
            }
            return f21Var.g;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            f21 f21Var = this.c;
            if (f21Var == null) {
                return null;
            }
            return f21Var.a;
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
            this.c = f21.b(intent);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f == null) {
                this.f = new i11();
            }
            f21 f21Var = this.c;
            if (f21Var != null) {
                this.f.b(f21Var.i);
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
            hx0.f(jSONObject, LegoListActivityConfig.AD_ID, this.c.c);
            hx0.f(jSONObject, "lp_url", this.c.a);
            hx0.f(jSONObject, "log_ext", this.c.f);
            hx0.f(jSONObject, Constant.KEY_BUSINESS, "native_ads");
            f21.b bVar = this.c.j;
            if (bVar != null) {
                hx0.f(jSONObject, "key", bVar.e);
                hx0.f(jSONObject, "url", this.c.j.a);
                hx0.f(jSONObject, "close_v_dl", this.c.j.b);
                hx0.f(jSONObject, "app_icon", this.c.j.d);
                hx0.f(jSONObject, "app_name", this.c.j.c);
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
            a21 a21Var = new a21(0);
            a21Var.a(this.e);
            a21Var.b(new c(this, webView));
            this.a.F(a21Var, "NadJsControl");
            this.a.F(new g21(new d(this, activity)), "go_back_js_interface_name");
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.a.N() == null) {
            return;
        }
        if (this.h == null) {
            this.h = new n21(this.a.N());
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
        this.d = new b21();
        p11.b().a(this.k, new b(this));
    }

    public void u(Context context, ViewGroup viewGroup, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, context, viewGroup, webView) == null) {
            this.b = webView;
            p();
            if (p11.h()) {
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
        b21 b21Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            f21 f21Var = this.c;
            if (f21Var != null && TextUtils.equals(f21Var.h, "1") && (b21Var = this.d) != null) {
                this.d.b(this.e.a(), b21Var.a(this.c.f, this.l, this.m, false), this.c.a, this.a.J(), 0L);
            }
            b21 b21Var2 = this.d;
            if (b21Var2 != null) {
                b21Var2.c();
            }
            p11.b().release();
            h();
            f();
            g();
            if (this.i != null) {
                this.a.N().removeOnLayoutChangeListener(this.i);
            }
            nj0.a().unregister(this.k);
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
        b21 b21Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (b21Var = this.d) == null) {
            return;
        }
        b21Var.d();
    }
}
