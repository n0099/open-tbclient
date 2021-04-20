package com.kwai.video.player;

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
import android.view.Surface;
import android.view.SurfaceHolder;
import com.android.internal.http.multipart.Part;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.kwai.player.KwaiPlayerConfig;
import com.kwai.player.debuginfo.KwaiPlayerDebugInfoProvider;
import com.kwai.player.debuginfo.model.AppLiveQosDebugInfo;
import com.kwai.player.debuginfo.model.AppLiveQosDebugInfoNew;
import com.kwai.player.debuginfo.model.AppVodQosDebugInfoNew;
import com.kwai.player.debuginfo.model.KwaiPlayerDebugInfo;
import com.kwai.player.debuginfo.model.PlayerConfigDebugInfo;
import com.kwai.player.qos.AppLiveAdaptiveRealtimeInfo;
import com.kwai.player.qos.AppLiveReatimeInfoProvider;
import com.kwai.player.qos.AppQosLiveAdaptiveRealtime;
import com.kwai.player.qos.AppQosLiveRealtime;
import com.kwai.player.qos.KwaiQosInfo;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.cache.CacheSessionListener;
import com.kwai.video.cache.PlayerPreferrenceUtil;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.KlogObserver;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.PlayerSettingConstants;
import com.kwai.video.player.annotations.CalledByNative;
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
/* loaded from: classes6.dex */
public final class KsMediaPlayer extends AbstractNativeMediaPlayer implements KwaiPlayerDebugInfoProvider, AppLiveReatimeInfoProvider {
    public static final int DEFAULT_LIVE_ADAPTIVE_QOS_TICK_DURATION = 2000;
    public static final int DEFAULT_MONITOR_INTERVAL = 1000;
    public static final int DEFAULT_QOS_TICK_DURATION = 10000;
    public static final int DEVICE_OUT_SPEAKER = 1;
    public static final int DEVICE_OUT_UNKNOWN = 0;
    public static final int MEDIA_BUFFERSIZE_DEFAULT = 20;
    public static final int MEDIA_TIME_OUT_DEFAULT = 30;
    public static final String TAG = "com.kwai.video.player.KsMediaPlayer";
    public static final boolean VERBOSE = false;
    public AppQosLiveAdaptiveRealtime mAppQosLiveAdaptiveRealtime;
    public AppQosLiveRealtime mAppQosLiveRealtime;
    public AwesomeCacheCallback mAwesomeCacheCallback;
    public int mBufferingCount;
    public CacheSessionListener mCacheSessionListener;
    public CacheSessionListener mCacheSessionListenerInnerBridge;
    public Context mContext;
    public String mDataSource;
    public boolean mEnableLiveAdaptiveAdditionalQosStat;
    public boolean mEnableLiveAdaptiveQosStat;
    public boolean mEnableQosStat;
    public boolean mEnableStatModule;
    public int mErrorCode;
    public String mHost;
    public boolean mIsLive;
    public volatile boolean mIsLiveAdaptiveQosTimerStarted;
    public volatile boolean mIsQosTimerStarted;
    public boolean mIsVodAdaptive;
    public KwaiPlayerDebugInfo mKwaiPlayerDebugInfo;
    public Object mLiveAdaptiveQosObject;
    public long mLiveAdaptiveQosTickDuration;
    public OnControlMessageListener mOnControlMessageListener;
    public IMediaPlayer.OnLiveAdaptiveQosStatListener mOnLiveAdaptiveQosStatListener;
    public IMediaPlayer.OnLiveVoiceCommentListener mOnLiveVoiceCommentListener;
    public OnNativeInvokeListener mOnNativeInvokeListener;
    public IMediaPlayer.OnQosStatListener mOnQosStatListener;
    public OnVideoTextureListener mOnVideoTextureListener;
    public long mPlayStartTime;
    public PlayerState mPlayerState;
    public ByteBuffer mProcessPCMBuffer;
    public Object mQosObject;
    public long mQosTickDuration;
    public boolean mScreenOnWhilePlaying;
    public long mStartBufferingTime;
    public boolean mStayAwake;
    public SurfaceHolder mSurfaceHolder;
    public int mTotalBufferingTime;
    public int mVideoHeight;
    public int mVideoSarDen;
    public int mVideoSarNum;
    public int mVideoWidth;
    public PowerManager.WakeLock mWakeLock;

    /* loaded from: classes6.dex */
    public static class Builder {
        public AwesomeCacheCallback awesomeCacheCallback;
        public CacheSessionListener cacheSessionListener;
        public Context mContext;
        public String appId = null;
        public String accessKey = null;
        public String secretKeySign = null;
        public String timeSec = null;
        public boolean enableStatModule = true;
        public boolean enablePlayerCache = false;
        public int preLoadVer = 1;
        public long preLoadDurationMs = 0;
        public long abLoopStartMs = 0;
        public long abLoopEndMs = 0;
        public long seekAtStart = 0;
        public int fadeinEndTimeMs = 0;
        public boolean vodManifestEnable = false;
        public long vodManifestWidth = 0;
        public long vodManifestHeight = 0;
        public int vodManifestNetType = 0;
        public String vodManifestRateConfig = "";
        public int vodManifestLowDevice = 0;
        public int vodManifestSignalStrength = 0;
        public int vodManifestSwitchCode = 0;
        public int mVodManifestMaxResolution = 0;
        public int mManifestType = 0;

