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
/* loaded from: classes6.dex */
public final class a {
    public final boolean mdR;
    private final String mimeType;
    public final boolean mrf;
    private final MediaCodecInfo.CodecCapabilities mrg;
    public final String name;
    public final boolean secure;

    public static a Pu(String str) {
        return new a(str, null, null, false, false);
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, z, z2);
    }

    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        boolean z3 = false;
        this.name = (String) com.google.android.exoplayer2.util.a.checkNotNull(str);
        this.mimeType = str2;
        this.mrg = codecCapabilities;
        this.mrf = (z || codecCapabilities == null || !a(codecCapabilities)) ? false : true;
        this.mdR = codecCapabilities != null && c(codecCapabilities);
        if (z2 || (codecCapabilities != null && e(codecCapabilities))) {
            z3 = true;
        }
        this.secure = z3;
    }

    public MediaCodecInfo.CodecProfileLevel[] dwl() {
        return (this.mrg == null || this.mrg.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.mrg.profileLevels;
    }

    public boolean Ps(String str) {
        MediaCodecInfo.CodecProfileLevel[] dwl;
        if (str == null || this.mimeType == null) {
            return true;
        }
        String Qs = i.Qs(str);
        if (Qs == null) {
            return true;
        }
        if (!this.mimeType.equals(Qs)) {
            Pv("codec.mime " + str + ", " + Qs);
            return false;
        }
        Pair<Integer, Integer> PC = MediaCodecUtil.PC(str);
        if (PC == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : dwl()) {
            if (codecProfileLevel.profile == ((Integer) PC.first).intValue() && codecProfileLevel.level >= ((Integer) PC.second).intValue()) {
                return true;
            }
        }
        Pv("codec.profileLevel, " + str + ", " + Qs);
        return false;
    }

    @TargetApi(21)
    public boolean a(int i, int i2, double d) {
        if (this.mrg == null) {
            Pv("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.mrg.getVideoCapabilities();
        if (videoCapabilities == null) {
            Pv("sizeAndRate.vCaps");
            return false;
        }
        if (!a(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
                Pv("sizeAndRate.support, " + i + Config.EVENT_HEAT_X + i2 + Config.EVENT_HEAT_X + d);
                return false;
            }
            Pw("sizeAndRate.rotated, " + i + Config.EVENT_HEAT_X + i2 + Config.EVENT_HEAT_X + d);
        }
        return true;
    }

    @TargetApi(21)
    public Point dO(int i, int i2) {
        if (this.mrg == null) {
            Pv("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.mrg.getVideoCapabilities();
        if (videoCapabilities == null) {
            Pv("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(widthAlignment * v.ea(i, widthAlignment), heightAlignment * v.ea(i2, heightAlignment));
    }

    @TargetApi(21)
    public boolean Kh(int i) {
        if (this.mrg == null) {
            Pv("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.mrg.getAudioCapabilities();
        if (audioCapabilities == null) {
            Pv("sampleRate.aCaps");
            return false;
        } else if (!audioCapabilities.isSampleRateSupported(i)) {
            Pv("sampleRate.support, " + i);
            return false;
        } else {
            return true;
        }
    }

    @TargetApi(21)
    public boolean Ki(int i) {
        if (this.mrg == null) {
            Pv("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.mrg.getAudioCapabilities();
        if (audioCapabilities == null) {
            Pv("channelCount.aCaps");
            return false;
        } else if (w(this.name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) < i) {
            Pv("channelCount.support, " + i);
            return false;
        } else {
            return true;
        }
    }

    private void Pv(String str) {
        Log.d("MediaCodecInfo", "NoSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + v.mJJ + "]");
    }

    private void Pw(String str) {
        Log.d("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + v.mJJ + "]");
    }

    private static int w(String str, String str2, int i) {
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
