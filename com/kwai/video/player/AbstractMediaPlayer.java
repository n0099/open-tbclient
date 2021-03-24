package com.kwai.video.player;

import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.misc.IMediaDataSource;
/* loaded from: classes6.dex */
public abstract class AbstractMediaPlayer implements IMediaPlayer {
    public IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    public IMediaPlayer.OnCompletionListener mOnCompletionListener;
    public IMediaPlayer.OnErrorListener mOnErrorListener;
    public IMediaPlayer.OnFftDataCaptureListener mOnFftDataCaptureListener;
    public IMediaPlayer.OnInfoListener mOnInfoListener;
    public IMediaPlayer.OnLogEventListener mOnLogEventListener;
    public IMediaPlayer.OnPreparedListener mOnPreparedListener;
    public IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    public IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;

    public final void notifyOnBufferingUpdate(int i) {
        IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(this, i);
        }
    }

    public final void notifyOnCompletion() {
        IMediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(this);
        }
    }

    public final boolean notifyOnError(int i, int i2) {
        Timber.d("notifyOnError, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
        IMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
        return onErrorListener != null && onErrorListener.onError(this, i, i2);
    }

    public void notifyOnFftDataCapture(float[] fArr) {
        IMediaPlayer.OnFftDataCaptureListener onFftDataCaptureListener = this.mOnFftDataCaptureListener;
        if (onFftDataCaptureListener != null) {
            onFftDataCaptureListener.onFftDataCapture(fArr);
        }
    }

    public final boolean notifyOnInfo(int i, int i2) {
        IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
        return onInfoListener != null && onInfoListener.onInfo(this, i, i2);
    }

    public final void notifyOnLogEvent(String str) {
        IMediaPlayer.OnLogEventListener onLogEventListener = this.mOnLogEventListener;
        if (onLogEventListener != null) {
            onLogEventListener.onLogEvent(this, str);
        }
    }

    public final void notifyOnPrepared() {
        IMediaPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this);
        }
    }

    public final void notifyOnSeekComplete() {
        IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete(this);
        }
    }

    public final void notifyOnVideoSizeChanged(int i, int i2, int i3, int i4) {
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(this, i, i2, i3, i4);
        }
    }

    public void resetListeners() {
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

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnFftDataCaptureListener(IMediaPlayer.OnFftDataCaptureListener onFftDataCaptureListener) {
        this.mOnFftDataCaptureListener = onFftDataCaptureListener;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnLogEventListener(IMediaPlayer.OnLogEventListener onLogEventListener) {
        this.mOnLogEventListener = onLogEventListener;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public final void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }
}
