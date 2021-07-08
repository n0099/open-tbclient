package d.a.n0.h.a.e;

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
import d.a.n0.f.i.l.f;
import d.a.n0.f.i.r.i;
import d.a.n0.h.a.e.c;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class a extends EventTargetImpl implements d, c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public String f49725e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.a.l0.c f49726f;

    /* renamed from: g  reason: collision with root package name */
    public String f49727g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49728h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.f.i.i.b f49729i;
    public f j;
    public boolean k;
    public Map<String, String> l;
    public d.a.n0.h.a.f.d m;
    public d.a.n0.f.i.i.f n;
    @V8JavascriptField
    public c style;

    /* renamed from: d.a.n0.h.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1074a implements d.a.n0.f.i.i.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f49730a;

        public C1074a(a aVar) {
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
            this.f49730a = aVar;
        }

        @Override // d.a.n0.f.i.i.f
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f49730a.dispatchEvent(new JSEvent("load"));
                    d.a.n0.h.a.c.b(this.f49730a.k ? "gdtbanner" : "banner", "success");
                    return;
                }
                d.a.n0.h.a.c.c(this.f49730a.k ? "gdtbanner" : "banner", com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // d.a.n0.f.i.i.f
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = d.a.n0.h.a.e.b.b(i2, i3);
                this.f49730a.dispatchEvent(jSEvent);
            }
        }

        @Override // d.a.n0.f.i.i.f
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f49730a.k) {
                d.a.n0.h.a.c.b("gdtbanner", PrefetchEvent.STATE_CLICK);
            }
        }

        @Override // d.a.n0.f.i.i.f
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f49730a.destroy();
                d.a.n0.h.m0.d A = d.a.n0.h.m0.d.A();
                String str = this.f49730a.adUnitId;
                A.K(str, "" + System.currentTimeMillis());
                d.a.n0.h.a.c.b(this.f49730a.k ? "gdtbanner" : "banner", IntentConfig.CLOSE);
            }
        }

        @Override // d.a.n0.f.i.i.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = d.a.n0.h.a.e.b.a(str);
                this.f49730a.dispatchEvent(jSEvent);
                d.a.n0.f.i.q.b.k(this.f49730a.l, str);
            }
        }

        @Override // d.a.n0.f.i.i.f
        public void onShow(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.f49730a.m == null) {
                return;
            }
            if (z) {
                this.f49730a.m.c();
            } else {
                this.f49730a.m.b("3010010");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49731e;

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
            this.f49731e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = d.a.n0.h.a.e.b.a(this.f49731e.f49727g);
                this.f49731e.dispatchEvent(jSEvent);
                d.a.n0.f.i.q.b.k(this.f49731e.l, this.f49731e.f49727g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.n0.a.l0.c cVar, JsObject jsObject) {
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
        this.n = new C1074a(this);
        this.f49726f = cVar;
        d.a.n0.a.y.b.a G = d.a.n0.a.y.b.a.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.f49725e = G.C("appSid");
            d.a.n0.a.y.b.a x = G.x("style");
            if (x != null) {
                this.style = new c(x);
            }
        }
        boolean e2 = i.e();
        this.k = e2;
        if (e2) {
            this.f49725e = i.a();
            this.adUnitId = i.b();
        }
        Map<String, String> a2 = d.a.n0.f.i.q.b.a("banner", "game", this.f49725e, this.adUnitId, this.k);
        this.l = a2;
        d.a.n0.f.i.q.b.m("loadApi", a2);
        if (C()) {
            if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f49725e) && this.style != null) {
                d.a.n0.h.a.a aVar = new d.a.n0.h.a.a();
                this.j = aVar;
                d.a.n0.f.i.i.b bVar = new d.a.n0.f.i.i.b(this.f49725e, this.adUnitId, this.n, aVar);
                this.f49729i = bVar;
                bVar.F(this.l);
                c cVar2 = this.style;
                if (cVar2 != null) {
                    this.f49729i.E(cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                    this.style.b(this);
                }
                d.a.n0.h.a.c.b(this.k ? "gdtbanner" : "banner", null);
                return;
            }
            cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f49727g)) {
                d.a.n0.h.m0.d A = d.a.n0.h.m0.d.A();
                if (!A.k()) {
                    if (!A.l()) {
                        if (A.t(this.adUnitId)) {
                            this.f49727g = "3010011";
                        }
                    } else {
                        this.f49727g = "3010013";
                    }
                } else {
                    this.f49727g = "3010012";
                }
            }
            if (TextUtils.isEmpty(this.f49727g)) {
                return true;
            }
            this.f49726f.postOnJSThread(new b(this));
            d.a.n0.h.a.c.c("banner", "reject", this.f49727g);
            return false;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49728h = true;
            removeEventListener("error", null);
            removeEventListener("load", null);
            removeEventListener("resize", null);
            d.a.n0.f.i.i.b bVar = this.f49729i;
            if (bVar != null) {
                bVar.y();
                this.f49729i = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        d.a.n0.f.i.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f49729i) == null) {
            return;
        }
        bVar.B();
    }

    @Override // d.a.n0.h.a.e.c.a
    public void i(String str) {
        d.a.n0.f.i.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f49728h || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (bVar = this.f49729i) == null) {
            return;
        }
        bVar.H(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            d.a.n0.h.a.c.d(this.k ? "gdtbanner" : "banner");
            d.a.n0.f.i.q.b.m("showApi", this.l);
            if (!C() || this.f49729i == null) {
                return;
            }
            d.a.n0.h.m0.d.A().E();
            this.m = d.a.n0.h.a.f.d.d(d.a.n0.a.y.b.a.G(jsObject));
            this.f49729i.G(jsObject);
        }
    }
}
