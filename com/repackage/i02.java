package com.repackage;

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
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d02;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i02 extends a02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean L0;
    public transient /* synthetic */ FieldHolder $fh;
    public dn1 F0;
    public bn1 G0;
    public String H0;
    public String I0;
    public String J0;
    public boolean K0;

    /* loaded from: classes6.dex */
    public class a extends SwanAppWebViewWidget {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i02 h0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i02 i02Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i02Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h0 = i02Var;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean X1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h0.K0 : invokeV.booleanValue;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean Y1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends f22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i02 c;

        public b(i02 i02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i02Var;
        }

        @Override // com.repackage.f22, com.repackage.i22
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.c.W2(str) && this.c.J0 != null) {
                    i02 i02Var = this.c;
                    i02Var.l0.setTitle(i02Var.J0);
                    return;
                }
                this.c.l0.setTitle(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i02 a;

        public c(i02 i02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.G0.canGoBack()) {
                    this.a.G0.goBack();
                } else {
                    this.a.g2();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public uq2 a;
        public JSONObject b;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new JSONObject();
            this.a = uq2.d(str, str);
        }

        public d a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                try {
                    this.b.put("should_check_domain", z);
                } catch (JSONException e) {
                    if (i02.L0) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            return (d) invokeZ.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b = this.b.toString();
                i02.c3("default_webview", this.a);
            }
        }

        public void c(oe4 oe4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oe4Var) == null) || oe4Var == null) {
                return;
            }
            this.a.b = this.b.toString();
            i02 b3 = i02.b3(this.a, "default_webview");
            qe4 a = oe4Var.a();
            a.a(R.id.obfuscated_res_0x7f090174, b3);
            a.d(null);
            a.e();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755672346, "Lcom/repackage/i02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755672346, "Lcom/repackage/i02;");
                return;
            }
        }
        L0 = eh1.a;
    }

    public i02() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.K0 = true;
    }

    public static boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            d02 V = hm2.U().V();
            if (V == null) {
                ux1.i("SwanAppWebViewFragment", "close page failed");
                return false;
            }
            ux1.i("SwanAppWebViewFragment", "page closed! ");
            d02.b h = V.h();
            h.n(d02.i, d02.h);
            h.g();
            h.a();
            return true;
        }
        return invokeV.booleanValue;
    }

    public static d a3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? new d(str) : (d) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static i02 b3(uq2 uq2Var, String str) {
        InterceptResult invokeLL;
        char c2;
        i02 ot2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, uq2Var, str)) == null) {
            switch (str.hashCode()) {
                case -1750679182:
                    if (str.equals("allianceLogin")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -718660690:
                    if (str.equals("web_mode")) {
                        c2 = 6;
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
            switch (c2) {
                case 0:
                    ot2Var = new ot2();
                    break;
                case 1:
                    ot2Var = new SwanAppAdLandingFragment();
                    break;
                case 2:
                    ot2Var = new i02();
                    break;
                case 3:
                    ot2Var = new go1();
                    break;
                case 4:
                    ot2Var = new oo1();
                    break;
                case 5:
                    ot2Var = new kt2();
                    break;
                case 6:
                    ot2Var = new h02();
                    break;
                default:
                    if (L0) {
                        Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
                    }
                    ot2Var = null;
                    break;
            }
            if (ot2Var != null) {
                ot2Var.e3(uq2Var);
            }
            return ot2Var;
        }
        return (i02) invokeLL.objValue;
    }

    public static boolean c3(String str, uq2 uq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, uq2Var)) == null) {
            d02 V = hm2.U().V();
            if (V == null) {
                ux1.i("SwanAppWebViewFragment", "open page failed");
                return false;
            }
            ux1.i("SwanAppWebViewFragment", "open page url=" + uq2Var.c);
            d02.b h = V.h();
            h.n(d02.g, d02.i);
            h.k(str, uq2Var).b();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.a02
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bn1 bn1Var = this.G0;
            if (bn1Var == null || !bn1Var.canGoBack()) {
                return false;
            }
            this.G0.goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.T1(view2);
            s2(-1);
            B2(-16777216);
            SwanAppActionBar swanAppActionBar = this.l0;
            String str = this.J0;
            if (str == null) {
                str = "";
            }
            swanAppActionBar.setTitle(str);
            this.l0.setRightZoneVisibility(false);
            w2(true);
            this.l0.setLeftBackViewClickListener(new c(this));
        }
    }

    public void V2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frameLayout) == null) {
        }
    }

    public final boolean W2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(this.H0, str) || TextUtils.equals(this.H0.replace("http://", "").replace("https://", ""), str) : invokeL.booleanValue;
    }

    public i22 Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new b(this) : (i22) invokeV.objValue;
    }

    public void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.repackage.a02
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d3() {
        Bundle q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (q = q()) == null) {
            return;
        }
        this.H0 = q.getString("url");
        String string = q.getString("params");
        this.I0 = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.I0);
            this.J0 = jSONObject.optString("fallback_title", null);
            this.K0 = jSONObject.optBoolean("should_check_domain", true);
        } catch (JSONException e) {
            if (L0) {
                e.printStackTrace();
            }
        }
    }

    public void e3(uq2 uq2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, uq2Var) == null) || uq2Var == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", uq2Var.c);
        bundle.putString("params", uq2Var.b);
        i1(bundle);
    }

    @Override // com.repackage.a02
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.F0.W();
            Z2();
            this.m0.t(bk2.M().a(), G1());
        }
    }

    @Override // com.repackage.a02, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            dn1 dn1Var = this.F0;
            if (dn1Var != null) {
                return dn1Var.isSlidable(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public dn1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new a(this, getContext()) : (dn1) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.v0(bundle);
            d3();
            if (L0) {
                Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.repackage.bn1] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e0, viewGroup, false);
            T1(inflate);
            dn1 m = m();
            this.F0 = m;
            m.c0(Y2());
            this.G0 = this.F0.u();
            this.F0.loadUrl(this.H0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901a8);
            this.F0.l(frameLayout, this.G0.covertToView());
            V2(frameLayout);
            if (S1()) {
                inflate = V1(inflate);
            }
            return C1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            dn1 dn1Var = this.F0;
            if (dn1Var != null) {
                dn1Var.destroy();
                this.F0 = null;
            }
            super.z0();
        }
    }
}
