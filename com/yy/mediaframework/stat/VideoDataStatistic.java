package com.yy.mediaframework.stat;

import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.YYVideoCodec;
import com.yy.mediaframework.utils.CPUTool;
import com.yy.mediaframework.utils.CommonUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class VideoDataStatistic {
    private static final String TAG = "VideoDataStatistic";
    private static LinkedHashMap<String, Object> mCoreUploadDataHashMap = new LinkedHashMap<>();
    private static LinkedHashMap<String, Object> mAssistantUploadDataHashMap = new LinkedHashMap<>();
    private static LinkedHashMap<String, Object> mBaseUploadDataHashMap = new LinkedHashMap<>();
    private static String mCpuName = "";
    private static String mVersion = "";
    private static String mGpuName = "";
    private static int mCameraCaptureRealFrameRate = 0;
    private static int mCameraCaptureMeanLatency = 0;
    private static int mPreProcessMeanLatency = 0;
    private static int mPreProcessMaxLatency = 0;
    private static int mVideoPtsMaxDiff = 0;
    private static int mVideoCaptureStallingIndication = 0;
    private static HashMap<Integer, Integer> mPmDesiredEncodeWidth = new HashMap<>();
    private static HashMap<Integer, Integer> mPmDesiredEncodeHeight = new HashMap<>();
    private static HashMap<Integer, Integer> mPmDesiredEncodeBitrate = new HashMap<>();
    private static HashMap<Integer, Integer> mPmDesiredEncodeFps = new HashMap<>();
    private static int mCaptureType = -1;
    private static HashMap<Integer, Integer> mVideoEncodeId = new HashMap<>();
    private static HashMap<Integer, Integer> mVideoEncodeWidth = new HashMap<>();
    private static HashMap<Integer, Integer> mVideoEncodeHeight = new HashMap<>();
    private static HashMap<Integer, Integer> mDesiredFps = new HashMap<>();
    private static HashMap<Integer, Integer> mRealFps = new HashMap<>();
    private static HashMap<Integer, Integer> mRealMinFps = new HashMap<>();
    private static HashMap<Integer, Integer> mDesiredBitrate = new HashMap<>();
    private static HashMap<Integer, Integer> mRealMeanBitrate = new HashMap<>();
    private static HashMap<Integer, Integer> mRealMaxBitrate = new HashMap<>();
    private static HashMap<Integer, Integer> mEncodeMeanLatency = new HashMap<>();
    private static HashMap<Integer, Integer> mEncodeMaxLatency = new HashMap<>();
    private static HashMap<Integer, Integer> mVideoCapture2EncodeLatency = new HashMap<>();
    private static HashMap<Integer, Integer> mVideoPtsDtsMaxDiff = new HashMap<>();
    private static HashMap<Integer, Integer> mVideoEncodeTimeDiff = new HashMap<>();

    /* loaded from: classes6.dex */
    private interface AnchorHiidoAssistantStatisticKey {
        public static final String CpuDeviceInfo = "cpu";
        public static final String GpuDeviceInfo = "gpu";
        public static final String H265SupportInfo = "hevc";
        public static final String VideoLibVer = "vver";
    }

    /* loaded from: classes6.dex */
    public interface AnchorHiidoCoreStatisticKey {
        public static final String AppCpuRate = "s7";
        public static final String CaptureDesiredFps = "sfr";
        public static final String CaptureDesiredResolutionHeight = "sh";
        public static final String CaptureDesiredResolutionWidth = "sw";
        public static final String CaptureMeanLatency = "cal";
        public static final String CaptureRealFps = "rfr";
        public static final String CaptureRealResolutionHeight = "rh";
        public static final String CaptureRealResolutionWidth = "rw";
        public static final String CaptureType = "vct";
        public static final String PmDesiredEncodeBitrate = "pmbr";
        public static final String PmDesiredEncodeFps = "pmfr";
        public static final String PmDesiredEncodeHeight = "pmh";
        public static final String PmDesiredEncodeWidth = "pmw";
        public static final String VideoCapture2EncodeLatency = "c2el";
        public static final String VideoCaptureStallingIndication = "vcsi";
        public static final String VideoEncodeDesiredBitrate = "epbr";
        public static final String VideoEncodeDesiredFps = "esfr";
        public static final String VideoEncodeHeight = "eh";
        public static final String VideoEncodeId = "eid";
        public static final String VideoEncodeMaxLatency = "eml";
        public static final String VideoEncodeMeanLatency = "eal";
        public static final String VideoEncodeRealFps = "erfr";
        public static final String VideoEncodeRealMaxBitrate = "embr";
        public static final String VideoEncodeRealMeanBitrate = "ebr";
        public static final String VideoEncodeTimeDiff = "emd";
        public static final String VideoEncodeWidth = "ew";
        public static final String VideoPreProcessMaxLatency = "fml";
        public static final String VideoPreProcessMeanLatency = "fal";
        public static final String VideoPtsDtsMaxDiff = "pdmd";
        public static final String VideoPtsMaxDiff = "epd";
    }

    public VideoDataStatistic() {
        initInfo();
    }

    private void initInfo() {
        mVersion = "200.3.3.101";
        mCpuName = CPUTool.getCpuInfo();
    }

    public void setDesiredParam(int i, int i2, int i3, int i4, int i5) {
        if (mPmDesiredEncodeWidth != null) {
            mPmDesiredEncodeWidth.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
        if (mPmDesiredEncodeHeight != null) {
            mPmDesiredEncodeHeight.put(Integer.valueOf(i), Integer.valueOf(i3));
        }
        if (mPmDesiredEncodeBitrate != null) {
            mPmDesiredEncodeBitrate.put(Integer.valueOf(i), Integer.valueOf(i4));
        }
        if (mPmDesiredEncodeFps != null) {
            mPmDesiredEncodeFps.put(Integer.valueOf(i), Integer.valueOf(i5));
        }
    }

    public void setGpuDeviceName(String str) {
        mGpuName = str;
    }

    public void setCameraCaptureFrameRate(int i) {
        mCameraCaptureRealFrameRate = i;
    }

    public void setCameraCaptureMeanLatency(int i) {
        mCameraCaptureMeanLatency = i;
    }

    public void setPreProcessMeanLatency(int i) {
        mPreProcessMeanLatency = i;
    }

    public void setPreProcessMaxLatency(int i) {
        mPreProcessMaxLatency = i;
    }

    public void setVideoEncodeTypeId(int i, int i2) {
        if (mVideoEncodeId != null) {
            mVideoEncodeId.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoEncodeWidth(int i, int i2) {
        if (mVideoEncodeWidth != null) {
            mVideoEncodeWidth.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoEncodeHeight(int i, int i2) {
        if (mVideoEncodeHeight != null) {
            mVideoEncodeHeight.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoEncodeDesiredFps(int i, int i2) {
        if (mRealFps != null) {
            mDesiredFps.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoRealEncodeFps(int i, int i2) {
        if (mRealFps != null) {
            mRealFps.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoRealMinEncodeFps(int i, int i2) {
        if (mRealMinFps != null) {
            mRealMinFps.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoDesiredEncodeBitrate(int i, int i2) {
        if (mDesiredBitrate != null) {
            mDesiredBitrate.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoRealMeanBitrate(int i, int i2) {
        if (mRealMeanBitrate != null) {
            mRealMeanBitrate.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoRealMaxBitrate(int i, int i2) {
        if (mRealMaxBitrate != null) {
            mRealMaxBitrate.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoEncodeMeanLatency(int i, int i2) {
        if (mEncodeMeanLatency != null) {
            mEncodeMeanLatency.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoEncodeMaxLatency(int i, int i2) {
        if (mEncodeMaxLatency != null) {
            mEncodeMaxLatency.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoCapture2EncodeLatency(int i, int i2) {
        if (mVideoCapture2EncodeLatency != null) {
            mVideoCapture2EncodeLatency.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoPtsMaxDiff(int i) {
        mVideoPtsMaxDiff = i;
    }

    public void setVideoCaptureStallingIndication(int i) {
        mVideoCaptureStallingIndication = i;
    }

    public void setVideoPtsDtsMaxDiff(int i, int i2) {
        if (mVideoPtsDtsMaxDiff != null) {
            mVideoPtsDtsMaxDiff.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setVideoEncodeTimeDiff(int i, int i2) {
        if (mVideoEncodeTimeDiff != null) {
            mVideoEncodeTimeDiff.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void setCaptureType(int i) {
        mCaptureType = i;
    }

    public static String getBaseUploadVideoStatistics(int i) {
        if (i < 3) {
            mBaseUploadDataHashMap.put("vver", CommonUtil.toURLEncoded(mVersion));
            mBaseUploadDataHashMap.put("cpu", CommonUtil.toURLEncoded(mCpuName));
            mBaseUploadDataHashMap.put("gpu", CommonUtil.toURLEncoded(mGpuName));
            mBaseUploadDataHashMap.put(AnchorHiidoAssistantStatisticKey.H265SupportInfo, CommonUtil.toURLEncoded(String.valueOf(YYVideoCodec.getSupportH265())));
            String paramsOrderByKey = CommonUtil.getParamsOrderByKey(mBaseUploadDataHashMap);
            YMFLog.info(TAG, "[Procedur]", "upload hiido data:" + paramsOrderByKey);
            return paramsOrderByKey;
        }
        return "";
    }

    public static String getUploadVideoStatistics(boolean z, int i) {
        String paramsOrderByKey;
        if (z) {
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.PmDesiredEncodeWidth, Integer.valueOf(mPmDesiredEncodeWidth.containsKey(Integer.valueOf(i)) ? mPmDesiredEncodeWidth.get(Integer.valueOf(i)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.PmDesiredEncodeHeight, Integer.valueOf(mPmDesiredEncodeHeight.containsKey(Integer.valueOf(i)) ? mPmDesiredEncodeHeight.get(Integer.valueOf(i)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.PmDesiredEncodeBitrate, Integer.valueOf(mPmDesiredEncodeBitrate.containsKey(Integer.valueOf(i)) ? mPmDesiredEncodeBitrate.get(Integer.valueOf(i)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.PmDesiredEncodeFps, Integer.valueOf(mPmDesiredEncodeFps.containsKey(Integer.valueOf(i)) ? mPmDesiredEncodeFps.get(Integer.valueOf(i)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureDesiredFps, Integer.valueOf(CameraInterface.getInstance().getDesiredFps()));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureType, Integer.valueOf(mCaptureType));
            mCoreUploadDataHashMap.put("sw", Integer.valueOf(CameraInterface.getInstance().getCameraPreviewDesiredWidth()));
            mCoreUploadDataHashMap.put("sh", Integer.valueOf(CameraInterface.getInstance().getCameraPreviewDesiredHeight()));
            if (CameraInterface.getInstance().getPreviewSize() != null) {
                mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth, Integer.valueOf(CameraInterface.getInstance().getPreviewSize().width));
            } else {
                mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth, -1);
            }
            if (CameraInterface.getInstance().getPreviewSize() != null) {
                mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureRealResolutionHeight, Integer.valueOf(CameraInterface.getInstance().getPreviewSize().height));
            } else {
                mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureRealResolutionHeight, -1);
            }
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureRealFps, Integer.valueOf(mCameraCaptureRealFrameRate));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureMeanLatency, Integer.valueOf(mCameraCaptureMeanLatency));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoPreProcessMeanLatency, Integer.valueOf(mPreProcessMeanLatency));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoPreProcessMaxLatency, Integer.valueOf(mPreProcessMaxLatency));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeId, mVideoEncodeId.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeWidth, mVideoEncodeWidth.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeHeight, mVideoEncodeHeight.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeDesiredFps, mDesiredFps.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeRealFps, mRealFps.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeDesiredBitrate, mDesiredBitrate.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeRealMeanBitrate, mRealMeanBitrate.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeRealMaxBitrate, mRealMaxBitrate.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeMeanLatency, mEncodeMeanLatency.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeMaxLatency, mEncodeMaxLatency.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoCapture2EncodeLatency, mVideoCapture2EncodeLatency.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoPtsMaxDiff, Integer.valueOf(mVideoPtsMaxDiff));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoCaptureStallingIndication, Integer.valueOf(mVideoCaptureStallingIndication));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoPtsDtsMaxDiff, mVideoPtsDtsMaxDiff.get(Integer.valueOf(i)));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeTimeDiff, mVideoEncodeTimeDiff.get(Integer.valueOf(i)));
            paramsOrderByKey = CommonUtil.getParamsOrderByKey(mCoreUploadDataHashMap);
        } else {
            paramsOrderByKey = CommonUtil.getParamsOrderByKey(mAssistantUploadDataHashMap);
        }
        YMFLog.info(TAG, "[Procedur]", "upload hiido publishId:" + i + " data:" + paramsOrderByKey);
        return paramsOrderByKey;
    }
}
