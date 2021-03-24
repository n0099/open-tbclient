package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.PlayerSettingConstants;
import com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder;
/* loaded from: classes6.dex */
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
        int i = this.mVideoPictureQueueSize;
        if (i > 3 && i <= 16) {
            kwaiMediaPlayer.setOption(4, "video-pictq-size", i);
        }
        int i2 = this.mMediaCodecMaxNum;
        if (i2 > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-max-cnt", i2);
        }
        int i3 = this.mMediaCodecAvcHeightLimit;
        if (i3 > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-avc-height-limit", i3);
        }
        int i4 = this.mMediaCodecHevcHeightLimit;
        if (i4 > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-hevc-height-limit", i4);
        }
        int i5 = this.mMediaCodecAvcWidthLimit;
        if (i5 > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-avc-width-limit", i5);
        }
        int i6 = this.mMediaCodecHevcWidthLimit;
        if (i6 > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-hevc-width-limit", i6);
        }
        if (this.mUseMediaCodecByteBuffer) {
            kwaiMediaPlayer.setOption(4, "use-mediacodec-bytebuffer", 1L);
        }
        if (this.mEnableSoftwareDecodeLimit) {
            kwaiMediaPlayer.setOption(4, "enable-software-decode-limitation", 1L);
            int i7 = this.mSoftwareDecodeWidthLimit;
            if (i7 > 0) {
                kwaiMediaPlayer.setOption(4, "software-decode-width-limit", i7);
            }
            int i8 = this.mSoftwareDecodeHeightLimit;
            if (i8 > 0) {
                kwaiMediaPlayer.setOption(4, "software-decode-height-limit", i8);
            }
            int i9 = this.mSoftwareDecodeFpsLimit;
            if (i9 > 0) {
                kwaiMediaPlayer.setOption(4, "software-decode-fps-limit", i9);
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
        int i10 = this.mFadeinEndTimeMs;
        if (i10 > 0) {
            kwaiMediaPlayer.setOption(4, "fade-in-end-time-ms", i10);
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
        int i11 = this.mMaxBufferSizeMb;
        if (i11 > 0) {
            kwaiMediaPlayer._setBufferSize(i11);
        }
        kwaiMediaPlayer.setOption(4, "max-buffer-dur-ms", this.mMaxBufferTimeMs);
        int i12 = this.mMaxBufferTimeBspMs;
        if (i12 > 0) {
            kwaiMediaPlayer.setOption(4, "dcc.max-buffer-dur-bsp-ms", i12);
        }
        kwaiMediaPlayer._setConnectionTimeout(this.mFFmpegConnectionTimeoutSec);
        kwaiMediaPlayer._setTimeout(this.mFFmpegDataReadTimeoutSec);
        int i13 = this.mFFmpegSocketRecvBufferSize;
        if (i13 > 0) {
            kwaiMediaPlayer.setOption(1, "recv_buffer_size", i13);
        }
        int i14 = this.mFFmpegSocketSendBufferSize;
        if (i14 > 0) {
            kwaiMediaPlayer.setOption(1, "send_buffer_size", i14);
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

    public T setAudioChannelMode(int i) {
        this.mAudioChannelMode = i;
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

    public T setFFmpegConnectionTimeout(int i) {
        this.mFFmpegConnectionTimeoutSec = i;
        return self();
    }

    public T setFFmpegDataReadTimeout(int i) {
        this.mFFmpegDataReadTimeoutSec = i;
        return self();
    }

    public void setFFmpegSocketRecvBufferSize(int i) {
        this.mFFmpegSocketRecvBufferSize = i;
    }

    public void setFFmpegSocketSendBufferSize(int i) {
        this.mFFmpegSocketSendBufferSize = i;
    }

    public T setFadeinEndTimeMs(int i) {
        this.mFadeinEndTimeMs = i;
        return self();
    }

    public void setHevcDcoderName(String str) {
        this.mHevcDcoderName = str;
    }

    public T setInteractiveMode(int i) {
        this.mInteractiveMode = i;
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

    public T setMaxBufferSizeMb(int i) {
        this.mMaxBufferSizeMb = i;
        return self();
    }

    public T setMaxBufferTimeBspMs(int i) {
        this.mMaxBufferTimeBspMs = i;
        return self();
    }

    public T setMaxBufferTimeMs(int i) {
        this.mMaxBufferTimeMs = i;
        return self();
    }

    public T setMediaCodecAvcHeightLimit(int i) {
        this.mMediaCodecAvcHeightLimit = i;
        return self();
    }

    public T setMediaCodecAvcWidthLimit(int i) {
        this.mMediaCodecAvcWidthLimit = i;
        return self();
    }

    public T setMediaCodecHevcHeightLimit(int i) {
        this.mMediaCodecHevcHeightLimit = i;
        return self();
    }

    public T setMediaCodecHevcWidthLimit(int i) {
        this.mMediaCodecHevcWidthLimit = i;
        return self();
    }

    public T setMediaCodecMaxNum(int i) {
        this.mMediaCodecMaxNum = i;
        return self();
    }

    public T setOverlayFormat(@PlayerSettingConstants.OverlayFormat int i) {
        this.mOverlayFormat = Integer.valueOf(i);
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

    public T setSoftwareDecodeLimit(int i, int i2, int i3) {
        this.mSoftwareDecodeWidthLimit = i;
        this.mSoftwareDecodeHeightLimit = i2;
        this.mSoftwareDecodeFpsLimit = i3;
        return self();
    }

    public T setStartOnPrepared(boolean z) {
        this.mStartOnPrepared = z;
        return self();
    }

    public T setStereoType(int i) {
        this.mStereoType = i;
        return self();
    }

    public T setUseHardwareDcoderFlag(@PlayerSettingConstants.UseHardwareDecoderFlag int i) {
        this.mUseHardwareDcoderFlag = i;
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

    public T setVideoPictureQueueSize(int i) {
        this.mVideoPictureQueueSize = i;
        return self();
    }
}
