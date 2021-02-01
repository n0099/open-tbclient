package com.yy.mediaframework.stat;

import android.os.Build;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.webkit.internal.ETAG;
import com.yy.mediaframework.utils.YMFLog;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class VideoDataStatUtil {
    private static final int DIS_TIME = 3000;
    public static final int ENCODE_STREAM_ID = 1001;
    private static final String TAG = "VideoLibStatUtil";
    private static long mTempPtsStatTime;
    private static long mTempPtsTime;
    private static ConcurrentHashMap<Long, Object> mFluency = new ConcurrentHashMap<>();
    private static long mMaxBeautyTime = 0;
    private static ArrayList<Long> mBeautyTime = new ArrayList<>();
    public static int mCaptureType = 0;

    public static void putCaptureType(int i) {
        mCaptureType = i;
    }

    public static String getCaptureType() {
        return mCaptureType + "";
    }

    public static String getBeautyTime() {
        float f = 0.0f;
        synchronized (mBeautyTime) {
            if (mBeautyTime != null && mBeautyTime.size() != 0) {
                int size = mBeautyTime.size();
                float f2 = 0.0f;
                for (int i = 0; i < size; i++) {
                    f2 += (float) mBeautyTime.get(i).longValue();
                }
                f = f2 / size;
            }
            mBeautyTime.clear();
        }
        return f + "";
    }

    public static void putBeautyTime(long j) {
        if (j > mMaxBeautyTime) {
            mMaxBeautyTime = j;
        }
        synchronized (mBeautyTime) {
            mBeautyTime.add(Long.valueOf(j));
        }
    }

    public static String getMaxBeautyTime() {
        String str = mMaxBeautyTime + "";
        mMaxBeautyTime = 0L;
        return str;
    }

    public static int getFluency(long j) {
        double d = 0.0d;
        synchronized (mFluency) {
            ArrayList<Long> createPtsList = createPtsList(j);
            if (createPtsList == null || createPtsList.size() <= 1) {
                return -1;
            }
            double[] dArr = new double[createPtsList.size()];
            for (int i = 0; i < createPtsList.size(); i++) {
                dArr[i] = createPtsList.get(i).longValue();
            }
            if (dArr == null) {
                return (int) (-1.0d);
            }
            int length = dArr.length;
            double d2 = 0.0d;
            for (double d3 : dArr) {
                d2 += d3;
            }
            if (d2 != 0.0d) {
                double d4 = d2 / length;
                for (int i2 = 0; i2 < length; i2++) {
                    d += (dArr[i2] - d4) * (dArr[i2] - d4);
                }
                int sqrt = (int) ((Math.sqrt(d / length) / d4) * 100.0d);
                if (sqrt < 0) {
                    sqrt = 0;
                } else if (sqrt > 1000) {
                    sqrt = 1000;
                }
                return sqrt;
            }
            return 0;
        }
    }

    public static void addPtsToList(long j) {
        synchronized (mFluency) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<Long> createPtsList = createPtsList(j);
            long j2 = currentTimeMillis - mTempPtsTime;
            if (mTempPtsTime != 0) {
                if (System.currentTimeMillis() - mTempPtsStatTime < IMConnection.RETRY_DELAY_TIMES) {
                    createPtsList.add(Long.valueOf(j2));
                } else {
                    createPtsList.clear();
                    mTempPtsStatTime = System.currentTimeMillis();
                }
            }
            mTempPtsTime = currentTimeMillis;
        }
    }

    private static ArrayList<Long> createPtsList(long j) {
        ArrayList<Long> arrayList = (ArrayList) mFluency.get(Long.valueOf(j));
        if (arrayList == null) {
            ArrayList<Long> arrayList2 = new ArrayList<>();
            mFluency.put(Long.valueOf(j), arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static void clearPtsTimes(long j) {
        synchronized (mFluency) {
            mFluency.remove(Long.valueOf(j));
            mTempPtsStatTime = 0L;
            mTempPtsTime = 0L;
        }
    }

    public static String getParamsOrderByKey(Map<String, Object> map) {
        String str;
        String str2 = "";
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (true) {
            String str3 = str2;
            if (it.hasNext()) {
                str2 = str3 + ETAG.ITEM_SEPARATOR + ((String) it.next()) + "=" + map.get(str);
            } else {
                return str3;
            }
        }
    }

    public static String toURLEncoded(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
        } catch (Exception e) {
            YMFLog.error((Object) null, "[Encoder ]", "toURLEncoded exception:" + e.toString());
            return "";
        }
    }

    public static String getAndroidInfo() {
        return Build.VERSION.RELEASE;
    }

    public static String getCurrentTime() {
        return toURLEncoded(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public static int getVideoEncodeId() {
        return VideoDataStat.getInstance().getVideoEncodeId();
    }

    public static String getDPI(int i, int i2) {
        return ((i << 16) | i2) + "";
    }
}
