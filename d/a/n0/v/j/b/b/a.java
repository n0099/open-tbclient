package d.a.n0.v.j.b.b;

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
import d.a.n0.a.a2.e;
import d.a.n0.a.c1.d.j;
import d.a.n0.a.k;
import d.a.n0.v.g;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public class a implements j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanVideoView f51185a;

    /* renamed from: b  reason: collision with root package name */
    public Context f51186b;

    /* renamed from: c  reason: collision with root package name */
    public VideoContainerManager f51187c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51188d;

    /* renamed from: e  reason: collision with root package name */
    public int f51189e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51190f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51191g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51192h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.a.i1.g.c f51193i;
    public FrameLayout j;
    public j.d k;
    public j.b l;
    public j.a m;
    public j.e n;
    public j.f o;
    public j.c p;
    public boolean q;
    public int r;

    /* renamed from: d.a.n0.v.j.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1160a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f51194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f51195f;

        public RunnableC1160a(a aVar, Activity activity) {
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
            this.f51195f = aVar;
            this.f51194e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51194e.setRequestedOrientation(0);
                this.f51194e.getWindow().addFlags(1024);
                this.f51195f.N(this.f51194e);
                SwanAppComponentContainerView I = this.f51195f.O().I();
                I.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                g.b(I);
                g.a(this.f51194e, I);
                d.a.n0.v.j.b.a.a.c(this.f51195f.f51193i.n, this.f51195f.f51193i.f43478g, true, this.f51195f.O());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51196e;

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
            this.f51196e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.b(this.f51196e.O().I());
                this.f51196e.O().w();
                d.a.n0.v.j.b.a.a.c(this.f51196e.f51193i.n, this.f51196e.f51193i.f43478g, false, this.f51196e.O());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51197e;

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
            this.f51197e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51197e.a0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.n0.v.h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f51198a;

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
            this.f51198a = aVar;
        }

        @Override // d.a.n0.v.h.a
        public void a(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
                int currentPosition = swanVideoView.getCurrentPosition() / 1000;
                int duration = swanVideoView.getDuration() / 1000;
                int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
                if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                    d.a.n0.a.e0.d.a("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                    d.a.n0.v.j.b.a.a.b(this.f51198a.f51193i.n, this.f51198a.f51193i.f43478g, "waiting", new JSONObject());
                    return;
                }
                d.a.n0.a.e0.d.a("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                c(currentPosition, duration);
            }
        }

        @Override // d.a.n0.v.h.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f51198a.S();
                } else {
                    this.f51198a.T();
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
                d.a.n0.v.j.b.a.a.b(this.f51198a.f51193i.n, this.f51198a.f51193i.f43478g, "timeupdate", jSONObject);
            }
        }

        @Override // d.a.n0.v.h.a
        public void onEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f51198a.f51188d = false;
                d.a.n0.v.j.b.a.a.b(this.f51198a.f51193i.n, this.f51198a.f51193i.f43478g, "ended", new JSONObject());
                if (this.f51198a.m != null) {
                    this.f51198a.m.b(this.f51198a);
                }
                this.f51198a.f51192h = true;
                d.a.n0.a.e0.d.a("video", "onEnded call back");
            }
        }

        @Override // d.a.n0.v.h.a
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
                this.f51198a.f51188d = false;
                d.a.n0.a.e0.d.b("video", "errorCode :" + i2);
                this.f51198a.O().L();
                this.f51198a.O().M();
                d.a.n0.v.j.b.a.a.b(this.f51198a.f51193i.n, this.f51198a.f51193i.f43478g, "error", d.a.n0.v.j.a.b.a.c(i3));
                if (this.f51198a.l != null) {
                    this.f51198a.l.f(this.f51198a, i2, i3);
                }
                this.f51198a.f51192h = false;
                int currentPosition = this.f51198a.P().getCurrentPosition();
                a aVar = this.f51198a;
                if (currentPosition <= 0) {
                    currentPosition = aVar.r;
                }
                aVar.r = currentPosition;
                d.a.n0.a.e0.d.b("video", "onError what " + i2 + " ,extra " + i3);
            }
        }

        @Override // d.a.n0.v.h.a
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                d.a.n0.v.j.b.a.a.b(this.f51198a.f51193i.n, this.f51198a.f51193i.f43478g, "pause", new JSONObject());
                d.a.n0.a.e0.d.a("video", "onPaused call back");
                this.f51198a.f51188d = true;
                if (this.f51198a.p != null) {
                    this.f51198a.p.c(this.f51198a);
                }
            }
        }

        @Override // d.a.n0.v.h.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                d.a.n0.a.e0.d.a("video", "onPrepared call back");
                this.f51198a.V();
                this.f51198a.M();
                if (this.f51198a.k != null) {
                    this.f51198a.k.e(this.f51198a);
                }
            }
        }

        @Override // d.a.n0.v.h.b, d.a.n0.v.h.a
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                super.onResume();
                d.a.n0.v.j.b.a.a.b(this.f51198a.f51193i.n, this.f51198a.f51193i.f43478g, "play", new JSONObject());
                this.f51198a.f51192h = false;
                this.f51198a.f51188d = false;
                this.f51198a.O().M();
                if (this.f51198a.n != null) {
                    this.f51198a.n.a(this.f51198a);
                }
            }
        }

        @Override // d.a.n0.v.h.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                d.a.n0.v.j.b.a.a.b(this.f51198a.f51193i.n, this.f51198a.f51193i.f43478g, "play", new JSONObject());
                this.f51198a.f51192h = false;
                this.f51198a.f51188d = false;
                this.f51198a.O().M();
                if (this.f51198a.o != null) {
                    this.f51198a.o.d(this.f51198a);
                }
            }
        }

        public /* synthetic */ d(a aVar, RunnableC1160a runnableC1160a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1154481178, "Ld/a/n0/v/j/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1154481178, "Ld/a/n0/v/j/b/b/a;");
                return;
            }
        }
        s = k.f45831a;
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
        this.f51191g = true;
        this.r = 0;
    }

    public final void K(d.a.n0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            d.a.n0.a.i1.g.c cVar2 = this.f51193i;
            if (cVar2 != null && cVar != null && !TextUtils.isEmpty(cVar2.C) && !TextUtils.isEmpty(cVar.C) && !TextUtils.equals(this.f51193i.C, cVar.C)) {
                this.f51190f = true;
            } else {
                this.f51190f = false;
            }
        }
    }

    public a L(Context context, @NonNull d.a.n0.a.i1.g.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar)) == null) {
            this.f51186b = context;
            this.f51193i = cVar;
            O();
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f51191g) {
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
            if (this.f51193i == null) {
                d.a.n0.a.c0.g.a.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
            }
            if (this.f51187c == null) {
                this.f51187c = new VideoContainerManager(this.f51186b, this.f51193i);
            }
            return this.f51187c;
        }
        return (VideoContainerManager) invokeV.objValue;
    }

    public final SwanVideoView P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f51185a == null) {
                d.a.n0.a.e0.d.g("video", "create player");
                this.f51185a = new SwanVideoView(this.f51186b);
                Q();
            }
            return this.f51185a;
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
            k.runOnUiThread(new RunnableC1160a(this, k));
            this.q = true;
            this.f51185a.setIsLandscape(true);
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
            this.f51185a.setIsLandscape(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void U() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (swanVideoView = this.f51185a) == null) {
            return;
        }
        swanVideoView.D();
        g.b(this.f51185a);
        this.f51185a = null;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && f0()) {
            if (this.f51189e != 0) {
                P().B(this.f51189e);
                this.f51189e = 0;
                return;
            }
            int i2 = this.f51193i.q;
            if (i2 != 0) {
                this.f51185a.B(i2 * 1000);
                this.f51193i.q = 0;
                return;
            }
            int i3 = this.r;
            if (i3 != 0) {
                this.f51185a.B(i3);
                this.r = 0;
            }
        }
    }

    public final void W(d.a.n0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (cVar == null) {
                d.a.n0.a.e0.d.b("SwanAppVideoPlayer", "setDataSource params is null!");
                return;
            }
            P().setVideoPath(this.f51193i.C);
            d.a.n0.a.e0.d.a("video", "setDataSource url " + cVar.C);
        }
    }

    public final void X(d.a.n0.a.i1.g.c cVar) {
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

    public final boolean Y(d.a.n0.a.i1.g.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cVar)) == null) {
            d.a.n0.a.i1.g.c cVar2 = this.f51193i;
            if (cVar2 == null) {
                return false;
            }
            if (cVar2.o == cVar.o && cVar2.B == cVar.B && TextUtils.equals(cVar2.u, cVar.u)) {
                d.a.n0.a.i1.g.c cVar3 = this.f51193i;
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

    @Override // d.a.n0.a.c1.d.j
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
            X(this.f51193i);
            h(this.f51193i, false);
            W(this.f51193i);
            P().C();
            this.f51190f = false;
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public final void b0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (swanVideoView = this.f51185a) == null) {
            return;
        }
        swanVideoView.D();
    }

    @Override // d.a.n0.a.c1.d.j
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
            if (this.f51185a == null || z || !isPlaying()) {
                return;
            }
            this.f51185a.x();
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
        }
    }

    public void d0(d.a.n0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            O().Q(cVar);
            e0();
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public /* bridge */ /* synthetic */ j e(Context context, @NonNull d.a.n0.a.i1.g.c cVar) {
        L(context, cVar);
        return this;
    }

    public final void e0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (swanVideoView = this.f51185a) == null) {
            return;
        }
        g.b(swanVideoView);
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            frameLayout.addView(this.f51185a);
        } else {
            O().J().addView(this.f51185a);
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    public final boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            d.a.n0.a.i1.g.c cVar = this.f51193i;
            return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f51193i.n) || TextUtils.isEmpty(this.f51193i.f43477f)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.c1.d.j
    public void g(j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            this.m = aVar;
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? P().getCurrentPosition() : invokeV.intValue;
    }

    @Override // d.a.n0.a.c1.d.j
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? P().getDuration() : invokeV.intValue;
    }

    @Override // d.a.n0.a.c1.d.j
    public void h(d.a.n0.a.i1.g.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, cVar, z) == null) {
            if (s) {
                Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
            }
            d.a.n0.a.e0.d.a("video", "updatePlayerConfigInternal params: " + cVar.toString());
            if (Y(cVar)) {
                X(cVar);
            }
            this.f51193i = cVar;
            if (z) {
                c0(cVar.l());
            }
            d0(cVar);
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f51192h : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.c1.d.j
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            SwanVideoView swanVideoView = this.f51185a;
            if (swanVideoView == null) {
                return false;
            }
            return swanVideoView.v();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.c1.d.j
    public void j(j.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, eVar) == null) {
            this.n = eVar;
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void k(j.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, fVar) == null) {
            this.o = fVar;
        }
    }

    @Override // d.a.n0.a.c1.d.j
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

    @Override // d.a.n0.a.c1.d.j
    public void m(j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, dVar) == null) {
            this.k = dVar;
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            P().setMuted(z);
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void n(d.a.n0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, cVar) == null) {
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void o(d.a.n0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, cVar) == null) {
            d.a.n0.a.e0.d.a("video", "Open Player " + cVar.n);
            K(cVar);
            this.f51193i = cVar;
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

    @Override // d.a.n0.a.c1.d.j
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? R() && T() : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.c1.d.j
    public void p(j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bVar) == null) {
            this.l = bVar;
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            P().x();
            this.f51188d = true;
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void q(j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, cVar) == null) {
            this.p = cVar;
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.f51188d && !this.f51190f) {
                P().C();
            } else {
                a0();
            }
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048623, this, i2) == null) && f0()) {
            if (!this.f51190f) {
                P().B(i2);
            } else {
                this.f51189e = i2;
            }
        }
    }

    @Override // d.a.n0.a.c1.d.j
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            d.a.n0.a.e0.d.a("video", IntentConfig.STOP);
            U();
            P().y();
        }
    }
}
