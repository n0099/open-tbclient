package com.facebook.imagepipeline.producers;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HTTP_DEFAULT_TIMEOUT = 30000;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    public static final int MAX_REDIRECTS = 5;
    public static final int NUM_NETWORK_THREADS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService mExecutorService;
    public int mHttpConnectionTimeout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpUrlConnectionNetworkFetcher() {
        this(Executors.newFixedThreadPool(3));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((ExecutorService) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private HttpURLConnection downloadFrom(Uri uri, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, uri, i2)) == null) {
            HttpURLConnection openConnectionTo = openConnectionTo(uri);
            openConnectionTo.setConnectTimeout(this.mHttpConnectionTimeout);
            int responseCode = openConnectionTo.getResponseCode();
            if (isHttpSuccess(responseCode)) {
                return openConnectionTo;
            }
            if (isHttpRedirect(responseCode)) {
                String headerField = openConnectionTo.getHeaderField("Location");
                openConnectionTo.disconnect();
                Uri parse = headerField == null ? null : Uri.parse(headerField);
                String scheme = uri.getScheme();
                if (i2 > 0 && parse != null && !parse.getScheme().equals(scheme)) {
                    return downloadFrom(parse, i2 - 1);
                }
                throw new IOException(i2 == 0 ? error("URL %s follows too many redirects", uri.toString()) : error("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
            }
            openConnectionTo.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        }
        return (HttpURLConnection) invokeLI.objValue;
    }

    public static String error(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, objArr)) == null) ? String.format(Locale.getDefault(), str, objArr) : (String) invokeLL.objValue;
    }

    public static boolean isHttpRedirect(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            if (i2 == 307 || i2 == 308) {
                return true;
            }
            switch (i2) {
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

    public static boolean isHttpSuccess(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) ? i2 >= 200 && i2 < 300 : invokeI.booleanValue;
    }

    @VisibleForTesting
    public static HttpURLConnection openConnectionTo(Uri uri) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, uri)) == null) ? (HttpURLConnection) UriUtil.uriToUrl(uri).openConnection() : (HttpURLConnection) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public FetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, consumer, producerContext)) == null) ? new FetchState(consumer, producerContext) : (FetchState) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(FetchState fetchState, NetworkFetcher.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fetchState, callback) == null) {
            fetchState.getContext().addCallbacks(new BaseProducerContextCallbacks(this, this.mExecutorService.submit(new Runnable(this, fetchState, callback) { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpUrlConnectionNetworkFetcher this$0;
                public final /* synthetic */ NetworkFetcher.Callback val$callback;
                public final /* synthetic */ FetchState val$fetchState;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, fetchState, callback};
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
                    this.val$fetchState = fetchState;
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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

    /* JADX WARN: Removed duplicated region for block: B:35:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchSync(FetchState fetchState, NetworkFetcher.Callback callback) {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fetchState, callback) == null) {
            InputStream inputStream = null;
            try {
                httpURLConnection = downloadFrom(fetchState.getUri(), 5);
                if (httpURLConnection != null) {
                    try {
                        try {
                            inputStream = httpURLConnection.getInputStream();
                            callback.onResponse(inputStream, -1);
                        } catch (IOException e2) {
                            e = e2;
                            callback.onFailure(e);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (httpURLConnection == null) {
                                return;
                            }
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (httpURLConnection == null) {
                    return;
                }
            } catch (IOException e3) {
                e = e3;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
            httpURLConnection.disconnect();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpUrlConnectionNetworkFetcher(int i2) {
        this(Executors.newFixedThreadPool(3));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this((ExecutorService) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHttpConnectionTimeout = i2;
    }

    @VisibleForTesting
    public HttpUrlConnectionNetworkFetcher(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mExecutorService = executorService;
    }
}
