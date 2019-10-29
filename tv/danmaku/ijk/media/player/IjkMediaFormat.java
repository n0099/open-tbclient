package tv.danmaku.ijk.media.player;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.DefaultConfig;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class IjkMediaFormat implements IMediaFormat {
    public static final String CODEC_NAME_H264 = "h264";
    public static final String KEY_IJK_BIT_RATE_UI = "ijk-bit-rate-ui";
    public static final String KEY_IJK_CHANNEL_UI = "ijk-channel-ui";
    public static final String KEY_IJK_CODEC_LONG_NAME_UI = "ijk-codec-long-name-ui";
    public static final String KEY_IJK_CODEC_PIXEL_FORMAT_UI = "ijk-pixel-format-ui";
    public static final String KEY_IJK_CODEC_PROFILE_LEVEL_UI = "ijk-profile-level-ui";
    public static final String KEY_IJK_FRAME_RATE_UI = "ijk-frame-rate-ui";
    public static final String KEY_IJK_RESOLUTION_UI = "ijk-resolution-ui";
    public static final String KEY_IJK_SAMPLE_RATE_UI = "ijk-sample-rate-ui";
    private static final Map<String, Formatter> sFormatterMap = new HashMap();
    public final IjkMediaMeta.IjkStreamMeta mMediaFormat;

    public IjkMediaFormat(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        sFormatterMap.put(KEY_IJK_CODEC_LONG_NAME_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.IjkMediaFormat.1
            @Override // tv.danmaku.ijk.media.player.IjkMediaFormat.Formatter
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                return IjkMediaFormat.this.mMediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_LONG_NAME);
            }
        });
        sFormatterMap.put(KEY_IJK_BIT_RATE_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.IjkMediaFormat.2
            @Override // tv.danmaku.ijk.media.player.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_BITRATE);
                if (integer <= 0) {
                    return null;
                }
                return integer < 1000 ? String.format(Locale.US, "%d bit/s", Integer.valueOf(integer)) : String.format(Locale.US, "%d kb/s", Integer.valueOf(integer / 1000));
            }
        });
        sFormatterMap.put(KEY_IJK_CODEC_PROFILE_LEVEL_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.IjkMediaFormat.3
            @Override // tv.danmaku.ijk.media.player.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                String string = ijkMediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_PROFILE);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                String string2 = ijkMediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_NAME);
                if (!TextUtils.isEmpty(string2) && string2.equalsIgnoreCase(IjkMediaFormat.CODEC_NAME_H264)) {
                    int integer = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_CODEC_LEVEL);
                    if (integer < 10) {
                        return sb.toString();
                    }
                    sb.append(" Profile Level ");
                    sb.append((integer / 10) % 10);
                    if (integer % 10 != 0) {
                        sb.append(DefaultConfig.TOKEN_SEPARATOR);
                        sb.append(integer % 10);
                    }
                }
                return sb.toString();
            }
        });
        sFormatterMap.put(KEY_IJK_CODEC_PIXEL_FORMAT_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.IjkMediaFormat.4
            @Override // tv.danmaku.ijk.media.player.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                return ijkMediaFormat.getString(IjkMediaMeta.IJKM_KEY_CODEC_PIXEL_FORMAT);
            }
        });
        sFormatterMap.put(KEY_IJK_RESOLUTION_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.IjkMediaFormat.5
            @Override // tv.danmaku.ijk.media.player.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger("width");
                int integer2 = ijkMediaFormat.getInteger("height");
                int integer3 = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_SAR_NUM);
                int integer4 = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_SAR_DEN);
                if (integer <= 0 || integer2 <= 0) {
                    return null;
                }
                return (integer3 <= 0 || integer4 <= 0) ? String.format(Locale.US, "%d x %d", Integer.valueOf(integer), Integer.valueOf(integer2)) : String.format(Locale.US, "%d x %d [SAR %d:%d]", Integer.valueOf(integer), Integer.valueOf(integer2), Integer.valueOf(integer3), Integer.valueOf(integer4));
            }
        });
        sFormatterMap.put(KEY_IJK_FRAME_RATE_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.IjkMediaFormat.6
            @Override // tv.danmaku.ijk.media.player.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_FPS_NUM);
                int integer2 = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_FPS_DEN);
                if (integer <= 0 || integer2 <= 0) {
                    return null;
                }
                return String.valueOf(integer / integer2);
            }
        });
        sFormatterMap.put(KEY_IJK_SAMPLE_RATE_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.IjkMediaFormat.7
            @Override // tv.danmaku.ijk.media.player.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE);
                if (integer <= 0) {
                    return null;
                }
                return String.format(Locale.US, "%d Hz", Integer.valueOf(integer));
            }
        });
        sFormatterMap.put(KEY_IJK_CHANNEL_UI, new Formatter() { // from class: tv.danmaku.ijk.media.player.IjkMediaFormat.8
            @Override // tv.danmaku.ijk.media.player.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(IjkMediaMeta.IJKM_KEY_CHANNEL_LAYOUT);
                if (integer <= 0) {
                    return null;
                }
                if (integer == 4) {
                    return "mono";
                }
                return ((long) integer) == 3 ? "stereo" : String.format(Locale.US, "%x", Integer.valueOf(integer));
            }
        });
        this.mMediaFormat = ijkStreamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaFormat
    public int getInteger(String str) {
        if (this.mMediaFormat == null) {
            return 0;
        }
        return this.mMediaFormat.getInt(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaFormat
    public String getString(String str) {
        if (this.mMediaFormat == null) {
            return null;
        }
        if (sFormatterMap.containsKey(str)) {
            return sFormatterMap.get(str).format(this);
        }
        return this.mMediaFormat.getString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class Formatter {
        protected abstract String doFormat(IjkMediaFormat ijkMediaFormat);

        private Formatter() {
        }

        public String format(IjkMediaFormat ijkMediaFormat) {
            String doFormat = doFormat(ijkMediaFormat);
            if (TextUtils.isEmpty(doFormat)) {
                return getDefaultString();
            }
            return doFormat;
        }

        protected String getDefaultString() {
            return "N/A";
        }
    }
}
