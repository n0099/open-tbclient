package com.thunder.livesdk;
/* loaded from: classes4.dex */
public final class ThunderRtcConstant {

    /* loaded from: classes4.dex */
    public static final class AreaType {
        public static final int THUNDER_AREA_DEFAULT = 0;
        public static final int THUNDER_AREA_FOREIGN = 1;
        public static final int THUNDER_AREA_PRIVATE = 10;
        public static final int THUNDER_AREA_RESERVED = 2;
    }

    /* loaded from: classes4.dex */
    public static final class AudioConfig {
        public static final int THUNDER_AUDIO_CONFIG_DEFAULT = 0;
        public static final int THUNDER_AUDIO_CONFIG_MUSIC_HIGH_QUALITY_STEREO = 4;
        public static final int THUNDER_AUDIO_CONFIG_MUSIC_HIGH_QUALITY_STEREO_192 = 5;
        public static final int THUNDER_AUDIO_CONFIG_MUSIC_HIGH_QUALITY_STEREO_192_PRO = 9;
        public static final int THUNDER_AUDIO_CONFIG_MUSIC_HIGH_QUALITY_STEREO_PRO = 8;
        public static final int THUNDER_AUDIO_CONFIG_MUSIC_STANDARD = 3;
        public static final int THUNDER_AUDIO_CONFIG_MUSIC_STANDARD_PRO = 7;
        public static final int THUNDER_AUDIO_CONFIG_MUSIC_STANDARD_STEREO = 2;
        public static final int THUNDER_AUDIO_CONFIG_MUSIC_STANDARD_STEREO_LOW_DELAY = 10;
        public static final int THUNDER_AUDIO_CONFIG_SPEECH_STANDARD = 1;
        public static final int THUNDER_AUDIO_CONFIG_SPEECH_STANDARD_PRO = 6;
    }

    /* loaded from: classes4.dex */
    public static final class AudioSaverMode {
        public static final int THUNDER_AUDIO_SAVER_BOTH = 2;
        public static final int THUNDER_AUDIO_SAVER_ONLY_CAPTURE = 0;
        public static final int THUNDER_AUDIO_SAVER_ONLY_RENDER = 1;
    }

    /* loaded from: classes4.dex */
    public static final class AudioSaverQuality {
        public static final int THUNDER_AUDIO_SAVER_QUALITY_HIGH = 2;
        public static final int THUNDER_AUDIO_SAVER_QUALITY_LOW = 0;
        public static final int THUNDER_AUDIO_SAVER_QUALITY_MEDIUM = 1;
    }

    /* loaded from: classes4.dex */
    public static final class AudioSaverWfMode {
        public static final int THUNDER_AUDIO_SAVER_FILE_APPEND = 0;
        public static final int THUNDER_AUDIO_SAVER_FILE_OVERRIDE = 1;
    }

    /* loaded from: classes4.dex */
    public static final class AuthResult {
        public static final int THUNDER_AUTHRES_ERR_APPID = 10003;
        public static final int THUNDER_AUTHRES_ERR_BAND = 10008;
        public static final int THUNDER_AUTHRES_ERR_NO_APP = 10006;
        public static final int THUNDER_AUTHRES_ERR_NO_TOKEN = 10001;
        public static final int THUNDER_AUTHRES_ERR_SERVER_INTERNAL = 10000;
        public static final int THUNDER_AUTHRES_ERR_TOKEN_ERR = 10002;
        public static final int THUNDER_AUTHRES_ERR_TOKEN_EXPIRE = 10005;
        public static final int THUNDER_AUTHRES_ERR_TOKEN_WILL_EXPIRE = 10007;
        public static final int THUNDER_AUTHRES_ERR_UID = 10004;
        public static final int THUNDER_AUTHRES_SUCCUSS = 0;
    }

    /* loaded from: classes4.dex */
    public static final class CommutMode {
        public static final int THUNDER_COMMUT_MODE_DEFAULT = 0;
        public static final int THUNDER_COMMUT_MODE_HIGH = 1;
        public static final int THUNDER_COMMUT_MODE_LOW = 2;
    }

    /* loaded from: classes4.dex */
    public static final class CompressorParam {
        public int mThreshold = 0;
        public int mMakeupGain = 0;
        public int mRatio = 0;
        public int mKnee = 0;
        public int mReleaseTime = 0;
        public int mAttackTime = 0;
    }

    /* loaded from: classes4.dex */
    public static final class DecoderType {
        public static final int THUNDER_FORCE_CANCEL = 2;
        public static final int THUNDER_FORCE_HARD_DECODE = 1;
        public static final int THUNDER_FORCE_SOFT_DECODE = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ExternalVideoPixelFormat {
        public static final int THUNDER_PIXEL_FORMAT_I420 = 1;
        public static final int THUNDER_PIXEL_FORMAT_NV21 = 2;
        public static final int THUNDER_PIXEL_FORMAT_RGBA = 0;
    }

