package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.s03;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes6.dex */
public class ny3 extends HttpManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ny3 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ny3() {
        super(oj2.c());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static ny3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ny3.class) {
                    if (a == null) {
                        a = new ny3();
                    }
                }
            }
            return a;
        }
        return (ny3) invokeV.objValue;
    }

    public static ny3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ny3 ny3Var = new ny3();
            ny3Var.setHttpDnsEnable(a().getHttpDnsEnable());
            return ny3Var;
        }
        return (ny3) invokeV.objValue;
    }

    public void call(Request request, Callback callback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, callback) == null) || request == null) {
            return;
        }
        getOkHttpClient().newCall(request).enqueue(callback);
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        InterceptResult invokeV;
        s03.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (h03.M() == null) {
                return super.initClient();
            }
            a04 a04Var = (a04) h03.M().T();
            OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
            int i = 60000;
            if (a04Var != null && (aVar = a04Var.a) != null) {
                i = aVar.a;
                newBuilder.connectTimeout(aVar.b, TimeUnit.MILLISECONDS);
                newBuilder.addNetworkInterceptor(new as2());
            }
            long j = i;
            newBuilder.readTimeout(j, TimeUnit.MILLISECONDS);
            newBuilder.writeTimeout(j, TimeUnit.MILLISECONDS);
            OkHttpClient build = newBuilder.build();
            build.dispatcher().setMaxRequests(10);
            return build;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public void call(Request request, List<Interceptor> list, Callback callback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, request, list, callback) == null) || request == null) {
            return;
        }
        OkHttpClient.Builder newBuilder = getOkHttpClient().newBuilder();
        if (list != null && !list.isEmpty()) {
            for (Interceptor interceptor : list) {
                if (interceptor != null) {
                    newBuilder.addInterceptor(interceptor);
                }
            }
        }
        newBuilder.build().newCall(request).enqueue(callback);
    }
}
