package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes.dex */
public interface IMediaPlayer {

    /* loaded from: classes.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i);
    }

    /* loaded from: classes.dex */
    public interface OnCompletionListener {
        void onCompletion(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes.dex */
    public interface OnErrorListener {
        boolean onError(IMediaPlayer iMediaPlayer, int i, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface OnHandleOppoErrorListener {
        void handleOppoError(String str);
    }

    /* loaded from: classes.dex */
    public interface OnInfoListener {
        boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnPreparedListener {
        void onPrepared(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes.dex */
    public interface OnSpeedWhenInvokingErrorListener {
        void onSpeed(long j);
    }

    /* loaded from: classes.dex */
    public interface OnSubErrorInfoListener {
        void onSubError(int i, int i2, String str);
    }

    /* loaded from: classes.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4);
    }

    int getAudioSessionId();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    MediaInfo getMediaInfo();

    ITrackInfo[] getTrackInfo();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    void handleOppoError(String str);

    boolean isLooping();

    @Deprecated
    boolean isPlayable();

    boolean isPlaying();

    void pause() throws IllegalStateException;

    void prepareAsync() throws IllegalStateException;

    void release();

    void reset();

    void seekTo(long j) throws IllegalStateException;

    void setAudioStreamType(int i);

    void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    @TargetApi(14)
    void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException;

    void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(IMediaDataSource iMediaDataSource);

    void setDisplay(SurfaceHolder surfaceHolder);

    @Deprecated
    void setKeepInBackground(boolean z);

    @Deprecated
    void setLogEnabled(boolean z);

    void setLooping(boolean z);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnHandleOppoErrorListener(OnHandleOppoErrorListener onHandleOppoErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnSpeedWhenInvokingErrorListener(OnSpeedWhenInvokingErrorListener onSpeedWhenInvokingErrorListener);

    void setOnSubErrorListener(OnSubErrorInfoListener onSubErrorInfoListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setScreenOnWhilePlaying(boolean z);

    void setSurface(Surface surface);

    void setVolume(float f, float f2);

    @Deprecated
    void setWakeMode(Context context, int i);

    void start() throws IllegalStateException;

    void stop() throws IllegalStateException;
}
