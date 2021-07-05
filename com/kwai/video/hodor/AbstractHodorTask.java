package com.kwai.video.hodor;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.hodor.anotations.AccessedByNative;
@Keep
/* loaded from: classes7.dex */
public abstract class AbstractHodorTask implements IHodorTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @AccessedByNative
    public String mBizType;
    @AccessedByNative
    public int mConnectTimeoutMs;
    @AccessedByNative
    public String mGroupName;
    @AccessedByNative
    public int mMaxSpeedKbps;
    @AccessedByNative
    public int mPriority;
    @AccessedByNative
    public int mTaskQosClass;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1193232476, "Lcom/kwai/video/hodor/AbstractHodorTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1193232476, "Lcom/kwai/video/hodor/AbstractHodorTask;");
                return;
            }
        }
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    public AbstractHodorTask() {
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
        this.mTaskQosClass = 0;
        this.mPriority = 3000;
        this.mConnectTimeoutMs = 3000;
        this.mMaxSpeedKbps = -1;
        this.mBizType = "unknown";
        this.mGroupName = "";
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setBizType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.mBizType = str;
        }
    }

    public void setConnectTimeoutMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mConnectTimeoutMs = i2;
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setGroupName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.mGroupName = str;
        }
    }

    public void setMaxSpeedKbps(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mMaxSpeedKbps = i2;
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setPriority(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mPriority = i2;
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setTaskQosClass(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mTaskQosClass = i2;
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void submit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            submit();
        }
    }
}
