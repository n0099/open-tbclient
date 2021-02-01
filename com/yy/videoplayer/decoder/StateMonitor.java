package com.yy.videoplayer.decoder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
import com.yy.videoplayer.Constant;
import com.yy.videoplayer.VideoPlayer;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.stat.YMFPlayerStatisticManager;
import com.yy.videoplayer.stat.YMFPlayerUsrBehaviorStat;
import com.yy.videoplayer.utils.YMFLog;
import com.yy.videoplayer.view.YMFVideoPosition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class StateMonitor implements Runnable {
    private static final int DEC_TYPE_H264_HW_OFFSCREEEN = 0;
    private static final int DEC_TYPE_H264_SW_FFMPEG = 2;
    private static final int DEC_TYPE_H265_HW_OFFSCREEEN = 1;
    private static final int DEC_TYPE_H265_SW_ITTIAM = 3;
    private static final int DEC_TYPE_VP8_SW_DECVP8 = 4;
    private static final int MSG_ADD_DECODER = 1;
    private static final int MSG_ADD_RENDER = 3;
    private static final int MSG_ADD_VIEW = 5;
    private static final int MSG_DECODE_LATENCY = 27;
    private static final int MSG_DEC_OUT_FRAMERATE = 13;
    private static final int MSG_DEL_DECODER = 2;
    private static final int MSG_DEL_RENDER = 4;
    private static final int MSG_DEL_VIEW = 6;
    private static final int MSG_FIRST_FRAME_ARRIVE = 10;
    private static final int MSG_FIRST_FRAME_RENDER = 12;
    private static final int MSG_FRAMERATE = 24;
    private static final int MSG_IS_BLUE_RAY_STATISTIC = 21;
    private static final int MSG_LAST_FRAME_NOT_RENDER_STATISTIC = 19;
    private static final int MSG_LOST_RENDER_FRAME_STATISTIC = 20;
    private static final int MSG_MULTIVIDEO_ORIGIN_POSITION = 17;
    private static final int MSG_MULTIVIDEO_SURFACE_CHANGE_POSITION = 18;
    private static final int MSG_NotifyPts = 15;
    private static final int MSG_Notify_Clear_Pts = 16;
    private static final int MSG_Notify_ViewState = 26;
    private static final int MSG_QUIT = 0;
    private static final int MSG_RENDER_FRAMERATE = 11;
    private static final int MSG_RESOLUTION = 14;
    private static final int MSG_SET_BITRATE_STATISTIC = 22;
    private static final int MSG_SET_DECODE_DELAY_FRAME_COUNT_STATISTIC = 23;
    private static final int MSG_STREAM_END = 8;
    private static final int MSG_STREAM_START = 7;
    private static final int MSG_TRANS_FRAMERATE = 9;
    private static final int MSG_VIDEOPLAYER_BITRATE = 25;
    private static final String TAG = "[StateMonitor]";
    private static final int mStaticsCycle = 10;
    private StateMonitorHandler mHandler;
    private static StateMonitor mInstance = null;
    private static final byte[] SYNC_FLAG = new byte[1];
    public static boolean mOnlyDeconded = false;
    private AtomicBoolean mReady = new AtomicBoolean(false);
    public int mCurrentFps = 0;
    public String mCurrentDecoderType = "";
    public int mCurrentWidth = 0;
    public int mCurrentHeight = 0;
    private HashMap<Long, PlayerState> mPlayerStateMap = new HashMap<>();

    /* loaded from: classes4.dex */
    public interface DecoderType {
        public static final int DEFAULT = -1;
        public static final int HARD_DECODER_H264 = 1;
        public static final int HARD_DECODER_H265 = 3;
        public static final int SOFT_DECODER_H264 = 0;
        public static final int SOFT_DECODER_H265 = 2;
        public static final int SOFT_DECODER_VP8 = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class streamInfo {
        int bHardDecoder;
        int fps;
        long mGroupId;
        long mStreamId;
        int micPos;
        int vType;

        private streamInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class MutiVideoPositionInfo {
        YMFVideoPosition backgroundPosition;
        YMFVideoPosition[] videoPositions;

        private MutiVideoPositionInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class frameRateInfo {
        int mFrameRate;
        int mFrameRateDecoder;
        long mStreamId;

        private frameRateInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class DecodeLatencyInfo {
        int latency;
        long mStreamId;

        private DecodeLatencyInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class FramePtsInfo {
        long mStreamId;
        long pts;

        private FramePtsInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class ViewStateInfo {
        long mStreamId;
        int viewState;

        private ViewStateInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class resolutionInfo {
        int mHeight;
        long mStreamId;
        int mWidth;

        private resolutionInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class VideoPlayerBitRateInfo {
        int mBitRate;
        long mStreamId;

        private VideoPlayerBitRateInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class LostRenderInfo {
        float mFrameRate;
        long mStreamId;

        private LostRenderInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class BlueRayInfo {
        int mIsBlueRay;
        long mStreamId;

        private BlueRayInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class BitRateInfo {
        String mBitRate;
        long mStreamId;

        private BitRateInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class DecodeDelayFrameInfo {
        int mCount;
        long mStreamId;

        private DecodeDelayFrameInfo() {
        }
    }

    /* loaded from: classes4.dex */
    private class RenderTimeInfo {
        String mRenderMaxTime;
        String mRenderTime;
        long mStreamId;

        private RenderTimeInfo() {
        }
    }

    public static void NotifyCreateDecoder(long j, int i, long j2) {
        String str = RomUtils.UNKNOWN;
        switch (i) {
            case 0:
                str = "DEC_TYPE_H264_HW_OFFSCREEEN";
                break;
            case 1:
                str = "DEC_TYPE_H265_HW_OFFSCREEEN";
                break;
            case 2:
                str = "DEC_TYPE_H264_SW_FFMPEG";
                break;
            case 3:
                str = "DEC_TYPE_H265_SW_ITTIAM";
                break;
            case 4:
                str = "DEC_TYPE_VP8_SW_DECVP8";
                break;
        }
        instance().addDecoder(j, i, str, j2);
        YMFPlayerStatisticManager.getInstance().setVideoDecodeId(j, i);
        YMFPlayerUsrBehaviorStat.getInstance().notifyVideoDecoderIdState(j, wrapperLocalDecodeId2HiidoDecodeId(i), true);
    }

    private static int wrapperLocalDecodeId2HiidoDecodeId(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 3;
            case 2:
                return 0;
            case 3:
                return 2;
            case 4:
                return 4;
            default:
                return -1;
        }
    }

    public static void NotifyReleaseDecoder(long j) {
        instance().removeDecoder(j);
    }

    public static void NotifyVideoStreamStart(long j, long j2, int i, int i2, int i3, int i4) {
        instance().streamStart(j, j2, i, i2, i3, i4);
    }

    public static void NotifyVideoStreamEnd(long j) {
        instance().streamEnd(j);
    }

    public static void NotifyCreateRender(long j, int i) {
        String str = RomUtils.UNKNOWN;
        switch (i) {
            case 0:
                str = "MediaCodec-H264DecRender";
                break;
            case 1:
                str = "MediaCodec-H265DecRender";
                break;
            case 2:
                str = "RenderFramebuffer";
                break;
            case 3:
                str = "Canvas";
                break;
            case 4:
                str = "YMFRender";
                break;
        }
        instance().addRender(j, i, str);
    }

    public static void NotifyReleaseRender(long j) {
        instance().removeRender(j);
    }

    public static void NotifyDecoderFrameRate(long j, int i, int i2) {
        instance().NotifyFrameRate(j, i, i2);
    }

    public static void NotifyDecoderFrameRateOUT(long j, int i) {
        instance().notifyDecoderFrameRateO(j, i);
    }

    public static void notifyDecoderLatency(long j, int i) {
        instance().notifyDecoderLatencyState(j, i);
    }

    public static void NotifyViewState(long j, int i) {
        instance().notifyViewState(j, i);
    }

    public static void NotifyPts(long j, long j2) {
        instance().notifyPts(j, j2);
    }

    public static void NotifyClearPts(long j) {
        instance().notifyClearPts(j);
    }

    public static void NotifyFirstFrameArrived(long j, long j2) {
        instance().notifyFirstFrameArrived(j, j2);
    }

    public static void NotifyFirstFrameRendered(long j, long j2) {
        instance().notifyFirstFrameRendered(j, j2);
    }

    public void NotifyRenderFrameRate(long j, int i) {
        instance().notifyRenderFrameRate(j, i);
    }

    public static void NotifyResolution(long j, int i, int i2) {
        instance().notifyResolution(j, i, i2);
    }

    public static void NotifyDecodeTime(long j, long j2) {
        YMFPlayerStatisticManager.getInstance().setDecodeVideoMaxLatency(j, j2);
    }

    public static void NotifyIsSvcData() {
    }

    public static void NotifyVideoPlayerBitrate(long j, int i) {
        instance().notifyVideoPlayerBitrate(j, i);
    }

    public static void NotifyDecodeException(String str) {
        YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerException(str);
    }

    public static void NotifyRenderLostRate(long j, float f) {
        instance().notifyRenderLostRate(j, f);
    }

    public static void NotifyBlueRayInfo(long j, int i) {
        instance().notifyBlueRayInfo(j, i);
    }

    public static void NotifyBiteRateInfo(long j, int i) {
        instance().notifyBiteRateInfo(j, i + "");
    }

    public void NotifyDecodeDelayFrameCountInfo(long j, int i) {
        instance().notifyDecodeDelayFrameCountInfo(j, i);
    }

    public static void NotifyMultiVideoOriginPosition(YMFVideoPosition[] yMFVideoPositionArr, YMFVideoPosition yMFVideoPosition) {
        instance().notifyMultiVideoOriginPosition(yMFVideoPositionArr, yMFVideoPosition);
    }

    public static void NotifyMultiVideoSurfaceChangePosition(YMFVideoPosition[] yMFVideoPositionArr, YMFVideoPosition yMFVideoPosition) {
        instance().notifyMultiVideoSurfaceChangePosition(yMFVideoPositionArr, yMFVideoPosition);
    }

    public static void NotifyResetStatistic(long j, int i) {
        YMFPlayerStatisticManager.getInstance().setResetStatistic(j, i);
    }

    public static StateMonitor instance() {
        if (mInstance == null) {
            synchronized (SYNC_FLAG) {
                if (mInstance == null) {
                    mInstance = new StateMonitor();
                }
            }
        }
        return mInstance;
    }

    public static void NotifyLastFrameNotRenderStatistic(long j, int i) {
        instance().notifyLastFrameNotRenderStatistic(j, i);
    }

    public StateMonitor() {
        InitThread();
    }

    public void init() {
        YMFLog.info(this, Constant.MEDIACODE_STAT, "Init.");
    }

    public void deInit() {
    }

    private void InitThread() {
        Thread thread = new Thread(this);
        thread.setName("YYVideoLib-StateMonitor");
        synchronized (SYNC_FLAG) {
            thread.start();
        }
        YMFLog.info(this, Constant.MEDIACODE_STAT, "construct done.");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Looper.prepare();
            this.mHandler = new StateMonitorHandler();
            this.mReady.set(true);
            Looper.loop();
            this.mReady.set(false);
        } catch (Throwable th) {
            try {
                YMFLog.error(this, Constant.MEDIACODE_STAT, "end looper exception:" + th.getMessage() + " " + th.toString());
                th.printStackTrace();
            } finally {
                YMFLog.info(this, Constant.MEDIACODE_STAT, "end!!!");
                deInit();
            }
        }
    }

    private PlayerState getPlayerState(long j) {
        if (this.mPlayerStateMap.containsKey(Long.valueOf(j))) {
            return this.mPlayerStateMap.get(Long.valueOf(j));
        }
        YMFLog.warn(this, Constant.MEDIACODE_STAT, "new PlayerState, streamId:" + j);
        PlayerState playerState = new PlayerState(j);
        this.mPlayerStateMap.put(Long.valueOf(j), playerState);
        return playerState;
    }

    private void removePlayerState(long j) {
        if (this.mPlayerStateMap.containsKey(Long.valueOf(j))) {
            YMFLog.warn(this, Constant.MEDIACODE_STAT, "remove PlayerState, streamId:" + j);
            this.mPlayerStateMap.remove(Long.valueOf(j));
        }
    }

    private void notifyRenderLostRate(long j, float f) {
        if (this.mReady.get() && this.mHandler != null) {
            LostRenderInfo lostRenderInfo = new LostRenderInfo();
            lostRenderInfo.mStreamId = j;
            lostRenderInfo.mFrameRate = f;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(20, lostRenderInfo));
        }
    }

    private void notifyBlueRayInfo(long j, int i) {
        if (this.mReady.get() && this.mHandler != null) {
            BlueRayInfo blueRayInfo = new BlueRayInfo();
            blueRayInfo.mStreamId = j;
            blueRayInfo.mIsBlueRay = i;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(21, blueRayInfo));
        }
    }

    private void notifyBiteRateInfo(long j, String str) {
        if (this.mReady.get() && this.mHandler != null) {
            BitRateInfo bitRateInfo = new BitRateInfo();
            bitRateInfo.mStreamId = j;
            bitRateInfo.mBitRate = str;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(22, bitRateInfo));
        }
    }

    private void notifyDecodeDelayFrameCountInfo(long j, int i) {
        if (this.mReady.get() && this.mHandler != null) {
            DecodeDelayFrameInfo decodeDelayFrameInfo = new DecodeDelayFrameInfo();
            decodeDelayFrameInfo.mStreamId = j;
            decodeDelayFrameInfo.mCount = i;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(23, decodeDelayFrameInfo));
        }
    }

    private void notifyResolution(long j, int i, int i2) {
        if (this.mReady.get() && this.mHandler != null) {
            resolutionInfo resolutioninfo = new resolutionInfo();
            resolutioninfo.mStreamId = j;
            resolutioninfo.mWidth = i;
            resolutioninfo.mHeight = i2;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(14, resolutioninfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResolution(long j, int i, int i2) {
        DecoderState decoderState;
        PlayerState playerState = getPlayerState(j);
        if (playerState == null || (decoderState = playerState.mDecoderState) == null) {
            return;
        }
        decoderState.mWidth = i;
        decoderState.mHeight = i2;
        YMFPlayerStatisticManager.getInstance().setDecodeOutputWidth(j, i);
        YMFPlayerStatisticManager.getInstance().setDecodeOutputHeight(j, i2);
        VideoPlayer.getInstance().pushVideoPlayerInfo(j, i, i2, -1, -1, -1);
        YMFLog.warn(this, "[Decoder ]", "streamId:" + j + " Resolution:" + decoderState.mWidth + Config.EVENT_HEAT_X + decoderState.mHeight);
    }

    private void notifyVideoPlayerBitrate(long j, int i) {
        if (this.mReady.get() && this.mHandler != null) {
            VideoPlayerBitRateInfo videoPlayerBitRateInfo = new VideoPlayerBitRateInfo();
            videoPlayerBitRateInfo.mStreamId = j;
            videoPlayerBitRateInfo.mBitRate = i;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(25, videoPlayerBitRateInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoPlayerBitrate(long j, int i) {
        DecoderState decoderState;
        PlayerState playerState = getPlayerState(j);
        if (playerState == null || (decoderState = playerState.mDecoderState) == null) {
            return;
        }
        decoderState.mBitrate = i;
        VideoPlayer.getInstance().pushVideoPlayerInfo(j, -1, -1, -1, i, -1);
        YMFLog.warn(this, "[Decoder ]", "streamId:" + j + " bitrate:" + i);
    }

    private void notifyFirstFrameArrived(long j, long j2) {
        if (this.mReady.get() && this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(10, new StreamTimeInfo(j, j2)));
        }
    }

    private void notifyFirstFrameRendered(long j, long j2) {
        PlayerState playerState;
        if (!this.mReady.get() || this.mHandler == null || (playerState = getPlayerState(j)) == null) {
            return;
        }
        playerState.mFirstFrameRendedTime = j2;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(12, Long.valueOf(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNofityFirstFrameRendered(long j) {
        DecoderState decoderState;
        PlayerState playerState = getPlayerState(j);
        if (playerState == null || (decoderState = playerState.mDecoderState) == null) {
            return;
        }
        playerState.mFirstFrameRendered = true;
        YMFLog.warn(this, "[Decoder ]", "streamId:" + j + " First Frame Rendered. firstArrive - createDecoder " + (playerState.mFirstFrameArrivedTime - decoderState.mCreateDecoderTime) + " firstRender - createDecoder:" + (playerState.mFirstFrameRendedTime - decoderState.mCreateDecoderTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNotifyFirstFrameArrive(StreamTimeInfo streamTimeInfo) {
        PlayerState playerState = getPlayerState(streamTimeInfo.mStreamId);
        if (playerState == null) {
            return;
        }
        playerState.mFirstFrameArrivedTime = streamTimeInfo.mTimeStamp;
        playerState.mFristFrameArrived = true;
        YMFLog.warn(this, "[Decoder ]", "streamId:" + streamTimeInfo.mStreamId + " First Frame Arrived . " + playerState.mFristFrameArrived);
    }

    private void notifyDecoderFrameRateO(long j, int i) {
        if (this.mReady.get() && this.mHandler != null) {
            frameRateInfo framerateinfo = new frameRateInfo();
            framerateinfo.mStreamId = j;
            framerateinfo.mFrameRate = i;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(13, framerateinfo));
        }
    }

    private void notifyDecoderLatencyState(long j, int i) {
        if (this.mReady.get() && this.mHandler != null) {
            DecodeLatencyInfo decodeLatencyInfo = new DecodeLatencyInfo();
            decodeLatencyInfo.mStreamId = j;
            decodeLatencyInfo.latency = i;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(27, decodeLatencyInfo));
        }
    }

    private void notifyPts(long j, long j2) {
        if (this.mReady.get() && this.mHandler != null) {
            FramePtsInfo framePtsInfo = new FramePtsInfo();
            framePtsInfo.mStreamId = j;
            framePtsInfo.pts = j2;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(15, framePtsInfo));
        }
    }

    private void notifyViewState(long j, int i) {
        if (this.mReady.get() && this.mHandler != null) {
            ViewStateInfo viewStateInfo = new ViewStateInfo();
            viewStateInfo.mStreamId = j;
            viewStateInfo.viewState = i;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(26, viewStateInfo));
        }
    }

    private void notifyClearPts(long j) {
        if (this.mReady.get() && this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(16, Long.valueOf(j)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDecoderFrameRateO(long j, int i) {
        DecoderState decoderState;
        PlayerState playerState = getPlayerState(j);
        if (playerState == null || (decoderState = playerState.mDecoderState) == null) {
            return;
        }
        List list = decoderState.mFrameOList;
        if (list != null) {
            list.add(Integer.valueOf(i));
        }
        YMFPlayerStatisticManager.getInstance().setDecodeOutputCount(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDecoderLatency(long j, int i) {
        YMFPlayerStatisticManager.getInstance().setDecodeLatency(j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePts(long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleViewState(long j, int i) {
        DecoderState decoderState;
        PlayerState playerState = getPlayerState(j);
        if (playerState == null || (decoderState = playerState.mDecoderState) == null) {
            return;
        }
        decoderState.mViewState = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClearPts(long j) {
    }

    private void notifyRenderFrameRate(long j, int i) {
        if (this.mReady.get() && this.mHandler != null) {
            frameRateInfo framerateinfo = new frameRateInfo();
            framerateinfo.mStreamId = j;
            framerateinfo.mFrameRate = i;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(11, framerateinfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRenderFrameRate(long j, int i) {
        String str;
        List list;
        YMFPlayerStatisticManager.getInstance().setRenderFrameCount(j, i);
        VideoPlayer.getInstance().pushVideoPlayerInfo(j, -1, -1, i, -1, -1);
        PlayerState playerState = getPlayerState(j);
        if (playerState != null) {
            this.mCurrentFps = i;
            if (playerState.mDecoderState == null) {
                str = "UNKOWN";
            } else {
                str = playerState.mDecoderState.mName;
            }
            this.mCurrentDecoderType = str;
            this.mCurrentWidth = playerState.mDecoderState != null ? (int) playerState.mDecoderState.mWidth : 0;
            this.mCurrentHeight = playerState.mDecoderState != null ? (int) playerState.mDecoderState.mHeight : 0;
            RenderState renderState = playerState.mRenderState;
            if (renderState != null && (list = renderState.mFrameRateList) != null) {
                list.add(Integer.valueOf(i));
            }
        }
    }

    private void NotifyFrameRate(long j, int i, int i2) {
        if (this.mReady.get() && this.mHandler != null) {
            frameRateInfo framerateinfo = new frameRateInfo();
            framerateinfo.mStreamId = j;
            framerateinfo.mFrameRate = i;
            framerateinfo.mFrameRateDecoder = i2;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(24, framerateinfo));
        }
    }

    private void PrintFrameRate(long j, String str, List<Integer> list) {
        if (list != null) {
            String str2 = " ";
            for (int i = 0; i < list.size(); i++) {
                str2 = str2 + list.get(i) + ",";
            }
            YMFLog.warn(this, "[Decoder ]", "streamId:" + j + " " + str + "[" + str2 + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTransInputFrameRate(long j, int i, int i2) {
        DecoderState decoderState;
        List<Integer> list;
        PlayerState playerState = getPlayerState(j);
        if (playerState == null || (decoderState = playerState.mDecoderState) == null) {
            return;
        }
        List<Integer> list2 = decoderState.mFrameIList;
        List list3 = decoderState.mFrameOList;
        if (list2 != null) {
            list2.add(Integer.valueOf(i));
            if (i2 != -1) {
                list3.add(Integer.valueOf(i2));
            }
            if (list2.size() >= 10) {
                PrintFrameRate(j, "TransfFrameRate", list2);
                list2.clear();
                List<Integer> list4 = decoderState.mFrameOList;
                if (list4 != null) {
                    PrintFrameRate(j, "DecOutFrameRate-" + decoderState.mViewState, list4);
                    list4.clear();
                }
                RenderState renderState = playerState.mRenderState;
                if (renderState != null && (list = renderState.mFrameRateList) != null) {
                    PrintFrameRate(j, "RenderFrameRate", list);
                    list.clear();
                }
            }
        }
    }

    private void addDecoder(long j, int i, String str, long j2) {
        if (this.mReady.get() && this.mHandler != null) {
            DecoderState decoderState = new DecoderState();
            decoderState.mStreamId = j;
            decoderState.mType = i;
            decoderState.mName = str;
            decoderState.mCreateDecoderTime = j2;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, decoderState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAddDecoder(long j, int i, String str, long j2) {
        DecoderState decoderState = new DecoderState();
        decoderState.mName = str;
        decoderState.mType = i;
        decoderState.mStreamId = j;
        decoderState.mCreateDecoderTime = j2;
        if (this.mPlayerStateMap.containsKey(Long.valueOf(j))) {
            this.mPlayerStateMap.get(Long.valueOf(j)).mDecoderState = null;
        }
        VideoPlayer.getInstance().pushVideoPlayerInfo(j, -1, -1, -1, -1, i);
        getPlayerState(j).mDecoderState = decoderState;
        YMFLog.warn(this, "[Decoder ]", "addDecoder, streamId:" + j + " Decoder:" + str + " type:" + i + " addDecoderTime:" + j2);
    }

    private void removeDecoder(long j) {
        if (this.mReady.get() && this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(2, Long.valueOf(j)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRemoveDecoder(long j) {
        PlayerState playerState;
        if (!this.mPlayerStateMap.containsKey(Long.valueOf(j)) || (playerState = this.mPlayerStateMap.get(Long.valueOf(j))) == null) {
            return;
        }
        DecoderState decoderState = playerState.mDecoderState;
        YMFPlayerUsrBehaviorStat.getInstance().notifyVideoDecoderIdState(j, decoderState.mType, false);
        if (decoderState != null) {
            YMFLog.warn(this, "[Decoder ]", "removeDecoder, streamId:" + j + " Decoder:" + decoderState.mName);
            playerState.mDecoderState = null;
        }
        if (playerState.mViewState == null && playerState.mRenderState == null) {
            VideoPlayer.getInstance().deleteVideoPlayerInfo(j);
            removePlayerState(j);
        }
    }

    private void addRender(long j, int i, String str) {
        if (this.mReady.get() && this.mHandler != null) {
            RenderState renderState = new RenderState();
            renderState.mName = str;
            renderState.mType = i;
            renderState.mStreamId = j;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, renderState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAddRender(long j, int i, String str) {
        RenderState renderState = new RenderState();
        renderState.mName = str;
        renderState.mType = i;
        renderState.mStreamId = j;
        if (this.mPlayerStateMap.containsKey(Long.valueOf(j))) {
            handlerPrintfFramRate(j);
            this.mPlayerStateMap.get(Long.valueOf(j)).mRenderState = null;
        }
        getPlayerState(j).mRenderState = renderState;
        YMFLog.warn(this, "[Render  ]", "addRender, streamId:" + j + " Render:" + str + " type:" + i + " (0-MediaCodec-H264DecRender 1.MediaCodec-H265DecRender 2-RenderFramebuffer 3-Canvas 4-YMFRender)");
    }

    private void removeRender(long j) {
        if (this.mReady.get() && this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(j)));
        }
    }

    private void handlerPrintfFramRate(long j) {
        PlayerState playerState;
        DecoderState decoderState;
        List<Integer> list;
        if (!this.mPlayerStateMap.containsKey(Long.valueOf(j)) || (playerState = this.mPlayerStateMap.get(Long.valueOf(j))) == null || (decoderState = playerState.mDecoderState) == null) {
            return;
        }
        List<Integer> list2 = decoderState.mFrameIList;
        PrintFrameRate(j, "TransfFrameRate", list2);
        list2.clear();
        List<Integer> list3 = decoderState.mFrameOList;
        if (list3 != null) {
            PrintFrameRate(j, "DecOutFrameRate", list3);
            list3.clear();
        }
        RenderState renderState = playerState.mRenderState;
        if (renderState != null && (list = renderState.mFrameRateList) != null) {
            PrintFrameRate(j, "RenderFrameRate", list);
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRemoveRender(long j) {
        PlayerState playerState;
        if (this.mPlayerStateMap.containsKey(Long.valueOf(j)) && (playerState = this.mPlayerStateMap.get(Long.valueOf(j))) != null) {
            handlerPrintfFramRate(j);
            RenderState renderState = playerState.mRenderState;
            if (renderState != null) {
                YMFLog.warn(this, "[Render  ]", "removeRender, streamId:" + j + " Render:" + renderState.mName + " type:" + renderState.mType + " (0-MediaCodec-H264DecRender 1.MediaCodec-H265DecRender 2-RenderFramebuffer 3-Canvas)");
                playerState.mRenderState = null;
            }
            if (playerState.mViewState == null && playerState.mDecoderState == null) {
                VideoPlayer.getInstance().deleteVideoPlayerInfo(j);
                removePlayerState(j);
            }
        }
    }

    private String getViewTypeName(VideoConstant.ViewType viewType) {
        switch (viewType) {
            case SURFACE_VIDEO_VIEW:
                return " YSurfaceVideoViewExt ";
            case NO_GL_VIDEO_VIEW:
                return " YVideoViewExt ";
            case NO_GL_VIDEO_VIEW_MULTIVIDEO:
                return " YVideoViewMultiVideo ";
            case CUSTOM_GL_VIDEO_VIEW_LOW:
                return " YCustomGLVideoViewLowEGLExt ";
            case CUSTOM_GL_VIDEO_VIEW_LOW_MULTIVIDEO:
                return " YCustomGLVideoViewLowEGLMultiVideo ";
            case CUSTOM_GL_VIDEO_VIEW_HIGH:
                return " YCustomGLVideoViewHighEGLExt ";
            case CUSTOM_GL_VIDEO_VIEW_HIGH_MULTIVIDEO:
                return " YCustomGLVideoViewHighEGLMultiVideo";
            case GL_VIDEO_VIEW:
                return " YGLVideoViewExt ";
            case GL_VIDEO_VIEW_MULTIVIDEO:
                return " YGLVideoViewMutiVideo ";
            case GL_VIDEO_VIEW_GLSURFACE:
                return " YMFPlayerView ";
            default:
                return " unknow view type ";
        }
    }

    public void NotifyAddView(long j, int i, VideoConstant.ViewType viewType, String str) {
        if (this.mReady.get() && this.mHandler != null) {
            ViewState viewState = new ViewState();
            viewState.mName = str;
            viewState.mType = viewType;
            viewState.mStreamId = j;
            viewState.mVideoIndex = i;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, viewState));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAddView(long j, int i, VideoConstant.ViewType viewType, String str) {
        ViewState viewState = new ViewState();
        viewState.mName = str;
        viewState.mType = viewType;
        viewState.mStreamId = j;
        viewState.mVideoIndex = i;
        if (this.mPlayerStateMap.containsKey(Long.valueOf(j))) {
            this.mPlayerStateMap.get(Long.valueOf(j)).mViewState = null;
        }
        getPlayerState(j).mViewState = viewState;
        YMFLog.warn(this, Constant.MEDIACODE_PLAYVIEW, "addView, streamId:" + j + " mVideoIndex:" + i + " View:" + str + " type:" + getViewTypeName(viewType));
    }

    public void NotifyRemoveView(long j) {
        if (this.mReady.get() && this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(6, Long.valueOf(j)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRemoveView(long j) {
        PlayerState playerState;
        if (!this.mPlayerStateMap.containsKey(Long.valueOf(j)) || (playerState = this.mPlayerStateMap.get(Long.valueOf(j))) == null) {
            return;
        }
        ViewState viewState = playerState.mViewState;
        if (viewState != null) {
            YMFLog.warn(this, Constant.MEDIACODE_PLAYVIEW, "removeView, streamId:" + j + " View:" + viewState.mName + " type:" + getViewTypeName(viewState.mType));
            playerState.mViewState = null;
        }
        if (playerState.mRenderState == null && playerState.mDecoderState == null) {
            VideoPlayer.getInstance().deleteVideoPlayerInfo(j);
            removePlayerState(j);
        }
    }

    private void streamStart(long j, long j2, int i, int i2, int i3, int i4) {
        if (this.mReady.get() && this.mHandler != null) {
            streamInfo streaminfo = new streamInfo();
            streaminfo.mStreamId = j;
            streaminfo.mGroupId = j2;
            streaminfo.micPos = i;
            streaminfo.fps = i2;
            streaminfo.bHardDecoder = i3;
            streaminfo.vType = i4;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(7, streaminfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStreamStart(streamInfo streaminfo) {
        PlayerState playerState = getPlayerState(streaminfo.mStreamId);
        if (playerState == null) {
            return;
        }
        playerState.mStreamID = streaminfo.mStreamId;
        playerState.mGroupId = streaminfo.mGroupId;
        playerState.mMicPos = streaminfo.micPos;
        playerState.mFps = streaminfo.fps;
        if (streaminfo.vType != 2) {
            if (streaminfo.vType != 4) {
                if (streaminfo.vType == 5) {
                    playerState.mFormat = 5;
                }
            } else {
                playerState.mFormat = 4;
            }
        } else {
            playerState.mFormat = 2;
        }
        playerState.mHardDecoder = streaminfo.bHardDecoder;
        YMFLog.warn(this, "[Decoder ]", "handleStreamStart, streamId:" + playerState.mStreamID + " groupId:" + playerState.mGroupId + " micPos:" + playerState.mMicPos + " fps:" + playerState.mFps + " bHardDec:" + playerState.mHardDecoder + " vType:" + playerState.mFormat + " [H.264(2) H.265(5)]");
    }

    private void streamEnd(long j) {
        if (this.mReady.get() && this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(j)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStreamEnd(long j) {
        YMFLog.warn(this, "[Decoder ]", "handleStreamEnd, streamId:" + j);
    }

    private void notifyLastFrameNotRenderStatistic(long j, int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(19, new LostFrameRender(j, i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLastFrameNotRenderStatistic(long j, int i) {
        YMFLog.warn(this, "[Render  ]", "last Frame have not be Rendered, streamId:" + j + ", count:" + i);
    }

    private void notifyMultiVideoOriginPosition(YMFVideoPosition[] yMFVideoPositionArr, YMFVideoPosition yMFVideoPosition) {
        if (this.mReady.get() && this.mHandler != null) {
            MutiVideoPositionInfo mutiVideoPositionInfo = new MutiVideoPositionInfo();
            mutiVideoPositionInfo.videoPositions = yMFVideoPositionArr;
            mutiVideoPositionInfo.backgroundPosition = yMFVideoPosition;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(17, mutiVideoPositionInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMultiVideoOriginPosition(YMFVideoPosition[] yMFVideoPositionArr, YMFVideoPosition yMFVideoPosition) {
        if (yMFVideoPositionArr != null) {
            for (int i = 0; i < yMFVideoPositionArr.length; i++) {
                YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "MultiVideo origin TotalVideoCnt:" + yMFVideoPositionArr.length + " :index = " + i + " ( " + yMFVideoPositionArr[i].mX + "," + yMFVideoPositionArr[i].mY + "," + yMFVideoPositionArr[i].mWidth + "," + yMFVideoPositionArr[i].mHeight + ")");
            }
        }
        if (yMFVideoPosition != null) {
            YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "MultiVideo origin background:( " + yMFVideoPosition.mX + "," + yMFVideoPosition.mY + "," + yMFVideoPosition.mWidth + "," + yMFVideoPosition.mHeight + ")");
        }
    }

    private void notifyMultiVideoSurfaceChangePosition(YMFVideoPosition[] yMFVideoPositionArr, YMFVideoPosition yMFVideoPosition) {
        if (this.mReady.get() && this.mHandler != null) {
            MutiVideoPositionInfo mutiVideoPositionInfo = new MutiVideoPositionInfo();
            mutiVideoPositionInfo.videoPositions = yMFVideoPositionArr;
            mutiVideoPositionInfo.backgroundPosition = yMFVideoPosition;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(18, mutiVideoPositionInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMultiVideoSurfaceChangePosition(YMFVideoPosition[] yMFVideoPositionArr, YMFVideoPosition yMFVideoPosition) {
        if (yMFVideoPositionArr != null) {
            for (int i = 0; i < yMFVideoPositionArr.length; i++) {
                YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "MultiVideo Surface change TotalVideoCnt:" + yMFVideoPositionArr.length + ":index = " + i + " (" + yMFVideoPositionArr[i].mX + "," + yMFVideoPositionArr[i].mY + "," + yMFVideoPositionArr[i].mWidth + "," + yMFVideoPositionArr[i].mHeight + ")");
            }
        }
        if (yMFVideoPosition != null) {
            YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "MultiVideo surface change background:( " + yMFVideoPosition.mX + "," + yMFVideoPosition.mY + "," + yMFVideoPosition.mWidth + "," + yMFVideoPosition.mHeight + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class DecoderState {
        private long mBitrate;
        private long mCreateDecoderTime;
        private long mException;
        private long mFirstDecodeOutTime;
        private List<Integer> mFrameIList;
        private List<Integer> mFrameOList;
        private long mHeight;
        private long mLevel;
        private String mName;
        private long mProfile;
        private long mStreamId;
        private long mTotalI;
        private long mTotalO;
        private int mType;
        private int mViewState;
        private long mWidth;

        private DecoderState() {
            this.mFrameIList = new ArrayList(10);
            this.mFrameOList = new ArrayList(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class RenderState {
        private long mException;
        private List<Integer> mFrameRateList;
        private List<Integer> mMissFrameList;
        private String mName;
        private long mStreamId;
        private long mTotalI;
        private long mTotalO;
        private int mType;

        private RenderState() {
            this.mFrameRateList = new ArrayList(20);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class ViewState {
        private String mName;
        private long mStreamId;
        private VideoConstant.ViewType mType;
        private int mVideoIndex;

        private ViewState() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class PlayerState {
        private DecoderState mDecoderState;
        private long mFirstFrameArrivedTime;
        private long mFirstFrameRendedTime;
        private boolean mFirstFrameRendered;
        private int mFormat;
        private int mFps;
        private boolean mFristFrameArrived;
        private long mGroupId;
        private int mHardDecoder;
        private long mMicPos;
        private RenderState mRenderState;
        private long mStreamID;
        private ViewState mViewState;

        private PlayerState(long j) {
            this.mStreamID = j;
            this.mDecoderState = null;
            this.mRenderState = null;
            this.mViewState = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class StreamTimeInfo {
        private long mStreamId;
        private long mTimeStamp;

        public StreamTimeInfo(long j, long j2) {
            this.mStreamId = j;
            this.mTimeStamp = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class LostFrameRender {
        private int mCount;
        private long mStreamID;

        private LostFrameRender(long j, int i) {
            this.mStreamID = j;
            this.mCount = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class StateMonitorHandler extends Handler {
        private WeakReference<StateMonitor> mWeakWay;

        private StateMonitorHandler(StateMonitor stateMonitor) {
            this.mWeakWay = new WeakReference<>(stateMonitor);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                Looper myLooper = Looper.myLooper();
                if (myLooper != null) {
                    myLooper.quit();
                    removeCallbacksAndMessages(null);
                    return;
                }
                return;
            }
            StateMonitor stateMonitor = this.mWeakWay.get();
            if (stateMonitor == null) {
                YMFLog.warn(this, Constant.MEDIACODE_STAT, "handleMessage: stateManager is null");
                return;
            }
            switch (i) {
                case 1:
                    DecoderState decoderState = (DecoderState) message.obj;
                    if (decoderState != null) {
                        stateMonitor.handleAddDecoder(decoderState.mStreamId, decoderState.mType, decoderState.mName, decoderState.mCreateDecoderTime);
                        return;
                    }
                    return;
                case 2:
                    stateMonitor.handleRemoveDecoder(((Long) message.obj).longValue());
                    return;
                case 3:
                    RenderState renderState = (RenderState) message.obj;
                    if (renderState != null) {
                        stateMonitor.handleAddRender(renderState.mStreamId, renderState.mType, renderState.mName);
                        return;
                    }
                    return;
                case 4:
                    stateMonitor.handleRemoveRender(((Long) message.obj).longValue());
                    return;
                case 5:
                    ViewState viewState = (ViewState) message.obj;
                    if (viewState != null) {
                        stateMonitor.handleAddView(viewState.mStreamId, viewState.mVideoIndex, viewState.mType, viewState.mName);
                        return;
                    }
                    return;
                case 6:
                    stateMonitor.handleRemoveView(((Long) message.obj).longValue());
                    return;
                case 7:
                    stateMonitor.handleStreamStart((streamInfo) message.obj);
                    return;
                case 8:
                    stateMonitor.handleStreamEnd(((Long) message.obj).longValue());
                    return;
                case 9:
                    frameRateInfo framerateinfo = (frameRateInfo) message.obj;
                    if (framerateinfo != null) {
                        stateMonitor.handleTransInputFrameRate(framerateinfo.mStreamId, framerateinfo.mFrameRate, -1);
                        return;
                    }
                    return;
                case 10:
                    stateMonitor.handleNotifyFirstFrameArrive((StreamTimeInfo) message.obj);
                    return;
                case 11:
                    frameRateInfo framerateinfo2 = (frameRateInfo) message.obj;
                    if (framerateinfo2 != null) {
                        stateMonitor.handleRenderFrameRate(framerateinfo2.mStreamId, framerateinfo2.mFrameRate);
                        return;
                    }
                    return;
                case 12:
                    stateMonitor.handleNofityFirstFrameRendered(((Long) message.obj).longValue());
                    return;
                case 13:
                    frameRateInfo framerateinfo3 = (frameRateInfo) message.obj;
                    if (framerateinfo3 != null) {
                        stateMonitor.handleDecoderFrameRateO(framerateinfo3.mStreamId, framerateinfo3.mFrameRate);
                        return;
                    }
                    return;
                case 14:
                    resolutionInfo resolutioninfo = (resolutionInfo) message.obj;
                    if (resolutioninfo != null) {
                        stateMonitor.handleResolution(resolutioninfo.mStreamId, resolutioninfo.mWidth, resolutioninfo.mHeight);
                        return;
                    }
                    return;
                case 15:
                    FramePtsInfo framePtsInfo = (FramePtsInfo) message.obj;
                    if (framePtsInfo != null) {
                        stateMonitor.handlePts(framePtsInfo.mStreamId, framePtsInfo.pts);
                        return;
                    }
                    return;
                case 16:
                    long longValue = ((Long) message.obj).longValue();
                    if (longValue != 0) {
                        stateMonitor.handleClearPts(longValue);
                        return;
                    }
                    return;
                case 17:
                    MutiVideoPositionInfo mutiVideoPositionInfo = (MutiVideoPositionInfo) message.obj;
                    if (mutiVideoPositionInfo != null) {
                        stateMonitor.handleMultiVideoOriginPosition(mutiVideoPositionInfo.videoPositions, mutiVideoPositionInfo.backgroundPosition);
                        return;
                    }
                    return;
                case 18:
                    MutiVideoPositionInfo mutiVideoPositionInfo2 = (MutiVideoPositionInfo) message.obj;
                    if (mutiVideoPositionInfo2 != null) {
                        stateMonitor.handleMultiVideoSurfaceChangePosition(mutiVideoPositionInfo2.videoPositions, mutiVideoPositionInfo2.backgroundPosition);
                        return;
                    }
                    return;
                case 19:
                    LostFrameRender lostFrameRender = (LostFrameRender) message.obj;
                    stateMonitor.handleLastFrameNotRenderStatistic(lostFrameRender.mStreamID, lostFrameRender.mCount);
                    return;
                case 20:
                case 21:
                case 23:
                default:
                    return;
                case 22:
                    BitRateInfo bitRateInfo = (BitRateInfo) message.obj;
                    YMFPlayerStatisticManager.getInstance().setDecodeInBitrate(bitRateInfo.mStreamId, Integer.parseInt(bitRateInfo.mBitRate));
                    return;
                case 24:
                    frameRateInfo framerateinfo4 = (frameRateInfo) message.obj;
                    if (framerateinfo4 != null) {
                        stateMonitor.handleTransInputFrameRate(framerateinfo4.mStreamId, framerateinfo4.mFrameRate, framerateinfo4.mFrameRateDecoder);
                        return;
                    }
                    return;
                case 25:
                    VideoPlayerBitRateInfo videoPlayerBitRateInfo = (VideoPlayerBitRateInfo) message.obj;
                    if (videoPlayerBitRateInfo != null) {
                        stateMonitor.handleVideoPlayerBitrate(videoPlayerBitRateInfo.mStreamId, videoPlayerBitRateInfo.mBitRate);
                        return;
                    }
                    return;
                case 26:
                    ViewStateInfo viewStateInfo = (ViewStateInfo) message.obj;
                    if (viewStateInfo != null) {
                        stateMonitor.handleViewState(viewStateInfo.mStreamId, viewStateInfo.viewState);
                        return;
                    }
                    return;
                case 27:
                    DecodeLatencyInfo decodeLatencyInfo = (DecodeLatencyInfo) message.obj;
                    if (decodeLatencyInfo != null) {
                        stateMonitor.handleDecoderLatency(decodeLatencyInfo.mStreamId, decodeLatencyInfo.latency);
                        return;
                    }
                    return;
            }
        }
    }
}
