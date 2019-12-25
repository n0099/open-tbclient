package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.baidu.mobstat.Config;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.v;
@TargetApi(16)
/* loaded from: classes4.dex */
public final class a {
    public final boolean lXv;
    private final String mimeType;
    public final boolean mkM;
    private final MediaCodecInfo.CodecCapabilities mkN;
    public final String name;
    public final boolean secure;

    public static a OW(String str) {
        return new a(str, null, null, false, false);
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, z, z2);
    }

    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        boolean z3 = false;
        this.name = (String) com.google.android.exoplayer2.util.a.checkNotNull(str);
        this.mimeType = str2;
        this.mkN = codecCapabilities;
        this.mkM = (z || codecCapabilities == null || !a(codecCapabilities)) ? false : true;
        this.lXv = codecCapabilities != null && c(codecCapabilities);
        if (z2 || (codecCapabilities != null && e(codecCapabilities))) {
            z3 = true;
        }
        this.secure = z3;
    }

    public MediaCodecInfo.CodecProfileLevel[] dto() {
        return (this.mkN == null || this.mkN.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.mkN.profileLevels;
    }

    public boolean OU(String str) {
        MediaCodecInfo.CodecProfileLevel[] dto;
        if (str == null || this.mimeType == null) {
            return true;
        }
        String PU = i.PU(str);
        if (PU == null) {
            return true;
        }
        if (!this.mimeType.equals(PU)) {
            OX("codec.mime " + str + ", " + PU);
            return false;
        }
        Pair<Integer, Integer> Pe = MediaCodecUtil.Pe(str);
        if (Pe == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : dto()) {
            if (codecProfileLevel.profile == ((Integer) Pe.first).intValue() && codecProfileLevel.level >= ((Integer) Pe.second).intValue()) {
                return true;
            }
        }
        OX("codec.profileLevel, " + str + ", " + PU);
        return false;
    }

    @TargetApi(21)
    public boolean a(int i, int i2, double d) {
        if (this.mkN == null) {
            OX("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.mkN.getVideoCapabilities();
        if (videoCapabilities == null) {
            OX("sizeAndRate.vCaps");
            return false;
        }
        if (!a(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
                OX("sizeAndRate.support, " + i + Config.EVENT_HEAT_X + i2 + Config.EVENT_HEAT_X + d);
                return false;
            }
            OY("sizeAndRate.rotated, " + i + Config.EVENT_HEAT_X + i2 + Config.EVENT_HEAT_X + d);
        }
        return true;
    }

    @TargetApi(21)
    public Point dM(int i, int i2) {
        if (this.mkN == null) {
            OX("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.mkN.getVideoCapabilities();
        if (videoCapabilities == null) {
            OX("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(widthAlignment * v.dY(i, widthAlignment), heightAlignment * v.dY(i2, heightAlignment));
    }

    @TargetApi(21)
    public boolean JN(int i) {
        if (this.mkN == null) {
            OX("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.mkN.getAudioCapabilities();
        if (audioCapabilities == null) {
            OX("sampleRate.aCaps");
            return false;
        } else if (!audioCapabilities.isSampleRateSupported(i)) {
            OX("sampleRate.support, " + i);
            return false;
        } else {
            return true;
        }
    }

    @TargetApi(21)
    public boolean JO(int i) {
        if (this.mkN == null) {
            OX("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.mkN.getAudioCapabilities();
        if (audioCapabilities == null) {
            OX("channelCount.aCaps");
            return false;
        } else if (x(this.name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) < i) {
            OX("channelCount.support, " + i);
            return false;
        } else {
            return true;
        }
    }

    private void OX(String str) {
        Log.d("MediaCodecInfo", "NoSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + v.mDm + "]");
    }

    private void OY(String str) {
        Log.d("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + v.mDm + "]");
    }

    private static int x(String str, String str2, int i) {
        int i2;
        if (i <= 1) {
            if ((v.SDK_INT < 26 || i <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2)) {
                if ("audio/ac3".equals(str2)) {
                    i2 = 6;
                } else if ("audio/eac3".equals(str2)) {
                    i2 = 16;
                } else {
                    i2 = 30;
                }
                Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
                return i2;
            }
            return i;
        }
        return i;
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return v.SDK_INT >= 19 && b(codecCapabilities);
    }

    @TargetApi(19)
    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return v.SDK_INT >= 21 && d(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return v.SDK_INT >= 21 && f(codecCapabilities);
    }

    @TargetApi(21)
    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @TargetApi(21)
    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        return (d == -1.0d || d <= 0.0d) ? videoCapabilities.isSizeSupported(i, i2) : videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }
}
