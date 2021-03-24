package com.kwai.video.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.misc.AndroidTrackInfo;
import com.kwai.video.player.misc.IMediaDataSource;
import com.kwai.video.player.misc.ITrackInfo;
import com.kwai.video.player.pragma.DebugLog;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes6.dex */
public class AndroidMediaPlayer extends AbstractMediaPlayer {
    public static MediaInfo sMediaInfo;
    public String mDataSource;
    public final Object mInitLock;
    public final AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
    public final MediaPlayer mInternalMediaPlayer;
    public boolean mIsReleased;
    public MediaDataSource mMediaDataSource;

    /* loaded from: classes6.dex */
    public class AndroidMediaPlayerListenerHolder implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        public final WeakReference<AndroidMediaPlayer> mWeakMediaPlayer;

        public AndroidMediaPlayerListenerHolder(AndroidMediaPlayer androidMediaPlayer) {
            this.mWeakMediaPlayer = new WeakReference<>(androidMediaPlayer);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnBufferingUpdate(i);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnCompletion();
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return this.mWeakMediaPlayer.get() != null && AndroidMediaPlayer.this.notifyOnError(i, i2);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return this.mWeakMediaPlayer.get() != null && AndroidMediaPlayer.this.notifyOnInfo(i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnPrepared();
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnSeekComplete();
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.mWeakMediaPlayer.get() == null) {
                return;
            }
            AndroidMediaPlayer.this.notifyOnVideoSizeChanged(i, i2, 1, 1);
        }
    }

    @TargetApi(23)
    /* loaded from: classes6.dex */
    public static class MediaDataSourceProxy extends MediaDataSource {
        public final IMediaDataSource mMediaDataSource;

        public MediaDataSourceProxy(IMediaDataSource iMediaDataSource) {
            this.mMediaDataSource = iMediaDataSource;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mMediaDataSource.close();
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return this.mMediaDataSource.getSize();
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) {
            return this.mMediaDataSource.readAt(j, bArr, i, i2);
        }
    }

    public AndroidMediaPlayer() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.mInitLock = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.mInternalMediaPlayer = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new AndroidMediaPlayerListenerHolder(this);
        attachInternalListeners();
    }

    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource = this.mMediaDataSource;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.mMediaDataSource = null;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void addVideoRawBuffer(byte[] bArr) {
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public long getCurrentPosition() {
        try {
            return this.mInternalMediaPlayer.getCurrentPosition();
        } catch (IllegalStateException e2) {
            DebugLog.printStackTrace(e2);
            return 0L;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public String getDataSource() {
        return this.mDataSource;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public long getDuration() {
        try {
            return this.mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException e2) {
            DebugLog.printStackTrace(e2);
            return 0L;
        }
    }

    public MediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
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

    @Override // com.kwai.video.player.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarDen() {
        return 1;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarNum() {
        return 1;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isPlaying() {
        try {
            return this.mInternalMediaPlayer.isPlaying();
        } catch (IllegalStateException e2) {
            DebugLog.printStackTrace(e2);
            return false;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void pause() {
        this.mInternalMediaPlayer.pause();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void prepareAsync() {
        this.mInternalMediaPlayer.prepareAsync();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void release() {
        this.mIsReleased = true;
        this.mInternalMediaPlayer.release();
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void reset() {
        try {
            this.mInternalMediaPlayer.reset();
        } catch (IllegalStateException e2) {
            DebugLog.printStackTrace(e2);
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void seekTo(long j) {
        this.mInternalMediaPlayer.seekTo((int) j);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setAudioStreamType(int i) {
        this.mInternalMediaPlayer.setAudioStreamType(i);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(14)
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    @Override // com.kwai.video.player.AbstractMediaPlayer, com.kwai.video.player.IMediaPlayer
    @TargetApi(23)
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        releaseMediaDataSource();
        MediaDataSourceProxy mediaDataSourceProxy = new MediaDataSourceProxy(iMediaDataSource);
        this.mMediaDataSource = mediaDataSourceProxy;
        this.mInternalMediaPlayer.setDataSource(mediaDataSourceProxy);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(String str) {
        this.mDataSource = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.mInternalMediaPlayer.setDataSource(str);
        } else {
            this.mInternalMediaPlayer.setDataSource(parse.getPath());
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.mInitLock) {
            if (!this.mIsReleased) {
                this.mInternalMediaPlayer.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setLooping(boolean z) {
        this.mInternalMediaPlayer.setLooping(z);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(14)
    public void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setVideoRawDataListener(IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener) {
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setVolume(float f2, float f3) {
        this.mInternalMediaPlayer.setVolume(f2, f3);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setWakeMode(Context context, int i) {
        this.mInternalMediaPlayer.setWakeMode(context, i);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void start() {
        this.mInternalMediaPlayer.start();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void stop() {
        this.mInternalMediaPlayer.stop();
    }
}
