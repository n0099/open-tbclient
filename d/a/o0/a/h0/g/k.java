package d.a.o0.a.h0.g;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h0.g.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k extends d.a.o0.a.h0.g.d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean I0;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.o0.a.p.e.e C0;
    public d.a.o0.a.p.e.c D0;
    public String E0;
    public String F0;
    public String G0;
    public boolean H0;

    /* loaded from: classes7.dex */
    public class a extends SwanAppWebViewWidget {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k i0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i0 = kVar;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean R1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i0.H0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.o0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f45234c;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45234c = kVar;
        }

        @Override // d.a.o0.a.h0.j.a, d.a.o0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f45234c.K2(str) && this.f45234c.G0 != null) {
                    k kVar = this.f45234c;
                    kVar.n0.setTitle(kVar.G0);
                    return;
                }
                this.f45234c.n0.setTitle(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f45235e;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45235e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f45235e.D0.canGoBack()) {
                    this.f45235e.D0.goBack();
                } else {
                    this.f45235e.c2();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.o0.a.l1.b f45236a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f45237b;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45237b = new JSONObject();
            this.f45236a = d.a.o0.a.l1.b.g(str, str);
        }

        public d a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                try {
                    this.f45237b.put("should_check_domain", z);
                } catch (JSONException e2) {
                    if (k.I0) {
                        e2.printStackTrace();
                    }
                }
                return this;
            }
            return (d) invokeZ.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f45236a.f46494f = this.f45237b.toString();
                k.Q2("default_webview", this.f45236a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447252072, "Ld/a/o0/a/h0/g/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447252072, "Ld/a/o0/a/h0/g/k;");
                return;
            }
        }
        I0 = d.a.o0.a.k.f46335a;
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.H0 = true;
    }

    public static boolean L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            g W = d.a.o0.a.g1.f.V().W();
            if (W == null) {
                d.a.o0.a.e0.d.g("SwanAppWebViewFragment", "close page failed");
                return false;
            }
            d.a.o0.a.e0.d.g("SwanAppWebViewFragment", "page closed! ");
            g.b h2 = W.h();
            h2.n(g.f45214i, g.f45213h);
            h2.g();
            h2.a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public static d O2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? new d(str) : (d) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static k P2(d.a.o0.a.l1.b bVar, String str) {
        InterceptResult invokeLL;
        char c2;
        k fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, bVar, str)) == null) {
            switch (str.hashCode()) {
                case -1750679182:
                    if (str.equals("allianceLogin")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -130826522:
                    if (str.equals("allianceChooseAddress")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 113553927:
                    if (str.equals("wxPay")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 570452084:
                    if (str.equals("adLanding")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1221126139:
                    if (str.equals("default_webview")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1339472410:
                    if (str.equals("qrCodePay")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                fVar = new d.a.o0.a.q1.f();
            } else if (c2 == 1) {
                fVar = new SwanAppAdLandingFragment();
            } else if (c2 == 2) {
                fVar = new k();
            } else if (c2 == 3) {
                fVar = new d.a.o0.a.s.a.e();
            } else if (c2 == 4) {
                fVar = new d.a.o0.a.s.a.k.a.c();
            } else if (c2 != 5) {
                if (I0) {
                    Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
                }
                fVar = null;
            } else {
                fVar = new d.a.o0.a.q1.c();
            }
            if (fVar != null) {
                fVar.S2(bVar);
            }
            return fVar;
        }
        return (k) invokeLL.objValue;
    }

    public static boolean Q2(String str, d.a.o0.a.l1.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, bVar)) == null) {
            g W = d.a.o0.a.g1.f.V().W();
            if (W == null) {
                d.a.o0.a.e0.d.g("SwanAppWebViewFragment", "open page failed");
                return false;
            }
            d.a.o0.a.e0.d.g("SwanAppWebViewFragment", "open page url=" + bVar.f46495g);
            g.b h2 = W.h();
            h2.n(g.f45212g, g.f45214i);
            h2.k(str, bVar).b();
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [d.a.o0.a.p.e.c] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(d.a.o0.a.g.aiapps_webview_fragment, viewGroup, false);
            Q1(inflate);
            d.a.o0.a.p.e.e m = m();
            this.C0 = m;
            m.Z(M2());
            this.D0 = this.C0.u();
            this.C0.loadUrl(this.E0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(d.a.o0.a.f.aiapps_webView_container);
            this.C0.l(frameLayout, this.D0.covertToView());
            J2(frameLayout);
            if (P1()) {
                inflate = S1(inflate);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public void J2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout) == null) {
        }
    }

    @Override // d.a.o0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.o0.a.p.e.c cVar = this.D0;
            if (cVar == null || !cVar.canGoBack()) {
                return false;
            }
            this.D0.goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean K2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(this.E0, str) || TextUtils.equals(this.E0.replace("http://", "").replace("https://", ""), str) : invokeL.booleanValue;
    }

    public d.a.o0.a.h0.j.d M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new b(this) : (d.a.o0.a.h0.j.d) invokeV.objValue;
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // d.a.o0.a.h0.g.d
    public void Q1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            super.Q1(view);
            l2(-1);
            t2(-16777216);
            SwanAppActionBar swanAppActionBar = this.n0;
            String str = this.G0;
            if (str == null) {
                str = "";
            }
            swanAppActionBar.setTitle(str);
            this.n0.setRightZoneVisibility(false);
            p2(true);
            this.n0.setLeftBackViewClickListener(new c(this));
        }
    }

    public final void R2() {
        Bundle n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (n = n()) == null) {
            return;
        }
        this.E0 = n.getString("url");
        String string = n.getString("params");
        this.F0 = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.F0);
            this.G0 = jSONObject.optString("fallback_title", null);
            this.H0 = jSONObject.optBoolean("should_check_domain", true);
        } catch (JSONException e2) {
            if (I0) {
                e2.printStackTrace();
            }
        }
    }

    public void S2(d.a.o0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", bVar.f46495g);
        bundle.putString("params", bVar.f46494f);
        j1(bundle);
    }

    @Override // d.a.o0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.o0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.o0.a.h0.g.d
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.C0.U();
            N2();
            this.o0.q(d.a.o0.a.c1.a.H().a(), E1());
        }
    }

    @Override // d.a.o0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            d.a.o0.a.p.e.e eVar = this.C0;
            if (eVar != null) {
                return eVar.isSlidable(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public d.a.o0.a.p.e.e m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new a(this, q()) : (d.a.o0.a.p.e.e) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            R2();
            if (I0) {
                Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d.a.o0.a.p.e.e eVar = this.C0;
            if (eVar != null) {
                eVar.destroy();
                this.C0 = null;
            }
            super.onDestroy();
        }
    }
}
