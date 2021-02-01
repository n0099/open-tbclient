package com.kwai.video.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwai.video.player.misc.IMediaDataSource;
import com.kwai.video.player.misc.ITrackInfo;
import java.io.FileDescriptor;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IMediaPlayer {
    public static final int kVideoMixOverlay = 1;
    public static final int kVideoMixSideBySide = 2;
    public static final int kVideoMixSingle = 0;
    public static final int kVideoMixUnknow = -1;

    /* loaded from: classes3.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i);
    }

    /* loaded from: classes3.dex */
    public interface OnCompletionListener {
        void onCompletion(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        boolean onError(IMediaPlayer iMediaPlayer, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface OnFftDataCaptureListener {
        void onFftDataCapture(float[] fArr);
    }

    /* loaded from: classes3.dex */
    public interface OnInfoListener {
        boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface OnLiveAdaptiveQosStatListener {
        void onLiveAdaptiveQosStat(IMediaPlayer iMediaPlayer, JSONObject jSONObject);
    }

    /* loaded from: classes3.dex */
    public interface OnLiveEventListener {
        void onLiveEventChange(byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface OnLiveVoiceCommentListener {
        void onLiveVoiceCommentChange(IMediaPlayer iMediaPlayer, String str);
    }

    /* loaded from: classes3.dex */
    public interface OnLogEventListener {
        void onLogEvent(IMediaPlayer iMediaPlayer, String str);
    }

    /* loaded from: classes3.dex */
    public interface OnPreparedListener {
        void onPrepared(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes3.dex */
    public interface OnQosStatListener {
        void onQosStat(IMediaPlayer iMediaPlayer, JSONObject jSONObject);
    }

    /* loaded from: classes3.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: classes3.dex */
    public interface OnVideoRawDataListener {
        void onVideoRawDataAvailable(IMediaPlayer iMediaPlayer, byte[] bArr, int i, int i2, int i3, int i4);

        void onVideoRawDataSize(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4);
    }

    /* loaded from: classes3.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4);
    }

    void addVideoRawBuffer(byte[] bArr);

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

    boolean isLooping();

    @Deprecated
    boolean isPlayable();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void reset();

    void seekTo(long j);

    void setAudioStreamType(int i);

    void setDataSource(Context context, Uri uri);

    @TargetApi(14)
    void setDataSource(Context context, Uri uri, Map<String, String> map);

    void setDataSource(IMediaDataSource iMediaDataSource);

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    @Deprecated
    void setKeepInBackground(boolean z);

    void setLooping(boolean z);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnFftDataCaptureListener(OnFftDataCaptureListener onFftDataCaptureListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnLogEventListener(OnLogEventListener onLogEventListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setScreenOnWhilePlaying(boolean z);

    void setSurface(Surface surface);

    void setVideoRawDataListener(OnVideoRawDataListener onVideoRawDataListener);

    void setVolume(float f, float f2);

    @Deprecated
    void setWakeMode(Context context, int i);

    void start();

    void stop();
}
