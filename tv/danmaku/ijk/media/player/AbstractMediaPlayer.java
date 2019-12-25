package tv.danmaku.ijk.media.player;

import com.baidu.adp.lib.util.StringUtils;
import java.util.UUID;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes10.dex */
public abstract class AbstractMediaPlayer implements IMediaPlayer {
    private boolean isNewPlayer = true;
    private IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private IMediaPlayer.OnCompletionListener mOnCompletionListener;
    private IMediaPlayer.OnErrorListener mOnErrorListener;
    private IMediaPlayer.OnHandleOppoErrorListener mOnHandleOppoErrorListener;
    private IMediaPlayer.OnInfoListener mOnInfoListener;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private IMediaPlayer.OnSpeedWhenInvokingErrorListener mOnSpeedWhenInvokingErrorListener;
    private IMediaPlayer.OnSubErrorInfoListener mOnSubErrorInfoListener;
    private IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private String uuid;

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSubErrorListener(IMediaPlayer.OnSubErrorInfoListener onSubErrorInfoListener) {
        this.mOnSubErrorInfoListener = onSubErrorInfoListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnHandleOppoErrorListener(IMediaPlayer.OnHandleOppoErrorListener onHandleOppoErrorListener) {
        this.mOnHandleOppoErrorListener = onHandleOppoErrorListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void resetListeners() {
        this.isNewPlayer = true;
        this.mOnPreparedListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnSubErrorInfoListener = null;
        this.mOnHandleOppoErrorListener = null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isNewPlayer() {
        return this.isNewPlayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnPrepared() {
        if (this.mOnPreparedListener != null) {
            this.mOnPreparedListener.onPrepared(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnCompletion() {
        if (this.mOnCompletionListener != null) {
            this.mOnCompletionListener.onCompletion(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnBufferingUpdate(int i) {
        if (this.mOnBufferingUpdateListener != null) {
            this.mOnBufferingUpdateListener.onBufferingUpdate(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnSeekComplete() {
        if (this.mOnSeekCompleteListener != null) {
            this.mOnSeekCompleteListener.onSeekComplete(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnVideoSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mOnVideoSizeChangedListener != null) {
            this.mOnVideoSizeChangedListener.onVideoSizeChanged(this, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean notifyOnError(int i, int i2, int i3) {
        return this.mOnErrorListener != null && this.mOnErrorListener.onError(this, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean notifyOnInfo(int i, int i2) {
        if (i == 3) {
            this.isNewPlayer = false;
        }
        return this.mOnInfoListener != null && this.mOnInfoListener.onInfo(this, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOnSubError(int i, int i2, String str) {
        if (this.mOnSubErrorInfoListener != null) {
            this.mOnSubErrorInfoListener.onSubError(i, i2, str);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void handleOppoError(String str) {
        notifyOppoError(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyOppoError(String str) {
        if (this.mOnHandleOppoErrorListener != null) {
            this.mOnHandleOppoErrorListener.handleOppoError(str);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSpeedWhenInvokingErrorListener(IMediaPlayer.OnSpeedWhenInvokingErrorListener onSpeedWhenInvokingErrorListener) {
        this.mOnSpeedWhenInvokingErrorListener = onSpeedWhenInvokingErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifySpeed(long j) {
        if (this.mOnSpeedWhenInvokingErrorListener != null) {
            this.mOnSpeedWhenInvokingErrorListener.onSpeed(j);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public String generateMediaID() {
        if (StringUtils.isNull(this.uuid)) {
            this.uuid = UUID.randomUUID().toString();
        }
        return this.uuid;
    }
}
