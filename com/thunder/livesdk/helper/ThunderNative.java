package com.thunder.livesdk.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.thunder.livesdk.IThunderLogCallback;
import com.thunder.livesdk.LiveTranscoding;
import com.thunder.livesdk.ThunderAudioFilePlayer;
import com.thunder.livesdk.ThunderBoltImage;
import com.thunder.livesdk.ThunderDeviceInfo;
import com.thunder.livesdk.ThunderEventHandler;
import com.thunder.livesdk.ThunderMultiVideoViewParam;
import com.thunder.livesdk.ThunderNotification;
import com.thunder.livesdk.ThunderPublishVideoConfig;
import com.thunder.livesdk.ThunderVideoEncodeParam;
import com.thunder.livesdk.ThunderVideoEncoderConfiguration;
import com.thunder.livesdk.TranscodingImage;
import com.thunder.livesdk.TranscodingText;
import com.thunder.livesdk.TranscodingTimestamp;
import com.thunder.livesdk.audio.IAudioEncodedFrameObserver;
import com.thunder.livesdk.audio.IAudioFrameObserver;
import com.thunder.livesdk.log.ThunderLog;
import com.thunder.livesdk.video.CpuTool;
import com.thunder.livesdk.video.IVideoDecodeObserver;
import com.thunder.livesdk.video.ThunderPublishLowStreamVideoConfig;
import com.thunder.livesdk.video.serviceConfig.VideoConfigManager;
import com.thunder.livesdk.video.serviceConfig.VideoLiveConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public class ThunderNative {
    private static final int THUNDER_ADAPT_TO_SYSTEM_KARAOKE = 132;
    private static final int THUNDER_APP_ENTER_BACKGROUND = 98;
    private static final int THUNDER_APP_ENTER_FOREGROUND = 97;
    private static final int THUNDER_ATTACH_VIDEO_CAPTURE = 94;
    private static final int THUNDER_AUDIO_ENABLE_AI_DENOISE = 153;
    private static final int THUNDER_CHANGE_REMOTE_VIDEO_STREAM_TYPE = 130;
    private static final int THUNDER_CUSTOMIZE_VIDEO_PUBLISH_CFG = 127;
    private static final int THUNDER_ENABLE_AUDIO_AGC = 147;
    private static final int THUNDER_ENABLE_AUDIO_MIC_DENOISE = 137;
    private static final int THUNDER_ENABLE_AUDIO_PLAY_SPECTRUM = 112;
    private static final int THUNDER_ENABLE_COMPRESSOR = 104;
    private static final int THUNDER_ENABLE_ECHO_DETECTOR = 135;
    private static final int THUNDER_ENABLE_EQUALIZER = 102;
    private static final int THUNDER_ENABLE_HOWLING_DETECTOR = 126;
    private static final int THUNDER_ENABLE_IN_EAR_MONITOR = 101;
    private static final int THUNDER_ENABLE_LIMITER = 119;
    private static final int THUNDER_ENABLE_LOCAL_DUANL_STREAM_MODE = 128;
    private static final int THUNDER_ENABLE_LOG_CALLBACK = 70;
    private static final int THUNDER_ENABLE_LOUD_SPEAKER = 99;
    private static final int THUNDER_ENABLE_MIX_VIDEO_EXTRA_INFO = 64;
    private static final int THUNDER_ENABLE_REVERB = 106;
    private static final int THUNDER_ENABLE_VOICE_POSITION = 114;
    private static final int THUNDER_GET_CAMERA_MAX_ZOOM_FACTOR = 206;
    private static final int THUNDER_GET_CONNECTION_STATUS = 124;
    private static final int THUNDER_GET_CPU_RATE = 118;
    private static final int THUNDER_GET_HARD_DECODE_RENDER_CONFIG = 181;
    private static final int THUNDER_GET_LOUDSPEAKER_ENABLED = 100;
    private static final int THUNDER_GET_USER_ROLE = 216;
    private static final int THUNDER_IS_AUDIO_CAPTURE_ENABLED = 136;
    private static final int THUNDER_IS_AUDIO_ENCODER_ENABLED = 154;
    private static final int THUNDER_IS_AUDIO_MIC_DENOISE_ENABLE = 138;
    private static final int THUNDER_IS_AUDIO_PUBLISHER_ENABLED = 155;
    private static final int THUNDER_IS_CAMERA_AUTO_FOCUS_FACE_MODE_SUPPORTED = 211;
    private static final int THUNDER_IS_CAMERA_MANUAL_EXPOSURE_POSITION_SUPPORTED = 204;
    private static final int THUNDER_IS_CAMERA_MANUAL_FOCUS_POSITION_SUPPORTED = 203;
    private static final int THUNDER_IS_CAMERA_OPEN = 201;
    private static final int THUNDER_IS_CAMERA_TORCH_SUPPORTED = 208;
    private static final int THUNDER_IS_CAMERA_ZOOM_SUPPORTED = 205;
    private static final int THUNDER_IS_FRONT_CAMERA = 202;
    private static final int THUNDER_JOIN_ROOM = 6;
    private static final int THUNDER_MAKE_BEHAVIOR_EVENT = 120;
    private static final int THUNDER_NOTIFY_NETWORK_STATE = 96;
    private static final int THUNDER_PREFETCH_STREAMS = 121;
    private static final int THUNDER_PUSH_CUSTOME_AUDIO_FRAME = 90;
    private static final int THUNDER_QUERY_STREAMS = 122;
    private static final int THUNDER_REMOVE_LIVE_TRANSCODING_TASK = 73;
    private static final int THUNDER_SEND_AUDIO_FILE_PLAYER_INFO = 61;
    private static final int THUNDER_SEND_MEDIA_EXTRA_INFO = 63;
    private static final int THUNDER_SEND_PRIVATE_MEDIA_EXTRA_DATA = 213;
    private static final int THUNDER_SET_AUDIO_CONFIG = 86;
    private static final int THUNDER_SET_AUDIO_PLAY_SPECTRUM_INFO = 113;
    private static final int THUNDER_SET_AUDIO_PUBLISH_MODE = 87;
    private static final int THUNDER_SET_CAMERA_AUTO_FOCUS_FACE_MODE_ENABLED = 212;
    private static final int THUNDER_SET_CAMERA_EXPOSURE_POSITION = 210;
    private static final int THUNDER_SET_CAMERA_FOCUS_POSITION = 209;
    private static final int THUNDER_SET_CAMERA_TORCH_ON = 200;
    private static final int THUNDER_SET_CAMERA_ZOOM_FACTOR = 207;
    private static final int THUNDER_SET_COMPRESSOR_PARAM = 105;
    private static final int THUNDER_SET_CRASH_EVENT = 184;
    private static final int THUNDER_SET_CUSTOME_AUDIO_SOURCE = 88;
    private static final int THUNDER_SET_CUSTOM_PUBLISH_APPID = 142;
    private static final int THUNDER_SET_CUSTOM_STREAM_NAME = 140;
    private static final int THUNDER_SET_DEFAULT_REMOTE_VIDEO_STREAM_TYPE = 129;
    private static final int THUNDER_SET_EAR_MONITORING_VOLUME = 131;
    private static final int THUNDER_SET_EQ_GAINS = 103;
    private static final int THUNDER_SET_LIMIT_PARAM = 108;
    private static final int THUNDER_SET_LIVE_TRANSCODING_TASK = 72;
    private static final int THUNDER_SET_LOCAL_VIDEO_CANVAS = 76;
    private static final int THUNDER_SET_LOG_FILE_PATH = 69;
    private static final int THUNDER_SET_LOG_LEVEL = 68;
    private static final int THUNDER_SET_Local_VIDEO_CANVAS_MODE = 77;
    private static final int THUNDER_SET_MEDIA_MODE = 65;
    private static final int THUNDER_SET_PUB_WATERMARK = 89;
    private static final int THUNDER_SET_REMOTE_AUDIO_STREAM_VOLUME = 15;
    private static final int THUNDER_SET_REMOTE_PLAY_TYPE = 24;
    private static final int THUNDER_SET_REMOTE_VIDEO_CANVAS = 74;
    private static final int THUNDER_SET_REMOTE_VIDEO_CANVAS_MODE = 75;
    private static final int THUNDER_SET_REVERB_PARAM = 107;
    private static final int THUNDER_SET_ROOM_MODE = 66;
    private static final int THUNDER_SET_SID_AND_SUBSID = 117;
    private static final int THUNDER_SET_SOUND_EFFECT = 115;
    private static final int THUNDER_SET_SUBSCRIBE_GROUP_IN_THUNDER = 141;
    private static final int THUNDER_SET_THUNDERBOLT_PUBLISH_GROUP = 32;
    private static final int THUNDER_SET_THUNDERBOLT_SUBSCRIBE_GROUP = 79;
    private static final int THUNDER_SET_USER_64BIT_UID = 67;
    private static final int THUNDER_SET_VIDEO_ENCODER_CONFIG = 95;
    private static final int THUNDER_SET_VOICE_CHANGER = 116;
    private static final int THUNDER_SET_VOICE_CHANGER_PITCH = 125;
    private static final int THUNDER_START_AUDIO_CAPTURE = 133;
    private static final int THUNDER_START_AUDIO_ENCODE = 134;
    private static final int THUNDER_START_AUDIO_RECORD = 148;
    private static final int THUNDER_START_AUDIO_SAVER = 110;
    private static final int THUNDER_START_INPUT_DEVICE_TEST = 143;
    private static final int THUNDER_START_OUTPUT_DEVICE_TEST = 145;
    private static final int THUNDER_START_PREVIEW = 93;
    private static final int THUNDER_START_PUBLISH_AUDIO = 84;
    private static final int THUNDER_START_PUBLISH_VIDEO_STREAM = 92;
    private static final int THUNDER_START_PUSH_AUDIO_STREAM = 85;
    private static final int THUNDER_START_VIDEO_CAPTURE = 30;
    private static final int THUNDER_START_VIDEO_ENCODE = 91;
    private static final int THUNDER_START_VIDEO_LOCAL_PREVIEW = 214;
    private static final int THUNDER_STOP_ALL_REMOTE_STREAMS = 80;
    private static final int THUNDER_STOP_AUDIO_RECORD = 149;
    private static final int THUNDER_STOP_AUDIO_SAVER = 111;
    private static final int THUNDER_STOP_INPUT_DEVICE_TEST = 144;
    private static final int THUNDER_STOP_OUTPUT_DEVICE_TEST = 146;
    private static final int THUNDER_STOP_REMOTE_AUDIO_STREAM = 81;
    private static final int THUNDER_STOP_REMOTE_VIDEO_STREAM = 82;
    private static final int THUNDER_SUBSCRIBE_ROOM = 215;
    private static final int THUNDER_SUBSCRIBE_USER = 78;
    private static final int THUNDER_SWITCH_FRONT_CAMERA = 83;
    private static final int THUNDER_SWITCH_USER_ROLE = 152;
    private static final int THUNDER_UPDATE_PUBLISH_TRANSCODING_STREAM_URL = 71;
    private static final int THUNDER_VIDEO_FRAME_OBSERVER = 21;
    private static final int YYLIVE_AUDIO_ENABLE_AUDIO_DATA_INDICATION = 49;
    private static final int YYLIVE_AUDIO_ENABLE_CAPTURE_PCM_DATA_CALLBACK = 48;
    private static final int YYLIVE_AUDIO_ENABLE_RENDER_PCM_DATA_CALLBACK = 52;
    private static final int YYLIVE_AUDIO_FILE_CLOSE = 36;
    private static final int YYLIVE_AUDIO_FILE_ENABLE_PUBLISH = 46;
    private static final int YYLIVE_AUDIO_FILE_ENABLE_VOLUME_CALLBACK = 53;
    private static final int YYLIVE_AUDIO_FILE_GET_AUDIOTRACK_COUNT = 55;
    private static final int YYLIVE_AUDIO_FILE_GET_CURRENT_TIME = 43;
    private static final int YYLIVE_AUDIO_FILE_GET_PLAYER_LOCAL_VOLUME = 58;
    private static final int YYLIVE_AUDIO_FILE_GET_PLAYER_PUBLISH_VOLUME = 59;
    private static final int YYLIVE_AUDIO_FILE_GET_TOTAL_TIME = 42;
    private static final int YYLIVE_AUDIO_FILE_OPEN = 35;
    private static final int YYLIVE_AUDIO_FILE_PAUSE = 39;
    private static final int YYLIVE_AUDIO_FILE_PLAY = 37;
    private static final int YYLIVE_AUDIO_FILE_RESUME = 40;
    private static final int YYLIVE_AUDIO_FILE_SEEK = 41;
    private static final int YYLIVE_AUDIO_FILE_SELECT_AUDIOTRACK = 54;
    private static final int YYLIVE_AUDIO_FILE_SET_LOOPING = 60;
    private static final int YYLIVE_AUDIO_FILE_SET_PLAYER_LOCAL_VOLUME = 56;
    private static final int YYLIVE_AUDIO_FILE_SET_PLAYER_PUBLISH_VOLUME = 57;
    private static final int YYLIVE_AUDIO_FILE_SET_PLAY_VOLUME = 44;
    private static final int YYLIVE_AUDIO_FILE_SET_POSITION = 151;
    private static final int YYLIVE_AUDIO_FILE_SET_SEMITONE = 45;
    private static final int YYLIVE_AUDIO_FILE_SET_TEMPO = 150;
    private static final int YYLIVE_AUDIO_FILE_STOP = 38;
    private static final int YYLIVE_AUDIO_SET_EXTERNAL_PROCESSOR = 47;
    private static final int YYLIVE_CAPTURE_REMOTE_SCREEN_SHOT = 190;
    private static final int YYLIVE_CHANGE_SCREEN_LIVE_MODE = 26;
    private static final int YYLIVE_CREATE_AUDIO_FILE_PLAYER = 50;
    private static final int YYLIVE_DESTROY_AUDIO_FILE_PLAYER = 51;
    private static final int YYLIVE_ENABLE_VIDEO_PUBLISH_BUFFER_PROCESS = 182;
    private static final int YYLIVE_ENABLE_VIDEO_SET_PARAMETERS_PROCESS = 191;
    private static final int YYLIVE_ENABLE_WEBSDK_COMPATIBILITY = 19;
    private static final int YYLIVE_GET_ABROAD_NETWORK_STRATEGY = 180;
    private static final int YYLIVE_GET_BEAUTIFY_LEVEL = 34;
    private static final int YYLIVE_GET_ORIENTATION = 28;
    private static final int YYLIVE_H264_SUPPORT_MODE = 20;
    private static final int YYLIVE_H265_SUPPORT_MODE = 18;
    private static final int YYLIVE_INIT_MULTI_VIEW_LAYOUT = 23;
    private static final int YYLIVE_LEAVE_ROOM = 7;
    private static final int YYLIVE_LOG_TEXT = 3;
    private static final int YYLIVE_SDK_INIT = 1;
    private static final int YYLIVE_SEND_USER_APP_MSG_DATA = 62;
    private static final int YYLIVE_SET_AREA_TYPE = 8;
    private static final int YYLIVE_SET_CAPTURE_VOLUME_INTERVAL = 10;
    private static final int YYLIVE_SET_HARDWARE_DECODE_STATUS = 183;
    private static final int YYLIVE_SET_HTTPS_RESPONSE = 11;
    private static final int YYLIVE_SET_LOCAL_VIDEO_MIRROR_MODE = 33;
    private static final int YYLIVE_SET_MIC_VOLUME = 25;
    private static final int YYLIVE_SET_MIX_AUDIO_PARAMS = 14;
    private static final int YYLIVE_SET_ORIENTATION = 27;
    private static final int YYLIVE_SET_PLAY_AUDIO_PARAMS = 13;
    private static final int YYLIVE_SET_PLAY_VOLUME_INTERVAL = 9;
    private static final int YYLIVE_SET_RECORD_AUDIO_PARAMS = 12;
    private static final int YYLIVE_SET_REMOTE_UID_VOICE_POSITION = 22;
    private static final int YYLIVE_SET_SCENE_ID = 2;
    private static final int YYLIVE_SET_SPEAKER_VOLUME = 17;
    private static final int YYLIVE_SET_VIDEO_COMMON_CONFIG_MODE = 185;
    private static final int YYLIVE_UPDATE_PUBLISH_ORIGIN_STREAM_URL = 31;
    private static final int YYLIVE_UPDATE_TOKEN = 5;
    private static IThunderLogCallback s_logCallback = null;
    private static NotificationDispatcher s_notificationDispatcher = null;
    private static ReentrantLock s_notificationLock = null;
    private static int s_remoteVideoStatsNotificationCount = 0;
    private static int s_remoteAudioStatsNotificationCount = 0;
    private static Boolean isInit = false;
    private static int s_audioCaptureVolumeNotificationCount = 0;
    private static int s_audioPlayVolumeNotificationCount = 0;
    private static int s_playRuntimeNotificationCount = 0;
    private static int s_publishRuntimeNotificationCount = 0;
    private static int s_audioExtraInfoNotificationCount = 0;

    /* loaded from: classes4.dex */
    public interface NotificationDispatcher {
        Object[] collectNotificationHandlers();

        void registerNotificationHandler(Handler handler);

        void unregisterNotificationHandler(Handler handler);
    }

    private static native String LiveEngineTranscodingCfgByMode(int i);

    private static native Object ThunderCaptureLocalScreenShot();

    private static native Object ThunderCaptureRemoteScreenShot(String str);

    private static native Object ThunderGetVideoEncoderParamByGear(int i, int i2);

    private static native int ThunderSetCaptureReplaceImage(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long YYLiveObjectToPtr(Object obj);

    private static native int YYLiveRegisterAudioEncodedObserver(IAudioEncodedFrameObserver iAudioEncodedFrameObserver);

    private static native void YYLiveRegisterAudioObserver(IAudioFrameObserver iAudioFrameObserver);

    private static native void YYLiveSdkFini();

    private static native String YYLiveSdkGetVersion();

    private static native int YYLiveSdkGetVersionInt();

    private static native int YYLiveSdkInit(Context context, byte[] bArr);

    private static native long YYLiveSdkProcess(int i, byte[] bArr);

    /* loaded from: classes4.dex */
    private static class YLESdkInit extends YLEBase {
        long appId;
        int areaType;
        ThunderDeviceInfo info;
        long sceneId;
        int serverDomain;

        YLESdkInit(long j, long j2, int i, int i2, ThunderDeviceInfo thunderDeviceInfo) {
            super();
            this.event = 1;
            this.appId = j;
            this.sceneId = j2;
            this.areaType = i;
            this.serverDomain = i2;
            this.info = thunderDeviceInfo;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.appId);
            pushInt(this.sceneId);
            pushInt(this.areaType);
            pushInt(this.serverDomain);
            pushString16(this.info.osVersion);
            pushString16(this.info.manufacturer);
            pushString16(this.info.model);
            pushString16(this.info.deviceID);
            pushString16(this.info.appInfo);
            pushInt64(this.info.imsi);
            return super.marshall();
        }
    }

    public static void fini() {
        isInit = false;
        s_notificationLock.lock();
        try {
            s_notificationDispatcher = null;
            s_notificationLock.unlock();
            YYLiveSdkFini();
        } catch (Throwable th) {
            s_notificationLock.unlock();
            throw th;
        }
    }

    public static String getVersion() {
        return YYLiveSdkGetVersion();
    }

    public static void registerAudioFrameObserver(IAudioFrameObserver iAudioFrameObserver) {
        YYLiveRegisterAudioObserver(iAudioFrameObserver);
    }

    public static int registerAudioEncodedFrameObserver(IAudioEncodedFrameObserver iAudioEncodedFrameObserver) {
        return YYLiveRegisterAudioEncodedObserver(iAudioEncodedFrameObserver);
    }

    private static long YLEProcess(YLEBase yLEBase) {
        MshBuffer mshBuffer = new MshBuffer(4096, NativeByteBufferPool.get());
        long YYLiveSdkProcess = YYLiveSdkProcess(yLEBase.event(), yLEBase.HPmarshall(mshBuffer));
        mshBuffer.freeBuffer();
        return YYLiveSdkProcess;
    }

    public static int initMultiPlayerViewLayout(ThunderMultiVideoViewParam thunderMultiVideoViewParam, int i, Object obj) {
        return (int) YLEProcess(new YLEInitMultiPlayerViewLayout(thunderMultiVideoViewParam, i, obj));
    }

    public static Bitmap captureRemoteScreenShot(String str) {
        Object ThunderCaptureRemoteScreenShot = ThunderCaptureRemoteScreenShot(str);
        if (ThunderCaptureRemoteScreenShot instanceof Bitmap) {
            return (Bitmap) ThunderCaptureRemoteScreenShot;
        }
        return null;
    }

    public static int setCaptureReplaceImage(Bitmap bitmap) {
        return ThunderSetCaptureReplaceImage(bitmap);
    }

    public static Bitmap captureLocalScreenShot() {
        Object ThunderCaptureLocalScreenShot = ThunderCaptureLocalScreenShot();
        if (ThunderCaptureLocalScreenShot instanceof Bitmap) {
            return (Bitmap) ThunderCaptureLocalScreenShot;
        }
        return null;
    }

    public static int setParameters(String str) {
        return (int) YLEProcess(new YLESetParameters(str));
    }

    public static int setVideoPlayType(int i, boolean z) {
        return (int) YLEProcess(new YLESetVideoPlayType(i, z));
    }

    public static int onCrashEvent() {
        return (int) YLEProcess(new YLESetCrashEvent());
    }

    public static int setHardwareDecodeStatus(int i) {
        return (int) YLEProcess(new YLESetHardwareDecodeStatus(i));
    }

    public static int enableVideoPublishBufferProcess(boolean z) {
        return (int) YLEProcess(new YLEEnableVideoPublishBufferProcess(z));
    }

    public static int setVideoCommonConfigMode(int i) {
        return (int) YLEProcess(new YLESetVideoCommonConfigMode(i));
    }

    public static void logText(int i, int i2, String str, String str2) {
        YLEProcess(new YLELogText(i, i2, str, str2));
    }

    public static int leaveRoom() {
        return (int) YLEProcess(new YLELeaveRoom());
    }

    public static int setPlayVolumeInterval(int i, int i2, int i3) {
        return (int) YLEProcess(new YLESetPlayVolumeInterval(i, i2, i3));
    }

    public static int setCaptureVolumeInterval(int i, int i2, int i3) {
        return (int) YLEProcess(new YLESetCaptureVolumeInterval(i, i2, i3));
    }

    public static int getBeautifyLevel() {
        return (int) YLEProcess(new YLEGetBeautifyLevel());
    }

    public static int getAbroadNetWorkStrategy() {
        return (int) YLEProcess(new YLEGetAbroadNetWorkStrategy());
    }

    public static int enableWebSdkCompatibility(boolean z) {
        return (int) YLEProcess(new YLEEnableWebSdkCompatibility(z));
    }

    public static int setLocalVideoMirrorMode(int i) {
        return (int) YLEProcess(new YLESetLocalVideoMirrorMode(i));
    }

    public static int setRemoteAudioStreamVolume(String str, int i) {
        return (int) YLEProcess(new YLESetRemoteAudioStreamVolume(str, i));
    }

    public static int setRemoteUidVoicePosition(String str, int i, int i2) {
        return (int) YLEProcess(new YLESetRemoteUidVoicePosition(str, i, i2));
    }

    public static int setSpeakerVolume(int i) {
        return (int) YLEProcess(new YLESetSpeakerVolume(i));
    }

    public static int getH265SupportMode() {
        return (int) YLEProcess(new YLEGetH265SupportMode());
    }

    public static int getH264SupportMode() {
        return (int) YLEProcess(new YLEGetH264SupportMode());
    }

    public static int getHardDecodeDirectRenderConfig() {
        return (int) YLEProcess(new YLEGetHardDecodeRenderMode());
    }

    public static int getAppCpuSupportMode() {
        return (int) YLEProcess(new YLEGetAppCpuSupportMode());
    }

    public static int setMicVolume(int i) {
        return (int) YLEProcess(new YLESetMicVolume(i));
    }

    public static int setOrientation(int i) {
        return (int) YLEProcess(new YLESetOrientation(i));
    }

    public static int getOrientation() {
        return (int) YLEProcess(new YLEGetOrientation());
    }

    public static int setThunderboltPublishGroup(boolean z) {
        return (int) YLEProcess(new YLESetThunderboltPublishGroup(z));
    }

    public static void changeScreenLiveMode(boolean z, Object obj) {
        YLEProcess(new YLEChangeScreenLiveMode(z, obj));
    }

    public static long createAudioFilePlayer(Object obj) {
        return YLEProcess(new YLECreateAudioFilePlayer(obj));
    }

    public static long destroyAudioFilePlayer(long j) {
        return YLEProcess(new YLEAudioFileEventCommon(51, j));
    }

    public static long sendAudioFilePlayerInfo(int i, int i2, int i3) {
        return YLEProcess(new YLESendAudioFilePlayerInfo(i, i2, i3));
    }

    public static long audioFileOpen(long j, String str) {
        return YLEProcess(new YLEAudioFileOpen(j, str));
    }

    public static void audioFileClose(long j) {
        YLEProcess(new YLEAudioFileEventCommon(36, j));
    }

    public static void audioFilePlay(long j) {
        YLEProcess(new YLEAudioFileEventCommon(37, j));
    }

    public static void audioFileStop(long j) {
        YLEProcess(new YLEAudioFileEventCommon(38, j));
    }

    public static void audioFilePause(long j) {
        YLEProcess(new YLEAudioFileEventCommon(39, j));
    }

    public static void audioFileResume(long j) {
        YLEProcess(new YLEAudioFileEventCommon(40, j));
    }

    public static void audioFileSeek(long j, long j2) {
        YLEProcess(new YLEAudioFileSeek(j, j2));
    }

    public static long audioFileGetTotalTime(long j) {
        return YLEProcess(new YLEAudioFileEventCommon(42, j));
    }

    public static long audioFileGetCurrentPlayTime(long j) {
        return YLEProcess(new YLEAudioFileEventCommon(43, j));
    }

    public static void audioFileSetPlayVolume(long j, int i) {
        YLEProcess(new YLEAudioFileSetPlayVolume(j, i));
    }

    public static int audioFileSetPlayerLocalVolume(long j, int i) {
        return (int) YLEProcess(new YLEAudioFileSetPlayerLocalVolume(j, i));
    }

    public static int audioFileSetPlayerPublishVolume(long j, int i) {
        return (int) YLEProcess(new YLEAudioFileSetPlayerPublishVolume(j, i));
    }

    public static long audioFileGetPlayerLocalVolume(long j) {
        return YLEProcess(new YLEAudioFileEventCommon(58, j));
    }

    public static long audioFileGetPlayerPublishVolume(long j) {
        return YLEProcess(new YLEAudioFileEventCommon(59, j));
    }

    public static long audioFileSetLooping(long j, int i) {
        return YLEProcess(new YLEAudioFileSetLooping(j, i));
    }

    public static long audioFileSelectAudioTrack(long j, int i) {
        return YLEProcess(new YLEAudioFileSelectAudioTrack(j, i));
    }

    public static long audioFileGetAudioTrackCount(long j) {
        return YLEProcess(new YLEAudioFileEventCommon(55, j));
    }

    public static void audioFileSetSemitone(long j, float f) {
        YLEProcess(new YLEAudioFileSetSemitone(j, f));
    }

    public static void audioFileSetTempo(long j, float f) {
        YLEProcess(new YLEAudioFileSetTempo(j, f));
    }

    public static void audioFileSetPosition(long j, int i, int i2) {
        YLEProcess(new YLEAudioFileSetPosition(j, i, i2));
    }

    public static void audioFileEnablePublish(long j, boolean z) {
        YLEProcess(new YLEAudioFileEnablePublish(j, z));
    }

    public static void enableAudioFileVolumeCallback(long j, boolean z, int i) {
        YLEProcess(new YLEEnableAudioFileVolumeCallback(j, z, i));
    }

    public static void setExternalAudioProcessor(long j) {
        YLEProcess(new YLEAudioSetExternalProcessor(j));
    }

    public static void enableAudioDataIndication(boolean z) {
        YLEProcess(new YLEEnableAudioDataIndication(z));
    }

    public static int enableCapturePcmDataCallBack(boolean z, int i, int i2) {
        return (int) YLEProcess(new YLEEnableCapturePcmDataCallBack(z, i, i2));
    }

    public static boolean enableRenderPcmDataCallBack(boolean z, int i, int i2) {
        return 0 == YLEProcess(new YLEEnableRenderPcmDataCallBack(z, i, i2));
    }

    public static int sendUserAppMsgData(byte[] bArr) {
        return (int) YLEProcess(new YLESendUserAppMsgData(bArr));
    }

    public static int sendMediaExtraInfo(byte[] bArr) {
        return (int) YLEProcess(new YLESendMediaExtraInfo(bArr));
    }

    public static int sendPrivateMediaExtraData(String str) {
        return (int) YLEProcess(new YLESendPrivateMediaExtraData(str));
    }

    public static int enableMixVideoExtraInfo(boolean z) {
        return (int) YLEProcess(new YLEEnableMixVideoExtraInfo(z));
    }

    public static void setHttpsBinaryResponse(String str, byte[] bArr, int i, int i2, int i3) {
        if (isInit.booleanValue()) {
            YLEProcess(new YLESetHttpsBinaryResponse(str, bArr, i, i2, i3));
        }
    }

    public static void setHttpsTextResponse(String str, String str2, int i, int i2, int i3) {
        if (isInit.booleanValue()) {
            YLEProcess(new YLESetHttpsTextResponse(str, str2, i, i2, i3));
        }
    }

    public static int setPlaybackAudioFrameParameters(int i, int i2, int i3, int i4) {
        return (int) YLEProcess(new YLESetPlaybackAudioFrameParameters(i, i2, i3, i4));
    }

    public static ThunderVideoEncodeParam getVideoEncoderParamByGear(int i, int i2) {
        Object ThunderGetVideoEncoderParamByGear = ThunderGetVideoEncoderParamByGear(i, i2);
        if (ThunderGetVideoEncoderParamByGear instanceof ThunderVideoEncodeParam) {
            return (ThunderVideoEncodeParam) ThunderGetVideoEncoderParamByGear;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class YLEBase extends HPMarshaller {
        int event;

        private YLEBase() {
            this.event = 0;
        }

        int event() {
            return this.event;
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class YLELogText extends YLEBase {
        private int level;
        private int module;
        private String tag;
        private String text;

        YLELogText(int i, int i2, String str, String str2) {
            super();
            this.event = 3;
            this.level = i;
            this.module = i2;
            this.tag = str;
            this.text = str2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.level);
            pushInt(this.module);
            pushString16(this.tag);
            pushString32(this.text);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLELeaveRoom extends YLEBase {
        private int reverse;

        YLELeaveRoom() {
            super();
            this.event = 7;
            this.reverse = 0;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.reverse);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetPlayVolumeInterval extends YLEBase {
        private int interval;
        private int lessThanThd;
        private int moreThanThd;

        YLESetPlayVolumeInterval(int i, int i2, int i3) {
            super();
            this.event = 9;
            this.interval = i;
            this.moreThanThd = i2;
            this.lessThanThd = i3;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.interval);
            pushInt(this.moreThanThd);
            pushInt(this.lessThanThd);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCaptureVolumeInterval extends YLEBase {
        private int interval;
        private int lessThanThd;
        private int moreThanThd;

        YLESetCaptureVolumeInterval(int i, int i2, int i3) {
            super();
            this.event = 10;
            this.interval = i;
            this.moreThanThd = i2;
            this.lessThanThd = i3;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.interval);
            pushInt(this.moreThanThd);
            pushInt(this.lessThanThd);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetBeautifyLevel extends YLEBase {
        YLEGetBeautifyLevel() {
            super();
            this.event = 34;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetAbroadNetWorkStrategy extends YLEBase {
        YLEGetAbroadNetWorkStrategy() {
            super();
            this.event = 180;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEInitMultiPlayerViewLayout extends YLEBase {
        private Object multiParam;
        private Object view;
        private int viewId;

        YLEInitMultiPlayerViewLayout(Object obj, int i, Object obj2) {
            super();
            this.event = 23;
            this.multiParam = obj;
            this.viewId = i;
            this.view = obj2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(ThunderNative.YYLiveObjectToPtr(this.multiParam));
            pushInt(this.viewId);
            pushInt64(ThunderNative.YYLiveObjectToPtr(this.view));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetVideoPlayType extends YLEBase {
        private boolean checkJoined;
        private int remotePlayType;

        YLESetVideoPlayType(int i, boolean z) {
            super();
            this.event = 24;
            this.remotePlayType = i;
            this.checkJoined = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.remotePlayType);
            pushBool(Boolean.valueOf(this.checkJoined));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCrashEvent extends YLEBase {
        YLESetCrashEvent() {
            super();
            this.event = 184;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetParameters extends YLEBase {
        private String options;

        YLESetParameters(String str) {
            super();
            this.event = ThunderNative.YYLIVE_ENABLE_VIDEO_SET_PARAMETERS_PROCESS;
            this.options = str;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.options);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableVideoPublishBufferProcess extends YLEBase {
        private boolean bBufferMode;

        YLEEnableVideoPublishBufferProcess(boolean z) {
            super();
            this.event = 182;
            this.bBufferMode = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bBufferMode));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetVideoCommonConfigMode extends YLEBase {
        private int mode;

        YLESetVideoCommonConfigMode(int i) {
            super();
            this.event = 185;
            this.mode = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.mode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetHardwareDecodeStatus extends YLEBase {
        private int mHardwareDecodeStatus;

        YLESetHardwareDecodeStatus(int i) {
            super();
            this.event = 183;
            this.mHardwareDecodeStatus = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.mHardwareDecodeStatus);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableWebSdkCompatibility extends YLEBase {
        private boolean enable;

        YLEEnableWebSdkCompatibility(boolean z) {
            super();
            this.event = 19;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetLocalVideoMirrorMode extends YLEBase {
        private int mode;

        YLESetLocalVideoMirrorMode(int i) {
            super();
            this.event = 33;
            this.mode = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.mode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetRemoteAudioStreamVolume extends YLEBase {
        private String uid;
        private int volume;

        public YLESetRemoteAudioStreamVolume(String str, int i) {
            super();
            this.event = 15;
            this.uid = str;
            this.volume = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.uid);
            pushInt(this.volume);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetRemoteUidVoicePosition extends YLEBase {
        private int azimuth;
        private int gain;
        private String uid;

        public YLESetRemoteUidVoicePosition(String str, int i, int i2) {
            super();
            this.event = 22;
            this.uid = str;
            this.azimuth = i;
            this.gain = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.uid);
            pushInt(this.azimuth);
            pushInt(this.gain);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetSpeakerVolume extends YLEBase {
        private int volume;

        YLESetSpeakerVolume(int i) {
            super();
            this.event = 17;
            this.volume = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.volume);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetH265SupportMode extends YLEBase {
        YLEGetH265SupportMode() {
            super();
            this.event = 18;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetH264SupportMode extends YLEBase {
        YLEGetH264SupportMode() {
            super();
            this.event = 20;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetHardDecodeRenderMode extends YLEBase {
        YLEGetHardDecodeRenderMode() {
            super();
            this.event = 181;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetAppCpuSupportMode extends YLEBase {
        YLEGetAppCpuSupportMode() {
            super();
            this.event = 118;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetMicVolume extends YLEBase {
        private int volume;

        YLESetMicVolume(int i) {
            super();
            this.event = 25;
            this.volume = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.volume);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetOrientation extends YLEBase {
        private int orientation;

        YLESetOrientation(int i) {
            super();
            this.event = 27;
            this.orientation = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.orientation);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetOrientation extends YLEBase {
        YLEGetOrientation() {
            super();
            this.event = 28;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetThunderboltPublishGroup extends YLEBase {
        private boolean isPublishGroup;

        YLESetThunderboltPublishGroup(boolean z) {
            super();
            this.event = 32;
            this.isPublishGroup = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.isPublishGroup));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    public static class YLEChangeScreenLiveMode extends YLEBase {
        private boolean bPicMode;
        private Object bitmap;

        public YLEChangeScreenLiveMode(boolean z, Object obj) {
            super();
            this.event = 26;
            this.bPicMode = z;
            this.bitmap = obj;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bPicMode));
            pushInt64(ThunderNative.YYLiveObjectToPtr(this.bitmap));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnterBackground extends YLEBase {
        private int reverse;

        YLEEnterBackground() {
            super();
            this.event = 98;
            this.reverse = 0;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.reverse);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnterForeground extends YLEBase {
        private int reverse;

        YLEEnterForeground() {
            super();
            this.event = 97;
            this.reverse = 0;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.reverse);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLECreateAudioFilePlayer extends YLEBase {
        private Object obj;

        YLECreateAudioFilePlayer(Object obj) {
            super();
            this.event = 50;
            this.obj = obj;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(ThunderNative.YYLiveObjectToPtr(this.obj));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileOpen extends YLEBase {
        private long ctx;
        private String path;

        YLEAudioFileOpen(long j, String str) {
            super();
            this.event = 35;
            this.path = str;
            this.ctx = j;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushString16(this.path);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileEventCommon extends YLEBase {
        private long ctx;

        YLEAudioFileEventCommon(int i, long j) {
            super();
            this.event = i;
            this.ctx = j;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESendAudioFilePlayerInfo extends YLEBase {
        private int currentMs;
        private int totalMs;
        private int volume;

        YLESendAudioFilePlayerInfo(int i, int i2, int i3) {
            super();
            this.event = 61;
            this.volume = i;
            this.currentMs = i2;
            this.totalMs = i3;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.volume);
            pushInt(this.currentMs);
            pushInt(this.totalMs);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileSeek extends YLEBase {
        private long ctx;
        private long timeMS;

        YLEAudioFileSeek(long j, long j2) {
            super();
            this.event = 41;
            this.ctx = j;
            this.timeMS = j2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushInt(this.timeMS);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileSetPlayVolume extends YLEBase {
        private long ctx;
        private int volume;

        YLEAudioFileSetPlayVolume(long j, int i) {
            super();
            this.event = 44;
            this.ctx = j;
            this.volume = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushInt(this.volume);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileSetPlayerLocalVolume extends YLEBase {
        private long ctx;
        private int volume;

        YLEAudioFileSetPlayerLocalVolume(long j, int i) {
            super();
            this.event = 56;
            this.ctx = j;
            this.volume = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushInt(this.volume);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileSetPlayerPublishVolume extends YLEBase {
        private long ctx;
        private int volume;

        YLEAudioFileSetPlayerPublishVolume(long j, int i) {
            super();
            this.event = 57;
            this.ctx = j;
            this.volume = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushInt(this.volume);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileSelectAudioTrack extends YLEBase {
        private int audioTrack;
        private long ctx;

        YLEAudioFileSelectAudioTrack(long j, int i) {
            super();
            this.ctx = j;
            this.audioTrack = i;
            this.event = 54;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushInt(this.audioTrack);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileSetLooping extends YLEBase {
        private long ctx;
        private int cycle;

        YLEAudioFileSetLooping(long j, int i) {
            super();
            this.ctx = j;
            this.cycle = i;
            this.event = 60;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushInt(this.cycle);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileSetSemitone extends YLEBase {
        private long ctx;
        private float val;

        YLEAudioFileSetSemitone(long j, float f) {
            super();
            this.event = 45;
            this.ctx = j;
            this.val = f;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushString16(String.valueOf(this.val * 1000000.0f));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileSetTempo extends YLEBase {
        private long ctx;
        private float val;

        YLEAudioFileSetTempo(long j, float f) {
            super();
            this.event = 150;
            this.ctx = j;
            this.val = f;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushInt((int) (this.val * 1000000.0f));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileSetPosition extends YLEBase {
        private int azimuth;
        private long ctx;
        private int elevation;

        YLEAudioFileSetPosition(long j, int i, int i2) {
            super();
            this.event = 151;
            this.ctx = j;
            this.azimuth = i;
            this.elevation = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushInt(this.azimuth);
            pushInt(this.elevation);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioFileEnablePublish extends YLEBase {
        private long ctx;
        private boolean enable;

        YLEAudioFileEnablePublish(long j, boolean z) {
            super();
            this.event = 46;
            this.ctx = j;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableAudioFileVolumeCallback extends YLEBase {
        private long ctx;
        private boolean enable;
        private int interval;

        YLEEnableAudioFileVolumeCallback(long j, boolean z, int i) {
            super();
            this.event = 53;
            this.ctx = j;
            this.enable = z;
            this.interval = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.ctx);
            pushBool(Boolean.valueOf(this.enable));
            pushInt(this.interval);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAudioSetExternalProcessor extends YLEBase {
        private long eap;

        YLEAudioSetExternalProcessor(long j) {
            super();
            this.event = 47;
            this.eap = j;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(this.eap);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableCapturePcmDataCallBack extends YLEBase {
        private boolean enable;
        private int room;
        private int sampleRate;

        YLEEnableCapturePcmDataCallBack(boolean z, int i, int i2) {
            super();
            this.event = 48;
            this.enable = z;
            this.sampleRate = i;
            this.room = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            pushInt(this.sampleRate);
            pushInt(this.room);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableRenderPcmDataCallBack extends YLEBase {
        private boolean enable;
        private int room;
        private int sampleRate;

        YLEEnableRenderPcmDataCallBack(boolean z, int i, int i2) {
            super();
            this.event = 52;
            this.enable = z;
            this.sampleRate = i;
            this.room = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            pushInt(this.sampleRate);
            pushInt(this.room);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESendUserAppMsgData extends YLEBase {
        private byte[] msgData;

        YLESendUserAppMsgData(byte[] bArr) {
            super();
            this.event = 62;
            this.msgData = bArr;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBytes(this.msgData);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESendMediaExtraInfo extends YLEBase {
        private byte[] extraInfo;

        YLESendMediaExtraInfo(byte[] bArr) {
            super();
            this.event = 63;
            this.extraInfo = bArr;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBytes(this.extraInfo);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableMixVideoExtraInfo extends YLEBase {
        private boolean enable;

        YLEEnableMixVideoExtraInfo(boolean z) {
            super();
            this.event = 64;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableAudioDataIndication extends YLEBase {
        private boolean enable;

        YLEEnableAudioDataIndication(boolean z) {
            super();
            this.event = 49;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetHttpsBinaryResponse extends YLEBase {
        private int errCode;
        private String reqUrl;
        private byte[] response;
        private int statusCode;
        private int target;

        YLESetHttpsBinaryResponse(String str, byte[] bArr, int i, int i2, int i3) {
            super();
            this.event = 11;
            this.reqUrl = str;
            this.response = bArr;
            this.statusCode = i;
            this.errCode = i2;
            this.target = i3;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.reqUrl);
            pushBytes(this.response);
            pushInt(this.statusCode);
            pushInt(this.errCode);
            pushInt(this.target);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetHttpsTextResponse extends YLEBase {
        private int errCode;
        private String reqUrl;
        private String response;
        private int statusCode;
        private int target;

        YLESetHttpsTextResponse(String str, String str2, int i, int i2, int i3) {
            super();
            this.event = 11;
            this.reqUrl = str;
            this.response = str2;
            this.statusCode = i;
            this.errCode = i2;
            this.target = i3;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.reqUrl);
            pushString16(this.response);
            pushInt(this.statusCode);
            pushInt(this.errCode);
            pushInt(this.target);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetPlaybackAudioFrameParameters extends YLEBase {
        private int mode;
        private int room;
        private int sampleRate;
        private int samplesPerCall;

        YLESetPlaybackAudioFrameParameters(int i, int i2, int i3, int i4) {
            super();
            this.event = 13;
            this.sampleRate = i;
            this.room = i2;
            this.mode = i3;
            this.samplesPerCall = i4;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.sampleRate);
            pushInt(this.room);
            pushInt(this.mode);
            pushInt(this.samplesPerCall);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEUpdatePublishOriginStreamUrl extends YLEBase {
        private boolean bAdd;
        private String srcUrl;

        public YLEUpdatePublishOriginStreamUrl(boolean z, String str) {
            super();
            this.event = 31;
            this.bAdd = z;
            this.srcUrl = str;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bAdd));
            pushString16(this.srcUrl);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEUpdatePublishTranscodingStreamUrl extends YLEBase {
        private boolean bAdd;
        private String taskId;
        private String transcodingUrl;

        public YLEUpdatePublishTranscodingStreamUrl(String str, boolean z, String str2) {
            super();
            this.event = 71;
            this.taskId = str;
            this.bAdd = z;
            this.transcodingUrl = str2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.taskId);
            pushBool(Boolean.valueOf(this.bAdd));
            pushString16(this.transcodingUrl);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetLiveTranscodingTask extends YLEBase {
        private String taskId;
        private LiveTranscoding transcoding;

        public YLESetLiveTranscodingTask(String str, LiveTranscoding liveTranscoding) {
            super();
            this.event = 72;
            this.taskId = str;
            this.transcoding = liveTranscoding;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.taskId);
            pushInt(this.transcoding.getTransCodingMode());
            pushInt(this.transcoding.getTransCodingStreamType());
            if (this.transcoding.getCustomTranscodingOptions() != null) {
                pushInt(this.transcoding.getCustomTranscodingOptions().videoCodecType);
                pushInt(this.transcoding.getCustomTranscodingOptions().videoBitrate);
                pushInt(this.transcoding.getCustomTranscodingOptions().videoFps);
                pushInt(this.transcoding.getCustomTranscodingOptions().videoGop);
                pushInt(this.transcoding.getCustomTranscodingOptions().videoWidth);
                pushInt(this.transcoding.getCustomTranscodingOptions().videoHeight);
                pushInt(this.transcoding.getCustomTranscodingOptions().audioCodecType);
                pushInt(this.transcoding.getCustomTranscodingOptions().audioSample);
                pushInt(this.transcoding.getCustomTranscodingOptions().audioBitrate);
                pushInt(this.transcoding.getCustomTranscodingOptions().audioChannel);
            } else {
                pushInt(0);
                pushInt(0);
                pushInt(0);
                pushInt(0);
                pushInt(0);
                pushInt(0);
                pushInt(0);
                pushInt(44100);
                pushInt(64);
                pushInt(2);
            }
            if (this.transcoding.getUsers() == null || this.transcoding.getUsers().isEmpty()) {
                pushInt(0);
            } else {
                pushInt(this.transcoding.getUserCount());
                Iterator<LiveTranscoding.TranscodingUser> it = this.transcoding.getUsers().iterator();
                while (it.hasNext()) {
                    LiveTranscoding.TranscodingUser next = it.next();
                    pushString16(next.uid);
                    pushString16(next.roomId);
                    pushBool(Boolean.valueOf(next.bStandard));
                    pushInt(next.layoutX);
                    pushInt(next.layoutY);
                    pushInt(next.layoutW);
                    pushInt(next.layoutH);
                    pushInt(next.zOrder);
                    pushBool(Boolean.valueOf(next.bCrop));
                    pushInt(next.cropX);
                    pushInt(next.cropY);
                    pushInt(next.cropW);
                    pushInt(next.cropH);
                    pushInt(next.layoutShape);
                    pushString16(String.valueOf(next.alpha * 1000000.0f));
                }
            }
            pushString16(this.transcoding.getAudioUrl());
            pushString16(this.transcoding.getLyricUrl());
            pushString16(this.transcoding.getMediaUrl());
            if (!this.transcoding.getMediaUrl().isEmpty() && this.transcoding.getMediaStreamLayout() != null) {
                LiveTranscoding.MediaStreamLayout mediaStreamLayout = this.transcoding.getMediaStreamLayout();
                pushInt(mediaStreamLayout.layoutX);
                pushInt(mediaStreamLayout.layoutY);
                pushInt(mediaStreamLayout.layoutW);
                pushInt(mediaStreamLayout.layoutH);
                pushInt(mediaStreamLayout.zOrder);
                pushBool(Boolean.valueOf(mediaStreamLayout.bCrop));
                pushInt(mediaStreamLayout.cropX);
                pushInt(mediaStreamLayout.cropY);
                pushInt(mediaStreamLayout.cropW);
                pushInt(mediaStreamLayout.cropH);
                pushString16(String.valueOf(mediaStreamLayout.alpha * 1000000.0f));
            }
            pushInt(this.transcoding.getBackgroundColor());
            TranscodingImage backgroundImage = this.transcoding.getBackgroundImage();
            if (backgroundImage != null && backgroundImage.url != null && !backgroundImage.url.isEmpty()) {
                pushString16(backgroundImage.url);
                pushInt(backgroundImage.scale);
            } else {
                pushString16("");
            }
            TranscodingTimestamp timestamp = this.transcoding.getTimestamp();
            if (timestamp != null && timestamp.format != null && !timestamp.format.isEmpty()) {
                pushString16(timestamp.format);
                pushInt(timestamp.x);
                pushInt(timestamp.y);
                pushString16(timestamp.font);
                pushInt(timestamp.size);
                pushInt(timestamp.color);
                pushInt(timestamp.backgroundColor);
                pushString16(String.valueOf(timestamp.alpha * 1000000.0f));
            } else {
                pushString16("");
            }
            ArrayList<TranscodingText> texts = this.transcoding.getTexts();
            if (texts == null || texts.isEmpty()) {
                pushInt(0);
            } else {
                pushInt(this.transcoding.getTextCount());
                Iterator<TranscodingText> it2 = texts.iterator();
                while (it2.hasNext()) {
                    TranscodingText next2 = it2.next();
                    pushInt(next2.x);
                    pushInt(next2.y);
                    pushString16(next2.content);
                    pushString16(next2.font);
                    pushInt(next2.size);
                    pushInt(next2.color);
                    pushInt(next2.backgroundColor);
                    pushString16(String.valueOf(next2.alpha * 1000000.0f));
                }
            }
            ArrayList<TranscodingImage> images = this.transcoding.getImages();
            if (images == null || images.isEmpty()) {
                pushInt(0);
            } else {
                pushInt(this.transcoding.getImageCount());
                Iterator<TranscodingImage> it3 = images.iterator();
                while (it3.hasNext()) {
                    TranscodingImage next3 = it3.next();
                    pushInt(next3.x);
                    pushInt(next3.y);
                    pushInt(next3.width);
                    pushInt(next3.height);
                    pushString16(next3.url);
                    pushInt(next3.scale);
                    pushString16(String.valueOf(next3.alpha * 1000000.0f));
                }
            }
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLERemoveLiveTranscodingTask extends YLEBase {
        private String taskId;

        public YLERemoveLiveTranscodingTask(String str) {
            super();
            this.event = 73;
            this.taskId = str;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.taskId);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetSidAndSubsid extends YLEBase {
        private int sid;
        private int subsid;

        public YLESetSidAndSubsid(int i, int i2) {
            super();
            this.event = 117;
            this.sid = i;
            this.subsid = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.sid);
            pushInt(this.subsid);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEPrefetchStreams extends YLEBase {
        private LinkedList<String> roomIds;
        private String uid;

        YLEPrefetchStreams(String str, LinkedList<String> linkedList) {
            super();
            this.event = 121;
            this.uid = str;
            this.roomIds = linkedList;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.uid);
            int size = this.roomIds.size();
            pushInt(size);
            for (int i = 0; i < size; i++) {
                pushString16(this.roomIds.get(i));
            }
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEQueryStreams extends YLEBase {
        private LinkedList<String> roomIds;

        YLEQueryStreams(LinkedList<String> linkedList) {
            super();
            this.event = 122;
            this.roomIds = linkedList;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            int size = this.roomIds.size();
            pushInt(size);
            for (int i = 0; i < size; i++) {
                pushString16(this.roomIds.get(i));
            }
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEMakeBehaviorEvent extends YLEBase {
        private int level;
        private String name;
        private String oval;
        private String val;

        YLEMakeBehaviorEvent(String str, String str2, String str3, int i) {
            super();
            this.event = 120;
            this.name = str;
            this.val = str2;
            this.oval = str3;
            this.level = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.name);
            pushString16(this.val);
            pushString16(this.oval);
            pushInt(this.level);
            return super.marshall();
        }
    }

    public static int init(long j, long j2, int i, int i2, Context context, ThunderDeviceInfo thunderDeviceInfo, NotificationDispatcher notificationDispatcher) {
        if (s_notificationLock == null) {
            s_notificationLock = new ReentrantLock();
        }
        s_notificationLock.lock();
        try {
            s_notificationDispatcher = notificationDispatcher;
            s_notificationLock.unlock();
            YLESdkInit yLESdkInit = new YLESdkInit(j, j2, i, i2, thunderDeviceInfo);
            MshBuffer mshBuffer = new MshBuffer(4096, NativeByteBufferPool.get());
            int YYLiveSdkInit = YYLiveSdkInit(context, yLESdkInit.HPmarshall(mshBuffer));
            mshBuffer.freeBuffer();
            isInit = true;
            return YYLiveSdkInit;
        } catch (Throwable th) {
            s_notificationLock.unlock();
            throw th;
        }
    }

    public static int setLogLevel(int i) {
        return (int) YLEProcess(new YLESetLogLevel(i));
    }

    public static int setLogFilePath(String str) {
        return (int) YLEProcess(new YLESetLogFilePath(str));
    }

    public static int setLogCallback(IThunderLogCallback iThunderLogCallback) {
        s_logCallback = iThunderLogCallback;
        return (int) YLEProcess(new YLEEnableLogCallback(iThunderLogCallback != null));
    }

    public static void setSceneId(long j) {
        YLEProcess(new YLESetSceneId(j));
    }

    public static int updateToken(byte[] bArr) {
        return (int) YLEProcess(new YLEUpdateToken(bArr));
    }

    public static int setMediaMode(int i) {
        return (int) YLEProcess(new YLESetMediaMode(i));
    }

    public static int setRoomMode(int i) {
        return (int) YLEProcess(new YLESetRoomMode(i));
    }

    public static int joinRoom(byte[] bArr, String str, String str2) {
        return (int) YLEProcess(new YLEJoinLiveEngineRoom(bArr, str, str2));
    }

    public static int setRemoteVideoCanvas(Object obj, int i, String str, int i2) {
        return (int) YLEProcess(new YLESetRemoteVideoCanvas(obj, i, str, i2));
    }

    public static int setRemoteVideoCanvasMode(String str, int i, int i2) {
        return (int) YLEProcess(new YLESetRemoteVideoCanvasMode(str, i, i2));
    }

    public static int setLocalVideoCanvas(Object obj, int i) {
        return (int) YLEProcess(new YLESetLocalVideoCanvas(obj, i));
    }

    public static int setLocalVideoCanvasMode(int i) {
        return (int) YLEProcess(new YLESetLocalVideoCanvasMode(i));
    }

    public static int subscribeUser(boolean z, String str, String str2) {
        return (int) YLEProcess(new YLESubscribeUser(z, str, str2));
    }

    public static int subscribeRoom(boolean z, String str) {
        return (int) YLEProcess(new YLESubscribeRoom(z, str));
    }

    public static int getUserRole() {
        return (int) YLEProcess(new YLEGetUserRole());
    }

    public static int setThunderboltSubscribeGroup(boolean z) {
        return (int) YLEProcess(new YLESetThunderboltSubscribeGroup(z));
    }

    public static int stopAllRemoteStreams(boolean z, boolean z2) {
        return (int) YLEProcess(new YLEStopAllRemoteStreams(z, z2));
    }

    public static int enableLocalDualStreamMode(boolean z) {
        return (int) YLEProcess(new YLEEnableLocalDualStreamMode(z));
    }

    public static int setDefaultRemoteVideoStreamType(int i) {
        return (int) YLEProcess(new YLESetDefaultRemoteVideoStreamType(i));
    }

    public static int changeRemoteVideoStreamType(String str, int i) {
        return (int) YLEProcess(new YLEChangeRemoteVideoStreamType(str, i));
    }

    public static int switchUserRole(int i) {
        return (int) YLEProcess(new YLESwitchUserRole(i));
    }

    public static int stopRemoteAudioStream(String str, boolean z) {
        return (int) YLEProcess(new YLEStopRemoteAudioStream(str, z));
    }

    public static int stopRemoteVideoStream(String str, boolean z) {
        return (int) YLEProcess(new YLEStopRemoteVideoStream(str, z));
    }

    public static int setAreaType(int i) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagCall, "setAreaType %d", Integer.valueOf(i));
        }
        return (int) YLEProcess(new YLESetAreaType(i));
    }

    public static int getConnectionStatus() {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagCall, "getConnectionStatus");
        }
        return (int) YLEProcess(new YLEGetConnectionStatus());
    }

    public static int startVideoCapture(boolean z) {
        return (int) YLEProcess(new YLEStartVideoCapture(z));
    }

    public static int startLocalVideoPreview(boolean z) {
        return (int) YLEProcess(new YLEStartLocalVideoPreview(z));
    }

    public static int setUse64bitUid(boolean z) {
        return (int) YLEProcess(new YLESetUse64bitUid(z));
    }

    public static int switchFrontCamera(boolean z) {
        return (int) YLEProcess(new YLESwitchFrontCamera(z));
    }

    public static boolean isCameraOpen() {
        return ((int) YLEProcess(new YLEIsCameraOpen())) != 0;
    }

    public static boolean isFrontCamera() {
        return ((int) YLEProcess(new YLEIsFrontCamera())) != 0;
    }

    public static int setCameraTorchOn(boolean z) {
        return (int) YLEProcess(new YLESetCameraTorchOn(z));
    }

    public static boolean isCameraManualFocusPositionSupported() {
        return ((int) YLEProcess(new YLEIsCameraManualFocusPositionSupported())) != 0;
    }

    public static boolean isCameraManualExposurePositionSupported() {
        return ((int) YLEProcess(new YLEIsCameraManualExposurePositionSupported())) != 0;
    }

    public static boolean isCameraZoomSupported() {
        return ((int) YLEProcess(new YLEIsCameraZoomSupported())) != 0;
    }

    public static float getCameraMaxZoomFactor() {
        return (((float) YLEProcess(new YLEGetCameraMaxZoomFactor())) * 1.0f) / 1000000.0f;
    }

    public static int setCameraZoomFactor(float f) {
        return (int) YLEProcess(new YLESetCameraZoomFactor(f));
    }

    public static boolean isCameraTorchSupported() {
        return ((int) YLEProcess(new YLEIsCameraTorchSupported())) != 0;
    }

    public static int setCameraFocusPosition(float f, float f2) {
        return (int) YLEProcess(new YLESetCameraFocusPosition(f, f2));
    }

    public static int setCameraExposurePosition(float f, float f2) {
        return (int) YLEProcess(new YLESetCameraExposurePosition(f, f2));
    }

    public static boolean isCameraAutoFocusFaceModeSupported() {
        return ((int) YLEProcess(new YLEIsCameraAutoFocusFaceModeSupported())) != 0;
    }

    public static int setCameraAutoFocusFaceModeEnabled(boolean z) {
        return (int) YLEProcess(new YLESetCameraAutoFocusFaceModeEnabled(z));
    }

    public static int startPushAudioStream(boolean z) {
        return (int) YLEProcess(new YLEStartPushAudioStream(z));
    }

    public static int isAudioCaptureEnabled() {
        return (int) YLEProcess(new YLEIsAudioCaptureEnabled());
    }

    public static int isAudioEncoderEnabled() {
        return (int) YLEProcess(new YLEIsAudioEncoderEnabled());
    }

    public static int isAudioPublisherEnabled() {
        return (int) YLEProcess(new YLEIsAudioPublisherEnabled());
    }

    public static int setAudioConfig(int i, int i2, int i3) {
        return (int) YLEProcess(new YLESetAudioConfig(i, i2, i3));
    }

    public static int startPublishAudio(boolean z) {
        return (int) YLEProcess(new YLEStartPublishAudio(z));
    }

    public static int startAudioCapture(boolean z) {
        return (int) YLEProcess(new YLEStartAudioCapture(z));
    }

    public static int startAudioEncode(boolean z) {
        return (int) YLEProcess(new YLEStartAudioEncode(z));
    }

    public static int setAudioPublishMode(int i) {
        return (int) YLEProcess(new YLESetAudioPublishMode(i));
    }

    public static int setCustomAudioSource(boolean z, int i, int i2) {
        return (int) YLEProcess(new YLESetCustomAudioSource(z, i, i2));
    }

    public static int setPubWatermark(ThunderBoltImage thunderBoltImage) {
        return (int) YLEProcess(new YLESetPubWatermark(thunderBoltImage));
    }

    public static int pushCustomAudioFrame(byte[] bArr, long j) {
        return (int) YLEProcess(new YLEPushCustomAudioFrame(bArr, j));
    }

    public static int startVideoEncode(boolean z) {
        return (int) YLEProcess(new YLEStartVideoEncode(z));
    }

    public static int startPushVideoStream(boolean z) {
        return (int) YLEProcess(new YLEStartPushVideoStream(z));
    }

    public static int startPreview(boolean z) {
        return (int) YLEProcess(new YLEStartPreview(z));
    }

    public static int attachVideoCapture(Object obj, int i) {
        return (int) YLEProcess(new YLEAttachVideoCapture(obj, i));
    }

    public static int setVideoEncoderConfig(ThunderVideoEncoderConfiguration thunderVideoEncoderConfiguration) {
        return (int) YLEProcess(new YLESetVideoEncoderConfig(thunderVideoEncoderConfiguration.playType, thunderVideoEncoderConfiguration.publishMode));
    }

    public static int setCustomVideoPublishConfig(ThunderPublishVideoConfig thunderPublishVideoConfig) {
        return (int) YLEProcess(new YLESetCustomVideoPublishConfig(thunderPublishVideoConfig.playType, thunderPublishVideoConfig.mode, thunderPublishVideoConfig.encodeResolutionWidth, thunderPublishVideoConfig.encodeResolutionHeight, thunderPublishVideoConfig.encodeBitrate, thunderPublishVideoConfig.encodeFrameRate, thunderPublishVideoConfig.lowStreamCfgs));
    }

    public static int setCustomStreamName(int i, String str) {
        return (int) YLEProcess(new YLESetCustomStreamName(i, str));
    }

    public static int setSubscribeGroupInThunder(boolean z) {
        return (int) YLEProcess(new YLESetSubscribeGroupInThunder(z));
    }

    public static int setCustomPublishAppid(int i) {
        return (int) YLEProcess(new YLESetCustomPublishAppid(i));
    }

    public static void notifyNetState(int i) {
        YLEProcess(new YLENotifyNetworkState(i));
    }

    public static void enterBackground() {
        YLEProcess(new YLEEnterBackground());
    }

    public static void enterForeground() {
        YLEProcess(new YLEEnterForeground());
    }

    public static int enableLoudSpeaker(boolean z) {
        return (int) YLEProcess(new YLEEnableLoudSpeaker(z));
    }

    public static boolean getLoudSpeakerEnabled() {
        return ((int) YLEProcess(new YLEGetLoudSpeakerEnabled())) == 0;
    }

    public static int adaptToSystemKaraoke(boolean z) {
        return (int) YLEProcess(new YLEadaptToSystemKaraoke(z));
    }

    public static int enableInEarMonitor(boolean z) {
        return (int) YLEProcess(new YLEenableInEarMonitor(z));
    }

    public static int setEarMonitoringVolume(int i) {
        return (int) YLEProcess(new YLEsetEarMonitoringVolume(i));
    }

    public static int enableEqualizer(boolean z) {
        return (int) YLEProcess(new YLEEnableEqualizer(z));
    }

    public static int setGqGains(int[] iArr) {
        return (int) YLEProcess(new YLESetEqGains(iArr));
    }

    public static int enableCompressor(boolean z) {
        return (int) YLEProcess(new YLEEnableCompressor(z));
    }

    public static int setVoicePitch(float f) {
        return (int) YLEProcess(new YLESetVoicePitch(f));
    }

    public static int enableHowlingDetector(boolean z) {
        return (int) YLEProcess(new YLEEnableHowlingDetector(z));
    }

    public static int enableEchoDetector(boolean z) {
        return (int) YLEProcess(new YLEEnableEchoDetector(z));
    }

    public static int startInputDeviceTest() {
        return (int) YLEProcess(new YLEStartInputDeviceTest());
    }

    public static int stopInputDeviceTest() {
        return (int) YLEProcess(new YLEStopInputDeviceTest());
    }

    public static int startOutputDeviceTest(String str) {
        return (int) YLEProcess(new YLEStartOutputDeviceTest(str));
    }

    public static int stopOutputDeviceTest() {
        return (int) YLEProcess(new YLEStopOutputDeviceTest());
    }

    public static int enableMicDenoise(boolean z) {
        return (int) YLEProcess(new YLEEnableMicDenoise(z));
    }

    public static int enableAGC(boolean z) {
        return (int) YLEProcess(new YLEEnableAudioAGC(z));
    }

    public static int enableAIDenoise(boolean z) {
        return (int) YLEProcess(new YLEEnableAIDenoise(z));
    }

    public static boolean micDenoiseEnabled() {
        return ((int) YLEProcess(new YLEIsMicDenoiseEnable())) != 0;
    }

    public static int setCompressorParam(int i, int i2, int i3, int i4, int i5, int i6) {
        return (int) YLEProcess(new YLESetCompressorParam(i, i2, i3, i4, i5, i6));
    }

    public static int enableReverb(boolean z) {
        return (int) YLEProcess(new YLEEnableReverb(z));
    }

    public static int setReverbExParameter(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return (int) YLEProcess(new YLESetReverbExParameter(f, f2, f3, f4, f5, f6, f7, f8, f9));
    }

    public static int setLimiterParameter(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return (int) YLEProcess(new YLESetLimiterParameter(f, f2, f3, f4, f5, f6, f7, f8, f9));
    }

    public static int enableLimiter(boolean z) {
        return (int) YLEProcess(new YLEEnableLimiter(z));
    }

    public static boolean startAudioSaver(String str, int i, int i2) {
        return YLEProcess(new YLEStartAudioSaver(str, i, i2)) == 0;
    }

    public static boolean stopAudioSaver() {
        return YLEProcess(new YLEStopAudioSaver()) == 0;
    }

    public static int startAudioRecord(String str, int i, int i2, int i3) {
        return (int) YLEProcess(new YLEStartAudioRecord(str, i, i2, i3));
    }

    public static int stopAudioRecord() {
        return (int) YLEProcess(new YLEStopAudioRecord());
    }

    public static int enableAudioPlaySpectrum(boolean z) {
        return (int) YLEProcess(new YLEEnableAudioPlaySpectrum(z));
    }

    public static int setAudioPlaySpectrumInfo(int i, int i2) {
        return (int) YLEProcess(new YLESetAudioPlaySpectrumInfo(i, i2));
    }

    public static int enableVoicePosition(boolean z) {
        return (int) YLEProcess(new YLEEnableVoicePosition(z));
    }

    public static boolean setSoundEffect(int i) {
        return 0 == YLEProcess(new YLESetSoundEffect(i));
    }

    public static boolean setVoiceChanger(int i) {
        return 0 == YLEProcess(new YLESetVoiceChanger(i));
    }

    public static int setVideoFrameObserver(String str, IVideoDecodeObserver iVideoDecodeObserver) {
        return (int) YLEProcess(new YLEVideoFrameObserverStringUid(str, iVideoDecodeObserver));
    }

    public static int setRecordingAudioFrameParameters(int i, int i2, int i3, int i4) {
        return (int) YLEProcess(new YLESetRecordingAudioFrameParameters(i, i2, i3, i4));
    }

    public static int setMixedAudioFrameParameters(int i, int i2, int i3) {
        return (int) YLEProcess(new YLESetMixedAudioFrameParameters(i, i2, i3));
    }

    public static int updatePublishOriginStreamUrl(boolean z, String str) {
        return (int) YLEProcess(new YLEUpdatePublishOriginStreamUrl(z, str));
    }

    public static int updatePublishTranscodingStreamUrl(String str, boolean z, String str2) {
        return (int) YLEProcess(new YLEUpdatePublishTranscodingStreamUrl(str, z, str2));
    }

    public static int setLiveTranscodingTask(String str, LiveTranscoding liveTranscoding) {
        return (int) YLEProcess(new YLESetLiveTranscodingTask(str, liveTranscoding));
    }

    public static int removeLiveTranscodingTask(String str) {
        return (int) YLEProcess(new YLERemoveLiveTranscodingTask(str));
    }

    public static int setSidAndSubsid(int i, int i2) {
        return (int) YLEProcess(new YLESetSidAndSubsid(i, i2));
    }

    public static int makeBehaviorEvent(String str, String str2, String str3, int i) {
        return (int) YLEProcess(new YLEMakeBehaviorEvent(str, str2, str3, i));
    }

    public static int prefetchStreams(String str, LinkedList<String> linkedList) {
        return (int) YLEProcess(new YLEPrefetchStreams(str, linkedList));
    }

    public static int queryStreams(LinkedList<String> linkedList) {
        return (int) YLEProcess(new YLEQueryStreams(linkedList));
    }

    /* loaded from: classes4.dex */
    private static class YLESetLogLevel extends YLEBase {
        private int logLevel;

        public YLESetLogLevel(int i) {
            super();
            this.event = 68;
            this.logLevel = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.logLevel);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetLogFilePath extends YLEBase {
        private String filePath;

        public YLESetLogFilePath(String str) {
            super();
            this.event = 69;
            this.filePath = str;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.filePath);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableLogCallback extends YLEBase {
        private boolean bCallback;

        public YLEEnableLogCallback(boolean z) {
            super();
            this.event = 70;
            this.bCallback = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bCallback));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetSceneId extends YLEBase {
        private long sceneId;

        YLESetSceneId(long j) {
            super();
            this.event = 2;
            this.sceneId = j;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.sceneId);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEUpdateToken extends YLEBase {
        byte[] token;

        YLEUpdateToken(byte[] bArr) {
            super();
            this.event = 5;
            this.token = bArr;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBytes(this.token);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetMediaMode extends YLEBase {
        private int mediaMode;

        public YLESetMediaMode(int i) {
            super();
            this.event = 65;
            this.mediaMode = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.mediaMode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetRoomMode extends YLEBase {
        private int roomMode;

        public YLESetRoomMode(int i) {
            super();
            this.event = 66;
            this.roomMode = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.roomMode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEJoinLiveEngineRoom extends YLEBase {
        private String roomId;
        private byte[] token;
        private String uid;

        public YLEJoinLiveEngineRoom(byte[] bArr, String str, String str2) {
            super();
            this.event = 6;
            this.token = bArr;
            this.roomId = str;
            this.uid = str2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBytes(this.token);
            pushString16(this.roomId);
            pushString16(this.uid);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetRemoteVideoCanvas extends YLEBase {
        private int renderMode;
        private int seatIndex;
        private String uid;
        private Object view;

        public YLESetRemoteVideoCanvas(Object obj, int i, String str, int i2) {
            super();
            this.event = 74;
            this.view = obj;
            this.renderMode = i;
            this.uid = str;
            this.seatIndex = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(ThunderNative.YYLiveObjectToPtr(this.view));
            pushInt(this.renderMode);
            pushString16(this.uid);
            pushInt(this.seatIndex);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetRemoteVideoCanvasMode extends YLEBase {
        private int mirrorMode;
        private int renderMode;
        private String uid;

        public YLESetRemoteVideoCanvasMode(String str, int i, int i2) {
            super();
            this.event = 75;
            this.uid = str;
            this.renderMode = i;
            this.mirrorMode = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.uid);
            pushInt(this.renderMode);
            pushInt(this.mirrorMode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetLocalVideoCanvas extends YLEBase {
        private int scaleMode;
        private Object view;

        public YLESetLocalVideoCanvas(Object obj, int i) {
            super();
            this.event = 76;
            this.view = obj;
            this.scaleMode = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(ThunderNative.YYLiveObjectToPtr(this.view));
            pushInt(this.scaleMode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetLocalVideoCanvasMode extends YLEBase {
        private int mode;

        public YLESetLocalVideoCanvasMode(int i) {
            super();
            this.event = 77;
            this.mode = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.mode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESubscribeUser extends YLEBase {
        private boolean bSubscribe;
        private String roomId;
        private String uid;

        public YLESubscribeUser(boolean z, String str, String str2) {
            super();
            this.event = 78;
            this.bSubscribe = z;
            this.roomId = str;
            this.uid = str2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bSubscribe));
            pushString16(this.roomId);
            pushString16(this.uid);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESubscribeRoom extends YLEBase {
        private boolean bSubscribe;
        private String roomId;

        public YLESubscribeRoom(boolean z, String str) {
            super();
            this.event = ThunderNative.THUNDER_SUBSCRIBE_ROOM;
            this.bSubscribe = z;
            this.roomId = str;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bSubscribe));
            pushString16(this.roomId);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetUserRole extends YLEBase {
        public YLEGetUserRole() {
            super();
            this.event = ThunderNative.THUNDER_GET_USER_ROLE;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetThunderboltSubscribeGroup extends YLEBase {
        private boolean bSubscribe;

        public YLESetThunderboltSubscribeGroup(boolean z) {
            super();
            this.event = 79;
            this.bSubscribe = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bSubscribe));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStopAllRemoteStreams extends YLEBase {
        private boolean bStop;
        private boolean bVideo;

        public YLEStopAllRemoteStreams(boolean z, boolean z2) {
            super();
            this.event = 80;
            this.bVideo = z;
            this.bStop = z2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bVideo));
            pushBool(Boolean.valueOf(this.bStop));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableLocalDualStreamMode extends YLEBase {
        private boolean enbaled;

        public YLEEnableLocalDualStreamMode(boolean z) {
            super();
            this.event = 128;
            this.enbaled = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enbaled));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetDefaultRemoteVideoStreamType extends YLEBase {
        private int type;

        public YLESetDefaultRemoteVideoStreamType(int i) {
            super();
            this.event = ThunderNative.THUNDER_SET_DEFAULT_REMOTE_VIDEO_STREAM_TYPE;
            this.type = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.type);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEChangeRemoteVideoStreamType extends YLEBase {
        private int type;
        private String uid;

        public YLEChangeRemoteVideoStreamType(String str, int i) {
            super();
            this.event = 130;
            this.uid = str;
            this.type = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.uid);
            pushInt(this.type);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESwitchUserRole extends YLEBase {
        private int role;

        public YLESwitchUserRole(int i) {
            super();
            this.event = ThunderNative.THUNDER_SWITCH_USER_ROLE;
            this.role = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.role);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStopRemoteAudioStream extends YLEBase {
        private boolean bStop;
        private String uid;

        public YLEStopRemoteAudioStream(String str, boolean z) {
            super();
            this.event = 81;
            this.uid = str;
            this.bStop = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.uid);
            pushBool(Boolean.valueOf(this.bStop));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStopRemoteVideoStream extends YLEBase {
        private boolean bStop;
        private String uid;

        public YLEStopRemoteVideoStream(String str, boolean z) {
            super();
            this.event = 82;
            this.uid = str;
            this.bStop = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.uid);
            pushBool(Boolean.valueOf(this.bStop));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetAreaType extends YLEBase {
        private int areaType;

        YLESetAreaType(int i) {
            super();
            this.event = 8;
            this.areaType = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.areaType);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetUse64bitUid extends YLEBase {
        private boolean bUser64bitUid;

        public YLESetUse64bitUid(boolean z) {
            super();
            this.event = 67;
            this.bUser64bitUid = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bUser64bitUid));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartVideoCapture extends YLEBase {
        private boolean bStart;

        public YLEStartVideoCapture(boolean z) {
            super();
            this.event = 30;
            this.bStart = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bStart));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartLocalVideoPreview extends YLEBase {
        private boolean bStart;

        public YLEStartLocalVideoPreview(boolean z) {
            super();
            this.event = ThunderNative.THUNDER_START_VIDEO_LOCAL_PREVIEW;
            this.bStart = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bStart));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESwitchFrontCamera extends YLEBase {
        private boolean bFront;

        public YLESwitchFrontCamera(boolean z) {
            super();
            this.event = 83;
            this.bFront = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bFront));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsCameraOpen extends YLEBase {
        public YLEIsCameraOpen() {
            super();
            this.event = 201;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsFrontCamera extends YLEBase {
        public YLEIsFrontCamera() {
            super();
            this.event = 202;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsCameraManualFocusPositionSupported extends YLEBase {
        public YLEIsCameraManualFocusPositionSupported() {
            super();
            this.event = 203;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsCameraManualExposurePositionSupported extends YLEBase {
        public YLEIsCameraManualExposurePositionSupported() {
            super();
            this.event = 204;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsCameraZoomSupported extends YLEBase {
        public YLEIsCameraZoomSupported() {
            super();
            this.event = 205;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsCameraTorchSupported extends YLEBase {
        public YLEIsCameraTorchSupported() {
            super();
            this.event = 208;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetCameraMaxZoomFactor extends YLEBase {
        public YLEGetCameraMaxZoomFactor() {
            super();
            this.event = 206;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCameraZoomFactor extends YLEBase {
        private float zoomFactor;

        public YLESetCameraZoomFactor(float f) {
            super();
            this.event = 207;
            this.zoomFactor = f;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(String.valueOf(this.zoomFactor * 1000000.0f));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCameraTorchOn extends YLEBase {
        private boolean isOn;

        public YLESetCameraTorchOn(boolean z) {
            super();
            this.event = 200;
            this.isOn = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.isOn));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCameraFocusPosition extends YLEBase {
        private float posX;
        private float posY;

        public YLESetCameraFocusPosition(float f, float f2) {
            super();
            this.event = 209;
            this.posX = f;
            this.posY = f2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(String.valueOf(this.posX * 1000000.0f));
            pushString16(String.valueOf(this.posY * 1000000.0f));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCameraExposurePosition extends YLEBase {
        private float posX;
        private float posY;

        public YLESetCameraExposurePosition(float f, float f2) {
            super();
            this.event = 210;
            this.posX = f;
            this.posY = f2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(String.valueOf(this.posX * 1000000.0f));
            pushString16(String.valueOf(this.posY * 1000000.0f));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsCameraAutoFocusFaceModeSupported extends YLEBase {
        public YLEIsCameraAutoFocusFaceModeSupported() {
            super();
            this.event = ThunderNative.THUNDER_IS_CAMERA_AUTO_FOCUS_FACE_MODE_SUPPORTED;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCameraAutoFocusFaceModeEnabled extends YLEBase {
        private boolean enable;

        public YLESetCameraAutoFocusFaceModeEnabled(boolean z) {
            super();
            this.event = ThunderNative.THUNDER_SET_CAMERA_AUTO_FOCUS_FACE_MODE_ENABLED;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESendPrivateMediaExtraData extends YLEBase {
        private String extraData;

        YLESendPrivateMediaExtraData(String str) {
            super();
            this.event = ThunderNative.THUNDER_SEND_PRIVATE_MEDIA_EXTRA_DATA;
            this.extraData = str;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.extraData);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartPublishAudio extends YLEBase {
        private boolean bStart;

        public YLEStartPublishAudio(boolean z) {
            super();
            this.event = 84;
            this.bStart = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bStart));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartAudioCapture extends YLEBase {
        private boolean bStart;

        public YLEStartAudioCapture(boolean z) {
            super();
            this.event = ThunderNative.THUNDER_START_AUDIO_CAPTURE;
            this.bStart = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bStart));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartAudioEncode extends YLEBase {
        private boolean bStart;

        public YLEStartAudioEncode(boolean z) {
            super();
            this.event = ThunderNative.THUNDER_START_AUDIO_ENCODE;
            this.bStart = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bStart));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartPushAudioStream extends YLEBase {
        private boolean bStart;

        public YLEStartPushAudioStream(boolean z) {
            super();
            this.event = 85;
            this.bStart = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bStart));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetAudioPublishMode extends YLEBase {
        private int sourceType;

        public YLESetAudioPublishMode(int i) {
            super();
            this.event = 87;
            this.sourceType = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.sourceType);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetAudioConfig extends YLEBase {
        private int commutMode;
        private int profile;
        private int scenarioMode;

        public YLESetAudioConfig(int i, int i2, int i3) {
            super();
            this.event = 86;
            this.profile = i;
            this.commutMode = i2;
            this.scenarioMode = i3;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.profile);
            pushInt(this.commutMode);
            pushInt(this.scenarioMode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCustomAudioSource extends YLEBase {
        private boolean bEnable;
        private int channel;
        private int sampleRate;

        public YLESetCustomAudioSource(boolean z, int i, int i2) {
            super();
            this.event = 88;
            this.bEnable = z;
            this.sampleRate = i;
            this.channel = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bEnable));
            pushInt(this.sampleRate);
            pushInt(this.channel);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetPubWatermark extends YLEBase {
        private int height;
        private String imageUrl;
        private int width;
        private int x;
        private int y;

        public YLESetPubWatermark(ThunderBoltImage thunderBoltImage) {
            super();
            this.x = 0;
            this.y = 0;
            this.width = 0;
            this.height = 0;
            this.imageUrl = null;
            this.event = 89;
            if (thunderBoltImage != null) {
                this.x = thunderBoltImage.x;
                this.y = thunderBoltImage.y;
                this.width = thunderBoltImage.width;
                this.height = thunderBoltImage.height;
                this.imageUrl = thunderBoltImage.url;
            }
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.x);
            pushInt(this.y);
            pushInt(this.width);
            pushInt(this.height);
            pushString16(this.imageUrl);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEPushCustomAudioFrame extends YLEBase {
        private byte[] data;
        private long timeStamp;

        public YLEPushCustomAudioFrame(byte[] bArr, long j) {
            super();
            this.event = 90;
            this.data = bArr;
            this.timeStamp = j;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBytes(this.data);
            pushInt64(this.timeStamp);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartVideoEncode extends YLEBase {
        private boolean bEnable;

        public YLEStartVideoEncode(boolean z) {
            super();
            this.event = 91;
            this.bEnable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bEnable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartPushVideoStream extends YLEBase {
        private boolean bEnable;

        public YLEStartPushVideoStream(boolean z) {
            super();
            this.event = 92;
            this.bEnable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bEnable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartPreview extends YLEBase {
        private boolean bEnable;

        public YLEStartPreview(boolean z) {
            super();
            this.event = 93;
            this.bEnable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bEnable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEAttachVideoCapture extends YLEBase {
        private int capType;
        private Object capture;

        public YLEAttachVideoCapture(Object obj, int i) {
            super();
            this.event = 94;
            this.capture = obj;
            this.capType = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt64(ThunderNative.YYLiveObjectToPtr(this.capture));
            pushInt(this.capType);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetVideoEncoderConfig extends YLEBase {
        private int playType;
        private int publishMode;

        public YLESetVideoEncoderConfig(int i, int i2) {
            super();
            this.event = 95;
            this.playType = i;
            this.publishMode = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.playType);
            pushInt(this.publishMode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCustomVideoPublishConfig extends YLEBase {
        private int bitrate;
        private int fps;
        private int height;
        private LinkedList<ThunderPublishLowStreamVideoConfig> lowCfgs;
        private int playType;
        private int publishMode;
        private int width;

        public YLESetCustomVideoPublishConfig(int i, int i2, int i3, int i4, int i5, int i6, LinkedList<ThunderPublishLowStreamVideoConfig> linkedList) {
            super();
            this.event = 127;
            this.playType = i;
            this.publishMode = i2;
            this.width = i3;
            this.height = i4;
            this.bitrate = i5;
            this.fps = i6;
            this.lowCfgs = linkedList;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.playType);
            pushInt(this.publishMode);
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.bitrate);
            pushInt(this.fps);
            pushInt(this.lowCfgs.size());
            Iterator<ThunderPublishLowStreamVideoConfig> it = this.lowCfgs.iterator();
            while (it.hasNext()) {
                ThunderPublishLowStreamVideoConfig next = it.next();
                pushInt(next.type);
                pushInt(next.encodeResolutionWidth);
                pushInt(next.encodeResolutionHeight);
                pushInt(next.encodeBitrate);
                pushInt(next.encodeFrameRate);
            }
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCameraZoomConfig extends YLEBase {
        private float zoomFactor;

        public YLESetCameraZoomConfig(float f) {
            super();
            this.event = 207;
            this.zoomFactor = f;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(String.valueOf(this.zoomFactor * 1000000.0f));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCustomStreamName extends YLEBase {
        private String streamName;
        private int streamType;

        public YLESetCustomStreamName(int i, String str) {
            super();
            this.event = ThunderNative.THUNDER_SET_CUSTOM_STREAM_NAME;
            this.streamType = i;
            this.streamName = str;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.streamType);
            pushString16(this.streamName);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetSubscribeGroupInThunder extends YLEBase {
        private boolean bSubscribe;

        public YLESetSubscribeGroupInThunder(boolean z) {
            super();
            this.event = ThunderNative.THUNDER_SET_SUBSCRIBE_GROUP_IN_THUNDER;
            this.bSubscribe = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bSubscribe));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCustomPublishAppid extends YLEBase {
        private int pubAppid;

        public YLESetCustomPublishAppid(int i) {
            super();
            this.event = ThunderNative.THUNDER_SET_CUSTOM_PUBLISH_APPID;
            this.pubAppid = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.pubAppid);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLENotifyNetworkState extends YLEBase {
        private int state;

        YLENotifyNetworkState(int i) {
            super();
            this.event = 96;
            this.state = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.state);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetConnectionStatus extends YLEBase {
        YLEGetConnectionStatus() {
            super();
            this.event = 124;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableLoudSpeaker extends YLEBase {
        private boolean bEnable;

        public YLEEnableLoudSpeaker(boolean z) {
            super();
            this.event = 99;
            this.bEnable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.bEnable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEGetLoudSpeakerEnabled extends YLEBase {
        private int reverse;

        YLEGetLoudSpeakerEnabled() {
            super();
            this.event = 100;
            this.reverse = 0;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.reverse);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEadaptToSystemKaraoke extends YLEBase {
        private boolean enable;

        YLEadaptToSystemKaraoke(boolean z) {
            super();
            this.event = 132;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEenableInEarMonitor extends YLEBase {
        private boolean enable;

        YLEenableInEarMonitor(boolean z) {
            super();
            this.event = 101;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEsetEarMonitoringVolume extends YLEBase {
        private int volume;

        YLEsetEarMonitoringVolume(int i) {
            super();
            this.event = 131;
            this.volume = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.volume);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableEqualizer extends YLEBase {
        private boolean enable;

        YLEEnableEqualizer(boolean z) {
            super();
            this.event = 102;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetEqGains extends YLEBase {
        private float mBand0;
        private float mBand1;
        private float mBand2;
        private float mBand3;
        private float mBand4;
        private float mBand5;
        private float mBand6;
        private float mBand7;
        private float mBand8;
        private float mBand9;
        private float mPreamp;

        YLESetEqGains(int[] iArr) {
            super();
            this.event = 103;
            this.mPreamp = iArr[0];
            this.mBand0 = iArr[1];
            this.mBand1 = iArr[2];
            this.mBand2 = iArr[3];
            this.mBand3 = iArr[4];
            this.mBand4 = iArr[5];
            this.mBand5 = iArr[6];
            this.mBand6 = iArr[7];
            this.mBand7 = iArr[8];
            this.mBand8 = iArr[9];
            this.mBand9 = iArr[10];
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(String.valueOf(this.mPreamp * 1000000.0f));
            pushString16(String.valueOf(this.mBand0 * 1000000.0f));
            pushString16(String.valueOf(this.mBand1 * 1000000.0f));
            pushString16(String.valueOf(this.mBand2 * 1000000.0f));
            pushString16(String.valueOf(this.mBand3 * 1000000.0f));
            pushString16(String.valueOf(this.mBand4 * 1000000.0f));
            pushString16(String.valueOf(this.mBand5 * 1000000.0f));
            pushString16(String.valueOf(this.mBand6 * 1000000.0f));
            pushString16(String.valueOf(this.mBand7 * 1000000.0f));
            pushString16(String.valueOf(this.mBand8 * 1000000.0f));
            pushString16(String.valueOf(this.mBand9 * 1000000.0f));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableCompressor extends YLEBase {
        private boolean enable;

        YLEEnableCompressor(boolean z) {
            super();
            this.event = 104;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetVoicePitch extends YLEBase {
        private float pitch;

        YLESetVoicePitch(float f) {
            super();
            this.event = 125;
            this.pitch = f;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(String.valueOf(this.pitch * 1000000.0f));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableHowlingDetector extends YLEBase {
        private boolean enable;

        YLEEnableHowlingDetector(boolean z) {
            super();
            this.event = 126;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableEchoDetector extends YLEBase {
        private boolean enable;

        YLEEnableEchoDetector(boolean z) {
            super();
            this.event = ThunderNative.THUNDER_ENABLE_ECHO_DETECTOR;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartInputDeviceTest extends YLEBase {
        YLEStartInputDeviceTest() {
            super();
            this.event = ThunderNative.THUNDER_START_INPUT_DEVICE_TEST;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStopInputDeviceTest extends YLEBase {
        YLEStopInputDeviceTest() {
            super();
            this.event = ThunderNative.THUNDER_STOP_INPUT_DEVICE_TEST;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartOutputDeviceTest extends YLEBase {
        private String filePath;

        YLEStartOutputDeviceTest(String str) {
            super();
            this.event = ThunderNative.THUNDER_START_OUTPUT_DEVICE_TEST;
            this.filePath = str;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.filePath);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStopOutputDeviceTest extends YLEBase {
        YLEStopOutputDeviceTest() {
            super();
            this.event = ThunderNative.THUNDER_STOP_OUTPUT_DEVICE_TEST;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsAudioCaptureEnabled extends YLEBase {
        YLEIsAudioCaptureEnabled() {
            super();
            this.event = ThunderNative.THUNDER_IS_AUDIO_CAPTURE_ENABLED;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsAudioEncoderEnabled extends YLEBase {
        YLEIsAudioEncoderEnabled() {
            super();
            this.event = 154;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsAudioPublisherEnabled extends YLEBase {
        YLEIsAudioPublisherEnabled() {
            super();
            this.event = ThunderNative.THUNDER_IS_AUDIO_PUBLISHER_ENABLED;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableMicDenoise extends YLEBase {
        private boolean enable;

        YLEEnableMicDenoise(boolean z) {
            super();
            this.event = ThunderNative.THUNDER_ENABLE_AUDIO_MIC_DENOISE;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableAudioAGC extends YLEBase {
        private boolean enable;

        YLEEnableAudioAGC(boolean z) {
            super();
            this.event = ThunderNative.THUNDER_ENABLE_AUDIO_AGC;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableAIDenoise extends YLEBase {
        private boolean enable;

        YLEEnableAIDenoise(boolean z) {
            super();
            this.event = 153;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEIsMicDenoiseEnable extends YLEBase {
        YLEIsMicDenoiseEnable() {
            super();
            this.event = ThunderNative.THUNDER_IS_AUDIO_MIC_DENOISE_ENABLE;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetCompressorParam extends YLEBase {
        private int mattackTime;
        private int mknee;
        private int mmakeupGain;
        private int mratio;
        private int mreleaseTime;
        private int mthreshold;

        YLESetCompressorParam(int i, int i2, int i3, int i4, int i5, int i6) {
            super();
            this.event = 105;
            this.mthreshold = i;
            this.mmakeupGain = i2;
            this.mratio = i3;
            this.mknee = i4;
            this.mreleaseTime = i5;
            this.mattackTime = i6;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.mthreshold);
            pushInt(this.mmakeupGain);
            pushInt(this.mratio);
            pushInt(this.mknee);
            pushInt(this.mreleaseTime);
            pushInt(this.mattackTime);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableReverb extends YLEBase {
        private boolean enable;

        YLEEnableReverb(boolean z) {
            super();
            this.event = 106;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetReverbExParameter extends YLEBase {
        private float mDryGain;
        private float mHfDamping;
        private float mPreDelay;
        private float mReverberance;
        private float mRoomSize;
        private float mStereoWidth;
        private float mToneHigh;
        private float mToneLow;
        private float mWetGain;

        YLESetReverbExParameter(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
            super();
            this.event = 107;
            this.mRoomSize = f;
            this.mPreDelay = f2;
            this.mReverberance = f3;
            this.mHfDamping = f4;
            this.mToneLow = f5;
            this.mToneHigh = f6;
            this.mWetGain = f7;
            this.mDryGain = f8;
            this.mStereoWidth = f9;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(String.valueOf(this.mRoomSize * 1000000.0f));
            pushString16(String.valueOf(this.mPreDelay * 1000000.0f));
            pushString16(String.valueOf(this.mReverberance * 1000000.0f));
            pushString16(String.valueOf(this.mHfDamping * 1000000.0f));
            pushString16(String.valueOf(this.mToneLow * 1000000.0f));
            pushString16(String.valueOf(this.mToneHigh * 1000000.0f));
            pushString16(String.valueOf(this.mWetGain * 1000000.0f));
            pushString16(String.valueOf(this.mDryGain * 1000000.0f));
            pushString16(String.valueOf(this.mStereoWidth * 1000000.0f));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetLimiterParameter extends YLEBase {
        private float m_fAttack;
        private float m_fCeiling;
        private float m_fLookahead;
        private float m_fLookaheadRatio;
        private float m_fPreGain;
        private float m_fRMS;
        private float m_fRelease;
        private float m_fStLink;
        private float m_fThreshold;

        YLESetLimiterParameter(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
            super();
            this.event = 108;
            this.m_fCeiling = f;
            this.m_fRelease = f4;
            this.m_fLookaheadRatio = f7;
            this.m_fThreshold = f2;
            this.m_fAttack = f5;
            this.m_fRMS = f8;
            this.m_fPreGain = f3;
            this.m_fLookahead = f6;
            this.m_fStLink = f9;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(String.valueOf(this.m_fCeiling * 1000000.0f));
            pushString16(String.valueOf(this.m_fRelease * 1000000.0f));
            pushString16(String.valueOf(this.m_fLookaheadRatio * 1000000.0f));
            pushString16(String.valueOf(this.m_fThreshold * 1000000.0f));
            pushString16(String.valueOf(this.m_fAttack * 1000000.0f));
            pushString16(String.valueOf(this.m_fRMS * 1000000.0f));
            pushString16(String.valueOf(this.m_fPreGain * 1000000.0f));
            pushString16(String.valueOf(this.m_fLookahead * 1000000.0f));
            pushString16(String.valueOf(this.m_fStLink * 1000000.0f));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableLimiter extends YLEBase {
        private boolean enable;

        YLEEnableLimiter(boolean z) {
            super();
            this.event = 119;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartAudioSaver extends YLEBase {
        private int fileMode;
        private String fileName;
        private int saverMode;

        YLEStartAudioSaver(String str, int i, int i2) {
            super();
            this.event = 110;
            this.fileName = str;
            this.saverMode = i;
            this.fileMode = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.fileName);
            pushInt(this.saverMode);
            pushInt(this.fileMode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStopAudioSaver extends YLEBase {
        YLEStopAudioSaver() {
            super();
            this.event = 111;
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStartAudioRecord extends YLEBase {
        private String fileName;
        private int quality;
        private int sampleRate;
        private int saverMode;

        YLEStartAudioRecord(String str, int i, int i2, int i3) {
            super();
            this.event = 148;
            this.fileName = str;
            this.saverMode = i;
            this.sampleRate = i2;
            this.quality = i3;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.fileName);
            pushInt(this.saverMode);
            pushInt(this.sampleRate);
            pushInt(this.quality);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEStopAudioRecord extends YLEBase {
        YLEStopAudioRecord() {
            super();
            this.event = 149;
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableAudioPlaySpectrum extends YLEBase {
        private boolean enable;

        YLEEnableAudioPlaySpectrum(boolean z) {
            super();
            this.event = 112;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetAudioPlaySpectrumInfo extends YLEBase {
        private int notifyIntervalMS;
        private int spectrumLen;

        YLESetAudioPlaySpectrumInfo(int i, int i2) {
            super();
            this.event = 113;
            this.spectrumLen = i;
            this.notifyIntervalMS = i2;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.spectrumLen);
            pushInt(this.notifyIntervalMS);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEEnableVoicePosition extends YLEBase {
        private boolean enable;

        YLEEnableVoicePosition(boolean z) {
            super();
            this.event = 114;
            this.enable = z;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enable));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetSoundEffect extends YLEBase {
        private int soundEffectMode;

        YLESetSoundEffect(int i) {
            super();
            this.event = 115;
            this.soundEffectMode = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.soundEffectMode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetVoiceChanger extends YLEBase {
        private int voiceChangerMode;

        YLESetVoiceChanger(int i) {
            super();
            this.event = 116;
            this.voiceChangerMode = i;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.voiceChangerMode);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLEVideoFrameObserverStringUid extends YLEBase {
        private Object observer;
        private String uid;

        YLEVideoFrameObserverStringUid(String str, Object obj) {
            super();
            this.event = 21;
            this.observer = obj;
            this.uid = str;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushString16(this.uid);
            pushInt64(ThunderNative.YYLiveObjectToPtr(this.observer));
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetRecordingAudioFrameParameters extends YLEBase {
        private int mode;
        private int room;
        private int sampleRate;
        private int samplesPerCall;

        YLESetRecordingAudioFrameParameters(int i, int i2, int i3, int i4) {
            super();
            this.event = 12;
            this.sampleRate = i;
            this.room = i2;
            this.mode = i3;
            this.samplesPerCall = i4;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.sampleRate);
            pushInt(this.room);
            pushInt(this.mode);
            pushInt(this.samplesPerCall);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLESetMixedAudioFrameParameters extends YLEBase {
        private int channel;
        private int sampleRate;
        private int samplesPerCall;

        YLESetMixedAudioFrameParameters(int i, int i2, int i3) {
            super();
            this.event = 14;
            this.sampleRate = i;
            this.channel = i2;
            this.samplesPerCall = i3;
        }

        @Override // com.thunder.livesdk.helper.ThunderNative.YLEBase, com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public byte[] marshall() {
            pushInt(this.sampleRate);
            pushInt(this.channel);
            pushInt(this.samplesPerCall);
            return super.marshall();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNBase extends Marshallable {
        Object notification;

        private YLNBase() {
        }

        public Object get() {
            return this.notification;
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNFirstVideoFrameSend extends YLNBase {
        private YLNFirstVideoFrameSend() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderFirstVideoFrameSend(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNFirstAudioFrameSend extends YLNBase {
        private YLNFirstAudioFrameSend() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderFirstAudioFrameSend(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNJoinRoomSuccess extends YLNBase {
        private YLNJoinRoomSuccess() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderJoinRoomSuccess(popString16(), popString16(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNLeaveRoom extends YLNBase {
        private YLNLeaveRoom() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderLeaveRoom();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNRemoteVideoPlay extends YLNBase {
        private YLNRemoteVideoPlay() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderRemoteVideoPlay(popString16(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNBizAuthRes extends YLNBase {
        private YLNBizAuthRes() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderBizAuthStreamRes(popBool().booleanValue(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNSdkAuthRes extends YLNBase {
        private YLNSdkAuthRes() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderSdkAuthRes(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNUserBanned extends YLNBase {
        private YLNUserBanned() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderUserBanned(popBool().booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNTokenRequest extends YLNBase {
        private YLNTokenRequest() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderTokenRequest();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNTokenWillExpire extends YLNBase {
        private YLNTokenWillExpire() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderTokenWillExpire(popString16());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioCaptureVolume extends YLNBase {
        private YLNAudioCaptureVolume() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioCaptureVolume(popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioPlayVolume extends YLNBase {
        private YLNAudioPlayVolume() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            int popInt = popInt();
            HashSet hashSet = new HashSet();
            if (popInt > 0) {
                for (int i = 0; i < popInt; i++) {
                    ThunderEventHandler.AudioVolumeInfo audioVolumeInfo = new ThunderEventHandler.AudioVolumeInfo();
                    audioVolumeInfo.uid = popString16();
                    audioVolumeInfo.originalVolume = popInt();
                    audioVolumeInfo.volume = popInt();
                    audioVolumeInfo.pts = popInt();
                    hashSet.add(audioVolumeInfo);
                }
            }
            this.notification = new ThunderNotification.ThunderAudioPlayVolume(popInt(), hashSet);
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioPlayData extends YLNBase {
        private YLNAudioPlayData() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioPlayData(popString16(), popInt(), popInt(), popInt(), popInt(), popBytes32());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioPlaySpectrumData extends YLNBase {
        private YLNAudioPlaySpectrumData() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioPlaySpectrumData(popBytes32());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioCapturePcmData extends YLNBase {
        private YLNAudioCapturePcmData() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioCapturePcmData(popBytes32(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNUserAppMsgData extends YLNBase {
        private YLNUserAppMsgData() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderUserAppMsgData(popInt(), popString16UTF8(), popString16());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAppMsgDataFailStatus extends YLNBase {
        private YLNAppMsgDataFailStatus() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAppMsgDataFailStatus(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioRenderPcmData extends YLNBase {
        private YLNAudioRenderPcmData() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioRenderPcmData(popInt(), popBytes32(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNHttpsRequest extends YLNBase {
        private YLNHttpsRequest() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderHttpsRequest(popString16(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNRemoteVideoStopped extends YLNBase {
        private YLNRemoteVideoStopped() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderRemoteVideoStopped(popString16(), popString16(), popBool().booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNRemoteAudioStopped extends YLNBase {
        private YLNRemoteAudioStopped() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderRemoteAudioStopped(popString16(), popString16(), popBool().booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNVideoSizeChange extends YLNBase {
        private YLNVideoSizeChange() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderVideoSizeChange(popString16(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNVideoCaptureExposureChanged extends YLNBase {
        private YLNVideoCaptureExposureChanged() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderVideoCaptureExposureChanged(popInt(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNVideoCaptureFocusChanged extends YLNBase {
        private YLNVideoCaptureFocusChanged() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderVideoCaptureFocusChanged(popInt(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNConnectionStatus extends YLNBase {
        private YLNConnectionStatus() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderConnectionStatus(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNConnectionLost extends YLNBase {
        private YLNConnectionLost() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderConnectionLost();
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNRoomStats extends YLNBase {
        private YLNRoomStats() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.RoomStats(popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNNetworkStateChange extends YLNBase {
        private YLNNetworkStateChange() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderNetworkStateChange(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNPublishStreamToCdnStatus extends YLNBase {
        private YLNPublishStreamToCdnStatus() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderPublishStreamToCdnStatus(popString16(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNUserJoined extends YLNBase {
        private YLNUserJoined() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderUserJoined(popString16(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNUserOffline extends YLNBase {
        private YLNUserOffline() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderUserOffline(popString16(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNNetworkQuality extends YLNBase {
        private YLNNetworkQuality() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderNetworkQuality(popString16(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioExtraInfo extends YLNBase {
        private YLNAudioExtraInfo() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioExtraInfo(popString16(), popBytes());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioExtraFailStatus extends YLNBase {
        private YLNAudioExtraFailStatus() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioExtraFailStatus(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNVideoExtraInfo extends YLNBase {
        private YLNVideoExtraInfo() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderVideoExtraInfo(popString16(), popBytes());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNMixVideoExtraInfo extends YLNBase {
        private YLNMixVideoExtraInfo() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            String popString16 = popString16();
            ArrayList arrayList = new ArrayList();
            int popInt = popInt();
            if (popInt > 0) {
                for (int i = 0; i < popInt; i++) {
                    ThunderEventHandler.MixVideoInfo mixVideoInfo = new ThunderEventHandler.MixVideoInfo();
                    mixVideoInfo.uid = popString16();
                    mixVideoInfo.width = popInt();
                    mixVideoInfo.height = popInt();
                    mixVideoInfo.cropX = popInt();
                    mixVideoInfo.cropY = popInt();
                    mixVideoInfo.cropW = popInt();
                    mixVideoInfo.cropH = popInt();
                    mixVideoInfo.layoutX = popInt();
                    mixVideoInfo.layoutY = popInt();
                    mixVideoInfo.layoutW = popInt();
                    mixVideoInfo.layoutH = popInt();
                    mixVideoInfo.zOrder = popInt();
                    mixVideoInfo.alpha = popInt() / 10.0f;
                    arrayList.add(mixVideoInfo);
                }
            }
            this.notification = new ThunderNotification.ThunderMixVideoExtraInfo(popString16, arrayList);
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNMixAudioExtraInfo extends YLNBase {
        private YLNMixAudioExtraInfo() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            String popString16 = popString16();
            ArrayList arrayList = new ArrayList();
            int popInt = popInt();
            if (popInt > 0) {
                for (int i = 0; i < popInt; i++) {
                    ThunderEventHandler.MixAudioInfo mixAudioInfo = new ThunderEventHandler.MixAudioInfo();
                    mixAudioInfo.uid = popString16();
                    mixAudioInfo.volume = popInt();
                    arrayList.add(mixAudioInfo);
                }
            }
            this.notification = new ThunderNotification.ThunderMixAudioExtraInfo(popString16, arrayList);
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioCaptureStatus extends YLNBase {
        private YLNAudioCaptureStatus() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioCaptureStatus(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNVideoCaptureStatus extends YLNBase {
        private YLNVideoCaptureStatus() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderVideoCaptureStatus(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNOnVideoConfig extends YLNBase {
        private YLNOnVideoConfig() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            HashMap<Integer, VideoLiveConfig> hashMap = new HashMap<>();
            int popInt = popInt();
            for (int i = 0; i < popInt; i++) {
                int popInt2 = popInt();
                VideoLiveConfig videoLiveConfig = new VideoLiveConfig();
                videoLiveConfig.entEncode = popInt();
                videoLiveConfig.bframeswitch = popInt();
                videoLiveConfig.intervalSecs = popInt();
                int popInt3 = popInt();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < popInt3; i2++) {
                    videoLiveConfig.getClass();
                    VideoLiveConfig.ResolutionInfo resolutionInfo = new VideoLiveConfig.ResolutionInfo();
                    resolutionInfo.key = popInt();
                    resolutionInfo.isDefault = popInt();
                    resolutionInfo.width = popInt();
                    resolutionInfo.height = popInt();
                    resolutionInfo.frameRate = popInt();
                    resolutionInfo.bframeNum = popInt();
                    resolutionInfo.encode_id = popInt();
                    resolutionInfo.encode_param = popString16();
                    resolutionInfo.previewWidth = popInt();
                    resolutionInfo.previewHeight = popInt();
                    resolutionInfo.previewFrameRate = popInt();
                    resolutionInfo.codeRate = popInt();
                    resolutionInfo.maxrate = popInt();
                    resolutionInfo.minrate = popInt();
                    resolutionInfo.currate = popInt();
                    resolutionInfo.description = popString16();
                    resolutionInfo.transcoding = popInt();
                    int popInt4 = popInt();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < popInt4; i3++) {
                        videoLiveConfig.getClass();
                        VideoLiveConfig.ModifyInfo modifyInfo = new VideoLiveConfig.ModifyInfo();
                        modifyInfo.width = popInt();
                        modifyInfo.height = popInt();
                        modifyInfo.maxCodeRate = popInt();
                        modifyInfo.minCodeRate = popInt();
                        modifyInfo.encode_id = popInt();
                        modifyInfo.encode_param = popString16();
                        modifyInfo.maxFrameRate = popInt();
                        modifyInfo.minFrameRate = popInt();
                        arrayList2.add(modifyInfo);
                    }
                    resolutionInfo.modifyConfig = arrayList2;
                    arrayList.add(resolutionInfo);
                }
                videoLiveConfig.resolutions = arrayList;
                hashMap.put(Integer.valueOf(popInt2), videoLiveConfig);
            }
            VideoConfigManager.instance().notifyVideoConfig(hashMap);
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNOnBlackCodecConfig extends YLNBase {
        private YLNOnBlackCodecConfig() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            VideoConfigManager.instance().notifyBlackCodecConfig(popString16());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNLocalVideoStats extends YLNBase {
        private YLNLocalVideoStats() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderLocalVideoStats(popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNLocalAudioStats extends YLNBase {
        private YLNLocalAudioStats() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderLocalAudioStats(popInt(), popInt(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNRemoteVideoStats extends YLNBase {
        private YLNRemoteVideoStats() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.RemoteVideoStats(popString16(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNRemoteAudioStats extends YLNBase {
        private YLNRemoteAudioStats() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.RemoteAudioStats(popString16(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNRemoteAudioStateChanged extends YLNBase {
        private YLNRemoteAudioStateChanged() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderRemoteAudioStateChanged(popString16(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNRemoteVideoStateChanged extends YLNBase {
        private YLNRemoteVideoStateChanged() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderRemoteVideoStateChanged(popString16(), popInt(), popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNPrivateCallBack extends YLNBase {
        private YLNPrivateCallBack() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderPrivateCallBack(popInt(), popString16());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNRemoteAudioPlay extends YLNBase {
        private YLNRemoteAudioPlay() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderRemoteAudioPlay(popString16(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNLocalAudioStatusChanged extends YLNBase {
        private YLNLocalAudioStatusChanged() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.LocalAudioStatusChanged(popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNLocalVideoStatusChanged extends YLNBase {
        private YLNLocalVideoStatusChanged() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.LocalVideoStatusChanged(popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNDeviceStats extends YLNBase {
        private YLNDeviceStats() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            int popInt = popInt();
            int popInt2 = popInt();
            int popInt3 = popInt();
            int popInt4 = popInt();
            if (CpuTool.OS_VERSION.compareTo("8.0") >= 0) {
                this.notification = new ThunderNotification.ThunderDeviceStats(popInt / 100.0d, CpuTool.getAppCpuRateAverage(), popInt3 / 100.0d, popInt4 / 100.0d);
            } else {
                this.notification = new ThunderNotification.ThunderDeviceStats(popInt / 100.0d, popInt2 / 100.0d, popInt3 / 100.0d, popInt4 / 100.0d);
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNUserRoleChanged extends YLNBase {
        private YLNUserRoleChanged() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderUserRoleChanged(popInt(), popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioRouteChanged extends YLNBase {
        private YLNAudioRouteChanged() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioRouteChanged(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNHowlingDetectResult extends YLNBase {
        private YLNHowlingDetectResult() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderHowlingDetectResult(popBool().booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNEchoDetectResult extends YLNBase {
        private YLNEchoDetectResult() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderEchoDetectResult(popBool().booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioInputDeviceTestVolume extends YLNBase {
        private YLNAudioInputDeviceTestVolume() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioInputDeviceTestVolume(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioOutputDeviceTestVolume extends YLNBase {
        private YLNAudioOutputDeviceTestVolume() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioOutputDeviceTestVolume(popInt());
        }
    }

    /* loaded from: classes4.dex */
    private static class YLNAudioRecordState extends YLNBase {
        private YLNAudioRecordState() {
            super();
        }

        @Override // com.thunder.livesdk.helper.Marshallable, com.thunder.livesdk.helper.IPtotoPacket
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.notification = new ThunderNotification.ThunderAudioRecordState(popInt(), popInt());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5033=4] */
    public static void notificationCallback(int i, byte[] bArr) {
        YLNBase yLNAudioRecordState;
        Object[] collectNotificationHandlers;
        s_notificationLock.lock();
        try {
            if (s_notificationDispatcher == null) {
                return;
            }
            switch (i) {
                case 0:
                    yLNAudioRecordState = new YLNFirstVideoFrameSend();
                    break;
                case 1:
                    yLNAudioRecordState = new YLNFirstAudioFrameSend();
                    break;
                case 2:
                    yLNAudioRecordState = new YLNJoinRoomSuccess();
                    break;
                case 3:
                    yLNAudioRecordState = new YLNLeaveRoom();
                    break;
                case 4:
                    yLNAudioRecordState = new YLNRemoteVideoPlay();
                    break;
                case 5:
                    yLNAudioRecordState = new YLNBizAuthRes();
                    break;
                case 6:
                    yLNAudioRecordState = new YLNSdkAuthRes();
                    break;
                case 7:
                    yLNAudioRecordState = new YLNUserBanned();
                    break;
                case 8:
                    yLNAudioRecordState = new YLNTokenRequest();
                    break;
                case 9:
                    yLNAudioRecordState = new YLNTokenWillExpire();
                    break;
                case 10:
                    yLNAudioRecordState = new YLNAudioCaptureVolume();
                    break;
                case 11:
                    yLNAudioRecordState = new YLNAudioPlayVolume();
                    break;
                case 12:
                    yLNAudioRecordState = new YLNAudioPlayData();
                    break;
                case 13:
                    yLNAudioRecordState = new YLNAudioPlaySpectrumData();
                    break;
                case 14:
                    yLNAudioRecordState = new YLNAudioCapturePcmData();
                    break;
                case 15:
                    yLNAudioRecordState = new YLNUserAppMsgData();
                    break;
                case 16:
                    yLNAudioRecordState = new YLNAppMsgDataFailStatus();
                    break;
                case 17:
                    yLNAudioRecordState = new YLNAudioRenderPcmData();
                    break;
                case 18:
                    yLNAudioRecordState = new YLNHttpsRequest();
                    break;
                case 19:
                    yLNAudioRecordState = new YLNRemoteVideoStopped();
                    break;
                case 20:
                    yLNAudioRecordState = new YLNRemoteAudioStopped();
                    break;
                case 21:
                    yLNAudioRecordState = new YLNVideoSizeChange();
                    break;
                case 22:
                    yLNAudioRecordState = new YLNConnectionStatus();
                    break;
                case 23:
                    yLNAudioRecordState = new YLNConnectionLost();
                    break;
                case 24:
                    yLNAudioRecordState = new YLNRoomStats();
                    break;
                case 25:
                    yLNAudioRecordState = new YLNNetworkStateChange();
                    break;
                case 26:
                    yLNAudioRecordState = new YLNPublishStreamToCdnStatus();
                    break;
                case 27:
                    yLNAudioRecordState = new YLNUserJoined();
                    break;
                case 28:
                    yLNAudioRecordState = new YLNUserOffline();
                    break;
                case 29:
                    yLNAudioRecordState = new YLNNetworkQuality();
                    break;
                case 30:
                    yLNAudioRecordState = new YLNAudioExtraInfo();
                    break;
                case 31:
                    yLNAudioRecordState = new YLNAudioExtraFailStatus();
                    break;
                case 32:
                    yLNAudioRecordState = new YLNVideoExtraInfo();
                    break;
                case 33:
                    yLNAudioRecordState = new YLNMixVideoExtraInfo();
                    break;
                case 34:
                    yLNAudioRecordState = new YLNMixAudioExtraInfo();
                    break;
                case 35:
                    yLNAudioRecordState = new YLNAudioCaptureStatus();
                    break;
                case 36:
                    yLNAudioRecordState = new YLNVideoCaptureStatus();
                    break;
                case 37:
                    yLNAudioRecordState = new YLNLocalVideoStats();
                    break;
                case 38:
                    yLNAudioRecordState = new YLNRemoteVideoStats();
                    break;
                case 39:
                    yLNAudioRecordState = new YLNLocalAudioStats();
                    break;
                case 40:
                    yLNAudioRecordState = new YLNRemoteAudioStats();
                    break;
                case 41:
                    yLNAudioRecordState = new YLNRemoteAudioStateChanged();
                    break;
                case 42:
                    yLNAudioRecordState = new YLNRemoteAudioPlay();
                    break;
                case 43:
                    yLNAudioRecordState = new YLNRemoteVideoStateChanged();
                    break;
                case 44:
                    yLNAudioRecordState = new YLNLocalAudioStatusChanged();
                    break;
                case 45:
                    yLNAudioRecordState = new YLNDeviceStats();
                    break;
                case 46:
                    yLNAudioRecordState = new YLNLocalVideoStatusChanged();
                    break;
                case 47:
                    yLNAudioRecordState = new YLNAudioRouteChanged();
                    break;
                case 48:
                    yLNAudioRecordState = new YLNHowlingDetectResult();
                    break;
                case 49:
                    yLNAudioRecordState = new YLNEchoDetectResult();
                    break;
                case 50:
                    yLNAudioRecordState = new YLNAudioInputDeviceTestVolume();
                    break;
                case 51:
                    yLNAudioRecordState = new YLNAudioOutputDeviceTestVolume();
                    break;
                case 52:
                    yLNAudioRecordState = new YLNVideoCaptureFocusChanged();
                    break;
                case 53:
                    yLNAudioRecordState = new YLNVideoCaptureExposureChanged();
                    break;
                case 54:
                    yLNAudioRecordState = new YLNPrivateCallBack();
                    break;
                case 55:
                    yLNAudioRecordState = new YLNAudioRecordState();
                    break;
                case 56:
                    yLNAudioRecordState = new YLNUserRoleChanged();
                    break;
                case 1000:
                    yLNAudioRecordState = new YLNOnVideoConfig();
                    break;
                case 1001:
                    yLNAudioRecordState = new YLNOnBlackCodecConfig();
                    break;
                default:
                    ThunderLog.warn(ThunderLog.kLogTagCallback, "unknown notification type %d", Integer.valueOf(i));
                    return;
            }
            yLNAudioRecordState.unmarshall(bArr);
            if (i < 1000 && (collectNotificationHandlers = s_notificationDispatcher.collectNotificationHandlers()) != null) {
                for (Object obj : collectNotificationHandlers) {
                    Message obtain = Message.obtain();
                    obtain.what = i;
                    obtain.obj = yLNAudioRecordState.get();
                    ((Handler) obj).sendMessage(obtain);
                }
            }
            switch (i) {
                case 0:
                    ThunderLog.release(ThunderLog.kLogTagCallback, "kThunderNotification_FirstVideoFrameSend mElapsedTime= %d", Integer.valueOf(((ThunderNotification.ThunderFirstVideoFrameSend) yLNAudioRecordState.get()).getElapsedTime()));
                    break;
                case 38:
                    ThunderNotification.RemoteVideoStats remoteVideoStats = (ThunderNotification.RemoteVideoStats) yLNAudioRecordState.get();
                    int i2 = s_remoteVideoStatsNotificationCount;
                    s_remoteVideoStatsNotificationCount = i2 + 1;
                    if (i2 % 10 == 0 && ThunderLog.isInfoValid()) {
                        ThunderLog.info(ThunderLog.kLogTagCallback, "kThunderAPINotification_RemoteVideoStats: uid %s delay %d width %d height %d receivedBitrate %d decoderFrameRate %d renderFrameRate %d packetLossRate %d rxStreamType %d frozenTime %d frozenRate %dcodecType %d decodedType %d", remoteVideoStats.getUid(), Integer.valueOf(remoteVideoStats.getDelay()), Integer.valueOf(remoteVideoStats.getWidth()), Integer.valueOf(remoteVideoStats.getHeight()), Integer.valueOf(remoteVideoStats.getReceivedBitrate()), Integer.valueOf(remoteVideoStats.getDecoderFrameRate()), Integer.valueOf(remoteVideoStats.getRenderFrameRate()), Integer.valueOf(remoteVideoStats.getPacketLossRate()), Integer.valueOf(remoteVideoStats.getRxStreamType()), Integer.valueOf(remoteVideoStats.getFrozenTime()), Integer.valueOf(remoteVideoStats.getFrozenRate()), Integer.valueOf(remoteVideoStats.getCodecType()), Integer.valueOf(remoteVideoStats.getDecodedType()));
                        break;
                    }
                    break;
                case 40:
                    ThunderNotification.RemoteAudioStats remoteAudioStats = (ThunderNotification.RemoteAudioStats) yLNAudioRecordState.get();
                    int i3 = s_remoteAudioStatsNotificationCount;
                    s_remoteAudioStatsNotificationCount = i3 + 1;
                    if (i3 % 10 == 0 && ThunderLog.isInfoValid()) {
                        ThunderLog.info(ThunderLog.kLogTagCallback, "kThunderAPINotification_RemoteAudioStats: uid %s quality %d networkTransportDelay %d jitterBufferDelay %d totalDelay %d frameLossRate %d numChannels %d receivedSampleRate %d receivedBitrate %d frozenTime %d frozenRate %d", remoteAudioStats.getUid(), Integer.valueOf(remoteAudioStats.getQuality()), Integer.valueOf(remoteAudioStats.getNetworkTransportDelay()), Integer.valueOf(remoteAudioStats.getJitterBufferDelay()), Integer.valueOf(remoteAudioStats.getTotalDelay()), Integer.valueOf(remoteAudioStats.getFrameLossRate()), Integer.valueOf(remoteAudioStats.getNumChannels()), Integer.valueOf(remoteAudioStats.getReceivedSampleRate()), Integer.valueOf(remoteAudioStats.getReceivedBitrate()), Integer.valueOf(remoteAudioStats.getFrozenTime()), Integer.valueOf(remoteAudioStats.getFrozenRate()));
                        break;
                    }
                    break;
            }
        } finally {
            s_notificationLock.unlock();
        }
    }

    public static void logCallback(int i, byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null && s_logCallback != null) {
            s_logCallback.onThunderLogWithLevel(i, new String(bArr), new String(bArr2));
        }
    }

    public static void audioFilePlayCallback(Object obj, int i, int i2) {
        if (obj instanceof ThunderAudioFilePlayer) {
            ((ThunderAudioFilePlayer) obj).onPlayEvent(i, i2);
        }
    }

    public static void audioFilePlayVolumeCallback(Object obj, int i, int i2, int i3) {
        if (obj instanceof ThunderAudioFilePlayer) {
            ((ThunderAudioFilePlayer) obj).onAudioFileVolume(i, i2, i3);
        }
    }
}
