package com.sdk.base.framework.a;

import android.net.ConnectivityManager;
import android.net.Network;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes10.dex */
public final class b extends ConnectivityManager.NetworkCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ URL f75257a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f75258b;

    public b(a aVar, URL url) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, url};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75258b = aVar;
        this.f75257a = url;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, network) == null) {
            super.onAvailable(network);
            try {
                this.f75258b.f75250c = (HttpURLConnection) network.openConnection(this.f75257a);
            } catch (IOException unused) {
            }
        }
    }
}
