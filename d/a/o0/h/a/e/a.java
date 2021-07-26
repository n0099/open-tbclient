package d.a.o0.h.a.e;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.f.i.l.f;
import d.a.o0.f.i.r.i;
import d.a.o0.h.a.e.c;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class a extends EventTargetImpl implements d, c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public String f50229e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.a.l0.c f50230f;

    /* renamed from: g  reason: collision with root package name */
    public String f50231g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50232h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.f.i.i.b f50233i;
    public f j;
    public boolean k;
    public Map<String, String> l;
    public d.a.o0.h.a.f.d m;
    public d.a.o0.f.i.i.f n;
    @V8JavascriptField
    public c style;

    /* renamed from: d.a.o0.h.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1083a implements d.a.o0.f.i.i.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f50234a;

        public C1083a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50234a = aVar;
        }

        @Override // d.a.o0.f.i.i.f
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f50234a.dispatchEvent(new JSEvent("load"));
                    d.a.o0.h.a.c.b(this.f50234a.k ? "gdtbanner" : "banner", "success");
                    return;
                }
                d.a.o0.h.a.c.c(this.f50234a.k ? "gdtbanner" : "banner", com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // d.a.o0.f.i.i.f
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = d.a.o0.h.a.e.b.b(i2, i3);
                this.f50234a.dispatchEvent(jSEvent);
            }
        }

        @Override // d.a.o0.f.i.i.f
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f50234a.k) {
                d.a.o0.h.a.c.b("gdtbanner", PrefetchEvent.STATE_CLICK);
            }
        }

        @Override // d.a.o0.f.i.i.f
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f50234a.destroy();
                d.a.o0.h.m0.d A = d.a.o0.h.m0.d.A();
                String str = this.f50234a.adUnitId;
                A.K(str, "" + System.currentTimeMillis());
                d.a.o0.h.a.c.b(this.f50234a.k ? "gdtbanner" : "banner", IntentConfig.CLOSE);
            }
        }

        @Override // d.a.o0.f.i.i.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = d.a.o0.h.a.e.b.a(str);
                this.f50234a.dispatchEvent(jSEvent);
                d.a.o0.f.i.q.b.k(this.f50234a.l, str);
            }
        }

        @Override // d.a.o0.f.i.i.f
        public void onShow(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.f50234a.m == null) {
                return;
            }
            if (z) {
                this.f50234a.m.c();
            } else {
                this.f50234a.m.b("3010010");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50235e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50235e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = d.a.o0.h.a.e.b.a(this.f50235e.f50231g);
                this.f50235e.dispatchEvent(jSEvent);
                d.a.o0.f.i.q.b.k(this.f50235e.l, this.f50235e.f50231g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.l0.c cVar, JsObject jsObject) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, jsObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.style = null;
        this.l = new TreeMap();
        this.n = new C1083a(this);
        this.f50230f = cVar;
        d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.f50229e = G.C("appSid");
            d.a.o0.a.y.b.a x = G.x("style");
            if (x != null) {
                this.style = new c(x);
            }
        }
        boolean e2 = i.e();
        this.k = e2;
        if (e2) {
            this.f50229e = i.a();
            this.adUnitId = i.b();
        }
        Map<String, String> a2 = d.a.o0.f.i.q.b.a("banner", "game", this.f50229e, this.adUnitId, this.k);
        this.l = a2;
        d.a.o0.f.i.q.b.m("loadApi", a2);
        if (C()) {
            if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f50229e) && this.style != null) {
                d.a.o0.h.a.a aVar = new d.a.o0.h.a.a();
                this.j = aVar;
                d.a.o0.f.i.i.b bVar = new d.a.o0.f.i.i.b(this.f50229e, this.adUnitId, this.n, aVar);
                this.f50233i = bVar;
                bVar.F(this.l);
                c cVar2 = this.style;
                if (cVar2 != null) {
                    this.f50233i.E(cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                    this.style.b(this);
                }
                d.a.o0.h.a.c.b(this.k ? "gdtbanner" : "banner", null);
                return;
            }
            cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f50231g)) {
                d.a.o0.h.m0.d A = d.a.o0.h.m0.d.A();
                if (!A.k()) {
                    if (!A.l()) {
                        if (A.t(this.adUnitId)) {
                            this.f50231g = "3010011";
                        }
                    } else {
                        this.f50231g = "3010013";
                    }
                } else {
                    this.f50231g = "3010012";
                }
            }
            if (TextUtils.isEmpty(this.f50231g)) {
                return true;
            }
            this.f50230f.postOnJSThread(new b(this));
            d.a.o0.h.a.c.c("banner", "reject", this.f50231g);
            return false;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f50232h = true;
            removeEventListener("error", null);
            removeEventListener("load", null);
            removeEventListener("resize", null);
            d.a.o0.f.i.i.b bVar = this.f50233i;
            if (bVar != null) {
                bVar.y();
                this.f50233i = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        d.a.o0.f.i.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f50233i) == null) {
            return;
        }
        bVar.B();
    }

    @Override // d.a.o0.h.a.e.c.a
    public void i(String str) {
        d.a.o0.f.i.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f50232h || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (bVar = this.f50233i) == null) {
            return;
        }
        bVar.H(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            d.a.o0.h.a.c.d(this.k ? "gdtbanner" : "banner");
            d.a.o0.f.i.q.b.m("showApi", this.l);
            if (!C() || this.f50233i == null) {
                return;
            }
            d.a.o0.h.m0.d.A().E();
            this.m = d.a.o0.h.a.f.d.d(d.a.o0.a.y.b.a.G(jsObject));
            this.f50233i.G(jsObject);
        }
    }
}
