package com.kwad.sdk.core.imageloader.core.listener;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class SimpleImageLoadingListener implements ImageLoadingListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SimpleImageLoadingListener() {
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

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, inputStream, decodedResult)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public void onLoadingCancelled(String str, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view) == null) {
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, view, decodedResult) == null) {
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public void onLoadingFailed(String str, View view, FailReason failReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, view, failReason) == null) {
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public void onLoadingStarted(String str, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, view) == null) {
        }
    }
}
