package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public interface af<FETCH_STATE extends t> {

    /* loaded from: classes8.dex */
    public interface a {
        void E(Throwable th);

        void dOu();

        void f(InputStream inputStream, int i) throws IOException;
    }

    @Nullable
    Map<String, String> a(FETCH_STATE fetch_state, int i);

    void a(FETCH_STATE fetch_state, a aVar);

    boolean a(FETCH_STATE fetch_state);

    FETCH_STATE b(k<com.facebook.imagepipeline.g.e> kVar, ak akVar);

    void b(FETCH_STATE fetch_state, int i);
}
