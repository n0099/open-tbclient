package com.kwai.video.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
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
import com.kwai.video.player.misc.AndroidTrackInfo;
import com.kwai.video.player.misc.IMediaDataSource;
import com.kwai.video.player.misc.ITrackInfo;
import com.kwai.video.player.pragma.DebugLog;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes7.dex */
public class AndroidMediaPlayer extends AbstractMediaPlayer {
    public static /* synthetic */ Interceptable $ic;
    public static MediaInfo sMediaInfo;
    public transient /* synthetic */ FieldHolder $fh;
    public String mDataSource;
    public final Object mInitLock;
    public final AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
    public final MediaPlayer mInternalMediaPlayer;
    public boolean mIsReleased;
    public MediaDataSource mMediaDataSource;

    /* loaded from: classes7.dex */
    public class AndroidMediaPlayerListenerHolder implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AndroidMediaPlayer> mWeakMediaPlayer;
        public final /* synthetic */ AndroidMediaPlayer this$0;

        public AndroidMediaPlayerListenerHolder(AndroidMediaPlayer androidMediaPlayer, AndroidMediaPlayer androidMediaPlayer2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidMediaPlayer, androidMediaPlayer2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = androidMediaPlayer;
            this.mWeakMediaPlayer = new WeakReference<>(androidMediaPlayer2);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) || this.mWeakMediaPlayer.get() == null) {
                return;
            }
            this.this$0.notifyOnBufferingUpdate(i2);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) || this.mWeakMediaPlayer.get() == null) {
                return;
            }
            this.this$0.notifyOnCompletion();
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i2, i3)) == null) ? this.mWeakMediaPlayer.get() != null && this.this$0.notifyOnError(i2, i3) : invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, mediaPlayer, i2, i3)) == null) ? this.mWeakMediaPlayer.get() != null && this.this$0.notifyOnInfo(i2, i3) : invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, mediaPlayer) == null) || this.mWeakMediaPlayer.get() == null) {
                return;
            }
            this.this$0.notifyOnPrepared();
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, mediaPlayer) == null) || this.mWeakMediaPlayer.get() == null) {
                return;
            }
            this.this$0.notifyOnSeekComplete();
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048582, this, mediaPlayer, i2, i3) == null) || this.mWeakMediaPlayer.get() == null) {
                return;
            }
            this.this$0.notifyOnVideoSizeChanged(i2, i3, 1, 1);
        }
    }

    @TargetApi(23)
    /* loaded from: classes7.dex */
    public static class MediaDataSourceProxy extends MediaDataSource {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final IMediaDataSource mMediaDataSource;

        public MediaDataSourceProxy(IMediaDataSource iMediaDataSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMediaDataSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMediaDataSource = iMediaDataSource;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mMediaDataSource.close();
            }
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMediaDataSource.getSize() : invokeV.longValue;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? this.mMediaDataSource.readAt(j, bArr, i2, i3) : invokeCommon.intValue;
        }
    }

    public AndroidMediaPlayer() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Object obj = new Object();
        this.mInitLock = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.mInternalMediaPlayer = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new AndroidMediaPlayerListenerHolder(this, this);
        attachInternalListeners();
    }

    private void attachInternalListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
            this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
            this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
            this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
            this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
            this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
            this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
        }
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (mediaDataSource = this.mMediaDataSource) == null) {
            return;
        }
        try {
            mediaDataSource.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.mMediaDataSource = null;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mInternalMediaPlayer.getAudioSessionId() : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return this.mInternalMediaPlayer.getCurrentPosition();
            } catch (IllegalStateException e2) {
                DebugLog.printStackTrace(e2);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public String getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDataSource : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return this.mInternalMediaPlayer.getDuration();
            } catch (IllegalStateException e2) {
                DebugLog.printStackTrace(e2);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public MediaPlayer getInternalMediaPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mInternalMediaPlayer : (MediaPlayer) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (sMediaInfo == null) {
                MediaInfo mediaInfo = new MediaInfo();
                mediaInfo.mVideoDecoder = "android";
                mediaInfo.mVideoDecoderImpl = "HW";
                mediaInfo.mAudioDecoder = "android";
                mediaInfo.mAudioDecoderImpl = "HW";
                sMediaInfo = mediaInfo;
            }
            return sMediaInfo;
        }
        return (MediaInfo) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer) : (ITrackInfo[]) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mInternalMediaPlayer.getVideoHeight() : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarDen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mInternalMediaPlayer.getVideoWidth() : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mInternalMediaPlayer.isLooping() : invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isPlayable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                return this.mInternalMediaPlayer.isPlaying();
            } catch (IllegalStateException e2) {
                DebugLog.printStackTrace(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mInternalMediaPlayer.pause();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mInternalMediaPlayer.prepareAsync();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mIsReleased = true;
            this.mInternalMediaPlayer.release();
            releaseMediaDataSource();
            resetListeners();
            attachInternalListeners();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                this.mInternalMediaPlayer.reset();
            } catch (IllegalStateException e2) {
                DebugLog.printStackTrace(e2);
            }
            releaseMediaDataSource();
            resetListeners();
            attachInternalListeners();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void seekTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.mInternalMediaPlayer.seekTo((int) j);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setAudioStreamType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mInternalMediaPlayer.setAudioStreamType(i2);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, uri) == null) {
            this.mInternalMediaPlayer.setDataSource(context, uri);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(14)
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, context, uri, map) == null) {
            this.mInternalMediaPlayer.setDataSource(context, uri, map);
        }
    }

    @Override // com.kwai.video.player.AbstractMediaPlayer, com.kwai.video.player.IMediaPlayer
    @TargetApi(23)
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iMediaDataSource) == null) {
            releaseMediaDataSource();
            MediaDataSourceProxy mediaDataSourceProxy = new MediaDataSourceProxy(iMediaDataSource);
            this.mMediaDataSource = mediaDataSourceProxy;
            this.mInternalMediaPlayer.setDataSource(mediaDataSourceProxy);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, fileDescriptor) == null) {
            this.mInternalMediaPlayer.setDataSource(fileDescriptor);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mDataSource = str;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
                this.mInternalMediaPlayer.setDataSource(str);
            } else {
                this.mInternalMediaPlayer.setDataSource(parse.getPath());
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, surfaceHolder) == null) {
            synchronized (this.mInitLock) {
                if (!this.mIsReleased) {
                    this.mInternalMediaPlayer.setDisplay(surfaceHolder);
                }
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mInternalMediaPlayer.setLooping(z);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.mInternalMediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(14)
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, surface) == null) {
            this.mInternalMediaPlayer.setSurface(surface);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setVideoRawDataListener(IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onVideoRawDataListener) == null) {
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.mInternalMediaPlayer.setVolume(f2, f3);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setWakeMode(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, context, i2) == null) {
            this.mInternalMediaPlayer.setWakeMode(context, i2);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.mInternalMediaPlayer.start();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.mInternalMediaPlayer.stop();
        }
    }
}
