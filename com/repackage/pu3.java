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
/* loaded from: classes6.dex */
public final class pu3 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public t72 a;
    public kc2 b;
    public rz3 c;
    public pz3 d;
    @V8JavascriptField
    public final String domain;
    public JsObject e;
    @V8JavascriptField
    public gc2 env;
    public sz3 f;
    public ay3 g;
    public by3 h;
    public l14 i;
    public r24 j;
    public nt3 k;
    public fz3 l;
    public bv3 m;
    public d04 n;
    public DesktopGuideApi o;
    public zz3 p;
    public g44 q;
    public tt3 r;
    public lv3 s;
    public xz3 t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755397469, "Lcom/repackage/pu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755397469, "Lcom/repackage/pu3;");
                return;
            }
        }
        u = tg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pu3(t72 t72Var) {
        super(t72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t72Var};
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
        this.a = t72Var;
        this.env = new gc2();
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
            uv3.b(jsObject);
        }
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            if (this.d == null) {
                this.d = new pz3(this.a);
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
            s14.a(this.a, "clearStorageSync", "", y().a());
        }
    }

    @JavascriptInterface
    public hz3 connectSocket(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            if (this.l == null) {
                this.l = new fz3(this.a);
            }
            return this.l.a(jsObject);
        }
        return (hz3) invokeL.objValue;
    }

    @JavascriptInterface
    public lt3 createBannerAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jsObject)) == null) ? new it3(this.a, jsObject) : (lt3) invokeL.objValue;
    }

    @JavascriptInterface
    public fu3 createInnerAudioContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new fu3(this.a) : (fu3) invokeV.objValue;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jsObject)) == null) ? new RecommendButtonApiProxy(this.a, jsObject) : (RecommendButtonApiProxy) invokeL.objValue;
    }

    @JavascriptInterface
    public nt3 createRewardedVideoAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jsObject)) == null) {
            if (this.k == null) {
                this.k = new qt3(this.a, jsObject);
            }
            return this.k;
        }
        return (nt3) invokeL.objValue;
    }

    @JavascriptInterface
    public j24 createUDPSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? m24.c.b(this.a) : (j24) invokeV.objValue;
    }

    @JavascriptInterface
    public i34 createUserInfoButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jsObject)) == null) ? new i34(jsObject, this.a) : (i34) invokeL.objValue;
    }

    @JavascriptInterface
    public sy3 downloadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, jsObject)) == null) {
            qs1 F = qs1.F(jsObject);
            oy3 d = wy3.b().d(this.a, F, 2);
            if (d instanceof sy3) {
                sy3 sy3Var = (sy3) d;
                sy3Var.I(F);
                return sy3Var;
            }
            sy3 sy3Var2 = new sy3(this.a, F);
            sy3Var2.start();
            return sy3Var2;
        }
        return (sy3) invokeL.objValue;
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
            ru3 ru3Var = new ru3();
            qu3 e = qu3.e(qs1.F(jsObject));
            SwanAppActivity activity = wl2.U().getActivity();
            if (activity == null) {
                ru3Var.errMsg = String.format("%s:%s", AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, "failed");
                e.b(ru3Var);
                return;
            }
            ru3Var.errMsg = String.format("%s:%s", AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, "ok");
            e.d(ru3Var);
            activity.finishAndRemoveTask();
        }
    }

    @JavascriptInterface
    public void exitVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            if (this.t == null) {
                this.t = yz3.a.a();
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
                return iw2.p() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
            }
            return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public tt3 getAntiAddiction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.r == null) {
                this.r = new tt3(this.a);
            }
            return this.r;
        }
        return (tt3) invokeV.objValue;
    }

    @JavascriptInterface
    public lv3 getDownloadApp(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, jsObject)) == null) {
            if (this.s == null) {
                this.s = new lv3(this.a, qs1.F(jsObject));
            }
            return this.s;
        }
        return (lv3) invokeL.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? tk2.a(this.a) : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public kc2 getFileSystemManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.b == null) {
                this.b = new kc2((r72) this.a);
            }
            return this.b;
        }
        return (kc2) invokeV.objValue;
    }

    @JavascriptInterface
    public rz3 getOpenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.c == null) {
                this.c = new rz3((r72) this.a);
            }
            return this.c;
        }
        return (rz3) invokeV.objValue;
    }

    @JavascriptInterface
    public sz3 getOpenDataContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f == null) {
                sz3 sz3Var = new sz3(this.a);
                this.f = sz3Var;
                sz3Var.canvas = this.e;
                this.e = null;
            }
            return this.f;
        }
        return (sz3) invokeV.objValue;
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
    public r14 getStorageInfoSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? y().b() : (r14) invokeV.objValue;
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? s14.a(this.a, "getStorageSync", str, y().c(str)) : invokeL.objValue;
    }

    @JavascriptInterface
    public void getSwanGameDuration(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jsObject) == null) {
            pv3.a(jsObject);
        }
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, jsObject) == null) {
            z24.d(jsObject);
        }
    }

    @JavascriptInterface
    public r24 getUpdateManager(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, jsObject)) == null) {
            if (this.j == null) {
                this.j = new r24(jsObject);
            }
            return this.j;
        }
        return (r24) invokeL.objValue;
    }

    @JavascriptInterface
    public d04 getVideoRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.n == null) {
                this.n = new d04(this.a);
            }
            return this.n;
        }
        return (d04) invokeV.objValue;
    }

    @JavascriptInterface
    public g44 getWebViewManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.q == null) {
                this.q = new g44(this.a);
            }
            return this.q;
        }
        return (g44) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        ay3 ay3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) || (ay3Var = this.g) == null) {
            return;
        }
        ay3Var.k(jsObject);
    }

    @JavascriptInterface
    public void joinVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) {
            if (this.t == null) {
                this.t = yz3.a.a();
            }
            this.t.b(jsObject);
        }
    }

    @JavascriptInterface
    public x14 loadSubpackage(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, jsObject)) == null) {
            x14 x14Var = new x14(this.a);
            x14Var.F(jsObject);
            return x14Var;
        }
        return (x14) invokeL.objValue;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        xh1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, jsObject) == null) || (F = wl2.U().F()) == null) {
            return;
        }
        F.a(qs1.F(jsObject));
    }

    @JavascriptInterface
    public void offVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, jsObject) == null) {
            if (this.t == null) {
                this.t = yz3.a.a();
            }
            this.t.a(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jsObject) == null) {
            if (this.t == null) {
                this.t = yz3.a.a();
            }
            this.t.g(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, jsObject) == null) {
            if (this.t == null) {
                this.t = yz3.a.a();
            }
            this.t.i(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jsObject) == null) {
            if (this.t == null) {
                this.t = yz3.a.a();
            }
            this.t.c(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jsObject) == null) {
            if (this.t == null) {
                this.t = yz3.a.a();
            }
            this.t.h(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, jsObject) == null) {
            if (this.t == null) {
                this.t = yz3.a.a();
            }
            this.t.k(jsObject);
        }
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, jsObject) == null) {
            hv3.a((pu3) this.a.p(), jsObject);
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, jsObject) == null) {
            if (this.p == null) {
                this.p = new zz3();
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
            s14.a(this.a, "removeStorageSync", str, y().e(str));
        }
    }

    @JavascriptInterface
    public zy3 request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, jsObject)) == null) {
            qs1 F = qs1.F(jsObject);
            oy3 d = wy3.b().d(this.a, F, 1);
            if (d instanceof zy3) {
                zy3 zy3Var = (zy3) d;
                zy3Var.I(F);
                return zy3Var;
            }
            zy3 zy3Var2 = new zy3(this.a, F);
            zy3Var2.start();
            return zy3Var2;
        }
        return (zy3) invokeL.objValue;
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jsObject) == null) {
            if (this.m == null) {
                this.m = new bv3(this.a);
            }
            this.m.i(jsObject);
        }
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, jsObject) == null) {
            new gu3(jsObject);
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
            s14.a(this.a, "setStorageSync", str, y().f(str, jsSerializeValue));
        }
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, jsObject) == null) {
            new u04(jsObject).m();
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
                this.g = new ay3(this.a, this.h);
            }
            this.g.l(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        ay3 ay3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, jsObject) == null) || (ay3Var = this.g) == null) {
            return;
        }
        ay3Var.m(jsObject);
    }

    @JavascriptInterface
    public void updateVoIPChatMuteConfig(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, jsObject) == null) {
            if (this.t == null) {
                this.t = yz3.a.a();
            }
            this.t.e(jsObject);
        }
    }

    @JavascriptInterface
    public dz3 uploadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, jsObject)) == null) {
            dz3 dz3Var = new dz3(this.a, qs1.F(jsObject));
            dz3Var.start();
            return dz3Var;
        }
        return (dz3) invokeL.objValue;
    }

    @NonNull
    public final l14 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.i == null) {
                this.i = new l14(this.a);
            }
            return this.i;
        }
        return (l14) invokeV.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.h = new by3(this.a);
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
        ay3 ay3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (ay3Var = this.g) == null) {
            return;
        }
        ay3Var.k(null);
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            s14.a(this.a, "setStorageSync", str, y().f(str, null));
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        ay3 ay3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (ay3Var = this.g) == null) {
            return;
        }
        ay3Var.m(null);
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
                this.g = new ay3(this.a, this.h);
            }
            this.g.l(null);
        }
    }
}
