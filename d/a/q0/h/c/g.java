package d.a.q0.h.c;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.audio.AudioPlayer;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.h.c.j.a;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g extends EventTargetImpl implements d.a.q0.h.c.a, d.a.q0.h.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public boolean autoplay;
    @V8JavascriptField
    public int buffered;
    @V8JavascriptField
    public double currentTime;
    @V8JavascriptField
    public long duration;

    /* renamed from: e  reason: collision with root package name */
    public AudioPlayer f53116e;

    /* renamed from: f  reason: collision with root package name */
    public String f53117f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.a.l0.c f53118g;
    @V8JavascriptField
    public boolean loop;
    @V8JavascriptField
    public boolean obeyMuteSwitch;
    @V8JavascriptField
    public boolean paused;
    @V8JavascriptField
    public String src;
    @V8JavascriptField
    public float startTime;
    @V8JavascriptField
    public float volume;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f53119e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f53120f;

        public a(g gVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53120f = gVar;
            this.f53119e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f53119e || this.f53120f.f53116e.I()) {
                    this.f53120f.f53116e.N(d.a.q0.h.c.f.c(this.f53120f));
                    g gVar = this.f53120f;
                    if (gVar.autoplay) {
                        gVar.f53116e.Q();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f53121e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53121e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53121e.f53116e.Q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f53122e;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53122e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53122e.f53116e.O();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f53123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f53124f;

        public d(g gVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53124f = gVar;
            this.f53123e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53124f.f53116e.U(this.f53123e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f53125e;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53125e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53125e.f53116e.Y();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f53126e;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53126e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53126e.f53116e.T();
            }
        }
    }

    /* renamed from: d.a.q0.h.c.g$g  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1131g implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f53127a;

        /* renamed from: d.a.q0.h.c.g$g$a */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f53128e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1131g f53129f;

            public a(C1131g c1131g, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1131g, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53129f = c1131g;
                this.f53128e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f53129f.f53127a.src = d.a.q0.a.g1.f.V().I().g(this.f53128e);
                    if (k.f49133a) {
                        Log.d("Aigame AudioContext", "prepare path: " + this.f53129f.f53127a.src + " autoPlay: " + this.f53129f.f53127a.autoplay + " class: " + toString());
                    }
                    this.f53129f.f53127a.F(true);
                }
            }
        }

        public C1131g(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53127a = gVar;
        }

        @Override // d.a.q0.h.c.j.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f53127a.f53118g.runOnJSThread(new a(this, str));
            }
        }

        @Override // d.a.q0.h.c.j.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d.a.q0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
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
        this.src = "";
        this.volume = 1.0f;
        this.obeyMuteSwitch = true;
        this.paused = true;
        this.f53118g = cVar;
        B();
    }

    public static AudioPlayer D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? new AudioPlayer(str) : (AudioPlayer) invokeL.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String valueOf = String.valueOf(d.a.q0.h.c.c.a());
            this.f53117f = valueOf;
            this.f53116e = D(valueOf);
            E();
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AudioPlayer audioPlayer = this.f53116e;
            if (audioPlayer != null) {
                return audioPlayer.y();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f53116e == null) {
            return;
        }
        d.a.q0.h.c.e eVar = new d.a.q0.h.c.e(this, d.a.q0.h.c.f.i());
        eVar.e(this);
        this.f53116e.V(eVar);
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.f53116e == null) {
            return;
        }
        d.a.q0.h.c.j.b.h().e().post(new a(this, z));
    }

    public final void G(d.a.q0.h.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f53116e.Z(dVar);
        }
    }

    @Override // d.a.q0.h.c.a
    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f53116e == null) {
            return;
        }
        d.a.q0.h.c.j.b.h().e().post(new f(this));
    }

    @Override // d.a.q0.h.c.a
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AudioPlayer audioPlayer = this.f53116e;
            if (audioPlayer != null) {
                return (int) audioPlayer.A();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (k.f49133a) {
                Log.d("Aigame AudioContext", str);
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2129294769:
                    if (str.equals("startTime")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -810883302:
                    if (str.equals("volume")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 114148:
                    if (str.equals("src")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3327652:
                    if (str.equals("loop")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1439562083:
                    if (str.equals("autoplay")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                G(d.a.q0.h.c.f.c(this));
            } else if (c2 == 2) {
                if (d.a.q0.h.c.f.b(this.volume)) {
                    G(d.a.q0.h.c.f.c(this));
                } else {
                    this.volume = this.f53116e.D();
                }
            } else if (c2 != 3) {
                if (c2 == 4 && this.autoplay) {
                    play();
                }
            } else {
                F(false);
            }
        }
    }

    @Override // d.a.q0.h.c.a
    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f53116e == null) {
            return;
        }
        d.a.q0.h.c.j.b.h().e().post(new c(this));
    }

    @Override // d.a.q0.h.c.a
    @JavascriptInterface
    public void play() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f53116e == null) {
            return;
        }
        d.a.q0.h.c.j.b.h().e().post(new b(this));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // d.a.q0.h.c.b
    public void q(String str, JSONObject jSONObject) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, jSONObject) == null) {
            switch (str.hashCode()) {
                case -1522036513:
                    if (str.equals("buffered")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3443508:
                    if (str.equals("play")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3540994:
                    if (str.equals(IntentConfig.STOP)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 96651962:
                    if (str.equals("ended")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 96784904:
                    if (str.equals("error")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 550609668:
                    if (str.equals("canplay")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1762557398:
                    if (str.equals("timeupdate")) {
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
                    this.buffered = C();
                    return;
                case 1:
                    if (jSONObject != null) {
                        this.duration = getDuration() / 1000;
                        this.currentTime = w() / 1000.0d;
                        return;
                    }
                    return;
                case 2:
                    this.paused = false;
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    this.paused = true;
                    return;
                case 7:
                    this.duration = getDuration() / 1000;
                    return;
                default:
                    return;
            }
        }
    }

    @Override // d.a.q0.h.c.a
    @JavascriptInterface
    public void seek(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048587, this, f2) == null) || this.f53116e == null) {
            return;
        }
        d.a.q0.h.c.j.b.h().e().post(new d(this, f2));
    }

    @JavascriptInterface
    public void setDataBuffer(JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsArrayBuffer) == null) {
            d.a.q0.h.c.j.b.h().m(jsArrayBuffer, new C1131g(this));
        }
    }

    @Override // d.a.q0.h.c.a
    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f53116e == null) {
            return;
        }
        d.a.q0.h.c.j.b.h().e().post(new e(this));
    }

    @Override // d.a.q0.h.c.a
    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AudioPlayer audioPlayer = this.f53116e;
            if (audioPlayer != null) {
                return audioPlayer.z();
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
