package okhttp3.internal.cache;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes8.dex */
public final class CacheStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final Response cacheResponse;
    @Nullable
    public final Request networkRequest;

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                for (int i3 = 0; i3 < size; i3++) {
                    String name = headers.name(i3);
                    String value = headers.value(i3);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.servedDate = HttpDate.parse(value);
                        this.servedDateString = value;
                    } else if (com.baidubce.http.Headers.EXPIRES.equalsIgnoreCase(name)) {
                        this.expires = HttpDate.parse(value);
                    } else if (com.baidubce.http.Headers.LAST_MODIFIED.equalsIgnoreCase(name)) {
                        this.lastModified = HttpDate.parse(value);
                        this.lastModifiedString = value;
                    } else if (com.baidubce.http.Headers.ETAG.equalsIgnoreCase(name)) {
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
                long j = 0;
                if (date != null) {
                    j = Math.max(0L, this.receivedResponseMillis - date.getTime());
                }
                int i = this.ageSeconds;
                if (i != -1) {
                    j = Math.max(j, TimeUnit.SECONDS.toMillis(i));
                }
                long j2 = this.receivedResponseMillis;
                return j + (j2 - this.sentRequestMillis) + (this.nowMillis - j2);
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
                    if (time <= 0) {
                        return 0L;
                    }
                    return time;
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
                    if (time2 <= 0) {
                        return 0L;
                    }
                    return time2 / 10;
                }
            }
            return invokeV.longValue;
        }

        private CacheStrategy getCandidate() {
            InterceptResult invokeV;
            long j;
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
                    long j2 = 0;
                    if (cacheControl.minFreshSeconds() != -1) {
                        j = TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds());
                    } else {
                        j = 0;
                    }
                    if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                        j2 = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
                    }
                    if (!cacheControl2.noCache()) {
                        long j3 = j + cacheResponseAge;
                        if (j3 < j2 + computeFreshnessLifetime) {
                            Response.Builder newBuilder = this.cacheResponse.newBuilder();
                            if (j3 >= computeFreshnessLifetime) {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, request)) == null) {
                if (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        private boolean isFreshnessLifetimeHeuristic() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
                if (this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public CacheStrategy get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                CacheStrategy candidate = getCandidate();
                if (candidate.networkRequest != null && this.request.cacheControl().onlyIfCached()) {
                    return new CacheStrategy(null, null);
                }
                return candidate;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                if (response.header(com.baidubce.http.Headers.EXPIRES) == null) {
                    if (response.cacheControl().maxAgeSeconds() == -1) {
                        if (!response.cacheControl().isPublic()) {
                        }
                    }
                }
            }
            if (response.cacheControl().noStore() || request.cacheControl().noStore()) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
