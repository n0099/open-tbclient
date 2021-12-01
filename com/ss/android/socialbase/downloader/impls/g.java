package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class g implements IDownloadHttpService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.ss.android.socialbase.downloader.i.h<String, OkHttpClient> a;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new com.ss.android.socialbase.downloader.i.h<>(4, 8);
    }

    private OkHttpClient a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            try {
                String host = Uri.parse(str).getHost();
                if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                    String str3 = host + "_" + str2;
                    synchronized (this.a) {
                        OkHttpClient okHttpClient = this.a.get(str3);
                        if (okHttpClient != null) {
                            return okHttpClient;
                        }
                        OkHttpClient.Builder t = com.ss.android.socialbase.downloader.downloader.c.t();
                        t.dns(new Dns(this, host, str2) { // from class: com.ss.android.socialbase.downloader.impls.g.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ String a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f61942b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ g f61943c;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, host, str2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f61943c = this;
                                this.a = host;
                                this.f61942b = str2;
                            }
                        });
                        OkHttpClient build = t.build();
                        synchronized (this.a) {
                            this.a.put(str3, build);
                        }
                        return build;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return com.ss.android.socialbase.downloader.downloader.c.s();
        }
        return (OkHttpClient) invokeLL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public com.ss.android.socialbase.downloader.network.i downloadWithConnection(int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
        InterceptResult invokeILL;
        String str2;
        OkHttpClient s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, str, list)) == null) {
            Request.Builder url = new Request.Builder().url(str);
            if (list == null || list.size() <= 0) {
                str2 = null;
            } else {
                str2 = null;
                for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                    String a = cVar.a();
                    if (str2 == null && "ss_d_request_host_ip_114".equals(a)) {
                        str2 = cVar.b();
                    } else {
                        url.addHeader(a, com.ss.android.socialbase.downloader.i.f.g(cVar.b()));
                    }
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                s = a(str, str2);
            } else {
                s = com.ss.android.socialbase.downloader.downloader.c.s();
            }
            if (s != null) {
                Call newCall = s.newCall(url.build());
                Response execute = newCall.execute();
                if (execute != null) {
                    ResponseBody body = execute.body();
                    if (body != null) {
                        InputStream byteStream = body.byteStream();
                        String header = execute.header("Content-Encoding");
                        return new com.ss.android.socialbase.downloader.network.e(this, (header == null || !"gzip".equalsIgnoreCase(header) || (byteStream instanceof GZIPInputStream)) ? byteStream : new GZIPInputStream(byteStream), execute, newCall, body) { // from class: com.ss.android.socialbase.downloader.impls.g.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ InputStream a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ Response f61938b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ Call f61939c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ ResponseBody f61940d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ g f61941e;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7, execute, newCall, body};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f61941e = this;
                                this.a = r7;
                                this.f61938b = execute;
                                this.f61939c = newCall;
                                this.f61940d = body;
                            }

                            @Override // com.ss.android.socialbase.downloader.network.i
                            public InputStream a() throws IOException {
                                InterceptResult invokeV;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.a : (InputStream) invokeV.objValue;
                            }

                            @Override // com.ss.android.socialbase.downloader.network.g
                            public int b() throws IOException {
                                InterceptResult invokeV;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61938b.code() : invokeV.intValue;
                            }

                            @Override // com.ss.android.socialbase.downloader.network.g
                            public void c() {
                                Call call;
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || (call = this.f61939c) == null || call.isCanceled()) {
                                    return;
                                }
                                this.f61939c.cancel();
                            }

                            @Override // com.ss.android.socialbase.downloader.network.i
                            public void d() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                                    try {
                                        if (this.f61940d != null) {
                                            this.f61940d.close();
                                        }
                                        if (this.f61939c == null || this.f61939c.isCanceled()) {
                                            return;
                                        }
                                        this.f61939c.cancel();
                                    } catch (Throwable unused) {
                                    }
                                }
                            }

                            @Override // com.ss.android.socialbase.downloader.network.a
                            public String e() {
                                InterceptResult invokeV;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
                            }

                            @Override // com.ss.android.socialbase.downloader.network.g
                            public String a(String str3) {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3)) == null) ? this.f61938b.header(str3) : (String) invokeL.objValue;
                            }
                        };
                    }
                    return null;
                }
                throw new IOException("can't get response");
            }
            throw new IOException("can't get httpClient");
        }
        return (com.ss.android.socialbase.downloader.network.i) invokeILL.objValue;
    }
}
