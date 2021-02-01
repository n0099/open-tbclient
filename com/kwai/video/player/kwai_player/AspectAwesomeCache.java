package com.kwai.video.player.kwai_player;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.cache.CacheSessionListener;
import com.kwai.video.hodor.util.Timber;
import java.lang.ref.WeakReference;
@Keep
/* loaded from: classes3.dex */
public class AspectAwesomeCache {
    private AwesomeCacheCallback mAwesomeCacheCallback;
    @Nullable
    private CacheSessionListener mCacheSessionListener;
    private CacheSessionListener mCacheSessionListenerInnerBridge;
    @NonNull
    private final KwaiMediaPlayer mPlayer;

    public AspectAwesomeCache(@NonNull KwaiMediaPlayer kwaiMediaPlayer, boolean z) {
        this.mPlayer = kwaiMediaPlayer;
        setEnableHodor(z);
    }

    private void setEnableHodor(boolean z) {
        this.mPlayer.setOption(4, "cache-enabled", z ? 1L : 0L);
    }

    public void release() {
        this.mAwesomeCacheCallback = null;
    }

    public void setAegonMTRequestDelayTime(int i) {
        this.mPlayer.setOption(1, "mt_request_delay_ms", i < 0 ? -1L : i);
    }

    public void setAwesomeCacheCallback(@NonNull AwesomeCacheCallback awesomeCacheCallback) {
        this.mAwesomeCacheCallback = awesomeCacheCallback;
        this.mPlayer._setAwesomeCacheCallback(awesomeCacheCallback);
    }

    public void setBufferedDataSourceSizeKB(int i) {
        this.mPlayer.setOption(1, "buffered-datasource-size-kb", i);
    }

    public void setCacheDownloadConnectTimeoutMs(int i) {
        this.mPlayer.setOption(1, "cache-connect-timeout-ms", i);
    }

