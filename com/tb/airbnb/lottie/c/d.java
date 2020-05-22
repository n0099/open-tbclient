package com.tb.airbnb.lottie.c;

import android.support.annotation.Nullable;
import android.util.JsonReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public static com.tb.airbnb.lottie.model.a.b f(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        return a(jsonReader, dVar, true);
    }

    public static com.tb.airbnb.lottie.model.a.b a(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar, boolean z) throws IOException {
        return new com.tb.airbnb.lottie.model.a.b(a(jsonReader, z ? com.tb.airbnb.lottie.d.f.jk() : 1.0f, dVar, i.nkA));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.d g(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.d(a(jsonReader, dVar, o.nkB));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.f h(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.f(a(jsonReader, com.tb.airbnb.lottie.d.f.jk(), dVar, y.nkD));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.g i(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.g(a(jsonReader, dVar, ac.nkE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.h j(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.h(a(jsonReader, com.tb.airbnb.lottie.d.f.jk(), dVar, ad.nkF));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.j k(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.j(a(jsonReader, dVar, h.nkz));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.a l(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.a(a(jsonReader, dVar, f.nky));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.c a(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar, int i) throws IOException {
        return new com.tb.airbnb.lottie.model.a.c(a(jsonReader, dVar, new l(i)));
    }

    @Nullable
    private static <T> List<com.tb.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, dVar, 1.0f, ajVar);
    }

    @Nullable
    private static <T> List<com.tb.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, float f, com.tb.airbnb.lottie.d dVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, dVar, f, ajVar);
    }
}
