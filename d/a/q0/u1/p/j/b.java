package d.a.q0.u1.p.j;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.rtc.RTCCommStatesReport;
import com.baidu.rtc.player.BRTCPlayer;
import com.baidu.rtc.player.BRTCPlayerEvents;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.IPlayerViewable;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.tieba.medialive.player.bdrtc.TbBRTCPlayerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b extends d.a.q0.u1.p.j.a implements LivePlayer, IPlayerViewable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbBRTCPlayerView p;
    public boolean q;
    public BuildParams r;
    public RTCCommStatesReport s;

    /* loaded from: classes8.dex */
    public class a implements BRTCPlayerEvents {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64755a;

        /* renamed from: d.a.q0.u1.p.j.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1746a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f64756e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f64757f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f64758g;

            public RunnableC1746a(a aVar, int i2, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64758g = aVar;
                this.f64756e = i2;
                this.f64757f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f64758g.f64755a.f64746f) == null) {
                    return;
                }
                iVideoPlayerCallback.onError(this.f64756e, 0, this.f64757f);
            }
        }

        /* renamed from: d.a.q0.u1.p.j.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1747b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f64759e;

            public RunnableC1747b(a aVar) {
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
                this.f64759e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f64759e.f64755a.f64746f) == null) {
                    return;
                }
                iVideoPlayerCallback.onInfo(904, 0);
                this.f64759e.f64755a.f64746f.onInfo(3, 0);
                this.f64759e.f64755a.f64746f.onInfo(CyberPlayerManager.MEDIA_INFO_PROCESS, 0);
                this.f64759e.f64755a.f64746f.onInfo(702, 0);
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f64760e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Object f64761f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f64762g;

            public c(a aVar, int i2, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), obj};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64762g = aVar;
                this.f64760e = i2;
                this.f64761f = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f64762g.f64755a.f64746f) == null) {
                    return;
                }
                iVideoPlayerCallback.onInfo(this.f64760e, 0);
                if (this.f64760e == 1003 && this.f64762g.f64755a.p.k()) {
                    Object obj = this.f64761f;
                    if (obj instanceof RTCCommStatesReport) {
                        this.f64762g.f64755a.s = (RTCCommStatesReport) obj;
                    }
                    this.f64762g.f64755a.f64746f.onInfo(CyberPlayerManager.MEDIA_INFO_PROCESS, 0);
                    return;
                }
                int i2 = this.f64760e;
                if (i2 == 1004) {
                    this.f64762g.f64755a.f64746f.onBufferStart();
                    this.f64762g.f64755a.f64746f.onInfo(701, 0);
                } else if (i2 == 1005) {
                    this.f64762g.f64755a.f64746f.onBufferEnd();
                    this.f64762g.f64755a.f64746f.onInfo(702, 0);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f64763e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f64764f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f64765g;

            public d(a aVar, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64765g = aVar;
                this.f64763e = i2;
                this.f64764f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerCallback iVideoPlayerCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoPlayerCallback = this.f64765g.f64755a.f64746f) == null) {
                    return;
                }
                iVideoPlayerCallback.onVideoSizeChanged(this.f64763e, this.f64764f);
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64755a = bVar;
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onError(int i2, String str) {
            b bVar;
            TbBRTCPlayerView tbBRTCPlayerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || (tbBRTCPlayerView = (bVar = this.f64755a).p) == null || bVar.f64746f == null) {
                return;
            }
            tbBRTCPlayerView.post(new RunnableC1746a(this, i2, str));
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onFirstFrameRendered() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f64755a.a("onFirstFrameRendered invoked");
                b bVar = this.f64755a;
                TbBRTCPlayerView tbBRTCPlayerView = bVar.p;
                if (tbBRTCPlayerView == null || bVar.f64746f == null) {
                    return;
                }
                tbBRTCPlayerView.post(new RunnableC1747b(this));
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onInfoUpdated(int i2, Object obj) {
            b bVar;
            TbBRTCPlayerView tbBRTCPlayerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, obj) == null) || (tbBRTCPlayerView = (bVar = this.f64755a).p) == null || bVar.f64746f == null) {
                return;
            }
            tbBRTCPlayerView.post(new c(this, i2, obj));
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onPlayerStateChanged(BRTCPlayer.PlayerState playerState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, playerState) == null) {
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteData(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onRemoteStreamStats(boolean z, boolean z2, BigInteger bigInteger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), bigInteger}) == null) {
            }
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onResolutionChanged(int i2, int i3) {
            b bVar;
            TbBRTCPlayerView tbBRTCPlayerView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || (tbBRTCPlayerView = (bVar = this.f64755a).p) == null || bVar.f64746f == null) {
                return;
            }
            tbBRTCPlayerView.post(new d(this, i2, i3));
        }

        @Override // com.baidu.rtc.player.BRTCPlayerEvents
        public void onSEIRecv(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, byteBuffer) == null) {
                this.f64755a.d(10103, 0, byteBuffer);
            }
        }
    }

    public b(BuildParams buildParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buildParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = buildParams;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.IPlayerViewable
    public void attachKernelView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (view instanceof TbBRTCPlayerView) {
                this.p = (TbBRTCPlayerView) view;
            }
            attachToContainer(this.j);
        }
    }

    @Override // d.a.q0.u1.p.j.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void attachToContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            a("attachToContainer " + viewGroup);
            super.attachToContainer(viewGroup);
            if (this.p == null) {
                b(viewGroup.getContext());
                TbBRTCPlayerView tbBRTCPlayerView = new TbBRTCPlayerView(viewGroup.getContext());
                this.p = tbBRTCPlayerView;
                tbBRTCPlayerView.setParams(this.r);
                this.p.setBRTCPlayerEvents(new a(this));
            }
            TbBRTCPlayerView tbBRTCPlayerView2 = this.p;
            if (tbBRTCPlayerView2 == null || tbBRTCPlayerView2.getParent() == viewGroup) {
                return;
            }
            this.p.f(viewGroup);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void detachFromContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a("detachFromContainer ");
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.h();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.IPlayerViewable
    @Nullable
    public View detachKernelView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            detachFromContainer();
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.q0.u1.p.j.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void disableOrientationEventHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.disableOrientationEventHelper();
        }
    }

    @Override // d.a.q0.u1.p.j.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void enableOrientationEventHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.enableOrientationEventHelper();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    @Nullable
    public Object getInfo(Object obj, @Nullable Object obj2, @Nullable LivePlayer.InfoCallback infoCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, obj, obj2, infoCallback)) == null) {
            if ("video_fps".equals(obj)) {
                return Integer.valueOf(this.s.getVideoOutputFps());
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public UniversalPlayerCallbackManager getPlayerCallbackManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (UniversalPlayerCallbackManager) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    @Nullable
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RTCCommStatesReport rTCCommStatesReport = this.s;
            return rTCCommStatesReport != null ? rTCCommStatesReport.getRemoteAddr() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    @Nullable
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            return tbBRTCPlayerView != null ? tbBRTCPlayerView.getVideoUrl() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.u1.p.j.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void goBackOrForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            super.goBackOrForeground(z);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void imCloseTimeStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            if (tbBRTCPlayerView != null) {
                return tbBRTCPlayerView.i();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            if (tbBRTCPlayerView != null) {
                return tbBRTCPlayerView.j();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            return tbBRTCPlayerView != null && tbBRTCPlayerView.k();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isReverseLandscape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            a("BRTCPlayer pause");
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.l();
                IVideoPlayerCallback iVideoPlayerCallback = this.f64746f;
                if (iVideoPlayerCallback != null) {
                    iVideoPlayerCallback.onPause();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void pauseInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            a("pauseInternal isUserClick= " + z);
            this.q = z;
            pause();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void play(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            a("BRTCPlayer play");
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.m(str);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void prePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    @Override // d.a.q0.u1.p.j.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.release();
            a("BRTCPlayer release");
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            if (tbBRTCPlayerView != null) {
                this.f64746f = null;
                tbBRTCPlayerView.o();
                this.p = null;
            }
            ViewGroup viewGroup = this.j;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.j = null;
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resetDefaultSwitchHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resume(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            if (z) {
                resume();
            } else if (this.q) {
            } else {
                resume();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumeFromError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            a("BRTCPlayer resumeFromError");
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.r();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumePlayer(boolean z) {
        TbBRTCPlayerView tbBRTCPlayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (tbBRTCPlayerView = this.p) == null) {
            return;
        }
        tbBRTCPlayerView.q();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void saveProgressToDb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void seekTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i2, i3) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void sendEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, videoEvent) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setExtInfoStatistics(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, hashMap) == null) {
        }
    }

    @Override // d.a.q0.u1.p.j.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setOrientationLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            super.setOrientationLock(z);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setParameter(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048613, this, str, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f2) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setStyleSwitchHelper(IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, iPlayerStyleSwitchHelper) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setVideoInfo(@Nullable HashMap<Integer, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, hashMap) == null) {
            a("setVideoInfo${videoInfo?.map " + hashMap);
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.setVideoInfo(hashMap);
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            a("BRTCPlayer setVideoUrl url= " + str);
            if (this.p == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.p.setVideoUrl(str);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            a("BRTCPlayer start");
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.s();
                IVideoPlayerCallback iVideoPlayerCallback = this.f64746f;
                if (iVideoPlayerCallback != null) {
                    iVideoPlayerCallback.onStart();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            a("BRTCPlayer stop ");
            TbBRTCPlayerView tbBRTCPlayerView = this.p;
            if (tbBRTCPlayerView != null) {
                tbBRTCPlayerView.t();
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void stopTimeStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    @Override // d.a.q0.u1.p.j.a, com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.switchToHalf();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && isPause()) {
            a("resume no force");
            this.p.q();
            IVideoPlayerCallback iVideoPlayerCallback = this.f64746f;
            if (iVideoPlayerCallback != null) {
                iVideoPlayerCallback.onResume();
            }
        }
    }
}
