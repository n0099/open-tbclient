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
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public final class KsMediaPlayer extends AbstractNativeMediaPlayer implements KwaiPlayerDebugInfoProvider, AppLiveReatimeInfoProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_LIVE_ADAPTIVE_QOS_TICK_DURATION = 2000;
    public static final int DEFAULT_MONITOR_INTERVAL = 1000;
    public static final int DEFAULT_QOS_TICK_DURATION = 10000;
    public static final int DEVICE_OUT_SPEAKER = 1;
    public static final int DEVICE_OUT_UNKNOWN = 0;
    public static final int MEDIA_BUFFERSIZE_DEFAULT = 20;
    public static final int MEDIA_TIME_OUT_DEFAULT = 30;
    public static final String TAG = "com.kwai.video.player.KsMediaPlayer";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long abLoopEndMs;
        public long abLoopStartMs;
        public String accessKey;
        public String appId;
        public AwesomeCacheCallback awesomeCacheCallback;
        public CacheSessionListener cacheSessionListener;
        public boolean enablePlayerCache;
        public boolean enableStatModule;
        public int fadeinEndTimeMs;
        public Context mContext;
        public int mManifestType;
        public int mVodManifestMaxResolution;
        public long preLoadDurationMs;
        public int preLoadVer;
        public String secretKeySign;
        public long seekAtStart;
        public String timeSec;
        public boolean vodManifestEnable;
        public long vodManifestHeight;
        public int vodManifestLowDevice;
        public int vodManifestNetType;
        public String vodManifestRateConfig;
        public int vodManifestSignalStrength;
        public int vodManifestSwitchCode;
        public long vodManifestWidth;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.appId = null;
            this.accessKey = null;
            this.secretKeySign = null;
            this.timeSec = null;
            this.enableStatModule = true;
            this.enablePlayerCache = false;
            this.preLoadVer = 1;
            this.preLoadDurationMs = 0L;
            this.abLoopStartMs = 0L;
            this.abLoopEndMs = 0L;
            this.seekAtStart = 0L;
            this.fadeinEndTimeMs = 0;
            this.vodManifestEnable = false;
            this.vodManifestWidth = 0L;
            this.vodManifestHeight = 0L;
            this.vodManifestNetType = 0;
            this.vodManifestRateConfig = "";
            this.vodManifestLowDevice = 0;
            this.vodManifestSignalStrength = 0;
            this.vodManifestSwitchCode = 0;
            this.mVodManifestMaxResolution = 0;
            this.mManifestType = 0;
            this.mContext = context.getApplicationContext();
        }

        public KsMediaPlayer build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new KsMediaPlayer(this) : (KsMediaPlayer) invokeV.objValue;
        }

        public Builder enableCache(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.enablePlayerCache = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder enableKSYStatModule(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.enableStatModule = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder seekAtStart(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.seekAtStart = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setAbLoop(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                this.abLoopStartMs = j;
                this.abLoopEndMs = j2;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setAccessKey(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.accessKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.appId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, awesomeCacheCallback)) == null) {
                this.awesomeCacheCallback = awesomeCacheCallback;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCacheSessionListener(CacheSessionListener cacheSessionListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cacheSessionListener)) == null) {
                this.cacheSessionListener = cacheSessionListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFadeinEndTimeMs(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? this : (Builder) invokeI.objValue;
        }

        public Builder setManifestType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.mManifestType = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setPreLoadDurationMs(int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                this.preLoadVer = i2;
                this.preLoadDurationMs = j;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setSecretKeySign(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.secretKeySign = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTimeSec(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.timeSec = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVodManifest(int i2, long j, long j2, String str, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                this.vodManifestEnable = true;
                this.vodManifestHeight = j2;
                this.vodManifestWidth = j;
                this.vodManifestNetType = i2;
                this.vodManifestRateConfig = str;
                this.vodManifestLowDevice = i3;
                this.vodManifestSignalStrength = i4;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setVodManifestMaxResolution(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
                this.mVodManifestMaxResolution = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setVodManifestSwitchCode(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                this.vodManifestSwitchCode = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface OnAudioProcessPCMListener {
        void onAudioProcessPCMAvailable(IMediaPlayer iMediaPlayer, ByteBuffer byteBuffer, long j, int i2, int i3, int i4);
    }

    /* loaded from: classes7.dex */
    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i2);
    }

    /* loaded from: classes7.dex */
    public interface OnNativeInvokeListener {
        public static final String ARG_RETRY_COUNTER = "retry_counter";
        public static final String ARG_SEGMENT_INDEX = "segment_index";
        public static final String ARG_URL = "url";
        public static final int ON_CONCAT_RESOLVE_SEGMENT = 65536;
        public static final int ON_HTTP_OPEN = 65538;
        public static final int ON_LIVE_RETRY = 65540;
        public static final int ON_TCP_OPEN = 65537;

        boolean onNativeInvoke(int i2, Bundle bundle);
    }

    /* loaded from: classes7.dex */
    public interface OnVideoTextureListener {
        void onVideoTextureAvailable(IMediaPlayer iMediaPlayer, SurfaceTexture surfaceTexture, int i2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class PlayerState {
        public static final /* synthetic */ PlayerState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PlayerState STATE_COMPLETED;
        public static final PlayerState STATE_END;
        public static final PlayerState STATE_ERROR;
        public static final PlayerState STATE_IDLE;
        public static final PlayerState STATE_INITIALIZED;
        public static final PlayerState STATE_PAUSED;
        public static final PlayerState STATE_PLAYING;
        public static final PlayerState STATE_PREPARED;
        public static final PlayerState STATE_PREPARING;
        public static final PlayerState STATE_STOPPED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(710169899, "Lcom/kwai/video/player/KsMediaPlayer$PlayerState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(710169899, "Lcom/kwai/video/player/KsMediaPlayer$PlayerState;");
                    return;
                }
            }
            STATE_IDLE = new PlayerState("STATE_IDLE", 0);
            STATE_INITIALIZED = new PlayerState("STATE_INITIALIZED", 1);
            STATE_PREPARING = new PlayerState("STATE_PREPARING", 2);
            STATE_PREPARED = new PlayerState("STATE_PREPARED", 3);
            STATE_PLAYING = new PlayerState("STATE_PLAYING", 4);
            STATE_PAUSED = new PlayerState("STATE_PAUSED", 5);
            STATE_STOPPED = new PlayerState("STATE_STOPPED", 6);
            STATE_COMPLETED = new PlayerState("STATE_COMPLETED", 7);
            STATE_ERROR = new PlayerState("STATE_ERROR", 8);
            PlayerState playerState = new PlayerState("STATE_END", 9);
            STATE_END = playerState;
            $VALUES = new PlayerState[]{STATE_IDLE, STATE_INITIALIZED, STATE_PREPARING, STATE_PREPARED, STATE_PLAYING, STATE_PAUSED, STATE_STOPPED, STATE_COMPLETED, STATE_ERROR, playerState};
        }

        public PlayerState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PlayerState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PlayerState) Enum.valueOf(PlayerState.class, str) : (PlayerState) invokeL.objValue;
        }

        public static PlayerState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PlayerState[]) $VALUES.clone() : (PlayerState[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1044997865, "Lcom/kwai/video/player/KsMediaPlayer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1044997865, "Lcom/kwai/video/player/KsMediaPlayer;");
        }
    }

    public KsMediaPlayer(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        this.mCacheSessionListenerInnerBridge = new CacheSessionListener(this) { // from class: com.kwai.video.player.KsMediaPlayer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsMediaPlayer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadPaused() {
                CacheSessionListener cacheSessionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (cacheSessionListener = this.this$0.mCacheSessionListener) == null) {
                    return;
                }
                cacheSessionListener.onDownloadPaused();
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadProgress(long j, long j2) {
                CacheSessionListener cacheSessionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (cacheSessionListener = this.this$0.mCacheSessionListener) == null) {
                    return;
                }
                cacheSessionListener.onDownloadProgress(j, j2);
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadResumed() {
                CacheSessionListener cacheSessionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cacheSessionListener = this.this$0.mCacheSessionListener) == null) {
                    return;
                }
                cacheSessionListener.onDownloadResumed();
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadStarted(long j, String str, String str2, String str3, int i4, long j2) {
                CacheSessionListener cacheSessionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, str2, str3, Integer.valueOf(i4), Long.valueOf(j2)}) == null) || (cacheSessionListener = this.this$0.mCacheSessionListener) == null) {
                    return;
                }
                cacheSessionListener.onDownloadStarted(j, str, str2, str3, i4, j2);
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadStopped(int i4, long j, long j2, String str, int i5, String str2, String str3, String str4, String str5) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i4), Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i5), str2, str3, str4, str5}) == null) || this.this$0.mCacheSessionListener == null) {
                    return;
                }
                this.this$0.mCacheSessionListener.onDownloadStopped(i4, j, j2, str, i5, str2, str3, str4, str5);
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onSessionClosed(int i4, long j, long j2, long j3, String str, boolean z) {
                CacheSessionListener cacheSessionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i4), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Boolean.valueOf(z)}) == null) || (cacheSessionListener = this.this$0.mCacheSessionListener) == null) {
                    return;
                }
                cacheSessionListener.onSessionClosed(i4, j, j2, j3, str, z);
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onSessionStart(String str, long j, long j2, long j3) {
                CacheSessionListener cacheSessionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (cacheSessionListener = this.this$0.mCacheSessionListener) == null) {
                    return;
                }
                cacheSessionListener.onSessionStart(str, j, j2, j3);
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

    private native void _enablePreDemux(int i2, long j);

    private native void _enableVideoRawDataCallback(boolean z);

    private native Bundle _getAppLiveAdaptiveRealtimeInfo();

    private native Bundle _getAppLiveQosDebugInfo();

    private native void _getAppLiveQosDebugInfoNew(AppLiveQosDebugInfoNew appLiveQosDebugInfoNew);

    private native void _getAppVodQosDebugInfoNew(AppVodQosDebugInfoNew appVodQosDebugInfoNew);

    private native String _getAudioCodecInfo();

    public static native String _getColorFormatName(int i2);

    private native String _getKwaiLiveVoiceComment(long j);

    private native String _getKwaiSign();

    private native String _getLiveRealTimeQosJson(int i2, int i3, long j, long j2, long j3);

    private native String _getLiveStatJson();

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native void _getPlayerConfigDebugInfo(PlayerConfigDebugInfo playerConfigDebugInfo);

    private native float _getPropertyFloat(int i2, float f2);

    private native long _getPropertyLong(int i2, long j);

    private native String _getPropertyString(int i2);

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

    private native void _setBufferSize(int i2);

    private native void _setCodecFlag(int i2);

    private native void _setConfigJson(String str);

    private native void _setConnectionTimeout(int i2);

    private native void _setDataSource(IMediaDataSource iMediaDataSource);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void _setDataSourceFd(int i2, long j, long j2);

    private native void _setHevcCodecName(String str);

    public static native void _setKlogParam(Object obj);

    private native void _setLiveManifestSwitchMode(int i2);

    private native void _setLoopCount(int i2);

    private native void _setOption(int i2, String str, long j);

    private native void _setOption(int i2, String str, String str2);

    private native void _setPlayerMute(int i2);

    private native void _setProcessPCMBuffer(ByteBuffer byteBuffer);

    private native void _setPropertyFloat(int i2, float f2);

    private native void _setPropertyLong(int i2, long j);

    private native boolean _setRotateDegree(int i2);

    private native void _setSpeed(float f2);

    private native void _setStartPlayBlockBufferMs(int i2, int i3);

    private native void _setStreamSelected(int i2, boolean z);

    private native void _setSurfaceTexture(SurfaceTexture surfaceTexture);

    private native void _setTimeout(int i2);

    private native void _setTone(int i2);

    private native void _setVideoScalingMode(int i2);

    private native void _setVideoSurface(Surface surface);

    private native void _setupCacheSessionListener(Object obj);

    private native void _shutdownWaitStop();

    private native void _start();

    private native void _step_frame();

    private native void _stop();

    private native void _updateCurrentMaxWallClockOffset(long j);

    private native void _updateCurrentWallClock(long j);

    public static String getColorFormatName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65612, null, i2)) == null) ? _getColorFormatName(i2) : (String) invokeI.objValue;
    }

    @TargetApi(13)
    private int getNativeFd(FileDescriptor fileDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, this, fileDescriptor)) == null) {
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
        return invokeL.intValue;
    }

    public static native String getVersion();

    public static native String getVersionExt();

    private native void native_finalize();

    public static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setKwaiLogLevel(int i2);

    public static native void native_setLogLevel(int i2);

    private native void native_set_context(Object obj);

    private native void native_setup(Object obj);

    @CalledByNative
    public static boolean onNativeInvoke(Object obj, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        OnControlMessageListener onControlMessageListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65625, null, obj, i2, bundle)) == null) {
            DebugLog.ifmt(TAG, "onNativeInvoke %d", Integer.valueOf(i2));
            if (obj == null || !(obj instanceof WeakReference)) {
                throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
            }
            KsMediaPlayer ksMediaPlayer = (KsMediaPlayer) ((WeakReference) obj).get();
            if (ksMediaPlayer != null) {
                OnNativeInvokeListener onNativeInvokeListener = ksMediaPlayer.mOnNativeInvokeListener;
                if (onNativeInvokeListener == null || !onNativeInvokeListener.onNativeInvoke(i2, bundle)) {
                    if (i2 == 65536 && (onControlMessageListener = ksMediaPlayer.mOnControlMessageListener) != null) {
                        int i3 = bundle.getInt("segment_index", -1);
                        if (i3 >= 0) {
                            String onControlResolveSegmentUrl = onControlMessageListener.onControlResolveSegmentUrl(i3);
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
        return invokeLIL.booleanValue;
    }

    private void setDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65626, this, new Object[]{fileDescriptor, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.mDataSource = fileDescriptor.toString();
            _setDataSourceFd(getNativeFd(fileDescriptor), j, j2);
            this.mPlayerState = PlayerState.STATE_INITIALIZED;
        }
    }

    public static void setKlogParam(KlogObserver.KlogParam klogParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65627, null, klogParam) == null) {
            _setKlogParam(klogParam);
        }
    }

    private void startLiveAdaptiveQosStatTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65628, this) == null) {
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
    }

    private void startQosStatTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65629, this) == null) {
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
    }

    @SuppressLint({"Wakelock"})
    private void stayAwake(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65630, this, z) == null) {
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
    }

    private void stopLiveAdaptiveQosStatTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65631, this) == null) {
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
    }

    private void stopQosStatTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65632, this) == null) {
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
    }

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65633, this) == null) || (surfaceHolder = this.mSurfaceHolder) == null) {
            return;
        }
        surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
    }

    public native void _prepareAsync();

    public void abortNativeCacheIO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            _abortNativeCacheIO();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void addVideoRawBuffer(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) {
            _addVideoRawBuffer(bArr);
        }
    }

    public void audioOnly(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            _audioOnly(z);
        }
    }

    public int bufferEmptyCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_BLOCKCNT, 0L) : invokeV.intValue;
    }

    public int bufferEmptyCountOld() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBufferingCount : invokeV.intValue;
    }

    public long bufferEmptyDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_BUFFERTIME, 0L) : invokeV.longValue;
    }

    public long bufferEmptyDurationOld() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTotalBufferingTime : invokeV.longValue;
    }

    public void deselectTrack(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            _setStreamSelected(i2, false);
        }
    }

    public void disableSoftVideoDecode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            _disableSoftVideoDecode(z);
        }
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public void enableVideoRawDataCallback(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            _enableVideoRawDataCallback(z);
        }
    }

    public boolean getAdaptiveQosTimerStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIsLiveAdaptiveQosTimerStarted : invokeV.booleanValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public AppLiveAdaptiveRealtimeInfo getAppLiveAdaptiveRealtimeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? AppLiveAdaptiveRealtimeInfo.from(_getAppLiveAdaptiveRealtimeInfo()) : (AppLiveAdaptiveRealtimeInfo) invokeV.objValue;
    }

    public AppLiveQosDebugInfo getAppLiveQosDebugInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? AppLiveQosDebugInfo.from(_getAppLiveQosDebugInfo()) : (AppLiveQosDebugInfo) invokeV.objValue;
    }

    public long getAudioCachedBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_BYTES, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public long getAudioCachedDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_DURATION, 0L) : invokeV.longValue;
    }

    public long getAudioCachedPackets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_PACKETS, 0L) : invokeV.longValue;
    }

    public float getAudioRawLatencySeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_AUDIO_RAW_LATENCY_SECONDS, 0.0f) : invokeV.floatValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native int getAudioSessionId();

    public float getAverageDisplayFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_AVERAGE_DISPLAYED_FPS, 0.0f) : invokeV.floatValue;
    }

    public long getBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_BIT_RATE, 0L) : invokeV.longValue;
    }

    public float getBufferTimeMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_BUFFERSIZE_MAX, 0.0f) : invokeV.floatValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public long getCpuUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_CPU, 0L) : invokeV.longValue;
    }

    public long getCurAbsTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_CURRENT_ABSOLUTE_TIME, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getCurPlayingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? _getPropertyString(PlayerProps.FFP_PROP_STRING_PLAYING_URL) : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native long getCurrentPosition();

    @Override // com.kwai.video.player.IMediaPlayer
    public String getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mDataSource : (String) invokeV.objValue;
    }

    @Override // com.kwai.player.debuginfo.KwaiPlayerDebugInfoProvider
    public KwaiPlayerDebugInfo getDebugInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
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
        return (KwaiPlayerDebugInfo) invokeV.objValue;
    }

    public long getDecodeVideoFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_DECODED_VIDEO_FRAME_COUNT, 0L) : invokeV.longValue;
    }

    public long getDecodedDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? _getPropertyLong(PlayerProps.PROP_LONG_DECODED_SIZE, 0L) : invokeV.longValue;
    }

    public long getDecodedVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_HEIGHT, 0L) : invokeV.longValue;
    }

    public long getDecodedVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_WIDTH, 0L) : invokeV.longValue;
    }

    public long getDisplayFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_DISPLAYED_FRAME_COUNT, 0L) : invokeV.longValue;
    }

    public long getDownloadDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? _getPropertyLong(PlayerProps.PROP_LONG_DOWNLOAD_SIZE, 0L) : invokeV.longValue;
    }

    public long getDroppedDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_DROPPED_DURATION, 0L) : invokeV.longValue;
    }

    public long getDtsDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_DTS_DURATION, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native long getDuration();

    public boolean getEnableLiveAdaptiveQos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mEnableLiveAdaptiveQosStat : invokeV.booleanValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    @Deprecated
    public String getKflvVideoPlayingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? getCurPlayingUrl() : (String) invokeV.objValue;
    }

    public String getKwaiLiveVoiceComment(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048616, this, j)) == null) ? _getKwaiLiveVoiceComment(j) : (String) invokeJ.objValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getKwaiSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? _getKwaiSign() : (String) invokeV.objValue;
    }

    public long getLiveAdaptiveTickDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mLiveAdaptiveQosTickDuration : invokeV.longValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getLiveRealTimeQosJson(int i2, int i3, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? _getLiveRealTimeQosJson(i2, i3, j, j2, j3) : (String) invokeCommon.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
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
        return (MediaInfo) invokeV.objValue;
    }

    public Bundle getMediaMeta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? _getMediaMeta() : (Bundle) invokeV.objValue;
    }

    public long getMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_MEMORY, 0L) : invokeV.longValue;
    }

    public IMediaPlayer.OnLiveVoiceCommentListener getOnLiveVoiceCommentListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mOnLiveVoiceCommentListener : (IMediaPlayer.OnLiveVoiceCommentListener) invokeV.objValue;
    }

    public native float getProbeFps();

    public boolean getQosTimerStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mIsQosTimerStarted : invokeV.booleanValue;
    }

    public long getReadVideoFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_READ_VIDEO_FRAME_COUNT, 0L) : invokeV.longValue;
    }

    public Bitmap getScreenShot() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            int i3 = this.mVideoWidth;
            if (i3 <= 0 || (i2 = this.mVideoHeight) <= 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.RGB_565);
            _getScreenShot(createBitmap);
            return createBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public int getSelectedTrack(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
            if (i2 == 1) {
                i3 = 20001;
            } else if (i2 != 2) {
                return -1;
            } else {
                i3 = PlayerProps.FFP_PROP_INT64_SELECTED_AUDIO_STREAM;
            }
            return (int) _getPropertyLong(i3, -1L);
        }
        return invokeI.intValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getServerAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? _getPropertyString(PlayerProps.PROP_STRING_SERVER_IP) : (String) invokeV.objValue;
    }

    public long getSourceDeviceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_SOURCE_DEVICE_TYPE, 0L) : invokeV.longValue;
    }

    public float getSpeed(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048631, this, f2)) == null) ? _getPropertyFloat(10003, 0.0f) : invokeF.floatValue;
    }

    @Deprecated
    public String getStatJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? _getLiveStatJson() : (String) invokeV.objValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getStreamId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? _getPropertyString(PlayerProps.FFP_PROP_STRING_STREAM_ID) : (String) invokeV.objValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public KwaiQosInfo getStreamQosInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? KwaiQosInfo.fromBundle(_getQosInfo()) : (KwaiQosInfo) invokeV.objValue;
    }

    public long getTickDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mQosTickDuration : invokeV.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.video.player.IMediaPlayer
    public KsTrackInfo[] getTrackInfo() {
        InterceptResult invokeV;
        KsMediaMeta parse;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
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
                    i2 = 1;
                } else if (next.mType.equalsIgnoreCase("audio")) {
                    i2 = 2;
                } else {
                    arrayList.add(ksTrackInfo);
                }
                ksTrackInfo.setTrackType(i2);
                arrayList.add(ksTrackInfo);
            }
            return (KsTrackInfo[]) arrayList.toArray(new KsTrackInfo[arrayList.size()]);
        }
        return (KsTrackInfo[]) invokeV.objValue;
    }

    public float getVideoAvgFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_VIDEO_AVG_FPS, 0.0f) : invokeV.floatValue;
    }

    public long getVideoCachedBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_BYTES, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public long getVideoCachedDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_DURATION, 0L) : invokeV.longValue;
    }

    public long getVideoCachedPackets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_PACKETS, 0L) : invokeV.longValue;
    }

    public long getVideoDecErrorCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_DEC_ERROR_COUNT, 0L) : invokeV.longValue;
    }

    public float getVideoDecodeFramesPerSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? _getPropertyFloat(10001, 0.0f) : invokeV.floatValue;
    }

    public int getVideoDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_DECODER, 0L) : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mVideoHeight : invokeV.intValue;
    }

    public float getVideoOutputFramesPerSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? _getPropertyFloat(10002, 0.0f) : invokeV.floatValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarDen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.mVideoSarDen : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.mVideoSarNum : invokeV.intValue;
    }

    public String getVideoStatJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? _getVideoStatJson() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mVideoWidth : invokeV.intValue;
    }

    public String getVodAdaptiveCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? _getVodAdaptiveCacheKey() : (String) invokeV.objValue;
    }

    public String getVodAdaptiveHostName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? _getVodAdaptiveHostName() : (String) invokeV.objValue;
    }

    public int getVodAdaptiveRepID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_VOD_ADAPTIVE_REP_ID, 0L) : invokeV.intValue;
    }

    public String getVodAdaptiveUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? _getVodAdaptiveUrl() : (String) invokeV.objValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getXksCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? _getXksCache() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public final void initPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            super.initPlayer();
            native_set_context(this.mContext);
            native_setup(new WeakReference(this));
            _setupCacheSessionListener(new WeakReference(this.mCacheSessionListenerInnerBridge));
        }
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public void initProcessPCMBuffer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            if (this.mProcessPCMBuffer == null) {
                int _getPropertyLong = (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_BUF_SIZE, 0L);
                this.mProcessPCMBuffer = _getPropertyLong <= 0 ? ByteBuffer.allocate(176000) : ByteBuffer.allocate(_getPropertyLong * 2);
            }
            _setProcessPCMBuffer(this.mProcessPCMBuffer);
        }
    }

    public boolean isCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? _isCacheEnabled() : invokeV.booleanValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public boolean isLiveManifest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? _isLiveManifest() : invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? _getLoopCount() != 1 : invokeV.booleanValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public boolean isMediaPlayerValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? _isMediaPlayerValid() : invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isPlayable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native boolean isPlaying();

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public void onReceivePostEvent(Message message) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048664, this, message) == null) || (i2 = message.what) == 0) {
            return;
        }
        if (i2 == 1) {
            this.mPlayerState = PlayerState.STATE_PREPARED;
            notifyOnPrepared();
        } else if (i2 == 2) {
            this.mPlayerState = PlayerState.STATE_COMPLETED;
            notifyOnCompletion();
            stayAwake(false);
        } else if (i2 == 3) {
            notifyOnBufferingUpdate(message.arg1);
        } else if (i2 == 4) {
            notifyOnSeekComplete();
        } else if (i2 == 5) {
            int i3 = message.arg1;
            this.mVideoWidth = i3;
            int i4 = message.arg2;
            this.mVideoHeight = i4;
            notifyOnVideoSizeChanged(i3, i4, this.mVideoSarNum, this.mVideoSarDen);
        } else if (i2 != 99) {
            if (i2 == 100) {
                Timber.e("MEDIA_ERROR, msg.arg1:%d, msg.arg2:%d", Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
                if (!notifyOnError(message.arg1, message.arg2)) {
                    notifyOnCompletion();
                }
                this.mErrorCode = message.arg1;
                stayAwake(false);
            } else if (i2 == 200) {
                int i5 = message.arg1;
                if (i5 == 701) {
                    this.mBufferingCount++;
                    this.mStartBufferingTime = System.currentTimeMillis();
                } else if (i5 == 702) {
                    this.mTotalBufferingTime += (int) (System.currentTimeMillis() - this.mStartBufferingTime);
                } else if (i5 == 10100) {
                    notifyOnSeekComplete();
                    return;
                }
                notifyOnInfo(message.arg1, message.arg2);
            } else if (i2 == 300) {
                long j = (message.arg1 << 32) | message.arg2;
                String kwaiLiveVoiceComment = getKwaiLiveVoiceComment(j);
                Timber.i("MEDIA_LIVE_VC_TIME, vc_time:%d, voice_comment:%s", Long.valueOf(j), kwaiLiveVoiceComment);
                IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener = getOnLiveVoiceCommentListener();
                if (onLiveVoiceCommentListener != null) {
                    onLiveVoiceCommentListener.onLiveVoiceCommentChange(this, kwaiLiveVoiceComment);
                }
            } else if (i2 != 10001) {
                DebugLog.e(TAG, "Unknown message type " + message.what);
            } else {
                int i6 = message.arg1;
                this.mVideoSarNum = i6;
                int i7 = message.arg2;
                this.mVideoSarDen = i7;
                notifyOnVideoSizeChanged(this.mVideoWidth, this.mVideoHeight, i6, i7);
            }
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            stayAwake(false);
            _pause();
            Timber.d("KSYMeidaPlayer getAverageDisplayFps:%f", Float.valueOf(getAverageDisplayFps()));
            this.mPlayerState = PlayerState.STATE_PAUSED;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
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
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            if (this.mIsVodAdaptive) {
                PlayerPreferrenceUtil.getInstance().saveVodAdaptiveData();
            }
            stayAwake(false);
            updateSurfaceScreenOn();
            _release();
            resetListeners();
            this.mPlayerState = PlayerState.STATE_END;
        }
    }

    public void reload(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048668, this, str, z) == null) {
            _reload(str, z);
        }
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer, com.kwai.video.player.IMediaPlayer
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            stayAwake(false);
            _reset();
            super.reset();
            this.mVideoWidth = 0;
            this.mVideoHeight = 0;
        }
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer, com.kwai.video.player.AbstractMediaPlayer
    public void resetListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            super.resetListeners();
            _setProcessPCMBuffer(null);
            this.mProcessPCMBuffer = null;
            this.mAwesomeCacheCallback = null;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native void seekTo(long j);

    public void selectTrack(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048672, this, i2) == null) {
            _setStreamSelected(i2, true);
        }
    }

    public void setAegonMTRequestDelayTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i2) == null) {
            setOption(1, "mt_request_delay_ms", i2 < 0 ? -1L : i2);
        }
    }

    public void setAsyncCacheByteRangeSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048674, this, i2) == null) {
            setOption(1, "byte-range-size", i2);
        }
    }

    public void setAsyncCacheEnableReuseManager(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z) == null) {
            setOption(1, "async-enable-reuse-manager", z ? 1L : 0L);
        }
    }

    public void setAsyncCacheFirstByteRangeSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i2) == null) {
            setOption(1, "first-byte-range-size", i2);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setAudioStreamType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i2) == null) {
        }
    }

    public void setBufferSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i2) == null) {
            if (i2 <= 0) {
                String str = TAG;
                Log.w(str, "unsupported buffer size :20,replace the default size :20");
                i2 = 20;
            }
            _setBufferSize(i2);
        }
    }

    public void setBufferTimeMax(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048679, this, f2) == null) {
            _setPropertyFloat(PlayerProps.FFP_PROP_FLOAT_BUFFERSIZE_MAX, f2);
        }
    }

    public void setBufferedDataSourceSizeKB(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048680, this, i2) == null) {
            setOption(1, "buffered-datasource-size-kb", i2);
        }
    }

    @Deprecated
    public void setBufferedDataSourceType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048681, this, i2) == null) {
            setOption(1, "buffered-datasource-type", i2);
        }
    }

    public void setCacheDownloadConnectTimeoutMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i2) == null) {
            setOption(1, "cache-connect-timeout-ms", i2);
        }
    }

    public void setCacheDownloadReadTimeoutMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i2) == null) {
            setOption(1, "cache-read-timeout-ms", i2);
        }
    }

    public void setCacheHttpConnectRetryCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            setOption(1, "cache-http-connect-retry-cnt", i2);
        }
    }

    public void setCacheKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, str) == null) {
            setOption(4, "cache-key", str);
        }
    }

    public void setCacheProgressCallbackIntervalMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048686, this, i2) == null) {
            setOption(1, "progress_cb_interval_ms", i2);
        }
    }

    public void setCacheSocketBufferSizeKb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i2) == null) {
            setOption(1, "cache-socket-buf-size-kb", i2);
        }
    }

    public void setCodecFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048688, this, i2) == null) {
            if (i2 <= 0) {
                String str = TAG;
                Log.w(str, "unsupported codec flag :0,replace the codec flag :0");
                i2 = 0;
            }
            _setCodecFlag(i2);
        }
    }

    public void setConfig(KwaiPlayerConfig kwaiPlayerConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, kwaiPlayerConfig) == null) {
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
    }

    public void setConfigJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, str) == null) {
            _setConfigJson(str);
        }
    }

    public void setCurlBufferSizeKb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048691, this, i2) == null) {
            setOption(1, "curl-buffer-size-kb", i2);
        }
    }

    public void setDataReadTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048692, this, i2) == null) {
            if (i2 <= 0) {
                String str = TAG;
                Log.w(str, "unsupported time out  :" + i2 + ",replace the default time out :30");
                i2 = 30;
            }
            _setTimeout(i2);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048693, this, context, uri) == null) {
            setDataSource(context, uri, (Map<String, String>) null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
        if (0 == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
        if (0 == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
        android.util.Log.d(com.kwai.video.player.KsMediaPlayer.TAG, "Couldn't open file on client side, trying server side");
        setDataSource(r9.toString(), r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0099, code lost:
        return;
     */
    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(14)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048694, this, context, uri, map) != null) {
            return;
        }
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            setDataSource(uri.getPath());
        } else if ("content".equals(scheme) && "settings".equals(uri.getAuthority()) && (uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri))) == null) {
            throw new FileNotFoundException("Failed to resolve default ringtone");
        } else {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, r.f7745a);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, iMediaDataSource) == null) {
            _setDataSource(iMediaDataSource);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(13)
    public void setDataSource(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, fileDescriptor) == null) {
            this.mDataSource = fileDescriptor.toString();
            _setDataSourceFd(getNativeFd(fileDescriptor), 0L, 0L);
            this.mPlayerState = PlayerState.STATE_INITIALIZED;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, str) == null) {
            this.mDataSource = str;
            String format = String.format("a/%s/%s/%s", KsMediaPlayerInitConfig.packageName, KsMediaPlayerInitConfig.packageVersion, getVersion());
            setOption(1, "user-agent", format);
            Timber.d("user-agent:%s", format);
            _setDataSource(str, null, null);
            this.mPlayerState = PlayerState.STATE_INITIALIZED;
        }
    }

    public void setDataSource(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048698, this, str, map) == null) {
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
    }

    public void setDataSourceSeekReopenThresholdKB(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048699, this, i2) == null) {
            setOption(1, "datasource-seek-reopen-threshold-kb", i2);
        }
    }

    public void setDataSourceType(@AwesomeCache.DataSourceType int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048700, this, i2) == null) {
            setOption(1, "data-source-type", i2);
        }
    }

    public void setDccAlgMBTh_10(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048701, this, i2) == null) {
            setOption(4, "dcc-alg.config_mark_bitrate_th_10", i2);
        }
    }

    public void setDccAlgPreReadMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048702, this, i2) == null) {
            setOption(4, "dcc-alg.config_dcc_pre_read_ms", i2);
        }
    }

    public void setDccAlgorithm(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z) == null) {
            setOption(4, "dcc-alg.config_enabled", z ? 1L : 0L);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, surfaceHolder) == null) {
            this.mSurfaceHolder = surfaceHolder;
            _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
            updateSurfaceScreenOn();
        }
    }

    public void setEnableAudioSpectrum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z) == null) {
            setOption(4, "enable-audio-spectrum", z ? 1L : 0L);
        }
    }

    public void setEnableHttpdns(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048706, this, z) == null) {
            setOption(1, "enable_httpdns_in_hodor", z ? 1L : 0L);
        }
    }

    public void setEnablePlayAudioGain(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048707, this, z, str) == null) {
            setOption(4, "audio-gain.enable", z ? 1L : 0L);
            if (z) {
                setOption(4, "audio-gain.audio_str", str);
            }
        }
    }

    public void setEnableQosStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048708, this, z) == null) {
            this.mEnableQosStat = z;
        }
    }

    public void setHevcCodecName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            _setHevcCodecName(str);
        }
    }

    public void setIsLive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048710, this, z) == null) {
            this.mIsLive = z;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z) == null) {
        }
    }

    public void setLiveManifestSwitchMode(@PlayerSettingConstants.KFlvSwitchMode int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048712, this, i2) == null) {
            _setLiveManifestSwitchMode(i2);
        }
    }

    public void setLiveP2spSwitchCooldownMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048713, this, i2) == null) {
            setOption(1, "live-p2sp-switch-cooldown-ms", i2);
        }
    }

    public void setLiveP2spSwitchLagThresholdMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i2) == null) {
            setOption(1, "live-p2sp-switch-lag-threshold-ms", i2);
        }
    }

    public void setLiveP2spSwitchMaxCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i2) == null) {
            setOption(1, "live-p2sp-switch-max-count", i2);
        }
    }

    public void setLiveP2spSwitchOffBufferThresholdMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048716, this, i2) == null) {
            setOption(1, "live-p2sp-switch-off-buffer-threshold-ms", i2);
        }
    }

    public void setLiveP2spSwitchOnBufferHoldThresholdMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048717, this, i2) == null) {
            setOption(1, "live-p2sp-switch-on-buffer-hold-threshold-ms", i2);
        }
    }

    public void setLiveP2spSwitchOnBufferThresholdMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048718, this, i2) == null) {
            setOption(1, "live-p2sp-switch-on-buffer-threshold-ms", i2);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z) == null) {
            int i2 = !z ? 1 : 0;
            setOption(4, "loop", i2);
            _setLoopCount(i2);
        }
    }

    public void setNetWorkConnectionTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i2) == null) {
            if (i2 > 0) {
                _setConnectionTimeout(i2);
                return;
            }
            String str = TAG;
            Log.w(str, "unsupported connection time out  :" + i2 + ", use the default time out : 5");
        }
    }

    public void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, onControlMessageListener) == null) {
            this.mOnControlMessageListener = onControlMessageListener;
        }
    }

    public void setOnLiveVoiceCommentListener(IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, onLiveVoiceCommentListener) == null) {
            this.mOnLiveVoiceCommentListener = onLiveVoiceCommentListener;
        }
    }

    public void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, onNativeInvokeListener) == null) {
            this.mOnNativeInvokeListener = onNativeInvokeListener;
        }
    }

    public void setOnPeriodicalLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, onLiveAdaptiveQosStatListener) == null) {
            this.mOnLiveAdaptiveQosStatListener = onLiveAdaptiveQosStatListener;
        }
    }

    public void setOnPeriodicalQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, onQosStatListener) == null) {
            this.mOnQosStatListener = onQosStatListener;
        }
    }

    public void setOnVideoTextureListener(OnVideoTextureListener onVideoTextureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, onVideoTextureListener) == null) {
            this.mOnVideoTextureListener = onVideoTextureListener;
        }
    }

    public void setOption(int i2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048727, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}) == null) {
            _setOption(i2, str, j);
        }
    }

    public void setOption(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048728, this, i2, str, str2) == null) {
            _setOption(i2, str, str2);
        }
    }

    public void setPlayerMute(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048729, this, i2) == null) {
            _setPlayerMute(i2);
        }
    }

    public void setProductContext(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, str) == null) {
            setOption(1, "product-context", str);
        }
    }

    public void setQosTickDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048731, this, i2) == null) {
            this.mQosTickDuration = i2;
        }
    }

    public boolean setRotateDegree(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048732, this, i2)) == null) ? _setRotateDegree(i2) : invokeI.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048733, this, z) == null) || this.mScreenOnWhilePlaying == z) {
            return;
        }
        if (z && this.mSurfaceHolder == null) {
            DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
        }
        this.mScreenOnWhilePlaying = z;
        updateSurfaceScreenOn();
    }

    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048734, this, f2) == null) {
            _setSpeed(f2);
        }
    }

    public void setStartPlayBlockBufferMs(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048735, this, i2, i3) == null) {
            _setStartPlayBlockBufferMs(i2, i3);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, surface) == null) {
            if (this.mScreenOnWhilePlaying && surface != null) {
                DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
            }
            this.mSurfaceHolder = null;
            _setVideoSurface(surface);
            updateSurfaceScreenOn();
        }
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, surfaceTexture) == null) {
            this.mSurfaceHolder = null;
            _setSurfaceTexture(surfaceTexture);
        }
    }

    public void setTag1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048738, this, i2) == null) {
            setOption(4, "tag1", i2);
        }
    }

    public void setTcpConnectionReuse(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048739, this, i2) == null) {
            setOption(1, "tcp-connection-reuse", i2);
        }
    }

    public void setTcpConnectionReuseMaxage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048740, this, i2) == null) {
            setOption(1, "tcp-connection-reuse-maxage", i2);
        }
    }

    public void setTcpKeepaliveIdle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048741, this, i2) == null) {
            setOption(1, "tcp-keepalive-idle", i2);
        }
    }

    public void setTcpKeepaliveInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048742, this, i2) == null) {
            setOption(1, "tcp-keepalive-interval", i2);
        }
    }

    public void setTone(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048743, this, i2) == null) {
            _setTone(i2);
        }
    }

    public void setUpstreamType(@AwesomeCache.UpstreamType int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048744, this, i2) == null) {
            setOption(1, "upstream-type", i2);
        }
    }

    public void setVideoScalingMode(@PlayerSettingConstants.ScalingMode int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048745, this, i2) == null) {
            _setVideoScalingMode(i2);
        }
    }

    public void setVodP2spCdnRequestInitialSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048746, this, i2) == null) {
            setOption(1, "vod-p2sp-cdn-request-initial-size", i2);
        }
    }

    public void setVodP2spCdnRequestMaxSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048747, this, i2) == null) {
            setOption(1, "vod-p2sp-cdn-request-max-size", i2);
        }
    }

    public void setVodP2spDisable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            setOption(1, "vod-p2sp-disable", "1");
        }
    }

    public void setVodP2spHoleIgnoreSpeedcal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z) == null) {
            setOption(1, "vod-p2sp-hole-ignore-speedcal", z ? 1L : 0L);
        }
    }

    public void setVodP2spOffThreshold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048750, this, i2) == null) {
            setOption(1, "vod-p2sp-off-threshold", i2);
        }
    }

    public void setVodP2spOnThreshold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048751, this, i2) == null) {
            setOption(1, "vod-p2sp-on-threshold", i2);
        }
    }

    public void setVodP2spPolicy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, str) == null) {
            setOption(1, "vod-p2sp-policy", str);
        }
    }

    public void setVodP2spTaskMaxSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048753, this, i2) == null) {
            setOption(1, "vod-p2sp-task-max-size", i2);
        }
    }

    public void setVodP2spTaskTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048754, this, i2) == null) {
            setOption(1, "vod-p2sp-task-timeout", i2);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native void setVolume(float f2, float f3);

    @Override // com.kwai.video.player.IMediaPlayer
    @SuppressLint({"Wakelock"})
    public void setWakeMode(Context context, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048756, this, context, i2) == null) {
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
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2 | 536870912, KsMediaPlayer.class.getName());
            this.mWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            if (z) {
                this.mWakeLock.acquire();
            }
        }
    }

    public void shutdownWaitStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            stopStatTimer();
            stayAwake(false);
            _shutdownWaitStop();
            this.mPlayerState = PlayerState.STATE_STOPPED;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            stayAwake(true);
            _start();
            this.mPlayerState = PlayerState.STATE_PLAYING;
        }
    }

    public void step_frame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            stayAwake(false);
            _step_frame();
            Timber.d("step_frame", new Object[0]);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            stopStatTimer();
            stayAwake(false);
            _stop();
            this.mPlayerState = PlayerState.STATE_STOPPED;
        }
    }

    public void stopStatTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            if (this.mEnableQosStat) {
                stopQosStatTimer();
            }
            if (this.mEnableLiveAdaptiveQosStat) {
                stopLiveAdaptiveQosStatTimer();
            }
        }
    }

    public void updateCurrentMaxWallClockOffset(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048762, this, j) == null) {
            _updateCurrentMaxWallClockOffset(j);
        }
    }

    public void updateCurrentWallClock(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048763, this, j) == null) {
            _updateCurrentWallClock(j);
        }
    }
}
