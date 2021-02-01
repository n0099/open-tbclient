package com.kwai.video.hodor;

import androidx.annotation.Keep;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.hodor.debuginfo.model.HodorDebugInfo;
@Keep
/* loaded from: classes3.dex */
public class Hodor extends HodorDeprecatedApi {
    private static final int GET_DEBUG_INFO_INTERVAL_MIN_MS = 500;
    public static final int TaskType_Media = 0;
    public static final int TaskType_Resource = 1;
    private HodorDebugInfo mHodorDebugInfo = new HodorDebugInfo();
    private long mLastGetDebugInfoTsMs = 0;

    /* loaded from: classes3.dex */
    private static class INSTANCE_HOLDER {
        static Hodor INSTANCE = new Hodor();

        private INSTANCE_HOLDER() {
        }
    }

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    private native void getDebugInfo(HodorDebugInfo hodorDebugInfo);

    public static Hodor instance() {
        return INSTANCE_HOLDER.INSTANCE;
    }

    public static native int loadJavaClass();

    public native void cancelAllTasksOfGroupName(String str);

    public native void clearCacheDirectory(@TaskType int i);

    public native void deleteCacheByKey(String str, @TaskType int i);

    public native long getCacheBytesLimitOfDirectory(@TaskType int i);

    public native long getCachedBytesOfDirectory(@TaskType int i);

    public HodorDebugInfo getDebugInfo() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastGetDebugInfoTsMs > 500) {
            getDebugInfo(this.mHodorDebugInfo);
            this.mLastGetDebugInfoTsMs = currentTimeMillis;
        }
        return this.mHodorDebugInfo;
    }

    public native int getRemainTaskCount();

    public native boolean isFullyCached(String str, @TaskType int i);

    public native void pauseAllTasksOfGroupName(String str);

    public native void pruneStrategyNeverCacheContent(boolean z);

    public native void resumeAllTasksOfGroupName(String str);

    public void submitTask(IHodorTask iHodorTask) {
        iHodorTask.submit();
    }
}
