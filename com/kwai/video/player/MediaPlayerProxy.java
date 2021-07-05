package com.kwai.video.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.misc.IMediaDataSource;
import com.kwai.video.player.misc.ITrackInfo;
import java.io.FileDescriptor;
import java.util.Map;
/* loaded from: classes7.dex */
public class MediaPlayerProxy implements IMediaPlayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IMediaPlayer mBackEndMediaPlayer;

    public MediaPlayerProxy(IMediaPlayer iMediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMediaPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBackEndMediaPlayer = iMediaPlayer;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void addVideoRawBuffer(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBackEndMediaPlayer.getAudioSessionId() : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBackEndMediaPlayer.getCurrentPosition() : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public String getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBackEndMediaPlayer.getDataSource() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBackEndMediaPlayer.getDuration() : invokeV.longValue;
    }

    public IMediaPlayer getInternalMediaPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBackEndMediaPlayer : (IMediaPlayer) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mBackEndMediaPlayer.getMediaInfo() : (MediaInfo) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBackEndMediaPlayer.getTrackInfo() : (ITrackInfo[]) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mBackEndMediaPlayer.getVideoHeight() : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarDen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mBackEndMediaPlayer.getVideoSarDen() : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mBackEndMediaPlayer.getVideoSarNum() : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mBackEndMediaPlayer.getVideoWidth() : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mBackEndMediaPlayer.isLooping() : invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isPlayable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mBackEndMediaPlayer.isPlaying() : invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mBackEndMediaPlayer.pause();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mBackEndMediaPlayer.prepareAsync();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mBackEndMediaPlayer.release();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mBackEndMediaPlayer.reset();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void seekTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.mBackEndMediaPlayer.seekTo(j);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setAudioStreamType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mBackEndMediaPlayer.setAudioStreamType(i2);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, uri) == null) {
            this.mBackEndMediaPlayer.setDataSource(context, uri);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(14)
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, context, uri, map) == null) {
            this.mBackEndMediaPlayer.setDataSource(context, uri, map);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iMediaDataSource) == null) {
            this.mBackEndMediaPlayer.setDataSource(iMediaDataSource);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, fileDescriptor) == null) {
            this.mBackEndMediaPlayer.setDataSource(fileDescriptor);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mBackEndMediaPlayer.setDataSource(str);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, surfaceHolder) == null) {
            this.mBackEndMediaPlayer.setDisplay(surfaceHolder);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.mBackEndMediaPlayer.setKeepInBackground(z);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mBackEndMediaPlayer.setLooping(z);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onBufferingUpdateListener) == null) {
            if (onBufferingUpdateListener != null) {
                this.mBackEndMediaPlayer.setOnBufferingUpdateListener(new IMediaPlayer.OnBufferingUpdateListener(this, onBufferingUpdateListener) { // from class: com.kwai.video.player.MediaPlayerProxy.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaPlayerProxy this$0;
                    public final /* synthetic */ IMediaPlayer.OnBufferingUpdateListener val$finalListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onBufferingUpdateListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$finalListener = onBufferingUpdateListener;
                    }

                    @Override // com.kwai.video.player.IMediaPlayer.OnBufferingUpdateListener
                    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaPlayer, i2) == null) {
                            this.val$finalListener.onBufferingUpdate(this.this$0, i2);
                        }
                    }
                });
            } else {
                this.mBackEndMediaPlayer.setOnBufferingUpdateListener(null);
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onCompletionListener) == null) {
            if (onCompletionListener != null) {
                this.mBackEndMediaPlayer.setOnCompletionListener(new IMediaPlayer.OnCompletionListener(this, onCompletionListener) { // from class: com.kwai.video.player.MediaPlayerProxy.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaPlayerProxy this$0;
                    public final /* synthetic */ IMediaPlayer.OnCompletionListener val$finalListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onCompletionListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$finalListener = onCompletionListener;
                    }

                    @Override // com.kwai.video.player.IMediaPlayer.OnCompletionListener
                    public void onCompletion(IMediaPlayer iMediaPlayer) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) {
                            this.val$finalListener.onCompletion(this.this$0);
                        }
                    }
                });
            } else {
                this.mBackEndMediaPlayer.setOnCompletionListener(null);
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onErrorListener) == null) {
            if (onErrorListener != null) {
                this.mBackEndMediaPlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener(this, onErrorListener) { // from class: com.kwai.video.player.MediaPlayerProxy.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaPlayerProxy this$0;
                    public final /* synthetic */ IMediaPlayer.OnErrorListener val$finalListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onErrorListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$finalListener = onErrorListener;
                    }

                    @Override // com.kwai.video.player.IMediaPlayer.OnErrorListener
                    public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
                        InterceptResult invokeLII;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, iMediaPlayer, i2, i3)) == null) ? this.val$finalListener.onError(this.this$0, i2, i3) : invokeLII.booleanValue;
                    }
                });
            } else {
                this.mBackEndMediaPlayer.setOnErrorListener(null);
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setOnFftDataCaptureListener(IMediaPlayer.OnFftDataCaptureListener onFftDataCaptureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onFftDataCaptureListener) == null) {
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onInfoListener) == null) {
            if (onInfoListener != null) {
                this.mBackEndMediaPlayer.setOnInfoListener(new IMediaPlayer.OnInfoListener(this, onInfoListener) { // from class: com.kwai.video.player.MediaPlayerProxy.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaPlayerProxy this$0;
                    public final /* synthetic */ IMediaPlayer.OnInfoListener val$finalListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onInfoListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$finalListener = onInfoListener;
                    }

                    @Override // com.kwai.video.player.IMediaPlayer.OnInfoListener
                    public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
                        InterceptResult invokeLII;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, iMediaPlayer, i2, i3)) == null) ? this.val$finalListener.onInfo(this.this$0, i2, i3) : invokeLII.booleanValue;
                    }
                });
            } else {
                this.mBackEndMediaPlayer.setOnInfoListener(null);
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setOnLogEventListener(IMediaPlayer.OnLogEventListener onLogEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onLogEventListener) == null) {
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onPreparedListener) == null) {
            if (onPreparedListener != null) {
                this.mBackEndMediaPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener(this, onPreparedListener) { // from class: com.kwai.video.player.MediaPlayerProxy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaPlayerProxy this$0;
                    public final /* synthetic */ IMediaPlayer.OnPreparedListener val$finalListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onPreparedListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$finalListener = onPreparedListener;
                    }

                    @Override // com.kwai.video.player.IMediaPlayer.OnPreparedListener
                    public void onPrepared(IMediaPlayer iMediaPlayer) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) {
                            this.val$finalListener.onPrepared(this.this$0);
                        }
                    }
                });
            } else {
                this.mBackEndMediaPlayer.setOnPreparedListener(null);
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onSeekCompleteListener) == null) {
            if (onSeekCompleteListener != null) {
                this.mBackEndMediaPlayer.setOnSeekCompleteListener(new IMediaPlayer.OnSeekCompleteListener(this, onSeekCompleteListener) { // from class: com.kwai.video.player.MediaPlayerProxy.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaPlayerProxy this$0;
                    public final /* synthetic */ IMediaPlayer.OnSeekCompleteListener val$finalListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onSeekCompleteListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$finalListener = onSeekCompleteListener;
                    }

                    @Override // com.kwai.video.player.IMediaPlayer.OnSeekCompleteListener
                    public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) {
                            this.val$finalListener.onSeekComplete(this.this$0);
                        }
                    }
                });
            } else {
                this.mBackEndMediaPlayer.setOnSeekCompleteListener(null);
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onVideoSizeChangedListener) == null) {
            if (onVideoSizeChangedListener != null) {
                this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(new IMediaPlayer.OnVideoSizeChangedListener(this, onVideoSizeChangedListener) { // from class: com.kwai.video.player.MediaPlayerProxy.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaPlayerProxy this$0;
                    public final /* synthetic */ IMediaPlayer.OnVideoSizeChangedListener val$finalListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onVideoSizeChangedListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$finalListener = onVideoSizeChangedListener;
                    }

                    @Override // com.kwai.video.player.IMediaPlayer.OnVideoSizeChangedListener
                    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i3, int i4, int i5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{iMediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                            this.val$finalListener.onVideoSizeChanged(this.this$0, i2, i3, i4, i5);
                        }
                    }
                });
            } else {
                this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(null);
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.mBackEndMediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(14)
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, surface) == null) {
            this.mBackEndMediaPlayer.setSurface(surface);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setVideoRawDataListener(IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onVideoRawDataListener) == null) {
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.mBackEndMediaPlayer.setVolume(f2, f3);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setWakeMode(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048618, this, context, i2) == null) {
            this.mBackEndMediaPlayer.setWakeMode(context, i2);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.mBackEndMediaPlayer.start();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.mBackEndMediaPlayer.stop();
        }
    }
}