        public Builder(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public KsMediaPlayer build() {
            return new KsMediaPlayer(this);
        }

        public Builder enableCache(boolean z) {
            this.enablePlayerCache = z;
            return this;
        }

        public Builder enableKSYStatModule(boolean z) {
            this.enableStatModule = z;
            return this;
        }

        public Builder seekAtStart(long j) {
            this.seekAtStart = j;
            return this;
        }

        public Builder setAbLoop(long j, long j2) {
            this.abLoopStartMs = j;
            this.abLoopEndMs = j2;
            return this;
        }

        public Builder setAccessKey(String str) {
            this.accessKey = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback) {
            this.awesomeCacheCallback = awesomeCacheCallback;
            return this;
        }

        public Builder setCacheSessionListener(CacheSessionListener cacheSessionListener) {
            this.cacheSessionListener = cacheSessionListener;
            return this;
        }

        public Builder setFadeinEndTimeMs(int i) {
            return this;
        }

        public Builder setManifestType(int i) {
            this.mManifestType = i;
            return this;
        }

        public Builder setPreLoadDurationMs(int i, long j) {
            this.preLoadVer = i;
            this.preLoadDurationMs = j;
            return this;
        }

        public Builder setSecretKeySign(String str) {
            this.secretKeySign = str;
            return this;
        }

        public Builder setTimeSec(String str) {
            this.timeSec = str;
            return this;
        }

        public Builder setVodManifest(int i, long j, long j2, String str, int i2, int i3) {
            this.vodManifestEnable = true;
            this.vodManifestHeight = j2;
            this.vodManifestWidth = j;
            this.vodManifestNetType = i;
            this.vodManifestRateConfig = str;
            this.vodManifestLowDevice = i2;
            this.vodManifestSignalStrength = i3;
            return this;
        }

        public Builder setVodManifestMaxResolution(int i) {
            this.mVodManifestMaxResolution = i;
            return this;
        }

        public Builder setVodManifestSwitchCode(int i) {
            this.vodManifestSwitchCode = i;
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public interface OnAudioProcessPCMListener {
        void onAudioProcessPCMAvailable(IMediaPlayer iMediaPlayer, ByteBuffer byteBuffer, long j, int i, int i2, int i3);
    }

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

    /* loaded from: classes6.dex */
    public interface OnVideoTextureListener {
        void onVideoTextureAvailable(IMediaPlayer iMediaPlayer, SurfaceTexture surfaceTexture, int i);
    }

    /* loaded from: classes6.dex */
    public enum PlayerState {
        STATE_IDLE,
        STATE_INITIALIZED,
        STATE_PREPARING,
        STATE_PREPARED,
        STATE_PLAYING,
        STATE_PAUSED,
        STATE_STOPPED,
        STATE_COMPLETED,
        STATE_ERROR,
        STATE_END
    }

    public KsMediaPlayer(Builder builder) {
        this.mIsVodAdaptive = false;
        this.mWakeLock = null;
        this.mQosTickDuration = 10000L;
        this.mLiveAdaptiveQosTickDuration = 2000L;
        this.mEnableQosStat = false;
        this.mEnableLiveAdaptiveQosStat = false;
        this.mEnableLiveAdaptiveAdditionalQosStat = false;
        this.mQosObject = new Object();
        this.mLiveAdaptiveQosObject = new Object();
        this.mPlayStartTime = 0L;
        this.mCacheSessionListenerInnerBridge = new CacheSessionListener() { // from class: com.kwai.video.player.KsMediaPlayer.1
            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadPaused() {
                CacheSessionListener cacheSessionListener = KsMediaPlayer.this.mCacheSessionListener;
                if (cacheSessionListener != null) {
                    cacheSessionListener.onDownloadPaused();
                }
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadProgress(long j, long j2) {
                CacheSessionListener cacheSessionListener = KsMediaPlayer.this.mCacheSessionListener;
                if (cacheSessionListener != null) {
                    cacheSessionListener.onDownloadProgress(j, j2);
                }
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadResumed() {
                CacheSessionListener cacheSessionListener = KsMediaPlayer.this.mCacheSessionListener;
                if (cacheSessionListener != null) {
                    cacheSessionListener.onDownloadResumed();
                }
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadStarted(long j, String str, String str2, String str3, int i, long j2) {
                CacheSessionListener cacheSessionListener = KsMediaPlayer.this.mCacheSessionListener;
                if (cacheSessionListener != null) {
                    cacheSessionListener.onDownloadStarted(j, str, str2, str3, i, j2);
                }
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadStopped(int i, long j, long j2, String str, int i2, String str2, String str3, String str4, String str5) {
                if (KsMediaPlayer.this.mCacheSessionListener != null) {
                    KsMediaPlayer.this.mCacheSessionListener.onDownloadStopped(i, j, j2, str, i2, str2, str3, str4, str5);
                }
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onSessionClosed(int i, long j, long j2, long j3, String str, boolean z) {
                CacheSessionListener cacheSessionListener = KsMediaPlayer.this.mCacheSessionListener;
                if (cacheSessionListener != null) {
                    cacheSessionListener.onSessionClosed(i, j, j2, j3, str, z);
                }
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onSessionStart(String str, long j, long j2, long j3) {
                CacheSessionListener cacheSessionListener = KsMediaPlayer.this.mCacheSessionListener;
                if (cacheSessionListener != null) {
                    cacheSessionListener.onSessionStart(str, j, j2, j3);
                }
            }
        };
        this.mIsLive = false;
        this.mKwaiPlayerDebugInfo = new KwaiPlayerDebugInfo();
        this.mOnVideoTextureListener = null;
        this.mProcessPCMBuffer = null;
        this.mContext = builder.mContext;
        this.mBufferingCount = 0;
        this.mTotalBufferingTime = 0;
        this.mStartBufferingTime = 0L;
        this.mIsQosTimerStarted = false;
        this.mIsLiveAdaptiveQosTimerStarted = false;
        this.mPlayerState = PlayerState.STATE_IDLE;
        this.mEnableStatModule = builder.enableStatModule;
        initPlayer();
        setOption(4, "cache-enabled", builder.enablePlayerCache ? 1L : 0L);
        if (builder.awesomeCacheCallback != null) {
            AwesomeCacheCallback awesomeCacheCallback = builder.awesomeCacheCallback;
            this.mAwesomeCacheCallback = awesomeCacheCallback;
            _setAwesomeCacheCallback(awesomeCacheCallback);
        }
        this.mCacheSessionListener = builder.cacheSessionListener;
        if (builder.preLoadDurationMs > 0) {
            _enablePreDemux(builder.preLoadVer, builder.preLoadDurationMs);
        }
        if (builder.abLoopEndMs > 0) {
            _enableAbLoop(builder.abLoopStartMs, builder.abLoopEndMs);
        }
        if (builder.seekAtStart > 0) {
            setOption(4, "seek-at-start", builder.seekAtStart);
        }
        if (builder.fadeinEndTimeMs > 0) {
            setOption(4, "fade-in-end-time-ms", builder.fadeinEndTimeMs);
        }
        if (builder.vodManifestEnable) {
            setOption(4, "enable-vod-manifest", 1L);
            setOption(1, "device-resolution-width", builder.vodManifestWidth);
            setOption(1, "device-resolution-height", builder.vodManifestHeight);
            setOption(1, "device-network-type", builder.vodManifestNetType);
            setOption(1, "abr-config-string", builder.vodManifestRateConfig);
            setOption(1, "low-device", builder.vodManifestLowDevice);
            setOption(1, "signal-strength", builder.vodManifestSignalStrength);
            setOption(1, "switch-code", builder.vodManifestSwitchCode);
            setOption(1, "adaptive-max-resolution", builder.mVodManifestMaxResolution);
            setOption(1, "manifest_type", builder.mManifestType);
            this.mIsVodAdaptive = builder.vodManifestEnable;
        }
    }

    private native void _abortNativeCacheIO();

    private native void _addVideoRawBuffer(byte[] bArr);

    private native void _audioOnly(boolean z);

    private native void _disableSoftVideoDecode(boolean z);

    private native void _enableAbLoop(long j, long j2);

    private native void _enablePreDemux(int i, long j);

    private native void _enableVideoRawDataCallback(boolean z);

    private native Bundle _getAppLiveAdaptiveRealtimeInfo();

    private native Bundle _getAppLiveQosDebugInfo();

    private native void _getAppLiveQosDebugInfoNew(AppLiveQosDebugInfoNew appLiveQosDebugInfoNew);

    private native void _getAppVodQosDebugInfoNew(AppVodQosDebugInfoNew appVodQosDebugInfoNew);

    private native String _getAudioCodecInfo();

    public static native String _getColorFormatName(int i);

    private native String _getKwaiLiveVoiceComment(long j);

    private native String _getKwaiSign();

    private native String _getLiveRealTimeQosJson(int i, int i2, long j, long j2, long j3);

    private native String _getLiveStatJson();

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native void _getPlayerConfigDebugInfo(PlayerConfigDebugInfo playerConfigDebugInfo);

    private native float _getPropertyFloat(int i, float f2);

    private native long _getPropertyLong(int i, long j);

    private native String _getPropertyString(int i);

    private native Bundle _getQosInfo();

    private native void _getScreenShot(Bitmap bitmap);

    private native String _getVideoCodecInfo();

    private native String _getVideoStatJson();

    private native String _getVodAdaptiveCacheKey();

    private native String _getVodAdaptiveHostName();

    private native String _getVodAdaptiveUrl();

    private native String _getXksCache();

    private native boolean _isCacheEnabled();

    private native boolean _isLiveManifest();

    private native boolean _isMediaPlayerValid();

    private native void _pause();

    private native void _release();

    private native void _reload(String str, boolean z);

    private native void _reset();

    private native void _setAwesomeCacheCallback(Object obj);

    private native void _setBufferSize(int i);

    private native void _setCodecFlag(int i);

    private native void _setConfigJson(String str);

    private native void _setConnectionTimeout(int i);

    private native void _setDataSource(IMediaDataSource iMediaDataSource);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void _setDataSourceFd(int i, long j, long j2);

    private native void _setHevcCodecName(String str);

    public static native void _setKlogParam(Object obj);

    private native void _setLiveManifestSwitchMode(int i);

    private native void _setLoopCount(int i);

    private native void _setOption(int i, String str, long j);

    private native void _setOption(int i, String str, String str2);

    private native void _setPlayerMute(int i);

    private native void _setProcessPCMBuffer(ByteBuffer byteBuffer);

    private native void _setPropertyFloat(int i, float f2);

    private native void _setPropertyLong(int i, long j);

    private native boolean _setRotateDegree(int i);

    private native void _setSpeed(float f2);

    private native void _setStartPlayBlockBufferMs(int i, int i2);

    private native void _setStreamSelected(int i, boolean z);

    private native void _setSurfaceTexture(SurfaceTexture surfaceTexture);

    private native void _setTimeout(int i);

    private native void _setTone(int i);

    private native void _setVideoScalingMode(int i);

    private native void _setVideoSurface(Surface surface);

    private native void _setupCacheSessionListener(Object obj);

    private native void _shutdownWaitStop();

    private native void _start();

    private native void _step_frame();

    private native void _stop();

    private native void _updateCurrentMaxWallClockOffset(long j);

    private native void _updateCurrentWallClock(long j);

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

    public static native void native_setKwaiLogLevel(int i);

    public static native void native_setLogLevel(int i);

    private native void native_set_context(Object obj);

    private native void native_setup(Object obj);

    @CalledByNative
    public static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        OnControlMessageListener onControlMessageListener;
        DebugLog.ifmt(TAG, "onNativeInvoke %d", Integer.valueOf(i));
        if (obj == null || !(obj instanceof WeakReference)) {
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        KsMediaPlayer ksMediaPlayer = (KsMediaPlayer) ((WeakReference) obj).get();
        if (ksMediaPlayer != null) {
            OnNativeInvokeListener onNativeInvokeListener = ksMediaPlayer.mOnNativeInvokeListener;
            if (onNativeInvokeListener == null || !onNativeInvokeListener.onNativeInvoke(i, bundle)) {
                if (i == 65536 && (onControlMessageListener = ksMediaPlayer.mOnControlMessageListener) != null) {
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

    private void setDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        this.mDataSource = fileDescriptor.toString();
        _setDataSourceFd(getNativeFd(fileDescriptor), j, j2);
        this.mPlayerState = PlayerState.STATE_INITIALIZED;
    }

    public static void setKlogParam(KlogObserver.KlogParam klogParam) {
        _setKlogParam(klogParam);
    }

    private void startLiveAdaptiveQosStatTimer() {
        synchronized (this.mLiveAdaptiveQosObject) {
            if (this.mIsLiveAdaptiveQosTimerStarted) {
                return;
            }
            this.mIsLiveAdaptiveQosTimerStarted = true;
            if (this.mAppQosLiveAdaptiveRealtime == null) {
                AppQosLiveAdaptiveRealtime appQosLiveAdaptiveRealtime = new AppQosLiveAdaptiveRealtime(1000L, this.mLiveAdaptiveQosTickDuration, this, this.mLiveAdaptiveQosObject);
                this.mAppQosLiveAdaptiveRealtime = appQosLiveAdaptiveRealtime;
                appQosLiveAdaptiveRealtime.setPlayStartTime(this.mPlayStartTime);
                this.mAppQosLiveAdaptiveRealtime.setEnableLiveAdaptiveAdditionalQosStat(this.mEnableLiveAdaptiveAdditionalQosStat);
            }
            this.mAppQosLiveAdaptiveRealtime.startReport(this.mOnLiveAdaptiveQosStatListener);
        }
    }

    private void startQosStatTimer() {
        synchronized (this.mQosObject) {
            if (this.mIsQosTimerStarted) {
                return;
            }
            this.mIsQosTimerStarted = true;
            if (this.mAppQosLiveRealtime == null) {
                this.mAppQosLiveRealtime = new AppQosLiveRealtime(1000L, this.mQosTickDuration, this, this.mQosObject);
            }
            this.mAppQosLiveRealtime.startReport(this.mOnQosStatListener);
        }
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

    private void stopLiveAdaptiveQosStatTimer() {
        synchronized (this.mLiveAdaptiveQosObject) {
            if (this.mIsLiveAdaptiveQosTimerStarted) {
                this.mIsLiveAdaptiveQosTimerStarted = false;
                if (this.mAppQosLiveAdaptiveRealtime != null) {
                    this.mAppQosLiveAdaptiveRealtime.stopReport();
                    this.mAppQosLiveAdaptiveRealtime = null;
                }
            }
        }
    }

    private void stopQosStatTimer() {
        synchronized (this.mQosObject) {
            if (this.mIsQosTimerStarted) {
                if (this.mAppQosLiveRealtime != null) {
                    this.mAppQosLiveRealtime.stopReport();
                    this.mAppQosLiveRealtime = null;
                }
                this.mIsQosTimerStarted = false;
            }
        }
    }

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    public native void _prepareAsync();

    public void abortNativeCacheIO() {
        _abortNativeCacheIO();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void addVideoRawBuffer(byte[] bArr) {
        _addVideoRawBuffer(bArr);
    }

    public void audioOnly(boolean z) {
        _audioOnly(z);
    }

    public int bufferEmptyCount() {
        return (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_BLOCKCNT, 0L);
    }

    public int bufferEmptyCountOld() {
        return this.mBufferingCount;
    }

    public long bufferEmptyDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_BUFFERTIME, 0L);
    }

    public long bufferEmptyDurationOld() {
        return this.mTotalBufferingTime;
    }

    public void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    public void disableSoftVideoDecode(boolean z) {
        _disableSoftVideoDecode(z);
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public void enableVideoRawDataCallback(boolean z) {
        _enableVideoRawDataCallback(z);
    }

    public boolean getAdaptiveQosTimerStarted() {
        return this.mIsLiveAdaptiveQosTimerStarted;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public AppLiveAdaptiveRealtimeInfo getAppLiveAdaptiveRealtimeInfo() {
        return AppLiveAdaptiveRealtimeInfo.from(_getAppLiveAdaptiveRealtimeInfo());
    }

    public AppLiveQosDebugInfo getAppLiveQosDebugInfo() {
        return AppLiveQosDebugInfo.from(_getAppLiveQosDebugInfo());
    }

    public long getAudioCachedBytes() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_BYTES, 0L);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public long getAudioCachedDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_DURATION, 0L);
    }

    public long getAudioCachedPackets() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_PACKETS, 0L);
    }

    public float getAudioRawLatencySeconds() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_AUDIO_RAW_LATENCY_SECONDS, 0.0f);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native int getAudioSessionId();

    public float getAverageDisplayFps() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_AVERAGE_DISPLAYED_FPS, 0.0f);
    }

    public long getBitrate() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_BIT_RATE, 0L);
    }

    public float getBufferTimeMax() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_BUFFERSIZE_MAX, 0.0f);
    }

    public Context getContext() {
        return this.mContext;
    }

    public long getCpuUsage() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_CPU, 0L);
    }

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

