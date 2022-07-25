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
public final class ou3 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public s72 a;
    public jc2 b;
    public qz3 c;
    public oz3 d;
    @V8JavascriptField
    public final String domain;
    public JsObject e;
    @V8JavascriptField
    public fc2 env;
    public rz3 f;
    public zx3 g;
    public ay3 h;
    public k14 i;
    public q24 j;
    public mt3 k;
    public ez3 l;
    public av3 m;
    public c04 n;
    public DesktopGuideApi o;
    public yz3 p;
    public f44 q;
    public st3 r;
    public kv3 s;
    public wz3 t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755427260, "Lcom/repackage/ou3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755427260, "Lcom/repackage/ou3;");
                return;
            }
        }
        u = sg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ou3(s72 s72Var) {
        super(s72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s72Var};
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
        this.a = s72Var;
        this.env = new fc2();
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
            tv3.b(jsObject);
        }
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            if (this.d == null) {
                this.d = new oz3(this.a);
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
            r14.a(this.a, "clearStorageSync", "", y().a());
        }
    }

    @JavascriptInterface
    public gz3 connectSocket(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            if (this.l == null) {
                this.l = new ez3(this.a);
            }
            return this.l.a(jsObject);
        }
        return (gz3) invokeL.objValue;
    }

    @JavascriptInterface
    public kt3 createBannerAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jsObject)) == null) ? new ht3(this.a, jsObject) : (kt3) invokeL.objValue;
    }

    @JavascriptInterface
    public eu3 createInnerAudioContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new eu3(this.a) : (eu3) invokeV.objValue;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jsObject)) == null) ? new RecommendButtonApiProxy(this.a, jsObject) : (RecommendButtonApiProxy) invokeL.objValue;
    }

    @JavascriptInterface
    public mt3 createRewardedVideoAd(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jsObject)) == null) {
            if (this.k == null) {
                this.k = new pt3(this.a, jsObject);
            }
            return this.k;
        }
        return (mt3) invokeL.objValue;
    }

    @JavascriptInterface
    public i24 createUDPSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? l24.c.b(this.a) : (i24) invokeV.objValue;
    }

    @JavascriptInterface
    public h34 createUserInfoButton(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, jsObject)) == null) ? new h34(jsObject, this.a) : (h34) invokeL.objValue;
    }

    @JavascriptInterface
    public ry3 downloadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, jsObject)) == null) {
            ps1 F = ps1.F(jsObject);
            ny3 d = vy3.b().d(this.a, F, 2);
            if (d instanceof ry3) {
                ry3 ry3Var = (ry3) d;
                ry3Var.I(F);
                return ry3Var;
            }
            ry3 ry3Var2 = new ry3(this.a, F);
            ry3Var2.start();
            return ry3Var2;
        }
        return (ry3) invokeL.objValue;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            if (u) {
                this.a.z().b("exit from java side.");
            }
            if (jsObject == null) {
                return;
            }
            qu3 qu3Var = new qu3();
            pu3 e = pu3.e(ps1.F(jsObject));
            SwanAppActivity activity = vl2.U().getActivity();
            if (activity == null) {
                qu3Var.errMsg = String.format("%s:%s", AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, "failed");
                e.b(qu3Var);
                return;
            }
            qu3Var.errMsg = String.format("%s:%s", AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, "ok");
            e.d(qu3Var);
            activity.finishAndRemoveTask();
        }
    }

    @JavascriptInterface
    public void exitVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xz3.a.a();
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
                return hw2.p() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
            }
            return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public st3 getAntiAddiction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.r == null) {
                this.r = new st3(this.a);
            }
            return this.r;
        }
        return (st3) invokeV.objValue;
    }

    @JavascriptInterface
    public kv3 getDownloadApp(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, jsObject)) == null) {
            if (this.s == null) {
                this.s = new kv3(this.a, ps1.F(jsObject));
            }
            return this.s;
        }
        return (kv3) invokeL.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? sk2.a(this.a) : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public jc2 getFileSystemManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.b == null) {
                this.b = new jc2((q72) this.a);
            }
            return this.b;
        }
        return (jc2) invokeV.objValue;
    }

    @JavascriptInterface
    public qz3 getOpenData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.c == null) {
                this.c = new qz3((q72) this.a);
            }
            return this.c;
        }
        return (qz3) invokeV.objValue;
    }

    @JavascriptInterface
    public rz3 getOpenDataContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f == null) {
                rz3 rz3Var = new rz3(this.a);
                this.f = rz3Var;
                rz3Var.canvas = this.e;
                this.e = null;
            }
            return this.f;
        }
        return (rz3) invokeV.objValue;
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
    public q14 getStorageInfoSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? y().b() : (q14) invokeV.objValue;
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? r14.a(this.a, "getStorageSync", str, y().c(str)) : invokeL.objValue;
    }

    @JavascriptInterface
    public void getSwanGameDuration(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jsObject) == null) {
            ov3.a(jsObject);
        }
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, jsObject) == null) {
            y24.d(jsObject);
        }
    }

    @JavascriptInterface
    public q24 getUpdateManager(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, jsObject)) == null) {
            if (this.j == null) {
                this.j = new q24(jsObject);
            }
            return this.j;
        }
        return (q24) invokeL.objValue;
    }

    @JavascriptInterface
    public c04 getVideoRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.n == null) {
                this.n = new c04(this.a);
            }
            return this.n;
        }
        return (c04) invokeV.objValue;
    }

    @JavascriptInterface
    public f44 getWebViewManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.q == null) {
                this.q = new f44(this.a);
            }
            return this.q;
        }
        return (f44) invokeV.objValue;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        zx3 zx3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) || (zx3Var = this.g) == null) {
            return;
        }
        zx3Var.k(jsObject);
    }

    @JavascriptInterface
    public void joinVoIPChat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xz3.a.a();
            }
            this.t.b(jsObject);
        }
    }

    @JavascriptInterface
    public w14 loadSubpackage(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, jsObject)) == null) {
            w14 w14Var = new w14(this.a);
            w14Var.F(jsObject);
            return w14Var;
        }
        return (w14) invokeL.objValue;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        wh1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, jsObject) == null) || (F = vl2.U().F()) == null) {
            return;
        }
        F.a(ps1.F(jsObject));
    }

    @JavascriptInterface
    public void offVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xz3.a.a();
            }
            this.t.a(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xz3.a.a();
            }
            this.t.g(jsObject);
        }
    }

    @JavascriptInterface
    public void offVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xz3.a.a();
            }
            this.t.i(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatInterrupted(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xz3.a.a();
            }
            this.t.c(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatMembersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xz3.a.a();
            }
            this.t.h(jsObject);
        }
    }

    @JavascriptInterface
    public void onVoIPChatSpeakersChanged(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xz3.a.a();
            }
            this.t.k(jsObject);
        }
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, jsObject) == null) {
            gv3.a((ou3) this.a.o(), jsObject);
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, jsObject) == null) {
            if (this.p == null) {
                this.p = new yz3();
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
            r14.a(this.a, "removeStorageSync", str, y().e(str));
        }
    }

    @JavascriptInterface
    public yy3 request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, jsObject)) == null) {
            ps1 F = ps1.F(jsObject);
            ny3 d = vy3.b().d(this.a, F, 1);
            if (d instanceof yy3) {
                yy3 yy3Var = (yy3) d;
                yy3Var.I(F);
                return yy3Var;
            }
            yy3 yy3Var2 = new yy3(this.a, F);
            yy3Var2.start();
            return yy3Var2;
        }
        return (yy3) invokeL.objValue;
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jsObject) == null) {
            if (this.m == null) {
                this.m = new av3(this.a);
            }
            this.m.i(jsObject);
        }
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, jsObject) == null) {
            new fu3(jsObject);
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
            r14.a(this.a, "setStorageSync", str, y().f(str, jsSerializeValue));
        }
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, jsObject) == null) {
            new t04(jsObject).m();
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
                this.g = new zx3(this.a, this.h);
            }
            this.g.l(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        zx3 zx3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, jsObject) == null) || (zx3Var = this.g) == null) {
            return;
        }
        zx3Var.m(jsObject);
    }

    @JavascriptInterface
    public void updateVoIPChatMuteConfig(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, jsObject) == null) {
            if (this.t == null) {
                this.t = xz3.a.a();
            }
            this.t.e(jsObject);
        }
    }

    @JavascriptInterface
    public cz3 uploadFile(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, jsObject)) == null) {
            cz3 cz3Var = new cz3(this.a, ps1.F(jsObject));
            cz3Var.start();
            return cz3Var;
        }
        return (cz3) invokeL.objValue;
    }

    @NonNull
    public final k14 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.i == null) {
                this.i = new k14(this.a);
            }
            return this.i;
        }
        return (k14) invokeV.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.h = new ay3(this.a);
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
        zx3 zx3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (zx3Var = this.g) == null) {
            return;
        }
        zx3Var.k(null);
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            r14.a(this.a, "setStorageSync", str, y().f(str, null));
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        zx3 zx3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (zx3Var = this.g) == null) {
            return;
        }
        zx3Var.m(null);
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
                this.g = new zx3(this.a, this.h);
            }
            this.g.l(null);
        }
    }
}
