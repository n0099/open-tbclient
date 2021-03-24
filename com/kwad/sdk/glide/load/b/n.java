package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public interface n<Model, Data> {

    /* loaded from: classes6.dex */
    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f35333a;

        /* renamed from: b  reason: collision with root package name */
        public final List<com.kwad.sdk.glide.load.c> f35334b;

        /* renamed from: c  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.a.d<Data> f35335c;

        public a(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull com.kwad.sdk.glide.load.a.d<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull List<com.kwad.sdk.glide.load.c> list, @NonNull com.kwad.sdk.glide.load.a.d<Data> dVar) {
            this.f35333a = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar);
            this.f35334b = (List) com.kwad.sdk.glide.g.j.a(list);
            this.f35335c = (com.kwad.sdk.glide.load.a.d) com.kwad.sdk.glide.g.j.a(dVar);
        }
    }

    @Nullable
    a<Data> a(@NonNull Model model, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar);

    boolean a(@NonNull Model model);
}
