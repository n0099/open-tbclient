package com.facebook.imagepipeline.producers;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FETCH_TIME = "fetch_time";
    public static final int HTTP_DEFAULT_TIMEOUT = 30000;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    public static final String IMAGE_SIZE = "image_size";
    public static final int MAX_REDIRECTS = 5;
    public static final int NUM_NETWORK_THREADS = 3;
    public static final String QUEUE_TIME = "queue_time";
    public static final String TOTAL_TIME = "total_time";
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService mExecutorService;
    public int mHttpConnectionTimeout;
    public final MonotonicClock mMonotonicClock;
    @Nullable
    public final Map mRequestHeaders;
    @Nullable
    public String mUserAgent;

    public static boolean isHttpRedirect(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            if (i == 307 || i == 308) {
                return true;
            }
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static boolean isHttpSuccess(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) ? i >= 200 && i < 300 : invokeI.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class HttpUrlConnectionNetworkFetchState extends FetchState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HttpUrlConnectionNetworkFetchState(Consumer consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer, producerContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Consumer) objArr2[0], (ProducerContext) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpUrlConnectionNetworkFetcher() {
        this((String) null, (Map) null, RealtimeSinceBootClock.get());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (Map) objArr[1], (MonotonicClock) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpUrlConnectionNetworkFetcher(int i) {
        this((String) null, (Map) null, RealtimeSinceBootClock.get());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Map) objArr2[1], (MonotonicClock) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHttpConnectionTimeout = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpUrlConnectionNetworkFetcher(String str, int i) {
        this(str, (Map) null, RealtimeSinceBootClock.get());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Map) objArr2[1], (MonotonicClock) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mHttpConnectionTimeout = i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x002b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x000e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.net.HttpURLConnection, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, com.facebook.imagepipeline.producers.NetworkFetcher$Callback] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchSync(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, NetworkFetcher.Callback callback) {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, httpUrlConnectionNetworkFetchState, callback) == null) {
            ?? r0 = 0;
            InputStream inputStream = null;
            r0 = 0;
            try {
                try {
                    httpURLConnection = downloadFrom(httpUrlConnectionNetworkFetchState.getUri(), 5);
                    try {
                        httpUrlConnectionNetworkFetchState.responseTime = this.mMonotonicClock.now();
                        if (httpURLConnection != null) {
                            r0 = httpURLConnection.getInputStream();
                            callback.onResponse(r0, -1);
                            inputStream = r0;
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                    } catch (IOException e) {
                        e = e;
                        callback.onFailure(e);
                        if (r0 != 0) {
                            try {
                                r0.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (0 != 0) {
                        r0.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                if (0 != 0) {
                }
                throw th;
            }
            httpURLConnection.disconnect();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public Map getExtraMap(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, httpUrlConnectionNetworkFetchState, i)) == null) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("queue_time", Long.toString(httpUrlConnectionNetworkFetchState.responseTime - httpUrlConnectionNetworkFetchState.submitTime));
            hashMap.put("fetch_time", Long.toString(httpUrlConnectionNetworkFetchState.fetchCompleteTime - httpUrlConnectionNetworkFetchState.responseTime));
            hashMap.put("total_time", Long.toString(httpUrlConnectionNetworkFetchState.fetchCompleteTime - httpUrlConnectionNetworkFetchState.submitTime));
            hashMap.put("image_size", Integer.toString(i));
            return hashMap;
        }
        return (Map) invokeLI.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpUrlConnectionNetworkFetcher(String str, @Nullable Map map, int i) {
        this(str, map, RealtimeSinceBootClock.get());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Map) objArr2[1], (MonotonicClock) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mHttpConnectionTimeout = i;
    }

    public HttpUrlConnectionNetworkFetcher(@Nullable String str, @Nullable Map map, MonotonicClock monotonicClock) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map, monotonicClock};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mExecutorService = Executors.newFixedThreadPool(3);
        this.mMonotonicClock = monotonicClock;
        this.mRequestHeaders = map;
        this.mUserAgent = str;
    }

    private HttpURLConnection downloadFrom(Uri uri, int i) throws IOException {
        InterceptResult invokeLI;
        Uri parse;
        String error;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, this, uri, i)) == null) {
            HttpURLConnection openConnectionTo = openConnectionTo(uri);
            String str = this.mUserAgent;
            if (str != null) {
                openConnectionTo.setRequestProperty("User-Agent", str);
            }
            Map map = this.mRequestHeaders;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    openConnectionTo.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            openConnectionTo.setConnectTimeout(this.mHttpConnectionTimeout);
            int responseCode = openConnectionTo.getResponseCode();
            if (isHttpSuccess(responseCode)) {
                return openConnectionTo;
            }
            if (isHttpRedirect(responseCode)) {
                String headerField = openConnectionTo.getHeaderField("Location");
                openConnectionTo.disconnect();
                if (headerField == null) {
                    parse = null;
                } else {
                    parse = Uri.parse(headerField);
                }
                String scheme = uri.getScheme();
                if (i > 0 && parse != null && !parse.getScheme().equals(scheme)) {
                    return downloadFrom(parse, i - 1);
                }
                if (i == 0) {
                    error = error("URL %s follows too many redirects", uri.toString());
                } else {
                    error = error("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode));
                }
                throw new IOException(error);
            }
            openConnectionTo.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        }
        return (HttpURLConnection) invokeLI.objValue;
    }

    public static String error(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, objArr)) == null) {
            return String.format(Locale.getDefault(), str, objArr);
        }
        return (String) invokeLL.objValue;
    }

    public static HttpURLConnection openConnectionTo(Uri uri) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uri)) == null) {
            return (HttpURLConnection) UriUtil.uriToUrl(uri).openConnection();
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public HttpUrlConnectionNetworkFetchState createFetchState(Consumer consumer, ProducerContext producerContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consumer, producerContext)) == null) {
            return new HttpUrlConnectionNetworkFetchState(consumer, producerContext);
        }
        return (HttpUrlConnectionNetworkFetchState) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, NetworkFetcher.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, httpUrlConnectionNetworkFetchState, callback) == null) {
            httpUrlConnectionNetworkFetchState.submitTime = this.mMonotonicClock.now();
            httpUrlConnectionNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks(this, this.mExecutorService.submit(new Runnable(this, httpUrlConnectionNetworkFetchState, callback) { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpUrlConnectionNetworkFetcher this$0;
                public final /* synthetic */ NetworkFetcher.Callback val$callback;
                public final /* synthetic */ HttpUrlConnectionNetworkFetchState val$fetchState;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, httpUrlConnectionNetworkFetchState, callback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$fetchState = httpUrlConnectionNetworkFetchState;
                    this.val$callback = callback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.fetchSync(this.val$fetchState, this.val$callback);
                    }
                }
            }), callback) { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpUrlConnectionNetworkFetcher this$0;
                public final /* synthetic */ NetworkFetcher.Callback val$callback;
                public final /* synthetic */ Future val$future;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, callback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$future = r7;
                    this.val$callback = callback;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.val$future.cancel(false)) {
                        this.val$callback.onCancellation();
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public void onFetchCompletion(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpUrlConnectionNetworkFetchState, i) == null) {
            httpUrlConnectionNetworkFetchState.fetchCompleteTime = this.mMonotonicClock.now();
        }
    }
}
