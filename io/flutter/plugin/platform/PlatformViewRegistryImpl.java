package io.flutter.plugin.platform;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class PlatformViewRegistryImpl implements PlatformViewRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, PlatformViewFactory> viewFactories;

    public PlatformViewRegistryImpl() {
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
        this.viewFactories = new HashMap();
    }

    public PlatformViewFactory getFactory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.viewFactories.get(str) : (PlatformViewFactory) invokeL.objValue;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRegistry
    public boolean registerViewFactory(String str, PlatformViewFactory platformViewFactory) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, platformViewFactory)) == null) {
            if (this.viewFactories.containsKey(str)) {
                return false;
            }
            this.viewFactories.put(str, platformViewFactory);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
