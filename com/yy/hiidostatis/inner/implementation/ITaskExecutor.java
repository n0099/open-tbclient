package com.yy.hiidostatis.inner.implementation;

import android.content.Context;
/* loaded from: classes8.dex */
public interface ITaskExecutor {

    /* loaded from: classes8.dex */
    public interface OnTaskRejectedListener {
        void onRejectedTask(ExecutorTask executorTask);
    }

    void submit(ExecutorTask executorTask);

    void submit(ExecutorTask executorTask, int i);

    void submit(Runnable runnable);

    void submit(Runnable runnable, int i);

    /* loaded from: classes8.dex */
    public static abstract class ExecutorTask implements Runnable {
        public Context mContext;
        public TaskData mData;

        public ExecutorTask(Context context, TaskData taskData) {
            this.mContext = context;
            this.mData = taskData;
        }

        public String getContent() {
            TaskData taskData = this.mData;
            if (taskData == null) {
                return null;
            }
            return taskData.getContent();
        }

        public Context getContext() {
            return this.mContext;
        }

        public TaskData getData() {
            return this.mData;
        }
    }
}
