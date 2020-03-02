package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.exoplayer2.util.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes6.dex */
public final class MediaCodecUtil {
    private static final SparseIntArray mqf;
    private static final Map<String, Integer> mqg;
    private static final com.google.android.exoplayer2.mediacodec.a mqb = com.google.android.exoplayer2.mediacodec.a.Pu("OMX.google.raw.decoder");
    private static final Pattern mqc = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<com.google.android.exoplayer2.mediacodec.a>> mqd = new HashMap<>();
    private static int mqh = -1;
    private static final SparseIntArray mqe = new SparseIntArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface b {
        MediaCodecInfo Ke(int i);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int dwa();

        boolean dwb();
    }

    /* loaded from: classes6.dex */
    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    static {
        mqe.put(66, 1);
        mqe.put(77, 2);
        mqe.put(88, 4);
        mqe.put(100, 8);
        mqf = new SparseIntArray();
        mqf.put(10, 1);
        mqf.put(11, 4);
        mqf.put(12, 8);
        mqf.put(13, 16);
        mqf.put(20, 32);
        mqf.put(21, 64);
        mqf.put(22, 128);
        mqf.put(30, 256);
        mqf.put(31, 512);
        mqf.put(32, 1024);
        mqf.put(40, 2048);
        mqf.put(41, 4096);
        mqf.put(42, 8192);
        mqf.put(50, 16384);
        mqf.put(51, 32768);
        mqf.put(52, 65536);
        mqg = new HashMap();
        mqg.put("L30", 1);
        mqg.put("L60", 4);
        mqg.put("L63", 16);
        mqg.put("L90", 64);
        mqg.put("L93", 256);
        mqg.put("L120", 1024);
        mqg.put("L123", 4096);
        mqg.put("L150", 16384);
        mqg.put("L153", 65536);
        mqg.put("L156", 262144);
        mqg.put("L180", 1048576);
        mqg.put("L183", 4194304);
        mqg.put("L186", 16777216);
        mqg.put("H30", 2);
        mqg.put("H60", 8);
        mqg.put("H63", 32);
        mqg.put("H90", 128);
        mqg.put("H93", 512);
        mqg.put("H120", 2048);
        mqg.put("H123", 8192);
        mqg.put("H150", 32768);
        mqg.put("H153", 131072);
        mqg.put("H156", 524288);
        mqg.put("H180", 2097152);
        mqg.put("H183", 8388608);
        mqg.put("H186", 33554432);
    }

    public static com.google.android.exoplayer2.mediacodec.a dvY() {
        return mqb;
    }

    public static com.google.android.exoplayer2.mediacodec.a aL(String str, boolean z) throws DecoderQueryException {
        List<com.google.android.exoplayer2.mediacodec.a> aM = aM(str, z);
        if (aM.isEmpty()) {
            return null;
        }
        return aM.get(0);
    }

