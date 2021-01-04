package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.PlayerSettingConstants;
/* loaded from: classes5.dex */
public final class KwaiPlayerVodBuilder extends KwaiPlayerBaseBuilder<KwaiPlayerVodBuilder> {
    private long mAbLoopEndMs;
    private long mAbLoopStartMs;
    private long mAppStartTime;
    private String mAudioStr;
    private String mCacheKey;
    private Context mContext;
    private boolean mDccAlgEnable;
    private int mDccAlgPreReadMs;
    private boolean mDisableVodAudio;
    private boolean mEnableAccurateSeek;
    private boolean mEnableAudioGain;
    private boolean mEnableCacheSeek;
    private boolean mEnableSeekForwardOffset;
    private boolean mEnableVodAdaptive;
    private int mManifestType;
    private long mPreLoadDurationMs;
    private int mPreLoadVer;
    private long mSeekAtStart;
    private int mSpbBufferMs;
    private int mSpbMaxBufferCostMs;
    private int mSwitchCode;
    private int mTh_10;
    private boolean mUseSpbBuffer;
    private boolean mVodManifestEnable;
    private long mVodManifestHeight;
    private int mVodManifestLowDevice;
    private int mVodManifestMaxResolution;
    private int mVodManifestNetType;
    private String mVodManifestRateConfig;
    private int mVodManifestSignalStrength;
    private long mVodManifestWidth;
    int mVodMaxBufferStrategy;

