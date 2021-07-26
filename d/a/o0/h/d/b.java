package d.a.o0.h.d;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.view.desktopguide.DesktopGuideApi;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.l0.c;
import d.a.o0.a.r0.e;
import d.a.o0.h.c.g;
import d.a.o0.h.c.h;
import d.a.o0.h.f.f;
import d.a.o0.h.k0.j;
import d.a.o0.h.z.d;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes7.dex */
public final class b extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public c f50400e;
    @V8JavascriptField
    public d.a.o0.a.r0.a env;

    /* renamed from: f  reason: collision with root package name */
    public e f50401f;

    /* renamed from: g  reason: collision with root package name */
    public d f50402g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.h.z.b f50403h;

    /* renamed from: i  reason: collision with root package name */
    public JsObject f50404i;
    public d.a.o0.h.z.e j;
    public d.a.o0.h.u.a k;
    public d.a.o0.h.u.b l;
    public d.a.o0.h.g0.b m;
    public d.a.o0.h.l0.d n;
    public d.a.o0.h.a.f.b o;
    public d.a.o0.h.y.h.a p;
    public f q;
    public d.a.o0.h.d0.a r;
    public DesktopGuideApi s;
    public d.a.o0.h.b0.a t;
    public d.a.o0.h.o0.h.a u;
    public d.a.o0.h.b.b v;
    public d.a.o0.h.i.a w;
    public d.a.o0.h.a0.a x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(355283188, "Ld/a/o0/h/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(355283188, "Ld/a/o0/h/d/b;");
                return;
            }
        }
        y = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.domain = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        this.f50404i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.f50400e = cVar;
        this.env = new d.a.o0.a.r0.a();
        z();
    }

    public void A(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) {
            this.f50404i = jsObject;
        }
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            d.a.o0.h.l.a.b(jsObject);
        }
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            if (this.f50403h == null) {
                this.f50403h = new d.a.o0.h.z.b(this.f50400e);
            }
            this.f50403h.checkIsUserAdvisedToRest(jsObject);
        }
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            y().h(jsObject);
        }
    }

    @JavascriptInterface
    public void clearStorageSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.o0.h.g0.f.d.a(this.f50400e, "clearStorageSync", "", y().a());
        }
    }

    @JavascriptInterface
    public d.a.o0.h.y.h.c connectSocket(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            if (this.p == null) {
                this.p = new d.a.o0.h.y.h.a(this.f50400e);
            }
            return this.p.a(jsObject);
        }
        return (d.a.o0.h.y.h.c) invokeL.objValue;
    }

    @JavascriptInterface
    public d.a.o0.h.a.e.d createBannerAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jsObject)) == null) ? new d.a.o0.h.a.e.a(this.f50400e, jsObject) : (d.a.o0.h.a.e.d) invokeL.objValue;
    }

    @JavascriptInterface
    public g createInnerAudioContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new g(this.f50400e) : (g) invokeV.objValue;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jsObject)) == null) ? new RecommendButtonApiProxy(this.f50400e, jsObject) : (RecommendButtonApiProxy) invokeL.objValue;
    }

    @JavascriptInterface
    public d.a.o0.h.a.f.b createRewardedVideoAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jsObject)) == null) {
            if (this.o == null) {
                this.o = new d.a.o0.h.a.f.e(this.f50400e, jsObject);
            }
            return this.o;
        }
        return (d.a.o0.h.a.f.b) invokeL.objValue;
    }

    @JavascriptInterface
    public d.a.o0.h.k0.g createUDPSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j.f50566c.b(this.f50400e) : (d.a.o0.h.k0.g) invokeV.objValue;
    }

    @JavascriptInterface
    public d.a.o0.h.o0.d.b.b createUserInfoButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jsObject)) == null) ? new d.a.o0.h.o0.d.b.b(jsObject, this.f50400e) : (d.a.o0.h.o0.d.b.b) invokeL.objValue;
    }

    @JavascriptInterface
    public d.a.o0.h.y.d.b downloadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, jsObject)) == null) {
            d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObject);
            d.a.o0.h.y.a d2 = d.a.o0.h.y.e.b.b().d(this.f50400e, G, 2);
            if (d2 instanceof d.a.o0.h.y.d.b) {
                d.a.o0.h.y.d.b bVar = (d.a.o0.h.y.d.b) d2;
                bVar.I(G);
                return bVar;
            }
            d.a.o0.h.y.d.b bVar2 = new d.a.o0.h.y.d.b(this.f50400e, G);
            bVar2.start();
            return bVar2;
        }
        return (d.a.o0.h.y.d.b) invokeL.objValue;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            if (y) {
                this.f50400e.A().b("exit from java side.");
            }
            if (jsObject == null) {
                return;
            }
            d.a.o0.h.d.c.b bVar = new d.a.o0.h.d.c.b();
            d.a.o0.h.d.c.a e2 = d.a.o0.h.d.c.a.e(d.a.o0.a.y.b.a.G(jsObject));
            SwanAppActivity activity = d.a.o0.a.g1.f.V().getActivity();
            if (activity == null) {
                bVar.errMsg = String.format("%s:%s", "exit", com.alipay.sdk.util.e.f2000a);
                e2.b(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", "exit", "ok");
            e2.d(bVar);
            activity.finishAndRemoveTask();
        }
    }

    @JavascriptInterface
    public void exitVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            if (this.x == null) {
                this.x = d.a.o0.h.a0.b.f50250a.a();
            }
            this.x.d(jsObject);
        }
    }

    @JavascriptInterface
    public String getAPIs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (y) {
                return d.a.o0.a.u1.a.a.p() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i2) : "";
            }
            return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i2);
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public d.a.o0.h.b.b getAntiAddiction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.v == null) {
                this.v = new d.a.o0.h.b.b(this.f50400e);
            }
            return this.v;
        }
        return (d.a.o0.h.b.b) invokeV.objValue;
    }

    @JavascriptInterface
    public d.a.o0.h.i.a getDownloadApp(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, jsObject)) == null) {
            if (this.w == null) {
                this.w = new d.a.o0.h.i.a(this.f50400e, d.a.o0.a.y.b.a.G(jsObject));
            }
            return this.w;
        }
        return (d.a.o0.h.i.a) invokeL.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? d.a.o0.a.d1.b.b.a(this.f50400e) : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f50401f == null) {
                this.f50401f = new e((d.a.o0.a.l0.a) this.f50400e);
            }
            return this.f50401f;
        }
        return (e) invokeV.objValue;
    }

    @JavascriptInterface
    public d getOpenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f50402g == null) {
                this.f50402g = new d((d.a.o0.a.l0.a) this.f50400e);
            }
            return this.f50402g;
        }
        return (d) invokeV.objValue;
    }

    @JavascriptInterface
    public d.a.o0.h.z.e getOpenDataContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.j == null) {
                d.a.o0.h.z.e eVar = new d.a.o0.h.z.e(this.f50400e);
                this.j = eVar;
                eVar.canvas = this.f50404i;
                this.f50404i = null;
            }
            return this.j;
        }
        return (d.a.o0.h.z.e) invokeV.objValue;
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) {
            y().k(jsObject);
        }
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, jsObject) == null) {
            y().l(jsObject);
        }
    }

    @JavascriptInterface
    public d.a.o0.h.g0.f.c getStorageInfoSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? y().b() : (d.a.o0.h.g0.f.c) invokeV.objValue;
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? d.a.o0.h.g0.f.d.a(this.f50400e, "getStorageSync", str, y().c(str)) : invokeL.objValue;
    }

    @JavascriptInterface
    public void getSwanGameDuration(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jsObject) == null) {
            d.a.o0.h.j.a.a(jsObject);
        }
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, jsObject) == null) {
            d.a.o0.h.n0.a.d(jsObject);
        }
    }

    @JavascriptInterface
    public d.a.o0.h.l0.d getUpdateManager(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, jsObject)) == null) {
            if (this.n == null) {
                this.n = new d.a.o0.h.l0.d(jsObject);
            }
            return this.n;
        }
        return (d.a.o0.h.l0.d) invokeL.objValue;
    }

    @JavascriptInterface
    public d.a.o0.h.d0.a getVideoRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.r == null) {
                this.r = new d.a.o0.h.d0.a(this.f50400e);
            }
            return this.r;
        }
        return (d.a.o0.h.d0.a) invokeV.objValue;
    }

    @JavascriptInterface
    public d.a.o0.h.o0.h.a getWebViewManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.u == null) {
                this.u = new d.a.o0.h.o0.h.a(this.f50400e);
            }
            return this.u;
        }
        return (d.a.o0.h.o0.h.a) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        d.a.o0.h.u.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.k(jsObject);
    }

    @JavascriptInterface
    public void joinVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) {
            if (this.x == null) {
                this.x = d.a.o0.h.a0.b.f50250a.a();
            }
            this.x.b(jsObject);
        }
    }

    @JavascriptInterface
    public d.a.o0.h.i0.c loadSubpackage(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, jsObject)) == null) {
            d.a.o0.h.i0.c cVar = new d.a.o0.h.i0.c(this.f50400e);
            cVar.F(jsObject);
            return cVar;
        }
        return (d.a.o0.h.i0.c) invokeL.objValue;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        d.a.o0.a.p.b.a.k H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, jsObject) == null) || (H = d.a.o0.a.g1.f.V().H()) == null) {
            return;
        }
        H.a(d.a.o0.a.y.b.a.G(jsObject));
    }

    @JavascriptInterface
    public void offVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, jsObject) == null) {
            if (this.x == null) {
                this.x = d.a.o0.h.a0.b.f50250a.a();
            }
            this.x.a(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jsObject) == null) {
            if (this.x == null) {
                this.x = d.a.o0.h.a0.b.f50250a.a();
            }
            this.x.g(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, jsObject) == null) {
            if (this.x == null) {
                this.x = d.a.o0.h.a0.b.f50250a.a();
            }
            this.x.i(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jsObject) == null) {
            if (this.x == null) {
                this.x = d.a.o0.h.a0.b.f50250a.a();
            }
            this.x.c(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jsObject) == null) {
            if (this.x == null) {
                this.x = d.a.o0.h.a0.b.f50250a.a();
            }
            this.x.h(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, jsObject) == null) {
            if (this.x == null) {
                this.x = d.a.o0.h.a0.b.f50250a.a();
            }
            this.x.k(jsObject);
        }
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, jsObject) == null) {
            d.a.o0.h.g.a.a((b) this.f50400e.p(), jsObject);
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, jsObject) == null) {
            if (this.t == null) {
                this.t = new d.a.o0.h.b0.a();
            }
            this.t.d(jsObject);
        }
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, jsObject) == null) {
            y().o(jsObject);
        }
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            d.a.o0.h.g0.f.d.a(this.f50400e, "removeStorageSync", str, y().e(str));
        }
    }

    @JavascriptInterface
    public d.a.o0.h.y.f.c request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, jsObject)) == null) {
            d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObject);
            d.a.o0.h.y.a d2 = d.a.o0.h.y.e.b.b().d(this.f50400e, G, 1);
            if (d2 instanceof d.a.o0.h.y.f.c) {
                d.a.o0.h.y.f.c cVar = (d.a.o0.h.y.f.c) d2;
                cVar.I(G);
                return cVar;
            }
            d.a.o0.h.y.f.c cVar2 = new d.a.o0.h.y.f.c(this.f50400e, G);
            cVar2.start();
            return cVar2;
        }
        return (d.a.o0.h.y.f.c) invokeL.objValue;
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jsObject) == null) {
            if (this.q == null) {
                this.q = new f(this.f50400e);
            }
            this.q.i(jsObject);
        }
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, jsObject) == null) {
            new h(jsObject);
        }
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Short.valueOf(s)}) == null) || s < 1 || s > 60) {
            return;
        }
        this.f50400e.setPreferredFramesPerSecond(s);
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, jsObject) == null) {
            y().p(jsObject);
        }
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, str, jsSerializeValue) == null) {
            d.a.o0.h.g0.f.d.a(this.f50400e, "setStorageSync", str, y().f(str, jsSerializeValue));
        }
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, jsObject) == null) {
            new d.a.o0.h.e0.b.a(jsObject).m();
        }
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, jsObject) == null) {
            if (this.s == null) {
                this.s = new DesktopGuideApi(this.f50400e);
            }
            this.s.v(jsObject);
        }
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, jsObject) == null) {
            if (this.k == null) {
                this.k = new d.a.o0.h.u.a(this.f50400e, this.l);
            }
            this.k.l(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        d.a.o0.h.u.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, jsObject) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.m(jsObject);
    }

    @JavascriptInterface
    public void updateVoIPChatMuteConfig(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, jsObject) == null) {
            if (this.x == null) {
                this.x = d.a.o0.h.a0.b.f50250a.a();
            }
            this.x.e(jsObject);
        }
    }

    @JavascriptInterface
    public d.a.o0.h.y.g.b uploadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, jsObject)) == null) {
            d.a.o0.h.y.g.b bVar = new d.a.o0.h.y.g.b(this.f50400e, d.a.o0.a.y.b.a.G(jsObject));
            bVar.start();
            return bVar;
        }
        return (d.a.o0.h.y.g.b) invokeL.objValue;
    }

    @NonNull
    public final d.a.o0.h.g0.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.m == null) {
                this.m = new d.a.o0.h.g0.b(this.f50400e);
            }
            return this.m;
        }
        return (d.a.o0.h.g0.b) invokeV.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.l = new d.a.o0.h.u.b(this.f50400e);
        }
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? createRecommendationButton(null) : (RecommendButtonApiProxy) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard() {
        d.a.o0.h.u.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.k(null);
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            d.a.o0.h.g0.f.d.a(this.f50400e, "setStorageSync", str, y().f(str, null));
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        d.a.o0.h.u.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.m(null);
    }

    @JavascriptInterface
    public void reload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            reload(null);
        }
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            showAddToDesktopGuide(null);
        }
    }

    @JavascriptInterface
    public void showKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.k == null) {
                this.k = new d.a.o0.h.u.a(this.f50400e, this.l);
            }
            this.k.l(null);
        }
    }
}
