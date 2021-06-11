package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alipay.sdk.sys.a;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.PlayerSettingConstants;
/* loaded from: classes7.dex */
public final class KwaiPlayerVodBuilder extends KwaiPlayerBaseBuilder<KwaiPlayerVodBuilder> {
    public long mAbLoopEndMs;
    public long mAbLoopStartMs;
    public long mAppStartTime;
    public String mAudioStr;
    public String mCacheKey;
    public Context mContext;
    public boolean mDccAlgEnable;
    public int mDccAlgPreReadMs;
    public boolean mDisableVodAudio;
    public boolean mEnableAccurateSeek;
    public boolean mEnableAudioGain;
    public boolean mEnableCacheSeek;
    public boolean mEnableSeekForwardOffset;
    public boolean mEnableVodAdaptive;
    public int mManifestType;
    public long mPreLoadDurationMs;
    public int mPreLoadVer;
    public long mSeekAtStart;
    public int mSpbBufferMs;
    public int mSpbMaxBufferCostMs;
    public int mSwitchCode;
    public int mTh_10;
    public boolean mUseSpbBuffer;
    public boolean mVodManifestEnable;
    public long mVodManifestHeight;
    public int mVodManifestLowDevice;
    public int mVodManifestMaxResolution;
    public int mVodManifestNetType;
    public String mVodManifestRateConfig;
    public int mVodManifestSignalStrength;
    public long mVodManifestWidth;
    public int mVodMaxBufferStrategy;

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

    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    public void applyTo(KwaiMediaPlayer kwaiMediaPlayer) {
        super.applyTo(kwaiMediaPlayer);
        Timber.d("applyTo", new Object[0]);
        kwaiMediaPlayer.setupAspectLiveRealTimeReporter(false, null);
        kwaiMediaPlayer.getAspectAwesomeCache().setCacheKey(this.mCacheKey);
        long j = this.mPreLoadDurationMs;
        if (j > 0) {
            kwaiMediaPlayer._enablePreDemux(this.mPreLoadVer, j);
        }
        long j2 = this.mAbLoopEndMs;
        if (j2 > 0) {
            kwaiMediaPlayer._enableAbLoop(this.mAbLoopStartMs, j2);
        }
        long j3 = this.mSeekAtStart;
        if (j3 > 0) {
            kwaiMediaPlayer.setOption(4, "seek-at-start", j3);
        }
        if (this.mDisableVodAudio) {
            kwaiMediaPlayer.setOption(4, a.f1933i, 1L);
        }
        kwaiMediaPlayer.setOption(4, "dcc-alg.config_enabled", this.mDccAlgEnable ? 1L : 0L);
        if (this.mDccAlgEnable) {
            kwaiMediaPlayer.setOption(4, "dcc-alg.config_mark_bitrate_th_10", this.mTh_10);
            kwaiMediaPlayer.setOption(4, "dcc-alg.config_dcc_pre_read_ms", this.mDccAlgPreReadMs);
        }
        if (this.mUseSpbBuffer) {
            kwaiMediaPlayer._setStartPlayBlockBufferMs(this.mSpbBufferMs, this.mSpbMaxBufferCostMs);
        }
        int i2 = this.mVodMaxBufferStrategy;
        if (i2 > 0) {
            kwaiMediaPlayer.setOption(4, "dcc.max-buffer-strategy", i2);
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
        boolean z = this.mEnableAudioGain;
        if (z) {
            kwaiMediaPlayer.setOption(4, "audio-gain.enable", z ? 1L : 0L);
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

    public KwaiPlayerVodBuilder setDccAlgMBTh_10(int i2) {
        this.mTh_10 = i2;
        return this;
    }

    public KwaiPlayerVodBuilder setDccAlgPreReadMs(int i2) {
        this.mDccAlgPreReadMs = i2;
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

    public KwaiPlayerVodBuilder setManifestType(int i2) {
        this.mManifestType = i2;
        return this;
    }

    public KwaiPlayerVodBuilder setMaxBufferStrategy(@PlayerSettingConstants.MaxBufferStrategy int i2) {
        if (i2 >= 1 && i2 <= 2) {
            this.mVodMaxBufferStrategy = i2;
        }
        return this;
    }

    public KwaiPlayerVodBuilder setPreLoadDurationMs(int i2, long j) {
        this.mPreLoadVer = i2;
        this.mPreLoadDurationMs = j;
        return this;
    }

    public KwaiPlayerVodBuilder setStartPlayBlockBufferMs(int i2, int i3) {
        this.mUseSpbBuffer = true;
        this.mSpbBufferMs = i2;
        this.mSpbMaxBufferCostMs = i3;
        return this;
    }

    public KwaiPlayerVodBuilder setStartTime(long j) {
        this.mAppStartTime = j;
        return this;
    }

    public KwaiPlayerVodBuilder setVodManifest(int i2, long j, long j2, String str, int i3, int i4) {
        this.mVodManifestEnable = true;
        this.mVodManifestHeight = j2;
        this.mVodManifestWidth = j;
        this.mVodManifestNetType = i2;
        this.mVodManifestRateConfig = str;
        this.mVodManifestLowDevice = i3;
        this.mVodManifestSignalStrength = i4;
        return this;
    }

    public KwaiPlayerVodBuilder setVodManifestMaxResolution(int i2) {
        this.mVodManifestMaxResolution = i2;
        return this;
    }

    public KwaiPlayerVodBuilder setVodManifestSwitchCode(int i2) {
        this.mSwitchCode = i2;
        return this;
    }
}
