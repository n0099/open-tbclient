package com.repackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class os3 extends EventTargetImpl implements ls3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public no3 a;
    @V8JavascriptField
    public String adUnitId;
    public String b;
    public boolean c;
    public ms3 d;
    public ns3 e;
    public Map<String, String> f;
    public wn3 g;
    public b h;
    public boolean i;
    public boolean j;
    public ge3 k;
    public mo3 l;

    /* loaded from: classes6.dex */
    public class a implements mo3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ os3 a;

        /* renamed from: com.repackage.os3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0486a implements ge3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0486a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.repackage.ge3
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.repackage.ge3
            public void g() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.a.i = false;
                    this.a.a.a.i0();
                }
            }

            @Override // com.repackage.ge3
            public void n() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.a.i = true;
                    if (this.a.a.j) {
                        this.a.a.a.N();
                    }
                }
            }
        }

        public a(os3 os3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {os3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = os3Var;
        }

        @Override // com.repackage.mo3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (this.a.d != null) {
                        this.a.d.c();
                    }
                    ks3.b().c(16, "");
                    es3.b(this.a.getType(), "success");
                    return;
                }
                if (this.a.d != null) {
                    this.a.d.b(str);
                }
                ks3.b().c(17, str);
                es3.c(this.a.getType(), com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // com.repackage.mo3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    if (this.a.e != null) {
                        this.a.e.c();
                    }
                    if (this.a.h == null) {
                        this.a.h = new b(this.a, null);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        AppRuntime.getAppContext().registerReceiver(this.a.h, intentFilter);
                    }
                    if (this.a.k == null) {
                        this.a.k = new C0486a(this);
                        os3.M(this.a.k);
                    }
                } else if (this.a.e != null) {
                    this.a.e.b(str);
                }
            }
        }

        @Override // com.repackage.mo3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                JSEvent jSEvent = new JSEvent("close");
                jSEvent.data = ps3.a(z);
                this.a.dispatchEvent(jSEvent);
                es3.a(this.a.getType(), "pageclose", i);
                this.a.destroy();
            }
        }

        @Override // com.repackage.mo3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                es3.a(this.a.getType(), "click", i);
            }
        }

        @Override // com.repackage.mo3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = ps3.b(str);
                this.a.dispatchEvent(jSEvent);
                po3.k(this.a.f, str);
                this.a.destroy();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ os3 this$0;

        public b(os3 os3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {os3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = os3Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    this.this$0.j = true;
                    if (this.this$0.i) {
                        this.this$0.a.N();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    this.this$0.j = false;
                }
            }
        }

        public /* synthetic */ b(os3 os3Var, a aVar) {
            this(os3Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public os3(r62 r62Var, JsObject jsObject) {
        super(r62Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r62Var, jsObject};
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
        this.adUnitId = "";
        this.f = new TreeMap();
        this.j = true;
        this.l = new a(this);
        or1 F = or1.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.b = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.b)) {
            boolean g = ap3.g();
            this.c = g;
            if (g) {
                this.b = ap3.c();
                this.adUnitId = ap3.d();
            }
            this.f = po3.a("video", "game", this.b, this.adUnitId, this.c);
            this.g = new cs3();
            no3 no3Var = new no3(uk2.U().getActivity(), this.b, this.adUnitId, this.c, this.l, this.g);
            this.a = no3Var;
            no3Var.k0(this.f);
            loadAd(null);
            return;
        }
        r62Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void M(ge3 ge3Var) {
        yg1 W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, ge3Var) == null) || (W = uk2.U().W()) == null) {
            return;
        }
        W.e(ge3Var);
    }

    public static void N(ge3 ge3Var) {
        yg1 W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, ge3Var) == null) || (W = uk2.U().W()) == null) {
            return;
        }
        W.f(ge3Var);
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.h != null) {
                AppRuntime.getAppContext().unregisterReceiver(this.h);
                this.h = null;
            }
            ge3 ge3Var = this.k;
            if (ge3Var != null) {
                N(ge3Var);
                this.k = null;
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c ? "gdtvideo" : "video" : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.d = ms3.d(or1.F(jsObject));
                ks3.b().a(this.d);
                if (this.a != null) {
                    this.a.c0();
                }
            }
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            synchronized (this) {
                es3.d(getType());
                this.e = ns3.d(or1.F(jsObject));
                if (this.a != null) {
                    this.a.l0();
                }
            }
        }
    }
}
