package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public interface af<FETCH_STATE extends t> {

    /* loaded from: classes12.dex */
    public interface a {
        void G(Throwable th);

        void dzh();

        void g(InputStream inputStream, int i) throws IOException;
    }

    @Nullable
    Map<String, String> a(FETCH_STATE fetch_state, int i);

    void a(FETCH_STATE fetch_state, a aVar);

    boolean a(FETCH_STATE fetch_state);

    FETCH_STATE b(k<com.facebook.imagepipeline.g.e> kVar, ak akVar);

    void b(FETCH_STATE fetch_state, int i);
}
