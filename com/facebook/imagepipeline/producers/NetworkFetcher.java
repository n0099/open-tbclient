package com.facebook.imagepipeline.producers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface NetworkFetcher {

    /* loaded from: classes7.dex */
    public interface Callback {
        void onCancellation();

        void onFailure(Throwable th);

        void onResponse(InputStream inputStream, int i) throws IOException;
    }

    FetchState createFetchState(Consumer consumer, ProducerContext producerContext);

    void fetch(FetchState fetchState, Callback callback);

    @Nullable
    Map getExtraMap(FetchState fetchState, int i);

    void onFetchCompletion(FetchState fetchState, int i);

    boolean shouldPropagate(FetchState fetchState);
}
