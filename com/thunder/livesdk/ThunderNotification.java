package com.thunder.livesdk;

import com.thunder.livesdk.ThunderEventHandler;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class ThunderNotification {
    public static final int kThunderAPINotification_AudioRouteChanged = 47;
    public static final int kThunderAPINotification_DeviceStats = 45;
    public static final int kThunderAPINotification_EchoDetectResult = 49;
    public static final int kThunderAPINotification_HowlingDetectResult = 48;
    public static final int kThunderAPINotification_LocalAudioStats = 39;
    public static final int kThunderAPINotification_LocalAudioStatusChanged = 44;
    public static final int kThunderAPINotification_LocalVideoStats = 37;
    public static final int kThunderAPINotification_LocalVideoStatusChanged = 46;
    public static final int kThunderAPINotification_RemoteAudioStats = 40;
    public static final int kThunderAPINotification_RemoteVideoStats = 38;
    public static final int kThunderNotification_AppMsgDataFailStatus = 16;
    public static final int kThunderNotification_AudioCapturePcmData = 14;
    public static final int kThunderNotification_AudioCaptureStatus = 35;
    public static final int kThunderNotification_AudioCaptureVolume = 10;
    public static final int kThunderNotification_AudioExtraFailStatus = 31;
    public static final int kThunderNotification_AudioExtraInfo = 30;
    public static final int kThunderNotification_AudioInputDeviceTestVolume = 50;
    public static final int kThunderNotification_AudioOutputDeviceTestVolume = 51;
    public static final int kThunderNotification_AudioPlayData = 12;
    public static final int kThunderNotification_AudioPlaySpectrumData = 13;
    public static final int kThunderNotification_AudioPlayVolume = 11;
    public static final int kThunderNotification_AudioRecordState = 55;
    public static final int kThunderNotification_AudioRenderPcmData = 17;
    public static final int kThunderNotification_BizAuthRes = 5;
    public static final int kThunderNotification_CameraExposureChanged = 53;
    public static final int kThunderNotification_CameraFocuseChanged = 52;
    public static final int kThunderNotification_ConnectionLost = 23;
    public static final int kThunderNotification_ConnectionStatus = 22;
    public static final int kThunderNotification_FirstAudioFrameSend = 1;
    public static final int kThunderNotification_FirstVideoFrameSend = 0;
    public static final int kThunderNotification_HttpsRequest = 18;
    public static final int kThunderNotification_JoinRoomSuccess = 2;
    public static final int kThunderNotification_LeaveRoom = 3;
    public static final int kThunderNotification_MixAudioExtraInfo = 34;
    public static final int kThunderNotification_MixVideoExtraInfo = 33;
    public static final int kThunderNotification_NetworkQuality = 29;
    public static final int kThunderNotification_NetworkStateChange = 25;
    public static final int kThunderNotification_OnBlackCodecConfig = 1001;
    public static final int kThunderNotification_OnVideoConfig = 1000;
    public static final int kThunderNotification_PrivateCallBack = 54;
    public static final int kThunderNotification_PublishStreamToCdnStatus = 26;
    public static final int kThunderNotification_RemoteAudioPlay = 42;
    public static final int kThunderNotification_RemoteAudioStateChanged = 41;
    public static final int kThunderNotification_RemoteAudioStopped = 20;
    public static final int kThunderNotification_RemoteVideoPlay = 4;
    public static final int kThunderNotification_RemoteVideoStateChanged = 43;
    public static final int kThunderNotification_RemoteVideoStopped = 19;
    public static final int kThunderNotification_RoomStats = 24;
    public static final int kThunderNotification_SdkAuthRes = 6;
    public static final int kThunderNotification_TokenRequest = 8;
    public static final int kThunderNotification_TokenWillExpire = 9;
    public static final int kThunderNotification_UserAppMsgData = 15;
    public static final int kThunderNotification_UserBanned = 7;
    public static final int kThunderNotification_UserJoined = 27;
    public static final int kThunderNotification_UserOffline = 28;
    public static final int kThunderNotification_UserRoleChanged = 56;
    public static final int kThunderNotification_VideoCaptureStatus = 36;
    public static final int kThunderNotification_VideoExtraInfo = 32;
    public static final int kThunderNotification_VideoSizeChange = 21;

    /* loaded from: classes6.dex */
    public static class ThunderConnectionLost {
    }

    /* loaded from: classes6.dex */
    public static class ThunderLeaveRoom {
    }

    /* loaded from: classes6.dex */
    public static class ThunderTokenRequest {
    }

    /* loaded from: classes6.dex */
    public static class ThunderFirstVideoFrameSend {
        private int mElapsedTime;

        public ThunderFirstVideoFrameSend(int i) {
            this.mElapsedTime = i;
        }

        public int getElapsedTime() {
            return this.mElapsedTime;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderFirstAudioFrameSend {
        private int mElapsedTime;

        public ThunderFirstAudioFrameSend(int i) {
            this.mElapsedTime = i;
        }

        public int getElapsedTime() {
            return this.mElapsedTime;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderJoinRoomSuccess {
        private int mElapsedTime;
        private String mRoomName;
        private String mUid;

        public ThunderJoinRoomSuccess(String str, String str2, int i) {
            this.mRoomName = str;
            this.mUid = str2;
            this.mElapsedTime = i;
        }

        public String getmRoomName() {
            return this.mRoomName;
        }

        public String getmUid() {
            return this.mUid;
        }

        public int getmElapsedTime() {
            return this.mElapsedTime;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderRemoteVideoPlay {
        private int mElapsedTime;
        private int mHeigh;
        private String mUid;
        private int mWith;

        public ThunderRemoteVideoPlay(String str, int i, int i2, int i3) {
            this.mUid = str;
            this.mWith = i;
            this.mHeigh = i2;
            this.mElapsedTime = i3;
        }

        public String getmUid() {
            return this.mUid;
        }

        public int getmWith() {
            return this.mWith;
        }

        public int getmHeigh() {
            return this.mHeigh;
        }

        public int getmElapsedTime() {
            return this.mElapsedTime;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderBizAuthRes {
        private boolean bPublish;
        private int mResult;

        public ThunderBizAuthRes(boolean z, int i) {
            this.bPublish = z;
            this.mResult = i;
        }

        public boolean isbPublish() {
            return this.bPublish;
        }

        public int getmResult() {
            return this.mResult;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderBizAuthStreamRes {
        private boolean bPublish;
        private int mResult;
        private int mStreamType;

        public ThunderBizAuthStreamRes(boolean z, int i, int i2) {
            this.bPublish = z;
            this.mResult = i;
            this.mStreamType = i2;
        }

        public boolean isbPublish() {
            return this.bPublish;
        }

        public int getmStreamType() {
            return this.mStreamType;
        }

        public int getmResult() {
            return this.mResult;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderSdkAuthRes {
        public static final int THUNDER_SDK_AUTHRES_ERR_APPID = 10003;
        public static final int THUNDER_SDK_AUTHRES_ERR_NO_APP = 10006;
        public static final int THUNDER_SDK_AUTHRES_ERR_NO_TOKEN = 10001;
        public static final int THUNDER_SDK_AUTHRES_ERR_SERVER_INTERNAL = 10000;
        public static final int THUNDER_SDK_AUTHRES_ERR_TOKEN_ERR = 10002;
        public static final int THUNDER_SDK_AUTHRES_ERR_TOKEN_EXPIRE = 10005;
        public static final int THUNDER_SDK_AUTHRES_ERR_UID = 10004;
        public static final int THUNDER_SDK_AUTHRES_SUCCUSS = 0;
        private int mResult;

        public ThunderSdkAuthRes(int i) {
            this.mResult = i;
        }

        public int getmResult() {
            return this.mResult;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderUserBanned {
        private boolean bBanned;

        public ThunderUserBanned(boolean z) {
            this.bBanned = z;
        }

        public boolean isbBanned() {
            return this.bBanned;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderTokenWillExpire {
        private String token;

        public ThunderTokenWillExpire(String str) {
            this.token = str;
        }

        public String getToken() {
            return this.token;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioCaptureVolume {
        private int mCpt;
        private int mMicVolume;
        private int mVolume;

        public ThunderAudioCaptureVolume(int i, int i2, int i3) {
            this.mVolume = i;
            this.mCpt = i2;
            this.mMicVolume = i3;
        }

        public int getmVolume() {
            return this.mVolume;
        }

        public int getmCpt() {
            return this.mCpt;
        }

        public int getmMicVolume() {
            return this.mMicVolume;
        }
    }

    /* loaded from: classes6.dex */
    public static class AudioPlayVolume {
        private long pts;
        private String uid;
        private int volume;

        public AudioPlayVolume(String str, int i, long j) {
            this.uid = str;
            this.volume = i;
            this.pts = j;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioPlayVolume {
        private int totalVolume;
        private HashSet<ThunderEventHandler.AudioVolumeInfo> volumes;

        public ThunderAudioPlayVolume(int i, HashSet<ThunderEventHandler.AudioVolumeInfo> hashSet) {
            this.volumes = new HashSet<>();
            this.totalVolume = i;
            this.volumes = hashSet;
        }

        public int getTotalVolume() {
            return this.totalVolume;
        }

        public HashSet<ThunderEventHandler.AudioVolumeInfo> getVolumes() {
            return this.volumes;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioPlayData {
        private int cpt;
        private byte[] data;
        private int duration;
        private int frameType;
        private int pts;
        private String uid;

        public ThunderAudioPlayData(String str, int i, int i2, int i3, int i4, byte[] bArr) {
            this.uid = str;
            this.duration = i;
            this.cpt = i2;
            this.pts = i3;
            this.frameType = i4;
            this.data = bArr;
        }

        public String getUid() {
            return this.uid;
        }

        public int getDuration() {
            return this.duration;
        }

        public int getCpt() {
            return this.cpt;
        }

        public int getPts() {
            return this.pts;
        }

        public int getFrameType() {
            return this.frameType;
        }

        public byte[] getData() {
            return this.data;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioPlaySpectrumData {
        private byte[] data;

        public ThunderAudioPlaySpectrumData(byte[] bArr) {
            this.data = bArr;
        }

        public byte[] getData() {
            return this.data;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioCapturePcmData {
        private int channel;
        private byte[] data;
        private int len;
        private int sampleRate;

        public ThunderAudioCapturePcmData(byte[] bArr, int i, int i2, int i3) {
            this.data = bArr;
            this.len = i;
            this.sampleRate = i2;
            this.channel = i3;
        }

        public int getLen() {
            return this.len;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }

        public int getChannel() {
            return this.channel;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderUserAppMsgData {
        private int len;
        String msgData;
        String uid;

        public ThunderUserAppMsgData(int i, String str, String str2) {
            this.len = i;
            this.msgData = str;
            this.uid = str2;
        }

        public int getLen() {
            return this.len;
        }

        public String getMsgData() {
            return this.msgData;
        }

        public String getUid() {
            return this.uid;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAppMsgDataFailStatus {
        private int status;

        public ThunderAppMsgDataFailStatus(int i) {
            this.status = i;
        }

        public int getStatus() {
            return this.status;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioRenderPcmData {
        private int channel;
        private byte[] data;
        private int duration;
        private int len;
        private int sampleRate;

        public ThunderAudioRenderPcmData(int i, byte[] bArr, int i2, int i3, int i4) {
            this.len = i;
            this.data = bArr;
            this.duration = i2;
            this.sampleRate = i3;
            this.channel = i4;
        }

        public int getLen() {
            return this.len;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getDuration() {
            return this.duration;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }

        public int getChannel() {
            return this.channel;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderHttpsRequest {
        private int target;
        private String url;

        public ThunderHttpsRequest(String str, int i) {
            this.url = str;
            this.target = i;
        }

        public String getUrl() {
            return this.url;
        }

        public int getTarget() {
            return this.target;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderRemoteVideoStopped {
        private boolean bStop;
        private String roomId;
        private String uid;

        public ThunderRemoteVideoStopped(String str, String str2, boolean z) {
            this.roomId = str;
            this.uid = str2;
            this.bStop = z;
        }

        public String getRoomId() {
            return this.roomId;
        }

        public String getUid() {
            return this.uid;
        }

        public boolean isbStop() {
            return this.bStop;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderRemoteAudioStopped {
        private boolean bStop;
        private String roomId;
        private String uid;

        public ThunderRemoteAudioStopped(String str, String str2, boolean z) {
            this.roomId = str;
            this.uid = str2;
            this.bStop = z;
        }

        public String getRoomId() {
            return this.roomId;
        }

        public String getUid() {
            return this.uid;
        }

        public boolean isbStop() {
            return this.bStop;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderVideoSizeChange {
        private int height;
        private String uid;
        private int width;

        public ThunderVideoSizeChange(String str, int i, int i2) {
            this.uid = str;
            this.width = i;
            this.height = i2;
        }

        public String getUid() {
            return this.uid;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderVideoCaptureFocusChanged {
        private int height;
        private int posX;
        private int posY;
        private int width;

        public ThunderVideoCaptureFocusChanged(int i, int i2, int i3, int i4) {
            this.posX = i;
            this.posY = i2;
            this.width = i3;
            this.height = i4;
        }

        public int getPosX() {
            return this.posX;
        }

        public int getPosY() {
            return this.posY;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderVideoCaptureExposureChanged {
        private int height;
        private int posX;
        private int posY;
        private int width;

        public ThunderVideoCaptureExposureChanged(int i, int i2, int i3, int i4) {
            this.posX = i;
            this.posY = i2;
            this.width = i3;
            this.height = i4;
        }

        public int getPosX() {
            return this.posX;
        }

        public int getPosY() {
            return this.posY;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderConnectionStatus {
        public static final int CONNETED = 1;
        public static final int CONNETING = 0;
        public static final int DISCONNECT = 2;
        private int status;

        public ThunderConnectionStatus(int i) {
            this.status = i;
        }

        public int getStatus() {
            return this.status;
        }
    }

    /* loaded from: classes6.dex */
    public static class RoomStats {
        public int lastmileDelay;
        public int localIpStack;
        public int rxAudioBitrate;
        public int rxAudioBytes;
        public int rxBitrate;
        public int rxBytes;
        public int rxPacketLossRate;
        public int rxVideoBitrate;
        public int rxVideoBytes;
        public int serverIpType;
        public int totalDuration;
        public int txAudioBitrate;
        public int txAudioBytes;
        public int txBitrate;
        public int txBytes;
        public int txPacketLossRate;
        public int txVideoBitrate;
        public int txVideoBytes;

        public RoomStats(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.totalDuration = i;
            this.txBitrate = i2;
            this.rxBitrate = i3;
            this.txBytes = i4;
            this.rxBytes = i5;
            this.txAudioBytes = i6;
            this.rxAudioBytes = i7;
            this.txVideoBytes = i8;
            this.rxVideoBytes = i9;
            this.txAudioBitrate = i10;
            this.rxAudioBitrate = i11;
            this.txVideoBitrate = i12;
            this.rxVideoBitrate = i13;
            this.lastmileDelay = i14;
            this.txPacketLossRate = i15;
            this.rxPacketLossRate = i16;
            this.serverIpType = i17;
            this.localIpStack = i18;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderNetworkStateChange {
        private int status;

        public ThunderNetworkStateChange(int i) {
            this.status = i;
        }

        public int getStatus() {
            return this.status;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderPublishStreamToCdnStatus {
        private int errorCode;
        private String url;

        public ThunderPublishStreamToCdnStatus(String str, int i) {
            this.url = str;
            this.errorCode = i;
        }

        public String getUrl() {
            return this.url;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderUserJoined {
        private int elapsedTime;
        private String uid;

        public ThunderUserJoined(String str, int i) {
            this.uid = str;
            this.elapsedTime = i;
        }

        public String getUid() {
            return this.uid;
        }

        public int getElapsedTime() {
            return this.elapsedTime;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderUserOffline {
        private int reason;
        private String uid;

        public ThunderUserOffline(String str, int i) {
            this.uid = str;
            this.reason = i;
        }

        public String getUid() {
            return this.uid;
        }

        public int getReason() {
            return this.reason;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderNetworkQuality {
        private int rxQuality;
        private int txQuality;
        private String uid;

        public ThunderNetworkQuality(String str, int i, int i2) {
            this.uid = str;
            this.txQuality = i;
            this.rxQuality = i2;
        }

        public String getUid() {
            return this.uid;
        }

        public int getTxQuality() {
            return this.txQuality;
        }

        public int getRxQuality() {
            return this.rxQuality;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioExtraInfo {
        private byte[] extraInfo;
        private String uid;

        public ThunderAudioExtraInfo(String str, byte[] bArr) {
            this.uid = str;
            this.extraInfo = bArr;
        }

        public String getUid() {
            return this.uid;
        }

        public byte[] getExtraInfo() {
            return this.extraInfo;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioExtraFailStatus {
        private int status;

        public ThunderAudioExtraFailStatus(int i) {
            this.status = i;
        }

        public int getStatus() {
            return this.status;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderVideoExtraInfo {
        private byte[] extraInfo;
        private String uid;

        public ThunderVideoExtraInfo(String str, byte[] bArr) {
            this.uid = str;
            this.extraInfo = bArr;
        }

        public String getUid() {
            return this.uid;
        }

        public byte[] getExtraInfo() {
            return this.extraInfo;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderMixVideoExtraInfo {
        private String mUid;
        private ArrayList<ThunderEventHandler.MixVideoInfo> mixVideoExtraInfos;

        public ThunderMixVideoExtraInfo(String str, ArrayList<ThunderEventHandler.MixVideoInfo> arrayList) {
            this.mixVideoExtraInfos = new ArrayList<>();
            this.mUid = str;
            this.mixVideoExtraInfos = arrayList;
        }

        public String getmUid() {
            return this.mUid;
        }

        public ArrayList<ThunderEventHandler.MixVideoInfo> getMixExtraInfos() {
            return this.mixVideoExtraInfos;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderMixAudioExtraInfo {
        private String mUid;
        private ArrayList<ThunderEventHandler.MixAudioInfo> mixAudioExtraInfos;

        public ThunderMixAudioExtraInfo(String str, ArrayList<ThunderEventHandler.MixAudioInfo> arrayList) {
            this.mixAudioExtraInfos = new ArrayList<>();
            this.mUid = str;
            this.mixAudioExtraInfos = arrayList;
        }

        public String getmUid() {
            return this.mUid;
        }

        public ArrayList<ThunderEventHandler.MixAudioInfo> getMixAudioExtraInfos() {
            return this.mixAudioExtraInfos;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioCaptureStatus {
        private int mStatus;

        public ThunderAudioCaptureStatus(int i) {
            this.mStatus = i;
        }

        public int getStatus() {
            return this.mStatus;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderVideoCaptureStatus {
        private int mStatus;

        public ThunderVideoCaptureStatus(int i) {
            this.mStatus = i;
        }

        public int getStatus() {
            return this.mStatus;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderLocalVideoStats {
        private int mCodecType;
        private int mConfigBitRate;
        private int mConfigFrameRate;
        private int mConfigHeight;
        private int mConfigWidth;
        private int mEncodedBitrate;
        private int mEncodedFrameCount;
        private int mEncodedFrameHeight;
        private int mEncodedFrameWidth;
        private int mEncodedType;
        private int mEncoderOutputFrameRate;
        private int mQualityAdaptIndication;
        private int mRenderOutputFrameRate;
        private int mSendBitRate;
        private int mSendFrameRate;
        private int mTargetBitRate;
        private int mTargetFrameRate;

        public ThunderLocalVideoStats(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.mSendBitRate = i;
            this.mSendFrameRate = i2;
            this.mRenderOutputFrameRate = i3;
            this.mTargetBitRate = i4;
            this.mTargetFrameRate = i5;
            this.mQualityAdaptIndication = i6;
            this.mEncoderOutputFrameRate = i7;
            this.mEncodedBitrate = i8;
            this.mEncodedFrameWidth = i9;
            this.mEncodedFrameHeight = i10;
            this.mEncodedFrameCount = i11;
            this.mEncodedType = i12;
            this.mCodecType = i13;
            this.mConfigBitRate = i14;
            this.mConfigFrameRate = i15;
            this.mConfigWidth = i16;
            this.mConfigHeight = i17;
        }

        public int getSendBitrate() {
            return this.mSendBitRate;
        }

        public int getSendFrameRate() {
            return this.mSendFrameRate;
        }

        public int getRenderOutputFrameRate() {
            return this.mRenderOutputFrameRate;
        }

        public int getTargetBitrate() {
            return this.mTargetBitRate;
        }

        public int getTargetFrameRate() {
            return this.mTargetFrameRate;
        }

        public int getEncodedFrameCount() {
            return this.mEncodedFrameCount;
        }

        public int getQualityAdaptIndicat() {
            return this.mQualityAdaptIndication;
        }

        public int getEncodeFrameRate() {
            return this.mEncoderOutputFrameRate;
        }

        public int getBitrate() {
            return this.mEncodedBitrate;
        }

        public int getWidth() {
            return this.mEncodedFrameWidth;
        }

        public int getHeight() {
            return this.mEncodedFrameHeight;
        }

        public int getEncodedType() {
            return this.mEncodedType;
        }

        public int getCodec() {
            return this.mCodecType;
        }

        public int getConfigBitRate() {
            return this.mConfigBitRate;
        }

        public int getConfigFrameRate() {
            return this.mConfigFrameRate;
        }

        public int getConfigHeight() {
            return this.mConfigHeight;
        }

        public int getConfigWidth() {
            return this.mConfigWidth;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderLocalAudioStats {
        private int mEnableVad;
        private int mEncodedBitrate;
        private int mNumChannels;
        private int mSendBitrate;
        private int mSendSampleRate;

        public ThunderLocalAudioStats(int i, int i2, int i3, int i4, int i5) {
            this.mEncodedBitrate = i;
            this.mNumChannels = i2;
            this.mSendSampleRate = i3;
            this.mSendBitrate = i4;
            this.mEnableVad = i5;
        }

        public int getEncodedBitrate() {
            return this.mEncodedBitrate;
        }

        public int getNumChannels() {
            return this.mNumChannels;
        }

        public int getSampleRate() {
            return this.mSendSampleRate;
        }

        public int getSendBitRate() {
            return this.mSendBitrate;
        }

        public int getEnableVad() {
            return this.mEnableVad;
        }
    }

    /* loaded from: classes6.dex */
    public static class RemoteVideoStats {
        private int mCodecType;
        private int mDecodedType;
        private int mDecoderFrameRate;
        private int mDelay;
        private int mFrozenRate;
        private int mFrozenTime;
        private int mHeight;
        private int mPacketLossRate;
        private int mReceivedBitrate;
        private int mRenderFrameRate;
        private int mRxStreamType;
        private String mUid;
        private int mWidth;

        public RemoteVideoStats(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.mUid = str;
            this.mDelay = i;
            this.mWidth = i2;
            this.mHeight = i3;
            this.mReceivedBitrate = i4;
            this.mDecoderFrameRate = i5;
            this.mRenderFrameRate = i6;
            this.mPacketLossRate = i7;
            this.mRxStreamType = i8;
            this.mFrozenTime = i9;
            this.mFrozenRate = i10;
            this.mCodecType = i11;
            this.mDecodedType = i12;
        }

        public String getUid() {
            return this.mUid;
        }

        public int getDelay() {
            return this.mDelay;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getReceivedBitrate() {
            return this.mReceivedBitrate;
        }

        public int getDecoderFrameRate() {
            return this.mDecoderFrameRate;
        }

        public int getRenderFrameRate() {
            return this.mRenderFrameRate;
        }

        public int getPacketLossRate() {
            return this.mPacketLossRate;
        }

        public int getRxStreamType() {
            return this.mRxStreamType;
        }

        public int getFrozenTime() {
            return this.mFrozenTime;
        }

        public int getFrozenRate() {
            return this.mFrozenRate;
        }

        public int getCodecType() {
            return this.mCodecType;
        }

        public int getDecodedType() {
            return this.mDecodedType;
        }
    }

    /* loaded from: classes6.dex */
    public static class RemoteAudioStats {
        private int mFrameLossRate;
        private int mFrozenRate;
        private int mFrozenTime;
        private int mJitterBufferDelay;
        private int mNetworkTransportDelay;
        private int mNumChannels;
        private int mQuality;
        private int mReceivedBitrate;
        private int mReceivedSampleRate;
        private int mTotalDelay;
        private String mUid;

        public RemoteAudioStats(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            this.mUid = str;
            this.mQuality = i;
            this.mNetworkTransportDelay = i2;
            this.mJitterBufferDelay = i3;
            this.mTotalDelay = i4;
            this.mFrameLossRate = i5;
            this.mNumChannels = i6;
            this.mReceivedSampleRate = i7;
            this.mReceivedBitrate = i8;
            this.mFrozenTime = i9;
            this.mFrozenRate = i10;
        }

        public String getUid() {
            return this.mUid;
        }

        public int getQuality() {
            return this.mQuality;
        }

        public int getNetworkTransportDelay() {
            return this.mNetworkTransportDelay;
        }

        public int getTotalDelay() {
            return this.mTotalDelay;
        }

        public int getJitterBufferDelay() {
            return this.mJitterBufferDelay;
        }

        public int getFrameLossRate() {
            return this.mFrameLossRate;
        }

        public int getNumChannels() {
            return this.mNumChannels;
        }

        public int getReceivedSampleRate() {
            return this.mReceivedSampleRate;
        }

        public int getReceivedBitrate() {
            return this.mReceivedBitrate;
        }

        public int getFrozenTime() {
            return this.mFrozenTime;
        }

        public int getFrozenRate() {
            return this.mFrozenRate;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderRemoteAudioStateChanged {
        private int elapsedTime;
        private int reason;
        private int state;
        private String uid;

        public ThunderRemoteAudioStateChanged(String str, int i, int i2, int i3) {
            this.uid = str;
            this.state = i;
            this.reason = i2;
            this.elapsedTime = i3;
        }

        public String getUid() {
            return this.uid;
        }

        public int getState() {
            return this.state;
        }

        public int getReason() {
            return this.reason;
        }

        public int getElapsedTime() {
            return this.elapsedTime;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderRemoteVideoStateChanged {
        private int mElapsedTime;
        private int mReason;
        private int mState;
        private String mUid;

        public ThunderRemoteVideoStateChanged(String str, int i, int i2, int i3) {
            this.mUid = str;
            this.mState = i;
            this.mReason = i2;
            this.mElapsedTime = i3;
        }

        public String getUid() {
            return this.mUid;
        }

        public int getState() {
            return this.mState;
        }

        public int getReason() {
            return this.mReason;
        }

        public int getElapsedTime() {
            return this.mElapsedTime;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderPrivateCallBack {
        private String mJsonStr;
        private int mKey;

        public ThunderPrivateCallBack(int i, String str) {
            this.mKey = i;
            this.mJsonStr = str;
        }

        public int getmKey() {
            return this.mKey;
        }

        public String getmJsonStr() {
            return this.mJsonStr;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderRemoteAudioPlay {
        private int elapsedTime;
        private String uid;

        public ThunderRemoteAudioPlay(String str, int i) {
            this.uid = str;
            this.elapsedTime = i;
        }

        public String getUid() {
            return this.uid;
        }

        public int getElapsedTime() {
            return this.elapsedTime;
        }
    }

    /* loaded from: classes6.dex */
    public static class LocalAudioStatusChanged {
        private int mErrorReason;
        private int mStaus;

        public LocalAudioStatusChanged(int i, int i2) {
            this.mStaus = i;
            this.mErrorReason = i2;
        }

        public int getLocalAudioStreamStatus() {
            return this.mStaus;
        }

        public int getLocalAudioStreamErrorReason() {
            return this.mErrorReason;
        }
    }

    /* loaded from: classes6.dex */
    public static class LocalVideoStatusChanged {
        private int mError;
        private int mStatus;

        public LocalVideoStatusChanged(int i, int i2) {
            this.mStatus = i;
            this.mError = i2;
        }

        public int getLocalVideoStreamStatus() {
            return this.mStatus;
        }

        public int getLocalVideoStreamError() {
            return this.mError;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderDeviceStats {
        private double cpuAppUsage;
        private double cpuTotalUsage;
        private double memoryAppUsage;
        private double memoryTotalUsage;

        public ThunderDeviceStats(double d, double d2, double d3, double d4) {
            this.cpuTotalUsage = d;
            this.cpuAppUsage = d2;
            this.memoryTotalUsage = d3;
            this.memoryAppUsage = d4;
        }

        public double getCpuTotalUsage() {
            return this.cpuTotalUsage;
        }

        public double getCpuAppUsage() {
            return this.cpuAppUsage;
        }

        public double getMemoryAppUsage() {
            return this.memoryAppUsage;
        }

        public double getMemoryTotalUsage() {
            return this.memoryTotalUsage;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioRouteChanged {
        private int routing;

        public ThunderAudioRouteChanged(int i) {
            this.routing = i;
        }

        public int getRouting() {
            return this.routing;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderUserRoleChanged {
        private int mNewRole;
        private int mOldRole;

        public ThunderUserRoleChanged(int i, int i2) {
            this.mOldRole = i;
            this.mNewRole = i2;
        }

        public int getOldRole() {
            return this.mOldRole;
        }

        public int getNewRole() {
            return this.mNewRole;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderHowlingDetectResult {
        private boolean value;

        public ThunderHowlingDetectResult(boolean z) {
            this.value = z;
        }

        public boolean getValue() {
            return this.value;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderEchoDetectResult {
        private boolean value;

        public ThunderEchoDetectResult(boolean z) {
            this.value = z;
        }

        public boolean getValue() {
            return this.value;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioInputDeviceTestVolume {
        private int volume;

        public ThunderAudioInputDeviceTestVolume(int i) {
            this.volume = i;
        }

        public int getVolume() {
            return this.volume;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioOutputDeviceTestVolume {
        private int volume;

        public ThunderAudioOutputDeviceTestVolume(int i) {
            this.volume = i;
        }

        public int getVolume() {
            return this.volume;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThunderAudioRecordState {
        private int duration;
        private int errorCode;

        public ThunderAudioRecordState(int i, int i2) {
            this.errorCode = i;
            this.duration = i2;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public int getDuration() {
            return this.duration;
        }
    }
}
