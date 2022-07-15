package com.kwad.components.offline.tk;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.offline.init.kwai.h;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.ap;
/* loaded from: classes5.dex */
public final class b implements ITkOfflineCompoInitConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getSpKeyTkSoLoadTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "tk_so_load_times" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getSpNameSoLoadTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ksadsdk_so_load_times" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getTkJsFileDir(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) ? ap.a(context, str) : (String) invokeLL.objValue;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final String getTkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "4.0.0" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final boolean isCanUseTk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d.C() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final boolean isLocalDebugEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a(DevelopMangerComponents.class);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final boolean isTkCloseCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (isLocalDebugEnable()) {
                return true;
            }
            c.a(DevelopMangerComponents.class);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final ISoLoader soLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new ISoLoader(this) { // from class: com.kwad.components.offline.tk.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
            public final void loadSo(Context context, @NonNull SoLoadListener soLoadListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, soLoadListener) == null) {
                    com.kwad.components.offline.tk.a.a.a(context, soLoadListener);
                }
            }
        } : (ISoLoader) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig
    public final boolean useTkLite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? com.kwad.components.offline.tk.a.a.a() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new h(ITkOfflineCompo.PACKAGE_NAME) : (IOfflineCompoWrapper) invokeV.objValue;
    }
}
