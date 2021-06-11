package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
/* loaded from: classes7.dex */
public interface d<T> {

    /* loaded from: classes7.dex */
    public interface a<T> {
        void a(@NonNull Exception exc);

        void a(@Nullable T t);
    }

    @NonNull
    Class<T> a();

    void a(@NonNull Priority priority, @NonNull a<? super T> aVar);

    void b();

    void c();

    @NonNull
    DataSource d();
}
