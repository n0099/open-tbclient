package com.kwai.video.player.misc;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.kwai.video.player.KsMediaMeta;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes4.dex */
public class KsMediaFormat implements IMediaFormat {
    public static final String CODEC_NAME_H264 = "h264";
    public static final String KEY_KS_BIT_RATE_UI = "ks-bit-rate-ui";
    public static final String KEY_KS_CHANNEL_UI = "ks-channel-ui";
    public static final String KEY_KS_CODEC_LONG_NAME_UI = "ks-codec-long-name-ui";
    public static final String KEY_KS_CODEC_PIXEL_FORMAT_UI = "ks-pixel-format-ui";
    public static final String KEY_KS_CODEC_PROFILE_LEVEL_UI = "ks-profile-level-ui";
    public static final String KEY_KS_FRAME_RATE_UI = "ks-frame-rate-ui";
    public static final String KEY_KS_RESOLUTION_UI = "ks-resolution-ui";
    public static final String KEY_KS_SAMPLE_RATE_UI = "ks-sample-rate-ui";
    private static final Map<String, Formatter> sFormatterMap = new HashMap();
    public final KsMediaMeta.KSYStreamMeta mMediaFormat;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class Formatter {
        private Formatter() {
        }

        protected abstract String doFormat(KsMediaFormat ksMediaFormat);

        public String format(KsMediaFormat ksMediaFormat) {
            String doFormat = doFormat(ksMediaFormat);
            return TextUtils.isEmpty(doFormat) ? getDefaultString() : doFormat;
        }

        protected String getDefaultString() {
            return "N/A";
        }
    }

    public KsMediaFormat(KsMediaMeta.KSYStreamMeta kSYStreamMeta) {
        sFormatterMap.put(KEY_KS_CODEC_LONG_NAME_UI, new Formatter() { // from class: com.kwai.video.player.misc.KsMediaFormat.1
            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            public String doFormat(KsMediaFormat ksMediaFormat) {
                return KsMediaFormat.this.mMediaFormat.getString(KsMediaMeta.KSM_KEY_CODEC_LONG_NAME);
            }
        });
        sFormatterMap.put(KEY_KS_BIT_RATE_UI, new Formatter() { // from class: com.kwai.video.player.misc.KsMediaFormat.2
            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            protected String doFormat(KsMediaFormat ksMediaFormat) {
                int integer = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_BITRATE);
                if (integer <= 0) {
                    return null;
                }
                return integer < 1000 ? String.format(Locale.US, "%d bit/s", Integer.valueOf(integer)) : String.format(Locale.US, "%d kb/s", Integer.valueOf(integer / 1000));
            }
        });
        sFormatterMap.put(KEY_KS_CODEC_PROFILE_LEVEL_UI, new Formatter() { // from class: com.kwai.video.player.misc.KsMediaFormat.3
            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            protected String doFormat(KsMediaFormat ksMediaFormat) {
                String string = ksMediaFormat.getString(KsMediaMeta.KSM_KEY_CODEC_PROFILE);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                String string2 = ksMediaFormat.getString(KsMediaMeta.KSM_KEY_CODEC_NAME);
                if (!TextUtils.isEmpty(string2) && string2.equalsIgnoreCase(KsMediaFormat.CODEC_NAME_H264)) {
                    int integer = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_CODEC_LEVEL);
                    if (integer < 10) {
                        return sb.toString();
                    }
                    sb.append(" Profile Level ");
                    sb.append((integer / 10) % 10);
                    if (integer % 10 != 0) {
                        sb.append(".");
                        sb.append(integer % 10);
                    }
                }
                return sb.toString();
            }
        });
        sFormatterMap.put(KEY_KS_CODEC_PIXEL_FORMAT_UI, new Formatter() { // from class: com.kwai.video.player.misc.KsMediaFormat.4
            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            protected String doFormat(KsMediaFormat ksMediaFormat) {
                return ksMediaFormat.getString(KsMediaMeta.KSM_KEY_CODEC_PIXEL_FORMAT);
            }
        });
        sFormatterMap.put(KEY_KS_RESOLUTION_UI, new Formatter() { // from class: com.kwai.video.player.misc.KsMediaFormat.5
            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            protected String doFormat(KsMediaFormat ksMediaFormat) {
                int integer = ksMediaFormat.getInteger("width");
                int integer2 = ksMediaFormat.getInteger("height");
                int integer3 = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_SAR_NUM);
                int integer4 = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_SAR_DEN);
                if (integer <= 0 || integer2 <= 0) {
                    return null;
                }
                return (integer3 <= 0 || integer4 <= 0) ? String.format(Locale.US, "%d x %d", Integer.valueOf(integer), Integer.valueOf(integer2)) : String.format(Locale.US, "%d x %d [SAR %d:%d]", Integer.valueOf(integer), Integer.valueOf(integer2), Integer.valueOf(integer3), Integer.valueOf(integer4));
            }
        });
        sFormatterMap.put(KEY_KS_FRAME_RATE_UI, new Formatter() { // from class: com.kwai.video.player.misc.KsMediaFormat.6
            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            protected String doFormat(KsMediaFormat ksMediaFormat) {
                int integer = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_FPS_NUM);
                int integer2 = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_FPS_DEN);
                if (integer <= 0 || integer2 <= 0) {
                    return null;
                }
                return String.valueOf(integer / integer2);
            }
        });
        sFormatterMap.put(KEY_KS_SAMPLE_RATE_UI, new Formatter() { // from class: com.kwai.video.player.misc.KsMediaFormat.7
            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            protected String doFormat(KsMediaFormat ksMediaFormat) {
                int integer = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_SAMPLE_RATE);
                if (integer <= 0) {
                    return null;
                }
                return String.format(Locale.US, "%d Hz", Integer.valueOf(integer));
            }
        });
        sFormatterMap.put(KEY_KS_CHANNEL_UI, new Formatter() { // from class: com.kwai.video.player.misc.KsMediaFormat.8
            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            protected String doFormat(KsMediaFormat ksMediaFormat) {
                int integer = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_CHANNEL_LAYOUT);
                if (integer <= 0) {
                    return null;
                }
                return ((long) integer) == 4 ? "mono" : ((long) integer) == 3 ? "stereo" : String.format(Locale.US, "%x", Integer.valueOf(integer));
            }
        });
        this.mMediaFormat = kSYStreamMeta;
    }

    @Override // com.kwai.video.player.misc.IMediaFormat
    @TargetApi(16)
    public int getInteger(String str) {
        if (this.mMediaFormat == null) {
            return 0;
        }
        return this.mMediaFormat.getInt(str);
    }

    @Override // com.kwai.video.player.misc.IMediaFormat
    public String getString(String str) {
        if (this.mMediaFormat == null) {
            return null;
        }
        return sFormatterMap.containsKey(str) ? sFormatterMap.get(str).format(this) : this.mMediaFormat.getString(str);
    }
}
