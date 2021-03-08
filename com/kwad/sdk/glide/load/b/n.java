package com.kwad.sdk.glide.load.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public interface n<Model, Data> {

    /* loaded from: classes3.dex */
    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f6686a;
        public final List<com.kwad.sdk.glide.load.c> b;
        public final com.kwad.sdk.glide.load.a.d<Data> c;

        public a(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull com.kwad.sdk.glide.load.a.d<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull List<com.kwad.sdk.glide.load.c> list, @NonNull com.kwad.sdk.glide.load.a.d<Data> dVar) {
            this.f6686a = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar);
            this.b = (List) com.kwad.sdk.glide.g.j.a(list);
            this.c = (com.kwad.sdk.glide.load.a.d) com.kwad.sdk.glide.g.j.a(dVar);
        }
    }

    @Nullable
    a<Data> a(@NonNull Model model, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar);

    boolean a(@NonNull Model model);
}
