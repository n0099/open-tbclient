package com.kwai.video.player.kwai_player;

import androidx.annotation.Keep;
import com.kwai.video.player.NativeErrorCode;
@Keep
/* loaded from: classes5.dex */
public class Util {
    public static boolean isCriticalErrorInMediaPlayer(int i, int i2) {
        switch (i) {
            case NativeErrorCode.EKS_KWAI_LIVE_CODEC_CHANGE /* -5108 */:
            case NativeErrorCode.EKS_KWAI_MEDIACODEC_RECONFIG_ERR /* -5107 */:
            case NativeErrorCode.EKS_KWAI_NO_MEMORY /* -5104 */:
            case NativeErrorCode.EKS_KWAI_READ_DATA_IO_TIMEOUT /* -5101 */:
            case NativeErrorCode.EKS_AVERROR_EOF /* -5013 */:
            case NativeErrorCode.EKS_AVERROR_INVALIDDATA /* -5011 */:
            case NativeErrorCode.EKS_AVERROR_HTTP_SERVER_ERROR /* -5010 */:
            case NativeErrorCode.EKS_AVERROR_HTTP_OTHER_4XX /* -5009 */:
            case NativeErrorCode.EKS_AVERROR_HTTP_NOT_FOUND /* -5008 */:
            case NativeErrorCode.EKS_AVERROR_HTTP_FORBIDDEN /* -5007 */:
            case NativeErrorCode.EKS_AVERROR_HTTP_UNAUTHORIZED /* -5006 */:
            case NativeErrorCode.EKS_AVERROR_HTTP_BAD_REQUEST /* -5005 */:
            case NativeErrorCode.EKS_AVERROR_ETIMEDOUT /* -5004 */:
            case NativeErrorCode.EKS_AVERROR_EMFILE /* -5003 */:
            case NativeErrorCode.EKS_AVERROR_EIO /* -5002 */:
            case NativeErrorCode.EKS_AVERROR_PROTOCOL_NOT_FOUND /* -5001 */:
            case -1010:
            case -1007:
            case -1004:
            case -110:
            case 1:
            case 100:
            case 200:
                return true;
            default:
                return (i == -5012 && i2 < 0) || i < -20000;
        }
    }

    public static boolean isHttpForbiddenErrorInMediaPlayer(int i, int i2) {
        return -5007 == i || -2403 == i2;
    }

    public static boolean isMarlinTokenInvalidInMediaPlayer(int i, int i2) {
        return -5122 == i || -5123 == i;
    }
}
