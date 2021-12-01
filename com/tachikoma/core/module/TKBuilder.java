package com.tachikoma.core.module;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.api.IAnimatedImageInner;
import com.tachikoma.core.api.IHostEnvInner;
import com.tachikoma.core.api.IRequestDelegateInner;
import com.tachikoma.core.api.IWebImageHandlerInner;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class TKBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TKBuilder";
    public transient /* synthetic */ FieldHolder $fh;
    public IAnimatedImageInner mAnimatedImageInner;
    public IHostEnvInner mEnv;
    public IRequestDelegateInner mRequestDelegate;
    public IWebImageHandlerInner mWebImageHandler;

    public TKBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public Map<Class<?>, Object> build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            IWebImageHandlerInner iWebImageHandlerInner = this.mWebImageHandler;
            if (iWebImageHandlerInner != null) {
                hashMap.put(IWebImageHandlerInner.class, iWebImageHandlerInner);
            }
            IAnimatedImageInner iAnimatedImageInner = this.mAnimatedImageInner;
            if (iAnimatedImageInner != null) {
                hashMap.put(IAnimatedImageInner.class, iAnimatedImageInner);
            }
            IHostEnvInner iHostEnvInner = this.mEnv;
            if (iHostEnvInner != null) {
                hashMap.put(IHostEnvInner.class, iHostEnvInner);
            }
            IRequestDelegateInner iRequestDelegateInner = this.mRequestDelegate;
            if (iRequestDelegateInner != null) {
                hashMap.put(IRequestDelegateInner.class, iRequestDelegateInner);
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public void setAnimatedImageInner(IAnimatedImageInner iAnimatedImageInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iAnimatedImageInner) == null) {
            this.mAnimatedImageInner = iAnimatedImageInner;
        }
    }

    public void setEnv(@NonNull IHostEnvInner iHostEnvInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iHostEnvInner) == null) {
            this.mEnv = iHostEnvInner;
        }
    }

    public void setNetWork(IRequestDelegateInner iRequestDelegateInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iRequestDelegateInner) == null) {
            this.mRequestDelegate = iRequestDelegateInner;
        }
    }

    public void setWebImageHandler(@NonNull IWebImageHandlerInner iWebImageHandlerInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iWebImageHandlerInner) == null) {
            this.mWebImageHandler = iWebImageHandlerInner;
        }
    }
}