    public static synchronized List<com.google.android.exoplayer2.mediacodec.a> aM(String str, boolean z) throws DecoderQueryException {
        List<com.google.android.exoplayer2.mediacodec.a> list;
        synchronized (MediaCodecUtil.class) {
            a aVar = new a(str, z);
            list = mqd.get(aVar);
            if (list == null) {
                List<com.google.android.exoplayer2.mediacodec.a> a2 = a(aVar, v.SDK_INT >= 21 ? new d(z) : new c());
                if (z && a2.isEmpty() && 21 <= v.SDK_INT && v.SDK_INT <= 23) {
                    List<com.google.android.exoplayer2.mediacodec.a> a3 = a(aVar, new c());
                    if (!a3.isEmpty()) {
                        Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + a3.get(0).name);
                    }
                    a2 = a3;
                }
                fb(a2);
                list = Collections.unmodifiableList(a2);
                mqd.put(aVar, list);
            }
        }
        return list;
    }

    public static int dvZ() throws DecoderQueryException {
        int i = 0;
        if (mqh == -1) {
            com.google.android.exoplayer2.mediacodec.a aL = aL("video/avc", false);
            if (aL != null) {
                MediaCodecInfo.CodecProfileLevel[] dvN = aL.dvN();
                int length = dvN.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(Kd(dvN[i].level), i2);
                    i++;
                }
                i = Math.max(i2, v.SDK_INT >= 21 ? 345600 : 172800);
            }
            mqh = i;
        }
        return mqh;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r4.equals("hev1") != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> PC(String str) {
        char c2 = 0;
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        String str2 = split[0];
        switch (str2.hashCode()) {
            case 3006243:
                if (str2.equals(VisualSampleEntry.TYPE3)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3006244:
                if (str2.equals("avc2")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3199032:
                break;
            case 3214780:
                if (str2.equals("hvc1")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return f(str, split);
            case 2:
            case 3:
                return g(str, split);
            default:
                return null;
        }
    }

    private static List<com.google.android.exoplayer2.mediacodec.a> a(a aVar, b bVar) throws DecoderQueryException {
        String[] supportedTypes;
        try {
            ArrayList arrayList = new ArrayList();
            String str = aVar.mimeType;
            int dwa = bVar.dwa();
            boolean dwb = bVar.dwb();
            loop0: for (int i = 0; i < dwa; i++) {
                MediaCodecInfo Ke = bVar.Ke(i);
                String name = Ke.getName();
                if (a(Ke, name, dwb)) {
                    for (String str2 : Ke.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = Ke.getCapabilitiesForType(str2);
                                boolean a2 = bVar.a(str, capabilitiesForType);
                                boolean PD = PD(name);
                                if ((dwb && aVar.secure == a2) || (!dwb && !aVar.secure)) {
                                    arrayList.add(com.google.android.exoplayer2.mediacodec.a.a(name, str, capabilitiesForType, PD, false));
                                } else if (!dwb && a2) {
                                    arrayList.add(com.google.android.exoplayer2.mediacodec.a.a(name + ".secure", str, capabilitiesForType, PD, true));
                                    break loop0;
                                }
                            } catch (Exception e) {
                                if (v.SDK_INT <= 23 && !arrayList.isEmpty()) {
                                    Log.e("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
                                } else {
                                    Log.e("MediaCodecUtil", "Failed to query codec " + name + " (" + str2 + ")");
                                    throw e;
                                }
                            }
                        }
                    }
                    continue;
                }
            }
            return arrayList;
        } catch (Exception e2) {
            throw new DecoderQueryException(e2);
        }
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        if (z || !str.endsWith(".secure")) {
            if (v.SDK_INT >= 21 || !("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
                if (v.SDK_INT >= 18 || !"OMX.SEC.MP3.Decoder".equals(str)) {
                    if (v.SDK_INT < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
                        if ("a70".equals(v.mHN)) {
                            return false;
                        }
                        if ("Xiaomi".equals(v.MANUFACTURER) && v.mHN.startsWith("HM")) {
                            return false;
                        }
                    }
                    if (v.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(v.mHN) || "protou".equals(v.mHN) || "ville".equals(v.mHN) || "villeplus".equals(v.mHN) || "villec2".equals(v.mHN) || v.mHN.startsWith("gee") || "C6602".equals(v.mHN) || "C6603".equals(v.mHN) || "C6606".equals(v.mHN) || "C6616".equals(v.mHN) || "L36h".equals(v.mHN) || "SO-02E".equals(v.mHN))) {
                        return false;
                    }
                    if (v.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(v.mHN) || "C1505".equals(v.mHN) || "C1604".equals(v.mHN) || "C1605".equals(v.mHN))) {
                        return false;
                    }
                    if (v.SDK_INT >= 24 || !(("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && v.MANUFACTURER.equals("samsung") && (v.mHN.startsWith("zeroflte") || v.mHN.startsWith("zerolte") || v.mHN.startsWith("zenlte") || v.mHN.equals("SC-05G") || v.mHN.equals("marinelteatt") || v.mHN.equals("404SC") || v.mHN.equals("SC-04G") || v.mHN.equals("SCV31")))) {
                        if (v.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(v.MANUFACTURER) && (v.mHN.startsWith("d2") || v.mHN.startsWith("serrano") || v.mHN.startsWith("jflte") || v.mHN.startsWith("santos") || v.mHN.startsWith("t0"))) {
                            return false;
                        }
                        return (v.SDK_INT <= 19 && v.mHN.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) ? false : true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static void fb(List<com.google.android.exoplayer2.mediacodec.a> list) {
        if (v.SDK_INT < 26 && list.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(list.get(0).name)) {
            for (int i = 1; i < list.size(); i++) {
                com.google.android.exoplayer2.mediacodec.a aVar = list.get(i);
                if ("OMX.google.raw.decoder".equals(aVar.name)) {
                    list.remove(i);
                    list.add(0, aVar);
                    return;
                }
            }
        }
    }

    private static boolean PD(String str) {
        return v.SDK_INT <= 22 && (v.MODEL.equals("ODROID-XU3") || v.MODEL.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str));
    }

    private static Pair<Integer, Integer> f(String str, String[] strArr) {
        int i;
        if (strArr.length < 4) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        Matcher matcher = mqc.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if ("1".equals(group)) {
            i = 1;
        } else if ("2".equals(group)) {
            i = 2;
        } else {
            Log.w("MediaCodecUtil", "Unknown HEVC profile string: " + group);
            return null;
        }
        Integer num = mqg.get(strArr[3]);
        if (num == null) {
            Log.w("MediaCodecUtil", "Unknown HEVC level string: " + matcher.group(1));
            return null;
        }
        return new Pair<>(Integer.valueOf(i), num);
    }

    private static Pair<Integer, Integer> g(String str, String[] strArr) {
        Integer valueOf;
        Integer valueOf2;
        if (strArr.length < 2) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            Integer valueOf3 = Integer.valueOf(mqe.get(valueOf.intValue()));
            if (valueOf3 == null) {
                Log.w("MediaCodecUtil", "Unknown AVC profile: " + valueOf);
                return null;
            }
            Integer valueOf4 = Integer.valueOf(mqf.get(valueOf2.intValue()));
            if (valueOf4 == null) {
                Log.w("MediaCodecUtil", "Unknown AVC level: " + valueOf2);
                return null;
            }
            return new Pair<>(valueOf3, valueOf4);
        } catch (NumberFormatException e) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static int Kd(int i) {
        switch (i) {
            case 1:
            case 2:
                return 25344;
            case 8:
                return 101376;
            case 16:
                return 101376;
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
                return 414720;
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
                return 2097152;
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
                return 9437184;
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    /* loaded from: classes6.dex */
    public static final class d implements b {
        private final int mqi;
        private MediaCodecInfo[] mqj;

        public d(boolean z) {
            this.mqi = z ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public int dwa() {
            dwc();
            return this.mqj.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public MediaCodecInfo Ke(int i) {
            dwc();
            return this.mqj[i];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean dwb() {
            return true;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        private void dwc() {
            if (this.mqj == null) {
                this.mqj = new MediaCodecList(this.mqi).getCodecInfos();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c implements b {
        private c() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public int dwa() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public MediaCodecInfo Ke(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean dwb() {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final String mimeType;
        public final boolean secure;

        public a(String str, boolean z) {
            this.mimeType = str;
            this.secure = z;
        }

        public int hashCode() {
            return (this.secure ? 1231 : 1237) + (((this.mimeType == null ? 0 : this.mimeType.hashCode()) + 31) * 31);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.mimeType, aVar.mimeType) && this.secure == aVar.secure;
        }
    }
}
