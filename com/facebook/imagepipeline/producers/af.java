package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public interface af<FETCH_STATE extends t> {

    /* loaded from: classes15.dex */
    public interface a {
        void E(Throwable th);

        void epN();

        void f(InputStream inputStream, int i) throws IOException;
    }

    void a(FETCH_STATE fetch_state, int i);

    void a(FETCH_STATE fetch_state, a aVar);

    boolean a(FETCH_STATE fetch_state);

    @Nullable
    Map<String, String> b(FETCH_STATE fetch_state, int i);

    FETCH_STATE d(k<com.facebook.imagepipeline.f.e> kVar, ak akVar);
}
