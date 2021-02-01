package com.yy.mediaframework;

import android.content.Context;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.Passthrough;
import com.yy.mediaframework.gpuimage.custom.PhonePerformanceLevel;
import com.yy.mediaframework.utils.CPUTool;
import com.yy.mediaframework.utils.YMFLog;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class YYVideoSDK {
    private static volatile YYVideoSDK instance;
    public boolean mIsEmulator;
    private static byte[] SYNC_FLAG = new byte[1];
    private static long sDeltaPtsDts = 0;
    private String mAppVersion = "";
    private Context mApplicationContext = null;
    private String mAppName = "";
    private String mDeviceOsVersion = "";
    private String mDeviceModel = "";
    private String mLogPath = null;
    private boolean mUseMultiLianmai = false;
    private boolean mIsEnableSTLibrary = false;
    private boolean mIsEnableVenusLibrary = false;
    private boolean mIsEnableMTLibrary = false;
    private boolean mUseGLClear = false;
    private int mNewPtsStrategy = 0;
    private IVideoLibInfo mVideoLibInfo = null;
    private PhonePerformanceLevel mPhonePerformanceLevel = PhonePerformanceLevel.Level_0;
    private IYYVideoLib2YCloud mYYVideoLib2YCloudListener = null;
    private Constant.MultiLianmaiMode mMultiLianmaiMode = Constant.MultiLianmaiMode.NormalMode;

    public static YYVideoSDK getInstance() {
        if (instance == null) {
            synchronized (SYNC_FLAG) {
                if (instance == null) {
                    instance = new YYVideoSDK();
                }
            }
        }
        return instance;
    }

    public YYVideoSDK() {
        this.mIsEmulator = false;
        this.mIsEmulator = CPUTool.isEmulator();
        if (this.mIsEmulator) {
            YMFLiveAPI.getInstance().setYuvCanvasMode(true);
        }
        YMFLog.info(this, "[Api     ]", "mIsEmulator:" + this.mIsEmulator);
    }

    public void initSDK(Context context, String str, String str2, String str3, String str4, String str5) {
        this.mApplicationContext = context.getApplicationContext();
        this.mAppVersion = str;
        this.mAppName = str2;
        setDeviceOsVersion(str3);
        setDeviceModel(str4);
        this.mLogPath = str5;
        YMFLog.setFilePath(this.mLogPath);
        if (this.mIsEmulator) {
            YMFLiveAPI.getInstance().setYuvCanvasMode(true);
        }
        YMFLog.info(this, "[Api     ]", "initSDK");
        YMFLog.info(this, "[Api     ]", "********************************************************************");
        YMFLog.info(this, "[Api     ]", "YYVideoLib Version  : 200.3.3.101");
        YMFLog.info(this, "[Api     ]", "Application Name    : " + this.mAppName);
        YMFLog.info(this, "[Api     ]", "Device Model        : " + this.mDeviceModel);
        YMFLog.info(this, "[Api     ]", "Android Version     : " + this.mDeviceOsVersion);
        YMFLog.info(this, "[Api     ]", "Flavor              : full");
        YMFLog.info(this, "[Api     ]", "********************************************************************");
    }

    public void setMultiVideoLianmaiMode(boolean z) {
        YMFLog.info(this, "[Procedur]", "setMultiVideoLianmaiMode:" + z);
        this.mUseMultiLianmai = z;
    }

    public void setMultiVideoLianmaiMode(Constant.MultiLianmaiMode multiLianmaiMode) {
        YMFLog.info(this, "[Procedur]", "setMultiVideoLianmaiMode:" + multiLianmaiMode);
        this.mMultiLianmaiMode = multiLianmaiMode;
        if (this.mMultiLianmaiMode != Constant.MultiLianmaiMode.NormalMode) {
            this.mUseMultiLianmai = true;
        } else {
            this.mUseMultiLianmai = false;
        }
    }

    public boolean isMultiVideoLianmaiMode() {
        return this.mUseMultiLianmai;
    }

    public Constant.MultiLianmaiMode getMultiVideoLianmaiMode() {
        return this.mMultiLianmaiMode;
    }

    public long getUid() {
        if (this.mVideoLibInfo == null) {
            return 0L;
        }
        return this.mVideoLibInfo.getUid();
    }

    public long getTopSid() {
        if (this.mVideoLibInfo == null) {
            return 0L;
        }
        return this.mVideoLibInfo.getTopSid();
    }

    public long getSubSid() {
        if (this.mVideoLibInfo == null) {
            return 0L;
        }
        return this.mVideoLibInfo.getSubSid();
    }

    public String getPackageName() {
        return this.mVideoLibInfo == null ? "" : this.mVideoLibInfo.getPackageName();
    }

    public String getAppName() {
        return this.mAppName;
    }

    public void setAppVersion(String str) {
        this.mAppVersion = str;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public Context getAppContext() {
        return this.mApplicationContext;
    }

    public void setAppContext(Context context) {
        this.mApplicationContext = context;
    }

    public String getDeviceOsVersion() {
        return this.mDeviceOsVersion;
    }

    public void setDeviceOsVersion(String str) {
        this.mDeviceOsVersion = str;
    }

    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    public void setDeviceModel(String str) {
        this.mDeviceModel = str;
    }

    public void setVideoInfoListener(IVideoLibInfo iVideoLibInfo) {
        this.mVideoLibInfo = iVideoLibInfo;
    }

    public void setPhonePerformanceLevel(PhonePerformanceLevel phonePerformanceLevel) {
        YMFLog.info(this, "[Beauty  ]", "set beauty_level:" + phonePerformanceLevel);
        this.mPhonePerformanceLevel = phonePerformanceLevel;
    }

    public PhonePerformanceLevel getPhonePerformanceLevel() {
        return this.mPhonePerformanceLevel;
    }

    public void setUseGLClear(boolean z) {
        this.mUseGLClear = z;
    }

    public boolean enableGLClear() {
        return this.mUseGLClear;
    }

    public void enableSTLibrary(boolean z) {
        this.mIsEnableSTLibrary = z;
        YMFLog.info(this, "[Beauty  ]", "enableSTLibrary:" + z);
        this.mIsEnableMTLibrary = false;
        this.mIsEnableVenusLibrary = false;
    }

    public void enableVenusLibrary(boolean z) {
        this.mIsEnableVenusLibrary = z;
        YMFLog.info(this, "[Beauty  ]", "enableVenusLibrary:" + z);
        this.mIsEnableMTLibrary = false;
        this.mIsEnableSTLibrary = false;
    }

    public void enableMTLibrary(boolean z) {
        this.mIsEnableMTLibrary = z;
        YMFLog.info(this, "[Beauty  ]", "enableVenusLibrary:" + z);
        this.mIsEnableSTLibrary = false;
        this.mIsEnableSTLibrary = false;
    }

    public boolean isEnableSTLibrary() {
        return this.mIsEnableSTLibrary;
    }

    public boolean isEnableMTLibrary() {
        return this.mIsEnableMTLibrary;
    }

    public boolean isEnableVenusLibrary() {
        return this.mIsEnableVenusLibrary;
    }

    public void setDeltaYYPtsMillions(long j) {
        sDeltaPtsDts = j;
    }

    public long getDeltaYYPtsMillions() {
        return sDeltaPtsDts;
    }

    public void setPtsStrategy(int i) {
        YMFLog.info(this, "[Encoder ]", "setPtsStrategy:" + i);
        this.mNewPtsStrategy = i;
    }

    public int getPtsStrategy() {
        YMFLog.info(this, "[Encoder ]", "getPtsStrategy:" + this.mNewPtsStrategy);
        return this.mNewPtsStrategy;
    }

    public void setYYVideoLib2YCloudListener(IYYVideoLib2YCloud iYYVideoLib2YCloud) {
        this.mYYVideoLib2YCloudListener = iYYVideoLib2YCloud;
    }

    public IYYVideoLib2YCloud getYYVideoLib2YCloudListener() {
        return this.mYYVideoLib2YCloudListener;
    }

    public void setPassthroughDataDown(int i, HashMap hashMap) {
        switch (i) {
            case 1:
                handlePassthroughPtsStrategy((Integer) hashMap.get(Passthrough.METUseNewPtsStrategy.ptsStrategyKey));
                return;
            default:
                return;
        }
    }

    private void handlePassthroughPtsStrategy(Integer num) {
        YMFLog.info(this, "[Encoder ]", "handlePassthroughPtsStrategy:" + num.intValue());
        setPtsStrategy(num.intValue());
    }
}
