package com.yy.mediaframework.stat;

import com.yy.mediaframework.utils.VideoStatisticTool;
import com.yy.mediaframework.utils.YMFLog;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class YMFLiveStatisticManager {
    protected static final int RESET_DATA_COUNT = 10;
    protected static final int RESET_DATA_TIME = 5000;
    private static final byte[] SYNC_FLAG = new byte[1];
    public static final String TAG = "VideoStatisticManager ";
    private static volatile YMFLiveStatisticManager mInstance;
    private VideoDataStatistic mVideoDataStatistic = new VideoDataStatistic();
    private VideoStatisticTool mCaptureDataStatistic = null;
    private VideoStatisticTool mPreProcessStatistic = null;
    private VideoStatisticTool mPtsStatistic = null;
    private HashMap<Integer, VideoStatisticTool> mRealEncodeBitrateStatic = new HashMap<>();
    private HashMap<Integer, VideoStatisticTool> mRealEncodeFpsStatistic = new HashMap<>();
    private HashMap<Integer, VideoStatisticTool> mEncodeLatencyStatistic = new HashMap<>();
    private HashMap<Integer, VideoStatisticTool> mPtsDtsStatistic = new HashMap<>();
    private HashMap<Integer, VideoStatisticTool> mVideoCapture2EncodeLatencyStatistic = new HashMap<>();
    private HashMap<Integer, VideoStatisticTool> mEncodeDiffStatistic = new HashMap<>();
    private HashMap<Integer, HashMap<Long, Long>> mEncodeLatency = new HashMap<>();
    HashMap<Long, Long> mVideoCapture2EncodeLatency = new HashMap<>();
    private HashMap<Integer, Boolean> mResetVideoEncodeTimeDiff = new HashMap<>();
    private long mLastCameraCaptureTime = 0;
    private long mDesiredEncodeBitrate = 0;
    private long mLastPts = 0;
    private long mLastPrintTime = 0;
    private int mMaxDeltaPts = 0;
    private long mStartResetTime = -1;
    private long mPureEncodeFlowTime = 0;
    private long mPureCap2EncodeFlowTime = 0;
    private long mPurePreProcessTime = 0;
    private long mPureCap2EncodeStartFlowTime = 0;
    private long mLastCalcPreProcessTime = 0;
    private long mLastCalcCap2EncodeTime = 0;
    private long mLastCalcEncodeTime = 0;

    public static synchronized YMFLiveStatisticManager getInstance() {
        YMFLiveStatisticManager yMFLiveStatisticManager;
        synchronized (YMFLiveStatisticManager.class) {
            if (mInstance == null) {
                synchronized (SYNC_FLAG) {
                    if (mInstance == null) {
                        mInstance = new YMFLiveStatisticManager();
                    }
                }
            }
            yMFLiveStatisticManager = mInstance;
        }
        return yMFLiveStatisticManager;
    }

    private YMFLiveStatisticManager() {
        init();
    }

    private void init() {
        this.mCaptureDataStatistic = new VideoStatisticTool();
        this.mPreProcessStatistic = new VideoStatisticTool();
        this.mPtsStatistic = new VideoStatisticTool();
    }

    public synchronized void reset() {
        YMFLog.info(this, "[Preview ]", "resetData");
        for (Integer num : this.mEncodeLatency.keySet()) {
            int intValue = num.intValue();
            YMFLog.info(this, "[Preview ]", "clear mEncodeLatency publishId:" + intValue + " count：" + this.mEncodeLatency.size());
            this.mEncodeLatency.get(Integer.valueOf(intValue)).clear();
        }
        YMFLog.info(this, "[Preview ]", "clear mVideoCapture2EncodeLatency count：" + this.mVideoCapture2EncodeLatency.size());
        this.mVideoCapture2EncodeLatency.clear();
        for (Integer num2 : this.mResetVideoEncodeTimeDiff.keySet()) {
            this.mResetVideoEncodeTimeDiff.put(Integer.valueOf(num2.intValue()), true);
        }
        this.mLastCameraCaptureTime = 0L;
        this.mStartResetTime = System.currentTimeMillis();
    }

    public void calcPurePreProcessLatency(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mLastCalcPreProcessTime == 0 || currentTimeMillis - this.mLastCalcPreProcessTime > 10000) {
            YMFLog.info(TAG, "[Util    ]", "calcPurePreProcessLatency: " + (currentTimeMillis - j));
            this.mLastCalcPreProcessTime = currentTimeMillis;
        }
    }

    public void calcPureEncodeLatency(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mLastCalcEncodeTime == 0 || currentTimeMillis - this.mLastCalcEncodeTime > 10000) {
            YMFLog.info(TAG, "[Util    ]", "calcPureEncodeLatency: " + (currentTimeMillis - j));
            this.mLastCalcEncodeTime = currentTimeMillis;
        }
    }

    public void beginCalcPureCap2PreProcessLatency() {
        this.mPureCap2EncodeStartFlowTime = System.currentTimeMillis();
    }

    public void endCalcPureCap2PreProcessLatency() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mLastCalcCap2EncodeTime == 0 || currentTimeMillis - this.mLastCalcCap2EncodeTime > 10000) {
            YMFLog.info(TAG, "[Util    ]", "calcPureCap2PreProcessLatency: " + (currentTimeMillis - this.mPureCap2EncodeStartFlowTime));
            this.mLastCalcCap2EncodeTime = currentTimeMillis;
        }
    }

    public void setGpuDeviceName(String str) {
        this.mVideoDataStatistic.setGpuDeviceName(str);
    }

    public void setCameraCaptureFrameRate() {
        if (this.mCaptureDataStatistic != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mLastCameraCaptureTime == 0) {
                this.mLastCameraCaptureTime = System.currentTimeMillis();
                return;
            }
            this.mLastCameraCaptureTime = currentTimeMillis;
            this.mCaptureDataStatistic.triggerStatisticCalcBySecond((int) (currentTimeMillis - this.mLastCameraCaptureTime));
        }
    }

    public void calcPreProcessLatency(long j) {
        if (this.mPreProcessStatistic != null) {
            this.mPreProcessStatistic.triggerStatisticCalcBySecond((int) (System.currentTimeMillis() - j));
        }
    }

    public void setDesiredParam(int i, int i2, int i3, int i4, int i5) {
        this.mVideoDataStatistic.setDesiredParam(i, i2, i3, i4, i5);
    }

    public void setVideoEncodeTypeId(int i, int i2) {
        this.mVideoDataStatistic.setVideoEncodeTypeId(i, i2);
    }

    public void setVideoEncodeWidth(int i, int i2) {
        this.mVideoDataStatistic.setVideoEncodeWidth(i, i2);
    }

    public void setVideoEncodeHeight(int i, int i2) {
        this.mVideoDataStatistic.setVideoEncodeHeight(i, i2);
    }

    public void setVideoEncodeDesiredFps(int i, int i2) {
        this.mVideoDataStatistic.setVideoEncodeDesiredFps(i, i2);
    }

    public void setVideoRealEncodeFps(int i, int i2) {
        if (this.mRealEncodeFpsStatistic != null) {
            if (!this.mRealEncodeFpsStatistic.containsKey(Integer.valueOf(i))) {
                this.mRealEncodeFpsStatistic.put(Integer.valueOf(i), new VideoStatisticTool());
            }
            this.mRealEncodeFpsStatistic.get(Integer.valueOf(i)).triggerStatisticCalcBySecond(i2);
        }
    }

    public void setVideoDesiredEncodeBitrate(int i, int i2) {
        this.mDesiredEncodeBitrate = i2 / 1000;
        this.mVideoDataStatistic.setVideoDesiredEncodeBitrate(i, i2 / 1000);
    }

    public void setVideoRealBitrate(int i, int i2) {
        if (this.mRealEncodeBitrateStatic != null) {
            if (!this.mRealEncodeBitrateStatic.containsKey(Integer.valueOf(i))) {
                this.mRealEncodeBitrateStatic.put(Integer.valueOf(i), new VideoStatisticTool());
            }
            this.mRealEncodeBitrateStatic.get(Integer.valueOf(i)).triggerStatisticCalcBySecond(i2);
        }
    }

    public void setCaptureType(int i) {
        this.mVideoDataStatistic.setCaptureType(i);
    }

    public synchronized void beginEncode(int i, long j) {
        if (!this.mEncodeLatency.containsKey(Integer.valueOf(i))) {
            this.mEncodeLatency.put(Integer.valueOf(i), new HashMap<>());
        }
        this.mEncodeLatency.get(Integer.valueOf(i)).put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
    }

    public synchronized void endEncode(int i, long j) {
        if (!this.mEncodeLatencyStatistic.containsKey(Integer.valueOf(i))) {
            this.mEncodeLatencyStatistic.put(Integer.valueOf(i), new VideoStatisticTool());
        }
        if (!this.mVideoCapture2EncodeLatencyStatistic.containsKey(Integer.valueOf(i))) {
            this.mVideoCapture2EncodeLatencyStatistic.put(Integer.valueOf(i), new VideoStatisticTool());
        }
        if (this.mEncodeLatency.containsKey(Integer.valueOf(i)) && this.mEncodeLatency.get(Integer.valueOf(i)).containsKey(Long.valueOf(j))) {
            this.mEncodeLatencyStatistic.get(Integer.valueOf(i)).triggerStatistic((int) (System.currentTimeMillis() - this.mEncodeLatency.get(Integer.valueOf(i)).get(Long.valueOf(j)).longValue()));
            this.mEncodeLatency.get(Integer.valueOf(i)).remove(Long.valueOf(j));
            if (this.mEncodeLatency.get(Integer.valueOf(i)).size() > 3000) {
                this.mEncodeLatency.get(Integer.valueOf(i)).clear();
            }
        }
        if (this.mVideoCapture2EncodeLatency.get(Long.valueOf(j)) != null) {
            this.mVideoCapture2EncodeLatencyStatistic.get(Integer.valueOf(i)).triggerStatistic((int) (System.currentTimeMillis() - this.mVideoCapture2EncodeLatency.get(Long.valueOf(j)).longValue()));
        }
    }

    public synchronized void beginCapture2Encode(long j) {
        if (this.mVideoCapture2EncodeLatency.size() > 3000) {
            this.mVideoCapture2EncodeLatency.clear();
        }
        this.mVideoCapture2EncodeLatency.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
    }

    public void setVideoPtsMaxDiff(long j) {
        if (this.mPtsStatistic != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mLastPts == 0) {
                this.mLastPrintTime = currentTimeMillis;
                this.mLastPts = j;
                return;
            }
            int i = (int) (j - this.mLastPts);
            this.mLastPts = j;
            if (this.mStartResetTime == -1 || System.currentTimeMillis() - this.mStartResetTime >= 5000) {
                if (this.mMaxDeltaPts >= i) {
                    i = this.mMaxDeltaPts;
                }
                this.mMaxDeltaPts = i;
                if (currentTimeMillis - this.mLastPrintTime >= 1000) {
                    this.mLastPrintTime = currentTimeMillis;
                    this.mPtsStatistic.triggerStatisticCalcStalling(this.mMaxDeltaPts);
                    this.mMaxDeltaPts = 0;
                }
            }
        }
    }

    public void setVideoPtsDtsMaxDiff(int i, int i2) {
        if (this.mPtsDtsStatistic != null) {
            if (!this.mPtsDtsStatistic.containsKey(Integer.valueOf(i))) {
                this.mPtsDtsStatistic.put(Integer.valueOf(i), new VideoStatisticTool());
            }
            if (this.mStartResetTime == -1 || System.currentTimeMillis() - this.mStartResetTime >= 5000) {
                this.mPtsDtsStatistic.get(Integer.valueOf(i)).triggerStatistic(i2);
            }
        }
    }

    public void setVideoEncodeTimeDiff(int i, int i2) {
        if (this.mEncodeDiffStatistic != null) {
            if (!this.mEncodeDiffStatistic.containsKey(Integer.valueOf(i))) {
                this.mEncodeDiffStatistic.put(Integer.valueOf(i), new VideoStatisticTool());
            }
            if (this.mResetVideoEncodeTimeDiff.containsKey(Integer.valueOf(i)) && this.mResetVideoEncodeTimeDiff.get(Integer.valueOf(i)).booleanValue()) {
                this.mResetVideoEncodeTimeDiff.put(Integer.valueOf(i), false);
                YMFLog.info(TAG, "[Procedur]", "isResetVideoEncodeTimeDiff==true,give up the data");
                return;
            }
            if (!this.mResetVideoEncodeTimeDiff.containsKey(Integer.valueOf(i))) {
                this.mResetVideoEncodeTimeDiff.put(Integer.valueOf(i), false);
            }
            this.mEncodeDiffStatistic.get(Integer.valueOf(i)).triggerStatistic(i2);
        }
    }

    public String getUploadVideoStatistics(boolean z, int i) {
        if (this.mVideoDataStatistic == null) {
            return "";
        }
        flush(z, i);
        return VideoDataStatistic.getUploadVideoStatistics(z, i);
    }

    public String getBaseUploadVideoStatistics(int i) {
        if (this.mVideoDataStatistic != null) {
            VideoDataStatistic videoDataStatistic = this.mVideoDataStatistic;
            return VideoDataStatistic.getBaseUploadVideoStatistics(i);
        }
        return "";
    }

    private void flush(boolean z, int i) {
        if (z) {
            if (this.mCaptureDataStatistic != null) {
                if (i == 0) {
                    this.mCaptureDataStatistic.flush();
                }
                VideoStatisticTool.VideoStatisticResult statisticResult = this.mCaptureDataStatistic.getStatisticResult();
                this.mVideoDataStatistic.setCameraCaptureFrameRate(statisticResult.meanCount);
                this.mVideoDataStatistic.setCameraCaptureMeanLatency(statisticResult.meanDeal);
            }
            if (this.mPreProcessStatistic != null) {
                if (i == 0) {
                    this.mPreProcessStatistic.flush();
                }
                VideoStatisticTool.VideoStatisticResult statisticResult2 = this.mPreProcessStatistic.getStatisticResult();
                this.mVideoDataStatistic.setPreProcessMeanLatency(statisticResult2.meanDeal);
                this.mVideoDataStatistic.setPreProcessMaxLatency(statisticResult2.maxDeal);
            }
            if (this.mRealEncodeFpsStatistic != null && this.mRealEncodeFpsStatistic.get(Integer.valueOf(i)) != null) {
                this.mRealEncodeFpsStatistic.get(Integer.valueOf(i)).flush();
                VideoStatisticTool.VideoStatisticResult statisticResult3 = this.mRealEncodeFpsStatistic.get(Integer.valueOf(i)).getStatisticResult();
                this.mVideoDataStatistic.setVideoRealEncodeFps(i, statisticResult3.meanDeal);
                this.mVideoDataStatistic.setVideoRealMinEncodeFps(i, statisticResult3.minDeal);
            } else {
                this.mVideoDataStatistic.setVideoRealEncodeFps(i, -1);
                this.mVideoDataStatistic.setVideoRealMinEncodeFps(i, -1);
            }
            if (this.mRealEncodeBitrateStatic != null && this.mRealEncodeBitrateStatic.get(Integer.valueOf(i)) != null) {
                this.mRealEncodeBitrateStatic.get(Integer.valueOf(i)).flush();
                VideoStatisticTool.VideoStatisticResult statisticResult4 = this.mRealEncodeBitrateStatic.get(Integer.valueOf(i)).getStatisticResult();
                this.mVideoDataStatistic.setVideoRealMaxBitrate(i, statisticResult4.maxDeal);
                this.mVideoDataStatistic.setVideoRealMeanBitrate(i, statisticResult4.meanDeal);
            } else {
                this.mVideoDataStatistic.setVideoRealMaxBitrate(i, -1);
                this.mVideoDataStatistic.setVideoRealMeanBitrate(i, -1);
            }
            if (this.mEncodeLatencyStatistic != null && this.mEncodeLatencyStatistic.get(Integer.valueOf(i)) != null) {
                this.mEncodeLatencyStatistic.get(Integer.valueOf(i)).flush();
                VideoStatisticTool.VideoStatisticResult statisticResult5 = this.mEncodeLatencyStatistic.get(Integer.valueOf(i)).getStatisticResult();
                this.mVideoDataStatistic.setVideoEncodeMeanLatency(i, statisticResult5.meanDeal);
                this.mVideoDataStatistic.setVideoEncodeMaxLatency(i, statisticResult5.maxDeal);
            } else {
                this.mVideoDataStatistic.setVideoEncodeMeanLatency(i, -1);
                this.mVideoDataStatistic.setVideoEncodeMaxLatency(i, -1);
            }
            if (this.mVideoCapture2EncodeLatencyStatistic != null && this.mVideoCapture2EncodeLatencyStatistic.get(Integer.valueOf(i)) != null) {
                this.mVideoCapture2EncodeLatencyStatistic.get(Integer.valueOf(i)).flush();
                this.mVideoDataStatistic.setVideoCapture2EncodeLatency(i, this.mVideoCapture2EncodeLatencyStatistic.get(Integer.valueOf(i)).getStatisticResult().meanDeal);
            } else {
                this.mVideoDataStatistic.setVideoCapture2EncodeLatency(i, -1);
            }
            if (this.mPtsStatistic != null) {
                if (i == 0) {
                    this.mPtsStatistic.flush();
                }
                VideoStatisticTool.VideoStatisticResult statisticResult6 = this.mPtsStatistic.getStatisticResult();
                this.mVideoDataStatistic.setVideoPtsMaxDiff(statisticResult6.maxDeal);
                this.mVideoDataStatistic.setVideoCaptureStallingIndication(statisticResult6.other);
            }
            if (this.mPtsDtsStatistic != null && this.mPtsDtsStatistic.get(Integer.valueOf(i)) != null) {
                this.mPtsDtsStatistic.get(Integer.valueOf(i)).flush();
                this.mVideoDataStatistic.setVideoPtsDtsMaxDiff(i, this.mPtsDtsStatistic.get(Integer.valueOf(i)).getStatisticResult().maxDeal);
            } else {
                this.mVideoDataStatistic.setVideoPtsDtsMaxDiff(i, -1);
            }
            if (this.mEncodeDiffStatistic != null && this.mEncodeDiffStatistic.get(Integer.valueOf(i)) != null) {
                this.mEncodeDiffStatistic.get(Integer.valueOf(i)).flush();
                VideoStatisticTool.VideoStatisticResult statisticResult7 = this.mEncodeDiffStatistic.get(Integer.valueOf(i)).getStatisticResult();
                this.mVideoDataStatistic.setVideoEncodeTimeDiff(i, (statisticResult7.maxDeal <= -1 || statisticResult7.minDeal <= -1) ? -1 : statisticResult7.maxDeal - statisticResult7.minDeal);
                return;
            }
            this.mVideoDataStatistic.setVideoEncodeTimeDiff(i, -1);
        }
    }
}
