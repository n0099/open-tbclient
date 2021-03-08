package com.thunder.livesdk;

import com.thunder.livesdk.ThunderNotification;
import com.yy.mediaframework.model.Rect;
/* loaded from: classes6.dex */
public abstract class ThunderEventHandler {

    /* loaded from: classes6.dex */
    public static class AudioVolumeInfo {
        public int originalVolume;
        public int pts;
        public String uid;
        public int volume;
    }

    /* loaded from: classes6.dex */
    public static class DeviceStats {
        public double cpuAppUsage;
        public double cpuTotalUsage;
        public double memoryAppUsage;
        public double memoryTotalUsage;
    }

    /* loaded from: classes6.dex */
    public static class LocalAudioStats {
        public int enableVad;
        public int encodedBitrate;
        public int numChannels;
        public int sendBitrate;
        public int sendSampleRate;
    }

    /* loaded from: classes6.dex */
    public static class LocalAudioStatusChanged {
        public int errorReason;
        public int status;
    }

    /* loaded from: classes6.dex */
    public static class LocalVideoStats {
        public int codecType;
        public int configBitRate;
        public int configFrameRate;
        public int configHeight;
        public int configWidth;
        public int encodedBitrate;
        public int encodedFrameCount;
        public int encodedFrameHeight;
        public int encodedFrameWidth;
        public int encodedType;
        public int encoderOutputFrameRate;
        public int qualityAdaptIndication;
        public int renderOutputFrameRate;
        public int sentBitrate;
        public int sentFrameRate;
        public int targetBitRate;
        public int targetFrameRate;
    }

    /* loaded from: classes6.dex */
    public static class MixAudioInfo {
        public String uid;
        public int volume;
    }

    /* loaded from: classes6.dex */
    public static class MixVideoInfo {
        public float alpha;
        public int cropH;
        public int cropW;
        public int cropX;
        public int cropY;
        public int height;
        public int layoutH;
        public int layoutW;
        public int layoutX;
        public int layoutY;
        public String uid;
        public int width;
        public int zOrder;
    }

    /* loaded from: classes6.dex */
    public static class RemoteAudioStats {
        public int frameLossRate;
        public int frozenRate;
        public int jitterBufferDelay;
        public int networkTransportDelay;
        public int numChannels;
        public int quality;
        public int receivedBitrate;
        public int receivedSampleRate;
        public int totalDelay;
        public int totalFrozenTime;
    }

    /* loaded from: classes6.dex */
    public static class RemoteVideoStats {
        public int codecType;
        public int decodedType;
        public int decoderOutputFrameRate;
        public int delay;
        public int frozenRate;
        public int height;
        public int packetLossRate;
        public int receivedBitrate;
        public int rendererOutputFrameRate;
        public int rxStreamType;
        public int totalFrozenTime;
        public int width;
    }

    /* loaded from: classes6.dex */
    public static class RoomStats {
        public int temp;
    }

    public void onError(int i) {
    }

    public void onJoinRoomSuccess(String str, String str2, int i) {
    }

    public void onLeaveRoom(RoomStats roomStats) {
    }

    public void onBizAuthResult(boolean z, int i) {
    }

    public void onBizAuthStreamResult(boolean z, int i, int i2) {
    }

    public void onSdkAuthResult(int i) {
    }

    public void onUserBanned(boolean z) {
    }

    public void onUserJoined(String str, int i) {
    }

    public void onUserOffline(String str, int i) {
    }

    public void onTokenWillExpire(byte[] bArr) {
    }

    public void onTokenRequested() {
    }

    public void onNetworkQuality(String str, int i, int i2) {
    }

    public void onRoomStats(ThunderNotification.RoomStats roomStats) {
    }

    public void onPlayVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i) {
    }

    public void onCaptureVolumeIndication(int i, int i2, int i3) {
    }

    public void onAudioQuality(String str, int i, short s, short s2) {
    }

    public void onConnectionLost() {
    }

    public void onConnectionInterrupted() {
    }

    public void onAudioPlayData(byte[] bArr, long j, long j2, String str, long j3) {
    }

    public void onAudioPlaySpectrumData(byte[] bArr) {
    }

    public void onAudioCapturePcmData(byte[] bArr, int i, int i2, int i3) {
    }

    public void onAudioRenderPcmData(byte[] bArr, int i, long j, int i2, int i3) {
    }

    public void onRecvUserAppMsgData(byte[] bArr, String str) {
    }

    public void onSendAppMsgDataFailedStatus(int i) {
    }

    public void onRemoteAudioStopped(String str, boolean z) {
    }

    public void onRemoteVideoStopped(String str, boolean z) {
    }

    public void onRemoteAudioArrived(String str, String str2, boolean z) {
    }

    public void onRemoteVideoArrived(String str, String str2, boolean z) {
    }

    public void onRemoteVideoPlay(String str, int i, int i2, int i3) {
    }

    public void onVideoSizeChanged(String str, int i, int i2, int i3) {
    }

    public void onFirstLocalAudioFrameSent(int i) {
    }

    public void onFirstLocalVideoFrameSent(int i) {
    }

    public void onPublishStreamToCDNStatus(String str, int i) {
    }

    public void onNetworkTypeChanged(int i) {
    }

    public void onConnectionStatus(int i) {
    }

    public void onAudioCaptureStatus(int i) {
    }

    public void onVideoCaptureStatus(int i) {
    }

    public void onLocalVideoStats(LocalVideoStats localVideoStats) {
    }

    public void onLocalAudioStats(LocalAudioStats localAudioStats) {
    }

    public void onRemoteVideoStatsOfUid(String str, RemoteVideoStats remoteVideoStats) {
    }

    public void onRemoteAudioStatsOfUid(String str, RemoteAudioStats remoteAudioStats) {
    }

    public void onRemoteAudioStateChangedOfUid(String str, int i, int i2, int i3) {
    }

    public void onRemoteVideoStateChangedOfUid(String str, int i, int i2, int i3) {
    }

    public void onRemoteAudioPlay(String str, int i) {
    }

    public void onLocalAudioStatusChanged(int i, int i2) {
    }

    public void onLocalVideoStatusChanged(int i, int i2) {
    }

    public void onDeviceStats(DeviceStats deviceStats) {
    }

    public void onUserRoleChanged(int i, int i2) {
    }

    public void onAudioRouteChanged(int i) {
    }

    public void onHowlingDetectResult(boolean z) {
    }

    public void onCameraFocusAreaChanged(Rect rect) {
    }

    public void onCameraExposureAreaChanged(Rect rect) {
    }

    public void onEchoDetectResult(boolean z) {
    }

    public void onAudioInputDeviceTestVolume(int i) {
    }

    public void onAudioOutputDeviceTestVolume(int i) {
    }

    public void onParamsCallback(int i, String str) {
    }

    public void onAudioRecordState(int i, int i2) {
    }
}
