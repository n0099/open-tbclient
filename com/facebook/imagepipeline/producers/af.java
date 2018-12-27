package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public interface af<FETCH_STATE extends s> {

    /* loaded from: classes2.dex */
    public interface a {
        void B(Throwable th);

        void bTP();

        void e(InputStream inputStream, int i) throws IOException;
    }

    void a(FETCH_STATE fetch_state, int i);

    void a(FETCH_STATE fetch_state, a aVar);

    boolean a(FETCH_STATE fetch_state);

    @Nullable
    Map<String, String> b(FETCH_STATE fetch_state, int i);

    FETCH_STATE d(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar);
}
