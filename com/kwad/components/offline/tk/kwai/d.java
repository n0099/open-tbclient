package com.kwad.components.offline.tk.kwai;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaView;
import com.kwad.sdk.components.g;
import com.kwad.sdk.components.h;
import com.kwad.sdk.utils.am;
/* loaded from: classes5.dex */
public final class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IOfflineCompoTachikomaView Qq;

    public d(@NonNull IOfflineCompoTachikomaView iOfflineCompoTachikomaView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iOfflineCompoTachikomaView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        am.checkNotNull(iOfflineCompoTachikomaView);
        this.Qq = iOfflineCompoTachikomaView;
    }

    @Override // com.kwad.sdk.components.h
    public final void a(String str, String str2, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, gVar) == null) {
            this.Qq.execute(str, str2, new c(gVar));
        }
    }

    @Override // com.kwad.sdk.components.h
    public final void c(com.kwad.sdk.core.webview.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        this.Qq.registerJsBridge(new b(aVar));
    }

    @Override // com.kwad.sdk.components.h
    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.Qq.getView() : (View) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.h
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.Qq.onDestroy();
        }
    }
}