    public KwaiPlayerVodBuilder(Context context) {
        super(context);
        this.mPreLoadVer = 1;
        this.mPreLoadDurationMs = 0L;
        this.mAbLoopStartMs = 0L;
        this.mAbLoopEndMs = 0L;
        this.mAppStartTime = 0L;
        this.mSeekAtStart = 0L;
        this.mEnableAccurateSeek = false;
        this.mEnableSeekForwardOffset = true;
        this.mEnableCacheSeek = true;
        this.mEnableAudioGain = false;
        this.mAudioStr = "0";
        this.mDisableVodAudio = false;
        this.mEnableVodAdaptive = false;
        this.mUseSpbBuffer = false;
        this.mSpbBufferMs = 1000;
        this.mSpbMaxBufferCostMs = 500;
        this.mDccAlgEnable = false;
        this.mTh_10 = 100;
        this.mDccAlgPreReadMs = 5000;
        this.mVodManifestEnable = false;
        this.mVodManifestWidth = 0L;
        this.mVodManifestHeight = 0L;
        this.mVodManifestNetType = 0;
        this.mVodManifestRateConfig = "";
        this.mVodManifestLowDevice = 0;
        this.mVodManifestSignalStrength = 0;
        this.mSwitchCode = 0;
        this.mVodManifestMaxResolution = 0;
        this.mManifestType = 0;
        this.mVodMaxBufferStrategy = -1;
        this.mUseNatvieCache = false;
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    public void applyTo(KwaiMediaPlayer kwaiMediaPlayer) {
        super.applyTo(kwaiMediaPlayer);
        Timber.d("applyTo", new Object[0]);
        kwaiMediaPlayer.setupAspectLiveRealTimeReporter(false, null);
        kwaiMediaPlayer.getAspectAwesomeCache().setCacheKey(this.mCacheKey);
        if (this.mPreLoadDurationMs > 0) {
            kwaiMediaPlayer._enablePreDemux(this.mPreLoadVer, this.mPreLoadDurationMs);
        }
        if (this.mAbLoopEndMs > 0) {
            kwaiMediaPlayer._enableAbLoop(this.mAbLoopStartMs, this.mAbLoopEndMs);
        }
        if (this.mSeekAtStart > 0) {
            kwaiMediaPlayer.setOption(4, "seek-at-start", this.mSeekAtStart);
        }
        if (this.mDisableVodAudio) {
            kwaiMediaPlayer.setOption(4, "an", 1L);
        }
        kwaiMediaPlayer.setOption(4, "dcc-alg.config_enabled", this.mDccAlgEnable ? 1L : 0L);
        if (this.mDccAlgEnable) {
            kwaiMediaPlayer.setOption(4, "dcc-alg.config_mark_bitrate_th_10", this.mTh_10);
            kwaiMediaPlayer.setOption(4, "dcc-alg.config_dcc_pre_read_ms", this.mDccAlgPreReadMs);
        }
        if (this.mUseSpbBuffer) {
            kwaiMediaPlayer._setStartPlayBlockBufferMs(this.mSpbBufferMs, this.mSpbMaxBufferCostMs);
        }
        if (this.mVodMaxBufferStrategy > 0) {
            kwaiMediaPlayer.setOption(4, "dcc.max-buffer-strategy", this.mVodMaxBufferStrategy);
        }
        kwaiMediaPlayer.setOption(4, "app-start-time", this.mAppStartTime);
        kwaiMediaPlayer.setOption(4, "islive", 0L);
        kwaiMediaPlayer.setOption(4, "framedrop", 8L);
        kwaiMediaPlayer.setOption(4, "enable-accurate-seek", this.mEnableAccurateSeek ? 1L : 0L);
        kwaiMediaPlayer.setOption(4, "enable-seek-forward-offset", this.mEnableSeekForwardOffset ? 1L : 0L);
        kwaiMediaPlayer.setOption(4, "enable-cache-seek", this.mEnableCacheSeek ? 1L : 0L);
        if (this.mVodManifestEnable) {
            kwaiMediaPlayer.setOption(4, "enable-vod-manifest", 1L);
            kwaiMediaPlayer.setOption(1, "device-resolution-width", this.mVodManifestWidth);
            kwaiMediaPlayer.setOption(1, "device-resolution-height", this.mVodManifestHeight);
            kwaiMediaPlayer.setOption(1, "device-network-type", this.mVodManifestNetType);
            kwaiMediaPlayer.setOption(1, "abr-config-string", this.mVodManifestRateConfig);
            kwaiMediaPlayer.setOption(1, "low-device", this.mVodManifestLowDevice);
            kwaiMediaPlayer.setOption(1, "signal-strength", this.mVodManifestSignalStrength);
            kwaiMediaPlayer.setOption(1, "switch-code", this.mSwitchCode);
            kwaiMediaPlayer.setOption(1, "adaptive-max-resolution", this.mVodManifestMaxResolution);
            kwaiMediaPlayer.setOption(1, "manifest_type", this.mManifestType);
            kwaiMediaPlayer.setIsVodAdaptive(true);
        }
        if (this.mEnableAudioGain) {
            kwaiMediaPlayer.setOption(4, "audio-gain.enable", this.mEnableAudioGain ? 1L : 0L);
            kwaiMediaPlayer.setOption(4, "audio-gain.audio_str", this.mAudioStr);
        }
        if (this.mEnableVodAdaptive) {
            kwaiMediaPlayer.setOption(1, "enable-adaptive", 1L);
            kwaiMediaPlayer.setupAspectKwaiVodAdaptive(this.mEnableVodAdaptive);
        }
    }

    public IKwaiMediaPlayer build() {
        KwaiMediaPlayer kwaiMediaPlayer = new KwaiMediaPlayer();
        kwaiMediaPlayer.setIsLive(false);
        applyTo(kwaiMediaPlayer);
        return kwaiMediaPlayer;
    }

    public KwaiPlayerVodBuilder seekAtStart(long j) {
        this.mSeekAtStart = j;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    public KwaiPlayerVodBuilder self() {
        return this;
    }

    public KwaiPlayerVodBuilder setAbLoop(long j, long j2) {
        this.mAbLoopStartMs = j;
        this.mAbLoopEndMs = j2;
        return this;
    }

    public KwaiPlayerVodBuilder setCacheKey(String str) {
        this.mCacheKey = str;
        return this;
    }

    public KwaiPlayerVodBuilder setDccAlgMBTh_10(int i) {
        this.mTh_10 = i;
        return this;
    }

    public KwaiPlayerVodBuilder setDccAlgPreReadMs(int i) {
        this.mDccAlgPreReadMs = i;
        return this;
    }

    public KwaiPlayerVodBuilder setDccAlgorithm(boolean z) {
        this.mDccAlgEnable = z;
        return this;
    }

    public KwaiPlayerVodBuilder setDisableVodAudio(boolean z) {
        this.mDisableVodAudio = z;
        return this;
    }

    public KwaiPlayerVodBuilder setEnableAccurateSeek(boolean z) {
        this.mEnableAccurateSeek = z;
        return this;
    }

    public KwaiPlayerVodBuilder setEnableAudioGain(boolean z, @Nullable String str) {
        this.mEnableAudioGain = z;
        if (TextUtils.isEmpty(str)) {
            this.mAudioStr = "0";
        } else {
            this.mAudioStr = str;
        }
        return this;
    }

    public KwaiPlayerVodBuilder setEnableCacheSeek(boolean z) {
        this.mEnableCacheSeek = z;
        return this;
    }

    public KwaiPlayerVodBuilder setEnableSeekForwardOffset(boolean z) {
        this.mEnableSeekForwardOffset = z;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    public KwaiPlayerVodBuilder setEnableVodAdaptive(boolean z) {
        this.mEnableVodAdaptive = z;
        return this;
    }

    public KwaiPlayerVodBuilder setManifestType(int i) {
        this.mManifestType = i;
        return this;
    }

    public KwaiPlayerVodBuilder setMaxBufferStrategy(@PlayerSettingConstants.MaxBufferStrategy int i) {
        if (i >= 1 && i <= 2) {
            this.mVodMaxBufferStrategy = i;
        }
        return this;
    }

    public KwaiPlayerVodBuilder setPreLoadDurationMs(int i, long j) {
        this.mPreLoadVer = i;
        this.mPreLoadDurationMs = j;
        return this;
    }

    public KwaiPlayerVodBuilder setStartPlayBlockBufferMs(int i, int i2) {
        this.mUseSpbBuffer = true;
        this.mSpbBufferMs = i;
        this.mSpbMaxBufferCostMs = i2;
        return this;
    }

    public KwaiPlayerVodBuilder setStartTime(long j) {
        this.mAppStartTime = j;
        return this;
    }

    public KwaiPlayerVodBuilder setVodManifest(int i, long j, long j2, String str, int i2, int i3) {
        this.mVodManifestEnable = true;
        this.mVodManifestHeight = j2;
        this.mVodManifestWidth = j;
        this.mVodManifestNetType = i;
        this.mVodManifestRateConfig = str;
        this.mVodManifestLowDevice = i2;
        this.mVodManifestSignalStrength = i3;
        return this;
    }

    public KwaiPlayerVodBuilder setVodManifestMaxResolution(int i) {
        this.mVodManifestMaxResolution = i;
        return this;
    }

    public KwaiPlayerVodBuilder setVodManifestSwitchCode(int i) {
        this.mSwitchCode = i;
        return this;
    }
}
