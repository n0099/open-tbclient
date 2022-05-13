package com.tachikoma.core.component.network;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.api.IRequestCallbackInner;
import com.tachikoma.core.utility.UIThreadUtil;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class RequestOKHttpDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient mOkHttpClient;

    public RequestOKHttpDelegate(OkHttpClient okHttpClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOkHttpClient = okHttpClient;
    }

    private void sendHttpPostRequest(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, IRequestCallbackInner iRequestCallbackInner) {
        HashMap hashMap3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{str, str2, Integer.valueOf(i), hashMap, hashMap2, iRequestCallbackInner}) == null) {
            if (hashMap != null) {
                hashMap3 = new HashMap();
                for (String str3 : hashMap.keySet()) {
                    hashMap3.put(str3, String.valueOf(hashMap.get(str3)));
                }
            } else {
                hashMap3 = null;
            }
            FormBody.Builder builder = new FormBody.Builder();
            for (String str4 : hashMap2.keySet()) {
                builder.add(str4, String.valueOf(hashMap2.get(str4)));
            }
            this.mOkHttpClient.newCall(new Request.Builder().url(str).headers(hashMap3 == null ? new Headers.Builder().build() : Headers.of(hashMap3)).post(builder.build()).build()).enqueue(new Callback(this, iRequestCallbackInner) { // from class: com.tachikoma.core.component.network.RequestOKHttpDelegate.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RequestOKHttpDelegate this$0;
                public final /* synthetic */ IRequestCallbackInner val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iRequestCallbackInner};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = iRequestCallbackInner;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) || this.val$callback == null) {
                        return;
                    }
                    UIThreadUtil.runOnUiThread(new Runnable(this) { // from class: com.tachikoma.core.component.network.RequestOKHttpDelegate.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.this$1.val$callback.onError(null);
                            }
                        }
                    });
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) || this.val$callback == null) {
                        return;
                    }
                    UIThreadUtil.runOnUiThread(response.code() != 200 ? new Runnable(this) { // from class: com.tachikoma.core.component.network.RequestOKHttpDelegate.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.this$1.val$callback.onError(null);
                            }
                        }
                    } : new Runnable(this, response) { // from class: com.tachikoma.core.component.network.RequestOKHttpDelegate.1.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ Response val$response;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, response};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$response = response;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.this$1.val$callback.onComplete(this.val$response.toString());
                            }
                        }
                    });
                }
            });
        }
    }

    public void send(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, IRequestCallbackInner iRequestCallbackInner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), hashMap, hashMap2, iRequestCallbackInner}) == null) {
            sendHttpPostRequest(str, str2, i, hashMap, hashMap2, iRequestCallbackInner);
        }
    }
}
