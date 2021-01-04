package com.kwai.video.player;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes5.dex */
public class KsMediaMeta {
    public static final long AV_CH_BACK_CENTER = 256;
    public static final long AV_CH_BACK_LEFT = 16;
    public static final long AV_CH_BACK_RIGHT = 32;
    public static final long AV_CH_FRONT_CENTER = 4;
    public static final long AV_CH_FRONT_LEFT = 1;
    public static final long AV_CH_FRONT_LEFT_OF_CENTER = 64;
    public static final long AV_CH_FRONT_RIGHT = 2;
    public static final long AV_CH_FRONT_RIGHT_OF_CENTER = 128;
    public static final long AV_CH_LAYOUT_2POINT1 = 11;
    public static final long AV_CH_LAYOUT_2_1 = 259;
    public static final long AV_CH_LAYOUT_2_2 = 1539;
    public static final long AV_CH_LAYOUT_3POINT1 = 15;
    public static final long AV_CH_LAYOUT_4POINT0 = 263;
    public static final long AV_CH_LAYOUT_4POINT1 = 271;
    public static final long AV_CH_LAYOUT_5POINT0 = 1543;
    public static final long AV_CH_LAYOUT_5POINT0_BACK = 55;
    public static final long AV_CH_LAYOUT_5POINT1 = 1551;
    public static final long AV_CH_LAYOUT_5POINT1_BACK = 63;
    public static final long AV_CH_LAYOUT_6POINT0 = 1799;
    public static final long AV_CH_LAYOUT_6POINT0_FRONT = 1731;
    public static final long AV_CH_LAYOUT_6POINT1 = 1807;
    public static final long AV_CH_LAYOUT_6POINT1_BACK = 319;
    public static final long AV_CH_LAYOUT_6POINT1_FRONT = 1739;
    public static final long AV_CH_LAYOUT_7POINT0 = 1591;
    public static final long AV_CH_LAYOUT_7POINT0_FRONT = 1735;
    public static final long AV_CH_LAYOUT_7POINT1 = 1599;
    public static final long AV_CH_LAYOUT_7POINT1_WIDE = 1743;
    public static final long AV_CH_LAYOUT_7POINT1_WIDE_BACK = 255;
    public static final long AV_CH_LAYOUT_HEXAGONAL = 311;
    public static final long AV_CH_LAYOUT_MONO = 4;
    public static final long AV_CH_LAYOUT_OCTAGONAL = 1847;
    public static final long AV_CH_LAYOUT_QUAD = 51;
    public static final long AV_CH_LAYOUT_STEREO = 3;
    public static final long AV_CH_LAYOUT_STEREO_DOWNMIX = 1610612736;
    public static final long AV_CH_LAYOUT_SURROUND = 7;
    public static final long AV_CH_LOW_FREQUENCY = 8;
    public static final long AV_CH_LOW_FREQUENCY_2 = 34359738368L;
    public static final long AV_CH_SIDE_LEFT = 512;
    public static final long AV_CH_SIDE_RIGHT = 1024;
    public static final long AV_CH_STEREO_LEFT = 536870912;
    public static final long AV_CH_STEREO_RIGHT = 1073741824;
    public static final long AV_CH_SURROUND_DIRECT_LEFT = 8589934592L;
    public static final long AV_CH_SURROUND_DIRECT_RIGHT = 17179869184L;
    public static final long AV_CH_TOP_BACK_CENTER = 65536;
    public static final long AV_CH_TOP_BACK_LEFT = 32768;
    public static final long AV_CH_TOP_BACK_RIGHT = 131072;
    public static final long AV_CH_TOP_CENTER = 2048;
    public static final long AV_CH_TOP_FRONT_CENTER = 8192;
    public static final long AV_CH_TOP_FRONT_LEFT = 4096;
    public static final long AV_CH_TOP_FRONT_RIGHT = 16384;
    public static final long AV_CH_WIDE_LEFT = 2147483648L;
    public static final long AV_CH_WIDE_RIGHT = 4294967296L;
    public static final String KSM_KEY_AUDIO_STREAM = "audio";
    public static final String KSM_KEY_BITRATE = "bitrate";
    public static final String KSM_KEY_CHANNEL_LAYOUT = "channel_layout";
    public static final String KSM_KEY_CODEC_LEVEL = "codec_level";
    public static final String KSM_KEY_CODEC_LONG_NAME = "codec_long_name";
    public static final String KSM_KEY_CODEC_NAME = "codec_name";
    public static final String KSM_KEY_CODEC_PIXEL_FORMAT = "codec_pixel_format";
    public static final String KSM_KEY_CODEC_PROFILE = "codec_profile";
    public static final String KSM_KEY_DURATION_US = "duration_us";
    public static final String KSM_KEY_FORMAT = "format";
    public static final String KSM_KEY_FPS_DEN = "fps_den";
    public static final String KSM_KEY_FPS_NUM = "fps_num";
    public static final String KSM_KEY_HEIGHT = "height";
    public static final String KSM_KEY_HTTP_ANALYZE_DNS = "analyze_dns_time";
    public static final String KSM_KEY_HTTP_CODE = "http_code";
    public static final String KSM_KEY_HTTP_CONNECT_TIME = "connect_time";
    public static final String KSM_KEY_HTTP_CONTENT_LENGHT = "http_content_length";
    public static final String KSM_KEY_HTTP_CONTENT_RANGE = "http_content_range";
    public static final String KSM_KEY_HTTP_FIRST_DATA_TIME = "first_data_time";
    public static final String KSM_KEY_HTTP_REDIRECT = "http_redirect";
    public static final String KSM_KEY_HTTP_X_CACHE = "http_x_cache";
    public static final String KSM_KEY_LANGUAGE = "language";
    public static final String KSM_KEY_SAMPLE_RATE = "sample_rate";
    public static final String KSM_KEY_SAR_DEN = "sar_den";
    public static final String KSM_KEY_SAR_NUM = "sar_num";
    public static final String KSM_KEY_START_US = "start_us";
    public static final String KSM_KEY_STREAMID = "streamId";
    public static final String KSM_KEY_STREAMS = "streams";
    public static final String KSM_KEY_TBR_DEN = "tbr_den";
    public static final String KSM_KEY_TBR_NUM = "tbr_num";
    public static final String KSM_KEY_TYPE = "type";
    public static final String KSM_KEY_VIDEO_STREAM = "video";
    public static final String KSM_KEY_WIDTH = "width";
    public static final String KSM_VAL_TYPE__AUDIO = "audio";
    public static final String KSM_VAL_TYPE__UNKNOWN = "unknown";
    public static final String KSM_VAL_TYPE__VIDEO = "video";
    public int mAnalyzeDnsTime;
    public KSYStreamMeta mAudioStream;
    public long mBitrate;
    public long mDurationUS;
    public String mFormat;
    public int mHttpCode;
    public String mHttpContentLength;
    public String mHttpContentRange;
    public String mHttpRedirect;
    public String mHttpXCache;
    public Bundle mMediaMeta;
    public long mStartUS;
    public String mStreamId;
    public KSYStreamMeta mVideoStream;
    public final ArrayList<KSYStreamMeta> mStreams = new ArrayList<>();
    public int mHttpConnectTime = 0;
    public int mHttpFirstDataTime = 0;

