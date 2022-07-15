package com.repackage;

import android.net.http.Headers;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.manager.HttpManager;
import com.baidu.searchbox.network.outback.request.PostFormRequest;
import com.baidu.searchbox.network.outback.request.RequestCall;
import com.baidu.searchbox.network.outback.statistics.RequestCallException;
import com.baidu.searchbox.network.outback.support.request.HttpRequestCompat;
import com.baidu.searchbox.network.outback.support.request.PostBodyRequest;
import com.baidu.searchbox.network.outback.support.request.PostMultiPartFormRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public class pf implements IHttpNet {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final rf a;
    public Request.Builder<?> b;
    public RequestCall c;
    public Response d;

    /* loaded from: classes6.dex */
    public class a extends RequestBody {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pf a;

        public a(pf pfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfVar;
        }

        @Override // com.baidu.searchbox.network.outback.core.RequestBody
        @Nullable
        public MediaType contentType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? MediaType.parse("multipart/form-data; boundary=--------7da3d81520810*") : (MediaType) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.network.outback.core.RequestBody
        public void writeTo(OutputStream outputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, outputStream) == null) {
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                if (this.a.a.b().j() != null) {
                    Iterator<BasicNameValuePair> it = this.a.a.b().j().iterator();
                    while (it.hasNext()) {
                        BasicNameValuePair next = it.next();
                        if (next != null) {
                            String name = next.getName();
                            String value = next.getValue();
                            if (value != null && name != null) {
                                dataOutputStream.writeBytes("----------7da3d81520810*\r\n");
                                byte[] bytes = value.getBytes("UTF-8");
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                                dataOutputStream.writeBytes("\r\n");
                                dataOutputStream.write(bytes);
                                dataOutputStream.writeBytes("\r\n");
                            }
                        }
                    }
                }
                if (this.a.a.b().g != null) {
                    for (Map.Entry<String, byte[]> entry : this.a.a.b().g.entrySet()) {
                        String key = entry.getKey();
                        byte[] value2 = entry.getValue();
                        if (value2 != null) {
                            dataOutputStream.writeBytes("----------7da3d81520810*\r\n");
                            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"\r\n");
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.write(value2);
                            dataOutputStream.writeBytes("\r\n");
                        }
                    }
                }
                dataOutputStream.writeBytes("----------7da3d81520810*--\r\n");
                dataOutputStream.flush();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1942945071, "Lcom/repackage/pf$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1942945071, "Lcom/repackage/pf$b;");
                    return;
                }
            }
            int[] iArr = new int[IHttpNet.HttpNetType.values().length];
            a = iArr;
            try {
                iArr[IHttpNet.HttpNetType.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IHttpNet.HttpNetType.POST_FORM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[IHttpNet.HttpNetType.POST_BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public pf(rf rfVar, IHttpNet.HttpNetType httpNetType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rfVar, httpNetType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rfVar;
        int i3 = b.a[httpNetType.ordinal()];
        if (i3 == 1) {
            this.b = HttpManager.getDefault(BdBaseApplication.getInst()).getRequest();
        } else if (i3 == 2) {
            this.b = HttpManager.getDefault(BdBaseApplication.getInst()).postFormRequest();
        } else if (i3 != 3) {
        } else {
            if (((mf) ServiceManager.getService(mf.a)).netBdABTest()) {
                this.b = new HttpRequestCompat(HttpManager.getDefault(BdBaseApplication.getInst())).postRequest();
            } else {
                this.b = new HttpRequestCompat(HttpManager.getDefault(BdBaseApplication.getInst())).postMultiPartRequest();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.baidu.searchbox.network.outback.core.Request$Builder] */
    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void a(URL url, int i, int i2) {
        Request.Builder<?> builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048576, this, url, i, i2) == null) || (builder = this.b) == null || url == null) {
            return;
        }
        builder.url(url.toString()).connectionTimeout(i * 2).readTimeout(i2 * 2).requestSubFrom(8927);
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public Map<String, List<String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Response response = this.d;
            if (response == null || response.headers() == null) {
                return null;
            }
            return this.d.headers().toMultimap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Request.Builder<?> builder = this.b;
            if (builder == null) {
                return 0;
            }
            if (builder instanceof PostFormRequest.PostFormRequestBuilder) {
                ((PostFormRequest.PostFormRequestBuilder) builder).params(this.a.b().i());
            } else if (builder instanceof PostMultiPartFormRequest.PostMultiPartFormRequestBuilder) {
                ((PostMultiPartFormRequest.PostMultiPartFormRequestBuilder) builder).addParams(this.a.b().i());
                if (this.a.b().g != null) {
                    for (Map.Entry<String, byte[]> entry : this.a.b().g.entrySet()) {
                        String key = entry.getKey();
                        byte[] value = entry.getValue();
                        if (value != null) {
                            ((PostMultiPartFormRequest.PostMultiPartFormRequestBuilder) this.b).addBytes(key, "file", "application/octet-stream", value);
                        }
                    }
                }
            } else if (builder instanceof PostBodyRequest.PostBodyRequestBuilder) {
                ((PostBodyRequest.PostBodyRequestBuilder) builder).requestBody(new a(this));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void connect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public URL d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (URL) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void e(URL url) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, url) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public byte[] execute() throws RequestCallException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequestCall makeRequestCall = this.b.build().makeRequestCall();
            this.c = makeRequestCall;
            Response executeSync = makeRequestCall.executeSync();
            this.d = executeSync;
            if (executeSync == null || executeSync.body() == null) {
                return null;
            }
            return this.d.body().bytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void f() {
        Request.Builder<?> builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (builder = this.b) == null) {
            return;
        }
        builder.addHeaders(this.a.b().g());
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void g(URL url, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, url, z) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Response response = this.d;
            return (response == null || response.headers() == null) ? "" : this.d.headers().get(Headers.CONTENT_ENCODING);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Response response = this.d;
            if (response == null || response.body() == null) {
                return 0L;
            }
            return this.d.body().contentLength();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Response response = this.d;
            return (response == null || response.body() == null || this.d.body().contentType() == null) ? "" : this.d.body().contentType().toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public int getResponseCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Response response = this.d;
            if (response == null) {
                return 0;
            }
            return response.code();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }
}
