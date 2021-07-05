package com.kwai.video.player.kwai_player;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.cache.CacheSessionListener;
import com.kwai.video.hodor.util.Timber;
import java.lang.ref.WeakReference;
@Keep
/* loaded from: classes7.dex */
public class AspectAwesomeCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AwesomeCacheCallback mAwesomeCacheCallback;
    @Nullable
    public CacheSessionListener mCacheSessionListener;
    public CacheSessionListener mCacheSessionListenerInnerBridge;
    @NonNull
    public final KwaiMediaPlayer mPlayer;

    public AspectAwesomeCache(@NonNull KwaiMediaPlayer kwaiMediaPlayer, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kwaiMediaPlayer, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlayer = kwaiMediaPlayer;
        setEnableHodor(z);
    }

    private void setEnableHodor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            this.mPlayer.setOption(4, "cache-enabled", z ? 1L : 0L);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mAwesomeCacheCallback = null;
        }
    }

    public void setAegonMTRequestDelayTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mPlayer.setOption(1, "mt_request_delay_ms", i2 < 0 ? -1L : i2);
        }
    }

    public void setAwesomeCacheCallback(@NonNull AwesomeCacheCallback awesomeCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, awesomeCacheCallback) == null) {
            this.mAwesomeCacheCallback = awesomeCacheCallback;
            this.mPlayer._setAwesomeCacheCallback(awesomeCacheCallback);
        }
    }

    public void setBufferedDataSourceSizeKB(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mPlayer.setOption(1, "buffered-datasource-size-kb", i2);
        }
    }

    public void setCacheDownloadConnectTimeoutMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mPlayer.setOption(1, "cache-connect-timeout-ms", i2);
        }
    }

    public void setCacheDownloadReadTimeoutMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mPlayer.setOption(1, "cache-read-timeout-ms", i2);
        }
    }

    public void setCacheKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mPlayer.setOption(4, "cache-key", str);
        }
    }

    public void setCacheProgressCallbackIntervalMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mPlayer.setOption(1, "progress_cb_interval_ms", i2);
        }
    }

    public void setCacheSessionListener(CacheSessionListener cacheSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cacheSessionListener) == null) {
            if (this.mCacheSessionListener != null) {
                throw new IllegalStateException("should not setCacheSessionListener twice");
            }
            this.mCacheSessionListener = cacheSessionListener;
            setupListener();
        }
    }

    public void setCacheSocketBufferSizeKb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mPlayer.setOption(1, "cache-socket-buf-size-kb", i2);
        }
    }

    public void setDataSourceSeekReopenThresholdKB(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mPlayer.setOption(1, "datasource-seek-reopen-threshold-kb", i2);
        }
    }

    public void setDataSourceType(@AwesomeCache.DataSourceType int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mPlayer.setOption(1, "data-source-type", i2);
        }
    }

    public void setEnableHttpdns(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mPlayer.setOption(1, "enable_httpdns_in_hodor", z ? 1L : 0L);
        }
    }

    public void setLiveP2spSwitchCooldownMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mPlayer.setOption(1, "live-p2sp-switch-cooldown-ms", i2);
        }
    }

    public void setLiveP2spSwitchLagThresholdMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mPlayer.setOption(1, "live-p2sp-switch-lag-threshold-ms", i2);
        }
    }

    public void setLiveP2spSwitchMaxCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mPlayer.setOption(1, "live-p2sp-switch-max-count", i2);
        }
    }

    public void setLiveP2spSwitchOffBufferThresholdMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mPlayer.setOption(1, "live-p2sp-switch-off-buffer-threshold-ms", i2);
        }
    }

    public void setLiveP2spSwitchOnBufferHoldThresholdMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mPlayer.setOption(1, "live-p2sp-switch-on-buffer-hold-threshold-ms", i2);
        }
    }

    public void setLiveP2spSwitchOnBufferThresholdMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mPlayer.setOption(1, "live-p2sp-switch-on-buffer-threshold-ms", i2);
        }
    }

    public void setMaxSpeedKbps(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mPlayer.setOption(1, "max-speed-kbps", i2);
        }
    }

    public void setTcpConnectionReuse(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mPlayer.setOption(1, "tcp-connection-reuse", i2);
        }
    }

    public void setTcpConnectionReuseMaxage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mPlayer.setOption(1, "tcp-connection-reuse-maxage", i2);
        }
    }

    public void setTcpKeepaliveIdle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.mPlayer.setOption(1, "tcp-keepalive-idle", i2);
        }
    }

    public void setTcpKeepaliveInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.mPlayer.setOption(1, "tcp-keepalive-interval", i2);
        }
    }

    public void setUpstreamType(@AwesomeCache.UpstreamType int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mPlayer.setOption(1, "upstream-type", i2);
        }
    }

    public void setVodP2spCdnRequestInitialSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mPlayer.setOption(1, "vod-p2sp-cdn-request-initial-size", i2);
        }
    }

    public void setVodP2spCdnRequestMaxSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.mPlayer.setOption(1, "vod-p2sp-cdn-request-max-size", i2);
        }
    }

    public void setVodP2spDisable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.mPlayer.setOption(1, "vod-p2sp-disable", "1");
        }
    }

    public void setVodP2spHoleIgnoreSpeedcal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mPlayer.setOption(1, "vod-p2sp-hole-ignore-speedcal", z ? 1L : 0L);
        }
    }

    public void setVodP2spOffThreshold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.mPlayer.setOption(1, "vod-p2sp-off-threshold", i2);
        }
    }

    public void setVodP2spOnThreshold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.mPlayer.setOption(1, "vod-p2sp-on-threshold", i2);
        }
    }

    public void setVodP2spPolicy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.mPlayer.setOption(1, "vod-p2sp-policy", str);
        }
    }

    public void setVodP2spTaskMaxSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.mPlayer.setOption(1, "vod-p2sp-task-max-size", i2);
        }
    }

    public void setVodP2spTaskTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.mPlayer.setOption(1, "vod-p2sp-task-timeout", i2);
        }
    }

    public void setupListener() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.mCacheSessionListener == null) {
            return;
        }
        this.mCacheSessionListenerInnerBridge = new CacheSessionListener(this) { // from class: com.kwai.video.player.kwai_player.AspectAwesomeCache.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AspectAwesomeCache this$0;

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
            public void onDownloadStarted(long j, String str, String str2, String str3, int i2, long j2) {
                CacheSessionListener cacheSessionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, str2, str3, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (cacheSessionListener = this.this$0.mCacheSessionListener) == null) {
                    return;
                }
                cacheSessionListener.onDownloadStarted(j, str, str2, str3, i2, j2);
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onDownloadStopped(int i2, long j, long j2, String str, int i3, String str2, String str3, String str4, String str5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i3), str2, str3, str4, str5}) == null) {
                    if (this.this$0.mCacheSessionListener != null) {
                        this.this$0.mCacheSessionListener.onDownloadStopped(i2, j, j2, str, i3, str2, str3, str4, str5);
                    } else {
                        Timber.e("onDownloadStopped, listener = null", new Object[0]);
                    }
                }
            }

            @Override // com.kwai.video.cache.CacheSessionListener
            public void onSessionClosed(int i2, long j, long j2, long j3, String str, boolean z) {
                CacheSessionListener cacheSessionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Boolean.valueOf(z)}) == null) || (cacheSessionListener = this.this$0.mCacheSessionListener) == null) {
                    return;
                }
                cacheSessionListener.onSessionClosed(i2, j, j2, j3, str, z);
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
        this.mPlayer._setupCacheSessionListener(new WeakReference(this.mCacheSessionListenerInnerBridge));
    }
}
