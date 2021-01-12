package com.kwai.video.hodor;

import com.kwai.video.cache.AwesomeCacheCallback;
/* loaded from: classes4.dex */
public interface IHodorTask {
    public static final int EvictStrategy_LRU = 1;
    public static final int EvictStrategy_NEVER = 2;
    public static final int HodorTaskState_Cancelled = 2;
    public static final int HodorTaskState_Failed = 3;
    public static final int HodorTaskState_Finished = 1;
    public static final int HodorTaskState_Paused = 4;
    public static final int HodorTaskState_Started = 0;
    public static final int HodorTaskState_Unknown = -1;
    public static final int Priority_HIGH = 3000;
    public static final int Priority_LOW = 1000;
    public static final int Priority_MEDIUM = 2000;
    public static final int TaskQosClass_Background = 0;
    public static final int TaskQosClass_None = -1;
    public static final int TaskQosClass_User_Interactive = 2;
    public static final int TaskQosClass_Utility = 1;

    /* loaded from: classes4.dex */
    public @interface HodorTaskState {
    }

    /* loaded from: classes4.dex */
    public @interface MediaDirEvictStrategy {
    }

    /* loaded from: classes4.dex */
    public @interface TaskQosClass {
    }

    void cancel();

    void pause();

    void resume();

    void setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback);

    void setBizType(String str);

    void setGroupName(String str);

    void setPriority(int i);

    void setTaskQosClass(@TaskQosClass int i);

    void submit();

    void submit(boolean z);
}