    public void setCacheDownloadReadTimeoutMs(int i) {
        this.mPlayer.setOption(1, "cache-read-timeout-ms", i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCacheKey(String str) {
        this.mPlayer.setOption(4, "cache-key", str);
    }

    public void setCacheProgressCallbackIntervalMs(int i) {
        this.mPlayer.setOption(1, "progress_cb_interval_ms", i);
    }

    public void setCacheSessionListener(CacheSessionListener cacheSessionListener) {
        if (this.mCacheSessionListener != null) {
            throw new IllegalStateException("should not setCacheSessionListener twice");
        }
        this.mCacheSessionListener = cacheSessionListener;
        setupListener();
    }

    public void setCacheSocketBufferSizeKb(int i) {
        this.mPlayer.setOption(1, "cache-socket-buf-size-kb", i);
    }

    public void setDataSourceSeekReopenThresholdKB(int i) {
        this.mPlayer.setOption(1, "datasource-seek-reopen-threshold-kb", i);
    }

    public void setDataSourceType(@AwesomeCache.DataSourceType int i) {
        this.mPlayer.setOption(1, "data-source-type", i);
    }

    public void setEnableHttpdns(boolean z) {
        this.mPlayer.setOption(1, "enable_httpdns_in_hodor", z ? 1L : 0L);
    }

    public void setLiveP2spSwitchCooldownMs(int i) {
        this.mPlayer.setOption(1, "live-p2sp-switch-cooldown-ms", i);
    }

    public void setLiveP2spSwitchLagThresholdMs(int i) {
        this.mPlayer.setOption(1, "live-p2sp-switch-lag-threshold-ms", i);
    }

    public void setLiveP2spSwitchMaxCount(int i) {
        this.mPlayer.setOption(1, "live-p2sp-switch-max-count", i);
    }

    public void setLiveP2spSwitchOffBufferThresholdMs(int i) {
        this.mPlayer.setOption(1, "live-p2sp-switch-off-buffer-threshold-ms", i);
    }

    public void setLiveP2spSwitchOnBufferHoldThresholdMs(int i) {
        this.mPlayer.setOption(1, "live-p2sp-switch-on-buffer-hold-threshold-ms", i);
    }

    public void setLiveP2spSwitchOnBufferThresholdMs(int i) {
        this.mPlayer.setOption(1, "live-p2sp-switch-on-buffer-threshold-ms", i);
    }

    public void setMaxSpeedKbps(int i) {
        this.mPlayer.setOption(1, "max-speed-kbps", i);
    }

    public void setTcpConnectionReuse(int i) {
        this.mPlayer.setOption(1, "tcp-connection-reuse", i);
    }

    public void setTcpConnectionReuseMaxage(int i) {
        this.mPlayer.setOption(1, "tcp-connection-reuse-maxage", i);
    }

    public void setTcpKeepaliveIdle(int i) {
        this.mPlayer.setOption(1, "tcp-keepalive-idle", i);
    }

    public void setTcpKeepaliveInterval(int i) {
        this.mPlayer.setOption(1, "tcp-keepalive-interval", i);
    }

    public void setUpstreamType(@AwesomeCache.UpstreamType int i) {
        this.mPlayer.setOption(1, "upstream-type", i);
    }

    public void setVodP2spCdnRequestInitialSize(int i) {
        this.mPlayer.setOption(1, "vod-p2sp-cdn-request-initial-size", i);
    }

    public void setVodP2spCdnRequestMaxSize(int i) {
        this.mPlayer.setOption(1, "vod-p2sp-cdn-request-max-size", i);
    }

    public void setVodP2spDisable() {
        this.mPlayer.setOption(1, "vod-p2sp-disable", "1");
    }

    public void setVodP2spHoleIgnoreSpeedcal(boolean z) {
        this.mPlayer.setOption(1, "vod-p2sp-hole-ignore-speedcal", z ? 1L : 0L);
    }

    public void setVodP2spOffThreshold(int i) {
        this.mPlayer.setOption(1, "vod-p2sp-off-threshold", i);
    }

    public void setVodP2spOnThreshold(int i) {
        this.mPlayer.setOption(1, "vod-p2sp-on-threshold", i);
    }

    public void setVodP2spPolicy(String str) {
        this.mPlayer.setOption(1, "vod-p2sp-policy", str);
    }

    public void setVodP2spTaskMaxSize(int i) {
        this.mPlayer.setOption(1, "vod-p2sp-task-max-size", i);
    }

    public void setVodP2spTaskTimeout(int i) {
        this.mPlayer.setOption(1, "vod-p2sp-task-timeout", i);
    }

    public void setupListener() {
        if (this.mCacheSessionListener != null) {
            this.mCacheSessionListenerInnerBridge = new CacheSessionListener() { // from class: com.kwai.video.player.kwai_player.AspectAwesomeCache.1
                @Override // com.kwai.video.cache.CacheSessionListener
                public void onDownloadPaused() {
                    CacheSessionListener cacheSessionListener = AspectAwesomeCache.this.mCacheSessionListener;
                    if (cacheSessionListener != null) {
                        cacheSessionListener.onDownloadPaused();
                    }
                }

                @Override // com.kwai.video.cache.CacheSessionListener
                public void onDownloadProgress(long j, long j2) {
                    CacheSessionListener cacheSessionListener = AspectAwesomeCache.this.mCacheSessionListener;
                    if (cacheSessionListener != null) {
                        cacheSessionListener.onDownloadProgress(j, j2);
                    }
                }

                @Override // com.kwai.video.cache.CacheSessionListener
                public void onDownloadResumed() {
                    CacheSessionListener cacheSessionListener = AspectAwesomeCache.this.mCacheSessionListener;
                    if (cacheSessionListener != null) {
                        cacheSessionListener.onDownloadResumed();
                    }
                }

                @Override // com.kwai.video.cache.CacheSessionListener
                public void onDownloadStarted(long j, String str, String str2, String str3, int i, long j2) {
                    CacheSessionListener cacheSessionListener = AspectAwesomeCache.this.mCacheSessionListener;
                    if (cacheSessionListener != null) {
                        cacheSessionListener.onDownloadStarted(j, str, str2, str3, i, j2);
                    }
                }

                @Override // com.kwai.video.cache.CacheSessionListener
                public void onDownloadStopped(int i, long j, long j2, String str, int i2, String str2, String str3, String str4, String str5) {
                    if (AspectAwesomeCache.this.mCacheSessionListener != null) {
                        AspectAwesomeCache.this.mCacheSessionListener.onDownloadStopped(i, j, j2, str, i2, str2, str3, str4, str5);
                    } else {
                        Timber.e("onDownloadStopped, listener = null", new Object[0]);
                    }
                }

                @Override // com.kwai.video.cache.CacheSessionListener
                public void onSessionClosed(int i, long j, long j2, long j3, String str, boolean z) {
                    CacheSessionListener cacheSessionListener = AspectAwesomeCache.this.mCacheSessionListener;
                    if (cacheSessionListener != null) {
                        cacheSessionListener.onSessionClosed(i, j, j2, j3, str, z);
                    }
                }

                @Override // com.kwai.video.cache.CacheSessionListener
                public void onSessionStart(String str, long j, long j2, long j3) {
                    CacheSessionListener cacheSessionListener = AspectAwesomeCache.this.mCacheSessionListener;
                    if (cacheSessionListener != null) {
                        cacheSessionListener.onSessionStart(str, j, j2, j3);
                    }
                }
            };
            this.mPlayer._setupCacheSessionListener(new WeakReference(this.mCacheSessionListenerInnerBridge));
        }
    }
}
