package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes4.dex */
public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Linux; Android 4.4.2; Nexus 5 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";
    public static final String FETCH_TIME = "fetch_time";
    public static final String IMAGE_SIZE = "image_size";
    public static final String QUEUE_TIME = "queue_time";
    public static final String TAG = "OkHttpNetworkFetchProducer";
    public static final String TOTAL_TIME = "total_time";
    public static final String USER_AGENT = "User-Agent";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Call.Factory mCallFactory;
    public volatile Executor mCancellationExecutor;
    public Context mContext;

    /* loaded from: classes4.dex */
    public static class OkHttpNetworkFetchState extends FetchState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OkHttpNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
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

    public OkHttpNetworkFetcher(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    private void getOkHttpClientIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.mCancellationExecutor == null) {
            synchronized (this) {
                if (this.mCancellationExecutor == null) {
                    OkHttpClient okHttpClient = HttpManager.newHttpManager(this.mContext).getOkHttpClient();
                    this.mCallFactory = okHttpClient;
                    this.mCancellationExecutor = okHttpClient.dispatcher().executorService();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleException(Call call, Exception exc, NetworkFetcher.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, this, call, exc, callback) == null) {
            if (call.isCanceled()) {
                callback.onCancellation();
            } else {
                callback.onFailure(exc);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ FetchState createFetchState(Consumer consumer, ProducerContext producerContext) {
        return createFetchState((Consumer<EncodedImage>) consumer, producerContext);
    }

    public void fetchWithRequest(OkHttpNetworkFetchState okHttpNetworkFetchState, NetworkFetcher.Callback callback, Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, okHttpNetworkFetchState, callback, request) == null) {
            Call newCall = this.mCallFactory.newCall(request);
            okHttpNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks(this, newCall) { // from class: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OkHttpNetworkFetcher this$0;
                public final /* synthetic */ Call val$call;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, newCall};
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
                    this.val$call = newCall;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            this.this$0.mCancellationExecutor.execute(new Runnable(this) { // from class: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$1.val$call.cancel();
                                    }
                                }
                            });
                        } else {
                            this.val$call.cancel();
                        }
                    }
                }
            });
            newCall.enqueue(new Callback(this, okHttpNetworkFetchState, callback) { // from class: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OkHttpNetworkFetcher this$0;
                public final /* synthetic */ NetworkFetcher.Callback val$callback;
                public final /* synthetic */ OkHttpNetworkFetchState val$fetchState;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, okHttpNetworkFetchState, callback};
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
                    this.val$fetchState = okHttpNetworkFetchState;
                    this.val$callback = callback;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                        this.this$0.handleException(call, iOException, this.val$callback);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                        this.val$fetchState.responseTime = SystemClock.elapsedRealtime();
                        ResponseBody body = response.body();
                        try {
                            try {
                            } catch (Exception e) {
                                this.this$0.handleException(call, e, this.val$callback);
                            }
                            if (!response.isSuccessful()) {
                                this.this$0.handleException(call, new IOException("Unexpected HTTP code " + response), this.val$callback);
                                return;
                            }
                            BytesRange fromContentRangeHeader = BytesRange.fromContentRangeHeader(response.header("Content-Range"));
                            if (fromContentRangeHeader != null && (fromContentRangeHeader.from != 0 || fromContentRangeHeader.to != Integer.MAX_VALUE)) {
                                this.val$fetchState.setResponseBytesRange(fromContentRangeHeader);
                                this.val$fetchState.setOnNewResultStatusFlags(8);
                            }
                            long contentLength = body.contentLength();
                            if (contentLength < 0) {
                                contentLength = 0;
                            }
                            this.val$callback.onResponse(body.byteStream(), (int) contentLength);
                        } finally {
                            body.close();
                        }
                    }
                }
            });
        }
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, consumer, producerContext)) == null) ? new OkHttpNetworkFetchState(consumer, producerContext) : (OkHttpNetworkFetchState) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(OkHttpNetworkFetchState okHttpNetworkFetchState, NetworkFetcher.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, okHttpNetworkFetchState, callback) == null) {
            okHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
            Uri uri = okHttpNetworkFetchState.getUri();
            getOkHttpClientIfNeeded();
            try {
                Request.Builder builder = new Request.Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(uri.toString()).get();
                BytesRange bytesRange = okHttpNetworkFetchState.getContext().getImageRequest().getBytesRange();
                if (bytesRange != null) {
                    builder.addHeader("Range", bytesRange.toHttpRangeHeaderValue());
                }
                Map<String, String> netRequestHeader = okHttpNetworkFetchState.getNetRequestHeader();
                if (netRequestHeader == null) {
                    builder.addHeader("User-Agent", DEFAULT_USER_AGENT);
                } else {
                    if (!netRequestHeader.containsKey("User-Agent")) {
                        builder.addHeader("User-Agent", DEFAULT_USER_AGENT);
                    }
                    for (Map.Entry<String, String> entry : netRequestHeader.entrySet()) {
                        builder.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                fetchWithRequest(okHttpNetworkFetchState, callback, builder.build());
            } catch (Exception e) {
                callback.onFailure(e);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public Map<String, String> getExtraMap(OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, okHttpNetworkFetchState, i)) == null) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("queue_time", Long.toString(okHttpNetworkFetchState.responseTime - okHttpNetworkFetchState.submitTime));
            hashMap.put("fetch_time", Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.responseTime));
            hashMap.put("total_time", Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.submitTime));
            hashMap.put("image_size", Integer.toString(i));
            return hashMap;
        }
        return (Map) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public void onFetchCompletion(OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, okHttpNetworkFetchState, i) == null) {
            okHttpNetworkFetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OkHttpNetworkFetcher(OkHttpClient okHttpClient) {
        this(okHttpClient, okHttpClient.dispatcher().executorService());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Call.Factory) objArr2[0], (Executor) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public OkHttpNetworkFetcher(Call.Factory factory, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {factory, executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCallFactory = factory;
        this.mCancellationExecutor = executor;
    }
}