    /* loaded from: classes4.dex */
    public static final class LimterParam {
        public float fCeiling = 0.0f;
        public float fThreshold = 0.0f;
        public float fPreGain = 0.0f;
        public float fRelease = 0.0f;
        public float fAttack = 0.0f;
        public float fLookahead = 0.0f;
        public float fLookaheadRatio = 0.0f;
        public float fRMS = 0.0f;
        public float fStLink = 0.0f;
    }

    /* loaded from: classes4.dex */
    public static final class LiveBizAuthStreamType {
        public static final int LIVE_BIZ_AUTH_STREAM_AUDIO = 2;
        public static final int LIVE_BIZ_AUTH_STREAM_VIDEO = 1;
    }

    /* loaded from: classes4.dex */
    public static final class LiveEngineCaptureType {
        public static final int THUNDER_CAPTURE_TYPE_DEFAULT_CAMERA = 0;
        public static final int THUNDER_CAPTURE_TYPE_EXTERNAL_SOURCE = 2;
        public static final int THUNDER_CAPTURE_TYPE_SCREEN_RECORD = 1;
    }

    /* loaded from: classes4.dex */
    public static final class LiveTranscodingMode {
        public static final int TRANSCODING_MODE_1280X720 = 6;
        public static final int TRANSCODING_MODE_1920X1080 = 7;
        public static final int TRANSCODING_MODE_320X180 = 1;
        public static final int TRANSCODING_MODE_320X240 = 2;
        public static final int TRANSCODING_MODE_640X360 = 3;
        public static final int TRANSCODING_MODE_640X480 = 4;
        public static final int TRANSCODING_MODE_960X544 = 5;
    }

    /* loaded from: classes4.dex */
    public static final class LocalAudioStreamErrorReason {
        public static final int THUNDER_LOCAL_AUDIO_STREAM_ERROR_CAPTURE_FAILURE = 2;
        public static final int THUNDER_LOCAL_AUDIO_STREAM_ERROR_DEVICE_BUSY = 13;
        public static final int THUNDER_LOCAL_AUDIO_STREAM_ERROR_DEVICE_NO_PERMISSION = 12;
        public static final int THUNDER_LOCAL_AUDIO_STREAM_ERROR_ENCODE_FAILURE = 3;
        public static final int THUNDER_LOCAL_AUDIO_STREAM_ERROR_OK = 0;
        public static final int THUNDER_LOCAL_AUDIO_STREAM_ERROR_UNKNOWN = 1;
    }

    /* loaded from: classes4.dex */
    public static final class LocalAudioStreamStatus {
        public static final int THUNDER_LOCAL_AUDIO_STREAM_STATUS_CAPTURING = 1;
        public static final int THUNDER_LOCAL_AUDIO_STREAM_STATUS_ENCODING = 2;
        public static final int THUNDER_LOCAL_AUDIO_STREAM_STATUS_FAILED = 4;
        public static final int THUNDER_LOCAL_AUDIO_STREAM_STATUS_SENDING = 3;
        public static final int THUNDER_LOCAL_AUDIO_STREAM_STATUS_STOPPED = 0;
    }

    /* loaded from: classes4.dex */
    public static final class LocalVideoStreamErrorReason {
        public static final int THUNDER_LOCAL_VIDEO_STREAM_ERROR_CAPTURE_FAILURE = 4;
        public static final int THUNDER_LOCAL_VIDEO_STREAM_ERROR_DEVICE_DENIED = 2;
        public static final int THUNDER_LOCAL_VIDEO_STREAM_ERROR_DEVICE_RESTRICTED = 3;
        public static final int THUNDER_LOCAL_VIDEO_STREAM_ERROR_ENCODE_FAILURE = 5;
        public static final int THUNDER_LOCAL_VIDEO_STREAM_ERROR_FAILURE = 1;
        public static final int THUNDER_LOCAL_VIDEO_STREAM_ERROR_OK = 0;
    }

