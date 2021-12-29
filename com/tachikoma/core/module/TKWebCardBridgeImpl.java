package com.tachikoma.core.module;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Function;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.api.IWebCardBridgeInner;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.utility.V8Proxy;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes4.dex */
public class TKWebCardBridgeImpl implements IWebCardBridgeInner {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TKJSContext mTKJSContext;

    public TKWebCardBridgeImpl(Context context, List<Object> list) {
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

    private IWebCardBridgeInner getBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? (IWebCardBridgeInner) this.mTKJSContext.getHandler(IWebCardBridgeInner.class) : (IWebCardBridgeInner) invokeV.objValue;
    }

    @Override // com.tachikoma.core.api.IWebCardBridgeInner
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            getBridge().close();
        }
    }

    @Override // com.tachikoma.core.api.IWebCardBridgeInner
    public void convert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getBridge().convert();
        }
    }

    @Override // com.tachikoma.core.api.IWebCardBridgeInner
    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getBridge().getData() : (String) invokeV.objValue;
    }

    @Override // com.tachikoma.core.api.IWebCardBridgeInner
    public void handleAdUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            getBridge().handleAdUrl(str);
        }
    }

    @Override // com.tachikoma.core.api.IWebCardBridgeInner
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            getBridge().hide();
        }
    }

    @Override // com.tachikoma.core.api.IWebCardBridgeInner
    public void log(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            getBridge().log(str);
        }
    }

    @Override // com.tachikoma.core.api.IWebCardBridgeInner
    public void nonActionbarClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            getBridge().nonActionbarClick(str);
        }
    }

    @Override // com.tachikoma.core.api.IWebCardBridgeInner
    public void pageStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            getBridge().pageStatus(str);
        }
    }

    @Override // com.tachikoma.core.api.IWebCardBridgeInner
    public void registerProgressListener(V8Function v8Function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v8Function) == null) {
            getBridge().registerProgressListener(v8Function);
        }
    }

    @Override // com.tachikoma.core.api.IWebCardBridgeInner
    public void trace(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            getBridge().trace(str);
        }
    }
}
