package com.yy.videoplayer.decoder;

import android.content.Context;
import com.yy.videoplayer.IVideoInfoCallback;
import com.yy.videoplayer.IVideoLibInfoExt;
import com.yy.videoplayer.VideoDecodeEventNotify;
import com.yy.videoplayer.VideoRenderNotify;
import com.yy.videoplayer.utils.TimeUtil;
import com.yy.videoplayer.utils.YMFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes6.dex */
public class YYVideoLibMgr {
    private static final String TAG = "YYVideoLibMgr";
    private static YYVideoLibMgr mInstance = null;
    private static byte[] SYNC_FLAG = new byte[1];
    private static boolean mOnlyDeconded = false;
    private String mAppVersion = "";
    private Context mApplicationContext = null;
    private String mAppName = "";
    private String mDeviceOsVersion = "";
    private String mDeviceModel = "";
    private String mLogPath = null;
    private ConcurrentLinkedQueue<IVideoLibInfoExt> mYYVideoLibInfoList = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<IVideoInfoCallback> mVideoInfoCBList = new ConcurrentLinkedQueue<>();
    private ConcurrentHashMap<String, IVideoLibInfoExt> mYYVideoLibInfoMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, IVideoInfoCallback> mVideoInfoCBMap = new ConcurrentHashMap<>();
    private int mHardDirectRenderConfig = 0;
    private ReentrantReadWriteLock syncLock = new ReentrantReadWriteLock();

    /* loaded from: classes6.dex */
    public static class MediaDecodeConfigKey {
        public static final int CCK_H265_HARDWARE_DECODE = 316;
        public static final int CCK_HARDWARE_DECODE = 302;
        public static final int CCK_HARD_DECODE_DIRECT_RENDER = 0;
    }

    static {
        try {
            System.loadLibrary("yydec265");
            YMFLog.info(null, "[Decoder ]", "loadLibrary yydec265...");
        } catch (UnsatisfiedLinkError e) {
            YMFLog.error((Object) null, "[Decoder ]", "loadLibrary yydec265 Exception:" + e.toString());
        }
    }

    public static YYVideoLibMgr instance() {
        if (mInstance == null) {
            synchronized (SYNC_FLAG) {
                if (mInstance == null) {
                    mInstance = new YYVideoLibMgr();
                }
            }
        }
        return mInstance;
    }

    public void init(Context context, String str, String str2, String str3, String str4, String str5) {
        this.mApplicationContext = context.getApplicationContext();
        this.mAppVersion = str;
        this.mAppName = str2;
        this.mDeviceOsVersion = str3;
        this.mDeviceModel = str4;
        this.mLogPath = str5;
        if (this.mLogPath != null) {
            YMFLog.setFilePath(this.mLogPath);
        }
        GLVersionUtils.holdGLVersion(this.mApplicationContext);
        StateMonitor.instance().init();
        YMFLog.info(this, "[Api     ]", " ********************************************************************\n * YYVideoPlayer Version  : 200.3.3.101\n * Application Name    : " + this.mAppName + "\n * Application Version : " + this.mAppVersion + "\n * Device Model        : " + this.mDeviceModel + "\n * Android Version     : " + this.mDeviceOsVersion + "\n * OpenGL ES Version   : " + Integer.toHexString(GLVersionUtils.getGlVersion()) + "\n * Flavor              : full\n * sw265               : true\n ********************************************************************");
    }

    public void deInit(String str) {
        this.mAppVersion = "";
        this.mAppName = "";
        this.mDeviceOsVersion = "";
        this.mDeviceModel = "";
        this.mLogPath = null;
        YMFLog.setFilePath(null);
        this.syncLock.writeLock().lock();
        IVideoLibInfoExt remove = this.mYYVideoLibInfoMap.remove(str);
        if (remove != null) {
            this.mYYVideoLibInfoList.remove(remove);
        }
        IVideoInfoCallback remove2 = this.mVideoInfoCBMap.remove(str);
        if (remove2 != null) {
            this.mVideoInfoCBList.remove(remove2);
        }
        this.syncLock.writeLock().unlock();
        mInstance = null;
        YMFLog.info(this, "[Api     ]", "deInit " + this.mYYVideoLibInfoMap.size() + ":" + this.mVideoInfoCBMap.size());
    }

