package d.a.q0.h.a.f;

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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.p.b.a.n;
import d.a.q0.f.i.r.i;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class e extends EventTargetImpl implements d.a.q0.h.a.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.f.i.p.b f53041e;

    /* renamed from: f  reason: collision with root package name */
    public String f53042f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53043g;

    /* renamed from: h  reason: collision with root package name */
    public c f53044h;

    /* renamed from: i  reason: collision with root package name */
    public d f53045i;
    public Map<String, String> j;
    public d.a.q0.f.i.l.f k;
    public b l;
    public boolean m;
    public boolean n;
    public d.a.q0.a.w2.c o;
    public d.a.q0.f.i.p.a p;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.f.i.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f53046a;

        /* renamed from: d.a.q0.h.a.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1126a implements d.a.q0.a.w2.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f53047e;

            public C1126a(a aVar) {
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
                this.f53047e = aVar;
            }

            @Override // d.a.q0.a.w2.c
            public void f() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f53047e.f53046a.m = false;
                    this.f53047e.f53046a.f53041e.i0();
                }
            }

            @Override // d.a.q0.a.w2.c
            public void k() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // d.a.q0.a.w2.c
            public void n() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f53047e.f53046a.m = true;
                    if (this.f53047e.f53046a.n) {
                        this.f53047e.f53046a.f53041e.P();
                    }
                }
            }
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53046a = eVar;
        }

        @Override // d.a.q0.f.i.p.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.f53046a.dispatchEvent(new JSEvent("load"));
                    if (this.f53046a.f53044h != null) {
                        this.f53046a.f53044h.c();
                    }
                    d.a.q0.h.a.f.a.b().c(16, "");
                    d.a.q0.h.a.c.b(this.f53046a.M(), "success");
                    return;
                }
                if (this.f53046a.f53044h != null) {
                    this.f53046a.f53044h.b(str);
                }
                d.a.q0.h.a.f.a.b().c(17, str);
                d.a.q0.h.a.c.c(this.f53046a.M(), com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // d.a.q0.f.i.p.a
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    if (this.f53046a.f53045i != null) {
                        this.f53046a.f53045i.c();
                    }
                    if (this.f53046a.l == null) {
                        this.f53046a.l = new b(this.f53046a, null);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        AppRuntime.getAppContext().registerReceiver(this.f53046a.l, intentFilter);
                    }
                    if (this.f53046a.o == null) {
                        this.f53046a.o = new C1126a(this);
                        e.N(this.f53046a.o);
                    }
                } else if (this.f53046a.f53045i != null) {
                    this.f53046a.f53045i.b(str);
                }
            }
        }

        @Override // d.a.q0.f.i.p.a
        public void c(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                JSEvent jSEvent = new JSEvent(IntentConfig.CLOSE);
                jSEvent.data = f.a(z);
                this.f53046a.dispatchEvent(jSEvent);
                d.a.q0.h.a.c.a(this.f53046a.M(), "pageclose", i2);
                this.f53046a.destroy();
            }
        }

        @Override // d.a.q0.f.i.p.a
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                d.a.q0.h.a.c.a(this.f53046a.M(), PrefetchEvent.STATE_CLICK, i2);
            }
        }

        @Override // d.a.q0.f.i.p.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = f.b(str);
                this.f53046a.dispatchEvent(jSEvent);
                d.a.q0.f.i.q.b.k(this.f53046a.j, str);
                this.f53046a.destroy();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e this$0;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    this.this$0.n = true;
                    if (this.this$0.m) {
                        this.this$0.f53041e.P();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    this.this$0.n = false;
                }
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d.a.q0.a.l0.c cVar, JsObject jsObject) {
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
        this.adUnitId = "";
        this.j = new TreeMap();
        this.n = true;
        this.p = new a(this);
        d.a.q0.a.y.b.a G = d.a.q0.a.y.b.a.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.f53042f = G.C("appSid");
        }
        if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f53042f)) {
            boolean g2 = i.g();
            this.f53043g = g2;
            if (g2) {
                this.f53042f = i.c();
                this.adUnitId = i.d();
            }
            this.j = d.a.q0.f.i.q.b.a("video", "game", this.f53042f, this.adUnitId, this.f53043g);
            this.k = new d.a.q0.h.a.a();
            d.a.q0.f.i.p.b bVar = new d.a.q0.f.i.p.b(d.a.q0.a.g1.f.V().getActivity(), this.f53042f, this.adUnitId, this.f53043g, this.p, this.k);
            this.f53041e = bVar;
            bVar.k0(this.j);
            loadAd(null);
            return;
        }
        cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void N(d.a.q0.a.w2.c cVar) {
        n X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, cVar) == null) || (X = d.a.q0.a.g1.f.V().X()) == null) {
            return;
        }
        X.e(cVar);
    }

    public static void O(d.a.q0.a.w2.c cVar) {
        n X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, cVar) == null) || (X = d.a.q0.a.g1.f.V().X()) == null) {
            return;
        }
        X.f(cVar);
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53043g ? "gdtvideo" : "video" : (String) invokeV.objValue;
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.l != null) {
                AppRuntime.getAppContext().unregisterReceiver(this.l);
                this.l = null;
            }
            d.a.q0.a.w2.c cVar = this.o;
            if (cVar != null) {
                O(cVar);
                this.o = null;
            }
        }
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.f53044h = c.d(d.a.q0.a.y.b.a.G(jsObject));
                d.a.q0.h.a.f.a.b().a(this.f53044h);
                if (this.f53041e != null) {
                    this.f53041e.e0();
                }
            }
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            synchronized (this) {
                d.a.q0.h.a.c.d(M());
                this.f53045i = d.d(d.a.q0.a.y.b.a.G(jsObject));
                if (this.f53041e != null) {
                    this.f53041e.l0();
                }
            }
        }
    }
}
