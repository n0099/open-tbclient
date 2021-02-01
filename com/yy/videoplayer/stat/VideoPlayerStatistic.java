package com.yy.videoplayer.stat;

import com.yy.videoplayer.Constant;
import com.yy.videoplayer.utils.CPUTool;
import com.yy.videoplayer.utils.YMFLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public class VideoPlayerStatistic {
    private static final String TAG = "VideoPlayerStatistic";
    private static VideoPlayerStatistic mInstance;
    private static LinkedHashMap<String, Object> mCorePlayerDataHashMap = new LinkedHashMap<>();
    private static LinkedHashMap<String, Object> mAssistantUploadDataHashMap = new LinkedHashMap<>();
    private static LinkedHashMap<String, Object> mBaseUploadDataHashMap = new LinkedHashMap<>();
    private static String mCpuName = "";
    private static String mVersion = "";
    private static String mGpuName = "";
    private static HashMap<Long, Integer> mDecodeId = new HashMap<>();
    private static HashMap<Long, Integer> mDecodeOutputWidth = new HashMap<>();
    private static HashMap<Long, Integer> mDecodeOutputHeight = new HashMap<>();
    private static HashMap<Long, Integer> mDecodeOutputCount = new HashMap<>();
    private static HashMap<Long, Integer> mRenderFrameCount = new HashMap<>();
    private static HashMap<Long, Integer> mBitrateCount = new HashMap<>();
    private static HashMap<Long, Integer> mRenderStallingIndication = new HashMap<>();
    private static HashMap<Long, Integer> mRenderPtsMaxDiff = new HashMap<>();
    private static HashMap<Long, Integer> mDecodeMaxLatency = new HashMap<>();
    private static HashMap<Long, Integer> mDecodeVideoMaxLatency = new HashMap<>();
    private static HashMap<Long, Integer> mRenderMaxLatency = new HashMap<>();
    private static HashMap<Long, Integer> mDecodeMeanLatency = new HashMap<>();
    private static HashMap<Long, Integer> mRenderMeanLatency = new HashMap<>();
    private static Object mSyncObj = new Object();

    /* loaded from: classes4.dex */
    public interface AudienceHiidoAssistantStatisticKey {
        public static final String CpuDeviceInfo = "cpu";
        public static final String GpuDeviceInfo = "gpu";
        public static final String VideoLibVer = "vver";
    }

    /* loaded from: classes4.dex */
    public interface AudienceHiidoCoreStatisticKey {
        public static final String AppCpuRate = "s7";
        public static final String DecodeId = "did";
        public static final String DecodeMaxLatency = "dml";
        public static final String DecodeMeanLatency = "dal";
        public static final String DecodeOutputCount = "dofr";
        public static final String DecodeOutputHeight = "doh";
        public static final String DecodeOutputWidth = "dow";
        public static final String DecodeVideoMaxLatency = "dmt";
        public static final String RenderFrameCount = "frdc";
        public static final String RenderMaxLatency = "rml";
        public static final String RenderMeanLatency = "ral";
        public static final String RenderPtsMaxDiff = "rpd";
        public static final String RenderStallingIndication = "vrsi";
    }

    public static VideoPlayerStatistic getInstance() {
        if (mInstance == null) {
            mInstance = new VideoPlayerStatistic();
        }
        return mInstance;
    }

    public VideoPlayerStatistic() {
        initInfo();
    }

    private void initInfo() {
        mVersion = "200.3.3.101";
        mCpuName = CPUTool.getCpuInfo();
    }

    public static void setGpuDeviceName(String str) {
        mGpuName = str;
    }

    public void setVideoDecodeId(long j, int i) {
        if (mDecodeId != null) {
            mDecodeId.put(Long.valueOf(j), Integer.valueOf(CommonUtil.wrapperHiidoDecodeId(i)));
        }
    }

    public void setVideoDecodeOutputWidth(long j, int i) {
        if (mDecodeOutputWidth != null) {
            mDecodeOutputWidth.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setDecodeOutputHeight(long j, int i) {
        if (mDecodeOutputHeight != null) {
            mDecodeOutputHeight.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setDecodeOutputCount(long j, int i) {
        if (mDecodeOutputCount != null) {
            mDecodeOutputCount.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setRenderFrameCount(long j, int i) {
        if (mRenderFrameCount != null) {
            mRenderFrameCount.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setDecodeInBitrate(long j, int i) {
        if (mBitrateCount != null) {
            mBitrateCount.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setRenderStallingIndication(long j, int i) {
        if (mRenderStallingIndication != null) {
            mRenderStallingIndication.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setRenderPtsMaxDiff(long j, int i) {
        if (mRenderPtsMaxDiff != null) {
            mRenderPtsMaxDiff.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setDecodeMaxLatency(long j, int i) {
        if (mDecodeMaxLatency != null) {
            mDecodeMaxLatency.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setDecodeVideoMaxLatency(long j, int i) {
        if (mDecodeVideoMaxLatency != null) {
            mDecodeVideoMaxLatency.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setRenderMaxLatency(long j, int i) {
        if (mRenderMaxLatency != null) {
            mRenderMaxLatency.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setDecodeMeanLatency(long j, int i) {
        if (mDecodeMeanLatency != null) {
            mDecodeMeanLatency.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void setRenderMeanLatency(long j, int i) {
        if (mRenderMeanLatency != null) {
            mRenderMeanLatency.put(Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public static String getBasePlayerVideoStatistics(int i) {
        if (i < 3) {
            mBaseUploadDataHashMap.put("vver", CommonUtil.toURLEncoded(mVersion));
            mBaseUploadDataHashMap.put("cpu", CommonUtil.toURLEncoded(mCpuName));
            mBaseUploadDataHashMap.put("gpu", CommonUtil.toURLEncoded(mGpuName));
            String paramsOrderByKey = CommonUtil.getParamsOrderByKey(mBaseUploadDataHashMap);
            YMFLog.info(TAG, Constant.MEDIACODE_STAT, "videoplayer hiido data:" + paramsOrderByKey);
            mBaseUploadDataHashMap.clear();
            return paramsOrderByKey;
        }
        return "";
    }

    public static String getPlayerVideoStatistics(boolean z, long j) {
        String paramsOrderByKey;
        synchronized (mSyncObj) {
            if (z) {
                mCorePlayerDataHashMap.put(AudienceHiidoCoreStatisticKey.DecodeId, Integer.valueOf(mDecodeId.get(Long.valueOf(j)) != null ? mDecodeId.get(Long.valueOf(j)).intValue() : 0));
                mCorePlayerDataHashMap.put(AudienceHiidoCoreStatisticKey.DecodeOutputWidth, Integer.valueOf(mDecodeOutputWidth.get(Long.valueOf(j)) != null ? mDecodeOutputWidth.get(Long.valueOf(j)).intValue() : 0));
                mCorePlayerDataHashMap.put(AudienceHiidoCoreStatisticKey.DecodeOutputHeight, Integer.valueOf(mDecodeOutputHeight.get(Long.valueOf(j)) != null ? mDecodeOutputHeight.get(Long.valueOf(j)).intValue() : 0));
                mCorePlayerDataHashMap.put(AudienceHiidoCoreStatisticKey.DecodeOutputCount, Integer.valueOf(mDecodeOutputCount.get(Long.valueOf(j)) != null ? mDecodeOutputCount.get(Long.valueOf(j)).intValue() : 0));
                mCorePlayerDataHashMap.put(AudienceHiidoCoreStatisticKey.RenderFrameCount, Integer.valueOf(mRenderFrameCount.get(Long.valueOf(j)) != null ? mRenderFrameCount.get(Long.valueOf(j)).intValue() : -1));
                mCorePlayerDataHashMap.put(AudienceHiidoCoreStatisticKey.RenderStallingIndication, Integer.valueOf(mRenderStallingIndication.get(Long.valueOf(j)) != null ? mRenderStallingIndication.get(Long.valueOf(j)).intValue() : -1));
                mCorePlayerDataHashMap.put(AudienceHiidoCoreStatisticKey.RenderPtsMaxDiff, Integer.valueOf(mRenderPtsMaxDiff.get(Long.valueOf(j)) != null ? mRenderPtsMaxDiff.get(Long.valueOf(j)).intValue() : -1));
                mCorePlayerDataHashMap.put(AudienceHiidoCoreStatisticKey.DecodeMeanLatency, Integer.valueOf(mDecodeMeanLatency.get(Long.valueOf(j)) != null ? mDecodeMeanLatency.get(Long.valueOf(j)).intValue() : -1));
                mCorePlayerDataHashMap.put(AudienceHiidoCoreStatisticKey.RenderMeanLatency, Integer.valueOf(mRenderMeanLatency.get(Long.valueOf(j)) != null ? mRenderMeanLatency.get(Long.valueOf(j)).intValue() : -1));
                paramsOrderByKey = CommonUtil.getParamsOrderByKey(mCorePlayerDataHashMap);
            } else {
                mAssistantUploadDataHashMap.put(AudienceHiidoCoreStatisticKey.DecodeMaxLatency, mDecodeMaxLatency.get(Long.valueOf(j)));
                mAssistantUploadDataHashMap.put(AudienceHiidoCoreStatisticKey.RenderMaxLatency, mRenderMaxLatency.get(Long.valueOf(j)));
                mAssistantUploadDataHashMap.put(AudienceHiidoCoreStatisticKey.DecodeVideoMaxLatency, mDecodeVideoMaxLatency.get(Long.valueOf(j)));
                paramsOrderByKey = CommonUtil.getParamsOrderByKey(mAssistantUploadDataHashMap);
            }
        }
        YMFLog.info(TAG, "[Procedur]", "videoplayer hiido streamId:" + j + " data:" + paramsOrderByKey);
        return paramsOrderByKey;
    }

    public void clean(long j) {
        synchronized (mSyncObj) {
            if (mDecodeId != null && mDecodeId.containsKey(Long.valueOf(j))) {
                mDecodeId.remove(Long.valueOf(j));
            }
            if (mDecodeOutputWidth != null && mDecodeOutputWidth.containsKey(Long.valueOf(j))) {
                mDecodeOutputWidth.remove(Long.valueOf(j));
            }
            if (mDecodeOutputCount != null && mDecodeOutputCount.containsKey(Long.valueOf(j))) {
                mDecodeOutputCount.remove(Long.valueOf(j));
            }
            if (mRenderFrameCount != null && mRenderFrameCount.containsKey(Long.valueOf(j))) {
                mRenderFrameCount.remove(Long.valueOf(j));
            }
            if (mRenderStallingIndication != null && mRenderStallingIndication.containsKey(Long.valueOf(j))) {
                mRenderStallingIndication.remove(Long.valueOf(j));
            }
            if (mRenderPtsMaxDiff != null && mRenderPtsMaxDiff.containsKey(Long.valueOf(j))) {
                mRenderPtsMaxDiff.remove(Long.valueOf(j));
            }
            if (mDecodeMaxLatency != null && mDecodeMaxLatency.containsKey(Long.valueOf(j))) {
                mDecodeMaxLatency.remove(Long.valueOf(j));
            }
            if (mDecodeVideoMaxLatency != null && mDecodeVideoMaxLatency.containsKey(Long.valueOf(j))) {
                mDecodeVideoMaxLatency.remove(Long.valueOf(j));
            }
            if (mDecodeMeanLatency != null && mDecodeMeanLatency.containsKey(Long.valueOf(j))) {
                mDecodeMeanLatency.remove(Long.valueOf(j));
            }
            if (mRenderMeanLatency != null && mRenderMeanLatency.containsKey(Long.valueOf(j))) {
                mRenderMeanLatency.remove(Long.valueOf(j));
            }
            if (mRenderMaxLatency != null && mRenderMaxLatency.containsKey(Long.valueOf(j))) {
                mRenderMaxLatency.remove(Long.valueOf(j));
            }
            if (mDecodeOutputHeight != null && mDecodeOutputHeight.containsKey(Long.valueOf(j))) {
                mDecodeOutputHeight.remove(Long.valueOf(j));
            }
        }
    }
}
