package com.kwad.sdk.glide.c;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.kwad.sdk.glide.c.c;
/* loaded from: classes7.dex */
public class f implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    @Override // com.kwad.sdk.glide.c.d
    @NonNull
    public c a(@NonNull Context context, @NonNull c.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, aVar)) == null) {
            boolean z = ContextCompat.checkSelfPermission(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) == 0;
            if (Log.isLoggable("ConnectivityMonitor", 3)) {
                Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
            }
            return z ? new e(context, aVar) : new j();
        }
        return (c) invokeLL.objValue;
    }
}
