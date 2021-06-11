package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.PlayerSettingConstants;
import com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder;
/* loaded from: classes7.dex */
public abstract class KwaiPlayerBaseBuilder<T extends KwaiPlayerBaseBuilder<T>> {
    public static final String HEVC_DECODER_NAME_KS265 = "libks265dec";
    public static final String HEVC_DECODER_NAME_KVC = "libkvcdec";
    public static final String HEVC_DECODER_NAME_QY265 = "libqy265dec";
    public Context mContext;
    public ProductContext mProductContext;
    public boolean mUseOpenSLES = false;
    @PlayerSettingConstants.OverlayFormat
    public Integer mOverlayFormat = null;
    public String mOverlayFormatString = null;
    public boolean mUseMediaCodecDummySurface = false;
    @PlayerSettingConstants.UseHardwareDecoderFlag
    public int mUseHardwareDcoderFlag = 0;
    public boolean mUseLibfdkForAac = false;
    public String mHevcDcoderName = HEVC_DECODER_NAME_QY265;
    public boolean mStartOnPrepared = true;
    public boolean mAsyncStreamComponentOpen = false;
    public boolean mEnableVodAdaptive = false;
    public boolean mUseNatvieCache = false;
    public boolean mEnableSegmentCache = false;
    public int mVideoPictureQueueSize = 3;
    public boolean mEnableSoftwareDecodeLimit = false;
    public int mSoftwareDecodeWidthLimit = -1;
    public int mSoftwareDecodeHeightLimit = -1;
    public int mSoftwareDecodeFpsLimit = -1;
    public int mMediaCodecMaxNum = -1;
    public int mMediaCodecAvcHeightLimit = -1;
    public int mMediaCodecHevcHeightLimit = -1;
    public int mMediaCodecAvcWidthLimit = -1;
    public int mMediaCodecHevcWidthLimit = -1;
    public boolean mUseMediaCodecByteBuffer = false;
    public int mMaxBufferSizeMb = -1;
    public int mMaxBufferTimeMs = 120000;
    public int mMaxBufferTimeBspMs = -1;
    public int mFFmpegConnectionTimeoutSec = 5;
    public int mFFmpegDataReadTimeoutSec = 30;
    public int mFFmpegSocketSendBufferSize = -1;
    public int mFFmpegSocketRecvBufferSize = -1;
    public int mFadeinEndTimeMs = 0;
    public String mKs265DecExtraParams = null;
    public boolean mEnableModifyBlock = false;
    public boolean mEnableAvSyncOpt = false;
    public boolean mIsVR = false;
    public int mInteractiveMode = 0;
    public int mStereoType = 0;
    public int mAudioChannelMode = 0;

    public KwaiPlayerBaseBuilder(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void applyTo(KwaiMediaPlayer kwaiMediaPlayer) {
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

    public T enableAvSyncOpt(boolean z) {
        this.mEnableAvSyncOpt = z;
        return self();
    }

    public abstract T self();

    public T setAsyncStreamOpen(boolean z) {
        this.mAsyncStreamComponentOpen = z;
        return self();
    }

    public T setAudioChannelMode(int i2) {
        this.mAudioChannelMode = i2;
        return self();
    }

    public T setEnableModifyBlock(boolean z) {
        this.mEnableModifyBlock = z;
        return self();
    }

    public T setEnableSegmentCache(boolean z) {
        this.mEnableSegmentCache = z;
        return self();
    }

    public T setEnableSoftwareDecodeLimit(boolean z) {
        this.mEnableSoftwareDecodeLimit = z;
        return self();
    }

    public T setEnableVodAdaptive(boolean z) {
        this.mEnableVodAdaptive = z;
        return self();
    }

    public T setFFmpegConnectionTimeout(int i2) {
        this.mFFmpegConnectionTimeoutSec = i2;
        return self();
    }

    public T setFFmpegDataReadTimeout(int i2) {
        this.mFFmpegDataReadTimeoutSec = i2;
        return self();
    }

    public void setFFmpegSocketRecvBufferSize(int i2) {
        this.mFFmpegSocketRecvBufferSize = i2;
    }

    public void setFFmpegSocketSendBufferSize(int i2) {
        this.mFFmpegSocketSendBufferSize = i2;
    }

    public T setFadeinEndTimeMs(int i2) {
        this.mFadeinEndTimeMs = i2;
        return self();
    }

    public void setHevcDcoderName(String str) {
        this.mHevcDcoderName = str;
    }

    public T setInteractiveMode(int i2) {
        this.mInteractiveMode = i2;
        return self();
    }

    public T setIsVR(boolean z) {
        this.mIsVR = z;
        return self();
    }

    public T setKs265DecExtraParams(String str) {
        this.mKs265DecExtraParams = str;
        return self();
    }

    public T setLibfdkForAac(boolean z) {
        this.mUseLibfdkForAac = z;
        return self();
    }

    public T setMaxBufferSizeMb(int i2) {
        this.mMaxBufferSizeMb = i2;
        return self();
    }

    public T setMaxBufferTimeBspMs(int i2) {
        this.mMaxBufferTimeBspMs = i2;
        return self();
    }

    public T setMaxBufferTimeMs(int i2) {
        this.mMaxBufferTimeMs = i2;
        return self();
    }

    public T setMediaCodecAvcHeightLimit(int i2) {
        this.mMediaCodecAvcHeightLimit = i2;
        return self();
    }

    public T setMediaCodecAvcWidthLimit(int i2) {
        this.mMediaCodecAvcWidthLimit = i2;
        return self();
    }

    public T setMediaCodecHevcHeightLimit(int i2) {
        this.mMediaCodecHevcHeightLimit = i2;
        return self();
    }

    public T setMediaCodecHevcWidthLimit(int i2) {
        this.mMediaCodecHevcWidthLimit = i2;
        return self();
    }

    public T setMediaCodecMaxNum(int i2) {
        this.mMediaCodecMaxNum = i2;
        return self();
    }

    public T setOverlayFormat(@PlayerSettingConstants.OverlayFormat int i2) {
        this.mOverlayFormat = Integer.valueOf(i2);
        return self();
    }

    public T setOverlayFormatString(String str) {
        this.mOverlayFormatString = str;
        return self();
    }

    public T setProductContext(ProductContext productContext) {
        this.mProductContext = productContext;
        return self();
    }

    public T setSoftwareDecodeLimit(int i2, int i3, int i4) {
        this.mSoftwareDecodeWidthLimit = i2;
        this.mSoftwareDecodeHeightLimit = i3;
        this.mSoftwareDecodeFpsLimit = i4;
        return self();
    }

    public T setStartOnPrepared(boolean z) {
        this.mStartOnPrepared = z;
        return self();
    }

    public T setStereoType(int i2) {
        this.mStereoType = i2;
        return self();
    }

    public T setUseHardwareDcoderFlag(@PlayerSettingConstants.UseHardwareDecoderFlag int i2) {
        this.mUseHardwareDcoderFlag = i2;
        return self();
    }

    public T setUseMediaCodecByteBuffer(boolean z) {
        this.mUseMediaCodecByteBuffer = z;
        return self();
    }

    public T setUseMediaCodecDummySurface(boolean z) {
        this.mUseMediaCodecDummySurface = z;
        return self();
    }

    public T setUseNatvieCache(boolean z) {
        this.mUseNatvieCache = z;
        return self();
    }

    public T setUseOpenSLES(boolean z) {
        this.mUseOpenSLES = z;
        return self();
    }

    public T setVideoPictureQueueSize(int i2) {
        this.mVideoPictureQueueSize = i2;
        return self();
    }
}
