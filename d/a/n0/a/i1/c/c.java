package d.a.n0.a.i1.c;

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
import d.a.n0.a.a2.e;
import d.a.n0.a.e0.d;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.g1.f;
import d.a.n0.a.j2.k;
import d.a.n0.a.p.b.a.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45360i;
    public static d.a.n0.a.j2.a j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppAudioClient f45361a;

    /* renamed from: b  reason: collision with root package name */
    public Context f45362b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.a.i1.c.a f45363c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.a.i1.c.e.a f45364d;

    /* renamed from: e  reason: collision with root package name */
    public int f45365e;

    /* renamed from: f  reason: collision with root package name */
    public int f45366f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45367g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.a.g1.a f45368h;

    /* loaded from: classes7.dex */
    public class a extends d.a.n0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f45369e;

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
            this.f45369e = cVar;
        }

        @Override // d.a.n0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                this.f45369e.f45367g = false;
                if (this.f45369e.x()) {
                    return;
                }
                this.f45369e.p();
            }
        }

        @Override // d.a.n0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                this.f45369e.f45367g = true;
                if (this.f45369e.w()) {
                    if (this.f45369e.x()) {
                        d.a.n0.a.j2.a unused = c.j = null;
                        return;
                    } else if (c.j == null) {
                        d.a.n0.a.j2.a unused2 = c.j = k.c("1044");
                        return;
                    } else {
                        return;
                    }
                }
                super.onActivityStopped(activity);
                this.f45369e.J();
                d.l("SwanAppBGAudioPlayer", "stop player without requiredBackgroundModes");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.n0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f45370e;

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
            this.f45370e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f45370e.v().v(this.f45370e.f45363c.c(str), str);
        }
    }

    /* renamed from: d.a.n0.a.i1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0772c implements SwanAppAudioClient.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f45371a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f45372b;

        public C0772c(c cVar) {
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
            this.f45372b = cVar;
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
                this.f45372b.H(message, i4, this.f45372b.u() / 1000);
                switch (i2) {
                    case 1001:
                        d.g("backgroundAudio", "event onCanPlay");
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.a("onCanplay");
                        }
                        this.f45371a = true;
                        return true;
                    case 1002:
                        d.g("backgroundAudio", "event onPlay");
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.a("onPlay");
                        }
                        if (this.f45372b.f45367g) {
                            d.a.n0.a.j2.a unused = c.j = k.c("1044");
                        }
                        return true;
                    case 1003:
                        d.g("backgroundAudio", "event onPause");
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.a(MissionEvent.MESSAGE_PAUSE);
                        }
                        if (this.f45372b.f45367g) {
                            this.f45372b.p();
                        }
                        return true;
                    case 1004:
                        d.g("backgroundAudio", "event onStop");
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.a(MissionEvent.MESSAGE_STOP);
                        }
                        this.f45371a = true;
                        if (this.f45372b.f45367g) {
                            this.f45372b.p();
                        }
                        return true;
                    case 1005:
                        d.g("backgroundAudio", "event onEnd");
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.a("onEnded");
                        }
                        if (this.f45372b.f45367g) {
                            this.f45372b.p();
                        }
                        return true;
                    case 1006:
                        this.f45372b.f45365e = i4;
                        try {
                            jSONObject.putOpt("currentTime", Integer.valueOf(this.f45372b.r()));
                            jSONObject.putOpt("duration", Integer.valueOf(this.f45372b.u() / 1000));
                        } catch (JSONException e2) {
                            if (c.f45360i) {
                                e2.printStackTrace();
                            }
                        }
                        d.g("backgroundAudio", "event onTimeUpdate " + jSONObject.toString());
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.b("onTimeUpdate", jSONObject);
                        }
                        if (this.f45371a) {
                            if (this.f45372b.f45363c.k > 0) {
                                c cVar = this.f45372b;
                                cVar.G(cVar.f45363c.k);
                            }
                            this.f45371a = false;
                        }
                        return true;
                    case 1007:
                        try {
                            jSONObject.putOpt(RouterCallback.KEY_ERROR_CODE, Integer.valueOf(i3));
                        } catch (JSONException e3) {
                            if (c.f45360i) {
                                e3.printStackTrace();
                            }
                        }
                        d.g("backgroundAudio", "event onError code:" + i3);
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.b("onError", jSONObject);
                        }
                        return true;
                    case 1008:
                        int s = this.f45372b.s();
                        this.f45372b.f45366f = i3;
                        d.g("backgroundAudio", "event onDownloadProgress " + this.f45372b.f45366f);
                        if (this.f45372b.f45364d != null && s >= this.f45372b.f45366f) {
                            this.f45372b.f45364d.a("onWaiting");
                        }
                        return true;
                    case 1009:
                        d.g("backgroundAudio", "event onPrev");
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.a("onPrev");
                        }
                        return true;
                    case 1010:
                        d.g("backgroundAudio", "event onNext");
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.a("onNext");
                        }
                        return true;
                    case 1011:
                        d.g("backgroundAudio", "event onSeekEnd");
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.a("onSeeked");
                        }
                        return true;
                    case 1012:
                        d.g("backgroundAudio", "event onSeeking");
                        if (this.f45372b.f45364d != null) {
                            this.f45372b.f45364d.a("onSeeking");
                        }
                        return true;
                    default:
                        return false;
                }
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ C0772c(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1234182773, "Ld/a/n0/a/i1/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1234182773, "Ld/a/n0/a/i1/c/c;");
                return;
            }
        }
        f45360i = d.a.n0.a.k.f45831a;
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
        this.f45363c = new d.a.n0.a.i1.c.a();
        this.f45365e = 0;
        this.f45366f = 0;
        this.f45362b = context;
    }

    public void A() {
        SwanAppAudioClient swanAppAudioClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppAudioClient = this.f45361a) == null) {
            return;
        }
        swanAppAudioClient.u();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f45360i) {
                Log.d("SwanAppBGAudioPlayer", "play");
            }
            if (this.f45363c.a()) {
                return;
            }
            I();
            String str = this.f45363c.f45344c;
            e i2 = e.i();
            if (d.a.n0.a.k2.b.s(str) == PathType.CLOUD) {
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
            d.a.n0.a.c1.a.k().b(this.f45362b, str, new b(this));
        }
    }

    public final void D(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eVar) == null) {
            if (this.f45363c.q && eVar != null) {
                l m = d.a.n0.a.c1.b.m();
                if (this.f45364d.c()) {
                    str = m == null ? null : m.a(str);
                } else {
                    str = d.a.n0.a.k2.b.H(str, eVar);
                }
            }
            v().v(this.f45363c.c(str), str);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.g("backgroundAudio", "release ");
            if (this.f45361a == null || w()) {
                return;
            }
            this.f45361a.w();
            f.V().b();
            this.f45361a = null;
            j = null;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f45360i) {
                Log.d("SwanAppBGAudioPlayer", "play");
            }
            SwanAppAudioClient swanAppAudioClient = this.f45361a;
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
        SwanAppAudioClient swanAppAudioClient = this.f45361a;
        if (swanAppAudioClient != null) {
            swanAppAudioClient.z(i2 * 1000);
        }
        d.g("backgroundAudio", "seekTo " + i2);
        d.a.n0.a.i1.c.e.a aVar = this.f45364d;
        if (aVar != null) {
            aVar.a("onSeeking");
        }
    }

    public final void H(Message message, int i2, int i3) {
        d.a.n0.a.i1.c.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, message, i2, i3) == null) && (aVar = this.f45363c) != null && aVar.f45350i) {
            aVar.n = i2;
            aVar.o = i3;
            d.a.n0.a.c1.a.n().v(message, this.f45363c);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f45368h != null) {
                d.a.n0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f45368h);
            }
            this.f45368h = new a(this);
            d.a.n0.a.c1.a.b().registerActivityLifecycleCallbacks(this.f45368h);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppAudioClient swanAppAudioClient = this.f45361a;
            if (swanAppAudioClient != null) {
                swanAppAudioClient.C();
            }
            if (this.f45368h != null) {
                d.a.n0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.f45368h);
                this.f45368h = null;
            }
        }
    }

    public void K(d.a.n0.a.i1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            if (f45360i) {
                Log.d("SwanAppBGAudioPlayer", "Audio Update : " + aVar);
            }
            this.f45363c = aVar;
            d.a.n0.a.i1.c.e.a aVar2 = this.f45364d;
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
                d.a.n0.a.j2.p.f fVar = new d.a.n0.a.j2.p.f();
                fVar.f45817a = k.m(N.G());
                fVar.f45822f = N.H();
                fVar.f45819c = N.T();
                fVar.a("appid", N.H());
                fVar.a("cuid", d.a.n0.a.c1.a.a0().i(d.a.n0.a.c1.a.b()));
                JSONObject k = k.k(N.W());
                if (k != null) {
                    fVar.a("keyfeed", k.optString("keyfeed"));
                }
                k.i(j, fVar);
            }
            j = null;
        }
    }

    public d.a.n0.a.i1.c.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f45363c : (d.a.n0.a.i1.c.a) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f45365e : invokeV.intValue;
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
                    return Integer.valueOf(this.f45365e);
                case 2:
                    return Boolean.valueOf(x());
                case 3:
                    return this.f45363c.f45344c;
                case 4:
                    return Integer.valueOf(this.f45363c.k);
                case 5:
                    return Integer.valueOf(this.f45366f);
                case 6:
                    return this.f45363c.f45345d;
                case 7:
                    return this.f45363c.f45346e;
                case '\b':
                    return this.f45363c.f45347f;
                case '\t':
                    return this.f45363c.f45348g;
                case '\n':
                    return this.f45363c.f45349h;
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
            SwanAppAudioClient swanAppAudioClient = this.f45361a;
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
            if (this.f45361a == null) {
                this.f45361a = new SwanAppAudioClient(this.f45362b);
                this.f45361a.A(new C0772c(this, null));
            }
            return this.f45361a;
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
            SwanAppAudioClient swanAppAudioClient = this.f45361a;
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
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (swanAppAudioClient = this.f45361a) == null) {
            return;
        }
        swanAppAudioClient.t(z);
        f.V().p();
    }

    public void z(d.a.n0.a.i1.c.a aVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, aVar, callbackHandler) == null) {
            if (f45360i) {
                Log.d("SwanAppBGAudioPlayer", "AudioPlayer open");
            }
            this.f45363c = aVar;
            if (aVar.p != null) {
                try {
                    this.f45364d = new d.a.n0.a.i1.c.e.a(callbackHandler, new JSONObject(this.f45363c.p));
                } catch (JSONException e2) {
                    d.b("backgroundAudio", e2.toString());
                    if (f45360i) {
                        Log.e("SwanAppBGAudioPlayer", "Audio callback is not jsonObject");
                    }
                }
            }
            B();
        }
    }
}
