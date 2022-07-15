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
import com.kwad.sdk.utils.aj;
/* loaded from: classes5.dex */
public final class c implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IOfflineCompoTachikomaView a;

    public c(@NonNull IOfflineCompoTachikomaView iOfflineCompoTachikomaView) {
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
        aj.a(iOfflineCompoTachikomaView);
        this.a = iOfflineCompoTachikomaView;
    }

    @Override // com.kwad.sdk.components.g
    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getView() : (View) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.g
    public final void a(com.kwad.sdk.core.webview.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        this.a.registerJsBridge(new b(aVar));
    }

    @Override // com.kwad.sdk.components.g
    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.a.execute(str, str2);
        }
    }

    @Override // com.kwad.sdk.components.g
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.onDestroy();
        }
    }
}
