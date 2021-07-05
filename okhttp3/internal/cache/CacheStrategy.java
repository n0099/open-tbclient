package okhttp3.internal.cache;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;
/* loaded from: classes10.dex */
public final class CacheStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final Response cacheResponse;
    @Nullable
    public final Request networkRequest;

    /* loaded from: classes10.dex */
    public static class Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int ageSeconds;
        public final Response cacheResponse;
        public String etag;
        public Date expires;
        public Date lastModified;
        public String lastModifiedString;
        public final long nowMillis;
        public long receivedResponseMillis;
        public final Request request;
        public long sentRequestMillis;
        public Date servedDate;
        public String servedDateString;

        public Factory(long j, Request request, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), request, response};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ageSeconds = -1;
            this.nowMillis = j;
            this.request = request;
            this.cacheResponse = response;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i4 = 0; i4 < size; i4++) {
                    String name = headers.name(i4);
                    String value = headers.value(i4);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.servedDate = HttpDate.parse(value);
                        this.servedDateString = value;
                    } else if ("Expires".equalsIgnoreCase(name)) {
                        this.expires = HttpDate.parse(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.lastModified = HttpDate.parse(value);
                        this.lastModifiedString = value;
                    } else if ("ETag".equalsIgnoreCase(name)) {
                        this.etag = value;
                    } else if ("Age".equalsIgnoreCase(name)) {
                        this.ageSeconds = HttpHeaders.parseSeconds(value, -1);
                    }
                }
            }
        }

        private long cacheResponseAge() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                Date date = this.servedDate;
                long max = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
                int i2 = this.ageSeconds;
                if (i2 != -1) {
                    max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
                }
                long j = this.receivedResponseMillis;
                return max + (j - this.sentRequestMillis) + (this.nowMillis - j);
            }
            return invokeV.longValue;
        }

        private long computeFreshnessLifetime() {
            InterceptResult invokeV;
            long j;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                CacheControl cacheControl = this.cacheResponse.cacheControl();
                if (cacheControl.maxAgeSeconds() != -1) {
                    return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
                }
                if (this.expires != null) {
                    Date date = this.servedDate;
                    if (date != null) {
                        j2 = date.getTime();
                    } else {
                        j2 = this.receivedResponseMillis;
                    }
                    long time = this.expires.getTime() - j2;
                    if (time > 0) {
                        return time;
                    }
                    return 0L;
                } else if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                    return 0L;
                } else {
                    Date date2 = this.servedDate;
                    if (date2 != null) {
                        j = date2.getTime();
                    } else {
                        j = this.sentRequestMillis;
                    }
                    long time2 = j - this.lastModified.getTime();
                    if (time2 > 0) {
                        return time2 / 10;
                    }
                    return 0L;
                }
            }
            return invokeV.longValue;
        }

        private CacheStrategy getCandidate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                if (this.cacheResponse == null) {
                    return new CacheStrategy(this.request, null);
                }
                if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                    return new CacheStrategy(this.request, null);
                }
                if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
                    return new CacheStrategy(this.request, null);
                }
                CacheControl cacheControl = this.request.cacheControl();
                if (!cacheControl.noCache() && !hasConditions(this.request)) {
                    CacheControl cacheControl2 = this.cacheResponse.cacheControl();
                    if (cacheControl2.immutable()) {
                        return new CacheStrategy(null, this.cacheResponse);
                    }
                    long cacheResponseAge = cacheResponseAge();
                    long computeFreshnessLifetime = computeFreshnessLifetime();
                    if (cacheControl.maxAgeSeconds() != -1) {
                        computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
                    }
                    long j = 0;
                    long millis = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
                    if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                        j = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
                    }
                    if (!cacheControl2.noCache()) {
                        long j2 = millis + cacheResponseAge;
                        if (j2 < j + computeFreshnessLifetime) {
                            Response.Builder newBuilder = this.cacheResponse.newBuilder();
                            if (j2 >= computeFreshnessLifetime) {
                                newBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (cacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                                newBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                            }
                            return new CacheStrategy(null, newBuilder.build());
                        }
                    }
                    String str = this.etag;
                    String str2 = "If-Modified-Since";
                    if (str != null) {
                        str2 = "If-None-Match";
                    } else if (this.lastModified != null) {
                        str = this.lastModifiedString;
                    } else if (this.servedDate != null) {
                        str = this.servedDateString;
                    } else {
                        return new CacheStrategy(this.request, null);
                    }
                    Headers.Builder newBuilder2 = this.request.headers().newBuilder();
                    Internal.instance.addLenient(newBuilder2, str2, str);
                    return new CacheStrategy(this.request.newBuilder().headers(newBuilder2.build()).build(), this.cacheResponse);
                }
                return new CacheStrategy(this.request, null);
            }
            return (CacheStrategy) invokeV.objValue;
        }

        public static boolean hasConditions(Request request) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, request)) == null) ? (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true : invokeL.booleanValue;
        }

        private boolean isFreshnessLifetimeHeuristic() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null : invokeV.booleanValue;
        }

        public CacheStrategy get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                CacheStrategy candidate = getCandidate();
                return (candidate.networkRequest == null || !this.request.cacheControl().onlyIfCached()) ? candidate : new CacheStrategy(null, null);
            }
            return (CacheStrategy) invokeV.objValue;
        }
    }

    public CacheStrategy(Request request, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {request, response};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
        if (r4.cacheControl().isPrivate() == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isCacheable(Response response, Request request) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, response, request)) == null) {
            int code = response.code();
            if (code != 200 && code != 410 && code != 414 && code != 501 && code != 203 && code != 204) {
                if (code != 307) {
                    if (code != 308 && code != 404 && code != 405) {
                        switch (code) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (response.header("Expires") == null) {
                    if (response.cacheControl().maxAgeSeconds() == -1) {
                        if (!response.cacheControl().isPublic()) {
                        }
                    }
                }
            }
            return (response.cacheControl().noStore() || request.cacheControl().noStore()) ? false : true;
        }
        return invokeLL.booleanValue;
    }
}