    /* loaded from: classes4.dex */
    public static final class LocalVideoStreamStatus {
        public static final int THUNDER_LOCAL_VIDEO_STREAM_STATUS_CAPTURING = 1;
        public static final int THUNDER_LOCAL_VIDEO_STREAM_STATUS_ENCODING = 3;
        public static final int THUNDER_LOCAL_VIDEO_STREAM_STATUS_FAILED = 5;
        public static final int THUNDER_LOCAL_VIDEO_STREAM_STATUS_PREVIEWING = 2;
        public static final int THUNDER_LOCAL_VIDEO_STREAM_STATUS_SENDING = 4;
        public static final int THUNDER_LOCAL_VIDEO_STREAM_STATUS_STOPPED = 0;
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public static final class LogLevel {
        public static final int THUNDER_LOG_LEVEL_DEBUG = 1;
        public static final int THUNDER_LOG_LEVEL_ERROR = 4;
        public static final int THUNDER_LOG_LEVEL_INFO = 2;
        public static final int THUNDER_LOG_LEVEL_TRACE = 0;
        public static final int THUNDER_LOG_LEVEL_WARN = 3;
    }

    /* loaded from: classes4.dex */
    public static final class NetworkQuality {
        public static final int THUNDER_QUALITY_BAD = 4;
        public static final int THUNDER_QUALITY_DOWN = 6;
        public static final int THUNDER_QUALITY_EXCELLENT = 1;
        public static final int THUNDER_QUALITY_GOOD = 2;
        public static final int THUNDER_QUALITY_POOR = 3;
        public static final int THUNDER_QUALITY_UNKNOWN = 0;
        public static final int THUNDER_QUALITY_VBAD = 5;
    }

    /* loaded from: classes4.dex */
    public static final class RemoteAudioReason {
        public static final int THUNDER_REMOTE_AUDIO_REASON_FORMAT_NOT_SUPPORT = 9;
        public static final int THUNDER_REMOTE_AUDIO_REASON_INTERNAL = 1;
        public static final int THUNDER_REMOTE_AUDIO_REASON_LOCAL_STARTED = 5;
        public static final int THUNDER_REMOTE_AUDIO_REASON_LOCAL_STOPPED = 4;
        public static final int THUNDER_REMOTE_AUDIO_REASON_NETWORK_CONGESTION = 2;
        public static final int THUNDER_REMOTE_AUDIO_REASON_NETWORK_RECOVERY = 3;
        public static final int THUNDER_REMOTE_AUDIO_REASON_OK = 0;
        public static final int THUNDER_REMOTE_AUDIO_REASON_PLAY_DEVICE_START_FAILED = 8;
        public static final int THUNDER_REMOTE_AUDIO_REASON_REMOTE_STARTED = 7;
        public static final int THUNDER_REMOTE_AUDIO_REASON_REMOTE_STOPPED = 6;
    }

    /* loaded from: classes4.dex */
    public static final class RemoteAudioState {
        public static final int THUNDER_REMOTE_AUDIO_STATE_DECODING = 2;
        public static final int THUNDER_REMOTE_AUDIO_STATE_FAILED = 4;
        public static final int THUNDER_REMOTE_AUDIO_STATE_FROZEN = 3;
        public static final int THUNDER_REMOTE_AUDIO_STATE_STARTING = 1;
        public static final int THUNDER_REMOTE_AUDIO_STATE_STOPPED = 0;
    }

    /* loaded from: classes4.dex */
    public static final class RemoteVideoReason {
        public static final int THUNDER_REMOTE_VIDEO_REASON_CODEC_UNKNOWN = 8;
        public static final int THUNDER_REMOTE_VIDEO_REASON_INTERNAL = 1;
        public static final int THUNDER_REMOTE_VIDEO_REASON_LOCAL_STARTED = 5;
        public static final int THUNDER_REMOTE_VIDEO_REASON_LOCAL_STOPPED = 4;
        public static final int THUNDER_REMOTE_VIDEO_REASON_NETWORK_CONGESTION = 2;
        public static final int THUNDER_REMOTE_VIDEO_REASON_NETWORK_RECOVERY = 3;
        public static final int THUNDER_REMOTE_VIDEO_REASON_OK = 0;
        public static final int THUNDER_REMOTE_VIDEO_REASON_REMOTE_STARTED = 7;
        public static final int THUNDER_REMOTE_VIDEO_REASON_REMOTE_STOPPED = 6;
    }

    /* loaded from: classes4.dex */
    public static final class RemoteVideoState {
        public static final int THUNDER_REMOTE_VIDEO_STATE_DECODING = 2;
        public static final int THUNDER_REMOTE_VIDEO_STATE_FAILED = 5;
        public static final int THUNDER_REMOTE_VIDEO_STATE_FROZEN = 4;
        public static final int THUNDER_REMOTE_VIDEO_STATE_RENDERING = 3;
        public static final int THUNDER_REMOTE_VIDEO_STATE_STARTING = 1;
        public static final int THUNDER_REMOTE_VIDEO_STATE_STOPPED = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ReverbExParameter {
        public float mRoomSize = 0.0f;
        public float mPreDelay = 0.0f;
        public float mReverberance = 0.0f;
        public float mHfDamping = 0.0f;
        public float mToneLow = 0.0f;
        public float mToneHigh = 0.0f;
        public float mWetGain = 0.0f;
        public float mDryGain = 0.0f;
        public float mStereoWidth = 0.0f;
    }

