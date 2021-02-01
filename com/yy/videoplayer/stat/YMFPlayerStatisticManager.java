package com.yy.videoplayer.stat;

import com.yy.videoplayer.Constant;
import com.yy.videoplayer.stat.VideoStatisticTool;
import com.yy.videoplayer.utils.YMFLog;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class YMFPlayerStatisticManager {
    protected static final int RESET_DATA_COUNT = 10;
    protected static final int RESET_DATA_TIME = 5000;
    private static final byte[] SYNC_FLAG = new byte[1];
    public static final String TAG = "YMFPlayerStatisticManager ";
    private static volatile YMFPlayerStatisticManager mInstance;
    private VideoPlayerStatistic mVideoPlayerStatistic = new VideoPlayerStatistic();
    private HashMap<Long, VideoStatisticTool> mDecodeLatencyStatistic = new HashMap<>();
    private HashMap<Long, VideoStatisticTool> mRenderLatencyStatistic = new HashMap<>();
    private HashMap<Long, VideoStatisticTool> mRenderTimeStatistic = new HashMap<>();
    private HashMap<Long, VideoStatisticTool> mPtsStatistic = new HashMap<>();
    private HashMap<Long, VideoStatisticTool> mRenderFrameStatistic = new HashMap<>();
    private HashMap<Long, VideoStatisticTool> mDecodeMaxLatencyStatistic = new HashMap<>();
    private HashMap<Long, VideoStatisticTool> mRenderMaxLatencyStatistic = new HashMap<>();
    private HashMap<Long, VideoStatisticTool> mDecodeVideoMaxLatencyStatistic = new HashMap<>();
    private HashMap<Long, Long> mLastSampleMap = new HashMap<>();
    private HashMap<Long, Long> mLastRenderTimeStampMap = new HashMap<>();
    private ArrayList<VideoStatisticTool> statisticTools = new ArrayList<>();
    private HashMap<Long, Long> mResetRenderPtsStreamMap = new HashMap<>();
    private HashMap<Long, Long> mStartResetTimeMap = new HashMap<>();

    public static synchronized YMFPlayerStatisticManager getInstance() {
        YMFPlayerStatisticManager yMFPlayerStatisticManager;
        synchronized (YMFPlayerStatisticManager.class) {
            if (mInstance == null) {
                synchronized (SYNC_FLAG) {
                    if (mInstance == null) {
                        mInstance = new YMFPlayerStatisticManager();
                    }
                }
            }
            yMFPlayerStatisticManager = mInstance;
        }
        return yMFPlayerStatisticManager;
    }

    private YMFPlayerStatisticManager() {
        init();
    }

    private void init() {
    }

    public synchronized void reset() {
        for (Long l : this.mLastSampleMap.keySet()) {
            this.mLastSampleMap.put(Long.valueOf(l.longValue()), 0L);
        }
        for (Long l2 : this.mLastRenderTimeStampMap.keySet()) {
            this.mLastRenderTimeStampMap.put(Long.valueOf(l2.longValue()), 0L);
        }
        for (Long l3 : this.mStartResetTimeMap.keySet()) {
            this.mStartResetTimeMap.put(Long.valueOf(l3.longValue()), Long.valueOf(System.currentTimeMillis()));
        }
        YMFLog.info(this, Constant.MEDIACODE_STAT, "reset all");
    }

    public synchronized void reset(long j) {
        this.mLastSampleMap.put(Long.valueOf(j), 0L);
        this.mLastRenderTimeStampMap.put(Long.valueOf(j), 0L);
        this.mStartResetTimeMap.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        YMFLog.info(this, Constant.MEDIACODE_STAT, "reset streamId：" + j);
    }

    public synchronized void setResetStatistic(long j, long j2) {
        YMFLog.info(this, Constant.MEDIACODE_STAT, "setResetStatistic streamId：" + j + " pts：" + j2);
        reset(j);
    }

    public synchronized void setVideoDecodeId(long j, int i) {
        if (this.mVideoPlayerStatistic != null) {
            this.mVideoPlayerStatistic.setVideoDecodeId(j, i);
        }
    }

    public synchronized void setDecodeOutputWidth(long j, int i) {
        if (this.mVideoPlayerStatistic != null) {
            this.mVideoPlayerStatistic.setVideoDecodeOutputWidth(j, i);
        }
    }

    public synchronized void setDecodeOutputHeight(long j, int i) {
        if (this.mVideoPlayerStatistic != null) {
            this.mVideoPlayerStatistic.setDecodeOutputHeight(j, i);
        }
    }

    public synchronized void setDecodeOutputCount(long j, int i) {
        if (this.mVideoPlayerStatistic != null) {
            this.mVideoPlayerStatistic.setDecodeOutputCount(j, i);
        }
    }

    public synchronized void setRenderFrameCount(long j, int i) {
        if (this.mVideoPlayerStatistic != null && this.mRenderFrameStatistic != null) {
            if (!this.mRenderFrameStatistic.containsKey(Long.valueOf(j))) {
                this.mRenderFrameStatistic.put(Long.valueOf(j), new VideoStatisticTool());
            }
            this.mRenderFrameStatistic.get(Long.valueOf(j)).triggerStatistic(i);
        }
    }

    public void setDecodeInBitrate(long j, int i) {
    }

    public synchronized void setRenderTimeStamp(long j, long j2, long j3) {
        if (this.mVideoPlayerStatistic != null && this.mRenderTimeStatistic != null) {
            if (!this.mRenderTimeStatistic.containsKey(Long.valueOf(j))) {
                this.mRenderTimeStatistic.put(Long.valueOf(j), new VideoStatisticTool());
            }
            if (!this.mLastRenderTimeStampMap.containsKey(Long.valueOf(j)) || this.mLastRenderTimeStampMap.get(Long.valueOf(j)).longValue() == 0) {
                this.mLastRenderTimeStampMap.put(Long.valueOf(j), Long.valueOf(j2));
            } else if (this.mStartResetTimeMap.containsKey(Long.valueOf(j)) && System.currentTimeMillis() - this.mStartResetTimeMap.get(Long.valueOf(j)).longValue() < 5000) {
                this.mLastRenderTimeStampMap.put(Long.valueOf(j), Long.valueOf(j2));
            } else {
                int longValue = (int) (j2 - this.mLastRenderTimeStampMap.get(Long.valueOf(j)).longValue());
                this.mLastRenderTimeStampMap.put(Long.valueOf(j), Long.valueOf(j2));
                this.mRenderTimeStatistic.get(Long.valueOf(j)).triggerStatisticCalcStalling(longValue);
            }
        }
    }

    public synchronized void setDecodeLatency(long j, int i) {
        if (this.mVideoPlayerStatistic != null && (!this.mStartResetTimeMap.containsKey(Long.valueOf(j)) || System.currentTimeMillis() - this.mStartResetTimeMap.get(Long.valueOf(j)).longValue() >= 5000)) {
            if (this.mDecodeLatencyStatistic != null) {
                if (!this.mDecodeLatencyStatistic.containsKey(Long.valueOf(j))) {
                    this.mDecodeLatencyStatistic.put(Long.valueOf(j), new VideoStatisticTool());
                }
                this.mDecodeLatencyStatistic.get(Long.valueOf(j)).triggerStatisticCalcBySecond(i);
            }
            if (this.mDecodeMaxLatencyStatistic != null) {
                if (!this.mDecodeMaxLatencyStatistic.containsKey(Long.valueOf(j))) {
                    this.mDecodeMaxLatencyStatistic.put(Long.valueOf(j), new VideoStatisticTool());
                }
                this.mDecodeMaxLatencyStatistic.get(Long.valueOf(j)).triggerStatisticCalcBySecond(i);
            }
            if (this.mDecodeVideoMaxLatencyStatistic != null) {
                if (!this.mDecodeVideoMaxLatencyStatistic.containsKey(Long.valueOf(j))) {
                    this.mDecodeVideoMaxLatencyStatistic.put(Long.valueOf(j), new VideoStatisticTool());
                }
                this.mDecodeVideoMaxLatencyStatistic.get(Long.valueOf(j)).triggerStatisticCalcBySecond(i);
            }
        }
    }

    public synchronized void setDecodeVideoMaxLatency(long j, long j2) {
        if (this.mDecodeVideoMaxLatencyStatistic != null && (!this.mStartResetTimeMap.containsKey(Long.valueOf(j)) || System.currentTimeMillis() - this.mStartResetTimeMap.get(Long.valueOf(j)).longValue() >= 5000)) {
            if (!this.mDecodeVideoMaxLatencyStatistic.containsKey(Long.valueOf(j))) {
                this.mDecodeVideoMaxLatencyStatistic.put(Long.valueOf(j), new VideoStatisticTool());
            }
            this.mDecodeVideoMaxLatencyStatistic.get(Long.valueOf(j)).triggerStatisticCalcBySecond((int) j2);
        }
    }

    public synchronized void setRenderLatency(long j, int i) {
        if (this.mVideoPlayerStatistic != null) {
            if (this.mRenderLatencyStatistic != null) {
                if (!this.mRenderLatencyStatistic.containsKey(Long.valueOf(j))) {
                    this.mRenderLatencyStatistic.put(Long.valueOf(j), new VideoStatisticTool());
                }
                this.mRenderLatencyStatistic.get(Long.valueOf(j)).triggerStatisticCalcBySecond(i);
            }
            if (this.mRenderMaxLatencyStatistic != null) {
                if (!this.mRenderMaxLatencyStatistic.containsKey(Long.valueOf(j))) {
                    this.mRenderMaxLatencyStatistic.put(Long.valueOf(j), new VideoStatisticTool());
                }
                this.mRenderMaxLatencyStatistic.get(Long.valueOf(j)).triggerStatisticCalcBySecond(i);
            }
        }
    }

    public void setGpuDeviceName(String str) {
        VideoPlayerStatistic videoPlayerStatistic = this.mVideoPlayerStatistic;
        VideoPlayerStatistic.setGpuDeviceName(str);
    }

    public synchronized String getVideoDecodeBaseStatistics(int i) {
        return VideoPlayerStatistic.getBasePlayerVideoStatistics(i);
    }

    public synchronized String getVideoDecodeStatistics(boolean z, long j) {
        flush(z, j);
        return VideoPlayerStatistic.getPlayerVideoStatistics(z, j);
    }

    private void flush(boolean z, long j) {
        if (z) {
            if (this.mRenderFrameStatistic != null) {
                if (!this.mRenderFrameStatistic.containsKey(Long.valueOf(j))) {
                    this.mVideoPlayerStatistic.setRenderFrameCount(j, -1);
                } else {
                    this.mRenderFrameStatistic.get(Long.valueOf(j)).flush();
                    this.mVideoPlayerStatistic.setRenderFrameCount(j, this.mRenderFrameStatistic.get(Long.valueOf(j)).getStatisticResult().sumDeal);
                }
            }
            if (this.mRenderTimeStatistic != null) {
                if (!this.mRenderTimeStatistic.containsKey(Long.valueOf(j))) {
                    this.mVideoPlayerStatistic.setRenderStallingIndication(j, -1);
                    this.mVideoPlayerStatistic.setRenderPtsMaxDiff(j, -1);
                } else {
                    this.mRenderTimeStatistic.get(Long.valueOf(j)).flush();
                    VideoStatisticTool.VideoStatisticResult statisticResult = this.mRenderTimeStatistic.get(Long.valueOf(j)).getStatisticResult();
                    this.mVideoPlayerStatistic.setRenderStallingIndication(j, statisticResult.other);
                    this.mVideoPlayerStatistic.setRenderPtsMaxDiff(j, statisticResult.maxDeal);
                }
            }
            if (this.mDecodeLatencyStatistic != null) {
                if (!this.mDecodeLatencyStatistic.containsKey(Long.valueOf(j))) {
                    this.mVideoPlayerStatistic.setDecodeMeanLatency(j, -1);
                } else {
                    this.mDecodeLatencyStatistic.get(Long.valueOf(j)).flush();
                    this.mVideoPlayerStatistic.setDecodeMeanLatency(j, this.mDecodeLatencyStatistic.get(Long.valueOf(j)).getStatisticResult().meanDeal);
                }
            }
            if (this.mRenderLatencyStatistic != null) {
                if (!this.mRenderLatencyStatistic.containsKey(Long.valueOf(j))) {
                    this.mVideoPlayerStatistic.setRenderMeanLatency(j, -1);
                    return;
                }
                this.mRenderLatencyStatistic.get(Long.valueOf(j)).flush();
                this.mVideoPlayerStatistic.setRenderMeanLatency(j, this.mRenderLatencyStatistic.get(Long.valueOf(j)).getStatisticResult().meanDeal);
                return;
            }
            return;
        }
        if (this.mDecodeMaxLatencyStatistic != null) {
            if (!this.mDecodeMaxLatencyStatistic.containsKey(Long.valueOf(j))) {
                this.mVideoPlayerStatistic.setDecodeMaxLatency(j, -1);
            } else {
                this.mDecodeMaxLatencyStatistic.get(Long.valueOf(j)).flush();
                this.mVideoPlayerStatistic.setDecodeMaxLatency(j, this.mDecodeMaxLatencyStatistic.get(Long.valueOf(j)).getStatisticResult().maxDeal);
            }
        }
        if (this.mRenderMaxLatencyStatistic != null) {
            if (!this.mRenderMaxLatencyStatistic.containsKey(Long.valueOf(j))) {
                this.mVideoPlayerStatistic.setRenderMaxLatency(j, -1);
            } else {
                this.mRenderMaxLatencyStatistic.get(Long.valueOf(j)).flush();
                this.mVideoPlayerStatistic.setRenderMaxLatency(j, this.mRenderMaxLatencyStatistic.get(Long.valueOf(j)).getStatisticResult().maxDeal);
            }
        }
        if (this.mDecodeVideoMaxLatencyStatistic != null) {
            if (!this.mDecodeVideoMaxLatencyStatistic.containsKey(Long.valueOf(j))) {
                this.mVideoPlayerStatistic.setDecodeVideoMaxLatency(j, -1);
                return;
            }
            this.mDecodeVideoMaxLatencyStatistic.get(Long.valueOf(j)).flush();
            this.mVideoPlayerStatistic.setDecodeVideoMaxLatency(j, this.mDecodeVideoMaxLatencyStatistic.get(Long.valueOf(j)).getStatisticResult().maxDeal);
        }
    }

    public synchronized void clean(long j) {
        if (this.mVideoPlayerStatistic != null) {
            this.mVideoPlayerStatistic.clean(j);
        }
        if (this.mRenderFrameStatistic != null && this.mRenderFrameStatistic.containsKey(Long.valueOf(j))) {
            this.mRenderFrameStatistic.remove(Long.valueOf(j));
        }
        if (this.mRenderTimeStatistic != null && this.mRenderTimeStatistic.containsKey(Long.valueOf(j))) {
            this.mRenderTimeStatistic.remove(Long.valueOf(j));
        }
        if (this.mPtsStatistic != null && this.mPtsStatistic.containsKey(Long.valueOf(j))) {
            this.mPtsStatistic.remove(Long.valueOf(j));
        }
        if (this.mDecodeLatencyStatistic != null && this.mDecodeLatencyStatistic.containsKey(Long.valueOf(j))) {
            this.mDecodeLatencyStatistic.remove(Long.valueOf(j));
        }
        if (this.mRenderLatencyStatistic != null && this.mRenderLatencyStatistic.containsKey(Long.valueOf(j))) {
            this.mRenderLatencyStatistic.remove(Long.valueOf(j));
        }
        if (this.mDecodeMaxLatencyStatistic != null && this.mDecodeMaxLatencyStatistic.containsKey(Long.valueOf(j))) {
            this.mDecodeMaxLatencyStatistic.remove(Long.valueOf(j));
        }
        if (this.mDecodeVideoMaxLatencyStatistic != null && this.mDecodeVideoMaxLatencyStatistic.containsKey(Long.valueOf(j))) {
            this.mDecodeVideoMaxLatencyStatistic.remove(Long.valueOf(j));
        }
        if (this.mRenderMaxLatencyStatistic != null && this.mRenderMaxLatencyStatistic.containsKey(Long.valueOf(j))) {
            this.mRenderMaxLatencyStatistic.remove(Long.valueOf(j));
        }
        this.mLastSampleMap.clear();
        this.mLastRenderTimeStampMap.clear();
        this.mStartResetTimeMap.clear();
        YMFLog.info(TAG, Constant.MEDIACODE_STAT, "clean streamId:" + j);
    }
}
