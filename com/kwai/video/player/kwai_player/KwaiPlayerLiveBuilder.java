package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.player.KwaiPlayerConfig;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.PlayerProps;
/* loaded from: classes7.dex */
public final class KwaiPlayerLiveBuilder extends KwaiPlayerBaseBuilder<KwaiPlayerLiveBuilder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KwaiPlayerLiveBuilder(Context context) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kwaiMediaPlayer) == null) {
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
    }

    public IKwaiMediaPlayer build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            KwaiMediaPlayer kwaiMediaPlayer = new KwaiMediaPlayer();
            kwaiMediaPlayer.setIsLive(true);
            applyTo(kwaiMediaPlayer);
            return kwaiMediaPlayer;
        }
        return (IKwaiMediaPlayer) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    public KwaiPlayerLiveBuilder self() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (KwaiPlayerLiveBuilder) invokeV.objValue;
    }

    public KwaiPlayerLiveBuilder setAdaptiveNetType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.mNetType = i2;
            return this;
        }
        return (KwaiPlayerLiveBuilder) invokeI.objValue;
    }

    public KwaiPlayerLiveBuilder setBufferTimeMaxSec(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            this.mBufferTimeMaxSec = f2;
            return this;
        }
        return (KwaiPlayerLiveBuilder) invokeF.objValue;
    }

    public KwaiPlayerLiveBuilder setConfigJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.mConfigJson = str;
            return this;
        }
        return (KwaiPlayerLiveBuilder) invokeL.objValue;
    }

    public KwaiPlayerLiveBuilder setIsLiveManifest(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.mIsLiveManifest = z;
            return this;
        }
        return (KwaiPlayerLiveBuilder) invokeZ.objValue;
    }

    public KwaiPlayerLiveBuilder setKwaiPlayerConfig(KwaiPlayerConfig kwaiPlayerConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kwaiPlayerConfig)) == null) {
            this.mKwaiPlayerConfig = kwaiPlayerConfig;
            return this;
        }
        return (KwaiPlayerLiveBuilder) invokeL.objValue;
    }

    public KwaiPlayerLiveBuilder setLiveLowDelayConfigJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.mLiveLowDelayConfigJson = str;
            return this;
        }
        return (KwaiPlayerLiveBuilder) invokeL.objValue;
    }

    public KwaiPlayerLiveBuilder setStartPlayBlockBufferMs(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            this.mUseSpbBuffer = true;
            this.mSpbBufferMs = i2;
            this.mSpbMaxBufferCostMs = i3;
            return this;
        }
        return (KwaiPlayerLiveBuilder) invokeII.objValue;
    }

    public KwaiPlayerLiveBuilder setUseAlignedPts(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.mUseAlignedPts = z;
            return this;
        }
        return (KwaiPlayerLiveBuilder) invokeZ.objValue;
    }
}
