package com.tachikoma.core.module;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Function;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.api.IBaseBridgeInner;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.utility.V8Proxy;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes3.dex */
public class TKBaseBridge implements IBaseBridgeInner {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TKJSContext mTKJSContext;

    public TKBaseBridge(Context context, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTKJSContext = V8Proxy.getTKContext(list);
    }

    private IBaseBridgeInner getBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? (IBaseBridgeInner) this.mTKJSContext.getHandler(IBaseBridgeInner.class) : (IBaseBridgeInner) invokeV.objValue;
    }

    @Override // com.tachikoma.core.api.IBaseBridgeInner
    public Object invoke(String str, @Nullable String str2, @Nullable V8Function v8Function) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, v8Function)) == null) ? getBridge().invoke(str, str2, v8Function) : invokeLLL.objValue;
    }

    @Override // com.tachikoma.core.api.IBaseBridgeInner
    public Object invokeM(String str, String str2, @Nullable String str3, @Nullable V8Function v8Function) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, v8Function)) == null) ? getBridge().invokeM(str, str2, str3, v8Function) : invokeLLLL.objValue;
    }
}
