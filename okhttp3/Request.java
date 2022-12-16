package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes9.dex */
public final class Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int addressIndex;
    public List<InetAddress> addressList;
    @Nullable
    public final RequestBody body;
    @Nullable
    public volatile CacheControl cacheControl;
    public final Headers headers;
    public boolean isFallbackConn;
    public boolean isMultiConnectTriggered;
    public int maxMultiConnectNum;
    public final String method;
    public int multiConnectDelayTimeInMs;
    public final Map<Class<?>, Object> tags;
    public final HttpUrl url;

    /* loaded from: classes9.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int addressIndex;
        public List<InetAddress> addressList;
        @Nullable
        public RequestBody body;
        public Headers.Builder headers;
        public boolean isFallbackConn;
        public boolean isMultiConnectTriggered;
        public String method;
        public Map<Class<?>, Object> tags;
        @Nullable
        public HttpUrl url;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isFallbackConn = false;
            this.addressIndex = -1;
            this.isMultiConnectTriggered = false;
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder(Request request) {
            Map<Class<?>, Object> linkedHashMap;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {request};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.isFallbackConn = false;
            this.addressIndex = -1;
            this.isMultiConnectTriggered = false;
            this.tags = Collections.emptyMap();
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            if (request.tags.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(request.tags);
            }
            this.tags = linkedHashMap;
            this.headers = request.headers.newBuilder();
            this.isFallbackConn = request.isFallbackConn;
            this.addressList = request.addressList;
            this.addressIndex = request.addressIndex;
            this.isMultiConnectTriggered = request.isMultiConnectTriggered;
        }

        public Builder url(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                if (str != null) {
                    if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                        str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
                    } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
                    }
                    return url(HttpUrl.get(str));
                }
                throw new NullPointerException("url == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addressIndex(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.addressIndex = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder cacheControl(CacheControl cacheControl) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cacheControl)) == null) {
                String cacheControl2 = cacheControl.toString();
                if (cacheControl2.isEmpty()) {
                    return removeHeader(com.baidubce.http.Headers.CACHE_CONTROL);
                }
                return header(com.baidubce.http.Headers.CACHE_CONTROL, cacheControl2);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder delete(@Nullable RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, requestBody)) == null) {
                return method(HttpDelete.METHOD_NAME, requestBody);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder fallbackConn(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.isFallbackConn = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder headers(Headers headers) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, headers)) == null) {
                this.headers = headers.newBuilder();
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder isMultiConnectTriggered(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.isMultiConnectTriggered = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder patch(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, requestBody)) == null) {
                return method("PATCH", requestBody);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder post(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, requestBody)) == null) {
                return method("POST", requestBody);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder put(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, requestBody)) == null) {
                return method(HttpPut.METHOD_NAME, requestBody);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder removeHeader(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.headers.removeAll(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder tag(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
                return tag(Object.class, obj);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder url(URL url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, url)) == null) {
                if (url != null) {
                    return url(HttpUrl.get(url.toString()));
                }
                throw new NullPointerException("url == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addHeader(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.headers.add(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder header(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
                this.headers.set(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder addressList(List<Route> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
                if (list != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Route route : list) {
                        InetSocketAddress socketAddress = route.socketAddress();
                        if (!socketAddress.isUnresolved()) {
                            arrayList.add(socketAddress.getAddress());
                        }
                    }
                    this.addressList = arrayList;
                } else {
                    this.addressList = null;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Request build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.url != null) {
                    return new Request(this);
                }
                throw new IllegalStateException("url == null");
            }
            return (Request) invokeV.objValue;
        }

        public Builder delete() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return delete(Util.EMPTY_REQUEST);
            }
            return (Builder) invokeV.objValue;
        }

        public Builder get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return method("GET", null);
            }
            return (Builder) invokeV.objValue;
        }

        public Builder head() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return method("HEAD", null);
            }
            return (Builder) invokeV.objValue;
        }

        public Builder method(String str, @Nullable RequestBody requestBody) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, requestBody)) == null) {
                if (str != null) {
                    if (str.length() != 0) {
                        if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                            throw new IllegalArgumentException("method " + str + " must not have a request body.");
                        } else if (requestBody == null && HttpMethod.requiresRequestBody(str)) {
                            throw new IllegalArgumentException("method " + str + " must have a request body.");
                        } else {
                            this.method = str;
                            this.body = requestBody;
                            return this;
                        }
                    }
                    throw new IllegalArgumentException("method.length() == 0");
                }
                throw new NullPointerException("method == null");
            }
            return (Builder) invokeLL.objValue;
        }

        public <T> Builder tag(Class<? super T> cls, @Nullable T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, cls, t)) == null) {
                if (cls != null) {
                    if (t == null) {
                        this.tags.remove(cls);
                    } else {
                        if (this.tags.isEmpty()) {
                            this.tags = new LinkedHashMap();
                        }
                        this.tags.put(cls, cls.cast(t));
                    }
                    return this;
                }
                throw new NullPointerException("type == null");
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder url(HttpUrl httpUrl) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, httpUrl)) == null) {
                if (httpUrl != null) {
                    this.url = httpUrl;
                    return this;
                }
                throw new NullPointerException("url == null");
            }
            return (Builder) invokeL.objValue;
        }
    }

    public Request(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isMultiConnectTriggered = false;
        this.url = builder.url;
        this.method = builder.method;
        this.addressIndex = builder.addressIndex;
        this.isMultiConnectTriggered = builder.isMultiConnectTriggered;
        String str = builder.headers.get(HttpRequest.EXT_HEADER_MULTIPLE_CONNECT_NUM);
        String str2 = builder.headers.get(HttpRequest.EXT_HEADER_MULTIPLE_CONNECT_DELAY_TIME_MS);
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            try {
                this.maxMultiConnectNum = Integer.parseInt(str);
                this.multiConnectDelayTimeInMs = Integer.parseInt(str2);
                builder.removeHeader(HttpRequest.EXT_HEADER_MULTIPLE_CONNECT_NUM).removeHeader(HttpRequest.EXT_HEADER_MULTIPLE_CONNECT_DELAY_TIME_MS);
            } catch (NumberFormatException unused) {
            }
        }
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.tags = Util.immutableMap(builder.tags);
        this.isFallbackConn = builder.isFallbackConn;
        this.addressList = builder.addressList;
    }

    public void addressIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.addressIndex = i;
        }
    }

    @Nullable
    public String header(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return this.headers.get(str);
        }
        return (String) invokeL.objValue;
    }

    public List<String> headers(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return this.headers.values(str);
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public <T> T tag(Class<? extends T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cls)) == null) {
            return cls.cast(this.tags.get(cls));
        }
        return (T) invokeL.objValue;
    }

    @Nullable
    public RequestBody body() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.body;
        }
        return (RequestBody) invokeV.objValue;
    }

    public CacheControl cacheControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            CacheControl cacheControl = this.cacheControl;
            if (cacheControl == null) {
                CacheControl parse = CacheControl.parse(this.headers);
                this.cacheControl = parse;
                return parse;
            }
            return cacheControl;
        }
        return (CacheControl) invokeV.objValue;
    }

    public int getAddressIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.addressIndex;
        }
        return invokeV.intValue;
    }

    public List<InetAddress> getAddressList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<InetAddress> list = this.addressList;
            if (list != null) {
                return Collections.unmodifiableList(list);
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public int getMaxMultiConnectNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.maxMultiConnectNum;
        }
        return invokeV.intValue;
    }

    public int getMultiConnectDelayTimeInMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.multiConnectDelayTimeInMs;
        }
        return invokeV.intValue;
    }

    public Headers headers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.headers;
        }
        return (Headers) invokeV.objValue;
    }

    public boolean isFallbackConn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.isFallbackConn;
        }
        return invokeV.booleanValue;
    }

    public boolean isHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.url.isHttps();
        }
        return invokeV.booleanValue;
    }

    public boolean isMultiConnectTriggered() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.isMultiConnectTriggered;
        }
        return invokeV.booleanValue;
    }

    public String method() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.method;
        }
        return (String) invokeV.objValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return new Builder(this);
        }
        return (Builder) invokeV.objValue;
    }

    @Nullable
    public Object tag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return tag(Object.class);
        }
        return invokeV.objValue;
    }

    public HttpUrl url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.url;
        }
        return (HttpUrl) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
        }
        return (String) invokeV.objValue;
    }
}