    /* loaded from: classes5.dex */
    public static class KSYStreamMeta {
        public long mBitrate;
        public long mChannelLayout;
        public String mCodecLongName;
        public String mCodecName;
        public String mCodecProfile;
        public int mFpsDen;
        public int mFpsNum;
        public int mHeight;
        public final int mIndex;
        public String mLanguage;
        public Bundle mMeta;
        public int mSampleRate;
        public int mSarDen;
        public int mSarNum;
        public int mTbrDen;
        public int mTbrNum;
        public String mType;
        public int mWidth;

        public KSYStreamMeta(int i) {
            this.mIndex = i;
        }

        public String getBitrateInline() {
            return this.mBitrate <= 0 ? "N/A" : this.mBitrate < 1000 ? String.format(Locale.US, "%d bit/s", Long.valueOf(this.mBitrate)) : String.format(Locale.US, "%d kb/s", Long.valueOf(this.mBitrate / 1000));
        }

        public String getChannelLayoutInline() {
            return this.mChannelLayout <= 0 ? "N/A" : this.mChannelLayout == 4 ? "mono" : this.mChannelLayout == 3 ? "stereo" : String.format(Locale.US, "%x", Long.valueOf(this.mChannelLayout));
        }

        public String getCodecLongNameInline() {
            return !TextUtils.isEmpty(this.mCodecLongName) ? this.mCodecLongName : !TextUtils.isEmpty(this.mCodecName) ? this.mCodecName : "N/A";
        }