    public long getUserId() {
        return 0L;
    }

    public long getTopSid() {
        return 0L;
    }

    public long getSubSid() {
        return 0L;
    }

    public String getLogFilePath() {
        return this.mLogPath;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public Context getAppContext() {
        return this.mApplicationContext;
    }

    public String getDeviceOsVersion() {
        return this.mDeviceOsVersion;
    }

    public void setConfig(int i, Object obj) {
        switch (i) {
            case 0:
                if (obj != null && (obj instanceof Integer)) {
                    this.mHardDirectRenderConfig = ((Integer) obj).intValue();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int getHardDirectRender() {
        return this.mHardDirectRenderConfig;
    }

    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    public void setVideoInfoListener(String str, IVideoLibInfoExt iVideoLibInfoExt) {
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() != 0) {
            Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
            while (it.hasNext()) {
                if (it.next().equals(iVideoLibInfoExt)) {
                    this.syncLock.readLock().unlock();
                    return;
                }
            }
        }
        this.syncLock.readLock().unlock();
        this.syncLock.writeLock().lock();
        this.mYYVideoLibInfoList.add(iVideoLibInfoExt);
        this.mYYVideoLibInfoMap.put(str, iVideoLibInfoExt);
        this.syncLock.writeLock().unlock();
    }

    public void setVideoInfoCallback(String str, IVideoInfoCallback iVideoInfoCallback) {
        this.syncLock.readLock().lock();
        if (this.mVideoInfoCBList.size() != 0) {
            Iterator<IVideoInfoCallback> it = this.mVideoInfoCBList.iterator();
            while (it.hasNext()) {
                if (it.next().equals(iVideoInfoCallback)) {
                    this.syncLock.readLock().unlock();
                    return;
                }
            }
        }
        this.syncLock.readLock().unlock();
        this.syncLock.writeLock().lock();
        this.mVideoInfoCBList.add(iVideoInfoCallback);
        this.mVideoInfoCBMap.put(str, iVideoInfoCallback);
        this.syncLock.writeLock().unlock();
    }

    public void onViewPlayEventNotify(long j, long j2, int i, long j3) {
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().onViewPlayEventNotify(j, j2, i, j3);
        }
        this.syncLock.readLock().unlock();
    }

    public void onVideoRenderNotify(ArrayList<VideoRenderNotify> arrayList) {
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().onVideoRenderNotify(arrayList);
        }
        this.syncLock.readLock().unlock();
    }

    public void onViewStateNotify(long j, int i) {
        YMFLog.info(this, "[Render  ]", "onViewStateNotify streamId:" + j + " viewState" + i);
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().onViewStateNotify(j, i);
        }
        this.syncLock.readLock().unlock();
    }

