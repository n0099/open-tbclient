package org.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
/* loaded from: classes7.dex */
public class MediaCodecVideoDecoderFactory implements VideoDecoderFactory {
    public static final String TAG = "MediaCodecVideoDecoderFactory";
    public final String[] prefixBlacklist;
    public final String[] prefixWhitelist;
    @Nullable
    public final EglBase.Context sharedContext;

    public MediaCodecVideoDecoderFactory(@Nullable EglBase.Context context, String[] strArr, String[] strArr2) {
        this.sharedContext = context;
        this.prefixWhitelist = (String[]) Arrays.copyOf(strArr, strArr.length);
        this.prefixBlacklist = (String[]) Arrays.copyOf(strArr2, strArr2.length);
    }

    @Nullable
    private MediaCodecInfo findCodecForType(VideoCodecType videoCodecType) {
        MediaCodecInfo mediaCodecInfo;
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        for (int i2 = 0; i2 < MediaCodecList.getCodecCount(); i2++) {
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i2);
            } catch (IllegalArgumentException e2) {
                Logging.e(TAG, "Cannot retrieve decoder codec info", e2);
                mediaCodecInfo = null;
            }
            if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder() && isSupportedCodec(mediaCodecInfo, videoCodecType)) {
                return mediaCodecInfo;
            }
        }
        return null;
    }

    private boolean isBlacklisted(String str) {
        for (String str2 : this.prefixBlacklist) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        if (Build.VERSION.SDK_INT < 21 || !name.startsWith("OMX.qcom.")) {
            return Build.VERSION.SDK_INT >= 23 && name.startsWith("OMX.Exynos.");
        }
        return true;
    }

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        String name = mediaCodecInfo.getName();
        return MediaCodecUtils.codecSupportsType(mediaCodecInfo, videoCodecType) && MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(videoCodecType.mimeType())) != null && isWhitelisted(name) && !isBlacklisted(name);
    }

    private boolean isWhitelisted(String str) {
        for (String str2 : this.prefixWhitelist) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.webrtc.VideoDecoderFactory
    @Nullable
    @Deprecated
    public VideoDecoder createDecoder(String str) {
        return VideoDecoderFactory_CC.$default$createDecoder(this, str);
    }

    @Override // org.webrtc.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        VideoCodecType valueOf = VideoCodecType.valueOf(videoCodecInfo.getName());
        MediaCodecInfo findCodecForType = findCodecForType(valueOf);
        if (findCodecForType == null) {
            return null;
        }
        return new AndroidVideoDecoder(new MediaCodecWrapperFactoryImpl(), findCodecForType.getName(), valueOf, MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(valueOf.mimeType())).intValue(), this.sharedContext);
    }

    @Override // org.webrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        VideoCodecType[] videoCodecTypeArr = {VideoCodecType.VP8, VideoCodecType.VP9, VideoCodecType.H264};
        for (int i2 = 0; i2 < 3; i2++) {
            VideoCodecType videoCodecType = videoCodecTypeArr[i2];
            MediaCodecInfo findCodecForType = findCodecForType(videoCodecType);
            if (findCodecForType != null) {
                String name = videoCodecType.name();
                if (videoCodecType == VideoCodecType.H264 && isH264HighProfileSupported(findCodecForType)) {
                    arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(videoCodecType, true)));
                }
                arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(videoCodecType, false)));
            }
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }
}
