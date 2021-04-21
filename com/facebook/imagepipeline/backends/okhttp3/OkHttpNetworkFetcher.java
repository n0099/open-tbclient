package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.baidu.searchbox.http.HttpManager;
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
/* loaded from: classes2.dex */
public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState> {
    public static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Linux; Android 4.4.2; Nexus 5 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";
    public static final String FETCH_TIME = "fetch_time";
    public static final String IMAGE_SIZE = "image_size";
    public static final String QUEUE_TIME = "queue_time";
    public static final String TAG = "OkHttpNetworkFetchProducer";
    public static final String TOTAL_TIME = "total_time";
    public static final String USER_AGENT = "User-Agent";
    public volatile Call.Factory mCallFactory;
    public volatile Executor mCancellationExecutor;
    public Context mContext;

    /* loaded from: classes2.dex */
    public static class OkHttpNetworkFetchState extends FetchState {
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        public OkHttpNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public OkHttpNetworkFetcher(Context context) {
        this.mContext = context;
    }

    private void getOkHttpClientIfNeeded() {
        if (this.mCancellationExecutor == null) {
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
        if (call.isCanceled()) {
            callback.onCancellation();
        } else {
            callback.onFailure(exc);
        }
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ FetchState createFetchState(Consumer consumer, ProducerContext producerContext) {
        return createFetchState((Consumer<EncodedImage>) consumer, producerContext);
    }

    public void fetchWithRequest(final OkHttpNetworkFetchState okHttpNetworkFetchState, final NetworkFetcher.Callback callback, Request request) {
        final Call newCall = this.mCallFactory.newCall(request);
        okHttpNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.1
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    OkHttpNetworkFetcher.this.mCancellationExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            newCall.cancel();
                        }
                    });
                } else {
                    newCall.cancel();
                }
            }
        });
        newCall.enqueue(new Callback() { // from class: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                OkHttpNetworkFetcher.this.handleException(call, iOException, callback);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                okHttpNetworkFetchState.responseTime = SystemClock.elapsedRealtime();
                ResponseBody body = response.body();
                try {
                    try {
                    } catch (Exception e2) {
                        OkHttpNetworkFetcher.this.handleException(call, e2, callback);
                    }
                    if (!response.isSuccessful()) {
                        OkHttpNetworkFetcher.this.handleException(call, new IOException("Unexpected HTTP code " + response), callback);
                        return;
                    }
                    BytesRange fromContentRangeHeader = BytesRange.fromContentRangeHeader(response.header("Content-Range"));
                    if (fromContentRangeHeader != null && (fromContentRangeHeader.from != 0 || fromContentRangeHeader.to != Integer.MAX_VALUE)) {
                        okHttpNetworkFetchState.setResponseBytesRange(fromContentRangeHeader);
                        okHttpNetworkFetchState.setOnNewResultStatusFlags(8);
                    }
                    long contentLength = body.contentLength();
                    if (contentLength < 0) {
                        contentLength = 0;
                    }
                    callback.onResponse(body.byteStream(), (int) contentLength);
                } finally {
                    body.close();
                }
            }
        });
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new OkHttpNetworkFetchState(consumer, producerContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(OkHttpNetworkFetchState okHttpNetworkFetchState, NetworkFetcher.Callback callback) {
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
        } catch (Exception e2) {
            callback.onFailure(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public Map<String, String> getExtraMap(OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        HashMap hashMap = new HashMap(4);
        hashMap.put(QUEUE_TIME, Long.toString(okHttpNetworkFetchState.responseTime - okHttpNetworkFetchState.submitTime));
        hashMap.put(FETCH_TIME, Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.responseTime));
        hashMap.put(TOTAL_TIME, Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.submitTime));
        hashMap.put(IMAGE_SIZE, Integer.toString(i));
        return hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public void onFetchCompletion(OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        okHttpNetworkFetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
    }

    public OkHttpNetworkFetcher(OkHttpClient okHttpClient) {
        this(okHttpClient, okHttpClient.dispatcher().executorService());
    }

    public OkHttpNetworkFetcher(Call.Factory factory, Executor executor) {
        this.mCallFactory = factory;
        this.mCancellationExecutor = executor;
    }
}