    /* loaded from: classes4.dex */
    public static final class RoomConfig {
        public static final int THUNDER_ROOMCONFIG_COMMUNICATION = 1;
        public static final int THUNDER_ROOMCONFIG_CONFERENCE = 5;
        public static final int THUNDER_ROOMCONFIG_GAME = 3;
        public static final int THUNDER_ROOMCONFIG_LIVE = 0;
        public static final int THUNDER_ROOMCONFIG_MULTIAUDIOROOM = 4;
    }

    /* loaded from: classes4.dex */
    public static final class ScenarioMode {
        public static final int THUNDER_SCENARIO_MODE_DEFAULT = 0;
        public static final int THUNDER_SCENARIO_MODE_QUALITY_FIRST = 2;
        public static final int THUNDER_SCENARIO_MODE_STABLE_FIRST = 1;
    }

    /* loaded from: classes4.dex */
    public static final class SoundEffectMode {
        public static final int THUNDER_SOUND_EFFECT_MODE_CHARMING = 4;
        public static final int THUNDER_SOUND_EFFECT_MODE_CONCERT = 8;
        public static final int THUNDER_SOUND_EFFECT_MODE_HIPHOP = 6;
        public static final int THUNDER_SOUND_EFFECT_MODE_KTV = 3;
        public static final int THUNDER_SOUND_EFFECT_MODE_NONE = 0;
        public static final int THUNDER_SOUND_EFFECT_MODE_POP = 5;
        public static final int THUNDER_SOUND_EFFECT_MODE_RANDB = 2;
        public static final int THUNDER_SOUND_EFFECT_MODE_ROCK = 7;
        public static final int THUNDER_SOUND_EFFECT_MODE_STUDIO = 9;
        public static final int THUNDER_SOUND_EFFECT_MODE_VALLEY = 1;
    }