        public String getCodecShortNameInline() {
            return !TextUtils.isEmpty(this.mCodecName) ? this.mCodecName : "N/A";
        }

        public String getFpsInline() {
            return (this.mFpsNum <= 0 || this.mFpsDen <= 0) ? "N/A" : String.valueOf(this.mFpsNum / this.mFpsDen);
        }

        public int getInt(String str) {
            return getInt(str, 0);
        }

        public int getInt(String str, int i) {
            String string = getString(str);
            if (TextUtils.isEmpty(string)) {
                return i;
            }
            try {
                return Integer.parseInt(string);
            } catch (NumberFormatException e) {
                return i;
            }
        }

        public long getLong(String str) {
            return getLong(str, 0L);
        }

        public long getLong(String str, long j) {
            String string = getString(str);
            if (TextUtils.isEmpty(string)) {
                return j;
            }
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException e) {
                return j;
            }
        }

        public String getResolutionInline() {
            return (this.mWidth <= 0 || this.mHeight <= 0) ? "N/A" : (this.mSarNum <= 0 || this.mSarDen <= 0) ? String.format(Locale.US, "%d x %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)) : String.format(Locale.US, "%d x %d [SAR %d:%d]", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mSarNum), Integer.valueOf(this.mSarDen));
        }

        public String getSampleRateInline() {
            return this.mSampleRate <= 0 ? "N/A" : String.format(Locale.US, "%d Hz", Integer.valueOf(this.mSampleRate));
        }

        public String getString(String str) {
            return this.mMeta.getString(str);
        }
    }

