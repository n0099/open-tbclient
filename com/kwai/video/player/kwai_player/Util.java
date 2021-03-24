package com.kwai.video.player.kwai_player;

import androidx.annotation.Keep;
import com.kwai.video.player.NativeErrorCode;
@Keep
/* loaded from: classes6.dex */
public class Util {
    public static boolean isCriticalErrorInMediaPlayer(int i, int i2) {
        if (i != -5108 && i != -5107 && i != -5104 && i != -5101 && i != -5013 && i != -1010 && i != -1007 && i != -1004 && i != -110 && i != 1 && i != 100 && i != 200) {
            switch (i) {
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
                    break;
                default:
                    return (i == -5012 && i2 < 0) || i < -20000;
            }
        }
        return true;
    }

    public static boolean isHttpForbiddenErrorInMediaPlayer(int i, int i2) {
        return -5007 == i || -2403 == i2;
    }

    public static boolean isMarlinTokenInvalidInMediaPlayer(int i, int i2) {
        return -5122 == i || -5123 == i;
    }
}
