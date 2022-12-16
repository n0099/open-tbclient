package com.kwad.components.core.offline.init.a;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.utils.am;
import java.io.FileDescriptor;
import java.util.Map;
/* loaded from: classes8.dex */
public final class c implements IMediaPlayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.video.kwai.c Fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final c b(@NonNull com.kwad.sdk.core.video.kwai.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            am.checkNotNull(cVar);
            this.Fh = cVar;
            return this;
        }
        return (c) invokeL.objValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.Fh.getAudioSessionId() : invokeV.intValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final String getCurrentPlayingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.Fh.getCurrentPlayingUrl() : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.Fh.getCurrentPosition() : invokeV.longValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final String getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.Fh.getDataSource() : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.Fh.getDuration() : invokeV.longValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getMediaPlayerType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Fh.getMediaPlayerType() : invokeV.intValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.Fh.getVideoHeight() : invokeV.intValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.Fh.getVideoWidth() : invokeV.intValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.Fh.isLooping() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.Fh.isPlaying() : invokeV.booleanValue;
    }

    public final com.kwad.sdk.core.video.kwai.c nr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.Fh : (com.kwad.sdk.core.video.kwai.c) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.Fh.pause();
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.Fh.prepareAsync() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.Fh.release();
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.Fh.reset();
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void seekTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.Fh.seekTo(j);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setAudioStreamType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.Fh.setAudioStreamType(i);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, uri) == null) {
            this.Fh.setDataSource(context, uri);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, context, uri, map) == null) {
            this.Fh.setDataSource(context, uri, map);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(@NonNull PlayVideoInfo playVideoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, playVideoInfo) == null) {
            this.Fh.a(d.a(playVideoInfo));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fileDescriptor) == null) {
            this.Fh.setDataSource(fileDescriptor);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.Fh.setDataSource(str);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, surfaceHolder) == null) {
            this.Fh.setDisplay(surfaceHolder);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.Fh.setLooping(z);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onBufferingUpdateListener) == null) {
            this.Fh.a(d.a(this, onBufferingUpdateListener));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onCompletionListener) == null) {
            this.Fh.a(d.a(this, onCompletionListener));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onErrorListener) == null) {
            this.Fh.a(d.a(this, onErrorListener));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onInfoListener) == null) {
            this.Fh.c(d.a(this, onInfoListener));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onPreparedListener) == null) {
            this.Fh.b(d.a(this, onPreparedListener));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onSeekCompleteListener) == null) {
            this.Fh.a(d.a(this, onSeekCompleteListener));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onTimedTextListener) == null) {
            this.Fh.a(d.a(this, onTimedTextListener));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onVideoSizeChangedListener) == null) {
            this.Fh.a(d.a(this, onVideoSizeChangedListener));
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setScreenOnWhilePlaying(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.Fh.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setSpeed(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048610, this, f) == null) {
            this.Fh.setSpeed(f);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, surface) == null) {
            this.Fh.setSurface(surface);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setVolume(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.Fh.setVolume(f, f2);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.Fh.start();
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.Fh.stop();
        }
    }
}
