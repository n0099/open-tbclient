package d.a.o0.a.i1.c;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.wallet.router.RouterCallback;
import d.a.o0.a.a2.e;
import d.a.o0.a.e0.d;
import d.a.o0.a.f1.e.b;
import d.a.o0.a.g1.f;
import d.a.o0.a.j2.k;
import d.a.o0.a.p.b.a.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45864i;
    public static d.a.o0.a.j2.a j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppAudioClient f45865a;

    /* renamed from: b  reason: collision with root package name */
    public Context f45866b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.a.i1.c.a f45867c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.a.i1.c.e.a f45868d;

    /* renamed from: e  reason: collision with root package name */
    public int f45869e;

    /* renamed from: f  reason: collision with root package name */
    public int f45870f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45871g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.a.g1.a f45872h;

    /* loaded from: classes7.dex */
    public class a extends d.a.o0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f45873e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45873e = cVar;
        }

        @Override // d.a.o0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                this.f45873e.f45871g = false;
                if (this.f45873e.x()) {
                    return;
                }
                this.f45873e.p();
            }
        }

        @Override // d.a.o0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                this.f45873e.f45871g = true;
                if (this.f45873e.w()) {
                    if (this.f45873e.x()) {
                        d.a.o0.a.j2.a unused = c.j = null;
                        return;
                    } else if (c.j == null) {
                        d.a.o0.a.j2.a unused2 = c.j = k.c("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                this.f45873e.J();
                d.l("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f45874e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45874e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f45874e.v().v(this.f45874e.f45867c.c(str), str);
        }
    }

    /* renamed from: d.a.o0.a.i1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0781c implements SwanAppAudioClient.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f45875a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f45876b;

        public C0781c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45876b = cVar;
        }

        @Override // com.baidu.swan.apps.media.audio.SwanAppAudioClient.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                int i3 = message.arg1;
                int i4 = message.arg2;
                JSONObject jSONObject = new JSONObject();
                this.f45876b.H(message, i4, this.f45876b.u() / 1000);
                switch (i2) {
                    case 1001:
                        d.g("backgroundAudio", "event onCanPlay");
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.a("onCanplay");
                        }
                        this.f45875a = true;
                        return true;
                    case 1002:
                        d.g("backgroundAudio", "event onPlay");
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.a("onPlay");
                        }
                        if (this.f45876b.f45871g) {
                            d.a.o0.a.j2.a unused = c.j = k.c("1044");
                        }
                        return true;
                    case 1003:
                        d.g("backgroundAudio", "event onPause");
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.a(MissionEvent.MESSAGE_PAUSE);
                        }
                        if (this.f45876b.f45871g) {
                            this.f45876b.p();
                        }
                        return true;
                    case 1004:
                        d.g("backgroundAudio", "event onStop");
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.a(MissionEvent.MESSAGE_STOP);
                        }
                        this.f45875a = true;
                        if (this.f45876b.f45871g) {
                            this.f45876b.p();
                        }
                        return true;
                    case 1005:
                        d.g("backgroundAudio", "event onEnd");
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.a("onEnded");
                        }
                        if (this.f45876b.f45871g) {
                            this.f45876b.p();
                        }
                        return true;
                    case 1006:
                        this.f45876b.f45869e = i4;
                        try {
                            jSONObject.putOpt("currentTime", Integer.valueOf(this.f45876b.r()));
                            jSONObject.putOpt("duration", Integer.valueOf(this.f45876b.u() / 1000));
                        } catch (JSONException e2) {
                            if (c.f45864i) {
                                e2.printStackTrace();
                            }
                        }
                        d.g("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.b("onTimeUpdate", jSONObject);
                        }
                        if (this.f45875a) {
                            if (this.f45876b.f45867c.k > 0) {
                                c cVar = this.f45876b;
                                cVar.G(cVar.f45867c.k);
                            }
                            this.f45875a = false;
                        }
                        return true;
                    case 1007:
                        try {
                            jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, Integer.valueOf(i3));
                        } catch (JSONException e3) {
                            if (c.f45864i) {
                                e3.printStackTrace();
                            }
                        }
                        d.g("backgroundAudio", "event onError code:" + i3);
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.b("onError", jSONObject);
                        }
                        return true;
                    case 1008:
                        int s = this.f45876b.s();
                        this.f45876b.f45870f = i3;
                        d.g("backgroundAudio", "event onDownloadProgress " + this.f45876b.f45870f);
                        if (this.f45876b.f45868d != null && s >= this.f45876b.f45870f) {
                            this.f45876b.f45868d.a("onWaiting");
                        }
                        return true;
                    case 1009:
                        d.g("backgroundAudio", "event onPrev");
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.a("onPrev");
                        }
                        return true;
                    case 1010:
                        d.g("backgroundAudio", "event onNext");
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.a("onNext");
                        }
                        return true;
                    case 1011:
                        d.g("backgroundAudio", "event onSeekEnd");
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.a("onSeeked");
                        }
                        return true;
                    case 1012:
                        d.g("backgroundAudio", "event onSeeking");
                        if (this.f45876b.f45868d != null) {
                            this.f45876b.f45868d.a("onSeeking");
                        }
                        return true;
                    default:
                        return false;
                }
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ C0781c(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1363265492, "Ld/a/o0/a/i1/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1363265492, "Ld/a/o0/a/i1/c/c;");
                return;
            }
        }
        f45864i = d.a.o0.a.k.f46335a;
    }

    public c(Context context) {
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
        this.f45867c = new d.a.o0.a.i1.c.a();
        this.f45869e = 0;
        this.f45870f = 0;
        this.f45866b = context;
    }

    public void A() {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppAudioClient = this.f45865a) == null) {
            return;
        }
        swanAppAudioClient.u();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f45864i) {
                Log.d("SwanAppBGAudioPlayer", "play");
            }
            if (this.f45867c.a()) {
                return;
            }
            I();
            String str = this.f45867c.f45848c;
            e i2 = e.i();
            if (d.a.o0.a.k2.b.s(str) == PathType.CLOUD) {
                C(str);
            } else {
                D(str, i2);
            }
            f.V().p();
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            d.a.o0.a.c1.a.k().b(this.f45866b, str, new b(this));
        }
    }

    public final void D(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
            if (this.f45867c.q && eVar != null) {
                l m = d.a.o0.a.c1.b.m();
                if (this.f45868d.c()) {
                    str = m == null ? null : m.a(str);
                } else {
                    str = d.a.o0.a.k2.b.H(str, eVar);
                }
            }
            v().v(this.f45867c.c(str), str);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.g("backgroundAudio", "release ");
            if (this.f45865a == null || w()) {
                return;
            }
            this.f45865a.w();
            f.V().b();
            this.f45865a = null;
            j = null;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f45864i) {
                Log.d("SwanAppBGAudioPlayer", "play");
            }
            SwanAppAudioClient swanAppAudioClient = this.f45865a;
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
        SwanAppAudioClient swanAppAudioClient = this.f45865a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.z(i2 * 1000);
        }
        d.g("backgroundAudio", "seekTo " + i2);
        d.a.o0.a.i1.c.e.a aVar = this.f45868d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void H(Message message, int i2, int i3) {
        d.a.o0.a.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, message, i2, i3) == null) && (aVar = this.f45867c) != null && aVar.f45854i) {
            aVar.n = i2;
            aVar.o = i3;
            d.a.o0.a.c1.a.n().v(message, this.f45867c);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f45872h != null) {
                d.a.o0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f45872h);
            }
            this.f45872h = new a(this);
            d.a.o0.a.c1.a.b().registerActivityLifecycleCallbacks(this.f45872h);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppAudioClient swanAppAudioClient = this.f45865a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.C();
            }
            if (this.f45872h != null) {
                d.a.o0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f45872h);
                this.f45872h = null;
            }
        }
    }

    public void K(d.a.o0.a.i1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            if (f45864i) {
                Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
            }
            this.f45867c = aVar;
            d.a.o0.a.i1.c.e.a aVar2 = this.f45868d;
            if (aVar2 != null) {
                aVar2.d(aVar.p);
            }
            B();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (e.i() != null && e.i().N() != null && j != null) {
                b.a N = e.i().N();
                d.a.o0.a.j2.p.f fVar = new d.a.o0.a.j2.p.f();
                fVar.f46321a = k.m(N.G());
                fVar.f46326f = N.H();
                fVar.f46323c = N.T();
                fVar.a("appid", N.H());
                fVar.a("cuid", d.a.o0.a.c1.a.a0().i(d.a.o0.a.c1.a.b()));
                JSONObject k = k.k(N.W());
                if (k != null) {
                    fVar.a("keyfeed", k.optString("keyfeed"));
                }
                k.i(j, fVar);
            }
            j = null;
        }
    }

    public d.a.o0.a.i1.c.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f45867c : (d.a.o0.a.i1.c.a) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f45869e : invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            switch (str.hashCode()) {
                case -2129294769:
                    if (str.equals("startTime")) {
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
                    return Integer.valueOf(this.f45869e);
                case 2:
                    return Boolean.valueOf(x());
                case 3:
                    return this.f45867c.f45848c;
                case 4:
                    return Integer.valueOf(this.f45867c.k);
                case 5:
                    return Integer.valueOf(this.f45870f);
                case 6:
                    return this.f45867c.f45849d;
                case 7:
                    return this.f45867c.f45850e;
                case '\b':
                    return this.f45867c.f45851f;
                case '\t':
                    return this.f45867c.f45852g;
                case '\n':
                    return this.f45867c.f45853h;
                default:
                    return "";
            }
        }
        return invokeL.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.f45865a;
            if (swanAppAudioClient != null) {
                return swanAppAudioClient.r();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final SwanAppAudioClient v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f45865a == null) {
                this.f45865a = new SwanAppAudioClient(this.f45866b);
                this.f45865a.A(new C0781c(this, null));
            }
            return this.f45865a;
        }
        return (SwanAppAudioClient) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SwanAppConfigData F = e.i() != null ? e.i().F() : null;
            return F != null && F.p.contains(SwanAppConfigData.RequiredBackgroundModeItem.AUDIO.mMode);
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppAudioClient swanAppAudioClient = this.f45865a;
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
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (swanAppAudioClient = this.f45865a) == null) {
            return;
        }
        swanAppAudioClient.t(z);
        f.V().p();
    }

    public void z(d.a.o0.a.i1.c.a aVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, aVar, callbackHandler) == null) {
            if (f45864i) {
                Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
            }
            this.f45867c = aVar;
            if (aVar.p != null) {
                try {
                    this.f45868d = new d.a.o0.a.i1.c.e.a(callbackHandler, new JSONObject(this.f45867c.p));
                } catch (JSONException e2) {
                    d.b("backgroundAudio", e2.toString());
                    if (f45864i) {
                        Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                    }
                }
            }
            B();
        }
    }
}
