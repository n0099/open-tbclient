package com.kwai.player.debuginfo.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class KwaiPlayerDebugInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AppLiveQosDebugInfo mAppLiveQosDebugInfo;
    public AppLiveQosDebugInfoNew mAppLiveQosDebugInfoNew;
    public AppVodQosDebugInfoNew mAppVodQosDebugInfo;
    public boolean mIsLive;
    public PlayerConfigDebugInfo mPlayerApplyConfig;
    public String mSdkVersion;

    public KwaiPlayerDebugInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsLive = false;
        this.mPlayerApplyConfig = new PlayerConfigDebugInfo();
    }

    public boolean isLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIsLive : invokeV.booleanValue;
    }

    public void setIsLive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.mIsLive = z;
        }
    }
}
