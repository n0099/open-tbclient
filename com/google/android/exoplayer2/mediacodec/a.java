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
/* loaded from: classes5.dex */
public final class a {
    public final boolean mbn;
    private final String mimeType;
    public final boolean moB;
    private final MediaCodecInfo.CodecCapabilities moC;
    public final String name;
    public final boolean secure;

    public static a Ph(String str) {
        return new a(str, null, null, false, false);
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, codecCapabilities, z, z2);
    }

    private a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        boolean z3 = false;
        this.name = (String) com.google.android.exoplayer2.util.a.checkNotNull(str);
        this.mimeType = str2;
        this.moC = codecCapabilities;
        this.moB = (z || codecCapabilities == null || !a(codecCapabilities)) ? false : true;
        this.mbn = codecCapabilities != null && c(codecCapabilities);
        if (z2 || (codecCapabilities != null && e(codecCapabilities))) {
            z3 = true;
        }
        this.secure = z3;
    }

    public MediaCodecInfo.CodecProfileLevel[] duz() {
        return (this.moC == null || this.moC.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.moC.profileLevels;
    }

    public boolean Pf(String str) {
        MediaCodecInfo.CodecProfileLevel[] duz;
        if (str == null || this.mimeType == null) {
            return true;
        }
        String Qf = i.Qf(str);
        if (Qf == null) {
            return true;
        }
        if (!this.mimeType.equals(Qf)) {
            Pi("codec.mime " + str + ", " + Qf);
            return false;
        }
        Pair<Integer, Integer> Pp = MediaCodecUtil.Pp(str);
        if (Pp == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : duz()) {
            if (codecProfileLevel.profile == ((Integer) Pp.first).intValue() && codecProfileLevel.level >= ((Integer) Pp.second).intValue()) {
                return true;
            }
        }
        Pi("codec.profileLevel, " + str + ", " + Qf);
        return false;
    }

    @TargetApi(21)
    public boolean a(int i, int i2, double d) {
        if (this.moC == null) {
            Pi("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.moC.getVideoCapabilities();
        if (videoCapabilities == null) {
            Pi("sizeAndRate.vCaps");
            return false;
        }
        if (!a(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
                Pi("sizeAndRate.support, " + i + Config.EVENT_HEAT_X + i2 + Config.EVENT_HEAT_X + d);
                return false;
            }
            Pj("sizeAndRate.rotated, " + i + Config.EVENT_HEAT_X + i2 + Config.EVENT_HEAT_X + d);
        }
        return true;
    }

    @TargetApi(21)
    public Point dK(int i, int i2) {
        if (this.moC == null) {
            Pi("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.moC.getVideoCapabilities();
        if (videoCapabilities == null) {
            Pi("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(widthAlignment * v.dW(i, widthAlignment), heightAlignment * v.dW(i2, heightAlignment));
    }

    @TargetApi(21)
    public boolean JW(int i) {
        if (this.moC == null) {
            Pi("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.moC.getAudioCapabilities();
        if (audioCapabilities == null) {
            Pi("sampleRate.aCaps");
            return false;
        } else if (!audioCapabilities.isSampleRateSupported(i)) {
            Pi("sampleRate.support, " + i);
            return false;
        } else {
            return true;
        }
    }

    @TargetApi(21)
    public boolean JX(int i) {
        if (this.moC == null) {
            Pi("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.moC.getAudioCapabilities();
        if (audioCapabilities == null) {
            Pi("channelCount.aCaps");
            return false;
        } else if (x(this.name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) < i) {
            Pi("channelCount.support, " + i);
            return false;
        } else {
            return true;
        }
    }

    private void Pi(String str) {
        Log.d("MediaCodecInfo", "NoSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + v.mHc + "]");
    }

    private void Pj(String str) {
        Log.d("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + v.mHc + "]");
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
