package com.thunder.livesdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.thunder.livesdk.ThunderEventHandler;
import com.thunder.livesdk.ThunderNotification;
import com.thunder.livesdk.ThunderRtcConstant;
import com.thunder.livesdk.audio.IAudioEncodedFrameObserver;
import com.thunder.livesdk.audio.IAudioFrameObserver;
import com.thunder.livesdk.helper.ThunderHttpsRequestHandler;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
import com.thunder.livesdk.system.ThunderForeBackgroundListener;
import com.thunder.livesdk.system.ThunderNetStateService;
import com.thunder.livesdk.video.IVideoCaptureObserver;
import com.thunder.livesdk.video.IVideoDecodeObserver;
import com.thunder.livesdk.video.ThunderVideoLogCallback;
import com.thunder.livesdk.video.VideoFrameTextrue;
import com.thunder.livesdk.video.VideoFrameYuvCapture;
import com.thunder.livesdk.video.VideoTextureFrameObserver;
import com.yy.mediaframework.VideoLibAPI;
import com.yy.mediaframework.gpuimage.custom.IGPUProcess;
import com.yy.mediaframework.model.Rect;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import com.yy.videoplayer.utils.YMFLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public class ThunderEngine {
    private static ThunderHttpsRequestHandler mHttpsRequestHandler;
    private static ThunderEventHandler mRtcEventHandler;
    private Set<ThunderAudioFilePlayer> mAudioFilePlayerSet;
    private ExternalVideoSource mExternalVideoSource;
    private static boolean mIsInited = false;
    private static NotificationHandler mHandler = null;
    private static ThunderNetStateService mNetStateService = null;
    private static ThunderForeBackgroundListener mForeBackgroundListener = null;
    private static ThunderNative.NotificationDispatcher mNotificationDispatcher = null;
    private static IThunderMediaExtraInfoCallback mThunderMediaExtraInfoCallback = null;
    private static int s_captureVolumeNotifyCount = 0;
    private static int s_playVolumeNotifyCount = 0;
    private static int s_playDataNotifyCount = 0;
    private static int s_audioPlaySpectrumCount = 0;
    private static ThunderPublisher mPublisher = null;

    static /* synthetic */ int access$104() {
        int i = s_captureVolumeNotifyCount + 1;
        s_captureVolumeNotifyCount = i;
        return i;
    }

    static /* synthetic */ int access$204() {
        int i = s_playVolumeNotifyCount + 1;
        s_playVolumeNotifyCount = i;
        return i;
    }

    static /* synthetic */ int access$304() {
        int i = s_playDataNotifyCount + 1;
        s_playDataNotifyCount = i;
        return i;
    }

    static /* synthetic */ int access$404() {
        int i = s_audioPlaySpectrumCount + 1;
        s_audioPlaySpectrumCount = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class NotificationHandler extends Handler {
        private final WeakReference<ThunderEngine> mThunderEngine;

        public NotificationHandler(ThunderEngine thunderEngine) {
            this.mThunderEngine = new WeakReference<>(thunderEngine);
        }

        public NotificationHandler(ThunderEngine thunderEngine, Looper looper) {
            super(looper);
            this.mThunderEngine = new WeakReference<>(thunderEngine);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.mThunderEngine.get() != null && ThunderEngine.mRtcEventHandler != null) {
                try {
                    switch (message.what) {
                        case 0:
                            ThunderNotification.ThunderFirstVideoFrameSend thunderFirstVideoFrameSend = (ThunderNotification.ThunderFirstVideoFrameSend) message.obj;
                            ThunderEngine.mRtcEventHandler.onFirstLocalVideoFrameSent(thunderFirstVideoFrameSend.getElapsedTime());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderFirstVideoFrameSend elapsedTime %d", Integer.valueOf(thunderFirstVideoFrameSend.getElapsedTime()));
                            return;
                        case 1:
                            ThunderNotification.ThunderFirstAudioFrameSend thunderFirstAudioFrameSend = (ThunderNotification.ThunderFirstAudioFrameSend) message.obj;
                            ThunderEngine.mRtcEventHandler.onFirstLocalAudioFrameSent(thunderFirstAudioFrameSend.getElapsedTime());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderFirstAudioFrameSend elapsedTime %d", Integer.valueOf(thunderFirstAudioFrameSend.getElapsedTime()));
                            return;
                        case 2:
                            ThunderNotification.ThunderJoinRoomSuccess thunderJoinRoomSuccess = (ThunderNotification.ThunderJoinRoomSuccess) message.obj;
                            ThunderEngine.mRtcEventHandler.onJoinRoomSuccess(thunderJoinRoomSuccess.getmRoomName(), thunderJoinRoomSuccess.getmUid(), thunderJoinRoomSuccess.getmElapsedTime());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderJoinRoomSucces room %s, uid %s, elapsedTime %d", thunderJoinRoomSuccess.getmRoomName(), thunderJoinRoomSuccess.getmUid(), Integer.valueOf(thunderJoinRoomSuccess.getmElapsedTime()));
                            return;
                        case 3:
                            ThunderNotification.ThunderLeaveRoom thunderLeaveRoom = (ThunderNotification.ThunderLeaveRoom) message.obj;
                            ThunderEventHandler.RoomStats roomStats = new ThunderEventHandler.RoomStats();
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_LeaveRoom");
                            ThunderEngine.mRtcEventHandler.onLeaveRoom(roomStats);
                            return;
                        case 4:
                            ThunderNotification.ThunderRemoteVideoPlay thunderRemoteVideoPlay = (ThunderNotification.ThunderRemoteVideoPlay) message.obj;
                            ThunderEngine.mRtcEventHandler.onRemoteVideoPlay(thunderRemoteVideoPlay.getmUid(), thunderRemoteVideoPlay.getmWith(), thunderRemoteVideoPlay.getmHeigh(), thunderRemoteVideoPlay.getmElapsedTime());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_RemoteVideoPlay uid %s, with %d, heigh %d, elapsedTime %d", thunderRemoteVideoPlay.getmUid(), Integer.valueOf(thunderRemoteVideoPlay.getmWith()), Integer.valueOf(thunderRemoteVideoPlay.getmHeigh()), Integer.valueOf(thunderRemoteVideoPlay.getmElapsedTime()));
                            return;
                        case 5:
                            ThunderNotification.ThunderBizAuthStreamRes thunderBizAuthStreamRes = (ThunderNotification.ThunderBizAuthStreamRes) message.obj;
                            ThunderEngine.mRtcEventHandler.onBizAuthResult(thunderBizAuthStreamRes.isbPublish(), thunderBizAuthStreamRes.getmResult());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderBizAuthRes bPublish %b, result %d", Boolean.valueOf(thunderBizAuthStreamRes.isbPublish()), Integer.valueOf(thunderBizAuthStreamRes.getmResult()));
                            ThunderEngine.mRtcEventHandler.onBizAuthStreamResult(thunderBizAuthStreamRes.isbPublish(), thunderBizAuthStreamRes.getmStreamType(), thunderBizAuthStreamRes.getmResult());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderBizAuthStreamRes bPublish %b, type %d, result %d", Boolean.valueOf(thunderBizAuthStreamRes.isbPublish()), Integer.valueOf(thunderBizAuthStreamRes.getmStreamType()), Integer.valueOf(thunderBizAuthStreamRes.getmResult()));
                            return;
                        case 6:
                            ThunderNotification.ThunderSdkAuthRes thunderSdkAuthRes = (ThunderNotification.ThunderSdkAuthRes) message.obj;
                            ThunderEngine.mRtcEventHandler.onSdkAuthResult(thunderSdkAuthRes.getmResult());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderSdkAuthRes result %d", Integer.valueOf(thunderSdkAuthRes.getmResult()));
                            return;
                        case 7:
                            ThunderNotification.ThunderUserBanned thunderUserBanned = (ThunderNotification.ThunderUserBanned) message.obj;
                            ThunderEngine.mRtcEventHandler.onUserBanned(thunderUserBanned.isbBanned());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderUserBanned bBanned %b", Boolean.valueOf(thunderUserBanned.isbBanned()));
                            return;
                        case 8:
                            ThunderNotification.ThunderTokenRequest thunderTokenRequest = (ThunderNotification.ThunderTokenRequest) message.obj;
                            ThunderEngine.mRtcEventHandler.onTokenRequested();
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderTokenRequest");
                            return;
                        case 9:
                            ThunderNotification.ThunderTokenWillExpire thunderTokenWillExpire = (ThunderNotification.ThunderTokenWillExpire) message.obj;
                            ThunderEngine.mRtcEventHandler.onTokenWillExpire(thunderTokenWillExpire.getToken().getBytes());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderTokenWillExpire %s", thunderTokenWillExpire.getToken());
                            return;
                        case 10:
                            ThunderNotification.ThunderAudioCaptureVolume thunderAudioCaptureVolume = (ThunderNotification.ThunderAudioCaptureVolume) message.obj;
                            ThunderEngine.mRtcEventHandler.onCaptureVolumeIndication(thunderAudioCaptureVolume.getmVolume(), thunderAudioCaptureVolume.getmCpt(), thunderAudioCaptureVolume.getmMicVolume());
                            if (ThunderEngine.s_captureVolumeNotifyCount % 200 == 0) {
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderAudioCaptureVolume totalVolume %d, cpt %d, micVolume %d", Integer.valueOf(thunderAudioCaptureVolume.getmVolume()), Integer.valueOf(thunderAudioCaptureVolume.getmCpt()), Integer.valueOf(thunderAudioCaptureVolume.getmMicVolume()));
                            }
                            ThunderEngine.access$104();
                            return;
                        case 11:
                            ThunderNotification.ThunderAudioPlayVolume thunderAudioPlayVolume = (ThunderNotification.ThunderAudioPlayVolume) message.obj;
                            HashSet<ThunderEventHandler.AudioVolumeInfo> volumes = thunderAudioPlayVolume.getVolumes();
                            if (volumes != null && !volumes.isEmpty()) {
                                ThunderEngine.mRtcEventHandler.onPlayVolumeIndication((ThunderEventHandler.AudioVolumeInfo[]) volumes.toArray(new ThunderEventHandler.AudioVolumeInfo[volumes.size()]), thunderAudioPlayVolume.getTotalVolume());
                                if (ThunderEngine.s_playVolumeNotifyCount % 200 == 0) {
                                    ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderAudioPlayVolume size %d totalVolume %d", Integer.valueOf(thunderAudioPlayVolume.getVolumes().size()), Integer.valueOf(thunderAudioPlayVolume.getTotalVolume()));
                                }
                                ThunderEngine.access$204();
                                return;
                            }
                            ThunderLog.error(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderAudioPlayVolume size %d totalVolume %d", 0, Integer.valueOf(thunderAudioPlayVolume.getTotalVolume()));
                            return;
                        case 12:
                            ThunderNotification.ThunderAudioPlayData thunderAudioPlayData = (ThunderNotification.ThunderAudioPlayData) message.obj;
                            ThunderEngine.mRtcEventHandler.onAudioPlayData(thunderAudioPlayData.getData(), thunderAudioPlayData.getCpt(), thunderAudioPlayData.getPts(), thunderAudioPlayData.getUid(), thunderAudioPlayData.getDuration());
                            if (ThunderEngine.s_playDataNotifyCount % 500 == 0) {
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderAudioPlayData cpt %d, pts %d, uid %s, duration %d", Integer.valueOf(thunderAudioPlayData.getCpt()), Integer.valueOf(thunderAudioPlayData.getPts()), thunderAudioPlayData.getUid(), Integer.valueOf(thunderAudioPlayData.getDuration()));
                            }
                            ThunderEngine.access$304();
                            return;
                        case 13:
                            ThunderEngine.mRtcEventHandler.onAudioPlaySpectrumData(((ThunderNotification.ThunderAudioPlaySpectrumData) message.obj).getData());
                            if (ThunderEngine.s_audioPlaySpectrumCount % 500 == 0) {
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_AudioPlaySpectrumData");
                            }
                            ThunderEngine.access$404();
                            return;
                        case 14:
                            ThunderNotification.ThunderAudioCapturePcmData thunderAudioCapturePcmData = (ThunderNotification.ThunderAudioCapturePcmData) message.obj;
                            ThunderEngine.mRtcEventHandler.onAudioCapturePcmData(thunderAudioCapturePcmData.getData(), thunderAudioCapturePcmData.getLen(), thunderAudioCapturePcmData.getSampleRate(), thunderAudioCapturePcmData.getChannel());
                            return;
                        case 15:
                            ThunderNotification.ThunderUserAppMsgData thunderUserAppMsgData = (ThunderNotification.ThunderUserAppMsgData) message.obj;
                            ThunderEngine.mRtcEventHandler.onRecvUserAppMsgData(thunderUserAppMsgData.getMsgData().getBytes(), thunderUserAppMsgData.getUid());
                            return;
                        case 16:
                            ThunderNotification.ThunderAppMsgDataFailStatus thunderAppMsgDataFailStatus = (ThunderNotification.ThunderAppMsgDataFailStatus) message.obj;
                            ThunderEngine.mRtcEventHandler.onSendAppMsgDataFailedStatus(thunderAppMsgDataFailStatus.getStatus());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_AppMsgDataFailStatus status %d", Integer.valueOf(thunderAppMsgDataFailStatus.getStatus()));
                            return;
                        case 17:
                            ThunderNotification.ThunderAudioRenderPcmData thunderAudioRenderPcmData = (ThunderNotification.ThunderAudioRenderPcmData) message.obj;
                            ThunderEngine.mRtcEventHandler.onAudioRenderPcmData(thunderAudioRenderPcmData.getData(), thunderAudioRenderPcmData.getLen(), thunderAudioRenderPcmData.getDuration(), thunderAudioRenderPcmData.getSampleRate(), thunderAudioRenderPcmData.getChannel());
                            return;
                        case 18:
                            ThunderNotification.ThunderHttpsRequest thunderHttpsRequest = (ThunderNotification.ThunderHttpsRequest) message.obj;
                            if (ThunderEngine.mHttpsRequestHandler != null) {
                                ThunderEngine.mHttpsRequestHandler.send(thunderHttpsRequest.getUrl(), thunderHttpsRequest.getTarget());
                            }
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_HttpsRequest, url %s, target %d", thunderHttpsRequest.getUrl(), Integer.valueOf(thunderHttpsRequest.getTarget()));
                            return;
                        case 19:
                            ThunderNotification.ThunderRemoteVideoStopped thunderRemoteVideoStopped = (ThunderNotification.ThunderRemoteVideoStopped) message.obj;
                            ThunderEngine.mRtcEventHandler.onRemoteVideoStopped(thunderRemoteVideoStopped.getUid(), thunderRemoteVideoStopped.isbStop());
                            ThunderEngine.mRtcEventHandler.onRemoteVideoArrived(thunderRemoteVideoStopped.getRoomId(), thunderRemoteVideoStopped.getUid(), !thunderRemoteVideoStopped.isbStop());
                            Object[] objArr = new Object[3];
                            objArr[0] = thunderRemoteVideoStopped.getRoomId();
                            objArr[1] = thunderRemoteVideoStopped.getUid();
                            objArr[2] = Boolean.valueOf(!thunderRemoteVideoStopped.isbStop());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_RemoteVideoArrived roomId %s, uid %s, arrive %b", objArr);
                            return;
                        case 20:
                            ThunderNotification.ThunderRemoteAudioStopped thunderRemoteAudioStopped = (ThunderNotification.ThunderRemoteAudioStopped) message.obj;
                            ThunderEngine.mRtcEventHandler.onRemoteAudioStopped(thunderRemoteAudioStopped.getUid(), thunderRemoteAudioStopped.isbStop());
                            ThunderEngine.mRtcEventHandler.onRemoteAudioArrived(thunderRemoteAudioStopped.getRoomId(), thunderRemoteAudioStopped.getUid(), !thunderRemoteAudioStopped.isbStop());
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = thunderRemoteAudioStopped.getRoomId();
                            objArr2[1] = thunderRemoteAudioStopped.getUid();
                            objArr2[2] = Boolean.valueOf(!thunderRemoteAudioStopped.isbStop());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_RemoteAudioArrived roomId %s, uid %s, arrive %b", objArr2);
                            return;
                        case 21:
                            ThunderNotification.ThunderVideoSizeChange thunderVideoSizeChange = (ThunderNotification.ThunderVideoSizeChange) message.obj;
                            ThunderEngine.mRtcEventHandler.onVideoSizeChanged(thunderVideoSizeChange.getUid(), thunderVideoSizeChange.getWidth(), thunderVideoSizeChange.getHeight(), 0);
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_VideoSizeChange uid %s, w %d, h %d", thunderVideoSizeChange.getUid(), Integer.valueOf(thunderVideoSizeChange.getWidth()), Integer.valueOf(thunderVideoSizeChange.getHeight()));
                            return;
                        case 22:
                            ThunderEngine.mRtcEventHandler.onConnectionStatus(((ThunderNotification.ThunderConnectionStatus) message.obj).getStatus());
                            return;
                        case 23:
                            ThunderNotification.ThunderConnectionLost thunderConnectionLost = (ThunderNotification.ThunderConnectionLost) message.obj;
                            ThunderEngine.mRtcEventHandler.onConnectionLost();
                            return;
                        case 24:
                            ThunderEngine.mRtcEventHandler.onRoomStats((ThunderNotification.RoomStats) message.obj);
                            return;
                        case 25:
                            ThunderNotification.ThunderNetworkStateChange thunderNetworkStateChange = (ThunderNotification.ThunderNetworkStateChange) message.obj;
                            ThunderEngine.mRtcEventHandler.onNetworkTypeChanged(thunderNetworkStateChange.getStatus());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_NetworkStateChange status %d", Integer.valueOf(thunderNetworkStateChange.getStatus()));
                            return;
                        case 26:
                            ThunderNotification.ThunderPublishStreamToCdnStatus thunderPublishStreamToCdnStatus = (ThunderNotification.ThunderPublishStreamToCdnStatus) message.obj;
                            ThunderEngine.mRtcEventHandler.onPublishStreamToCDNStatus(thunderPublishStreamToCdnStatus.getUrl(), thunderPublishStreamToCdnStatus.getErrorCode());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_PublishStreamToCdnStatus url %s, errorCode %d", thunderPublishStreamToCdnStatus.getUrl(), Integer.valueOf(thunderPublishStreamToCdnStatus.getErrorCode()));
                            return;
                        case 27:
                            ThunderNotification.ThunderUserJoined thunderUserJoined = (ThunderNotification.ThunderUserJoined) message.obj;
                            ThunderEngine.mRtcEventHandler.onUserJoined(thunderUserJoined.getUid(), thunderUserJoined.getElapsedTime());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_UserJoined uid %s", thunderUserJoined.getUid());
                            return;
                        case 28:
                            ThunderNotification.ThunderUserOffline thunderUserOffline = (ThunderNotification.ThunderUserOffline) message.obj;
                            ThunderEngine.mRtcEventHandler.onUserOffline(thunderUserOffline.getUid(), thunderUserOffline.getReason());
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_UserOffline uid %s reason %d", thunderUserOffline.getUid(), Integer.valueOf(thunderUserOffline.getReason()));
                            return;
                        case 29:
                            ThunderNotification.ThunderNetworkQuality thunderNetworkQuality = (ThunderNotification.ThunderNetworkQuality) message.obj;
                            ThunderEngine.mRtcEventHandler.onNetworkQuality(thunderNetworkQuality.getUid(), thunderNetworkQuality.getTxQuality(), thunderNetworkQuality.getRxQuality());
                            return;
                        case 30:
                            ThunderNotification.ThunderAudioExtraInfo thunderAudioExtraInfo = (ThunderNotification.ThunderAudioExtraInfo) message.obj;
                            if (ThunderEngine.mThunderMediaExtraInfoCallback != null) {
                                ByteBuffer wrap = ByteBuffer.wrap(thunderAudioExtraInfo.getExtraInfo());
                                ThunderEngine.mThunderMediaExtraInfoCallback.onRecvMediaExtraInfo(thunderAudioExtraInfo.getUid(), wrap, wrap.remaining());
                                return;
                            }
                            return;
                        case 31:
                            ThunderNotification.ThunderAudioExtraFailStatus thunderAudioExtraFailStatus = (ThunderNotification.ThunderAudioExtraFailStatus) message.obj;
                            if (ThunderEngine.mThunderMediaExtraInfoCallback != null) {
                                ThunderEngine.mThunderMediaExtraInfoCallback.onSendMediaExtraInfoFailedStatus(thunderAudioExtraFailStatus.getStatus());
                            }
                            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "kThunderNotification_AudioExtraFailStatus status %d", Integer.valueOf(thunderAudioExtraFailStatus.getStatus()));
                            return;
                        case 32:
                            if (ThunderEngine.mThunderMediaExtraInfoCallback != null) {
                                ThunderNotification.ThunderVideoExtraInfo thunderVideoExtraInfo = (ThunderNotification.ThunderVideoExtraInfo) message.obj;
                                ByteBuffer wrap2 = ByteBuffer.wrap(thunderVideoExtraInfo.getExtraInfo());
                                ThunderEngine.mThunderMediaExtraInfoCallback.onRecvMediaExtraInfo(thunderVideoExtraInfo.getUid(), wrap2, wrap2.remaining());
                                return;
                            }
                            return;
                        case 33:
                            if (ThunderEngine.mThunderMediaExtraInfoCallback != null) {
                                ThunderNotification.ThunderMixVideoExtraInfo thunderMixVideoExtraInfo = (ThunderNotification.ThunderMixVideoExtraInfo) message.obj;
                                ThunderEngine.mThunderMediaExtraInfoCallback.onRecvMixVideoInfo(thunderMixVideoExtraInfo.getmUid(), thunderMixVideoExtraInfo.getMixExtraInfos());
                                return;
                            }
                            return;
                        case 34:
                            if (ThunderEngine.mThunderMediaExtraInfoCallback != null) {
                                ThunderNotification.ThunderMixAudioExtraInfo thunderMixAudioExtraInfo = (ThunderNotification.ThunderMixAudioExtraInfo) message.obj;
                                ThunderEngine.mThunderMediaExtraInfoCallback.onRecvMixAudioInfo(thunderMixAudioExtraInfo.getmUid(), thunderMixAudioExtraInfo.getMixAudioExtraInfos());
                                return;
                            }
                            return;
                        case 35:
                            ThunderEngine.mRtcEventHandler.onAudioCaptureStatus(((ThunderNotification.ThunderAudioCaptureStatus) message.obj).getStatus());
                            return;
                        case 36:
                            ThunderEngine.mRtcEventHandler.onVideoCaptureStatus(((ThunderNotification.ThunderVideoCaptureStatus) message.obj).getStatus());
                            return;
                        case 37:
                            ThunderNotification.ThunderLocalVideoStats thunderLocalVideoStats = (ThunderNotification.ThunderLocalVideoStats) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderEventHandler.LocalVideoStats localVideoStats = new ThunderEventHandler.LocalVideoStats();
                                localVideoStats.sentBitrate = thunderLocalVideoStats.getSendBitrate();
                                localVideoStats.sentFrameRate = thunderLocalVideoStats.getSendFrameRate();
                                localVideoStats.renderOutputFrameRate = thunderLocalVideoStats.getRenderOutputFrameRate();
                                localVideoStats.targetBitRate = thunderLocalVideoStats.getTargetBitrate();
                                localVideoStats.targetFrameRate = thunderLocalVideoStats.getTargetFrameRate();
                                localVideoStats.qualityAdaptIndication = thunderLocalVideoStats.getQualityAdaptIndicat();
                                localVideoStats.encoderOutputFrameRate = thunderLocalVideoStats.getEncodeFrameRate();
                                localVideoStats.encodedBitrate = thunderLocalVideoStats.getBitrate();
                                localVideoStats.encodedFrameWidth = thunderLocalVideoStats.getWidth();
                                localVideoStats.encodedFrameHeight = thunderLocalVideoStats.getHeight();
                                localVideoStats.encodedFrameCount = thunderLocalVideoStats.getEncodedFrameCount();
                                localVideoStats.encodedType = thunderLocalVideoStats.getEncodedType();
                                localVideoStats.codecType = thunderLocalVideoStats.getCodec();
                                localVideoStats.configBitRate = thunderLocalVideoStats.getConfigBitRate();
                                localVideoStats.configFrameRate = thunderLocalVideoStats.getConfigFrameRate();
                                localVideoStats.configWidth = thunderLocalVideoStats.getConfigWidth();
                                localVideoStats.configHeight = thunderLocalVideoStats.getConfigHeight();
                                ThunderEngine.mRtcEventHandler.onLocalVideoStats(localVideoStats);
                                return;
                            }
                            return;
                        case 38:
                            ThunderNotification.RemoteVideoStats remoteVideoStats = (ThunderNotification.RemoteVideoStats) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderEventHandler.RemoteVideoStats remoteVideoStats2 = new ThunderEventHandler.RemoteVideoStats();
                                remoteVideoStats2.delay = remoteVideoStats.getDelay();
                                remoteVideoStats2.width = remoteVideoStats.getWidth();
                                remoteVideoStats2.height = remoteVideoStats.getHeight();
                                remoteVideoStats2.receivedBitrate = remoteVideoStats.getReceivedBitrate();
                                remoteVideoStats2.decoderOutputFrameRate = remoteVideoStats.getDecoderFrameRate();
                                remoteVideoStats2.rendererOutputFrameRate = remoteVideoStats.getRenderFrameRate();
                                remoteVideoStats2.packetLossRate = remoteVideoStats.getPacketLossRate();
                                remoteVideoStats2.rxStreamType = remoteVideoStats.getRxStreamType();
                                remoteVideoStats2.totalFrozenTime = remoteVideoStats.getFrozenTime();
                                remoteVideoStats2.frozenRate = remoteVideoStats.getFrozenRate();
                                remoteVideoStats2.codecType = remoteVideoStats.getCodecType();
                                remoteVideoStats2.decodedType = remoteVideoStats.getDecodedType();
                                ThunderEngine.mRtcEventHandler.onRemoteVideoStatsOfUid(remoteVideoStats.getUid(), remoteVideoStats2);
                                return;
                            }
                            return;
                        case 39:
                            ThunderNotification.ThunderLocalAudioStats thunderLocalAudioStats = (ThunderNotification.ThunderLocalAudioStats) message.obj;
                            if (ThunderLog.isInfoValid()) {
                                ThunderLog.info(ThunderLog.kLogTagRtcEngine, String.format("ThunderNotification.ThunderLocalAudioStats encodedBitrate=%d channels=%d sendSampleRate=%d sendBitRate=%d enableVad=%d", Integer.valueOf(thunderLocalAudioStats.getEncodedBitrate()), Integer.valueOf(thunderLocalAudioStats.getNumChannels()), Integer.valueOf(thunderLocalAudioStats.getSampleRate()), Integer.valueOf(thunderLocalAudioStats.getSendBitRate()), Integer.valueOf(thunderLocalAudioStats.getEnableVad())));
                            }
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderEventHandler.LocalAudioStats localAudioStats = new ThunderEventHandler.LocalAudioStats();
                                localAudioStats.encodedBitrate = thunderLocalAudioStats.getEncodedBitrate();
                                localAudioStats.numChannels = thunderLocalAudioStats.getNumChannels();
                                localAudioStats.sendSampleRate = thunderLocalAudioStats.getSampleRate();
                                localAudioStats.sendBitrate = thunderLocalAudioStats.getSendBitRate();
                                localAudioStats.enableVad = thunderLocalAudioStats.getEnableVad();
                                ThunderEngine.mRtcEventHandler.onLocalAudioStats(localAudioStats);
                                return;
                            }
                            return;
                        case 40:
                            ThunderNotification.RemoteAudioStats remoteAudioStats = (ThunderNotification.RemoteAudioStats) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderEventHandler.RemoteAudioStats remoteAudioStats2 = new ThunderEventHandler.RemoteAudioStats();
                                remoteAudioStats2.quality = remoteAudioStats.getQuality();
                                remoteAudioStats2.networkTransportDelay = remoteAudioStats.getNetworkTransportDelay();
                                remoteAudioStats2.jitterBufferDelay = remoteAudioStats.getJitterBufferDelay();
                                remoteAudioStats2.totalDelay = remoteAudioStats.getTotalDelay();
                                remoteAudioStats2.frameLossRate = remoteAudioStats.getFrameLossRate();
                                remoteAudioStats2.numChannels = remoteAudioStats.getNumChannels();
                                remoteAudioStats2.receivedSampleRate = remoteAudioStats.getReceivedSampleRate();
                                remoteAudioStats2.receivedBitrate = remoteAudioStats.getReceivedBitrate();
                                remoteAudioStats2.totalFrozenTime = remoteAudioStats.getFrozenTime();
                                remoteAudioStats2.frozenRate = remoteAudioStats.getFrozenRate();
                                ThunderEngine.mRtcEventHandler.onRemoteAudioStatsOfUid(remoteAudioStats.getUid(), remoteAudioStats2);
                                return;
                            }
                            return;
                        case 41:
                            ThunderNotification.ThunderRemoteAudioStateChanged thunderRemoteAudioStateChanged = (ThunderNotification.ThunderRemoteAudioStateChanged) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null && thunderRemoteAudioStateChanged != null) {
                                ThunderEngine.mRtcEventHandler.onRemoteAudioStateChangedOfUid(thunderRemoteAudioStateChanged.getUid(), thunderRemoteAudioStateChanged.getState(), thunderRemoteAudioStateChanged.getReason(), thunderRemoteAudioStateChanged.getElapsedTime());
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_RemoteAudioStateChanged uid %s, state %d, reason %d, elapsedTime %d", thunderRemoteAudioStateChanged.getUid(), Integer.valueOf(thunderRemoteAudioStateChanged.getState()), Integer.valueOf(thunderRemoteAudioStateChanged.getReason()), Integer.valueOf(thunderRemoteAudioStateChanged.getElapsedTime()));
                                return;
                            }
                            return;
                        case 42:
                            ThunderNotification.ThunderRemoteAudioPlay thunderRemoteAudioPlay = (ThunderNotification.ThunderRemoteAudioPlay) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null && thunderRemoteAudioPlay != null) {
                                ThunderEngine.mRtcEventHandler.onRemoteAudioPlay(thunderRemoteAudioPlay.getUid(), thunderRemoteAudioPlay.getElapsedTime());
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_RemoteAudioStateChanged uid %s, elapsedTime %d", thunderRemoteAudioPlay.getUid(), Integer.valueOf(thunderRemoteAudioPlay.getElapsedTime()));
                                return;
                            }
                            return;
                        case 43:
                            ThunderNotification.ThunderRemoteVideoStateChanged thunderRemoteVideoStateChanged = (ThunderNotification.ThunderRemoteVideoStateChanged) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null && thunderRemoteVideoStateChanged != null) {
                                ThunderEngine.mRtcEventHandler.onRemoteVideoStateChangedOfUid(thunderRemoteVideoStateChanged.getUid(), thunderRemoteVideoStateChanged.getState(), thunderRemoteVideoStateChanged.getReason(), thunderRemoteVideoStateChanged.getElapsedTime());
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.kThunderNotification_RemoteVideoStateChanged uid %s, state %d, reason %d, elapsedTime %d", thunderRemoteVideoStateChanged.getUid(), Integer.valueOf(thunderRemoteVideoStateChanged.getState()), Integer.valueOf(thunderRemoteVideoStateChanged.getReason()), Integer.valueOf(thunderRemoteVideoStateChanged.getElapsedTime()));
                                return;
                            }
                            return;
                        case 44:
                            ThunderNotification.LocalAudioStatusChanged localAudioStatusChanged = (ThunderNotification.LocalAudioStatusChanged) message.obj;
                            if (ThunderLog.isInfoValid()) {
                                ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.LocalAudioStatusChanged status=%d errorReason=%d", Integer.valueOf(localAudioStatusChanged.getLocalAudioStreamStatus()), Integer.valueOf(localAudioStatusChanged.getLocalAudioStreamErrorReason()));
                            }
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderEventHandler.LocalAudioStatusChanged localAudioStatusChanged2 = new ThunderEventHandler.LocalAudioStatusChanged();
                                localAudioStatusChanged2.status = localAudioStatusChanged.getLocalAudioStreamStatus();
                                localAudioStatusChanged2.errorReason = localAudioStatusChanged.getLocalAudioStreamErrorReason();
                                ThunderEngine.mRtcEventHandler.onLocalAudioStatusChanged(localAudioStatusChanged2.status, localAudioStatusChanged2.errorReason);
                                return;
                            }
                            return;
                        case 45:
                            ThunderNotification.ThunderDeviceStats thunderDeviceStats = (ThunderNotification.ThunderDeviceStats) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderEventHandler.DeviceStats deviceStats = new ThunderEventHandler.DeviceStats();
                                deviceStats.cpuTotalUsage = thunderDeviceStats.getCpuTotalUsage();
                                deviceStats.cpuAppUsage = thunderDeviceStats.getCpuAppUsage();
                                deviceStats.memoryAppUsage = thunderDeviceStats.getMemoryAppUsage();
                                deviceStats.memoryTotalUsage = thunderDeviceStats.getMemoryTotalUsage();
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderDeviceStats cpuTotalUsage=%f cpuAppUsage=%f memoryAppUsage=%f memoryTotalUsage=%f", Double.valueOf(deviceStats.cpuTotalUsage), Double.valueOf(deviceStats.cpuAppUsage), Double.valueOf(deviceStats.memoryAppUsage), Double.valueOf(deviceStats.memoryTotalUsage));
                                ThunderEngine.mRtcEventHandler.onDeviceStats(deviceStats);
                                return;
                            }
                            return;
                        case 46:
                            ThunderNotification.LocalVideoStatusChanged localVideoStatusChanged = (ThunderNotification.LocalVideoStatusChanged) message.obj;
                            if (ThunderLog.isInfoValid()) {
                                ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.LocalVideoStatusChanged status=%d errorReason=%d", Integer.valueOf(localVideoStatusChanged.getLocalVideoStreamStatus()), Integer.valueOf(localVideoStatusChanged.getLocalVideoStreamError()));
                            }
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderEngine.mRtcEventHandler.onLocalVideoStatusChanged(localVideoStatusChanged.getLocalVideoStreamStatus(), localVideoStatusChanged.getLocalVideoStreamError());
                                return;
                            }
                            return;
                        case 47:
                            ThunderNotification.ThunderAudioRouteChanged thunderAudioRouteChanged = (ThunderNotification.ThunderAudioRouteChanged) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderAudioRouteChanged Routing = %d", Integer.valueOf(thunderAudioRouteChanged.getRouting()));
                                ThunderEngine.mRtcEventHandler.onAudioRouteChanged(thunderAudioRouteChanged.getRouting());
                                return;
                            }
                            return;
                        case 48:
                            ThunderNotification.ThunderHowlingDetectResult thunderHowlingDetectResult = (ThunderNotification.ThunderHowlingDetectResult) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderHowlingDetectResult value = %b", Boolean.valueOf(thunderHowlingDetectResult.getValue()));
                                ThunderEngine.mRtcEventHandler.onHowlingDetectResult(thunderHowlingDetectResult.getValue());
                                return;
                            }
                            return;
                        case 49:
                            ThunderNotification.ThunderEchoDetectResult thunderEchoDetectResult = (ThunderNotification.ThunderEchoDetectResult) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderEchoDetectResult value = %b", Boolean.valueOf(thunderEchoDetectResult.getValue()));
                                ThunderEngine.mRtcEventHandler.onEchoDetectResult(thunderEchoDetectResult.getValue());
                                return;
                            }
                            return;
                        case 50:
                            ThunderNotification.ThunderAudioInputDeviceTestVolume thunderAudioInputDeviceTestVolume = (ThunderNotification.ThunderAudioInputDeviceTestVolume) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderEngine.mRtcEventHandler.onAudioInputDeviceTestVolume(thunderAudioInputDeviceTestVolume.getVolume());
                                return;
                            }
                            return;
                        case 51:
                            ThunderNotification.ThunderAudioOutputDeviceTestVolume thunderAudioOutputDeviceTestVolume = (ThunderNotification.ThunderAudioOutputDeviceTestVolume) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderEngine.mRtcEventHandler.onAudioOutputDeviceTestVolume(thunderAudioOutputDeviceTestVolume.getVolume());
                                return;
                            }
                            return;
                        case 52:
                            ThunderNotification.ThunderVideoCaptureFocusChanged thunderVideoCaptureFocusChanged = (ThunderNotification.ThunderVideoCaptureFocusChanged) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderVideoCaptureFocusChanged posX = %d, poxY = %d, w = %d, h = %d", Integer.valueOf(thunderVideoCaptureFocusChanged.getPosX()), Integer.valueOf(thunderVideoCaptureFocusChanged.getPosY()), Integer.valueOf(thunderVideoCaptureFocusChanged.getWidth()), Integer.valueOf(thunderVideoCaptureFocusChanged.getHeight()));
                                ThunderEngine.mRtcEventHandler.onCameraFocusAreaChanged(new Rect(thunderVideoCaptureFocusChanged.getPosX(), thunderVideoCaptureFocusChanged.getPosY(), thunderVideoCaptureFocusChanged.getPosX() + thunderVideoCaptureFocusChanged.getWidth(), thunderVideoCaptureFocusChanged.getPosY() - thunderVideoCaptureFocusChanged.getHeight()));
                                return;
                            }
                            return;
                        case 53:
                            ThunderNotification.ThunderVideoCaptureExposureChanged thunderVideoCaptureExposureChanged = (ThunderNotification.ThunderVideoCaptureExposureChanged) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderVideoCaptureExposureChanged posX = %d, poxY = %d, w = %d, h = %d", Integer.valueOf(thunderVideoCaptureExposureChanged.getPosX()), Integer.valueOf(thunderVideoCaptureExposureChanged.getPosY()), Integer.valueOf(thunderVideoCaptureExposureChanged.getWidth()), Integer.valueOf(thunderVideoCaptureExposureChanged.getHeight()));
                                ThunderEngine.mRtcEventHandler.onCameraExposureAreaChanged(new Rect(thunderVideoCaptureExposureChanged.getPosX(), thunderVideoCaptureExposureChanged.getPosY(), thunderVideoCaptureExposureChanged.getPosX() + thunderVideoCaptureExposureChanged.getWidth(), thunderVideoCaptureExposureChanged.getPosY() - thunderVideoCaptureExposureChanged.getHeight()));
                                return;
                            }
                            return;
                        case 54:
                            ThunderNotification.ThunderPrivateCallBack thunderPrivateCallBack = (ThunderNotification.ThunderPrivateCallBack) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                if (ThunderLog.isInfoValid()) {
                                    ThunderLog.info(ThunderLog.kLogTagRtcEngine, "ThunderNotification.PrivateCallBack key:%d jsonStr:%s", Integer.valueOf(thunderPrivateCallBack.getmKey()), thunderPrivateCallBack.getmJsonStr());
                                }
                                ThunderEngine.mRtcEventHandler.onParamsCallback(thunderPrivateCallBack.getmKey(), thunderPrivateCallBack.getmJsonStr());
                                return;
                            }
                            return;
                        case 55:
                            ThunderNotification.ThunderAudioRecordState thunderAudioRecordState = (ThunderNotification.ThunderAudioRecordState) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                ThunderEngine.mRtcEventHandler.onAudioRecordState(thunderAudioRecordState.getErrorCode(), thunderAudioRecordState.getDuration());
                                return;
                            }
                            return;
                        case 56:
                            ThunderNotification.ThunderUserRoleChanged thunderUserRoleChanged = (ThunderNotification.ThunderUserRoleChanged) message.obj;
                            if (ThunderEngine.mRtcEventHandler != null) {
                                int oldRole = thunderUserRoleChanged.getOldRole();
                                int newRole = thunderUserRoleChanged.getNewRole();
                                ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderNotification.ThunderUserRoleChanged oldRole=%d newRole=%d", Integer.valueOf(oldRole), Integer.valueOf(newRole));
                                ThunderEngine.mRtcEventHandler.onUserRoleChanged(oldRole, newRole);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } catch (Exception e) {
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    ThunderLog.error(ThunderLog.kLogTagRtcEngine, String.format("handleMessage err=%s", stringWriter.toString()));
                }
            }
        }
    }

    static {
        if ("full".equalsIgnoreCase("fullvideo")) {
            try {
                System.loadLibrary("c++_shared");
            } catch (Throwable th) {
                th.printStackTrace();
                Log.e(ThunderLog.kLogTagRtcEngine, "fullvideo flavor load c++_shared failed!");
            }
        }
        try {
            System.loadLibrary("ffmpeg-neon");
            System.loadLibrary("yydec265");
        } catch (Throwable th2) {
            th2.printStackTrace();
            Log.e(ThunderLog.kLogTagRtcEngine, "load ffmpeg-neon & Ittiamhevcdec failed!");
        }
        try {
            System.loadLibrary("thunder");
        } catch (Throwable th3) {
            th3.printStackTrace();
            Log.e(ThunderLog.kLogTagRtcEngine, "load thunder failed!");
        }
    }

    private ThunderEngine() {
        this.mAudioFilePlayerSet = new TreeSet();
        this.mExternalVideoSource = null;
        mPublisher = new ThunderPublisher();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class SingleonHolder {
        private static ThunderEngine INSTANCE = new ThunderEngine();

        private SingleonHolder() {
        }
    }

    private static synchronized ThunderEngine createRtcEngine(Context context, String str, long j, int i, int i2, ThunderEventHandler thunderEventHandler, Looper looper) {
        ThunderEngine thunderEngine;
        long parseLong;
        synchronized (ThunderEngine.class) {
            try {
                parseLong = Long.parseLong(str);
                if (SingleonHolder.INSTANCE == null) {
                    ThunderEngine unused = SingleonHolder.INSTANCE = new ThunderEngine();
                }
                if (mHandler == null) {
                    if (looper != null) {
                        mHandler = new NotificationHandler(SingleonHolder.INSTANCE, looper);
                    } else {
                        mHandler = new NotificationHandler(SingleonHolder.INSTANCE);
                    }
                }
            } catch (NumberFormatException e) {
                Log.e(ThunderLog.kLogTagRtcEngine, "init failed, appid is not number");
                thunderEngine = null;
            }
            if (!mIsInited) {
                mRtcEventHandler = thunderEventHandler;
                mHttpsRequestHandler = new ThunderHttpsRequestHandler();
                YMFLog.registerLogger(ThunderVideoLogCallback.sharedInstance());
                if (mNetStateService != null) {
                    mNetStateService.fini();
                }
                if (mForeBackgroundListener != null) {
                    mForeBackgroundListener.fini();
                }
                mNotificationDispatcher = new ThunderNative.NotificationDispatcher() { // from class: com.thunder.livesdk.ThunderEngine.1
                    private final HashSet<Handler> mNotificationHandlers = new HashSet<>();

                    @Override // com.thunder.livesdk.helper.ThunderNative.NotificationDispatcher
                    public void registerNotificationHandler(Handler handler) {
                        synchronized (this.mNotificationHandlers) {
                            this.mNotificationHandlers.add(handler);
                        }
                    }

                    @Override // com.thunder.livesdk.helper.ThunderNative.NotificationDispatcher
                    public void unregisterNotificationHandler(Handler handler) {
                        synchronized (this.mNotificationHandlers) {
                            this.mNotificationHandlers.remove(handler);
                        }
                    }

                    @Override // com.thunder.livesdk.helper.ThunderNative.NotificationDispatcher
                    public Object[] collectNotificationHandlers() {
                        Object[] objArr = null;
                        synchronized (this.mNotificationHandlers) {
                            if (this.mNotificationHandlers.size() > 0) {
                                objArr = this.mNotificationHandlers.toArray();
                            }
                        }
                        return objArr;
                    }
                };
                mNotificationDispatcher.registerNotificationHandler(mHandler);
                ThunderDeviceInfo thunderDeviceInfo = new ThunderDeviceInfo(context);
                YYVideoLibMgr.instance().init(context, "1.0", "Thunder", Build.VERSION.RELEASE, Build.MODEL, null);
                VideoLibAPI.instance().initVideoLib(parseLong, j, context);
                if (ThunderNative.init(parseLong, j, i, i2, context, thunderDeviceInfo, mNotificationDispatcher) < 0) {
                    ThunderLog.error(ThunderLog.kLogTagRtcEngine, "init failed");
                    thunderEngine = null;
                } else {
                    mNetStateService = new ThunderNetStateService(context);
                    mNetStateService.init();
                    mForeBackgroundListener = new ThunderForeBackgroundListener(context);
                    mForeBackgroundListener.init();
                    mIsInited = true;
                }
            }
            thunderEngine = SingleonHolder.INSTANCE;
        }
        return thunderEngine;
    }

    public static synchronized ThunderEngine createEngine(Context context, String str, long j, ThunderEventHandler thunderEventHandler) {
        ThunderEngine createRtcEngine;
        synchronized (ThunderEngine.class) {
            createRtcEngine = createRtcEngine(context, str, j, -1, -1, thunderEventHandler, null);
        }
        return createRtcEngine;
    }

    public static synchronized ThunderEngine createEngine(ThunderEngineConfig thunderEngineConfig) {
        ThunderEngine createRtcEngine;
        synchronized (ThunderEngine.class) {
            createRtcEngine = createRtcEngine(thunderEngineConfig.context, thunderEngineConfig.appId, thunderEngineConfig.sceneId, thunderEngineConfig.areaType, thunderEngineConfig.serverDomain, thunderEngineConfig.handler, null);
        }
        return createRtcEngine;
    }

    public static synchronized ThunderEngine createWithLoop(Context context, String str, long j, ThunderEventHandler thunderEventHandler, Looper looper) {
        ThunderEngine createRtcEngine;
        synchronized (ThunderEngine.class) {
            createRtcEngine = createRtcEngine(context, str, j, -1, -1, thunderEventHandler, looper);
        }
        return createRtcEngine;
    }

    public static synchronized ThunderEngine createWithLoop(ThunderEngineConfig thunderEngineConfig, Looper looper) {
        ThunderEngine createRtcEngine;
        synchronized (ThunderEngine.class) {
            createRtcEngine = createRtcEngine(thunderEngineConfig.context, thunderEngineConfig.appId, thunderEngineConfig.sceneId, thunderEngineConfig.areaType, thunderEngineConfig.serverDomain, thunderEngineConfig.handler, looper);
        }
        return createRtcEngine;
    }

    public static synchronized void destroyEngine() {
        synchronized (ThunderEngine.class) {
            if (mIsInited) {
                SingleonHolder.INSTANCE.setVideoWatermark(null);
                SingleonHolder.INSTANCE.setLocalVideoMirrorMode(0);
                SingleonHolder.INSTANCE.cleanAllAudioFilePlayer();
                SingleonHolder.INSTANCE.resetRtcEngine();
                ThunderEngine unused = SingleonHolder.INSTANCE = null;
                ThunderNative.fini();
                YYVideoLibMgr.instance().deInit("Thunder");
                mIsInited = false;
            }
        }
    }

    public static String getVersion() {
        return ThunderNative.getVersion();
    }

    public static int setLogFilePath(String str) {
        return ThunderNative.setLogFilePath(str);
    }

    public static int setLogCallback(IThunderLogCallback iThunderLogCallback) {
        return ThunderNative.setLogCallback(iThunderLogCallback);
    }

    public static int setLogLevel(int i) {
        ThunderLog.setLogLevel(i);
        return ThunderNative.setLogLevel(i);
    }

    public int setParameters(String str) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setParameters argument %s", str);
        if (str == null || str.isEmpty()) {
            return -13;
        }
        return ThunderNative.setParameters(str);
    }

    public void setSceneId(long j) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setSceneId %d", Long.valueOf(j));
        ThunderNative.setSceneId(j);
    }

    @Deprecated
    public int setRoomConfig(int i, int i2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRoomConfig: config=%d roomConfig:%d", Integer.valueOf(i), Integer.valueOf(i2));
        ThunderNative.setMediaMode(i);
        ThunderNative.setRoomMode(i2);
        return 0;
    }

    public int setMediaMode(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setMediaMode: mode=%d ", Integer.valueOf(i));
        return ThunderNative.setMediaMode(i);
    }

    public int setRoomMode(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRoomMode: mode=%d ", Integer.valueOf(i));
        return ThunderNative.setRoomMode(i);
    }

    public int setArea(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setArea: area=%d", Integer.valueOf(i));
        return ThunderNative.setAreaType(i);
    }

    public int getConnectionStatus() {
        return ThunderNative.getConnectionStatus();
    }

    public int enableWebSdkCompatibility(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableWebSdkCompatibility %b", Boolean.valueOf(z));
        return ThunderNative.enableWebSdkCompatibility(z);
    }

    public int setUse64bitUid(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setUse64bitUid %b", Boolean.valueOf(z));
        return ThunderNative.setUse64bitUid(z);
    }

    public int joinRoom(byte[] bArr, String str, String str2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "joinRoom: roomName=%s, uid=%s, token=%s", str, str2, getPrintString(bArr));
        return ThunderNative.joinRoom(bArr, str, str2);
    }

    public int leaveRoom() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "leaveRoom");
        return ThunderNative.leaveRoom();
    }

    public int updateToken(byte[] bArr) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "updateToken: %s ", getPrintString(bArr));
        return ThunderNative.updateToken(bArr);
    }

    @Deprecated
    public int enableAudioEngine() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableAudioEngine ");
        return ThunderNative.startPublishAudio(true);
    }

    @Deprecated
    public int disableAudioEngine() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "disableAudioEngine");
        return ThunderNative.startPublishAudio(false);
    }

    public int setAudioConfig(int i, int i2, int i3) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setAudioConfig: profile=%d, commutMode=%d, scenarioMode=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        return ThunderNative.setAudioConfig(i, i2, i3);
    }

    public int enableVoicePosition(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableVoicePosition: enable=%b", Boolean.valueOf(z));
        return ThunderNative.enableVoicePosition(z);
    }

    public int enableLoudspeaker(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableLoudspeaker: %b", Boolean.valueOf(z));
        return ThunderNative.enableLoudSpeaker(z);
    }

    public boolean isLoudspeakerEnabled() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isLoudspeakerEnabled");
        return ThunderNative.getLoudSpeakerEnabled();
    }

    public int setAudioVolumeIndication(int i, int i2, int i3, int i4) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setAudioVolumeIndication: interval=%d,moreThanThd=%d, lessThanThd=%d, smooth=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        return ThunderNative.setPlayVolumeInterval(i, i2, i3);
    }

    public int enableCaptureVolumeIndication(int i, int i2, int i3, int i4) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableCaptureVolumeIndication: interval=%d,moreThanThd=%d, lessThanThd=%d, smooth=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        return ThunderNative.setCaptureVolumeInterval(i, i2, i3);
    }

    public boolean startAudioSaver(String str, int i, int i2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "startAudioSaver: fileName=%s, saverMode=%d, fileMode=%d", getPrintString(str), Integer.valueOf(i), Integer.valueOf(i2));
        if (str.isEmpty()) {
            return false;
        }
        return ThunderNative.startAudioSaver(str, i, i2);
    }

    public boolean stopAudioSaver() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopAudioSaver");
        return ThunderNative.stopAudioSaver();
    }

    public int startAudioRecord(String str, int i, int i2, int i3) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "startAudioRecord: fileName=%s, saverMode=%d, sampleRate=%d, quality=%d", getPrintString(str), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (str.isEmpty()) {
            return -13;
        }
        return ThunderNative.startAudioRecord(str, i, i2, i3);
    }

    public int stopAudioRecord() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopAudioRecord");
        return ThunderNative.stopAudioRecord();
    }

    public void setSoundEffect(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderEngine::setSoundEffect %d", Integer.valueOf(i));
        ThunderNative.setSoundEffect(i);
    }

    public void setVoiceChanger(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "ThunderEngine::setVoiceChanger %d", Integer.valueOf(i));
        ThunderNative.setVoiceChanger(i);
    }

    public int stopLocalAudioStream(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopLocalAudioStream: %b", Boolean.valueOf(z));
        return ThunderNative.startPublishAudio(z ? false : true);
    }

    public int enableLocalAudioCapture(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableLocalAudioCapture: %b", Boolean.valueOf(z));
        return ThunderNative.startAudioCapture(z);
    }

    public int enableLocalAudioEncoder(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableLocalAudioEncoder: %b", Boolean.valueOf(z));
        return ThunderNative.startAudioEncode(z);
    }

    public int enableLocalAudioPublisher(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableLocalAudioPublisher: %b", Boolean.valueOf(z));
        return ThunderNative.startPushAudioStream(z);
    }

    public boolean isAudioCaptureEnabled() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isAudioCaptureEnabled");
        return ThunderNative.isAudioCaptureEnabled() == 1;
    }

    public boolean isAudioEncoderEnabled() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isAudioEncoderEnabled");
        return ThunderNative.isAudioEncoderEnabled() == 1;
    }

    public boolean isAudioPublisherEnabled() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isAudioPublisherEnabled");
        return ThunderNative.isAudioPublisherEnabled() == 1;
    }

    public int stopAllRemoteAudioStreams(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopAllRemoteAudioStreams: %b", Boolean.valueOf(z));
        return ThunderNative.stopAllRemoteStreams(false, z);
    }

    public int stopRemoteAudioStream(String str, boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopRemoteAudioStream: uid=%s, %b", str, Boolean.valueOf(z));
        return ThunderNative.stopRemoteAudioStream(str, z);
    }

    public int setLoudSpeakerVolume(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setSpeakerphoneVolume: %d", Integer.valueOf(i));
        return ThunderNative.setSpeakerVolume(i);
    }

    public int setMicVolume(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setMicVolume: %d", Integer.valueOf(i));
        return ThunderNative.setMicVolume(i);
    }

    public int setRemoteAudioStreamsVolume(String str, int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRemoteAudioStreamsVolume: uid=%s, volume=%d", getPrintString(str), Integer.valueOf(i));
        return ThunderNative.setRemoteAudioStreamVolume(str, i);
    }

    public int setRemoteUidVoicePosition(String str, int i, int i2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRemoteUidVoicePosition: uid=%s, azimuth=%d, gain=%d", getPrintString(str), Integer.valueOf(i), Integer.valueOf(i2));
        return ThunderNative.setRemoteUidVoicePosition(str, i, i2);
    }

    public ThunderAudioFilePlayer createAudioFilePlayer() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "createAudioFilePlayer");
        ThunderAudioFilePlayer thunderAudioFilePlayer = new ThunderAudioFilePlayer();
        this.mAudioFilePlayerSet.add(thunderAudioFilePlayer);
        return thunderAudioFilePlayer;
    }

    public void destroyAudioFilePlayer(ThunderAudioFilePlayer thunderAudioFilePlayer) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "destroyAudioFilePlayer: %s", getPrintString(thunderAudioFilePlayer));
        if (thunderAudioFilePlayer == null) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "destroyAudioFilePlayer null");
            return;
        }
        thunderAudioFilePlayer.destroyAudioFilePlayer();
        this.mAudioFilePlayerSet.remove(thunderAudioFilePlayer);
    }

    public int setEnableEqualizer(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setEnableEqualizer %b", Boolean.valueOf(z));
        return ThunderNative.enableEqualizer(z);
    }

    public int setEqGains(int[] iArr) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setEqGains");
        if (iArr == null) {
            return -13;
        }
        return ThunderNative.setGqGains(iArr);
    }

    public int setEnableReverb(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setEnableReverb %b", Boolean.valueOf(z));
        return ThunderNative.enableReverb(z);
    }

    public int setReverbExParameter(ThunderRtcConstant.ReverbExParameter reverbExParameter) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setReverbExParameter");
        if (reverbExParameter == null) {
            return -13;
        }
        return ThunderNative.setReverbExParameter(reverbExParameter.mRoomSize, reverbExParameter.mPreDelay, reverbExParameter.mReverberance, reverbExParameter.mHfDamping, reverbExParameter.mToneLow, reverbExParameter.mToneHigh, reverbExParameter.mWetGain, reverbExParameter.mDryGain, reverbExParameter.mStereoWidth);
    }

    public int setEnableCompressor(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setEnableCompressor %b", Boolean.valueOf(z));
        return ThunderNative.enableCompressor(z);
    }

    public int setCompressorParam(ThunderRtcConstant.CompressorParam compressorParam) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setCompressorParam");
        if (compressorParam == null) {
            return -13;
        }
        return ThunderNative.setCompressorParam(compressorParam.mThreshold, compressorParam.mMakeupGain, compressorParam.mRatio, compressorParam.mKnee, compressorParam.mReleaseTime, compressorParam.mAttackTime);
    }

    public int setEnableLimiter(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setEnableLimiter %b", Boolean.valueOf(z));
        return ThunderNative.enableLimiter(z);
    }

    public int setLimiterParam(ThunderRtcConstant.LimterParam limterParam) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setLimiterParam");
        if (limterParam == null) {
            return -13;
        }
        return ThunderNative.setLimiterParameter(limterParam.fCeiling, limterParam.fThreshold, limterParam.fPreGain, limterParam.fRelease, limterParam.fAttack, limterParam.fLookahead, limterParam.fLookaheadRatio, limterParam.fRMS, limterParam.fStLink);
    }

    public int setVoicePitch(float f) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setVoicePitch %f", Float.valueOf(f));
        return ThunderNative.setVoicePitch(f);
    }

    public void setExternalAudioProcessor(long j) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setExternalAudioProcessor");
        ThunderNative.setExternalAudioProcessor(j);
    }

    public void enableAudioPlaySpectrum(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableAudioPlaySpectrum %b", Boolean.valueOf(z));
        ThunderNative.enableAudioPlaySpectrum(z);
    }

    public void setAudioPlaySpectrumInfo(int i, int i2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setAudioPlaySpectrumInfo %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
        ThunderNative.setAudioPlaySpectrumInfo(i, i2);
    }

    public int sendUserAppMsgData(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "sendUserAppMsgData: msgData is null or length is 0");
            return -13;
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "sendUserAppMsgData %s", new String(bArr));
        return ThunderNative.sendUserAppMsgData(bArr);
    }

    public int sendMediaExtraInfo(ByteBuffer byteBuffer, int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "sendMediaExtraInfo %d", Integer.valueOf(i));
        if (byteBuffer == null) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "sendMediaExtraInfo: data is null");
            return -13;
        } else if (byteBuffer.remaining() < i) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "sendMediaExtraInfo: dataLen large than data.remaining()");
            return -13;
        } else {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr, 0, bArr.length);
            return ThunderNative.sendMediaExtraInfo(bArr);
        }
    }

    public int setMediaExtraInfoCallback(IThunderMediaExtraInfoCallback iThunderMediaExtraInfoCallback) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setMediaExtraInfoCallback");
        mThunderMediaExtraInfoCallback = iThunderMediaExtraInfoCallback;
        ThunderNative.makeBehaviorEvent("sdk_api", "setMediaExtraInfoCallback", iThunderMediaExtraInfoCallback == null ? "null" : "not null", 2);
        return 0;
    }

    public int enableMixVideoExtraInfo(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableMixVideoExtraInfo %b", Boolean.valueOf(z));
        return ThunderNative.enableMixVideoExtraInfo(z);
    }

    public int syncMediaPlayingProgress(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "syncMediaPlayingProgress %d", Integer.valueOf(i));
        return (int) ThunderNative.sendAudioFilePlayerInfo(0, i, 0);
    }

    public void enableAudioDataIndication(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableAudioDataIndication %b", Boolean.valueOf(z));
        ThunderNative.enableAudioDataIndication(z);
    }

    public void enableCapturePcmDataCallBack(boolean z, int i, int i2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableCapturePcmDataCallBack %b , %d, %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        ThunderNative.enableCapturePcmDataCallBack(z, i, i2);
    }

    public boolean enableRenderPcmDataCallBack(boolean z, int i, int i2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableRenderPcmDataCallBack %b , %d, %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        return ThunderNative.enableRenderPcmDataCallBack(z, i, i2);
    }

    public int setAudioSourceType(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setAudioSourceType: mode %d", Integer.valueOf(i));
        return ThunderNative.setAudioPublishMode(i);
    }

    public int adaptToSystemKaraoke(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "adaptToSystemKaraoke: %b", Boolean.valueOf(z));
        return ThunderNative.adaptToSystemKaraoke(z);
    }

    public int setEnableInEarMonitor(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setEnableInEarMonitor: %b", Boolean.valueOf(z));
        return ThunderNative.enableInEarMonitor(z);
    }

    public int setEarMonitoringVolume(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setEarMonitoringVolume: %d", Integer.valueOf(i));
        return ThunderNative.setEarMonitoringVolume(i);
    }

    @Deprecated
    public int enableVideoEngine() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableVideoEngine ");
        return 0;
    }

    @Deprecated
    public int disableVideoEngine() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "disableVideoEngine ");
        return 0;
    }

    public int setVideoEncoderConfig(ThunderVideoEncoderConfiguration thunderVideoEncoderConfiguration) {
        if (thunderVideoEncoderConfiguration == null) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setVideoEncoderConfig null params");
            return -13;
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setVideoEncoderConfig, playType %d, publishMode %d", Integer.valueOf(thunderVideoEncoderConfiguration.playType), Integer.valueOf(thunderVideoEncoderConfiguration.publishMode));
        return ThunderNative.setVideoEncoderConfig(thunderVideoEncoderConfiguration);
    }

    public int setLocalVideoCanvas(ThunderVideoCanvas thunderVideoCanvas) {
        if (thunderVideoCanvas == null) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setLocalVideoCanvas null canvas");
            return -13;
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setLocalVideoCanvas view:%s, renderMode:%d, uid:%s, seatIndex:%d", getPrintString(thunderVideoCanvas.mView), Integer.valueOf(thunderVideoCanvas.mRenderMode), thunderVideoCanvas.mUid, Integer.valueOf(thunderVideoCanvas.mSeatIndex));
        return ThunderNative.setLocalVideoCanvas(thunderVideoCanvas.mView, thunderVideoCanvas.mRenderMode);
    }

    public int setRemotePlayType(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRemotePlayType %d", Integer.valueOf(i));
        return 0;
    }

    public int setRemoteVideoCanvas(ThunderVideoCanvas thunderVideoCanvas) {
        if (thunderVideoCanvas == null) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRemoteVideoCanvas null canvas");
            return -13;
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRemoteVideoCanvas view:%s, renderMode:%d, uid:%s, mSeatIndex:%d", getPrintString(thunderVideoCanvas.mView), Integer.valueOf(thunderVideoCanvas.mRenderMode), thunderVideoCanvas.mUid, Integer.valueOf(thunderVideoCanvas.mSeatIndex));
        return ThunderNative.setRemoteVideoCanvas(thunderVideoCanvas.mView, thunderVideoCanvas.mRenderMode, thunderVideoCanvas.mUid, thunderVideoCanvas.mSeatIndex);
    }

    public int setLocalCanvasScaleMode(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setLocalCanvasScaleMode mode: %d", Integer.valueOf(i));
        return ThunderNative.setLocalVideoCanvasMode(i);
    }

    public int setRemoteCanvasScaleMode(String str, int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRemoteCanvasScaleMode uid: %s, mode: %d", str, Integer.valueOf(i));
        return ThunderNative.setRemoteVideoCanvasMode(str, i, 0);
    }

    public int setRemoteCanvasMode(String str, int i, int i2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRemoteCanvasMode uid: %s, renderMode: %d, mirrorMode: %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        return ThunderNative.setRemoteVideoCanvasMode(str, i, i2);
    }

    public int startVideoPreview() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "startVideoPreview");
        return ThunderNative.startPreview(true);
    }

    public int stopVideoPreview() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopVideoPreview");
        return ThunderNative.startPreview(false);
    }

    public int startLocalVideoPreview() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "startLocalVideoPreview");
        return ThunderNative.startLocalVideoPreview(true);
    }

    public int stopLocalVideoPreview() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopLocalVideoPreview");
        return ThunderNative.startLocalVideoPreview(false);
    }

    public int enableLocalVideoCapture(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableLocalVideoCapture %b", Boolean.valueOf(z));
        return ThunderNative.startVideoCapture(z);
    }

    public int stopLocalVideoStream(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopLocalVideoStream: %b", Boolean.valueOf(z));
        if (z) {
            return ThunderNative.startVideoEncode(false) | ThunderNative.startPushVideoStream(false);
        }
        int startVideoEncode = ThunderNative.startVideoEncode(true);
        if (startVideoEncode == 0) {
            int startPushVideoStream = ThunderNative.startPushVideoStream(true);
            if (startPushVideoStream != 0) {
                ThunderNative.startVideoEncode(false);
                return startPushVideoStream;
            }
            return startPushVideoStream;
        }
        return startVideoEncode;
    }

    public int stopRemoteVideoStream(String str, boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopRemoteVideoStream Uid: %s, stop: %b", str, Boolean.valueOf(z));
        return ThunderNative.stopRemoteVideoStream(str, z);
    }

    public int stopAllRemoteVideoStreams(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopAllRemoteVideoStreams  stop: %b", Boolean.valueOf(z));
        return ThunderNative.stopAllRemoteStreams(true, z);
    }

    public int enableLocalDualStreamMode(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableLocalDualStreamMode  enbaled:%b", Boolean.valueOf(z));
        return ThunderNative.enableLocalDualStreamMode(z);
    }

    public int setDefaultRemoteVideoStreamType(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setDefaultRemoteVideoStreamType  type:" + i);
        return ThunderNative.setDefaultRemoteVideoStreamType(i);
    }

    public int changeRemoteVideoStreamType(String str, int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "changeRemoteVideoStreamType: UID:" + str + " type:" + i);
        return ThunderNative.changeRemoteVideoStreamType(str, i);
    }

    public int switchUserRole(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "switchUserRole: role:" + i);
        return ThunderNative.switchUserRole(i);
    }

    public int registerVideoCaptureTextureObserver(IGPUProcess iGPUProcess) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "registerVideoCaptureTextureObserver");
        ThunderBridgeLib.getInstance().setGPUImageProcessFilter(iGPUProcess);
        return 0;
    }

    public int registerVideoCaptureTextureFrameObserver(VideoTextureFrameObserver videoTextureFrameObserver) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "registerVideoCaptureTextureObserver");
        VideoFrameTextrue.getInstance().enableVideoTextrue(videoTextureFrameObserver);
        return 0;
    }

    public int registerVideoCaptureFrameObserver(IVideoCaptureObserver iVideoCaptureObserver) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "registerVideoCaptureFrameObserver");
        VideoFrameYuvCapture.getInstance().enableVideoCapture(iVideoCaptureObserver);
        return 0;
    }

    public int registerVideoDecodeFrameObserver(String str, IVideoDecodeObserver iVideoDecodeObserver) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "registerVideoDecodeFrameObserver uid %s, %s", str, iVideoDecodeObserver);
        return ThunderNative.setVideoFrameObserver(str, iVideoDecodeObserver);
    }

    public int registerAudioFrameObserver(IAudioFrameObserver iAudioFrameObserver) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "registerAudioFrameObserver " + iAudioFrameObserver);
        ThunderNative.registerAudioFrameObserver(iAudioFrameObserver);
        return 0;
    }

    public int registerAudioEncodedFrameObserver(IAudioEncodedFrameObserver iAudioEncodedFrameObserver) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "registerAudioEncodedFrameObserver " + iAudioEncodedFrameObserver);
        return ThunderNative.registerAudioEncodedFrameObserver(iAudioEncodedFrameObserver);
    }

    public int setRecordingAudioFrameParameters(int i, int i2, int i3, int i4) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setRecordingAudioFrameParameters sampleRate %d, channel %d, mode %d, samplesPerCall %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        return ThunderNative.setRecordingAudioFrameParameters(i, i2, i3, i4);
    }

    public int setPlaybackAudioFrameParameters(int i, int i2, int i3, int i4) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setPlaybackAudioFrameParameters sampleRate %d, channel %d, mode %d, samplesPerCall %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        return ThunderNative.setPlaybackAudioFrameParameters(i, i2, i3, i4);
    }

    public int setMixedAudioFrameParameters(int i, int i2, int i3) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setMixedAudioFrameParameters sampleRate %d, channel %d, samplesPerCall %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        return ThunderNative.setMixedAudioFrameParameters(i, i2, i3);
    }

    public int setVideoWatermark(ThunderBoltImage thunderBoltImage) {
        if (thunderBoltImage != null && (thunderBoltImage.height <= 0 || thunderBoltImage.width <= 0 || thunderBoltImage.width > 1920 || thunderBoltImage.height > 1920 || thunderBoltImage.x < 0 || thunderBoltImage.y < 0)) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setVideoWatermark invalid params, x %d, y %d, w %d, h %d ", Integer.valueOf(thunderBoltImage.x), Integer.valueOf(thunderBoltImage.y), Integer.valueOf(thunderBoltImage.width), Integer.valueOf(thunderBoltImage.height));
            return -13;
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setVideoWatermark");
        return ThunderNative.setPubWatermark(thunderBoltImage);
    }

    public int setCustomAudioSource(boolean z, int i, int i2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setCustomAudioSource enable %b, sampleRate %d, channel %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        return ThunderNative.setCustomAudioSource(z, i, i2);
    }

    public int pushCustomAudioFrame(byte[] bArr, long j) {
        if (bArr == null || bArr.length == 0) {
            return -13;
        }
        return ThunderNative.pushCustomAudioFrame(bArr, j);
    }

    public int setCustomVideoSource(ThunderCustomVideoSource thunderCustomVideoSource) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setCustomVideoSource");
        if (ThunderNative.getUserRole() != 1) {
            ThunderLog.warn(ThunderLog.kLogTagRtcEngine, "setCustomVideoSource not anchor");
            return -31;
        } else if (thunderCustomVideoSource == null || (thunderCustomVideoSource instanceof ThunderDefaultCamera)) {
            if (thunderCustomVideoSource != null) {
                return ThunderNative.attachVideoCapture(thunderCustomVideoSource, 0);
            }
            return ThunderNative.attachVideoCapture(mPublisher.getDefaluteCamera(), 0);
        } else if (thunderCustomVideoSource instanceof ScreenRecordSource) {
            return ThunderNative.attachVideoCapture(((ScreenRecordSource) thunderCustomVideoSource).mScreenCapture, 1);
        } else {
            if (this.mExternalVideoSource == null || !this.mExternalVideoSource.equals(thunderCustomVideoSource)) {
                this.mExternalVideoSource = new ExternalVideoSource(thunderCustomVideoSource);
                if (thunderCustomVideoSource instanceof ThunderExternalVideoSource) {
                    this.mExternalVideoSource.setVideoBufferType(((ThunderExternalVideoSource) thunderCustomVideoSource).getThunderVideoBufferType());
                }
            }
            return ThunderNative.attachVideoCapture(this.mExternalVideoSource, 2);
        }
    }

    public int addPublishOriginStreamUrl(String str) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "addPublishOriginStreamUrl %s", str);
        return ThunderNative.updatePublishOriginStreamUrl(true, str);
    }

    public int removePublishOriginStreamUrl(String str) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "removePublishOriginStreamUrl %s", str);
        return ThunderNative.updatePublishOriginStreamUrl(false, str);
    }

    public int addPublishTranscodingStreamUrl(String str, String str2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "addPublishTranscodingStreamUrl taskId %s, url %s", str, str2);
        return ThunderNative.updatePublishTranscodingStreamUrl(str, true, str2);
    }

    public int removePublishTranscodingStreamUrl(String str, String str2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "removePublishTranscodingStreamUrl taskId %s, url %s", str, str2);
        return ThunderNative.updatePublishTranscodingStreamUrl(str, false, str2);
    }

    public int setLiveTranscodingTask(String str, LiveTranscoding liveTranscoding) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setLiveTranscodingTask taskId %s", str);
        return ThunderNative.setLiveTranscodingTask(str, liveTranscoding);
    }

    public int removeLiveTranscodingTask(String str) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "removeLiveTranscodingTask taskId %s", str);
        return ThunderNative.removeLiveTranscodingTask(str);
    }

    public int addSubscribe(String str, String str2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "addSubscribe roomId %s, uid %s", str, str2);
        return ThunderNative.subscribeUser(true, str, str2);
    }

    public int removeSubscribe(String str, String str2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "removeSubscribe roomId %s, uid %s", str, str2);
        return ThunderNative.subscribeUser(false, str, str2);
    }

    public int subscribeRoom(String str) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "subscribeRoom roomId %s", str);
        return ThunderNative.subscribeRoom(true, str);
    }

    public int unsubscribeRoom(String str) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "unsubscribeRoom roomId %s", str);
        return ThunderNative.subscribeRoom(false, str);
    }

    public int switchFrontCamera(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "switchFrontCamera %b", Boolean.valueOf(z));
        return ThunderNative.switchFrontCamera(z);
    }

    public boolean isCameraOpen() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isCameraOpen");
        return ThunderNative.isCameraOpen();
    }

    public boolean isFrontCamera() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isFrontCamera");
        return ThunderNative.isFrontCamera();
    }

    public boolean isCameraFocusSupported() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isCameraFocusSupported");
        return ThunderNative.isCameraManualFocusPositionSupported();
    }

    public boolean isCameraExposurePositionSupported() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isCameraExposurePositionSupported");
        return ThunderNative.isCameraManualExposurePositionSupported();
    }

    public boolean isCameraZoomSupported() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isCameraZoomSupported");
        return ThunderNative.isCameraZoomSupported();
    }

    public float getCameraMaxZoomFactor() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "getCameraMaxZoomFactor");
        return ThunderNative.getCameraMaxZoomFactor();
    }

    public int setCameraZoomFactor(float f) {
        return ThunderNative.setCameraZoomFactor(f);
    }

    public boolean isCameraTorchSupported() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isCameraTorchSupported");
        return ThunderNative.isCameraTorchSupported();
    }

    public int setCameraTorchOn(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setCameraTorchOn %b", Boolean.valueOf(z));
        return ThunderNative.setCameraTorchOn(z);
    }

    public int setCameraFocusPositionInPreview(float f, float f2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setCameraFocusPositionInPreview");
        return ThunderNative.setCameraFocusPosition(f, f2);
    }

    public int setCameraExposurePosition(float f, float f2) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setCameraExposurePosition");
        return ThunderNative.setCameraExposurePosition(f, f2);
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isCameraAutoFocusFaceModeSupported");
        return ThunderNative.isCameraAutoFocusFaceModeSupported();
    }

    public int setCameraAutoFocusFaceModeEnabled(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setCameraAutoFocusFaceModeEnabled %b", Boolean.valueOf(z));
        return ThunderNative.setCameraAutoFocusFaceModeEnabled(z);
    }

    public int getVideoCaptureOrientation() {
        return ThunderNative.getOrientation();
    }

    public int setVideoCaptureOrientation(int i) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setVideoCaptureOrientation orientation %d", Integer.valueOf(i));
        return ThunderNative.setOrientation(i);
    }

    public int setLocalVideoMirrorMode(int i) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "setLocalVideoMirrorMode %d", Integer.valueOf(i));
        }
        return ThunderNative.setLocalVideoMirrorMode(i);
    }

    public int enableHowlingDetector(Boolean bool) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableHowlingDetector %b", bool);
        return ThunderNative.enableHowlingDetector(bool.booleanValue());
    }

    public int enableEchoDetector(Boolean bool) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableEchoDetector %b", bool);
        return ThunderNative.enableEchoDetector(bool.booleanValue());
    }

    public int startInputDeviceTest() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "startInputDeviceTest");
        return ThunderNative.startInputDeviceTest();
    }

    public int stopInputDeviceTest() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopInputDeviceTest");
        return ThunderNative.stopInputDeviceTest();
    }

    public int startOutputDeviceTest(String str) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "startOutputDeviceTest");
        return ThunderNative.startOutputDeviceTest(str);
    }

    public int stopOutputDeviceTest() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "stopOutputDeviceTest");
        return ThunderNative.stopOutputDeviceTest();
    }

    public int enableMicDenoise(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableMicDenoise %b", Boolean.valueOf(z));
        return ThunderNative.enableMicDenoise(z);
    }

    public boolean isMicDenoiseEnabled() {
        boolean micDenoiseEnabled = ThunderNative.micDenoiseEnabled();
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "isMicDenoiseEnabled %b", Boolean.valueOf(micDenoiseEnabled));
        return micDenoiseEnabled;
    }

    public int enableAGC(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableAGC %b", Boolean.valueOf(z));
        return ThunderNative.enableAGC(z);
    }

    public int enableAIDenoise(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "enableAIDenoise %b", Boolean.valueOf(z));
        return ThunderNative.enableAIDenoise(z);
    }

    public int setMultiVideoViewLayout(ThunderMultiVideoViewParam thunderMultiVideoViewParam) {
        if (thunderMultiVideoViewParam != null) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setMultiVideoViewLayout mViewId:%d, view:%s, BitMap:%s, coordinate:%s", Integer.valueOf(thunderMultiVideoViewParam.mViewId), getPrintString(thunderMultiVideoViewParam.mView), getPrintString(thunderMultiVideoViewParam.mBgBitmap), getPrintString(thunderMultiVideoViewParam.mBgViewPosition));
            return ThunderNative.initMultiPlayerViewLayout(thunderMultiVideoViewParam, thunderMultiVideoViewParam.mViewId, thunderMultiVideoViewParam.mView);
        }
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setMultiVideoViewLayout null");
        return -13;
    }

    public Bitmap captureRemoteScreenShot(String str) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "captureRemoteScreenShot uid: %b", str);
        return ThunderNative.captureRemoteScreenShot(str);
    }

    public int setCaptureReplaceImage(Bitmap bitmap) {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "setCaptureReplaceImage");
        return ThunderNative.setCaptureReplaceImage(bitmap);
    }

    public Bitmap captureLocalScreenShot() {
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "captureLocalScreenShot");
        return ThunderNative.captureLocalScreenShot();
    }

    public ThunderVideoEncodeParam getVideoEncoderParam(ThunderVideoEncoderConfiguration thunderVideoEncoderConfiguration) {
        if (thunderVideoEncoderConfiguration == null) {
            ThunderLog.release(ThunderLog.kLogTagRtcEngine, "getVideoEncoderParam null params");
            return null;
        }
        ThunderVideoEncodeParam videoEncoderParamByGear = ThunderNative.getVideoEncoderParamByGear(thunderVideoEncoderConfiguration.playType, thunderVideoEncoderConfiguration.publishMode);
        ThunderLog.release(ThunderLog.kLogTagRtcEngine, "getVideoEncoderParam playType %d, publishMode %d", Integer.valueOf(thunderVideoEncoderConfiguration.playType), Integer.valueOf(thunderVideoEncoderConfiguration.publishMode));
        return videoEncoderParamByGear;
    }

    public static ThunderDefaultCamera getDefaluteCamera() {
        if (mPublisher != null) {
            return mPublisher.getDefaluteCamera();
        }
        return null;
    }

    private void resetRtcEngine() {
        mHandler = null;
        mRtcEventHandler = null;
        mHttpsRequestHandler = null;
        s_captureVolumeNotifyCount = 0;
        s_playVolumeNotifyCount = 0;
        s_playDataNotifyCount = 0;
        s_audioPlaySpectrumCount = 0;
        if (mPublisher.getDefaluteCamera() != null) {
            ThunderPreviewConfig thunderPreviewConfig = (ThunderPreviewConfig) mPublisher.getDefaluteCamera().getCaptureConfig();
            thunderPreviewConfig.cameraPosition = 0;
            thunderPreviewConfig.captureOrientation = 0;
        }
        mPublisher = null;
        mThunderMediaExtraInfoCallback = null;
        if (mNetStateService != null) {
            mNetStateService.fini();
        }
        if (mForeBackgroundListener != null) {
            mForeBackgroundListener.fini();
        }
        mNetStateService = null;
        mForeBackgroundListener = null;
    }

    private void cleanAllAudioFilePlayer() {
        for (ThunderAudioFilePlayer thunderAudioFilePlayer : this.mAudioFilePlayerSet) {
            thunderAudioFilePlayer.destroyAudioFilePlayer();
        }
        this.mAudioFilePlayerSet.clear();
    }

    private String getPrintString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private String getPrintString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        return bArr.toString();
    }

    private String getPrintString(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }
}
