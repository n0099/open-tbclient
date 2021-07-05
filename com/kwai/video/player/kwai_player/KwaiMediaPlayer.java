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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public final class KwaiMediaPlayer extends AbstractNativeMediaPlayer implements IKwaiMediaPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUDIO_CHANNEL_MODE_FOA = 2;
    public static final int INPUT_DATA_TYPE_HLS_CUSTOME_MANIFEST = 3;
    public static final int INPUT_DATA_TYPE_INDEX_CONTENT = 2;
    public static final int INPUT_DATA_TYPE_SINGLE_URL = 0;
    public static final int INPUT_DATA_TYPE_VOD_MANIFEST = 1;
    public static final int MEDIA_BUFFERSIZE_DEFAULT = 20;
    public static final String TAG = "com.kwai.video.player.kwai_player.KwaiMediaPlayer";
    public transient /* synthetic */ FieldHolder $fh;
    public AppQosLiveAdaptiveRealtimeWrapper mAppQosLiveAdaptiveRealtimeWrapper;
    public AppQosLiveRealtimeWrapper mAppQosLiveRealtimeWrapper;
    public AspectAwesomeCache mAspectAwesomeCache;
    public AspectKFlv mAspectKFlv;
    public int mAudioChannelMode;
    public int mBufferingCount;
    public Context mContext;
    public String mDataSource;
    public int mInteractivemode;
    public boolean mIsLive;
    public boolean mIsVR;
    public boolean mIsVodAdaptive;
    public KwaiPlayerDebugInfo mKwaiPlayerDebugInfo;
    public IKwaiRepresentationListener mKwaiRepresentationListener;
    public KwaiVR mKwaiVR;
    public OnControlMessageListener mOnControlMessageListener;
    public IMediaPlayer.OnLiveVoiceCommentListener mOnLiveVoiceCommentListener;
    public OnNativeInvokeListener mOnNativeInvokeListener;
    public ByteBuffer mProcessPCMBuffer;
    public boolean mScreenOnWhilePlaying;
    public long mStartBufferingTime;
    public boolean mStayAwake;
    public int mStereoType;
    public SurfaceHolder mSurfaceHolder;
    public SurfaceTextureRenderer mSurfaceTextureRender;
    public int mTotalBufferingTime;
    public int mVideoHeight;
    public int mVideoSarDen;
    public int mVideoSarNum;
    public int mVideoWidth;
    public AspectKwaiVodAdaptive mVodAdaptive;
    public PowerManager.WakeLock mWakeLock;

    /* loaded from: classes7.dex */
    public interface IHeadTrackerListener {
        void onHeadTracker(float f2, float f3, float f4);
    }

    @Deprecated
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1297999174, "Lcom/kwai/video/player/kwai_player/KwaiMediaPlayer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1297999174, "Lcom/kwai/video/player/kwai_player/KwaiMediaPlayer;");
        }
    }

    public KwaiMediaPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mWakeLock = null;
        this.mInteractivemode = 0;
        this.mStereoType = 0;
        this.mProcessPCMBuffer = null;
        this.mKwaiPlayerDebugInfo = new KwaiPlayerDebugInfo();
        initPlayer();
        resetSomething();
    }

    private native void _addVideoRawBuffer(byte[] bArr);

    private native void _audioOnly(boolean z);

    private native boolean _checkCanStartPlay();

    private native void _disableSoftVideoDecode(boolean z);

    private native void _enableLoopOnBlock(int i2, int i3, long j);

    private native void _enableVideoRawDataCallback(boolean z);

    private native Bundle _getAppLiveAdaptiveRealtimeInfo();

    private native Bundle _getAppLiveQosDebugInfo();

    private native void _getAppLiveQosDebugInfoNew(AppLiveQosDebugInfoNew appLiveQosDebugInfoNew);

    private native void _getAppVodQosDebugInfoNew(AppVodQosDebugInfoNew appVodQosDebugInfoNew);

    private native String _getAudioCodecInfo();

    private native String _getBriefVideoStatJson();

    public static native String _getColorFormatName(int i2);

    private native int _getDownloadedPercent();

    private native String _getKwaiLiveVoiceComment(long j);

    private native String _getKwaiSign();

    private native String _getLiveRealTimeQosJson(int i2, int i3, long j, long j2, long j3);

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

    private native void _setCodecFlag(int i2);

    private native void _setDataSource(IMediaDataSource iMediaDataSource);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void _setDataSourceFd(int i2, long j, long j2);

    private native void _setHeadTracker(float f2, float f3, float f4);

    private native void _setHevcCodecName(String str);

    private native void _setLastTryFlag(int i2);

    private native void _setLiveAppQosInfo(String str);

    private native void _setLiveManifestSwitchMode(int i2);

    private native void _setLoopCount(int i2);

    private native void _setOnLiveInterActiveListener(Object obj);

    private native void _setOption(int i2, String str, long j);

    private native void _setOption(int i2, String str, String str2);

    private native void _setPlayerMute(int i2);

    private native void _setProcessPCMBuffer(ByteBuffer byteBuffer);

    private native void _setRepresentation(int i2);

    private native void _setRepresentationListener(Object obj);

    private native boolean _setRotateDegree(int i2);

    private native void _setSpeed(float f2);

    private native void _setStreamSelected(int i2, boolean z);

    private native void _setSurfaceTexture(SurfaceTexture surfaceTexture);

    private native void _setTone(int i2);

    private native void _setVideoScalingMode(int i2);

    private native void _setVideoSurface(Surface surface);

    private native void _shutdownWaitStop();

    private native void _start();

    private native void _step_frame();

    private native void _stop();

    private native void _updateCurrentMaxWallClockOffset(long j);

    private native void _updateCurrentWallClock(long j);

    private void configHeaders(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65608, this, map) == null) || map == null || map.isEmpty()) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65609, this) == null) {
            String format = String.format("a/%s/%s/%s", KsMediaPlayerInitConfig.packageName, KsMediaPlayerInitConfig.packageVersion, getVersion());
            setOption(1, "user-agent", format);
            Timber.d("user-agent:%s", format);
        }
    }

    public static String getColorFormatName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65610, null, i2)) == null) ? _getColorFormatName(i2) : (String) invokeI.objValue;
    }

    @TargetApi(13)
    private int getNativeFd(FileDescriptor fileDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, this, fileDescriptor)) == null) {
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

    public static native void native_setKlogParam(Object obj);

    public static native void native_setKwaiLogLevel(int i2);

    public static native void native_setLogLevel(int i2);

    private native void native_setup(Object obj);

    private void notifyRepresentationChangeEnd(int i2) {
        IKwaiRepresentationListener iKwaiRepresentationListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65623, this, i2) == null) || (iKwaiRepresentationListener = this.mKwaiRepresentationListener) == null) {
            return;
        }
        iKwaiRepresentationListener.representationChangeEnd(i2);
    }

    private void notifyRepresentationChangeStart(int i2, int i3) {
        IKwaiRepresentationListener iKwaiRepresentationListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65624, this, i2, i3) == null) || (iKwaiRepresentationListener = this.mKwaiRepresentationListener) == null) {
            return;
        }
        iKwaiRepresentationListener.representationChangeStart(i2, i3);
    }

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
            KwaiMediaPlayer kwaiMediaPlayer = (KwaiMediaPlayer) ((WeakReference) obj).get();
            if (kwaiMediaPlayer != null) {
                OnNativeInvokeListener onNativeInvokeListener = kwaiMediaPlayer.mOnNativeInvokeListener;
                if (onNativeInvokeListener == null || !onNativeInvokeListener.onNativeInvoke(i2, bundle)) {
                    if (i2 == 65536 && (onControlMessageListener = kwaiMediaPlayer.mOnControlMessageListener) != null) {
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

    private void resetSomething() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65626, this) == null) {
            this.mBufferingCount = 0;
            this.mTotalBufferingTime = 0;
            this.mStartBufferingTime = 0L;
        }
    }

    private void setDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65627, this, new Object[]{fileDescriptor, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.mDataSource = fileDescriptor.toString();
            _setDataSourceFd(getNativeFd(fileDescriptor), j, j2);
        }
    }

    @Deprecated
    private void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65628, this, onControlMessageListener) == null) {
            this.mOnControlMessageListener = onControlMessageListener;
        }
    }

    private void setVideoSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65629, this, surface) == null) {
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

    private void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65631, this) == null) || (surfaceHolder = this.mSurfaceHolder) == null) {
            return;
        }
        surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
    }

    public native void _enableAbLoop(long j, long j2);

    public native void _enablePreDemux(int i2, long j);

    public native float _getPropertyFloat(int i2, float f2);

    public native long _getPropertyLong(int i2, long j);

    public native String _getPropertyString(int i2);

    public native boolean _isLiveManifest();

    public native void _setAwesomeCacheCallback(Object obj);

    public native void _setBufferSize(int i2);

    public native void _setConfigJson(String str);

    public native void _setConnectionTimeout(int i2);

    public native void _setLiveLowDelayConfigJson(String str);

    public native void _setPropertyFloat(int i2, float f2);

    public native void _setPropertyLong(int i2, long j);

    public native void _setQy265Context(Object obj);

    public native void _setStartPlayBlockBufferMs(int i2, int i3);

    public native void _setTimeout(int i2);

    public native void _setupCacheSessionListener(Object obj);

    @Override // com.kwai.video.player.IMediaPlayer
    public void addVideoRawBuffer(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bArr) == null) {
            _addVideoRawBuffer(bArr);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void audioOnly(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            _audioOnly(z);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    @Deprecated
    public int bufferEmptyCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_BLOCKCNT, 0L) : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public int bufferEmptyCountOld() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mBufferingCount : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    @Deprecated
    public long bufferEmptyDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_BUFFERTIME, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long bufferEmptyDurationOld() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mTotalBufferingTime : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public boolean checkCanStartPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? _checkCanStartPlay() : invokeV.booleanValue;
    }

    public void deselectTrack(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            _setStreamSelected(i2, false);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void disableSoftVideoDecode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            _disableSoftVideoDecode(z);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void enableAudioMono(@PlayerSettingConstants.AudioMonoType int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            setOption(4, "audio-mono-type", i2);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void enableLoopOnBlock(int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            _enableLoopOnBlock(i2, i3, j);
        }
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public void enableVideoRawDataCallback(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            _enableVideoRawDataCallback(z);
        }
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public AppLiveAdaptiveRealtimeInfo getAppLiveAdaptiveRealtimeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? AppLiveAdaptiveRealtimeInfo.from(_getAppLiveAdaptiveRealtimeInfo()) : (AppLiveAdaptiveRealtimeInfo) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public AppLiveQosDebugInfo getAppLiveQosDebugInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? AppLiveQosDebugInfo.from(_getAppLiveQosDebugInfo()) : (AppLiveQosDebugInfo) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public AspectAwesomeCache getAspectAwesomeCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            AspectAwesomeCache aspectAwesomeCache = this.mAspectAwesomeCache;
            if (aspectAwesomeCache != null) {
                return aspectAwesomeCache;
            }
            throw new NullPointerException("AspectAwesomeCache is not setup");
        }
        return (AspectAwesomeCache) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public AspectKFlv getAspectKFlv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            AspectKFlv aspectKFlv = this.mAspectKFlv;
            if (aspectKFlv != null) {
                return aspectKFlv;
            }
            throw new NullPointerException("AspectKFlv is not setup");
        }
        return (AspectKFlv) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public AspectKwaiVodAdaptive getAspectVodAdaptive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            AspectKwaiVodAdaptive aspectKwaiVodAdaptive = this.mVodAdaptive;
            if (aspectKwaiVodAdaptive != null) {
                return aspectKwaiVodAdaptive;
            }
            throw new NullPointerException("AspectKwaiVodAdaptive is not setup");
        }
        return (AspectKwaiVodAdaptive) invokeV.objValue;
    }

    @Deprecated
    public long getAudioCachedBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_BYTES, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public long getAudioCachedDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_DURATION, 0L) : invokeV.longValue;
    }

    @Deprecated
    public long getAudioCachedPackets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_PACKETS, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getAudioRawLatencySeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_AUDIO_RAW_LATENCY_SECONDS, 0.0f) : invokeV.floatValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native int getAudioSessionId();

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getAverageDisplayFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_AVERAGE_DISPLAYED_FPS, 0.0f) : invokeV.floatValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_BIT_RATE, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getBriefVodStatJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? _getBriefVideoStatJson() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getBufferTimeMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_BUFFERSIZE_MAX, 0.0f) : invokeV.floatValue;
    }

    @Deprecated
    public long getCpuUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_CPU, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getCurAbsTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_CURRENT_ABSOLUTE_TIME, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getCurPlayingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? _getPropertyString(PlayerProps.FFP_PROP_STRING_PLAYING_URL) : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native long getCurrentPosition();

    @Override // com.kwai.video.player.IMediaPlayer
    public String getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mDataSource : (String) invokeV.objValue;
    }

    @Override // com.kwai.player.debuginfo.KwaiPlayerDebugInfoProvider
    public KwaiPlayerDebugInfo getDebugInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
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
        return (KwaiPlayerDebugInfo) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDecodeVideoFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_DECODED_VIDEO_FRAME_COUNT, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDecodedDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? _getPropertyLong(PlayerProps.PROP_LONG_DECODED_SIZE, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDecodedVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_HEIGHT, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDecodedVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_WIDTH, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDisplayFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_DISPLAYED_FRAME_COUNT, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDownloadDataSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? _getPropertyLong(PlayerProps.PROP_LONG_DOWNLOAD_SIZE, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public int getDownloadedPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? _getDownloadedPercent() : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDroppedDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_DROPPED_DURATION, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getDtsDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_DTS_DURATION, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native long getDuration();

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    @Deprecated
    public String getKflvVideoPlayingUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? getCurPlayingUrl() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getKwaiLiveVoiceComment(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048636, this, j)) == null) ? _getKwaiLiveVoiceComment(j) : (String) invokeJ.objValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getKwaiSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? _getKwaiSign() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer, com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getLiveRealTimeQosJson(int i2, int i3, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048638, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? _getLiveRealTimeQosJson(i2, i3, j, j2, j3) : (String) invokeCommon.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getLiveStatJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? _getLiveStatJson() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
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

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public Bundle getMediaMeta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? _getMediaMeta() : (Bundle) invokeV.objValue;
    }

    @Deprecated
    public long getMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_MEMORY, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public int getOrientaionDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            KwaiVR kwaiVR = this.mKwaiVR;
            if (kwaiVR != null) {
                return kwaiVR.getOrientaionDegrees();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getProbeFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? _getProbeFps() : invokeV.floatValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getReadVideoFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_READ_VIDEO_FRAME_COUNT, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public Bitmap getScreenShot() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048647, this, i2)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? _getPropertyString(PlayerProps.PROP_STRING_SERVER_IP) : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getSourceDeviceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_SOURCE_DEVICE_TYPE, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getSpeed(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048650, this, f2)) == null) ? _getPropertyFloat(10003, 0.0f) : invokeF.floatValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getStreamId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? _getPropertyString(PlayerProps.FFP_PROP_STRING_STREAM_ID) : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer, com.kwai.player.qos.AppLiveReatimeInfoProvider
    public KwaiQosInfo getStreamQosInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? KwaiQosInfo.fromBundle(_getQosInfo()) : (KwaiQosInfo) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.video.player.IMediaPlayer
    public KsTrackInfo[] getTrackInfo() {
        InterceptResult invokeV;
        KsMediaMeta parse;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
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

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getVideoAvgFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? _getPropertyFloat(PlayerProps.FFP_PROP_FLOAT_VIDEO_AVG_FPS, 0.0f) : invokeV.floatValue;
    }

    @Deprecated
    public long getVideoCachedBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_BYTES, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public long getVideoCachedDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_DURATION, 0L) : invokeV.longValue;
    }

    @Deprecated
    public long getVideoCachedPackets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_PACKETS, 0L) : invokeV.longValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public long getVideoDecErrorCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_DEC_ERROR_COUNT, 0L) : invokeV.longValue;
    }

    public float getVideoDecodeFramesPerSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? _getPropertyFloat(10001, 0.0f) : invokeV.floatValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public int getVideoDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_VIDEO_DECODER, 0L) : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.mVideoHeight : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public float getVideoOutputFramesPerSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? _getPropertyFloat(10002, 0.0f) : invokeV.floatValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarDen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.mVideoSarDen : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoSarNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.mVideoSarNum : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.mVideoWidth : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getVodAdaptiveCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? _getVodAdaptiveCacheKey() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getVodAdaptiveHostName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? _getVodAdaptiveHostName() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public int getVodAdaptiveRepID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_VOD_ADAPTIVE_REP_ID, 0L) : invokeV.intValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getVodAdaptiveUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? _getVodAdaptiveUrl() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public String getVodStatJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? _getVideoStatJson() : (String) invokeV.objValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public String getXksCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? _getXksCache() : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public boolean handleTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, motionEvent)) == null) {
            KwaiVR kwaiVR = this.mKwaiVR;
            if (kwaiVR != null) {
                return kwaiVR.handleTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public final void initPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            super.initPlayer();
            native_setup(new WeakReference(this));
        }
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer
    public void initProcessPCMBuffer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            if (this.mProcessPCMBuffer == null) {
                int _getPropertyLong = (int) _getPropertyLong(PlayerProps.FFP_PROP_INT64_AUDIO_BUF_SIZE, 0L);
                this.mProcessPCMBuffer = _getPropertyLong <= 0 ? ByteBuffer.allocate(176000) : ByteBuffer.allocate(_getPropertyLong * 2);
            }
            _setProcessPCMBuffer(this.mProcessPCMBuffer);
        }
    }

    @Deprecated
    public boolean isCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? _isCacheEnabled() : invokeV.booleanValue;
    }

    @Override // com.kwai.player.qos.AppLiveReatimeInfoProvider
    public boolean isLiveManifest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.mAspectKFlv.isLiveManifest() : invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? _getLoopCount() != 1 : invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer, com.kwai.player.qos.AppLiveReatimeInfoProvider
    public boolean isMediaPlayerValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? _isMediaPlayerValid() : invokeV.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public boolean isPlayable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048682, this, message) == null) || (i2 = message.what) == 0) {
            return;
        }
        if (i2 == 1) {
            notifyOnPrepared();
        } else if (i2 == 2) {
            notifyOnCompletion();
            stayAwake(false);
        } else if (i2 == 3) {
            notifyOnBufferingUpdate(message.arg1);
        } else if (i2 == 4) {
            notifyOnSeekComplete();
        } else if (i2 == 5) {
            int i3 = message.arg2;
            this.mVideoHeight = i3;
            this.mVideoWidth = (this.mIsLive && this.mIsVR) ? (int) (i3 * 0.5625d) : message.arg1;
            notifyOnVideoSizeChanged(this.mVideoWidth, this.mVideoHeight, this.mVideoSarNum, this.mVideoSarDen);
            resizeVideo(this.mVideoWidth, this.mVideoHeight);
        } else if (i2 != 99) {
            if (i2 == 100) {
                Timber.e("MEDIA_ERROR, msg.arg1:%d, msg.arg2:%d", Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
                if (!notifyOnError(message.arg1, message.arg2)) {
                    notifyOnCompletion();
                }
                stayAwake(false);
            } else if (i2 == 200) {
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
            } else if (i2 == 300) {
                long j = (message.arg1 << 32) | message.arg2;
                String kwaiLiveVoiceComment = getKwaiLiveVoiceComment(j);
                Timber.i("MEDIA_LIVE_VC_TIME, vc_time:%d, voice_comment:%s", Long.valueOf(j), kwaiLiveVoiceComment);
                IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener = this.mOnLiveVoiceCommentListener;
                if (onLiveVoiceCommentListener != null) {
                    onLiveVoiceCommentListener.onLiveVoiceCommentChange(this, kwaiLiveVoiceComment);
                }
            } else if (i2 == 10001) {
                int i5 = message.arg1;
                this.mVideoSarNum = i5;
                int i6 = message.arg2;
                this.mVideoSarDen = i6;
                notifyOnVideoSizeChanged(this.mVideoWidth, this.mVideoHeight, i5, i6);
            } else if (i2 == 12001) {
                notifyRepresentationChangeStart(message.arg1, message.arg2);
            } else if (i2 == 12002) {
                notifyRepresentationChangeEnd(message.arg1);
            } else {
                DebugLog.e(TAG, "Unknown message type " + message.what);
            }
        }
    }

    public Surface openSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
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
        return (Surface) invokeV.objValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            stayAwake(false);
            _pause();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            this.mAppQosLiveRealtimeWrapper.start(this.mDataSource);
            this.mAppQosLiveAdaptiveRealtimeWrapper.start();
            _prepareAsync();
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void registerSensorEvent() {
        KwaiVR kwaiVR;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (kwaiVR = this.mKwaiVR) == null) {
            return;
        }
        kwaiVR.registerSensorEvent();
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
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
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void releaseAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            releaseAsync(null);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void releaseAsync(@Nullable OnPlayerReleaseListener onPlayerReleaseListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, onPlayerReleaseListener) == null) {
            KwaiPlayerReleasePool.submit(new Runnable(this, onPlayerReleaseListener) { // from class: com.kwai.video.player.kwai_player.KwaiMediaPlayer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KwaiMediaPlayer this$0;
                public final /* synthetic */ OnPlayerReleaseListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onPlayerReleaseListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = onPlayerReleaseListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.shutdownWaitStop();
                        if (this.val$listener != null) {
                            this.val$listener.onRelease(this.this$0._getResultQos());
                        }
                        this.this$0.release();
                    }
                }
            });
        }
    }

    public void reload(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048690, this, str, z) == null) {
            _reload(str, z);
        }
    }

    @Override // com.kwai.video.player.AbstractNativeMediaPlayer, com.kwai.video.player.IMediaPlayer
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            super.resetListeners();
            _setProcessPCMBuffer(null);
            this.mProcessPCMBuffer = null;
            this.mKwaiRepresentationListener = null;
        }
    }

    public void resizeVideo(int i2, int i3) {
        SurfaceTextureRenderer surfaceTextureRenderer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048693, this, i2, i3) == null) || (surfaceTextureRenderer = this.mSurfaceTextureRender) == null) {
            return;
        }
        surfaceTextureRenderer.resizeVideo(i2, i3);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native void seekTo(long j);

    public void selectTrack(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i2) == null) {
            _setStreamSelected(i2, true);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setAppQosStatJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, jSONObject) == null) {
            _setLiveAppQosInfo(jSONObject.toString());
        }
    }

    public void setAudioChannelMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048697, this, i2) == null) {
            this.mAudioChannelMode = i2;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setAudioStreamType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048698, this, i2) == null) {
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setCencKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, str) == null) {
            setOption(1, "decryption_key", str);
        }
    }

    public void setCodecFlag(@PlayerSettingConstants.UseHardwareDecoderFlag int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048700, this, i2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048701, this, kwaiPlayerConfig) == null) {
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
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, context) == null) {
            this.mContext = context;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048703, this, context, uri) == null) {
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
        android.util.Log.d(com.kwai.video.player.kwai_player.KwaiMediaPlayer.TAG, "Couldn't open file on client side, trying server side");
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
        if (interceptable != null && interceptable.invokeLLL(1048704, this, context, uri, map) != null) {
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
        if (interceptable == null || interceptable.invokeL(1048705, this, iMediaDataSource) == null) {
            _setDataSource(iMediaDataSource);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    @TargetApi(13)
    public void setDataSource(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, fileDescriptor) == null) {
            this.mDataSource = fileDescriptor.toString();
            _setDataSourceFd(getNativeFd(fileDescriptor), 0L, 0L);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, str) == null) {
            this.mDataSource = str;
            configUserAgent();
            _setDataSource(str, null, null);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setDataSource(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048708, this, str, map) == null) {
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
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, surfaceHolder) == null) {
            this.mSurfaceHolder = surfaceHolder;
            setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
            updateSurfaceScreenOn();
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setEnableAudioSpectrum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048710, this, z) == null) {
            setOption(4, "enable-audio-spectrum", z ? 1L : 0L);
        }
    }

    public void setEnableSegmentCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z) == null) {
            setOption(4, "enable-segment-cache", z ? 1L : 0L);
        }
    }

    public void setHeadTracker(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048712, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            _setHeadTracker(f2, f3, f4);
        }
    }

    public void setHevcCodecName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, str) == null) {
            _setHevcCodecName(str);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setIndexContent(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048714, this, str, str2, str3, map) == null) {
            this.mDataSource = str;
            configHeaders(map);
            configUserAgent();
            _setDataSource(str, null, null);
            setOption(4, "input-data-type", 2L);
            setOption(4, "index-content.pre_path", str2);
            setOption(4, "index-content.content", str3);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setInteractiveMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i2) == null) {
            this.mInteractivemode = i2;
            KwaiVR kwaiVR = this.mKwaiVR;
            if (kwaiVR != null) {
                kwaiVR.setInteractiveMode(i2);
            }
        }
    }

    public void setIsLive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048716, this, z) == null) {
            this.mIsLive = z;
        }
    }

    public void setIsVR(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048717, this, z) == null) {
            this.mIsVR = z;
            setVR();
        }
    }

    public void setIsVodAdaptive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048718, this, z) == null) {
            this.mIsVodAdaptive = z;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z) == null) {
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setKwaiManifest(String str, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048720, this, str, str2, map) == null) {
            this.mDataSource = str;
            configHeaders(map);
            configUserAgent();
            _setDataSource(str, null, null);
            setOption(4, "input-data-type", 3L);
            setOption(4, "index-content.content", str2);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setKwaiRepresentationListener(IKwaiRepresentationListener iKwaiRepresentationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, iKwaiRepresentationListener) == null) {
            this.mKwaiRepresentationListener = iKwaiRepresentationListener;
            _setRepresentationListener(new WeakReference(this.mKwaiRepresentationListener));
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setLastTryFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048722, this, z) == null) {
            _setLastTryFlag(z ? 1 : 0);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setLiveManifestSwitchMode(@PlayerSettingConstants.KFlvSwitchMode int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048723, this, i2) == null) {
            _setLiveManifestSwitchMode(i2);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setLiveOnPeriodicalLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, onLiveAdaptiveQosStatListener) == null) {
            this.mAppQosLiveAdaptiveRealtimeWrapper.setOnPeriodicalLiveAdaptiveQosStatListener(onLiveAdaptiveQosStatListener);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setLiveOnQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, onQosStatListener) == null) {
            this.mAppQosLiveRealtimeWrapper.setOnQosStatListener(onQosStatListener);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z) == null) {
            int i2 = !z ? 1 : 0;
            setOption(4, "loop", i2);
            _setLoopCount(i2);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setOnLiveInterActiveListener(IKwaiMediaPlayer.OnLiveInterActiveListener onLiveInterActiveListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048727, this, onLiveInterActiveListener) == null) || onLiveInterActiveListener == null) {
            return;
        }
        _setOnLiveInterActiveListener(new WeakReference(onLiveInterActiveListener));
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setOnLiveVoiceCommentListener(IMediaPlayer.OnLiveVoiceCommentListener onLiveVoiceCommentListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, onLiveVoiceCommentListener) == null) {
            this.mOnLiveVoiceCommentListener = onLiveVoiceCommentListener;
        }
    }

    public void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, onNativeInvokeListener) == null) {
            this.mOnNativeInvokeListener = onNativeInvokeListener;
        }
    }

    public void setOption(int i2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048730, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}) == null) {
            _setOption(i2, str, j);
        }
    }

    public void setOption(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048731, this, i2, str, str2) == null) {
            _setOption(i2, str, str2);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setPlayerMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z) == null) {
            _setPlayerMute(z ? 1 : 0);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setRepresentation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048733, this, i2) == null) {
            _setRepresentation(i2);
        }
    }

    public boolean setRotateDegree(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048734, this, i2)) == null) ? _setRotateDegree(i2) : invokeI.booleanValue;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048735, this, z) == null) || this.mScreenOnWhilePlaying == z) {
            return;
        }
        if (z && this.mSurfaceHolder == null) {
            DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
        }
        this.mScreenOnWhilePlaying = z;
        updateSurfaceScreenOn();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048736, this, f2) == null) {
            _setSpeed(f2);
        }
    }

    public void setStereoType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048737, this, i2) == null) {
            this.mStereoType = i2;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, surface) == null) {
            if (this.mScreenOnWhilePlaying && surface != null) {
                DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
            }
            this.mSurfaceHolder = null;
            setVideoSurface(surface);
            updateSurfaceScreenOn();
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, surfaceTexture) == null) {
            this.mSurfaceHolder = null;
            _setSurfaceTexture(surfaceTexture);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setTag1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048740, this, i2) == null) {
            setOption(4, "tag1", i2);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setTone(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048741, this, i2) == null) {
            _setTone(i2);
        }
    }

    public void setVR() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && this.mIsVR) {
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
                    this.mSurfaceTextureRender.setHeadTrackerListener(new IHeadTrackerListener(this) { // from class: com.kwai.video.player.kwai_player.KwaiMediaPlayer.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ KwaiMediaPlayer this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.kwai.video.player.kwai_player.KwaiMediaPlayer.IHeadTrackerListener
                        public void onHeadTracker(float f2, float f3, float f4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                                this.this$0.setHeadTracker(f2, f3, f4);
                            }
                        }
                    });
                }
            }
            setOption(4, "video-stereo-type", this.mStereoType);
            setOption(4, "audio-channel-mode", this.mAudioChannelMode);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048743, this, i2) == null) {
            _setVideoScalingMode(i2);
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public native void setVolume(float f2, float f3);

    @Override // com.kwai.video.player.IMediaPlayer
    @SuppressLint({"Wakelock"})
    public void setWakeMode(Context context, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048745, this, context, i2) == null) {
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
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2 | 536870912, KwaiMediaPlayer.class.getName());
            this.mWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            if (z) {
                this.mWakeLock.acquire();
            }
        }
    }

    public void setupAspectKlv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z) == null) {
            this.mAspectKFlv = new AspectKFlv(this, z);
        }
    }

    public void setupAspectKwaiVodAdaptive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048747, this, z) == null) {
            this.mVodAdaptive = new AspectKwaiVodAdaptive(this, z);
        }
    }

    public void setupAspectLiveRealTimeReporter(boolean z, KwaiPlayerConfig kwaiPlayerConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048748, this, z, kwaiPlayerConfig) == null) {
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
    }

    public void setupAspectNativeCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z) == null) {
            this.mAspectAwesomeCache = new AspectAwesomeCache(this, z);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void shutdownWaitStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            stopLiveStatTimerImmediately();
            stayAwake(false);
            stopDrawLoopTimer();
            _shutdownWaitStop();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            stayAwake(true);
            _start();
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void stepFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            stayAwake(false);
            _step_frame();
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            stopLiveStatTimerImmediately();
            stayAwake(false);
            stopDrawLoopTimer();
            _stop();
        }
    }

    public void stopDrawLoopTimer() {
        SurfaceTextureRenderer surfaceTextureRenderer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048754, this) == null) || (surfaceTextureRenderer = this.mSurfaceTextureRender) == null) {
            return;
        }
        surfaceTextureRenderer.stopDrawFrameLoop();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void stopLiveStatTimerImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            this.mAppQosLiveRealtimeWrapper.stop();
            this.mAppQosLiveAdaptiveRealtimeWrapper.stop();
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    public void unRegisterSensorEvent() {
        KwaiVR kwaiVR;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048756, this) == null) || (kwaiVR = this.mKwaiVR) == null) {
            return;
        }
        kwaiVR.unRegisterSensorEvent();
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    @RuntimePlayerConfig
    public void updateCurrentMaxWallClockOffset(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048757, this, j) == null) {
            _updateCurrentMaxWallClockOffset(j);
        }
    }

    @Override // com.kwai.video.player.IKwaiMediaPlayer
    @RuntimePlayerConfig
    public void updateCurrentWallClock(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048758, this, j) == null) {
            _updateCurrentWallClock(j);
        }
    }
}
