package com.yy.hiidostatis.inner;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.log.ActLog;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes3.dex */
public abstract class AbstractConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_DATA_CACHE_DAY = 62;
    public static int MAX_DATA_RETRY_TIME = 20000;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int businessType;
    public volatile String cacheFileName;
    public volatile boolean isAbroad;
    public volatile boolean isEncrypt;
    public volatile boolean isEncryptTestServer;
    public volatile String sdkVer;
    public volatile String testServer;
    public volatile String urlConfigServer;
    public volatile String urlLogUpload;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(160143499, "Lcom/yy/hiidostatis/inner/AbstractConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(160143499, "Lcom/yy/hiidostatis/inner/AbstractConfig;");
        }
    }

    public AbstractConfig() {
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
        this.isEncrypt = true;
        this.isEncryptTestServer = false;
        this.testServer = null;
        this.urlConfigServer = "https://config.bigda.com/";
        this.urlLogUpload = "https://config.bigda.com/api/upload";
        this.cacheFileName = "hdcommon_module_used_file";
        this.isAbroad = false;
        this.businessType = 100;
    }

    public int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.businessType : invokeV.intValue;
    }

    public String getCacheFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cacheFileName : (String) invokeV.objValue;
    }

    public String getConfigKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getClass().getName() : (String) invokeV.objValue;
    }

    public String getMetricsHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? HiidoSDK.getHiidoHost() : (String) invokeV.objValue;
    }

    public String getSdkVer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sdkVer : (String) invokeV.objValue;
    }

    public String getTestServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.testServer : (String) invokeV.objValue;
    }

    public String[] getUrlAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? HiidoSDK.getHiidoIps() : (String[]) invokeV.objValue;
    }

    public String getUrlConfigServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.urlConfigServer : (String) invokeV.objValue;
    }

    public boolean isAbroad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isAbroad : invokeV.booleanValue;
    }

    public boolean isEncrypt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isEncrypt : invokeV.booleanValue;
    }

    public boolean isEncryptTestServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isEncryptTestServer : invokeV.booleanValue;
    }

    public void setAbroad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.isAbroad = z;
        }
    }

    public void setActLogNamePre(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            ActLog.setLogNamePre(str);
        }
    }

    public void setActLogUploadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            ActLog.setUploadUrl(str);
        }
    }

    public void setBusinessType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.businessType = i2;
        }
    }

    public void setDefaultPrefName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            DefaultPreference.setPrefName(str);
        }
    }

    public void setLogTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            L.setLogTag(str);
        }
    }
}
