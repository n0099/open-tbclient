package com.yy.mediaframework.stat;

import android.provider.Settings;
import com.xiaomi.mipush.sdk.Constants;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.GetAnchorStatInfoInterface;
import com.yy.mediaframework.YYVideoSDK;
import com.yy.mediaframework.utils.CPUTool;
import com.yy.mediaframework.utils.InfoUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class VideoDataStat {
    private static final String TAG = "VideoDataStat";
    private static VideoDataStat mInstance = null;
    private static final int mStaticsCycle = 20;
    private GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo mIGetCurrentCameraEncodeStatInfo;
    private GetAnchorStatInfoInterface.IGetImageFilterInfo mIGetImageFilterInfo;
    private int mVideoEncodeId;
    private static LinkedHashMap<String, Object> mAnchorHashMap = new LinkedHashMap<>();
    private static String mVideoRenderPtsMeanDiff = null;
    private static String mVideoRenderPtsMaxDiff = null;
    private static String mVideoEncodingState = null;
    private static VideoRenderTimeStamp mVideoRenderTimeStamp = new VideoRenderTimeStamp();
    private static AtomicBoolean mIsVideoEncodingOn = new AtomicBoolean(true);
    private static long mCameraCaptureFrameRate = 0;
    private static long mPreviewFrameRate = 0;
    private static long mEncodeFrameRate = 0;
    private static long mDynamicEncodeFrameRate = 0;
    private static long mLibMgrBitrate = 0;
    private String mIMEI = "";
    private String mMAC = "";
    private String mARID = "";
    private String mAppPackage = "";
    private String mVersionName = "";
    private String mCpuName = "";
    private ArrayList<Long> mEncodeTimeArr = new ArrayList<>();
    private ArrayList<Long> mPreprocessTimeArr = new ArrayList<>();
    private final Object mQuitObjet = new Object();
    private final Object mEncodeObject = new Object();
    private final Object mPreprocessObject = new Object();
    private final Object syncLock = new Object();

    /* loaded from: classes6.dex */
    private interface AnchorHiidoStatInfoKey {
        public static final String ANDROID_ID = "dr30";
        public static final String APP_PK = "dr29";
        public static final String BeautyAVGTime = "dr54";
        public static final String BeautyLEVEL = "dr21";
        public static final String BeautyMAXTime = "dr55";
        public static final String CameraCaptureFrameRate = "dr51";
        public static final String CameraDirection = "dr18";
        public static final String CameraFramerate = "dr5";
        public static final String CaptureType = "it";
        public static final String CpuInfo = "dr6";
        public static final String CpuMaxFrequency = "dr43";
        public static final String CpuMinFrequency = "dr44";
        public static final String Decals1 = "dr24";
        public static final String Decals2 = "dr25";
        public static final String ENC_TIME_AVG = "dr34";
        public static final String ENC_TIME_MAX = "dr35";
        public static final String EncodeFrameRate = "dr53";
        public static final String FaceLiftLEVEL = "dr23";
        public static final String Fluency = "dr38";
        public static final String FluencyRate = "dr7";
        public static final String IMEI = "dr26";
        public static final String IsBeauty = "dr20";
        public static final String IsFaceLift = "dr22";
        public static final String MAC = "dr27";
        public static final String MobileScreenCap = "dr17";
        public static final String OperationSystemInfoName = "dr10";
        public static final String PREPROCESS_TIME_AVG = "dr36";
        public static final String PREPROCESS_TIME_MAX = "dr37";
        public static final String PSNR = "dr8";
        public static final String Performance_Level = "dr33";
        public static final String PreviewFrameRate = "dr52";
        public static final String RealBitRate = "dr15";
        public static final String RealDPI = "dr14";
        public static final String RealFrameRate = "dr13";
        public static final String ScreenBrightness = "dr40";
        public static final String SettingBitRate = "dr16";
        public static final String SettingCameraDPI = "dr11";
        public static final String SettingFrameRate = "dr12";
        public static final String SettingScreenDirection = "dr19";
        public static final String VER = "dr28";
        public static final String VideoEncodeId = "dr1";
        public static final String VideoEncodingState = "dr45";
        public static final String VideoRenderPtsMaxDiff = "dr47";
        public static final String VideoRenderPtsMeanDiff = "dr46";
    }

    /* loaded from: classes6.dex */
    public static class VideoRenderTimeStamp {
        public List<Long> mVideoRenderPtsMaxDiffList = new ArrayList();
        public List<Long> mVideoRenderPtsMeanDiffList = new ArrayList();
        public List<Integer> mVideoEncodeOnStateList = new ArrayList();
        public long mStartStamp = 0;
        public long mLastStamp = 0;
        public int mFpsCount = 0;
        public long mMeanTimeStampDiffPerSecond = 0;
        public long mMaxTimeStampDiffPerSecond = 0;
    }

    public static VideoDataStat getInstance() {
        if (mInstance == null) {
            mInstance = new VideoDataStat();
        }
        return mInstance;
    }

    public VideoDataStat() {
        initInfo();
    }

    private void initInfo() {
        this.mIMEI = "";
        this.mMAC = InfoUtil.getMacAddr();
        this.mARID = InfoUtil.getAndroidId();
        this.mAppPackage = InfoUtil.getAppPackage();
        this.mVersionName = InfoUtil.getVersionName();
        this.mCpuName = CPUTool.getCpuInfo();
    }

    private int getSystemBrightness() {
        try {
            return Settings.System.getInt(YYVideoSDK.getInstance().getAppContext().getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void setIGetCurrentCameraStatInfo(GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo iGetCurrentCameraEncodeStatInfo) {
        synchronized (this.mQuitObjet) {
            this.mIGetCurrentCameraEncodeStatInfo = iGetCurrentCameraEncodeStatInfo;
        }
    }

    public void setIGetImageFilterInfo(GetAnchorStatInfoInterface.IGetImageFilterInfo iGetImageFilterInfo) {
        synchronized (this.mQuitObjet) {
            this.mIGetImageFilterInfo = iGetImageFilterInfo;
        }
    }

    public void setCameraCaptureFrameRate(long j) {
        mCameraCaptureFrameRate = j;
    }

    public void setPreviewFrameRate(long j) {
        mPreviewFrameRate = j;
    }

    public void setEncodeFrameRate(long j) {
        mEncodeFrameRate = j;
    }

    public void setDynamicEncodeFrameRate(long j) {
        mDynamicEncodeFrameRate = j;
    }

    public int getDynamicEncodeFrameRate() {
        return (int) mDynamicEncodeFrameRate;
    }

    public int getPreviewFrameRate() {
        return (int) mPreviewFrameRate;
    }

    public void setVideoEncodingState(boolean z) {
        YMFLog.warn(this, "[Encoder ]", "upload hiido set VideoLiveFlag:" + z);
        mIsVideoEncodingOn.set(z);
        if (!z) {
            mVideoRenderTimeStamp.mVideoEncodeOnStateList.add(0);
        }
    }

    public int getVideoEncodingFlag() {
        return mIsVideoEncodingOn.get() ? 1 : 0;
    }

    public void clearVideoRenderPtsStatistics() {
        if (mVideoRenderTimeStamp != null) {
            updateVideoRenderPtsDiff();
            synchronized (this.syncLock) {
                mVideoRenderTimeStamp.mVideoRenderPtsMaxDiffList.clear();
                mVideoRenderTimeStamp.mVideoRenderPtsMeanDiffList.clear();
                mVideoRenderTimeStamp.mVideoEncodeOnStateList.clear();
                mVideoRenderTimeStamp.mFpsCount = 0;
                mVideoRenderTimeStamp.mLastStamp = 0L;
                mVideoRenderTimeStamp.mStartStamp = 0L;
                mVideoRenderTimeStamp.mMeanTimeStampDiffPerSecond = 0L;
                mVideoRenderTimeStamp.mMaxTimeStampDiffPerSecond = 0L;
            }
        }
    }

    public void putVideoRenderPtsStatistics(long j, boolean z) {
        if (mVideoRenderTimeStamp != null) {
            synchronized (this.syncLock) {
                if (mVideoRenderTimeStamp.mStartStamp == 0 || mVideoRenderTimeStamp.mLastStamp == 0) {
                    mVideoRenderTimeStamp.mFpsCount = 0;
                    mVideoRenderTimeStamp.mLastStamp = j;
                    mVideoRenderTimeStamp.mStartStamp = j;
                    mVideoRenderTimeStamp.mMeanTimeStampDiffPerSecond = 0L;
                    mVideoRenderTimeStamp.mMaxTimeStampDiffPerSecond = 0L;
                    return;
                }
                long j2 = j - mVideoRenderTimeStamp.mLastStamp;
                if (j2 >= mVideoRenderTimeStamp.mMaxTimeStampDiffPerSecond) {
                    mVideoRenderTimeStamp.mMaxTimeStampDiffPerSecond = j2;
                }
                VideoRenderTimeStamp videoRenderTimeStamp = mVideoRenderTimeStamp;
                videoRenderTimeStamp.mMeanTimeStampDiffPerSecond = j2 + videoRenderTimeStamp.mMeanTimeStampDiffPerSecond;
                mVideoRenderTimeStamp.mLastStamp = j;
                mVideoRenderTimeStamp.mFpsCount++;
                if (j - mVideoRenderTimeStamp.mStartStamp > 1000 && mVideoRenderTimeStamp.mFpsCount != 0) {
                    mVideoRenderTimeStamp.mMeanTimeStampDiffPerSecond /= mVideoRenderTimeStamp.mFpsCount;
                    mVideoRenderTimeStamp.mVideoRenderPtsMeanDiffList.add(Long.valueOf(mVideoRenderTimeStamp.mMeanTimeStampDiffPerSecond));
                    mVideoRenderTimeStamp.mVideoRenderPtsMaxDiffList.add(Long.valueOf(mVideoRenderTimeStamp.mMaxTimeStampDiffPerSecond));
                    mVideoRenderTimeStamp.mVideoEncodeOnStateList.add(Integer.valueOf(getVideoEncodingFlag()));
                    mVideoRenderTimeStamp.mStartStamp = j;
                    mVideoRenderTimeStamp.mFpsCount = 0;
                    mVideoRenderTimeStamp.mMeanTimeStampDiffPerSecond = 0L;
                    mVideoRenderTimeStamp.mMaxTimeStampDiffPerSecond = 0L;
                }
                if (mVideoRenderTimeStamp.mVideoRenderPtsMaxDiffList.size() > 19 || z) {
                    updateVideoRenderPtsDiff();
                    synchronized (this.syncLock) {
                        mVideoRenderTimeStamp.mVideoRenderPtsMaxDiffList.clear();
                        mVideoRenderTimeStamp.mVideoRenderPtsMeanDiffList.clear();
                        mVideoRenderTimeStamp.mVideoEncodeOnStateList.clear();
                    }
                    mVideoRenderTimeStamp.mFpsCount = 0;
                    mVideoRenderTimeStamp.mLastStamp = 0L;
                    mVideoRenderTimeStamp.mStartStamp = 0L;
                    mVideoRenderTimeStamp.mMeanTimeStampDiffPerSecond = 0L;
                    mVideoRenderTimeStamp.mMaxTimeStampDiffPerSecond = 0L;
                }
            }
        }
    }

    public void updateVideoRenderPtsDiff() {
        if (mVideoRenderTimeStamp != null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            synchronized (this.syncLock) {
                for (Long l : mVideoRenderTimeStamp.mVideoRenderPtsMeanDiffList) {
                    if (l.longValue() != 0) {
                        sb.append(l).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                }
                for (Long l2 : mVideoRenderTimeStamp.mVideoRenderPtsMaxDiffList) {
                    if (l2.longValue() != 0) {
                        sb2.append(l2).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                }
                if (mVideoRenderTimeStamp.mVideoEncodeOnStateList.contains(0)) {
                    mVideoEncodingState = String.valueOf(0);
                } else {
                    mVideoEncodingState = String.valueOf(1);
                }
            }
            mVideoRenderPtsMeanDiff = sb.toString();
            mVideoRenderPtsMaxDiff = sb2.toString();
        }
    }

    public String getAnchorVideoData(long j) {
        mAnchorHashMap.put("dr5", Integer.valueOf(CameraInterface.getInstance().getDesiredFps()));
        mAnchorHashMap.put("dr6", toURLEncoded(this.mCpuName));
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.CpuMaxFrequency, Integer.valueOf(CPUTool.getMaxCpuFreq()));
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.CpuMinFrequency, Integer.valueOf(CPUTool.getMinCpuFreq()));
        mAnchorHashMap.put("dr7", Integer.valueOf(CPUTool.getCurCpuFreq()));
        mAnchorHashMap.put("dr10", toURLEncoded(VideoDataStatUtil.getAndroidInfo()));
        synchronized (this.mQuitObjet) {
            if (this.mIGetCurrentCameraEncodeStatInfo != null) {
                mAnchorHashMap.put("dr13", Integer.valueOf(this.mIGetCurrentCameraEncodeStatInfo.onGetAnchorCurrentFrameRate()));
                mAnchorHashMap.put("dr15", Integer.valueOf(this.mIGetCurrentCameraEncodeStatInfo.onGetAnchorCurrentBitRate()));
                mAnchorHashMap.put("dr14", this.mIGetCurrentCameraEncodeStatInfo.onGetAnchorCurrentDIPRate());
            }
        }
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.IMEI, this.mIMEI);
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.ANDROID_ID, this.mARID);
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.MAC, this.mMAC);
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.VER, this.mVersionName);
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.APP_PK, toURLEncoded(this.mAppPackage));
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.MobileScreenCap, 0);
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.CameraDirection, Integer.valueOf(CameraInterface.getInstance().getOrginalCameraFacing()));
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.SettingScreenDirection, Integer.valueOf(CameraInterface.getInstance().getDisplayRotation() != 0 ? 1 : 0));
        synchronized (this.mQuitObjet) {
            if (this.mIGetImageFilterInfo != null) {
                mAnchorHashMap.put(AnchorHiidoStatInfoKey.IsBeauty, Integer.valueOf(convertToInt(this.mIGetImageFilterInfo.onGetHasBeauty())));
                mAnchorHashMap.put(AnchorHiidoStatInfoKey.BeautyLEVEL, Float.valueOf(this.mIGetImageFilterInfo.onGetBeautyLevel()));
                mAnchorHashMap.put(AnchorHiidoStatInfoKey.IsFaceLift, Integer.valueOf(convertToInt(this.mIGetImageFilterInfo.onGetHasFaceLift())));
                mAnchorHashMap.put(AnchorHiidoStatInfoKey.FaceLiftLEVEL, Float.valueOf(this.mIGetImageFilterInfo.onGetFaceLiftLevel()));
                mAnchorHashMap.put(AnchorHiidoStatInfoKey.Decals1, Integer.valueOf(convertToInt(this.mIGetImageFilterInfo.onGetHasSticker())));
                mAnchorHashMap.put(AnchorHiidoStatInfoKey.Decals2, Integer.valueOf(convertToInt(this.mIGetImageFilterInfo.onGetHasDynamicSticker())));
            }
        }
        getFluencyToStat(1001L);
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.Performance_Level, YYVideoSDK.getInstance().getPhonePerformanceLevel());
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.ENC_TIME_AVG, Long.valueOf(getTimeAVGToStat()));
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.PREPROCESS_TIME_AVG, Long.valueOf(getPreprocessTimeArrToStat()));
        clear();
        if (mVideoRenderPtsMaxDiff != null) {
            mAnchorHashMap.put(AnchorHiidoStatInfoKey.VideoRenderPtsMaxDiff, mVideoRenderPtsMaxDiff);
            mVideoRenderPtsMaxDiff = null;
        }
        if (mVideoRenderPtsMeanDiff != null) {
            mAnchorHashMap.put(AnchorHiidoStatInfoKey.VideoRenderPtsMeanDiff, mVideoRenderPtsMeanDiff);
            mVideoRenderPtsMeanDiff = null;
        }
        if (mVideoEncodingState != null) {
            mAnchorHashMap.put(AnchorHiidoStatInfoKey.VideoEncodingState, mVideoEncodingState);
            mVideoEncodingState = null;
        }
        mAnchorHashMap.put("dr40", Integer.valueOf(getSystemBrightness()));
        mAnchorHashMap.put("it", VideoDataStatUtil.getCaptureType());
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.CameraCaptureFrameRate, Long.valueOf(mCameraCaptureFrameRate));
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.PreviewFrameRate, Long.valueOf(mPreviewFrameRate));
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.EncodeFrameRate, Long.valueOf(mEncodeFrameRate));
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.BeautyAVGTime, VideoDataStatUtil.getBeautyTime());
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.BeautyMAXTime, VideoDataStatUtil.getMaxBeautyTime());
        String paramsOrderByKey = VideoDataStatUtil.getParamsOrderByKey(mAnchorHashMap);
        YMFLog.info(this, "[Procedur]", "upload hiido data:" + paramsOrderByKey);
        mAnchorHashMap.remove("dr8");
        return paramsOrderByKey;
    }

    private int convertToInt(boolean z) {
        return z ? 1 : 0;
    }

    public void putSettingBitRate(int i) {
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.SettingBitRate, Integer.valueOf(i));
    }

    public void putVideoPsnr(double d) {
        String str = (mAnchorHashMap.get("dr8") == null ? "" : ((String) mAnchorHashMap.get("dr8")) + ",") + String.format("%.2f", Double.valueOf(d));
        mAnchorHashMap.put("dr8", str);
        YMFLog.info(this, "[Encoder ]", "putVideoPsnr:" + str);
    }

    public void putSettingDPI(String str) {
        mAnchorHashMap.put("dr11", str);
    }

    public void putSettingFrameRate(int i) {
        mAnchorHashMap.put("dr12", Integer.valueOf(i));
    }

    public String toURLEncoded(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
        } catch (Exception e) {
            YMFLog.error(this, "[Encoder ]", "toURLEncoded exception:" + e.toString());
            return "";
        }
    }

    public void putVideoEncodeIdToStat(int i) {
        this.mVideoEncodeId = i;
        mAnchorHashMap.put("dr1", Integer.valueOf(i));
    }

    public int getVideoEncodeId() {
        return this.mVideoEncodeId;
    }

    public void putTimeAVGToStat(long j) {
        synchronized (this.mEncodeObject) {
            this.mEncodeTimeArr.add(Long.valueOf(j));
        }
    }

    public void putPreprocessTimeArrToStat(long j) {
        synchronized (this.mPreprocessObject) {
            this.mPreprocessTimeArr.add(Long.valueOf(j));
        }
    }

    public void clear() {
        synchronized (this.mEncodeObject) {
            if (this.mEncodeTimeArr != null) {
                this.mEncodeTimeArr.clear();
            }
        }
        synchronized (this.mPreprocessObject) {
            if (this.mPreprocessTimeArr != null) {
                this.mPreprocessTimeArr.clear();
            }
        }
    }

    private void getFluencyToStat(long j) {
        int fluency = VideoDataStatUtil.getFluency(j);
        if (fluency != -1) {
            mAnchorHashMap.put(AnchorHiidoStatInfoKey.Fluency, Integer.valueOf(fluency));
        }
    }

    private long getTimeAVGToStat() {
        long j = 0;
        synchronized (this.mEncodeObject) {
            if (this.mEncodeTimeArr.size() != 0) {
                Iterator<Long> it = this.mEncodeTimeArr.iterator();
                long j2 = 0;
                while (it.hasNext()) {
                    j2 = it.next().longValue() + j2;
                }
                j = j2 / this.mEncodeTimeArr.size();
            }
        }
        return j;
    }

    private long getPreprocessTimeArrToStat() {
        long j = 0;
        synchronized (this.mPreprocessObject) {
            if (this.mPreprocessTimeArr.size() != 0) {
                Iterator<Long> it = this.mPreprocessTimeArr.iterator();
                long j2 = 0;
                while (it.hasNext()) {
                    j2 = it.next().longValue() + j2;
                }
                j = j2 / this.mPreprocessTimeArr.size();
            }
        }
        return j;
    }

    public void putTimeMAXToStat(long j) {
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.ENC_TIME_MAX, Long.valueOf(j));
    }

    public void putPreprocessTimeMaxToStat(long j) {
        mAnchorHashMap.put(AnchorHiidoStatInfoKey.PREPROCESS_TIME_MAX, Long.valueOf(j));
    }
}
