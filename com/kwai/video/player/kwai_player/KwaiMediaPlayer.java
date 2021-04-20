package com.kwai.video.player.kwai_player;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.android.internal.http.multipart.Part;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.kwai.player.KwaiPlayerConfig;
import com.kwai.player.KwaiPlayerReleasePool;
import com.kwai.player.OnPlayerReleaseListener;
import com.kwai.player.debuginfo.model.AppLiveQosDebugInfo;
import com.kwai.player.debuginfo.model.AppLiveQosDebugInfoNew;
import com.kwai.player.debuginfo.model.AppVodQosDebugInfoNew;
import com.kwai.player.debuginfo.model.KwaiPlayerDebugInfo;
import com.kwai.player.debuginfo.model.PlayerConfigDebugInfo;
import com.kwai.player.qos.AppLiveAdaptiveRealtimeInfo;
import com.kwai.player.qos.AppQosLiveAdaptiveRealtimeWrapper;
import com.kwai.player.qos.AppQosLiveRealtimeWrapper;
import com.kwai.player.qos.KwaiPlayerResultQos;
import com.kwai.player.qos.KwaiQosInfo;
import com.kwai.player.vr.KwaiVR;
import com.kwai.player.vr.SurfaceTextureRenderer;
import com.kwai.video.cache.PlayerPreferrenceUtil;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.AbstractNativeMediaPlayer;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.IKwaiRepresentationListener;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.KsMediaPlayerInitConfig;
import com.kwai.video.player.MediaInfo;
import com.kwai.video.player.PlayerProps;
import com.kwai.video.player.PlayerSettingConstants;
import com.kwai.video.player.annotations.CalledByNative;
import com.kwai.video.player.annotations.RuntimePlayerConfig;
import com.kwai.video.player.misc.IMediaDataSource;
import com.kwai.video.player.misc.KsTrackInfo;
import com.kwai.video.player.pragma.DebugLog;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
@Keep
/* loaded from: classes6.dex */
public final class KwaiMediaPlayer extends AbstractNativeMediaPlayer implements IKwaiMediaPlayer {
    public static final int AUDIO_CHANNEL_MODE_FOA = 2;
    public static final int INPUT_DATA_TYPE_HLS_CUSTOME_MANIFEST = 3;
    public static final int INPUT_DATA_TYPE_INDEX_CONTENT = 2;
    public static final int INPUT_DATA_TYPE_SINGLE_URL = 0;
    public static final int INPUT_DATA_TYPE_VOD_MANIFEST = 1;
    public static final int MEDIA_BUFFERSIZE_DEFAULT = 20;
    public static final String TAG = "com.kwai.video.player.kwai_player.KwaiMediaPlayer";
    public AppQosLiveAdaptiveRealtimeWrapper mAppQosLiveAdaptiveRealtimeWrapper;
    public AppQosLiveRealtimeWrapper mAppQosLiveRealtimeWrapper;
    public AspectAwesomeCache mAspectAwesomeCache;
    public AspectKFlv mAspectKFlv;
    public int mAudioChannelMode;
    public int mBufferingCount;
    public Context mContext;
    public String mDataSource;
    public boolean mIsLive;
    public boolean mIsVR;
    public boolean mIsVodAdaptive;
    public IKwaiRepresentationListener mKwaiRepresentationListener;
    public KwaiVR mKwaiVR;
    public OnControlMessageListener mOnControlMessageListener;
    public IMediaPlayer.OnLiveVoiceCommentListener mOnLiveVoiceCommentListener;
    public OnNativeInvokeListener mOnNativeInvokeListener;
    public boolean mScreenOnWhilePlaying;
    public long mStartBufferingTime;
    public boolean mStayAwake;
    public SurfaceHolder mSurfaceHolder;
    public SurfaceTextureRenderer mSurfaceTextureRender;
    public int mTotalBufferingTime;
    public int mVideoHeight;
    public int mVideoSarDen;
    public int mVideoSarNum;
    public int mVideoWidth;
    public AspectKwaiVodAdaptive mVodAdaptive;
    public PowerManager.WakeLock mWakeLock = null;
    public int mInteractivemode = 0;
    public int mStereoType = 0;
    public ByteBuffer mProcessPCMBuffer = null;
    public KwaiPlayerDebugInfo mKwaiPlayerDebugInfo = new KwaiPlayerDebugInfo();

