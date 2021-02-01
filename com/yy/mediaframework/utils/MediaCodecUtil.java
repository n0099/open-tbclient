package com.yy.mediaframework.utils;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.yy.mediaframework.base.VideoEncoderType;
@TargetApi(18)
/* loaded from: classes4.dex */
public class MediaCodecUtil {
    private static final String TAG = "MediaCodecUtil";
    private int mCorlorFormatH264;
    private int mCorlorFormatH265;
    private boolean mH264Support;
    private boolean mH265Support;
    private static final byte[] SYNC_FLAG = new byte[1];
    private static MediaCodecUtil mInstance = null;

    public static MediaCodecUtil instance() {
        if (mInstance == null) {
            synchronized (SYNC_FLAG) {
                if (mInstance == null) {
                    mInstance = new MediaCodecUtil();
                }
            }
        }
        return mInstance;
    }

    private MediaCodecUtil() {
        selectColorFormat();
    }

    private void selectColorFormat() {
        int codecCount = MediaCodecList.getCodecCount();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder() && !codecInfoAt.getName().startsWith("OMX.google")) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (int i2 = 0; supportedTypes != null && i2 < supportedTypes.length; i2++) {
                    if (supportedTypes[i2].startsWith("video")) {
                        if (supportedTypes[i2].equals("video/avc") && !z2) {
                            this.mH264Support = true;
                            if (codecInfoAt.getName().contains("hisi")) {
                                this.mCorlorFormatH264 = selectSupportColorFormatByHisi(codecInfoAt.getCapabilitiesForType(supportedTypes[i2]));
                                YMFLog.info(this, "[Encoder ]", supportedTypes[i2] + "hisi select color format:" + colorFormatToName(this.mCorlorFormatH264) + ":" + this.mCorlorFormatH264);
                                z2 = true;
                            } else {
                                this.mCorlorFormatH264 = selectSupportColorFormat(codecInfoAt.getCapabilitiesForType(supportedTypes[i2]));
                                YMFLog.info(this, "[Encoder ]", supportedTypes[i2] + "select color format:" + colorFormatToName(this.mCorlorFormatH264) + ":" + this.mCorlorFormatH264);
                                z2 = true;
                            }
                        } else if (supportedTypes[i2].equals("video/hevc") && !z) {
                            this.mH265Support = true;
                            if (codecInfoAt.getName().contains("hisi")) {
                                this.mCorlorFormatH265 = selectSupportColorFormatByHisi(codecInfoAt.getCapabilitiesForType(supportedTypes[i2]));
                                YMFLog.info(this, "[Encoder ]", supportedTypes[i2] + "hisi select color format:" + colorFormatToName(this.mCorlorFormatH265) + ":" + this.mCorlorFormatH265);
                                z = true;
                            } else {
                                this.mCorlorFormatH265 = selectSupportColorFormat(codecInfoAt.getCapabilitiesForType(supportedTypes[i2]));
                                YMFLog.info(this, "[Encoder ]", supportedTypes[i2] + " select color format:" + colorFormatToName(this.mCorlorFormatH265) + ":" + this.mCorlorFormatH265);
                                z = true;
                            }
                        } else if (z2 && z) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public int getColorFormat(VideoEncoderType videoEncoderType) {
        if (videoEncoderType.compareTo(VideoEncoderType.HARD_ENCODER_H264) == 0) {
            return this.mCorlorFormatH264;
        }
        if (videoEncoderType.compareTo(VideoEncoderType.HARD_ENCODER_H265) == 0) {
            return this.mCorlorFormatH265;
        }
        return -1;
    }

    public int getColorFormat(String str) {
        if ("video/avc".equals(str)) {
            return this.mCorlorFormatH264;
        }
        if ("video/hevc".equals(str)) {
            return this.mCorlorFormatH265;
        }
        return -1;
    }

    private boolean supportColorFormat(MediaCodecInfo.CodecCapabilities codecCapabilities, int i) {
        for (int i2 = 0; i2 < codecCapabilities.colorFormats.length; i2++) {
            if (codecCapabilities.colorFormats[i2] == i) {
                return true;
            }
        }
        return false;
    }

    private void printSupportedFormat(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        YMFLog.info(this, "[Encoder ]", "support encoder input color format: ");
        for (int i = 0; i < codecCapabilities.colorFormats.length; i++) {
            YMFLog.info(this, "[Encoder ]", i + ":" + codecCapabilities.colorFormats[i]);
        }
    }

    public static String colorFormatToName(int i) {
        switch (i) {
            case 19:
                return "COLOR_FormatYUV420Planar";
            case 20:
                return "COLOR_FormatYUV420PackedPlanar";
            case 21:
                return "COLOR_FormatYUV420SemiPlanar";
            case 39:
                return "COLOR_FormatYUV420PackedSemiPlanar";
            case 2130708361:
                return "COLOR_FormatSurface";
            case 2135033992:
                return "COLOR_FormatYUV420Flexible";
            default:
                return "unknown";
        }
    }

    public static boolean isSemiPlanar(int i) {
        switch (i) {
            case 19:
            case 20:
            default:
                return false;
            case 21:
            case 39:
                return true;
        }
    }

    private int selectSupportColorFormat(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (codecCapabilities == null) {
            return -1;
        }
        String str = "";
        for (int i = 0; i < codecCapabilities.colorFormats.length; i++) {
            str = str + codecCapabilities.colorFormats[i] + " ,";
        }
        YMFLog.info(this, "[Encoder ]", "all color :" + str);
        if (supportColorFormat(codecCapabilities, 19)) {
            return 19;
        }
        if (supportColorFormat(codecCapabilities, 20)) {
            return 20;
        }
        if (supportColorFormat(codecCapabilities, 21)) {
            return 21;
        }
        if (supportColorFormat(codecCapabilities, 39)) {
            return 39;
        }
        printSupportedFormat(codecCapabilities);
        return -1;
    }

    private int selectSupportColorFormatByHisi(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (codecCapabilities == null) {
            return -1;
        }
        String str = "";
        for (int i = 0; i < codecCapabilities.colorFormats.length; i++) {
            str = str + codecCapabilities.colorFormats[i] + " ,";
        }
        YMFLog.info(this, "[Encoder ]", "hisi all color :" + str);
        if (supportColorFormat(codecCapabilities, 21)) {
            return 21;
        }
        if (supportColorFormat(codecCapabilities, 19)) {
            return 19;
        }
        if (supportColorFormat(codecCapabilities, 20)) {
            return 20;
        }
        if (supportColorFormat(codecCapabilities, 21)) {
            return 21;
        }
        if (supportColorFormat(codecCapabilities, 39)) {
            return 39;
        }
        printSupportedFormat(codecCapabilities);
        return -1;
    }
}
