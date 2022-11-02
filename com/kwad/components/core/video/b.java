package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean JD;
    public static final AtomicInteger JE;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int JF;
    public com.kwad.sdk.core.video.kwai.c JG;
    public int JH;
    public long JI;
    public Runnable JJ;
    public com.kwad.sdk.contentalliance.kwai.kwai.b JK;
    public int JL;
    public List<c.d> JM;
    public final AtomicBoolean JN;
    public boolean JO;
    public volatile List<g> JP;
    public volatile List<c.e> JQ;
    public c.e JR;
    public c.h JS;
    public c.b JT;
    public c.InterfaceC0618c JU;
    public c.d JV;
    public c.a JW;
    public int Jn;
    public int Jo;
    public String TAG;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public Handler mHandler;
    public long mStartTime;

    /* loaded from: classes7.dex */
    public interface a {
        @WorkerThread
        void onReleaseSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(127637514, "Lcom/kwad/components/core/video/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(127637514, "Lcom/kwad/components/core/video/b;");
                return;
            }
        }
        JE = new AtomicInteger(0);
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailVideoView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.TAG = "MediaPlayerImpl";
        this.JF = 0;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.JL = 0;
        this.JM = new CopyOnWriteArrayList();
        this.JN = new AtomicBoolean(false);
        this.JO = false;
        this.JP = new CopyOnWriteArrayList();
        this.JQ = new CopyOnWriteArrayList();
        this.JR = new c.e(this) { // from class: com.kwad.components.core.video.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b JX;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.JX = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    String str = this.JX.TAG;
                    com.kwad.sdk.core.e.b.i(str, "onPrepared:" + b.getStateString(this.JX.JF) + "->STATE_PREPARED");
                    this.JX.JF = 2;
                    b bVar = this.JX;
                    bVar.onPlayStateChanged(bVar.JF);
                    for (c.e eVar : this.JX.JQ) {
                        eVar.a(this.JX.JG);
                    }
                }
            }
        };
        this.JS = new c.h(this) { // from class: com.kwad.components.core.video.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b JX;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.JX = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.h
            public final void i(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                    if (this.JX.mDetailVideoView != null) {
                        this.JX.mDetailVideoView.adaptVideoSize(i3, i4);
                    }
                    String str = this.JX.TAG;
                    com.kwad.sdk.core.e.b.i(str, "onVideoSizeChanged ——> width：" + i3 + "， height：" + i4);
                }
            }
        };
        this.JT = new c.b(this) { // from class: com.kwad.components.core.video.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b JX;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.JX = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.b
            public final void ns() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.JX.JF = 9;
                    b bVar = this.JX;
                    bVar.onPlayStateChanged(bVar.JF);
                    com.kwad.sdk.core.e.b.i(this.JX.TAG, "onCompletion ——> STATE_COMPLETED");
                }
            }
        };
        this.JU = new c.InterfaceC0618c(this) { // from class: com.kwad.components.core.video.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b JX;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.JX = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0618c
            public final boolean j(int i3, int i4) {
                InterceptResult invokeII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i3, i4)) == null) {
                    if (i3 != -38) {
                        this.JX.JF = -1;
                        this.JX.Jn = i3;
                        this.JX.Jo = i4;
                        b bVar = this.JX;
                        bVar.onPlayStateChanged(bVar.JF);
                        String str = this.JX.TAG;
                        com.kwad.sdk.core.e.b.i(str, "onError ——> STATE_ERROR ———— what：" + i3 + ", extra: " + i4);
                        return true;
                    }
                    return true;
                }
                return invokeII.booleanValue;
            }
        };
        this.JV = new c.d(this) { // from class: com.kwad.components.core.video.b.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b JX;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.JX = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.d
            public final boolean k(int i3, int i4) {
                InterceptResult invokeII;
                String str;
                StringBuilder sb;
                String str2;
                String str3;
                String str4;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i3, i4)) == null) {
                    if (i3 != 3) {
                        if (i3 == 701) {
                            if (this.JX.JF == 5 || this.JX.JF == 7) {
                                this.JX.JF = 7;
                                str3 = this.JX.TAG;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                            } else {
                                this.JX.JF = 6;
                                str3 = this.JX.TAG;
                                str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                            }
                            com.kwad.sdk.core.e.b.i(str3, str4);
                            b bVar = this.JX;
                            bVar.onPlayStateChanged(bVar.JF);
                        } else if (i3 == 702) {
                            if (this.JX.JF == 6) {
                                this.JX.JF = 4;
                                b bVar2 = this.JX;
                                bVar2.onPlayStateChanged(bVar2.JF);
                                com.kwad.sdk.core.e.b.i(this.JX.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                            }
                            if (this.JX.JF == 7) {
                                this.JX.JF = 5;
                                b bVar3 = this.JX;
                                bVar3.onPlayStateChanged(bVar3.JF);
                                str = this.JX.TAG;
                                str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                                com.kwad.sdk.core.e.b.i(str, str2);
                            }
                        } else if (i3 != 10001) {
                            if (i3 == 801) {
                                str = this.JX.TAG;
                                str2 = "视频不能seekTo，为直播视频";
                                com.kwad.sdk.core.e.b.i(str, str2);
                            } else {
                                str = this.JX.TAG;
                                sb = new StringBuilder("onInfo ——> what：");
                                sb.append(i3);
                            }
                        }
                        b bVar4 = this.JX;
                        bVar4.a(bVar4.JG, i3, i4);
                        return true;
                    }
                    this.JX.JF = 4;
                    b bVar5 = this.JX;
                    bVar5.onPlayStateChanged(bVar5.JF);
                    str = this.JX.TAG;
                    sb = new StringBuilder("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
                    sb.append(System.currentTimeMillis() - this.JX.mStartTime);
                    str2 = sb.toString();
                    com.kwad.sdk.core.e.b.i(str, str2);
                    b bVar42 = this.JX;
                    bVar42.a(bVar42.JG, i3, i4);
                    return true;
                }
                return invokeII.booleanValue;
            }
        };
        this.JW = new c.a(this) { // from class: com.kwad.components.core.video.b.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b JX;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.JX = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.a
            public final void ai(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    this.JX.JH = i3;
                }
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, boolean z, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{bVar, Boolean.valueOf(z), detailVideoView, cVar}) == null) {
            com.kwad.sdk.core.e.b.i(this.TAG, "initMediaPlayer");
            if (bVar == null || detailVideoView == null || cVar == null) {
                return;
            }
            if (this.mContext == null) {
                this.mContext = detailVideoView.getContext().getApplicationContext();
            }
            this.JO = z;
            this.JK = bVar;
            DetailVideoView detailVideoView2 = this.mDetailVideoView;
            if (detailVideoView2 != detailVideoView) {
                com.kwad.sdk.core.e.b.i(this.TAG, "initMediaPlayer videoView changed");
                if (detailVideoView2 != null) {
                    detailVideoView2.setMediaPlayer(null);
                    detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                    detailVideoView2.setKeepScreenOn(false);
                }
                this.mDetailVideoView = detailVideoView;
            }
            detailVideoView.setMediaPlayer(this);
            if (this.JG != cVar) {
                com.kwad.sdk.core.e.b.i(this.TAG, "initMediaPlayer mediaPlayer changed");
                com.kwad.sdk.core.video.kwai.c cVar2 = this.JG;
                if (cVar2 != null) {
                    cVar.setLooping(cVar2.isLooping());
                    oV();
                    this.JG.release();
                }
                this.JG = cVar;
                reset();
                oU();
                cVar.setAudioStreamType(3);
            } else {
                com.kwad.sdk.core.e.b.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
                reset();
                oV();
                oU();
            }
            this.JG.setSurface(detailVideoView.Ke);
        }
    }

    public static void a(com.kwad.sdk.core.video.kwai.c cVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, cVar, aVar) == null) || cVar == null) {
            return;
        }
        try {
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    public static String getStateString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) {
            switch (i) {
                case -1:
                    return "STATE_ERROR";
                case 0:
                    return "STATE_IDLE";
                case 1:
                    return "STATE_PREPARING";
                case 2:
                    return "STATE_PREPARED";
                case 3:
                    return "STATE_STARTED";
                case 4:
                    return "STATE_PLAYING";
                case 5:
                    return "STATE_PAUSED";
                case 6:
                    return "STATE_BUFFERING_PLAYING";
                case 7:
                    return "STATE_BUFFERING_PAUSED";
                case 8:
                    return "PLAYER_STATE_STOPPED";
                case 9:
                    return "STATE_COMPLETED";
                default:
                    return "STATE_UNKNOWN";
            }
        }
        return (String) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            long currentPosition = getCurrentPosition();
            long duration = getDuration();
            if (this.JP != null) {
                for (g gVar : this.JP) {
                    gVar.onVideoPlayProgress(duration, currentPosition);
                }
            }
        }
    }

    private void oU() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            this.JG.b(this.JR);
            this.JG.a(this.JS);
            this.JG.a(this.JT);
            this.JG.a(this.JU);
            this.JG.c(this.JV);
            this.JG.a(this.JW);
        }
    }

    private void oV() {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (cVar = this.JG) == null) {
            return;
        }
        cVar.a((c.InterfaceC0618c) null);
        this.JG.a((c.b) null);
        this.JG.b(null);
        this.JG.a((c.h) null);
        this.JG.c(null);
        this.JG.a((c.f) null);
        this.JG.a((c.a) null);
    }

    private void oX() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            oY();
            if (this.JJ == null) {
                this.JJ = new Runnable(this) { // from class: com.kwad.components.core.video.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b JX;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.JX = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.JX.oR();
                            if (this.JX.JJ != null) {
                                this.JX.mHandler.postDelayed(this.JX.JJ, 500L);
                            }
                        }
                    }
                };
            }
            this.mHandler.post(this.JJ);
        }
    }

    private void oY() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (runnable = this.JJ) == null) {
            return;
        }
        this.mHandler.removeCallbacks(runnable);
        this.JJ = null;
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            String str = this.TAG;
            com.kwad.sdk.core.e.b.i(str, "reset:" + getStateString(this.JF) + "->STATE_IDLE");
            this.JG.reset();
            this.JF = 0;
        }
    }

    private void setKeepScreenOn(boolean z) {
        DetailVideoView detailVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65563, this, z) == null) || (detailVideoView = this.mDetailVideoView) == null) {
            return;
        }
        detailVideoView.setKeepScreenOn(z);
    }

    private void setPlayType(int i) {
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar;
        VideoPlayerStatus videoPlayerStatus;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65564, this, i) == null) || (bVar = this.JK) == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            a(aVar, true);
        }
    }

    public final void a(a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) || this.JG == null) {
            return;
        }
        setKeepScreenOn(false);
        this.mHandler.removeCallbacksAndMessages(null);
        oY();
        oV();
        this.mDetailVideoView = null;
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            if (z) {
                com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this, cVar, aVar) { // from class: com.kwad.components.core.video.b.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b JX;
                    public final /* synthetic */ com.kwad.sdk.core.video.kwai.c JZ;
                    public final /* synthetic */ a Ka;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.JX = this;
                        this.JZ = cVar;
                        this.Ka = aVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            b bVar = this.JX;
                            b.a(this.JZ, this.Ka);
                        }
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.JG = null;
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.b.i(str, "release:" + getStateString(this.JF) + "->STATE_IDLE");
        this.JF = 0;
        this.JL = 0;
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.JG;
            if (cVar instanceof com.kwad.sdk.core.video.kwai.d) {
                ((com.kwad.sdk.core.video.kwai.d) cVar).a(aVar);
            }
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            try {
                if (TextUtils.isEmpty(bVar.videoUrl)) {
                    com.kwad.sdk.core.e.b.e(this.TAG, "videoUrl is null");
                    return;
                }
                String str = this.TAG;
                com.kwad.sdk.core.e.b.e(str, "videoUrl=" + bVar.videoUrl);
                this.JG.a(bVar);
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, @NonNull DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, detailVideoView) == null) {
            a(bVar, true, false, detailVideoView);
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, boolean z, boolean z2, @NonNull DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{bVar, Boolean.valueOf(z), Boolean.valueOf(z2), detailVideoView}) == null) {
            String str = this.TAG;
            com.kwad.sdk.core.e.b.i(str, "initMediaPlayer enablePreLoad:" + z);
            if (bVar == null || detailVideoView == null) {
                return;
            }
            com.kwad.sdk.core.video.kwai.c a2 = com.kwad.sdk.core.video.kwai.e.a(this.mContext, z, com.kwad.sdk.core.config.d.lt(), com.kwad.sdk.core.config.d.lu());
            a2.setLooping(false);
            a(bVar, z2, detailVideoView, a2);
        }
    }

    public final void a(c.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null) {
            return;
        }
        this.JM.add(dVar);
    }

    public final void a(c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.JQ.add(eVar);
        }
    }

    public final void a(com.kwad.sdk.core.video.kwai.c cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, i, i2) == null) {
            Iterator<c.d> it = this.JM.iterator();
            while (it.hasNext()) {
                c.d next = it.next();
                if (next == null) {
                    it.remove();
                } else {
                    next.k(i, i2);
                }
            }
        }
    }

    public final void b(c.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) || dVar == null) {
            return;
        }
        this.JM.remove(dVar);
    }

    public final void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.JP.add(gVar);
        }
    }

    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.JP.clear();
        }
    }

    public final void d(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.JP.remove(gVar);
        }
    }

    public final int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.JH : invokeV.intValue;
    }

    public final String getCurrentPlayingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.JG;
            return cVar == null ? "" : cVar.getCurrentPlayingUrl();
        }
        return (String) invokeV.objValue;
    }

    public final long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.JG;
            if (cVar != null) {
                return cVar.getCurrentPosition();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.JG;
            if (cVar != null) {
                return cVar.getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final int getMediaPlayerType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.JG;
            if (cVar != null) {
                return cVar.getMediaPlayerType();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final long getPlayDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.JG;
            if (cVar != null) {
                return cVar.getCurrentPosition();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.JG;
            if (cVar != null) {
                return cVar.getVideoHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.JG;
            if (cVar != null) {
                return cVar.getVideoWidth();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            com.kwad.sdk.core.video.kwai.c cVar = this.JG;
            if (cVar != null) {
                return cVar.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.JF == 2 || this.JF == 3 || this.JF == 5 || this.JF == 8 || this.JF == 9 : invokeV.booleanValue;
    }

    public final boolean isPreparing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.JF == 1 : invokeV.booleanValue;
    }

    public final com.kwad.sdk.core.video.kwai.c oT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.JG : (com.kwad.sdk.core.video.kwai.c) invokeV.objValue;
    }

    public final void oW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.JG == null) {
                com.kwad.sdk.core.e.b.w("resetAndPlay", "mMediaPlayer is null");
            } else if (this.JF == 2 || this.JF == 3 || this.JF == 4 || this.JF == 5) {
                com.kwad.sdk.core.e.b.w("resetAndPlay", "can not resetAndPlay in sate:" + this.JF);
            } else {
                reset();
                oV();
                oU();
                prepareAsync();
            }
        }
    }

    public final void onPlayStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i) == null) || this.JP == null) {
            return;
        }
        for (g gVar : this.JP) {
            if (gVar != null) {
                switch (i) {
                    case -1:
                        setKeepScreenOn(false);
                        oY();
                        gVar.onVideoPlayError(this.Jn, this.Jo);
                        continue;
                    case 1:
                        gVar.onVideoPreparing();
                        continue;
                    case 2:
                        gVar.onVideoPrepared();
                        continue;
                    case 3:
                        setKeepScreenOn(true);
                        gVar.onVideoPlayStart();
                        continue;
                    case 4:
                        setKeepScreenOn(true);
                        gVar.onVideoPlaying();
                        continue;
                    case 5:
                        setKeepScreenOn(false);
                        gVar.onVideoPlayPaused();
                        continue;
                    case 6:
                        gVar.onVideoPlayBufferingPlaying();
                        continue;
                    case 7:
                        gVar.onVideoPlayBufferingPaused();
                        continue;
                    case 9:
                        try {
                            if (this.JG != null && !this.JG.isLooping()) {
                                setKeepScreenOn(false);
                                oY();
                            }
                            gVar.onVideoPlayCompleted();
                            continue;
                        } catch (Exception e) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public final boolean pause() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            String str = this.TAG;
            com.kwad.sdk.core.e.b.i(str, "pause mCurrentState: " + getStateString(this.JF));
            if (this.JF == 4) {
                this.JG.pause();
                com.kwad.sdk.core.e.b.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
                this.JF = 5;
                onPlayStateChanged(this.JF);
                z = true;
            } else {
                z = false;
            }
            if (this.JF == 6) {
                this.JG.pause();
                com.kwad.sdk.core.e.b.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
                this.JF = 7;
                onPlayStateChanged(this.JF);
                z = true;
            }
            if (this.JF == 3) {
                this.JG.pause();
                com.kwad.sdk.core.e.b.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
                this.JF = 5;
                onPlayStateChanged(this.JF);
                z = true;
            }
            if (this.JF == 9 && this.JG.isLooping()) {
                this.JG.pause();
                String str2 = this.TAG;
                com.kwad.sdk.core.e.b.i(str2, "pause " + getStateString(this.JF) + "->STATE_PAUSED");
                this.JF = 5;
                onPlayStateChanged(this.JF);
                return true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void prepareAsync() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || this.JG == null) {
            return;
        }
        if (this.JO) {
            if (this.JN.compareAndSet(false, true)) {
                com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this) { // from class: com.kwad.components.core.video.b.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b JX;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.JX = this;
                    }

                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, CONST_STR, CONSTRUCTOR, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x00cd A[Catch: all -> 0x00d8, TRY_ENTER, TryCatch #1 {Exception -> 0x00db, blocks: (B:22:0x00c6, B:23:0x00cc, B:24:0x00cd, B:25:0x00d6), top: B:39:0x00c6 }] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void run() {
                        boolean prepareAsync;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            String str = this.JX.TAG;
                            com.kwad.sdk.core.e.b.i(str, "prepareAsync now:" + b.getStateString(this.JX.JF));
                            if (this.JX.JG == null) {
                                return;
                            }
                            try {
                                try {
                                    synchronized (this.JX.JG) {
                                        this.JX.a(this.JX.JK);
                                        prepareAsync = this.JX.JG.prepareAsync();
                                        String str2 = this.JX.TAG;
                                        com.kwad.sdk.core.e.b.i(str2, "prepareAsync:" + b.getStateString(this.JX.JF) + "->STATE_PREPARING, success: " + prepareAsync);
                                        this.JX.JF = 1;
                                    }
                                    if (prepareAsync) {
                                        this.JX.mHandler.post(new Runnable(this) { // from class: com.kwad.components.core.video.b.8.1
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AnonymousClass8 JY;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i = newInitContext.flag;
                                                    if ((i & 1) != 0) {
                                                        int i2 = i & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.JY = this;
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                    b bVar = this.JY.JX;
                                                    bVar.onPlayStateChanged(bVar.JF);
                                                }
                                            }
                                        });
                                    } else {
                                        com.kwad.sdk.core.e.b.e(this.JX.TAG, "prepareAsync failed");
                                    }
                                } finally {
                                    try {
                                        synchronized (this.JX.JN) {
                                        }
                                    } finally {
                                    }
                                }
                                synchronized (this.JX.JN) {
                                    this.JX.JN.notifyAll();
                                }
                            } catch (Exception e) {
                                com.kwad.sdk.core.e.b.printStackTrace(e);
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            a(this.JK);
            if (!this.JG.prepareAsync()) {
                com.kwad.sdk.core.e.b.e(this.TAG, "prepareAsync failed");
                return;
            }
            String str = this.TAG;
            com.kwad.sdk.core.e.b.i(str, "prepareAsync:" + getStateString(this.JF) + "->STATE_PREPARING");
            this.JF = 1;
            onPlayStateChanged(this.JF);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i = this.JL;
                this.JL = i + 1;
                if (i <= 4) {
                    oW();
                }
            }
            String str2 = this.TAG;
            com.kwad.sdk.core.e.b.i(str2, "prepareAsync Exception:" + getStateString(this.JF));
            com.kwad.sdk.core.e.b.printStackTrace(th);
        }
    }

    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            a((a) null);
        }
    }

    public final void releaseSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            a((a) null, false);
        }
    }

    public final void restart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.JG != null && this.JF == 9) {
                start();
            }
            setPlayType(3);
        }
    }

    public final void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.JG == null) {
                com.kwad.sdk.core.e.b.e(this.TAG, "resume but mMediaPlayer is null");
                return;
            }
            String str = this.TAG;
            com.kwad.sdk.core.e.b.i(str, "resume mCurrentState: " + getStateString(this.JF));
            if (this.JF == 2 || this.JF == 0) {
                String str2 = this.TAG;
                com.kwad.sdk.core.e.b.i(str2, "resume:" + getStateString(this.JF) + "->start()");
                start();
            } else if (this.JF == 5) {
                this.JG.start();
                String str3 = this.TAG;
                com.kwad.sdk.core.e.b.i(str3, "resume:" + getStateString(this.JF) + "->STATE_PLAYING");
                this.JF = 4;
                onPlayStateChanged(this.JF);
                setPlayType(2);
            } else if (this.JF != 7) {
                String str4 = this.TAG;
                com.kwad.sdk.core.e.b.e(str4, "resume: " + getStateString(this.JF) + " 此时不能调用resume()方法.");
            } else {
                this.JG.start();
                String str5 = this.TAG;
                com.kwad.sdk.core.e.b.i(str5, "resume:" + getStateString(this.JF) + "->STATE_BUFFERING_PLAYING");
                this.JF = 6;
                onPlayStateChanged(this.JF);
            }
        }
    }

    public final void seekTo(long j) {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048609, this, j) == null) || (cVar = this.JG) == null) {
            return;
        }
        cVar.seekTo(j);
    }

    public final void setAudioEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            float f = z ? 1.0f : 0.0f;
            setVolume(f, f);
        }
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.mDetailVideoView.setRadius(f, f2, f3, f4);
        }
    }

    public final void setSpeed(float f) {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048612, this, f) == null) || (cVar = this.JG) == null) {
            return;
        }
        cVar.setSpeed(f);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, surface) == null) || (cVar = this.JG) == null) {
            return;
        }
        cVar.setSurface(surface);
    }

    public final void setVolume(float f, float f2) {
        com.kwad.sdk.core.video.kwai.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || (cVar = this.JG) == null) {
            return;
        }
        cVar.setVolume(f, f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
        if (r7.JF == 9) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            String str = this.TAG;
            com.kwad.sdk.core.e.b.i(str, "start mCurrentState: " + getStateString(this.JF));
            if (this.JF == 0) {
                com.kwad.sdk.core.e.b.i(this.TAG, "start, still not prepared well, prepare again");
                prepareAsync();
                if (getMediaPlayerType() == 2) {
                    if (this.JO && this.JN.get()) {
                        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable(this) { // from class: com.kwad.components.core.video.b.9
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ b JX;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.JX = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    if (this.JX.JN.get()) {
                                        try {
                                            synchronized (this.JX.JN) {
                                                this.JX.JN.wait(5000L);
                                            }
                                        } catch (InterruptedException e) {
                                            com.kwad.sdk.core.e.b.printStackTrace(e);
                                        }
                                    }
                                    if (this.JX.getMediaPlayerType() == 2) {
                                        this.JX.JG.start();
                                    }
                                }
                            }
                        });
                    } else {
                        this.JG.start();
                    }
                }
            } else if (this.JF == 2 || this.JF == 9) {
                this.mStartTime = System.currentTimeMillis();
                this.JG.start();
                long j = this.JI;
                if (j != 0) {
                    this.JG.seekTo((int) j);
                }
                String str2 = this.TAG;
                com.kwad.sdk.core.e.b.i(str2, "start:" + getStateString(this.JF) + "->STATE_STARTED");
                com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.JK;
                if (bVar != null && bVar.videoPlayerStatus != null) {
                    if (this.JF == 2) {
                        if (this.JK.videoPlayerStatus.mVideoPlayerType == 0) {
                            setPlayType(1);
                        }
                        setPlayType(3);
                    }
                }
                this.JF = 3;
                onPlayStateChanged(this.JF);
                oX();
            }
        }
    }

    public final void start(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j) == null) {
            this.JI = j;
            start();
        }
    }

    public final void stopAndPrepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            String str = this.TAG;
            com.kwad.sdk.core.e.b.i(str, "stopAndPrepareAsync mCurrentState:" + this.JF);
            if (this.JF == 1 || this.JF == 2) {
                return;
            }
            if (this.JF != 3 && this.JF != 4 && this.JF != 5 && this.JF != 6 && this.JF != 7 && this.JF != 8 && this.JF != 9) {
                release();
                return;
            }
            try {
                this.JG.stop();
                this.JF = 8;
                onPlayStateChanged(this.JF);
                prepareAsync();
            } catch (Exception unused) {
                release();
                String str2 = this.TAG;
                com.kwad.sdk.core.e.b.e(str2, "stopAndPrepareAsync mCurrentState:" + this.JF);
            }
        }
    }
}
