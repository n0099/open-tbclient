package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import com.baidu.swan.videoplayer.widget.MediaTipStateLayer;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pk2;
import com.repackage.xh4;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public class uh4 implements pk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanVideoView a;
    public Context b;
    public VideoContainerManager c;
    public boolean d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public dp2 j;
    public FrameLayout k;
    public pk2.d l;
    public pk2.b m;
    public pk2.a n;
    public pk2.e o;
    public pk2.f p;
    public pk2.c q;
    public boolean r;
    public int s;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ uh4 b;

        public a(uh4 uh4Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh4Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uh4Var;
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setRequestedOrientation(0);
                this.a.getWindow().addFlags(1024);
                this.b.Q(this.a);
                SwanAppComponentContainerView G = this.b.R().G();
                G.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                hh4.b(G);
                hh4.a(this.a, G);
                th4.c(this.b.j.j, this.b.j.c, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh4 a;

        public b(uh4 uh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uh4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hh4.b(this.a.R().G());
                this.a.R().insert();
                th4.c(this.a.j.j, this.a.j.c, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh4 a;

        public c(uh4 uh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uh4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh4 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ d b;

            public a(d dVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    th4.b(this.b.a.j.j, this.b.a.j.c, this.a, this.b.a.S().getWidth(), this.b.a.S().getHeight());
                }
            }
        }

        public d(uh4 uh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uh4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(this.a.j.y, new HashMap());
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    mediaMetadataRetriever.release();
                    this.a.S().post(new a(this, extractMetadata));
                } catch (RuntimeException e) {
                    if (uh4.t) {
                        Log.e("SwanAppVideoPlayer", "preloadVideoMetadata: ", e);
                    }
                    mediaMetadataRetriever.release();
                    th4.a(this.a.j.j, this.a.j.c, "error", rh4.c(0));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class e implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh4 a;

        public e(uh4 uh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uh4Var;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != -1) {
                    if (i != 1) {
                        return;
                    }
                    this.a.S().X();
                    return;
                }
                this.a.stop();
                this.a.e0();
                this.a.R().N(this.a.j.l, this.a.j.q);
            }
        }

        public /* synthetic */ e(uh4 uh4Var, a aVar) {
            this(uh4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends jh4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh4 a;

        public f(uh4 uh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uh4Var;
        }

        @Override // com.repackage.ih4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d = false;
                th4.a(this.a.j.j, this.a.j.c, "ended", new JSONObject());
                if (this.a.n != null) {
                    this.a.n.b(this.a);
                }
                this.a.i = true;
                this.a.S().c0(MediaTipStateLayer.TipState.END);
                jx1.b("video", "onEnded call back");
            }
        }

        @Override // com.repackage.ih4
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a.j.k = z;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("muted", Boolean.valueOf(z));
                } catch (JSONException e) {
                    if (uh4.t) {
                        e.printStackTrace();
                    }
                }
                th4.a(this.a.j.j, this.a.j.c, "muted", jSONObject);
            }
        }

        @Override // com.repackage.ih4
        public void c(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanVideoView) == null) {
                int currentPosition = swanVideoView.getCurrentPosition() / 1000;
                int duration = swanVideoView.getDuration() / 1000;
                int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
                if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                    jx1.b("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                    th4.a(this.a.j.j, this.a.j.c, "waiting", new JSONObject());
                    return;
                }
                jx1.b("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                e(currentPosition, duration);
            }
        }

        @Override // com.repackage.ih4
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.a.j.Q = z;
                if (z) {
                    this.a.X();
                } else {
                    this.a.Y();
                }
            }
        }

        public final void e(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Integer.valueOf(i2));
                    jSONObject.putOpt("currentTime", Integer.valueOf(i));
                } catch (JSONException e) {
                    if (uh4.t) {
                        e.printStackTrace();
                    }
                }
                th4.a(this.a.j.j, this.a.j.c, "timeupdate", jSONObject);
            }
        }

        @Override // com.repackage.ih4
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) {
                this.a.d = false;
                jx1.c("video", "errorCode :" + i);
                this.a.R().J();
                this.a.R().K();
                th4.a(this.a.j.j, this.a.j.c, "error", rh4.c(i2));
                if (this.a.m != null) {
                    this.a.m.f(this.a, i, i2);
                }
                this.a.i = false;
                int currentPosition = this.a.S().getCurrentPosition();
                uh4 uh4Var = this.a;
                if (currentPosition <= 0) {
                    currentPosition = uh4Var.s;
                }
                uh4Var.s = currentPosition;
                this.a.S().c0(MediaTipStateLayer.TipState.ERROR);
                jx1.c("video", "onError what " + i + " ,extra " + i2);
            }
        }

        @Override // com.repackage.ih4
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                th4.a(this.a.j.j, this.a.j.c, "pause", new JSONObject());
                jx1.b("video", "onPaused call back");
                this.a.d = true;
                if (this.a.q != null) {
                    this.a.q.c(this.a);
                }
            }
        }

        @Override // com.repackage.ih4
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                jx1.b("video", "onPrepared call back");
                this.a.a0();
                this.a.P();
                if (this.a.l != null) {
                    this.a.l.e(this.a);
                }
            }
        }

        @Override // com.repackage.jh4, com.repackage.ih4
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onResume();
                th4.a(this.a.j.j, this.a.j.c, "play", new JSONObject());
                this.a.i = false;
                this.a.d = false;
                this.a.R().K();
                if (this.a.o != null) {
                    this.a.o.a(this.a);
                }
            }
        }

        @Override // com.repackage.ih4
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                th4.a(this.a.j.j, this.a.j.c, "play", new JSONObject());
                this.a.i = false;
                this.a.d = false;
                this.a.R().K();
                if (this.a.p != null) {
                    this.a.p.d(this.a);
                }
            }
        }

        public /* synthetic */ f(uh4 uh4Var, a aVar) {
            this(uh4Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755260976, "Lcom/repackage/uh4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755260976, "Lcom/repackage/uh4;");
                return;
            }
        }
        t = tg1.a;
    }

    public uh4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = true;
        this.s = 0;
    }

    public final void M(dp2 dp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dp2Var) == null) {
            dp2 dp2Var2 = this.j;
            if (dp2Var2 != null && dp2Var != null && !TextUtils.isEmpty(dp2Var2.y) && !TextUtils.isEmpty(dp2Var.y) && !TextUtils.equals(this.j.y, dp2Var.y)) {
                this.f = true;
            } else {
                this.f = false;
            }
        }
    }

    public final boolean N(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (!SwanAppNetworkUtils.h()) {
                R().J();
                R().K();
                S().c0(MediaTipStateLayer.TipState.NO_NETWORK);
                return false;
            } else if (z) {
                if (SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._2G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._3G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._4G || SwanAppNetworkUtils.f() == SwanAppNetworkUtils.NetType._5G) {
                    R().J();
                    R().K();
                    S().c0(MediaTipStateLayer.TipState.NO_WIFI);
                    return false;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeZ.booleanValue;
    }

    public uh4 O(Context context, @NonNull dp2 dp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, dp2Var)) == null) {
            this.b = context;
            this.j = dp2Var;
            R();
            return this;
        }
        return (uh4) invokeLL.objValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.g) {
            return;
        }
        pause();
    }

    public final void Q(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public final VideoContainerManager R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.j == null) {
                cx1.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
            }
            if (this.c == null) {
                this.c = new VideoContainerManager(this.b, this.j);
            }
            return this.c;
        }
        return (VideoContainerManager) invokeV.objValue;
    }

    public final SwanVideoView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            U();
            return this.a;
        }
        return (SwanVideoView) invokeV.objValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            S().setVideoPlayerCallback(new f(this, null));
            S().setAudioFocusListener(new e(this, null));
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a == null) {
            jx1.i("video", "create player");
            this.a = new SwanVideoView(this.b);
            T();
        }
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!SwanAppNetworkUtils.h()) {
                dp2 dp2Var = this.j;
                th4.a(dp2Var.j, dp2Var.c, "error", rh4.c(0));
                return;
            }
            if (!this.j.i() || !this.j.o()) {
                U();
                i0(this.j);
            }
            dd3.k(new d(this), "preloadVideoMetadata");
        }
    }

    public final boolean X() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            j03 L = j03.L();
            if (L == null || (activity = L.getActivity()) == null || activity.isFinishing()) {
                return false;
            }
            activity.runOnUiThread(new a(this, activity));
            this.r = true;
            this.a.setIsLandscape(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            j03 L = j03.L();
            if (L == null || (activity = L.getActivity()) == null || activity.isFinishing()) {
                return false;
            }
            activity.setRequestedOrientation(1);
            activity.getWindow().clearFlags(1024);
            activity.runOnUiThread(new b(this));
            this.r = false;
            this.a.setIsLandscape(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (swanVideoView = this.a) == null) {
            return;
        }
        swanVideoView.Z();
        hh4.b(this.a);
        this.a = null;
    }

    @Override // com.repackage.pk2
    public void a(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frameLayout) == null) {
            this.k = frameLayout;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && k0()) {
            if (this.e != 0) {
                S().H(this.e);
                this.e = 0;
                return;
            }
            int i = this.j.m;
            if (i != 0) {
                this.a.H(i * 1000);
                this.j.m = 0;
                return;
            }
            int i2 = this.s;
            if (i2 != 0) {
                this.a.H(i2);
                this.s = 0;
            }
        }
    }

    @Override // com.repackage.pk2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public final void b0(dp2 dp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dp2Var) == null) {
            if (dp2Var == null) {
                jx1.c("SwanAppVideoPlayer", "setDataSource params is null!");
                return;
            }
            S().setVideoPath(this.j.y);
            jx1.b("video", "setDataSource url " + dp2Var.y);
        }
    }

    @Override // com.repackage.pk2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public final void c0(dp2 dp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dp2Var) == null) {
            if (dp2Var.S) {
                S().W(true);
                S().V(dp2Var.U);
                S().setSilentTips(dp2Var.V);
                mute(true);
            } else {
                S().W(false);
                mute(dp2Var.k);
            }
            xh4.b bVar = new xh4.b();
            bVar.k(dp2Var.S);
            bVar.i(dp2Var.L);
            bVar.h(dp2Var.D);
            bVar.g(dp2Var.M);
            bVar.j(dp2Var.H);
            S().setMediaGesture(bVar.f());
            S().setMediaControllerEnabled(dp2Var.x);
            S().setLooping(dp2Var.p);
            S().M(dp2Var.G);
            S().N(dp2Var.m());
            S().K(dp2Var.k());
            S().O(dp2Var.n());
            S().P(dp2Var.P);
            S().L(dp2Var.w);
            S().S(dp2Var.E);
            S().T(dp2Var.R);
            S().setTitle(dp2Var.K);
            if (TextUtils.equals(dp2Var.q, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                S().setVideoScalingMode(2);
            } else if (TextUtils.equals(dp2Var.q, "fill")) {
                S().setVideoScalingMode(3);
            } else {
                S().setVideoScalingMode(1);
            }
            l(dp2Var.Q, dp2Var.F);
        }
    }

    @Override // com.repackage.pk2
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public final boolean d0(dp2 dp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, dp2Var)) == null) {
            dp2 dp2Var2 = this.j;
            if (dp2Var2 == null) {
                return false;
            }
            if (dp2Var2.k == dp2Var.k && dp2Var2.x == dp2Var.x && TextUtils.equals(dp2Var2.q, dp2Var.q)) {
                dp2 dp2Var3 = this.j;
                if (dp2Var3.H == dp2Var.H && dp2Var3.D == dp2Var.D && dp2Var3.E == dp2Var.E && dp2Var3.G == dp2Var.G && dp2Var3.L == dp2Var.L && dp2Var3.S == dp2Var.S && dp2Var3.F == dp2Var.F && dp2Var3.P == dp2Var.P && dp2Var3.n() == dp2Var.n() && this.j.k() == dp2Var.k() && this.j.m() == dp2Var.m() && this.j.l() == dp2Var.l() && TextUtils.equals(this.j.K, dp2Var.K)) {
                    dp2 dp2Var4 = this.j;
                    if (dp2Var4.R == dp2Var.R && dp2Var4.Q == dp2Var.Q && dp2Var4.M == dp2Var.M && dp2Var4.p == dp2Var.p) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.pk2
    public /* bridge */ /* synthetic */ pk2 e(Context context, @NonNull dp2 dp2Var) {
        O(context, dp2Var);
        return this;
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            R().M(new c(this));
        }
    }

    @Override // com.repackage.pk2
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && k0()) {
            R().J();
            Z();
            S().B();
            c0(this.j);
            h(this.j, false);
            b0(this.j);
            if (N(this.j.J)) {
                S().Y();
            }
            this.f = false;
        }
    }

    @Override // com.repackage.pk2
    public void g(pk2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public final void g0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (swanVideoView = this.a) == null) {
            return;
        }
        swanVideoView.Z();
    }

    @Override // com.repackage.pk2
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? S().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.pk2
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? S().getDuration() : invokeV.intValue;
    }

    @Override // com.repackage.pk2
    public void h(dp2 dp2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, dp2Var, z) == null) {
            if (t) {
                Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + dp2Var.toString());
            }
            jx1.b("video", "updatePlayerConfigInternal params: " + dp2Var.toString());
            if (d0(dp2Var)) {
                c0(dp2Var);
            }
            this.j = dp2Var;
            if (z) {
                h0(dp2Var.o());
            }
            i0(dp2Var);
        }
    }

    public final void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (t) {
                Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
            }
            if (this.a == null || z || !isPlaying()) {
                return;
            }
            this.a.C();
        }
    }

    @Override // com.repackage.pk2
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
        }
    }

    public void i0(dp2 dp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dp2Var) == null) {
            R().O(dp2Var);
            j0();
        }
    }

    @Override // com.repackage.pk2
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.i : invokeV.booleanValue;
    }

    @Override // com.repackage.pk2
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            SwanVideoView swanVideoView = this.a;
            if (swanVideoView == null) {
                return false;
            }
            return swanVideoView.z();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.pk2
    public void j(pk2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public final void j0() {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (swanVideoView = this.a) == null) {
            return;
        }
        hh4.b(swanVideoView);
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.addView(this.a);
        } else {
            R().H().addView(this.a);
        }
    }

    @Override // com.repackage.pk2
    public void k(pk2.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            dp2 dp2Var = this.j;
            return (dp2Var == null || TextUtils.isEmpty(dp2Var.y) || TextUtils.isEmpty(this.j.j) || TextUtils.isEmpty(this.j.b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.pk2
    public void l(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || yh4.a() == z) {
            return;
        }
        if (z) {
            X();
        } else {
            Y();
        }
    }

    @Override // com.repackage.pk2
    public void m(pk2.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, dVar) == null) {
            this.l = dVar;
        }
    }

    @Override // com.repackage.pk2
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            S().setMuted(z);
        }
    }

    @Override // com.repackage.pk2
    public void n(dp2 dp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, dp2Var) == null) {
        }
    }

    @Override // com.repackage.pk2
    public void o(dp2 dp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, dp2Var) == null) {
            jx1.b("video", "Open Player " + dp2Var.j);
            M(dp2Var);
            this.j = dp2Var;
            i0(dp2Var);
            boolean j = dp2Var.j();
            this.h = j;
            if (j) {
                W();
            }
            if (dp2Var.i() && dp2Var.o()) {
                f0();
                return;
            }
            g0();
            e0();
            R().N(dp2Var.l, dp2Var.q);
        }
    }

    @Override // com.repackage.pk2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? V() && Y() : invokeV.booleanValue;
    }

    @Override // com.repackage.pk2
    public void p(pk2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bVar) == null) {
            this.m = bVar;
        }
    }

    @Override // com.repackage.pk2
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            S().C();
            this.d = true;
        }
    }

    @Override // com.repackage.pk2
    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) ? S().I(str) : invokeL.intValue;
    }

    @Override // com.repackage.pk2
    public void r(pk2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, cVar) == null) {
            this.q = cVar;
        }
    }

    @Override // com.repackage.pk2
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.d && !this.f) {
                S().X();
            } else {
                f0();
            }
        }
    }

    @Override // com.repackage.pk2
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048627, this, i) == null) && k0()) {
            if (!this.f) {
                S().H(i);
            } else {
                this.e = i;
            }
        }
    }

    @Override // com.repackage.pk2
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            jx1.b("video", IntentConfig.STOP);
            Z();
            S().D();
        }
    }
}
