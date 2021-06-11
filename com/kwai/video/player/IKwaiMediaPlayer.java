package com.kwai.video.player;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.MotionEvent;
import com.kwai.player.OnPlayerReleaseListener;
import com.kwai.player.debuginfo.KwaiPlayerDebugInfoProvider;
import com.kwai.player.debuginfo.model.AppLiveQosDebugInfo;
import com.kwai.player.qos.AppLiveReatimeInfoProvider;
import com.kwai.player.qos.KwaiQosInfo;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.KsMediaPlayer;
import com.kwai.video.player.PlayerSettingConstants;
import com.kwai.video.player.kwai_player.AspectAwesomeCache;
import com.kwai.video.player.kwai_player.AspectKFlv;
import com.kwai.video.player.kwai_player.AspectKwaiVodAdaptive;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface IKwaiMediaPlayer extends KwaiPlayerDebugInfoProvider, AppLiveReatimeInfoProvider, IMediaPlayer {

    /* loaded from: classes7.dex */
    public interface OnLiveInterActiveListener {
        void onParseAdSei(long j, int i2, String str);

        void onTsptInfo(byte[] bArr, int i2);

        void onVideoFrameRender(long j);
    }

    void audioOnly(boolean z);

    int bufferEmptyCount();

    @Deprecated
    int bufferEmptyCountOld();

    long bufferEmptyDuration();

    @Deprecated
    long bufferEmptyDurationOld();

    boolean checkCanStartPlay();

    void disableSoftVideoDecode(boolean z);

    void enableAudioMono(@PlayerSettingConstants.AudioMonoType int i2);

    void enableLoopOnBlock(int i2, int i3, long j);

    AppLiveQosDebugInfo getAppLiveQosDebugInfo();

    AspectAwesomeCache getAspectAwesomeCache();

    AspectKFlv getAspectKFlv();

    AspectKwaiVodAdaptive getAspectVodAdaptive();

    float getAudioRawLatencySeconds();

    float getAverageDisplayFps();

    long getBitrate();

    String getBriefVodStatJson();

    float getBufferTimeMax();

    long getCurAbsTime();

    long getDecodeVideoFrameCount();

    long getDecodedDataSize();

    long getDecodedVideoHeight();

    long getDecodedVideoWidth();

    long getDisplayFrameCount();

    long getDownloadDataSize();

    int getDownloadedPercent();

    long getDroppedDuration();

    long getDtsDuration();

    String getKwaiLiveVoiceComment(long j);

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    String getLiveRealTimeQosJson(int i2, int i3, long j, long j2, long j3);

    String getLiveStatJson();

    @Deprecated
    Bundle getMediaMeta();

    int getOrientaionDegree();

    float getProbeFps();

    long getReadVideoFrameCount();

    Bitmap getScreenShot();

    long getSourceDeviceType();

    float getSpeed(float f2);

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    KwaiQosInfo getStreamQosInfo();

    float getVideoAvgFps();

    long getVideoDecErrorCount();

    int getVideoDecoder();

    float getVideoOutputFramesPerSecond();

    String getVodAdaptiveCacheKey();

    String getVodAdaptiveHostName();

    int getVodAdaptiveRepID();

    String getVodAdaptiveUrl();

    String getVodStatJson();

    boolean handleTouchEvent(MotionEvent motionEvent);

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    boolean isMediaPlayerValid();

    void registerSensorEvent();

    void releaseAsync();

    void releaseAsync(OnPlayerReleaseListener onPlayerReleaseListener);

    void setAppQosStatJson(JSONObject jSONObject);

    void setCencKey(String str);

    void setDataSource(String str, Map<String, String> map);

    void setEnableAudioSpectrum(boolean z);

    void setIndexContent(String str, String str2, String str3, Map<String, String> map);

    void setInteractiveMode(int i2);

    void setKwaiManifest(String str, String str2, Map<String, String> map);

    void setKwaiRepresentationListener(IKwaiRepresentationListener iKwaiRepresentationListener);

    void setLastTryFlag(boolean z);

    void setLiveManifestSwitchMode(@PlayerSettingConstants.KFlvSwitchMode int i2);

    void setLiveOnPeriodicalLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener);

    void setLiveOnQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener);

    void setOnAudioProcessPCMAvailableListener(KsMediaPlayer.OnAudioProcessPCMListener onAudioProcessPCMListener);

    void setOnLiveEventListener(IMediaPlayer.OnLiveEventListener onLiveEventListener);

    void setOnLiveInterActiveListener(OnLiveInterActiveListener onLiveInterActiveListener);

    void setOnLiveVoiceCommentListener(IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener);

    void setPlayerMute(boolean z);

    void setRepresentation(int i2);

    void setSpeed(float f2);

    void setSurfaceTexture(SurfaceTexture surfaceTexture);

    void setTag1(int i2);

    void setTone(int i2);

    void setVideoScalingMode(@PlayerSettingConstants.ScalingMode int i2);

    void shutdownWaitStop();

    void stepFrame();

    void stopLiveStatTimerImmediately();

    void unRegisterSensorEvent();

    void updateCurrentMaxWallClockOffset(long j);

    void updateCurrentWallClock(long j);
}
