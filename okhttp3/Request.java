package okhttp3;

import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
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
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes14.dex */
public final class Request {
    private List<InetAddress> addressList;
    @Nullable
    final RequestBody body;
    @Nullable
    private volatile CacheControl cacheControl;
    final Headers headers;
    private boolean isFallbackConn;
    final String method;
    final Headers proxyHeaders;
    final Map<Class<?>, Object> tags;
    final HttpUrl url;

    Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.proxyHeaders = builder.proxyHeaders.build();
        this.body = builder.body;
        this.tags = Util.immutableMap(builder.tags);
        this.isFallbackConn = builder.isFallbackConn;
        this.addressList = builder.addressList;
    }

    public HttpUrl url() {
        return this.url;
    }

    public String method() {
        return this.method;
    }

    public Headers headers() {
        return this.headers;
    }

    public Headers proxyHeaders() {
        return this.proxyHeaders;
    }

    @Nullable
    public String header(String str) {
        return this.headers.get(str);
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    public String proxyHeader(String str) {
        return this.proxyHeaders.get(str);
    }

    public List<String> proxyHeaders(String str) {
        return this.proxyHeaders.values(str);
    }

    @Nullable
    public RequestBody body() {
        return this.body;
    }

    @Nullable
    public Object tag() {
        return tag(Object.class);
    }

    @Nullable
    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.tags.get(cls));
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.headers);
        this.cacheControl = parse;
        return parse;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public boolean isFallbackConn() {
        return this.isFallbackConn;
    }

    public List<InetAddress> getAddressList() {
        if (this.addressList != null) {
            return Collections.unmodifiableList(this.addressList);
        }
        return null;
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
    }

    /* loaded from: classes14.dex */
    public static class Builder {
        List<InetAddress> addressList;
        @Nullable
        RequestBody body;
        Headers.Builder headers;
        boolean isFallbackConn;
        String method;
        Headers.Builder proxyHeaders;
        Map<Class<?>, Object> tags;
        @Nullable
        HttpUrl url;

        public Builder() {
            this.isFallbackConn = false;
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
            this.proxyHeaders = new Headers.Builder();
        }

        Builder(Request request) {
            this.isFallbackConn = false;
            this.tags = Collections.emptyMap();
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.tags = request.tags.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(request.tags);
            this.headers = request.headers.newBuilder();
            this.proxyHeaders = request.proxyHeaders.newBuilder();
            this.isFallbackConn = request.isFallbackConn;
            this.addressList = request.addressList;
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new NullPointerException("url == null");
            }
            this.url = httpUrl;
            return this;
        }

        public Builder url(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTP + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = UrlSchemaHelper.SCHEMA_TYPE_HTTPS + str.substring(4);
            }
            return url(HttpUrl.get(str));
        }

        public Builder url(URL url) {
            if (url == null) {
                throw new NullPointerException("url == null");
            }
            return url(HttpUrl.get(url.toString()));
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder proxyHeader(String str, String str2) {
            this.proxyHeaders.set(str, str2);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder addProxyHeader(String str, String str2) {
            this.proxyHeaders.add(str, str2);
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder removeProxyHeader(String str) {
            this.proxyHeaders.removeAll(str);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder proxyHeaders(Headers headers) {
            this.proxyHeaders = headers.newBuilder();
            return this;
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.isEmpty() ? removeHeader(com.baidubce.http.Headers.CACHE_CONTROL) : header(com.baidubce.http.Headers.CACHE_CONTROL, cacheControl2);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method(HttpHead.METHOD_NAME, null);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder delete(@Nullable RequestBody requestBody) {
            return method(HttpDelete.METHOD_NAME, requestBody);
        }

        public Builder delete() {
            return delete(Util.EMPTY_REQUEST);
        }

        public Builder put(RequestBody requestBody) {
            return method(HttpPut.METHOD_NAME, requestBody);
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder method(String str, @Nullable RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody == null && HttpMethod.requiresRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.method = str;
            this.body = requestBody;
            return this;
        }

        public Builder tag(@Nullable Object obj) {
            return tag(Object.class, obj);
        }

        public <T> Builder tag(Class<? super T> cls, @Nullable T t) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
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

        public Builder fallbackConn(boolean z) {
            this.isFallbackConn = z;
            return this;
        }

        public Request build() {
            if (this.url == null) {
                throw new IllegalStateException("url == null");
            }
            return new Request(this);
        }
    }
}
