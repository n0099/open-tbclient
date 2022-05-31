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
import com.repackage.nj2;
import com.repackage.vg4;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public class sg4 implements nj2 {
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
    public bo2 j;
    public FrameLayout k;
    public nj2.d l;
    public nj2.b m;
    public nj2.a n;
    public nj2.e o;
    public nj2.f p;
    public nj2.c q;
    public boolean r;
    public int s;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ sg4 b;

        public a(sg4 sg4Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg4Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sg4Var;
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
                fg4.b(G);
                fg4.a(this.a, G);
                rg4.c(this.b.j.j, this.b.j.c, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg4 a;

        public b(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fg4.b(this.a.R().G());
                this.a.R().insert();
                rg4.c(this.a.j.j, this.a.j.c, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg4 a;

        public c(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg4Var;
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
        public final /* synthetic */ sg4 a;

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
                    rg4.b(this.b.a.j.j, this.b.a.j.c, this.a, this.b.a.S().getWidth(), this.b.a.S().getHeight());
                }
            }
        }

        public d(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg4Var;
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
                    if (sg4.t) {
                        Log.e("SwanAppVideoPlayer", "preloadVideoMetadata: ", e);
                    }
                    mediaMetadataRetriever.release();
                    rg4.a(this.a.j.j, this.a.j.c, "error", pg4.c(0));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class e implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg4 a;

        public e(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg4Var;
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

        public /* synthetic */ e(sg4 sg4Var, a aVar) {
            this(sg4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends hg4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg4 a;

        public f(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg4Var;
        }

        @Override // com.repackage.gg4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d = false;
                rg4.a(this.a.j.j, this.a.j.c, "ended", new JSONObject());
                if (this.a.n != null) {
                    this.a.n.b(this.a);
                }
                this.a.i = true;
                this.a.S().c0(MediaTipStateLayer.TipState.END);
                hw1.b("video", "onEnded call back");
            }
        }

        @Override // com.repackage.gg4
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a.j.k = z;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("muted", Boolean.valueOf(z));
                } catch (JSONException e) {
                    if (sg4.t) {
                        e.printStackTrace();
                    }
                }
                rg4.a(this.a.j.j, this.a.j.c, "muted", jSONObject);
            }
        }

        @Override // com.repackage.gg4
        public void c(SwanVideoView swanVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanVideoView) == null) {
                int currentPosition = swanVideoView.getCurrentPosition() / 1000;
                int duration = swanVideoView.getDuration() / 1000;
                int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
                if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                    hw1.b("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                    rg4.a(this.a.j.j, this.a.j.c, "waiting", new JSONObject());
                    return;
                }
                hw1.b("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                e(currentPosition, duration);
            }
        }

        @Override // com.repackage.gg4
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
                    if (sg4.t) {
                        e.printStackTrace();
                    }
                }
                rg4.a(this.a.j.j, this.a.j.c, "timeupdate", jSONObject);
            }
        }

        @Override // com.repackage.gg4
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, str) == null) {
                this.a.d = false;
                hw1.c("video", "errorCode :" + i);
                this.a.R().J();
                this.a.R().K();
                rg4.a(this.a.j.j, this.a.j.c, "error", pg4.c(i2));
                if (this.a.m != null) {
                    this.a.m.f(this.a, i, i2);
                }
                this.a.i = false;
                int currentPosition = this.a.S().getCurrentPosition();
                sg4 sg4Var = this.a;
                if (currentPosition <= 0) {
                    currentPosition = sg4Var.s;
                }
                sg4Var.s = currentPosition;
                this.a.S().c0(MediaTipStateLayer.TipState.ERROR);
                hw1.c("video", "onError what " + i + " ,extra " + i2);
            }
        }

        @Override // com.repackage.gg4
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                rg4.a(this.a.j.j, this.a.j.c, "pause", new JSONObject());
                hw1.b("video", "onPaused call back");
                this.a.d = true;
                if (this.a.q != null) {
                    this.a.q.c(this.a);
                }
            }
        }

        @Override // com.repackage.gg4
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                hw1.b("video", "onPrepared call back");
                this.a.a0();
                this.a.P();
                if (this.a.l != null) {
                    this.a.l.e(this.a);
                }
            }
        }

        @Override // com.repackage.hg4, com.repackage.gg4
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onResume();
                rg4.a(this.a.j.j, this.a.j.c, "play", new JSONObject());
                this.a.i = false;
                this.a.d = false;
                this.a.R().K();
                if (this.a.o != null) {
                    this.a.o.a(this.a);
                }
            }
        }

        @Override // com.repackage.gg4
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                rg4.a(this.a.j.j, this.a.j.c, "play", new JSONObject());
                this.a.i = false;
                this.a.d = false;
                this.a.R().K();
                if (this.a.p != null) {
                    this.a.p.d(this.a);
                }
            }
        }

        public /* synthetic */ f(sg4 sg4Var, a aVar) {
            this(sg4Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755321519, "Lcom/repackage/sg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755321519, "Lcom/repackage/sg4;");
                return;
            }
        }
        t = rf1.a;
    }

    public sg4() {
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

    public final void M(bo2 bo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bo2Var) == null) {
            bo2 bo2Var2 = this.j;
            if (bo2Var2 != null && bo2Var != null && !TextUtils.isEmpty(bo2Var2.y) && !TextUtils.isEmpty(bo2Var.y) && !TextUtils.equals(this.j.y, bo2Var.y)) {
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

    public sg4 O(Context context, @NonNull bo2 bo2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bo2Var)) == null) {
            this.b = context;
            this.j = bo2Var;
            R();
            return this;
        }
        return (sg4) invokeLL.objValue;
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
                aw1.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
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
            hw1.i("video", "create player");
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
                bo2 bo2Var = this.j;
                rg4.a(bo2Var.j, bo2Var.c, "error", pg4.c(0));
                return;
            }
            if (!this.j.i() || !this.j.o()) {
                U();
                i0(this.j);
            }
            bc3.k(new d(this), "preloadVideoMetadata");
        }
    }

    public final boolean X() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            hz2 L = hz2.L();
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
            hz2 L = hz2.L();
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
        fg4.b(this.a);
        this.a = null;
    }

    @Override // com.repackage.nj2
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

    @Override // com.repackage.nj2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public final void b0(bo2 bo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bo2Var) == null) {
            if (bo2Var == null) {
                hw1.c("SwanAppVideoPlayer", "setDataSource params is null!");
                return;
            }
            S().setVideoPath(this.j.y);
            hw1.b("video", "setDataSource url " + bo2Var.y);
        }
    }

    @Override // com.repackage.nj2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public final void c0(bo2 bo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bo2Var) == null) {
            if (bo2Var.S) {
                S().W(true);
                S().V(bo2Var.U);
                S().setSilentTips(bo2Var.V);
                mute(true);
            } else {
                S().W(false);
                mute(bo2Var.k);
            }
            vg4.b bVar = new vg4.b();
            bVar.k(bo2Var.S);
            bVar.i(bo2Var.L);
            bVar.h(bo2Var.D);
            bVar.g(bo2Var.M);
            bVar.j(bo2Var.H);
            S().setMediaGesture(bVar.f());
            S().setMediaControllerEnabled(bo2Var.x);
            S().setLooping(bo2Var.p);
            S().M(bo2Var.G);
            S().N(bo2Var.m());
            S().K(bo2Var.k());
            S().O(bo2Var.n());
            S().P(bo2Var.P);
            S().L(bo2Var.w);
            S().S(bo2Var.E);
            S().T(bo2Var.R);
            S().setTitle(bo2Var.K);
            if (TextUtils.equals(bo2Var.q, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                S().setVideoScalingMode(2);
            } else if (TextUtils.equals(bo2Var.q, "fill")) {
                S().setVideoScalingMode(3);
            } else {
                S().setVideoScalingMode(1);
            }
            l(bo2Var.Q, bo2Var.F);
        }
    }

    @Override // com.repackage.nj2
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public final boolean d0(bo2 bo2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bo2Var)) == null) {
            bo2 bo2Var2 = this.j;
            if (bo2Var2 == null) {
                return false;
            }
            if (bo2Var2.k == bo2Var.k && bo2Var2.x == bo2Var.x && TextUtils.equals(bo2Var2.q, bo2Var.q)) {
                bo2 bo2Var3 = this.j;
                if (bo2Var3.H == bo2Var.H && bo2Var3.D == bo2Var.D && bo2Var3.E == bo2Var.E && bo2Var3.G == bo2Var.G && bo2Var3.L == bo2Var.L && bo2Var3.S == bo2Var.S && bo2Var3.F == bo2Var.F && bo2Var3.P == bo2Var.P && bo2Var3.n() == bo2Var.n() && this.j.k() == bo2Var.k() && this.j.m() == bo2Var.m() && this.j.l() == bo2Var.l() && TextUtils.equals(this.j.K, bo2Var.K)) {
                    bo2 bo2Var4 = this.j;
                    if (bo2Var4.R == bo2Var.R && bo2Var4.Q == bo2Var.Q && bo2Var4.M == bo2Var.M && bo2Var4.p == bo2Var.p) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.nj2
    public /* bridge */ /* synthetic */ nj2 e(Context context, @NonNull bo2 bo2Var) {
        O(context, bo2Var);
        return this;
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            R().M(new c(this));
        }
    }

    @Override // com.repackage.nj2
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

    @Override // com.repackage.nj2
    public void g(nj2.a aVar) {
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

    @Override // com.repackage.nj2
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? S().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.nj2
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? S().getDuration() : invokeV.intValue;
    }

    @Override // com.repackage.nj2
    public void h(bo2 bo2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, bo2Var, z) == null) {
            if (t) {
                Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + bo2Var.toString());
            }
            hw1.b("video", "updatePlayerConfigInternal params: " + bo2Var.toString());
            if (d0(bo2Var)) {
                c0(bo2Var);
            }
            this.j = bo2Var;
            if (z) {
                h0(bo2Var.o());
            }
            i0(bo2Var);
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

    @Override // com.repackage.nj2
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
        }
    }

    public void i0(bo2 bo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bo2Var) == null) {
            R().O(bo2Var);
            j0();
        }
    }

    @Override // com.repackage.nj2
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.i : invokeV.booleanValue;
    }

    @Override // com.repackage.nj2
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

    @Override // com.repackage.nj2
    public void j(nj2.e eVar) {
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
        fg4.b(swanVideoView);
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.addView(this.a);
        } else {
            R().H().addView(this.a);
        }
    }

    @Override // com.repackage.nj2
    public void k(nj2.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            bo2 bo2Var = this.j;
            return (bo2Var == null || TextUtils.isEmpty(bo2Var.y) || TextUtils.isEmpty(this.j.j) || TextUtils.isEmpty(this.j.b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nj2
    public void l(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || wg4.a() == z) {
            return;
        }
        if (z) {
            X();
        } else {
            Y();
        }
    }

    @Override // com.repackage.nj2
    public void m(nj2.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, dVar) == null) {
            this.l = dVar;
        }
    }

    @Override // com.repackage.nj2
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            S().setMuted(z);
        }
    }

    @Override // com.repackage.nj2
    public void n(bo2 bo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bo2Var) == null) {
        }
    }

    @Override // com.repackage.nj2
    public void o(bo2 bo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bo2Var) == null) {
            hw1.b("video", "Open Player " + bo2Var.j);
            M(bo2Var);
            this.j = bo2Var;
            i0(bo2Var);
            boolean j = bo2Var.j();
            this.h = j;
            if (j) {
                W();
            }
            if (bo2Var.i() && bo2Var.o()) {
                f0();
                return;
            }
            g0();
            e0();
            R().N(bo2Var.l, bo2Var.q);
        }
    }

    @Override // com.repackage.nj2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? V() && Y() : invokeV.booleanValue;
    }

    @Override // com.repackage.nj2
    public void p(nj2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bVar) == null) {
            this.m = bVar;
        }
    }

    @Override // com.repackage.nj2
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            S().C();
            this.d = true;
        }
    }

    @Override // com.repackage.nj2
    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) ? S().I(str) : invokeL.intValue;
    }

    @Override // com.repackage.nj2
    public void r(nj2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, cVar) == null) {
            this.q = cVar;
        }
    }

    @Override // com.repackage.nj2
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

    @Override // com.repackage.nj2
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

    @Override // com.repackage.nj2
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            hw1.b("video", IntentConfig.STOP);
            Z();
            S().D();
        }
    }
}