    public static KsMediaMeta parse(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        KsMediaMeta ksMediaMeta = new KsMediaMeta();
        ksMediaMeta.mMediaMeta = bundle;
        ksMediaMeta.mFormat = ksMediaMeta.getString(KSM_KEY_FORMAT);
        ksMediaMeta.mDurationUS = ksMediaMeta.getLong(KSM_KEY_DURATION_US);
        ksMediaMeta.mStartUS = ksMediaMeta.getLong(KSM_KEY_START_US);
        ksMediaMeta.mBitrate = ksMediaMeta.getLong(KSM_KEY_BITRATE);
        int i = ksMediaMeta.getInt("video", -1);
        int i2 = ksMediaMeta.getInt("audio", -1);
        ksMediaMeta.mFormat = ksMediaMeta.getString(KSM_KEY_HTTP_X_CACHE);
        ksMediaMeta.mHttpRedirect = ksMediaMeta.getString(KSM_KEY_HTTP_REDIRECT);
        ksMediaMeta.mHttpContentRange = ksMediaMeta.getString(KSM_KEY_HTTP_CONTENT_RANGE);
        ksMediaMeta.mHttpContentLength = ksMediaMeta.getString(KSM_KEY_HTTP_CONTENT_LENGHT);
        ksMediaMeta.mAnalyzeDnsTime = ksMediaMeta.getInt(KSM_KEY_HTTP_ANALYZE_DNS, 0);
        ksMediaMeta.mHttpCode = ksMediaMeta.getInt("http_code", 0);
        ksMediaMeta.mStreamId = ksMediaMeta.getString(KSM_KEY_STREAMID);
        try {
            if (ksMediaMeta.getString(KSM_KEY_HTTP_CONNECT_TIME) != null) {
                ksMediaMeta.mHttpConnectTime = new Double(ksMediaMeta.getString(KSM_KEY_HTTP_CONNECT_TIME)).intValue();
            }
            if (ksMediaMeta.getString(KSM_KEY_HTTP_FIRST_DATA_TIME) != null) {
                ksMediaMeta.mHttpFirstDataTime = new Double(ksMediaMeta.getString(KSM_KEY_HTTP_FIRST_DATA_TIME)).intValue();
            }
        } catch (NumberFormatException e) {
            ksMediaMeta.mHttpConnectTime = 0;
            ksMediaMeta.mHttpFirstDataTime = 0;
        }
        ArrayList<Bundle> parcelableArrayList = ksMediaMeta.getParcelableArrayList(KSM_KEY_STREAMS);
        if (parcelableArrayList == null) {
            return ksMediaMeta;
        }
        Iterator<Bundle> it = parcelableArrayList.iterator();
        int i3 = -1;
        while (it.hasNext()) {
            Bundle next = it.next();
            i3++;
            if (next != null) {
                KSYStreamMeta kSYStreamMeta = new KSYStreamMeta(i3);
                kSYStreamMeta.mMeta = next;
                kSYStreamMeta.mType = kSYStreamMeta.getString("type");
                kSYStreamMeta.mLanguage = kSYStreamMeta.getString(KSM_KEY_LANGUAGE);
                if (!TextUtils.isEmpty(kSYStreamMeta.mType)) {
                    kSYStreamMeta.mCodecName = kSYStreamMeta.getString(KSM_KEY_CODEC_NAME);
                    kSYStreamMeta.mCodecProfile = kSYStreamMeta.getString(KSM_KEY_CODEC_PROFILE);
                    kSYStreamMeta.mCodecLongName = kSYStreamMeta.getString(KSM_KEY_CODEC_LONG_NAME);
                    kSYStreamMeta.mBitrate = kSYStreamMeta.getInt(KSM_KEY_BITRATE);
                    if (kSYStreamMeta.mType.equalsIgnoreCase("video")) {
                        kSYStreamMeta.mWidth = kSYStreamMeta.getInt("width");
                        kSYStreamMeta.mHeight = kSYStreamMeta.getInt("height");
                        kSYStreamMeta.mFpsNum = kSYStreamMeta.getInt(KSM_KEY_FPS_NUM);
                        kSYStreamMeta.mFpsDen = kSYStreamMeta.getInt(KSM_KEY_FPS_DEN);
                        kSYStreamMeta.mTbrNum = kSYStreamMeta.getInt(KSM_KEY_TBR_NUM);
                        kSYStreamMeta.mTbrDen = kSYStreamMeta.getInt(KSM_KEY_TBR_DEN);
                        kSYStreamMeta.mSarNum = kSYStreamMeta.getInt(KSM_KEY_SAR_NUM);
                        kSYStreamMeta.mSarDen = kSYStreamMeta.getInt(KSM_KEY_SAR_DEN);
                        if (i == i3) {
                            ksMediaMeta.mVideoStream = kSYStreamMeta;
                        }
                    } else if (kSYStreamMeta.mType.equalsIgnoreCase("audio")) {
                        kSYStreamMeta.mSampleRate = kSYStreamMeta.getInt(KSM_KEY_SAMPLE_RATE);
                        kSYStreamMeta.mChannelLayout = kSYStreamMeta.getLong(KSM_KEY_CHANNEL_LAYOUT);
                        if (i2 == i3) {
                            ksMediaMeta.mAudioStream = kSYStreamMeta;
                        }
                    }
                    ksMediaMeta.mStreams.add(kSYStreamMeta);
                }
            }
        }
        return ksMediaMeta;
    }

    public String getDurationInline() {
        long j = (this.mDurationUS + 5000) / TimeUtils.NANOS_PER_MS;
        long j2 = j / 60;
        return String.format(Locale.US, "%02d:%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60), Long.valueOf(j % 60));
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return i;
        }
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public long getLong(String str, long j) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return j;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public ArrayList<Bundle> getParcelableArrayList(String str) {
        return this.mMediaMeta.getParcelableArrayList(str);
    }

    public String getString(String str) {
        return this.mMediaMeta.getString(str);
    }
}
