package com.yy.hiidostatis.inner.implementation;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public interface ITaskExecutor {

    /* loaded from: classes3.dex */
    public static abstract class ExecutorTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public TaskData mData;

        public ExecutorTask(Context context, TaskData taskData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, taskData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
            this.mData = taskData;
        }

        public String getContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TaskData taskData = this.mData;
                if (taskData == null) {
                    return null;
                }
                return taskData.getContent();
            }
            return (String) invokeV.objValue;
        }

        public Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mContext : (Context) invokeV.objValue;
        }

        public TaskData getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (TaskData) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface OnTaskRejectedListener {
        void onRejectedTask(ExecutorTask executorTask);
    }

    void submit(ExecutorTask executorTask);

    void submit(ExecutorTask executorTask, int i2);

    void submit(Runnable runnable);

    void submit(Runnable runnable, int i2);
}
