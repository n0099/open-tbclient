package com.kwad.components.core.offline.init.a;

import android.media.TimedText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.g;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoPlayStateListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.video.kwai.c;
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static b.a a(ReleaseCallback releaseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, releaseCallback)) == null) {
            if (releaseCallback == null) {
                return null;
            }
            return new b.a(releaseCallback) { // from class: com.kwad.components.core.offline.init.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ReleaseCallback Fk;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {releaseCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fk = releaseCallback;
                }

                @Override // com.kwad.components.core.video.b.a
                public final void onReleaseSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.Fk.onReleaseSuccess();
                    }
                }
            };
        }
        return (b.a) invokeL.objValue;
    }

    public static g a(VideoPlayStateListener videoPlayStateListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, videoPlayStateListener)) == null) {
            if (videoPlayStateListener == null) {
                return null;
            }
            return new g(videoPlayStateListener) { // from class: com.kwad.components.core.offline.init.a.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VideoPlayStateListener Fs;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {videoPlayStateListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fs = videoPlayStateListener;
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayBufferingPaused() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.Fs.onVideoPlayBufferingPaused();
                    }
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayBufferingPlaying() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.Fs.onVideoPlayBufferingPlaying();
                    }
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayCompleted() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.Fs.onVideoPlayCompleted();
                    }
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayError(int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048579, this, i, i2) == null) {
                        this.Fs.onVideoPlayError(i, i2);
                    }
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayPaused() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        this.Fs.onVideoPlayPaused();
                    }
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        this.Fs.onVideoPlayProgress(j, j2);
                    }
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlayStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                        this.Fs.onVideoPlayStart();
                    }
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPlaying() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                        this.Fs.onVideoPlaying();
                    }
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPrepared() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                        this.Fs.onVideoPrepared();
                    }
                }

                @Override // com.kwad.components.core.video.g
                public final void onVideoPreparing() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                        this.Fs.onVideoPreparing();
                    }
                }
            };
        }
        return (g) invokeL.objValue;
    }

    public static com.kwad.sdk.contentalliance.kwai.kwai.a a(KsPlayerLogParams ksPlayerLogParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ksPlayerLogParams)) == null) {
            if (ksPlayerLogParams == null) {
                return null;
            }
            com.kwad.sdk.contentalliance.kwai.kwai.a aVar = new com.kwad.sdk.contentalliance.kwai.kwai.a();
            aVar.photoId = ksPlayerLogParams.photoId;
            aVar.clickTime = ksPlayerLogParams.clickTime;
            aVar.adStyle = ksPlayerLogParams.adStyle;
            aVar.contentType = ksPlayerLogParams.contentType;
            return aVar;
        }
        return (com.kwad.sdk.contentalliance.kwai.kwai.a) invokeL.objValue;
    }

    public static com.kwad.sdk.contentalliance.kwai.kwai.b a(PlayVideoInfo playVideoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, playVideoInfo)) == null) {
            if (playVideoInfo == null) {
                return null;
            }
            return new b.a(playVideoInfo.videoUrl).bl(playVideoInfo.manifest).b(a(playVideoInfo.ksplayerLogParams)).a(playVideoInfo.videoPlayerStatus).aJ(playVideoInfo.isNoCache).rC();
        }
        return (com.kwad.sdk.contentalliance.kwai.kwai.b) invokeL.objValue;
    }

    public static c.a a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, iMediaPlayer, onBufferingUpdateListener)) == null) {
            if (onBufferingUpdateListener == null) {
                return null;
            }
            return new c.a(onBufferingUpdateListener, iMediaPlayer) { // from class: com.kwad.components.core.offline.init.a.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMediaPlayer Fj;
                public final /* synthetic */ IMediaPlayer.OnBufferingUpdateListener Fm;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onBufferingUpdateListener, iMediaPlayer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fm = onBufferingUpdateListener;
                    this.Fj = iMediaPlayer;
                }

                @Override // com.kwad.sdk.core.video.kwai.c.a
                public final void ai(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.Fm.onBufferingUpdate(this.Fj, i);
                    }
                }
            };
        }
        return (c.a) invokeLL.objValue;
    }

    public static c.b a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnCompletionListener onCompletionListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, iMediaPlayer, onCompletionListener)) == null) {
            if (onCompletionListener == null) {
                return null;
            }
            return new c.b(onCompletionListener, iMediaPlayer) { // from class: com.kwad.components.core.offline.init.a.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMediaPlayer Fj;
                public final /* synthetic */ IMediaPlayer.OnCompletionListener Fl;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onCompletionListener, iMediaPlayer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fl = onCompletionListener;
                    this.Fj = iMediaPlayer;
                }

                @Override // com.kwad.sdk.core.video.kwai.c.b
                public final void ns() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.Fl.onCompletion(this.Fj);
                    }
                }
            };
        }
        return (c.b) invokeLL.objValue;
    }

    public static c.InterfaceC0639c a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnErrorListener onErrorListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, iMediaPlayer, onErrorListener)) == null) {
            if (onErrorListener == null) {
                return null;
            }
            return new c.InterfaceC0639c(onErrorListener, iMediaPlayer) { // from class: com.kwad.components.core.offline.init.a.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMediaPlayer Fj;
                public final /* synthetic */ IMediaPlayer.OnErrorListener Fp;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onErrorListener, iMediaPlayer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fp = onErrorListener;
                    this.Fj = iMediaPlayer;
                }

                @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0639c
                public final boolean j(int i, int i2) {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i, i2)) == null) ? this.Fp.onError(this.Fj, i, i2) : invokeII.booleanValue;
                }
            };
        }
        return (c.InterfaceC0639c) invokeLL.objValue;
    }

    public static c.d a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnInfoListener onInfoListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, iMediaPlayer, onInfoListener)) == null) {
            if (onInfoListener == null) {
                return null;
            }
            return new c.d(onInfoListener, iMediaPlayer) { // from class: com.kwad.components.core.offline.init.a.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMediaPlayer Fj;
                public final /* synthetic */ IMediaPlayer.OnInfoListener Fq;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onInfoListener, iMediaPlayer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fq = onInfoListener;
                    this.Fj = iMediaPlayer;
                }

                @Override // com.kwad.sdk.core.video.kwai.c.d
                public final boolean k(int i, int i2) {
                    InterceptResult invokeII;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeII = interceptable2.invokeII(1048576, this, i, i2)) == null) ? this.Fq.onInfo(this.Fj, i, i2) : invokeII.booleanValue;
                }
            };
        }
        return (c.d) invokeLL.objValue;
    }

    public static c.e a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnPreparedListener onPreparedListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, iMediaPlayer, onPreparedListener)) == null) {
            if (onPreparedListener == null) {
                return null;
            }
            return new c.e(onPreparedListener, iMediaPlayer) { // from class: com.kwad.components.core.offline.init.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMediaPlayer.OnPreparedListener Fi;
                public final /* synthetic */ IMediaPlayer Fj;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onPreparedListener, iMediaPlayer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fi = onPreparedListener;
                    this.Fj = iMediaPlayer;
                }

                @Override // com.kwad.sdk.core.video.kwai.c.e
                public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                        this.Fi.onPrepared(this.Fj);
                    }
                }
            };
        }
        return (c.e) invokeLL.objValue;
    }

    public static c.f a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, iMediaPlayer, onSeekCompleteListener)) == null) {
            if (onSeekCompleteListener == null) {
                return null;
            }
            return new c.f(onSeekCompleteListener, iMediaPlayer) { // from class: com.kwad.components.core.offline.init.a.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMediaPlayer Fj;
                public final /* synthetic */ IMediaPlayer.OnSeekCompleteListener Fn;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onSeekCompleteListener, iMediaPlayer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fn = onSeekCompleteListener;
                    this.Fj = iMediaPlayer;
                }

                @Override // com.kwad.sdk.core.video.kwai.c.f
                public final void nt() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.Fn.onSeekComplete(this.Fj);
                    }
                }
            };
        }
        return (c.f) invokeLL.objValue;
    }

    public static c.g a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, iMediaPlayer, onTimedTextListener)) == null) {
            if (onTimedTextListener == null) {
                return null;
            }
            return new c.g(onTimedTextListener, iMediaPlayer) { // from class: com.kwad.components.core.offline.init.a.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMediaPlayer Fj;
                public final /* synthetic */ IMediaPlayer.OnTimedTextListener Fr;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onTimedTextListener, iMediaPlayer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fr = onTimedTextListener;
                    this.Fj = iMediaPlayer;
                }

                @Override // com.kwad.sdk.core.video.kwai.c.g
                public final void a(TimedText timedText) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, timedText) == null) {
                        this.Fr.onTimedText(this.Fj, timedText);
                    }
                }
            };
        }
        return (c.g) invokeLL.objValue;
    }

    public static c.h a(IMediaPlayer iMediaPlayer, IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, iMediaPlayer, onVideoSizeChangedListener)) == null) {
            if (onVideoSizeChangedListener == null) {
                return null;
            }
            return new c.h(onVideoSizeChangedListener, iMediaPlayer) { // from class: com.kwad.components.core.offline.init.a.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMediaPlayer Fj;
                public final /* synthetic */ IMediaPlayer.OnVideoSizeChangedListener Fo;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onVideoSizeChangedListener, iMediaPlayer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fo = onVideoSizeChangedListener;
                    this.Fj = iMediaPlayer;
                }

                @Override // com.kwad.sdk.core.video.kwai.c.h
                public final void i(int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048576, this, i, i2) == null) {
                        this.Fo.onVideoSizeChanged(this.Fj, i, i2);
                    }
                }
            };
        }
        return (c.h) invokeLL.objValue;
    }
}
