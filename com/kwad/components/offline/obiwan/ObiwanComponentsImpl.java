package com.kwad.components.offline.obiwan;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.offline.api.obiwan.ObiwanComponents;
import com.kwad.components.core.offline.init.DefaultOfflineCompo;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes7.dex */
public class ObiwanComponentsImpl extends DefaultOfflineCompo implements ObiwanComponents {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IObiwanOfflineCompo mOfflineCompo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObiwanComponentsImpl(IObiwanOfflineCompo iObiwanOfflineCompo) {
        super(iObiwanOfflineCompo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iObiwanOfflineCompo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((IOfflineCompo) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOfflineCompo = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ObiwanComponentsImpl.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo
    public IObiwanLogcat getLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mOfflineCompo.getLog() : (IObiwanLogcat) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo
    public void initReal(Context context, SdkConfig sdkConfig, IObiwanOfflineCompoInitConfig iObiwanOfflineCompoInitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, sdkConfig, iObiwanOfflineCompoInitConfig) == null) {
            this.mOfflineCompo.initReal(context, sdkConfig, iObiwanOfflineCompoInitConfig);
        }
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo
    public void updateConfigs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mOfflineCompo.updateConfigs();
        }
    }
}
