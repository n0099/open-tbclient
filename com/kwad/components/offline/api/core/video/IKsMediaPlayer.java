package com.kwad.components.offline.api.core.video;

import android.view.Surface;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoPlayStateListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
/* loaded from: classes10.dex */
public interface IKsMediaPlayer {
    void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener);

    void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener);

    void clear();

    int getBufferPercentage();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    long getDuration();

    int getMaxVolume();

    IMediaPlayer getMediaPlayer();

    int getMediaPlayerType();

    long getPlayDuration();

    String getStateString(int i);

    int getVideoHeight();

    int getVideoWidth();

    int getVolume();

    void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, @NonNull IKsMediaPlayerView iKsMediaPlayerView);

    void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, boolean z, boolean z2, @NonNull IKsMediaPlayerView iKsMediaPlayerView);

    boolean isPlaying();

    boolean isPrepared();

    boolean isPreparing();

    void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i, int i2);

    void onPlayStateChanged(int i);

    boolean pause();

    void prepareAsync();

    void registerVideoPlayStateListener(VideoPlayStateListener videoPlayStateListener);

    void release();

    void release(ReleaseCallback releaseCallback);

    void release(ReleaseCallback releaseCallback, boolean z);

    void releaseSync();

    void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener);

    void resetAndPlay(PlayVideoInfo playVideoInfo);

    void restart();

    void resume();

    void seekTo(long j);

    void setAudioEnabled(boolean z);

    void setDataSource(@NonNull PlayVideoInfo playVideoInfo);

    void setRadius(float f, float f2, float f3, float f4);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void setVolume(float f, float f2);

    void start();

    void start(long j);

    void stopAndPrepareAsync();

    void unRegisterVideoPlayStateListener(VideoPlayStateListener videoPlayStateListener);

    void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams);
}
