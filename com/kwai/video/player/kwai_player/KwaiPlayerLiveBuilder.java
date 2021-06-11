package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.player.KwaiPlayerConfig;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.PlayerProps;
/* loaded from: classes7.dex */
public final class KwaiPlayerLiveBuilder extends KwaiPlayerBaseBuilder<KwaiPlayerLiveBuilder> {
    public float mBufferTimeMaxSec;
    public String mConfigJson;
    public boolean mIsLiveManifest;
    public KwaiPlayerConfig mKwaiPlayerConfig;
    public String mLiveLowDelayConfigJson;
    public int mNetType;
    public int mSpbBufferMs;
    public int mSpbMaxBufferCostMs;
    public boolean mUseAlignedPts;
    public boolean mUseSpbBuffer;

    public KwaiPlayerLiveBuilder(Context context) {
        super(context);
        this.mBufferTimeMaxSec = 5.0f;
        this.mNetType = 0;
        this.mIsLiveManifest = false;
        this.mUseAlignedPts = true;
        this.mUseSpbBuffer = false;
        this.mSpbBufferMs = 500;
        this.mSpbMaxBufferCostMs = 1000;
        this.mUseNatvieCache = false;
    }

    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    public void applyTo(KwaiMediaPlayer kwaiMediaPlayer) {
        super.applyTo(kwaiMediaPlayer);
        Timber.d("applyTo", new Object[0]);
        KwaiPlayerConfig kwaiPlayerConfig = this.mKwaiPlayerConfig;
        if (kwaiPlayerConfig != null) {
            kwaiMediaPlayer.setupAspectLiveRealTimeReporter(true, kwaiPlayerConfig);
            kwaiMediaPlayer.setConfig(this.mKwaiPlayerConfig);
        } else {
            kwaiMediaPlayer.setupAspectLiveRealTimeReporter(false, null);
        }
        if (!TextUtils.isEmpty(this.mConfigJson)) {
            kwaiMediaPlayer._setConfigJson(this.mConfigJson);
        }
        if (!TextUtils.isEmpty(this.mLiveLowDelayConfigJson)) {
            kwaiMediaPlayer._setLiveLowDelayConfigJson(this.mLiveLowDelayConfigJson);
        }
        kwaiMediaPlayer.setupAspectNativeCache(this.mUseNatvieCache);
        if (this.mUseNatvieCache) {
            kwaiMediaPlayer.getAspectAwesomeCache().setDataSourceType(1);
        }
        if (this.mUseAlignedPts) {
            kwaiMediaPlayer.setOption(4, "use-aligned-pts", 1L);
        }
        if (this.mUseSpbBuffer) {
            kwaiMediaPlayer._setStartPlayBlockBufferMs(this.mSpbBufferMs, this.mSpbMaxBufferCostMs);
        }
        kwaiMediaPlayer.setOption(4, "islive", 1L);
        kwaiMediaPlayer.setOption(4, "framedrop", 150L);
        kwaiMediaPlayer._setPropertyFloat(PlayerProps.FFP_PROP_FLOAT_BUFFERSIZE_MAX, this.mBufferTimeMaxSec);
        int i2 = this.mNetType;
        if (i2 > 0) {
            kwaiMediaPlayer.setOption(1, "device-network-type", i2);
        }
        kwaiMediaPlayer.setupAspectKlv(this.mIsLiveManifest);
    }

    public IKwaiMediaPlayer build() {
        KwaiMediaPlayer kwaiMediaPlayer = new KwaiMediaPlayer();
        kwaiMediaPlayer.setIsLive(true);
        applyTo(kwaiMediaPlayer);
        return kwaiMediaPlayer;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    public KwaiPlayerLiveBuilder self() {
        return this;
    }

    public KwaiPlayerLiveBuilder setAdaptiveNetType(int i2) {
        this.mNetType = i2;
        return this;
    }

    public KwaiPlayerLiveBuilder setBufferTimeMaxSec(float f2) {
        this.mBufferTimeMaxSec = f2;
        return this;
    }

    public KwaiPlayerLiveBuilder setConfigJson(String str) {
        this.mConfigJson = str;
        return this;
    }

    public KwaiPlayerLiveBuilder setIsLiveManifest(boolean z) {
        this.mIsLiveManifest = z;
        return this;
    }

    public KwaiPlayerLiveBuilder setKwaiPlayerConfig(KwaiPlayerConfig kwaiPlayerConfig) {
        this.mKwaiPlayerConfig = kwaiPlayerConfig;
        return this;
    }

    public KwaiPlayerLiveBuilder setLiveLowDelayConfigJson(String str) {
        this.mLiveLowDelayConfigJson = str;
        return this;
    }

    public KwaiPlayerLiveBuilder setStartPlayBlockBufferMs(int i2, int i3) {
        this.mUseSpbBuffer = true;
        this.mSpbBufferMs = i2;
        this.mSpbMaxBufferCostMs = i3;
        return this;
    }

    public KwaiPlayerLiveBuilder setUseAlignedPts(boolean z) {
        this.mUseAlignedPts = z;
        return this;
    }
}