    /* loaded from: classes4.dex */
    public static final class SourceType {
        public static final int THUNDER_PUBLISH_MODE_FILE = 1;
        public static final int THUNDER_PUBLISH_MODE_MIC = 0;
        public static final int THUNDER_PUBLISH_MODE_MIX = 2;
        public static final int THUNDER_PUBLISH_MODE_NONE = 10;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderAudioCodecType {
        public static final int AUDIO_CODEC_AAC = 2;
        public static final int AUDIO_CODEC_EAAC_PLUS = 1;
        public static final int AUDIO_CODEC_UNKNOW = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderAudioDeviceStatus {
        public static final int THUNDER_AUDIO_DEVICE_STATUS_INIT_CAPTURE_ERROR_OR_NO_PERMISSION = 1;
        public static final int THUNDER_AUDIO_DEVICE_STATUS_INIT_CAPTURE_SUCCESS = 0;
        public static final int THUNDER_AUDIO_DEVICE_STATUS_RELEASE_CAPTURE_SUCCESS = 2;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderAudioFilePLayerErrorCode {
        public static final int AUDIO_PLAYER_CREATE_FILE_DECODER_FAILED = -1;
        public static final int AUDIO_PLAYER_OPEN_FILE_DECODER_FAILED = -2;
        public static final int AUDIO_PLAYER_OPEN_FILE_FORMAT_NOT_SUPPORT = -3;
        public static final int AUDIO_PLAYER_OPEN_FILE_PATH_ERROR = -4;
        public static final int AUDIO_PLAYER_STATUS_SUCCESS = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderAudioFilePlayerEvent {
        public static final int AUDIO_PLAY_EVENT_END = 6;
        public static final int AUDIO_PLAY_EVENT_OPEN = 1;
        public static final int AUDIO_PLAY_EVENT_PAUSE = 4;
        public static final int AUDIO_PLAY_EVENT_PLAY = 2;
        public static final int AUDIO_PLAY_EVENT_RESUME = 5;
        public static final int AUDIO_PLAY_EVENT_SEEK_COMPLETE = 7;
        public static final int AUDIO_PLAY_EVENT_STOP = 3;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderAudioOutputRouting {
        public static final int THUNDER_AUDIO_OUTPUT_ROUTING_DEFAULT = -1;
        public static final int THUNDER_AUDIO_OUTPUT_ROUTING_EARPIECE = 1;
        public static final int THUNDER_AUDIO_OUTPUT_ROUTING_HEADSET = 0;
        public static final int THUNDER_AUDIO_OUTPUT_ROUTING_HEADSETBLUETOOTH = 5;
        public static final int THUNDER_AUDIO_OUTPUT_ROUTING_HEADSETNOMIC = 2;
        public static final int THUNDER_AUDIO_OUTPUT_ROUTING_LOUDSPEAKER = 4;
        public static final int THUNDER_AUDIO_OUTPUT_ROUTING_SPEAKERPHONE = 3;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderAudioRawFrameOperationMode {
        public static final int THUNDER_AUDIO_RAW_FRAME_OPERATION_MODE_READ_ONLY = 1;
        public static final int THUNDER_AUDIO_RAW_FRAME_OPERATION_MODE_READ_WRITE = 3;
        public static final int THUNDER_AUDIO_RAW_FRAME_OPERATION_MODE_WRITE_ONLY = 2;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderAudioRecordStateCode {
        public static final int THUNDER_AUDIO_RECORD_COMPLETED = 1;
        public static final int THUNDER_AUDIO_RECORD_ENCODER_ERROR = 4;
        public static final int THUNDER_AUDIO_RECORD_ERROR_NONE = 0;
        public static final int THUNDER_AUDIO_RECORD_FILE_PATH_INVALID = 5;
        public static final int THUNDER_AUDIO_RECORD_INITIALIZED = 2;
        public static final int THUNDER_AUDIO_RECORD_NO_INITIALIZED = 3;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderAudioSample {
        public static final int AUDIO_SAMPLE_32000 = 32000;
        public static final int AUDIO_SAMPLE_44100 = 44100;
        public static final int AUDIO_SAMPLE_48000 = 48000;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderCameraPosition {
        public static final int THUNDERCAMERA_POSITION_BACK = 1;
        public static final int THUNDERCAMERA_POSITION_FRONT = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderConnectionStatus {
        public static final int THUNDER_CONNECTION_STATUS_CONNECTED = 1;
        public static final int THUNDER_CONNECTION_STATUS_CONNECTING = 0;
        public static final int THUNDER_CONNECTION_STATUS_DISCONNECTED = 2;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderExternalVideoRenderMode {
        public static final int THUNDER_RENDER_MODE_ASPECT_FIT = 0;
        public static final int THUNDER_RENDER_MODE_CLIP_TO_BOUNDS = 1;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderIPStack {
        public static final int THUNDER_IPSTACK_DUAL = 3;
        public static final int THUNDER_IPSTACK_IPV4 = 1;
        public static final int THUNDER_IPSTACK_IPV6 = 2;
        public static final int THUNDER_IPSTACK_NONE = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderIPType {
        public static final int THUNDER_IPTYPE_IPV4 = 1;
        public static final int THUNDER_IPTYPE_IPV6 = 2;
        public static final int THUNDER_IPTYPE_NONE = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderLogLevel {
        public static final int THUNDERLOG_LEVEL_DEBUG = 1;
        public static final int THUNDERLOG_LEVEL_ERROR = 4;
        public static final int THUNDERLOG_LEVEL_INFO = 2;
        public static final int THUNDERLOG_LEVEL_RELEASE = 10;
        public static final int THUNDERLOG_LEVEL_TRACE = 0;
        public static final int THUNDERLOG_LEVEL_WARN = 3;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderNetworkType {
        public static final int THUNDER_NETWORK_TYPE_CABLE = 2;
        public static final int THUNDER_NETWORK_TYPE_DISCONNECTED = 1;
        public static final int THUNDER_NETWORK_TYPE_MOBILE = 4;
        public static final int THUNDER_NETWORK_TYPE_MOBILE_2G = 5;
        public static final int THUNDER_NETWORK_TYPE_MOBILE_3G = 6;
        public static final int THUNDER_NETWORK_TYPE_MOBILE_4G = 7;
        public static final int THUNDER_NETWORK_TYPE_UNKNOWN = 0;
        public static final int THUNDER_NETWORK_TYPE_WIFI = 3;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderPrivateCallbackKey {
        public static final int THUNDER_PRIVATE_MEDIA_EXTRA_DATA = 3;
        public static final int THUNDER_PRIVATE_PUBLISH_LAG = 1;
        public static final int THUNDER_SEND_PRIVATE_MEDIA_EXTRA_DATA_FAILED_STATUS = 4;
        public static final int THUNDER_VIDEO_FRAME_PROCESS_TIME = 2;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderPublishCDNErrorCode {
        public static final int THUNDER_PUBLISH_CDN_ERR_SUCCESS = 0;
        public static final int THUNDER_PUBLISH_CDN_ERR_THUNDERSERVER_FAILED = 2;
        public static final int THUNDER_PUBLISH_CDN_ERR_THUNDERSERVER_STOP = 3;
        public static final int THUNDER_PUBLISH_CDN_ERR_TOCDN_FAILED = 1;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderPublishOrientation {
        public static final int THUNDERPUBLISH_VIDEO_ORIENTATION_LANDSCAPE = 1;
        public static final int THUNDERPUBLISH_VIDEO_ORIENTATION_PORTRAIT = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderPublishPlayType {
        public static final int THUNDERPUBLISH_PLAY_INTERACT = 1;
        public static final int THUNDERPUBLISH_PLAY_MULTI_INTERACT = 3;
        public static final int THUNDERPUBLISH_PLAY_SCREENCAP = 2;
        public static final int THUNDERPUBLISH_PLAY_SINGLE = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderPublishVideoMode {
        public static final int THUNDERPUBLISH_VIDEO_MODE_BLUERAY_2M = 4;
        public static final int THUNDERPUBLISH_VIDEO_MODE_BLUERAY_4M = 5;
        public static final int THUNDERPUBLISH_VIDEO_MODE_BLUERAY_6M = 6;
        public static final int THUNDERPUBLISH_VIDEO_MODE_BLUERAY_8M = 7;
        public static final int THUNDERPUBLISH_VIDEO_MODE_DEFAULT = -1;
        public static final int THUNDERPUBLISH_VIDEO_MODE_FLUENCY = 8;
        public static final int THUNDERPUBLISH_VIDEO_MODE_HIGHQULITY = 2;
        public static final int THUNDERPUBLISH_VIDEO_MODE_NORMAL = 1;
        public static final int THUNDERPUBLISH_VIDEO_MODE_SUPERQULITY = 3;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderRemoteMirrorMode {
        public static final int THUNDER_REMOTE_MIRROR_MODE_DISABLED = 0;
        public static final int THUNDER_REMOTE_MIRROR_MODE_ENABLED = 1;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderRet {
        public static final int THUNDER_NOTIFY_JOIN_FAIL = -2001;
        public static final int THUNDER_RET_ALREADY_JOIN_ROOM = -4;
        public static final int THUNDER_RET_ALREADY_START_AUDIO_CAPTURE = -16;
        public static final int THUNDER_RET_ALREADY_START_AUDIO_ENCODE = -18;
        public static final int THUNDER_RET_ALREADY_START_AUDIO_PUBLISH = -19;
        public static final int THUNDER_RET_ALREADY_START_CUSTOM_AUDIO = -24;
        public static final int THUNDER_RET_ALREADY_START_VIDEO_CAPTURE = -30;
        public static final int THUNDER_RET_ALREADY_START_VIDEO_PUBLISH = -28;
        public static final int THUNDER_RET_ALREADY_SUBSCRIBE_ALL_ROOM = -201;
        public static final int THUNDER_RET_ARGO_ENGINE_ERROR = -6001;
        public static final int THUNDER_RET_AUDIO_DISABLE_VOICE_POSITION = -3002;
        public static final int THUNDER_RET_AUDIO_ENGINE_ERROR = -3001;
        public static final int THUNDER_RET_AUDIO_PUBLISH_MODE_NONE = -3003;
        public static final int THUNDER_RET_CALL_TOO_FREQUENT = -25;
        public static final int THUNDER_RET_CAPACITY_LIMIT = -12;
        public static final int THUNDER_RET_INVALID_ARGUMENT = -13;
        public static final int THUNDER_RET_INVALID_ROOMID = -9;
        public static final int THUNDER_RET_INVALID_SEATINDEX = -22;
        public static final int THUNDER_RET_INVALID_TASKID = -11;
        public static final int THUNDER_RET_INVALID_TRANSCODING_MODE = 101;
        public static final int THUNDER_RET_INVALID_UID = -8;
        public static final int THUNDER_RET_INVALID_URL = -10;
        public static final int THUNDER_RET_INVALID_VIDEO_SOURCE = -4002;
        public static final int THUNDER_RET_INVALID_VIDEO_STREAM_TYPE = -27;
        public static final int THUNDER_RET_LOCAL_USER_ROLE_ERR = -31;
        public static final int THUNDER_RET_LOG_ENGINE_ERROR = -8001;
        public static final int THUNDER_RET_NOT_CUSTOM_AUDIO_SOURCE = -26;
        public static final int THUNDER_RET_NOT_INITIALIZED = -1;
        public static final int THUNDER_RET_NOT_IN_THUNDER = -6;
        public static final int THUNDER_RET_NOT_IN_THUNDERBOLT = -7;
        public static final int THUNDER_RET_NOT_ON_FRONT_CAMERA = -20;
        public static final int THUNDER_RET_NOT_ON_MULTI_TYPE = -21;
        public static final int THUNDER_RET_NO_JOIN_ROOM = -3;
        public static final int THUNDER_RET_NO_START_AUDIO_CAPTURE = -15;
        public static final int THUNDER_RET_NO_START_AUDIO_PUBLISH = -17;
        public static final int THUNDER_RET_NO_SUBSCRIBE_ROOM = -202;
        public static final int THUNDER_RET_NO_SUBSCRIBE_UID = -203;
        public static final int THUNDER_RET_SERVICE_ENGINE_ERROR = -7001;
        public static final int THUNDER_RET_START_AUDIO_CAPTURE_ERR = -14;
        public static final int THUNDER_RET_START_AUDIO_ENCODE_ERR = -29;
        public static final int THUNDER_RET_SUCCESS = 0;
        public static final int THUNDER_RET_TRANS_ENGINE_ERROR = -5001;
        public static final int THUNDER_RET_VIDEO_ENGINE_ERROR = -4001;
        public static final int THUNDER_RET_WRONG_AUDIO_CAPTURE_TYPE = -23;
        public static final int THUNDER_RET_WRONG_INIT_STATUS = -2;
        public static final int THUNDER_RET_WRONG_JOIN_STATUS = -5;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderRtcProfile {
        public static final int THUNDER_PROFILE_DEFAULT = 0;
        public static final int THUNDER_PROFILE_NORMAL = 1;
        public static final int THUNDER_PROFILE_ONLY_AUDIO = 2;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderRtcRemotePlayType {
        public static final int THUNDER_REMOTE_PLAY_MULTI = 1;
        public static final int THUNDER_REMOTE_PLAY_NORMAL = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderSendMediaExtraInfoFailedStatus {
        public static final int THUNDER_SEND_MEDIA_EXTRA_INFO_FAILED_DATA_EMPTY = 1;
        public static final int THUNDER_SEND_MEDIA_EXTRA_INFO_FAILED_DATA_TOO_LARGE = 2;
        public static final int THUNDER_SEND_MEDIA_EXTRA_INFO_FAILED_FREQUENCY_TOO_HIGHT = 3;
        public static final int THUNDER_SEND_MEDIA_EXTRA_INFO_FAILED_NOT_IN_ANCHOR_SYSTEM = 4;
        public static final int THUNDER_SEND_MEDIA_EXTRA_INFO_FAILED_NO_JOIN_MEDIA = 5;
        public static final int THUNDER_SEND_MEDIA_EXTRA_INFO_FAILED_NO_PUBLISH_SUCCESS = 6;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderUserRole {
        public static final int THUNDER_USER_ROLE_ANCHOR = 1;
        public static final int THUNDER_USER_ROLE_AUDIENCE = 2;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoCaptureOrientation {
        public static final int THUNDER_VIDEO_CAPTURE_ORIENTATION_LANDSCAPE = 1;
        public static final int THUNDER_VIDEO_CAPTURE_ORIENTATION_LANDSCAPE_UPSIDEDOWN = 3;
        public static final int THUNDER_VIDEO_CAPTURE_ORIENTATION_PORTRAIT = 0;
        public static final int THUNDER_VIDEO_CAPTURE_ORIENTATION_PORTRAIT_UPSIDEDOWN = 2;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoCaptureStatus {
        public static final int THUNDER_VIDEO_CAPTURE_STATUS_AUTHORIZED = 1;
        public static final int THUNDER_VIDEO_CAPTURE_STATUS_CLOSE = 5;
        public static final int THUNDER_VIDEO_CAPTURE_STATUS_DENIED = 4;
        public static final int THUNDER_VIDEO_CAPTURE_STATUS_NOT_DETERMINED = 2;
        public static final int THUNDER_VIDEO_CAPTURE_STATUS_RESTRICTED = 3;
        public static final int THUNDER_VIDEO_CAPTURE_STATUS_SUCCESS = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoCodecType {
        public static final int VIDEO_CODEC_H264 = 2;
        public static final int VIDEO_CODEC_H265 = 3;
        public static final int VIDEO_CODEC_UNKNOW = 0;
        public static final int VIDEO_CODEC_VP8 = 1;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoDecodedType {
        public static final int VIDEO_DECODED_TYPE_HARD = 1;
        public static final int VIDEO_DECODED_TYPE_SOFT = 2;
        public static final int VIDEO_DECODED_TYPE_UNKNOWN = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoEncodeType {
        public static final int THUNDERVIDEO_ENCODE_TYPE_H264 = 1;
        public static final int THUNDERVIDEO_ENCODE_TYPE_H265 = 2;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoEncodedType {
        public static final int VIDEO_ENCODED_TYPE_HARD = 1;
        public static final int VIDEO_ENCODED_TYPE_SOFT = 2;
        public static final int VIDEO_ENCODED_TYPE_UNKNOWN = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoMirrorMode {
        public static final int THUNDER_VIDEO_MIRROR_MODE_PREVIEW_MIRROR_PUBLISH_NO_MIRROR = 0;
        public static final int THUNDER_VIDEO_MIRROR_MODE_PREVIEW_NO_MIRROR_PUBLISH_MIRROR = 3;
        public static final int THUNDER_VIDEO_MIRROR_MODE_PREVIEW_PUBLISH_BOTH_MIRROR = 1;
        public static final int THUNDER_VIDEO_MIRROR_MODE_PREVIEW_PUBLISH_BOTH_NO_MIRROR = 2;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoQualityAdapt {
        public static final int ADAPT_DOWN_BANDWIDTH = 2;
        public static final int ADAPT_NONE = 0;
        public static final int ADAPT_UP_BANDWIDTH = 1;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoRenderMode {
        public static final int THUNDER_RENDER_MODE_ASPECT_FIT = 1;
        public static final int THUNDER_RENDER_MODE_CLIP_TO_BOUNDS = 2;
        public static final int THUNDER_RENDER_MODE_FILL = 0;
        public static final int THUNDER_RENDER_MODE_ORIGINAL = 3;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoStreamType {
        public static final int THUNDER_VIDEO_STREAM_TYPE_HIGH = 0;
        public static final int THUNDER_VIDEO_STREAM_TYPE_LOW = 1;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoViewScaleMode {
        public static final int THUNDERVIDEOVIEW_SCALE_MODE_ASPECT_FIT = 1;
        public static final int THUNDERVIDEOVIEW_SCALE_MODE_CLIP_TO_BOUNDS = 2;
        public static final int THUNDERVIDEOVIEW_SCALE_MODE_FILL = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ThunderVideoViewType {
        public static final int THUNDERVIDEO_VIEW_PLAYVIEW = 2;
        public static final int THUNDERVIDEO_VIEW_PREVIEW = 1;
    }

    /* loaded from: classes4.dex */
    public static final class TranscodingImageScaleType {
        public static final int TRANSCODING_IMAGESCALE_RATIO_TYPE = 0;
        public static final int TRANSCODING_IMAGESCALE_STRETCH_TYPE = 1;
    }

    /* loaded from: classes4.dex */
    public static final class TranscodingStreamType {
        public static final int TRANSCODING_STREAM_TYPE_AUDIO_VIDEO = 0;
        public static final int TRANSCODING_STREAM_TYPE_ONLY_AUDIO = 2;
    }

    /* loaded from: classes4.dex */
    public static final class TranscodingUserLayoutShape {
        public static final int TRANSCODING_UESER_LAYOUT_SHAPE_CIRCULAR = 1;
        public static final int TRANSCODING_UESER_LAYOUT_SHAPE_RECTANGLE = 0;
    }

    /* loaded from: classes4.dex */
    public static final class TranscodingWatermarkCountType {
        public static final int TRANSCODING_WATERMARK_IMAGE_MAX = 4;
        public static final int TRANSCODING_WATERMARK_TEXT_MAX = 3;
    }

    /* loaded from: classes4.dex */
    public static final class UserOfflineReason {
        public static final int THUNDER_OFFLINE_BECOME_AUDIENCE = 3;
        public static final int THUNDER_OFFLINE_DROPPED = 2;
        public static final int THUNDER_OFFLINE_QUIT = 1;
    }

    /* loaded from: classes4.dex */
    public static final class VoiceChangerMode {
        public static final int THUNDER_VOICE_CHANGER_MODE_BADBOY = 7;
        public static final int THUNDER_VOICE_CHANGER_MODE_COLD = 10;
        public static final int THUNDER_VOICE_CHANGER_MODE_DIEFAT = 6;
        public static final int THUNDER_VOICE_CHANGER_MODE_ETHEREAL = 1;
        public static final int THUNDER_VOICE_CHANGER_MODE_HEAVYMECHINERY = 11;
        public static final int THUNDER_VOICE_CHANGER_MODE_HEAVYMETAL = 9;
        public static final int THUNDER_VOICE_CHANGER_MODE_LORIE = 4;
        public static final int THUNDER_VOICE_CHANGER_MODE_LUBAN = 3;
        public static final int THUNDER_VOICE_CHANGER_MODE_NONE = 0;
        public static final int THUNDER_VOICE_CHANGER_MODE_POWERCURRENT = 13;
        public static final int THUNDER_VOICE_CHANGER_MODE_THRILLER = 2;
        public static final int THUNDER_VOICE_CHANGER_MODE_TRAPPEDBEAST = 12;
        public static final int THUNDER_VOICE_CHANGER_MODE_UNCLE = 5;
        public static final int THUNDER_VOICE_CHANGER_MODE_WRACRAFT = 8;
    }
}
