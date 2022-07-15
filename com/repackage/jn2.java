package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.media.audio.SwanAppAudioClient;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.el2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static n63 j;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppAudioClient a;
    public Context b;
    public hn2 c;
    public nn2 d;
    public int e;
    public int f;
    public boolean g;
    @Nullable
    public pl2 h;

    /* loaded from: classes6.dex */
    public class a extends pl2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn2 a;

        public a(jn2 jn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn2Var;
        }

        @Override // com.repackage.pl2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                this.a.g = false;
                if (this.a.x()) {
                    return;
                }
                this.a.p();
            }
        }

        @Override // com.repackage.pl2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                this.a.g = true;
                if (this.a.w()) {
                    if (this.a.x()) {
                        n63 unused = jn2.j = null;
                        return;
                    } else if (jn2.j == null) {
                        n63 unused2 = jn2.j = a73.c("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                this.a.L();
                hx1.o("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements af3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn2 a;

        public b(jn2 jn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    this.a.v().v(this.a.c.c(str), str);
                } else if (TextUtils.isEmpty(str)) {
                    n73.b("audio", 3001, "cloud url is null", -1, "");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements SwanAppAudioClient.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ jn2 b;

        public c(jn2 jn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jn2Var;
        }

        @Override // com.baidu.swan.apps.media.audio.SwanAppAudioClient.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                int i2 = message.arg1;
                int i3 = message.arg2;
                JSONObject jSONObject = new JSONObject();
                this.b.H(message, i3, this.b.u() / 1000);
                switch (i) {
                    case 1001:
                        kn2.b("SwanAppBGAudioPlayer", "#onHandleMessage [onCanPlay]");
                        hx1.i("backgroundAudio", "event onCanPlay");
                        if (this.b.d != null) {
                            this.b.d.a("onCanplay");
                        }
                        this.a = true;
                        return true;
                    case 1002:
                        kn2.b("SwanAppBGAudioPlayer", "#onHandleMessage [onPlay]");
                        hx1.i("backgroundAudio", "event onPlay");
                        if (this.b.d != null) {
                            this.b.d.a("onPlay");
                        }
                        if (this.b.g) {
                            n63 unused = jn2.j = a73.c("1044");
                        }
                        return true;
                    case 1003:
                        kn2.b("SwanAppBGAudioPlayer", "#onHandleMessage [onPause]");
                        hx1.i("backgroundAudio", "event onPause");
                        if (this.b.d != null) {
                            this.b.d.a(MissionEvent.MESSAGE_PAUSE);
                        }
                        if (this.b.g) {
                            this.b.p();
                        }
                        return true;
                    case 1004:
                        kn2.b("SwanAppBGAudioPlayer", "#onHandleMessage [onStop]");
                        hx1.i("backgroundAudio", "event onStop");
                        if (this.b.d != null) {
                            this.b.d.a(MissionEvent.MESSAGE_STOP);
                        }
                        this.a = true;
                        if (this.b.g) {
                            this.b.p();
                        }
                        return true;
                    case 1005:
                        hx1.i("backgroundAudio", "event onEnd");
                        if (this.b.d != null) {
                            this.b.d.a("onEnded");
                        }
                        if (this.b.g) {
                            this.b.p();
                        }
                        return true;
                    case 1006:
                        this.b.e = i3;
                        try {
                            jSONObject.putOpt("currentTime", Integer.valueOf(this.b.r()));
                            jSONObject.putOpt("duration", Integer.valueOf(this.b.u() / 1000));
                        } catch (JSONException e) {
                            if (jn2.i) {
                                e.printStackTrace();
                            }
                        }
                        hx1.i("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                        if (this.b.d != null) {
                            this.b.d.b("onTimeUpdate", jSONObject);
                        }
                        if (this.a) {
                            if (this.b.c.k > 0) {
                                jn2 jn2Var = this.b;
                                jn2Var.G(jn2Var.c.k);
                            }
                            this.a = false;
                        }
                        return true;
                    case 1007:
                        try {
                            n73.b("audio", 4000, "audio fail, src: " + this.b.v().q(), i2, "");
                            jSONObject.putOpt(StatConstants.KEY_EXT_ERR_CODE, Integer.valueOf(i2));
                        } catch (JSONException e2) {
                            if (jn2.i) {
                                e2.printStackTrace();
                            }
                        }
                        hx1.i("backgroundAudio", "event onError code:" + i2);
                        if (this.b.d != null) {
                            this.b.d.b("onError", jSONObject);
                        }
                        return true;
                    case 1008:
                        int s = this.b.s();
                        this.b.f = i2;
                        hx1.i("backgroundAudio", "event onDownloadProgress " + this.b.f);
                        if (this.b.d != null && s >= this.b.f) {
                            this.b.d.a("onWaiting");
                        }
                        return true;
                    case 1009:
                        hx1.i("backgroundAudio", "event onPrev");
                        if (this.b.d != null) {
                            this.b.d.a("onPrev");
                        }
                        return true;
                    case 1010:
                        hx1.i("backgroundAudio", "event onNext");
                        if (this.b.d != null) {
                            this.b.d.a("onNext");
                        }
                        return true;
                    case 1011:
                        hx1.i("backgroundAudio", "event onSeekEnd");
                        if (this.b.d != null) {
                            this.b.d.a("onSeeked");
                        }
                        return true;
                    case 1012:
                        hx1.i("backgroundAudio", "event onSeeking");
                        if (this.b.d != null) {
                            this.b.d.a("onSeeking");
                        }
                        return true;
                    default:
                        return false;
                }
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ c(jn2 jn2Var, a aVar) {
            this(jn2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755582973, "Lcom/repackage/jn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755582973, "Lcom/repackage/jn2;");
                return;
            }
        }
        i = rg1.a;
    }

    public jn2(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new hn2();
        this.e = 0;
        this.f = 0;
        this.b = context;
    }

    public void A() {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppAudioClient = this.a) == null) {
            return;
        }
        swanAppAudioClient.u();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (i) {
                Log.d("SwanAppBGAudioPlayer", "play");
            }
            if (this.c.a()) {
                return;
            }
            K();
            String str = this.c.c;
            h03 M = h03.M();
            if (p73.s(str) == PathType.CLOUD) {
                C(str);
            } else {
                D(str, M);
            }
            J("#play");
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            oj2.l().b(this.b, str, new b(this));
        }
    }

    public final void D(String str, h03 h03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, h03Var) == null) {
            if (this.c.q && h03Var != null) {
                wh1 m = pj2.m();
                if (this.d.c()) {
                    str = m == null ? null : m.a(str);
                } else {
                    str = p73.H(str, h03Var);
                }
            }
            v().v(this.c.c(str), str);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hx1.i("backgroundAudio", "release ");
            if (this.a == null || w()) {
                return;
            }
            this.a.w();
            I("#release");
            this.a = null;
            j = null;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (i) {
                Log.d("SwanAppBGAudioPlayer", "play");
            }
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.y();
            }
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 < 0) {
            return;
        }
        SwanAppAudioClient swanAppAudioClient = this.a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.z(i2 * 1000);
        }
        hx1.i("backgroundAudio", "seekTo " + i2);
        nn2 nn2Var = this.d;
        if (nn2Var != null) {
            nn2Var.a("onSeeking");
        }
    }

    public final void H(Message message, int i2, int i3) {
        hn2 hn2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, message, i2, i3) == null) && (hn2Var = this.c) != null && hn2Var.i) {
            hn2Var.n = i2;
            hn2Var.o = i3;
            oj2.o().x(message, this.c);
        }
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            kn2.c("SwanAppBGAudioPlayer", "#policyContinueFlag", new Exception(str));
            ul2.U().c();
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            kn2.c("SwanAppBGAudioPlayer", "#setPolicyStopFlag", new Exception(str));
            ul2.U().p();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.h != null) {
                oj2.c().unregisterActivityLifecycleCallbacks(this.h);
            }
            this.h = new a(this);
            oj2.c().registerActivityLifecycleCallbacks(this.h);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.B();
            }
            if (this.h != null) {
                oj2.c().unregisterActivityLifecycleCallbacks(this.h);
                this.h = null;
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (h03.M() != null && h03.M().Y() != null && j != null) {
                el2.a Y = h03.M().Y();
                k73 k73Var = new k73();
                k73Var.a = a73.n(Y.G());
                k73Var.f = Y.H();
                k73Var.c = Y.T();
                k73Var.a("appid", Y.H());
                k73Var.a("cuid", oj2.h0().i(oj2.c()));
                JSONObject k = a73.k(Y.W());
                if (k != null) {
                    k73Var.a("keyfeed", k.optString("keyfeed"));
                }
                a73.i(j, k73Var);
            }
            j = null;
        }
    }

    public hn2 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.c : (hn2) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.e : invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int u = u();
            if (u <= 0) {
                return 0;
            }
            return (int) ((r() / u) * 100.0f);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object t(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            switch (str.hashCode()) {
                case -2129294769:
                    if (str.equals(FetchLog.START_TIME)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1992012396:
                    if (str.equals("duration")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1522036513:
                    if (str.equals("buffered")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1296614986:
                    if (str.equals("epname")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1094703982:
                    if (str.equals("lrcURL")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -995321554:
                    if (str.equals("paused")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -902265988:
                    if (str.equals("singer")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -453814973:
                    if (str.equals("coverImgUrl")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 114148:
                    if (str.equals("src")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 110371416:
                    if (str.equals("title")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 601235430:
                    if (str.equals("currentTime")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    return Integer.valueOf(u() / 1000);
                case 1:
                    return Integer.valueOf(this.e);
                case 2:
                    return Boolean.valueOf(x());
                case 3:
                    return this.c.c;
                case 4:
                    return Integer.valueOf(this.c.k);
                case 5:
                    return Integer.valueOf(this.f);
                case 6:
                    return this.c.d;
                case 7:
                    return this.c.e;
                case '\b':
                    return this.c.f;
                case '\t':
                    return this.c.g;
                case '\n':
                    return this.c.h;
                default:
                    return "";
            }
        }
        return invokeL.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                return swanAppAudioClient.r();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void update(hn2 hn2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hn2Var) == null) {
            if (i) {
                Log.d("SwanAppBGAudioPlayer", "Audio Update : " + hn2Var);
            }
            this.c = hn2Var;
            nn2 nn2Var = this.d;
            if (nn2Var != null) {
                nn2Var.d(hn2Var.p);
            }
            B();
        }
    }

    public final SwanAppAudioClient v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.a == null) {
                this.a = new SwanAppAudioClient(this.b);
                this.a.A(new c(this, null));
            }
            return this.a;
        }
        return (SwanAppAudioClient) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            SwanAppConfigData Q = h03.M() != null ? h03.M().Q() : null;
            return Q != null && Q.q.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO.mMode);
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.a;
            if (swanAppAudioClient != null) {
                return !swanAppAudioClient.s();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y(boolean z) {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (swanAppAudioClient = this.a) == null) {
            return;
        }
        swanAppAudioClient.t(z);
        J("#onForegroundChanged foreground=" + z);
    }

    public void z(hn2 hn2Var, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, hn2Var, callbackHandler) == null) {
            kn2.b("SwanAppBGAudioPlayer", "#openPlayer params=" + hn2Var);
            this.c = hn2Var;
            if (hn2Var.p != null) {
                try {
                    this.d = new nn2(callbackHandler, new JSONObject(this.c.p));
                } catch (JSONException e) {
                    n73.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "open audio fail", -1, "");
                    hx1.c("backgroundAudio", e.toString());
                    if (i) {
                        Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                    }
                }
            }
            B();
        }
    }
}