    public long getDecodeVideoFrameCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DECODED_VIDEO_FRAME_COUNT, 0L);
    }

    public long getDecodedDataSize() {
        return _getPropertyLong(PlayerProps.PROP_LONG_DECODED_SIZE, 0L);
    }

    public long getDecodedVideoHeight() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_HEIGHT, 0L);
    }

    public long getDecodedVideoWidth() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_WIDTH, 0L);
    }

    public long getDisplayFrameCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DISPLAYED_FRAME_COUNT, 0L);
    }

    public long getDownloadDataSize() {
        return _getPropertyLong(PlayerProps.PROP_LONG_DOWNLOAD_SIZE, 0L);
    }

    public long getDroppedDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DROPPED_DURATION, 0L);
    }

    public long getDtsDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_DTS_DURATION, 0L);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native long getDuration();

    public boolean getEnableLiveAdaptiveQos() {
        return this.mEnableLiveAdaptiveQosStat;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    @Deprecated
    public String getKflvVideoPlayingUrl() {
        return getCurPlayingUrl();
    }

    public String getKwaiLiveVoiceComment(long j) {
        return _getKwaiLiveVoiceComment(j);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getKwaiSign() {
        return _getKwaiSign();
    }

    public long getLiveAdaptiveTickDuration() {
        return this.mLiveAdaptiveQosTickDuration;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getLiveRealTimeQosJson(int i, int i2, long j, long j2, long j3) {
        return _getLiveRealTimeQosJson(i, i2, j, j2, j3);
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

    public Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    public long getMemorySize() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_MEMORY, 0L);
    }

    public IMediaPlayer.OnLiveVoiceCommentListener getOnLiveVoiceCommentListener() {
        return this.mOnLiveVoiceCommentListener;
    }

    public native float getProbeFps();

    public boolean getQosTimerStarted() {
        return this.mIsQosTimerStarted;
    }

    public long getReadVideoFrameCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_READ_VIDEO_FRAME_COUNT, 0L);
    }

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

    public long getSourceDeviceType() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_SOURCE_DEVICE_TYPE, 0L);
    }

    public float getSpeed(float f2) {
        return _getPropertyFloat(10003, 0.0f);
    }

    @Deprecated
    public String getStatJson() {
        return _getLiveStatJson();
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getStreamId() {
        return _getPropertyString(PlayerProps.FFP_PROP_STRING_STREAM_ID);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public KwaiQosInfo getStreamQosInfo() {
        return KwaiQosInfo.fromBundle(_getQosInfo());
    }

    public long getTickDuration() {
        return this.mQosTickDuration;
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

    public float getVideoAvgFps() {
        return _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_VIDEO_AVG_FPS, 0.0f);
    }

    public long getVideoCachedBytes() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_BYTES, 0L);
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public long getVideoCachedDuration() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_DURATION, 0L);
    }

    public long getVideoCachedPackets() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_PACKETS, 0L);
    }

    public long getVideoDecErrorCount() {
        return _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_DEC_ERROR_COUNT, 0L);
    }

    public float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    public int getVideoDecoder() {
        return (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_DECODER, 0L);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

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

    public String getVideoStatJson() {
        return _getVideoStatJson();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public String getVodAdaptiveCacheKey() {
        return _getVodAdaptiveCacheKey();
    }

    public String getVodAdaptiveHostName() {
        return _getVodAdaptiveHostName();
    }

    public int getVodAdaptiveRepID() {
        return (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_VOD_ADAPTIVE_REP_ID, 0L);
    }

    public String getVodAdaptiveUrl() {
        return _getVodAdaptiveUrl();
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getXksCache() {
        return _getXksCache();
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public final void initPlayer() {
        super.initPlayer();
        native_set_context(this.mContext);
        native_setup(new WeakReference(this));
        _setupCacheSessionListener(new WeakReference(this.mCacheSessionListenerInnerBridge));
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public void initProcessPCMBuffer() {
        if (this.mProcessPCMBuffer == null) {
            int _getPropertyLong = (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_BUF_SIZE, 0L);
            this.mProcessPCMBuffer = _getPropertyLong <= 0 ? ByteBuffer.allocate(176000) : ByteBuffer.allocate(_getPropertyLong * 2);
        }
        _setProcessPCMBuffer(this.mProcessPCMBuffer);
    }

    public boolean isCacheEnabled() {
        return _isCacheEnabled();
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public boolean isLiveManifest() {
        return _isLiveManifest();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isLooping() {
        return _getLoopCount() != 1;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
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
                this.mPlayerState = PlayerState.STATE_PREPARED;
                notifyOnPrepared();
            } else if (i == 2) {
                this.mPlayerState = PlayerState.STATE_COMPLETED;
                notifyOnCompletion();
                stayAwake(false);
            } else if (i == 3) {
                notifyOnBufferingUpdate(message.arg1);
            } else if (i == 4) {
                notifyOnSeekComplete();
            } else if (i == 5) {
                int i2 = message.arg1;
                this.mVideoWidth = i2;
                int i3 = message.arg2;
                this.mVideoHeight = i3;
                notifyOnVideoSizeChanged(i2, i3, this.mVideoSarNum, this.mVideoSarDen);
            } else if (i != 99) {
                if (i == 100) {
                    Timber.e("MEDIA_ERROR, msg.arg1:%d, msg.arg2:%d", Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
                    if (!notifyOnError(message.arg1, message.arg2)) {
                        notifyOnCompletion();
                    }
                    this.mErrorCode = message.arg1;
                    stayAwake(false);
                } else if (i == 200) {
                    int i4 = message.arg1;
                    if (i4 == 701) {
                        this.mBufferingCount++;
                        this.mStartBufferingTime = System.currentTimeMillis();
                    } else if (i4 == 702) {
                        this.mTotalBufferingTime += (int) (System.currentTimeMillis() - this.mStartBufferingTime);
                    } else if (i4 == 10100) {
                        notifyOnSeekComplete();
                        return;
                    }
                    notifyOnInfo(message.arg1, message.arg2);
                } else if (i == 300) {
                    long j = (message.arg1 << 32) | message.arg2;
                    String kwaiLiveVoiceComment = getKwaiLiveVoiceComment(j);
                    Timber.i("MEDIA_LIVE_VC_TIME, vc_time:%d, voice_comment:%s", Long.valueOf(j), kwaiLiveVoiceComment);
                    IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener = getOnLiveVoiceCommentListener();
                    if (onLiveVoiceCommentListener != null) {
                        onLiveVoiceCommentListener.onLiveVoiceCommentChange(this, kwaiLiveVoiceComment);
                    }
                } else if (i != 10001) {
                    DebugLog.e(TAG, "Unknown message type " + message.what);
                } else {
                    int i5 = message.arg1;
                    this.mVideoSarNum = i5;
                    int i6 = message.arg2;
                    this.mVideoSarDen = i6;
                    notifyOnVideoSizeChanged(this.mVideoWidth, this.mVideoHeight, i5, i6);
                }
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void pause() {
        stayAwake(false);
        _pause();
        Timber.d("KSYMeidaPlayer getAverageDisplayFps:%f", Float.valueOf(getAverageDisplayFps()));
        this.mPlayerState = PlayerState.STATE_PAUSED;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void prepareAsync() {
        this.mPlayStartTime = System.currentTimeMillis();
        if (this.mEnableQosStat) {
            startQosStatTimer();
        }
        if (this.mEnableLiveAdaptiveQosStat) {
            startLiveAdaptiveQosStatTimer();
        }
        _prepareAsync();
        this.mPlayerState = PlayerState.STATE_PREPARING;
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
        this.mPlayerState = PlayerState.STATE_END;
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
        this.mAwesomeCacheCallback = null;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native void seekTo(long j);

    public void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    public void setAegonMTRequestDelayTime(int i) {
        setOption(1, "mt_request_delay_ms", i < 0 ? -1L : i);
    }

    public void setAsyncCacheByteRangeSize(int i) {
        setOption(1, "byte-range-size", i);
    }

    public void setAsyncCacheEnableReuseManager(boolean z) {
        setOption(1, "async-enable-reuse-manager", z ? 1L : 0L);
    }

    public void setAsyncCacheFirstByteRangeSize(int i) {
        setOption(1, "first-byte-range-size", i);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setAudioStreamType(int i) {
    }

    public void setBufferSize(int i) {
        if (i <= 0) {
            String str = TAG;
            Log.w(str, "unsupported buffer size :20,replace the default size :20");
            i = 20;
        }
        _setBufferSize(i);
    }

    public void setBufferTimeMax(float f2) {
        _setPropertyFloat(PlayerProps.FFP_PROP_FLOAT_BUFFERSIZE_MAX, f2);
    }

    public void setBufferedDataSourceSizeKB(int i) {
        setOption(1, "buffered-datasource-size-kb", i);
    }

    @Deprecated
    public void setBufferedDataSourceType(int i) {
        setOption(1, "buffered-datasource-type", i);
    }

    public void setCacheDownloadConnectTimeoutMs(int i) {
        setOption(1, "cache-connect-timeout-ms", i);
    }

    public void setCacheDownloadReadTimeoutMs(int i) {
        setOption(1, "cache-read-timeout-ms", i);
    }

    public void setCacheHttpConnectRetryCount(int i) {
        setOption(1, "cache-http-connect-retry-cnt", i);
    }

    public void setCacheKey(String str) {
        setOption(4, "cache-key", str);
    }

    public void setCacheProgressCallbackIntervalMs(int i) {
        setOption(1, "progress_cb_interval_ms", i);
    }

    public void setCacheSocketBufferSizeKb(int i) {
        setOption(1, "cache-socket-buf-size-kb", i);
    }

    public void setCodecFlag(int i) {
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
        this.mEnableQosStat = kwaiPlayerConfig.getEnableQos();
        this.mQosTickDuration = kwaiPlayerConfig.getQosDuration();
        this.mEnableLiveAdaptiveQosStat = kwaiPlayerConfig.getEnableLiveAdaptiveQos();
        this.mEnableLiveAdaptiveAdditionalQosStat = kwaiPlayerConfig.getEnableLiveAdaptiveAdditionalQos();
        this.mLiveAdaptiveQosTickDuration = kwaiPlayerConfig.getLiveAdaptiveQosDuration();
        setOption(4, "first-high-water-mark-ms", kwaiPlayerConfig.getFirstBufferTime());
        setOption(4, "next-high-water-mark-ms", kwaiPlayerConfig.getMinBufferTime());
        setOption(4, "last-high-water-mark-ms", kwaiPlayerConfig.getMaxBufferTime());
        setOption(4, "buffer-strategy", kwaiPlayerConfig.getBufferStrategy().getValue());
        setOption(4, "buffer-increment-step", kwaiPlayerConfig.getBufferIncrementStep());
        setOption(4, "buffer-smooth-time", kwaiPlayerConfig.getBufferSmoothTime());
        setOption(4, "max-buffer-dur-ms", kwaiPlayerConfig.getMaxBufferDuration());
    }

    public void setConfigJson(String str) {
        _setConfigJson(str);
    }

    public void setCurlBufferSizeKb(int i) {
        setOption(1, "curl-buffer-size-kb", i);
    }

    public void setDataReadTimeout(int i) {
        if (i <= 0) {
            String str = TAG;
            Log.w(str, "unsupported time out  :" + i + ",replace the default time out :30");
            i = 30;
        }
        _setTimeout(i);
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
        android.util.Log.d(com.kwai.video.player.KsMediaPlayer.TAG, "Couldn't open file on client side, trying server side");
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
        this.mPlayerState = PlayerState.STATE_INITIALIZED;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(String str) {
        this.mDataSource = str;
        String format = String.format("a/%s/%s/%s", KsMediaPlayerInitConfig.packageName, KsMediaPlayerInitConfig.packageVersion, getVersion());
        setOption(1, "user-agent", format);
        Timber.d("user-agent:%s", format);
        _setDataSource(str, null, null);
        this.mPlayerState = PlayerState.STATE_INITIALIZED;
    }

    public void setDataSource(String str, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String str2 = map.get("Host");
            this.mHost = str2;
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

    public void setDataSourceSeekReopenThresholdKB(int i) {
        setOption(1, "datasource-seek-reopen-threshold-kb", i);
    }

    public void setDataSourceType(@AwesomeCache.DataSourceType int i) {
        setOption(1, "data-source-type", i);
    }

    public void setDccAlgMBTh_10(int i) {
        setOption(4, "dcc-alg.config_mark_bitrate_th_10", i);
    }

    public void setDccAlgPreReadMs(int i) {
        setOption(4, "dcc-alg.config_dcc_pre_read_ms", i);
    }

    public void setDccAlgorithm(boolean z) {
        setOption(4, "dcc-alg.config_enabled", z ? 1L : 0L);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    public void setEnableAudioSpectrum(boolean z) {
        setOption(4, "enable-audio-spectrum", z ? 1L : 0L);
    }

    public void setEnableHttpdns(boolean z) {
        setOption(1, "enable_httpdns_in_hodor", z ? 1L : 0L);
    }

    public void setEnablePlayAudioGain(boolean z, String str) {
        setOption(4, "audio-gain.enable", z ? 1L : 0L);
        if (z) {
            setOption(4, "audio-gain.audio_str", str);
        }
    }

    public void setEnableQosStat(boolean z) {
        this.mEnableQosStat = z;
    }

    public void setHevcCodecName(String str) {
        _setHevcCodecName(str);
    }

    public void setIsLive(boolean z) {
        this.mIsLive = z;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    public void setLiveManifestSwitchMode(@PlayerSettingConstants.KFlvSwitchMode int i) {
        _setLiveManifestSwitchMode(i);
    }

    public void setLiveP2spSwitchCooldownMs(int i) {
        setOption(1, "live-p2sp-switch-cooldown-ms", i);
    }

    public void setLiveP2spSwitchLagThresholdMs(int i) {
        setOption(1, "live-p2sp-switch-lag-threshold-ms", i);
    }

    public void setLiveP2spSwitchMaxCount(int i) {
        setOption(1, "live-p2sp-switch-max-count", i);
    }

    public void setLiveP2spSwitchOffBufferThresholdMs(int i) {
        setOption(1, "live-p2sp-switch-off-buffer-threshold-ms", i);
    }

    public void setLiveP2spSwitchOnBufferHoldThresholdMs(int i) {
        setOption(1, "live-p2sp-switch-on-buffer-hold-threshold-ms", i);
    }

    public void setLiveP2spSwitchOnBufferThresholdMs(int i) {
        setOption(1, "live-p2sp-switch-on-buffer-threshold-ms", i);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setLooping(boolean z) {
        int i = !z ? 1 : 0;
        setOption(4, "loop", i);
        _setLoopCount(i);
    }

    public void setNetWorkConnectionTimeout(int i) {
        if (i > 0) {
            _setConnectionTimeout(i);
            return;
        }
        String str = TAG;
        Log.w(str, "unsupported connection time out  :" + i + ", use the default time out : 5");
    }

    public void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    public void setOnLiveVoiceCommentListener(IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener) {
        this.mOnLiveVoiceCommentListener = onLiveVoiceCommentListener;
    }

    public void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    public void setOnPeriodicalLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        this.mOnLiveAdaptiveQosStatListener = onLiveAdaptiveQosStatListener;
    }

    public void setOnPeriodicalQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener) {
        this.mOnQosStatListener = onQosStatListener;
    }

    public void setOnVideoTextureListener(OnVideoTextureListener onVideoTextureListener) {
        this.mOnVideoTextureListener = onVideoTextureListener;
    }

    public void setOption(int i, String str, long j) {
        _setOption(i, str, j);
    }

    public void setOption(int i, String str, String str2) {
        _setOption(i, str, str2);
    }

    public void setPlayerMute(int i) {
        _setPlayerMute(i);
    }

    public void setProductContext(String str) {
        setOption(1, "product-context", str);
    }

    public void setQosTickDuration(int i) {
        this.mQosTickDuration = i;
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

    public void setSpeed(float f2) {
        _setSpeed(f2);
    }

    public void setStartPlayBlockBufferMs(int i, int i2) {
        _setStartPlayBlockBufferMs(i, i2);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.mSurfaceHolder = null;
        _setSurfaceTexture(surfaceTexture);
    }

    public void setTag1(int i) {
        setOption(4, "tag1", i);
    }

    public void setTcpConnectionReuse(int i) {
        setOption(1, "tcp-connection-reuse", i);
    }

    public void setTcpConnectionReuseMaxage(int i) {
        setOption(1, "tcp-connection-reuse-maxage", i);
    }

    public void setTcpKeepaliveIdle(int i) {
        setOption(1, "tcp-keepalive-idle", i);
    }

    public void setTcpKeepaliveInterval(int i) {
        setOption(1, "tcp-keepalive-interval", i);
    }

    public void setTone(int i) {
        _setTone(i);
    }

    public void setUpstreamType(@AwesomeCache.UpstreamType int i) {
        setOption(1, "upstream-type", i);
    }

    public void setVideoScalingMode(@PlayerSettingConstants.ScalingMode int i) {
        _setVideoScalingMode(i);
    }

    public void setVodP2spCdnRequestInitialSize(int i) {
        setOption(1, "vod-p2sp-cdn-request-initial-size", i);
    }

    public void setVodP2spCdnRequestMaxSize(int i) {
        setOption(1, "vod-p2sp-cdn-request-max-size", i);
    }

    public void setVodP2spDisable() {
        setOption(1, "vod-p2sp-disable", "1");
    }

    public void setVodP2spHoleIgnoreSpeedcal(boolean z) {
        setOption(1, "vod-p2sp-hole-ignore-speedcal", z ? 1L : 0L);
    }

    public void setVodP2spOffThreshold(int i) {
        setOption(1, "vod-p2sp-off-threshold", i);
    }

    public void setVodP2spOnThreshold(int i) {
        setOption(1, "vod-p2sp-on-threshold", i);
    }

    public void setVodP2spPolicy(String str) {
        setOption(1, "vod-p2sp-policy", str);
    }

    public void setVodP2spTaskMaxSize(int i) {
        setOption(1, "vod-p2sp-task-max-size", i);
    }

    public void setVodP2spTaskTimeout(int i) {
        setOption(1, "vod-p2sp-task-timeout", i);
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
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, KsMediaPlayer.class.getName());
        this.mWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    public void shutdownWaitStop() {
        stopStatTimer();
        stayAwake(false);
        _shutdownWaitStop();
        this.mPlayerState = PlayerState.STATE_STOPPED;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void start() {
        stayAwake(true);
        _start();
        this.mPlayerState = PlayerState.STATE_PLAYING;
    }

    public void step_frame() {
        stayAwake(false);
        _step_frame();
        Timber.d("step_frame", new Object[0]);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void stop() {
        stopStatTimer();
        stayAwake(false);
        _stop();
        this.mPlayerState = PlayerState.STATE_STOPPED;
    }

    public void stopStatTimer() {
        if (this.mEnableQosStat) {
            stopQosStatTimer();
        }
        if (this.mEnableLiveAdaptiveQosStat) {
            stopLiveAdaptiveQosStatTimer();
        }
    }

    public void updateCurrentMaxWallClockOffset(long j) {
        _updateCurrentMaxWallClockOffset(j);
    }

    public void updateCurrentWallClock(long j) {
        _updateCurrentWallClock(j);
    }
}
