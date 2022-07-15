package com.repackage;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.it3;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class gt3 extends EventTargetImpl implements jt3, it3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @V8JavascriptField
    public String adUnitId;
    public r72 b;
    public String c;
    public boolean d;
    public rn3 e;
    public wo3 f;
    public boolean g;
    public Map<String, String> h;
    public nt3 i;
    public vn3 j;
    @V8JavascriptField
    public it3 style;

    /* loaded from: classes6.dex */
    public class a implements vn3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt3 a;

        public a(gt3 gt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt3Var;
        }

        @Override // com.repackage.vn3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    et3.b(this.a.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, "success");
                    return;
                }
                et3.c(this.a.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // com.repackage.vn3
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.a.i == null) {
                return;
            }
            if (z) {
                this.a.i.c();
            } else {
                this.a.i.b("3010010");
            }
        }

        @Override // com.repackage.vn3
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = ht3.b(i, i2);
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.repackage.vn3
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.g) {
                et3.b("gdtbanner", "click");
            }
        }

        @Override // com.repackage.vn3
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.destroy();
                t24 A = t24.A();
                String str = this.a.adUnitId;
                A.K(str, "" + System.currentTimeMillis());
                et3.b(this.a.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, "close");
            }
        }

        @Override // com.repackage.vn3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = ht3.a(str);
                this.a.dispatchEvent(jSEvent);
                pp3.k(this.a.h, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt3 a;

        public b(gt3 gt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = ht3.a(this.a.c);
                this.a.dispatchEvent(jSEvent);
                pp3.k(this.a.h, this.a.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt3(r72 r72Var, JsObject jsObject) {
        super(r72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r72Var, jsObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.style = null;
        this.h = new TreeMap();
        this.j = new a(this);
        this.b = r72Var;
        os1 F = os1.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.a = F.B("appSid");
            os1 w = F.w("style");
            if (w != null) {
                this.style = new it3(w);
            }
        }
        boolean e = aq3.e();
        this.g = e;
        if (e) {
            this.a = aq3.a();
            this.adUnitId = aq3.b();
        }
        String str = this.a;
        String str2 = this.adUnitId;
        boolean z = this.g;
        String str3 = SpeedStatsUtils.UBC_VALUE_BANNER;
        Map<String, String> a2 = pp3.a(SpeedStatsUtils.UBC_VALUE_BANNER, "game", str, str2, z);
        this.h = a2;
        pp3.m("loadApi", a2);
        if (C()) {
            if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.a) && this.style != null) {
                ct3 ct3Var = new ct3();
                this.f = ct3Var;
                rn3 rn3Var = new rn3(this.a, this.adUnitId, this.j, ct3Var);
                this.e = rn3Var;
                rn3Var.F(this.h);
                it3 it3Var = this.style;
                if (it3Var != null) {
                    this.e.E(it3Var.left, it3Var.top, it3Var.width, it3Var.height);
                    this.style.b(this);
                }
                et3.b(this.g ? "gdtbanner" : str3, null);
                return;
            }
            r72Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                t24 A = t24.A();
                if (!A.k()) {
                    if (!A.l()) {
                        if (A.t(this.adUnitId)) {
                            this.c = "3010011";
                        }
                    } else {
                        this.c = "3010013";
                    }
                } else {
                    this.c = "3010012";
                }
            }
            if (TextUtils.isEmpty(this.c)) {
                return true;
            }
            this.b.postOnJSThread(new b(this));
            et3.c(SpeedStatsUtils.UBC_VALUE_BANNER, "reject", this.c);
            return false;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = true;
            removeEventListener("error", null);
            removeEventListener("load", null);
            removeEventListener("resize", null);
            rn3 rn3Var = this.e;
            if (rn3Var != null) {
                rn3Var.y();
                this.e = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        rn3 rn3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (rn3Var = this.e) == null) {
            return;
        }
        rn3Var.B();
    }

    @Override // com.repackage.it3.a
    public void j(String str) {
        rn3 rn3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.d || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (rn3Var = this.e) == null) {
            return;
        }
        rn3Var.H(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            et3.d(this.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER);
            pp3.m("showApi", this.h);
            if (!C() || this.e == null) {
                return;
            }
            t24.A().E();
            this.i = nt3.d(os1.F(jsObject));
            this.e.G(jsObject);
        }
    }
}
