package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.h;
/* loaded from: classes8.dex */
public class RequestListenerAdapter<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> implements h<RequestAdapter<R>, ResultDataAdapter<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IOfflineCompoRequestListener<R, T> mRequestListener;

    public RequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
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

    public void onError(@NonNull RequestAdapter<R> requestAdapter, int i, String str) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, requestAdapter, i, str) == null) || (iOfflineCompoRequestListener = this.mRequestListener) == null) {
            return;
        }
        iOfflineCompoRequestListener.onError(requestAdapter.getOfflineCompoRequest(), i, str);
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
        onError((RequestAdapter) ((RequestAdapter) gVar), i, str);
    }

    public void onStartRequest(@NonNull RequestAdapter<R> requestAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, requestAdapter) == null) || (iOfflineCompoRequestListener = this.mRequestListener) == null) {
            return;
        }
        iOfflineCompoRequestListener.onStartRequest(requestAdapter.getOfflineCompoRequest());
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onStartRequest(@NonNull g gVar) {
        onStartRequest((RequestAdapter) ((RequestAdapter) gVar));
    }

    public void onSuccess(@NonNull RequestAdapter<R> requestAdapter, @NonNull ResultDataAdapter<T> resultDataAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, requestAdapter, resultDataAdapter) == null) || (iOfflineCompoRequestListener = this.mRequestListener) == null) {
            return;
        }
        iOfflineCompoRequestListener.onSuccess(requestAdapter.getOfflineCompoRequest(), resultDataAdapter.getOfflineCompoResultData());
    }

    @Override // com.kwad.sdk.core.network.h
    public /* bridge */ /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
        onSuccess((RequestAdapter) ((RequestAdapter) gVar), (ResultDataAdapter) ((ResultDataAdapter) baseResultData));
    }
}
