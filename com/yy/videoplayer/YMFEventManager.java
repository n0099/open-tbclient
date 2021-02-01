package com.yy.videoplayer;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.yy.videoplayer.decoder.SmoothnessCounter;
import com.yy.videoplayer.decoder.StateMonitor;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import com.yy.videoplayer.stat.CommonUtil;
import com.yy.videoplayer.stat.YMFPlayerStatisticManager;
import com.yy.videoplayer.utils.TimeUtil;
import com.yy.videoplayer.utils.YMFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class YMFEventManager {
    private static final int MSG_NOTIFY_DECODER = 3;
    private static final int MSG_NOTIFY_RENDER = 1;
    private static final int MSG_NOTIFY_SIZE = 2;
    private static final int MSG_QUIT = 0;
    private static final long NOTIFY_SIZE_GAP = 15;
    private static final long NOTIFY_TIME_GAP = 500;
    private static String TAG = "YMFEventManager";
    private static YMFEventManager mInstance = new YMFEventManager();
    private Handler mHandler;
    private HandlerThread mThread;
    private boolean mNotifyRenderInfoByInterval = false;
    private SmoothnessCounter mSmoothnessCounter = new SmoothnessCounter(5000);
    private ArrayList<VideoRenderNotify> mVideoRenderNotifys = new ArrayList<>();
    private HashMap<Long, Boolean> mStreamFirstRenderFlagMap = new HashMap<>();
    private HashMap<Long, Integer> mStreamRenderCountMap = new HashMap<>();
    private HashMap<Long, Long> mStreamRtsMap = new HashMap<>();
    private HashMap<Long, CommonUtil.Size> mStreamSizeMap = new HashMap<>();

    public static YMFEventManager instance() {
        return mInstance;
    }

    public void notifyStreamStart(long j) {
        this.mStreamFirstRenderFlagMap.put(Long.valueOf(j), false);
        this.mStreamRenderCountMap.put(Long.valueOf(j), 0);
        this.mStreamRtsMap.put(Long.valueOf(j), 0L);
    }

    public void notifyStreamEnd(long j) {
        this.mStreamFirstRenderFlagMap.remove(Long.valueOf(j));
        this.mStreamRenderCountMap.remove(Long.valueOf(j));
        this.mStreamRtsMap.remove(Long.valueOf(j));
        this.mStreamSizeMap.remove(Long.valueOf(j));
    }

    public void notifyRenderEvnet(long j, long j2, long j3, int i, int i2, long j4, int i3, int i4, boolean z) {
        VideoRenderNotify videoRenderNotify = new VideoRenderNotify(0L, j, j2, j4, j3, i, i2, z);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.what = 1;
        obtainMessage.obj = videoRenderNotify;
        obtainMessage.arg1 = i3;
        obtainMessage.arg2 = i4;
        this.mHandler.sendMessage(obtainMessage);
        if (z) {
            YMFLog.info(this, "[Render  ]", "notifyRenderEvnet ignore streamid:" + j + " pts " + j2 + " dts " + j3 + " rts " + j4 + " rct " + i3 + " rts - dts " + (j4 - j3));
        }
    }

    public void notifyDecoderEvent(long j, long j2) {
        VideoDecodeEventNotify videoDecodeEventNotify = new VideoDecodeEventNotify(j, j2);
        Message obtainMessage = this.mHandler.obtainMessage(3);
        obtainMessage.what = 3;
        obtainMessage.obj = videoDecodeEventNotify;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void notifyFirstFrameSeeEvent(long j, long j2, int i, int i2) {
    }

    private void notifyRenderFrameRate(long j, long j2) {
        if (this.mStreamRenderCountMap.containsKey(Long.valueOf(j))) {
            int intValue = this.mStreamRenderCountMap.get(Long.valueOf(j)).intValue() + 1;
            this.mStreamRenderCountMap.put(Long.valueOf(j), Integer.valueOf(intValue));
            if (!this.mStreamRtsMap.containsKey(Long.valueOf(j))) {
                this.mStreamRtsMap.put(Long.valueOf(j), Long.valueOf(j2));
            }
            if (this.mStreamRtsMap.containsKey(Long.valueOf(j)) && this.mStreamRtsMap.get(Long.valueOf(j)).longValue() == 0) {
                this.mStreamRtsMap.put(Long.valueOf(j), Long.valueOf(j2));
            }
            if (j2 - this.mStreamRtsMap.get(Long.valueOf(j)).longValue() >= 1000) {
                StateMonitor.instance().NotifyRenderFrameRate(j, intValue);
                this.mStreamRtsMap.put(Long.valueOf(j), Long.valueOf(j2));
                this.mStreamRenderCountMap.put(Long.valueOf(j), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDecodeEventNotify(VideoDecodeEventNotify videoDecodeEventNotify) {
        YYVideoLibMgr.instance().onDecodeEventNotify(videoDecodeEventNotify);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRenderEventNotify(VideoRenderNotify videoRenderNotify, int i, int i2) {
        long j = videoRenderNotify.mStreamId;
        long j2 = videoRenderNotify.mRenderStamp;
        long j3 = videoRenderNotify.mPts;
        int i3 = videoRenderNotify.mWidth;
        int i4 = videoRenderNotify.mHeight;
        YMFPlayerStatisticManager.getInstance().setRenderLatency(j, i);
        YMFPlayerStatisticManager.getInstance().setRenderTimeStamp(j, System.currentTimeMillis(), j3);
        Boolean bool = this.mStreamFirstRenderFlagMap.get(Long.valueOf(j));
        if (bool != null && !bool.booleanValue()) {
            videoRenderNotify.mIgnoreStatistic = true;
        }
        this.mVideoRenderNotifys.add(videoRenderNotify);
        if (this.mNotifyRenderInfoByInterval) {
            Iterator<VideoRenderNotify> it = this.mVideoRenderNotifys.iterator();
            if (it.hasNext()) {
                if (videoRenderNotify.mPts - it.next().mPts < NOTIFY_TIME_GAP && this.mVideoRenderNotifys.size() < 15) {
                    return;
                }
            } else {
                return;
            }
        }
        YYVideoLibMgr.instance().onVideoRenderNotify(this.mVideoRenderNotifys);
        this.mVideoRenderNotifys.clear();
        YYVideoLibMgr.instance().onUpdatePts(j, j3);
        StateMonitor.NotifyPts(j, j3);
        StateMonitor.NotifyViewState(j, i2);
        notifyRenderFrameRate(j, j2);
        if (bool != null && !bool.booleanValue()) {
            YYVideoLibMgr.instance().onFirstFrameSeeNotify(j, j3, i3, i4);
            YYVideoLibMgr.instance().onFirstFrameRenderNotify(0L, j, j2, videoRenderNotify.mRenderStamp - videoRenderNotify.mDecodeStamp, 0);
            YMFLog.info(this, "[Render  ]", "onFirstFrameRenderNotify streamId:" + j + ",now " + TimeUtil.getTickCountLong() + ",pts:" + j3);
            StateMonitor.NotifyFirstFrameRendered(j, j2);
            this.mStreamSizeMap.get(Long.valueOf(j));
            this.mStreamFirstRenderFlagMap.put(Long.valueOf(j), true);
        }
        if (this.mSmoothnessCounter.RenderOneFrame(j, j2)) {
            YYVideoLibMgr.instance().onCoefficientOfVariationOfRenderInterval(0L, j, this.mSmoothnessCounter.GetIntervalMilliTs(), this.mSmoothnessCounter.ComputeCoefficientOfVariationAndReset());
        }
    }

    public void notifyVideoSize(long j, int i, int i2) {
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.what = 2;
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        obtainMessage.obj = Long.valueOf(j);
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoSizeChange(long j, int i, int i2) {
        YYVideoLibMgr.instance().onUpdateVideoSizeChanged(j, i, i2);
        this.mStreamSizeMap.put(Long.valueOf(j), new CommonUtil.Size(i, i2));
    }

    public YMFEventManager() {
        this.mSmoothnessCounter.ResetToInitialState();
        this.mThread = new HandlerThread(TAG);
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper()) { // from class: com.yy.videoplayer.YMFEventManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            YMFEventManager.this.onRenderEventNotify((VideoRenderNotify) message.obj, message.arg1, message.arg2);
                            break;
                        case 2:
                            YMFEventManager.this.onVideoSizeChange(((Long) message.obj).longValue(), message.arg1, message.arg2);
                            break;
                        case 3:
                            YMFEventManager.this.onDecodeEventNotify((VideoDecodeEventNotify) message.obj);
                            break;
                    }
                } catch (Exception e) {
                    YMFLog.error(this, "[Render  ]", "YMFEventManager handler exception:" + e.getMessage());
                }
            }
        };
    }

    public void release() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            if (Build.VERSION.SDK_INT >= 18) {
                this.mThread.quitSafely();
            } else {
                this.mThread.quit();
            }
            this.mHandler = null;
            this.mThread = null;
        }
    }
}
