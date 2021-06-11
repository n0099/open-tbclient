package com.kwai.video.player;
/* loaded from: classes7.dex */
public interface PlayerPostEvent {
    public static final int MEDIA_BUFFERING_UPDATE = 3;
    public static final int MEDIA_ERROR = 100;
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO = 200;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START_AFTER_SEEK = 10004;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_LIVE_TYPE_CHANGE = 10102;
    public static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_PLAYBACK_STATE_CHANGED = 10103;
    public static final int MEDIA_INFO_PLAY_TO_END = 10101;
    public static final int MEDIA_INFO_PRELOAD_FINISH = 10105;
    public static final int MEDIA_INFO_RELOADED_VIDEO_RENDERING_START = 10104;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START_AFTER_SEEK = 10003;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int MEDIA_LIVE_VC_TIME = 300;
    public static final int MEDIA_NOP = 0;
    public static final int MEDIA_PLAYBACK_COMPLETE = 2;
    public static final int MEDIA_PREPARED = 1;
    public static final int MEDIA_REP_CHANGE_END = 12002;
    public static final int MEDIA_REP_CHANGE_START = 12001;
    public static final int MEDIA_SEEK_COMPLETE = 4;
    public static final int MEDIA_SET_VIDEO_SAR = 10001;
    public static final int MEDIA_SET_VIDEO_SIZE = 5;
    public static final int MEDIA_TIMED_TEXT = 99;

    /* loaded from: classes7.dex */
    public @interface MediaErrorType {
    }

    /* loaded from: classes7.dex */
    public @interface MediaEventType {
    }

    /* loaded from: classes7.dex */
    public @interface MediaInfoType {
    }
}
