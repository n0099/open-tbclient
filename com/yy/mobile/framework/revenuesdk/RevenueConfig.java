package com.yy.mobile.framework.revenuesdk;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender;
/* loaded from: classes8.dex */
public class RevenueConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public String appName;
    public int authType;
    public String clientVer;
    public int currencyType;
    public IRevenueDataSender dataSender;
    public String deviceId;
    public Context mContext;
    public String pakageName;
    public ProtocolType protoType;
    public long uid;
    public int usedChannel;

    /* loaded from: classes8.dex */
    public static final class RevenueConfigBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int appId;
        public String appName;
        public int authType;
        public String clientVer;
        public int currencyType;
        public IRevenueDataSender dataSender;
        public String deviceId;
        public Context mContext;
        public String pakageName;
        public ProtocolType protoType;
        public long uid;
        public int usedChannel;

        public RevenueConfigBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.uid = 0L;
            this.usedChannel = 0;
            this.currencyType = 0;
            this.pakageName = "";
            this.clientVer = "";
            this.appName = "";
            this.deviceId = "";
            this.protoType = ProtocolType.SERVICE;
            this.authType = 4;
            this.appId = 0;
        }

        public static RevenueConfigBuilder aRevenueConfig() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return new RevenueConfigBuilder();
            }
            return (RevenueConfigBuilder) invokeV.objValue;
        }

        public RevenueConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                RevenueConfig revenueConfig = new RevenueConfig();
                revenueConfig.currencyType = this.currencyType;
                revenueConfig.dataSender = this.dataSender;
                revenueConfig.usedChannel = this.usedChannel;
                revenueConfig.uid = this.uid;
                revenueConfig.mContext = this.mContext;
                revenueConfig.pakageName = this.pakageName;
                revenueConfig.clientVer = this.clientVer;
                revenueConfig.protoType = this.protoType;
                revenueConfig.authType = this.authType;
                revenueConfig.appId = this.appId;
                revenueConfig.appName = this.appName;
                revenueConfig.deviceId = this.deviceId;
                return revenueConfig;
            }
            return (RevenueConfig) invokeV.objValue;
        }

        public RevenueConfigBuilder setAppId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.appId = i;
                return this;
            }
            return (RevenueConfigBuilder) invokeI.objValue;
        }

        public RevenueConfigBuilder setAppName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.appName = str;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setAuthType(@NonNull int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.authType = i;
                return this;
            }
            return (RevenueConfigBuilder) invokeI.objValue;
        }

        public RevenueConfigBuilder setClientVersion(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.clientVer = str;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setContext(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
                this.mContext = context;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setCurrencyType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.currencyType = i;
                return this;
            }
            return (RevenueConfigBuilder) invokeI.objValue;
        }

        public RevenueConfigBuilder setDataSender(@NonNull IRevenueDataSender iRevenueDataSender) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iRevenueDataSender)) == null) {
                this.dataSender = iRevenueDataSender;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setDeviceId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.deviceId = str;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setPakageName(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.pakageName = str;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setProtoType(@NonNull ProtocolType protocolType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, protocolType)) == null) {
                this.protoType = protocolType;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setUid(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
                this.uid = j;
                return this;
            }
            return (RevenueConfigBuilder) invokeJ.objValue;
        }

        public RevenueConfigBuilder setUsedChannel(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.usedChannel = i;
                return this;
            }
            return (RevenueConfigBuilder) invokeI.objValue;
        }
    }

    public RevenueConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.appId;
        }
        return invokeV.intValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.appName;
        }
        return (String) invokeV.objValue;
    }

    public int getAuthType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.authType;
        }
        return invokeV.intValue;
    }

    public String getClientVerion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.clientVer;
        }
        return (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    public int getCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.currencyType;
        }
        return invokeV.intValue;
    }

    public IRevenueDataSender getDataSender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.dataSender;
        }
        return (IRevenueDataSender) invokeV.objValue;
    }

    public String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.deviceId;
        }
        return (String) invokeV.objValue;
    }

    public String getPakageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.pakageName;
        }
        return (String) invokeV.objValue;
    }

    public ProtocolType getProtoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.protoType;
        }
        return (ProtocolType) invokeV.objValue;
    }

    public long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.uid;
        }
        return invokeV.longValue;
    }

    public int getUsedChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.usedChannel;
        }
        return invokeV.intValue;
    }

    public Context getmContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    public void setAppId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.appId = i;
        }
    }

    public void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.uid = j;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "RevenueConfig { appId=" + this.appId + " usedChannel=" + this.usedChannel + " deviceId=" + this.deviceId + " currencyType=" + this.currencyType + " clientVer=" + this.clientVer + " authType=" + this.authType + " appName=" + this.appName + "}";
        }
        return (String) invokeV.objValue;
    }
}
