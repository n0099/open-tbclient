package com.yy.mediaframework.stat;

import android.os.Build;
import androidx.annotation.NonNull;
import com.yy.mediaframework.IYYVideoLib2YCloud;
import com.yy.mediaframework.YYVideoSDK;
import com.yy.mediaframework.utils.InfoUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class VideoLibExceptionDataStat {
    private static final String ANCHOR = "0";
    public static final String ENCODE = "0";
    private static final int OS = 1;
    public static final String RENDER = "2";
    private static final String TABLE = "mobilevideoexceptionstatist";
    private static final String TABLE_NAME = "tableName";
    private static final String TAG = "VideoLibExceptionDataStat";
    private static VideoLibExceptionDataStat mInstance;
    private static LinkedHashMap<String, Object> mVideoLibExceptionHashMap = new LinkedHashMap<>();

    /* loaded from: classes6.dex */
    public interface EncodeExceptionID {
        public static final String ENCODE_BLOCK = "0";
        public static final String ENCODE_CHANGE_SOFT = "5";
        public static final String ENCODE_EXCEPTION = "1";
        public static final String ENCODE_INIT_EXCEPTION = "2";
        public static final String ENCODE_PARSE_ERROR = "4";
        public static final String ENCODE_RESET_EXCEPTION = "3";
        public static final String ENCODE_STOP_BLOCKED = "6";
    }

    /* loaded from: classes6.dex */
    public interface RenderExceptionID {
        public static final String DEINIT_ERROR = "103";
        public static final String INIT_ERROR = "101";
        public static final String RENDER_ERROR = "102";
    }

    /* loaded from: classes6.dex */
    public interface VideoLibExceptionInfoKey {
        public static final String APP_VERSION = "dr14";
        public static final String DTS = "dr10";
        public static final String ENCODER_STATE = "dr0";
        public static final String EXCEPTION_ID = "dr5";
        public static final String EXCEPTION_REASON = "dr6";
        public static final String LastInputPts = "dr15";
        public static final String MODEL = "dr8";
        public static final String MODULE_TYPE = "dr3";
        public static final String OS = "dr13";
        public static final String PTS = "dr9";
        public static final String RESOLUTION = "dr12";
        public static final String STREAM_ID = "dr7";
        public static final String SYSTEM_INFO = "dr1";
        public static final String UPLOAD_TIME = "dr11";
        public static final String VIDEO_DECODE_ID = "dr4";
        public static final String VIDEO_TYPE = "dr2";
    }

    public static VideoLibExceptionDataStat getInstance() {
        if (mInstance == null) {
            synchronized (VideoLibExceptionDataStat.class) {
                if (mInstance == null) {
                    mInstance = new VideoLibExceptionDataStat();
                }
            }
        }
        return mInstance;
    }

    private VideoLibExceptionDataStat() {
        initInfo();
    }

    @NonNull
    public synchronized void pushDecodeExceptionDataStat(String str, String str2, String str3) {
        IYYVideoLib2YCloud yYVideoLib2YCloudListener = YYVideoSDK.getInstance().getYYVideoLib2YCloudListener();
        if (yYVideoLib2YCloudListener != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dr5", str2);
            hashMap.put("dr6", VideoDataStatUtil.toURLEncoded(str3));
            mVideoLibExceptionHashMap.put(VideoLibExceptionInfoKey.VIDEO_DECODE_ID, Integer.valueOf(VideoDataStatUtil.getVideoEncodeId()));
            mVideoLibExceptionHashMap.put("dr7", 1001);
            mVideoLibExceptionHashMap.put(VideoLibExceptionInfoKey.MODULE_TYPE, str);
            mVideoLibExceptionHashMap.put("dr11", VideoDataStatUtil.getCurrentTime());
            mVideoLibExceptionHashMap.put(TABLE_NAME, TABLE);
            mVideoLibExceptionHashMap.putAll(hashMap);
            YMFLog.error(this, "[Procedur]", "exception data:" + mVideoLibExceptionHashMap.toString());
            yYVideoLib2YCloudListener.onPassthroughDataUp(2, 1, mVideoLibExceptionHashMap);
        } else {
            YMFLog.error(this, "[Procedur]", "IYYVideoLib2YCloud is null");
        }
    }

    public synchronized void pushDecodeExceptionDataStat(long j, HashMap<String, Object> hashMap) {
        IYYVideoLib2YCloud yYVideoLib2YCloudListener = YYVideoSDK.getInstance().getYYVideoLib2YCloudListener();
        if (yYVideoLib2YCloudListener != null) {
            mVideoLibExceptionHashMap.put(VideoLibExceptionInfoKey.VIDEO_DECODE_ID, Integer.valueOf(VideoDataStatUtil.getVideoEncodeId()));
            mVideoLibExceptionHashMap.put("dr7", Long.valueOf(j));
            mVideoLibExceptionHashMap.put(VideoLibExceptionInfoKey.MODULE_TYPE, "0");
            mVideoLibExceptionHashMap.put("dr11", VideoDataStatUtil.getCurrentTime());
            mVideoLibExceptionHashMap.put(TABLE_NAME, TABLE);
            mVideoLibExceptionHashMap.putAll(hashMap);
            YMFLog.error(this, "[Procedur]", "exception data:" + mVideoLibExceptionHashMap.toString());
            yYVideoLib2YCloudListener.onPassthroughDataUp(2, 1, mVideoLibExceptionHashMap);
        } else {
            YMFLog.error(this, "[Procedur]", "IYYVideoLib2YCloud is null");
        }
    }

    private void initInfo() {
        mVideoLibExceptionHashMap.put("dr1", VideoDataStatUtil.toURLEncoded(VideoDataStatUtil.getAndroidInfo()));
        mVideoLibExceptionHashMap.put(VideoLibExceptionInfoKey.VIDEO_TYPE, "0");
        mVideoLibExceptionHashMap.put("dr13", 1);
        mVideoLibExceptionHashMap.put("dr14", InfoUtil.getVersionName());
        mVideoLibExceptionHashMap.put("dr8", VideoDataStatUtil.toURLEncoded(Build.MODEL));
    }

    public void setDecoderPTS(String str) {
        mVideoLibExceptionHashMap.put(VideoLibExceptionInfoKey.PTS, str);
    }

    public void setDecoderDTS(String str) {
        mVideoLibExceptionHashMap.put("dr10", str);
    }

    public void setDecoderResolution(String str) {
        mVideoLibExceptionHashMap.put("dr12", str);
    }
}
