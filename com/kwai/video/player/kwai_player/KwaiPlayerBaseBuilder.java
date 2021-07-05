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
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.PlayerSettingConstants;
import com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder;
/* loaded from: classes7.dex */
public abstract class KwaiPlayerBaseBuilder<T extends KwaiPlayerBaseBuilder<T>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HEVC_DECODER_NAME_KS265 = "libks265dec";
    public static final String HEVC_DECODER_NAME_KVC = "libkvcdec";
    public static final String HEVC_DECODER_NAME_QY265 = "libqy265dec";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAsyncStreamComponentOpen;
    public int mAudioChannelMode;
    public Context mContext;
    public boolean mEnableAvSyncOpt;
    public boolean mEnableModifyBlock;
    public boolean mEnableSegmentCache;
    public boolean mEnableSoftwareDecodeLimit;
    public boolean mEnableVodAdaptive;
    public int mFFmpegConnectionTimeoutSec;
    public int mFFmpegDataReadTimeoutSec;
    public int mFFmpegSocketRecvBufferSize;
    public int mFFmpegSocketSendBufferSize;
    public int mFadeinEndTimeMs;
    public String mHevcDcoderName;
    public int mInteractiveMode;
    public boolean mIsVR;
    public String mKs265DecExtraParams;
    public int mMaxBufferSizeMb;
    public int mMaxBufferTimeBspMs;
    public int mMaxBufferTimeMs;
    public int mMediaCodecAvcHeightLimit;
    public int mMediaCodecAvcWidthLimit;
    public int mMediaCodecHevcHeightLimit;
    public int mMediaCodecHevcWidthLimit;
    public int mMediaCodecMaxNum;
    @PlayerSettingConstants.OverlayFormat
    public Integer mOverlayFormat;
    public String mOverlayFormatString;
    public ProductContext mProductContext;
    public int mSoftwareDecodeFpsLimit;
    public int mSoftwareDecodeHeightLimit;
    public int mSoftwareDecodeWidthLimit;
    public boolean mStartOnPrepared;
    public int mStereoType;
    @PlayerSettingConstants.UseHardwareDecoderFlag
    public int mUseHardwareDcoderFlag;
    public boolean mUseLibfdkForAac;
    public boolean mUseMediaCodecByteBuffer;
    public boolean mUseMediaCodecDummySurface;
    public boolean mUseNatvieCache;
    public boolean mUseOpenSLES;
    public int mVideoPictureQueueSize;

    public KwaiPlayerBaseBuilder(Context context) {
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
        this.mUseOpenSLES = false;
        this.mOverlayFormat = null;
        this.mOverlayFormatString = null;
        this.mUseMediaCodecDummySurface = false;
        this.mUseHardwareDcoderFlag = 0;
        this.mUseLibfdkForAac = false;
        this.mHevcDcoderName = HEVC_DECODER_NAME_QY265;
        this.mStartOnPrepared = true;
        this.mAsyncStreamComponentOpen = false;
        this.mEnableVodAdaptive = false;
        this.mUseNatvieCache = false;
        this.mEnableSegmentCache = false;
        this.mVideoPictureQueueSize = 3;
        this.mEnableSoftwareDecodeLimit = false;
        this.mSoftwareDecodeWidthLimit = -1;
        this.mSoftwareDecodeHeightLimit = -1;
        this.mSoftwareDecodeFpsLimit = -1;
        this.mMediaCodecMaxNum = -1;
        this.mMediaCodecAvcHeightLimit = -1;
        this.mMediaCodecHevcHeightLimit = -1;
        this.mMediaCodecAvcWidthLimit = -1;
        this.mMediaCodecHevcWidthLimit = -1;
        this.mUseMediaCodecByteBuffer = false;
        this.mMaxBufferSizeMb = -1;
        this.mMaxBufferTimeMs = 120000;
        this.mMaxBufferTimeBspMs = -1;
        this.mFFmpegConnectionTimeoutSec = 5;
        this.mFFmpegDataReadTimeoutSec = 30;
        this.mFFmpegSocketSendBufferSize = -1;
        this.mFFmpegSocketRecvBufferSize = -1;
        this.mFadeinEndTimeMs = 0;
        this.mKs265DecExtraParams = null;
        this.mEnableModifyBlock = false;
        this.mEnableAvSyncOpt = false;
        this.mIsVR = false;
        this.mInteractiveMode = 0;
        this.mStereoType = 0;
        this.mAudioChannelMode = 0;
        this.mContext = context.getApplicationContext();
    }

    public void applyTo(KwaiMediaPlayer kwaiMediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kwaiMediaPlayer) == null) {
            Timber.d("applyTo", new Object[0]);
            Context context = this.mContext;
            if (context != null) {
                kwaiMediaPlayer._setQy265Context(context);
                kwaiMediaPlayer.setContext(this.mContext);
            }
            kwaiMediaPlayer.setupAspectNativeCache(this.mUseNatvieCache);
            kwaiMediaPlayer.setEnableSegmentCache(this.mEnableSegmentCache);
            kwaiMediaPlayer.setOption(4, "opensles", this.mUseOpenSLES ? 1L : 0L);
            kwaiMediaPlayer.setOption(4, "start-on-prepared", this.mStartOnPrepared ? 1L : 0L);
            kwaiMediaPlayer.setOption(4, "async-stream-component-open", this.mAsyncStreamComponentOpen ? 1L : 0L);
            int i2 = this.mVideoPictureQueueSize;
            if (i2 > 3 && i2 <= 16) {
                kwaiMediaPlayer.setOption(4, "video-pictq-size", i2);
            }
            int i3 = this.mMediaCodecMaxNum;
            if (i3 > 0) {
                kwaiMediaPlayer.setOption(4, "mediacodec-max-cnt", i3);
            }
            int i4 = this.mMediaCodecAvcHeightLimit;
            if (i4 > 0) {
                kwaiMediaPlayer.setOption(4, "mediacodec-avc-height-limit", i4);
            }
            int i5 = this.mMediaCodecHevcHeightLimit;
            if (i5 > 0) {
                kwaiMediaPlayer.setOption(4, "mediacodec-hevc-height-limit", i5);
            }
            int i6 = this.mMediaCodecAvcWidthLimit;
            if (i6 > 0) {
                kwaiMediaPlayer.setOption(4, "mediacodec-avc-width-limit", i6);
            }
            int i7 = this.mMediaCodecHevcWidthLimit;
            if (i7 > 0) {
                kwaiMediaPlayer.setOption(4, "mediacodec-hevc-width-limit", i7);
            }
            if (this.mUseMediaCodecByteBuffer) {
                kwaiMediaPlayer.setOption(4, "use-mediacodec-bytebuffer", 1L);
            }
            if (this.mEnableSoftwareDecodeLimit) {
                kwaiMediaPlayer.setOption(4, "enable-software-decode-limitation", 1L);
                int i8 = this.mSoftwareDecodeWidthLimit;
                if (i8 > 0) {
                    kwaiMediaPlayer.setOption(4, "software-decode-width-limit", i8);
                }
                int i9 = this.mSoftwareDecodeHeightLimit;
                if (i9 > 0) {
                    kwaiMediaPlayer.setOption(4, "software-decode-height-limit", i9);
                }
                int i10 = this.mSoftwareDecodeFpsLimit;
                if (i10 > 0) {
                    kwaiMediaPlayer.setOption(4, "software-decode-fps-limit", i10);
                }
            }
            Integer num = this.mOverlayFormat;
            if (num != null) {
                kwaiMediaPlayer.setOption(4, "overlay-format", num.intValue());
            } else {
                String str = this.mOverlayFormatString;
                if (str != null) {
                    kwaiMediaPlayer.setOption(4, "overlay-format", str);
                }
            }
            ProductContext productContext = this.mProductContext;
            if (productContext != null && !productContext.productContextJson.isEmpty()) {
                kwaiMediaPlayer.setOption(1, "product-context", this.mProductContext.productContextJson);
            }
            if (this.mUseLibfdkForAac) {
                kwaiMediaPlayer.setOption(4, "aac-libfdk", 1L);
            }
            int i11 = this.mFadeinEndTimeMs;
            if (i11 > 0) {
                kwaiMediaPlayer.setOption(4, "fade-in-end-time-ms", i11);
            }
            boolean z = this.mEnableModifyBlock;
            if (z) {
                kwaiMediaPlayer.setOption(4, "enable-modify-block", z ? 1L : 0L);
            }
            boolean z2 = this.mEnableAvSyncOpt;
            if (z2) {
                kwaiMediaPlayer.setOption(4, "enable-av-sync-opt", z2 ? 1L : 0L);
            }
            kwaiMediaPlayer.setHevcCodecName(this.mHevcDcoderName);
            kwaiMediaPlayer.setCodecFlag(this.mUseHardwareDcoderFlag);
            if (this.mUseMediaCodecDummySurface) {
                kwaiMediaPlayer.setOption(4, "use-mediacodec-dummy-surface", 1L);
            }
            if (!TextUtils.isEmpty(this.mKs265DecExtraParams)) {
                kwaiMediaPlayer.setOption(2, "ks265_params", this.mKs265DecExtraParams);
            }
            int i12 = this.mMaxBufferSizeMb;
            if (i12 > 0) {
                kwaiMediaPlayer._setBufferSize(i12);
            }
            kwaiMediaPlayer.setOption(4, "max-buffer-dur-ms", this.mMaxBufferTimeMs);
            int i13 = this.mMaxBufferTimeBspMs;
            if (i13 > 0) {
                kwaiMediaPlayer.setOption(4, "dcc.max-buffer-dur-bsp-ms", i13);
            }
            kwaiMediaPlayer._setConnectionTimeout(this.mFFmpegConnectionTimeoutSec);
            kwaiMediaPlayer._setTimeout(this.mFFmpegDataReadTimeoutSec);
            int i14 = this.mFFmpegSocketRecvBufferSize;
            if (i14 > 0) {
                kwaiMediaPlayer.setOption(1, "recv_buffer_size", i14);
            }
            int i15 = this.mFFmpegSocketSendBufferSize;
            if (i15 > 0) {
                kwaiMediaPlayer.setOption(1, "send_buffer_size", i15);
            }
            if (this.mIsVR) {
                kwaiMediaPlayer.setInteractiveMode(this.mInteractiveMode);
                kwaiMediaPlayer.setStereoType(this.mStereoType);
                kwaiMediaPlayer.setAudioChannelMode(this.mAudioChannelMode);
                kwaiMediaPlayer.setIsVR(this.mIsVR);
            }
        }
    }

    public T enableAvSyncOpt(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.mEnableAvSyncOpt = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public abstract T self();

    public T setAsyncStreamOpen(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.mAsyncStreamComponentOpen = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setAudioChannelMode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.mAudioChannelMode = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setEnableModifyBlock(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.mEnableModifyBlock = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setEnableSegmentCache(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.mEnableSegmentCache = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setEnableSoftwareDecodeLimit(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.mEnableSoftwareDecodeLimit = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setEnableVodAdaptive(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.mEnableVodAdaptive = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setFFmpegConnectionTimeout(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.mFFmpegConnectionTimeoutSec = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setFFmpegDataReadTimeout(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.mFFmpegDataReadTimeoutSec = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public void setFFmpegSocketRecvBufferSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mFFmpegSocketRecvBufferSize = i2;
        }
    }

    public void setFFmpegSocketSendBufferSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mFFmpegSocketSendBufferSize = i2;
        }
    }

    public T setFadeinEndTimeMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.mFadeinEndTimeMs = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public void setHevcDcoderName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mHevcDcoderName = str;
        }
    }

    public T setInteractiveMode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            this.mInteractiveMode = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setIsVR(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            this.mIsVR = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setKs265DecExtraParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.mKs265DecExtraParams = str;
            return self();
        }
        return (T) invokeL.objValue;
    }

    public T setLibfdkForAac(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.mUseLibfdkForAac = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setMaxBufferSizeMb(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.mMaxBufferSizeMb = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setMaxBufferTimeBspMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            this.mMaxBufferTimeBspMs = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setMaxBufferTimeMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            this.mMaxBufferTimeMs = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setMediaCodecAvcHeightLimit(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            this.mMediaCodecAvcHeightLimit = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setMediaCodecAvcWidthLimit(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            this.mMediaCodecAvcWidthLimit = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setMediaCodecHevcHeightLimit(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            this.mMediaCodecHevcHeightLimit = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setMediaCodecHevcWidthLimit(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            this.mMediaCodecHevcWidthLimit = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setMediaCodecMaxNum(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            this.mMediaCodecMaxNum = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setOverlayFormat(@PlayerSettingConstants.OverlayFormat int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            this.mOverlayFormat = Integer.valueOf(i2);
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setOverlayFormatString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.mOverlayFormatString = str;
            return self();
        }
        return (T) invokeL.objValue;
    }

    public T setProductContext(ProductContext productContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, productContext)) == null) {
            this.mProductContext = productContext;
            return self();
        }
        return (T) invokeL.objValue;
    }

    public T setSoftwareDecodeLimit(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048606, this, i2, i3, i4)) == null) {
            this.mSoftwareDecodeWidthLimit = i2;
            this.mSoftwareDecodeHeightLimit = i3;
            this.mSoftwareDecodeFpsLimit = i4;
            return self();
        }
        return (T) invokeIII.objValue;
    }

    public T setStartOnPrepared(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
            this.mStartOnPrepared = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setStereoType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            this.mStereoType = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setUseHardwareDcoderFlag(@PlayerSettingConstants.UseHardwareDecoderFlag int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            this.mUseHardwareDcoderFlag = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }

    public T setUseMediaCodecByteBuffer(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
            this.mUseMediaCodecByteBuffer = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setUseMediaCodecDummySurface(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048611, this, z)) == null) {
            this.mUseMediaCodecDummySurface = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setUseNatvieCache(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
            this.mUseNatvieCache = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setUseOpenSLES(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048613, this, z)) == null) {
            this.mUseOpenSLES = z;
            return self();
        }
        return (T) invokeZ.objValue;
    }

    public T setVideoPictureQueueSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            this.mVideoPictureQueueSize = i2;
            return self();
        }
        return (T) invokeI.objValue;
    }
}
