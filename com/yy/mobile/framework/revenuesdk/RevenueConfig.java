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
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ReportConfig;
import java.util.Locale;
/* loaded from: classes8.dex */
public class RevenueConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public int authType;
    public String clientVer;
    public String countryCode;
    public int currencyType;
    public IRevenueDataSender dataSender;
    public String functionName;
    public boolean isOpenRisk;
    public String language;
    public Context mContext;
    public String pakageName;
    public ProtocolType protoType;
    public ReportConfig reportConfig;
    public String serviceName;
    public long uid;
    public int usedChannel;

    /* loaded from: classes8.dex */
    public static final class RevenueConfigBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int appId;
        public int authType;
        public String clientVer;
        public String countryCode;
        public int currencyType;
        public IRevenueDataSender dataSender;
        public String functionName;
        public String httpUrl;
        public boolean isOpenRisk;
        public String language;
        public Context mContext;
        public String pakageName;
        public ProtocolType protoType;
        public ReportConfig reportConfig;
        public String serviceName;
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
            this.countryCode = Locale.getDefault().getCountry();
            this.language = Locale.getDefault().getLanguage();
            this.pakageName = "";
            this.clientVer = "";
            this.serviceName = "";
            this.functionName = "";
            this.httpUrl = "";
            this.protoType = ProtocolType.SERVICE;
            this.authType = 4;
            this.isOpenRisk = false;
            this.appId = 0;
        }

        public static RevenueConfigBuilder aRevenueConfig() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new RevenueConfigBuilder() : (RevenueConfigBuilder) invokeV.objValue;
        }

        public RevenueConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                RevenueConfig revenueConfig = new RevenueConfig();
                revenueConfig.currencyType = this.currencyType;
                revenueConfig.dataSender = this.dataSender;
                revenueConfig.usedChannel = this.usedChannel;
                revenueConfig.countryCode = this.countryCode;
                revenueConfig.language = this.language;
                revenueConfig.uid = this.uid;
                revenueConfig.mContext = this.mContext;
                revenueConfig.pakageName = this.pakageName;
                revenueConfig.clientVer = this.clientVer;
                revenueConfig.serviceName = this.serviceName;
                revenueConfig.functionName = this.functionName;
                revenueConfig.protoType = this.protoType;
                revenueConfig.authType = this.authType;
                revenueConfig.isOpenRisk = this.isOpenRisk;
                revenueConfig.reportConfig = this.reportConfig;
                revenueConfig.appId = this.appId;
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

        public RevenueConfigBuilder setAuthType(@NonNull int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.authType = i;
                return this;
            }
            return (RevenueConfigBuilder) invokeI.objValue;
        }

        public RevenueConfigBuilder setClientVersion(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.clientVer = str;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setContext(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                this.mContext = context;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setCountryCode(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.countryCode = str;
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

        public RevenueConfigBuilder setFunctionName(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.functionName = str;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setHttpUrl(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.httpUrl = str;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setIsOpenRisk(@NonNull boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.isOpenRisk = z;
                return this;
            }
            return (RevenueConfigBuilder) invokeZ.objValue;
        }

        public RevenueConfigBuilder setLanguage(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.language = str;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setPakageName(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.pakageName = str;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setProtoType(@NonNull ProtocolType protocolType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, protocolType)) == null) {
                this.protoType = protocolType;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setReportConfig(@NonNull ReportConfig reportConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, reportConfig)) == null) {
                this.reportConfig = reportConfig;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setServiceName(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
                this.serviceName = str;
                return this;
            }
            return (RevenueConfigBuilder) invokeL.objValue;
        }

        public RevenueConfigBuilder setUid(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
                this.uid = j;
                return this;
            }
            return (RevenueConfigBuilder) invokeJ.objValue;
        }

        public RevenueConfigBuilder setUsedChannel(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.appId : invokeV.intValue;
    }

    public int getAuthType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.authType : invokeV.intValue;
    }

    public String getClientVerion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.clientVer : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public String getCountryCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.countryCode : (String) invokeV.objValue;
    }

    public int getCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.currencyType : invokeV.intValue;
    }

    public IRevenueDataSender getDataSender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.dataSender : (IRevenueDataSender) invokeV.objValue;
    }

    public String getFunctionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.functionName : (String) invokeV.objValue;
    }

    public boolean getIsOpenRisk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isOpenRisk : invokeV.booleanValue;
    }

    public String getLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.language : (String) invokeV.objValue;
    }

    public String getPakageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.pakageName : (String) invokeV.objValue;
    }

    public ProtocolType getProtoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.protoType : (ProtocolType) invokeV.objValue;
    }

    public ReportConfig getReportConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.reportConfig : (ReportConfig) invokeV.objValue;
    }

    public String getServiceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.serviceName : (String) invokeV.objValue;
    }

    public long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.uid : invokeV.longValue;
    }

    public int getUsedChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.usedChannel : invokeV.intValue;
    }

    public Context getmContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public void setAppId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.appId = i;
        }
    }

    public void setCountryCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.countryCode = str;
        }
    }

    public void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.uid = j;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "RevenueConfig { appId=" + this.appId + " usedChannel=" + this.usedChannel + " currencyType=" + this.currencyType + " clientVer=" + this.clientVer + " authType=" + this.authType + " }";
        }
        return (String) invokeV.objValue;
    }
}
