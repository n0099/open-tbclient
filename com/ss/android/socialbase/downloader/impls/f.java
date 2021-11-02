package com.ss.android.socialbase.downloader.impls;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class f implements com.ss.android.socialbase.downloader.network.h {
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

    @Override // com.ss.android.socialbase.downloader.network.h
    public com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, list)) == null) {
            OkHttpClient s = com.ss.android.socialbase.downloader.downloader.c.s();
            if (s != null) {
                Request.Builder head = new Request.Builder().url(str).head();
                if (list != null && list.size() > 0) {
                    for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                        head.addHeader(cVar.a(), com.ss.android.socialbase.downloader.i.f.g(cVar.b()));
                    }
                }
                Call newCall = s.newCall(head.build());
                Response execute = newCall.execute();
                if (execute != null) {
                    if (com.ss.android.socialbase.downloader.i.a.a(2097152)) {
                        execute.close();
                    }
                    return new com.ss.android.socialbase.downloader.network.g(this, execute, newCall) { // from class: com.ss.android.socialbase.downloader.impls.f.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Response f69550a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Call f69551b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ f f69552c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, execute, newCall};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f69552c = this;
                            this.f69550a = execute;
                            this.f69551b = newCall;
                        }

                        @Override // com.ss.android.socialbase.downloader.network.g
                        public String a(String str2) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str2)) == null) ? this.f69550a.header(str2) : (String) invokeL.objValue;
                        }

                        @Override // com.ss.android.socialbase.downloader.network.g
                        public int b() throws IOException {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69550a.code() : invokeV.intValue;
                        }

                        @Override // com.ss.android.socialbase.downloader.network.g
                        public void c() {
                            Call call;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (call = this.f69551b) == null || call.isCanceled()) {
                                return;
                            }
                            this.f69551b.cancel();
                        }
                    };
                }
                throw new IOException("can't get response");
            }
            throw new IOException("can't get httpClient");
        }
        return (com.ss.android.socialbase.downloader.network.g) invokeLL.objValue;
    }
}
