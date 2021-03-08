package com.yy.mediaframework.stat;

import android.util.SparseArray;
import com.yy.mediaframework.GetAnchorStatInfoInterface;
import com.yy.mediaframework.utils.YMFLog;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class UploadStatManager {
    private static final byte[] SYNC_FLAG = new byte[1];
    public static final String TAG = "UploadStatManager ";
    private static final int UPLOAD_TIME = 5000;
    private static volatile UploadStatManager mInstance;
    private long mPreprocessBeginTs = 0;
    private long mPreprocessTimeMax = 0;
    private SparseArray<Long> mEncodePts2Begin = new SparseArray<>();
    private long mEncodeTimeMax = 0;
    private HashMap<String, Long> mHashMap = new HashMap<>();

    public static synchronized UploadStatManager getInstance() {
        UploadStatManager uploadStatManager;
        synchronized (UploadStatManager.class) {
            if (mInstance == null) {
                synchronized (SYNC_FLAG) {
                    if (mInstance == null) {
                        mInstance = new UploadStatManager();
                    }
                }
            }
            uploadStatManager = mInstance;
        }
        return uploadStatManager;
    }

    public void startStat() {
        this.mPreprocessTimeMax = 0L;
        this.mEncodeTimeMax = 0L;
        this.mEncodePts2Begin.clear();
        VideoDataStat.getInstance().clear();
    }

    public void stopStat() {
        YMFLog.info(this, "[Encoder ]", "stopStat");
        VideoDataStat.getInstance().clear();
        VideoDataStat.getInstance().clearVideoRenderPtsStatistics();
    }

    public void beginPreprocess() {
        this.mPreprocessBeginTs = System.currentTimeMillis();
    }

    public void endPreprocess() {
        if (this.mPreprocessBeginTs != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mPreprocessBeginTs;
            if (currentTimeMillis > this.mPreprocessTimeMax) {
                this.mPreprocessTimeMax = currentTimeMillis;
            }
            VideoDataStat.getInstance().putPreprocessTimeArrToStat(currentTimeMillis);
            VideoDataStat.getInstance().putPreprocessTimeMaxToStat(this.mPreprocessTimeMax);
        }
    }

    public void beginEncode(int i) {
        this.mEncodePts2Begin.put(i, Long.valueOf(System.currentTimeMillis()));
    }

    public void endEncode(int i) {
        Long l;
        if (i > 0 && (l = this.mEncodePts2Begin.get(i)) != null) {
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            if (currentTimeMillis > this.mEncodeTimeMax) {
                this.mEncodeTimeMax = currentTimeMillis;
            }
            VideoDataStat.getInstance().putTimeAVGToStat(currentTimeMillis);
            VideoDataStat.getInstance().putTimeMAXToStat(this.mEncodeTimeMax);
        }
    }

    public void reportEncException(HashMap<String, Object> hashMap) {
        VideoLibExceptionDataStat.getInstance().pushDecodeExceptionDataStat(1001L, hashMap);
    }

    public void reportException(String str, String str2, String str3) {
        Long l;
        if (this.mHashMap == null || (l = this.mHashMap.get(str2)) == null || System.currentTimeMillis() - l.longValue() >= 5000) {
            this.mHashMap.put(str2, Long.valueOf(System.currentTimeMillis()));
            VideoLibExceptionDataStat.getInstance().pushDecodeExceptionDataStat(str, str2, str3);
        }
    }

    public void setDecoderResolution(String str) {
        VideoLibExceptionDataStat.getInstance().setDecoderResolution(str);
    }

    public void putVideoEncodeIdToStat(int i) {
        VideoDataStat.getInstance().putVideoEncodeIdToStat(i);
    }

    public void putSettingFrameRate(int i) {
        VideoDataStat.getInstance().putSettingFrameRate(i);
    }

    public void putSettingBitRate(int i) {
        VideoDataStat.getInstance().putSettingBitRate(i);
    }

    public void putSettingDPI(String str) {
        VideoDataStat.getInstance().putSettingDPI(str);
    }

    public void putVideoPsnr(double d) {
        VideoDataStat.getInstance().putVideoPsnr(d);
    }

    public void setIGetCurrentCameraStatInfo(GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo iGetCurrentCameraEncodeStatInfo) {
        VideoDataStat.getInstance().setIGetCurrentCameraStatInfo(iGetCurrentCameraEncodeStatInfo);
    }

    public void setIGetImageFilterInfo(GetAnchorStatInfoInterface.IGetImageFilterInfo iGetImageFilterInfo) {
        VideoDataStat.getInstance().setIGetImageFilterInfo(iGetImageFilterInfo);
    }
}
