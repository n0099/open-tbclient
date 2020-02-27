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
    private static final SparseIntArray mqd;
    private static final Map<String, Integer> mqe;
    private static final com.google.android.exoplayer2.mediacodec.a mpZ = com.google.android.exoplayer2.mediacodec.a.Pu("OMX.google.raw.decoder");
    private static final Pattern mqa = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<com.google.android.exoplayer2.mediacodec.a>> mqb = new HashMap<>();
    private static int mqf = -1;
    private static final SparseIntArray mqc = new SparseIntArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface b {
        MediaCodecInfo Ke(int i);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int dvY();

        boolean dvZ();
    }

    /* loaded from: classes6.dex */
    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    static {
        mqc.put(66, 1);
        mqc.put(77, 2);
        mqc.put(88, 4);
        mqc.put(100, 8);
        mqd = new SparseIntArray();
        mqd.put(10, 1);
        mqd.put(11, 4);
        mqd.put(12, 8);
        mqd.put(13, 16);
        mqd.put(20, 32);
        mqd.put(21, 64);
        mqd.put(22, 128);
        mqd.put(30, 256);
        mqd.put(31, 512);
        mqd.put(32, 1024);
        mqd.put(40, 2048);
        mqd.put(41, 4096);
        mqd.put(42, 8192);
        mqd.put(50, 16384);
        mqd.put(51, 32768);
        mqd.put(52, 65536);
        mqe = new HashMap();
        mqe.put("L30", 1);
        mqe.put("L60", 4);
        mqe.put("L63", 16);
        mqe.put("L90", 64);
        mqe.put("L93", 256);
        mqe.put("L120", 1024);
        mqe.put("L123", 4096);
        mqe.put("L150", 16384);
        mqe.put("L153", 65536);
        mqe.put("L156", 262144);
        mqe.put("L180", 1048576);
        mqe.put("L183", 4194304);
        mqe.put("L186", 16777216);
        mqe.put("H30", 2);
        mqe.put("H60", 8);
        mqe.put("H63", 32);
        mqe.put("H90", 128);
        mqe.put("H93", 512);
        mqe.put("H120", 2048);
        mqe.put("H123", 8192);
        mqe.put("H150", 32768);
        mqe.put("H153", 131072);
        mqe.put("H156", 524288);
        mqe.put("H180", 2097152);
        mqe.put("H183", 8388608);
        mqe.put("H186", 33554432);
    }

    public static com.google.android.exoplayer2.mediacodec.a dvW() {
        return mpZ;
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
            list = mqb.get(aVar);
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
                mqb.put(aVar, list);
            }
        }
        return list;
    }

    public static int dvX() throws DecoderQueryException {
        int i = 0;
        if (mqf == -1) {
            com.google.android.exoplayer2.mediacodec.a aL = aL("video/avc", false);
            if (aL != null) {
                MediaCodecInfo.CodecProfileLevel[] dvL = aL.dvL();
                int length = dvL.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(Kd(dvL[i].level), i2);
                    i++;
                }
                i = Math.max(i2, v.SDK_INT >= 21 ? 345600 : 172800);
            }
            mqf = i;
        }
        return mqf;
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
            int dvY = bVar.dvY();
            boolean dvZ = bVar.dvZ();
            loop0: for (int i = 0; i < dvY; i++) {
                MediaCodecInfo Ke = bVar.Ke(i);
                String name = Ke.getName();
                if (a(Ke, name, dvZ)) {
                    for (String str2 : Ke.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = Ke.getCapabilitiesForType(str2);
                                boolean a2 = bVar.a(str, capabilitiesForType);
                                boolean PD = PD(name);
                                if ((dvZ && aVar.secure == a2) || (!dvZ && !aVar.secure)) {
                                    arrayList.add(com.google.android.exoplayer2.mediacodec.a.a(name, str, capabilitiesForType, PD, false));
                                } else if (!dvZ && a2) {
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
                        if ("a70".equals(v.mHL)) {
                            return false;
                        }
                        if ("Xiaomi".equals(v.MANUFACTURER) && v.mHL.startsWith("HM")) {
                            return false;
                        }
                    }
                    if (v.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(v.mHL) || "protou".equals(v.mHL) || "ville".equals(v.mHL) || "villeplus".equals(v.mHL) || "villec2".equals(v.mHL) || v.mHL.startsWith("gee") || "C6602".equals(v.mHL) || "C6603".equals(v.mHL) || "C6606".equals(v.mHL) || "C6616".equals(v.mHL) || "L36h".equals(v.mHL) || "SO-02E".equals(v.mHL))) {
                        return false;
                    }
                    if (v.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(v.mHL) || "C1505".equals(v.mHL) || "C1604".equals(v.mHL) || "C1605".equals(v.mHL))) {
                        return false;
                    }
                    if (v.SDK_INT >= 24 || !(("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && v.MANUFACTURER.equals("samsung") && (v.mHL.startsWith("zeroflte") || v.mHL.startsWith("zerolte") || v.mHL.startsWith("zenlte") || v.mHL.equals("SC-05G") || v.mHL.equals("marinelteatt") || v.mHL.equals("404SC") || v.mHL.equals("SC-04G") || v.mHL.equals("SCV31")))) {
                        if (v.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(v.MANUFACTURER) && (v.mHL.startsWith("d2") || v.mHL.startsWith("serrano") || v.mHL.startsWith("jflte") || v.mHL.startsWith("santos") || v.mHL.startsWith("t0"))) {
                            return false;
                        }
                        return (v.SDK_INT <= 19 && v.mHL.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) ? false : true;
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
        Matcher matcher = mqa.matcher(strArr[1]);
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
        Integer num = mqe.get(strArr[3]);
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
            Integer valueOf3 = Integer.valueOf(mqc.get(valueOf.intValue()));
            if (valueOf3 == null) {
                Log.w("MediaCodecUtil", "Unknown AVC profile: " + valueOf);
                return null;
            }
            Integer valueOf4 = Integer.valueOf(mqd.get(valueOf2.intValue()));
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
        private final int mqg;
        private MediaCodecInfo[] mqh;

        public d(boolean z) {
            this.mqg = z ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public int dvY() {
            dwa();
            return this.mqh.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public MediaCodecInfo Ke(int i) {
            dwa();
            return this.mqh[i];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean dvZ() {
            return true;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        private void dwa() {
            if (this.mqh == null) {
                this.mqh = new MediaCodecList(this.mqg).getCodecInfos();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c implements b {
        private c() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public int dvY() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public MediaCodecInfo Ke(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean dvZ() {
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
