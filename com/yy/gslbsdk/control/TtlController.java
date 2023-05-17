package com.yy.gslbsdk.control;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes10.dex */
public class TtlController {
    public static final int ACTIVE_THRESHOLD = 5;
    public static final int ENABLE_EXPIRED_THRESHOLD = 7;
    public static final int MAX_QUEUE_SIZE = 15;
    public static final int[] TTL_INTERVAL = {1, 6, 10, 16, 32, 64, 80, 92, 104, 114, 120};
    public static TtlController sInstance;
    public int mTtlIntervalCount = 0;
    public int mTtlFailedCount = 0;
    public List<Boolean> mList = new ArrayList();

    public static synchronized TtlController getInstance() {
        TtlController ttlController;
        synchronized (TtlController.class) {
            if (sInstance == null) {
                sInstance = new TtlController();
            }
            ttlController = sInstance;
        }
        return ttlController;
    }

    public boolean addTtlIntervalCount() {
        int i = this.mTtlIntervalCount + 1;
        this.mTtlIntervalCount = i;
        if (i < getTtlIntervalValue()) {
            return false;
        }
        resetTtlIntervalCount();
        return true;
    }

    public boolean enableExpired() {
        if (getFailedCount() > 7) {
            return true;
        }
        return false;
    }

    public int getFailedCount() {
        return this.mTtlFailedCount;
    }

    public int getTtlIntervalCount() {
        return this.mTtlIntervalCount;
    }

    public int getTtlIntervalLevel() {
        int failedCount = getFailedCount();
        if (failedCount <= 5) {
            return 0;
        }
        return failedCount - 5;
    }

    public int getTtlIntervalValue() {
        return TTL_INTERVAL[getTtlIntervalLevel()];
    }

    public boolean isActive() {
        if (getFailedCount() > 5) {
            return true;
        }
        return false;
    }

    public void resetTtlIntervalCount() {
        this.mTtlIntervalCount = 0;
    }

    private void calcFailedCount() {
        List<Boolean> list;
        synchronized (this.mList) {
            list = (List) ((ArrayList) this.mList).clone();
        }
        int i = 0;
        for (Boolean bool : list) {
            if (bool != null && !bool.booleanValue()) {
                i++;
            }
        }
        this.mTtlFailedCount = Math.min(i, 15);
    }

    public boolean addStatus(boolean z) {
        synchronized (this.mList) {
            this.mList.add(Boolean.valueOf(z));
            if (this.mList.size() < 15) {
                return false;
            }
            while (this.mList.size() > 15) {
                this.mList.remove(0);
            }
            calcFailedCount();
            return true;
        }
    }

    public String toString() {
        List list;
        String str;
        synchronized (this.mList) {
            list = (List) ((ArrayList) this.mList).clone();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("( ");
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(i);
            stringBuffer.append("-");
            if (((Boolean) list.get(i)).booleanValue()) {
                str = "t";
            } else {
                str = "f";
            }
            stringBuffer.append(str);
            stringBuffer.append(" ");
        }
        stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
        return String.format(Locale.US, "[TtlController failed: %d, level: %d, value: %d, count: %d, isActive: %b, enableExpired: %b, queue: %s]", Integer.valueOf(getFailedCount()), Integer.valueOf(getTtlIntervalLevel()), Integer.valueOf(getTtlIntervalValue()), Integer.valueOf(getTtlIntervalCount()), Boolean.valueOf(isActive()), Boolean.valueOf(enableExpired()), stringBuffer.toString());
    }
}
