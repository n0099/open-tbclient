package d.a.o0.v.j.b.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.c1.d.j;
import d.a.o0.a.k;
import d.a.o0.v.g;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public class a implements j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanVideoView f51689a;

    /* renamed from: b  reason: collision with root package name */
    public Context f51690b;

    /* renamed from: c  reason: collision with root package name */
    public VideoContainerManager f51691c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51692d;

    /* renamed from: e  reason: collision with root package name */
    public int f51693e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51694f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51695g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51696h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.a.i1.g.c f51697i;
    public FrameLayout j;
    public j.d k;
    public j.b l;
    public j.a m;
    public j.e n;
    public j.f o;
    public j.c p;
    public boolean q;
    public int r;

    /* renamed from: d.a.o0.v.j.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1169a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f51698e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f51699f;

        public RunnableC1169a(a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51699f = aVar;
            this.f51698e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51698e.setRequestedOrientation(0);
                this.f51698e.getWindow().addFlags(1024);
                this.f51699f.N(this.f51698e);
                SwanAppComponentContainerView I = this.f51699f.O().I();
                I.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                g.b(I);
                g.a(this.f51698e, I);
                d.a.o0.v.j.b.a.a.c(this.f51699f.f51697i.n, this.f51699f.f51697i.f43982g, true, this.f51699f.O());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51700e;

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
            this.f51700e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.b(this.f51700e.O().I());
                this.f51700e.O().w();
                d.a.o0.v.j.b.a.a.c(this.f51700e.f51697i.n, this.f51700e.f51697i.f43982g, false, this.f51700e.O());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51701e;

        public c(a aVar) {
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
            this.f51701e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51701e.a0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.o0.v.h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f51702a;

        public d(a aVar) {
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
            this.f51702a = aVar;
        }

        @Override // d.a.o0.v.h.a
        public void a(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
                int currentPosition = swanVideoView.getCurrentPosition() / 1000;
                int duration = swanVideoView.getDuration() / 1000;
                int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
                if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                    d.a.o0.a.e0.d.a("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                    d.a.o0.v.j.b.a.a.b(this.f51702a.f51697i.n, this.f51702a.f51697i.f43982g, "waiting", new JSONObject());
                    return;
                }
                d.a.o0.a.e0.d.a("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                c(currentPosition, duration);
            }
        }

        @Override // d.a.o0.v.h.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f51702a.S();
                } else {
                    this.f51702a.T();
                }
            }
        }

        public final void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(i3));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i2));
                } catch (JSONException e2) {
                    if (a.s) {
                        e2.printStackTrace();
                    }
                }
                d.a.o0.v.j.b.a.a.b(this.f51702a.f51697i.n, this.f51702a.f51697i.f43982g, "timeupdate", jSONObject);
            }
        }

        @Override // d.a.o0.v.h.a
        public void onEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f51702a.f51692d = false;
                d.a.o0.v.j.b.a.a.b(this.f51702a.f51697i.n, this.f51702a.f51697i.f43982g, "ended", new JSONObject());
                if (this.f51702a.m != null) {
                    this.f51702a.m.b(this.f51702a);
                }
                this.f51702a.f51696h = true;
                d.a.o0.a.e0.d.a("video", "onEnded call back");
            }
        }

        @Override // d.a.o0.v.h.a
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
                this.f51702a.f51692d = false;
                d.a.o0.a.e0.d.b("video", "errorCode :" + i2);
                this.f51702a.O().L();
                this.f51702a.O().M();
                d.a.o0.v.j.b.a.a.b(this.f51702a.f51697i.n, this.f51702a.f51697i.f43982g, "error", d.a.o0.v.j.a.b.a.c(i3));
                if (this.f51702a.l != null) {
                    this.f51702a.l.f(this.f51702a, i2, i3);
                }
                this.f51702a.f51696h = false;
                int currentPosition = this.f51702a.P().getCurrentPosition();
                a aVar = this.f51702a;
                if (currentPosition <= 0) {
                    currentPosition = aVar.r;
                }
                aVar.r = currentPosition;
                d.a.o0.a.e0.d.b("video", "onError what " + i2 + " ,extra " + i3);
            }
        }

        @Override // d.a.o0.v.h.a
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                d.a.o0.v.j.b.a.a.b(this.f51702a.f51697i.n, this.f51702a.f51697i.f43982g, "pause", new JSONObject());
                d.a.o0.a.e0.d.a("video", "onPaused call back");
                this.f51702a.f51692d = true;
                if (this.f51702a.p != null) {
                    this.f51702a.p.c(this.f51702a);
                }
            }
        }

        @Override // d.a.o0.v.h.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                d.a.o0.a.e0.d.a("video", "onPrepared call back");
                this.f51702a.V();
                this.f51702a.M();
                if (this.f51702a.k != null) {
                    this.f51702a.k.e(this.f51702a);
                }
            }
        }

        @Override // d.a.o0.v.h.b, d.a.o0.v.h.a
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                super.onResume();
                d.a.o0.v.j.b.a.a.b(this.f51702a.f51697i.n, this.f51702a.f51697i.f43982g, "play", new JSONObject());
                this.f51702a.f51696h = false;
                this.f51702a.f51692d = false;
                this.f51702a.O().M();
                if (this.f51702a.n != null) {
                    this.f51702a.n.a(this.f51702a);
                }
            }
        }

        @Override // d.a.o0.v.h.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                d.a.o0.v.j.b.a.a.b(this.f51702a.f51697i.n, this.f51702a.f51697i.f43982g, "play", new JSONObject());
                this.f51702a.f51696h = false;
                this.f51702a.f51692d = false;
                this.f51702a.O().M();
                if (this.f51702a.o != null) {
                    this.f51702a.o.d(this.f51702a);
                }
            }
        }

        public /* synthetic */ d(a aVar, RunnableC1169a runnableC1169a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(861078171, "Ld/a/o0/v/j/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(861078171, "Ld/a/o0/v/j/b/b/a;");
                return;
            }
        }
        s = k.f46335a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51695g = true;
        this.r = 0;
    }

    public final void K(d.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            d.a.o0.a.i1.g.c cVar2 = this.f51697i;
            if (cVar2 != null && cVar != null && !TextUtils.isEmpty(cVar2.C) && !TextUtils.isEmpty(cVar.C) && !TextUtils.equals(this.f51697i.C, cVar.C)) {
                this.f51694f = true;
            } else {
                this.f51694f = false;
            }
        }
    }

    public a L(Context context, @NonNull d.a.o0.a.i1.g.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar)) == null) {
            this.f51690b = context;
            this.f51697i = cVar;
            O();
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f51695g) {
            return;
        }
        pause();
    }

    public final void N(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public final VideoContainerManager O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f51697i == null) {
                d.a.o0.a.c0.g.a.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
            }
            if (this.f51691c == null) {
                this.f51691c = new VideoContainerManager(this.f51690b, this.f51697i);
            }
            return this.f51691c;
        }
        return (VideoContainerManager) invokeV.objValue;
    }

    public final SwanVideoView P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f51689a == null) {
                d.a.o0.a.e0.d.g("video", "create player");
                this.f51689a = new SwanVideoView(this.f51690b);
                Q();
            }
            return this.f51689a;
        }
        return (SwanVideoView) invokeV.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            P().setVideoPlayerCallback(new d(this, null));
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final boolean S() {
        InterceptResult invokeV;
        Activity k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            e i2 = e.i();
            if (i2 == null || (k = i2.k()) == null || k.isFinishing()) {
                return false;
            }
            k.runOnUiThread(new RunnableC1169a(this, k));
            this.q = true;
            this.f51689a.setIsLandscape(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Activity k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            e i2 = e.i();
            if (i2 == null || (k = i2.k()) == null || k.isFinishing()) {
                return false;
            }
            k.setRequestedOrientation(1);
            k.getWindow().clearFlags(1024);
            k.runOnUiThread(new b(this));
            this.q = false;
            this.f51689a.setIsLandscape(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void U() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (swanVideoView = this.f51689a) == null) {
            return;
        }
        swanVideoView.D();
        g.b(this.f51689a);
        this.f51689a = null;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && f0()) {
            if (this.f51693e != 0) {
                P().B(this.f51693e);
                this.f51693e = 0;
                return;
            }
            int i2 = this.f51697i.q;
            if (i2 != 0) {
                this.f51689a.B(i2 * 1000);
                this.f51697i.q = 0;
                return;
            }
            int i3 = this.r;
            if (i3 != 0) {
                this.f51689a.B(i3);
                this.r = 0;
            }
        }
    }

    public final void W(d.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (cVar == null) {
                d.a.o0.a.e0.d.b("SwanAppVideoPlayer", "setDataSource params is null!");
                return;
            }
            P().setVideoPath(this.f51697i.C);
            d.a.o0.a.e0.d.a("video", "setDataSource url " + cVar.C);
        }
    }

    public final void X(d.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            P().setMuted(cVar.o);
            P().setMediaControllerEnabled(cVar.B);
            P().setLooping(cVar.t);
            if (TextUtils.equals(cVar.u, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                P().setVideoScalingMode(2);
            } else if (TextUtils.equals(cVar.u, "fill")) {
                P().setVideoScalingMode(3);
            } else {
                P().setVideoScalingMode(1);
            }
        }
    }

    public final boolean Y(d.a.o0.a.i1.g.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cVar)) == null) {
            d.a.o0.a.i1.g.c cVar2 = this.f51697i;
            if (cVar2 == null) {
                return false;
            }
            if (cVar2.o == cVar.o && cVar2.B == cVar.B && TextUtils.equals(cVar2.u, cVar.u)) {
                d.a.o0.a.i1.g.c cVar3 = this.f51697i;
                return (cVar3.L == cVar.L && cVar3.H == cVar.H && cVar3.I == cVar.I && cVar3.K == cVar.K && cVar3.J == cVar.J && cVar3.t == cVar.t) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            O().O(new c(this));
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void a(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, frameLayout) == null) {
            this.j = frameLayout;
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && f0()) {
            O().L();
            U();
            P().w();
            X(this.f51697i);
            h(this.f51697i, false);
            W(this.f51697i);
            P().C();
            this.f51694f = false;
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public final void b0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (swanVideoView = this.f51689a) == null) {
            return;
        }
        swanVideoView.D();
    }

    @Override // d.a.o0.a.c1.d.j
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public final void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (s) {
                Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
            }
            if (this.f51689a == null || z || !isPlaying()) {
                return;
            }
            this.f51689a.x();
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    public void d0(d.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            O().Q(cVar);
            e0();
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public /* bridge */ /* synthetic */ j e(Context context, @NonNull d.a.o0.a.i1.g.c cVar) {
        L(context, cVar);
        return this;
    }

    public final void e0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (swanVideoView = this.f51689a) == null) {
            return;
        }
        g.b(swanVideoView);
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            frameLayout.addView(this.f51689a);
        } else {
            O().J().addView(this.f51689a);
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    public final boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            d.a.o0.a.i1.g.c cVar = this.f51697i;
            return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f51697i.n) || TextUtils.isEmpty(this.f51697i.f43981f)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.o0.a.c1.d.j
    public void g(j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            this.m = aVar;
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? P().getCurrentPosition() : invokeV.intValue;
    }

    @Override // d.a.o0.a.c1.d.j
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? P().getDuration() : invokeV.intValue;
    }

    @Override // d.a.o0.a.c1.d.j
    public void h(d.a.o0.a.i1.g.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, cVar, z) == null) {
            if (s) {
                Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
            }
            d.a.o0.a.e0.d.a("video", "updatePlayerConfigInternal params: " + cVar.toString());
            if (Y(cVar)) {
                X(cVar);
            }
            this.f51697i = cVar;
            if (z) {
                c0(cVar.l());
            }
            d0(cVar);
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f51696h : invokeV.booleanValue;
    }

    @Override // d.a.o0.a.c1.d.j
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            SwanVideoView swanVideoView = this.f51689a;
            if (swanVideoView == null) {
                return false;
            }
            return swanVideoView.v();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.o0.a.c1.d.j
    public void j(j.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, eVar) == null) {
            this.n = eVar;
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void k(j.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, fVar) == null) {
            this.o = fVar;
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void l(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (z) {
                S();
            } else {
                T();
            }
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void m(j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, dVar) == null) {
            this.k = dVar;
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            P().setMuted(z);
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void n(d.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, cVar) == null) {
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void o(d.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, cVar) == null) {
            d.a.o0.a.e0.d.a("video", "Open Player " + cVar.n);
            K(cVar);
            this.f51697i = cVar;
            d0(cVar);
            if (cVar.k() && cVar.l()) {
                a0();
                return;
            }
            b0();
            Z();
            O().P(cVar.p, cVar.u);
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? R() && T() : invokeV.booleanValue;
    }

    @Override // d.a.o0.a.c1.d.j
    public void p(j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bVar) == null) {
            this.l = bVar;
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            P().x();
            this.f51692d = true;
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void q(j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, cVar) == null) {
            this.p = cVar;
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.f51692d && !this.f51694f) {
                P().C();
            } else {
                a0();
            }
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048623, this, i2) == null) && f0()) {
            if (!this.f51694f) {
                P().B(i2);
            } else {
                this.f51693e = i2;
            }
        }
    }

    @Override // d.a.o0.a.c1.d.j
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            d.a.o0.a.e0.d.a("video", IntentConfig.STOP);
            U();
            P().y();
        }
    }
}
