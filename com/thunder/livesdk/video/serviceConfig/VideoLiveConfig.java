package com.thunder.livesdk.video.serviceConfig;

import java.util.List;
/* loaded from: classes4.dex */
public class VideoLiveConfig {
    public int bframeswitch;
    public int entEncode;
    public int intervalSecs;
    public int playType;
    public List<ResolutionInfo> resolutions;

    /* loaded from: classes4.dex */
    public class ResolutionInfo {
        public int bframeNum;
        public int codeRate;
        public int currate;
        public String description;
        public int encode_id;
        public String encode_param;
        public int frameRate;
        public int height;
        public int isDefault;
        public int key;
        public int maxUsers;
        public int maxrate;
        public int minUsers;
        public int minrate;
        public List<ModifyInfo> modifyConfig;
        public int previewFrameRate;
        public int previewHeight;
        public int previewWidth;
        public int transcoding;
        public int width;

        public ResolutionInfo() {
        }
    }

    /* loaded from: classes4.dex */
    public class ModifyInfo {
        public int encode_id;
        public String encode_param;
        public int height;
        public int maxCodeRate;
        public int maxFrameRate;
        public int minCodeRate;
        public int minFrameRate;
        public int width;

        public ModifyInfo() {
        }
    }

    /* loaded from: classes4.dex */
    public class EncodeType {
        public static final int PHONE_CODEC_HW_H264 = 200;
        public static final int PHONE_CODEC_HW_H265 = 220;
        public static final int PHONE_CODEC_X264 = 201;
        public static final int PHONE_CODEC_X265 = 221;

        public EncodeType() {
        }
    }

    /* loaded from: classes4.dex */
    public class DecodeType {
        public static final int CODEC_DECODEC_H264_HW = 1;
        public static final int CODEC_DECODEC_H264_SOFT = 0;
        public static final int CODEC_DECODEC_H265_HW = 2;
        public static final int CODEC_DECODEC_H265_NO = 0;
        public static final int CODEC_DECODEC_H265_SOFT = 1;

        public DecodeType() {
        }
    }

    /* loaded from: classes4.dex */
    class PreviewType {
        public static final int PREVIEW_TYPE_NO_SHARE_CTX = 0;
        public static final int PREVIEW_TYPE_SHARE_CTX = 1;

        PreviewType() {
        }
    }

    /* loaded from: classes4.dex */
    class UseClear {
        public static final int NOT_USE_CLEAR = 0;
        public static final int USE_CLEAR = 1;

        UseClear() {
        }
    }

    /* loaded from: classes4.dex */
    public class StreamType {
        public static final int STREAM_TYPE_H264 = 1;
        public static final int STREAM_TYPE_H265 = 2;

        public StreamType() {
        }
    }

    /* loaded from: classes4.dex */
    public class PlayType {
        public static final int ACROSS = 3;
        public static final int ARENA_CROSS = 4;
        public static final int BEAUTIFYLEVEL = 11;
        public static final int BLACKENCODEC = 12;
        public static final int LIANMAI = 1;
        public static final int MULIT_LIVE = 6;
        public static final int MULIT_LIVE_LIANMAI = 7;
        public static final int ONE_TO_ONE = 8;
        public static final int ORIGIN_STREAM = 14;
        public static final int PLAYER_H264 = 9;
        public static final int PLAYER_H265 = 10;
        public static final int PLAYTRANSCODING = 13;
        public static final int PREVIEW_SHARECTX = 16;
        public static final int SCREEN_CAPTURE = 5;
        public static final int SINGLE = 0;
        public static final int TOTAL_TYPE = 15;
        public static final int USE_GLCLEAR = 17;

        public PlayType() {
        }
    }
}
