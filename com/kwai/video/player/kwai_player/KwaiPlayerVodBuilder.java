package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.sys.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.PlayerSettingConstants;
/* loaded from: classes7.dex */
public final class KwaiPlayerVodBuilder extends KwaiPlayerBaseBuilder<KwaiPlayerVodBuilder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KwaiPlayerVodBuilder(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kwaiMediaPlayer) == null) {
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
                kwaiMediaPlayer.setOption(4, a.f1936i, 1L);
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
    }

    public IKwaiMediaPlayer build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            KwaiMediaPlayer kwaiMediaPlayer = new KwaiMediaPlayer();
            kwaiMediaPlayer.setIsLive(false);
            applyTo(kwaiMediaPlayer);
            return kwaiMediaPlayer;
        }
        return (IKwaiMediaPlayer) invokeV.objValue;
    }

    public KwaiPlayerVodBuilder seekAtStart(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            this.mSeekAtStart = j;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    public KwaiPlayerVodBuilder self() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (KwaiPlayerVodBuilder) invokeV.objValue;
    }

    public KwaiPlayerVodBuilder setAbLoop(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            this.mAbLoopStartMs = j;
            this.mAbLoopEndMs = j2;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeCommon.objValue;
    }

    public KwaiPlayerVodBuilder setCacheKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.mCacheKey = str;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeL.objValue;
    }

    public KwaiPlayerVodBuilder setDccAlgMBTh_10(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.mTh_10 = i2;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeI.objValue;
    }

    public KwaiPlayerVodBuilder setDccAlgPreReadMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.mDccAlgPreReadMs = i2;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeI.objValue;
    }

    public KwaiPlayerVodBuilder setDccAlgorithm(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.mDccAlgEnable = z;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeZ.objValue;
    }

    public KwaiPlayerVodBuilder setDisableVodAudio(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.mDisableVodAudio = z;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeZ.objValue;
    }

    public KwaiPlayerVodBuilder setEnableAccurateSeek(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.mEnableAccurateSeek = z;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeZ.objValue;
    }

    public KwaiPlayerVodBuilder setEnableAudioGain(boolean z, @Nullable String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048588, this, z, str)) == null) {
            this.mEnableAudioGain = z;
            if (TextUtils.isEmpty(str)) {
                this.mAudioStr = "0";
            } else {
                this.mAudioStr = str;
            }
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeZL.objValue;
    }

    public KwaiPlayerVodBuilder setEnableCacheSeek(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            this.mEnableCacheSeek = z;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeZ.objValue;
    }

    public KwaiPlayerVodBuilder setEnableSeekForwardOffset(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            this.mEnableSeekForwardOffset = z;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    public KwaiPlayerVodBuilder setEnableVodAdaptive(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            this.mEnableVodAdaptive = z;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeZ.objValue;
    }

    public KwaiPlayerVodBuilder setManifestType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            this.mManifestType = i2;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeI.objValue;
    }

    public KwaiPlayerVodBuilder setMaxBufferStrategy(@PlayerSettingConstants.MaxBufferStrategy int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (i2 >= 1 && i2 <= 2) {
                this.mVodMaxBufferStrategy = i2;
            }
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeI.objValue;
    }

    public KwaiPlayerVodBuilder setPreLoadDurationMs(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            this.mPreLoadVer = i2;
            this.mPreLoadDurationMs = j;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeCommon.objValue;
    }

    public KwaiPlayerVodBuilder setStartPlayBlockBufferMs(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
            this.mUseSpbBuffer = true;
            this.mSpbBufferMs = i2;
            this.mSpbMaxBufferCostMs = i3;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeII.objValue;
    }

    public KwaiPlayerVodBuilder setStartTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j)) == null) {
            this.mAppStartTime = j;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeJ.objValue;
    }

    public KwaiPlayerVodBuilder setVodManifest(int i2, long j, long j2, String str, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            this.mVodManifestEnable = true;
            this.mVodManifestHeight = j2;
            this.mVodManifestWidth = j;
            this.mVodManifestNetType = i2;
            this.mVodManifestRateConfig = str;
            this.mVodManifestLowDevice = i3;
            this.mVodManifestSignalStrength = i4;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeCommon.objValue;
    }

    public KwaiPlayerVodBuilder setVodManifestMaxResolution(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            this.mVodManifestMaxResolution = i2;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeI.objValue;
    }

    public KwaiPlayerVodBuilder setVodManifestSwitchCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            this.mSwitchCode = i2;
            return this;
        }
        return (KwaiPlayerVodBuilder) invokeI.objValue;
    }
}
