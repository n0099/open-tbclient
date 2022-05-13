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
import com.repackage.vt3;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class tt3 extends EventTargetImpl implements wt3, vt3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @V8JavascriptField
    public String adUnitId;
    public e82 b;
    public String c;
    public boolean d;
    public eo3 e;
    public jp3 f;
    public boolean g;
    public Map<String, String> h;
    public au3 i;
    public io3 j;
    @V8JavascriptField
    public vt3 style;

    /* loaded from: classes7.dex */
    public class a implements io3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt3 a;

        public a(tt3 tt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt3Var;
        }

        @Override // com.repackage.io3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    rt3.b(this.a.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, "success");
                    return;
                }
                rt3.c(this.a.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // com.repackage.io3
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

        @Override // com.repackage.io3
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = ut3.b(i, i2);
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.repackage.io3
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.g) {
                rt3.b("gdtbanner", "click");
            }
        }

        @Override // com.repackage.io3
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.destroy();
                g34 A = g34.A();
                String str = this.a.adUnitId;
                A.K(str, "" + System.currentTimeMillis());
                rt3.b(this.a.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, "close");
            }
        }

        @Override // com.repackage.io3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = ut3.a(str);
                this.a.dispatchEvent(jSEvent);
                cq3.k(this.a.h, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt3 a;

        public b(tt3 tt3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = ut3.a(this.a.c);
                this.a.dispatchEvent(jSEvent);
                cq3.k(this.a.h, this.a.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tt3(e82 e82Var, JsObject jsObject) {
        super(e82Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e82Var, jsObject};
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
        this.b = e82Var;
        bt1 F = bt1.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.a = F.B("appSid");
            bt1 w = F.w("style");
            if (w != null) {
                this.style = new vt3(w);
            }
        }
        boolean e = nq3.e();
        this.g = e;
        if (e) {
            this.a = nq3.a();
            this.adUnitId = nq3.b();
        }
        String str = this.a;
        String str2 = this.adUnitId;
        boolean z = this.g;
        String str3 = SpeedStatsUtils.UBC_VALUE_BANNER;
        Map<String, String> a2 = cq3.a(SpeedStatsUtils.UBC_VALUE_BANNER, "game", str, str2, z);
        this.h = a2;
        cq3.m("loadApi", a2);
        if (C()) {
            if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.a) && this.style != null) {
                pt3 pt3Var = new pt3();
                this.f = pt3Var;
                eo3 eo3Var = new eo3(this.a, this.adUnitId, this.j, pt3Var);
                this.e = eo3Var;
                eo3Var.F(this.h);
                vt3 vt3Var = this.style;
                if (vt3Var != null) {
                    this.e.E(vt3Var.left, vt3Var.top, vt3Var.width, vt3Var.height);
                    this.style.b(this);
                }
                rt3.b(this.g ? "gdtbanner" : str3, null);
                return;
            }
            e82Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                g34 A = g34.A();
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
            rt3.c(SpeedStatsUtils.UBC_VALUE_BANNER, "reject", this.c);
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
            eo3 eo3Var = this.e;
            if (eo3Var != null) {
                eo3Var.y();
                this.e = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        eo3 eo3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (eo3Var = this.e) == null) {
            return;
        }
        eo3Var.B();
    }

    @Override // com.repackage.vt3.a
    public void j(String str) {
        eo3 eo3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.d || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (eo3Var = this.e) == null) {
            return;
        }
        eo3Var.H(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            rt3.d(this.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER);
            cq3.m("showApi", this.h);
            if (!C() || this.e == null) {
                return;
            }
            g34.A().E();
            this.i = au3.d(bt1.F(jsObject));
            this.e.G(jsObject);
        }
    }
}
