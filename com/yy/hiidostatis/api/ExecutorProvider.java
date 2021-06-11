package com.yy.hiidostatis.api;

import com.yy.mobile.perf.taskexecutor.IYYTaskExecutor;
/* loaded from: classes7.dex */
public class ExecutorProvider {
    public static IYYTaskExecutor iyyTaskExecutor;

    public static IYYTaskExecutor getIyyTaskExecutor() {
        return iyyTaskExecutor;
    }

    public static void setIyyTaskExecutor(IYYTaskExecutor iYYTaskExecutor) {
        iyyTaskExecutor = iYYTaskExecutor;
    }
}
