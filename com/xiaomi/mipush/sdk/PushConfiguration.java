package com.xiaomi.mipush.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.module.PushChannelRegion;
/* loaded from: classes8.dex */
public class PushConfiguration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mGeoEnable;
    public boolean mOpenCOSPush;
    public boolean mOpenFCMPush;
    public boolean mOpenFTOSPush;
    public boolean mOpenHmsPush;
    public PushChannelRegion mRegion;

    /* loaded from: classes8.dex */
    public class PushConfigurationBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mGeoEnable;
        public boolean mOpenCOSPush;
        public boolean mOpenFCMPush;
        public boolean mOpenFTOSPush;
        public boolean mOpenHmsPush;
        public PushChannelRegion mRegion;

        public PushConfigurationBuilder() {
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

        public PushConfiguration build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new PushConfiguration(this, null) : (PushConfiguration) invokeV.objValue;
        }

        public PushConfigurationBuilder openCOSPush(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.mOpenCOSPush = z;
                return this;
            }
            return (PushConfigurationBuilder) invokeZ.objValue;
        }

        public PushConfigurationBuilder openFCMPush(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.mOpenFCMPush = z;
                return this;
            }
            return (PushConfigurationBuilder) invokeZ.objValue;
        }

        public PushConfigurationBuilder openFTOSPush(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.mOpenFTOSPush = z;
                return this;
            }
            return (PushConfigurationBuilder) invokeZ.objValue;
        }

        public PushConfigurationBuilder openHmsPush(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.mOpenHmsPush = z;
                return this;
            }
            return (PushConfigurationBuilder) invokeZ.objValue;
        }

        public PushConfigurationBuilder region(PushChannelRegion pushChannelRegion) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pushChannelRegion)) == null) {
                this.mRegion = pushChannelRegion;
                return this;
            }
            return (PushConfigurationBuilder) invokeL.objValue;
        }
    }

    public PushConfiguration() {
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
        this.mRegion = PushChannelRegion.China;
        this.mOpenHmsPush = false;
        this.mOpenFCMPush = false;
        this.mOpenCOSPush = false;
        this.mOpenFTOSPush = false;
    }

    public PushConfiguration(PushConfigurationBuilder pushConfigurationBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pushConfigurationBuilder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRegion = pushConfigurationBuilder.mRegion == null ? PushChannelRegion.China : pushConfigurationBuilder.mRegion;
        this.mOpenHmsPush = pushConfigurationBuilder.mOpenHmsPush;
        this.mOpenFCMPush = pushConfigurationBuilder.mOpenFCMPush;
        this.mOpenCOSPush = pushConfigurationBuilder.mOpenCOSPush;
        this.mOpenFTOSPush = pushConfigurationBuilder.mOpenFTOSPush;
    }

    public /* synthetic */ PushConfiguration(PushConfigurationBuilder pushConfigurationBuilder, ah ahVar) {
        this(pushConfigurationBuilder);
    }

    public boolean getOpenCOSPush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mOpenCOSPush : invokeV.booleanValue;
    }

    public boolean getOpenFCMPush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mOpenFCMPush : invokeV.booleanValue;
    }

    public boolean getOpenFTOSPush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOpenFTOSPush : invokeV.booleanValue;
    }

    public boolean getOpenHmsPush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOpenHmsPush : invokeV.booleanValue;
    }

    public PushChannelRegion getRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRegion : (PushChannelRegion) invokeV.objValue;
    }

    public void setOpenCOSPush(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mOpenCOSPush = z;
        }
    }

    public void setOpenFCMPush(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mOpenFCMPush = z;
        }
    }

    public void setOpenFTOSPush(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mOpenFTOSPush = z;
        }
    }

    public void setOpenHmsPush(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mOpenHmsPush = z;
        }
    }

    public void setRegion(PushChannelRegion pushChannelRegion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pushChannelRegion) == null) {
            this.mRegion = pushChannelRegion;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer("PushConfiguration{");
            stringBuffer.append("Region:");
            PushChannelRegion pushChannelRegion = this.mRegion;
            stringBuffer.append(pushChannelRegion == null ? StringUtil.NULL_STRING : pushChannelRegion.name());
            stringBuffer.append(",mOpenHmsPush:" + this.mOpenHmsPush);
            stringBuffer.append(",mOpenFCMPush:" + this.mOpenFCMPush);
            stringBuffer.append(",mOpenCOSPush:" + this.mOpenCOSPush);
            stringBuffer.append(",mOpenFTOSPush:" + this.mOpenFTOSPush);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
