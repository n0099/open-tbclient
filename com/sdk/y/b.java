package com.sdk.y;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends ConnectivityManager.NetworkCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;
    public final /* synthetic */ f b;

    public b(f fVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = fVar;
        this.a = i;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        URL url;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, network) == null) {
            if (network != null) {
                try {
                    f fVar = this.b;
                    url = this.b.i;
                    fVar.k = (HttpURLConnection) network.openConnection(url);
                } catch (Exception e) {
                    String str = f.a;
                    Log.d(str, "onAvailable: " + e);
                    return;
                }
            }
            List<String> a = this.b.a();
            com.sdk.x.a aVar = new com.sdk.x.a();
            f fVar2 = this.b;
            context = this.b.e;
            fVar2.g = aVar.a(context, this.a, a, new a(this));
        }
    }
}
