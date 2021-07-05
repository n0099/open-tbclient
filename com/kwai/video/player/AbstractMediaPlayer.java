package com.kwai.video.player;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.misc.IMediaDataSource;
/* loaded from: classes7.dex */
public abstract class AbstractMediaPlayer implements IMediaPlayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    public IMediaPlayer.OnCompletionListener mOnCompletionListener;
    public IMediaPlayer.OnErrorListener mOnErrorListener;
    public IMediaPlayer.OnFftDataCaptureListener mOnFftDataCaptureListener;
    public IMediaPlayer.OnInfoListener mOnInfoListener;
    public IMediaPlayer.OnLogEventListener mOnLogEventListener;
    public IMediaPlayer.OnPreparedListener mOnPreparedListener;
    public IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    public IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;

    public AbstractMediaPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void notifyOnBufferingUpdate(int i2) {
        IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (onBufferingUpdateListener = this.mOnBufferingUpdateListener) == null) {
            return;
        }
        onBufferingUpdateListener.onBufferingUpdate(this, i2);
    }

    public final void notifyOnCompletion() {
        IMediaPlayer.OnCompletionListener onCompletionListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onCompletionListener = this.mOnCompletionListener) == null) {
            return;
        }
        onCompletionListener.onCompletion(this);
    }

    public final boolean notifyOnError(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            Timber.d("notifyOnError, what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            IMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
            return onErrorListener != null && onErrorListener.onError(this, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public void notifyOnFftDataCapture(float[] fArr) {
        IMediaPlayer.OnFftDataCaptureListener onFftDataCaptureListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, fArr) == null) || (onFftDataCaptureListener = this.mOnFftDataCaptureListener) == null) {
            return;
        }
        onFftDataCaptureListener.onFftDataCapture(fArr);
    }

    public final boolean notifyOnInfo(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
            return onInfoListener != null && onInfoListener.onInfo(this, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public final void notifyOnLogEvent(String str) {
        IMediaPlayer.OnLogEventListener onLogEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (onLogEventListener = this.mOnLogEventListener) == null) {
            return;
        }
        onLogEventListener.onLogEvent(this, str);
    }

    public final void notifyOnPrepared() {
        IMediaPlayer.OnPreparedListener onPreparedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (onPreparedListener = this.mOnPreparedListener) == null) {
            return;
        }
        onPreparedListener.onPrepared(this);
    }

    public final void notifyOnSeekComplete() {
        IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (onSeekCompleteListener = this.mOnSeekCompleteListener) == null) {
            return;
        }
        onSeekCompleteListener.onSeekComplete(this);
    }

    public final void notifyOnVideoSizeChanged(int i2, int i3, int i4, int i5) {
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) || (onVideoSizeChangedListener = this.mOnVideoSizeChangedListener) == null) {
            return;
        }
        onVideoSizeChangedListener.onVideoSizeChanged(this, i2, i3, i4, i5);
    }

    public void resetListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mOnPreparedListener = null;
            this.mOnBufferingUpdateListener = null;
            this.mOnCompletionListener = null;
            this.mOnSeekCompleteListener = null;
            this.mOnVideoSizeChangedListener = null;
            this.mOnErrorListener = null;
            this.mOnInfoListener = null;
            this.mOnLogEventListener = null;
            this.mOnFftDataCaptureListener = null;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iMediaDataSource) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onBufferingUpdateListener) == null) {
            this.mOnBufferingUpdateListener = onBufferingUpdateListener;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onCompletionListener) == null) {
            this.mOnCompletionListener = onCompletionListener;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onErrorListener) == null) {
            this.mOnErrorListener = onErrorListener;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnFftDataCaptureListener(IMediaPlayer.OnFftDataCaptureListener onFftDataCaptureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onFftDataCaptureListener) == null) {
            this.mOnFftDataCaptureListener = onFftDataCaptureListener;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onInfoListener) == null) {
            this.mOnInfoListener = onInfoListener;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnLogEventListener(IMediaPlayer.OnLogEventListener onLogEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onLogEventListener) == null) {
            this.mOnLogEventListener = onLogEventListener;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onPreparedListener) == null) {
            this.mOnPreparedListener = onPreparedListener;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onSeekCompleteListener) == null) {
            this.mOnSeekCompleteListener = onSeekCompleteListener;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onVideoSizeChangedListener) == null) {
            this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
        }
    }
}
