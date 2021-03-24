package com.kwai.video.player;
/* loaded from: classes6.dex */
public interface PlayerSettingConstants {
    public static final String AUDIO_STR_DEFAULT = "0";
    public static final int AudioMonoType_Left = 1;
    public static final int AudioMonoType_None = 0;
    public static final int AudioMonoType_Right = 2;
    public static final int DEVICE_OUT_SPEAKER = 1;
    public static final int DEVICE_OUT_UNKNOWN = 0;
    public static final int FLAG_KWAI_USE_MEDIACODEC_ALL = 4096;
    public static final int FLAG_KWAI_USE_MEDIACODEC_H264 = 1;
    public static final int FLAG_KWAI_USE_MEDIACODEC_H265 = 2;
    public static final int KS_LOG_DEBUG = 3;
    public static final int KS_LOG_DEFAULT = 1;
    public static final int KS_LOG_ERROR = 6;
    public static final int KS_LOG_FATAL = 7;
    public static final int KS_LOG_INFO = 4;
    public static final int KS_LOG_SILENT = 8;
    public static final int KS_LOG_UNKNOWN = 0;
    public static final int KS_LOG_VERBOSE = 2;
    public static final int KS_LOG_WARN = 5;
    public static final int LIVE_MANIFEST_AUTO = -1;
    public static final int LIVE_MANIFEST_REP_INDEX_1 = 0;
    public static final int LIVE_MANIFEST_REP_INDEX_2 = 1;
    public static final int LIVE_MANIFEST_REP_INDEX_3 = 2;
    public static final int LIVE_MANIFEST_REP_INDEX_4 = 3;
    public static final int LIVE_MANIFEST_REP_INDEX_5 = 4;
    public static final int LIVE_MANIFEST_REP_INDEX_6 = 5;
    public static final int MaxBufStrategy_BeforeStartPlayControl = 1;
    public static final int MaxBufStrategy_None = 0;
    public static final int MaxBufStrategy_ProgressToMax = 2;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int PRE_DEMUX_VER_1 = 1;
    public static final int PRE_DEMUX_VER_2 = 2;
    public static final int SDL_FCC_I420 = 808596553;
    public static final int SDL_FCC_NV21 = 825382478;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    public static final int SDL_FCC__GLES2 = 844318047;
    public static final int VIDEO_PICTURE_QUEUE_SIZE_MAX = 16;
    public static final int VIDEO_PICTURE_QUEUE_SIZE_MIN = 3;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;

    /* loaded from: classes.dex */
    public @interface AudioMonoType {
    }

    /* loaded from: classes.dex */
    public @interface DeviceOut {
    }

    /* loaded from: classes.dex */
    public @interface KFlvSwitchMode {
    }

    /* loaded from: classes.dex */
    public @interface LogLevel {
    }

    /* loaded from: classes.dex */
    public @interface MaxBufferStrategy {
    }

    /* loaded from: classes.dex */
    public @interface OptionType {
    }

    /* loaded from: classes.dex */
    public @interface OverlayFormat {
    }

    /* loaded from: classes.dex */
    public @interface ScalingMode {
    }

    /* loaded from: classes.dex */
    public @interface UseHardwareDecoderFlag {
    }
}