    public void onFirstFrameRenderNotify(long j, long j2, long j3, long j4, int i) {
        YMFLog.info(this, "[Render  ]", "onFirstFrameRenderNotify userGroupId:" + j + " streamId:" + j2 + ",now " + TimeUtil.getTickCountLong());
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() != 0) {
            Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
            while (it.hasNext()) {
                it.next().onFirstFrameRenderNotify(j, j2, j3, j4, i);
            }
        }
        this.syncLock.readLock().unlock();
    }

    public void onCoefficientOfVariationOfRenderInterval(long j, long j2, long j3, double d) {
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().onCoefficientOfVariationOfRenderInterval(j, j2, j3, d);
        }
        this.syncLock.readLock().unlock();
    }

    public void setConfigs(int i, Map<Integer, Integer> map) {
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().setConfigs(i, map);
        }
        this.syncLock.readLock().unlock();
    }

    public int getConfig(int i) {
        return 0;
    }

    public void notifyHardwareCodecConfigured(boolean z, boolean z2, boolean z3, boolean z4) {
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList == null) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().notifyHardwareCodecConfigured(z, z2, z3, z4);
        }
        this.syncLock.readLock().unlock();
    }

    public boolean isLibraryLoaded() {
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return false;
        }
        this.syncLock.readLock().unlock();
        return this.mYYVideoLibInfoList.peek().isLibraryLoaded();
    }

    public Context getmCtx() {
        return null;
    }

    public void setRunTimeStamp(String str, long j) {
    }

    public boolean getIsRooted() {
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return false;
        }
        this.syncLock.readLock().unlock();
        return this.mYYVideoLibInfoList.peek().HWCodecConfigGetIsRooted();
    }

    public void onFirstFrameSeeNotify(long j, long j2, int i, int i2) {
        YMFLog.info(this, "[Render  ]", "onFirstFrameSeeNotify  streamId:" + j + ":" + i + "*" + i2 + ":" + j2 + ",now " + TimeUtil.getTickCountLong());
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().onFirstFrameSeeNotify(j, j2, i, i2);
        }
        this.syncLock.readLock().unlock();
    }

    public void onHardwareDecodeErrorNotify(long j, long j2, int i) {
        YMFLog.error(this, "[Decoder ]", "onHardwareDecodeErrorNotify userGroupId:" + j + " streamId:" + j2 + " errorType:" + i);
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().onHardwareDecodeErrorNotify(j, j2, i);
        }
        this.syncLock.readLock().unlock();
    }

    public void onHardwareDecodeWrongFrameNotify(long j, String str, byte[] bArr, byte[] bArr2) {
        YMFLog.error(this, "[Decoder ]", "onHardwareDecodeWrongFrameNotify streamID:" + j + " name:" + str);
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().onHardwareDecodeWrongFrameNotify(j, str, bArr, bArr2);
        }
        this.syncLock.readLock().unlock();
    }

    public void onDecodedFrameData(long j, int i, int i2, byte[] bArr, int i3, long j2) {
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDecodedFrameData(j, i, i2, bArr, i3, j2);
            } catch (Exception e) {
                YMFLog.error(this, "[Decoder ]", "onDecodedFrameData exception:" + e.toString());
            }
        }
        this.syncLock.readLock().unlock();
    }

    public static void OnFirstFrameDecodeNotify(long j, long j2, long j3) {
        instance().onFirstFrameDecodeNotify(j, j2, j3);
    }

    public void onFirstFrameDecodeNotify(long j, long j2, long j3) {
        YMFLog.info(this, "[Decoder ]", "onFirstFrameDecodeNotify " + j + ", pts:" + j2 + ", happenTime:" + j3);
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().onFirstFrameDecodeNotify(j, j2, j3);
        }
        this.syncLock.readLock().unlock();
    }

    public void onDecodeEventNotify(VideoDecodeEventNotify videoDecodeEventNotify) {
        this.syncLock.readLock().lock();
        if (this.mYYVideoLibInfoList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoLibInfoExt> it = this.mYYVideoLibInfoList.iterator();
        while (it.hasNext()) {
            it.next().onDecodeEventNotify(videoDecodeEventNotify);
        }
        this.syncLock.readLock().unlock();
    }

    public void onUpdatePts(long j, long j2) {
        this.syncLock.readLock().lock();
        if (this.mVideoInfoCBList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoInfoCallback> it = this.mVideoInfoCBList.iterator();
        while (it.hasNext()) {
            it.next().onUpdatePts(j, j2);
        }
        this.syncLock.readLock().unlock();
    }

    public void onUpdateVideoSizeChanged(long j, int i, int i2) {
        this.syncLock.readLock().lock();
        if (this.mVideoInfoCBList.size() == 0) {
            this.syncLock.readLock().unlock();
            return;
        }
        Iterator<IVideoInfoCallback> it = this.mVideoInfoCBList.iterator();
        while (it.hasNext()) {
            it.next().onUpdateVideoSizeChanged(j, i, i2);
        }
        this.syncLock.readLock().unlock();
    }

    public static void notifySetOnlyDecoded(boolean z) {
        YMFLog.info(TAG, "[Decoder ]", "notifySetOnlyDecoded:" + z);
        mOnlyDeconded = z;
    }

    public static boolean getOnlyDecoded() {
        return mOnlyDeconded;
    }
}
