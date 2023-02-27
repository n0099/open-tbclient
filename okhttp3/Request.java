package okhttp3;

import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
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
            this.isFallbackConn = false;
            this.addressIndex = -1;
            this.isMultiConnectTriggered = false;
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder delete() {
            return delete(Util.EMPTY_REQUEST);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder(Request request) {
            Map<Class<?>, Object> linkedHashMap;
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

        public Builder addressIndex(int i) {
            this.addressIndex = i;
            return this;
        }

        public Builder addressList(List<Route> list) {
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

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.isEmpty()) {
                return removeHeader(com.baidubce.http.Headers.CACHE_CONTROL);
            }
            return header(com.baidubce.http.Headers.CACHE_CONTROL, cacheControl2);
        }

        public Builder delete(@Nullable RequestBody requestBody) {
            return method(HttpDelete.METHOD_NAME, requestBody);
        }

        public Builder fallbackConn(boolean z) {
            this.isFallbackConn = z;
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder isMultiConnectTriggered(boolean z) {
            this.isMultiConnectTriggered = z;
            return this;
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method(HttpPut.METHOD_NAME, requestBody);
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder tag(@Nullable Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(URL url) {
            if (url != null) {
                return url(HttpUrl.get(url.toString()));
            }
            throw new NullPointerException("url == null");
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public <T> Builder tag(Class<? super T> cls, @Nullable T t) {
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

        public Builder method(String str, @Nullable RequestBody requestBody) {
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

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.url = httpUrl;
                return this;
            }
            throw new NullPointerException("url == null");
        }
    }

    public Request(Builder builder) {
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
        this.addressIndex = i;
    }

    @Nullable
    public String header(String str) {
        return this.headers.get(str);
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    @Nullable
    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.tags.get(cls));
    }

    @Nullable
    public RequestBody body() {
        return this.body;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl == null) {
            CacheControl parse = CacheControl.parse(this.headers);
            this.cacheControl = parse;
            return parse;
        }
        return cacheControl;
    }

    public int getAddressIndex() {
        return this.addressIndex;
    }

    public List<InetAddress> getAddressList() {
        List<InetAddress> list = this.addressList;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return null;
    }

    public int getMaxMultiConnectNum() {
        return this.maxMultiConnectNum;
    }

    public int getMultiConnectDelayTimeInMs() {
        return this.multiConnectDelayTimeInMs;
    }

    public Headers headers() {
        return this.headers;
    }

    public boolean isFallbackConn() {
        return this.isFallbackConn;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public boolean isMultiConnectTriggered() {
        return this.isMultiConnectTriggered;
    }

    public String method() {
        return this.method;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
    }

    public HttpUrl url() {
        return this.url;
    }
}
