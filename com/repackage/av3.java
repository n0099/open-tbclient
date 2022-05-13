package com.repackage;

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
import com.baidu.tieba.account.AccountRestoreActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class av3 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public e82 a;
    public vc2 b;
    public c04 c;
    public a04 d;
    @V8JavascriptField
    public final String domain;
    public JsObject e;
    @V8JavascriptField
    public rc2 env;
    public d04 f;
    public ly3 g;
    public my3 h;
    public w14 i;
    public c34 j;
    public yt3 k;
    public qz3 l;
    public mv3 m;
    public o04 n;
    public DesktopGuideApi o;
    public k04 p;
    public r44 q;
    public eu3 r;
    public wv3 s;
    public i04 t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755843373, "Lcom/repackage/av3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755843373, "Lcom/repackage/av3;");
                return;
            }
        }
        u = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av3(e82 e82Var) {
        super(e82Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e82Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.domain = "main";
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.a = e82Var;
        this.env = new rc2();
        z();
    }

    public void A(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) {
            this.e = jsObject;
        }
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            fw3.b(jsObject);
        }
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            if (this.d == null) {
                this.d = new a04(this.a);
            }
            this.d.checkIsUserAdvisedToRest(jsObject);
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
            d24.a(this.a, "clearStorageSync", "", y().a());
        }
    }

    @JavascriptInterface
    public sz3 connectSocket(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            if (this.l == null) {
                this.l = new qz3(this.a);
            }
            return this.l.a(jsObject);
        }
        return (sz3) invokeL.objValue;
    }

    @JavascriptInterface
    public wt3 createBannerAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jsObject)) == null) ? new tt3(this.a, jsObject) : (wt3) invokeL.objValue;
    }

    @JavascriptInterface
    public qu3 createInnerAudioContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new qu3(this.a) : (qu3) invokeV.objValue;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jsObject)) == null) ? new RecommendButtonApiProxy(this.a, jsObject) : (RecommendButtonApiProxy) invokeL.objValue;
    }

    @JavascriptInterface
    public yt3 createRewardedVideoAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jsObject)) == null) {
            if (this.k == null) {
                this.k = new bu3(this.a, jsObject);
            }
            return this.k;
        }
        return (yt3) invokeL.objValue;
    }

    @JavascriptInterface
    public u24 createUDPSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? x24.c.b(this.a) : (u24) invokeV.objValue;
    }

    @JavascriptInterface
    public t34 createUserInfoButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jsObject)) == null) ? new t34(jsObject, this.a) : (t34) invokeL.objValue;
    }

    @JavascriptInterface
    public dz3 downloadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, jsObject)) == null) {
            bt1 F = bt1.F(jsObject);
            zy3 d = hz3.b().d(this.a, F, 2);
            if (d instanceof dz3) {
                dz3 dz3Var = (dz3) d;
                dz3Var.I(F);
                return dz3Var;
            }
            dz3 dz3Var2 = new dz3(this.a, F);
            dz3Var2.start();
            return dz3Var2;
        }
        return (dz3) invokeL.objValue;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            if (u) {
                this.a.A().b("exit from java side.");
            }
            if (jsObject == null) {
                return;
            }
            cv3 cv3Var = new cv3();
            bv3 e = bv3.e(bt1.F(jsObject));
            SwanAppActivity activity = hm2.U().getActivity();
            if (activity == null) {
                cv3Var.errMsg = String.format("%s:%s", AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, "failed");
                e.b(cv3Var);
                return;
            }
            cv3Var.errMsg = String.format("%s:%s", AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, "ok");
            e.d(cv3Var);
            activity.finishAndRemoveTask();
        }
    }

    @JavascriptInterface
    public void exitVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            if (this.t == null) {
                this.t = j04.a.a();
            }
            this.t.d(jsObject);
        }
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (u) {
                return tw2.p() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
            }
            return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public eu3 getAntiAddiction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.r == null) {
                this.r = new eu3(this.a);
            }
            return this.r;
        }
        return (eu3) invokeV.objValue;
    }

    @JavascriptInterface
    public wv3 getDownloadApp(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, jsObject)) == null) {
            if (this.s == null) {
                this.s = new wv3(this.a, bt1.F(jsObject));
            }
            return this.s;
        }
        return (wv3) invokeL.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? el2.a(this.a) : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public vc2 getFileSystemManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.b == null) {
                this.b = new vc2((c82) this.a);
            }
            return this.b;
        }
        return (vc2) invokeV.objValue;
    }

    @JavascriptInterface
    public c04 getOpenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.c == null) {
                this.c = new c04((c82) this.a);
            }
            return this.c;
        }
        return (c04) invokeV.objValue;
    }

    @JavascriptInterface
    public d04 getOpenDataContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f == null) {
                d04 d04Var = new d04(this.a);
                this.f = d04Var;
                d04Var.canvas = this.e;
                this.e = null;
            }
            return this.f;
        }
        return (d04) invokeV.objValue;
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
    public c24 getStorageInfoSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? y().b() : (c24) invokeV.objValue;
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? d24.a(this.a, "getStorageSync", str, y().c(str)) : invokeL.objValue;
    }

    @JavascriptInterface
    public void getSwanGameDuration(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jsObject) == null) {
            aw3.a(jsObject);
        }
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, jsObject) == null) {
            k34.d(jsObject);
        }
    }

    @JavascriptInterface
    public c34 getUpdateManager(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, jsObject)) == null) {
            if (this.j == null) {
                this.j = new c34(jsObject);
            }
            return this.j;
        }
        return (c34) invokeL.objValue;
    }

    @JavascriptInterface
    public o04 getVideoRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.n == null) {
                this.n = new o04(this.a);
            }
            return this.n;
        }
        return (o04) invokeV.objValue;
    }

    @JavascriptInterface
    public r44 getWebViewManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.q == null) {
                this.q = new r44(this.a);
            }
            return this.q;
        }
        return (r44) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        ly3 ly3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) || (ly3Var = this.g) == null) {
            return;
        }
        ly3Var.k(jsObject);
    }

    @JavascriptInterface
    public void joinVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) {
            if (this.t == null) {
                this.t = j04.a.a();
            }
            this.t.b(jsObject);
        }
    }

    @JavascriptInterface
    public i24 loadSubpackage(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, jsObject)) == null) {
            i24 i24Var = new i24(this.a);
            i24Var.F(jsObject);
            return i24Var;
        }
        return (i24) invokeL.objValue;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        ii1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, jsObject) == null) || (F = hm2.U().F()) == null) {
            return;
        }
        F.a(bt1.F(jsObject));
    }

    @JavascriptInterface
    public void offVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, jsObject) == null) {
            if (this.t == null) {
                this.t = j04.a.a();
            }
            this.t.a(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jsObject) == null) {
            if (this.t == null) {
                this.t = j04.a.a();
            }
            this.t.g(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, jsObject) == null) {
            if (this.t == null) {
                this.t = j04.a.a();
            }
            this.t.i(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jsObject) == null) {
            if (this.t == null) {
                this.t = j04.a.a();
            }
            this.t.c(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jsObject) == null) {
            if (this.t == null) {
                this.t = j04.a.a();
            }
            this.t.h(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, jsObject) == null) {
            if (this.t == null) {
                this.t = j04.a.a();
            }
            this.t.k(jsObject);
        }
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, jsObject) == null) {
            sv3.a((av3) this.a.p(), jsObject);
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, jsObject) == null) {
            if (this.p == null) {
                this.p = new k04();
            }
            this.p.d(jsObject);
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
            d24.a(this.a, "removeStorageSync", str, y().e(str));
        }
    }

    @JavascriptInterface
    public kz3 request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, jsObject)) == null) {
            bt1 F = bt1.F(jsObject);
            zy3 d = hz3.b().d(this.a, F, 1);
            if (d instanceof kz3) {
                kz3 kz3Var = (kz3) d;
                kz3Var.I(F);
                return kz3Var;
            }
            kz3 kz3Var2 = new kz3(this.a, F);
            kz3Var2.start();
            return kz3Var2;
        }
        return (kz3) invokeL.objValue;
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jsObject) == null) {
            if (this.m == null) {
                this.m = new mv3(this.a);
            }
            this.m.i(jsObject);
        }
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, jsObject) == null) {
            new ru3(jsObject);
        }
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Short.valueOf(s)}) == null) || s < 1 || s > 60) {
            return;
        }
        this.a.setPreferredFramesPerSecond(s);
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
            d24.a(this.a, "setStorageSync", str, y().f(str, jsSerializeValue));
        }
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, jsObject) == null) {
            new f14(jsObject).m();
        }
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, jsObject) == null) {
            if (this.o == null) {
                this.o = new DesktopGuideApi(this.a);
            }
            this.o.v(jsObject);
        }
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, jsObject) == null) {
            if (this.g == null) {
                this.g = new ly3(this.a, this.h);
            }
            this.g.l(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        ly3 ly3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, jsObject) == null) || (ly3Var = this.g) == null) {
            return;
        }
        ly3Var.m(jsObject);
    }

    @JavascriptInterface
    public void updateVoIPChatMuteConfig(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, jsObject) == null) {
            if (this.t == null) {
                this.t = j04.a.a();
            }
            this.t.e(jsObject);
        }
    }

    @JavascriptInterface
    public oz3 uploadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, jsObject)) == null) {
            oz3 oz3Var = new oz3(this.a, bt1.F(jsObject));
            oz3Var.start();
            return oz3Var;
        }
        return (oz3) invokeL.objValue;
    }

    @NonNull
    public final w14 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.i == null) {
                this.i = new w14(this.a);
            }
            return this.i;
        }
        return (w14) invokeV.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.h = new my3(this.a);
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
        ly3 ly3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (ly3Var = this.g) == null) {
            return;
        }
        ly3Var.k(null);
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            d24.a(this.a, "setStorageSync", str, y().f(str, null));
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        ly3 ly3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (ly3Var = this.g) == null) {
            return;
        }
        ly3Var.m(null);
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
            if (this.g == null) {
                this.g = new ly3(this.a, this.h);
            }
            this.g.l(null);
        }
    }
}
