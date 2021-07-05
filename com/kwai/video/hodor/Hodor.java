package com.kwai.video.hodor;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.hodor.debuginfo.model.HodorDebugInfo;
@Keep
/* loaded from: classes7.dex */
public class Hodor extends HodorDeprecatedApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GET_DEBUG_INFO_INTERVAL_MIN_MS = 500;
    public static final int TaskType_Media = 0;
    public static final int TaskType_Resource = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public HodorDebugInfo mHodorDebugInfo;
    public long mLastGetDebugInfoTsMs;

    /* loaded from: classes7.dex */
    public static class INSTANCE_HOLDER {
        public static /* synthetic */ Interceptable $ic;
        public static Hodor INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1051118611, "Lcom/kwai/video/hodor/Hodor$INSTANCE_HOLDER;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1051118611, "Lcom/kwai/video/hodor/Hodor$INSTANCE_HOLDER;");
                    return;
                }
            }
            INSTANCE = new Hodor();
        }

        public INSTANCE_HOLDER() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-250476129, "Lcom/kwai/video/hodor/Hodor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-250476129, "Lcom/kwai/video/hodor/Hodor;");
                return;
            }
        }
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    public Hodor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHodorDebugInfo = new HodorDebugInfo();
        this.mLastGetDebugInfoTsMs = 0L;
    }

    private native void getDebugInfo(HodorDebugInfo hodorDebugInfo);

    public static Hodor instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? INSTANCE_HOLDER.INSTANCE : (Hodor) invokeV.objValue;
    }

    public static native int loadJavaClass();

    public native void cancelAllTasksOfGroupName(String str);

    public native void clearCacheDirectory(@TaskType int i2);

    public native void deleteCacheByKey(String str, @TaskType int i2);

    public native long getCacheBytesLimitOfDirectory(@TaskType int i2);

    public native long getCachedBytesOfDirectory(@TaskType int i2);

    public HodorDebugInfo getDebugInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastGetDebugInfoTsMs > 500) {
                getDebugInfo(this.mHodorDebugInfo);
                this.mLastGetDebugInfoTsMs = currentTimeMillis;
            }
            return this.mHodorDebugInfo;
        }
        return (HodorDebugInfo) invokeV.objValue;
    }

    public native int getRemainTaskCount();

    public native boolean isFullyCached(String str, @TaskType int i2);

    public native void pauseAllTasksOfGroupName(String str);

    public native void pruneStrategyNeverCacheContent(boolean z);

    public native void resumeAllTasksOfGroupName(String str);

    public void submitTask(IHodorTask iHodorTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iHodorTask) == null) {
            iHodorTask.submit();
        }
    }
}