    /* loaded from: classes6.dex */
    public interface IHeadTrackerListener {
        void onHeadTracker(float f2, float f3, float f4);
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i);
    }

    /* loaded from: classes6.dex */
    public interface OnNativeInvokeListener {
        public static final String ARG_RETRY_COUNTER = "retry_counter";
        public static final String ARG_SEGMENT_INDEX = "segment_index";
        public static final String ARG_URL = "url";
        public static final int ON_CONCAT_RESOLVE_SEGMENT = 65536;
        public static final int ON_HTTP_OPEN = 65538;
        public static final int ON_LIVE_RETRY = 65540;
        public static final int ON_TCP_OPEN = 65537;

        boolean onNativeInvoke(int i, Bundle bundle);
    }

    public KwaiMediaPlayer() {
        initPlayer();
        resetSomething();
    }

    private native void _addVideoRawBuffer(byte[] bArr);

    private native void _audioOnly(boolean z);

    private native boolean _checkCanStartPlay();

    private native void _disableSoftVideoDecode(boolean z);

    private native void _enableLoopOnBlock(int i, int i2, long j);

    private native void _enableVideoRawDataCallback(boolean z);

    private native Bundle _getAppLiveAdaptiveRealtimeInfo();

    private native Bundle _getAppLiveQosDebugInfo();

    private native void _getAppLiveQosDebugInfoNew(AppLiveQosDebugInfoNew appLiveQosDebugInfoNew);

    private native void _getAppVodQosDebugInfoNew(AppVodQosDebugInfoNew appVodQosDebugInfoNew);

    private native String _getAudioCodecInfo();

    private native String _getBriefVideoStatJson();

    public static native String _getColorFormatName(int i);

    private native int _getDownloadedPercent();

    private native String _getKwaiLiveVoiceComment(long j);

    private native String _getKwaiSign();

    private native String _getLiveRealTimeQosJson(int i, int i2, long j, long j2, long j3);

    private native String _getLiveStatJson();

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    public static native int _getPlayerAliveCnt();

    private native void _getPlayerConfigDebugInfo(PlayerConfigDebugInfo playerConfigDebugInfo);

    private native float _getProbeFps();

    private native Bundle _getQosInfo();

    /* JADX INFO: Access modifiers changed from: private */
    public native KwaiPlayerResultQos _getResultQos();

    private native void _getScreenShot(Bitmap bitmap);

    private native String _getVideoCodecInfo();

    private native String _getVideoStatJson();

    private native String _getVodAdaptiveCacheKey();

    private native String _getVodAdaptiveHostName();

    private native String _getVodAdaptiveUrl();

    private native String _getXksCache();

    private native boolean _isCacheEnabled();

    private native boolean _isMediaPlayerValid();

    private native void _pause();

    private native void _prepareAsync();

    private native void _release();

    private native void _reload(String str, boolean z);

    private native void _reset();

    private native void _setCodecFlag(int i);

    private native void _setDataSource(IMediaDataSource iMediaDataSource);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void _setDataSourceFd(int i, long j, long j2);

    private native void _setHeadTracker(float f2, float f3, float f4);

    private native void _setHevcCodecName(String str);

    private native void _setLastTryFlag(int i);

    private native void _setLiveAppQosInfo(String str);

    private native void _setLiveManifestSwitchMode(int i);

    private native void _setLoopCount(int i);

    private native void _setOnLiveInterActiveListener(Object obj);

    private native void _setOption(int i, String str, long j);

    private native void _setOption(int i, String str, String str2);

    private native void _setPlayerMute(int i);

    private native void _setProcessPCMBuffer(ByteBuffer byteBuffer);

    private native void _setRepresentation(int i);

    private native void _setRepresentationListener(Object obj);

    private native boolean _setRotateDegree(int i);

    private native void _setSpeed(float f2);

    private native void _setStreamSelected(int i, boolean z);

    private native void _setSurfaceTexture(SurfaceTexture surfaceTexture);

    private native void _setTone(int i);

    private native void _setVideoScalingMode(int i);

    private native void _setVideoSurface(Surface surface);

    private native void _shutdownWaitStop();

    private native void _start();

    private native void _step_frame();

    private native void _stop();

    private native void _updateCurrentMaxWallClockOffset(long j);

    private native void _updateCurrentWallClock(long j);

    private void configHeaders(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        String str = map.get("Host");
        if (str != null) {
            setOption(4, "host", str);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            if (!TextUtils.isEmpty(entry.getValue())) {
                sb.append(entry.getValue());
            }
            sb.append(Part.CRLF);
        }
        setOption(1, "headers", sb.toString());
    }

    private void configUserAgent() {
        String format = String.format("a/%s/%s/%s", KsMediaPlayerInitConfig.packageName, KsMediaPlayerInitConfig.packageVersion, getVersion());
        setOption(1, "user-agent", format);
        Timber.d("user-agent:%s", format);
    }

    public static String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    @TargetApi(13)
    private int getNativeFd(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT < 12) {
            try {
                Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                return declaredField.getInt(fileDescriptor);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException(e3);
            }
        }
        return ParcelFileDescriptor.dup(fileDescriptor).getFd();
    }

    public static native String getVersion();

    public static native String getVersionExt();

    private native void native_finalize();

    public static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setKlogParam(Object obj);

    public static native void native_setKwaiLogLevel(int i);

    public static native void native_setLogLevel(int i);

    private native void native_setup(Object obj);

    private void notifyRepresentationChangeEnd(int i) {
        IKwaiRepresentationListener iKwaiRepresentationListener = this.mKwaiRepresentationListener;
        if (iKwaiRepresentationListener != null) {
            iKwaiRepresentationListener.representationChangeEnd(i);
        }
    }

    private void notifyRepresentationChangeStart(int i, int i2) {
        IKwaiRepresentationListener iKwaiRepresentationListener = this.mKwaiRepresentationListener;
        if (iKwaiRepresentationListener != null) {
            iKwaiRepresentationListener.representationChangeStart(i, i2);
        }
    }

    @CalledByNative
    public static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        OnControlMessageListener onControlMessageListener;
        DebugLog.ifmt(TAG, "onNativeInvoke %d", Integer.valueOf(i));
        if (obj == null || !(obj instanceof WeakReference)) {
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        KwaiMediaPlayer kwaiMediaPlayer = (KwaiMediaPlayer) ((WeakReference) obj).get();
        if (kwaiMediaPlayer != null) {
            OnNativeInvokeListener onNativeInvokeListener = kwaiMediaPlayer.mOnNativeInvokeListener;
            if (onNativeInvokeListener == null || !onNativeInvokeListener.onNativeInvoke(i, bundle)) {
                if (i == 65536 && (onControlMessageListener = kwaiMediaPlayer.mOnControlMessageListener) != null) {
                    int i2 = bundle.getInt("segment_index", -1);
                    if (i2 >= 0) {
                        String onControlResolveSegmentUrl = onControlMessageListener.onControlResolveSegmentUrl(i2);
                        if (onControlResolveSegmentUrl != null) {
                            bundle.putString("url", onControlResolveSegmentUrl);
                            return true;
                        }
                        throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
                    }
                    throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
                }
                return false;
            }
            return true;
        }
        throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
    }

    private void resetSomething() {
        this.mBufferingCount = 0;
        this.mTotalBufferingTime = 0;
        this.mStartBufferingTime = 0L;
    }

    private void setDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        this.mDataSource = fileDescriptor.toString();
        _setDataSourceFd(getNativeFd(fileDescriptor), j, j2);
    }

    @Deprecated
    private void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    private void setVideoSurface(Surface surface) {
        if (this.mIsVR) {
            Surface openSurface = surface != null ? openSurface() : surface;
            SurfaceTextureRenderer surfaceTextureRenderer = this.mSurfaceTextureRender;
            if (surfaceTextureRenderer != null) {
                surfaceTextureRenderer.updateNativeWindow(surface);
            }
            surface = openSurface;
        }
        _setVideoSurface(surface);
    }

    @SuppressLint({"Wakelock"})
    private void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    public native void _enableAbLoop(long j, long j2);

    public native void _enablePreDemux(int i, long j);

    public native float _getPropertyFloat(int i, float f2);

    public native long _getPropertyLong(int i, long j);

    public native String _getPropertyString(int i);

    public native boolean _isLiveManifest();

    public native void _setAwesomeCacheCallback(Object obj);

    public native void _setBufferSize(int i);

    public native void _setConfigJson(String str);

    public native void _setConnectionTimeout(int i);

    public native void _setLiveLowDelayConfigJson(String str);

    public native void _setPropertyFloat(int i, float f2);

    public native void _setPropertyLong(int i, long j);

    public native void _setQy265Context(Object obj);

    public native void _setStartPlayBlockBufferMs(int i, int i2);

    public native void _setTimeout(int i);

    public native void _setupCacheSessionListener(Object obj);

    @Override // com.kwai.video.player.IMediaPlayer
    public void addVideoRawBuffer(byte[] bArr) {
        _addVideoRawBuffer(bArr);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void audioOnly(boolean z) {
        _audioOnly(z);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    @Deprecated
    public int bufferEmptyCount() {
        return (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_BLOCKCNT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public int bufferEmptyCountOld() {
        return this.mBufferingCount;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    @Deprecated
    public long bufferEmptyDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_BUFFERTIME, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long bufferEmptyDurationOld() {
        return this.mTotalBufferingTime;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public boolean checkCanStartPlay() {
        return _checkCanStartPlay();
    }

    public void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void disableSoftVideoDecode(boolean z) {
        _disableSoftVideoDecode(z);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void enableAudioMono(@PlayerSettingConstants.AudioMonoType int i) {
        setOption(4, "audio-mono-type", i);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void enableLoopOnBlock(int i, int i2, long j) {
        _enableLoopOnBlock(i, i2, j);
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public void enableVideoRawDataCallback(boolean z) {
        _enableVideoRawDataCallback(z);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public AppLiveAdaptiveRealtimeInfo getAppLiveAdaptiveRealtimeInfo() {
        return AppLiveAdaptiveRealtimeInfo.from(_getAppLiveAdaptiveRealtimeInfo());
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public AppLiveQosDebugInfo getAppLiveQosDebugInfo() {
        return AppLiveQosDebugInfo.from(_getAppLiveQosDebugInfo());
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public AspectAwesomeCache getAspectAwesomeCache() {
        AspectAwesomeCache aspectAwesomeCache = this.mAspectAwesomeCache;
        if (aspectAwesomeCache != null) {
            return aspectAwesomeCache;
        }
        throw new NullPointerException("AspectAwesomeCache is not setup");
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public AspectKFlv getAspectKFlv() {
        AspectKFlv aspectKFlv = this.mAspectKFlv;
        if (aspectKFlv != null) {
            return aspectKFlv;
        }
        throw new NullPointerException("AspectKFlv is not setup");
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public AspectKwaiVodAdaptive getAspectVodAdaptive() {
        AspectKwaiVodAdaptive aspectKwaiVodAdaptive = this.mVodAdaptive;
        if (aspectKwaiVodAdaptive != null) {
            return aspectKwaiVodAdaptive;
        }
        throw new NullPointerException("AspectKwaiVodAdaptive is not setup");
    }

    @Deprecated
    public long getAudioCachedBytes() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_BYTES, 0L);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public long getAudioCachedDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_DURATION, 0L);
    }

    @Deprecated
    public long getAudioCachedPackets() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_PACKETS, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getAudioRawLatencySeconds() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_AUDIO_RAW_LATENCY_SECONDS, 0.0f);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native int getAudioSessionId();

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getAverageDisplayFps() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_AVERAGE_DISPLAYED_FPS, 0.0f);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getBitrate() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_BIT_RATE, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getBriefVodStatJson() {
        return _getBriefVideoStatJson();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getBufferTimeMax() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_BUFFERSIZE_MAX, 0.0f);
    }

    @Deprecated
    public long getCpuUsage() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_CPU, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getCurAbsTime() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_CURRENT_ABSOLUTE_TIME, 0L);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getCurPlayingUrl() {
        return _getPropertyString(PlayerProps.FFP_PROP_STRING_PLAYING_URL);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native long getCurrentPosition();

    @Override // com.kwai.video.player.IMediaPlayer
    public String getDataSource() {
        return this.mDataSource;
    }

    @Override // com.kwai.player.debuginfo.KwaiPlayerDebugInfoProvider
    public KwaiPlayerDebugInfo getDebugInfo() {
        if (TextUtils.isEmpty(this.mKwaiPlayerDebugInfo.mSdkVersion)) {
            this.mKwaiPlayerDebugInfo.mSdkVersion = getVersion();
        }
        PlayerConfigDebugInfo playerConfigDebugInfo = this.mKwaiPlayerDebugInfo.mPlayerApplyConfig;
        if (!playerConfigDebugInfo.collectFinish) {
            _getPlayerConfigDebugInfo(playerConfigDebugInfo);
        }
        this.mKwaiPlayerDebugInfo.setIsLive(this.mIsLive);
        if (this.mIsLive) {
            KwaiPlayerDebugInfo kwaiPlayerDebugInfo = this.mKwaiPlayerDebugInfo;
            if (kwaiPlayerDebugInfo.mAppLiveQosDebugInfoNew == null) {
                kwaiPlayerDebugInfo.mAppLiveQosDebugInfoNew = new AppLiveQosDebugInfoNew();
            }
            _getAppLiveQosDebugInfoNew(this.mKwaiPlayerDebugInfo.mAppLiveQosDebugInfoNew);
            this.mKwaiPlayerDebugInfo.mAppLiveQosDebugInfoNew.setWidth(getVideoWidth());
            this.mKwaiPlayerDebugInfo.mAppLiveQosDebugInfoNew.setHeight(getVideoHeight());
        } else {
            KwaiPlayerDebugInfo kwaiPlayerDebugInfo2 = this.mKwaiPlayerDebugInfo;
            if (kwaiPlayerDebugInfo2.mAppVodQosDebugInfo == null) {
                kwaiPlayerDebugInfo2.mAppVodQosDebugInfo = new AppVodQosDebugInfoNew();
            }
            _getAppVodQosDebugInfoNew(this.mKwaiPlayerDebugInfo.mAppVodQosDebugInfo);
        }
        return this.mKwaiPlayerDebugInfo;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDecodeVideoFrameCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DECODED_VIDEO_FRAME_COUNT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDecodedDataSize() {
        return _getPropertyLong(PlayerProps.PROP_LONG_DECODED_SIZE, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDecodedVideoHeight() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_HEIGHT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDecodedVideoWidth() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_WIDTH, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDisplayFrameCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DISPLAYED_FRAME_COUNT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDownloadDataSize() {
        return _getPropertyLong(PlayerProps.PROP_LONG_DOWNLOAD_SIZE, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public int getDownloadedPercent() {
        return _getDownloadedPercent();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDroppedDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DROPPED_DURATION, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDtsDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DTS_DURATION, 0L);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native long getDuration();

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    @Deprecated
    public String getKflvVideoPlayingUrl() {
        return getCurPlayingUrl();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getKwaiLiveVoiceComment(long j) {
        return _getKwaiLiveVoiceComment(j);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getKwaiSign() {
        return _getKwaiSign();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer, com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getLiveRealTimeQosJson(int i, int i2, long j, long j2, long j3) {
        return _getLiveRealTimeQosJson(i, i2, j, j2, j3);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getLiveStatJson() {
        return _getLiveStatJson();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = "kwaiplayer";
        String _getVideoCodecInfo = _getVideoCodecInfo();
        if (!TextUtils.isEmpty(_getVideoCodecInfo)) {
            String[] split = _getVideoCodecInfo.split(",");
            if (split.length >= 2) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = split[1];
            } else if (split.length >= 1) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = "";
            }
        }
        String _getAudioCodecInfo = _getAudioCodecInfo();
        if (!TextUtils.isEmpty(_getAudioCodecInfo)) {
            String[] split2 = _getAudioCodecInfo.split(",");
            if (split2.length >= 2) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = split2[1];
            } else if (split2.length >= 1) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = "";
            }
        }
        try {
            mediaInfo.mMeta = KsMediaMeta.parse(_getMediaMeta());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return mediaInfo;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    @Deprecated
    public long getMemorySize() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_MEMORY, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public int getOrientaionDegree() {
        KwaiVR kwaiVR = this.mKwaiVR;
        if (kwaiVR != null) {
            return kwaiVR.getOrientaionDegrees();
        }
        return 0;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getProbeFps() {
        return _getProbeFps();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getReadVideoFrameCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_READ_VIDEO_FRAME_COUNT, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public Bitmap getScreenShot() {
        int i;
        int i2 = this.mVideoWidth;
        if (i2 <= 0 || (i = this.mVideoHeight) <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.RGB_565);
        _getScreenShot(createBitmap);
        return createBitmap;
    }

    public int getSelectedTrack(int i) {
        int i2;
        if (i == 1) {
            i2 = 20001;
        } else if (i != 2) {
            return -1;
        } else {
            i2 = PlayerProps.FFP_PROP_INT64_SELECTED_AUDIO_STREAM;
        }
        return (int) _getPropertyLong(i2, -1L);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getServerAddress() {
        return _getPropertyString(PlayerProps.PROP_STRING_SERVER_IP);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getSourceDeviceType() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_SOURCE_DEVICE_TYPE, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getSpeed(float f2) {
        return _getPropertyFloat(10003, 0.0f);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getStreamId() {
        return _getPropertyString(PlayerProps.FFP_PROP_STRING_STREAM_ID);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer, com.kwai.player.qos.AppLiveReatimeInfoProvider
    public KwaiQosInfo getStreamQosInfo() {
        return KwaiQosInfo.fromBundle(_getQosInfo());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.video.player.IMediaPlayer
    public KsTrackInfo[] getTrackInfo() {
        KsMediaMeta parse;
        int i;
        Bundle mediaMeta = getMediaMeta();
        if (mediaMeta == null || (parse = KsMediaMeta.parse(mediaMeta)) == null || parse.mStreams == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<KsMediaMeta.KSYStreamMeta> it = parse.mStreams.iterator();
        while (it.hasNext()) {
            KsMediaMeta.KSYStreamMeta next = it.next();
            KsTrackInfo ksTrackInfo = new KsTrackInfo(next);
            if (next.mType.equalsIgnoreCase("video")) {
                i = 1;
            } else if (next.mType.equalsIgnoreCase("audio")) {
                i = 2;
            } else {
                arrayList.add(ksTrackInfo);
            }
            ksTrackInfo.setTrackType(i);
            arrayList.add(ksTrackInfo);
        }
        return (KsTrackInfo[]) arrayList.toArray(new KsTrackInfo[arrayList.size()]);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getVideoAvgFps() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_VIDEO_AVG_FPS, 0.0f);
    }

    @Deprecated
    public long getVideoCachedBytes() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_BYTES, 0L);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public long getVideoCachedDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_DURATION, 0L);
    }

    @Deprecated
    public long getVideoCachedPackets() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_PACKETS, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getVideoDecErrorCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_DEC_ERROR_COUNT, 0L);
    }

    public float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public int getVideoDecoder() {
        return (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_DECODER, 0L);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getVodAdaptiveCacheKey() {
        return _getVodAdaptiveCacheKey();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getVodAdaptiveHostName() {
        return _getVodAdaptiveHostName();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public int getVodAdaptiveRepID() {
        return (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_VOD_ADAPTIVE_REP_ID, 0L);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getVodAdaptiveUrl() {
        return _getVodAdaptiveUrl();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getVodStatJson() {
        return _getVideoStatJson();
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getXksCache() {
        return _getXksCache();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public boolean handleTouchEvent(MotionEvent motionEvent) {
        KwaiVR kwaiVR = this.mKwaiVR;
        if (kwaiVR != null) {
            return kwaiVR.handleTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public final void initPlayer() {
        super.initPlayer();
        native_setup(new WeakReference(this));
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public void initProcessPCMBuffer() {
        if (this.mProcessPCMBuffer == null) {
            int _getPropertyLong = (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_BUF_SIZE, 0L);
            this.mProcessPCMBuffer = _getPropertyLong <= 0 ? ByteBuffer.allocate(176000) : ByteBuffer.allocate(_getPropertyLong * 2);
        }
        _setProcessPCMBuffer(this.mProcessPCMBuffer);
    }

    @Deprecated
    public boolean isCacheEnabled() {
        return _isCacheEnabled();
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public boolean isLiveManifest() {
        return this.mAspectKFlv.isLiveManifest();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isLooping() {
        return _getLoopCount() != 1;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer, com.kwai.player.qos.AppLiveReatimeInfoProvider
    public boolean isMediaPlayerValid() {
        return _isMediaPlayerValid();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native boolean isPlaying();

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public void onReceivePostEvent(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i == 1) {
                notifyOnPrepared();
            } else if (i == 2) {
                notifyOnCompletion();
                stayAwake(false);
            } else if (i == 3) {
                notifyOnBufferingUpdate(message.arg1);
            } else if (i == 4) {
                notifyOnSeekComplete();
            } else if (i == 5) {
                int i2 = message.arg2;
                this.mVideoHeight = i2;
                this.mVideoWidth = (this.mIsLive && this.mIsVR) ? (int) (i2 * 0.5625d) : message.arg1;
                notifyOnVideoSizeChanged(this.mVideoWidth, this.mVideoHeight, this.mVideoSarNum, this.mVideoSarDen);
                resizeVideo(this.mVideoWidth, this.mVideoHeight);
            } else if (i != 99) {
                if (i == 100) {
                    Timber.e("MEDIA_ERROR, msg.arg1:%d, msg.arg2:%d", Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
                    if (!notifyOnError(message.arg1, message.arg2)) {
                        notifyOnCompletion();
                    }
                    stayAwake(false);
                } else if (i == 200) {
                    int i3 = message.arg1;
                    if (i3 == 701) {
                        this.mBufferingCount++;
                        this.mStartBufferingTime = System.currentTimeMillis();
                    } else if (i3 == 702) {
                        this.mTotalBufferingTime += (int) (System.currentTimeMillis() - this.mStartBufferingTime);
                    } else if (i3 == 10100) {
                        notifyOnSeekComplete();
                        return;
                    }
                    notifyOnInfo(message.arg1, message.arg2);
                } else if (i == 300) {
                    long j = (message.arg1 << 32) | message.arg2;
                    String kwaiLiveVoiceComment = getKwaiLiveVoiceComment(j);
                    Timber.i("MEDIA_LIVE_VC_TIME, vc_time:%d, voice_comment:%s", Long.valueOf(j), kwaiLiveVoiceComment);
                    IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener = this.mOnLiveVoiceCommentListener;
                    if (onLiveVoiceCommentListener != null) {
                        onLiveVoiceCommentListener.onLiveVoiceCommentChange(this, kwaiLiveVoiceComment);
                    }
                } else if (i == 10001) {
                    int i4 = message.arg1;
                    this.mVideoSarNum = i4;
                    int i5 = message.arg2;
                    this.mVideoSarDen = i5;
                    notifyOnVideoSizeChanged(this.mVideoWidth, this.mVideoHeight, i4, i5);
                } else if (i == 12001) {
                    notifyRepresentationChangeStart(message.arg1, message.arg2);
                } else if (i == 12002) {
                    notifyRepresentationChangeEnd(message.arg1);
                } else {
                    DebugLog.e(TAG, "Unknown message type " + message.what);
                }
            }
        }
    }

    public Surface openSurface() {
        SurfaceTextureRenderer surfaceTextureRenderer = this.mSurfaceTextureRender;
        if (surfaceTextureRenderer != null) {
            try {
                return surfaceTextureRenderer.getSurface();
            } catch (Exception unused) {
                this.mSurfaceTextureRender.release();
                this.mSurfaceTextureRender = null;
            }
        }
        return null;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void pause() {
        stayAwake(false);
        _pause();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void prepareAsync() {
        this.mAppQosLiveRealtimeWrapper.start(this.mDataSource);
        this.mAppQosLiveAdaptiveRealtimeWrapper.start();
        _prepareAsync();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void registerSensorEvent() {
        KwaiVR kwaiVR = this.mKwaiVR;
        if (kwaiVR != null) {
            kwaiVR.registerSensorEvent();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void release() {
        if (this.mIsVodAdaptive) {
            PlayerPreferrenceUtil.getInstance().saveVodAdaptiveData();
        }
        stayAwake(false);
        updateSurfaceScreenOn();
        _release();
        resetListeners();
        this.mAspectAwesomeCache.release();
        if (this.mIsVR) {
            SurfaceTextureRenderer surfaceTextureRenderer = this.mSurfaceTextureRender;
            if (surfaceTextureRenderer != null) {
                surfaceTextureRenderer.release();
            }
            KwaiVR kwaiVR = this.mKwaiVR;
            if (kwaiVR != null) {
                kwaiVR.release();
                this.mKwaiVR = null;
                Log.d(TAG, "release: mkwaivr release");
            }
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void releaseAsync() {
        releaseAsync(null);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void releaseAsync(@Nullable final OnPlayerReleaseListener onPlayerReleaseListener) {
        KwaiPlayerReleasePool.submit(new Runnable() { // from class: com.kwai.video.player.kwai_player.KwaiMediaPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                KwaiMediaPlayer.this.shutdownWaitStop();
                if (onPlayerReleaseListener != null) {
                    onPlayerReleaseListener.onRelease(KwaiMediaPlayer.this._getResultQos());
                }
                KwaiMediaPlayer.this.release();
            }
        });
    }

    public void reload(String str, boolean z) {
        _reload(str, z);
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer, com.kwai.video.player.IMediaPlayer
    public void reset() {
        stayAwake(false);
        _reset();
        super.reset();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer, com.kwai.video.player.AbstractMediaPlayer
    public void resetListeners() {
        super.resetListeners();
        _setProcessPCMBuffer(null);
        this.mProcessPCMBuffer = null;
        this.mKwaiRepresentationListener = null;
    }

    public void resizeVideo(int i, int i2) {
        SurfaceTextureRenderer surfaceTextureRenderer = this.mSurfaceTextureRender;
        if (surfaceTextureRenderer != null) {
            surfaceTextureRenderer.resizeVideo(i, i2);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native void seekTo(long j);

    public void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setAppQosStatJson(JSONObject jSONObject) {
        _setLiveAppQosInfo(jSONObject.toString());
    }

    public void setAudioChannelMode(int i) {
        this.mAudioChannelMode = i;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setAudioStreamType(int i) {
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setCencKey(String str) {
        setOption(1, "decryption_key", str);
    }

    public void setCodecFlag(@PlayerSettingConstants.UseHardwareDecoderFlag int i) {
        if (i <= 0) {
            String str = TAG;
            Log.w(str, "unsupported codec flag :0,replace the codec flag :0");
            i = 0;
        }
        _setCodecFlag(i);
    }

    public void setConfig(KwaiPlayerConfig kwaiPlayerConfig) {
        if (kwaiPlayerConfig == null) {
            throw new IllegalStateException("method invoking failed pConfig ==null !");
        }
        setOption(4, "first-high-water-mark-ms", kwaiPlayerConfig.getFirstBufferTime());
        setOption(4, "next-high-water-mark-ms", kwaiPlayerConfig.getMinBufferTime());
        setOption(4, "last-high-water-mark-ms", kwaiPlayerConfig.getMaxBufferTime());
        setOption(4, "buffer-strategy", kwaiPlayerConfig.getBufferStrategy().getValue());
        setOption(4, "buffer-increment-step", kwaiPlayerConfig.getBufferIncrementStep());
        setOption(4, "buffer-smooth-time", kwaiPlayerConfig.getBufferSmoothTime());
        setOption(4, "max-buffer-dur-ms", kwaiPlayerConfig.getMaxBufferDuration());
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        setDataSource(context, uri, (Map<String, String>) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
        if (0 == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0082, code lost:
        if (0 == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0084, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
        android.util.Log.d(com.kwai.video.player.kwai_player.KwaiMediaPlayer.TAG, "Couldn't open file on client side, trying server side");
        setDataSource(r9.toString(), r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0095, code lost:
        return;
     */
    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(14)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            setDataSource(uri.getPath());
        } else if ("content".equals(scheme) && "settings".equals(uri.getAuthority()) && (uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri))) == null) {
            throw new FileNotFoundException("Failed to resolve default ringtone");
        } else {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, r.f7699a);
                if (openAssetFileDescriptor == null) {
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                        return;
                    }
                    return;
                }
                if (openAssetFileDescriptor.getDeclaredLength() < 0) {
                    setDataSource(openAssetFileDescriptor.getFileDescriptor());
                } else {
                    setDataSource(openAssetFileDescriptor.getFileDescriptor(), openAssetFileDescriptor.getStartOffset(), openAssetFileDescriptor.getDeclaredLength());
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
            } catch (IOException unused) {
            } catch (SecurityException unused2) {
            } catch (Throwable th) {
                if (0 != 0) {
                    assetFileDescriptor.close();
                }
                throw th;
            }
        }
    }

    @Override // com.kwai.video.player.AbstractMediaPlayer, com.kwai.video.player.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        _setDataSource(iMediaDataSource);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(13)
    public void setDataSource(FileDescriptor fileDescriptor) {
        this.mDataSource = fileDescriptor.toString();
        _setDataSourceFd(getNativeFd(fileDescriptor), 0L, 0L);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(String str) {
        this.mDataSource = str;
        configUserAgent();
        _setDataSource(str, null, null);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setDataSource(String str, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String str2 = map.get("Host");
            if (str2 != null) {
                setOption(4, "host", str2);
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                if (!TextUtils.isEmpty(entry.getValue())) {
                    sb.append(entry.getValue());
                }
                sb.append(Part.CRLF);
            }
            setOption(1, "headers", sb.toString());
        }
        setDataSource(str);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setEnableAudioSpectrum(boolean z) {
        setOption(4, "enable-audio-spectrum", z ? 1L : 0L);
    }

    public void setEnableSegmentCache(boolean z) {
        setOption(4, "enable-segment-cache", z ? 1L : 0L);
    }

    public void setHeadTracker(float f2, float f3, float f4) {
        _setHeadTracker(f2, f3, f4);
    }

    public void setHevcCodecName(String str) {
        _setHevcCodecName(str);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setIndexContent(String str, String str2, String str3, Map<String, String> map) {
        this.mDataSource = str;
        configHeaders(map);
        configUserAgent();
        _setDataSource(str, null, null);
        setOption(4, "input-data-type", 2L);
        setOption(4, "index-content.pre_path", str2);
        setOption(4, "index-content.content", str3);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setInteractiveMode(int i) {
        this.mInteractivemode = i;
        KwaiVR kwaiVR = this.mKwaiVR;
        if (kwaiVR != null) {
            kwaiVR.setInteractiveMode(i);
        }
    }

    public void setIsLive(boolean z) {
        this.mIsLive = z;
    }

    public void setIsVR(boolean z) {
        this.mIsVR = z;
        setVR();
    }

    public void setIsVodAdaptive(boolean z) {
        this.mIsVodAdaptive = z;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setKwaiManifest(String str, String str2, Map<String, String> map) {
        this.mDataSource = str;
        configHeaders(map);
        configUserAgent();
        _setDataSource(str, null, null);
        setOption(4, "input-data-type", 3L);
        setOption(4, "index-content.content", str2);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setKwaiRepresentationListener(IKwaiRepresentationListener iKwaiRepresentationListener) {
        this.mKwaiRepresentationListener = iKwaiRepresentationListener;
        _setRepresentationListener(new WeakReference(this.mKwaiRepresentationListener));
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setLastTryFlag(boolean z) {
        _setLastTryFlag(z ? 1 : 0);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setLiveManifestSwitchMode(@PlayerSettingConstants.KFlvSwitchMode int i) {
        _setLiveManifestSwitchMode(i);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setLiveOnPeriodicalLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        this.mAppQosLiveAdaptiveRealtimeWrapper.setOnPeriodicalLiveAdaptiveQosStatListener(onLiveAdaptiveQosStatListener);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setLiveOnQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener) {
        this.mAppQosLiveRealtimeWrapper.setOnQosStatListener(onQosStatListener);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setLooping(boolean z) {
        int i = !z ? 1 : 0;
        setOption(4, "loop", i);
        _setLoopCount(i);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setOnLiveInterActiveListener(IKwaiMediaPlayer.OnLiveInterActiveListener onLiveInterActiveListener) {
        if (onLiveInterActiveListener != null) {
            _setOnLiveInterActiveListener(new WeakReference(onLiveInterActiveListener));
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setOnLiveVoiceCommentListener(IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener) {
        this.mOnLiveVoiceCommentListener = onLiveVoiceCommentListener;
    }

    public void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    public void setOption(int i, String str, long j) {
        _setOption(i, str, j);
    }

    public void setOption(int i, String str, String str2) {
        _setOption(i, str, str2);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setPlayerMute(boolean z) {
        _setPlayerMute(z ? 1 : 0);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setRepresentation(int i) {
        _setRepresentation(i);
    }

    public boolean setRotateDegree(int i) {
        return _setRotateDegree(i);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setSpeed(float f2) {
        _setSpeed(f2);
    }

    public void setStereoType(int i) {
        this.mStereoType = i;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.mSurfaceHolder = null;
        _setSurfaceTexture(surfaceTexture);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setTag1(int i) {
        setOption(4, "tag1", i);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setTone(int i) {
        _setTone(i);
    }

    public void setVR() {
        if (this.mIsVR) {
            KwaiVR build = KwaiVR.builder().setInteractive(this.mInteractivemode).setPinchEnabled(true).setContext(this.mContext).setStereoType(this.mStereoType).build();
            this.mKwaiVR = build;
            if (!build.isSupport()) {
                String str = TAG;
                Log.e(str, "setVR: not support stereoType" + this.mStereoType);
                return;
            }
            SurfaceTextureRenderer surfaceTextureRenderer = new SurfaceTextureRenderer(this.mContext);
            this.mSurfaceTextureRender = surfaceTextureRenderer;
            if (surfaceTextureRenderer != null) {
                surfaceTextureRenderer.init();
                this.mSurfaceTextureRender.createTexture();
                this.mSurfaceTextureRender.setKwaiVR(this.mKwaiVR);
                if (this.mAudioChannelMode == 2) {
                    this.mSurfaceTextureRender.setHeadTrackerListener(new IHeadTrackerListener() { // from class: com.kwai.video.player.kwai_player.KwaiMediaPlayer.2
                        @Override // com.kwai.video.player.kwai_player.KwaiMediaPlayer.IHeadTrackerListener
                        public void onHeadTracker(float f2, float f3, float f4) {
                            KwaiMediaPlayer.this.setHeadTracker(f2, f3, f4);
                        }
                    });
                }
            }
            setOption(4, "video-stereo-type", this.mStereoType);
            setOption(4, "audio-channel-mode", this.mAudioChannelMode);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setVideoScalingMode(int i) {
        _setVideoScalingMode(i);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native void setVolume(float f2, float f3);

    @Override // com.kwai.video.player.IMediaPlayer
    @SuppressLint({"Wakelock"})
    public void setWakeMode(Context context, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.mWakeLock.release();
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, KwaiMediaPlayer.class.getName());
        this.mWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    public void setupAspectKlv(boolean z) {
        this.mAspectKFlv = new AspectKFlv(this, z);
    }

    public void setupAspectKwaiVodAdaptive(boolean z) {
        this.mVodAdaptive = new AspectKwaiVodAdaptive(this, z);
    }

    public void setupAspectLiveRealTimeReporter(boolean z, KwaiPlayerConfig kwaiPlayerConfig) {
        if (!z) {
            this.mAppQosLiveRealtimeWrapper = new AppQosLiveRealtimeWrapper(this, false);
            this.mAppQosLiveAdaptiveRealtimeWrapper = new AppQosLiveAdaptiveRealtimeWrapper(this, false);
            return;
        }
        AppQosLiveRealtimeWrapper appQosLiveRealtimeWrapper = new AppQosLiveRealtimeWrapper(this, kwaiPlayerConfig.getEnableQos());
        this.mAppQosLiveRealtimeWrapper = appQosLiveRealtimeWrapper;
        appQosLiveRealtimeWrapper.setTickDurationMs(kwaiPlayerConfig.getQosDuration());
        AppQosLiveAdaptiveRealtimeWrapper appQosLiveAdaptiveRealtimeWrapper = new AppQosLiveAdaptiveRealtimeWrapper(this, kwaiPlayerConfig.getEnableLiveAdaptiveQos());
        this.mAppQosLiveAdaptiveRealtimeWrapper = appQosLiveAdaptiveRealtimeWrapper;
        appQosLiveAdaptiveRealtimeWrapper.setEnableLiveAdaptiveAdditionalQosStat(kwaiPlayerConfig.getEnableLiveAdaptiveAdditionalQos());
        this.mAppQosLiveAdaptiveRealtimeWrapper.setTickDurationMs(kwaiPlayerConfig.getLiveAdaptiveQosDuration());
    }

    public void setupAspectNativeCache(boolean z) {
        this.mAspectAwesomeCache = new AspectAwesomeCache(this, z);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void shutdownWaitStop() {
        stopLiveStatTimerImmediately();
        stayAwake(false);
        stopDrawLoopTimer();
        _shutdownWaitStop();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void start() {
        stayAwake(true);
        _start();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void stepFrame() {
        stayAwake(false);
        _step_frame();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void stop() {
        stopLiveStatTimerImmediately();
        stayAwake(false);
        stopDrawLoopTimer();
        _stop();
    }

    public void stopDrawLoopTimer() {
        SurfaceTextureRenderer surfaceTextureRenderer = this.mSurfaceTextureRender;
        if (surfaceTextureRenderer != null) {
            surfaceTextureRenderer.stopDrawFrameLoop();
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void stopLiveStatTimerImmediately() {
        this.mAppQosLiveRealtimeWrapper.stop();
        this.mAppQosLiveAdaptiveRealtimeWrapper.stop();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void unRegisterSensorEvent() {
        KwaiVR kwaiVR = this.mKwaiVR;
        if (kwaiVR != null) {
            kwaiVR.unRegisterSensorEvent();
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    @RuntimePlayerConfig
    public void updateCurrentMaxWallClockOffset(long j) {
        _updateCurrentMaxWallClockOffset(j);
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    @RuntimePlayerConfig
    public void updateCurrentWallClock(long j) {
        _updateCurrentWallClock(j);
    }
}
