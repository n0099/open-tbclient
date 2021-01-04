package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.PlayerSettingConstants;
import com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder;
/* loaded from: classes5.dex */
public abstract class KwaiPlayerBaseBuilder<T extends KwaiPlayerBaseBuilder<T>> {
    public static final String HEVC_DECODER_NAME_KS265 = "libks265dec";
    public static final String HEVC_DECODER_NAME_KVC = "libkvcdec";
    public static final String HEVC_DECODER_NAME_QY265 = "libqy265dec";
    private Context mContext;
    private ProductContext mProductContext;
    private boolean mUseOpenSLES = false;
    @PlayerSettingConstants.OverlayFormat
    private Integer mOverlayFormat = null;
    private String mOverlayFormatString = null;
    private boolean mUseMediaCodecDummySurface = false;
    @PlayerSettingConstants.UseHardwareDecoderFlag
    private int mUseHardwareDcoderFlag = 0;
    private boolean mUseLibfdkForAac = false;
    private String mHevcDcoderName = HEVC_DECODER_NAME_QY265;
    private boolean mStartOnPrepared = true;
    private boolean mAsyncStreamComponentOpen = false;
    private boolean mEnableVodAdaptive = false;
    protected boolean mUseNatvieCache = false;
    protected boolean mEnableSegmentCache = false;
    private int mVideoPictureQueueSize = 3;
    private boolean mEnableSoftwareDecodeLimit = false;
    private int mSoftwareDecodeWidthLimit = -1;
    private int mSoftwareDecodeHeightLimit = -1;
    private int mSoftwareDecodeFpsLimit = -1;
    private int mMediaCodecMaxNum = -1;
    private int mMediaCodecAvcHeightLimit = -1;
    private int mMediaCodecHevcHeightLimit = -1;
    private int mMediaCodecAvcWidthLimit = -1;
    private int mMediaCodecHevcWidthLimit = -1;
    private boolean mUseMediaCodecByteBuffer = false;
    private int mMaxBufferSizeMb = -1;
    private int mMaxBufferTimeMs = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int mMaxBufferTimeBspMs = -1;
    private int mFFmpegConnectionTimeoutSec = 5;
    private int mFFmpegDataReadTimeoutSec = 30;
    private int mFFmpegSocketSendBufferSize = -1;
    private int mFFmpegSocketRecvBufferSize = -1;
    private int mFadeinEndTimeMs = 0;
    private String mKs265DecExtraParams = null;
    private boolean mEnableModifyBlock = false;
    private boolean mEnableAvSyncOpt = false;
    private boolean mIsVR = false;
    private int mInteractiveMode = 0;
    private int mStereoType = 0;
    private int mAudioChannelMode = 0;

