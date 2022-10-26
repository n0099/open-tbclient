package com.kwad.components.offline.api.core.network.adapter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.sdk.core.network.h;
/* loaded from: classes7.dex */
public class RequestListenerAdapter implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IOfflineCompoRequestListener mRequestListener;

    public RequestListenerAdapter(IOfflineCompoRequestListener iOfflineCompoRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iOfflineCompoRequestListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.h
    public void onError(RequestAdapter requestAdapter, int i, String str) {
        IOfflineCompoRequestListener iOfflineCompoRequestListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, requestAdapter, i, str) == null) || (iOfflineCompoRequestListener = this.mRequestListener) == null) {
            return;
        }
        iOfflineCompoRequestListener.onError(requestAdapter.getOfflineCompoRequest(), i, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.h
    public void onStartRequest(RequestAdapter requestAdapter) {
        IOfflineCompoRequestListener iOfflineCompoRequestListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, requestAdapter) == null) || (iOfflineCompoRequestListener = this.mRequestListener) == null) {
            return;
        }
        iOfflineCompoRequestListener.onStartRequest(requestAdapter.getOfflineCompoRequest());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.h
    public void onSuccess(RequestAdapter requestAdapter, ResultDataAdapter resultDataAdapter) {
        IOfflineCompoRequestListener iOfflineCompoRequestListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, requestAdapter, resultDataAdapter) == null) || (iOfflineCompoRequestListener = this.mRequestListener) == null) {
            return;
        }
        iOfflineCompoRequestListener.onSuccess(requestAdapter.getOfflineCompoRequest(), resultDataAdapter.getOfflineCompoResultData());
    }
}
