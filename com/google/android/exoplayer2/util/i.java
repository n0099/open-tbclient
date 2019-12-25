package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public final class i {
    public static boolean PQ(String str) {
        return "audio".equals(PX(str));
    }

    public static boolean Ot(String str) {
        return "video".equals(PX(str));
    }

    public static boolean PR(String str) {
        return "text".equals(PX(str));
    }

    public static String PS(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            String PU = PU(str2);
            if (PU != null && Ot(PU)) {
                return PU;
            }
        }
        return null;
    }

    public static String PT(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            String PU = PU(str2);
            if (PU != null && PQ(PU)) {
                return PU;
            }
        }
        return null;
    }

    public static String PU(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith(VisualSampleEntry.TYPE3) || trim.startsWith(VisualSampleEntry.TYPE4)) {
            return "video/avc";
        }
        if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (trim.startsWith(AudioSampleEntry.TYPE3)) {
            return "audio/mp4a-latm";
        }
        if (trim.startsWith(AudioSampleEntry.TYPE8) || trim.startsWith(AC3SpecificBox.TYPE)) {
            return "audio/ac3";
        }
        if (trim.startsWith(AudioSampleEntry.TYPE9) || trim.startsWith(EC3SpecificBox.TYPE)) {
            return "audio/eac3";
        }
        if (trim.startsWith("dtsc") || trim.startsWith(AudioSampleEntry.TYPE13)) {
            return "audio/vnd.dts";
        }
        if (trim.startsWith(AudioSampleEntry.TYPE12) || trim.startsWith(AudioSampleEntry.TYPE11)) {
            return "audio/vnd.dts.hd";
        }
        if (trim.startsWith("opus")) {
            return "audio/opus";
        }
        if (trim.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        return null;
    }

    public static int PV(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (PQ(str)) {
            return 1;
        }
        if (Ot(str)) {
            return 2;
        }
        if (PR(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        return ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-camera-motion".equals(str)) ? 4 : -1;
    }

    public static int PW(String str) {
        return PV(PU(str));
    }

    private static String PX(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            throw new IllegalArgumentException("Invalid mime type: " + str);
        }
        return str.substring(0, indexOf);
    }
}