    public KwaiPlayerBaseBuilder(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyTo(KwaiMediaPlayer kwaiMediaPlayer) {
        Timber.d("applyTo", new Object[0]);
        if (this.mContext != null) {
            kwaiMediaPlayer._setQy265Context(this.mContext);
            kwaiMediaPlayer.setContext(this.mContext);
        }
        kwaiMediaPlayer.setupAspectNativeCache(this.mUseNatvieCache);
        kwaiMediaPlayer.setEnableSegmentCache(this.mEnableSegmentCache);
        kwaiMediaPlayer.setOption(4, "opensles", this.mUseOpenSLES ? 1L : 0L);
        kwaiMediaPlayer.setOption(4, "start-on-prepared", this.mStartOnPrepared ? 1L : 0L);
        kwaiMediaPlayer.setOption(4, "async-stream-component-open", this.mAsyncStreamComponentOpen ? 1L : 0L);
        if (this.mVideoPictureQueueSize > 3 && this.mVideoPictureQueueSize <= 16) {
            kwaiMediaPlayer.setOption(4, "video-pictq-size", this.mVideoPictureQueueSize);
        }
        if (this.mMediaCodecMaxNum > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-max-cnt", this.mMediaCodecMaxNum);
        }
        if (this.mMediaCodecAvcHeightLimit > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-avc-height-limit", this.mMediaCodecAvcHeightLimit);
        }
        if (this.mMediaCodecHevcHeightLimit > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-hevc-height-limit", this.mMediaCodecHevcHeightLimit);
        }
        if (this.mMediaCodecAvcWidthLimit > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-avc-width-limit", this.mMediaCodecAvcWidthLimit);
        }
        if (this.mMediaCodecHevcWidthLimit > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-hevc-width-limit", this.mMediaCodecHevcWidthLimit);
        }
        if (this.mUseMediaCodecByteBuffer) {
            kwaiMediaPlayer.setOption(4, "use-mediacodec-bytebuffer", 1L);
        }
        if (this.mEnableSoftwareDecodeLimit) {
            kwaiMediaPlayer.setOption(4, "enable-software-decode-limitation", 1L);
            if (this.mSoftwareDecodeWidthLimit > 0) {
                kwaiMediaPlayer.setOption(4, "software-decode-width-limit", this.mSoftwareDecodeWidthLimit);
            }
            if (this.mSoftwareDecodeHeightLimit > 0) {
                kwaiMediaPlayer.setOption(4, "software-decode-height-limit", this.mSoftwareDecodeHeightLimit);
            }
            if (this.mSoftwareDecodeFpsLimit > 0) {
                kwaiMediaPlayer.setOption(4, "software-decode-fps-limit", this.mSoftwareDecodeFpsLimit);
            }
        }
        if (this.mOverlayFormat != null) {
            kwaiMediaPlayer.setOption(4, "overlay-format", this.mOverlayFormat.intValue());
        } else if (this.mOverlayFormatString != null) {
            kwaiMediaPlayer.setOption(4, "overlay-format", this.mOverlayFormatString);
        }
        if (this.mProductContext != null && !this.mProductContext.productContextJson.isEmpty()) {
            kwaiMediaPlayer.setOption(1, "product-context", this.mProductContext.productContextJson);
        }
        if (this.mUseLibfdkForAac) {
            kwaiMediaPlayer.setOption(4, "aac-libfdk", 1L);
        }
        if (this.mFadeinEndTimeMs > 0) {
            kwaiMediaPlayer.setOption(4, "fade-in-end-time-ms", this.mFadeinEndTimeMs);
        }
        if (this.mEnableModifyBlock) {
            kwaiMediaPlayer.setOption(4, "enable-modify-block", this.mEnableModifyBlock ? 1L : 0L);
        }
        if (this.mEnableAvSyncOpt) {
            kwaiMediaPlayer.setOption(4, "enable-av-sync-opt", this.mEnableAvSyncOpt ? 1L : 0L);
        }
        kwaiMediaPlayer.setHevcCodecName(this.mHevcDcoderName);
        kwaiMediaPlayer.setCodecFlag(this.mUseHardwareDcoderFlag);
        if (this.mUseMediaCodecDummySurface) {
            kwaiMediaPlayer.setOption(4, "use-mediacodec-dummy-surface", 1L);
        }
        if (!TextUtils.isEmpty(this.mKs265DecExtraParams)) {
            kwaiMediaPlayer.setOption(2, "ks265_params", this.mKs265DecExtraParams);
        }
        if (this.mMaxBufferSizeMb > 0) {
            kwaiMediaPlayer._setBufferSize(this.mMaxBufferSizeMb);
        }
        kwaiMediaPlayer.setOption(4, "max-buffer-dur-ms", this.mMaxBufferTimeMs);
        if (this.mMaxBufferTimeBspMs > 0) {
            kwaiMediaPlayer.setOption(4, "dcc.max-buffer-dur-bsp-ms", this.mMaxBufferTimeBspMs);
        }
        kwaiMediaPlayer._setConnectionTimeout(this.mFFmpegConnectionTimeoutSec);
        kwaiMediaPlayer._setTimeout(this.mFFmpegDataReadTimeoutSec);
        if (this.mFFmpegSocketRecvBufferSize > 0) {
            kwaiMediaPlayer.setOption(1, "recv_buffer_size", this.mFFmpegSocketRecvBufferSize);
        }
        if (this.mFFmpegSocketSendBufferSize > 0) {
            kwaiMediaPlayer.setOption(1, "send_buffer_size", this.mFFmpegSocketSendBufferSize);
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

    protected abstract T self();

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
